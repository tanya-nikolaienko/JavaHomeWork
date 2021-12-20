package com.pb.nikolaenko.hw8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class OnlineShop {
    public static void main(String[] args) {

        String login;
        String password;
        String confirmPassword;

        Scanner sc = new Scanner(System.in);

        System.out.println("РЕГИСТРАЦИЯ");
        System.out.println();

        System.out.println("Введите логин: ");
        login = sc.nextLine();

        System.out.println("Введите пароль: ");
        password = sc.nextLine();

        System.out.println("Повторите пароль: ");
        confirmPassword = sc.nextLine();

        Auth user = new Auth();

        try {
            user.signUp(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e);
            return;
        } catch (WrongPasswordException e1) {
            System.out.println(e1);
            return;
        }

        System.out.println("АВТОРИЗАЦИЯ");
        System.out.println();

        System.out.println("Введите логин: ");
        login = sc.nextLine();

        System.out.println("Введите пароль: ");
        password = sc.nextLine();

        try {
            user.signIn(login, password);
        } catch (WrongLoginException e2) {
            System.out.println(e2);
        }


    }
}




