import java.util.Comparator;

public class LastNameCompare implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
