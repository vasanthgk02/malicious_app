package com.flurry.sdk;

import android.util.Log;
import com.flurry.sdk.mi.AnonymousClass1;

public abstract class nz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1704a = nz.class.getSimpleName();

    public final void run() {
        try {
            AnonymousClass1 r0 = (AnonymousClass1) this;
            r0.f1702a.a(r0.f1703b);
        } catch (Throwable th) {
            th.printStackTrace();
            Log.getStackTraceString(th);
        }
    }
}
