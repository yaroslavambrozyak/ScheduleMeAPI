package com.study.yaroslavambrozyak.schedulemeapi.exception;

public class RemindNotFoundException extends Exception {

    public RemindNotFoundException() {
        super();
    }

    public RemindNotFoundException(String message) {
        super(message);
    }

    public RemindNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemindNotFoundException(Throwable cause) {
        super(cause);
    }
}
