package com.bisa.blog.exception;

public class ErrorResponse {

    private String errorType;
    private String message;

    public ErrorResponse(String errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }

    // Getters and setters

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
