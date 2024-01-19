package com.mpl.androidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MPLSMSBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = "MPLSMSBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        MLogger.d(TAG, "onReceive: ", intent);
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (!(extras == null || extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS") == null)) {
                Status status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                if (status != null) {
                    MLogger.d(TAG, status, status.zzd);
                    int i = status.zzc;
                    if (i == 0) {
                        String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                        MLogger.d(TAG, "onReceive: ", "message", str);
                        if (!TextUtils.isEmpty(str)) {
                            Matcher matcher = Pattern.compile("(\\d{6})").matcher(str);
                            String group = matcher.find() ? matcher.group(1) : "";
                            Intent intent2 = new Intent(Constant.ACTION_OTP_READ);
                            intent2.putExtra("message", group);
                            LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
                        }
                    } else if (i != 15) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("IsSuccess", Boolean.FALSE);
                        hashMap.put("Reason", status.zzd);
                        hashMap.put("Time To Detect", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - MSharedPreferencesUtils.getLongPref(Constant.OTP_INITIATED_TIME, 0, false))));
                        CleverTapAnalyticsUtils.sendEvent((String) "Otp Detected", hashMap);
                    } else {
                        MLogger.d(TAG, "onReceive:TIMEOUT ");
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("IsSuccess", Boolean.FALSE);
                        hashMap2.put("StatusCode", Integer.valueOf(status.zzc));
                        hashMap2.put("Reason", "TimeOut");
                        hashMap2.put("Time To Detect", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - MSharedPreferencesUtils.getLongPref(Constant.OTP_INITIATED_TIME, 0, false))));
                        CleverTapAnalyticsUtils.sendEvent((String) "Otp Detected", hashMap2);
                    }
                }
            }
        }
    }
}
