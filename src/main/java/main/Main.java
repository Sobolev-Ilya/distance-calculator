package main;

import data.set.InputRecord;
import data.set.OutputRecord;
import main.impl.DistanceCalculatorImpl;
import main.impl.FileWorker;

import java.util.List;

/**
 * Created by Ilya on 04.04.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        DistanceCalculator distanceCalculator = new DistanceCalculatorImpl();
        InputOutputAdapter fileWorker = new FileWorker();

        String inputFileName = "";
        String outputFileName = "";
        try {
            inputFileName = args[0];
            outputFileName = args[1];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no input or output filename");
            System.out.println("For correct application using you should write in console next command 'java -jar distanceCalculator path_to_input_file path_to_output_file'");
            System.out.println("For example 'java -jar distanceCalculator data1.csv results.csv'");
            throw new IllegalArgumentException("Application closed.");
        }

        System.out.println("Reading data from file " + inputFileName + " ... ");
        List<InputRecord> recordsFromFile = fileWorker.getRecordsFromFile(inputFileName);
        System.out.println("Data was successfully read");
        System.out.println();

        System.out.println("Computing ... ");
        List<OutputRecord> outputRecordList = distanceCalculator.computeDistanceForRawList(recordsFromFile);
        System.out.println("Computing was successful");
        System.out.println();

        System.out.println("Writing computed results to file " + outputFileName + " ... ");
        fileWorker.writeRecordsToFile(outputFileName, outputRecordList);
        System.out.println("Results was successfully written");
        System.out.println();

        System.out.println("Application closed");
    }
}
