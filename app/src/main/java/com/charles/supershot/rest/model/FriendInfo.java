package com.charles.supershot.rest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FriendInfo {
    private int userSeq;
    private String type;
    private String friendId;
    private String name;
    private int friendUserSeq;
    private int handicap;
    private int recentTotalScore;
    private String created;
    private String updated;
    private User user;

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFriendUserSeq() {
        return friendUserSeq;
    }

    public void setFriendUserSeq(int friendUserSeq) {
        this.friendUserSeq = friendUserSeq;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public int getRecentTotalScore() {
        return recentTotalScore;
    }

    public void setRecentTotalScore(int recentTotalScore) {
        this.recentTotalScore = recentTotalScore;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
