package com.funkyganesha.threads.work;

import java.util.concurrent.Callable;

/**
 *
 */
public class CallableWork implements Callable<Work> {

    private String text;

    public CallableWork(String text) {
        this.text = text;
    }

    @Override
    public Work call() throws Exception {
        Work work = new Work(text);
        work.countVowels();
        return work;
    }
}
