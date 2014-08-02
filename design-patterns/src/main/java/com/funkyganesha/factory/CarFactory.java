package com.funkyganesha.factory;

import static com.funkyganesha.factory.CarType.*;

public class CarFactory {
    private Car car;

    public Car buildCar(CarType carType) {
        switch (carType) {
            case LUXURY_SEDAN: {
                car = new Bmw();
                car.setCarType(LUXURY_SEDAN);
                break;
            }
            case ECONOMY_SEDAN: {
                car = new Toyota();
                car.setCarType(ECONOMY_SEDAN);
                break;
            }
            case SMALL: {
                car = new Fiat500();
                car.setCarType(SMALL);
                break;
            }
        }
        return car;
    }
}
