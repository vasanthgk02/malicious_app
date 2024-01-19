package com.freshchat.consumer.sdk.m;

import android.view.View;
import android.view.View.OnClickListener;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.m.a.C0029a;

public class m implements OnClickListener {
    public final /* synthetic */ j pf;

    public m(j jVar) {
        this.pf = jVar;
    }

    public void onClick(View view) {
        if (as.a(this.pf.dS.getText())) {
            this.pf.pc.bq(this.pf.dS.getText().toString());
            this.pf.a(C0029a.CALENDAR_LIMITED_TIMESLOTS_VIEW_FRAGMENT);
        }
    }
}
