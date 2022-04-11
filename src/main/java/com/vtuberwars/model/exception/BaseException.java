package com.vtuberwars.model.exception;

public class BaseException {
    private String exceptionName;

    public BaseException(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getException() {
        return this.exceptionName;
    }
    public void printException() {
        System.out.println(this.exceptionName + " exception");
    }
}
