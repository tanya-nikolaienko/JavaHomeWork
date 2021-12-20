package com.pb.nikolaenko.hw8;

public class WrongLoginException extends Throwable {

    public WrongLoginException() {

    }

    public WrongLoginException(String message) {
        super(message);
    }
}
