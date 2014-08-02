package com.funkyganesha.singleton;

import java.util.concurrent.Callable;

/**
 * Created by barga009 on 8/1/14 at 11:42 PM. Comment {"$EXPR$"}
 */
public class BillPughSingletonCreatorCallable implements Callable<BillPughSingleton> {
    @Override
    public BillPughSingleton call() throws Exception {
        return BillPughSingleton.getInstance();
    }
}
