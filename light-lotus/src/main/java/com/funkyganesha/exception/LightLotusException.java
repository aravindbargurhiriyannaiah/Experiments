package com.funkyganesha.exception;

public class LightLotusException extends RuntimeException {
    public LightLotusException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public LightLotusException(String s) {
        super(s);            //To change body of overridden methods use File | Settings | File Templates.
    }

    public LightLotusException(String s, Throwable throwable) {
        super(s, throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public LightLotusException(Throwable throwable) {
        super(throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
