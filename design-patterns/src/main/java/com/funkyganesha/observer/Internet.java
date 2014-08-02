package com.funkyganesha.observer;
public class Internet implements Observer {
    private double interest;

    public double getInterest() {
        return interest;
    }

    public void update(double interest) {
        this.interest = interest;
        System.out.println("Internet " + interest);
    }
}
