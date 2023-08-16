package com.skorobagatiy.lecture_for_multythreding.lecture_2;

import static java.lang.Thread.sleep;

public class Solution_2_2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread");
        Runnable runnable = () -> {
            System.out.println("Hello");
            try {
                for (int i = 0; i < 2; i++) {
                    System.out.println("One "+i);
                    sleep(500);
                    System.out.println("Two "+i);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join(); // Switch to execute thread
        sleep(100);


        System.out.println("========== THE END =============");
    }
}
