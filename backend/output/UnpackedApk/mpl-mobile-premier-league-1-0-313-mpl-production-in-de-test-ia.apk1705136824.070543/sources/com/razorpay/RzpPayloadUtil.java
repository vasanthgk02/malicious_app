package com.razorpay;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.mpl.payment.routing.RoutingConstants;
import com.paynimo.android.payment.PaymentActivity;
import com.rudderstack.android.sdk.core.RudderTraits;
import in.juspay.hypersdk.core.InflateView;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RzpPayloadUtil {
    public static JSONArray getAllowedCardNetworks() {
        return new JSONArray().put("MASTERCARD").put(PaymentActivity.CARD_I_AUTHORITY_VISA);
    }

    public static JSONObject getBaseCardPaymentMethod() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "CARD");
            jSONObject.put(BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY, new JSONObject().put("allowedCardNetworks", getAllowedCardNetworks()));
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject getBaseRequest() {
        try {
            return new JSONObject().put("apiVersion", 2).put("apiVersionMinor", 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject getBaseUPIPaymentMethod() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "UPI");
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject getIsReadyToPayRequest() {
        try {
            JSONObject baseRequest = getBaseRequest();
            baseRequest.put("allowedPaymentMethods", new JSONArray().put(getBaseCardPaymentMethod()).put(getBaseUPIPaymentMethod()));
            return baseRequest;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String getPaymentRequestData(String str, JSONObject jSONObject) {
        try {
            JSONObject upiData = getUpiData(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("apiVersion", 2);
            jSONObject2.put("apiVersionMinor", 0);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("totalPriceStatus", "FINAL");
            jSONObject3.put("totalPrice", new BigDecimal(String.valueOf(jSONObject.getLong("amount"))).divide(new BigDecimal(100)).toPlainString());
            jSONObject3.put("currencyCode", jSONObject.getString("currency"));
            jSONObject3.put("transactionNote", upiData.get("description"));
            jSONObject2.put("transactionInfo", jSONObject3);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", "UPI");
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("payeeVpa", upiData.get(RudderTraits.ADDRESS_KEY));
            jSONObject5.put("payeeName", upiData.get("name"));
            jSONObject5.put(PaymentConstants.MCC, upiData.get("mc"));
            jSONObject5.put(RoutingConstants.KILLBILL_TPSL_TRANSACTION_REFERENCE_ID, upiData.get("transactionRefId"));
            jSONObject4.put(BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY, jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("type", "DIRECT");
            jSONObject4.put("tokenizationSpecification", jSONObject6);
            jSONArray.put(jSONObject4);
            jSONObject2.put("allowedPaymentMethods", jSONArray);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject getUpiData(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!str.startsWith("upi://")) {
                str = new JSONObject(new JSONObject(str).getString("data")).getString("intent_url");
            }
            if (str.contains("//")) {
                try {
                    Map<String, String> splitQuery = splitQuery(new URL(str.replaceFirst("upi://", "http://")));
                    if (!TextUtils.isEmpty(splitQuery.get("pa"))) {
                        jSONObject.put(RudderTraits.ADDRESS_KEY, splitQuery.get("pa"));
                    }
                    if (!TextUtils.isEmpty(splitQuery.get("pn"))) {
                        jSONObject.put("name", splitQuery.get("pn"));
                    }
                    if (!TextUtils.isEmpty(splitQuery.get("am"))) {
                        jSONObject.put("amount", splitQuery.get("am"));
                    }
                    if (!TextUtils.isEmpty(splitQuery.get("tn"))) {
                        jSONObject.put("description", splitQuery.get("tn"));
                    }
                    if (!TextUtils.isEmpty(splitQuery.get("tr"))) {
                        jSONObject.put("transactionRefId", splitQuery.get("tr"));
                    }
                    if (!TextUtils.isEmpty(splitQuery.get("mc"))) {
                        jSONObject.put("mc", splitQuery.get("mc"));
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                } catch (MalformedURLException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static String makeApiPayload(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            sb.append(String.format("%s=%s&", new Object[]{next, Uri.encode(jSONObject.getString(next))}));
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String makeErrorPayload(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", str);
            jSONObject2.put("description", str2);
            jSONObject.put("error", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "{\"error\":{\"code\": \"BAD_REQUEST_ERROR\", \"description\": \"An unknown error occurred.\"}}";
        }
    }

    public static String makeExternalSDKPayload(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("type", "gpay_inapp");
            jSONObject2.put("apiResponse", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("provider", "GOOGLE_PAY");
            jSONObject3.put("data", jSONObject2);
            return jSONObject3.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : url.getQuery().split("&")) {
            int indexOf = str.indexOf(InflateView.SETTER_EQUALS);
            linkedHashMap.put(URLDecoder.decode(str.substring(0, indexOf), "UTF-8"), URLDecoder.decode(str.substring(indexOf + 1), "UTF-8"));
        }
        return linkedHashMap;
    }
}
