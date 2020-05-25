package com.charles.supershot.rest.model;

public class UserData {
    private int statusCode;
    private String message;
    private UserToken data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserToken getData() {
        return data;
    }

    public void setData(UserToken data) {
        this.data = data;
    }
}
