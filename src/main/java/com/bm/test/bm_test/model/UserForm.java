package com.bm.test.bm_test.model;

public class UserForm {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;

    public UserForm(String userName, String firstName, String lastName, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }
}
