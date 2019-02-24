package com.baie.other.retry.exception;

public class RemoteServiceNotAvailableException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RemoteServiceNotAvailableException(String msg) {
        super(msg);
    }

    public RemoteServiceNotAvailableException(String msg, Exception ex) {
        super(msg, ex);
    }
}
