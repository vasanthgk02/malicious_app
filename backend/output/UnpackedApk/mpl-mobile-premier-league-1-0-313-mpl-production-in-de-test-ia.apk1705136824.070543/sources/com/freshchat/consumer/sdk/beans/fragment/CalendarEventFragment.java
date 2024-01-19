package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Set;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class CalendarEventFragment extends MessageFragment {
    public long endMillis;
    public String eventId;
    public int eventProviderType;
    public Set<Long> participantIds;
    public long startMillis;
    public String userTimeZone;

    public CalendarEventFragment() {
        super(FragmentType.CALENDAR_EVENT.asInt());
    }

    public long getEndMillis() {
        return this.endMillis;
    }

    public String getEventId() {
        return this.eventId;
    }

    public int getEventProviderType() {
        return this.eventProviderType;
    }

    public Set<Long> getParticipantIds() {
        return this.participantIds;
    }

    public long getStartMillis() {
        return this.startMillis;
    }

    public String getUserTimeZone() {
        return this.userTimeZone;
    }

    public void setEndMillis(long j) {
        this.endMillis = j;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventProviderType(int i) {
        this.eventProviderType = i;
    }

    public void setParticipantIds(Set<Long> set) {
        this.participantIds = set;
    }

    public void setStartMillis(long j) {
        this.startMillis = j;
    }

    public void setUserTimeZone(String str) {
        this.userTimeZone = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CalendarEventFragment{eventId='");
        GeneratedOutlineSupport.outline99(outline73, this.eventId, ExtendedMessageFormat.QUOTE, ", eventProviderType=");
        outline73.append(this.eventProviderType);
        outline73.append(", startMillis=");
        outline73.append(this.startMillis);
        outline73.append(", endMillis=");
        outline73.append(this.endMillis);
        outline73.append(", userTimeZone='");
        GeneratedOutlineSupport.outline99(outline73, this.userTimeZone, ExtendedMessageFormat.QUOTE, ", participantIds=");
        outline73.append(this.participantIds);
        outline73.append('}');
        return outline73.toString();
    }
}
