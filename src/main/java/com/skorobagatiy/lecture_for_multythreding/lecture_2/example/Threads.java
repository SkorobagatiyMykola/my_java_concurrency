package com.skorobagatiy.lecture_for_multythreding.lecture_2.example;

public class Threads {
    public static void main(String[] args) {
        // Тест работы потоков
        Number num = new Number();
        new FormNumber(num, 5); // Передать в другой поток 5 чисел
        new GetNumber(num, 5); // Получить из другого потока 5 чисел
    }
}
