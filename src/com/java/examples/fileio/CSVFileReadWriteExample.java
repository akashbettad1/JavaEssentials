package com.java.examples.fileio;

import java.io.*;

public class CSVFileReadWriteExample {

    public static void main(String[] args) throws IOException {

        String csvFile = "dta.csv";

        FileWriter writer = null;
        // Step 1: Write to CSV file
        try {
            writer = new FileWriter(csvFile);
            writer.append("Name, Age, Department\n");
            writer.append("Alice, 30, Engineering\n");
            writer.append("Bob, 25, Marketing\n");
            writer.append("Carol, 27, HR\n");
            System.out.println("Data has been written to " + csvFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally {
            writer.close();
        }

        // Step 2: Read from CSV file.
        try {
            String line;
            FileReader fr = new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fr);
            // Skip header.
            br.readLine();
            System.out.println("Reading data from " + csvFile + ":");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
