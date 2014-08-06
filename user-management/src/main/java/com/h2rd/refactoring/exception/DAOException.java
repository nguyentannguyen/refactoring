package com.h2rd.refactoring.exception;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-06
 * Time: 2:58 AM
 */
public class DAOException extends RuntimeException{

    public DAOException(){
        super();
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(String message, Exception cause){
        super(message, cause);
    }

    public DAOException(Exception cause){
        super(cause);
    }
}
