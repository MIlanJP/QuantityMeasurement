package com.quantityymeasurement.demo.exception;

public class UnitLengthException extends Exception{

    public enum ExceptionType {
        NULLVALUESUPPLIED,INVALID_CONVERSION
    }

     public ExceptionType type;

    public UnitLengthException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
