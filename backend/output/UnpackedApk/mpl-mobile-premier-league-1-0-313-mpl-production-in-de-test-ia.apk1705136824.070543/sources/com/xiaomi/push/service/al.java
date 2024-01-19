package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.ay;
import com.xiaomi.push.dq;
import java.util.Map;

public abstract class al {
    public abstract ay a(Context context, int i, String str, Map<String, String> map);

    public abstract void a(dq dqVar, Map<String, String> map, int i, Notification notification);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m802a(Context context, int i, String str, Map<String, String> map);

    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
