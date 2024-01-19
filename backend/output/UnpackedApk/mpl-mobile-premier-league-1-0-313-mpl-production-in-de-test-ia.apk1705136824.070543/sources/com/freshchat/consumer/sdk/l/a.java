package com.freshchat.consumer.sdk.l;

import android.app.Application;
import android.content.Context;
import com.freshchat.consumer.sdk.f.c;

public class a extends b {
    public static volatile a mV;

    public static synchronized a gR() {
        a aVar;
        Class<a> cls = a.class;
        synchronized (cls) {
            if (mV == null) {
                synchronized (cls) {
                    if (mV == null) {
                        mV = new a();
                    }
                }
            }
            aVar = mV;
        }
        return aVar;
    }

    public boolean bW(Context context) {
        return c.a((Application) context.getApplicationContext()).cE();
    }

    public void bX(Context context) {
        c.a((Application) context.getApplicationContext()).m(true);
    }
}
