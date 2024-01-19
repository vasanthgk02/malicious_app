package com.freshchat.consumer.sdk.m;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.j.ci;
import com.freshchat.consumer.sdk.k.p;

public class t extends a {
    public NestedScrollView jH;
    public p pn;

    private void g(View view) {
        new ci().a(view, this.pn, R.dimen.freshchat_calendar_confirmation_avatar_size);
        this.jH = (NestedScrollView) view.findViewById(R.id.freshchat_calendar_timeslot_confirmation_scrollbar);
        View findViewById = view.findViewById(R.id.freshchat_calendar_confirm_button);
        View findViewById2 = view.findViewById(R.id.freshchat_calendar_change_slot_button);
        findViewById.setOnClickListener(new v(this));
        findViewById2.setOnClickListener(new w(this));
        hR();
    }

    private int hJ() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("EXTRA_CALENDAR_TYPE")) {
            return 0;
        }
        return arguments.getInt("EXTRA_CALENDAR_TYPE");
    }

    private TimeSlot hQ() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("EXTRA_CALENDAR_SELECTED_TIMESLOT")) {
            return null;
        }
        return (TimeSlot) arguments.getParcelable("EXTRA_CALENDAR_SELECTED_TIMESLOT");
    }

    private void hR() {
        this.jH.post(new x(this));
    }

    public void cc(Context context) {
        this.pn = new p(context);
        CalendarMessageMeta calendarMessageMeta = getCalendarMessageMeta();
        TimeSlot hQ = hQ();
        String hC = hC();
        int hJ = hJ();
        this.pn.setCalendarMessageMeta(calendarMessageMeta);
        this.pn.b(hQ);
        this.pn.br(hC);
        this.pn.setCalendarType(hJ);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hR();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.freshchat_calendar_timeslot_confirmation, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g(view);
        view.post(new u(this));
    }
}
