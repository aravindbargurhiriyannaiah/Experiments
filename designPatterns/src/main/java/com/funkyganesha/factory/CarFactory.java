package com.funkyganesha.factory;

public class CarFactory {
    private Car car;

    public Car buildCar(CarType carType) {
        switch (carType) {
            case LUXURY: {
                car = new BMW();
                break;
            }
            case SEDAN: {
                car = new Toyota();
                break;
            }
        }
        return car;
    }

    public static void main(String[] args) {
        new CarFactory().buildCar(CarType.LUXURY);
    }

}
