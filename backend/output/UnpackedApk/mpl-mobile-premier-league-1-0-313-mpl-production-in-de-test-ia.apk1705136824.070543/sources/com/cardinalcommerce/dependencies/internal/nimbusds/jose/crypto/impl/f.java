package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<EncryptionMethod> f1993a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Integer, Set<EncryptionMethod>> f1994b;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(EncryptionMethod.f1944b);
        linkedHashSet.add(EncryptionMethod.f1945c);
        linkedHashSet.add(EncryptionMethod.f1946d);
        linkedHashSet.add(EncryptionMethod.g);
        linkedHashSet.add(EncryptionMethod.h);
        linkedHashSet.add(EncryptionMethod.i);
        linkedHashSet.add(EncryptionMethod.f1947e);
        linkedHashSet.add(EncryptionMethod.f1948f);
        f1993a = Collections.unmodifiableSet(linkedHashSet);
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        hashSet.add(EncryptionMethod.g);
        hashSet2.add(EncryptionMethod.h);
        hashSet3.add(EncryptionMethod.i);
        hashSet3.add(EncryptionMethod.f1944b);
        hashSet3.add(EncryptionMethod.f1947e);
        hashSet4.add(EncryptionMethod.f1945c);
        hashSet5.add(EncryptionMethod.f1946d);
        hashSet5.add(EncryptionMethod.f1948f);
        hashMap.put(Integer.valueOf(128), Collections.unmodifiableSet(hashSet));
        hashMap.put(Integer.valueOf(192), Collections.unmodifiableSet(hashSet2));
        hashMap.put(Integer.valueOf(256), Collections.unmodifiableSet(hashSet3));
        hashMap.put(Integer.valueOf(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT), Collections.unmodifiableSet(hashSet4));
        hashMap.put(Integer.valueOf(512), Collections.unmodifiableSet(hashSet5));
        f1994b = Collections.unmodifiableMap(hashMap);
    }
}
