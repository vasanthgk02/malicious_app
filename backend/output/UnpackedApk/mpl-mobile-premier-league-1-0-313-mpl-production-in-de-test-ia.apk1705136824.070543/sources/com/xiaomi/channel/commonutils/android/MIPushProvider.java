package com.xiaomi.channel.commonutils.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class MIPushProvider extends ContentProvider {
    public static Uri a(Context context) {
        String packageName = context.getPackageName();
        return Uri.parse("content://" + packageName + ".mipush.sdk.data");
    }

    private void a() {
        getContext().getSharedPreferences("mipush_region", 0).edit().putBoolean("req_hosts", false).apply();
    }

    private void a(Bundle bundle) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("mipush_region", 0);
        String string = sharedPreferences.getString("user_region", "");
        boolean z = sharedPreferences.getBoolean("req_hosts", false);
        bundle.putString("user_region", string);
        bundle.putBoolean("req_hosts", z);
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if ("getUserRegion".equals(str)) {
            a(bundle2);
        } else if ("reset_req_hosts".equals(str)) {
            a();
        }
        return bundle2;
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
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
