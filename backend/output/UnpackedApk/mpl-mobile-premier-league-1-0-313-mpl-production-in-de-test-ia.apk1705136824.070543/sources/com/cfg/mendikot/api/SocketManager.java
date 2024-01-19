package com.cfg.mendikot.api;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.util.concurrent.ConcurrentHashMap;

public class SocketManager extends Service {

    /* renamed from: c  reason: collision with root package name */
    public static final String f2241c = SocketManager.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static volatile SocketManager f2242d;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, b> f2243a;

    /* renamed from: b  reason: collision with root package name */
    public IBinder f2244b;

    public class a extends Binder {

        /* renamed from: a  reason: collision with root package name */
        public SocketManager f2245a;

        public a(SocketManager socketManager) {
            this.f2245a = socketManager;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f2244b;
    }

    public void onCreate() {
        if (!(f2242d != null)) {
            super.onCreate();
            this.f2244b = new a(this);
            this.f2243a = new ConcurrentHashMap<>();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (f2242d != null) {
            return 0;
        }
        super.onStartCommand(intent, i, i2);
        return 2;
    }
}
