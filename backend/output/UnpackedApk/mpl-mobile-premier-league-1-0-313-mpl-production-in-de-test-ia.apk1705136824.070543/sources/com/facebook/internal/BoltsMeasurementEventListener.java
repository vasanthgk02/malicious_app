package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\t\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "close", "", "finalize", "onReceive", "intent", "Landroid/content/Intent;", "open", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BoltsMeasurementEventListener.kt */
public final class BoltsMeasurementEventListener extends BroadcastReceiver {
    public static BoltsMeasurementEventListener singleton;
    public final Context applicationContext;

    public BoltsMeasurementEventListener(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        this.applicationContext = applicationContext2;
    }

    public static final /* synthetic */ BoltsMeasurementEventListener access$getSingleton$cp() {
        if (CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return null;
        }
        try {
            return singleton;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            return null;
        }
    }

    public static final BoltsMeasurementEventListener getInstance(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (access$getSingleton$cp() != null) {
            return access$getSingleton$cp();
        }
        BoltsMeasurementEventListener boltsMeasurementEventListener = new BoltsMeasurementEventListener(context, null);
        if (!CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(boltsMeasurementEventListener)) {
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(boltsMeasurementEventListener.applicationContext);
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                    instance.registerReceiver(boltsMeasurementEventListener, new IntentFilter("com.parse.bolts.measurement_event"));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            }
        }
        if (!CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            try {
                singleton = boltsMeasurementEventListener;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, BoltsMeasurementEventListener.class);
            }
        }
        return access$getSingleton$cp();
    }

    public final void finalize() throws Throwable {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.applicationContext);
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                    instance.unregisterReceiver(this);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        Object obj;
        Bundle bundle;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Set<String> set = null;
                AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, (String) null, (AccessToken) null);
                Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
                if (intent == null) {
                    obj = null;
                } else {
                    obj = intent.getStringExtra("event_name");
                }
                String stringPlus = Intrinsics.stringPlus("bf_", obj);
                if (intent == null) {
                    bundle = null;
                } else {
                    bundle = intent.getBundleExtra("event_args");
                }
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    set = bundle.keySet();
                }
                if (set != null) {
                    for (String str : set) {
                        Intrinsics.checkNotNullExpressionValue(str, "key");
                        bundle2.putString(new Regex((String) "[ -]*$").replace(new Regex((String) "^[ -]*").replace(new Regex((String) "[^0-9a-zA-Z _-]").replace(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER), ""), ""), (String) bundle.get(str));
                    }
                }
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    appEventsLoggerImpl.logEvent(stringPlus, bundle2);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
