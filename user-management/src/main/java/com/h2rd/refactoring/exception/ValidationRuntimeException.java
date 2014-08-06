package com.h2rd.refactoring.exception;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-06
 * Time: 2:58 AM
 */
public class ValidationRuntimeException extends RuntimeException{

    public ValidationRuntimeException(){
        super();
    }

    public ValidationRuntimeException(String message){
        super(message);
    }

    public ValidationRuntimeException(String message, Exception cause){
        super(message, cause);
    }

    public ValidationRuntimeException(Exception cause){
        super(cause);
    }
}
