package com.skorobagatiy.volotile_atomic;

public class WithoutVolatile {
    static int count = 5_000_000;
    static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(
                () -> {
                    for (int i = 0; i < count; i++) {
                        sum++;
                    }
                }
        );

        Thread thread2 = new Thread(
                () -> {
                    for (int i = 0; i < count; i++) {
                        sum++;
                    }
                }
        );

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Main thread");

        System.out.println(sum);

    }
}
