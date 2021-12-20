package com.pb.nikolaenko.hw8;

import java.util.Scanner;

public class Auth {
    private String login;
    private String password;

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.matches("[\\w]+") && login.length() <=20 && login.length() >=5) {
            this.login = login;
        } else {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры, содержать от 5 до 20 символов");
        }
        if (password.equals(confirmPassword) && (password.matches("[\\w]+") || password.contains("_"))
                && password.length() >=5) {
            this.password = password;
        } else {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и нижнее подчеркивание");
        }
    }

    public void signIn(String login, String password) throws WrongLoginException {
        if (login.equals(this.login) && password.equals(this.password)) {
            System.out.println("Авторизация прошла успешно!");
        } else {
            throw new WrongLoginException("Неверно введен логин или пароль");
        }
    }
}
