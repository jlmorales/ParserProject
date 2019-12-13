import java.util.Comparator;

public class StartDateCompare implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
}
