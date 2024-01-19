package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.auth.api.credentials.CredentialsOptions;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.HintRequest.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapiphone.zzab;
import com.google.android.gms.internal.p001authapi.zbn;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.paynimo.android.payment.UPIFragment;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.fontbox.cmap.CMapParser;

@ReactModule(name = "ReadOtpModule")
public class ReadOtpModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int RC_HINT = 3003;
    public static final String TAG = "ReadOtpModule";
    public final ReactContext mReactContext;
    public final BroadcastReceiver mSmsReadReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (Constant.ACTION_OTP_READ.equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra("message");
                if (!TextUtils.isEmpty(stringExtra)) {
                    Matcher matcher = Pattern.compile("(\\d{6})").matcher(stringExtra);
                    String group = matcher.find() ? matcher.group(1) : "";
                    MLogger.d(ReadOtpModule.TAG, "message: ", stringExtra, " otp: ", group);
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("otp", group);
                    HashMap hashMap = new HashMap();
                    hashMap.put("IsSuccess", Boolean.TRUE);
                    hashMap.put("Time To Detect", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ReadOtpModule.this.readOtpInitiatedTime)));
                    CleverTapAnalyticsUtils.sendEvent((String) "Otp Detected", hashMap);
                    ReadOtpModule readOtpModule = ReadOtpModule.this;
                    readOtpModule.sendEvent(readOtpModule.mReactContext, Constant.EVENT_OTP, createMap);
                }
            }
        }
    };
    public long readOtpInitiatedTime = 0;

    public ReadOtpModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    private void registerReceiver(Activity activity) {
        MLogger.d(TAG, "registerReceiver() called with: currentActivity = [" + activity + CMapParser.MARK_END_OF_ARRAY);
        if (activity != null) {
            try {
                LocalBroadcastManager.getInstance(activity).registerReceiver(this.mSmsReadReceiver, new IntentFilter(Constant.ACTION_OTP_READ));
            } catch (Exception unused) {
                MLogger.e(TAG, "Unable to read otp");
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext, String str, WritableMap writableMap) {
        ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    private void showHintToUser() {
        try {
            if (this.mReactContext.getCurrentActivity() != null) {
                Builder builder = new Builder();
                CredentialPickerConfig.Builder builder2 = new CredentialPickerConfig.Builder();
                builder2.zbb = true;
                CredentialPickerConfig build = builder2.build();
                Preconditions.checkNotNull(build);
                builder.zbd = build;
                builder.zba = false;
                builder.zbb = true;
                HintRequest build2 = builder.build();
                CredentialsOptions.Builder builder3 = new CredentialsOptions.Builder();
                builder3.zba = Boolean.TRUE;
                CredentialsClient credentialsClient = new CredentialsClient(this.mReactContext.getCurrentActivity(), new CredentialsOptions(builder3));
                PendingIntent zba = zbn.zba(credentialsClient.getApplicationContext(), (AuthCredentialsOptions) credentialsClient.getApiOptions(), build2, ((AuthCredentialsOptions) credentialsClient.getApiOptions()).zbd);
                if (getCurrentActivity() != null) {
                    getCurrentActivity().startIntentSenderForResult(zba.getIntentSender(), RC_HINT, null, 0, 0, 0);
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "Could not start hint picker Intent", e2);
        }
    }

    private void smsRetriever() {
        Task<Void> startSmsRetriever = new zzab((Context) getReactApplicationContext()).startSmsRetriever();
        AnonymousClass2 r1 = new OnSuccessListener<Void>() {
            public void onSuccess(Void voidR) {
                MLogger.d(ReadOtpModule.TAG, "onSuccess: ", voidR);
            }
        };
        zzw zzw = (zzw) startSmsRetriever;
        if (zzw != null) {
            zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r1);
            ((zzw) startSmsRetriever).addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    MLogger.e(ReadOtpModule.TAG, "onFailure: ", exc);
                }
            });
            return;
        }
        throw null;
    }

    public String getName() {
        return TAG;
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        String str;
        if (i == 3003) {
            Credential credential = null;
            String str2 = "";
            if (i2 == -1) {
                credential = (Credential) intent.getParcelableExtra("com.google.android.gms.credentials.Credential");
                str = credential.zba;
                if (str != null && str.length() > 10) {
                    String replaceAll = str.trim().replaceAll("[^0-9]", str2);
                    str = replaceAll.substring(replaceAll.length() - 10);
                }
                MLogger.d(TAG, UPIFragment.CONFIG_TYPE_NUMBER, str);
            } else {
                MLogger.e(TAG, "Hint Read: NOT OK");
                str = str2;
            }
            WritableMap createMap = Arguments.createMap();
            if (credential != null) {
                str2 = str;
            }
            createMap.putString(Constant.SUGGEST_NUMBER, str2);
            sendEvent(this.mReactContext, Constant.EVENT_FILL_NUMBER, createMap);
        }
    }

    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void readOtp(Promise promise) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.readOtpInitiatedTime = currentTimeMillis;
            MSharedPreferencesUtils.putLongPref(Constant.OTP_INITIATED_TIME, currentTimeMillis, false);
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                registerReceiver(currentActivity);
            }
            smsRetriever();
            promise.resolve(Boolean.TRUE);
        } catch (Exception unused) {
            MLogger.e(TAG, "Unable to lunch the game");
        }
    }

    @ReactMethod
    public void showNumberHint() {
        showHintToUser();
    }

    @ReactMethod
    public void unRegisterReceiver() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            unRegisterReceiver(currentActivity);
        }
    }

    private void unRegisterReceiver(Activity activity) {
        MLogger.d(TAG, "unRegisterReceiver() called with: currentActivity = [" + activity + CMapParser.MARK_END_OF_ARRAY);
        if (activity != null) {
            try {
                LocalBroadcastManager.getInstance(activity).unregisterReceiver(this.mSmsReadReceiver);
            } catch (Exception unused) {
            }
        }
    }
}
