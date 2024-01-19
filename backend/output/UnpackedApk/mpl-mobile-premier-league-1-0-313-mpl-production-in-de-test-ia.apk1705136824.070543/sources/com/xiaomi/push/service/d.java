package com.xiaomi.push.service;

import android.app.Notification.Action;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.xiaomi.channel.commonutils.android.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static List<a> f4944a = new CopyOnWriteArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4945a;

        /* renamed from: a  reason: collision with other field name */
        public final long f911a;

        /* renamed from: a  reason: collision with other field name */
        public final String f912a;

        /* renamed from: a  reason: collision with other field name */
        public final Action[] f913a;

        public a(String str, long j, int i, Action[] actionArr) {
            this.f912a = str;
            this.f911a = j;
            this.f4945a = i;
            this.f913a = actionArr;
        }
    }

    public static void a() {
        for (int size = f4944a.size() - 1; size >= 0; size--) {
            a aVar = f4944a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f911a > RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS) {
                f4944a.remove(aVar);
            }
        }
        if (f4944a.size() > 10) {
            f4944a.remove(0);
        }
    }

    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (f.a(context) && i > 0 && statusBarNotification != null) {
            a aVar = new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ar.a(statusBarNotification.getNotification()));
            a(aVar);
        }
    }

    public static void a(a aVar) {
        f4944a.add(aVar);
        a();
    }
}
