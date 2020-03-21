package com.bm.test.bm_test.model;

public class ServiceException extends Exception {
    private int errorCode;
    private String errorDescription;

    public ServiceException(int errorCode, String errorDescription) {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
