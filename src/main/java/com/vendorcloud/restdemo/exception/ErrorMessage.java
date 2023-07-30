package com.vendorcloud.restdemo.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;
public class ErrorMessage {
    private HttpStatus httpStatus;
    private  String message;
   // private  String errorCode;
    private Date date;

    public ErrorMessage(HttpStatus httpStatus, String message, Date date) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.date = date;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
