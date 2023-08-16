package com.skorobagatiy.lecture_for_multythreding.lecture_2.example;

public class FormNumber  implements Runnable{
    Number num; // Формируемое число
    int count; // количество чисел, которые нужно отправить другому потоку
    Thread thread; // Ссылка на текущий поток

    // Конструктор - получает число и количество сформированных чисел
    FormNumber(Number num, int count) {
        // Заполнить внутренние переменные
        this.num = num;
        this.count = count;

        // Создать поток и запустить его на выполнение
        thread = new Thread(this, "FormNumber");
        thread.start();
    }

    // Метод, реализующий код выполнения потока
    public void run() {
        for (int i=0; i<count; i++) {
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Сформировать некоторое случайное число от 1 до 100
            int number = (int)(Math.random()*100+1);

            System.out.println("Поток: " + thread.getName() + ", сформировано число: " + number);
            num.put(number);
        }
    }
}
