package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static s f4977a;

    /* renamed from: a  reason: collision with other field name */
    public Context f939a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f940a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f4978b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f4979c = new ArrayList();

    public s(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f939a = applicationContext;
        if (applicationContext == null) {
            this.f939a = context;
        }
        SharedPreferences sharedPreferences = this.f939a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f940a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f4978b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.f4979c.add(str3);
            }
        }
    }

    public static s a(Context context) {
        if (f4977a == null) {
            f4977a = new s(context);
        }
        return f4977a;
    }

    public void a(String str) {
        synchronized (this.f940a) {
            try {
                if (!this.f940a.contains(str)) {
                    this.f940a.add(str);
                    this.f939a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", ad.a((Collection<?>) this.f940a, (String) ",")).commit();
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m871a(String str) {
        boolean contains;
        synchronized (this.f940a) {
            contains = this.f940a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.f4978b) {
            try {
                if (!this.f4978b.contains(str)) {
                    this.f4978b.add(str);
                    this.f939a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", ad.a((Collection<?>) this.f4978b, (String) ",")).commit();
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m872b(String str) {
        boolean contains;
        synchronized (this.f4978b) {
            contains = this.f4978b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.f4979c) {
            try {
                if (!this.f4979c.contains(str)) {
                    this.f4979c.add(str);
                    this.f939a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", ad.a((Collection<?>) this.f4979c, (String) ",")).commit();
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m873c(String str) {
        boolean contains;
        synchronized (this.f4979c) {
            contains = this.f4979c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f940a) {
            if (this.f940a.contains(str)) {
                this.f940a.remove(str);
                this.f939a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", ad.a((Collection<?>) this.f940a, (String) ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f4978b) {
            if (this.f4978b.contains(str)) {
                this.f4978b.remove(str);
                this.f939a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", ad.a((Collection<?>) this.f4978b, (String) ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f4979c) {
            if (this.f4979c.contains(str)) {
                this.f4979c.remove(str);
                this.f939a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", ad.a((Collection<?>) this.f4979c, (String) ",")).commit();
            }
        }
    }
}
