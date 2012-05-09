package com.funkyganesha.threads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;

import com.funkyganesha.threads.work.RunnableWork;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;


public class RunnableWorker implements Worker {

    private ExecutorService executorService;
    private List<Runnable> workList;
    private boolean finishedWorkSuccessfully;

    @Override
    public void initialize(int noOfThreads, int noOfWorkers) {
        Preconditions.checkArgument(noOfThreads >= 1, "The number of threads in the pool should be at least 1 or more. Supplied argument [" + noOfThreads + "] ");
        Preconditions.checkArgument(noOfWorkers >= 1, "The number of workers should be at least 1 or more. Supplied argument [" + noOfWorkers + "] ");
        executorService = Executors.newFixedThreadPool(noOfThreads);
        workList = Lists.newArrayList();
        for (int i = 0; i < noOfWorkers; i++) {
            workList.add(new RunnableWork(RandomStringUtils.randomAlphabetic(50)));
        }
    }

    @Override
    public void doWork() {
        Preconditions.checkState(CollectionUtils.isNotEmpty(workList), "No work can be done because there are no worker threads.");
        for (Runnable work : workList) {
            executorService.execute(work);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            //wait for all the threads to finish the task.
        }
        finishedWorkSuccessfully = true;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public List<Runnable> getWorkList() {
        return workList;
    }

    public void setWorkList(List<Runnable> workList) {
        this.workList = workList;
    }

    @Override
    public boolean getFinishedWorkSuccessfully() {
        return finishedWorkSuccessfully;
    }
}
