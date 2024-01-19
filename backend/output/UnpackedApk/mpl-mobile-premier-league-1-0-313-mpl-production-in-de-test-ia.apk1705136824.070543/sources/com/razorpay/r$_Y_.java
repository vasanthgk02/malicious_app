package com.razorpay;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import org.json.JSONObject;

public class r$_Y_ {
    public String B$$W$;
    public JSONObject D$_X_;
    public String E$_6$;
    public boolean E$_j$;
    public String G__G_;
    public int J$$A_;
    public String J$_0_;
    public int L__R$;
    public String O_$B_;
    public boolean O__Y_;
    public String Q_$2$;
    public boolean R$$r_;
    public String Y$_o$;
    public String a_$P$;
    public boolean b__J_;
    public JSONObject c__C_;
    public String d__1_;
    public String f$_G$;
    public Boolean g__v_;
    public String h__y_;
    public boolean l_$w$;
    public String l__d$;
    public String r$_Y_;

    public final String B$$W$() {
        return this.h__y_;
    }

    public final JSONObject D$_X_() {
        return this.D$_X_;
    }

    public final String E$_6$() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.r$_Y_);
        sb.append(this.Y$_o$);
        return sb.toString();
    }

    public final int E$_j$() {
        return this.J$$A_;
    }

    public final boolean G__G_() {
        return this.R$$r_;
    }

    public final String O_$B_() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.r$_Y_);
        sb.append(this.O_$B_);
        return sb.toString();
    }

    public final String Q_$2$() {
        return this.G__G_;
    }

    public final Boolean R$$r_() {
        return Boolean.valueOf(this.E$_j$);
    }

    public final String Y$_o$() {
        return this.a_$P$;
    }

    public final String a_$P$() {
        return this.B$$W$;
    }

    public final boolean b__J_() {
        return this.O__Y_;
    }

    public final String c__C_() {
        StringBuilder sb = new StringBuilder(BaseConstants.RZP_URL);
        sb.append(this.Q_$2$);
        return sb.toString();
    }

    public final String d__1_() {
        return this.d__1_;
    }

    public final String l_$w$() {
        return this.O_$B_;
    }

    public final Boolean r$_Y_() {
        return Boolean.valueOf(this.b__J_);
    }

    public static JSONObject R$$r_(Context context, int i) {
        InputStream openRawResource;
        String string = O__Y_.d__1_(context).getString("rzp_config_json", null);
        if (string == null) {
            try {
                openRawResource = context.getResources().openRawResource(i);
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[1024];
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, "UTF-8"));
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    stringWriter.write(cArr, 0, read);
                }
                openRawResource.close();
                string = stringWriter.toString();
            } catch (Exception unused) {
                return null;
            } catch (Throwable th) {
                openRawResource.close();
                throw th;
            }
        }
        return new JSONObject(string);
    }

    public void d__1_(JSONObject jSONObject) {
        try {
            this.J$$A_ = ((Integer) BaseUtils.getJsonValue((String) "update_sdk_config.latest_version", jSONObject, (Object) Integer.valueOf(1))).intValue();
            this.h__y_ = (String) BaseUtils.getJsonValue((String) "update_sdk_config.msg", jSONObject, (Object) "");
            this.O__Y_ = ((Boolean) BaseUtils.getJsonValue((String) "update_sdk_config.enable_alert", jSONObject, (Object) Boolean.TRUE)).booleanValue();
            this.G__G_ = (String) BaseUtils.getJsonValue((String) "config_end_point", jSONObject, (Object) "");
            this.R$$r_ = ((Boolean) BaseUtils.getJsonValue((String) "enable", jSONObject, (Object) "")).booleanValue();
            this.J$_0_ = (String) BaseUtils.getJsonValue((String) "permissions.custom_message", jSONObject, (Object) "");
            this.g__v_ = Boolean.valueOf(((Boolean) BaseUtils.getJsonValue((String) "permissions.enable_custom_message", jSONObject, (Object) Boolean.FALSE)).booleanValue());
            this.L__R$ = ((Integer) BaseUtils.getJsonValue((String) "permissions.max_ask_count", jSONObject, (Object) Integer.valueOf(0))).intValue();
            this.E$_j$ = ((Boolean) BaseUtils.getJsonValue((String) "analytics.lumberjack.enable", jSONObject, (Object) Boolean.TRUE)).booleanValue();
            this.d__1_ = (String) BaseUtils.getJsonValue((String) "analytics.lumberjack.key", jSONObject, (Object) "");
            this.B$$W$ = (String) BaseUtils.getJsonValue((String) "analytics.lumberjack.end_point", jSONObject, (Object) "");
            this.a_$P$ = (String) BaseUtils.getJsonValue((String) "analytics.lumberjack.sdk_identifier", jSONObject, (Object) "");
            this.b__J_ = ((Boolean) BaseUtils.getJsonValue((String) "otpelf.enable", jSONObject, (Object) Boolean.TRUE)).booleanValue();
            this.D$_X_ = (JSONObject) BaseUtils.getJsonValue((String) "otpelf.settings", jSONObject, (Object) new JSONObject());
            this.r$_Y_ = (String) BaseUtils.getJsonValue((String) "otpelf.endpoint", jSONObject, (Object) "https://cdn.razorpay.com/static/otpelf/");
            this.Y$_o$ = (String) BaseUtils.getJsonValue((String) "otpelf.version_file_name", jSONObject, (Object) "version.json");
            this.O_$B_ = (String) BaseUtils.getJsonValue((String) "otpelf.js_file_name", jSONObject, (Object) "otpelf.js");
            this.l_$w$ = ((Boolean) BaseUtils.getJsonValue((String) "magic.enable", jSONObject, (Object) Boolean.TRUE)).booleanValue();
            this.c__C_ = (JSONObject) BaseUtils.getJsonValue((String) "magic.settings", jSONObject, (Object) new JSONObject());
            this.E$_6$ = (String) BaseUtils.getJsonValue((String) "magic.endpoint", jSONObject, (Object) "https://cdn.razorpay.com/static/magic/");
            this.l__d$ = (String) BaseUtils.getJsonValue((String) "magic.version_file_name", jSONObject, (Object) "version.json");
            this.f$_G$ = (String) BaseUtils.getJsonValue((String) "magic.js_file_name", jSONObject, (Object) "magic.js");
            this.Q_$2$ = (String) BaseUtils.getJsonValue((String) "checkout.end_point", jSONObject, (Object) "");
        } catch (Exception unused) {
        }
    }
}
