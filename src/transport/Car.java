package transport;

import java.security.PrivilegedAction;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Transport implements Competing{

    private TypeOfBody typeOfBody;

    public Car(String brand, String model, float engineVolume,TypeOfBody typeOfBody) {
        super(brand, model, engineVolume);
        this.typeOfBody=typeOfBody;
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    @Override
    public void startMovement() {
        System.out.printf("Автомобиль %s %s начал движение", this.getBrand(),this.getModel() );
    }

    @Override
    public void stopMovement() {
        System.out.printf("Автомобиль %s %s закончил движение", this.getBrand(),this.getModel() );
    }

    @Override
    public void printType() {
        if (typeOfBody == null){
            System.out.println("Данных по авто недостаточно");
        } else {
            System.out.println("Тип авто - " + typeOfBody);
        }
    }

    @Override
    public boolean service() {
        return Math.random()>0.5;
    }

    @Override
    public void repair() {
        System.out.println("Машина "+ getBrand()+" "+getModel()+" починена");
    }

    @Override
    public void pitStop() {
        System.out.printf("Автомобиль %s %s зашел на пит-стоп", this.getBrand(),this.getModel());
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
