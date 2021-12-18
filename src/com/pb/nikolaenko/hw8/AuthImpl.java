package com.pb.nikolaenko.hw8;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AuthImpl implements AuthUser {
    private static ArrayList<Auth> array = new ArrayList<Auth>();

    public boolean signIn(String Login, String Password) { // проверка входа
        boolean flag = false;

        for (Auth a : array) {
            if (a.getLogin().equals(Login) &&
                    a.getPassword().equals(Password)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void signup(Auth auth) { // регистрация
        array.add(auth);
        Scanner sc = new Scanner(System.in);
        String newlogin = sc.nextLine();
        int flags = 0; //для выхода из цикла for в регистрации
        int flagz = 0;// для выхода из цикла for
        AuthUser au = new AuthImpl();

        ////блок проверок логина
        char[] ch = newlogin.toCharArray();

        if(ch.length<5 || ch.length>20) {
            try {
                throw new WrongLoginException("Некорректная длина логина (меньше 5 или больше 20 символов)");
            } catch (WrongLoginException e) {
                e.printStackTrace();
            }
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

        ////блок проверок пароль
        System.out.println("Пожалуйста, введите пароль(латинские буквы+цифры, минимум 5 символов)");
        String newpassword = sc.nextLine();

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
            try {
                throw new WrongPasswordException("Пользователь ввел символы кирилицы");
            } catch (WrongPasswordException e) {
                e.printStackTrace();
            }
            // System.out.println("Нельзя использовать в пароле символы кирилицы");
            //System.exit(0);

            Auth n = new Auth();
            /**/n.setLogin(newlogin);
            /**/n.setPassword(newpassword);

            au.signup(n);
            System.out.println("Регистрация прошла успешно");
        }



    }
}



