package com.pb.nikolaenko.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    static void FIteration()

    {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите первую фразу: ");
        String originalF = input.nextLine();//вводим нашу фразу
        originalF = originalF.toLowerCase();//приводим в нижний регистр, тк сортировка чуствительна к регистру

        String originalF2 = originalF.replaceAll("\\s","");//удаление пробелов
        String originalF3 = originalF2.replaceAll("[^а-яА-ЯёЁ]", "");//удаление пунктуации
//        System.out.println("Строка отформатированная: " + originalF3);//выполнения замен пробелов и запятых
        char[] charsF = originalF3.toCharArray();
        Arrays.sort(charsF);
        String sortedF = new String(charsF);
//        System.out.println(sortedF);


        System.out.print("Введите вторую фразу: ");
        String originalS = input.nextLine();//вводим нашу фразу
        originalS = originalS.toLowerCase();

        String originalS2 = originalS.replaceAll("\\s","");//удаление пробелов
        String originalS3 = originalS2.replaceAll("[^а-яА-ЯёЁ]","");//удаление пунктуации

        //System.out.println(originalS3);//проверка выполнения замен пробелов и запятых
        char[] charsS = originalS3.toCharArray();
        Arrays.sort(charsS);
        String sortedS = new String(charsS);
        //System.out.println(sortedS);

        boolean test1 = sortedF.equals(sortedS);

        if (test1 == true){
            System.out.println("Да, эти фразы являются анаграммой");
        } else {
            System.out.println("Нет, эти фразы не являются анаграммой");
        }
    }


    public static void main(String[] args) {
        FIteration();
    }
}


