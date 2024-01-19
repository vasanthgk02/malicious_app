package com.mpl.androidapp.responsiblegaming;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;

public class RgSessionContentProvider extends ContentProvider {
    public static final int CONFIG_INFO = 101;
    public static final int SESSION_COUNT = 102;
    public static final int SESSION_INFO = 100;
    public static final String TAG = "ResponsibleGamingTimer";

    public static UriMatcher buildUriMatcher(Context context) {
        String str;
        if (context == null || TextUtils.isEmpty(context.getPackageName())) {
            str = RgSessionContract.CONTENT_AUTHORITY;
        } else {
            str = context.getPackageName() + RgSessionContract.CONTENT_AUTHORITY_POST_FIX;
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI(str, "session", 100);
        uriMatcher.addURI(str, "config", 101);
        uriMatcher.addURI(str, RgSessionContract.PATH_SESSION_COUNT, 102);
        return uriMatcher;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        if (buildUriMatcher(getContext()).match(uri) == 100) {
            return "rg/sessioninfo";
        }
        if (buildUriMatcher(getContext()).match(uri) == 101) {
            return "rg/configinfo";
        }
        if (buildUriMatcher(getContext()).match(uri) == 102) {
            return "rg/sessioncount";
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        MLogger.d("ResponsibleGamingTimer", "In rgSessionProviderOnCreate");
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (buildUriMatcher(getContext()).match(uri) == 100) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{Constant.RG_SESSION_ID, Constant.RG_SESSION_END, Constant.RG_LAST_WARNING_DURATION, Constant.RG_WARNING_COUNT, Constant.RG_SESSION_DURATION});
            matrixCursor.addRow(new Object[]{MSharedPreferencesUtils.getRgSessionId(), Long.valueOf(MSharedPreferencesUtils.getRgSessionEnd()), Long.valueOf(MSharedPreferencesUtils.getRgLastWarningDuration()), Integer.valueOf(MSharedPreferencesUtils.getRgWarningCount()), Long.valueOf(MSharedPreferencesUtils.getRgSessionDuration())});
            return matrixCursor;
        } else if (buildUriMatcher(getContext()).match(uri) != 101) {
            return null;
        } else {
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{Constant.RG_SESSION_TIMEOUT_MIN, Constant.RG_PRIMARY_WARNING_INTERVAL_MIN, Constant.RG_SECONDARY_WARNING_INTERVAL_MIN, Constant.RG_MAX_WARNING_COUNT, Constant.IS_RG_GAMING_ON});
            matrixCursor2.addRow(new Object[]{Integer.valueOf(MSharedPreferencesUtils.getRgSessionTimeoutMin()), Integer.valueOf(MSharedPreferencesUtils.getRgPrimaryWarningIntervalMinutes()), Integer.valueOf(MSharedPreferencesUtils.getRgSecondaryWarningIntervalMinutes()), Integer.valueOf(MSharedPreferencesUtils.getRgMaxWarningCount()), MSharedPreferencesUtils.getRgIsRgOn()});
            return matrixCursor2;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (buildUriMatcher(getContext()).match(uri) == 100) {
            RgSessionInfo rgSessionInfo = new RgSessionInfo();
            rgSessionInfo.setRgSessionId(contentValues.getAsString(Constant.RG_SESSION_ID));
            rgSessionInfo.setRgSessionEnd(contentValues.getAsLong(Constant.RG_SESSION_END).longValue());
            rgSessionInfo.setRgLastWarningDuration(contentValues.getAsLong(Constant.RG_LAST_WARNING_DURATION).longValue());
            rgSessionInfo.setRgWarningCount(contentValues.getAsInteger(Constant.RG_WARNING_COUNT).intValue());
            rgSessionInfo.setRgSessionDuration(contentValues.getAsLong(Constant.RG_SESSION_DURATION).longValue());
            MSharedPreferencesUtils.putRgSessionInfo(rgSessionInfo);
            return 1;
        } else if (buildUriMatcher(getContext()).match(uri) == 101) {
            RgConfigs rgConfigs = new RgConfigs();
            rgConfigs.setSessionTimeOutMinutes(contentValues.getAsInteger(Constant.RG_SESSION_TIMEOUT_MIN).intValue());
            rgConfigs.setPrimaryWarningIntervalMinutes(contentValues.getAsInteger(Constant.RG_PRIMARY_WARNING_INTERVAL_MIN).intValue());
            rgConfigs.setSecondaryWarningIntervalMinutes(contentValues.getAsInteger(Constant.RG_SECONDARY_WARNING_INTERVAL_MIN).intValue());
            rgConfigs.setMaxWarningCount(contentValues.getAsInteger(Constant.RG_MAX_WARNING_COUNT).intValue());
            rgConfigs.setIsRgGamingOn(contentValues.getAsString(Constant.IS_RG_GAMING_ON));
            MSharedPreferencesUtils.putRgConfig(rgConfigs);
            return 1;
        } else if (buildUriMatcher(getContext()).match(uri) != 102) {
            return 0;
        } else {
            MSharedPreferencesUtils.incrementSessionCount();
            return 1;
        }
    }
}
