package com.charles.supershot.rest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Rounder implements Parcelable {
    private int userSeq;
    private String profileImage;
    private String userName;
    private int handicap;
    private int recentTotalScore;
    private String phoneNumber;

    public Rounder() {
    }

    protected Rounder(Parcel in) {
        userSeq = in.readInt();
        profileImage = in.readString();
        userName = in.readString();
        handicap = in.readInt();
        recentTotalScore = in.readInt();
        phoneNumber = in.readString();
    }

    public static final Creator<Rounder> CREATOR = new Creator<Rounder>() {
        @Override public Rounder createFromParcel(Parcel in) {
            return new Rounder(in);
        }

        @Override
        public Rounder[] newArray(int size) {
            return new Rounder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeInt(userSeq);
        dest.writeString(profileImage);
        dest.writeString(userName);
        dest.writeInt(handicap);
        dest.writeInt(recentTotalScore);
        dest.writeString(phoneNumber);
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandycap(int handicap) {
        this.handicap = handicap;
    }

    public int getRecentTotalScore() {
        return recentTotalScore;
    }

    public void setRecentTotalScore(int recentTotalScore) {
        this.recentTotalScore = recentTotalScore;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
