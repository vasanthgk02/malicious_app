package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.a.c;
import java.util.Collections;
import java.util.Set;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final Set<JWEAlgorithm> f1990a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<EncryptionMethod> f1991b;

    /* renamed from: c  reason: collision with root package name */
    public final c f1992c = new c();

    public b(Set<JWEAlgorithm> set, Set<EncryptionMethod> set2) {
        if (set != null) {
            this.f1990a = Collections.unmodifiableSet(set);
            this.f1991b = set2;
            return;
        }
        throw new IllegalArgumentException("The supported JWE algorithm set must not be null");
    }
}
