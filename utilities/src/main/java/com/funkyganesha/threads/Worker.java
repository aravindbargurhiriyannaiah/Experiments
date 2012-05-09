package com.funkyganesha.threads;

/**
 *
 */
public interface Worker {
    void initialize(int noOfThreads, int noOfWorkers);

    void doWork();

    boolean getFinishedWorkSuccessfully();
}
