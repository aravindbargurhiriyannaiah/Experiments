package com.funkyganesha.factory;

import org.junit.Test;

import static com.funkyganesha.factory.CarType.LUXURY_SEDAN;
import static com.funkyganesha.factory.CarType.ECONOMY_SEDAN;
import static com.funkyganesha.factory.CarType.SMALL;
import static org.junit.Assert.assertTrue;

/**
 * Created by barga009 on 8/1/14 at 9:55 PM. Comment {"$EXPR$"}
 */
public class CarFactoryTest {
    @Test
    public void testDifferentCarTypes() {
        CarType carType;
        Car car;
        carType = LUXURY_SEDAN;
        car = new CarFactory().buildCar(carType);
        assertTrue("[" + carType + "] car should have been built.", car instanceof Bmw);
        assertTrue("Invalid car type.", car.getCarType().equals(carType));
        carType = ECONOMY_SEDAN;
        car = new CarFactory().buildCar(carType);
        assertTrue("[" + carType + "] car should have been built.", car instanceof Toyota);
        assertTrue("Invalid car type.", car.getCarType().equals(carType));
        carType = SMALL;
        car = new CarFactory().buildCar(carType);
        assertTrue("[" + carType + "] car should have been built.", car instanceof Fiat500);
        assertTrue("Invalid car type.", car.getCarType().equals(carType));

    }
}
