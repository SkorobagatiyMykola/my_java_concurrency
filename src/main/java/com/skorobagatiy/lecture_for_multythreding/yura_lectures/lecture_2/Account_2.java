package com.skorobagatiy.lecture_for_multythreding.yura_lectures.lecture_2;

import java.util.concurrent.atomic.AtomicInteger;

public class Account_2 {
    private AtomicInteger failCounter;

    public void incFailedTransferCount(){
        failCounter.incrementAndGet();
    }

    public int getFailCounter() {
        return failCounter.get();
    }
}
