package com.mpl.androidapp.utils;

import android.text.TextUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.mpl.androidapp.react.modules.SendBirdModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConvertUtils {

    /* renamed from: com.mpl.androidapp.utils.ConvertUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002b */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                r1 = 1
                com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x002b }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.ConvertUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static JSONArray convertArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (readableArray != null) {
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                int ordinal = readableArray.getType(i).ordinal();
                if (ordinal == 1) {
                    jSONArray.put(readableArray.getBoolean(i));
                } else if (ordinal == 2) {
                    jSONArray.put(readableArray.getDouble(i));
                } else if (ordinal == 3) {
                    jSONArray.put(readableArray.getString(i));
                } else if (ordinal == 4) {
                    jSONArray.put(convertMapToJson(readableArray.getMap(i)));
                } else if (ordinal == 5) {
                    jSONArray.put(convertArrayToJson(readableArray.getArray(i)));
                }
            }
        } else {
            MLogger.e(SendBirdModule.TAG, "convertArrayToJson:ReadableArray is null ");
        }
        return jSONArray;
    }

    public static WritableArray convertJsonToArray(JSONArray jSONArray) throws JSONException {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        int length = jSONArray != null ? jSONArray.length() : 0;
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    writableNativeArray.pushMap(convertJsonToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeArray.pushArray(convertJsonToArray((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeArray.pushInt(((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeArray.pushDouble(((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeArray.pushString((String) obj);
                } else {
                    writableNativeArray.pushString(obj.toString());
                }
            }
        }
        return writableNativeArray;
    }

    public static WritableMap convertJsonToMap(JSONObject jSONObject) throws JSONException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!(next == null || TextUtils.isEmpty(next) || obj == null)) {
                if (obj instanceof JSONObject) {
                    writableNativeMap.putMap(next, convertJsonToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeMap.putArray(next, convertJsonToArray((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeMap.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeMap.putString(next, (String) obj);
                } else {
                    writableNativeMap.putString(next, obj.toString());
                }
            }
        }
        return writableNativeMap;
    }

    public static JSONObject convertMapToJson(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (TextUtils.isEmpty(nextKey)) {
                    MLogger.e(SendBirdModule.TAG, "convertMapToJson: Key is null or empty");
                } else {
                    int ordinal = readableMap.getType(nextKey).ordinal();
                    if (ordinal == 0) {
                        jSONObject.put(nextKey, JSONObject.NULL);
                    } else if (ordinal == 1) {
                        jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    } else if (ordinal == 2) {
                        jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                    } else if (ordinal == 3) {
                        jSONObject.put(nextKey, readableMap.getString(nextKey));
                    } else if (ordinal == 4) {
                        jSONObject.put(nextKey, convertMapToJson(readableMap.getMap(nextKey)));
                    } else if (ordinal == 5) {
                        jSONObject.put(nextKey, convertArrayToJson(readableMap.getArray(nextKey)));
                    }
                }
            }
        } else {
            MLogger.e(SendBirdModule.TAG, "convertMapToJson: map is null");
        }
        return jSONObject;
    }

    public static WritableArray jsonToReact(JSONArray jSONArray) throws JSONException {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj == null) {
                MLogger.d(SendBirdModule.TAG, "jsonToReact:JsonArray key or value is null");
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                createArray.pushDouble(jSONArray.getDouble(i));
            } else if (obj instanceof Number) {
                createArray.pushInt(jSONArray.getInt(i));
            } else if (obj instanceof String) {
                createArray.pushString(jSONArray.getString(i));
            } else if (obj instanceof Boolean) {
                createArray.pushBoolean(jSONArray.getBoolean(i));
            } else if (obj instanceof JSONObject) {
                createArray.pushMap(jsonToReact(jSONArray.getJSONObject(i)));
            } else if (obj instanceof JSONArray) {
                createArray.pushArray(jsonToReact(jSONArray.getJSONArray(i)));
            } else if (obj == JSONObject.NULL) {
                createArray.pushNull();
            }
        }
        return createArray;
    }

    public static List<Object> readableArrayToList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        MLogger.d(SendBirdModule.TAG, "readableArrayToList: ");
        List<Object> arrayList = new ArrayList<>(readableArray.size());
        int i = 0;
        while (i < readableArray.size()) {
            try {
                int ordinal = readableArray.getType(i).ordinal();
                if (ordinal == 0) {
                    arrayList.add(String.valueOf(i));
                } else if (ordinal == 1) {
                    arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                } else if (ordinal == 2) {
                    MLogger.d(SendBirdModule.TAG, "readableArrayToList:Double ");
                    double d2 = readableArray.getDouble(i);
                    int i2 = (int) d2;
                    if (d2 == ((double) i2)) {
                        arrayList.add(Integer.valueOf(i2));
                    } else {
                        arrayList.add(Double.valueOf(d2));
                    }
                } else if (ordinal == 3) {
                    arrayList.add(readableArray.getString(i));
                } else if (ordinal == 4) {
                    arrayList.add(readableMapToMap(readableArray.getMap(i)));
                } else if (ordinal == 5) {
                    arrayList = readableArrayToList(readableArray.getArray(i));
                } else {
                    throw new IllegalArgumentException("Could not convert object with index: " + i + ".");
                }
                i++;
            } catch (Exception e2) {
                MLogger.e(SendBirdModule.TAG, "readableArrayToList: ", e2);
            }
        }
        return arrayList;
    }

    public static Map<String, Object> readableMapToMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return new HashMap();
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        if (!keySetIterator.hasNextKey()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, toObject(readableMap, nextKey));
        }
        return hashMap;
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Double] */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r5v6, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r5v8, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object toObject(com.facebook.react.bridge.ReadableMap r4, java.lang.String r5) {
        /*
            if (r4 != 0) goto L_0x0004
            r4 = 0
            return r4
        L_0x0004:
            com.facebook.react.bridge.ReadableType r0 = r4.getType(r5)
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x005e
            r1 = 1
            if (r0 == r1) goto L_0x0056
            r1 = 2
            if (r0 == r1) goto L_0x0042
            r1 = 3
            if (r0 == r1) goto L_0x003d
            r1 = 4
            if (r0 == r1) goto L_0x0034
            r1 = 5
            if (r0 != r1) goto L_0x0026
            com.facebook.react.bridge.ReadableArray r4 = r4.getArray(r5)
            java.util.List r5 = readableArrayToList(r4)
            goto L_0x005e
        L_0x0026:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Could not convert object with key: "
            java.lang.String r1 = "."
            java.lang.String r5 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r0, r5, r1)
            r4.<init>(r5)
            throw r4
        L_0x0034:
            com.facebook.react.bridge.ReadableMap r4 = r4.getMap(r5)
            java.util.Map r5 = readableMapToMap(r4)
            goto L_0x005e
        L_0x003d:
            java.lang.String r5 = r4.getString(r5)
            goto L_0x005e
        L_0x0042:
            double r4 = r4.getDouble(r5)
            int r0 = (int) r4
            double r1 = (double) r0
            int r3 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0051
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            goto L_0x005e
        L_0x0051:
            java.lang.Double r5 = java.lang.Double.valueOf(r4)
            goto L_0x005e
        L_0x0056:
            boolean r4 = r4.getBoolean(r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
        L_0x005e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.ConvertUtils.toObject(com.facebook.react.bridge.ReadableMap, java.lang.String):java.lang.Object");
    }

    public static WritableMap jsonToReact(JSONObject jSONObject) throws JSONException {
        WritableMap createMap = Arguments.createMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (next == null || TextUtils.isEmpty(next) || obj == null) {
                MLogger.d(SendBirdModule.TAG, "jsonToReact: key or value is null");
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                createMap.putDouble(next, jSONObject.getDouble(next));
            } else if (obj instanceof Number) {
                createMap.putInt(next, jSONObject.getInt(next));
            } else if (obj instanceof String) {
                createMap.putString(next, jSONObject.getString(next));
            } else if (obj instanceof JSONObject) {
                createMap.putMap(next, jsonToReact(jSONObject.getJSONObject(next)));
            } else if (obj instanceof JSONArray) {
                createMap.putArray(next, jsonToReact(jSONObject.getJSONArray(next)));
            } else if (obj instanceof Boolean) {
                createMap.putBoolean(next, jSONObject.getBoolean(next));
            } else if (obj == JSONObject.NULL) {
                createMap.putNull(next);
            }
        }
        return createMap;
    }
}
