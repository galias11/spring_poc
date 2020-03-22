package com.bm.test.bm_test.model;

// vendors
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// locals
import com.bm.test.bm_test.config.Messages;

public class Response {
    private HttpStatus status;
    private ResponseData responseData;

    public Response(HttpStatus status, ResponseData responseData) {
        this.status = status;
        this.responseData = responseData;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public ResponseEntity getResponse() {
        ResponseEntity response = ResponseEntity.status(this.status).body(this.responseData.getData());
        return response;
    }
}
