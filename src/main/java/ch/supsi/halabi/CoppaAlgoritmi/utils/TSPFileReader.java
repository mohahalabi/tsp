package ch.supsi.halabi.CoppaAlgoritmi.utils;

import ch.supsi.halabi.CoppaAlgoritmi.model.City;

import java.io.*;
import java.util.ArrayList;

public class TSPFileReader {

    private String name;
    private String type;
    private String comment;
    private String dimension;
    private String edgeWeightType;
    private String bestKnown;

    public ArrayList<City> read(File in) throws IOException {
        FileInputStream outputStream = new FileInputStream(in);
        BufferedReader br = new BufferedReader(new InputStreamReader(outputStream));
        ArrayList<City> cities = new ArrayList<>();
        String line;
        int lineNumber = 0;
        while (!(line = br.readLine()).equals("EOF")) {
            lineNumber++;
            if (line.startsWith("NAME"))
                name = line;
            if (line.startsWith("TYPE"))
                type = line;
            if (line.startsWith("COMMENT"))
                comment = line;
            if (line.startsWith("DIMENSION"))
                dimension = line;
            if (line.startsWith("EDGE"))
                edgeWeightType = line;
            if (line.startsWith("BEST"))
                bestKnown = line;
            if (lineNumber > 7) {
                String[] infos = line.split("\\s+");
                City city = new City(Integer.parseInt(
                        infos[0]) -1,
                        Double.parseDouble(infos[1]),
                        Double.parseDouble(infos[2]));
                cities.add(city);
            }
        }
        return cities;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getComment() {
        return comment;
    }

    public String getDimension() {
        return dimension;
    }

    public String getEdgeWeightType() {
        return edgeWeightType;
    }

    public String getBestKnown() {
        return bestKnown;
    }

    public int getBestKnownInt(){
        return Integer.parseInt(bestKnown.split("\\s*:\\s*")[1]);
    }


}
