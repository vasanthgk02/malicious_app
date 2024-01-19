package com.rudderstack.android.sdk.core.util;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rudderstack.android.sdk.core.RudderLogger;
import com.rudderstack.android.sdk.core.RudderProperty;
import io.sentry.DateUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class Utils {
    public static final int MAX_BATCH_SIZE = 512000;
    public static final int MAX_CONFIG_REFRESH_INTERVAL = 24;
    public static final int MAX_EVENT_SIZE = 32768;
    public static final int MAX_FLUSH_QUEUE_SIZE = 100;
    public static final int MIN_CONFIG_REFRESH_INTERVAL = 1;
    public static final int MIN_FLUSH_QUEUE_SIZE = 1;
    public static final int MIN_SLEEP_TIMEOUT = 1;

    public enum NetworkResponses {
        SUCCESS,
        ERROR,
        WRITE_KEY_ERROR
    }

    public static List<Map<String, Object>> convertToList(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<Map<String, Object>>>() {
        }.getType());
    }

    public static Map<String, Object> convertToMap(String str) {
        return (Map) new Gson().fromJson(str, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

    public static boolean fileExists(Context context, String str) {
        File fileStreamPath = context.getFileStreamPath(str);
        return fileStreamPath != null && fileStreamPath.exists();
    }

    public static <T> List<T> getBatch(List<T> list, int i) {
        if (list.size() <= i) {
            return list;
        }
        return new ArrayList(list.subList(0, i));
    }

    public static String getDeviceId(Application application) {
        String string = System.getString(application.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string) || "9774d56d682e549c".equals(string) || "unknown".equals(string) || "000000000000000".equals(string)) {
            return UUID.randomUUID().toString();
        }
        return string;
    }

    public static int getNumberOfBatches(int i, int i2) {
        if (i % i2 == 0) {
            return i / i2;
        }
        return (i / i2) + 1;
    }

    public static String getReferrer(Activity activity) {
        return activity.getReferrer().toString();
    }

    public static String getTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO_FORMAT_WITH_MILLIS, Locale.US);
        simpleDateFormat.setCalendar(new GregorianCalendar());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    public static String getTimeZone() {
        return TimeZone.getDefault().getID();
    }

    public static int getUTF8Length(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e2) {
            RudderLogger.logError((Exception) e2);
            return -1;
        }
    }

    public static String getWriteKeyFromStrings(Context context) {
        int identifier = context.getResources().getIdentifier(context.getPackageName(), NetworkingModule.REQUEST_BODY_KEY_STRING, "rudder_write_key");
        if (identifier != 0) {
            return context.getResources().getString(identifier);
        }
        return null;
    }

    public static boolean isOnClassPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isTv(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static String toDateString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setCalendar(new GregorianCalendar());
        return simpleDateFormat.format(date);
    }

    public static RudderProperty trackDeepLink(Activity activity, AtomicBoolean atomicBoolean, int i) {
        RudderProperty putValue = new RudderProperty().putValue("from_background", Boolean.valueOf(!atomicBoolean.get()));
        if (!atomicBoolean.getAndSet(false)) {
            return putValue;
        }
        putValue.putValue("version", Integer.valueOf(i));
        try {
            Intent intent = activity.getIntent();
            if (intent != null) {
                if (intent.getData() != null) {
                    String referrer = getReferrer(activity);
                    if (referrer != null) {
                        putValue.putValue("referring_application", referrer);
                    }
                    Uri data = intent.getData();
                    if (data != null) {
                        try {
                            for (String next : data.getQueryParameterNames()) {
                                String queryParameter = data.getQueryParameter(next);
                                if (queryParameter != null && !queryParameter.trim().isEmpty()) {
                                    putValue.putValue(next, queryParameter);
                                }
                            }
                        } catch (Exception e2) {
                            RudderLogger.logError("Failed to get uri query parameters: " + e2);
                        }
                        putValue.putValue("url", data.toString());
                    }
                    return putValue;
                }
            }
            return putValue;
        } catch (Exception e3) {
            RudderLogger.logError("Error occurred while tracking deep link" + e3);
        }
    }

    public static int getUTF8Length(StringBuilder sb) {
        return getUTF8Length(sb.toString());
    }
}
