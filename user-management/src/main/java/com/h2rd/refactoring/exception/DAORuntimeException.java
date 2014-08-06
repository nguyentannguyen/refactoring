package com.h2rd.refactoring.exception;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-06
 * Time: 2:58 AM
 */
public class DAORuntimeException extends RuntimeException{

    public DAORuntimeException(){
        super();
    }

    public DAORuntimeException(String message){
        super(message);
    }

    public DAORuntimeException(String message, Exception cause){
        super(message, cause);
    }

    public DAORuntimeException(Exception cause){
        super(cause);
    }
}
