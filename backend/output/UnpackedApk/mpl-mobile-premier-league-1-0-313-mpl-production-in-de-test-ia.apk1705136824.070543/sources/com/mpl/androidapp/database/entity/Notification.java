package com.mpl.androidapp.database.entity;

public class Notification {
    public String body;
    public String category;
    public long index;
    public boolean isSoftDeleted;
    public String notificationData;
    public boolean read;
    public String recievedTime;
    public String subCategory;
    public String title;

    public String getBody() {
        return this.body;
    }

    public String getCategory() {
        return this.category;
    }

    public long getIndex() {
        return this.index;
    }

    public boolean getIsSoftDeleted() {
        return this.isSoftDeleted;
    }

    public String getNotificationData() {
        return this.notificationData;
    }

    public String getRecievedTime() {
        return this.recievedTime;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isRead() {
        return this.read;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setIndex(long j) {
        this.index = j;
    }

    public void setIsSoftDeleted(boolean z) {
        this.isSoftDeleted = z;
    }

    public void setNotificationData(String str) {
        this.notificationData = str;
    }

    public void setRead(boolean z) {
        this.read = z;
    }

    public void setRecievedTime(String str) {
        this.recievedTime = str;
    }

    public void setSubCategory(String str) {
        this.subCategory = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
