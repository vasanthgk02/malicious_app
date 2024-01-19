package com.mpl.payment.paytm.autodebit;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import org.json.JSONException;
import org.json.JSONObject;

public class AutoDebitVerification {
    public static final String TAG = "AutoDebitVerification";

    public static void getOtp() {
        MClient.executeAsync(new Builder().setResponseListener(new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                try {
                    AutoDebitVerification.validateOtp("489871", new JSONObject(str).optString("state"));
                } catch (JSONException unused) {
                }
            }
        }).setPostJsonObject("\n                                            { \n                                                \"email\":\"\",\n                                                \"phone\":\"9606622168\",\n                                                \"clientId\":\"merchant-galactus-staging\",\n                                                \"scope\":\"wallet\",\n                                                \"responseType\":\"token\"\n                                            }").setUrl("https://accounts-uat.paytm.com/signin/otp").build());
    }

    public static void validateOtp(String str, String str2) {
        MClient.executeAsync(new Builder().setResponseListener(new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
            }

            public void onResponseSuccess(String str) {
            }

            public void progressResponse(long j, long j2, boolean z) {
            }
        }).addHeader(new MHeader("Authorization", Base64.encodeToString("thSAtomQEZp4pUxX934YyDpeEtxhTIUZ".getBytes(), 0))).setPostJsonObject(GeneratedOutlineSupport.outline54("{ \n                                            \"otp\":\"", str, "\",\n                                            \"state\":\"", str2, "\"\n                                            }        ")).setUrl("https://accounts-uat.paytm.com/signin/validate/otp").build());
    }

    public static void verifyAccessToken() {
    }
}
