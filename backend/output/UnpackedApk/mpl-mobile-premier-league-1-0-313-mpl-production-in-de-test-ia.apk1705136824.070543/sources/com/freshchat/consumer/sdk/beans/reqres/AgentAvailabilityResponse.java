package com.freshchat.consumer.sdk.beans.reqres;

import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.beans.CalendarTimeSlot;
import com.freshchat.consumer.sdk.service.e.k;
import java.util.List;
import java.util.Map;

public class AgentAvailabilityResponse implements k {
    public int bufferTime;
    public List<CalendarTimeSlot> calendarTimeSlots;
    public int calendarType;
    public String id;
    public int meetingLength;
    public int minNoticeTime;
    public Map<String, CalendarDay> processedCalendarDataMap;
    public boolean success;

    public int getBufferTime() {
        return this.bufferTime;
    }

    public List<CalendarTimeSlot> getCalendarTimeSlots() {
        return this.calendarTimeSlots;
    }

    public int getCalendarType() {
        return this.calendarType;
    }

    public String getId() {
        return this.id;
    }

    public int getMeetingLength() {
        return this.meetingLength;
    }

    public int getMinNoticeTime() {
        return this.minNoticeTime;
    }

    public Map<String, CalendarDay> getProcessedCalendarDataMap() {
        return this.processedCalendarDataMap;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setBufferTime(int i) {
        this.bufferTime = i;
    }

    public void setCalendarTimeSlots(List<CalendarTimeSlot> list) {
        this.calendarTimeSlots = list;
    }

    public void setCalendarType(int i) {
        this.calendarType = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMeetingLength(int i) {
        this.meetingLength = i;
    }

    public void setMinNoticeTime(int i) {
        this.minNoticeTime = i;
    }

    public void setProcessedCalendarDataMap(Map<String, CalendarDay> map) {
        this.processedCalendarDataMap = map;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
