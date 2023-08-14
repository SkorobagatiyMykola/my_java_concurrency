package com.skorobagatiy.lecture_for_multythreding.yura_lectures.lecture_1;

import com.skorobagatiy.deadlock.Account;
import com.skorobagatiy.deadlock.InsufficientFundsException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Operations {
    static long WAIT_SEC = 1l;

    public static void main(String[] args) throws InsufficientFundsException, InterruptedException {
        final Account a = new com.skorobagatiy.deadlock.Account(1000, new ReentrantLock());
        final Account b = new com.skorobagatiy.deadlock.Account(2000, new ReentrantLock());

        new Thread(() -> {
            try {
                transfer(a, b, 500);
            } catch (InsufficientFundsException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        transfer(b, a, 300);

        sleep(1000);
        System.out.println(a.getBalance());
        System.out.println(b.getBalance());

    }

    private static void transfer(Account acc1, Account acc2, int amount) throws InsufficientFundsException, InterruptedException {
        if (acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                System.out.println("Lock 1-first");
                if (acc1.getBalance() - amount < 0) {
                    throw new InsufficientFundsException("");
                }
                sleep(100);
                if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        acc1.withdraw(amount);
                        acc2.deposit(amount);
                    } finally {
                        acc2.getLock().unlock();
                    }

                }
            } finally {
                acc1.getLock().unlock();
            }
        }
    }

}
