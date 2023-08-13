package com.skorobagatiy.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();
    }
}
