package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.ShippingAddressRequirements;
import com.google.android.gms.wallet.TransactionInfo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class GooglePaymentRequest implements Parcelable {
    public static final Creator<GooglePaymentRequest> CREATOR = new Creator<GooglePaymentRequest>() {
        public Object createFromParcel(Parcel parcel) {
            return new GooglePaymentRequest(parcel);
        }

        public Object[] newArray(int i) {
            return new GooglePaymentRequest[i];
        }
    };
    public Boolean mAllowPrepaidCards;
    public HashMap<String, JSONArray> mAllowedAuthMethods;
    public HashMap<String, JSONArray> mAllowedCardNetworks;
    public HashMap<String, JSONObject> mAllowedPaymentMethods;
    public Integer mBillingAddressFormat;
    public Boolean mBillingAddressRequired;
    public Boolean mEmailRequired;
    public String mEnvironment;
    public String mGoogleMerchantId;
    public String mGoogleMerchantName;
    public boolean mPayPalEnabled;
    public Boolean mPhoneNumberRequired;
    public Boolean mShippingAddressRequired;
    public ShippingAddressRequirements mShippingAddressRequirements;
    public HashMap<String, JSONObject> mTokenizationSpecifications;
    public TransactionInfo mTransactionInfo;

    public GooglePaymentRequest() {
        this.mEmailRequired = null;
        this.mPhoneNumberRequired = null;
        this.mBillingAddressRequired = null;
        this.mShippingAddressRequired = null;
        this.mAllowPrepaidCards = null;
        this.mPayPalEnabled = true;
        this.mAllowedPaymentMethods = new HashMap<>();
        this.mTokenizationSpecifications = new HashMap<>();
        this.mAllowedAuthMethods = new HashMap<>();
        this.mAllowedCardNetworks = new HashMap<>();
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(4:2|(3:6|7|8)|9|10)|11|12|13|(8:17|18|19|(5:21|22|23|24|(3:26|(1:31)(1:30)|32))|33|54|52|15)|53|35|(5:36|37|(1:39)|40|(1:42))|43|45|46|(1:48)|49|51) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:2|(3:6|7|8)|9|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:21|22|23|24|(3:26|(1:31)(1:30)|32)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0041 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00ad */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c8 A[Catch:{ JSONException -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0101 A[Catch:{ JSONException -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0110 A[Catch:{ JSONException -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x015b A[Catch:{ JSONException -> 0x0160 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toJson() {
        /*
            r13 = this;
            java.lang.String r0 = "billingAddressParameters"
            java.lang.String r1 = "parameters"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            com.google.android.gms.wallet.TransactionInfo r3 = r13.mTransactionInfo
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            java.lang.Boolean r6 = r13.mShippingAddressRequired
            boolean r6 = r6.booleanValue()
            java.lang.String r7 = "phoneNumberRequired"
            if (r6 == 0) goto L_0x0041
            com.google.android.gms.wallet.ShippingAddressRequirements r6 = r13.mShippingAddressRequirements
            java.util.ArrayList r6 = r6.getAllowedCountryCodes()
            if (r6 == 0) goto L_0x003c
            int r8 = r6.size()
            if (r8 <= 0) goto L_0x003c
            java.lang.String r8 = "allowedCountryCodes"
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x003c }
            r9.<init>(r6)     // Catch:{ JSONException -> 0x003c }
            r5.put(r8, r9)     // Catch:{ JSONException -> 0x003c }
        L_0x003c:
            java.lang.Boolean r6 = r13.mPhoneNumberRequired     // Catch:{ JSONException -> 0x0041 }
            r5.put(r7, r6)     // Catch:{ JSONException -> 0x0041 }
        L_0x0041:
            java.lang.String r6 = r13.totalPriceStatusToString()     // Catch:{ JSONException -> 0x005e }
            java.lang.String r8 = "totalPriceStatus"
            org.json.JSONObject r6 = r2.put(r8, r6)     // Catch:{ JSONException -> 0x005e }
            java.lang.String r8 = "totalPrice"
            java.lang.String r9 = r3.getTotalPrice()     // Catch:{ JSONException -> 0x005e }
            org.json.JSONObject r6 = r6.put(r8, r9)     // Catch:{ JSONException -> 0x005e }
            java.lang.String r8 = "currencyCode"
            java.lang.String r3 = r3.getCurrencyCode()     // Catch:{ JSONException -> 0x005e }
            r6.put(r8, r3)     // Catch:{ JSONException -> 0x005e }
        L_0x005e:
            java.util.HashMap<java.lang.String, org.json.JSONObject> r3 = r13.mAllowedPaymentMethods
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0068:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00f4
            java.lang.Object r6 = r3.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f1 }
            r8.<init>()     // Catch:{ JSONException -> 0x00f1 }
            java.lang.String r9 = "type"
            java.lang.Object r10 = r6.getKey()     // Catch:{ JSONException -> 0x00f1 }
            org.json.JSONObject r8 = r8.put(r9, r10)     // Catch:{ JSONException -> 0x00f1 }
            java.lang.Object r9 = r6.getValue()     // Catch:{ JSONException -> 0x00f1 }
            org.json.JSONObject r8 = r8.put(r1, r9)     // Catch:{ JSONException -> 0x00f1 }
            java.lang.String r9 = "tokenizationSpecification"
            java.util.HashMap<java.lang.String, org.json.JSONObject> r10 = r13.mTokenizationSpecifications     // Catch:{ JSONException -> 0x00f1 }
            java.lang.Object r11 = r6.getKey()     // Catch:{ JSONException -> 0x00f1 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ JSONException -> 0x00f1 }
            org.json.JSONObject r8 = r8.put(r9, r10)     // Catch:{ JSONException -> 0x00f1 }
            java.lang.Object r9 = r6.getKey()     // Catch:{ JSONException -> 0x00f1 }
            java.lang.String r10 = "CARD"
            if (r9 != r10) goto L_0x00ec
            java.lang.Object r6 = r6.getValue()     // Catch:{ JSONException -> 0x00ad }
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x00ad }
            r6.get(r0)     // Catch:{ JSONException -> 0x00ad }
            goto L_0x00ec
        L_0x00ad:
            org.json.JSONObject r6 = r8.getJSONObject(r1)     // Catch:{ JSONException -> 0x00f1 }
            java.lang.String r9 = "billingAddressRequired"
            java.lang.Boolean r10 = r13.mBillingAddressRequired     // Catch:{ JSONException -> 0x00f1 }
            org.json.JSONObject r9 = r6.put(r9, r10)     // Catch:{ JSONException -> 0x00f1 }
            java.lang.String r10 = "allowPrepaidCards"
            java.lang.Boolean r11 = r13.mAllowPrepaidCards     // Catch:{ JSONException -> 0x00f1 }
            r9.put(r10, r11)     // Catch:{ JSONException -> 0x00f1 }
            java.lang.Boolean r9 = r13.mBillingAddressRequired     // Catch:{ JSONException -> 0x00f1 }
            boolean r9 = r9.booleanValue()     // Catch:{ JSONException -> 0x00f1 }
            if (r9 == 0) goto L_0x00ec
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f1 }
            r9.<init>()     // Catch:{ JSONException -> 0x00f1 }
            java.lang.String r10 = "format"
            java.lang.Integer r11 = r13.mBillingAddressFormat     // Catch:{ JSONException -> 0x00f1 }
            if (r11 == 0) goto L_0x00dd
            int r11 = r11.intValue()     // Catch:{ JSONException -> 0x00f1 }
            r12 = 1
            if (r11 != r12) goto L_0x00dd
            java.lang.String r11 = "FULL"
            goto L_0x00df
        L_0x00dd:
            java.lang.String r11 = "MIN"
        L_0x00df:
            org.json.JSONObject r9 = r9.put(r10, r11)     // Catch:{ JSONException -> 0x00f1 }
            java.lang.Boolean r10 = r13.mPhoneNumberRequired     // Catch:{ JSONException -> 0x00f1 }
            org.json.JSONObject r9 = r9.put(r7, r10)     // Catch:{ JSONException -> 0x00f1 }
            r6.put(r0, r9)     // Catch:{ JSONException -> 0x00f1 }
        L_0x00ec:
            r4.put(r8)     // Catch:{ JSONException -> 0x00f1 }
            goto L_0x0068
        L_0x00f1:
            goto L_0x0068
        L_0x00f4:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r13.mGoogleMerchantId     // Catch:{ JSONException -> 0x0117 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0117 }
            if (r1 != 0) goto L_0x0108
            java.lang.String r1 = "merchantId"
            java.lang.String r3 = r13.mGoogleMerchantId     // Catch:{ JSONException -> 0x0117 }
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0117 }
        L_0x0108:
            java.lang.String r1 = r13.mGoogleMerchantName     // Catch:{ JSONException -> 0x0117 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0117 }
            if (r1 != 0) goto L_0x0117
            java.lang.String r1 = "merchantName"
            java.lang.String r3 = r13.mGoogleMerchantName     // Catch:{ JSONException -> 0x0117 }
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0117 }
        L_0x0117:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r3 = "apiVersion"
            r6 = 2
            org.json.JSONObject r3 = r1.put(r3, r6)     // Catch:{ JSONException -> 0x0160 }
            java.lang.String r6 = "apiVersionMinor"
            r7 = 0
            org.json.JSONObject r3 = r3.put(r6, r7)     // Catch:{ JSONException -> 0x0160 }
            java.lang.String r6 = "allowedPaymentMethods"
            org.json.JSONObject r3 = r3.put(r6, r4)     // Catch:{ JSONException -> 0x0160 }
            java.lang.String r4 = "emailRequired"
            java.lang.Boolean r6 = r13.mEmailRequired     // Catch:{ JSONException -> 0x0160 }
            org.json.JSONObject r3 = r3.put(r4, r6)     // Catch:{ JSONException -> 0x0160 }
            java.lang.String r4 = "shippingAddressRequired"
            java.lang.Boolean r6 = r13.mShippingAddressRequired     // Catch:{ JSONException -> 0x0160 }
            org.json.JSONObject r3 = r3.put(r4, r6)     // Catch:{ JSONException -> 0x0160 }
            java.lang.String r4 = "environment"
            java.lang.String r6 = r13.mEnvironment     // Catch:{ JSONException -> 0x0160 }
            org.json.JSONObject r3 = r3.put(r4, r6)     // Catch:{ JSONException -> 0x0160 }
            java.lang.String r4 = "merchantInfo"
            org.json.JSONObject r0 = r3.put(r4, r0)     // Catch:{ JSONException -> 0x0160 }
            java.lang.String r3 = "transactionInfo"
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x0160 }
            java.lang.Boolean r0 = r13.mShippingAddressRequired     // Catch:{ JSONException -> 0x0160 }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x0160 }
            if (r0 == 0) goto L_0x0160
            java.lang.String r0 = "shippingAddressParameters"
            r1.put(r0, r5)     // Catch:{ JSONException -> 0x0160 }
        L_0x0160:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.models.GooglePaymentRequest.toJson():java.lang.String");
    }

    public final String totalPriceStatusToString() {
        int totalPriceStatus = this.mTransactionInfo.getTotalPriceStatus();
        if (totalPriceStatus != 1) {
            return totalPriceStatus != 2 ? "FINAL" : "ESTIMATED";
        }
        return "NOT_CURRENTLY_KNOWN";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mTransactionInfo, i);
        Boolean bool = this.mEmailRequired;
        int i2 = 2;
        parcel.writeByte((byte) (bool == null ? 0 : bool.booleanValue() ? 1 : 2));
        Boolean bool2 = this.mPhoneNumberRequired;
        parcel.writeByte((byte) (bool2 == null ? 0 : bool2.booleanValue() ? 1 : 2));
        Boolean bool3 = this.mBillingAddressRequired;
        parcel.writeByte((byte) (bool3 == null ? 0 : bool3.booleanValue() ? 1 : 2));
        if (this.mBillingAddressFormat == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeInt(this.mBillingAddressFormat.intValue());
        }
        Boolean bool4 = this.mShippingAddressRequired;
        parcel.writeByte((byte) (bool4 == null ? 0 : bool4.booleanValue() ? 1 : 2));
        parcel.writeParcelable(this.mShippingAddressRequirements, i);
        Boolean bool5 = this.mAllowPrepaidCards;
        if (bool5 == null) {
            i2 = 0;
        } else if (bool5.booleanValue()) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.mEnvironment);
        parcel.writeString(this.mGoogleMerchantId);
        parcel.writeString(this.mGoogleMerchantName);
    }

    public GooglePaymentRequest(Parcel parcel) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5 = null;
        this.mEmailRequired = null;
        this.mPhoneNumberRequired = null;
        this.mBillingAddressRequired = null;
        this.mShippingAddressRequired = null;
        this.mAllowPrepaidCards = null;
        boolean z = true;
        this.mPayPalEnabled = true;
        this.mAllowedPaymentMethods = new HashMap<>();
        this.mTokenizationSpecifications = new HashMap<>();
        this.mAllowedAuthMethods = new HashMap<>();
        this.mAllowedCardNetworks = new HashMap<>();
        this.mTransactionInfo = parcel.readParcelable(TransactionInfo.class.getClassLoader());
        byte readByte = parcel.readByte();
        if (readByte == 0) {
            bool = null;
        } else {
            bool = Boolean.valueOf(readByte == 1);
        }
        this.mEmailRequired = bool;
        byte readByte2 = parcel.readByte();
        if (readByte2 == 0) {
            bool2 = null;
        } else {
            bool2 = Boolean.valueOf(readByte2 == 1);
        }
        this.mPhoneNumberRequired = bool2;
        byte readByte3 = parcel.readByte();
        if (readByte3 == 0) {
            bool3 = null;
        } else {
            bool3 = Boolean.valueOf(readByte3 == 1);
        }
        this.mBillingAddressRequired = bool3;
        if (parcel.readByte() == 0) {
            this.mBillingAddressFormat = null;
        } else {
            this.mBillingAddressFormat = Integer.valueOf(parcel.readInt());
        }
        byte readByte4 = parcel.readByte();
        if (readByte4 == 0) {
            bool4 = null;
        } else {
            bool4 = Boolean.valueOf(readByte4 == 1);
        }
        this.mShippingAddressRequired = bool4;
        this.mShippingAddressRequirements = parcel.readParcelable(ShippingAddressRequirements.class.getClassLoader());
        byte readByte5 = parcel.readByte();
        if (readByte5 != 0) {
            bool5 = Boolean.valueOf(readByte5 != 1 ? false : z);
        }
        this.mAllowPrepaidCards = bool5;
        this.mEnvironment = parcel.readString();
        this.mGoogleMerchantId = parcel.readString();
        this.mGoogleMerchantName = parcel.readString();
    }
}
