package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.BaseJavaModule;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.push.m;
import com.xiaomi.push.o;
import com.xiaomi.push.y;
import java.util.concurrent.ConcurrentHashMap;

public final class bp implements ak {

    /* renamed from: a  reason: collision with root package name */
    public static volatile bp f4921a;

    /* renamed from: a  reason: collision with other field name */
    public long f893a;

    /* renamed from: a  reason: collision with other field name */
    public Context f894a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f895a;

    /* renamed from: a  reason: collision with other field name */
    public ConcurrentHashMap<String, a> f896a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f897a = false;

    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public long f4922a;

        /* renamed from: a  reason: collision with other field name */
        public String f898a;

        public a(String str, long j) {
            this.f898a = str;
            this.f4922a = j;
        }

        public abstract void a(bp bpVar);

        public void run() {
            if (bp.a() != null) {
                Context context = bp.a().f894a;
                if (y.c(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences a2 = bp.a(bp.a());
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73(":ts-");
                    outline73.append(this.f898a);
                    if (currentTimeMillis - a2.getLong(outline73.toString(), 0) > this.f4922a || m.a(context)) {
                        Editor edit = bp.a(bp.a()).edit();
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73(":ts-");
                        outline732.append(this.f898a);
                        h.a(edit.putLong(outline732.toString(), System.currentTimeMillis()));
                        a(bp.a());
                    }
                }
            }
        }
    }

    public bp(Context context) {
        this.f894a = context.getApplicationContext();
        this.f895a = context.getSharedPreferences(BaseJavaModule.METHOD_TYPE_SYNC, 0);
    }

    public static bp a(Context context) {
        if (f4921a == null) {
            synchronized (bp.class) {
                try {
                    if (f4921a == null) {
                        f4921a = new bp(context);
                    }
                }
            }
        }
        return f4921a;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f895a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    public void a() {
        if (!this.f897a) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f893a >= 3600000) {
                this.f893a = currentTimeMillis;
                this.f897a = true;
                o.a(this.f894a).a((Runnable) new bq(this), (int) (Math.random() * 10.0d));
            }
        }
    }

    public void a(a aVar) {
        if (this.f896a.putIfAbsent(aVar.f898a, aVar) == null) {
            o.a(this.f894a).a((Runnable) aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        Editor edit = f4921a.f895a.edit();
        h.a(edit.putString(str + ":" + str2, str3));
    }
}
