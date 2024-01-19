package com.braintreepayments.api.models;

import android.content.Context;
import android.os.Parcel;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.netcore.android.event.SMTEventType;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PaymentMethodBuilder<T> {
    public String mIntegration = SMTEventType.EVENT_TYPE_CUSTOM;
    public String mSessionId;
    public String mSource = "form";
    public boolean mValidate;
    public boolean mValidateSet;

    public PaymentMethodBuilder() {
    }

    public abstract void build(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException;

    /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|(2:25|26)(2:27|(1:29)(2:30|(1:32)))|33|34|36) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001d */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0040 A[SYNTHETIC, Splitter:B:25:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[Catch:{ JSONException -> 0x0069 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String buildGraphQL(android.content.Context r8, com.braintreepayments.api.models.Authorization r9) throws com.braintreepayments.api.exceptions.BraintreeException {
        /*
            r7 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "clientSdkMetadata"
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0069 }
            r4.<init>()     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r5 = "platform"
            java.lang.String r6 = "android"
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x001d }
        L_0x001d:
            java.lang.String r5 = r7.mSessionId     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r6 = "sessionId"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0024 }
        L_0x0024:
            java.lang.String r5 = r7.mSource     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r6 = "source"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x002b }
        L_0x002b:
            java.lang.String r5 = r7.mIntegration     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r6 = "integration"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0032 }
        L_0x0032:
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x0069 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0069 }
            r3.<init>()     // Catch:{ JSONException -> 0x0069 }
            boolean r4 = r7.mValidateSet     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r5 = "validate"
            if (r4 == 0) goto L_0x0046
            boolean r9 = r7.mValidate     // Catch:{ JSONException -> 0x0069 }
            r3.put(r5, r9)     // Catch:{ JSONException -> 0x0069 }
            goto L_0x0057
        L_0x0046:
            boolean r4 = r9 instanceof com.braintreepayments.api.models.ClientToken     // Catch:{ JSONException -> 0x0069 }
            if (r4 == 0) goto L_0x004f
            r9 = 1
            r3.put(r5, r9)     // Catch:{ JSONException -> 0x0069 }
            goto L_0x0057
        L_0x004f:
            boolean r9 = r9 instanceof com.braintreepayments.api.models.TokenizationKey     // Catch:{ JSONException -> 0x0069 }
            if (r9 == 0) goto L_0x0057
            r9 = 0
            r3.put(r5, r9)     // Catch:{ JSONException -> 0x0069 }
        L_0x0057:
            java.lang.String r9 = "options"
            r1.put(r9, r3)     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r9 = "input"
            r2.put(r9, r1)     // Catch:{ JSONException -> 0x0069 }
            r7.buildGraphQL(r8, r0, r2)     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r8 = "variables"
            r0.put(r8, r2)     // Catch:{ JSONException -> 0x0069 }
        L_0x0069:
            java.lang.String r8 = r0.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.models.PaymentMethodBuilder.buildGraphQL(android.content.Context, com.braintreepayments.api.models.Authorization):java.lang.String");
    }

    public abstract void buildGraphQL(Context context, JSONObject jSONObject, JSONObject jSONObject2) throws BraintreeException, JSONException;

    public abstract String getApiPath();

    public abstract String getResponsePaymentMethodType();

    public PaymentMethodBuilder(Parcel parcel) {
        this.mIntegration = parcel.readString();
        this.mSource = parcel.readString();
        boolean z = false;
        this.mValidate = parcel.readByte() > 0;
        this.mValidateSet = parcel.readByte() > 0 ? true : z;
        this.mSessionId = parcel.readString();
    }
}
