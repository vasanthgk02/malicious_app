package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;

public abstract class h extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<JWEAlgorithm> f1996a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<EncryptionMethod> f1997b = f.f1993a;

    /* renamed from: c  reason: collision with root package name */
    public final SecretKey f1998c;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWEAlgorithm.h);
        f1996a = Collections.unmodifiableSet(linkedHashSet);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(javax.crypto.SecretKey r4) {
        /*
            r3 = this;
            java.util.Set<com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm> r0 = f1996a
            byte[] r1 = r4.getEncoded()
            int r1 = co.hyperverge.hypersnapsdk.c.k.a(r1)
            java.util.Map<java.lang.Integer, java.util.Set<com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod>> r2 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.f.f1994b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r2.get(r1)
            java.util.Set r1 = (java.util.Set) r1
            if (r1 == 0) goto L_0x001e
            r3.<init>(r0, r1)
            r3.f1998c = r4
            return
        L_0x001e:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.KeyLengthException r4 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.KeyLengthException
            java.lang.String r0 = "The Content Encryption Key length must be 128 bits (16 bytes), 192 bits (24 bytes), 256 bits (32 bytes), 384 bits (48 bytes) or 512 bites (64 bytes)"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.h.<init>(javax.crypto.SecretKey):void");
    }
}
