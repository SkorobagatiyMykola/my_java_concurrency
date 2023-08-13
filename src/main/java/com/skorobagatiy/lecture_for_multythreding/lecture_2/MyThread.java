package com.skorobagatiy.lecture_for_multythreding.lecture_2;

public class MyThread extends Thread{
    @Override
    public void run() {
        int sum =0;
        for (int i = 0; i < 1000; i++) {
            sum++;

        }
        System.out.println(sum);

    }
}
