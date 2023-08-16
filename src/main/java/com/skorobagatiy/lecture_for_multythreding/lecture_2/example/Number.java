package com.skorobagatiy.lecture_for_multythreding.lecture_2.example;

public class Number {
    int n;

    // флажок, определяющий параллельный ли поток
    // сформировал/получил число
    boolean valueSet = false;

    // Метод, возвращающий число
    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        valueSet=false;
        notify();
        return n;
    }

    // Метод, который используется для передачи числа другому потоку
    synchronized void put(int n) {
        // Ожидать, пока не будет получено (valueSet=false)
        while(valueSet) {
            try {
                wait();
            }
            catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        this.n = n;
        valueSet=true;
        notify();
    }
}
