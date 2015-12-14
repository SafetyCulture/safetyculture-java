package com.safetyculture.exception;

/**
 * Created by Tannu on 11/3/2015.
 */
public class APIException extends SafetyCultureException{

    private static final long serialVersionUID = 1L;

    public APIException(String message, String requestId, Integer statusCode, Throwable e) {
        super(message, requestId, statusCode, e);
    }
}
