package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

public final class JWSAlgorithm extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final JWSAlgorithm f1966b = new JWSAlgorithm("HS256", m.REQUIRED);

    /* renamed from: c  reason: collision with root package name */
    public static final JWSAlgorithm f1967c = new JWSAlgorithm("HS384", m.OPTIONAL);

    /* renamed from: d  reason: collision with root package name */
    public static final JWSAlgorithm f1968d = new JWSAlgorithm("HS512", m.OPTIONAL);

    /* renamed from: e  reason: collision with root package name */
    public static final JWSAlgorithm f1969e = new JWSAlgorithm("RS256", m.RECOMMENDED);

    /* renamed from: f  reason: collision with root package name */
    public static final JWSAlgorithm f1970f = new JWSAlgorithm("RS384", m.OPTIONAL);
    public static final JWSAlgorithm g = new JWSAlgorithm("RS512", m.OPTIONAL);
    public static final JWSAlgorithm h = new JWSAlgorithm("ES256", m.RECOMMENDED);
    public static final JWSAlgorithm i = new JWSAlgorithm("ES256K", m.OPTIONAL);
    public static final JWSAlgorithm j = new JWSAlgorithm("ES384", m.OPTIONAL);
    public static final JWSAlgorithm k = new JWSAlgorithm("ES512", m.OPTIONAL);
    public static final JWSAlgorithm l = new JWSAlgorithm("PS256", m.OPTIONAL);
    public static final JWSAlgorithm m = new JWSAlgorithm("PS384", m.OPTIONAL);
    public static final JWSAlgorithm n = new JWSAlgorithm("PS512", m.OPTIONAL);
    public static final JWSAlgorithm o = new JWSAlgorithm("EdDSA", m.OPTIONAL);

    public JWSAlgorithm(String str) {
        super(str, null);
    }

    public JWSAlgorithm(String str, m mVar) {
        super(str, mVar);
    }
}
