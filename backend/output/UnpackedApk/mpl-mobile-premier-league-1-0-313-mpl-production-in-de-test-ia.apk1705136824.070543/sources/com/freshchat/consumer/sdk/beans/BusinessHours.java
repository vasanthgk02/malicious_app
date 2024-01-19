package com.freshchat.consumer.sdk.beans;

public class BusinessHours {
    public long created;
    public BHWeekDays days;
    public boolean defaultBhr;
    public boolean enabled;
    public String name;
    public long operatingHoursId;
    public String operatingHoursType;
    public String timezone;
    public BHWorkingDays working;

    public long getCreated() {
        return this.created;
    }

    public String getName() {
        return this.name;
    }

    public long getOperatingHoursId() {
        return this.operatingHoursId;
    }

    public String getOperatingHoursType() {
        return this.operatingHoursType;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public BHWeekDays getWeekDaysBH() {
        return this.days;
    }

    public BHWorkingDays getWorkingDays() {
        return this.working;
    }

    public boolean isDefaultBhr() {
        return this.defaultBhr;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setCreated(long j) {
        this.created = j;
    }

    public void setDefaultBhr(boolean z) {
        this.defaultBhr = z;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOperatingHoursId(long j) {
        this.operatingHoursId = j;
    }

    public void setOperatingHoursType(String str) {
        this.operatingHoursType = str;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public void setWeekDaysBH(BHWeekDays bHWeekDays) {
        this.days = bHWeekDays;
    }

    public void setWorkingDays(BHWorkingDays bHWorkingDays) {
        this.working = bHWorkingDays;
    }
}
