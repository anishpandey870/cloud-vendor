package com.vendorcloud.restdemo.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GetExceptionHandler {
//    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
//    //@ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorMessage> handlCloudVendorNotFoundException(CloudVendorNotFoundException ex, WebRequest req){
//      ErrorMessage message =new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
//      return new ResponseEntity<ErrorMessage>(message,HttpStatus.NOT_FOUND);
//    }
@Autowired
MessageSource messageSource;
    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handlCloudVendorNotFoundException(CloudVendorNotFoundException ex, WebRequest req){
        //  ErrorMessage message =new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
        //  return new ResponseEntity<ErrorMessage>(message,HttpStatus.NOT_FOUND);
        String errorMessage = messageSource.getMessage("CloudVendor.absent",new Object[]{ex.getMessage()}, new Locale("in"));
        System.out.println(errorMessage);
        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,errorMessage,new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity<ErrorMessage> IOException(IOException ex, WebRequest req){
        ErrorMessage message =new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                new Date());
        return new ResponseEntity<ErrorMessage>(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest req){
        ErrorMessage message =new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
        return new ResponseEntity<ErrorMessage>(message,HttpStatus.NOT_FOUND);
    }
}
