import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import exeptions.Data;
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

        service(car, truck, bus);//передаем на то

        //дз с валидацией логинов
        boolean success = Data.validate("test", "te3t", "test");
        if (success) {
            System.out.println("all ok");
        } else {
            System.out.println("fail");
        }
    }

    public static void service(Transport... transports) { //проверяем все машины в массиве
        for (Transport transport : transports) {
            serviceTransport(transport);
        }
    }

    public static void serviceTransport(Transport transport) { //проверяем каждую машину
        if (!transport.service()) {
        }
        try {
            throw new RuntimeException("Автомобиль" + transport.getBrand() + " " + transport.getModel() + " не прошел ТО");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void printInf(Driver<?> driver, Transport transport) {
        System.out.println(driver.getFullName() + transport.getBrand() + transport.getModel());
        transport.printType();
    }
}
