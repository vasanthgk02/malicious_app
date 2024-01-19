package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMap;

/* renamed from: p  reason: default package */
public class p {
    public Bundle a(Uri uri, String[] strArr) throws AuthError {
        Bundle bundle = new Bundle();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("response=");
        outline73.append(uri.toString());
        cp.a((String) "p", (String) "Received response from WebBroswer for OAuth2 flow", outline73.toString());
        bundle.putString("responseUrl", Base64.encodeToString(uri.toString().getBytes(), 0));
        String queryParameter = uri.getQueryParameter("code");
        bundle.putString("code", queryParameter);
        cp.a((String) "p", (String) "Code extracted from response", "code=" + queryParameter);
        String queryParameter2 = uri.getQueryParameter("error");
        if (!TextUtils.isEmpty(queryParameter2)) {
            String queryParameter3 = uri.getQueryParameter("error_description");
            if (!"access_denied".equals(queryParameter2) || TextUtils.isEmpty(queryParameter3) || (!"Access not permitted.".equals(queryParameter3) && !"Access+not+permitted.".equals(queryParameter3))) {
                ERROR_TYPE error_type = ERROR_TYPE.ERROR_SERVER_REPSONSE;
                if ("invalid_atn_token".equals(queryParameter2)) {
                    error_type = ERROR_TYPE.ERROR_INVALID_TOKEN;
                }
                throw new AuthError(GeneratedOutlineSupport.outline53("Error=", queryParameter2, " error_description=", queryParameter3), error_type);
            }
            bundle.putInt(ch$b.CAUSE_ID.f89a, 0);
            bundle.putString(ch$b.ON_CANCEL_TYPE.f89a, queryParameter2);
            bundle.putString(ch$b.ON_CANCEL_DESCRIPTION.f89a, queryParameter3);
            return bundle;
        } else if (!TextUtils.isEmpty(queryParameter)) {
            String queryParameter4 = uri.getQueryParameter("scope");
            String queryParameter5 = uri.getQueryParameter("state");
            if (queryParameter5 != null) {
                HashMap hashMap = new HashMap();
                for (String split : TextUtils.split(queryParameter5, "&")) {
                    String[] split2 = TextUtils.split(split, InflateView.SETTER_EQUALS);
                    if (split2 != null && split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
                bundle.putString(PaymentConstants.CLIENT_ID_CAMEL, (String) hashMap.get(PaymentConstants.CLIENT_ID_CAMEL));
                bundle.putString("redirectUri", (String) hashMap.get("redirectUri"));
                bundle.putBoolean(ch$b.GET_AUTH_CODE.f89a, Boolean.valueOf((String) hashMap.get(ch$b.GET_AUTH_CODE.f89a)).booleanValue());
                if (queryParameter4 != null) {
                    String str = CMap.SPACE;
                    if (!queryParameter4.contains(str)) {
                        str = "\\+";
                    }
                    bundle.putStringArray("scope", TextUtils.split(queryParameter4, str));
                } else {
                    bundle.putStringArray("scope", strArr);
                }
                return bundle;
            }
            throw new AuthError(String.format("Response does not have a state parameter: %s", new Object[]{uri.toString()}), ERROR_TYPE.ERROR_SERVER_REPSONSE);
        } else {
            throw new AuthError("No code in OAuth2 response", ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
    }
}
