import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;

import java.util.Arrays;
import java.util.List;

import static driver.Driver.printInf;
import static transport.ServiceStation.service;
import static transport.Transport.printInfoTo;

public class Main {

    public static void main(String[] args) {
        Mechanic<Car> petr = new Mechanic<Car>("Petr", "Ivanov", "STO");
        Mechanic<Transport> sergei = new Mechanic<Transport>("Sergei", "Ivanov", "STO");

        Sponsor lukoil = new Sponsor("Лукойл", "500_000");
        Sponsor gazprom = new Sponsor("Газпром", "800_000");

        Car car1 = new Car("Lada", "granta", 1.4f, TypeOfBody.COUPE);
        Car kia = new Car("kia", "seed", 1.8f, TypeOfBody.COUPE);

        kia.addDriver(new DriverB("pilot1", 3, car1));
        kia.addMechanic(petr);
        kia.addSponsor(lukoil, gazprom);

        DriverB driverB = new DriverB("pilot2", 3, car1);
        System.out.println(driverB);
        //printInf(driverB, car1);

        Truck truck = new Truck("Kamaz", "t34", 3.2f, Weight.N1);
        DriverC driverC = new DriverC("pilot2", 12, truck);
        //System.out.println(driverC);

        truck.addDriver(new DriverC("pilot1", 3, truck));
        truck.addMechanic(sergei);
        truck.addSponsor(gazprom);

        Bus bus = new Bus("Gazel", "next", 3.4f, Capacity.LARGE);
        DriverD driverD = new DriverD("pilot3", 3, bus);
        //System.out.println(driverD);

        bus.addDriver(new DriverD("pilot3", 3, bus));
        bus.addMechanic(sergei);
        bus.addSponsor(gazprom);

        service(car1, truck, bus);//передаем на то

        List<Transport> transports = List.of(
                kia, truck, bus
        );

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(car1);
        serviceStation.addTruck(truck);
        serviceStation.service();
        serviceStation.service();

        for (Transport transport : transports) {
            printInfoTo(transport);
            System.out.println(transport.getDrivers());
            System.out.println(transport.getSponsors());
            System.out.println(transport.getMechanics());
        }

        /*//дз с валидацией логинов
        boolean success = Data.validate("test", "te3t", "test");
        if (success) {
            System.out.println("all ok");
        } else {
            System.out.println("fail");
        }*/
    }
}
