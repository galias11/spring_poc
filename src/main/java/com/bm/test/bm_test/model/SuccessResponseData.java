package com.bm.test.bm_test.model;

// local
import com.bm.test.bm_test.interfaces.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SuccessResponseData implements ResponseData {
    private Object data;

    public SuccessResponseData(Object data) {
        this.data = data;
    }

    public Object getData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this.data);
    }
}
