package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc.a;
import com.xiaomi.push.service.n;

public class bd implements a {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f4483a = 0;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f345a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f346a = null;

    public bd(Context context) {
        this.f346a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        Class<AlarmManager> cls = AlarmManager.class;
        try {
            cls.getMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class}).invoke(alarmManager, new Object[]{Integer.valueOf(2), Long.valueOf(j), pendingIntent});
        } catch (Exception e2) {
            b.d("[Alarm] invoke setExact method meet error. " + e2);
        }
    }

    public void a() {
        if (this.f345a != null) {
            try {
                ((AlarmManager) this.f346a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f345a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f345a = null;
                b.c("[Alarm] unregister timer");
                this.f4483a = 0;
                throw th;
            }
            this.f345a = null;
            b.c("[Alarm] unregister timer");
            this.f4483a = 0;
        }
        this.f4483a = 0;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f346a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f345a = VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this.f346a, 0, intent, 33554432) : PendingIntent.getBroadcast(this.f346a, 0, intent, 0);
        if (VERSION.SDK_INT >= 31 && !f.a(this.f346a)) {
            alarmManager.set(2, j, this.f345a);
        } else if (VERSION.SDK_INT >= 23) {
            z.a((Object) alarmManager, (String) "setExactAndAllowWhileIdle", Integer.valueOf(2), Long.valueOf(j), this.f345a);
        } else {
            a(alarmManager, j, this.f345a);
        }
        b.c("[Alarm] register timer " + j);
    }

    public void a(boolean z) {
        long a2 = n.a(this.f346a).a();
        if (z || this.f4483a != 0) {
            if (z) {
                a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.f4483a == 0) {
                this.f4483a = (a2 - (elapsedRealtime % a2)) + elapsedRealtime;
            } else if (this.f4483a <= elapsedRealtime) {
                this.f4483a += a2;
                if (this.f4483a < elapsedRealtime) {
                    this.f4483a = elapsedRealtime + a2;
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.bd.q);
            intent.setPackage(this.f346a.getPackageName());
            a(intent, this.f4483a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m515a() {
        return this.f4483a != 0;
    }
}
