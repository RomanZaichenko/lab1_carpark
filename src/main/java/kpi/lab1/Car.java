package kpi.lab1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Car {
    private String model;
    private Manufacturer manufacturer;
    private double fuelTankCapacity;
    private double currentFuel;
    private int kilometrage;
    private double fuelConsumption;

    public Car() {} //потрібен для роботи json

    public Car(String model, Manufacturer manufacturer, double fuelTankCapacity, double fuelConsumption, int kilometrage) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        } else {
            this.model = model;
        }

        if (manufacturer == null) {
            throw new IllegalArgumentException("Car must have the manufacturer");
        } else {
            this.manufacturer = manufacturer;
        }

        if (fuelTankCapacity < 0) {
            throw new IllegalArgumentException("Fuel Tank Capacity cannot be negative");
        }else {
            this.fuelTankCapacity = fuelTankCapacity;
        }

        this.currentFuel = fuelTankCapacity/2;
        this.kilometrage = kilometrage;
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(int kilometers) {
        if (kilometers <= 0) {
            throw new IllegalArgumentException("Kilometers must be greater than 0");
        }

        int kilometersGone = 0;
        while(kilometersGone < kilometers) {
            if (fuelConsumption <= currentFuel) {
                kilometersGone++;
                this.kilometrage++;
                currentFuel -= fuelConsumption;
            } else {
                throw new IllegalArgumentException("Fuel exceeded");
            }
        }
    }

    public void refuel(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Refuel amount must be positive");
        if (currentFuel + amount > fuelTankCapacity) {
            currentFuel = fuelTankCapacity;
        } else {
            currentFuel += amount;
        }
    }

    public void refuelToFull() {
        currentFuel = fuelTankCapacity;
    }

    @JsonIgnore
    public String getInfo() {
        return "Model: " + model + ", Manufacturer: " + manufacturer.getName() +
                ", Fuel: " + currentFuel + "L/" + fuelTankCapacity + "L, kilometrage: " + kilometrage + " km";
    }

    public String getModel() { return model; }
    public Manufacturer getManufacturer() { return manufacturer; }
    public double getFuelTankCapacity() { return fuelTankCapacity; }
    public double getCurrentFuel() { return currentFuel; }
    public int getKilometrage() { return kilometrage; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car carToCompare)) return false;

        return model.equalsIgnoreCase(carToCompare.model)
                && manufacturer.equals(carToCompare.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, manufacturer, fuelTankCapacity, currentFuel, kilometrage, fuelConsumption);
    }
}
