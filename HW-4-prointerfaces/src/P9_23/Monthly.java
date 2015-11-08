package P9_23;

/**
 * Created by Eason on 10/23/15.
 */
public class Monthly extends Appointment {

    public Monthly() {
        super();
    }

    public Monthly(int year, int month, int day, String description) {
        super(year, month, day, description);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        if (year > super.getYear() && day == super.getDay()) {
            return true;
        } else if (year == super.getYear() && month >= super.getMonth() && day == super.getDay()) {
            return true;
        } else {
            return false;   //The date is before the appointment.
        }
    }

    @Override
    public String toString() {
        return "Monthly::" + super.toString();
    }
}
