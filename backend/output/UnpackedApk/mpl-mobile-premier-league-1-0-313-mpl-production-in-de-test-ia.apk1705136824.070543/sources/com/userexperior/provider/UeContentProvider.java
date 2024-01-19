package com.userexperior.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.userexperior.services.recording.f;
import com.userexperior.utilities.l;

public class UeContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static long f4096a;

    public static long a() {
        return f4096a;
    }

    public static void b() {
        f4096a = 0;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Context applicationContext = context.getApplicationContext();
        boolean c2 = l.c(applicationContext);
        if ((applicationContext instanceof Application) && !c2) {
            f4096a = System.currentTimeMillis();
            f.g().a(applicationContext);
            l.e(context, "COLD");
        }
        super.attachInfo(context, providerInfo);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
