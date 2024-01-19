package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jca.JCAContext;
import java.util.Collections;
import java.util.Set;

public abstract class BaseJWSProvider {
    public final JCAContext jcaContext = new JCAContext();

    public BaseJWSProvider(Set<JWSAlgorithm> set) {
        if (set != null) {
            Collections.unmodifiableSet(set);
            return;
        }
        throw new IllegalArgumentException("The supported JWS algorithm set must not be null");
    }
}
