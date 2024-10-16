package me.bosca.eventsapi.global;

import java.util.List;

public class ValidationErrorResponse {

    private int status;
    private String message;
    private long timestamp;
    private List<FieldErrorDetails> errors;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public List<FieldErrorDetails> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldErrorDetails> errors) {
        this.errors = errors;
    }

    public static class FieldErrorDetails {
        private String field;
        private String errorMessage;

        public FieldErrorDetails(String field, String errorMessage) {
            this.field = field;
            this.errorMessage = errorMessage;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        // Constructors, Getters, and Setters
    }
}
