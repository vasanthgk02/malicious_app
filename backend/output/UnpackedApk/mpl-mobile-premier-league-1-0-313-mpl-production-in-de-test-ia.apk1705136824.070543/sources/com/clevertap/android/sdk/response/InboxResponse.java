package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class InboxResponse extends CleverTapResponseDecorator {
    public final BaseCallbackManager callbackManager;
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final ControllerManager controllerManager;
    public final Object inboxControllerLock;
    public final Logger logger;

    public InboxResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig, CTLockManager cTLockManager, BaseCallbackManager baseCallbackManager, ControllerManager controllerManager2) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.callbackManager = baseCallbackManager;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.inboxControllerLock = cTLockManager.inboxControllerLock;
        this.controllerManager = controllerManager2;
    }

    public final void _processInboxMessages(JSONArray jSONArray) {
        synchronized (this.inboxControllerLock) {
            if (this.controllerManager.ctInboxController == null) {
                this.controllerManager.initializeInbox();
            }
            if (this.controllerManager.ctInboxController != null && this.controllerManager.ctInboxController.updateMessages(jSONArray)) {
                this.callbackManager._notifyInboxMessagesDidUpdate();
            }
        }
    }

    public void processResponse(JSONObject jSONObject, String str, Context context) {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "CleverTap instance is configured to analytics only, not processing inbox messages");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
            return;
        }
        this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "Inbox: Processing response");
        if (!jSONObject.has("inbox_notifs")) {
            this.logger.verbose(this.config.accountId, (String) "Inbox: Response JSON object doesn't contain the inbox key");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
            return;
        }
        try {
            _processInboxMessages(jSONObject.getJSONArray("inbox_notifs"));
        } catch (Throwable th) {
            this.logger.verbose(this.config.accountId, "InboxResponse: Failed to parse response", th);
        }
        this.cleverTapResponse.processResponse(jSONObject, str, context);
    }
}
