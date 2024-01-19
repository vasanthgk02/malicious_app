package com.clevertap.android.sdk.response;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.NetworkManager;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.validation.Validator;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ARPResponse extends CleverTapResponseDecorator {
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final CTProductConfigController ctProductConfigController;
    public final Logger logger;
    public final NetworkManager networkManager;
    public final Validator validator;

    public ARPResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig, NetworkManager networkManager2, Validator validator2, ControllerManager controllerManager) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.ctProductConfigController = controllerManager.ctProductConfigController;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.networkManager = networkManager2;
        this.validator = validator2;
    }

    public final void handleARPUpdate(Context context, JSONObject jSONObject) {
        if (jSONObject.length() != 0) {
            String newNamespaceARPKey = this.networkManager.getNewNamespaceARPKey();
            if (newNamespaceARPKey != null) {
                Editor edit = k.getPreferences(context, newNamespaceARPKey).edit();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof Number) {
                            edit.putInt(next, ((Number) obj).intValue());
                        } else if (obj instanceof String) {
                            if (((String) obj).length() < 100) {
                                edit.putString(next, (String) obj);
                            } else {
                                Logger logger2 = this.logger;
                                String str = this.config.accountId;
                                logger2.verbose(str, "ARP update for key " + next + " rejected (string value too long)");
                            }
                        } else if (obj instanceof Boolean) {
                            edit.putBoolean(next, ((Boolean) obj).booleanValue());
                        } else {
                            Logger logger3 = this.logger;
                            String str2 = this.config.accountId;
                            logger3.verbose(str2, "ARP update for key " + next + " rejected (invalid data type)");
                        }
                    } catch (JSONException unused) {
                    }
                }
                Logger logger4 = this.logger;
                String str3 = this.config.accountId;
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("Stored ARP for namespace key: ", newNamespaceARPKey, " values: ");
                outline80.append(jSONObject.toString());
                logger4.verbose(str3, outline80.toString());
                k.persist(edit);
            }
        }
    }

    public final void processDiscardedEventsList(JSONObject jSONObject) {
        if (!jSONObject.has("d_e")) {
            this.logger.verbose(this.config.accountId, (String) "ARP doesn't contain the Discarded Events key");
            return;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("d_e");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            if (this.validator != null) {
                this.validator.discardedEvents = arrayList;
            } else {
                this.logger.verbose(this.config.accountId, (String) "Validator object is NULL");
            }
        } catch (JSONException e2) {
            Logger logger2 = this.logger;
            String str = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error parsing discarded events list");
            outline73.append(e2.getLocalizedMessage());
            logger2.verbose(str, outline73.toString());
        }
    }

    public void processResponse(JSONObject jSONObject, String str, Context context) {
        try {
            if (jSONObject.has("arp")) {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("arp");
                if (jSONObject2.length() > 0) {
                    if (this.ctProductConfigController != null) {
                        this.ctProductConfigController.setArpValue(jSONObject2);
                    }
                    processDiscardedEventsList(jSONObject2);
                    handleARPUpdate(context, jSONObject2);
                }
            }
        } catch (Throwable th) {
            this.logger.verbose(this.config.accountId, "Failed to process ARP", th);
        }
        this.cleverTapResponse.processResponse(jSONObject, str, context);
    }
}
