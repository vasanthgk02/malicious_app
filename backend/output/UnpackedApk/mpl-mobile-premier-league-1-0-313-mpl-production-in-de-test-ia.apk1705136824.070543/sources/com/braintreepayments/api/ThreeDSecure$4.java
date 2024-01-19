package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.ThreeDSecureLookupListener;
import com.braintreepayments.api.models.ThreeDSecureRequest;

public final class ThreeDSecure$4 implements ConfigurationListener {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ ThreeDSecureLookupListener val$lookupListener;
    public final /* synthetic */ ThreeDSecureRequest val$request;

    public ThreeDSecure$4(BraintreeFragment braintreeFragment, ThreeDSecureRequest threeDSecureRequest, ThreeDSecureLookupListener threeDSecureLookupListener) {
        this.val$fragment = braintreeFragment;
        this.val$request = threeDSecureRequest;
        this.val$lookupListener = threeDSecureLookupListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ab A[Catch:{ JSONException -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationFetched(com.braintreepayments.api.models.Configuration r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            boolean r0 = r2.mThreeDSecureEnabled
            if (r0 != 0) goto L_0x001a
            com.braintreepayments.api.BraintreeFragment r0 = r1.val$fragment
            com.braintreepayments.api.exceptions.BraintreeException r2 = new com.braintreepayments.api.exceptions.BraintreeException
            java.lang.String r3 = "Three D Secure is not enabled for this account. Please contact Braintree Support for assistance."
            r2.<init>(r3)
            com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
            r3.<init>(r2)
            r0.postOrQueueCallback(r3)
            return
        L_0x001a:
            com.braintreepayments.api.BraintreeFragment r0 = r1.val$fragment
            android.content.Context r3 = r0.mContext
            java.lang.String r0 = r0.mReturnUrlScheme
            java.lang.Class<com.braintreepayments.api.BraintreeBrowserSwitchActivity> r4 = com.braintreepayments.api.BraintreeBrowserSwitchActivity.class
            boolean r0 = com.braintreepayments.api.internal.ManifestValidator.isUrlSchemeDeclaredInAndroidManifest(r3, r0, r4)
            if (r0 != 0) goto L_0x0041
            com.braintreepayments.api.BraintreeFragment r0 = r1.val$fragment
            java.lang.String r2 = "three-d-secure.invalid-manifest"
            r0.sendAnalyticsEvent(r2)
            com.braintreepayments.api.BraintreeFragment r0 = r1.val$fragment
            com.braintreepayments.api.exceptions.BraintreeException r2 = new com.braintreepayments.api.exceptions.BraintreeException
            java.lang.String r3 = "BraintreeBrowserSwitchActivity missing, incorrectly configured in AndroidManifest.xml or another app defines the same browser switch url as this app. See https://developers.braintreepayments.com/guides/client-sdk/android/v2#browser-switch for the correct configuration"
            r2.<init>(r3)
            com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
            r3.<init>(r2)
            r0.postOrQueueCallback(r3)
            return
        L_0x0041:
            java.lang.String r0 = r2.mCardinalAuthenticationJwt
            if (r0 != 0) goto L_0x0063
            com.braintreepayments.api.models.ThreeDSecureRequest r0 = r1.val$request
            java.lang.String r0 = r0.mVersionRequested
            java.lang.String r3 = "2"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            com.braintreepayments.api.BraintreeFragment r0 = r1.val$fragment
            com.braintreepayments.api.exceptions.BraintreeException r2 = new com.braintreepayments.api.exceptions.BraintreeException
            java.lang.String r3 = "Merchant is not configured for 3DS 2.0. Please contact Braintree Support for assistance."
            r2.<init>(r3)
            com.braintreepayments.api.BraintreeFragment$11 r3 = new com.braintreepayments.api.BraintreeFragment$11
            r3.<init>(r2)
            r0.postOrQueueCallback(r3)
            return
        L_0x0063:
            com.braintreepayments.api.BraintreeFragment r0 = r1.val$fragment
            java.lang.String r3 = "three-d-secure.initialized"
            r0.sendAnalyticsEvent(r3)
            com.braintreepayments.api.models.ThreeDSecureRequest r0 = r1.val$request
            java.lang.String r0 = r0.mVersionRequested
            java.lang.String r3 = "1"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0080
            com.braintreepayments.api.BraintreeFragment r0 = r1.val$fragment
            com.braintreepayments.api.models.ThreeDSecureRequest r2 = r1.val$request
            com.braintreepayments.api.interfaces.ThreeDSecureLookupListener r3 = r1.val$lookupListener
            co.hyperverge.hypersnapsdk.c.k.access$000(r0, r2, r3)
            return
        L_0x0080:
            com.braintreepayments.api.BraintreeFragment r0 = r1.val$fragment
            com.braintreepayments.api.models.ThreeDSecureRequest r3 = r1.val$request
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment r4 = com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment.STAGING
            java.lang.String r5 = r2.mEnvironment
            java.lang.String r6 = "production"
            boolean r5 = r6.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0092
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment r4 = com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment.PRODUCTION
        L_0x0092:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r5 = new com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters
            r5.<init>()
            r5.g = r4
            r4 = 8000(0x1f40, float:1.121E-41)
            r5.f1892a = r4
            r4 = 0
            r5.f1897f = r4
            r4 = 1
            r5.j = r4
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r3 = r3.mUiCustomization
            r5.i = r3
            com.cardinalcommerce.cardinalmobilesdk.Cardinal r3 = com.cardinalcommerce.cardinalmobilesdk.Cardinal.getInstance()
            android.content.Context r6 = r0.mContext
            r7 = 0
            if (r3 == 0) goto L_0x03cf
            java.lang.Class<com.cardinalcommerce.cardinalmobilesdk.Cardinal> r0 = com.cardinalcommerce.cardinalmobilesdk.Cardinal.class
            java.lang.String r3 = r0.getName()
            java.lang.String r8 = r0.getName()
            boolean r3 = r3.equals(r8)
            r3 = r3 ^ r4
            com.cardinalcommerce.cardinalmobilesdk.Cardinal.f1842d = r3
            com.cardinalcommerce.cardinalmobilesdk.a.a.a r4 = com.cardinalcommerce.cardinalmobilesdk.Cardinal.f1841c
            if (r4 == 0) goto L_0x03ce
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r8 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1847f
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r9 = com.cardinalcommerce.cardinalmobilesdk.a.a.d.Configured
            boolean r8 = com.cardinalcommerce.cardinalmobilesdk.a.a.g.a(r8, r9)
            java.lang.String r9 = ", "
            java.lang.String r10 = "Error: Current State, Next state  :"
            if (r8 == 0) goto L_0x02d1
            if (r6 == 0) goto L_0x02b6
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r8 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            boolean r11 = r5.l
            if (r8 == 0) goto L_0x02b5
            com.cardinalcommerce.shared.cs.utils.a.f2213a = r11
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r8 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            java.lang.String r11 = "SDKAppID: "
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.String r12 = r4.a(r6)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.String r12 = "CardinalConfigure"
            r8.a(r12, r11, r7)
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r8 = com.cardinalcommerce.cardinalmobilesdk.a.a.d.Configured
            com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1847f = r8
            com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1844b = r6
            java.lang.String r8 = co.hyperverge.hypersnapsdk.c.k.a(r5)
            com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1846e = r8
            r4.m = r5
            if (r3 != 0) goto L_0x0146
            java.lang.Class<com.cardinalcommerce.cardinalmobilesdk.a.a.a> r3 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.class
            java.lang.Throwable r4 = new java.lang.Throwable
            r4.<init>()
            java.lang.StackTraceElement[] r4 = r4.getStackTrace()
            r8 = 1
        L_0x0111:
            int r11 = r4.length
            if (r8 >= r11) goto L_0x0138
            r11 = r4[r8]
            java.lang.String r13 = r11.getClassName()
            java.lang.String r14 = r3.getName()
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x0135
            java.lang.String r13 = r11.getClassName()
            java.lang.String r14 = "java.lang.Thread"
            int r13 = r13.indexOf(r14)
            if (r13 == 0) goto L_0x0135
            java.lang.String r3 = r11.getClassName()
            goto L_0x0139
        L_0x0135:
            int r8 = r8 + 1
            goto L_0x0111
        L_0x0138:
            r3 = r7
        L_0x0139:
            java.lang.String r0 = r0.getName()
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0144
            goto L_0x0146
        L_0x0144:
            r0 = 0
            goto L_0x0147
        L_0x0146:
            r0 = 1
        L_0x0147:
            com.cardinalcommerce.cardinalmobilesdk.a.a.a.p = r0
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            java.lang.String r3 = "LASSO started"
            r0.a(r12, r3, r7)
            com.cardinalcommerce.shared.cs.a.b r3 = com.cardinalcommerce.shared.cs.a.b.a()
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r0 = "EnableQuickAuth"
            boolean r8 = r5.f1897f     // Catch:{ JSONException -> 0x01b3 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r0 = "Environment"
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment r8 = r5.g     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r0 = "ProxyAddress"
            java.lang.String r8 = r5.f1894c     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r0 = "RenderType"
            org.json.JSONArray r8 = r5.f1896e     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r0 = "Timeout"
            int r8 = r5.f1892a     // Catch:{ JSONException -> 0x01b3 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r0 = "UiType"
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType r8 = r5.f1895d     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r0 = "EnableDFSync"
            boolean r8 = r5.j     // Catch:{ JSONException -> 0x01b3 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r0 = "EnableLogging"
            boolean r8 = r5.l     // Catch:{ JSONException -> 0x01b3 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r0 = r5.h     // Catch:{ JSONException -> 0x01b3 }
            java.lang.String r8 = ""
            boolean r0 = r0.equals(r8)     // Catch:{ JSONException -> 0x01b3 }
            if (r0 != 0) goto L_0x01c7
            java.lang.String r0 = "ThreeDSRequestorAppURL"
            java.lang.String r8 = r5.h     // Catch:{ JSONException -> 0x01b3 }
            r4.putOpt(r0, r8)     // Catch:{ JSONException -> 0x01b3 }
            goto L_0x01c7
        L_0x01b3:
            r0 = move-exception
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r5 = r5.k
            r8 = 10610(0x2972, float:1.4868E-41)
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.String r0 = java.util.Arrays.toString(r0)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r5.b(r8, r0, r7)
        L_0x01c7:
            boolean r5 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.p
            if (r3 == 0) goto L_0x02b4
            com.cardinalcommerce.shared.cs.f.g r8 = com.cardinalcommerce.shared.cs.a.b.f2069a
            if (r8 == 0) goto L_0x02b3
            com.cardinalcommerce.shared.cs.f.c r0 = new com.cardinalcommerce.shared.cs.f.c
            r0.<init>(r6)
            r8.j = r0
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r6, r0)
            if (r0 != 0) goto L_0x01e0
            r0 = 1
            goto L_0x01e1
        L_0x01e0:
            r0 = 0
        L_0x01e1:
            java.lang.String r11 = "android.permission.ACCESS_COARSE_LOCATION"
            int r11 = androidx.core.content.ContextCompat.checkSelfPermission(r6, r11)
            if (r11 != 0) goto L_0x01eb
            r11 = 1
            goto L_0x01ec
        L_0x01eb:
            r11 = 0
        L_0x01ec:
            java.lang.String r12 = "android.permission.ACCESS_FINE_LOCATION"
            int r12 = androidx.core.content.ContextCompat.checkSelfPermission(r6, r12)
            if (r12 != 0) goto L_0x01f6
            r12 = 1
            goto L_0x01f7
        L_0x01f6:
            r12 = 0
        L_0x01f7:
            java.lang.String r13 = "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"
            androidx.core.content.ContextCompat.checkSelfPermission(r6, r13)
            java.lang.String r13 = "android.permission.GET_ACCOUNTS"
            androidx.core.content.ContextCompat.checkSelfPermission(r6, r13)
            java.lang.String r13 = "android.permission.READ_EXTERNAL_STORAGE"
            androidx.core.content.ContextCompat.checkSelfPermission(r6, r13)
            java.lang.String r13 = "android.permission.BLUETOOTH"
            int r13 = androidx.core.content.ContextCompat.checkSelfPermission(r6, r13)
            if (r13 != 0) goto L_0x0210
            r13 = 1
            goto L_0x0211
        L_0x0210:
            r13 = 0
        L_0x0211:
            java.lang.String r14 = "NativeData Data"
            if (r0 == 0) goto L_0x0227
            com.cardinalcommerce.shared.cs.f.l r0 = new com.cardinalcommerce.shared.cs.f.l     // Catch:{ Exception -> 0x021d }
            r0.<init>(r6)     // Catch:{ Exception -> 0x021d }
            r8.g = r0     // Catch:{ Exception -> 0x021d }
            goto L_0x0227
        L_0x021d:
            r0 = move-exception
            com.cardinalcommerce.shared.cs.utils.a r15 = r8.m
            java.lang.String r0 = r0.getMessage()
            r15.b(r14, r0, r7)
        L_0x0227:
            if (r12 != 0) goto L_0x022b
            if (r11 == 0) goto L_0x0277
        L_0x022b:
            java.lang.String r0 = "location"
            java.lang.Object r0 = r6.getSystemService(r0)     // Catch:{ Exception -> 0x026d }
            android.location.LocationManager r0 = (android.location.LocationManager) r0     // Catch:{ Exception -> 0x026d }
            java.lang.String r11 = "gps"
            android.location.Location r11 = r0.getLastKnownLocation(r11)     // Catch:{ Exception -> 0x026d }
            java.lang.String r12 = "network"
            android.location.Location r0 = r0.getLastKnownLocation(r12)     // Catch:{ Exception -> 0x026d }
            r15 = 0
            if (r11 == 0) goto L_0x0248
            long r17 = r11.getTime()     // Catch:{ Exception -> 0x026d }
            goto L_0x024a
        L_0x0248:
            r17 = r15
        L_0x024a:
            if (r0 == 0) goto L_0x0251
            long r19 = r0.getTime()     // Catch:{ Exception -> 0x026d }
            goto L_0x0253
        L_0x0251:
            r19 = r15
        L_0x0253:
            long r17 = r17 - r19
            int r12 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r12 >= 0) goto L_0x0263
            if (r11 == 0) goto L_0x0263
            com.cardinalcommerce.shared.cs.f.e r0 = new com.cardinalcommerce.shared.cs.f.e     // Catch:{ Exception -> 0x026d }
            r0.<init>(r11)     // Catch:{ Exception -> 0x026d }
            r8.i = r0     // Catch:{ Exception -> 0x026d }
            goto L_0x0277
        L_0x0263:
            if (r0 == 0) goto L_0x0277
            com.cardinalcommerce.shared.cs.f.e r11 = new com.cardinalcommerce.shared.cs.f.e     // Catch:{ Exception -> 0x026d }
            r11.<init>(r0)     // Catch:{ Exception -> 0x026d }
            r8.i = r11     // Catch:{ Exception -> 0x026d }
            goto L_0x0277
        L_0x026d:
            r0 = move-exception
            com.cardinalcommerce.shared.cs.utils.a r11 = r8.m
            java.lang.String r0 = r0.getMessage()
            r11.b(r14, r0, r7)
        L_0x0277:
            if (r13 == 0) goto L_0x0282
            com.cardinalcommerce.shared.cs.f.b r0 = new com.cardinalcommerce.shared.cs.f.b
            r0.<init>(r6)
            com.cardinalcommerce.shared.cs.f.c r11 = r8.j
            r11.f2121b = r0
        L_0x0282:
            com.cardinalcommerce.shared.cs.f.n r0 = new com.cardinalcommerce.shared.cs.f.n
            r0.<init>(r6)
            r8.f2135f = r0
            com.cardinalcommerce.shared.cs.f.d r0 = new com.cardinalcommerce.shared.cs.f.d
            r0.<init>(r6)
            r8.h = r0
            com.cardinalcommerce.shared.cs.f.a r0 = new com.cardinalcommerce.shared.cs.f.a
            r0.<init>(r6)
            r8.f2130a = r0
            com.cardinalcommerce.cardinalmobilesdk.a.a.a r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.a()
            java.lang.String r0 = r0.e()
            char[] r0 = com.cardinalcommerce.shared.cs.utils.h.a(r0)
            r8.f2132c = r0
            r8.k = r4
            com.cardinalcommerce.shared.cs.f.j r0 = new com.cardinalcommerce.shared.cs.f.j
            r0.<init>(r5, r6)
            r3.f2071c = r0
            com.cardinalcommerce.shared.cs.f.g r3 = com.cardinalcommerce.shared.cs.a.b.f2069a
            r3.l = r0
            goto L_0x02f1
        L_0x02b3:
            throw r7
        L_0x02b4:
            throw r7
        L_0x02b5:
            throw r7
        L_0x02b6:
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            com.cardinalcommerce.cardinalmobilesdk.a.a.c r2 = new com.cardinalcommerce.cardinalmobilesdk.a.a.c
            r3 = 10102(0x2776, float:1.4156E-41)
            r2.<init>(r3)
            r0.a(r2, r7)
            java.lang.Throwable r0 = new java.lang.Throwable
            java.lang.String r2 = "Invalid Input Exception - Application Context"
            r0.<init>(r2)
            com.cardinalcommerce.shared.models.exceptions.InvalidInputException r2 = new com.cardinalcommerce.shared.models.exceptions.InvalidInputException
            java.lang.String r3 = "InvalidInputException"
            r2.<init>(r3, r0)
            throw r2
        L_0x02d1:
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            r3 = 10101(0x2775, float:1.4155E-41)
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r10)
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r5 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1847f
            r4.append(r5)
            r4.append(r9)
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r5 = com.cardinalcommerce.cardinalmobilesdk.a.a.d.Configured
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.b(r3, r4, r7)
        L_0x02f1:
            com.cardinalcommerce.cardinalmobilesdk.Cardinal r0 = com.cardinalcommerce.cardinalmobilesdk.Cardinal.getInstance()
            java.lang.String r2 = r2.mCardinalAuthenticationJwt
            com.braintreepayments.api.ThreeDSecure$4$1 r3 = new com.braintreepayments.api.ThreeDSecure$4$1
            r3.<init>()
            if (r0 == 0) goto L_0x03cd
            com.cardinalcommerce.cardinalmobilesdk.a.a.a r4 = com.cardinalcommerce.cardinalmobilesdk.Cardinal.f1841c
            if (r4 == 0) goto L_0x03cc
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            java.lang.String r5 = "CardinalInit"
            java.lang.String r6 = "Init started"
            r0.a(r5, r6, r7)
            r4.g = r3
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1847f
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r3 = com.cardinalcommerce.cardinalmobilesdk.a.a.d.InitStarted
            boolean r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.g.a(r0, r3)
            if (r0 == 0) goto L_0x03a3
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r0 = r4.m
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType r3 = r0.f1895d
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType r6 = com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType.NATIVE
            if (r3 != r6) goto L_0x033e
            org.json.JSONArray r0 = r0.f1896e
            java.lang.String r0 = r0.toString()
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType r3 = com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType.HTML
            java.lang.String r3 = r3.toString()
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x033e
            com.cardinalcommerce.cardinalmobilesdk.a.a.c r0 = new com.cardinalcommerce.cardinalmobilesdk.a.a.c
            r2 = 10207(0x27df, float:1.4303E-41)
            r0.<init>(r2)
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r2 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            r2.a(r0, r7)
            goto L_0x039f
        L_0x033e:
            if (r2 == 0) goto L_0x038e
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x038e
            r4.i = r2
            com.cardinalcommerce.cardinalmobilesdk.a.c.c r0 = new com.cardinalcommerce.cardinalmobilesdk.a.c.c     // Catch:{ JSONException -> 0x036b }
            java.lang.String r3 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1846e     // Catch:{ JSONException -> 0x036b }
            r0.<init>(r4, r2, r3)     // Catch:{ JSONException -> 0x036b }
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r2 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1847f     // Catch:{ JSONException -> 0x036b }
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r3 = com.cardinalcommerce.cardinalmobilesdk.a.a.d.InitStarted     // Catch:{ JSONException -> 0x036b }
            if (r2 != r3) goto L_0x0360
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r2 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k     // Catch:{ JSONException -> 0x036b }
            java.lang.String r3 = "Previous centinel API init task cancelled"
            r2.a(r5, r3, r7)     // Catch:{ JSONException -> 0x036b }
            r2 = 1
            r0.cancel(r2)     // Catch:{ JSONException -> 0x036b }
        L_0x0360:
            r2 = 0
            java.lang.Void[] r2 = new java.lang.Void[r2]     // Catch:{ JSONException -> 0x036b }
            r0.execute(r2)     // Catch:{ JSONException -> 0x036b }
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.d.InitStarted     // Catch:{ JSONException -> 0x036b }
            com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1847f = r0     // Catch:{ JSONException -> 0x036b }
            goto L_0x03cb
        L_0x036b:
            r0 = move-exception
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r2 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            java.lang.String r3 = "Cardinal Init Error"
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r0 = r0.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 10205(0x27dd, float:1.43E-41)
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r2.b(r5, r0, r7)
            com.cardinalcommerce.cardinalmobilesdk.a.a.c r0 = new com.cardinalcommerce.cardinalmobilesdk.a.a.c
            r0.<init>(r3)
            goto L_0x039f
        L_0x038e:
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            com.cardinalcommerce.cardinalmobilesdk.a.a.c r2 = new com.cardinalcommerce.cardinalmobilesdk.a.a.c
            r3 = 10202(0x27da, float:1.4296E-41)
            r2.<init>(r3)
            r0.a(r2, r7)
            com.cardinalcommerce.cardinalmobilesdk.a.a.c r0 = new com.cardinalcommerce.cardinalmobilesdk.a.a.c
            r0.<init>(r3)
        L_0x039f:
            r4.c(r0)
            goto L_0x03cb
        L_0x03a3:
            com.cardinalcommerce.cardinalmobilesdk.a.d.b r0 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.k
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r10)
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r3 = com.cardinalcommerce.cardinalmobilesdk.a.a.a.f1847f
            r2.append(r3)
            r2.append(r9)
            com.cardinalcommerce.cardinalmobilesdk.a.a.d r3 = com.cardinalcommerce.cardinalmobilesdk.a.a.d.InitStarted
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 10201(0x27d9, float:1.4295E-41)
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r0.b(r5, r2, r7)
            com.cardinalcommerce.cardinalmobilesdk.a.a.c r0 = new com.cardinalcommerce.cardinalmobilesdk.a.a.c
            r0.<init>(r3)
            r4.c(r0)
        L_0x03cb:
            return
        L_0x03cc:
            throw r7
        L_0x03cd:
            throw r7
        L_0x03ce:
            throw r7
        L_0x03cf:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.ThreeDSecure$4.onConfigurationFetched(com.braintreepayments.api.models.Configuration):void");
    }
}
