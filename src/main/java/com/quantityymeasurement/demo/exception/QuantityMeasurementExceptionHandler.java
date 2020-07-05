package com.quantityymeasurement.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuantityMeasurementExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<QuantityMeasurementErrorResponse> addExceptionHandler(QuantityMeasurementResponseException message){
    QuantityMeasurementErrorResponse error=new QuantityMeasurementErrorResponse(message.getMessage());
    error.setStatusCode(HttpStatus.BAD_REQUEST.value());
    error.setTimestamp(System.currentTimeMillis());
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<QuantityMeasurementErrorResponse> addExceptionHandler(UnitLengthException message){
        QuantityMeasurementErrorResponse error=new QuantityMeasurementErrorResponse(message.getMessage());
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
