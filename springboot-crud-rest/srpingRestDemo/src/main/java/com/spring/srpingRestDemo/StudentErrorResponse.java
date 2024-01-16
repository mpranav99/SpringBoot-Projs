package com.spring.srpingRestDemo;

import java.util.Date;

public class StudentErrorResponse {
    //This is an error response class which will be sent as json during error handling

    private int status;
    private String message;
    private long timestamp;

    public StudentErrorResponse(){

    }

    public StudentErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
