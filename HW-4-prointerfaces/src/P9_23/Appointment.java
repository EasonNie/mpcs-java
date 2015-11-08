package P9_23;

import java.util.Calendar;

/**
 * Created by Eason on 15/10/23.
 */
public abstract class Appointment {

    public static final String PACKAGENAME = "P9_23";

    private Calendar date;
    private String description;

    public Appointment() {
        //Empty constructor
    }

    public Appointment(int year, int month, int day, String description) {
        this.date = Calendar.getInstance();
        this.date.set(year, month, day);
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s::%d-%d-%d", description, getYear(), getMonth(), getDay());
    }

    public abstract boolean occursOn(int year, int month, int day);

    //This is a method to create instance of appointment by using reflection and checking the name of the type.
    public static Appointment createAppointment(String type, int year, int month, int day, String description)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class c = Class.forName(PACKAGENAME + "." + type);
        Appointment New_Appointment = (Appointment) c.newInstance();

        New_Appointment.setDate(year, month, day);
        New_Appointment.setDescription(description);

        return New_Appointment;
    }

    //This method can parse a String (saved in file) to a actual object of appointment.
    public static Appointment parseAppointment(String string_appointment)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        String[] strings = string_appointment.split("::");
        String type = strings[0];
        String description = strings[1];
        int year = Integer.parseInt(strings[2].split("-")[0]);
        int month = Integer.parseInt(strings[2].split("-")[1]);
        int day = Integer.parseInt(strings[2].split("-")[2]);

        return createAppointment(type, year, month, day, description);
    }

    public int getDay() {
        return date.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth() {
        return date.get(Calendar.MONTH);
    }

    public int getYear() {
        return date.get(Calendar.YEAR);
    }

    public void setDate(int year, int month, int day) {
        this.date = Calendar.getInstance();
        this.date.set(year, month, day);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
