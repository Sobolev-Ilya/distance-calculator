package main.impl;

import data.set.GeographicPoint;
import data.set.InputRecord;
import data.set.OutputRecord;
import main.DistanceCalculator;
import main.impl.DistanceCalculatorImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DistanceCalculatorTest {

    DistanceCalculator calculator = new DistanceCalculatorImpl();

    @Test
    public void testComputeDistanceBetweenGeographicPoints() throws Exception {
        GeographicPoint a = new GeographicPoint(17.6627, 17.6627);
        GeographicPoint b = new GeographicPoint(0, 0);

        double result = calculator.computeDistanceBetweenGeographicPoints(a, b);

        Assert.assertEquals(result, 2755.943, 0.05);
    }

    @Test
    public void computeDistanceBetweenEqualPointShouldBeZero() throws Exception {
        GeographicPoint a = new GeographicPoint(18.2677, 16.6727);
        GeographicPoint b = new GeographicPoint(18.2677, 16.6727);

        double result = calculator.computeDistanceBetweenGeographicPoints(a, b);

        Assert.assertEquals(result, 0, 0.0001);
    }

    @Test
    public void computeDistanceForRawList_CorrectComputing() {
        List<InputRecord> inputRecords = new ArrayList<>();
        inputRecords.add(new InputRecord("test", new GeographicPoint(17.6627, 17.6627)));
        inputRecords.add(new InputRecord("test2", new GeographicPoint(0, 0)));

        List<OutputRecord> outputRecords = calculator.computeDistanceForRawList(inputRecords);

        Assert.assertEquals(outputRecords.size(), 1);
        Assert.assertEquals(outputRecords.get(0).yearAndMonth, "test");
        Assert.assertEquals(outputRecords.get(0).distance, 2755.943, 0.05);
    }

}
