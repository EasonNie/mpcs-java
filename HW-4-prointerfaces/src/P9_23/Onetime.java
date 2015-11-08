package P9_23;

/**
 * Created by Eason on 10/23/15.
 */
public class Onetime extends Appointment {

    public Onetime() {
        super();
    }

    public Onetime(int year, int month, int day, String description) {
        super(year, month, day, description);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        if (year == super.getYear() && month == super.getMonth() && day == super.getDay()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Onetime::" + super.toString();
    }
}
