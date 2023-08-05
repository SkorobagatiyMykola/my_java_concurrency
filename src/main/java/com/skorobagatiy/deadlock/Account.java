package com.skorobagatiy.deadlock;

import java.util.concurrent.locks.Lock;

public class Account {
    private int balance;
    private Lock lock;

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
