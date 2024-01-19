package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Base64;
import com.appsflyer.AFLogger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class n {
    public String AFInAppEventParameterName;
    public String AFInAppEventType;
    public bt AFKeystoreWrapper;
    public String valueOf;
    public byte[] values;

    public n() {
    }

    public static cj AFInAppEventParameterName(Context context) {
        if (context instanceof Activity) {
            return cj.activity;
        }
        if (context instanceof Application) {
            return cj.application;
        }
        return cj.other;
    }

    public static JSONObject AFInAppEventType(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Entry next : map.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), valueOf(next.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static Object valueOf(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
            if (obj.equals(JSONObject.NULL)) {
                return obj;
            }
            try {
                if (obj instanceof Collection) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object valueOf2 : (Collection) obj) {
                        jSONArray.put(valueOf(valueOf2));
                    }
                    return jSONArray;
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < length; i++) {
                        jSONArray2.put(valueOf(Array.get(obj, i)));
                    }
                    return jSONArray2;
                } else if (obj instanceof Map) {
                    return AFInAppEventType((Map) obj);
                } else {
                    if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                        obj = obj.toString();
                    }
                    return obj;
                }
            } catch (Exception unused) {
                obj = JSONObject.NULL;
            }
        }
        return obj;
    }

    public static List<Object> values(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = values((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = valueOf((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            String str = this.AFInAppEventType;
            if (str == null ? nVar.AFInAppEventType != null : !str.equals(nVar.AFInAppEventType)) {
                return false;
            }
            if (!Arrays.equals(this.values, nVar.values)) {
                return false;
            }
            String str2 = this.valueOf;
            if (str2 == null ? nVar.valueOf != null : !str2.equals(nVar.valueOf)) {
                return false;
            }
            String str3 = this.AFInAppEventParameterName;
            if (str3 == null ? nVar.AFInAppEventParameterName != null : !str3.equals(nVar.AFInAppEventParameterName)) {
                return false;
            }
            if (this.AFKeystoreWrapper == nVar.AFKeystoreWrapper) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.AFInAppEventType;
        int i = 0;
        int hashCode = (Arrays.hashCode(this.values) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        String str2 = this.valueOf;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.AFInAppEventParameterName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        bt btVar = this.AFKeystoreWrapper;
        if (btVar != null) {
            i = btVar.hashCode();
        }
        return hashCode3 + i;
    }

    public n(String str, byte[] bArr, String str2, bt btVar) {
        this.valueOf = str;
        this.values = bArr;
        this.AFInAppEventType = str2;
        this.AFKeystoreWrapper = btVar;
    }

    public final byte[] AFInAppEventParameterName() {
        return this.values;
    }

    @Deprecated
    public n(String str, byte[] bArr, String str2) {
        this(str, bArr, str2, null);
    }

    public n(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i = 0;
        int i2 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.valueOf = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.AFInAppEventType = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.AFInAppEventType);
                if (matcher.matches()) {
                    i = Integer.parseInt(matcher.group(1));
                    i2 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.values = (i > 4 || i2 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            } else if (nextLine.startsWith("type=")) {
                String trim2 = nextLine.substring(5).trim();
                try {
                    this.AFKeystoreWrapper = bt.valueOf(trim2);
                } catch (Exception e2) {
                    AFLogger.valueOf("CACHE: Unknown task type: ".concat(String.valueOf(trim2)), e2);
                }
            }
        }
        scanner.close();
    }

    public static Map<String, Object> valueOf(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = values((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = valueOf((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }
}
