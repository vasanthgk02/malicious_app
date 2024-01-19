package com.shield.android.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final f f1554a;

    public a(f fVar) {
        this.f1554a = fVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.location.MODE_CHANGED".equals(intent.getAction())) {
            this.f1554a.a();
        }
    }
}
