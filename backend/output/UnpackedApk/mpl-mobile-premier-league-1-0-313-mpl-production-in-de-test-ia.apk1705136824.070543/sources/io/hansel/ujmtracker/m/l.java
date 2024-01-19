package io.hansel.ujmtracker.m;

import android.content.Context;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.network.requestwriter.HSLConnectionJSONPOSTRequestWriter;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.HashMap;

public class l extends HSLServerRequest {

    /* renamed from: a  reason: collision with root package name */
    public CoreJSONArray f5397a;

    /* renamed from: b  reason: collision with root package name */
    public String f5398b;

    public l(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, String str, CoreJSONArray coreJSONArray, HSLServerResponseHandler hSLServerResponseHandler) {
        super(context, hSLSDKIdentifiers, hSLServerResponseHandler);
        this.f5397a = coreJSONArray;
        this.f5398b = str;
    }

    public HSLConnectionRequestWriter getConnectionRequestWriter() {
        CoreJSONObject finalRequestParams = getFinalRequestParams(false);
        if (finalRequestParams == null) {
            return null;
        }
        String str = this.f5398b;
        HashMap hashMap = new HashMap();
        hashMap.put("X-Hansel-Provider-Id", getSdkIdentifiers().getAppId());
        hashMap.put("X-Hansel-Provider-Key", HSLInternalUtils.getStringFromSharedPreferences(this.context, "ha_key"));
        return new HSLConnectionJSONPOSTRequestWriter(getSdkIdentifiers().getSecret(), str, finalRequestParams, hashMap);
    }

    public CoreJSONObject getFinalRequestParams(boolean z) {
        CoreJSONArray coreJSONArray = this.f5397a;
        if (coreJSONArray != null) {
            addRequestParam("el", coreJSONArray);
        }
        return super.getFinalRequestParams(z);
    }
}
