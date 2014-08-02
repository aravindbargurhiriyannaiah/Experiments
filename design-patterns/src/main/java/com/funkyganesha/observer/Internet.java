package com.funkyganesha.observer;
public class Internet implements Observer {
    public void update(double interest) {
        System.out.println("Internet " + interest);
    }
}
