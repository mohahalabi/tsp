package ch.supsi.halabi.CoppaAlgoritmi.model;


import java.util.List;

public class DistanceMatrix {

    private int[][] distanceMatrix;

    public DistanceMatrix(final List<City> cities){
        distanceMatrix = new int[cities.size()][cities.size()];
        for (int i = 0; i < cities.size(); i++) {
            for (int j = 0; j < cities.size(); j++) {
                distanceMatrix[i][j] = calculateDistance(cities.get(i).getX(), cities.get(i).getY(), cities.get(j).getX(), cities.get(j).getY());
            }
        }
    }

    private int calculateDistance(double x1, double y1, double x2, double y2) {
        int distance = (int) Math.round((Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))));
        return distance;
    }

    public int[][] getDistanceMatrix() {
        return distanceMatrix;
    }
}
