package com.funkyganesha.singleton;

import java.util.concurrent.Callable;

/**
 * Created by barga009 on 8/1/14 at 10:21 PM. Comment {"$EXPR$"}
 */
public class SingletonCreatorCallable implements Callable<Singleton> {

    @Override
    public Singleton call() throws Exception {
        return Singleton.getInstance();
    }
}
