package com.bm.test.bm_test.model;

// vendors
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// locals
import com.bm.test.bm_test.interfaces.ResponseData;

public class ErrorResponseData implements ResponseData {
    private class ErrorData {
        private int errorCode;
        private String errorDescription;

        public ErrorData(int errorCode, String errorDescription) {
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

    private ErrorData data;

    public ErrorResponseData(int errorCode, String errorDescription) {
        this.data = new ErrorData(errorCode, errorDescription);
    }

    public Object getData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this.data);
    }
}
