package com.skorobagatiy.lecture_for_multythreding.yura_lectures.lecture_3;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Operations3 {
    private static final int COUNT_THREADS=3;
    private static final int COUNT_TRANSFER=10;
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        random.nextInt(700);
        Account acc1 = new Account(1000,new ReentrantLock());
        Account acc2 = new Account(1000,new ReentrantLock());

        ExecutorService service = Executors.newFixedThreadPool(COUNT_THREADS);

        for (int i = 0; i < COUNT_TRANSFER; i++) {
            service.submit(new Transfer(acc1,acc2,random.nextInt(400)));
        }

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println(acc1.getFailCounter());
    }
}
