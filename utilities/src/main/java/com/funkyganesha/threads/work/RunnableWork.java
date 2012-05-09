package com.funkyganesha.threads.work;

public class RunnableWork implements Runnable {
    private String text;

    public RunnableWork(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        Work work = new Work(text);
        int noOfVowels = work.countVowels();
        System.out.println("Printing from [" + this.getClass().getName() + "]. No of vowels in [" + text + "] = [" + noOfVowels + "] ");
    }
}
