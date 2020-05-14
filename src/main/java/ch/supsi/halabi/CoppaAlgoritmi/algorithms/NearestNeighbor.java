package ch.supsi.halabi.CoppaAlgoritmi.algorithms;

import ch.supsi.halabi.CoppaAlgoritmi.model.DistanceMatrix;
import java.util.Random;

public class NearestNeighbor implements TSPAlgorithm{

    private DistanceMatrix distanceMatrix;
    private Random random;

    public NearestNeighbor(DistanceMatrix distanceMatrix, Random random) {
        this.distanceMatrix = distanceMatrix;
        this.random = random;
    }

    @Override
    public int[] execute(int [] path) {
        int[] minPath = new int[path.length+ 1];
        int position = random.nextInt(path.length - 1); // First city is chosen randomly
        boolean[] visitedCities = new boolean[path.length]; // boolean array to save if a city has been visited or not
        int min, count, i, minPosition = position;
        minPath[0] = path[position];
        visitedCities[position] = true;
        // search for the nearest city until the tour is completed
        // start from 1 because we already processed the index 0
        for (count = 1; count <= path.length ; count++) {
            min = Integer.MAX_VALUE;
            i = minPosition;
            for (int j = 0; j < path.length ; ++j) {
                if (distanceMatrix.getDistanceMatrix()[i][j] != 0 && distanceMatrix.getDistanceMatrix()[i][j] < min && !visitedCities[j]) {
                    min = distanceMatrix.getDistanceMatrix()[i][j];
                    minPosition = j;
                }
            }
            if (min == Integer.MAX_VALUE)
                break;
            visitedCities[minPosition] = true;
            minPath[count] = path[minPosition];
        }
        minPath[path.length] = minPath[0];
        return minPath;
    }

}
