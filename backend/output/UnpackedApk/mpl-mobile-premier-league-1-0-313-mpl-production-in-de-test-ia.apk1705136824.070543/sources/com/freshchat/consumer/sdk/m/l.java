package com.freshchat.consumer.sdk.m;

import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cp;

public class l extends cp {
    public final /* synthetic */ j pf;

    public l(j jVar) {
        this.pf = jVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.pf.dT.setEnabled(as.a(charSequence) ? this.pf.pc.aK(charSequence.toString()) : false);
    }
}
