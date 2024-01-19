package com.freshchat.consumer.sdk.m;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.a.l.b;
import com.freshchat.consumer.sdk.m.a.C0029a;
import java.util.ArrayList;

public class o implements OnClickListener {
    public final /* synthetic */ n pl;

    public o(n nVar) {
        this.pl = nVar;
    }

    public void onClick(View view) {
        ArrayList<b> jp = this.pl.qZ.jp();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("EXTRA_CALENDAR_ALL_TIMESLOTS", jp);
        bundle.putInt("EXTRA_CALENDAR_TYPE", this.pl.getCalendarType());
        this.pl.a(C0029a.CALENDAR_ALL_TIMESLOTS_VIEW_FRAGMENT, bundle);
    }
}
