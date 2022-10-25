package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Bus extends Transport implements Competing{
    private Capacity capacity;
    public Bus(String brand, String model, float engineVolume,Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void startMovement() {
        System.out.printf("Автобус %s %s начал движение", this.getBrand(),this.getModel() );
    }

    @Override
    public void stopMovement() {
        System.out.printf("Автобус %s %s начал движение", this.getBrand(),this.getModel() );
    }

    @Override
    public void printType() {
        if (capacity == null){
            System.out.println("Данных по авто недостаточно");
        } else {
            System.out.println("Вместимость автобуса: от " + capacity.getFrom()+" до "+capacity.getTo());
        }
    }

    @Override
    public boolean service() {
        System.out.println("Автобусу "+getBrand()+" "+getModel()+" ТО не требуется");
        return true;
    }

    @Override
    public void pitStop() {
        System.out.printf("Автобус %s %s зашел на пит-стоп", this.getBrand(),this.getModel());
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
