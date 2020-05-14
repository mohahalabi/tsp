package ch.supsi.halabi.CoppaAlgoritmi.algorithms;

import java.util.Random;

public class DoubleBridge implements TSPAlgorithm {

    private Random random;

    public DoubleBridge(Random random) {
        this.random = random;
    }

    @Override
    public int[] execute(int[] tour) {
        int position1, position2, position3, position4;
        int[] temp = tour.clone();
        int length = tour.length - 1;
        do {
            position1 = random.nextInt(length);
            position2 = random.nextInt(length);
            position3 = random.nextInt(length);
            position4 = random.nextInt(length);
        } while (position1 < 0 || position2 < position1 || position3 < position2 || position4 < position3);

        int k = position1 + 1;
        System.arraycopy(temp, k, tour, position3 + 1, position4 - position3);
        k += position4 - position3;
        System.arraycopy(temp, k, tour, position2 + 1, position3 - position2);
        k += position3 - position2;
        System.arraycopy(temp, k, tour, position1 + 1, position2 - position1);
        return tour;
    }
}

//System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)