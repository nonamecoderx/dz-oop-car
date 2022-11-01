package transport;

import driver.Driver;

import java.util.*;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final float engineVolume;

    public float getEngineVolume() {
        return engineVolume;
    }

    public abstract boolean service();

    private final Set<Driver<?>> drivers = new HashSet<>(); //пустой список, в который добавляем новых
    private final Set<Mechanic<?>> mechanics = new HashSet<>(); //пустой список, в который добавляем новых
    private final Set<Sponsor> sponsors = new HashSet<>(); //пустой список, в который добавляем новых

    protected Transport(String brand, String model, float engineVolume) {
        if (brand == null || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        this.engineVolume = engineVolume;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void addDriver(Driver<?>... drivers) {
        this.drivers.addAll(Set.of(drivers));
    }

    public Set<Driver<?>> getDrivers() {
        return drivers;
    }

    public Set<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public abstract void startMovement();

    public abstract void stopMovement();


    public void addMechanic(Mechanic<?>... mechanics) {
        this.mechanics.addAll(Set.of(mechanics));
    }

    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Set.of(sponsors));
    }


    public abstract void printType();


    public abstract void repair();

    public static void printInfoTo(Transport transport) {
        System.out.println("Информация по авто: " + transport.getBrand() + " " + transport.getModel());

    }

}

