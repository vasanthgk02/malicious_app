package io.hansel.visualizer.f;

import android.content.Context;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.config.ConfigConstant;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.network.requestwriter.HSLConnectionJSONPOSTRequestWriter;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.HashMap;

public class a extends HSLServerRequest {
    public a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLServerResponseHandler hSLServerResponseHandler) {
        super(context, hSLSDKIdentifiers, hSLServerResponseHandler);
    }

    public HSLConnectionRequestWriter getConnectionRequestWriter() {
        CoreJSONObject finalRequestParams = getFinalRequestParams(false);
        if (finalRequestParams == null) {
            return null;
        }
        return new HSLConnectionJSONPOSTRequestWriter(getSdkIdentifiers().getSecret(), c.a(this.context), finalRequestParams, new HashMap());
    }

    public CoreJSONObject getFinalRequestParams(boolean z) {
        addRequestParam(DefaultSettingsSpiCall.SOURCE_PARAM, "device");
        addRequestParam("app_id", getSdkIdentifiers().getAppId());
        addRequestParam(ConfigConstant.DEVICE_ID, getSdkIdentifiers().getDeviceId());
        return super.getFinalRequestParams(z);
    }
}
