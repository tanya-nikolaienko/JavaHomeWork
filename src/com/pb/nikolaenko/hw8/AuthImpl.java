package com.pb.nikolaenko.hw8;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
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


    }
}



