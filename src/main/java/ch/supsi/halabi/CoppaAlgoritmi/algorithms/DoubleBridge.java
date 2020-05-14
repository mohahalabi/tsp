package ch.supsi.halabi.CoppaAlgoritmi.algorithms;

import java.util.Random;

public class DoubleBridge implements TSPAlgorithm{

    private Random random;

    public DoubleBridge(Random random) {
        this.random = random;
    }

    @Override
    public int[] execute(int[] tour) {
        int pos1, pos2, pos3, pos4;
        int[] temp = tour.clone();
        int length = tour.length - 1;
        do {
            pos1 = random.nextInt(length);
            pos2 = random.nextInt(length);
            pos3 = random.nextInt(length);
            pos4 = random.nextInt(length);
        } while (pos1 < 0 || pos2 < pos1 || pos3 < pos2 || pos4 < pos3);

        int k = pos1 + 1;
        System.arraycopy(temp, k, tour, pos3 + 1, pos4 - pos3);
        k += pos4 - pos3;
        System.arraycopy(temp, k, tour, pos2 + 1, pos3 - pos2);
        k += pos3 - pos2;
        System.arraycopy(temp, k, tour, pos1 + 1, pos2 - pos1);
        return tour;
    }
}

//System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)