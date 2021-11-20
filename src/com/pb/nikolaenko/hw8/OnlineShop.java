package com.pb.nikolaenko.hw8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        while (true) {
            System.out.println("-------Что вы хотите сделать?-------");
            System.out.println("Для входа на сайт нажмите - 1. **** Для регистрации - нажмите 2. **** Для выхода - нажмите 3 ");
            System.out.println("Введите цифру: ");
            Scanner sc = new Scanner(System.in);
            AuthUser au = new AuthImpl();
            String choice = sc.nextLine();


            int flags = 0; //для выхода из цикла for в регистрации
            int flagz = 0;// для выхода из цикла for

            switch (choice) {
                case "1":  //Вход
                    System.out.println("----Вход-------");
                    System.out.println("Пожалуйста, введите логин");
                    String login = sc.nextLine();
                    System.out.println("Пожалуйста, введите  пароль");
                    String password = sc.nextLine();

                    boolean flag = au.signIn(login, password);
                    if (flag) {
                        System.out.println("Успешный вход");
                        System.exit(0);
                    } else {
                        System.out.println("Неверное имя пользователя или пароль, вход не выполнен");
                    }
                    break;
                case "2":
                    System.out.println("---------- Регистрация ----------");

                    System.out.println("Пожалуйста, введите логин (латинские буквы+цифры, 5-20 символов)");
                    String newlogin = sc.nextLine();

                    char[] ch = newlogin.toCharArray();  //блок проверок логина

                    if(ch.length<5 || ch.length>20) {
                     throw new WrongLoginException("Некорректная длина логина (меньше 5 или больше 20 символов)");

                    }

                    for (int i = 0; i < 1; i++) {
                        if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z') ||(ch[i] >= '0' && ch[i] <= '9')) {
                            flags = 0;
                             // System.out.println("Результат проверки: Корректный логин (латиница +цифры)");
                        } else
                            flags++;
                        break;
                    }

                    if (flags != 0) {
                       System.out.println("Нельзя использовать символы кирилицы");
                       System.exit(0);
                    }




                    System.out.println("Пожалуйста, введите пароль(латинские буквы+цифры, минимум 5 символов)");
                    String newpassword = sc.nextLine();
// блок проверки пароля
                    char[] chp = newpassword.toCharArray();
                    if(chp.length<5 ) {
                        System.out.println("Некорректная длина пароля (меньше 5  символов)");
                        return;}

                    for (int j = 0; j < 1; j++) {
                        if ((chp[j] >= 'a' && chp[j] <= 'z') || (chp[j] >= 'A' && chp[j] <= 'Z') || (chp[j] >= '0' && ch[j] <= '9') /*|| (chp[j] >= '_')*/) {
                            flagz = 0;
                             System.out.println("Результат проверки: Корректный пароль (латиница +цифры)");
                        } else
                            flagz++;
                        break;
                    }

                    if (flagz != 0) {
                        throw new WrongPasswordException("Пользователь ввел символы кирилицы");
                       // System.out.println("Нельзя использовать в пароле символы кирилицы");
                        //System.exit(0);
                    }


                    Auth n = new Auth();
                    n.setLogin(newlogin);
                    n.setPassword(newpassword);

                    au.signup(n);
                    System.out.println("Регистрация прошла успешно");
                    break;

                case "3":
                    System.out.println("Выход");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверный ввод, пожалуйста, введите заново");
                    break;

            }

        }


    }
}





