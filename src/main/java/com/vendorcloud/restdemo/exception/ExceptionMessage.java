package com.vendorcloud.restdemo.exception;

import lombok.Data;

@Data
public class ExceptionMessage {
    private String error;
    private String message;
    private String path;
}
