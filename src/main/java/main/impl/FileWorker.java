package main.impl;

import data.set.GeographicPoint;
import data.set.InputRecord;
import data.set.OutputRecord;
import main.CSVUtils;
import main.InputOutputAdapter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ilya on 04.04.2017.
 */
public class FileWorker implements InputOutputAdapter {

    public List<InputRecord> getRecordsFromFile(String filePath) throws IOException {
        List<InputRecord> records = new ArrayList<>();

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        try {
            //Reader reader = new InputStreamReader(new FileInputStream(filePath), "utf-8");
            //br = new BufferedReader(reader);
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(cvsSplitBy);
                String monthAndYear = lineArray[0];
                GeographicPoint geographicPoint = new GeographicPoint(Double.parseDouble(lineArray[1]), Double.parseDouble(lineArray[2]));
                InputRecord record = new InputRecord(monthAndYear, geographicPoint);
                records.add(record);
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found! " + e);
        } catch (IOException e) {
            throw new RuntimeException("Some problems!" + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return records;
    }

    @Override
    public void writeRecordsToFile(String fileName, List<OutputRecord> recordList) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        for (OutputRecord outputRecord : recordList) {
            CSVUtils.writeLine(writer, Arrays.asList(outputRecord.yearAndMonth, String.valueOf(outputRecord.distance)));
        }

        writer.flush();
        writer.close();
    }


}
