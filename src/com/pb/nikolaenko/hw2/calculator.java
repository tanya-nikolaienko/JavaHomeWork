package com.pb.nikolaenko.hw2;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;
        int operand2;
        String sign;

        System.out.print("Введите operand1: ");
        operand1 = scan.nextInt();
        System.out.print("Введите operand2: ");
        operand2 = scan.nextInt();
        System.out.print("Введите тип операции +-*/: ");
        sign = scan.next();

        switch (sign) {
            case "+":
                System.out.println("operand1 + operand2 = " + (operand1 + operand2));
                break;
            case "-":
                System.out.println("operand1 - operand2 = " + (operand1 - operand2));
                break;
            case "*":
                System.out.println("operand1 * operand2 = " + (operand1 * operand2));
                break;
            case "/":
                if (operand2 ==0){
                    System.out.println("Error. На ноль делить нельзя!");
                }
                else
                System.out.println("operand1 / operand2 = " + (operand1 / operand2));
                break;
            default:
                System.out.println("Оператор выбран не верно. Можно выбрать только +-*/");
        }
          }
}
