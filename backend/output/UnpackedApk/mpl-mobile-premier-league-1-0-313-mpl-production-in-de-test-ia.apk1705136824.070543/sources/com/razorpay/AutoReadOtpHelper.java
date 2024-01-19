package com.razorpay;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

public class AutoReadOtpHelper extends BroadcastReceiver {
    public Activity a_$P$;

    public AutoReadOtpHelper(Activity activity) {
        this.a_$P$ = activity;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_RECEIVED_SMS);
            int i = ((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).zzc;
            if (i == 0) {
                try {
                    this.a_$P$.startActivityForResult((Intent) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT"), 1001);
                    AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_SHOWED_ONE_TIME_CONSENT);
                } catch (ActivityNotFoundException e2) {
                    AnalyticsUtil.reportError(e2, "critical", e2.getLocalizedMessage());
                    e2.printStackTrace();
                }
            } else if (i == 15) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_TIMEOUT);
            }
        }
    }
}
