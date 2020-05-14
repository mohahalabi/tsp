package ch.supsi.halabi.CoppaAlgoritmi;

import ch.supsi.halabi.CoppaAlgoritmi.algorithms.NearestNeighbor;
import ch.supsi.halabi.CoppaAlgoritmi.algorithms.SimulatedAnnealing;
import ch.supsi.halabi.CoppaAlgoritmi.algorithms.TSPAlgorithm;
import ch.supsi.halabi.CoppaAlgoritmi.algorithms.TwoOpt;
import ch.supsi.halabi.CoppaAlgoritmi.model.City;
import ch.supsi.halabi.CoppaAlgoritmi.model.DistanceMatrix;
import ch.supsi.halabi.CoppaAlgoritmi.model.Result;
import ch.supsi.halabi.CoppaAlgoritmi.utils.TSPFileReader;
import ch.supsi.halabi.CoppaAlgoritmi.utils.TSPFileWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        final String fileName = args[0];
        final long seed = Long.parseLong(args[1]);
        final String inputPath = args[2];
        final String outputPath =args[3];

        TSPFileReader reader = new TSPFileReader();
        long startTime = System.nanoTime();

        try {
            File fileToRead = new File(inputPath + fileName + ".tsp");
            File fileToWrite = new File(outputPath + fileName + ".opt.tour");

            List<City> cities = reader.read(fileToRead);
            int[] path = cities.stream().mapToInt(City::getId).toArray();
            DistanceMatrix distanceMatrix = new DistanceMatrix(cities);
            Random random = new Random();
            random.setSeed(seed);

            TSPAlgorithm nearestNeighbor = new NearestNeighbor(distanceMatrix, random);
            int[] pathNN = nearestNeighbor.execute(path);
            int distanceNN = distance(distanceMatrix, pathNN);
            Result resultNN = new Result("Nearest Neighbor", distanceNN);

            TSPAlgorithm twoOpt = new TwoOpt(distanceMatrix);
            int[] pathTowOpt = twoOpt.execute(pathNN);
            int distanceTowOpt = distance(distanceMatrix, pathTowOpt);
            Result resultTowOpt = new Result("TowOpt", distanceTowOpt);

            TSPAlgorithm simulatedAnnealing = new SimulatedAnnealing(distanceMatrix, startTime, random);
            int[] finalTour = simulatedAnnealing.execute(pathTowOpt);
            int distanceSA = distance(distanceMatrix, finalTour);
            Result resultSA = new Result("Simulated annealing", distanceSA);

            printResults(fileName, reader.getBestKnownInt(), resultNN, resultTowOpt, resultSA);

            TSPFileWriter writer = new TSPFileWriter(fileName, distanceSA, reader.getDimension());
            writer.write(fileToWrite, finalTour);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int distance(DistanceMatrix distanceMatrix, int[] path) {
        int distance = 0;
        for (int i = 0; i < path.length - 1; i++) {
            distance += distanceMatrix.getDistanceMatrix()[path[i]][path[i + 1]];
        }
        return distance;
    }

    private static void printResults(String fileName, int bestKnown, Result... results) {
        System.out.println("****************** Problem: " + fileName + " ******************");
        System.out.println("Best known: " + bestKnown);
        for (Result result : results) {
            System.out.println("Distance " + result.getAlgorithmName() + ": " + result.getDistance() +
                    ", error: " + String.format("%.5f", calculateErrorPercentage(bestKnown, result.getDistance())) + "%");
        }
        System.out.println();
    }

    private static double calculateErrorPercentage(int bestKnown, int distance) {
        return (((double) distance - (double) bestKnown) / bestKnown) * 100;
    }
}
