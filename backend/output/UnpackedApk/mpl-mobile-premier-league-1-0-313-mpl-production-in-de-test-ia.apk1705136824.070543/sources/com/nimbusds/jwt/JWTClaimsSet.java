package com.nimbusds.jwt;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public final class JWTClaimsSet implements Serializable {
    public static final long serialVersionUID = 1;
    public final Map<String, Object> claims;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("iss");
        hashSet.add("sub");
        hashSet.add("aud");
        hashSet.add("exp");
        hashSet.add("nbf");
        hashSet.add("iat");
        hashSet.add("jti");
        Collections.unmodifiableSet(hashSet);
    }

    public JWTClaimsSet(Map map, JWTClaimsSet jWTClaimsSet) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.claims = linkedHashMap;
        linkedHashMap.putAll(map);
    }

    public static JWTClaimsSet parse(JSONObject jSONObject) throws ParseException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : jSONObject.keySet()) {
            if (str.equals("iss")) {
                linkedHashMap.put("iss", TextAppearanceConfig.getString(jSONObject, "iss"));
            } else if (str.equals("sub")) {
                linkedHashMap.put("sub", TextAppearanceConfig.getString(jSONObject, "sub"));
            } else if (str.equals("aud")) {
                Object obj = jSONObject.get("aud");
                if (obj instanceof String) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(TextAppearanceConfig.getString(jSONObject, "aud"));
                    linkedHashMap.put("aud", arrayList);
                } else if (obj instanceof List) {
                    linkedHashMap.put("aud", TextAppearanceConfig.getStringList(jSONObject, "aud"));
                }
            } else if (str.equals("exp")) {
                linkedHashMap.put("exp", new Date(TextAppearanceConfig.getLong(jSONObject, "exp") * 1000));
            } else if (str.equals("nbf")) {
                linkedHashMap.put("nbf", new Date(TextAppearanceConfig.getLong(jSONObject, "nbf") * 1000));
            } else if (str.equals("iat")) {
                linkedHashMap.put("iat", new Date(TextAppearanceConfig.getLong(jSONObject, "iat") * 1000));
            } else if (str.equals("jti")) {
                linkedHashMap.put("jti", TextAppearanceConfig.getString(jSONObject, "jti"));
            } else {
                linkedHashMap.put(str, jSONObject.get(str));
            }
        }
        return new JWTClaimsSet(linkedHashMap, null);
    }

    public List<String> getStringListClaim(String str) throws ParseException {
        Object[] objArr;
        if (this.claims.get(str) == null) {
            objArr = null;
        } else {
            try {
                List list = (List) this.claims.get(str);
                int size = list.size();
                objArr = new String[size];
                int i = 0;
                while (i < size) {
                    try {
                        objArr[i] = (String) list.get(i);
                        i++;
                    } catch (ClassCastException unused) {
                        throw new ParseException(GeneratedOutlineSupport.outline51("The \"", str, "\" claim is not a list / JSON array of strings"), 0);
                    }
                }
            } catch (ClassCastException unused2) {
                throw new ParseException(GeneratedOutlineSupport.outline51("The \"", str, "\" claim is not a list / JSON array"), 0);
            }
        }
        if (objArr == null) {
            return null;
        }
        return Collections.unmodifiableList(Arrays.asList(objArr));
    }

    public String toString() {
        List<T> list;
        JSONObject jSONObject = new JSONObject();
        for (Entry next : this.claims.entrySet()) {
            if (next.getValue() instanceof Date) {
                jSONObject.put((String) next.getKey(), Long.valueOf(((Date) next.getValue()).getTime() / 1000));
            } else if ("aud".equals(next.getKey())) {
                Object obj = this.claims.get("aud");
                if (obj instanceof String) {
                    list = Collections.singletonList((String) obj);
                } else {
                    try {
                        List<String> stringListClaim = getStringListClaim("aud");
                        list = stringListClaim != null ? Collections.unmodifiableList(stringListClaim) : Collections.emptyList();
                    } catch (ParseException unused) {
                        list = Collections.emptyList();
                    }
                }
                if (list != null && !list.isEmpty()) {
                    if (list.size() == 1) {
                        jSONObject.put("aud", list.get(0));
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.addAll(list);
                        jSONObject.put("aud", jSONArray);
                    }
                }
            } else if (next.getValue() != null) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        return JSONObject.toJSONString(jSONObject, JSONValue.COMPRESSION);
    }
}
