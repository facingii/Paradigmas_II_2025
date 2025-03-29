package mx.uv.fiee.iinf.poo.demos.filetextreaderbasics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void main (String [] args) throws FileNotFoundException, IOException {
        String pathname = "/Users/gonzalo/Documents/projects/github/1brc/data/";
        String filename = "weather_stations.csv";
        //String separator = "Data" + File.separator + "Stations" + File.separator + filename;
        //System.out.println(separator);


        File file = new File (pathname + filename);
        FileReader fileReader = new FileReader (file);
//
//        StringBuilder sb = new StringBuilder ();
//        int charsRead;
//        char[] charBuffer = new char [1024];
//
//        while ((charsRead = fileReader.read (charBuffer)) > -1) {
//            sb.append (charBuffer, 0, charsRead);
//        }
//
//        System.out.println (sb.toString ());


        
        BufferedReader buff = new BufferedReader (fileReader);

        String line;
        StringBuilder builder = new StringBuilder ();
        while ((line = buff.readLine ()) != null) {
            builder.append (line);
            builder.append ("\n");
        }

        System.out.println (builder);

        buff.close ();
        fileReader.close ();
    }

}
