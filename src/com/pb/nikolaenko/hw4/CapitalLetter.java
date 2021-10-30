package com.pb.nikolaenko.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class CapitalLetter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Объявляем Scanner // переменная input для чтения с клавиатуры

        System.out.print("Введите фразу: ");
        String phraze = input.nextLine();//вводим нашу фразу

        StringBuilder phraze2 = new StringBuilder(phraze);//новая переменная для отформатированной фразы

        for(int i=0;i<phraze2.length();i++)
            if(i==0 || phraze2.charAt(i-1)==' ')//first letter to uppercase by default
                phraze2.setCharAt(i, Character.toUpperCase(phraze2.charAt(i)));

        System.out.print("Отформатированная фраза: " + phraze2);//
    }
}