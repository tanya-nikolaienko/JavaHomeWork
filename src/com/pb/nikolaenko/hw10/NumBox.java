package com.pb.nikolaenko.hw10;

import java.lang.reflect.Array;
import java.util.Arrays;
/*
Создать пакет hw10.
Реализовать параметризованный класс NumBox, T - параметр типа.
Параметром должен быть любой класс-наследник Number (задать необходимое условие при объявлении класса NumBox).
Класс содержит:
- массив из объектов класса T, инициализировать массив в конструкторе.
- конструктор принимающий параметр - максимальную длину массива.
- метод void add(T num) добавляющий число в массив. В случае если массив полон - выбросить исключение.
- метод T get(int index) возвращающий число по индексу.
- метод int length() возвращает текущее количество элементов.
- метод double average() - подсчет среднего арифметического среди элементов массива.
- метод double sum() - сумма всех элементов массива.
- метод T max() - максимальный элемент массива.
При подсчете воспользоваться тем, что у любого из объектов подклассов Number есть методы intValue, doubleValue, floatValue и другие.


Создать класс Main с методом main где протестировать полученный класс на примере NumBox<Float> и NumBox<Integer>.
*/
public class NumBox<T extends Number> {
    private T[] array;
    private int size = 0;

    public NumBox(int maxSize, Class clazz) {
        array = (T[]) Array.newInstance(clazz, maxSize);
    }

    public void add(T num) {
        final int index = size;
        array[index] = num;
        size++;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return size;
    }

    public double average() {
        return sum() / length();
    }

    public double sum() {
        double arrSum = 0;
        for (int i = 0; i < size; i++) {
            arrSum += array[i].doubleValue();
        }
        return arrSum;
    }

    public T max() {
        if (size - 1 == 0) {
            throw new ArithmeticException("Массив пустой");
        }
        T maxValue = array[0];
        for (int i = 1; i < size; i++) {
            if (maxValue.doubleValue() < array[i].doubleValue()) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public void printArr() {
        System.out.print(array.getClass().getSimpleName() + ": ");
        System.out.println(Arrays.toString(array));
    }

}


