package com.funkyganesha.urlshortner.exception;

public class UrlShortnerException extends  RuntimeException{
    public UrlShortnerException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public UrlShortnerException(String s) {
        super(s);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public UrlShortnerException(String s, Throwable throwable) {
        super(s, throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public UrlShortnerException(Throwable throwable) {
        super(throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
