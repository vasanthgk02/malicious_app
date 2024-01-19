package com.paypal.android.sdk.onetouch.core;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.material.resources.TextAppearanceConfig;
import com.paypal.android.sdk.onetouch.core.config.CheckoutRecipe;
import com.paypal.android.sdk.onetouch.core.config.OtcConfiguration;
import com.paypal.android.sdk.onetouch.core.config.Recipe;
import com.paypal.android.sdk.onetouch.core.enums.RequestTarget;
import java.util.ArrayList;
import java.util.Iterator;
import lib.android.paypal.com.magnessdk.Environment;
import lib.android.paypal.com.magnessdk.InvalidInputException;
import lib.android.paypal.com.magnessdk.MagnesSDK;
import lib.android.paypal.com.magnessdk.MagnesSettings.Builder;
import lib.android.paypal.com.magnessdk.MagnesSource;
import lib.android.paypal.com.magnessdk.c$b$b;

public class CheckoutRequest extends Request<CheckoutRequest> implements Parcelable {
    public static final Creator<CheckoutRequest> CREATOR = new Creator<CheckoutRequest>() {
        public Object createFromParcel(Parcel parcel) {
            return new CheckoutRequest(parcel);
        }

        public Object[] newArray(int i) {
            return new CheckoutRequest[i];
        }
    };
    public String mApprovalUrl;
    public String mPairingId;
    public String mTokenQueryParamKey;

    public CheckoutRequest() {
        this.mTokenQueryParamKey = "token";
    }

    public CheckoutRequest approvalURL(String str) {
        this.mApprovalUrl = str;
        this.mTokenQueryParamKey = "token";
        return this;
    }

    public Recipe getRecipeToExecute(Context context, OtcConfiguration otcConfiguration) {
        Iterator it = new ArrayList(otcConfiguration.mCheckoutRecipesInDecreasingPriorityOrder).iterator();
        while (it.hasNext()) {
            CheckoutRecipe checkoutRecipe = (CheckoutRecipe) it.next();
            RequestTarget requestTarget = RequestTarget.wallet;
            RequestTarget requestTarget2 = checkoutRecipe.mTarget;
            if (requestTarget == requestTarget2) {
                if (checkoutRecipe.isValidAppTarget(context)) {
                    return checkoutRecipe;
                }
            } else if (RequestTarget.browser == requestTarget2 && checkoutRecipe.isValidBrowserTarget(context, this.mApprovalUrl)) {
                return checkoutRecipe;
            }
        }
        return null;
    }

    public CheckoutRequest pairingId(Context context, String str) {
        String str2;
        this.mPairingId = str;
        String installationGUID = TextAppearanceConfig.getInstallationGUID(context);
        String substring = str.substring(0, Math.min(str.length(), 32));
        if (context != null) {
            try {
                MagnesSDK instance = MagnesSDK.getInstance();
                Builder builder = new Builder(context);
                builder.sourceFlow = MagnesSource.BRAINTREE.getVersion();
                builder.disableBeacon = false;
                builder.environment = Environment.LIVE;
                if (installationGUID.length() <= 36) {
                    builder.appGuid = installationGUID;
                    instance.setUp(builder.build());
                    str2 = instance.collectAndSubmit(context, substring, null).paypalclientmetadataid;
                    this.mClientMetadataId = str2;
                    return this;
                }
                throw new InvalidInputException(c$b$b.APPGUID_EXCEPTION_MESSAGE.toString());
            } catch (InvalidInputException unused) {
            }
        }
        str2 = "";
        this.mClientMetadataId = str2;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        if ((r2.mValidUntil > java.lang.System.currentTimeMillis()) == false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackFpti(android.content.Context r13, com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r14, com.paypal.android.sdk.onetouch.core.enums.Protocol r15) {
        /*
            r12 = this;
            java.lang.String r0 = r12.mApprovalUrl
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r1 = r12.mTokenQueryParamKey
            java.lang.String r0 = r0.getQueryParameter(r1)
            java.lang.String r1 = "fltk"
            java.util.HashMap r0 = com.android.tools.r8.GeneratedOutlineSupport.outline87(r1, r0)
            java.lang.String r1 = r12.mClientId
            java.lang.String r2 = "clid"
            r0.put(r2, r1)
            com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.initService(r13)
            com.paypal.android.sdk.onetouch.core.fpti.FptiManager r13 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.sFptiManager
            java.lang.String r1 = r12.mEnvironment
            if (r13 == 0) goto L_0x0225
            java.lang.String r2 = "mock"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x002c
            goto L_0x0224
        L_0x002c:
            com.paypal.android.sdk.onetouch.core.fpti.FptiToken r2 = r13.mToken
            if (r2 == 0) goto L_0x003f
            long r2 = r2.mValidUntil
            long r4 = java.lang.System.currentTimeMillis()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x003c
            r2 = 1
            goto L_0x003d
        L_0x003c:
            r2 = 0
        L_0x003d:
            if (r2 != 0) goto L_0x0046
        L_0x003f:
            com.paypal.android.sdk.onetouch.core.fpti.FptiToken r2 = new com.paypal.android.sdk.onetouch.core.fpti.FptiToken
            r2.<init>()
            r13.mToken = r2
        L_0x0046:
            long r2 = java.lang.System.currentTimeMillis()
            com.paypal.android.sdk.onetouch.core.base.ContextInspector r4 = r13.mContextInspector
            android.content.Context r4 = r4.mContext
            java.lang.String r4 = com.google.android.material.resources.TextAppearanceConfig.getInstallationGUID(r4)
            java.lang.String r5 = "UTF-8"
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r5)     // Catch:{ UnsupportedEncodingException -> 0x0059 }
            goto L_0x005f
        L_0x0059:
            java.lang.String r5 = "unable_to_encode:"
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r5, r4)
        L_0x005f:
            java.lang.String r5 = "mobile:otc:"
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            java.lang.String r6 = r14.getCd()
            r5.append(r6)
            java.lang.String r6 = ":"
            r5.append(r6)
            java.lang.String r7 = ""
            if (r15 == 0) goto L_0x007a
            java.lang.String r15 = r15.name()
            goto L_0x007b
        L_0x007a:
            r15 = r7
        L_0x007b:
            r5.append(r15)
            java.lang.String r15 = r5.toString()
            java.lang.String r5 = "Android:"
            java.lang.String r8 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r5, r1, r6)
            java.lang.StringBuilder r8 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r15, r6, r8)
            boolean r14 = r14.hasError()
            if (r14 == 0) goto L_0x0094
            java.lang.String r7 = "|error"
        L_0x0094:
            r8.append(r7)
            java.lang.String r14 = r8.toString()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.paypal.android.sdk.onetouch.core.base.ContextInspector r8 = r13.mContextInspector
            android.content.Context r8 = r8.mContext
            java.lang.String r8 = com.google.android.material.resources.TextAppearanceConfig.getApplicationInfoName(r8)
            r0.append(r8)
            java.lang.String r8 = "|"
            r0.append(r8)
            java.lang.String r9 = "3.17.4"
            r0.append(r9)
            r0.append(r8)
            com.paypal.android.sdk.onetouch.core.base.ContextInspector r8 = r13.mContextInspector
            android.content.Context r8 = r8.mContext
            java.lang.String r8 = r8.getPackageName()
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r8 = "apid"
            r7.put(r8, r0)
            java.lang.String r0 = "otc"
            java.lang.String r8 = "bchn"
            r7.put(r8, r0)
            java.lang.String r8 = "mobile"
            java.lang.String r10 = "bzsr"
            r7.put(r10, r8)
            java.lang.String r10 = "dsid"
            r7.put(r10, r4)
            java.lang.String r10 = "e"
            java.lang.String r11 = "im"
            r7.put(r10, r11)
            java.util.GregorianCalendar r10 = new java.util.GregorianCalendar
            r10.<init>()
            java.util.TimeZone r10 = r10.getTimeZone()
            int r10 = r10.getRawOffset()
            int r10 = r10 / 1000
            int r10 = r10 / 60
            java.lang.String r10 = java.lang.Integer.toString(r10)
            java.lang.String r11 = "g"
            r7.put(r11, r10)
            java.lang.String r10 = "lgin"
            java.lang.String r11 = "out"
            r7.put(r10, r11)
            java.lang.String r10 = "mapv"
            r7.put(r10, r9)
            com.paypal.android.sdk.onetouch.core.base.ContextInspector r9 = r13.mContextInspector
            android.content.Context r9 = r9.mContext
            java.lang.String r10 = "phone"
            java.lang.Object r9 = r9.getSystemService(r10)     // Catch:{ SecurityException -> 0x0122 }
            android.telephony.TelephonyManager r9 = (android.telephony.TelephonyManager) r9     // Catch:{ SecurityException -> 0x0122 }
            java.lang.String r9 = r9.getSimOperatorName()     // Catch:{ SecurityException -> 0x0122 }
            goto L_0x0123
        L_0x0122:
            r9 = 0
        L_0x0123:
            java.lang.String r10 = "mcar"
            r7.put(r10, r9)
            java.lang.String r9 = com.google.android.material.resources.TextAppearanceConfig.getDeviceName()
            java.lang.String r10 = "mdvs"
            r7.put(r10, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Android "
            r9.append(r10)
            java.lang.String r10 = android.os.Build.VERSION.RELEASE
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "mosv"
            r7.put(r10, r9)
            java.lang.String r9 = "page"
            r7.put(r9, r14)
            java.lang.String r14 = "pgrp"
            r7.put(r14, r15)
            java.util.Locale r14 = java.util.Locale.getDefault()
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = "rsta"
            r7.put(r15, r14)
            java.lang.String r14 = "srce"
            r7.put(r14, r0)
            java.lang.String r14 = "sv"
            r7.put(r14, r8)
            java.util.GregorianCalendar r14 = new java.util.GregorianCalendar
            r14.<init>()
            java.util.TimeZone r14 = r14.getTimeZone()
            int r14 = r14.getRawOffset()
            long r14 = (long) r14
            long r14 = r2 - r14
            java.lang.String r14 = java.lang.Long.toString(r14)
            java.lang.String r15 = "t"
            r7.put(r15, r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r5)
            r14.append(r1)
            r14.append(r6)
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = "vers"
            r7.put(r15, r14)
            com.paypal.android.sdk.onetouch.core.fpti.FptiToken r14 = r13.mToken
            java.lang.String r14 = r14.mToken
            java.lang.String r15 = "vid"
            r7.put(r15, r14)
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0224 }
            r14.<init>()     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r15 = "tracking_visitor_id"
            r14.accumulate(r15, r4)     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r15 = "tracking_visit_id"
            com.paypal.android.sdk.onetouch.core.fpti.FptiToken r0 = r13.mToken     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r0 = r0.mToken     // Catch:{ JSONException -> 0x0224 }
            r14.accumulate(r15, r0)     // Catch:{ JSONException -> 0x0224 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0224 }
            r15.<init>()     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r0 = "actor"
            r15.accumulate(r0, r14)     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r14 = "channel"
            r15.accumulate(r14, r8)     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r14 = "tracking_event"
            java.lang.String r0 = java.lang.Long.toString(r2)     // Catch:{ JSONException -> 0x0224 }
            r15.accumulate(r14, r0)     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r14 = "event_params"
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0224 }
            r0.<init>()     // Catch:{ JSONException -> 0x0224 }
            java.util.Set r1 = r7.keySet()     // Catch:{ JSONException -> 0x0224 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ JSONException -> 0x0224 }
        L_0x01dd:
            boolean r2 = r1.hasNext()     // Catch:{ JSONException -> 0x0224 }
            if (r2 == 0) goto L_0x01f1
            java.lang.Object r2 = r1.next()     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0224 }
            java.lang.Object r3 = r7.get(r2)     // Catch:{ JSONException -> 0x0224 }
            r0.accumulate(r2, r3)     // Catch:{ JSONException -> 0x0224 }
            goto L_0x01dd
        L_0x01f1:
            r15.accumulate(r14, r0)     // Catch:{ JSONException -> 0x0224 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0224 }
            r14.<init>()     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r0 = "events"
            org.json.JSONObject r14 = r14.accumulate(r0, r15)     // Catch:{ JSONException -> 0x0224 }
            java.lang.String r14 = r14.toString()     // Catch:{ JSONException -> 0x0224 }
            android.os.Handler r15 = new android.os.Handler     // Catch:{ JSONException -> 0x0224 }
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ JSONException -> 0x0224 }
            r15.<init>(r0)     // Catch:{ JSONException -> 0x0224 }
            com.paypal.android.sdk.onetouch.core.fpti.FptiManager$1 r0 = new com.paypal.android.sdk.onetouch.core.fpti.FptiManager$1     // Catch:{ JSONException -> 0x0224 }
            r0.<init>(r14)     // Catch:{ JSONException -> 0x0224 }
            java.util.Random r13 = new java.util.Random     // Catch:{ JSONException -> 0x0224 }
            r13.<init>()     // Catch:{ JSONException -> 0x0224 }
            r14 = 190(0xbe, float:2.66E-43)
            int r13 = r13.nextInt(r14)     // Catch:{ JSONException -> 0x0224 }
            int r13 = r13 + 10
            int r13 = r13 * 1000
            long r13 = (long) r13     // Catch:{ JSONException -> 0x0224 }
            r15.postDelayed(r0, r13)     // Catch:{ JSONException -> 0x0224 }
        L_0x0224:
            return
        L_0x0225:
            r13 = 0
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.onetouch.core.CheckoutRequest.trackFpti(android.content.Context, com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint, com.paypal.android.sdk.onetouch.core.enums.Protocol):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEnvironment);
        parcel.writeString(this.mClientId);
        parcel.writeString(this.mClientMetadataId);
        parcel.writeString(this.mCancelUrl);
        parcel.writeString(this.mSuccessUrl);
        parcel.writeString(this.mApprovalUrl);
        parcel.writeString(this.mTokenQueryParamKey);
        parcel.writeString(this.mPairingId);
    }

    public CheckoutRequest(Parcel parcel) {
        super(parcel);
        this.mApprovalUrl = parcel.readString();
        this.mTokenQueryParamKey = parcel.readString();
        this.mPairingId = parcel.readString();
    }
}
