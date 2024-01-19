package com.razorpay;

import android.app.Activity;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class OtpelfBaseRazorpay extends BaseRazorpay {
    public boolean Q_$2$ = true;
    public RzpAssist R$$r_;

    public OtpelfBaseRazorpay(Activity activity, String str) {
        super(activity, str);
    }

    public final void Q_$2$(WebView webView, String str) {
        super.Q_$2$(webView, str);
        if (this.Q_$2$) {
            RzpAssist rzpAssist = this.R$$r_;
            if (rzpAssist != null) {
                rzpAssist.onPageStarted(webView, str);
            }
        }
    }

    public final void d__1_(WebView webView, String str) {
        if (this.Q_$2$) {
            RzpAssist rzpAssist = this.R$$r_;
            if (rzpAssist != null) {
                rzpAssist.onPageFinished(webView, str);
            }
        }
        super.d__1_(webView, str);
    }

    public final void finish() {
        RzpAssist rzpAssist = this.R$$r_;
        if (rzpAssist != null && this.Q_$2$) {
            rzpAssist.reset();
            this.R$$r_.paymentFlowEnd();
        }
        super.finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.Q_$2$) {
            RzpAssist rzpAssist = this.R$$r_;
            if (rzpAssist != null) {
                rzpAssist.G__G_(i, iArr);
            }
        }
    }

    public void setUpAddon(JSONObject jSONObject) {
        try {
            if ("upi".equalsIgnoreCase(jSONObject.getString(AnalyticsConstants.METHOD))) {
                this.Q_$2$ = false;
            } else {
                this.Q_$2$ = true;
            }
        } catch (Exception unused) {
        }
        if (this.Q_$2$) {
            RzpAssist rzpAssist = new RzpAssist(this.apiKey, this.activity, this.webview, b__J_.d__1_, b__J_.a_$P$, b__J_.G__G_);
            this.R$$r_ = rzpAssist;
            rzpAssist.R$$r_();
            this.R$$r_.d__1_(jSONObject);
        }
    }

    public OtpelfBaseRazorpay(Activity activity) {
        super(activity);
    }

    public final void Q_$2$() {
        HashMap hashMap = new HashMap();
        if (this.Q_$2$) {
            RzpAssist rzpAssist = this.R$$r_;
            if (rzpAssist != null) {
                hashMap.put("current_loading_url", rzpAssist.Q_$2$());
                hashMap.put("last_loaded_url", this.R$$r_.d__1_());
            }
        }
        AnalyticsUtil.trackEvent(AnalyticsEvent.CUSTOM_UI_BACK_PRESSED_SOFT, (Map<String, Object>) hashMap);
    }

    public final void d__1_(WebView webView, int i) {
        super.d__1_(webView, i);
        if (this.Q_$2$) {
            RzpAssist rzpAssist = this.R$$r_;
            if (rzpAssist != null) {
                rzpAssist.onProgressChanged(i);
            }
        }
    }

    public final void Q_$2$(String str) {
        if (this.Q_$2$) {
            RzpAssist rzpAssist = this.R$$r_;
            if (rzpAssist != null) {
                rzpAssist.d__1_(str);
            }
        }
    }
}
