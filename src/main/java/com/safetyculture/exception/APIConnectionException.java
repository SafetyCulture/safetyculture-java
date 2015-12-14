package com.safetyculture.exception;

/**
 * Created by Tannu on 11/3/2015.
 */
public class APIConnectionException extends SafetyCultureException{

    private static final long serialVersionUID = 1L;

    public APIConnectionException(String message) {
        super(message, null, 0);
    }

    public APIConnectionException(String message, Throwable e) {
        super(message, null, 0, e);
    }
}
