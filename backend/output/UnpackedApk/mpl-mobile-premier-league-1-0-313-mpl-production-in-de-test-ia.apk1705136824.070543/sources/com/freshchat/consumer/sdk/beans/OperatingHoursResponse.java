package com.freshchat.consumer.sdk.beans;

import java.util.List;

public class OperatingHoursResponse {
    public List<BusinessHours> operatingHours;

    public List<BusinessHours> getOperatingHours() {
        return this.operatingHours;
    }
}
