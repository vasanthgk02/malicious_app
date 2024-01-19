package com.mpl.androidapp.database.entity;

public class EventsAll {
    public long index;
    public String key;
    public String time;
    public String value;

    public long getIndex() {
        return this.index;
    }

    public String getKey() {
        return this.key;
    }

    public String getTime() {
        return this.time;
    }

    public String getValue() {
        return this.value;
    }

    public void setIndex(long j) {
        this.index = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
