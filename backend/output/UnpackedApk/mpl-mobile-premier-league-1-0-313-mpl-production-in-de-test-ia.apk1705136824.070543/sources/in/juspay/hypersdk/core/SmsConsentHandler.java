package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapiphone.zzab;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.ApiCall;
import java.lang.ref.WeakReference;

public abstract class SmsConsentHandler extends BroadcastReceiver {
    public static final String LOG_TAG = "SmsConsentHandler";
    public WeakReference<Activity> activityRef = new WeakReference<>(null);
    public Intent consentIntent;
    public Runnable intentReceivedCallback;
    public final JuspayServices juspayServices;

    public SmsConsentHandler(Activity activity, JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
        if (activity != null) {
            startListener(activity);
            this.activityRef = new WeakReference<>(activity);
            activity.registerReceiver(this, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
        }
    }

    private void startListener(Activity activity) {
        if (activity != null) {
            final SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
            Task<Void> startSmsUserConsent = new zzab(activity).startSmsUserConsent(null);
            AnonymousClass1 r2 = new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    sdkTracker.trackAction("system", "debug", "SMS_CONSENT", "sms_consent_listener", "SmsConsent listener started successfully");
                }
            };
            zzw zzw = (zzw) startSmsUserConsent;
            if (zzw != null) {
                zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r2);
                zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener() {
                    public void onFailure(Exception exc) {
                        sdkTracker.trackAndLogException(SmsConsentHandler.LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, "SMS_CONSENT", "SmsConsent listener failed to start", exc);
                    }
                });
                return;
            }
            throw null;
        }
    }

    public Intent getConsentIntent() {
        return this.consentIntent;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Status status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                int i = status != null ? status.zzc : 16;
                if (i == 0) {
                    JuspayLogger.d(LOG_TAG, "SMS received: Can ask user consent");
                    this.consentIntent = (Intent) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT");
                    Runnable runnable = this.intentReceivedCallback;
                    if (runnable != null) {
                        runnable.run();
                    }
                } else if (i != 15) {
                    JuspayLogger.d(LOG_TAG, "Listener gave some unrecognised status: Sending back with callback ");
                } else {
                    JuspayLogger.d(LOG_TAG, "Restarting consent listener");
                    resetConsentHandler();
                }
            }
        }
    }

    public abstract void resetConsentHandler();

    public void setIntentReceivedCallback(Runnable runnable) {
        this.intentReceivedCallback = runnable;
    }

    public void unregisterConsent() {
        unregisterConsent((Activity) this.activityRef.get());
    }

    public void unregisterConsent(Activity activity) {
        Activity activity2 = (Activity) this.activityRef.get();
        if (activity2 == activity) {
            if (activity2 != null) {
                activity2.unregisterReceiver(this);
            }
            this.activityRef = new WeakReference<>(null);
        }
    }
}
