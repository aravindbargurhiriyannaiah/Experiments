package com.funkyganesha.factory;

public class Toyota implements Car {
    private CarType carType;

    public CarType getCarType() {
        return this.carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
