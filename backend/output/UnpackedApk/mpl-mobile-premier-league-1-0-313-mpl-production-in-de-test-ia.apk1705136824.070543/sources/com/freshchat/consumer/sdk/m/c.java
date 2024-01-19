package com.freshchat.consumer.sdk.m;

import android.os.Bundle;
import com.freshchat.consumer.sdk.a.i.a;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.m.a.C0029a;

public class c implements a {
    public final /* synthetic */ b oV;

    public c(b bVar) {
        this.oV = bVar;
    }

    public void a(TimeSlot timeSlot) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("EXTRA_CALENDAR_SELECTED_TIMESLOT", timeSlot);
        bundle.putInt("EXTRA_CALENDAR_TYPE", this.oV.getCalendarType());
        this.oV.a(C0029a.CALENDAR_TIMESLOT_CONFIRMATION_FRAGMENT, bundle);
    }
}
