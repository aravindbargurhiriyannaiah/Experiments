package com.funkyganesha.singleton;

import org.junit.Test;

import java.util.concurrent.*;

import static junit.framework.Assert.assertTrue;

/**
 * Created by barga009 on 8/1/14 at 10:07 PM. Comment {"$EXPR$"}
 */
public class SingletonTest {

    public static final int NUMBER_OF_THREADS = 400;
    public static final int NUMBER_OF_TIMES_THREADS_SHOULD_CREATE_SINGLETONS = 10000;

    //The larger the number of threads and number of singletons to create, greater the probability of failure.
    @Test
    public void testGetInstanceMultipleThreads() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        CompletionService<Singleton> completionService = new ExecutorCompletionService<Singleton>(threadPool);

        for (int i = 0; i < NUMBER_OF_TIMES_THREADS_SHOULD_CREATE_SINGLETONS; i++) {
            completionService.submit(new SingletonCreatorCallable());
        }

        System.out.println("Unleashed [" + NUMBER_OF_THREADS + "] threads to create [" + NUMBER_OF_TIMES_THREADS_SHOULD_CREATE_SINGLETONS + "] singletons.");
        Singleton s1 = completionService.take().get();
        Singleton s2;
        for (int i = 1; i < NUMBER_OF_TIMES_THREADS_SHOULD_CREATE_SINGLETONS; i++) {
            s2 = completionService.take().get();
            assertTrue("The instances should be equal to one another as they are singletons. instance1 [" + s1 + "], instance2 [" + s2 + "]", s1 == s2);
            s1 = s2;
        }
        threadPool.shutdown();
    }

    @Test
    public void testBillPughGetInstanceMultipleThreads() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        CompletionService<BillPughSingleton> completionService = new ExecutorCompletionService<BillPughSingleton>(threadPool);

        for (int i = 0; i < NUMBER_OF_TIMES_THREADS_SHOULD_CREATE_SINGLETONS; i++) {
            completionService.submit(new BillPughSingletonCreatorCallable());
        }

        System.out.println("Unleashed [" + NUMBER_OF_THREADS + "] threads to create [" + NUMBER_OF_TIMES_THREADS_SHOULD_CREATE_SINGLETONS + "] singletons.");
        BillPughSingleton s1 = completionService.take().get();
        BillPughSingleton s2;
        for (int i = 1; i < NUMBER_OF_TIMES_THREADS_SHOULD_CREATE_SINGLETONS; i++) {
            s2 = completionService.take().get();
            assertTrue("The instances should be equal to one another as they are singletons. instance1 [" + s1 + "], instance2 [" + s2 + "]", s1 == s2);
            s1 = s2;
        }
        threadPool.shutdown();
    }

    @Test
    public void testGetInstanceMultipleTimes() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2;
        for (int i = 0; i < 10; i++) {
            s2 = Singleton.getInstance();
            assertTrue("The instances should have been equal to one another as they are singleton", s1 == s2);
            s1 = s2;
        }
    }

    @Test
    public void testBullPughGetInstanceMultipleTimes() {
        BillPughSingleton s1 = BillPughSingleton.getInstance();
        BillPughSingleton s2;
        for (int i = 0; i < 10; i++) {
            s2 = BillPughSingleton.getInstance();
            assertTrue("The instances should have been equal to one another as they are singleton", s1 == s2);
            s1 = s2;
        }
    }
}
