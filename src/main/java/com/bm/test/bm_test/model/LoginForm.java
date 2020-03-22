package com.bm.test.bm_test.model;

public class LoginForm {
    private final String userName;
    private final String password;

    public LoginForm(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
