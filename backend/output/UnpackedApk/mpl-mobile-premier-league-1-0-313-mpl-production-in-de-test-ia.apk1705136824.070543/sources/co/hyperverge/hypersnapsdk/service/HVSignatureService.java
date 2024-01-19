package co.hyperverge.hypersnapsdk.service;

import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;
import java.util.Iterator;
import java.util.TreeMap;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HVSignatureService {
    public static TreeMap<String, Object> convertJSONObjToMap(JSONObject jSONObject) {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = null;
            try {
                obj = jSONObject.get(next);
            } catch (JSONException e2) {
                i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
            treeMap.put(next, obj);
        }
        return treeMap;
    }

    public static String sortJSONKeysAlphabetically(TreeMap<String, Object> treeMap) {
        JSONObject jSONObject;
        try {
            String str = "{";
            for (String next : treeMap.keySet()) {
                if (!str.equals("{")) {
                    str = str + ",";
                }
                Object obj = treeMap.get(next);
                if (obj instanceof JSONObject) {
                    obj = sortJSONKeysAlphabetically(convertJSONObjToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    try {
                        jSONObject = ((JSONArray) obj).getJSONObject(0);
                    } catch (JSONException e2) {
                        i.a((Throwable) e2);
                        if (n.m().i != null) {
                            n.m().i.a(e2);
                        }
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        TreeMap<String, Object> convertJSONObjToMap = convertJSONObjToMap(jSONObject);
                        obj = "[" + sortJSONKeysAlphabetically(convertJSONObjToMap) + CMapParser.MARK_END_OF_ARRAY;
                    }
                } else if (obj instanceof String) {
                    obj = "\"" + obj.toString() + "\"";
                }
                str = str + "\"" + next + "\":" + obj;
            }
            return str + "}";
        } catch (Exception e3) {
            i.a((Throwable) e3);
            return null;
        }
    }
}
