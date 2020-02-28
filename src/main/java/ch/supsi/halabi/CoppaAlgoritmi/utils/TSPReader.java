package ch.supsi.halabi.CoppaAlgoritmi.utils;


import ch.supsi.halabi.CoppaAlgoritmi.model.City;

import java.io.*;

public class TSPReader {

    private String name;
    private String type;
    private String comment;
    private String dimension;
    private String edgeWeightType;
    private int bestKnown;


    public TSPReader(String name) {
        this.name = name;
    }

    public City[] read() throws IOException {
        File file = new File(name);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while (!(line = br.readLine()).equals("EOF")){
            System.out.println(line);
        }
        return null;
    }
}
