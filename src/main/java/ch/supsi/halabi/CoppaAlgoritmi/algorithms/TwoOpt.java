package ch.supsi.halabi.CoppaAlgoritmi.algorithms;

import ch.supsi.halabi.CoppaAlgoritmi.model.DistanceMatrix;

public class TwoOpt implements TSPAlgorithm {

    private DistanceMatrix distanceMatrix;

    public TwoOpt(DistanceMatrix distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    @Override
    public int[] execute(int[] path) {
        int bestGain, gain, bestI = 0, bestJ = 0;
        int size = path.length;
        do {
            bestGain = Integer.MAX_VALUE;
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    gain = gain(path[i], path[i + 1], path[j], path[j + 1]);
                    if (bestGain > gain) {
                        bestGain = gain;
                        bestI = i;
                        bestJ = j;
                    }
                }
            }
            executeSwap(path, bestI, bestJ); // we execute the swap until best gain is negative, thus there is no gain anymore
        } while (bestGain < 0);
        return path;
    }

    private int gain(int a, int b, int c, int d) {
        int ab = distanceMatrix.getDistanceMatrix()[a][b];
        int cd = distanceMatrix.getDistanceMatrix()[c][d];
        int ac = distanceMatrix.getDistanceMatrix()[a][c];
        int bd = distanceMatrix.getDistanceMatrix()[b][d];
        return (ac + bd) - (ab + cd);
    }

    private void executeSwap(int[] path, int source, int destination) {
        for (int i = source + 1, j = destination; i < j; i++, j--) {
            int tmp = path[i];
            path[i] = path[j];
            path[j] = tmp;
        }
    }
}
