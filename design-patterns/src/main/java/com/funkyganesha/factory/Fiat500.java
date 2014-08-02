package com.funkyganesha.factory;

/**
 * Created by barga009 on 8/1/14 at 9:30 PM. Comment {"$EXPR$"}
 */
public class Fiat500 implements Car {
    private CarType carType;
    @Override
    public CarType getCarType() {
        return carType;
    }

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
