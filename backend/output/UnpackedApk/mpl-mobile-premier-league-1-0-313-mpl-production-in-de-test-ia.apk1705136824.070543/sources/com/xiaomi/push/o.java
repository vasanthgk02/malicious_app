package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public static volatile o f4797a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f764a;

    /* renamed from: a  reason: collision with other field name */
    public Object f765a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public Map<String, ScheduledFuture> f766a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public ScheduledThreadPoolExecutor f767a = new ScheduledThreadPoolExecutor(1);

    public static abstract class a implements Runnable {
        public abstract String a();
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public a f4798a;

        public b(a aVar) {
            this.f4798a = aVar;
        }

        public void a() {
        }

        public void b() {
        }

        public void run() {
            a();
            this.f4798a.run();
            b();
        }
    }

    public o(Context context) {
        this.f764a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static o a(Context context) {
        if (f4797a == null) {
            synchronized (o.class) {
                try {
                    if (f4797a == null) {
                        f4797a = new o(context);
                    }
                }
            }
        }
        return f4797a;
    }

    public static String a(String str) {
        return GeneratedOutlineSupport.outline50("last_job_time", str);
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f765a) {
            scheduledFuture = this.f766a.get(aVar.a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f767a.schedule(runnable, (long) i, TimeUnit.SECONDS);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.a());
        p pVar = new p(this, aVar, z, a2);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f764a.getLong(a2, 0)) / 1000;
            if (abs < ((long) (i - i2))) {
                i2 = (int) (((long) i) - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f767a.scheduleAtFixedRate(pVar, (long) i2, (long) i, TimeUnit.SECONDS);
            synchronized (this.f765a) {
                this.f766a.put(aVar.a(), scheduleAtFixedRate);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m750a(String str) {
        synchronized (this.f765a) {
            ScheduledFuture scheduledFuture = this.f766a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f766a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f767a.schedule(new q(this, aVar), (long) i, TimeUnit.SECONDS);
        synchronized (this.f765a) {
            this.f766a.put(aVar.a(), schedule);
        }
        return true;
    }
}
