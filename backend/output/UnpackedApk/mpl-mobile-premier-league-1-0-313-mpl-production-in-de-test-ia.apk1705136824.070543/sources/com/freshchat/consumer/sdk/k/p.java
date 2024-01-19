package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.j.n;

public class p extends a {
    public CalendarMessageMeta calendarMessageMeta;
    public int calendarType;
    public String oY;
    public TimeSlot qq;

    public p(Context context) {
        super(context);
    }

    public void b(TimeSlot timeSlot) {
        this.qq = timeSlot;
    }

    public void br(String str) {
        this.oY = str;
    }

    public int getCalendarType() {
        return this.calendarType;
    }

    public String hL() {
        return this.oY;
    }

    public TimeSlot ih() {
        return this.qq;
    }

    public String ii() {
        return this.qq == null ? "" : GeneratedOutlineSupport.outline52(n.p(getContext(), this.qq.getFromMillis()), " - ", n.p(getContext(), this.qq.getToMillis()));
    }

    public String ij() {
        return this.qq == null ? "" : n.q(getContext(), this.qq.getFromMillis());
    }

    public boolean ik() {
        return e.i(getContext()).isTeamMemberInfoVisible();
    }

    public void setCalendarMessageMeta(CalendarMessageMeta calendarMessageMeta2) {
        this.calendarMessageMeta = calendarMessageMeta2;
    }

    public void setCalendarType(int i) {
        this.calendarType = i;
    }
}
