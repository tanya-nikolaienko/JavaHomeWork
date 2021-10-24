package com.pb.nikolaenko.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        int number;// мое число
        int attempt = 0;// число попыток

        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int R = random.nextInt(101); // рандомное число
        int S = 100; //ЧИСЛО СТОП

        System.out.println("Угадайте задуманное число от нуля до 100");
        System.out.println("Для выхода из игры введите число больше 100.");
        do {
            attempt++;
            System.out.println("Попытка " + attempt + ".  Введите Ваше число:");

            number = scan.nextInt(); //первичный ввод числа
            if (number >S){
                System.out.println("Конец игры!");
                break;
            }
            if ( number<R) System.out.println("Ваше число меньше");
            else if (number > R)System.out.println("Ваше число больше");
            else System.out.println("Поздравляем, Вы угадали с " + attempt + " попытки!");

        }
        while (number!=R);

    }
}
