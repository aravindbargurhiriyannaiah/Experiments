package com.funkyganesha.builder;

/**
 * Created by barga009 on 8/2/14 at 7:48 PM. Comment {"$EXPR$"}
 */
public class CarUser {
    public void useCar() {
        Car car = new Car.CarBuilder("BMW", "7 series").milesPerGallon(22.9).color("blue").countryOfManufacture("germany").numberOfCylinders(6).build();
    }
}
