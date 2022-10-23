package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Truck extends Transport implements Competing{


    public Truck(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMovement() {
        System.out.printf("Грузовик %s %s начал движение", this.getBrand(),this.getModel() );
    }

    @Override
    public void stopMovement() {
        System.out.printf("Грузовик %s %s закончил движение", this.getBrand(),this.getModel() );
    }

    @Override
    public void pitStop() {
        System.out.printf("Грузовик %s %s зашел на пит-стоп", this.getBrand(),this.getModel());
    }

    @Override
    public int getBestTime() {
        return ThreadLocalRandom.current().nextInt(1,1000);
    }

    @Override
    public int maxSpeed() {
        return ThreadLocalRandom.current().nextInt(1,350);
    }
}
