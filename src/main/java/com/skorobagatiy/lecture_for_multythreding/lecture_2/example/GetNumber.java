package com.skorobagatiy.lecture_for_multythreding.lecture_2.example;

public class GetNumber implements Runnable{
    // Внутренние переменные
    Number num; // формируемое число
    int count;   // количество чисел, которые нужно получить
    Thread thread; // ссылка на текущий поток

    GetNumber(Number num, int count) {
        // Заполнить внутренние переменные
        this.num = num;
        this.count = count;

        // Создать поток и запустить его на выполнение
        thread = new Thread(this, "GetNumber");
        thread.start();
    }

    // Метод, который содержит код выполнения потока
    public void run() {
        for (int i=0; i<count; i++) {
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток: " + thread.getName() + ", получено число " + num.get());
        }
    }
}
