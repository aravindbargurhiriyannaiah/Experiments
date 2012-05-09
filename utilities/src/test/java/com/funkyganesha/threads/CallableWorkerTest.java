package com.funkyganesha.threads;

import java.util.List;
import java.util.concurrent.Callable;

import org.junit.Before;
import org.junit.Test;

import com.funkyganesha.threads.work.CallableWork;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 *
 */
public class CallableWorkerTest extends CommonWorkerTestCases{

    private CallableWorker callableWorker = new CallableWorker();

    @Before
    public void setUp() {
        worker = new CallableWorker();
    }

    @Test
    public void testInitialize() {
        callableWorker.initialize(5, 500);
        List<Callable> workList = callableWorker.getWorkList();
        assertNotNull("The result should not be null", workList);
        assertEquals("Incorrect number of workers created.", 500, workList.size());
        assertNotNull("The executor service should not be null", callableWorker.getExecutorService());
    }

}
