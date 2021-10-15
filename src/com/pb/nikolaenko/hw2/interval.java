package com.pb.nikolaenko.hw2;

import java.util.Scanner;

public class interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;
        System.out.print("Введите целое число: ");
        x = scan.nextInt();
        if (x < 0) {
            System.out.print("Число вне промежутков");
        } else if (x <= 14) {
            System.out.print("Число относится к промежутку [0 -14]");
        } else if (x <= 35) {
            System.out.print("Число относится к промежутку[15 -35]");
        } else if (x <= 50) {
            System.out.print("Число относится к промежутку [36 -50]");
        }else if (x <= 100) {
            System.out.print("Число относится к промежутку [51 -100]");
        }else if (x > 100) {
            System.out.print("Число вне промежутков");
        }

    }
}
