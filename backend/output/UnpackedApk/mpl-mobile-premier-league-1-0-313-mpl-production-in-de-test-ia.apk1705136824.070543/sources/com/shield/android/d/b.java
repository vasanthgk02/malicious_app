package com.shield.android.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final f f1555a;

    public b(f fVar) {
        this.f1555a = fVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.location.PROVIDERS_CHANGED".equals(intent.getAction())) {
            this.f1555a.a();
        }
    }
}
