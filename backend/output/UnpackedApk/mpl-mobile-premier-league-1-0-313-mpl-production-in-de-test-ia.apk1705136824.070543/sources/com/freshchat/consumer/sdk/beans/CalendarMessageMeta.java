package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class CalendarMessageMeta implements Parcelable {
    public static final Creator<CalendarMessageMeta> CREATOR = new Creator<CalendarMessageMeta>() {
        public CalendarMessageMeta createFromParcel(Parcel parcel) {
            return new CalendarMessageMeta(parcel);
        }

        public CalendarMessageMeta[] newArray(int i) {
            return new CalendarMessageMeta[i];
        }
    };
    public String calendarAgentAlias;
    public long calendarAgentId;
    public String calendarBookingEmail;
    public String calendarEventLink;
    public String calendarInviteId;
    public long calendarSenderId;
    public boolean retryCalendarEvent;

    public CalendarMessageMeta() {
    }

    public CalendarMessageMeta(Parcel parcel) {
        this.calendarSenderId = parcel.readLong();
        this.calendarAgentId = parcel.readLong();
        this.calendarAgentAlias = parcel.readString();
        this.calendarInviteId = parcel.readString();
        this.retryCalendarEvent = parcel.readByte() != 0;
        this.calendarBookingEmail = parcel.readString();
        this.calendarEventLink = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCalendarAgentAlias() {
        return this.calendarAgentAlias;
    }

    public long getCalendarAgentId() {
        return this.calendarAgentId;
    }

    public String getCalendarBookingEmail() {
        return this.calendarBookingEmail;
    }

    public String getCalendarEventLink() {
        return this.calendarEventLink;
    }

    public String getCalendarInviteId() {
        return this.calendarInviteId;
    }

    public long getCalendarSenderId() {
        return this.calendarSenderId;
    }

    public boolean isRetryCalendarEvent() {
        return this.retryCalendarEvent;
    }

    public void setCalendarAgentAlias(String str) {
        this.calendarAgentAlias = str;
    }

    public void setCalendarAgentId(long j) {
        this.calendarAgentId = j;
    }

    public void setCalendarBookingEmail(String str) {
        this.calendarBookingEmail = str;
    }

    public void setCalendarEventLink(String str) {
        this.calendarEventLink = str;
    }

    public void setCalendarInviteId(String str) {
        this.calendarInviteId = str;
    }

    public void setCalendarSenderId(long j) {
        this.calendarSenderId = j;
    }

    public void setRetryCalendarEvent(boolean z) {
        this.retryCalendarEvent = z;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("CalendarMessageMeta{", "calendarSenderId=");
        outline77.append(this.calendarSenderId);
        outline77.append("calendarAgentId = ");
        outline77.append(this.calendarSenderId);
        outline77.append(", calendarAgentAlias='");
        GeneratedOutlineSupport.outline99(outline77, this.calendarAgentAlias, ExtendedMessageFormat.QUOTE, ", calendarInviteId='");
        GeneratedOutlineSupport.outline99(outline77, this.calendarInviteId, ExtendedMessageFormat.QUOTE, ", retryCalendarEvent=");
        outline77.append(this.retryCalendarEvent);
        outline77.append(", calendarBookingEmail=");
        outline77.append(this.calendarBookingEmail);
        outline77.append(", calendarEventLink=");
        return GeneratedOutlineSupport.outline59(outline77, this.calendarEventLink, '}');
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.calendarSenderId);
        parcel.writeLong(this.calendarAgentId);
        parcel.writeString(this.calendarAgentAlias);
        parcel.writeString(this.calendarInviteId);
        parcel.writeByte(this.retryCalendarEvent ? (byte) 1 : 0);
        parcel.writeString(this.calendarBookingEmail);
        parcel.writeString(this.calendarEventLink);
    }
}
