package com.bm.test.bm_test.model.dto;

// vendors
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class ResponseData {
    protected HashMap<String, Object> data;

    public ResponseData() {
        this.data = new HashMap<String, Object>();
    }

    public void addElement(String key, Object value) {
        this.data.put(key, value);
    }

    public String getData()  {
        Gson gsonBuilder = new GsonBuilder().create();
        return gsonBuilder.toJson(this.data);
    }
}
