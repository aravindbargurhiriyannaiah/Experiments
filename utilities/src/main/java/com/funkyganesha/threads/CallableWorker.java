package com.funkyganesha.threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;

import com.funkyganesha.threads.work.CallableWork;
import com.funkyganesha.threads.work.Work;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;


/**
 *
 */
public class CallableWorker implements Worker {
    private ExecutorService executorService;
    private List<Callable> workList;
    boolean finishedWorkSuccessfully;

    @Override
    public void initialize(int noOfThreads, int noOfWorkers) {
        Preconditions.checkArgument(noOfThreads >= 1, "The number of threads in the pool should be at least 1 or more. Supplied argument [" + noOfThreads + "] ");
        Preconditions.checkArgument(noOfWorkers >= 1, "The number of workers should be at least 1 or more. Supplied argument [" + noOfWorkers + "] ");
        executorService = Executors.newFixedThreadPool(noOfThreads);
        workList = Lists.newArrayList();
        for (int i = 0; i < noOfWorkers; i++) {
            workList.add(new CallableWork(RandomStringUtils.randomAlphabetic(50)));
        }
    }

    @Override
    public void doWork() {
        Preconditions.checkState(CollectionUtils.isNotEmpty(workList), "No work can be done because there are no worker threads.");
        List<Future<Work>> futures = Lists.newArrayList();
        for (Callable<Work> work : workList) {
            Future<Work> submit = executorService.submit(work);
            futures.add(submit);
        }
        executorService.shutdown();
        for (Future<Work> future : futures) {
            try {
                Work work = future.get();
                int noOfVowels = work.getNoOfVowels();
                System.out.println("Printing from [" + this.getClass().getName() + "]. No of vowels in [" + work.getText() + "] = [" + noOfVowels + "] ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        while (!executorService.isTerminated()) {

        }
        finishedWorkSuccessfully = true;
    }

    public boolean getFinishedWorkSuccessfully() {
        return finishedWorkSuccessfully;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public List<Callable> getWorkList() {
        return workList;
    }

    public void setWorkList(List<Callable> workList) {
        this.workList = workList;
    }
}
