package com.skorobagatiy.threads;

import static java.lang.Thread.sleep;

public class TreadsOnly {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()-> System.out.println("I am working"));

        thread.start();
        sleep(100);

        thread.start();

    }
}
