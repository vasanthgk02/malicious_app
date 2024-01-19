package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.q;

public class l extends p {
    public CalendarEventFragment qd;
    public boolean qe;

    public enum a {
        PENDING,
        CREATED,
        FAILED;
        
        public static final a qi = null;

        /* access modifiers changed from: public */
        static {
            a aVar;
            qi = aVar;
        }
    }

    public l(Context context) {
        super(context);
    }

    public void b(CalendarEventFragment calendarEventFragment) {
        this.qd = calendarEventFragment;
        b(new TimeSlot(calendarEventFragment.getStartMillis(), calendarEventFragment.getEndMillis()));
    }

    public a hZ() {
        CalendarEventFragment calendarEventFragment = this.qd;
        return calendarEventFragment == null ? a.qi : !this.qe ? a.PENDING : cm.a(calendarEventFragment) ? a.CREATED : a.FAILED;
    }

    public String ia() {
        try {
            if (this.qq == null) {
                return "";
            }
            return getContext().getString(R.string.freshchat_calendar_duration).replace(getContext().getString(R.string.freshchat_calendar_duration_place_holder), String.valueOf((this.qq.getToMillis() - this.qq.getFromMillis()) / 60000));
        } catch (Exception e2) {
            q.a(e2);
            return "";
        }
    }

    public void y(boolean z) {
        this.qe = z;
    }
}
