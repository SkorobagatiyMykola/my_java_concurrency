package com.skorobagatiy.lecture_for_multythreding.lecture_2;

public class Solution_2_1 {
    private static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        obj.wait();

    }
}
