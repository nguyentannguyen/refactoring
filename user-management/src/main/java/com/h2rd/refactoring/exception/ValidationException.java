package com.h2rd.refactoring.exception;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-06
 * Time: 2:58 AM
 */
public class ValidationException extends RuntimeException{

    public ValidationException(){
        super();
    }

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(String message, Exception cause){
        super(message, cause);
    }

    public ValidationException(Exception cause){
        super(cause);
    }
}
