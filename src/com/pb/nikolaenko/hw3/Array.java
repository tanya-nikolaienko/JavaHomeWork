package com.pb.nikolaenko.hw3;

import java.util.Scanner;
public class Array {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
       // System.out.println("Enter array length: ");
        int size = 10;//input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int sum = 0;
        int sump = 0;
        int array[] = new int[size]; // Создаём массив int размером в size
        int temp;// перемення для сортированного массива
        System.out.println("Введите элементы для массива:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print("1.Полученный массив элементов:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            sum = sum + array[i];
        }
        System.out.println("2.Сумма элементов массива= "+ sum);

        for (int i = 0; i < size; i++) {
                        if (array[i]>0) {
                            sump = sump + array[i];
                        }
        }
        System.out.println("3.Сумма положительных элементов массива= "+ sump);
        for (int i = size - 1; i > 0; i--) {            // внешний цикл
            for (int j = 0; j < i; j++) {                       // внутренний цикл
                if (array[j] > array[j + 1]) {                  // сравнение
                    temp = array[j];                            // если истино, то меняем
                    array[j] = array[j + 1];                    // местами элементы
                    array[j + 1] = temp;
                }
            }
        }
        // конец сортировки
        System.out.println("4.Oтсортированный массив: " );
        for (int i = 0; i <  size; i++) {
            System.out.print(array[i]);
    }
    }
}