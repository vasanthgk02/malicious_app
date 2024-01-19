package com.freshchat.consumer.sdk.b;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.e.am.a;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
    public final e cL;

    public m(Context context) {
        this.cL = e.i(context.getApplicationContext());
    }

    private String bx(String str) {
        return str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0];
    }

    private String by(String str) {
        return str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1];
    }

    private String j(String str, String str2) {
        if (as.isEmpty(str2) || as.isEmpty(str)) {
            return null;
        }
        return GeneratedOutlineSupport.outline52(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, str2);
    }

    private String k(String str, String str2) {
        return GeneratedOutlineSupport.outline52(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, str2);
    }

    public void c(String str, String str2, String str3, String str4) {
        if (!as.isEmpty(str2) && !as.isEmpty(str) && !as.isEmpty(str3)) {
            JSONObject iK = this.cL.iK();
            try {
                String j = j(str, str2);
                if (!as.isEmpty(j)) {
                    iK.put(j, k(str3, str4));
                    this.cL.a(iK);
                }
            } catch (JSONException e2) {
                q.a(e2);
            }
        }
    }

    public boolean c(String str, String str2, String str3) {
        if (!as.isEmpty(str2) && !as.isEmpty(str)) {
            try {
                String j = j(str, str2);
                if (as.isEmpty(j)) {
                    return false;
                }
                String string = this.cL.iK().getString(j);
                if (as.p(str3, by(string))) {
                    return false;
                }
                if (as.o(a.THUMBS_DOWN.getValue(), bx(string))) {
                    return true;
                }
            } catch (JSONException e2) {
                q.a(e2);
            }
        }
        return false;
    }

    public boolean d(String str, String str2, String str3) {
        if (!as.isEmpty(str2) && !as.isEmpty(str)) {
            try {
                String j = j(str, str2);
                if (!as.isEmpty(j) && this.cL.iK().has(j)) {
                    return as.o(str3, by(this.cL.iK().getString(j)));
                }
                return false;
            } catch (Exception e2) {
                q.a(e2);
            }
        }
        return false;
    }
}
