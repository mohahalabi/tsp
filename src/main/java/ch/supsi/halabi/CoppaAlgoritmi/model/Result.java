package ch.supsi.halabi.CoppaAlgoritmi.model;

public class Result {

    private String algorithmName;
    private int distance;

    public Result(String algorithmName, int distance) {
        this.algorithmName = algorithmName;
        this.distance = distance;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public int getDistance() {
        return distance;
    }

}
