package com.freshchat.consumer.sdk.b.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.b.b;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aw;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static String dY = "JsonResponse";
    public JSONObject dW;
    public JSONArray dX;

    public a() {
    }

    public a(InputStream inputStream) {
        a(inputStream);
    }

    public a(String str) {
        Q(str);
    }

    private void Q(String str) {
        reset();
        if (str != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("{ \"");
            GeneratedOutlineSupport.outline103(outline73, dY, "\":\t ", str, "}");
            try {
                Object obj = new JSONObject(outline73.toString()).get(dY);
                if (obj instanceof JSONObject) {
                    this.dW = (JSONObject) obj;
                } else if (obj instanceof JSONArray) {
                    this.dX = (JSONArray) obj;
                } else {
                    "Not an Valid one" + obj.getClass();
                }
            } catch (JSONException e2) {
                ai.e("FRESHCHAT", "Exception occured", e2);
            }
        }
    }

    private void a(InputStream inputStream) {
        reset();
        if (aw.eS()) {
            Object co2 = new b(inputStream).co();
            if (co2 instanceof JSONObject) {
                this.dW = (JSONObject) co2;
            } else if (co2 instanceof JSONArray) {
                this.dX = (JSONArray) co2;
            } else {
                "Not an Valid one" + co2;
            }
        } else {
            try {
                Q(ad.a(inputStream, b.da));
            } catch (IOException e2) {
                ai.e("FRESHCHAT", "Exception occured", e2);
            }
        }
    }

    private void reset() {
        this.dW = null;
        this.dX = null;
    }

    public JSONObject cm() {
        if (cn()) {
            return this.dW;
        }
        return null;
    }

    public boolean cn() {
        return this.dW != null;
    }

    public boolean db() {
        return cn() && !this.dW.optBoolean("success") && this.dW.optInt("errorCode") == 19;
    }

    public boolean fJ() {
        return cn() && !this.dW.optBoolean("success") && this.dW.optInt("errorCode") == 20;
    }

    public boolean isArray() {
        return this.dX != null;
    }

    public boolean isValid() {
        return (this.dW == null && this.dX == null) ? false : true;
    }

    public String toString() {
        String str;
        StringBuilder sb;
        if (cn()) {
            sb = GeneratedOutlineSupport.outline73("Object : ");
            str = this.dW.toString();
        } else if (!isArray()) {
            return null;
        } else {
            sb = GeneratedOutlineSupport.outline73("Array : ");
            str = this.dX.toString();
        }
        sb.append(str);
        return sb.toString();
    }
}
