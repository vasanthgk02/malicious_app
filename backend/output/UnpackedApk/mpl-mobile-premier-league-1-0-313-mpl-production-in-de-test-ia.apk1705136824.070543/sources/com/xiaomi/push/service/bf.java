package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings.Global;
import com.xiaomi.push.j;

public class bf {

    /* renamed from: a  reason: collision with root package name */
    public static bf f4905a;

    /* renamed from: a  reason: collision with other field name */
    public int f881a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Context f882a;

    public bf(Context context) {
        this.f882a = context.getApplicationContext();
    }

    public static bf a(Context context) {
        if (f4905a == null) {
            f4905a = new bf(context);
        }
        return f4905a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i = this.f881a;
        if (i != 0) {
            return i;
        }
        try {
            this.f881a = Global.getInt(this.f882a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f881a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m832a() {
        return Global.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m833a() {
        return j.f761a.contains("xmsf") || j.f761a.contains("xiaomi") || j.f761a.contains("miui");
    }
}
