package com.funkyganesha.threads;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class RunnableWorkerTest extends CommonWorkerTestCases {

    private RunnableWorker runnableWorker = new RunnableWorker();

    @Before
    public void setUp() {
        worker = new RunnableWorker();
    }

    @Test
    public void testInitialize() {
        runnableWorker.initialize(5, 500);
        List<Runnable> workList = runnableWorker.getWorkList();
        assertNotNull("The result should not be null", workList);
        assertEquals("Incorrect number of workers created.", 500, workList.size());
        assertNotNull("The executor service should not be null", runnableWorker.getExecutorService());
    }


}
