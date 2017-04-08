package data.set;

/**
 * Created by Ilya on 04.04.2017.
 */
public class InputRecord {
    public String yearAndMonth;
    public GeographicPoint point;

    public InputRecord(String yearAndMonth, GeographicPoint point) {
        this.yearAndMonth = yearAndMonth;
        this.point = point;
    }
}
