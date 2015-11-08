package P8_6;

/**
 * Created by Eason on 10/12/15.
 */
public class Car {
    private double fuelEfficiency;
    private double fuelLevel;

    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
        this.fuelLevel = 0;
    }

    public Car(int fuelEfficiency) {
        this((double) fuelEfficiency);
    }

    public void addGas(double amount) {
        fuelLevel += amount;
    }

    public void addGas(int amount) {
        addGas((double) amount);
    }

    public void drive(double miles) {
        if (fuelLevel - miles / fuelEfficiency < 0) {   //If there is not enough gas, then do not drive.
            System.out.println("Unable to drive.");
        } else {
            fuelLevel = fuelLevel - miles / fuelEfficiency;
        }
    }

    public void drive(int miles) {
        drive((double) miles);
    }

    public double getFuelLevel() {
        return this.fuelLevel;
    }
}
