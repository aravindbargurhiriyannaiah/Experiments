package com.funkyganesha.observer;
public class ObserverTest {
    public static void main(String[] args) {
        Observer observer = new Internet();
        Loan loan = new Loan("SBI", 5.6d);
        loan.registerObserver(observer);
        loan.setInterest(4.5d);
    }
}
