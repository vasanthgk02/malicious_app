package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

public final class JWEAlgorithm extends a {
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final JWEAlgorithm f1949b = new JWEAlgorithm("RSA1_5", m.REQUIRED);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final JWEAlgorithm f1950c = new JWEAlgorithm("RSA-OAEP", m.OPTIONAL);

    /* renamed from: d  reason: collision with root package name */
    public static final JWEAlgorithm f1951d = new JWEAlgorithm("RSA-OAEP-256", m.OPTIONAL);

    /* renamed from: e  reason: collision with root package name */
    public static final JWEAlgorithm f1952e = new JWEAlgorithm("A128KW", m.RECOMMENDED);

    /* renamed from: f  reason: collision with root package name */
    public static final JWEAlgorithm f1953f = new JWEAlgorithm("A192KW", m.OPTIONAL);
    public static final JWEAlgorithm g = new JWEAlgorithm("A256KW", m.RECOMMENDED);
    public static final JWEAlgorithm h = new JWEAlgorithm("dir", m.RECOMMENDED);
    public static final JWEAlgorithm i = new JWEAlgorithm("ECDH-ES", m.RECOMMENDED);
    public static final JWEAlgorithm j = new JWEAlgorithm("ECDH-ES+A128KW", m.RECOMMENDED);
    public static final JWEAlgorithm k = new JWEAlgorithm("ECDH-ES+A192KW", m.OPTIONAL);
    public static final JWEAlgorithm l = new JWEAlgorithm("ECDH-ES+A256KW", m.RECOMMENDED);
    public static final JWEAlgorithm m = new JWEAlgorithm("A128GCMKW", m.OPTIONAL);
    public static final JWEAlgorithm n = new JWEAlgorithm("A192GCMKW", m.OPTIONAL);
    public static final JWEAlgorithm o = new JWEAlgorithm("A256GCMKW", m.OPTIONAL);
    public static final JWEAlgorithm p = new JWEAlgorithm("PBES2-HS256+A128KW", m.OPTIONAL);
    public static final JWEAlgorithm q = new JWEAlgorithm("PBES2-HS384+A192KW", m.OPTIONAL);
    public static final JWEAlgorithm r = new JWEAlgorithm("PBES2-HS512+A256KW", m.OPTIONAL);

    public JWEAlgorithm(String str) {
        super(str, null);
    }

    public JWEAlgorithm(String str, m mVar) {
        super(str, mVar);
    }
}
