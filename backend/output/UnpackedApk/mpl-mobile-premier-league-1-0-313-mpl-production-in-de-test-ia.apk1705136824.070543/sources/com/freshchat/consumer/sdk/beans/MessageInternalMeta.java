package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;

public class MessageInternalMeta {
    public CalendarMessageMeta calendarMessageMeta;

    public CalendarMessageMeta getCalendarMessageMeta() {
        return this.calendarMessageMeta;
    }

    public void setCalendarMessageMeta(CalendarMessageMeta calendarMessageMeta2) {
        this.calendarMessageMeta = calendarMessageMeta2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MessageInternalMeta{calendarMessageMeta = ");
        outline73.append(this.calendarMessageMeta);
        outline73.append('}');
        return outline73.toString();
    }
}
