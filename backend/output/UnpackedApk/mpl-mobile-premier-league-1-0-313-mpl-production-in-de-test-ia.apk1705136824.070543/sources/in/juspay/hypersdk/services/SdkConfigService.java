package in.juspay.hypersdk.services;

import android.content.Context;
import in.juspay.hypersdk.core.JuspayCoreLib;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.LifeCycle;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.utils.IntegrationUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SdkConfigService {
    public static final int maxSecondsToLoad = 60;
    public static final String sdkConfigLocation = "sdk_config.json";
    public JuspayServices juspayServices;
    public JSONObject sdkConfig;

    public SdkConfigService(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
        try {
            this.sdkConfig = new JSONObject(KeyValueStore.read(juspayServices2, sdkConfigLocation, "{}"));
        } catch (JSONException e2) {
            this.sdkConfig = new JSONObject();
            SdkTracker.trackBootException(LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, "sdk_meta", "Exception while parsing sdk config", e2);
        }
    }

    public static JSONObject getCachedSdkConfig() {
        try {
            if (JuspayCoreLib.getApplicationContext() != null) {
                return new JSONObject(KeyValueStore.read(JuspayCoreLib.getApplicationContext(), IntegrationUtils.getSdkInfo(JuspayCoreLib.getApplicationContext()).getSdkName(), sdkConfigLocation, "{}"));
            }
        } catch (JSONException e2) {
            SdkTracker.trackBootException(LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, "sdk_meta", "Exception while parsing cached sdk config", e2);
        }
        return null;
    }

    public JSONObject getSdkConfig() {
        return this.sdkConfig;
    }

    public void renewConfig(Context context) {
        try {
            String readFromFile = this.juspayServices.getFileProviderService().readFromFile(context, (String) sdkConfigLocation, 60);
            this.sdkConfig = new JSONObject(readFromFile);
            KeyValueStore.write(this.juspayServices, sdkConfigLocation, readFromFile);
        } catch (JSONException e2) {
            SdkTracker.trackBootException(LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, "sdk_meta", "Exception while parsing renewed sdk config", e2);
        }
    }
}
