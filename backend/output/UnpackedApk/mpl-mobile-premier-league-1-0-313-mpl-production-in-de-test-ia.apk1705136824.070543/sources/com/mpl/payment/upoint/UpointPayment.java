package com.mpl.payment.upoint;

import android.util.Log;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import java.util.ArrayList;
import org.json.JSONObject;

public class UpointPayment {
    public static String PAYMENT_TYPE_TELKOMSEL = "telkomsel";
    public String TAG = "UpointPayment";
    public String clientKey;
    public String paymentType;
    public String phoneNumber;
    public String token;
    public UpointResultListener upointResultListener;

    public UpointPayment(String str, String str2, String str3, String str4, UpointResultListener upointResultListener2) {
        this.phoneNumber = str;
        this.clientKey = str2;
        this.token = str3;
        this.paymentType = str4;
        this.upointResultListener = upointResultListener2;
    }

    public void doUpointPayment() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payment_type", this.paymentType);
            if (this.paymentType.equalsIgnoreCase(PAYMENT_TYPE_TELKOMSEL)) {
                jSONObject.put("telkomsel", new JSONObject("{\"phone_number\":\"" + this.phoneNumber + "\"}"));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("X-Client-Key", this.clientKey));
            Builder builder = new Builder();
            MClient.executeAsync(builder.setUrl("https://payment.upoint.co.id/common/v1/transaction/" + this.token + "/pay").setHeaders(arrayList).setRetryOnConnectionFailure(true).setPostJsonObject(jSONObject.toString()).setResponseListener(new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    StringBuilder sb = new StringBuilder("onResponseFail: ");
                    if (exc != null) {
                        sb.append(exc.getMessage());
                        sb.append(Log.getStackTraceString(exc));
                    }
                    UpointPayment.this.upointResultListener.onUpointPaymentFailed(exc);
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    UpointPayment.this.upointResultListener.onUpointPaymentSuccess(str);
                }
            }).build());
        } catch (Exception e2) {
            this.upointResultListener.onUpointPaymentFailed(e2);
        }
    }
}
