package com.mpl.androidapp.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class MPLCalendar {
    public String mCalenderId;
    public String mCalenderName;

    public MPLCalendar(String str, String str2) {
        this.mCalenderName = str;
        this.mCalenderId = str2;
    }

    public String getCalenderId() {
        return this.mCalenderId;
    }

    public String getCalenderName() {
        return this.mCalenderName;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MyCalendar{mCalenderName='");
        GeneratedOutlineSupport.outline99(outline73, this.mCalenderName, ExtendedMessageFormat.QUOTE, ", mCalenderId='");
        return GeneratedOutlineSupport.outline60(outline73, this.mCalenderId, ExtendedMessageFormat.QUOTE, '}');
    }
}
