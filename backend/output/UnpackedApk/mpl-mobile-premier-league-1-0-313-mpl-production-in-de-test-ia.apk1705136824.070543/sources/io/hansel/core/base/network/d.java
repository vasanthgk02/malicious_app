package io.hansel.core.base.network;

import android.content.Context;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.network.requestwriter.HSLConnectionJSONPOSTRequestWriter;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.core.utils.HSLUtils;
import java.util.HashMap;

public class d extends HSLServerRequest {

    /* renamed from: a  reason: collision with root package name */
    public String f5103a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5104b;

    public d(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLServerResponseHandler hSLServerResponseHandler, String str, boolean z) {
        super(context, hSLSDKIdentifiers, hSLServerResponseHandler);
        this.f5103a = str;
        this.f5104b = z;
    }

    private String a() {
        String tgAuthEndPoint = HSLInternalUtils.getTgAuthEndPoint(this.context);
        if (tgAuthEndPoint != null && tgAuthEndPoint.length() != 0) {
            return tgAuthEndPoint;
        }
        return HSLBuildConfig.getTgAuthServerUrl(this.context) + "/" + "dashboard/td/verify";
    }

    public HSLConnectionRequestWriter getConnectionRequestWriter() {
        CoreJSONObject finalRequestParams = getFinalRequestParams(false);
        if (finalRequestParams == null) {
            return null;
        }
        return new HSLConnectionJSONPOSTRequestWriter(getSdkIdentifiers().getSecret(), a(), finalRequestParams, new HashMap());
    }

    public CoreJSONObject getFinalRequestParams(boolean z) {
        Object obj;
        String str;
        addRequestParam("a_id", this.sdkIdentifiers.appId);
        addRequestParam("d_id", this.sdkIdentifiers.deviceId);
        if (HSLUtils.isSet(this.f5103a)) {
            obj = this.f5103a;
            str = "auth";
        } else {
            obj = Boolean.valueOf(this.f5104b);
            str = "tg";
        }
        addRequestParam(str, obj);
        return this.requestParams;
    }
}
