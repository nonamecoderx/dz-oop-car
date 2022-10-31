package transport;

import driver.Driver;

import java.util.*;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final float engineVolume;

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

    public abstract void startMovement();

    public abstract void stopMovement();

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

    public void addMechanic(Mechanic<?>... mechanics) {
        this.mechanics.addAll(Set.of(mechanics));
    }

    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Set.of(sponsors));
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public abstract void printType();

    public abstract boolean service();

    public abstract void repair();

}

