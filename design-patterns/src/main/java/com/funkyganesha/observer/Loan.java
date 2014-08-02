package com.funkyganesha.observer;
import java.util.ArrayList;
import java.util.List;

public class Loan implements Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    private double interest;

    public void setInterest(double interest) {
        this.interest = interest;
        notifyObservers();
    }

    public Loan() {}

    public Loan(double interest) {
        this.interest = interest;
    }

    public boolean registerObserver(Observer observer) {
        boolean result = false;
        if (observer != null) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
        return result;
    }

    public boolean removeObserver(Observer observer) {
        boolean result = false;
        if (observer != null) {
            if (observers.contains(observer)) {
                observers.remove(observer);
                result = true;
            }
        }
        return result;
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("Notifying observers");
            observer.update(this.interest);
        }
    }
}
