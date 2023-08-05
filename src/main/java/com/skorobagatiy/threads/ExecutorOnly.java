package com.skorobagatiy.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class ExecutorOnly {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()-> System.out.println("I am working"));

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(thread);
        sleep(100);

        executorService.submit(thread);
        sleep(100);

        executorService.submit(thread);
        sleep(100);

        executorService.submit(thread);
    }
}
