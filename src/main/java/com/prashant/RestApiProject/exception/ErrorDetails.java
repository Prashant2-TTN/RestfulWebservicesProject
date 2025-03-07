package com.prashant.RestApiProject.exception;

import java.time.LocalDateTime;
// custom structured error response
public class ErrorDetails {
    private final LocalDateTime date;// current date and time
    private final String message;// exception message
    private final String details;// web request details

    public ErrorDetails(LocalDateTime date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
