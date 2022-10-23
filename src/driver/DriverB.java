package driver;

import transport.Car;

public class DriverB extends Driver<Car>{

    public DriverB(String fullName, int drivingExpirience, Car car) {
        super(fullName, "B", drivingExpirience, car);
    }
}

