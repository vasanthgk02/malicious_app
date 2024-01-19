package com.cardinalcommerce.cardinalmobilesdk.models;

import co.hyperverge.hypersnapsdk.c.k;
import com.cardinalcommerce.cardinalmobilesdk.a.a.c;
import java.io.Serializable;
import org.json.JSONObject;

public class ValidateResponse implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public CardinalActionCode f1900c;

    /* renamed from: e  reason: collision with root package name */
    public String f1901e;

    public ValidateResponse(String str) {
        String optString = new JSONObject(k.a(str)).optString("Payload", "");
        if (!optString.isEmpty()) {
            JSONObject jSONObject = new JSONObject(optString);
            String optString2 = jSONObject.optString("Payment", "");
            jSONObject.optBoolean("Validated", false);
            if (!optString2.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject(optString2);
                jSONObject2.optString("Type", "");
                jSONObject2.optString("ProcessorTransactionId", "");
                String optString3 = jSONObject2.optString("ExtendedData", "");
                if (optString3 != null && !optString3.isEmpty()) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    jSONObject3.optString("CAVV", "");
                    jSONObject3.optString("ECIFlag", "");
                    jSONObject3.optString("XID", "");
                    jSONObject3.optString("PAResStatus", "");
                    jSONObject3.optString("SignatureVerification", "");
                    jSONObject3.optString("Enrolled", "");
                }
            }
            this.f1900c = CardinalActionCode.getActionCode(jSONObject.optString("ActionCode", ""));
            jSONObject.optInt("ErrorNumber", 0);
            this.f1901e = jSONObject.optString("ErrorDescription", "");
        }
    }

    public ValidateResponse(boolean z, CardinalActionCode cardinalActionCode, c cVar) {
        this.f1900c = cardinalActionCode;
        int i = cVar.f1853a;
        this.f1901e = cVar.f1854b;
    }
}
