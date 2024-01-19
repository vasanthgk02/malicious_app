package com.freshchat.consumer.sdk.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.freshchat.consumer.sdk.a.d.e;
import com.freshchat.consumer.sdk.a.d.h;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.bg;

public class p implements OnClickListener {
    public final /* synthetic */ Message os;
    public final /* synthetic */ d ot;
    public final /* synthetic */ View pW;
    public final /* synthetic */ e pX;
    public final /* synthetic */ boolean qA;

    public p(d dVar, e eVar, Message message, boolean z, View view) {
        this.ot = dVar;
        this.pX = eVar;
        this.os = message;
        this.qA = z;
        this.pW = view;
    }

    public void onClick(View view) {
        View ir = this.pX.ir();
        boolean z = ir.getVisibility() == 0;
        if (z) {
            bg.f(this.ot.context, false);
            this.ot.pU.remove(Long.valueOf(this.os.getId()));
            i.c(ir);
        } else {
            bg.f(this.ot.context, true);
            this.ot.pU.add(Long.valueOf(this.os.getId()));
            this.ot.b(this.pX, this.os, this.qA);
            LinearLayout ip = this.pX.ip();
            d dVar = this.ot;
            ip.setOnLongClickListener(new h(this.os, dVar.oq, false));
        }
        this.ot.a(this.pW, !z);
    }
}
