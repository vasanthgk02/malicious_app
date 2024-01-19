package com.freshchat.consumer.sdk.a;

import android.view.View;
import android.view.View.OnClickListener;

public class u implements OnClickListener {
    public final /* synthetic */ int ck;
    public final /* synthetic */ s qT;

    public u(s sVar, int i) {
        this.qT = sVar;
        this.ck = i;
    }

    public void onClick(View view) {
        this.qT.qR.d(view, this.ck);
    }
}
