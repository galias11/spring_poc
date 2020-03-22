package com.bm.test.bm_test.model;

// vendors
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// locals
import com.bm.test.bm_test.config.Messages;
import com.bm.test.bm_test.interfaces.ResponseData;

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
        try {
            ResponseEntity response = ResponseEntity.status(this.status).body(this.responseData.getData());
            return response;
        } catch (JsonProcessingException e) {
            ResponseEntity response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Messages.INTERNAL_ERROR.getDescription());
            return response;
        }
    }
}
