package driver;

import transport.Bus;

public class DriverD extends Driver<Bus>{
    public DriverD(String fullName, int drivingExpirience, Bus car) {
        super(fullName, "D", drivingExpirience, car);
    }
}
