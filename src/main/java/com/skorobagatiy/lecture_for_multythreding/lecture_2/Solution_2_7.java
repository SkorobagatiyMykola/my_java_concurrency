package com.skorobagatiy.lecture_for_multythreding.lecture_2;

import static java.lang.Thread.sleep;

public class Solution_2_7 {
    private static Object lock = new Object();

    public static void main(String[] args) {

        Runnable runnable = () -> {
            synchronized (lock) {

                    System.out.println(Thread.currentThread().getName());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("End");
                    System.out.println("End, name:" + Thread.currentThread().getName());
                    lock.notify();
                }
        };

        Thread thread1 = new Thread(runnable, "First");
        Thread thread2 = new Thread(runnable, "Second");

        thread1.start();
        thread2.start();

    }
}
