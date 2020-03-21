package com.bm.test.bm_test.model;

public class Message {
    private int code;
    private String description;

    public Message(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
