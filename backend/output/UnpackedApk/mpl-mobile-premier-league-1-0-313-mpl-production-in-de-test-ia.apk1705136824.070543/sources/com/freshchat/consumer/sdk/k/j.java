package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.a.l.b;
import java.util.ArrayList;
import java.util.List;

public class j extends a {
    public int calendarType;
    public List<b> qa;

    public j(Context context) {
        super(context);
    }

    public void H(List<b> list) {
        this.qa = list;
    }

    public int getCalendarType() {
        return this.calendarType;
    }

    public List<b> hY() {
        List<b> list = this.qa;
        return list == null ? new ArrayList() : list;
    }

    public void setCalendarType(int i) {
        this.calendarType = i;
    }
}
