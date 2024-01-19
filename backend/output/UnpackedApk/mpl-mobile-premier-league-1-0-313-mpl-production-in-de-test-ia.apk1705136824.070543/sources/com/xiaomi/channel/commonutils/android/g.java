package com.xiaomi.channel.commonutils.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Handler f4313a;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f176a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f4314b;

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return a(context, broadcastReceiver, intentFilter, null, i);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i) {
        return a(context, broadcastReceiver, intentFilter, str, b(), i);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        return VERSION.SDK_INT >= 33 ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i) : context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    public static Handler a() {
        if (f4314b == null) {
            synchronized (f176a) {
                if (f4314b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    f4314b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f4314b;
    }

    public static Handler b() {
        if (f4313a == null) {
            synchronized (g.class) {
                if (f4313a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    f4313a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f4313a;
    }
}
