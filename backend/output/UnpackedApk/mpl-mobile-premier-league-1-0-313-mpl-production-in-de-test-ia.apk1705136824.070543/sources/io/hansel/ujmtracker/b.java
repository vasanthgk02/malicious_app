package io.hansel.ujmtracker;

import android.content.Context;
import com.netcore.android.preference.SMTPreferenceConstants;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.network.requestwriter.HSLConnectionJSONPOSTRequestWriter;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.HashMap;
import java.util.TimeZone;

public class b extends HSLServerRequest {

    /* renamed from: a  reason: collision with root package name */
    public io.hansel.userjourney.models.b f5312a;

    /* renamed from: b  reason: collision with root package name */
    public String f5313b;

    public b(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, String str, io.hansel.userjourney.models.b bVar, HSLServerResponseHandler hSLServerResponseHandler) {
        super(context, hSLSDKIdentifiers, hSLServerResponseHandler);
        if (bVar != null) {
            this.f5312a = bVar;
            this.f5313b = str;
        }
    }

    public HSLConnectionRequestWriter getConnectionRequestWriter() {
        CoreJSONObject finalRequestParams = getFinalRequestParams(false);
        if (finalRequestParams == null) {
            return null;
        }
        return new HSLConnectionJSONPOSTRequestWriter(getSdkIdentifiers().getSecret(), this.f5313b, finalRequestParams, new HashMap());
    }

    public CoreJSONObject getFinalRequestParams(boolean z) {
        addRequestParam("app_build_number", String.valueOf(this.sdkIdentifiers.getAppVersion().versionCode));
        addRequestParam(SMTPreferenceConstants.SMT_SDK_VERSION, HSLBuildConfig.SDK_VERSION);
        addRequestParam("os", "android");
        addRequestParam("app_version", this.sdkIdentifiers.appVersion.versionName);
        addRequestParam("tz_offset", Integer.valueOf(TimeZone.getDefault().getRawOffset()));
        addRequestParam("time", String.valueOf(System.currentTimeMillis()));
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        CoreJSONObject coreJSONObject = new CoreJSONObject();
        try {
            coreJSONObject.put((String) "name", (Object) this.f5312a.a());
            coreJSONObject.put((String) "ven", (Object) this.f5312a.g());
            coreJSONObject.put((String) "attrs", (Object) l.a(this.f5312a.a()).booleanValue() ? new CoreJSONArray() : this.f5312a.d());
            coreJSONObject.put((String) "internal", (Object) l.a(this.f5312a.a()));
            coreJSONArray.put((Object) coreJSONObject);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
        addRequestParam("events", coreJSONArray);
        return super.getFinalRequestParams(z);
    }
}
