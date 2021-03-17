package com.zeed.tdd.exception;

public class BookNotFoundException extends Throwable {

    public BookNotFoundException(String message) {
        super(message);
    }
}
