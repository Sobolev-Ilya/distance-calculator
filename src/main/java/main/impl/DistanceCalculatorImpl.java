package main.impl;

import data.set.GeographicPoint;
import data.set.InputRecord;
import data.set.OutputRecord;
import main.DistanceCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 04.04.2017.
 */
public class DistanceCalculatorImpl implements DistanceCalculator {

    public double computeDistanceBetweenGeographicPoints(GeographicPoint pointA, GeographicPoint pointB) {
        double R = 6372795; //радиус Земли

        //перевод коордитат в радианы
        double lat1 = pointA.latitude * Math.PI / 180;
        double long1 = pointA.longitude * Math.PI / 180;
        double lat2 = pointB.latitude * Math.PI / 180;
        double long2 = pointB.longitude * Math.PI / 180;

        //вычисление косинусов и синусов широт и разницы долгот
        double cl1 = Math.cos(lat1);
        double cl2 = Math.cos(lat2);
        double sl1 = Math.sin(lat1);
        double sl2 = Math.sin(lat2);
        double delta = long2 - long1;
        double cdelta = Math.cos(delta);
        double sdelta = Math.sin(delta);

        //вычисления длины большого круга
        double y = Math.sqrt(Math.pow(cl2 * sdelta, 2) + Math.pow(cl1 * sl2 - sl1 * cl2 * cdelta, 2));
        double x = sl1 * sl2 + cl1 * cl2 * cdelta;
        double ad = Math.atan2(y, x);
        double dist = ad * R; //расстояние между двумя координатами в метрах
        return dist / 1000;
    }

    @Override
    public List<OutputRecord> computeDistanceForRawList(List<InputRecord> recordList) {
        List<OutputRecord> outputRecordList = new ArrayList<>();
        for (int i = 0; i < recordList.size() - 1; i++) {
            GeographicPoint pointA = recordList.get(i).point;
            GeographicPoint pointB = recordList.get(i + 1).point;
            String yearAndMonth = recordList.get(i).yearAndMonth;
            double distance = computeDistanceBetweenGeographicPoints(pointA, pointB);
            OutputRecord outputRecord = new OutputRecord(yearAndMonth, distance);
            outputRecordList.add(outputRecord);
        }

        return outputRecordList;
    }


}
