package io.hansel.core.base.push;

import android.content.Context;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.network.requestwriter.HSLConnectionJSONPOSTRequestWriter;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.io.InputStream;
import java.util.HashMap;

public class a extends HSLServerRequest {

    /* renamed from: a  reason: collision with root package name */
    public static String f5109a = "pn_id";

    /* renamed from: io.hansel.core.base.push.a$a  reason: collision with other inner class name */
    public static class C0071a implements HSLServerResponseHandler {

        /* renamed from: a  reason: collision with root package name */
        public final Context f5110a;

        public C0071a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers) {
            this.f5110a = context;
        }

        public void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i) {
        }

        public void parseResponse(HSLServerRequest hSLServerRequest, String str, int i) {
            HSLLogger.d("InitSDKResponseHandlerPush:  " + i);
            if (str == null || i < 200 || i >= 300) {
                Context context = this.f5110a;
                HSLInternalUtils.setLongInSharedPreferences(context, HSLInternalUtils.KEY_REGISTER_PN_TOKEN_REQUEST_SILENCE_INTERVAL, (HSLInternalUtils.getRequestFailureTTL(this.f5110a) * 60000) + System.currentTimeMillis());
                return;
            }
            try {
                CoreJSONObject coreJSONObject = new CoreJSONObject(str);
                if (!coreJSONObject.optBoolean("is_error", true)) {
                    ((a) hSLServerRequest).a();
                    CoreJSONObject jSONObject = coreJSONObject.getJSONObject("api_response");
                    long currentTimeMillis = System.currentTimeMillis();
                    long optLong = jSONObject.optLong("api_silence_interval");
                    Long.signum(optLong);
                    HSLInternalUtils.setLongInSharedPreferences(this.f5110a, HSLInternalUtils.KEY_REGISTER_PN_TOKEN_REQUEST_SILENCE_INTERVAL, (optLong * 60000) + currentTimeMillis);
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers) {
        super(context, hSLSDKIdentifiers, new C0071a(context, hSLSDKIdentifiers));
    }

    private boolean b() {
        boolean booleanFromSharedPreferences = HSLInternalUtils.getBooleanFromSharedPreferences(this.context, HSLInternalUtils.KEY_PUSH_TOKEN_NOT_SYNCED);
        if (!booleanFromSharedPreferences) {
            booleanFromSharedPreferences = System.currentTimeMillis() - HSLInternalUtils.getLongFromSharedPreferences(this.context, HSLInternalUtils.KEY_REGISTER_PN_TOKEN_REQUEST_SILENCE_INTERVAL) > 0;
        }
        return booleanFromSharedPreferences ? !HSLInternalUtils.getStringFromSharedPreferences(this.context, HSLInternalUtils.KEY_PUSH_TOKEN, "").isEmpty() : booleanFromSharedPreferences;
    }

    public void a() {
        HSLInternalUtils.clearKey(this.context, HSLInternalUtils.KEY_PUSH_TOKEN_NOT_SYNCED);
    }

    public HSLConnectionRequestWriter getConnectionRequestWriter() {
        String serverUrlWithPath = HSLInternalUtils.getServerUrlWithPath("/dashboard/invalidatettlpn/registerdevice", this.context);
        CoreJSONObject finalRequestParams = getFinalRequestParams(true);
        if (finalRequestParams == null) {
            return null;
        }
        return new HSLConnectionJSONPOSTRequestWriter(getSdkIdentifiers().getSecret(), serverUrlWithPath, finalRequestParams, new HashMap());
    }

    public CoreJSONObject getFinalRequestParams(boolean z) {
        addRequestParam(f5109a, HSLInternalUtils.getStringFromSharedPreferences(this.context, HSLInternalUtils.KEY_PUSH_TOKEN, ""));
        addRequestParam("tg", Boolean.valueOf(HSLInternalUtils.isInTestGroup(this.context)));
        return super.getFinalRequestParams(z);
    }

    public void run() {
        if (b()) {
            HSLLogger.i("Trying to sync token with Hansel servers.");
            super.run();
        }
    }
}
