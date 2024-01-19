package com.razorpay;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.netcore.android.preference.SMTPreferenceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class RzpAssist implements Q$$U_ {
    public Activity B$$W$;
    public boolean D$_X_ = false;
    public boolean E$_6$ = false;
    public String E$_j$;
    public WebView G__G_;
    public boolean J$_0_ = false;
    public int L__R$;
    public JSONObject O_$B_ = new JSONObject();
    public String Q_$2$ = "";
    public boolean R$$r_ = false;
    public JSONObject Y$_o$ = new JSONObject();
    public long a_$P$;
    public boolean b__J_ = false;
    public Object c__C_$3bb8a87a;
    public String d__1_ = "";
    public boolean f$_G$ = false;
    public String g__v_ = "standalone";
    public String l_$w$;
    public String l__d$;
    public h__y_ r$_Y_;

    public RzpAssist(String str, Activity activity, WebView webView, String str2, int i, String str3) {
        Throwable cause;
        if (Y$_o$.J$_0_().r$_Y_().booleanValue()) {
            if (str == null || str.isEmpty()) {
                throw new RuntimeException("merchantKey cannot be null or empty");
            }
            this.g__v_ = str2;
            this.L__R$ = i;
            if (str2.equals("standalone")) {
                AnalyticsUtil.setup(activity, str, str2, i, str3);
            }
            this.G__G_ = webView;
            this.E$_j$ = str;
            this.B$$W$ = activity;
            try {
                Object newInstance = ((Class) L__R$.G__G_(18, 64047, 18)).getDeclaredConstructor(new Class[]{Activity.class}).newInstance(new Object[]{activity});
                this.c__C_$3bb8a87a = newInstance;
                try {
                    ((Class) L__R$.G__G_(18, 64047, 18)).getDeclaredMethod("d__1_", null).invoke(newInstance, null);
                    if (h__y_.G__G_ == null) {
                        h__y_.G__G_ = new h__y_();
                    }
                    h__y_ h__y_ = h__y_.G__G_;
                    this.r$_Y_ = h__y_;
                    h__y_.d__1_.add(this);
                    h__y_ h__y_2 = this.r$_Y_;
                    Activity activity2 = this.B$$W$;
                    if (ContextCompat.checkSelfPermission(activity2, "android.permission.RECEIVE_SMS") == 0) {
                        h__y_2.G__G_(true);
                        h__y_2.a_$P$(activity2);
                        AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_ALREADY_GRANTED);
                    } else {
                        AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_ALREADY_NOT_GRANTED);
                    }
                    this.G__G_.addJavascriptInterface(this, "OTPElfBridge");
                    this.G__G_.getSettings().setUseWideViewPort(true);
                    AnalyticsUtil.addProperty("OTPElf Version", new AnalyticsProperty(BaseUtils.getLocalVersion(activity, (String) ((Class) L__R$.G__G_(18, 64047, 18)).getField("a_$P$").get(null)), AnalyticsProperty$R$$r_.ORDER));
                } catch (Throwable th) {
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } finally {
                cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
            }
        }
    }

    @JavascriptInterface
    public final void copyToClipboard(String str) {
        ((ClipboardManager) this.B$$W$.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("rzp_clip_data", str));
    }

    @JavascriptInterface
    public final void onOtpParsed(final String str) {
        this.B$$W$.runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    OTP otp = new OTP(jSONObject.getString("otp"), jSONObject.getString("sender"), jSONObject.getString("bank"));
                    HashMap hashMap = new HashMap();
                    hashMap.put("sender", otp.Q_$2$);
                    if (otp.Q_$2$.contains("RZRPAY")) {
                        RzpAssist.this.b__J_ = true;
                        hashMap.put(AnalyticsConstants.RAZORPAY_OTP, Boolean.TRUE);
                    } else {
                        hashMap.put(AnalyticsConstants.RAZORPAY_OTP, Boolean.FALSE);
                        RzpAssist.this.J$_0_ = true;
                        AnalyticsUtil.addProperty("payment_otp_received", new AnalyticsProperty(true, AnalyticsProperty$R$$r_.PAYMENT));
                    }
                    AnalyticsUtil.trackEvent(AnalyticsEvent.OTP_RECEIVED, (Map<String, Object>) hashMap);
                } catch (Exception unused) {
                }
            }
        });
    }

    public final void onPageFinished(WebView webView, String str) {
        AnalyticsUtil.trackPageLoadEnd(str, System.nanoTime() - this.a_$P$);
        this.d__1_ = str;
        this.Q_$2$ = "";
        if (Y$_o$.J$_0_().r$_Y_().booleanValue() && !this.f$_G$) {
            try {
                JSONObject D$_X_2 = Y$_o$.J$_0_().D$_X_();
                D$_X_2.put(AnalyticsConstants.MERCHANT_KEY, this.E$_j$);
                D$_X_2.put("otp_permission", this.R$$r_);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", this.g__v_);
                jSONObject.put(SMTPreferenceConstants.SMT_APP_VERSION_CODE, this.L__R$);
                D$_X_2.put("sdk", jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", AnalyticsConstants.RZPASSIST);
                jSONObject2.put(SMTPreferenceConstants.SMT_APP_VERSION_CODE, l_$w$.d__1_.intValue());
                D$_X_2.put("plugin", jSONObject2);
                D$_X_2.put("payment_data", this.Y$_o$);
                D$_X_2.put(AnalyticsConstants.PREFERENCES, this.O_$B_);
                StringBuilder sb = new StringBuilder("window.__rzp_options = ");
                sb.append(D$_X_2.toString());
                String obj = sb.toString();
                this.G__G_.loadUrl(String.format("javascript: %s", new Object[]{obj}));
            } catch (Exception unused) {
            }
            try {
                Object invoke = ((Class) L__R$.G__G_(18, 64047, 18)).getDeclaredMethod("Q_$2$", null).invoke(this.c__C_$3bb8a87a, null);
                this.G__G_.loadUrl(String.format("javascript: %s", new Object[]{invoke}));
                String str2 = this.l__d$;
                if (str2 != null) {
                    String format = String.format("OTPElf.elfBridge.setSms(%s)", new Object[]{str2});
                    this.G__G_.loadUrl(String.format("javascript: %s", new Object[]{format}));
                    this.l__d$ = null;
                }
                this.f$_G$ = true;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    public final void onPageStarted(WebView webView, String str) {
        "RzpAssist onPageStarted: ".concat(String.valueOf(str));
        AnalyticsUtil.trackPageLoadStart(str);
        this.a_$P$ = System.nanoTime();
        this.Q_$2$ = str;
        this.f$_G$ = false;
    }

    public final void onProgressChanged(int i) {
        if (!Y$_o$.J$_0_().r$_Y_().booleanValue()) {
        }
    }

    @JavascriptInterface
    public final void openKeyboard() {
        this.B$$W$.runOnUiThread(new Runnable() {
            public final void run() {
                ((InputMethodManager) RzpAssist.this.B$$W$.getSystemService("input_method")).showSoftInput(RzpAssist.this.G__G_, 0);
            }
        });
    }

    public final void paymentFlowEnd() {
        if (this.g__v_.equals("standalone")) {
            AnalyticsUtil.postData();
        }
        if (Y$_o$.J$_0_().r$_Y_().booleanValue()) {
            this.r$_Y_.Q_$2$(this.B$$W$);
            try {
                this.r$_Y_.d__1_.remove(this);
            } catch (Exception unused) {
            }
        }
    }

    public final void postSms(String str, String str2) {
        if (this.E$_6$) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sender", str);
                jSONObject.put("message", str2);
                String jSONObject2 = jSONObject.toString();
                this.l__d$ = jSONObject2;
                String format = String.format("OTPElf.elfBridge.setSms(%s)", new Object[]{jSONObject2});
                this.G__G_.loadUrl(String.format("javascript: %s", new Object[]{format}));
            } catch (Exception unused) {
            }
        }
    }

    public final void reset() {
        try {
            String constructBasicAuth = BaseUtils.constructBasicAuth(this.E$_j$);
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", "Basic ".concat(String.valueOf(constructBasicAuth)));
            hashMap.put("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
            if (this.l_$w$ != null) {
                StringBuilder sb = new StringBuilder(BaseConstants.RZP_PAYMENTS_ENDPOINT);
                sb.append(this.l_$w$);
                sb.append("/metadata");
                String obj = sb.toString();
                JSONObject Q_$2$2 = E$_j$.Q_$2$(this.J$_0_);
                Q_$2$2.toString();
                l__d$.Q_$2$(obj, Q_$2$2.toString(), hashMap, new Callback() {
                    public final void run(K$$z$ k$$z$) {
                        StringBuilder sb = new StringBuilder("API Metadata: ");
                        sb.append(k$$z$.G__G_());
                        sb.toString();
                    }
                });
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "critical", e2.getMessage());
        }
        this.d__1_ = "";
        this.Q_$2$ = "";
        this.J$_0_ = false;
    }

    public final void setOtpElfPreferences(JSONObject jSONObject) {
        this.O_$B_ = jSONObject;
    }

    public final void setSmsPermission(boolean z) {
        this.R$$r_ = z;
        AnalyticsUtil.addProperty("otp_autoreading_access", new AnalyticsProperty(z, AnalyticsProperty$R$$r_.ORDER));
    }

    @JavascriptInterface
    public final void setUseWideViewPort(final boolean z) {
        this.B$$W$.runOnUiThread(new Runnable() {
            public final void run() {
                RzpAssist.this.G__G_.getSettings().setUseWideViewPort(z);
            }
        });
    }

    @JavascriptInterface
    public final void toast(final String str) {
        this.B$$W$.runOnUiThread(new Runnable() {
            public final void run() {
                Toast.makeText(RzpAssist.this.B$$W$, str, 1).show();
            }
        });
    }

    @JavascriptInterface
    public final void trackEvent(String str, String str2) {
        try {
            AnalyticsEvent analyticsEvent = AnalyticsEvent.JS_EVENT;
            analyticsEvent.setEventName(str);
            AnalyticsUtil.trackEvent(analyticsEvent, new JSONObject(str2));
        } catch (Exception unused) {
        }
    }

    public final void G__G_(int i, int[] iArr) {
        h__y_ h__y_ = this.r$_Y_;
        Activity activity = this.B$$W$;
        if (i == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                h__y_.G__G_(false);
                AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_NOW_DENIED);
            } else {
                h__y_.G__G_(true);
                h__y_.a_$P$(activity);
                AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_NOW_GRANTED);
            }
        }
    }

    public final String Q_$2$() {
        return this.Q_$2$;
    }

    public final void R$$r_() {
        this.E$_6$ = true;
    }

    public final void d__1_(JSONObject jSONObject) {
        this.Y$_o$ = jSONObject;
    }

    public final void d__1_(String str) {
        this.l_$w$ = str;
    }

    public final String d__1_() {
        return this.d__1_;
    }

    @JavascriptInterface
    public final void trackEvent(String str) {
        AnalyticsEvent analyticsEvent = AnalyticsEvent.JS_EVENT;
        analyticsEvent.setEventName(str);
        AnalyticsUtil.trackEvent(analyticsEvent);
    }
}
