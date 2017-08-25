package com.study.yaroslavambrozyak.schedulemeapi.controller;

import com.study.yaroslavambrozyak.schedulemeapi.exception.UserRegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity handleRegistrationException(UserRegistrationException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error Message");
    }

}
