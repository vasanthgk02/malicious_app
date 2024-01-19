package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.models.GooglePaymentRequest;

public final class GooglePayment$3 implements ConfigurationListener {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ GooglePaymentRequest val$request;

    public GooglePayment$3(BraintreeFragment braintreeFragment, GooglePaymentRequest googlePaymentRequest) {
        this.val$fragment = braintreeFragment;
        this.val$request = googlePaymentRequest;
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0224  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationFetched(com.braintreepayments.api.models.Configuration r32) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            com.braintreepayments.api.models.GooglePaymentConfiguration r2 = r1.mGooglePaymentConfiguration
            com.braintreepayments.api.BraintreeFragment r3 = r0.val$fragment
            android.content.Context r3 = r3.mContext
            boolean r2 = r2.isEnabled(r3)
            if (r2 != 0) goto L_0x0022
            com.braintreepayments.api.BraintreeFragment r1 = r0.val$fragment
            com.braintreepayments.api.exceptions.BraintreeException r2 = new com.braintreepayments.api.exceptions.BraintreeException
            java.lang.String r3 = "Google Pay enabled is not enabled for your Braintree account, or Google Play Services are not configured correctly."
            r2.<init>(r3)
            com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
            r3.<init>(r2)
            r1.postOrQueueCallback(r3)
            return
        L_0x0022:
            com.braintreepayments.api.BraintreeFragment r2 = r0.val$fragment
            com.braintreepayments.api.models.GooglePaymentRequest r3 = r0.val$request
            java.lang.Boolean r4 = r3.mEmailRequired
            if (r4 != 0) goto L_0x002e
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r3.mEmailRequired = r4
        L_0x002e:
            java.lang.Boolean r4 = r3.mPhoneNumberRequired
            if (r4 != 0) goto L_0x0036
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r3.mPhoneNumberRequired = r4
        L_0x0036:
            java.lang.Boolean r4 = r3.mBillingAddressRequired
            if (r4 != 0) goto L_0x003e
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r3.mBillingAddressRequired = r4
        L_0x003e:
            java.lang.Boolean r4 = r3.mBillingAddressRequired
            boolean r4 = r4.booleanValue()
            r5 = 0
            if (r4 == 0) goto L_0x0051
            java.lang.Integer r4 = r3.mBillingAddressFormat
            if (r4 != 0) goto L_0x0051
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r3.mBillingAddressFormat = r4
        L_0x0051:
            java.lang.Boolean r4 = r3.mShippingAddressRequired
            if (r4 != 0) goto L_0x0059
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r3.mShippingAddressRequired = r4
        L_0x0059:
            java.lang.Boolean r4 = r3.mAllowPrepaidCards
            if (r4 != 0) goto L_0x0061
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r3.mAllowPrepaidCards = r4
        L_0x0061:
            java.util.HashMap<java.lang.String, org.json.JSONObject> r4 = r3.mAllowedPaymentMethods
            java.lang.String r6 = "CARD"
            java.lang.Object r4 = r4.get(r6)
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            r7 = 1
            if (r4 != 0) goto L_0x0113
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.util.HashMap<java.lang.String, org.json.JSONArray> r8 = r3.mAllowedCardNetworks     // Catch:{ JSONException -> 0x010e }
            java.lang.Object r8 = r8.get(r6)     // Catch:{ JSONException -> 0x010e }
            org.json.JSONArray r8 = (org.json.JSONArray) r8     // Catch:{ JSONException -> 0x010e }
            if (r8 != 0) goto L_0x00b4
            org.json.JSONArray r8 = co.hyperverge.hypersnapsdk.c.k.buildCardNetworks(r2)     // Catch:{ JSONException -> 0x010e }
            java.util.HashMap<java.lang.String, org.json.JSONArray> r9 = r3.mAllowedAuthMethods     // Catch:{ JSONException -> 0x010e }
            java.lang.Object r9 = r9.get(r6)     // Catch:{ JSONException -> 0x010e }
            org.json.JSONArray r9 = (org.json.JSONArray) r9     // Catch:{ JSONException -> 0x010e }
            if (r9 != 0) goto L_0x00a2
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x010e }
            r9.<init>()     // Catch:{ JSONException -> 0x010e }
            java.lang.String r10 = "PAN_ONLY"
            org.json.JSONArray r9 = r9.put(r10)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r10 = "CRYPTOGRAM_3DS"
            org.json.JSONArray r9 = r9.put(r10)     // Catch:{ JSONException -> 0x010e }
            java.util.HashMap<java.lang.String, org.json.JSONArray> r10 = r3.mAllowedAuthMethods     // Catch:{ JSONException -> 0x010e }
            r10.put(r6, r9)     // Catch:{ JSONException -> 0x010e }
            goto L_0x00af
        L_0x00a2:
            java.util.HashMap<java.lang.String, org.json.JSONArray> r9 = r3.mAllowedAuthMethods     // Catch:{ JSONException -> 0x010e }
            java.lang.Object r9 = r9.get(r6)     // Catch:{ JSONException -> 0x010e }
            org.json.JSONArray r9 = (org.json.JSONArray) r9     // Catch:{ JSONException -> 0x010e }
            java.util.HashMap<java.lang.String, org.json.JSONArray> r10 = r3.mAllowedAuthMethods     // Catch:{ JSONException -> 0x010e }
            r10.put(r6, r9)     // Catch:{ JSONException -> 0x010e }
        L_0x00af:
            java.util.HashMap<java.lang.String, org.json.JSONArray> r9 = r3.mAllowedCardNetworks     // Catch:{ JSONException -> 0x010e }
            r9.put(r6, r8)     // Catch:{ JSONException -> 0x010e }
        L_0x00b4:
            java.lang.String r8 = "billingAddressRequired"
            java.lang.Boolean r9 = r3.mBillingAddressRequired     // Catch:{ JSONException -> 0x010e }
            org.json.JSONObject r8 = r4.put(r8, r9)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r9 = "allowPrepaidCards"
            java.lang.Boolean r10 = r3.mAllowPrepaidCards     // Catch:{ JSONException -> 0x010e }
            org.json.JSONObject r8 = r8.put(r9, r10)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r9 = "allowedAuthMethods"
            java.util.HashMap<java.lang.String, org.json.JSONArray> r10 = r3.mAllowedAuthMethods     // Catch:{ JSONException -> 0x010e }
            java.lang.Object r10 = r10.get(r6)     // Catch:{ JSONException -> 0x010e }
            org.json.JSONArray r10 = (org.json.JSONArray) r10     // Catch:{ JSONException -> 0x010e }
            org.json.JSONObject r8 = r8.put(r9, r10)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r9 = "allowedCardNetworks"
            java.util.HashMap<java.lang.String, org.json.JSONArray> r10 = r3.mAllowedCardNetworks     // Catch:{ JSONException -> 0x010e }
            java.lang.Object r10 = r10.get(r6)     // Catch:{ JSONException -> 0x010e }
            org.json.JSONArray r10 = (org.json.JSONArray) r10     // Catch:{ JSONException -> 0x010e }
            r8.put(r9, r10)     // Catch:{ JSONException -> 0x010e }
            java.lang.Boolean r8 = r3.mBillingAddressRequired     // Catch:{ JSONException -> 0x010e }
            boolean r8 = r8.booleanValue()     // Catch:{ JSONException -> 0x010e }
            if (r8 == 0) goto L_0x010e
            java.lang.String r8 = "billingAddressParameters"
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x010e }
            r9.<init>()     // Catch:{ JSONException -> 0x010e }
            java.lang.String r10 = "format"
            java.lang.Integer r11 = r3.mBillingAddressFormat     // Catch:{ JSONException -> 0x010e }
            if (r11 == 0) goto L_0x00fd
            int r11 = r11.intValue()     // Catch:{ JSONException -> 0x010e }
            if (r11 != r7) goto L_0x00fd
            java.lang.String r11 = "FULL"
            goto L_0x00ff
        L_0x00fd:
            java.lang.String r11 = "MIN"
        L_0x00ff:
            org.json.JSONObject r9 = r9.put(r10, r11)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r10 = "phoneNumberRequired"
            java.lang.Boolean r11 = r3.mPhoneNumberRequired     // Catch:{ JSONException -> 0x010e }
            org.json.JSONObject r9 = r9.put(r10, r11)     // Catch:{ JSONException -> 0x010e }
            r4.put(r8, r9)     // Catch:{ JSONException -> 0x010e }
        L_0x010e:
            java.util.HashMap<java.lang.String, org.json.JSONObject> r8 = r3.mAllowedPaymentMethods
            r8.put(r6, r4)
        L_0x0113:
            java.util.HashMap<java.lang.String, org.json.JSONObject> r4 = r3.mTokenizationSpecifications
            java.lang.Object r4 = r4.get(r6)
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r8 = "android"
            java.lang.String r9 = "platform"
            java.lang.String r10 = "version"
            java.lang.String r11 = "sessionId"
            java.lang.String r12 = "integration"
            java.lang.String r13 = "client"
            java.lang.String r14 = "source"
            java.lang.String r15 = "braintree:metadata"
            java.lang.String r5 = "braintree:merchantId"
            java.lang.String r7 = "braintree:sdkVersion"
            java.lang.String r0 = "parameters"
            java.lang.String r1 = "v1"
            r17 = r6
            java.lang.String r6 = "braintree:apiVersion"
            r18 = r3
            java.lang.String r3 = "PAYMENT_GATEWAY"
            r19 = r0
            java.lang.String r0 = "type"
            r20 = r0
            java.lang.String r0 = "braintree"
            r21 = r3
            java.lang.String r3 = "gateway"
            r22 = r15
            java.lang.String r15 = "3.3.1"
            if (r4 != 0) goto L_0x01ed
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r23 = r4
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r24 = r8
            org.json.JSONObject r8 = r4.put(r3, r0)     // Catch:{ JSONException -> 0x01bd }
            org.json.JSONObject r8 = r8.put(r6, r1)     // Catch:{ JSONException -> 0x01bd }
            org.json.JSONObject r8 = r8.put(r7, r15)     // Catch:{ JSONException -> 0x01bd }
            r25 = r1
            com.braintreepayments.api.models.Configuration r1 = r2.mConfiguration     // Catch:{ JSONException -> 0x01bf }
            java.lang.String r1 = r1.mMerchantId     // Catch:{ JSONException -> 0x01bf }
            org.json.JSONObject r1 = r8.put(r5, r1)     // Catch:{ JSONException -> 0x01bf }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01bf }
            r8.<init>()     // Catch:{ JSONException -> 0x01bf }
            org.json.JSONObject r8 = r8.put(r14, r13)     // Catch:{ JSONException -> 0x01bf }
            r26 = r13
            java.lang.String r13 = r2.mIntegrationType     // Catch:{ JSONException -> 0x01c1 }
            org.json.JSONObject r8 = r8.put(r12, r13)     // Catch:{ JSONException -> 0x01c1 }
            java.lang.String r13 = r2.mSessionId     // Catch:{ JSONException -> 0x01c1 }
            org.json.JSONObject r8 = r8.put(r11, r13)     // Catch:{ JSONException -> 0x01c1 }
            org.json.JSONObject r8 = r8.put(r10, r15)     // Catch:{ JSONException -> 0x01c1 }
            r13 = r24
            org.json.JSONObject r8 = r8.put(r9, r13)     // Catch:{ JSONException -> 0x01c3 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x01c3 }
            r24 = r9
            r9 = r22
            r1.put(r9, r8)     // Catch:{ JSONException -> 0x01c7 }
            com.braintreepayments.api.models.Authorization r1 = r2.mAuthorization     // Catch:{ JSONException -> 0x01c7 }
            java.lang.String r1 = r1.mRawValue     // Catch:{ JSONException -> 0x01c7 }
            boolean r1 = com.braintreepayments.api.models.Authorization.isTokenizationKey(r1)     // Catch:{ JSONException -> 0x01c7 }
            if (r1 == 0) goto L_0x01b1
            java.lang.String r1 = "braintree:clientKey"
            com.braintreepayments.api.models.Authorization r8 = r2.mAuthorization     // Catch:{ JSONException -> 0x01c7 }
            java.lang.String r8 = r8.mRawValue     // Catch:{ JSONException -> 0x01c7 }
            r4.put(r1, r8)     // Catch:{ JSONException -> 0x01c7 }
            goto L_0x01c7
        L_0x01b1:
            java.lang.String r1 = "braintree:authorizationFingerprint"
            com.braintreepayments.api.models.Configuration r8 = r2.mConfiguration     // Catch:{ JSONException -> 0x01c7 }
            com.braintreepayments.api.models.GooglePaymentConfiguration r8 = r8.mGooglePaymentConfiguration     // Catch:{ JSONException -> 0x01c7 }
            java.lang.String r8 = r8.mGoogleAuthorizationFingerprint     // Catch:{ JSONException -> 0x01c7 }
            r4.put(r1, r8)     // Catch:{ JSONException -> 0x01c7 }
            goto L_0x01c7
        L_0x01bd:
            r25 = r1
        L_0x01bf:
            r26 = r13
        L_0x01c1:
            r13 = r24
        L_0x01c3:
            r24 = r9
            r9 = r22
        L_0x01c7:
            r22 = r9
            r8 = r20
            r1 = r21
            r9 = r23
            r20 = r13
            org.json.JSONObject r13 = r9.put(r8, r1)     // Catch:{ JSONException -> 0x01dd }
            r21 = r10
            r10 = r19
            r13.put(r10, r4)     // Catch:{ JSONException -> 0x01e1 }
            goto L_0x01e1
        L_0x01dd:
            r21 = r10
            r10 = r19
        L_0x01e1:
            r4 = r18
            java.util.HashMap<java.lang.String, org.json.JSONObject> r13 = r4.mTokenizationSpecifications
            r19 = r10
            r10 = r17
            r13.put(r10, r9)
            goto L_0x01ff
        L_0x01ed:
            r25 = r1
            r24 = r9
            r26 = r13
            r4 = r18
            r1 = r21
            r21 = r10
            r30 = r20
            r20 = r8
            r8 = r30
        L_0x01ff:
            boolean r9 = r4.mPayPalEnabled
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x021c
            r9 = r32
            r10 = r25
            com.braintreepayments.api.models.GooglePaymentConfiguration r13 = r9.mGooglePaymentConfiguration
            java.lang.String r13 = r13.mPayPalClientId
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x0220
            r16 = 1
            goto L_0x0222
        L_0x021c:
            r9 = r32
            r10 = r25
        L_0x0220:
            r16 = 0
        L_0x0222:
            if (r16 == 0) goto L_0x0343
            java.util.HashMap<java.lang.String, org.json.JSONObject> r13 = r4.mAllowedPaymentMethods
            java.lang.String r9 = "PAYPAL"
            java.lang.Object r13 = r13.get(r9)
            org.json.JSONObject r13 = (org.json.JSONObject) r13
            if (r13 != 0) goto L_0x02b2
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            r16 = r11
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02a1 }
            r11.<init>()     // Catch:{ JSONException -> 0x02a1 }
            r17 = r12
            java.lang.String r12 = "purchase_units"
            r18 = r14
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ JSONException -> 0x028f }
            r14.<init>()     // Catch:{ JSONException -> 0x028f }
            r23 = r5
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0291 }
            r5.<init>()     // Catch:{ JSONException -> 0x0291 }
            r25 = r7
            java.lang.String r7 = "payee"
            r27 = r15
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0283 }
            r15.<init>()     // Catch:{ JSONException -> 0x0283 }
            r28 = r6
            java.lang.String r6 = "client_id"
            r29 = r10
            com.braintreepayments.api.models.Configuration r10 = r2.mConfiguration     // Catch:{ JSONException -> 0x02ac }
            com.braintreepayments.api.models.GooglePaymentConfiguration r10 = r10.mGooglePaymentConfiguration     // Catch:{ JSONException -> 0x02ac }
            java.lang.String r10 = r10.mPayPalClientId     // Catch:{ JSONException -> 0x02ac }
            org.json.JSONObject r6 = r15.put(r6, r10)     // Catch:{ JSONException -> 0x02ac }
            org.json.JSONObject r5 = r5.put(r7, r6)     // Catch:{ JSONException -> 0x02ac }
            java.lang.String r6 = "recurring_payment"
            java.lang.String r7 = "true"
            org.json.JSONObject r5 = r5.put(r6, r7)     // Catch:{ JSONException -> 0x02ac }
            org.json.JSONArray r5 = r14.put(r5)     // Catch:{ JSONException -> 0x02ac }
            org.json.JSONObject r5 = r11.put(r12, r5)     // Catch:{ JSONException -> 0x02ac }
            java.lang.String r6 = "purchase_context"
            r13.put(r6, r5)     // Catch:{ JSONException -> 0x02ac }
            goto L_0x02ac
        L_0x0283:
            r28 = r6
        L_0x0285:
            r29 = r10
            goto L_0x02ac
        L_0x0288:
            r28 = r6
        L_0x028a:
            r29 = r10
        L_0x028c:
            r27 = r15
            goto L_0x02ac
        L_0x028f:
            r23 = r5
        L_0x0291:
            r28 = r6
            r25 = r7
            goto L_0x028a
        L_0x0296:
            r23 = r5
            r28 = r6
            r25 = r7
            r29 = r10
        L_0x029e:
            r18 = r14
            goto L_0x028c
        L_0x02a1:
            r23 = r5
            r28 = r6
            r25 = r7
            r29 = r10
            r17 = r12
            goto L_0x029e
        L_0x02ac:
            java.util.HashMap<java.lang.String, org.json.JSONObject> r5 = r4.mAllowedPaymentMethods
            r5.put(r9, r13)
            goto L_0x02c2
        L_0x02b2:
            r23 = r5
            r28 = r6
            r25 = r7
            r29 = r10
            r16 = r11
            r17 = r12
            r18 = r14
            r27 = r15
        L_0x02c2:
            java.util.HashMap<java.lang.String, org.json.JSONObject> r5 = r4.mTokenizationSpecifications
            java.lang.Object r5 = r5.get(r9)
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            if (r5 != 0) goto L_0x0343
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONObject r1 = r5.put(r8, r1)     // Catch:{ JSONException -> 0x033e }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x033e }
            r6.<init>()     // Catch:{ JSONException -> 0x033e }
            org.json.JSONObject r0 = r6.put(r3, r0)     // Catch:{ JSONException -> 0x033e }
            r6 = r28
            r3 = r29
            org.json.JSONObject r0 = r0.put(r6, r3)     // Catch:{ JSONException -> 0x033e }
            r3 = r25
            r6 = r27
            org.json.JSONObject r0 = r0.put(r3, r6)     // Catch:{ JSONException -> 0x033e }
            com.braintreepayments.api.models.Configuration r3 = r2.mConfiguration     // Catch:{ JSONException -> 0x033e }
            java.lang.String r3 = r3.mMerchantId     // Catch:{ JSONException -> 0x033e }
            r7 = r23
            org.json.JSONObject r0 = r0.put(r7, r3)     // Catch:{ JSONException -> 0x033e }
            java.lang.String r3 = "braintree:paypalClientId"
            com.braintreepayments.api.models.Configuration r7 = r2.mConfiguration     // Catch:{ JSONException -> 0x033e }
            com.braintreepayments.api.models.GooglePaymentConfiguration r7 = r7.mGooglePaymentConfiguration     // Catch:{ JSONException -> 0x033e }
            java.lang.String r7 = r7.mPayPalClientId     // Catch:{ JSONException -> 0x033e }
            org.json.JSONObject r0 = r0.put(r3, r7)     // Catch:{ JSONException -> 0x033e }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x033e }
            r3.<init>()     // Catch:{ JSONException -> 0x033e }
            r8 = r18
            r7 = r26
            org.json.JSONObject r3 = r3.put(r8, r7)     // Catch:{ JSONException -> 0x033e }
            java.lang.String r7 = r2.mIntegrationType     // Catch:{ JSONException -> 0x033e }
            r8 = r17
            org.json.JSONObject r3 = r3.put(r8, r7)     // Catch:{ JSONException -> 0x033e }
            java.lang.String r2 = r2.mSessionId     // Catch:{ JSONException -> 0x033e }
            r7 = r16
            org.json.JSONObject r2 = r3.put(r7, r2)     // Catch:{ JSONException -> 0x033e }
            r3 = r21
            org.json.JSONObject r2 = r2.put(r3, r6)     // Catch:{ JSONException -> 0x033e }
            r3 = r20
            r6 = r24
            org.json.JSONObject r2 = r2.put(r6, r3)     // Catch:{ JSONException -> 0x033e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x033e }
            r3 = r22
            org.json.JSONObject r0 = r0.put(r3, r2)     // Catch:{ JSONException -> 0x033e }
            r2 = r19
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x033e }
        L_0x033e:
            java.util.HashMap<java.lang.String, org.json.JSONObject> r0 = r4.mTokenizationSpecifications
            r0.put(r9, r5)
        L_0x0343:
            r0 = r32
            com.braintreepayments.api.models.GooglePaymentConfiguration r1 = r0.mGooglePaymentConfiguration
            java.lang.String r1 = r1.mEnvironment
            java.lang.String r1 = r1.toUpperCase()
            java.lang.String r2 = "PRODUCTION"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0356
            goto L_0x0358
        L_0x0356:
            java.lang.String r2 = "TEST"
        L_0x0358:
            r4.mEnvironment = r2
            r1 = r31
            com.braintreepayments.api.BraintreeFragment r2 = r1.val$fragment
            java.lang.String r3 = "google-payment.started"
            r2.sendAnalyticsEvent(r3)
            com.braintreepayments.api.models.GooglePaymentRequest r2 = r1.val$request
            java.lang.String r2 = r2.toJson()
            com.google.android.gms.wallet.PaymentDataRequest r2 = com.google.android.gms.wallet.PaymentDataRequest.fromJson(r2)
            android.content.Intent r3 = new android.content.Intent
            com.braintreepayments.api.BraintreeFragment r4 = r1.val$fragment
            android.content.Context r4 = r4.mContext
            java.lang.Class<com.braintreepayments.api.GooglePaymentActivity> r5 = com.braintreepayments.api.GooglePaymentActivity.class
            r3.<init>(r4, r5)
            com.braintreepayments.api.models.GooglePaymentConfiguration r0 = r0.mGooglePaymentConfiguration
            java.lang.String r0 = r0.mEnvironment
            java.lang.String r4 = "production"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0386
            r7 = 1
            goto L_0x0387
        L_0x0386:
            r7 = 3
        L_0x0387:
            java.lang.String r0 = "com.braintreepayments.api.EXTRA_ENVIRONMENT"
            android.content.Intent r0 = r3.putExtra(r0, r7)
            java.lang.String r3 = "com.braintreepayments.api.EXTRA_PAYMENT_DATA_REQUEST"
            android.content.Intent r0 = r0.putExtra(r3, r2)
            com.braintreepayments.api.BraintreeFragment r2 = r1.val$fragment
            r3 = 13593(0x3519, float:1.9048E-41)
            r2.startActivityForResult(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.GooglePayment$3.onConfigurationFetched(com.braintreepayments.api.models.Configuration):void");
    }
}
