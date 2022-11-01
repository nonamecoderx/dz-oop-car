package driver;

import transport.Transport;

import java.util.Objects;

public abstract class Driver <T extends Transport> {
    private final String fullName;
    private String category;
    private final int drivingExperience;

    private final T car;
    public String getCategory() {
        return category;
    }
    public String getFullName() {
        return fullName;
    }
    public int getDrivingExperience() {
        return drivingExperience;
    }


    protected Driver(String fullName, String category, int drivingExperience, T car) {
        this.fullName = fullName;
        setCategory(category);
        this.drivingExperience = drivingExperience;
        this.car = car;
    }


    public void startMove(){
        System.out.printf("Driver %s %s start moving",this.fullName);
        this.car.startMovement();
    }
    public void stopMove(){
        System.out.printf("Driver %s %s stop moving",this.fullName);
        this.car.startMovement();
    }
    public void refill(){
        System.out.printf("Driver %s %s is refilling the %s %s",this.fullName, this.car.getBrand(),this.car.getModel());
    }



    public void setCategory(String category){
        if (category==null){
            throw new IllegalArgumentException("Укажите тип прав");
        }
        this.category = category;

    }


    public static void printInf(Driver<?> driver, Transport transport) {
        System.out.println(driver.getFullName() + transport.getBrand() + transport.getModel());
        transport.printType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return drivingExperience == driver.drivingExperience && Objects.equals(fullName, driver.fullName) && Objects.equals(category, driver.category) && Objects.equals(car, driver.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, category, drivingExperience, car);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "fullName='" + fullName + '\'' +
                ", category='" + category + '\'' +
                ", drivingExperience=" + drivingExperience +
                ", car=" + car +
                '}';
    }
}
