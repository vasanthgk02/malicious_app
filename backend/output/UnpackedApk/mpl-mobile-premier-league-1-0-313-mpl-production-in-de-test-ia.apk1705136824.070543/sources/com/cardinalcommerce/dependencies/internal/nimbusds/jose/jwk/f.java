package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Map<e, Set<c>> f2036a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(e.f2033a, new HashSet(Arrays.asList(new c[]{c.SIGN, c.VERIFY})));
        hashMap.put(e.f2034b, new HashSet(Arrays.asList(new c[]{c.ENCRYPT, c.DECRYPT, c.WRAP_KEY, c.UNWRAP_KEY})));
        f2036a = Collections.unmodifiableMap(hashMap);
    }

    public static boolean a(e eVar, Set<c> set) {
        if (eVar == null || set == null) {
            return true;
        }
        return f2036a.get(eVar).containsAll(set);
    }
}
