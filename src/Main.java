import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.Bus;
import transport.Car;
import transport.Truck;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Lada", "granta", 1.4f);
        DriverB driverB = new DriverB("pilot1", 3, car);
        System.out.println(driverB);

        Truck truck = new Truck("Kamaz", "t34", 3.2f);
        DriverC driverC = new DriverC("pilot2", 12, truck);
        System.out.println(driverC);

        Bus bus = new Bus("Gazel", "next", 3.4f);
        DriverD driverD = new DriverD("pilot3", 3, bus);
        System.out.println(driverD);
    }
}