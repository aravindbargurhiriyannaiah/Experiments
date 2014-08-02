package com.funkyganesha.singleton;

public class Singleton {
    private static Singleton SINGLETON_INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new Singleton();
        }
        return SINGLETON_INSTANCE;
    }
}
