package io.hansel.core.base.network;

import android.content.Context;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;

public abstract class StatusCodeResponseHandler implements HSLServerResponseHandler {
    public Context context;

    public StatusCodeResponseHandler(Context context2) {
        this.context = context2;
    }

    private void onErrorSave(Throwable th) {
        saveTTL(((HSLInternalUtils.isInTestGroup(this.context) ? 0 : HSLInternalUtils.getRequestFailureTTL(this.context)) * 60000) + System.currentTimeMillis());
        onError(th);
    }

    private void onKillHansel() {
        HSLInternalUtils.sHSLDoNotUseHansel = true;
        HSLInternalUtils.setBooleanInSharedPreferences(this.context, HSLInternalUtils.KEY_DONT_USE_HANSEL, true);
    }

    public abstract long getTTL();

    public abstract void onError(Throwable th);

    public void onNoDataUpdate() {
    }

    public abstract void onParseResponse(HSLServerRequest hSLServerRequest, CoreJSONObject coreJSONObject);

    public void parseResponse(HSLServerRequest hSLServerRequest, String str, int i) {
        try {
            HSLLogger.d("StatusCodeResponseHandler:  " + hSLServerRequest.getClass().getSimpleName() + "    :   " + i, LogGroup.AI);
            if (i == 211) {
                saveTTL((getTTL() * 60000) + System.currentTimeMillis());
                onNoDataUpdate();
            } else if (i == 521) {
                throw new Exception("InvalidParamException");
            } else if (i == 522) {
                throw new Exception("InvalidParamTypeException");
            } else if (i == 523) {
                throw new Exception("InvalidSignatureException");
            } else if (i == 524) {
                throw new Exception("InvalidSdkException");
            } else if (i == 526) {
                throw new Exception("App version obj not in redis");
            } else if (i == 527) {
                throw new Exception("No response in redis");
            } else if (i == 528) {
                throw new Exception("Any other exception");
            } else if (i == 529) {
                throw new Exception("App obj not found in redis");
            } else if (i == 525) {
                onKillHansel();
            } else if (str == null || i < 200 || i >= 300) {
                throw new Exception("Error in Response.");
            } else {
                CoreJSONObject coreJSONObject = new CoreJSONObject(str);
                if (!coreJSONObject.optBoolean("is_error")) {
                    CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("api_response");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("data", null);
                        if (optString != null) {
                            onParseResponse(hSLServerRequest, new CoreJSONObject(optString));
                            return;
                        }
                        throw new Exception("No data returned by the server.");
                    }
                    throw new Exception("Response is null.");
                } else if ("kill".equals(coreJSONObject.optString(PushMessageHelper.ERROR_TYPE))) {
                    onKillHansel();
                } else {
                    throw new Exception("Error in Response.");
                }
            }
        } catch (Throwable th) {
            onErrorSave(th);
        }
    }

    public abstract void saveTTL(long j);
}
