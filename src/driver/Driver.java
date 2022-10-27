package driver;

import transport.Transport;

public abstract class Driver <T extends Transport> {
    private final String fullName;
    private String category;
    private final int drivingExpirience;

    private final T car;


    protected Driver(String fullName, String category, int drivingExpirience, T car) {
        this.fullName = fullName;
        setCategory(category);
        this.drivingExpirience = drivingExpirience;
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
    public String getFullName() {
        return fullName;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category){
        if (category==null){
            throw new IllegalArgumentException("Укажите тип прав");
        }
        this.category = category;

    }

    public int getDrivingExpirience() {
        return drivingExpirience;
    }

    @Override
    public String toString() {
        return String.format("Водитель %s управляет автомобилем %s %s и будет учавствовать в заезде",
                this.fullName,
                this.car.getBrand(),
                this.car.getModel()
        );
    }

}
