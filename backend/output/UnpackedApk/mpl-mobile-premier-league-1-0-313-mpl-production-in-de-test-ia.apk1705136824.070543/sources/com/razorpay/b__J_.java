package com.razorpay;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import com.freshchat.consumer.sdk.beans.User;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.mpl.androidapp.utils.Constant;
import com.netcore.android.preference.SMTPreferenceConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b__J_ extends r$_Y_ {
    public static String D$_X_ = "3.0.7";
    public static String G__G_ = "3.8.10";
    public static b__J_ Q_$2$ = null;
    public static boolean R$$r_ = true;
    public static int a_$P$ = 30;
    public static String d__1_ = "customui";
    public static String r$_Y_ = "EPl0bxz9OvsD5IylM1M28Mv2n3v9XBsr";
    public HashSet<String> B$$W$;
    public JSONObject E$_6$;
    public boolean E$_j$;
    public String J$_0_;
    public String L__R$;
    public LinkedHashSet<String> O_$B_;
    public JSONObject Y$_o$;
    public HashSet<String> b__J_;
    public String c__C_;
    public boolean f$_G$;
    public String g__v_;
    public String l_$w$;
    public String l__d$;

    private void G__G_(JSONObject jSONObject) throws Exception {
        this.E$_6$ = (JSONObject) BaseUtils.getJsonValue((String) "static_rules.identify_network", jSONObject, (Object) new JSONObject());
        this.Y$_o$ = (JSONObject) BaseUtils.getJsonValue((String) "static_rules.network_card_length", jSONObject, (Object) new JSONObject());
        this.L__R$ = (String) BaseUtils.getJsonValue((String) "static_rules.logos.bank.base_url", jSONObject, (Object) null);
        this.l__d$ = (String) BaseUtils.getJsonValue((String) "static_rules.logos.bank.extension", jSONObject, (Object) null);
        this.L__R$ = (String) BaseUtils.getJsonValue((String) "static_rules.logos.bank.base_url", jSONObject, (Object) null);
        this.l__d$ = (String) BaseUtils.getJsonValue((String) "static_rules.logos.bank.extension", jSONObject, (Object) null);
        this.l_$w$ = (String) BaseUtils.getJsonValue((String) "static_rules.logos.wallet.base_url", jSONObject, (Object) null);
        this.c__C_ = (String) BaseUtils.getJsonValue((String) "static_rules.logos.wallet.extension", jSONObject, (Object) null);
        this.g__v_ = (String) BaseUtils.getJsonValue((String) "static_rules.logos.wallet_sq.base_url", jSONObject, (Object) null);
        this.J$_0_ = (String) BaseUtils.getJsonValue((String) "static_rules.logos.wallet_sq.extension", jSONObject, (Object) null);
    }

    public static b__J_ L__R$() {
        if (Q_$2$ == null) {
            b__J_ b__j_ = new b__J_();
            Q_$2$ = b__j_;
            Y$_o$.Q_$2$(b__j_);
        }
        return Q_$2$;
    }

    private void Q_$2$(JSONObject jSONObject) {
        try {
            this.f$_G$ = ((Boolean) BaseUtils.getJsonValue((String) "one_time_otp.enabled", jSONObject, (Object) Boolean.FALSE)).booleanValue();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "warning", e2.getLocalizedMessage());
            e2.printStackTrace();
        }
    }

    private void R$$r_(JSONObject jSONObject) throws Exception {
        boolean booleanValue = ((Boolean) BaseUtils.getJsonValue((String) "upi.isWhiteListingEnabled", jSONObject, (Object) Boolean.TRUE)).booleanValue();
        this.E$_j$ = booleanValue;
        if (booleanValue) {
            JSONArray jSONArray = (JSONArray) BaseUtils.getJsonValue((String) "upi.whiteListedApps", jSONObject, (Object) new String[0]);
            this.b__J_ = new HashSet<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.b__J_.add(jSONArray.getString(i));
            }
            this.B$$W$ = new HashSet<>();
        } else {
            JSONArray jSONArray2 = (JSONArray) BaseUtils.getJsonValue((String) "upi.blackListedApps", jSONObject, (Object) new String[0]);
            this.B$$W$ = new HashSet<>();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.B$$W$.add(jSONArray2.getString(i2));
            }
            this.b__J_ = new HashSet<>();
        }
        JSONArray jSONArray3 = (JSONArray) BaseUtils.getJsonValue((String) "upi.upiAppsPreferredOrder", jSONObject, (Object) new String[0]);
        this.O_$B_ = new LinkedHashSet<>();
        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
            this.O_$B_.add(jSONArray3.getString(i3));
        }
    }

    public final JSONObject B_$q$() {
        return this.Y$_o$;
    }

    public final String I$_e_() {
        return this.J$_0_;
    }

    public final String J$$A_() {
        return this.l_$w$;
    }

    public final HashSet<String> J$_0_() {
        return this.B$$W$;
    }

    public final String K$$z$() {
        return this.g__v_;
    }

    public final JSONObject O__Y_() {
        return this.E$_6$;
    }

    public final String T__j$() {
        return this.L__R$;
    }

    public final String Y_$B$() {
        return this.l__d$;
    }

    public final void d__1_(JSONObject jSONObject) {
        try {
            R$$r_(jSONObject);
            G__G_(jSONObject);
            Q_$2$(jSONObject);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "critical", e2.getLocalizedMessage());
            e2.printStackTrace();
        }
        super.d__1_(jSONObject);
    }

    public final boolean f$_G$() {
        return this.E$_j$;
    }

    public final HashSet<String> g__v_() {
        return this.b__J_;
    }

    public final String h__y_() {
        return this.c__C_;
    }

    public final LinkedHashSet<String> l__d$() {
        return this.O_$B_;
    }

    public final boolean r_$Z$() {
        return this.f$_G$;
    }

    public static void d__1_(Context context, String str) {
        if (Q_$2$ == null) {
            b__J_ b__j_ = new b__J_();
            Q_$2$ = b__j_;
            Y$_o$.Q_$2$(b__j_);
        }
        if (Q_$2$.G__G_()) {
            HashMap hashMap = new HashMap();
            hashMap.put("AuthKey", r$_Y_);
            hashMap.put("Content-type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
            String string = O__Y_.d__1_(context).getString("rzp_config_version", null);
            if (string == null) {
                string = D$_X_;
            }
            hashMap.put("CurrentSettingVersion", string);
            if (Q_$2$ == null) {
                b__J_ b__j_2 = new b__J_();
                Q_$2$ = b__j_2;
                Y$_o$.Q_$2$(b__j_2);
            }
            Builder buildUpon = Uri.parse(Q_$2$.Q_$2$()).buildUpon();
            StringBuilder sb = new StringBuilder("android_");
            sb.append(d__1_);
            Builder appendQueryParameter = buildUpon.appendQueryParameter("tenant", sb.toString()).appendQueryParameter(SMTPreferenceConstants.SMT_SDK_VERSION, G__G_).appendQueryParameter("sdk_type", d__1_).appendQueryParameter("magic_enabled", String.valueOf(R$$r_)).appendQueryParameter(User.DEVICE_META_SDK_VERSION_CODE, String.valueOf(a_$P$)).appendQueryParameter("app_version", BuildConfig.VERSION_NAME);
            String string2 = O__Y_.d__1_(context).getString("rzp_config_version", null);
            if (string2 == null) {
                string2 = D$_X_;
            }
            Matcher matcher = Pattern.compile("^(\\d+\\.)(\\d+\\.)(\\d+)$").matcher(string2);
            Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("version", matcher.find() ? matcher.replaceFirst("$1$2*") : null);
            appendQueryParameter2.appendQueryParameter(PaymentConstants.MERCHANT_KEY_ID, str).appendQueryParameter("android_version", VERSION.RELEASE).appendQueryParameter(ConfigConstant.DEVICE_ID, O__Y_.d__1_(context).getString(Constant.ADVERTISIING_ID, null)).appendQueryParameter("device_manufacturer", Build.MANUFACTURER).appendQueryParameter(OneSingnalConstant.TAG_DEVICE_MODEL, Build.MODEL).appendQueryParameter("network_type", BaseUtils.getDataNetworkType(context).Q_$2$()).appendQueryParameter(AnalyticsConstants.CELLULAR_NETWORK_TYPE, BaseUtils.getCellularNetworkType(context)).appendQueryParameter("cellular_network_provider", BaseUtils.getCellularNetworkProviderName(context)).appendQueryParameter("app_package_name", context.getApplicationContext().getPackageName()).appendQueryParameter("build_type", BaseUtils.getAppBuildType(context)).appendQueryParameter("magic_version_code", String.valueOf(l_$w$.G__G_.intValue())).appendQueryParameter("rzpassist_version_code", String.valueOf(l_$w$.d__1_.intValue())).appendQueryParameter(AnalyticsConstants.WEBVIEW_USER_AGENT, BaseUtils.getWebViewUserAgent(context).toString());
            l__d$.G__G_(appendQueryParameter2.build().toString(), hashMap, new Callback(context) {
                public /* synthetic */ Context a_$P$;

                {
                    this.a_$P$ = r1;
                }

                public final void run(K$$z$ k$$z$) {
                    try {
                        if (k$$z$.a_$P$() == 200) {
                            JSONObject jSONObject = new JSONObject(k$$z$.G__G_());
                            Context context = this.a_$P$;
                            O__Y_.Q_$2$(context).putString("rzp_config_json", jSONObject.toString()).apply();
                            List list = k$$z$.Q_$2$().get("Settingversion");
                            if (list != null && list.size() > 0) {
                                String str = (String) list.get(0);
                                if (str != null && !str.isEmpty()) {
                                    O__Y_.Q_$2$(this.a_$P$).putString("rzp_config_version", str).apply();
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public final void G__G_(Context context) {
        d__1_(r$_Y_.R$$r_(context, R.raw.rzp_config));
    }
}
