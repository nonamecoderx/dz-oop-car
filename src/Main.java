import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import exeptions.Data;
import transport.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Mechanic<Car> petr = new Mechanic<Car>("Petr", "Ivanov", "STO ot Arama");
        Mechanic<Transport> sergei = new Mechanic<Transport>("Vasya", "Ivanov", "STO ot Arama");

        Sponsor lukoil = new Sponsor("lukoil", "500_000");
        Sponsor gazprom = new Sponsor("gazprom", "800_000");

        Car car = new Car("Lada", "granta", 1.4f, TypeOfBody.COUPE);
        Car kia = new Car("kia", "seed", 1.8f, TypeOfBody.COUPE);

        kia.addDriver(new DriverB("pilot1", 3, car));
        kia.addMechanic(petr);
        kia.addSponsor(lukoil, gazprom);

        DriverB driverB = new DriverB("pilot2", 3, car);
        System.out.println(driverB);
        printInf(driverB, car);

        Truck truck = new Truck("Kamaz", "t34", 3.2f, Weight.N1);
        Truck truck1 = new Truck("Kamaz1", "t34", 3.2f, Weight.N1);
        Truck truck2 = new Truck("Kamaz2", "t34", 3.2f, Weight.N1);
        DriverC driverC = new DriverC("pilot2", 12, truck);
        System.out.println(driverC);

        truck.addDriver(new DriverC("pilot1", 3, truck));
        truck.addMechanic(sergei);
        truck.addSponsor(gazprom);


        Bus bus = new Bus("Gazel", "next", 3.4f, Capacity.LARGE);
        DriverD driverD = new DriverD("pilot3", 3, bus);
        System.out.println(driverD);

        bus.addDriver(new DriverD("pilot3", 3, bus));
        bus.addMechanic(sergei);
        bus.addSponsor(gazprom);


        service(car, truck, bus);//передаем на то

        List<Transport> transports = List.of(
                kia, truck, bus
        );

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(car);
        serviceStation.addTruck(truck);
        serviceStation.service();
        serviceStation.service();

        for (Transport transport : transports) {
            printInfoTo(transport);
            System.out.println(transport.getDrivers());
            System.out.println(transport.getSponsors());
            System.out.println(transport.getMechanics());
        }


        //дз с валидацией логинов
        boolean success = Data.validate("test", "te3t", "test");
        if (success) {
            System.out.println("all ok");
        } else {
            System.out.println("fail");
        }
    }

    private static void printInfoTo(Transport transport) {
        System.out.println("инфо по авто" + transport.getBrand() + " " + transport.getModel());

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
