package transport;

import driver.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final float engineVolume;

    private final List<Driver<?>> drivers = new ArrayList<>(); //пустой список, в который добавляем новых
    private final List<Mechanic<?>> mechanics = new ArrayList<>(); //пустой список, в который добавляем новых
    private final List<Sponsor> sponsors = new ArrayList<>(); //пустой список, в который добавляем новых

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
        this.drivers.addAll(Arrays.asList(drivers));
    }

    public List<Driver<?>> getDrivers() {
        return drivers;
    }

    public List<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void addMechanic(Mechanic<?>... mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }

    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public abstract void printType();

    public abstract boolean service();

    public abstract void repair();

}

