package com.clevertap.android.sdk.response;

import android.content.Context;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.pushnotification.PushNotificationHandler.SingletonNotificationHandler;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PushAmpResponse extends CleverTapResponseDecorator {
    public final BaseDatabaseManager baseDatabaseManager;
    public final BaseCallbackManager callbackManager;
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final ControllerManager controllerManager;
    public final Logger logger;

    public PushAmpResponse(CleverTapResponse cleverTapResponse2, Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, BaseDatabaseManager baseDatabaseManager2, BaseCallbackManager baseCallbackManager, ControllerManager controllerManager2) {
        this.cleverTapResponse = cleverTapResponse2;
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.baseDatabaseManager = baseDatabaseManager2;
        this.callbackManager = baseCallbackManager;
        this.controllerManager = controllerManager2;
    }

    public final void handlePushNotificationsInResponse(JSONArray jSONArray) {
        boolean equals;
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                Bundle bundle = new Bundle();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("wzrk_ttl")) {
                    bundle.putLong("wzrk_ttl", jSONObject.getLong("wzrk_ttl"));
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    bundle.putString(obj, jSONObject.getString(obj));
                }
                if (!bundle.isEmpty()) {
                    DBAdapter loadDBAdapter = this.baseDatabaseManager.loadDBAdapter(this.context);
                    String string = jSONObject.getString("wzrk_pid");
                    synchronized (loadDBAdapter) {
                        equals = string.equals(loadDBAdapter.fetchPushNotificationId(string));
                    }
                    if (!equals) {
                        this.logger.verbose("Creating Push Notification locally");
                        if (((CallbackManager) this.callbackManager).pushAmpListener != null) {
                            ((CallbackManager) this.callbackManager).pushAmpListener.onPushAmpPayloadReceived(bundle);
                        } else {
                            SingletonNotificationHandler.INSTANCE.onMessageReceived(this.context, bundle, PushType.FCM.toString());
                        }
                        i++;
                    }
                }
                Logger logger2 = this.logger;
                String str = this.config.accountId;
                logger2.verbose(str, "Push Notification already shown, ignoring local notification :" + jSONObject.getString("wzrk_pid"));
                i++;
            } catch (JSONException unused) {
                this.logger.verbose(this.config.accountId, (String) "Error parsing push notification JSON");
                return;
            }
        }
    }

    public void processResponse(JSONObject jSONObject, String str, Context context2) {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "CleverTap instance is configured to analytics only, not processing push amp response");
            this.cleverTapResponse.processResponse(jSONObject, str, context2);
            return;
        }
        try {
            if (jSONObject.has("pushamp_notifs")) {
                this.logger.verbose(this.config.accountId, (String) "Processing pushamp messages...");
                JSONObject jSONObject2 = jSONObject.getJSONObject("pushamp_notifs");
                JSONArray jSONArray = jSONObject2.getJSONArray("list");
                if (jSONArray.length() > 0) {
                    this.logger.verbose(this.config.accountId, (String) "Handling Push payload locally");
                    handlePushNotificationsInResponse(jSONArray);
                }
                if (jSONObject2.has("pf")) {
                    this.controllerManager.pushProviders.updatePingFrequencyIfNeeded(context2, jSONObject2.getInt("pf"));
                }
                if (jSONObject2.has("ack")) {
                    boolean z = jSONObject2.getBoolean("ack");
                    Logger logger2 = this.logger;
                    logger2.verbose("Received ACK -" + z);
                    if (z) {
                        JSONArray renderedTargetList = k.getRenderedTargetList(this.baseDatabaseManager.loadDBAdapter(context2));
                        String[] strArr = new String[renderedTargetList.length()];
                        for (int i = 0; i < strArr.length; i++) {
                            strArr[i] = renderedTargetList.getString(i);
                        }
                        this.logger.verbose("Updating RTL values...");
                        this.baseDatabaseManager.loadDBAdapter(context2).updatePushNotificationIds(strArr);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.cleverTapResponse.processResponse(jSONObject, str, context2);
    }
}
