package driver;

import transport.Truck;

public class DriverC extends Driver<Truck>{
    public DriverC(String fullName, int drivingExpirience, Truck car) {
        super(fullName, "C", drivingExpirience, car);
    }
}
