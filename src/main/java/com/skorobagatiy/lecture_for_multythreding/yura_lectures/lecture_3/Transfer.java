package com.skorobagatiy.lecture_for_multythreding.yura_lectures.lecture_3;

import com.skorobagatiy.deadlock.InsufficientFundsException;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Transfer implements Callable<Boolean> {
    static long WAIT_SEC = 1l;

    private Account accountFrom;
    private Account accountTo;
    private int amount;

    public Transfer(Account accountFrom, Account accountTo, int amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        if (accountFrom.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                //System.out.println("Begin transfer");
                if (accountFrom.getBalance() - amount < 0) {
                    System.out.println("Error");
                    accountFrom.incFailedTransferCount();
                    throw new InsufficientFundsException("");
                    //return false;
                }
                sleep(100);
                if (accountTo.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        accountFrom.withdraw(amount);
                        accountTo.deposit(amount);
                        return true;
                    } finally {
                        accountTo.getLock().unlock();
                    }
                }
            } finally {
                accountFrom.getLock().unlock();
            }
        } else {
            accountFrom.incFailedTransferCount();
            return false;
        }
        return true;
    }
}
