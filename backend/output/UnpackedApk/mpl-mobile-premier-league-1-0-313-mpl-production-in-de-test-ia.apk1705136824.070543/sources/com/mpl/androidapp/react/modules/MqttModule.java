package com.mpl.androidapp.react.modules;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.utils.MLogger;
import java.util.ArrayList;
import org.json.JSONArray;

@ReactModule(name = "MqttModule")
public class MqttModule extends ReactContextBaseJavaModule {
    public static final String TAG = "MqttModule";
    public Context mContext;

    public MqttModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (reactApplicationContext != null) {
            this.mContext = reactApplicationContext.getApplicationContext();
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void publishMessage(String str, String str2) {
        EventPublishHelper.publishToMqttChannel(this.mContext, str, str2);
    }

    @ReactMethod
    public void subscribe(String str, Promise promise) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!TextUtils.isEmpty(jSONArray.getString(i))) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            EventPublishHelper.subscribeToMqttChannel(this.mContext, (String[]) arrayList.toArray(new String[arrayList.size()]), true);
            promise.resolve("success");
        } catch (Exception e2) {
            promise.reject((String) "fail", (String) "error");
            MLogger.printStackTrace(e2);
        }
    }

    @ReactMethod
    public void unsubscribe(String str, Promise promise) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!TextUtils.isEmpty(jSONArray.getString(i))) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            EventPublishHelper.subscribeToMqttChannel(this.mContext, (String[]) arrayList.toArray(new String[arrayList.size()]), false);
            promise.resolve("success");
        } catch (Exception e2) {
            promise.reject((String) "fail", (String) "error");
            MLogger.printStackTrace(e2);
        }
    }
}
