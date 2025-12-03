package asd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleSearch {

    public static void main(String[] args) {
    	System.out.println(args[0]);
    	System.out.println(args[1]);
    	System.out.println(args[2]);
    	
        if (args.length != 3 || !args[0].equalsIgnoreCase("search")) {
            System.out.println("Please use the following syntax: search <pattern> <file>");
            return;
        }

        String pattern = args[1];
        String fileName = args[2];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pattern)) {
                    System.out.println(lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Couldn't find file: " + e.getMessage());
        }
    }
}
