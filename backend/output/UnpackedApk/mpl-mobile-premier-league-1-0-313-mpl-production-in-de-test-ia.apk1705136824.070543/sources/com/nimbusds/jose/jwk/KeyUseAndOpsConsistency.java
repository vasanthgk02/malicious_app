package com.nimbusds.jose.jwk;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyUseAndOpsConsistency {
    public static Map<KeyUse, Set<KeyOperation>> MAP;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(KeyUse.SIGNATURE, new HashSet(Arrays.asList(new KeyOperation[]{KeyOperation.SIGN, KeyOperation.VERIFY})));
        hashMap.put(KeyUse.ENCRYPTION, new HashSet(Arrays.asList(new KeyOperation[]{KeyOperation.ENCRYPT, KeyOperation.DECRYPT, KeyOperation.WRAP_KEY, KeyOperation.UNWRAP_KEY})));
        MAP = Collections.unmodifiableMap(hashMap);
    }

    public static boolean areConsistent(KeyUse keyUse, Set<KeyOperation> set) {
        if (keyUse == null || set == null) {
            return true;
        }
        return MAP.get(keyUse).containsAll(set);
    }
}
