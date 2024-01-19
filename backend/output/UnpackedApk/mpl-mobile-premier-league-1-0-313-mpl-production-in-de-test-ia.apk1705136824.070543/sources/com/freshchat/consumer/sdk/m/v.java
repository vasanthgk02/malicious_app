package com.freshchat.consumer.sdk.m;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;

public class v implements OnClickListener {
    public final /* synthetic */ t pp;

    public v(t tVar) {
        this.pp = tVar;
    }

    public void onClick(View view) {
        f hB = this.pp.hB();
        if (hB != null) {
            TimeSlot ih = this.pp.pn.ih();
            int calendarType = this.pp.pn.getCalendarType();
            if (ih != null) {
                hB.a(ih, calendarType);
            }
        }
    }
}
