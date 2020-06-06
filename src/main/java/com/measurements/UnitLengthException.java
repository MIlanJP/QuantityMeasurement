package com.measurements;

public class UnitLengthException extends Exception{

    enum ExceptionType {
        NULLVALUESUPPLIED,INVALID_CONVERSION
    }

    ExceptionType type;

    public UnitLengthException(String message,ExceptionType type) {
        super(message);
        this.type = type;
    }
}
