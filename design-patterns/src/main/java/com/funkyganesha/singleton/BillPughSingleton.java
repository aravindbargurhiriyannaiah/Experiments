package com.funkyganesha.singleton;

public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class InnerClass {
        public static final BillPughSingleton BILL_PUGH_SINGLETON = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return InnerClass.BILL_PUGH_SINGLETON;
    }
}
