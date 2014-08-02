package com.funkyganesha.factory;

import static com.funkyganesha.factory.CarType.*;

public class CarFactory {
    private Car car;

    public Car buildCar(CarType carType) {
        switch (carType) {
            case LUXURY: {
                car = new BMW();
                car.setCarType(LUXURY);
                break;
            }
            case SEDAN: {
                car = new Toyota();
                car.setCarType(SEDAN);
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

    public static void main(String[] args) {
        new CarFactory().buildCar(LUXURY);
    }

}
