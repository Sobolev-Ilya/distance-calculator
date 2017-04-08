package main;

import data.set.GeographicPoint;
import data.set.InputRecord;
import data.set.OutputRecord;

import java.util.List;

/**
 * Created by Ilya on 04.04.2017.
 */
public interface DistanceCalculator {

    double computeDistanceBetweenGeographicPoints(GeographicPoint pointA, GeographicPoint pointB);

    List<OutputRecord> computeDistanceForRawList(List<InputRecord> recordList);
}
