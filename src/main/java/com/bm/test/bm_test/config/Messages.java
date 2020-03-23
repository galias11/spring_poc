package com.bm.test.bm_test.config;

// local
import com.bm.test.bm_test.model.dto.Message;

public class Messages {
    public static final Message INTERNAL_ERROR = new Message(500, "Internal server error.");
    public static final Message USERS_ALREADY_EXISTS = new Message(400, "User already exists.");
    public static final Message USERS_INVALID_CREDENTIALS = new Message(401, "User name or password is not valid.");
    public static final Message USERS_NOT_FOUND = new Message(404, "User not found");
    public static final Message USERS_REGISTER_SUCCESS = new Message(200, "User creation was successful.");
    public static final Message VIDEO_ALREADY_EXISTS = new Message(400, "A video with the provided name already exists");
    public static final Message VIDEO_CREATION_SUCCESS = new Message (200, "Video creation was successful");
}
