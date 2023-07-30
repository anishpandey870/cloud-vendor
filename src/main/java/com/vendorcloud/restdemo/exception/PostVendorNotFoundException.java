package com.vendorcloud.restdemo.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@ControllerAdvice

@Order(Ordered.HIGHEST_PRECEDENCE)
public class PostVendorNotFoundException {
//    @Autowired
//    MessageSource messageSource;
//    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
//    //@ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorMessage> handlCloudVendorNotFoundException(CloudVendorNotFoundException ex, WebRequest req){
//      //  ErrorMessage message =new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
//      //  return new ResponseEntity<ErrorMessage>(message,HttpStatus.NOT_FOUND);
//        String errorMessage = messageSource.getMessage("CloudVendor.absent",new Object[]{ex.getMessage()}, new Locale("in"));
//        System.out.println(errorMessage);
//        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,errorMessage,new Date());
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleAllExceptionMethod(Exception ex, WebRequest requset) {

        ExceptionMessage exceptionMessageObj = new ExceptionMessage();

        // Handle All Field Validation Errors
        if(ex instanceof MethodArgumentNotValidException) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
            for(FieldError fieldError: fieldErrors){
                sb.append(fieldError.getDefaultMessage());
                sb.append(";");
            }
            exceptionMessageObj.setMessage(sb.toString());
        }else{
            exceptionMessageObj.setMessage(ex.getLocalizedMessage());
        }

        exceptionMessageObj.setError(ex.getClass().getCanonicalName());
        exceptionMessageObj.setPath(((ServletWebRequest) requset).getRequest().getServletPath());

        // return exceptionMessageObj;
        return new ResponseEntity<>(exceptionMessageObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
