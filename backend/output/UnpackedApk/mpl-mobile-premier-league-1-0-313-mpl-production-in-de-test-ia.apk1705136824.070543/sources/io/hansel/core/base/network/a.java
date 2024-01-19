package io.hansel.core.base.network;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import androidx.core.app.NotificationCompat.WearableExtender;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.network.requestwriter.HSLConnectionJSONPOSTRequestWriter;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;
import sfs2x.client.requests.CreateRoomRequest;

public class a extends HSLServerRequest {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f5099a;

    /* renamed from: b  reason: collision with root package name */
    public CoreJSONObject f5100b = getFinalRequestParams(false);

    public a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLServerResponseHandler hSLServerResponseHandler) {
        super(context, hSLSDKIdentifiers, hSLServerResponseHandler);
    }

    public void a() {
        c.a(this.context, this.f5099a);
    }

    public HSLConnectionRequestWriter getConnectionRequestWriter() {
        if (this.f5100b == null) {
            return null;
        }
        return new HSLConnectionJSONPOSTRequestWriter(getSdkIdentifiers().getSecret(), HSLInternalUtils.getUrlFromFormat(this.context, HSLInternalUtils.getServerUrlWithPath("/dashboard/sdk/v1/init/android/<app_id>/", this.context), HSLInternalUtils.getStringFromSharedPreferences(this.context, HSLInternalUtils.KEY_PATCH_LIST_VERSION)), this.f5100b, new HashMap());
    }

    public CoreJSONObject getFinalRequestParams(boolean z) {
        boolean isInTestGroup = HSLInternalUtils.isInTestGroup(this.context);
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        CoreJSONArray coreJSONArray2 = new CoreJSONArray();
        if (isInTestGroup) {
            coreJSONArray = HSLFiltersInternal.getInstance().getAllForRequest(isInTestGroup);
            coreJSONArray2 = io.hansel.core.filters.a.a(this.context);
        }
        addRequestParam("tg", Boolean.valueOf(isInTestGroup));
        addRequestParam("ua", coreJSONArray);
        addRequestParam(WearableExtender.KEY_ACTIONS, coreJSONArray2);
        CoreJSONArray a2 = c.a(this.context);
        if (a2 == null || a2.length() == 0) {
            return null;
        }
        int length = a2.length();
        this.f5099a = new ArrayList<>(length);
        CoreJSONArray coreJSONArray3 = new CoreJSONArray();
        for (int i = 0; i < length; i++) {
            try {
                b bVar = new b((CoreJSONObject) a2.get(i));
                this.f5099a.add(bVar);
                coreJSONArray3.put((Object) bVar.c());
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2, "Some issue in init sdk cache data", LogGroup.AI);
            }
        }
        addRequestParam(CreateRoomRequest.KEY_ROOMVARS, HSLInternalUtils.getStringFromSharedPreferences(this.context, HSLInternalUtils.KEY_PATCH_LIST_VERSION));
        addRequestParam("ispa", Boolean.valueOf(HSLInternalUtils.getBooleanFromSharedPreferences(this.context, HSLInternalUtils.KEY_INITSDK_IS_PUSH_INITIATED)));
        addRequestParam("aid", this.sdkIdentifiers.getAppId());
        addRequestParam("av", this.sdkIdentifiers.getAppVersion().versionName);
        addRequestParam("bno", String.valueOf(this.sdkIdentifiers.getAppVersion().versionCode));
        addRequestParam("did", this.sdkIdentifiers.getDeviceId());
        addRequestParam("sv", HSLBuildConfig.SDK_VERSION);
        addRequestParam("dname", Build.MODEL);
        addRequestParam("dmake", Build.MANUFACTURER);
        addRequestParam("os", "android");
        addRequestParam(HSLInternalUtils.KEY_OLD_SDK_V, VERSION.RELEASE);
        addRequestParam("tzo", Integer.valueOf(TimeZone.getDefault().getRawOffset()));
        addRequestParam("ts", String.valueOf(System.currentTimeMillis()));
        return super.getFinalRequestParams(z);
    }

    public void run() {
        super.run();
    }
}
