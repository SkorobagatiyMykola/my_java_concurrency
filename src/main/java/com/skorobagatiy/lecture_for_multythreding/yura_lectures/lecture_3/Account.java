package com.skorobagatiy.lecture_for_multythreding.yura_lectures.lecture_3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * https://www.youtube.com/watch?v=g7ynfDFoCL4&list=PL6jg6AGdCNaXo06LjCBmRao-qJdf38oKp&index=2
 *
 * */
public class Account {
    private int balance;
    private Lock lock;
    private AtomicInteger failCounter= new AtomicInteger(0);

    public void incFailedTransferCount(){
        failCounter.incrementAndGet();
    }

    public int getFailCounter() {
        return failCounter.get();
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public Account(int balance, Lock lock) {
        this.balance = balance;
        this.lock = lock;
    }

    public void  withdraw(int amount){
        balance-=amount;
    }

    public void deposit(int amount){
        balance+=amount;
    }
}
