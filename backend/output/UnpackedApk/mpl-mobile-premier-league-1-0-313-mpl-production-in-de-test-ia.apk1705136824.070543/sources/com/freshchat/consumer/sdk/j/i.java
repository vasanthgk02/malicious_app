package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.b.h;
import com.freshchat.consumer.sdk.b.h.a;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i<T> {
    public h hy;
    public Map<String, String> jh;

    public i(Context context) {
        ap(context);
    }

    private synchronized void ap(Context context) {
        if (!isReady()) {
            h hVar = new h(context, bf());
            this.hy = hVar;
            this.jh = hVar.getAll();
        }
    }

    private void iy() {
        h hVar = this.hy;
        if (hVar != null) {
            hVar.edit().clear().commit();
        }
    }

    private void put(String str, String str2) {
        if (str != null && str2 != null && isReady()) {
            a ci = this.hy.edit();
            if (ci != null) {
                ci.putString(str, str2).apply();
            }
            this.jh.put(str, str2);
        }
    }

    public void a(String str, JSONArray jSONArray) {
        putString(str, jSONArray.toString());
    }

    public void a(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            putString(str, jSONObject.toString());
        }
    }

    public void a(String[] strArr) {
        a ci = this.hy.edit();
        for (String str : strArr) {
            if (this.jh.containsKey(str)) {
                this.jh.remove(str);
            }
            if (this.hy.contains(str)) {
                ci.remove(str);
            }
        }
        ci.commit();
    }

    public void aq(Context context) {
        iy();
        Map<String, String> map = this.jh;
        if (map != null) {
            map.clear();
        }
        if (context != null) {
            ap(context);
        }
    }

    public boolean as(String str) {
        return this.jh.containsKey(str);
    }

    public void at(String str) {
        putString(str, Long.toString(System.currentTimeMillis()));
    }

    public abstract String bf();

    public void bo(Context context) {
        iy();
        this.hy = new h(context, bf());
        if (k.d(this.jh)) {
            for (Entry next : this.jh.entrySet()) {
                putString((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public void c(String str, String str2, boolean z) {
        if (!z) {
            try {
                if (!as.a(str2)) {
                    return;
                }
            } catch (Exception e2) {
                q.a(e2);
                return;
            }
        }
        put(str, str2);
    }

    public boolean eO() {
        return this.hy.eO();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        return as.a(string) ? Boolean.valueOf(string).booleanValue() : z;
    }

    public double getDouble(String str, double d2) {
        Double d3 = null;
        try {
            String string = getString(str);
            if (as.a(string)) {
                d3 = Double.valueOf(string);
            }
        } catch (NumberFormatException unused) {
        }
        return d3 == null ? d2 : d3.doubleValue();
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        if (string.isEmpty()) {
            return i;
        }
        try {
            return Integer.valueOf(string).intValue();
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public JSONArray getJSONArray(String str) {
        try {
            return new JSONArray(getString(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
        } catch (JSONException e2) {
            ai.e("FRESHCHAT", "Exception occured", e2);
            return new JSONArray();
        }
    }

    public JSONObject getJSONObject(String str) {
        try {
            return new JSONObject(getString(str, "{}"));
        } catch (JSONException e2) {
            ai.e("FRESHCHAT", "Exception occured", e2);
            return new JSONObject();
        }
    }

    public long getLong(String str) {
        return getLong(str, Long.MIN_VALUE);
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        try {
            if (as.a(string)) {
                return Long.valueOf(string).longValue();
            }
        } catch (NumberFormatException unused) {
        }
        return j;
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public String getString(String str, String str2) {
        String str3 = null;
        try {
            if (isReady() && this.jh.containsKey(str)) {
                str3 = this.jh.get(str);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return str3 == null ? str2 : str3;
    }

    public boolean isReady() {
        return (this.hy == null || this.jh == null) ? false : true;
    }

    public boolean jO() {
        return this.hy.jM();
    }

    public void putBoolean(String str, boolean z) {
        putString(str, Boolean.toString(z));
    }

    public void putDouble(String str, double d2) {
        putString(str, Double.toString(d2));
    }

    public void putInt(String str, int i) {
        putString(str, Integer.toString(i));
    }

    public void putLong(String str, long j) {
        putString(str, String.valueOf(j));
    }

    public void putString(String str, String str2) {
        c(str, str2, true);
    }

    public void remove(String str) {
        if (isReady()) {
            if (this.jh.containsKey(str)) {
                this.jh.remove(str);
            }
            if (this.hy.contains(str)) {
                this.hy.edit().remove(str).commit();
            }
        }
    }
}
