package com.clevertap.android.sdk.response;

import android.content.Context;
import android.text.TextUtils;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.displayunits.CTDisplayUnitController;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class DisplayUnitResponse extends CleverTapResponseDecorator {
    public final BaseCallbackManager callbackManager;
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final ControllerManager controllerManager;
    public final Object displayUnitControllerLock = new Object();
    public final Logger logger;

    public DisplayUnitResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig, BaseCallbackManager baseCallbackManager, ControllerManager controllerManager2) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.callbackManager = baseCallbackManager;
        this.controllerManager = controllerManager2;
    }

    public final void parseDisplayUnits(JSONArray jSONArray) {
        ArrayList arrayList;
        if (jSONArray == null || jSONArray.length() == 0) {
            this.logger.verbose(this.config.accountId, (String) "DisplayUnit : Can't parse Display Units, jsonArray is either empty or null");
            return;
        }
        synchronized (this.displayUnitControllerLock) {
            if (this.controllerManager.ctDisplayUnitController == null) {
                this.controllerManager.ctDisplayUnitController = new CTDisplayUnitController();
            }
        }
        CTDisplayUnitController cTDisplayUnitController = this.controllerManager.ctDisplayUnitController;
        synchronized (cTDisplayUnitController) {
            cTDisplayUnitController.reset();
            if (jSONArray.length() > 0) {
                arrayList = new ArrayList();
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        CleverTapDisplayUnit displayUnit = CleverTapDisplayUnit.toDisplayUnit((JSONObject) jSONArray.get(i));
                        if (TextUtils.isEmpty(displayUnit.error)) {
                            cTDisplayUnitController.items.put(displayUnit.unitID, displayUnit);
                            arrayList.add(displayUnit);
                        } else {
                            Logger.d("DisplayUnit : ", "Failed to convert JsonArray item at index:" + i + " to Display Unit");
                        }
                        i++;
                    } catch (Exception e2) {
                        Logger.d("DisplayUnit : ", "Failed while parsing Display Unit:" + e2.getLocalizedMessage());
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
            } else {
                Logger.d("DisplayUnit : ", "Null json array response can't parse Display Units ");
                arrayList = null;
            }
        }
        CallbackManager callbackManager2 = (CallbackManager) this.callbackManager;
        if (callbackManager2 != null) {
            if (arrayList == null || arrayList.isEmpty()) {
                callbackManager2.config.getLogger().verbose(callbackManager2.config.accountId, (String) "DisplayUnit : No Display Units found");
            } else {
                callbackManager2.config.getLogger().verbose(callbackManager2.config.accountId, (String) "DisplayUnit : No registered listener, failed to notify");
            }
            return;
        }
        throw null;
    }

    public void processResponse(JSONObject jSONObject, String str, Context context) {
        this.logger.verbose(this.config.accountId, (String) "Processing Display Unit items...");
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "CleverTap instance is configured to analytics only, not processing Display Unit response");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        } else if (jSONObject == null) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "DisplayUnit : Can't parse Display Unit Response, JSON response object is null");
        } else if (!jSONObject.has("adUnit_notifs")) {
            this.logger.verbose(this.config.accountId, (String) "DisplayUnit : JSON object doesn't contain the Display Units key");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        } else {
            try {
                this.logger.verbose(this.config.accountId, (String) "DisplayUnit : Processing Display Unit response");
                parseDisplayUnits(jSONObject.getJSONArray("adUnit_notifs"));
            } catch (Throwable th) {
                this.logger.verbose(this.config.accountId, "DisplayUnit : Failed to parse response", th);
            }
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        }
    }
}
