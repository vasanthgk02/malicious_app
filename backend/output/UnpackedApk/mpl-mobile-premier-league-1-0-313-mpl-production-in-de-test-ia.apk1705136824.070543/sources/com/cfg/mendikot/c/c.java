package com.cfg.mendikot.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.cfg.mendikot.app.CFGMendikot;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f2360a = "MainPrefsMendikot";

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f2361b;

    /* renamed from: c  reason: collision with root package name */
    public final Editor f2362c;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f2363a = new c(null);
    }

    public c(a aVar) {
        hashCode();
        SharedPreferences sharedPreferences = CFGMendikot.get().getAppContext().getSharedPreferences("MainPrefsMendikot", 4);
        this.f2361b = sharedPreferences;
        this.f2362c = sharedPreferences.edit();
    }

    public static c e() {
        return b.f2363a;
    }

    public void a() {
        Editor editor = this.f2362c;
        if (editor != null) {
            editor.apply();
        }
    }

    public void a(String str) {
        this.f2362c.putString("PREF_KEY_TOKEN", str);
    }

    public String b() {
        return this.f2361b.getString("PREF_KEY_TOKEN", "");
    }
}
