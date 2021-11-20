package com.pb.nikolaenko.hw8;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String description){
        super(description);
    }
}