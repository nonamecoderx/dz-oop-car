import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Lada", "granta", 1.4f, TypeOfBody.COUPE);
        DriverB driverB = new DriverB("pilot1", 3, car);
        System.out.println(driverB);
        printInf(driverB, car);
        Truck truck = new Truck("Kamaz", "t34", 3.2f, Weight.N1);
        DriverC driverC = new DriverC("pilot2", 12, truck);
        System.out.println(driverC);

        Bus bus = new Bus("Gazel", "next", 3.4f, Capacity.LARGE);
        DriverD driverD = new DriverD("pilot3", 3, bus);
        System.out.println(driverD);
    }

    private static void printInf(Driver<?> driver, Transport transport) {
        System.out.println(driver.getFullName() + transport.getBrand() + transport.getModel());
        transport.printType();
    }
}