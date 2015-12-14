package com.safetyculture.exception;

/**
 * Created by Tannu on 11/3/2015.
 */
public class InvalidRequestException extends SafetyCultureException{

    private static final long serialVersionUID = 1L;

    private final String param;

    public InvalidRequestException(String message, String param, String requestId, Integer statusCode, Throwable e) {
        super(message, requestId, statusCode, e);
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
