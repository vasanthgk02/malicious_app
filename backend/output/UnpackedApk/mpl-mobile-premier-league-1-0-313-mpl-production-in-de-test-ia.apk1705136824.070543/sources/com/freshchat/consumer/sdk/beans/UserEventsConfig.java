package com.freshchat.consumer.sdk.beans;

public class UserEventsConfig {
    public long maxAllowedEventsPerDay;
    public long maxAllowedPropertiesPerEvent;
    public int maxCharsPerEventName;
    public int maxCharsPerEventPropertyName;
    public int maxCharsPerEventPropertyValue;
    public long maxDelayInMillisUntilUpload;
    public long maxEventsPerBatch;
    public long triggerUploadOnEventsCount;

    public long getMaxAllowedEventsPerDay() {
        return this.maxAllowedEventsPerDay;
    }

    public long getMaxAllowedPropertiesPerEvent() {
        return this.maxAllowedPropertiesPerEvent;
    }

    public int getMaxCharsPerEventName() {
        return this.maxCharsPerEventName;
    }

    public int getMaxCharsPerEventPropertyName() {
        return this.maxCharsPerEventPropertyName;
    }

    public int getMaxCharsPerEventPropertyValue() {
        return this.maxCharsPerEventPropertyValue;
    }

    public long getMaxDelayInMillisUntilUpload() {
        return this.maxDelayInMillisUntilUpload;
    }

    public long getMaxEventsPerBatch() {
        return this.maxEventsPerBatch;
    }

    public long getTriggerUploadOnEventsCount() {
        return this.triggerUploadOnEventsCount;
    }

    public void setMaxAllowedEventsPerDay(long j) {
        this.maxAllowedEventsPerDay = j;
    }

    public void setMaxAllowedPropertiesPerEvent(long j) {
        this.maxAllowedPropertiesPerEvent = j;
    }

    public void setMaxCharsPerEventName(int i) {
        this.maxCharsPerEventName = i;
    }

    public void setMaxCharsPerEventPropertyName(int i) {
        this.maxCharsPerEventPropertyName = i;
    }

    public void setMaxCharsPerEventPropertyValue(int i) {
        this.maxCharsPerEventPropertyValue = i;
    }

    public void setMaxDelayInMillisUntilUpload(long j) {
        this.maxDelayInMillisUntilUpload = j;
    }

    public void setMaxEventsPerBatch(long j) {
        this.maxEventsPerBatch = j;
    }

    public void setTriggerUploadOnEventsCount(long j) {
        this.triggerUploadOnEventsCount = j;
    }
}
