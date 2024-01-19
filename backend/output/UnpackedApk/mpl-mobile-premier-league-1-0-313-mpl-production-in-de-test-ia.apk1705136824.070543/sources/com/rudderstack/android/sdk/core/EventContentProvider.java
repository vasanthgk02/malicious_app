package com.rudderstack.android.sdk.core;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;

public class EventContentProvider extends ContentProvider {
    public static final int EVENT_CODE = 1;
    public static final int EVENT_ID_CODE = 2;
    public static final String QUERY_PARAMETER_LIMIT = "limit";
    public static String authority = "";
    public static String check = "initial";
    public static UriMatcher uriMatcher;
    public EventsDbHelper dbHelper;

    public static Uri getContentUri(String str) {
        Uri parse = Uri.parse("content://" + str + "/" + "events");
        try {
            UriMatcher uriMatcher2 = new UriMatcher(-1);
            uriMatcher = uriMatcher2;
            uriMatcher2.addURI(str, "events", 1);
            uriMatcher.addURI(str, "events/#", 2);
        } catch (Exception e2) {
            RudderLogger.logError((String) "Failed to initialize URI Matcher");
            RudderLogger.logError(e2.getCause());
        }
        return parse;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        authority = GeneratedOutlineSupport.outline62(new StringBuilder(), providerInfo.packageName, ".EventContentProvider");
        check = "checked";
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher = uriMatcher2;
        uriMatcher2.addURI(authority, "events", 1);
        uriMatcher.addURI(authority, "events/#", 2);
        super.attachInfo(context, providerInfo);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i;
        String str2;
        int match = uriMatcher.match(uri);
        if (match == 1) {
            i = this.dbHelper.getWritableDatabase().delete("events", str, strArr);
        } else if (match != 2) {
            i = 0;
        } else {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            StringBuilder outline78 = GeneratedOutlineSupport.outline78("m_id = ", uri.getPathSegments().get(1));
            if (!TextUtils.isEmpty(str)) {
                str2 = " AND (" + str + ')';
            } else {
                str2 = "";
            }
            outline78.append(str2);
            i = writableDatabase.delete("events", outline78.toString(), strArr);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return i;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        long insert = this.dbHelper.getWritableDatabase().insert("events", "", contentValues);
        if (insert <= 0) {
            return null;
        }
        Uri withAppendedId = ContentUris.withAppendedId(getContentUri(authority), insert);
        getContext().getContentResolver().notifyChange(withAppendedId, null);
        return withAppendedId;
    }

    public boolean onCreate() {
        this.dbHelper = new EventsDbHelper(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.dbHelper.getWritableDatabase().query("events", strArr, str, strArr2, null, null, str2, uri.getQueryParameter(QUERY_PARAMETER_LIMIT));
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i;
        String str2;
        int match = uriMatcher.match(uri);
        if (match == 1) {
            i = this.dbHelper.getWritableDatabase().update("events", contentValues, str, strArr);
        } else if (match != 2) {
            i = 0;
        } else {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("m_id = ");
            outline73.append(uri.getPathSegments().get(1));
            if (!TextUtils.isEmpty(str)) {
                str2 = " AND (" + str + ')';
            } else {
                str2 = "";
            }
            outline73.append(str2);
            i = writableDatabase.update("events", contentValues, outline73.toString(), strArr);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return i;
    }
}
