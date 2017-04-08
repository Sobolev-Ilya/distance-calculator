package main;

import data.set.InputRecord;
import data.set.OutputRecord;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ilya on 04.04.2017.
 */
public interface InputOutputAdapter {

    List<InputRecord> getRecordsFromFile(String filePath) throws IOException;

    void writeRecordsToFile(String fileName, List<OutputRecord> recordList) throws IOException;

}
