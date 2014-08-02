package com.funkyganesha.factory;

public class Bmw implements Car {
    private CarType carType;

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public CarType getCarType() {
        return this.carType;
    }
}
