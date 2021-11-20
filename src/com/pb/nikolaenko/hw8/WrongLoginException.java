package com.pb.nikolaenko.hw8;

public class WrongLoginException extends Exception{
    public WrongLoginException(String description){
        super(description);
    }
}
