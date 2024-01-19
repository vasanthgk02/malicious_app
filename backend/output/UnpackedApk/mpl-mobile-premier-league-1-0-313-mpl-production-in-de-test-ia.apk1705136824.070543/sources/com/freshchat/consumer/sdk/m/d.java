package com.freshchat.consumer.sdk.m;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.l.b;
import com.freshchat.consumer.sdk.k.j;
import java.util.List;

public class d extends b {
    public j oW;

    private void hH() {
        G(this.oW.hY());
    }

    private List<b> hI() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("EXTRA_CALENDAR_ALL_TIMESLOTS")) {
            return null;
        }
        return arguments.getParcelableArrayList("EXTRA_CALENDAR_ALL_TIMESLOTS");
    }

    private int hJ() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("EXTRA_CALENDAR_TYPE")) {
            return 0;
        }
        return arguments.getInt("EXTRA_CALENDAR_TYPE");
    }

    public void cc(Context context) {
        j jVar = new j(context);
        this.oW = jVar;
        jVar.H(hI());
        this.oW.setCalendarType(hJ());
    }

    public int getCalendarType() {
        return this.oW.getCalendarType();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.freshchat_fragment_calendar_all_timeslots, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        hH();
        view.post(new e(this));
    }
}
