package com.razorpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.p000authapiphone.zzab;
import com.mpl.androidapp.login.LoginReactModule;
import com.paynimo.android.payment.util.Constant;
import com.razorpay.AdvertisingIdUtil.d__1_;
import com.reactnativecommunity.webview.RNCWebViewManager;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseRazorpay implements OnAppSelectedListener, PaymentCompleteInternalCallback, RzpInternalCallback {
    public static final int INVALID_OPTIONS = 3;
    public static final int NETWORK_ERROR = 2;
    public static final int PARSING_ERROR = 4;
    public static final int PAYMENT_CANCELED = 0;
    public static final int PAYMENT_ERROR = 5;
    public static String R$$r_ = "https://api.razorpay.com/v1/";
    public static final int TLS_ERROR = 6;
    public static int b__J_;
    public String B$$W$;
    public String D$_X_;
    public ArrayList<String> E$_6$;
    public boolean E$_j$ = false;
    public RazorpayWebViewClient G__G_;
    public boolean J$_0_;
    public ArrayList<String> L__R$;
    public HashSet<String> O_$B_;
    public RazorpayWebChromeClient Q_$2$;
    public HashMap<String, ApplicationDetails> Y$_o$;
    public String a_$P$;
    public Activity activity;
    public String apiKey;
    public HashSet<String> c__C_ = new HashSet<>();
    public JSONObject d__1_ = new JSONObject();
    public RzpPlugin extActiveRzpPluginInstance;
    public ArrayList<String> f$_G$;
    public boolean isExtRzpPluginActive = false;
    public HashSet<String> l_$w$ = new HashSet<>();
    public LinkedHashSet<String> l__d$ = new LinkedHashSet<>();
    public boolean mShouldDisplayLogo = true;
    public ViewGroup magicView;
    public PaymentResultListener paymentResultListener;
    public PaymentResultWithDataListener paymentResultWithDataListener;
    public String r$_Y_;
    public boolean useBottomSheet = true;
    public WebView webview;

    public interface G__G_ {
        void Q_$2$(String str);

        void a_$P$(String str);
    }

    public interface PaymentMethodsCallback {
        void onError(String str);

        void onPaymentMethodsReceived(String str);
    }

    public interface SubscriptionAmountCallback {
        void onError(String str);

        void onSubscriptionAmountReceived(long j);
    }

    public interface ValidationListener {
        void onValidationError(Map<String, String> map);

        void onValidationSuccess();
    }

    public BaseRazorpay(Activity activity2, String str) {
        this.apiKey = str;
        R$$r_(activity2);
    }

    private void B$$W$() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.Y$_o$.keySet());
        this.E$_6$ = new ArrayList<>();
        Iterator<String> it = this.l__d$.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.Y$_o$.containsKey(next)) {
                arrayList.remove(next);
                this.E$_6$.add(next);
            }
        }
        this.E$_6$.addAll(arrayList);
    }

    public static PaymentData Q_$2$(JSONObject jSONObject) {
        PaymentData paymentData = new PaymentData();
        try {
            paymentData.Q_$2$(jSONObject);
            if (jSONObject.has("razorpay_payment_id")) {
                paymentData.Q_$2$(jSONObject.getString("razorpay_payment_id"));
            }
            if (jSONObject.has("razorpay_order_id")) {
                paymentData.a_$P$(jSONObject.getString("razorpay_order_id"));
            }
            if (jSONObject.has("razorpay_signature")) {
                paymentData.R$$r_(jSONObject.getString("razorpay_signature"));
            }
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
        }
        return paymentData;
    }

    public static /* synthetic */ void R$$r_(BaseRazorpay baseRazorpay, JSONObject jSONObject) {
        try {
            if (jSONObject.has("error")) {
                int i = 5;
                AnalyticsUtil.addProperty("payment_status", new AnalyticsProperty((String) "fail", AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.addProperty("payload", new AnalyticsProperty(jSONObject.toString(), AnalyticsProperty$R$$r_.PAYMENT));
                if (jSONObject.has("sdk_error_code")) {
                    i = jSONObject.getInt("sdk_error_code");
                    jSONObject.remove("sdk_error_code");
                }
                AnalyticsUtil.addProperty("return code", new AnalyticsProperty(i, AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PAYMENT_COMPLETE);
                baseRazorpay.R$$r_(i, jSONObject.toString());
            } else if (jSONObject.has("razorpay_payment_id")) {
                PaymentData Q_$2$2 = Q_$2$(jSONObject);
                AnalyticsUtil.addProperty("payment_id", new AnalyticsProperty(Q_$2$2.getPaymentId(), AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.addProperty("payment_status", new AnalyticsProperty((String) "success", AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.addProperty("payload", new AnalyticsProperty(jSONObject.toString(), AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PAYMENT_COMPLETE);
                O__Y_.Q_$2$(baseRazorpay.activity).putBoolean("rzp_last_payment_status", true).apply();
                String paymentId = Q_$2$2.getPaymentId();
                if (baseRazorpay.paymentResultListener != null) {
                    baseRazorpay.paymentResultListener.onPaymentSuccess(paymentId);
                    return;
                }
                if (baseRazorpay.paymentResultWithDataListener != null) {
                    baseRazorpay.paymentResultWithDataListener.onPaymentSuccess(paymentId, Q_$2$2);
                }
            } else {
                AnalyticsUtil.addProperty("payment_status", new AnalyticsProperty((String) "fail", AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.addProperty("payload", new AnalyticsProperty(jSONObject.toString(), AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.addProperty("return code", new AnalyticsProperty((String) "4", AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PAYMENT_COMPLETE);
                baseRazorpay.R$$r_(4, (String) "Post payment parsing error");
            }
        } catch (Exception e2) {
            baseRazorpay.R$$r_(4, e2.getMessage());
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
        }
    }

    public static long calculateEmi(long j, int i, double d2) {
        double d3 = d2 / 1200.0d;
        double pow = Math.pow(d3 + 1.0d, (double) i);
        return Math.round(((((double) j) * d3) * pow) / (pow - 1.0d));
    }

    public static boolean canShowUpiIntentMethod(Context context) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_SHOULD_SHOW_UPI_INTENT_METHOD);
        HashSet<String> G__G_2 = G__G_(context);
        return G__G_2 != null && !G__G_2.isEmpty();
    }

    public static /* synthetic */ int d__1_() {
        int i = b__J_;
        b__J_ = i + 1;
        return i;
    }

    public static void getAppsWhichSupportUpi(final Context context, final RzpUpiSupportedAppsCallback rzpUpiSupportedAppsCallback) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_GET_APPS_SUPPORTING_UPI);
        final HashMap<String, String> allPluginsFromManifest = BaseUtils.getAllPluginsFromManifest(context);
        if (allPluginsFromManifest == null || allPluginsFromManifest.size() == 0) {
            rzpUpiSupportedAppsCallback.onReceiveUpiSupportedApps(d__1_(context));
            return;
        }
        for (String loadClass : allPluginsFromManifest.values()) {
            try {
                ((RzpPlugin) RzpPlugin.class.getClassLoader().loadClass(loadClass).newInstance()).isRegistered(context, new RzpPluginRegisterCallback() {
                    public final void onResponse(boolean z) {
                        BaseRazorpay.d__1_();
                        if (BaseRazorpay.b__J_ == allPluginsFromManifest.size()) {
                            BaseRazorpay.b__J_ = 0;
                            rzpUpiSupportedAppsCallback.onReceiveUpiSupportedApps(BaseRazorpay.d__1_(context));
                        }
                    }
                });
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, "critical", e2.getLocalizedMessage());
            }
        }
    }

    public static long r$_Y_(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("subscription");
            if (jSONObject != null) {
                return jSONObject.getLong("amount");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
        }
        return 0;
    }

    public abstract void Q_$2$();

    public void Q_$2$(WebView webView, String str) {
    }

    public abstract void Q_$2$(String str);

    @JavascriptInterface
    public final void callNativeIntent(String str) {
        this.a_$P$ = str;
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_CALLED);
        try {
            if (this.d__1_.has(AnalyticsConstants.UPI_APP_PACKAGE_NAME) && this.d__1_.getString(AnalyticsConstants.UPI_APP_PACKAGE_NAME).equals(BaseConstants.GOOGLE_PAY_PKG)) {
                openUpiApp(BaseConstants.GOOGLE_PAY_PKG, this.a_$P$);
            } else if (this.r$_Y_ == null || !this.O_$B_.contains(this.r$_Y_)) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_CUSTOM_APP_CHOOSER_SHOWN);
                Bundle bundle = new Bundle();
                bundle.putString("url_data", str);
                bundle.putStringArrayList("merchant_preferred_upi_apps_order", this.f$_G$);
                bundle.putStringArrayList("merchant_other_upi_apps_order", this.L__R$);
                bundle.putStringArrayList("list_remaining_apps", this.E$_6$);
                bundle.putSerializable("upi_package_to_app_details", this.Y$_o$);
                AppSelectorFragment appSelectorFragment = new AppSelectorFragment();
                appSelectorFragment.Q_$2$ = this;
                appSelectorFragment.setArguments(bundle);
                this.activity.getFragmentManager().beginTransaction().add(16908290, appSelectorFragment, "AppSelectorFragment").addToBackStack("AppSelectorFragment").commitAllowingStateLoss();
            } else {
                BaseUtils.startActivityForResult(str, this.r$_Y_, this.activity);
                HashMap hashMap = new HashMap();
                if (str == null) {
                    str = "null";
                }
                hashMap.put("url", str);
                hashMap.put("custom_chooser", Boolean.FALSE);
                hashMap.put("package_name", this.r$_Y_);
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_MERCHANT_PASSED_APP_LAUNCHED, (Map<String, Object>) hashMap);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
        }
    }

    public void changeApiKey(String str) {
        com.razorpay.AdvertisingIdUtil.AnonymousClass1.R$$r_(BaseConstants.PAYMENT_PREFERENCES_CACHE_KEY, "", -1);
        this.apiKey = str;
        R$$r_(this.activity);
    }

    public void d__1_(WebView webView, int i) {
    }

    public void d__1_(WebView webView, String str) {
    }

    public void finish() {
        AnalyticsUtil.postData();
        AnalyticsUtil.refreshOrderSession();
        this.B$$W$ = null;
        this.E$_j$ = false;
        this.webview.loadUrl(RNCWebViewManager.BLANK_URL);
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof B_$q$) {
            Thread.setDefaultUncaughtExceptionHandler(((B_$q$) defaultUncaughtExceptionHandler).Q_$2$);
        }
    }

    public String getBankLogoUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(b__J_.L__R$().T__j$());
        sb.append(str);
        sb.append(".");
        sb.append(b__J_.L__R$().Y_$B$());
        return sb.toString();
    }

    public String getCardNetwork(String str) {
        return J$$A_.R$$r_(str);
    }

    public int getCardNetworkLength(String str) {
        return J$$A_.a_$P$(str);
    }

    public void getPaymentMethods(PaymentMethodsCallback paymentMethodsCallback) {
        getPaymentMethods(null, paymentMethodsCallback);
    }

    public void getSubscriptionAmount(String str, final SubscriptionAmountCallback subscriptionAmountCallback) {
        Q_$2$(str, (G__G_) new G__G_() {
            public final void Q_$2$(String str) {
                subscriptionAmountCallback.onSubscriptionAmountReceived(BaseRazorpay.r$_Y_(str));
            }

            public final void a_$P$(String str) {
                subscriptionAmountCallback.onError(str);
            }
        });
    }

    public String getWalletLogoUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(b__J_.L__R$().J$$A_());
        sb.append(str);
        sb.append(".");
        sb.append(b__J_.L__R$().h__y_());
        return sb.toString();
    }

    public String getWalletSqLogoUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(b__J_.L__R$().K$$z$());
        sb.append(str);
        sb.append(".");
        sb.append(b__J_.L__R$().I$_e_());
        return sb.toString();
    }

    public boolean isValidCardNumber(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        for (int i = 0; i < str.length(); i++) {
            iArr[i] = Integer.parseInt(String.valueOf(Character.valueOf(str.charAt(i))));
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[(length - i3) - 1];
            if (i3 % 2 == 1) {
                i4 <<= 1;
            }
            if (i4 > 9) {
                i4 -= 9;
            }
            i2 += i4;
        }
        return i2 % 10 == 0;
    }

    public void isValidVpa(String str, final ValidateVpaCallback validateVpaCallback) {
        if (str.isEmpty()) {
            validateVpaCallback.onFailure();
            return;
        }
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_VALIDATE_VPA_CALLED);
        StringBuilder sb = new StringBuilder();
        sb.append(R$$r_);
        sb.append("payments/validate/account");
        String obj = sb.toString();
        HashMap outline87 = GeneratedOutlineSupport.outline87("Content-Type", "application/x-www-form-urlencoded");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("entity", "vpa");
            jSONObject.put(HSLCriteriaBuilder.VALUE, str);
            jSONObject.put("key_id", this.apiKey);
            l__d$.Q_$2$(obj, BaseUtils.makeUrlEncodedPayload(jSONObject), outline87, new Callback() {
                public final void run(K$$z$ k$$z$) {
                    try {
                        validateVpaCallback.onResponse(new JSONObject(k$$z$.G__G_()).getBoolean("success"));
                    } catch (JSONException e2) {
                        validateVpaCallback.onFailure();
                        e2.printStackTrace();
                        AnalyticsUtil.reportError(e2, "warning", e2.getMessage());
                    }
                }
            });
        } catch (JSONException e2) {
            validateVpaCallback.onFailure();
            e2.printStackTrace();
            AnalyticsUtil.reportError(e2, "warning", e2.getMessage());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent == null) {
            oncomplete("{error:{code: 'BAD_REQUEST_ERROR' , description : 'Payment processing cancelled by user'}}");
            this.activity.getFragmentManager().popBackStack();
        } else if (this.isExtRzpPluginActive) {
            this.extActiveRzpPluginInstance.onActivityResult(this.apiKey, i, i2, intent);
            this.activity.getFragmentManager().popBackStack();
        } else {
            this.activity.getFragmentManager().popBackStack();
            if (i != 1001) {
                if (i == 99) {
                    HashMap hashMap = new HashMap();
                    JSONObject jSONFromIntentData = BaseUtils.getJSONFromIntentData(intent);
                    WebView webView = this.webview;
                    if (webView == null || webView.getUrl() == null || !this.webview.getUrl().contains(BaseConstants.RZP_URL)) {
                        hashMap.put(AnalyticsConstants.ACTIVITY_DESTROYED, Boolean.TRUE);
                        J$$A_.a_$P$(jSONFromIntentData, this.activity, this.apiKey, this);
                    } else {
                        hashMap.put(AnalyticsConstants.ACTIVITY_DESTROYED, Boolean.FALSE);
                        try {
                            jSONFromIntentData.put("isWebviewVisible", this.webview.getVisibility() == 0);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                        }
                        this.webview.loadUrl(String.format("javascript: appLaunched(%s)", new Object[]{this.D$_X_}));
                        this.webview.loadUrl(String.format("javascript: pollStatus(%s)", new Object[]{jSONFromIntentData.toString()}));
                    }
                    hashMap.put(LoginReactModule.RESULT, jSONFromIntentData);
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_ONACTIVITY_RESULT, (Map<String, Object>) hashMap);
                }
            } else if (i2 == -1) {
                Q_$2$(intent);
            } else {
                AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_CONSENT_DECLINED);
            }
        }
    }

    public void onBackPressed() {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_BACK_PRESSED_HARD);
        if (this.E$_j$) {
            Q_$2$();
            if (this.B$$W$ != null) {
                try {
                    String constructBasicAuth = BaseUtils.constructBasicAuth(this.apiKey);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Authorization", "Basic ".concat(String.valueOf(constructBasicAuth)));
                    StringBuilder sb = new StringBuilder(BaseConstants.RZP_PAYMENTS_ENDPOINT);
                    sb.append(this.B$$W$);
                    sb.append("/cancel?platform=android_sdk");
                    l__d$.G__G_(sb.toString(), hashMap, new Callback() {
                        public final void run(K$$z$ k$$z$) {
                            StringBuilder sb = new StringBuilder("API Cancel hit: ");
                            sb.append(k$$z$.G__G_());
                            sb.toString();
                        }
                    });
                    this.B$$W$ = null;
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder("Exception in cancel req: ");
                    sb2.append(e2.getMessage());
                    sb2.toString();
                    AnalyticsUtil.reportError(e2, "warning", e2.getMessage());
                }
            }
        }
        finish();
    }

    public void onPaymentError(int i, String str) {
        HashMap outline87 = GeneratedOutlineSupport.outline87(Constant.TAG_RESPONSE, str);
        outline87.put("code", Integer.valueOf(i));
        AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PLUGIN_INTERNAL_CALLBACK_ERROR, (Map<String, Object>) outline87);
        try {
            oncomplete(new JSONObject(str).toString());
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "critical", e2.getLocalizedMessage());
            AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PLUGIN_INTERNAL_CALLBACK_ERROR_EXCEPTION);
            oncomplete(str);
        }
    }

    public void onPaymentSuccess(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("provider") && jSONObject.get("provider").equals("GOOGLE_PAY")) {
                HashMap hashMap = new HashMap();
                if (this.webview != null) {
                    if (this.webview.getUrl() != null && this.webview.getUrl().contains(BaseConstants.RZP_URL)) {
                        hashMap.put(AnalyticsConstants.ACTIVITY_DESTROYED, Boolean.FALSE);
                        try {
                            jSONObject.put("isWebviewVisible", this.webview.getVisibility() == 0);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                        }
                        this.webview.loadUrl(String.format("javascript: pollStatus(%s)", new Object[]{jSONObject.toString()}));
                        hashMap.put(LoginReactModule.RESULT, jSONObject);
                        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_ONACTIVITY_RESULT, (Map<String, Object>) hashMap);
                    }
                }
                hashMap.put(AnalyticsConstants.ACTIVITY_DESTROYED, Boolean.TRUE);
                J$$A_.a_$P$(jSONObject, this.activity, this.apiKey, this);
                hashMap.put(LoginReactModule.RESULT, jSONObject);
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_ONACTIVITY_RESULT, (Map<String, Object>) hashMap);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
            AnalyticsUtil.reportError(e3, "error", e3.getMessage());
        }
    }

    public void onUpiAppLaunched(String str, String str2) {
        this.D$_X_ = str;
    }

    @JavascriptInterface
    public final void oncomplete(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                O__Y_.G__G_(BaseRazorpay.this.activity, "razorpay_payment_id", null);
                try {
                    BaseRazorpay.R$$r_(BaseRazorpay.this, new JSONObject(str));
                } catch (Exception e2) {
                    BaseRazorpay.this.R$$r_(4, e2.getMessage());
                    AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                }
                BaseRazorpay.this.finish();
            }
        });
    }

    public void openCheckout(JSONObject jSONObject, PaymentResultListener paymentResultListener2) throws Exception {
        this.paymentResultListener = paymentResultListener2;
        openCheckout(jSONObject);
    }

    public void openUpiApp(String str, String str2) {
        HashMap<String, String> allPluginsFromManifest = BaseUtils.getAllPluginsFromManifest(this.activity);
        if (!(allPluginsFromManifest == null || allPluginsFromManifest.size() == 0)) {
            if (str.equalsIgnoreCase(BaseConstants.GOOGLE_PAY_PKG) && allPluginsFromManifest.containsKey("com.razorpay.plugin.googlepay")) {
                for (String loadClass : allPluginsFromManifest.values()) {
                    try {
                        RzpPlugin rzpPlugin = (RzpPlugin) RzpPlugin.class.getClassLoader().loadClass(loadClass).newInstance();
                        if (str.equalsIgnoreCase(BaseConstants.GOOGLE_PAY_PKG)) {
                            rzpPlugin.isRegistered(this.activity, new RzpPluginRegisterCallback() {
                                public final void onResponse(boolean z) {
                                }
                            });
                            try {
                                this.d__1_.put("_[app]", str);
                                this.d__1_.put("url_data", str2);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                            }
                        }
                        if (rzpPlugin.doesHandlePayload(this.apiKey, this.d__1_, this.activity)) {
                            this.isExtRzpPluginActive = true;
                            this.extActiveRzpPluginInstance = rzpPlugin;
                            rzpPlugin.processPayment(this.apiKey, this.d__1_, this.activity, this);
                            return;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NullPointerException e3) {
                        a_$P$(str, str2);
                        e3.printStackTrace();
                        AnalyticsUtil.reportError(e3, "error", e3.getMessage());
                    }
                }
                return;
            }
        }
        a_$P$(str, str2);
    }

    public final void reset() {
        finish();
    }

    public final void setMagicView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.magicView = viewGroup;
            this.useBottomSheet = false;
            return;
        }
        throw new RuntimeException("Magic View cannot be null");
    }

    @JavascriptInterface
    public final void setPaymentID(String str) {
        "setPaymentID called: ".concat(String.valueOf(str));
        this.B$$W$ = str;
        Q_$2$(str);
        AnalyticsUtil.addProperty("payment_id", new AnalyticsProperty(str, AnalyticsProperty$R$$r_.PAYMENT));
        O__Y_.G__G_(this.activity, "razorpay_payment_id", str);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_PAYMENT_ID_ATTACHED);
    }

    public abstract void setUpAddon(JSONObject jSONObject);

    public void setWebChromeClient(RazorpayWebChromeClient razorpayWebChromeClient) {
        this.Q_$2$ = razorpayWebChromeClient;
    }

    public void setWebView(WebView webView) {
        this.webview = webView;
        BaseUtils.setWebViewSettings(this.activity, webView, true);
        webView.clearFormData();
        webView.addJavascriptInterface(this, "CheckoutBridge");
    }

    public void setWebviewClient(RazorpayWebViewClient razorpayWebViewClient) {
        this.G__G_ = razorpayWebViewClient;
    }

    public void submit(JSONObject jSONObject, PaymentResultListener paymentResultListener2) throws Exception {
        this.paymentResultListener = paymentResultListener2;
        submit(jSONObject);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x020b, code lost:
        if (r2 != null) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void validateFields(org.json.JSONObject r10, com.razorpay.BaseRazorpay.ValidationListener r11) {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r0 = "currency"
            java.lang.String r1 = r10.optString(r0)
            boolean r2 = r1.isEmpty()
            r3 = 0
            java.lang.String r4 = "field"
            java.lang.String r5 = "description"
            if (r2 != 0) goto L_0x0025
            java.lang.String r2 = "^[A-Z]{3}$"
            boolean r1 = r1.matches(r2)
            if (r1 != 0) goto L_0x0025
            java.lang.String r1 = "Currency should be 3 characters. Default value is INR"
            java.util.HashMap r0 = com.android.tools.r8.GeneratedOutlineSupport.outline88(r4, r0, r5, r1)
            goto L_0x0026
        L_0x0025:
            r0 = r3
        L_0x0026:
            if (r0 == 0) goto L_0x002b
        L_0x0028:
            r3 = r0
            goto L_0x020f
        L_0x002b:
            java.lang.String r0 = "amount"
            java.lang.String r1 = r10.optString(r0)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0046
            java.lang.String r2 = "^[1-9][0-9]*[0-9]{2}$"
            boolean r1 = r1.matches(r2)
            if (r1 != 0) goto L_0x0046
            java.lang.String r1 = "Amount should be in paise. Minimum value is 100, which is equal to Re. 1"
            java.util.HashMap r0 = com.android.tools.r8.GeneratedOutlineSupport.outline88(r4, r0, r5, r1)
            goto L_0x0047
        L_0x0046:
            r0 = r3
        L_0x0047:
            if (r0 == 0) goto L_0x004a
            goto L_0x0028
        L_0x004a:
            java.lang.String r0 = "contact"
            java.lang.String r1 = r10.optString(r0)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            boolean r6 = r1.isEmpty()
            if (r6 != 0) goto L_0x0086
            int r6 = r1.length()
            r7 = 10
            if (r6 < r7) goto L_0x007d
            int r6 = r1.length()
            r7 = 15
            if (r6 <= r7) goto L_0x006c
            goto L_0x007d
        L_0x006c:
            java.lang.String r6 = "^[0-9()\\+]?[0-9()\\- ]*$"
            boolean r1 = r1.matches(r6)
            if (r1 != 0) goto L_0x0086
            r2.put(r4, r0)
            java.lang.String r0 = "Contact can only include + in the start and following characters: + - (  ) 0-9 space"
            r2.put(r5, r0)
            goto L_0x0087
        L_0x007d:
            r2.put(r4, r0)
            java.lang.String r0 = "Contact length should be between [10-15]"
            r2.put(r5, r0)
            goto L_0x0087
        L_0x0086:
            r2 = r3
        L_0x0087:
            if (r2 == 0) goto L_0x008c
        L_0x0089:
            r3 = r2
            goto L_0x020f
        L_0x008c:
            java.lang.String r0 = "email"
            java.lang.String r1 = r10.optString(r0)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            boolean r6 = r1.isEmpty()
            if (r6 != 0) goto L_0x00bf
            int r6 = r1.length()
            r7 = 255(0xff, float:3.57E-43)
            if (r6 <= r7) goto L_0x00ae
            r2.put(r4, r0)
            java.lang.String r0 = "email cannot be longer than 255 characters"
            r2.put(r5, r0)
            goto L_0x00c0
        L_0x00ae:
            java.lang.String r6 = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$"
            boolean r1 = r1.matches(r6)
            if (r1 != 0) goto L_0x00bf
            r2.put(r4, r0)
            java.lang.String r0 = "Email validation failed"
            r2.put(r5, r0)
            goto L_0x00c0
        L_0x00bf:
            r2 = r3
        L_0x00c0:
            if (r2 == 0) goto L_0x00c4
            goto L_0x020d
        L_0x00c4:
            java.lang.String r0 = "method"
            java.lang.String r1 = r10.optString(r0)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            boolean r6 = r1.isEmpty()
            r7 = 1
            if (r6 != r7) goto L_0x00e0
            r2.put(r4, r0)
            java.lang.String r10 = "method is a required field"
            r2.put(r5, r10)
            goto L_0x020b
        L_0x00e0:
            java.lang.String r0 = "card"
            boolean r0 = r1.equals(r0)
            if (r0 != r7) goto L_0x020a
            java.lang.String r0 = "card[name]"
            java.lang.String r1 = r10.optString(r0)
            java.util.HashMap r0 = com.android.tools.r8.GeneratedOutlineSupport.outline87(r4, r0)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x010b
            java.lang.String r2 = "^[a-zA-Z. ]*$"
            boolean r1 = r1.matches(r2)
            if (r1 != 0) goto L_0x010b
            java.lang.String r1 = "name"
            r0.put(r4, r1)
            java.lang.String r1 = ""
            r0.put(r5, r1)
            goto L_0x010c
        L_0x010b:
            r0 = r3
        L_0x010c:
            if (r0 == 0) goto L_0x0110
            goto L_0x0206
        L_0x0110:
            java.lang.String r0 = "card[number]"
            java.lang.String r0 = r10.optString(r0)
            java.lang.String r1 = "card_number"
            java.util.HashMap r1 = com.android.tools.r8.GeneratedOutlineSupport.outline87(r4, r1)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0148
            int r2 = r0.length()
            r6 = 13
            if (r2 < r6) goto L_0x0141
            int r2 = r0.length()
            r6 = 19
            if (r2 <= r6) goto L_0x0133
            goto L_0x0141
        L_0x0133:
            java.lang.String r2 = "^[0-9]*"
            boolean r0 = r0.matches(r2)
            if (r0 != 0) goto L_0x0148
            java.lang.String r0 = "Card number can only have digits 0-9"
            r1.put(r5, r0)
            goto L_0x0146
        L_0x0141:
            java.lang.String r0 = "Card number cannot have lesser than 13 digits or more than 19 digits"
            r1.put(r5, r0)
        L_0x0146:
            r0 = r1
            goto L_0x0149
        L_0x0148:
            r0 = r3
        L_0x0149:
            if (r0 == 0) goto L_0x014d
            goto L_0x0206
        L_0x014d:
            java.lang.String r0 = "card[expiry_month]"
            java.lang.String r1 = r10.optString(r0)
            java.util.HashMap r0 = com.android.tools.r8.GeneratedOutlineSupport.outline87(r4, r0)
            boolean r2 = r1.isEmpty()
            r6 = 2
            java.lang.String r8 = "0"
            if (r2 != 0) goto L_0x0184
            int r2 = r1.length()
            if (r2 != r7) goto L_0x016a
            java.lang.String r1 = r8.concat(r1)
        L_0x016a:
            int r2 = r1.length()
            if (r2 <= r6) goto L_0x0176
            java.lang.String r1 = "Card expiry month needs to be between 01-12"
            r0.put(r5, r1)
            goto L_0x01b8
        L_0x0176:
            java.lang.String r2 = "^(0[1-9]|1[0-2])$"
            boolean r1 = r1.matches(r2)
            if (r1 != 0) goto L_0x0184
            java.lang.String r1 = "Card expiry month can only have digits 0-9"
            r0.put(r5, r1)
            goto L_0x01b8
        L_0x0184:
            java.lang.String r1 = "card[expiry_year]"
            java.lang.String r2 = r10.optString(r1)
            r0.put(r4, r1)
            boolean r1 = r2.isEmpty()
            if (r1 != 0) goto L_0x01b7
            int r1 = r2.length()
            if (r1 != r7) goto L_0x019d
            java.lang.String r2 = r8.concat(r2)
        L_0x019d:
            int r1 = r2.length()
            if (r1 <= r6) goto L_0x01a9
            java.lang.String r1 = "Card expiry year needs to be two digits"
            r0.put(r5, r1)
            goto L_0x01b8
        L_0x01a9:
            java.lang.String r1 = "^[1-9][0-9]$"
            boolean r1 = r2.matches(r1)
            if (r1 != 0) goto L_0x01b7
            java.lang.String r1 = "Card expiry year can only have digits 0-9"
            r0.put(r5, r1)
            goto L_0x01b8
        L_0x01b7:
            r0 = r3
        L_0x01b8:
            if (r0 == 0) goto L_0x01bb
            goto L_0x0206
        L_0x01bb:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "card[cvv]"
            java.lang.String r10 = r10.optString(r1)
            r0.put(r4, r1)
            boolean r1 = r10.isEmpty()
            if (r1 != 0) goto L_0x0201
            int r1 = r10.length()
            if (r1 != r7) goto L_0x01d9
            java.lang.String r10 = r8.concat(r10)
        L_0x01d9:
            int r1 = r10.length()
            r2 = 3
            if (r1 < r2) goto L_0x01fb
            int r1 = r10.length()
            r2 = 4
            if (r1 <= r2) goto L_0x01e8
            goto L_0x01fb
        L_0x01e8:
            java.lang.String r1 = "^[0-9]{3,4}$"
            boolean r10 = r10.matches(r1)
            if (r10 != 0) goto L_0x0201
            java.lang.String r10 = "cvv"
            r0.put(r4, r10)
            java.lang.String r10 = "Card cvv can only have digits 0-9"
            r0.put(r5, r10)
            goto L_0x0202
        L_0x01fb:
            java.lang.String r10 = "Card cvv needs to be in 3 or 4 digits"
            r0.put(r5, r10)
            goto L_0x0202
        L_0x0201:
            r0 = r3
        L_0x0202:
            if (r0 == 0) goto L_0x0205
            goto L_0x0206
        L_0x0205:
            r0 = r3
        L_0x0206:
            if (r0 == 0) goto L_0x020a
            r2 = r0
            goto L_0x020b
        L_0x020a:
            r2 = r3
        L_0x020b:
            if (r2 == 0) goto L_0x020f
        L_0x020d:
            goto L_0x0089
        L_0x020f:
            if (r3 != 0) goto L_0x0215
            r11.onValidationSuccess()
            return
        L_0x0215:
            r11.onValidationError(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseRazorpay.validateFields(org.json.JSONObject, com.razorpay.BaseRazorpay$ValidationListener):void");
    }

    private String R$$r_(String str) {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "<input type='hidden' name='_[checkout_id]' value='");
        outline78.append(AnalyticsUtil.getLocalOrderId());
        outline78.append("'>");
        String obj = outline78.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append("<input type='hidden' name='_[os]' value='android'>");
        StringBuilder outline782 = GeneratedOutlineSupport.outline78(sb.toString(), "<input type='hidden' name='_[package_name]' value='");
        outline782.append(this.activity.getPackageName());
        outline782.append("'>");
        String obj2 = outline782.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj2);
        sb2.append("<input type='hidden' name='_[platform]' value='mobile_sdk'>");
        StringBuilder outline783 = GeneratedOutlineSupport.outline78(sb2.toString(), "<input type='hidden' name='_[cellular_network_type]' value=");
        outline783.append(BaseUtils.getCellularNetworkType(this.activity));
        outline783.append(">");
        StringBuilder outline784 = GeneratedOutlineSupport.outline78(outline783.toString(), "<input type='hidden' name='_[data_network_type]' value='");
        outline784.append(BaseUtils.getDataNetworkType(this.activity).Q_$2$());
        outline784.append("'>");
        StringBuilder outline785 = GeneratedOutlineSupport.outline78(outline784.toString(), "<input type='hidden' name='_[locale]' value='");
        outline785.append(BaseUtils.getLocale());
        outline785.append("'>");
        String obj3 = outline785.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj3);
        sb3.append("<input type='hidden' name='_[library]' value='custom'>");
        StringBuilder outline786 = GeneratedOutlineSupport.outline78(sb3.toString(), "<input type='hidden' name='_[library_version]' value='");
        outline786.append(b__J_.G__G_);
        outline786.append("'>");
        return outline786.toString();
    }

    private void a_$P$() {
        this.Y$_o$ = new HashMap<>();
        if (this.J$_0_) {
            Iterator<String> it = this.c__C_.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.O_$B_.contains(next)) {
                    try {
                        HashMap<String, ApplicationDetails> hashMap = this.Y$_o$;
                        Activity activity2 = this.activity;
                        hashMap.put(next, new ApplicationDetails(BaseUtils.getAppNameOfPackageName(next, activity2), BaseUtils.getBase64FromOtherAppsResource(activity2, next), next));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                    }
                }
            }
            return;
        }
        Iterator<String> it2 = this.O_$B_.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!this.l_$w$.contains(next2)) {
                try {
                    HashMap<String, ApplicationDetails> hashMap2 = this.Y$_o$;
                    Activity activity3 = this.activity;
                    hashMap2.put(next2, new ApplicationDetails(BaseUtils.getAppNameOfPackageName(next2, activity3), BaseUtils.getBase64FromOtherAppsResource(activity3, next2), next2));
                } catch (Exception e3) {
                    e3.printStackTrace();
                    AnalyticsUtil.reportError(e3, "error", e3.getMessage());
                }
            }
        }
    }

    public void getPaymentMethods(JSONObject jSONObject, final PaymentMethodsCallback paymentMethodsCallback) {
        String str;
        if (jSONObject != null && jSONObject.has("subscription_id")) {
            try {
                str = jSONObject.getString("subscription_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                AnalyticsUtil.reportError(e2, "error", e2.getMessage());
            }
            Q_$2$(str, (G__G_) new G__G_() {
                public final void Q_$2$(String str) {
                    paymentMethodsCallback.onPaymentMethodsReceived(BaseRazorpay.a_$P$(str));
                }

                public final void a_$P$(String str) {
                    paymentMethodsCallback.onError(str);
                }
            });
        }
        str = null;
        Q_$2$(str, (G__G_) new G__G_() {
            public final void Q_$2$(String str) {
                paymentMethodsCallback.onPaymentMethodsReceived(BaseRazorpay.a_$P$(str));
            }

            public final void a_$P$(String str) {
                paymentMethodsCallback.onError(str);
            }
        });
    }

    public static HashSet<String> G__G_(Context context) {
        HashSet<String> hashSet = new HashSet<>();
        b__J_.L__R$().G__G_(context);
        boolean f$_G$2 = b__J_.L__R$().f$_G$();
        HashSet<String> setOfPackageNamesSupportingUpi = BaseUtils.getSetOfPackageNamesSupportingUpi(context);
        if (f$_G$2) {
            HashSet<String> g__v_ = b__J_.L__R$().g__v_();
            if (g__v_ == null || g__v_.isEmpty()) {
                return new HashSet<>();
            }
            Iterator<String> it = setOfPackageNamesSupportingUpi.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (g__v_.contains(next)) {
                    hashSet.add(next);
                }
            }
        } else {
            HashSet<String> J$_0_2 = b__J_.L__R$().J$_0_();
            if (J$_0_2 != null && !J$_0_2.isEmpty()) {
                Iterator<String> it2 = setOfPackageNamesSupportingUpi.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    if (!J$_0_2.contains(next2)) {
                        hashSet.add(next2);
                    }
                }
            } else if (setOfPackageNamesSupportingUpi != null) {
                return setOfPackageNamesSupportingUpi;
            } else {
                return new HashSet<>();
            }
        }
        return hashSet;
    }

    public static List<ApplicationDetails> d__1_(Context context) {
        HashSet<String> G__G_2 = G__G_(context);
        List<ResolveInfo> listOfAppsWhichHandleDeepLink = BaseUtils.getListOfAppsWhichHandleDeepLink(context, BaseConstants.UPI_URL_SCHEMA);
        ArrayList arrayList = new ArrayList();
        if (listOfAppsWhichHandleDeepLink != null && listOfAppsWhichHandleDeepLink.size() > 0) {
            for (ResolveInfo next : listOfAppsWhichHandleDeepLink) {
                if (G__G_2.contains(next.activityInfo.packageName)) {
                    try {
                        String str = next.activityInfo.packageName;
                        arrayList.add(new ApplicationDetails(BaseUtils.getAppNameOfPackageName(str, context), BaseUtils.getBase64FromOtherAppsResource(context, str), str));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                    }
                }
            }
        }
        return arrayList;
    }

    public void openCheckout(JSONObject jSONObject, PaymentResultWithDataListener paymentResultWithDataListener2) throws Exception {
        this.paymentResultWithDataListener = paymentResultWithDataListener2;
        openCheckout(jSONObject);
    }

    public void submit(JSONObject jSONObject, PaymentResultWithDataListener paymentResultWithDataListener2) throws Exception {
        this.paymentResultWithDataListener = paymentResultWithDataListener2;
        submit(jSONObject);
    }

    public void openCheckout(JSONObject jSONObject) throws Exception {
        if (!BaseUtils.isDeviceHaveCorrectTlsVersion()) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_TLS_ERROR);
            R$$r_(6, (String) BaseConstants.TLS_ERROR_MESSAGE);
            return;
        }
        d__1_(jSONObject);
        AnalyticsUtil.addFilteredPropertiesFromPayload(jSONObject);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_SUBMIT_START);
        StringBuilder sb = new StringBuilder("<input type='hidden' name='key_id' value='");
        sb.append(this.apiKey);
        sb.append("'>");
        String obj = sb.toString();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj2 = jSONObject.get(next);
            if (!next.equals(AnalyticsConstants.UPI_APP_PACKAGE_NAME) && !next.equals("display_logo") && !next.equals("preferred_apps_order") && !next.equals("other_apps_order")) {
                if (obj2 instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String Q_$2$2 = J$$A_.Q_$2$(jSONObject2.getString(next2));
                        String Q_$2$3 = J$$A_.Q_$2$(String.format("%s[%s]", new Object[]{next, next2}));
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73(obj);
                        outline73.append(String.format("<input type='hidden' name='%s' value='%s'>", new Object[]{Q_$2$3, Q_$2$2}));
                        obj = outline73.toString();
                    }
                } else {
                    String Q_$2$4 = J$$A_.Q_$2$(jSONObject.getString(next));
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73(obj);
                    outline732.append(String.format("<input type='hidden' name='%s' value='%s'>", new Object[]{next, Q_$2$4}));
                    obj = outline732.toString();
                }
            }
        }
        String R$$r_2 = R$$r_(obj);
        StringBuilder sb2 = new StringBuilder("<form method='post' action='");
        sb2.append(R$$r_);
        sb2.append("checkout/embedded'>");
        sb2.append(R$$r_2);
        sb2.append("</form>");
        String replace = "<html><head><title>Processing, Please Wait...</title><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/><meta http-equiv=\"pragma\" content=\"no-cache\"><meta http-equiv=\"cache-control\" content=\"no-cache\"><style><style> html, body { width: 100%; } #content { width: 88%; max-width: 520px; text-align: center; position: absolute; transform: translate(-50%, -50%); top: 50%; left: 50%; } #title { color: #528ff0; font-size: 22px; } #ldr { width: 100%; height: 1px; position: relative; background: #e1e1e1; } #lding { height: 3px; top: -1px; background: #528ff0; position: absolute; animation: spin 20s cubic-bezier(0,0.1,0,1) forwards; animation-delay: 10; } @-webkit-keyframes spin { 0% { width: 0; } 100% { width: 90%; } } @keyframes spin { 0% { width: 0; } 100% { width: 90%; } } #desc { font-size: 16px; color: #8a8a8a; } #content > div { margin-bottom: 20px; } form { display: none; } .hide { display: none; }</style></head><body onload=\"document.forms[0].submit()\"><div id=\"content\"> <div id=\"title\">Processing Payment</div> <div id=\"ldr\"> <div id=\"lding\"></div> </div> <div id=\"desc\">Please wait while we fetch your transaction details and process your payment</div> <img id=\"rzplogo\" style=\"width:160px;margin-top:80px\" src=\"data:image/png;base64,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\"/>{{form}}</div></body><script></script></html>".replace("{{form}}", sb2.toString());
        if (!this.mShouldDisplayLogo) {
            replace = replace.replace("<script></script>", "<script>document.getElementById('rzplogo').className = 'hide';</script>");
        }
        this.webview.loadDataWithBaseURL(BaseConstants.RZP_URL, replace, RNCWebViewManager.HTML_MIME_TYPE, "UTF-8", null);
    }

    public void submit(JSONObject jSONObject) throws Exception {
        if (!BaseUtils.isDeviceHaveCorrectTlsVersion()) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_TLS_ERROR);
            R$$r_(6, (String) BaseConstants.TLS_ERROR_MESSAGE);
            return;
        }
        this.d__1_ = jSONObject;
        d__1_(jSONObject);
        AnalyticsUtil.addFilteredPropertiesFromPayload(jSONObject);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_SUBMIT_START);
        StringBuilder sb = new StringBuilder("<input type='hidden' name='key_id' value='");
        sb.append(this.apiKey);
        sb.append("'>");
        String obj = sb.toString();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj2 = jSONObject.get(next);
            if (next.equalsIgnoreCase(AnalyticsConstants.METHOD) && b__J_.L__R$().r_$Z$() && ((VERSION.SDK_INT >= 29 || ContextCompat.checkSelfPermission(this.activity, "android.permission.RECEIVE_SMS") != 0) && (obj2.toString().equalsIgnoreCase("netbanking") || obj2.toString().equalsIgnoreCase("card")))) {
                new zzab(this.activity).startSmsUserConsent(null);
                IntentFilter intentFilter = new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
                this.activity.registerReceiver(new AutoReadOtpHelper(this.activity), intentFilter);
                AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_TASK);
            }
            if (!next.equals(AnalyticsConstants.UPI_APP_PACKAGE_NAME) && !next.equals("display_logo") && !next.equals("preferred_apps_order") && !next.equals("other_apps_order")) {
                if (obj2 instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String Q_$2$2 = J$$A_.Q_$2$(jSONObject2.getString(next2));
                        String Q_$2$3 = J$$A_.Q_$2$(String.format("%s[%s]", new Object[]{next, next2}));
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73(obj);
                        outline73.append(String.format("<input type='hidden' name='%s' value='%s'>", new Object[]{Q_$2$3, Q_$2$2}));
                        obj = outline73.toString();
                    }
                } else {
                    String Q_$2$4 = J$$A_.Q_$2$(jSONObject.getString(next));
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73(obj);
                    outline732.append(String.format("<input type='hidden' name='%s' value='%s'>", new Object[]{next, Q_$2$4}));
                    obj = outline732.toString();
                }
            }
        }
        String R$$r_2 = R$$r_(obj);
        StringBuilder sb2 = new StringBuilder("<form method='post' action='");
        sb2.append(R$$r_);
        sb2.append("payments/create/checkout'>");
        sb2.append(R$$r_2);
        sb2.append("</form>");
        String replace = "<html><head><title>Processing, Please Wait...</title><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/><meta http-equiv=\"pragma\" content=\"no-cache\"><meta http-equiv=\"cache-control\" content=\"no-cache\"><style><style> html, body { width: 100%; } #content { width: 88%; max-width: 520px; text-align: center; position: absolute; transform: translate(-50%, -50%); top: 50%; left: 50%; } #title { color: #528ff0; font-size: 22px; } #ldr { width: 100%; height: 1px; position: relative; background: #e1e1e1; } #lding { height: 3px; top: -1px; background: #528ff0; position: absolute; animation: spin 20s cubic-bezier(0,0.1,0,1) forwards; animation-delay: 10; } @-webkit-keyframes spin { 0% { width: 0; } 100% { width: 90%; } } @keyframes spin { 0% { width: 0; } 100% { width: 90%; } } #desc { font-size: 16px; color: #8a8a8a; } #content > div { margin-bottom: 20px; } form { display: none; } .hide { display: none; }</style></head><body onload=\"document.forms[0].submit()\"><div id=\"content\"> <div id=\"title\">Processing Payment</div> <div id=\"ldr\"> <div id=\"lding\"></div> </div> <div id=\"desc\">Please wait while we fetch your transaction details and process your payment</div> <img id=\"rzplogo\" style=\"width:160px;margin-top:80px\" src=\"data:image/png;base64,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\"/>{{form}}</div></body><script></script></html>".replace("{{form}}", sb2.toString());
        if (!this.mShouldDisplayLogo) {
            replace = replace.replace("<script></script>", "<script>document.getElementById('rzplogo').className = 'hide';</script>");
        }
        this.webview.loadDataWithBaseURL(BaseConstants.RZP_URL, replace, RNCWebViewManager.HTML_MIME_TYPE, "UTF-8", null);
    }

    @Deprecated
    public static List<ApplicationDetails> getAppsWhichSupportUpi(Context context) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_GET_APPS_SUPPORTING_UPI);
        return d__1_(context);
    }

    private void Q_$2$(String str, final G__G_ g__g_) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.FETCH_PREFERENCES_CALLED);
        String R$$r_2 = !com.razorpay.AdvertisingIdUtil.AnonymousClass1.d__1_(BaseConstants.PAYMENT_PREFERENCES_CACHE_KEY) ? com.razorpay.AdvertisingIdUtil.AnonymousClass1.R$$r_(BaseConstants.PAYMENT_PREFERENCES_CACHE_KEY) : null;
        if (R$$r_2 == null || (str != null && !R$$r_2.contains(str))) {
            StringBuilder sb = new StringBuilder();
            sb.append(R$$r_);
            sb.append("preferences?key_id=");
            sb.append(this.apiKey);
            String obj = sb.toString();
            if (str != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append("&subscription_id=");
                sb2.append(str);
                obj = sb2.toString();
            }
            l__d$.R$$r_(obj, new Callback() {
                public final void run(K$$z$ k$$z$) {
                    String G__G_2 = k$$z$.G__G_();
                    if (G__G_2 == null || G__G_2.isEmpty() || k$$z$.a_$P$() != 200) {
                        g__g_.a_$P$(G__G_2);
                        AnalyticsUtil.trackEvent(AnalyticsEvent.FETCH_PREFERENCES_METHODS_CALL_FAIL);
                        return;
                    }
                    com.razorpay.AdvertisingIdUtil.AnonymousClass1.R$$r_(BaseConstants.PAYMENT_PREFERENCES_CACHE_KEY, G__G_2, TimeUnit.MINUTES.toMillis(15));
                    g__g_.Q_$2$(G__G_2);
                    AnalyticsUtil.trackEvent(AnalyticsEvent.FETCH_PREFERENCES_CALL_SUCCESS);
                }
            });
            return;
        }
        g__g_.Q_$2$(R$$r_2);
    }

    public final void R$$r_(int i, String str) {
        PaymentResultListener paymentResultListener2 = this.paymentResultListener;
        if (paymentResultListener2 != null) {
            paymentResultListener2.onPaymentError(i, str);
            return;
        }
        PaymentResultWithDataListener paymentResultWithDataListener2 = this.paymentResultWithDataListener;
        if (paymentResultWithDataListener2 != null) {
            paymentResultWithDataListener2.onPaymentError(i, str, new PaymentData());
        }
    }

    public BaseRazorpay(Activity activity2) {
        R$$r_(activity2);
    }

    private void R$$r_(Activity activity2) {
        if (O__Y_.d__1_(activity2).getString(com.mpl.androidapp.utils.Constant.ADVERTISIING_ID, null) == null) {
            AdvertisingIdUtil.Q_$2$(activity2, new d__1_(activity2) {
                public /* synthetic */ Context R$$r_;

                {
                    this.R$$r_ = r1;
                }

                public final void Q_$2$(String str) {
                    O__Y_.Q_$2$(this.R$$r_).putString(com.mpl.androidapp.utils.Constant.ADVERTISIING_ID, str).apply();
                }
            });
        }
        O__Y_.R$$r_(activity2, b__J_.G__G_);
        b__J_.L__R$().G__G_((Context) activity2);
        BaseUtils.checkForLatestVersion(activity2, b__J_.a_$P$);
        BaseUtils.setup();
        com.razorpay.AdvertisingIdUtil.AnonymousClass1.a_$P$ = activity2.getCacheDir();
        this.activity = activity2;
        String str = this.apiKey;
        if (str == null || str.isEmpty()) {
            this.apiKey = BaseUtils.getKeyId(activity2);
        }
        String str2 = this.apiKey;
        if (str2 == null || str2.isEmpty()) {
            throw new RuntimeException(BaseConstants.KEY_MISSING_EXCEPTION);
        }
        activity2.getWindow().setSoftInputMode(16);
        if (activity2 instanceof PaymentResultListener) {
            this.paymentResultListener = (PaymentResultListener) activity2;
        } else if (activity2 instanceof PaymentResultWithDataListener) {
            this.paymentResultWithDataListener = (PaymentResultWithDataListener) activity2;
        }
        b__J_.R$$r_ = false;
        b__J_.d__1_(activity2, this.apiKey);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_INIT_END);
    }

    private void Q_$2$(Intent intent) {
        String stringExtra = intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sender", BaseConstants.DEFAULT_SENDER);
            jSONObject.put("message", stringExtra);
            String jSONObject2 = jSONObject.toString();
            this.webview.loadUrl(String.format("javascript:OTPElf.elfBridge.setSms(%s)", new Object[]{jSONObject2}));
            AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_OTP_POPULATION_JS);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, AnalyticsConstants.ERROR_EXCEPTION, e2.getLocalizedMessage());
        }
    }

    private void d__1_(JSONObject jSONObject) throws Exception {
        this.r$_Y_ = null;
        this.mShouldDisplayLogo = true;
        if (jSONObject.has(AnalyticsConstants.METHOD) && jSONObject.getString(AnalyticsConstants.METHOD).equalsIgnoreCase("upi") && jSONObject.has("_[flow]") && jSONObject.getString("_[flow]").equalsIgnoreCase(AnalyticsConstants.INTENT)) {
            b__J_ L__R$2 = b__J_.L__R$();
            this.O_$B_ = BaseUtils.getSetOfPackageNamesSupportingUpi(this.activity);
            boolean f$_G$2 = L__R$2.f$_G$();
            this.J$_0_ = f$_G$2;
            if (f$_G$2) {
                HashSet<String> g__v_ = L__R$2.g__v_();
                this.c__C_ = g__v_;
                if (g__v_ == null) {
                    this.c__C_ = new HashSet<>();
                }
            } else {
                HashSet<String> J$_0_2 = L__R$2.J$_0_();
                this.l_$w$ = J$_0_2;
                if (J$_0_2 == null) {
                    this.l_$w$ = new HashSet<>();
                }
            }
            LinkedHashSet<String> l__d$2 = L__R$2.l__d$();
            this.l__d$ = l__d$2;
            if (l__d$2 == null) {
                this.l__d$ = new LinkedHashSet<>();
            }
            a_$P$();
            B$$W$();
            if (jSONObject.has(AnalyticsConstants.UPI_APP_PACKAGE_NAME)) {
                String string = jSONObject.getString(AnalyticsConstants.UPI_APP_PACKAGE_NAME);
                this.r$_Y_ = string;
                AnalyticsUtil.addProperty(AnalyticsConstants.UPI_APP_PACKAGE_NAME, new AnalyticsProperty(string, AnalyticsProperty$R$$r_.PAYMENT));
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_APP_PASSED);
            } else if (jSONObject.has("preferred_apps_order") || jSONObject.has("other_apps_order")) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_INTENT_APPS_PREFERENCE_PASSED);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                if (jSONObject.has("preferred_apps_order")) {
                    jSONArray = jSONObject.getJSONArray("preferred_apps_order");
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_INTENT_APPS_PREFERRED_ORDER_PASSED);
                }
                if (jSONObject.has("other_apps_order")) {
                    jSONArray2 = jSONObject.getJSONArray("other_apps_order");
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_INTENT_APPS_OTHER_ORDER_PASSED);
                }
                a_$P$(jSONArray, jSONArray2);
            }
        }
        if (jSONObject.has("display_logo")) {
            this.mShouldDisplayLogo = jSONObject.getBoolean("display_logo");
        }
    }

    public final void G__G_(JSONObject jSONObject) throws Exception {
        if (this.webview instanceof WebView) {
            AnalyticsUtil.setup(this.activity, this.apiKey, b__J_.d__1_, b__J_.a_$P$, b__J_.G__G_);
            if (this.Q_$2$ == null) {
                this.Q_$2$ = new RazorpayWebChromeClient(this);
            }
            if (this.G__G_ == null) {
                this.G__G_ = new RazorpayWebViewClient(this);
            }
            this.webview.setWebViewClient(this.G__G_);
            this.webview.setWebChromeClient(this.Q_$2$);
            this.B$$W$ = null;
            this.E$_j$ = true;
            try {
                String string = jSONObject.getString("amount");
                if (string != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (O__Y_.d__1_(this.activity).getBoolean("rzp_last_payment_status", false)) {
                        O__Y_.Q_$2$(this.activity).putBoolean("rzp_last_payment_status", false).apply();
                    } else {
                        String string2 = O__Y_.d__1_(this.activity).getString("rzp_last_payment_amount", null);
                        long j = O__Y_.d__1_(this.activity).getLong("rzp_last_payment_timestamp", 0);
                        if (string2 != null && j != 0 && string.equalsIgnoreCase(string2) && currentTimeMillis - j < 600000) {
                            AnalyticsUtil.setLocalOrderId(O__Y_.d__1_(this.activity).getString("rzp_last_payment_session_id", null));
                        }
                    }
                    O__Y_.Q_$2$(this.activity).putString("rzp_last_payment_amount", string).apply();
                    O__Y_.Q_$2$(this.activity).putLong("rzp_last_payment_timestamp", currentTimeMillis).apply();
                    Activity activity2 = this.activity;
                    O__Y_.Q_$2$(activity2).putString("rzp_last_payment_session_id", AnalyticsUtil.getLocalOrderId()).apply();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                AnalyticsUtil.reportError(e2, "error", e2.getMessage());
            }
            setUpAddon(jSONObject);
            return;
        }
        throw new Exception("WebView Inaccessible");
    }

    private void a_$P$(JSONArray jSONArray, JSONArray jSONArray2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(jSONArray.getString(i));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                }
            }
        }
        if (jSONArray2 != null) {
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                    arrayList2.add(jSONArray2.getString(i2));
                } catch (Exception e3) {
                    e3.printStackTrace();
                    AnalyticsUtil.reportError(e3, "error", e3.getMessage());
                }
            }
        }
        B$$W$();
        this.f$_G$ = new ArrayList<>();
        this.L__R$ = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.Y$_o$.containsKey(str)) {
                this.f$_G$.add(str);
                this.E$_6$.remove(str);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (this.Y$_o$.containsKey(str2)) {
                this.L__R$.add(str2);
                this.E$_6$.remove(str2);
            }
        }
    }

    public static String a_$P$(String str) {
        try {
            return new JSONObject(str).getJSONObject("methods").toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
            return null;
        }
    }

    private void a_$P$(String str, String str2) {
        BaseUtils.startActivityForResult(str2, str, this.activity);
        HashMap hashMap = new HashMap();
        if (str2 == null) {
            str2 = "null";
        }
        hashMap.put("url", str2);
        hashMap.put("custom_chooser", Boolean.TRUE);
        hashMap.put("package_name", str);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_UPI_APP_LAUNCHED, (Map<String, Object>) hashMap);
    }
}
