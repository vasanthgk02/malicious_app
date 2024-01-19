package com.appsflyer;

import android.content.Context;
import com.appsflyer.internal.ac;
import com.appsflyer.internal.an;
import com.appsflyer.internal.n;
import com.appsflyer.share.LinkGenerator;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class CreateOneLinkHttpTask extends an {
    public ResponseListener AFKeystoreWrapper;
    public final Map<String, String> AFLogger$LogLevel;
    public String getLevel = "";
    public final String init;
    public String values;

    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask(String str, Map<String, String> map, ac acVar, Context context) {
        super(acVar, context, RNCWebViewManager.HTTP_METHOD_POST);
        if (context != null) {
            this.getLevel = context.getPackageName();
        } else {
            AFLogger.AppsFlyer2dXConversionCallback("CreateOneLinkHttpTask: context can't be null");
        }
        this.AFInAppEventParameterName = str;
        this.init = "-1";
        this.AFLogger$LogLevel = map;
    }

    public final void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection) throws IOException {
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", this.init);
        hashMap.put("uuid", this.AppsFlyer2dXConversionCallback);
        hashMap.put("data", this.AFLogger$LogLevel);
        hashMap.put("meta", this.AFVersionDeclaration);
        String str = this.values;
        if (str != null) {
            hashMap.put("brand_domain", str);
        }
        String jSONObject = n.AFInAppEventType(hashMap).toString();
        AFKeystoreWrapper(httpsURLConnection, this.valueOf, jSONObject);
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(jSONObject);
        dataOutputStream.flush();
        dataOutputStream.close();
        httpsURLConnection.connect();
    }

    public final void valueOf(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                this.AFKeystoreWrapper.onResponse(jSONObject.optString(keys.next()));
            }
        } catch (JSONException e2) {
            this.AFKeystoreWrapper.onResponseError("Can't parse one link data");
            AFLogger.valueOf("Error while parsing to json ".concat(String.valueOf(str)), e2);
        }
    }

    public final String values() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(an.AFInAppEventType, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()}));
        sb.append("/");
        sb.append(this.AFInAppEventParameterName);
        return sb.toString();
    }

    public final void valueOf() {
        LinkGenerator addParameters = new LinkGenerator("af_app_invites").setBaseURL(this.AFInAppEventParameterName, AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN), this.getLevel).addParameter("af_siteid", this.getLevel).addParameters(this.AFLogger$LogLevel);
        ac.AFInAppEventParameterName();
        String AFInAppEventType = ac.AFInAppEventType();
        if (AFInAppEventType != null) {
            addParameters.setReferrerCustomerId(AFInAppEventType);
        }
        this.AFKeystoreWrapper.onResponse(addParameters.generateLink());
    }
}
