package com.skorobagatiy.lecture_for_multythreding.lecture_2;

public class Main2 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        //t.start();
        t.run();
    }
}
