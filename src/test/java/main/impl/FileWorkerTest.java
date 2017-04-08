package main.impl;

import data.set.InputRecord;
import data.set.OutputRecord;
import main.InputOutputAdapter;
import main.impl.FileWorker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Ilya on 04.04.2017.
 */
public class FileWorkerTest {
    InputOutputAdapter fileWorker;

    @BeforeMethod
    public void setUp() throws Exception {
        fileWorker = new FileWorker();
    }

    @Test
    public void testGetRecordsFromFile() throws Exception {
        List<InputRecord> recordList = fileWorker.getRecordsFromFile("test_example.ssv");
        assertEquals(recordList.size(), 4);

        InputRecord firstRecord = recordList.get(0);
        assertEquals(firstRecord.yearAndMonth, "2016 January");
        assertEquals(firstRecord.point.latitude, 1.123, 0.0001);
        assertEquals(firstRecord.point.longitude, 1.2341, 0.0001);

        InputRecord lastRecord = recordList.get(recordList.size() - 1);
        assertEquals(lastRecord.yearAndMonth, "2010 January");
        assertEquals(lastRecord.point.latitude, 4.312, 0.0001);
        assertEquals(lastRecord.point.longitude, 4.2341, 0.0001);
    }

    @Test
    public void writeRecordsToFileTest() throws Exception {
        List<OutputRecord> outputRecordList = new ArrayList<>();
        outputRecordList.add(new OutputRecord("test", 2.22));
        outputRecordList.add(new OutputRecord("test2", 2.33));
        fileWorker.writeRecordsToFile("someFile_"+new Date().getTime()+".txt", outputRecordList);
    }

}