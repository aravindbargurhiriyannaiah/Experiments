package com.funkyganesha.builder;

import org.junit.Test;
import sun.plugin.dom.exception.InvalidStateException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by barga009 on 8/2/14 at 8:22 PM. Comment {"$EXPR$"}
 */
public class CarTest {
    @Test
    public void testBuildCarValid() {
        Car car = new Car.CarBuilder("Toyota", "Camry").build();
        assertNotNull("Should not be null", car);
    }

    @Test (expected = InvalidStateException.class)
    public void testBuildCar_InvalidMPGInvariant() {
        new Car.CarBuilder("Toyota", "Camry").milesPerGallon(-9.08d).build();
    }

    @Test (expected = InvalidStateException.class)
    public void testBuildCar_InvalidMakeInvariant() {
        new Car.CarBuilder("     ", "Camry").milesPerGallon(-9.08d).build();
    }

    @Test (expected = InvalidStateException.class)
    public void testBuildCar_InvalidModelInvariant() {
        new Car.CarBuilder("  Toyota   ", "      ").milesPerGallon(-9.08d).build();
    }
}
