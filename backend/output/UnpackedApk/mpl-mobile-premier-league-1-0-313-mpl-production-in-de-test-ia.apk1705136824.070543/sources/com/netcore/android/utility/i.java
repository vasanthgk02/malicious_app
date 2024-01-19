package com.netcore.android.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netcore.android.f.c;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTNetowrkStateReceiver.kt */
public final class i extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final c f1313a;

    public i(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "listener");
        this.f1313a = cVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.f1313a.b();
    }
}
