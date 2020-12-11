package com.acw.todoserver.advice;

public class ErrorResponse {
    private final String message;
    private final String name;

    public ErrorResponse(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}
