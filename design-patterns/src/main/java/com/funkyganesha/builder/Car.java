package com.funkyganesha.builder;

/**
 * Created by barga009 on 8/2/14 at 3:27 PM. Comment {"$EXPR$"}
 */
public class Car {
    private final String make;
    private final int yearManufactured;
    private final String color;
    private final int numberOfCylinders;
    private final int cc;
    private final String model;
    private final double milesPerGallon;
    private final String countryOfManufacture;
    private final String vinNumber;

    public static class CarBuilder {
        //This is a required attribute
        private final String make;
        //This is a required attribute
        private final String model;

        //These are all optional attributes.
        private int yearManufactured;
        private String color;
        private int numberOfCylinders;
        private int cc;
        private double milesPerGallon;
        private String countryOfManufacture;
        private String vinNumber;

        public CarBuilder(String make, String model) {
            this.make = make;
            this.model = model;
        }

        public CarBuilder yearManufactured(int yearManufactured) {
            this.yearManufactured = yearManufactured;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder numberOfCylinders(int numberOfCylinders) {
            this.numberOfCylinders = numberOfCylinders;
            return this;
        }

        public CarBuilder cc(int cc) {
            this.cc = cc;
            return this;
        }

        public CarBuilder milesPerGallon(double milesPerGallon) {
            this.milesPerGallon = milesPerGallon;
            return this;
        }

        public CarBuilder vinNumber(String vinNumber) {
            this.vinNumber = vinNumber;
            return this;
        }

        public CarBuilder countryOfManufacture(String countryOfManufacture) {
            this.countryOfManufacture = countryOfManufacture;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    private Car(CarBuilder carBuilder) {
        this.make = carBuilder.make;
        this.yearManufactured = carBuilder.yearManufactured;
        this.color = carBuilder.color;
        this.numberOfCylinders = carBuilder.numberOfCylinders;
        this.cc = carBuilder.cc;
        this.model = carBuilder.model;
        this.milesPerGallon = carBuilder.milesPerGallon;
        this.countryOfManufacture = carBuilder.countryOfManufacture;
        this.vinNumber = carBuilder.vinNumber;
    }

    public String getMake() {
        return make;
    }

    public int getYearManufactured() {
        return yearManufactured;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public int getCc() {
        return cc;
    }

    public String getModel() {
        return model;
    }

    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    public String getCountryOfManufacture() {
        return countryOfManufacture;
    }

    public String getVinNumber() {
        return vinNumber;
    }
}
