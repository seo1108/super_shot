package com.charles.supershot.rest.model;

public class AddFriend {
    private int statusCode;
    private String message;
    private FriendData data;
    private boolean success;

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

    public FriendData getData() {
        return data;
    }

    public void setData(FriendData data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
