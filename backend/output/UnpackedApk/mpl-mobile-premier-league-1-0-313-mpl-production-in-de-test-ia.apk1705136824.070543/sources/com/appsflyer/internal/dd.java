package com.appsflyer.internal;

import android.content.Context;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public abstract class dd extends Observable {
    public d AFInAppEventParameterName = d.NOT_STARTED;
    public final Map<String, Object> AFInAppEventType = new HashMap();
    public final String AFKeystoreWrapper;
    public long valueOf;
    public final Runnable values;

    public enum d {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public dd(String str, Runnable runnable) {
        this.values = runnable;
        this.AFKeystoreWrapper = str;
    }

    public abstract void AFInAppEventParameterName(Context context);

    public final void valueOf() {
        this.AFInAppEventType.put(DefaultSettingsSpiCall.SOURCE_PARAM, this.AFKeystoreWrapper);
        this.AFInAppEventType.putAll(new da());
        this.AFInAppEventType.put("latency", Long.valueOf(System.currentTimeMillis() - this.valueOf));
        this.AFInAppEventParameterName = d.FINISHED;
        setChanged();
        notifyObservers();
    }

    public final void values() {
        this.valueOf = System.currentTimeMillis();
        this.AFInAppEventParameterName = d.STARTED;
        addObserver(new Observer() {
            public final void update(Observable observable, Object obj) {
                dd.this.values.run();
            }
        });
    }
}
