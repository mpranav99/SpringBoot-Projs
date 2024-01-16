package com.spring.srpingRestDemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExcceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlingExceptions(StudentNotFoundException exc){

        //create an obj of custom error response i.e student error response in our case
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());

        //return the ResponseEntity by passing the error(body) and the status code
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //another exception handler for all kinds of exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllExceptions(Exception ex){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());

        //return the ResponseEntity by passing the error(body) and the status code
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
