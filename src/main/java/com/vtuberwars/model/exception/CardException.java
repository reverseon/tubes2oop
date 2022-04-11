package com.vtuberwars.model.exception;

public class CardException extends BaseException {
    ExceptionType Type;

    public CardException(String exceptionName) {
        super(exceptionName);
    }

    public void printException() {

    }
}
