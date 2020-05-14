package ch.supsi.halabi.CoppaAlgoritmi.algorithms;

import ch.supsi.halabi.CoppaAlgoritmi.Main;
import ch.supsi.halabi.CoppaAlgoritmi.model.DistanceMatrix;

import java.util.Random;

public class SimulatedAnnealing implements TSPAlgorithm {
    private DistanceMatrix distanceMatrix;
    private long startTime;
    private Random random;


    public SimulatedAnnealing(DistanceMatrix distanceMatrix, long startTime, Random random) {
        this.distanceMatrix = distanceMatrix;
        this.startTime = startTime;
        this.random = random;
    }

    @Override
    public int[] execute(int[] tour) {
        double temperature = 100, constant = 0.95;
        int[] next, candidate;
        int [] current = tour.clone();
        int[] best = tour.clone();
        long end;
        int currentDistance, candidateDistance, bestDistance;
        TSPAlgorithm twoOpt = new TwoOpt(distanceMatrix);
        TSPAlgorithm doubleBridge = new DoubleBridge(random);
        while (temperature > 0.0001){
            for (int i = 0; i < 100; i++) {
                next = doubleBridge.execute(current).clone();
                candidate = twoOpt.execute(next).clone();
                currentDistance = Main.distance(distanceMatrix, current);
                candidateDistance = Main.distance(distanceMatrix, candidate);
                if (currentDistance > candidateDistance ) {
                    current = candidate.clone();
                    bestDistance = Main.distance(distanceMatrix, best);
                    if (bestDistance > candidateDistance ) {
                        best = candidate.clone();
                    }
                } else if (random.nextDouble() < Math.exp(-(candidateDistance - currentDistance) / temperature)) {
                    current = candidate.clone();
                }
                end = System.nanoTime();
                if (end - startTime > 1.74e+11) //2.9 minutes = 1.74e+11
                    return best;
            }
            temperature *= constant;
        }

        return best;
    }

}
