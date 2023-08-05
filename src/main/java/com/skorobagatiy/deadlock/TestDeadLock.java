package com.skorobagatiy.deadlock;

import static java.lang.Thread.sleep;

public class TestDeadLock {
    private static Object obj1 = new Object();
    private static Object obj2= new Object();

    public static void main(String[] args) throws Exception{
        Thread thread1 = new Thread(()-> {
            System.out.println("Thread starting ");

            synchronized (obj1){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj2){
                    System.out.println("Synchronized block!!");
                }
            }

            System.out.println("Thread end");

        },"thread1");

        Thread thread2 = new Thread(()-> {
            System.out.println("Thread starting ");

            synchronized (obj2){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj1){
                    System.out.println("Synchronized block!!");
                }
            }

            System.out.println("Thread end");

        },"thread2");

        thread1.start();
        thread2.start();


    }
}
