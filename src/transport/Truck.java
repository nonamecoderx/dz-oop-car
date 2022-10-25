package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Truck extends Transport implements Competing{
    private Weight weight;


    public Truck(String brand, String model, float engineVolume, Weight weight) {
        super(brand, model, engineVolume);
        this.weight = weight;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
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
    public void printType() {
        if (weight == null){
            System.out.println("Данных по авто недостаточно");
        } else {
            String from = weight.getFrom()==null?"":"от "+weight.getFrom();
            String to = weight.getTo()==null?"":"до "+weight.getTo();
            System.out.println("Грузоподъемность авто: " + from + to);
        }
    }

    @Override
    public boolean service() {
        return Math.random()>0.8;
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
