package com.vtuberwars.model.exception;

public class CardSpaceException extends BaseException {
    ExceptionType Type;

    public CardSpaceException(String exceptionName) {
        super(exceptionName);
    }

    public void printException() {

    }
}
