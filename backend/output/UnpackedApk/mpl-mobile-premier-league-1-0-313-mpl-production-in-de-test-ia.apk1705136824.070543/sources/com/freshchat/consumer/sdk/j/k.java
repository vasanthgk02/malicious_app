package com.freshchat.consumer.sdk.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class k {
    public static boolean a(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int b(Collection<?> collection) {
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public static <T> Set<T> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new HashSet();
        }
        int length = jSONArray.length();
        HashSet hashSet = new HashSet(length);
        for (int i = 0; i < length; i++) {
            try {
                hashSet.add(jSONArray.get(i));
            } catch (JSONException e2) {
                q.a(e2);
            }
        }
        return hashSet;
    }

    public static Collection<String> c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        if (a(collection)) {
            for (String obj : collection) {
                arrayList.add(obj.toString().trim().toLowerCase());
            }
        }
        return arrayList;
    }

    public static boolean c(Map<?, ?> map) {
        return map == null || map.size() == 0;
    }

    public static boolean c(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static Collection<String> d(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        if (a(collection)) {
            for (String obj : collection) {
                arrayList.add(obj.toString().trim());
            }
        }
        return arrayList;
    }

    public static boolean d(Map<?, ?> map) {
        return !c(map);
    }

    public static int f(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }
}
