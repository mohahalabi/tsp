package ch.supsi.halabi.CoppaAlgoritmi;

import ch.supsi.halabi.CoppaAlgoritmi.utils.TSPReader;

import java.io.IOException;


public class Main {


    public static void main(String[] args) {

        String path = Main.class.getResource("/problems/ch130.tsp").toString();
        TSPReader reader = new TSPReader(path);
        try {
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
