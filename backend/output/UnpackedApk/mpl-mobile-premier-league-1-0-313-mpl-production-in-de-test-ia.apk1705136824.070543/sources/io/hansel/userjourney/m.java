package io.hansel.userjourney;

import android.content.Context;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.network.requestwriter.HSLConnectionJSONPOSTRequestWriter;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.HashMap;
import java.util.TimeZone;

public class m extends HSLServerRequest {
    public m(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLServerResponseHandler hSLServerResponseHandler) {
        super(context, hSLSDKIdentifiers, hSLServerResponseHandler);
    }

    public HSLConnectionRequestWriter getConnectionRequestWriter() {
        CoreJSONObject finalRequestParams = getFinalRequestParams(true);
        if (finalRequestParams == null) {
            return null;
        }
        return new HSLConnectionJSONPOSTRequestWriter(getSdkIdentifiers().getSecret(), o.a(this.context), finalRequestParams, new HashMap());
    }

    public CoreJSONObject getFinalRequestParams(boolean z) {
        boolean isInTestGroup = HSLInternalUtils.isInTestGroup(this.context);
        addRequestParam("tzo", Integer.valueOf(TimeZone.getDefault().getRawOffset()));
        addRequestParam("ts", String.valueOf(System.currentTimeMillis()));
        addRequestParam("tg", Boolean.valueOf(isInTestGroup));
        addRequestParam("d_id", this.sdkIdentifiers.deviceId);
        addRequestParam("av", this.sdkIdentifiers.getAppVersion().versionName);
        addRequestParam("sv", HSLBuildConfig.SDK_VERSION);
        addRequestParam("ispa", Boolean.valueOf(p.k(this.context)));
        return this.requestParams;
    }
}
