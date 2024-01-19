package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PayPalUAT extends Authorization {
    public static final Creator<PayPalUAT> CREATOR = new Creator<PayPalUAT>() {
        public Object createFromParcel(Parcel parcel) {
            return new PayPalUAT(parcel);
        }

        public Object[] newArray(int i) {
            return new PayPalUAT[i];
        }
    };
    public String mBraintreeMerchantID;
    public String mConfigUrl;
    public Environment mEnvironment;
    public String mPayPalUrl;
    public String mToken;

    public enum Environment {
        STAGING,
        SANDBOX,
        PRODUCTION
    }

    public PayPalUAT(String str) throws InvalidArgumentException {
        super(str);
        this.mToken = str;
        try {
            JSONObject jSONObject = new JSONObject(decodeUATString(str));
            JSONArray jSONArray = jSONObject.getJSONArray("external_id");
            int i = 0;
            while (true) {
                if (i >= jSONArray.length()) {
                    break;
                } else if (jSONArray.getString(i).startsWith("Braintree:")) {
                    this.mBraintreeMerchantID = jSONArray.getString(i).split(":")[1];
                    break;
                } else {
                    i++;
                }
            }
            if (TextUtils.isEmpty(this.mBraintreeMerchantID)) {
                throw new IllegalArgumentException("Missing Braintree merchant account ID.");
            } else if (jSONObject.has("iss")) {
                this.mPayPalUrl = jSONObject.getString("iss");
                this.mEnvironment = determineIssuerEnv();
                this.mConfigUrl = generateConfigUrl();
            } else {
                throw new IllegalArgumentException("Does not contain issuer, or \"iss\" key.");
            }
        } catch (IllegalArgumentException | NullPointerException | JSONException e2) {
            throw new InvalidArgumentException(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("PayPal UAT invalid: ")));
        }
    }

    public final String decodeUATString(String str) {
        return new String(Base64.decode(str.split("[.]")[1], 0));
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.braintreepayments.api.models.PayPalUAT.Environment determineIssuerEnv() throws java.lang.IllegalArgumentException {
        /*
            r5 = this;
            java.lang.String r0 = r5.mPayPalUrl
            int r1 = r0.hashCode()
            r2 = -1750115095(0xffffffff97af5ce9, float:-1.1332564E-24)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002c
            r2 = 823203617(0x31111721, float:2.1113424E-9)
            if (r1 == r2) goto L_0x0022
            r2 = 1731655536(0x6736f770, float:8.640351E23)
            if (r1 == r2) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r1 = "https://api.sandbox.paypal.com"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0022:
            java.lang.String r1 = "https://api.msmaster.qa.paypal.com"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 2
            goto L_0x0037
        L_0x002c:
            java.lang.String r1 = "https://api.paypal.com"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x0036:
            r0 = -1
        L_0x0037:
            if (r0 == 0) goto L_0x0058
            if (r0 == r4) goto L_0x0055
            if (r0 != r3) goto L_0x0040
            com.braintreepayments.api.models.PayPalUAT$Environment r0 = com.braintreepayments.api.models.PayPalUAT.Environment.STAGING
            return r0
        L_0x0040:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "PayPal issuer URL missing or unknown: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = r5.mPayPalUrl
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0055:
            com.braintreepayments.api.models.PayPalUAT$Environment r0 = com.braintreepayments.api.models.PayPalUAT.Environment.SANDBOX
            return r0
        L_0x0058:
            com.braintreepayments.api.models.PayPalUAT$Environment r0 = com.braintreepayments.api.models.PayPalUAT.Environment.PRODUCTION
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.models.PayPalUAT.determineIssuerEnv():com.braintreepayments.api.models.PayPalUAT$Environment");
    }

    public final String generateConfigUrl() {
        Environment environment = this.mEnvironment;
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73((environment == Environment.STAGING || environment == Environment.SANDBOX) ? "https://api.sandbox.braintreegateway.com:443/merchants/" : "https://api.braintreegateway.com:443/merchants/"), this.mBraintreeMerchantID, "/client_api/v1/configuration");
    }

    public String getBearer() {
        return this.mToken;
    }

    public String getConfigUrl() {
        return this.mConfigUrl;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRawValue);
        parcel.writeString(this.mConfigUrl);
        parcel.writeString(this.mPayPalUrl);
        parcel.writeString(this.mToken);
        parcel.writeString(this.mBraintreeMerchantID);
    }

    public PayPalUAT(Parcel parcel) {
        super(parcel);
        this.mConfigUrl = parcel.readString();
        this.mPayPalUrl = parcel.readString();
        this.mToken = parcel.readString();
        this.mBraintreeMerchantID = parcel.readString();
    }
}
