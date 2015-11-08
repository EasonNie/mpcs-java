package P9_23;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Eason on 10/23/15.
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        boolean running = true;
        ArrayList<Appointment> appointments = new ArrayList<>();

        while (running) {
            Runtime.getRuntime().exec("clear");

            System.out.println("------------------------------");
            System.out.println("|This is an appointment book.|");
            System.out.println("------------------------------");
            System.out.println("1.Display all the appointment.");
            System.out.println("2.Insert new appointment.");
            System.out.println("3.Check A day.");
            System.out.println("4.Save data to file.");
            System.out.println("5.Load data from file");
            System.out.println("6.Exit");
            System.out.println("------------------------------");
            System.out.print("Please enter your choice:");
            String choice = s.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    display(appointments, s);
                    break;
                case "2":
                    insert(appointments, s);
                    break;
                case "3":
                    check(appointments, s);
                    break;
                case "4":
                    save(appointments, s);
                    break;
                case "5":
                    load(appointments, s);
                    break;
                case "6":
                    running = exit();
                default:
                    break;
            }

            System.out.println("\n\n\n\n\n\n\n\n");
        }
    }

    public static void display(ArrayList<Appointment> appointments, Scanner s) {
        if (appointments.size() == 0) {
            System.out.println("Your appointment book is empty.\n");
        } else {
            displayList(appointments);
        }
        System.out.println("Press enter to continue.");
        s.nextLine();
    }

    public static void insert(ArrayList<Appointment> appointments, Scanner s) {
        System.out.print("Enter your appointment type (Onetime/Daily/Monthly):");
        String type = s.nextLine().trim();
        System.out.print("Enter description:");
        String description = s.nextLine().trim();
        System.out.print("Enter date (yyyy-mm-dd):");
        String date = s.nextLine().trim();
        Appointment newOne = null;
        try {
            newOne = Appointment.parseAppointment(type + "::" + description + "::" + date);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Illegal appointment type.");
        } catch (NumberFormatException e) {
            System.out.println("Illegal date format.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Illegal data format.");
        }

        System.out.println();
        if (newOne != null) {
            appointments.add(newOne);
            System.out.println("1 appointment have been inserted successfully.\n");
        } else {
            System.out.println("Insert fail...\n");
        }

        System.out.println("Press enter to continue.");
        s.nextLine();

    }

    public static void check(ArrayList<Appointment> appointments, Scanner s) {
        try {
            System.out.print("Enter year (yyyy):");
            int year = Integer.parseInt(s.nextLine().trim());
            System.out.print("Enter month (mm):");
            int month = Integer.parseInt(s.nextLine().trim());
            System.out.print("Enter day (dd):");
            int day = Integer.parseInt(s.nextLine().trim());

            ArrayList<Appointment> occursOnes = new ArrayList<>();
            for (Appointment appointment : appointments) {
                if (appointment.occursOn(year, month, day)) {
                    occursOnes.add(appointment);
                }
            }
            if (occursOnes.size() == 0) {
                System.out.println("No appointment will occur on that day.");
            } else {
                System.out.println("Appointments that will occur on the selected day are showed below:");
                displayList(occursOnes);
            }
        } catch (NumberFormatException e) {
            System.out.println("Illegal input date.");
        }

        System.out.println();
        System.out.println("Press enter to continue.");
        s.nextLine();
    }

    //Choose file from dialog.
    public static void save(ArrayList<Appointment> appointments, Scanner s) {
        System.out.println("Choose your file from dialog.");
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectFile = chooser.getSelectedFile();
            try {
                FileOutputStream fos = new FileOutputStream(selectFile);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                int count = 0;
                for (Appointment appointment : appointments) {
                    bw.write(appointment.toString());
                    bw.newLine();
                    count++;
                }
                bw.flush();
                bw.close();
                System.out.println();
                System.out.println(count + " appointments have been written to file.");

            } catch (FileNotFoundException e) {
                System.out.println("File exception.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("Press enter to continue.");
        s.nextLine();

    }

    //Choose file from dialog.
    public static void load(ArrayList<Appointment> appointments, Scanner s) {
        System.out.println("Choose your file from dialog.");
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectFile = chooser.getSelectedFile();
            try {
                Scanner in = new Scanner(selectFile);
                int count = 0;
                while (in.hasNextLine()) {
                    String line = in.nextLine().trim();
                    if (line.equalsIgnoreCase("")) {
                        continue;
                    } else {
                        try {
                            Appointment newOne = Appointment.parseAppointment(line);
                            appointments.add(newOne);
                            count++;

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            System.out.println("Illegal appointment type.");
                        } catch (NumberFormatException e) {
                            System.out.println("Illegal date format.");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Illegal data format.");
                        }
                    }
                }
                System.out.println();
                System.out.println(count + " appointments have been loaded.");
                System.out.println();
                System.out.println("Press enter to continue.");
                s.nextLine();

            } catch (FileNotFoundException e) {
                System.out.println("Input File not Found.");
            }


        }
    }

    public static boolean exit() {
        return false;
    }

    public static void displayList(ArrayList<Appointment> appointments) {
        System.out.printf("--TYPE--|-----DESCRIPTION-----|---DATE---\n");
        for (Appointment appointment : appointments) {
            String[] show = appointment.toString().split("::");
            System.out.printf("%-8s|%-21s|%10s\n", show[0], show[1], show[2]);
        }
    }

}
