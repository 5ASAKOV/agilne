package com.teodoralashes.shop.config.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionResponse {

    @JsonProperty("message")
    private String errorMessage;

    @JsonProperty("path")
    private String requestedURI;

    @JsonProperty("code")
    private String errorCode;

    @JsonProperty("status")
    private String errorStatus;

    public ExceptionResponse(String errorMessage, String requestedURI, String errorCode, String errorStatus) {
        this.errorMessage = errorMessage;
        this.requestedURI = requestedURI;
        this.errorCode = errorCode;
        this.errorStatus = errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestedURI() {
        return requestedURI;
    }

    public void setRequestedURI(String requestedURI) {
        this.requestedURI = requestedURI;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }
}
