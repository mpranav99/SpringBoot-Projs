package com.spring.srpingRestDemo;

public class StudentNotFoundException extends RuntimeException{

    // this is a custom exception class which throws exceptions when there

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
