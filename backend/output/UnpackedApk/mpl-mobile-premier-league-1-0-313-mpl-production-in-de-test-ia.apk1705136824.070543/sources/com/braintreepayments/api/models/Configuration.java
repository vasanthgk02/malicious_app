package com.braintreepayments.api.models;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.paynimo.android.payment.PaymentActivity;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Configuration {
    public AnalyticsConfiguration mAnalyticsConfiguration;
    public String mAssetsUrl;
    public CardConfiguration mCardConfiguration;
    public String mCardinalAuthenticationJwt;
    public final Set<String> mChallenges = new HashSet();
    public String mClientApiUrl;
    public String mConfigurationString;
    public String mEnvironment;
    public GooglePaymentConfiguration mGooglePaymentConfiguration;
    public GraphQLConfiguration mGraphQLConfiguration;
    public KountConfiguration mKountConfiguration;
    public String mMerchantId;
    public PayPalConfiguration mPayPalConfiguration;
    public boolean mPaypalEnabled;
    public boolean mThreeDSecureEnabled;
    public UnionPayConfiguration mUnionPayConfiguration;
    public VenmoConfiguration mVenmoConfiguration;

    public Configuration(String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17 = str;
        if (str17 != null) {
            this.mConfigurationString = str17;
            JSONObject jSONObject = new JSONObject(str17);
            if (jSONObject.isNull("assetsUrl")) {
                str2 = "";
            } else {
                str2 = jSONObject.optString("assetsUrl", "");
            }
            this.mAssetsUrl = str2;
            this.mClientApiUrl = jSONObject.getString("clientApiUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray("challenges");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.mChallenges.add(optJSONArray.optString(i, ""));
                }
            }
            this.mEnvironment = jSONObject.getString(PaymentConstants.ENV);
            this.mMerchantId = jSONObject.getString(PaymentConstants.MERCHANT_ID_CAMEL);
            String str18 = null;
            if (!jSONObject.isNull("merchantAccountId")) {
                jSONObject.optString("merchantAccountId", null);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("analytics");
            optJSONObject = optJSONObject == null ? new JSONObject() : optJSONObject;
            AnalyticsConfiguration analyticsConfiguration = new AnalyticsConfiguration();
            if (optJSONObject.isNull("url")) {
                str3 = null;
            } else {
                str3 = optJSONObject.optString("url", null);
            }
            analyticsConfiguration.mUrl = str3;
            this.mAnalyticsConfiguration = analyticsConfiguration;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("braintreeApi");
            optJSONObject2 = optJSONObject2 == null ? new JSONObject() : optJSONObject2;
            if (!optJSONObject2.isNull("accessToken")) {
                optJSONObject2.optString("accessToken", "");
            }
            if (!optJSONObject2.isNull("url")) {
                optJSONObject2.optString("url", "");
            }
            this.mCardConfiguration = CardConfiguration.fromJson(jSONObject.optJSONObject("creditCards"));
            this.mPaypalEnabled = jSONObject.optBoolean("paypalEnabled", false);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("paypal");
            optJSONObject3 = optJSONObject3 == null ? new JSONObject() : optJSONObject3;
            PayPalConfiguration payPalConfiguration = new PayPalConfiguration();
            if (optJSONObject3.isNull("displayName")) {
                str4 = null;
            } else {
                str4 = optJSONObject3.optString("displayName", null);
            }
            payPalConfiguration.mDisplayName = str4;
            if (optJSONObject3.isNull(PaymentConstants.CLIENT_ID_CAMEL)) {
                str5 = null;
            } else {
                str5 = optJSONObject3.optString(PaymentConstants.CLIENT_ID_CAMEL, null);
            }
            payPalConfiguration.mClientId = str5;
            if (!optJSONObject3.isNull("privacyUrl")) {
                optJSONObject3.optString("privacyUrl", null);
            }
            if (!optJSONObject3.isNull("userAgreementUrl")) {
                optJSONObject3.optString("userAgreementUrl", null);
            }
            if (!optJSONObject3.isNull("directBaseUrl")) {
                optJSONObject3.optString("directBaseUrl", null);
            }
            if (optJSONObject3.isNull(PaymentConstants.ENV)) {
                str6 = null;
            } else {
                str6 = optJSONObject3.optString(PaymentConstants.ENV, null);
            }
            payPalConfiguration.mEnvironment = str6;
            optJSONObject3.optBoolean("touchDisabled", true);
            if (optJSONObject3.isNull("currencyIsoCode")) {
                str7 = null;
            } else {
                str7 = optJSONObject3.optString("currencyIsoCode", null);
            }
            payPalConfiguration.mCurrencyIsoCode = str7;
            this.mPayPalConfiguration = payPalConfiguration;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("androidPay");
            optJSONObject4 = optJSONObject4 == null ? new JSONObject() : optJSONObject4;
            GooglePaymentConfiguration googlePaymentConfiguration = new GooglePaymentConfiguration();
            googlePaymentConfiguration.mEnabled = optJSONObject4.optBoolean(RNGestureHandlerModule.KEY_ENABLED, false);
            if (optJSONObject4.isNull("googleAuthorizationFingerprint")) {
                str8 = null;
            } else {
                str8 = optJSONObject4.optString("googleAuthorizationFingerprint", null);
            }
            googlePaymentConfiguration.mGoogleAuthorizationFingerprint = str8;
            if (optJSONObject4.isNull(PaymentConstants.ENV)) {
                str9 = null;
            } else {
                str9 = optJSONObject4.optString(PaymentConstants.ENV, null);
            }
            googlePaymentConfiguration.mEnvironment = str9;
            if (!optJSONObject4.isNull("displayName")) {
                optJSONObject4.optString("displayName", "");
            }
            if (optJSONObject4.isNull("paypalClientId")) {
                str10 = "";
            } else {
                str10 = optJSONObject4.optString("paypalClientId", "");
            }
            googlePaymentConfiguration.mPayPalClientId = str10;
            JSONArray optJSONArray2 = optJSONObject4.optJSONArray("supportedNetworks");
            if (optJSONArray2 != null) {
                googlePaymentConfiguration.mSupportedNetworks = new String[optJSONArray2.length()];
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    try {
                        googlePaymentConfiguration.mSupportedNetworks[i2] = optJSONArray2.getString(i2);
                    } catch (JSONException unused) {
                    }
                }
            } else {
                googlePaymentConfiguration.mSupportedNetworks = new String[0];
            }
            this.mGooglePaymentConfiguration = googlePaymentConfiguration;
            this.mThreeDSecureEnabled = jSONObject.optBoolean("threeDSecureEnabled", false);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("payWithVenmo");
            optJSONObject5 = optJSONObject5 == null ? new JSONObject() : optJSONObject5;
            VenmoConfiguration venmoConfiguration = new VenmoConfiguration();
            if (optJSONObject5.isNull("accessToken")) {
                str11 = "";
            } else {
                str11 = optJSONObject5.optString("accessToken", "");
            }
            venmoConfiguration.mAccessToken = str11;
            if (optJSONObject5.isNull(PaymentConstants.ENV)) {
                str12 = "";
            } else {
                str12 = optJSONObject5.optString(PaymentConstants.ENV, "");
            }
            venmoConfiguration.mEnvironment = str12;
            if (optJSONObject5.isNull(PaymentConstants.MERCHANT_ID_CAMEL)) {
                str13 = "";
            } else {
                str13 = optJSONObject5.optString(PaymentConstants.MERCHANT_ID_CAMEL, "");
            }
            venmoConfiguration.mMerchantId = str13;
            this.mVenmoConfiguration = venmoConfiguration;
            JSONObject optJSONObject6 = jSONObject.optJSONObject("kount");
            optJSONObject6 = optJSONObject6 == null ? new JSONObject() : optJSONObject6;
            KountConfiguration kountConfiguration = new KountConfiguration();
            if (optJSONObject6.isNull("kountMerchantId")) {
                str14 = "";
            } else {
                str14 = optJSONObject6.optString("kountMerchantId", "");
            }
            kountConfiguration.mKountMerchantId = str14;
            this.mKountConfiguration = kountConfiguration;
            JSONObject optJSONObject7 = jSONObject.optJSONObject("unionPay");
            optJSONObject7 = optJSONObject7 == null ? new JSONObject() : optJSONObject7;
            UnionPayConfiguration unionPayConfiguration = new UnionPayConfiguration();
            unionPayConfiguration.mEnabled = optJSONObject7.optBoolean(RNGestureHandlerModule.KEY_ENABLED, false);
            this.mUnionPayConfiguration = unionPayConfiguration;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("visaCheckout");
            optJSONObject8 = optJSONObject8 == null ? new JSONObject() : optJSONObject8;
            if (optJSONObject8.isNull("apikey")) {
                str15 = "";
            } else {
                str15 = optJSONObject8.optString("apikey", "");
            }
            str15.equals("");
            if (!optJSONObject8.isNull("externalClientId")) {
                optJSONObject8.optString("externalClientId", "");
            }
            Set<String> supportedCardTypes = CardConfiguration.fromJson(optJSONObject8).getSupportedCardTypes();
            ArrayList arrayList = new ArrayList();
            for (String lowerCase : supportedCardTypes) {
                String lowerCase2 = lowerCase.toLowerCase(Locale.ROOT);
                char c2 = 65535;
                switch (lowerCase2.hashCode()) {
                    case -2038717326:
                        if (lowerCase2.equals("mastercard")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1120637072:
                        if (lowerCase2.equals("american express")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3619905:
                        if (lowerCase2.equals("visa")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 273184745:
                        if (lowerCase2.equals("discover")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    arrayList.add(PaymentActivity.CARD_I_AUTHORITY_VISA);
                } else if (c2 == 1) {
                    arrayList.add("MASTERCARD");
                } else if (c2 == 2) {
                    arrayList.add(PaymentActivity.CARD_I_AUTHORITY_DISCOVER);
                } else if (c2 == 3) {
                    arrayList.add(PaymentActivity.CARD_I_AUTHORITY_AMEX);
                }
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("graphQL");
            optJSONObject9 = optJSONObject9 == null ? new JSONObject() : optJSONObject9;
            GraphQLConfiguration graphQLConfiguration = new GraphQLConfiguration();
            if (optJSONObject9.isNull("url")) {
                str16 = "";
            } else {
                str16 = optJSONObject9.optString("url", "");
            }
            graphQLConfiguration.mUrl = str16;
            JSONArray optJSONArray3 = optJSONObject9.optJSONArray(SettingsJsonConstants.FEATURES_KEY);
            HashSet hashSet = new HashSet();
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    hashSet.add(optJSONArray3.optString(i3, ""));
                }
            }
            graphQLConfiguration.mFeatures = hashSet;
            this.mGraphQLConfiguration = graphQLConfiguration;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("samsungPay");
            HashSet hashSet2 = new HashSet();
            optJSONObject10 = optJSONObject10 == null ? new JSONObject() : optJSONObject10;
            if (!optJSONObject10.isNull("displayName")) {
                optJSONObject10.optString("displayName", "");
            }
            if (!optJSONObject10.isNull("serviceId")) {
                optJSONObject10.optString("serviceId", "");
            }
            try {
                JSONArray jSONArray = optJSONObject10.getJSONArray("supportedCardBrands");
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    hashSet2.add(jSONArray.getString(i4));
                }
            } catch (JSONException unused2) {
            }
            if (!optJSONObject10.isNull("samsungAuthorization")) {
                optJSONObject10.optString("samsungAuthorization", "");
            }
            if (!optJSONObject10.isNull(PaymentConstants.ENV)) {
                optJSONObject10.optString(PaymentConstants.ENV, "");
            }
            this.mCardinalAuthenticationJwt = !jSONObject.isNull("cardinalAuthenticationJWT") ? jSONObject.optString("cardinalAuthenticationJWT", null) : str18;
            return;
        }
        throw new JSONException("Configuration cannot be null");
    }
}
