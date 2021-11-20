package com.pb.nikolaenko.hw8;

public interface AuthUser {
    public abstract  boolean signIn(String Login,String Password); // успешен ли вход

    public abstract void signup (Auth auth);// Функция регистрации пользователя
}
