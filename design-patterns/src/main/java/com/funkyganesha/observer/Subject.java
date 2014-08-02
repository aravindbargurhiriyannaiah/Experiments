package com.funkyganesha.observer;

public interface Subject {
    boolean registerObserver(Observer observer);

    void notifyObservers();

    boolean removeObserver(Observer observer);
}
