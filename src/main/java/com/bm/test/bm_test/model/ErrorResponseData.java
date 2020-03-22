package com.bm.test.bm_test.model;

public class ErrorResponseData extends ResponseData {
    public ErrorResponseData(int errorCode, String errorDescription) {
        super();
        this.data.put("errorCode", errorCode);
        this.data.put("errorDescription", errorDescription);
    }

    public ErrorResponseData() {
        super();
    }
}
