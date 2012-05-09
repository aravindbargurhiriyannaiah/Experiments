package com.funkyganesha.threads;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 *
 */
public abstract class CommonWorkerTestCases {
    protected  Worker worker;

    @Test
    public void testDoWork() {
        worker.initialize(10, 50);
        worker.doWork();
        assertTrue("The work should have finished successfully.", worker.getFinishedWorkSuccessfully());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitializeInvalidNoOfThreads() {
        worker.initialize(-1, 90);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInitializeInvalidNoOfWorkers() {
        worker.initialize(1, -90);
    }

    @Test(expected = IllegalStateException.class)
    public void testDoWorkWithoutCallingInitialize() throws Exception {
        worker.doWork();
    }

}
