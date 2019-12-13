import java.util.Comparator;

public class FirstNameCompare implements Comparator<Record> {

    @Override
    public int compare(Record o1, Record o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
