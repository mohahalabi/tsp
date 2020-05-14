package ch.supsi.halabi.CoppaAlgoritmi.utils;


import java.io.*;

public class TSPFileWriter {

    private final String name;
    private final int distance;
    private final String comment;
    private final String type = "TYPE : TOUR";
    private final String dimension;
    private final String section = "TOUR_SECTION";

    public TSPFileWriter(String name, int distance, String dimension) {
        this.comment = "COMMENT : Optimum tour for " + name + ".tsp " + "(" + distance + ")";
        this.name = "NAME : " + name+ ".opt.tour";
        this.distance = distance;
        this.dimension = dimension;
    }

    public void write(File out, int[] minPath) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(out);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(name);
        bw.newLine();
        bw.write(comment);
        bw.newLine();
        bw.write(type);
        bw.newLine();
        bw.write(dimension);
        bw.newLine();
        bw.write(section);
        bw.newLine();
        for (int i = 0; i < minPath.length -1; i++) { // -1 because we don't want to write the last element which is equal to the first one
            bw.write(String.valueOf(minPath[i] + 1));
            bw.newLine();
        }
        bw.write("-1");
        bw.newLine();
        bw.write("EOF");
        bw.close();

    }


}
