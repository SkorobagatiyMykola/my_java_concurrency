package com.skorobagatiy.lecture_for_multythreding.lecture_2;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Solution_2_6 {
    //private static int SUM=0;
    //private static volatile int SUM=0;
    private static AtomicInteger SUM=new AtomicInteger(0);
    private static int COUNT=1_000_000;
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i <COUNT ; i++) {
                //SUM++;
                SUM.incrementAndGet(); // Solved all problems
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(SUM);
    }
}
