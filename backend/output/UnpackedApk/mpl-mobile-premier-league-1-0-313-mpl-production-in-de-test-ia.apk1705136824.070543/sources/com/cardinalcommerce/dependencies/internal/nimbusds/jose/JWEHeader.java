package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class JWEHeader extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f1954a;

    /* renamed from: b  reason: collision with root package name */
    public final EncryptionMethod f1955b;

    /* renamed from: c  reason: collision with root package name */
    public final JWK f1956c;

    /* renamed from: d  reason: collision with root package name */
    public final c f1957d;

    /* renamed from: e  reason: collision with root package name */
    public final Base64URL f1958e;

    /* renamed from: f  reason: collision with root package name */
    public final Base64URL f1959f;
    public final Base64URL g;
    public final int h;
    public final Base64URL i;
    public final Base64URL j;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("alg");
        hashSet.add("enc");
        hashSet.add("epk");
        hashSet.add("zip");
        hashSet.add("jku");
        GeneratedOutlineSupport.outline104(hashSet, "jwk", "x5u", "x5t", "x5t#S256");
        GeneratedOutlineSupport.outline104(hashSet, "x5c", "kid", "typ", "cty");
        GeneratedOutlineSupport.outline104(hashSet, "crit", "apu", "apv", "p2s");
        hashSet.add("p2c");
        hashSet.add("iv");
        hashSet.add("authTag");
        f1954a = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JWEHeader(a aVar, EncryptionMethod encryptionMethod, f fVar, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, JWK jwk2, c cVar, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, int i2, Base64URL base64URL6, Base64URL base64URL7, Map<String, Object> map, Base64URL base64URL8) {
        // EncryptionMethod encryptionMethod2 = encryptionMethod;
        // JWK jwk3 = jwk2;
        super(aVar, fVar, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, map, base64URL8);
        if (aVar.f1977b.equals(a.f1976a.f1977b)) {
            throw new IllegalArgumentException("The JWE algorithm cannot be \"none\"");
        } else if (encryptionMethod2 == null) {
            throw new IllegalArgumentException("The encryption method \"enc\" parameter must not be null");
        } else if (jwk3 == null || !jwk2.c()) {
            this.f1955b = encryptionMethod2;
            this.f1956c = jwk3;
            this.f1957d = cVar;
            this.f1958e = base64URL3;
            this.f1959f = base64URL4;
            this.g = base64URL5;
            this.h = i2;
            this.i = base64URL6;
            this.j = base64URL7;
        } else {
            throw new IllegalArgumentException("Ephemeral public key should not be a private key");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x045b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader a(com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r30) {
        /*
            java.lang.String r0 = new java.lang.String
            byte[] r1 = r30.a()
            java.nio.charset.Charset r2 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.i.f2055a
            r0.<init>(r1, r2)
            r1 = 0
            com.cardinalcommerce.dependencies.internal.minidev.json.b.a r2 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.a     // Catch:{ i -> 0x048c, Exception -> 0x047b }
            r3 = 640(0x280, float:8.97E-43)
            r2.<init>(r3)     // Catch:{ i -> 0x048c, Exception -> 0x047b }
            java.lang.Object r0 = r2.a(r0)     // Catch:{ i -> 0x048c, Exception -> 0x047b }
            boolean r2 = r0 instanceof com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject
            if (r2 == 0) goto L_0x0473
            com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject r0 = (com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject) r0
            java.lang.String r2 = "alg"
            java.lang.String r3 = co.hyperverge.hypersnapsdk.c.k.d(r0, r2)
            if (r3 == 0) goto L_0x046b
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.a r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.a.f1976a
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            java.lang.String r5 = "enc"
            if (r4 == 0) goto L_0x0035
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.a r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.a.f1976a
            goto L_0x01f2
        L_0x0035:
            boolean r4 = r0.containsKey(r5)
            if (r4 == 0) goto L_0x0130
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1949b
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0049
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1949b
            goto L_0x01f2
        L_0x0049:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1950c
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0057
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1950c
            goto L_0x01f2
        L_0x0057:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1951d
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0065
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1951d
            goto L_0x01f2
        L_0x0065:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1952e
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0073
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1952e
            goto L_0x01f2
        L_0x0073:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1953f
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0081
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.f1953f
            goto L_0x01f2
        L_0x0081:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.g
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x008f
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.g
            goto L_0x01f2
        L_0x008f:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.h
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x009d
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.h
            goto L_0x01f2
        L_0x009d:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.i
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x00ab
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.i
            goto L_0x01f2
        L_0x00ab:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.j
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x00b9
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.j
            goto L_0x01f2
        L_0x00b9:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.k
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x00c7
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.k
            goto L_0x01f2
        L_0x00c7:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.l
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x00d5
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.l
            goto L_0x01f2
        L_0x00d5:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.m
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x00e3
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.m
            goto L_0x01f2
        L_0x00e3:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.n
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x00f1
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.n
            goto L_0x01f2
        L_0x00f1:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.o
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x00ff
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.o
            goto L_0x01f2
        L_0x00ff:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.p
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x010d
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.p
            goto L_0x01f2
        L_0x010d:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.q
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x011b
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.q
            goto L_0x01f2
        L_0x011b:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.r
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0129
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm.r
            goto L_0x01f2
        L_0x0129:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r4 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm
            r4.<init>(r3)
            goto L_0x01f1
        L_0x0130:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1966b
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x013e
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1966b
            goto L_0x01f2
        L_0x013e:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1967c
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x014c
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1967c
            goto L_0x01f2
        L_0x014c:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1968d
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x015a
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1968d
            goto L_0x01f2
        L_0x015a:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1969e
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0168
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1969e
            goto L_0x01f2
        L_0x0168:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1970f
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0176
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.f1970f
            goto L_0x01f2
        L_0x0176:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.g
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0184
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.g
            goto L_0x01f2
        L_0x0184:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.h
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0191
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.h
            goto L_0x01f2
        L_0x0191:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.i
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x019e
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.i
            goto L_0x01f2
        L_0x019e:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.j
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x01ab
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.j
            goto L_0x01f2
        L_0x01ab:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.k
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x01b8
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.k
            goto L_0x01f2
        L_0x01b8:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.l
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x01c5
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.l
            goto L_0x01f2
        L_0x01c5:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.m
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x01d2
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.m
            goto L_0x01f2
        L_0x01d2:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.n
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x01df
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.n
            goto L_0x01f2
        L_0x01df:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.o
            java.lang.String r4 = r4.f1977b
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x01ec
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r3 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.o
            goto L_0x01f2
        L_0x01ec:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r4 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm
            r4.<init>(r3)
        L_0x01f1:
            r3 = r4
        L_0x01f2:
            boolean r4 = r3 instanceof com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm
            if (r4 == 0) goto L_0x0463
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r5)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1944b
            java.lang.String r6 = r6.f1977b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0208
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1944b
            goto L_0x0262
        L_0x0208:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1945c
            java.lang.String r6 = r6.f1977b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0215
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1945c
            goto L_0x0262
        L_0x0215:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1946d
            java.lang.String r6 = r6.f1977b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0222
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1946d
            goto L_0x0262
        L_0x0222:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.g
            java.lang.String r6 = r6.f1977b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x022f
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.g
            goto L_0x0262
        L_0x022f:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.h
            java.lang.String r6 = r6.f1977b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x023c
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.h
            goto L_0x0262
        L_0x023c:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.i
            java.lang.String r6 = r6.f1977b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0249
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.i
            goto L_0x0262
        L_0x0249:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1947e
            java.lang.String r6 = r6.f1977b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0256
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1947e
            goto L_0x0262
        L_0x0256:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1948f
            java.lang.String r6 = r6.f1977b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0264
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.f1948f
        L_0x0262:
            r9 = r4
            goto L_0x026a
        L_0x0264:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r6 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod
            r6.<init>(r4)
            r9 = r6
        L_0x026a:
            r8 = r3
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm r8 = (com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm) r8
            java.lang.String r3 = r8.f1977b
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.a r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.a.f1976a
            java.lang.String r4 = r4.f1977b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x045b
            if (r9 == 0) goto L_0x0453
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r6 = 0
            r10 = r4
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r21 = r20
            r22 = r21
            r23 = r22
            r24 = r23
            r26 = r24
            r27 = r26
            r28 = r27
            r25 = 0
        L_0x02a5:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x044a
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r6 = r2.equals(r4)
            if (r6 == 0) goto L_0x02b8
            goto L_0x02a5
        L_0x02b8:
            boolean r6 = r5.equals(r4)
            if (r6 == 0) goto L_0x02bf
            goto L_0x02a5
        L_0x02bf:
            java.lang.String r6 = "typ"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x02d3
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            if (r4 == 0) goto L_0x02a5
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.f r10 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.f
            r10.<init>(r4)
            goto L_0x02a5
        L_0x02d3:
            java.lang.String r6 = "cty"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x02e0
            java.lang.String r11 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            goto L_0x02a5
        L_0x02e0:
            java.lang.String r6 = "crit"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x02f4
            java.util.List r4 = co.hyperverge.hypersnapsdk.c.k.h(r0, r4)
            if (r4 == 0) goto L_0x02a5
            java.util.HashSet r12 = new java.util.HashSet
            r12.<init>(r4)
            goto L_0x02a5
        L_0x02f4:
            java.lang.String r6 = "jku"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0301
            java.net.URI r13 = co.hyperverge.hypersnapsdk.c.k.e(r0, r4)
            goto L_0x02a5
        L_0x0301:
            java.lang.String r6 = "jwk"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0318
            java.lang.Class<com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject> r6 = com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject.class
            java.lang.Object r4 = co.hyperverge.hypersnapsdk.c.k.a(r0, r4, r6)
            com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject r4 = (com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject) r4
            if (r4 == 0) goto L_0x02a5
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK r14 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK.b(r4)
            goto L_0x02a5
        L_0x0318:
            java.lang.String r6 = "x5u"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0325
            java.net.URI r15 = co.hyperverge.hypersnapsdk.c.k.e(r0, r4)
            goto L_0x02a5
        L_0x0325:
            java.lang.String r6 = "x5t"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0337
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r16 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.a(r4)
            goto L_0x02a5
        L_0x0337:
            java.lang.String r6 = "x5t#S256"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0349
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r17 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.a(r4)
            goto L_0x02a5
        L_0x0349:
            java.lang.String r6 = "x5c"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x035b
            com.cardinalcommerce.dependencies.internal.minidev.json.JSONArray r4 = co.hyperverge.hypersnapsdk.c.k.f(r0, r4)
            java.util.List r18 = co.hyperverge.hypersnapsdk.c.k.a(r4)
            goto L_0x02a5
        L_0x035b:
            java.lang.String r6 = "kid"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0369
            java.lang.String r19 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            goto L_0x02a5
        L_0x0369:
            java.lang.String r6 = "epk"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x037f
            java.lang.Class<com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject> r6 = com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject.class
            java.lang.Object r4 = co.hyperverge.hypersnapsdk.c.k.a(r0, r4, r6)
            com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject r4 = (com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject) r4
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK r20 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK.b(r4)
            goto L_0x02a5
        L_0x037f:
            java.lang.String r6 = "zip"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0396
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            if (r4 == 0) goto L_0x02a5
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.c r6 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.c
            r6.<init>(r4)
            r21 = r6
            goto L_0x02a5
        L_0x0396:
            java.lang.String r6 = "apu"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x03a8
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r22 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.a(r4)
            goto L_0x02a5
        L_0x03a8:
            java.lang.String r6 = "apv"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x03ba
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r23 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.a(r4)
            goto L_0x02a5
        L_0x03ba:
            java.lang.String r6 = "p2s"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x03cc
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r24 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.a(r4)
            goto L_0x02a5
        L_0x03cc:
            java.lang.String r6 = "p2c"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x03fc
            java.lang.Class<java.lang.Number> r6 = java.lang.Number.class
            java.lang.Object r6 = co.hyperverge.hypersnapsdk.c.k.a(r0, r4, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            if (r6 == 0) goto L_0x03ee
            int r25 = r6.intValue()
            if (r25 < 0) goto L_0x03e6
            goto L_0x02a5
        L_0x03e6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The PBES2 count parameter must not be negative"
            r0.<init>(r1)
            throw r0
        L_0x03ee:
            java.text.ParseException r0 = new java.text.ParseException
            java.lang.String r2 = "JSON object member with key \""
            java.lang.String r3 = "\" is missing or null"
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r2, r4, r3)
            r0.<init>(r2, r1)
            throw r0
        L_0x03fc:
            java.lang.String r6 = "iv"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x040e
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r26 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.a(r4)
            goto L_0x02a5
        L_0x040e:
            java.lang.String r6 = "tag"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0420
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.d(r0, r4)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r27 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.a(r4)
            goto L_0x02a5
        L_0x0420:
            java.lang.Object r6 = r0.get(r4)
            java.util.Set<java.lang.String> r7 = f1954a
            boolean r7 = r7.contains(r4)
            if (r7 != 0) goto L_0x043c
            if (r28 != 0) goto L_0x0433
            java.util.HashMap r28 = new java.util.HashMap
            r28.<init>()
        L_0x0433:
            r7 = r28
            r7.put(r4, r6)
            r28 = r7
            goto L_0x02a5
        L_0x043c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The parameter name \""
            java.lang.String r2 = "\" matches a registered name"
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r1, r4, r2)
            r0.<init>(r1)
            throw r0
        L_0x044a:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader r0 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader
            r7 = r0
            r29 = r30
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r0
        L_0x0453:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The encryption method \"enc\" parameter must not be null"
            r0.<init>(r1)
            throw r0
        L_0x045b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The JWE algorithm \"alg\" cannot be \"none\""
            r0.<init>(r1)
            throw r0
        L_0x0463:
            java.text.ParseException r0 = new java.text.ParseException
            java.lang.String r2 = "The algorithm \"alg\" header parameter must be for encryption"
            r0.<init>(r2, r1)
            throw r0
        L_0x046b:
            java.text.ParseException r0 = new java.text.ParseException
            java.lang.String r2 = "Missing \"alg\" in header JSON object"
            r0.<init>(r2, r1)
            throw r0
        L_0x0473:
            java.text.ParseException r0 = new java.text.ParseException
            java.lang.String r2 = "JSON entity is not an object"
            r0.<init>(r2, r1)
            throw r0
        L_0x047b:
            r0 = move-exception
            java.text.ParseException r2 = new java.text.ParseException
            java.lang.String r3 = "Unexpected exception: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline39(r0, r3)
            r2.<init>(r0, r1)
            throw r2
        L_0x048c:
            r0 = move-exception
            java.text.ParseException r2 = new java.text.ParseException
            java.lang.String r3 = "Invalid JSON: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader.a(com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL):com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader");
    }

    public JSONObject b() {
        JSONObject b2 = super.b();
        EncryptionMethod encryptionMethod = this.f1955b;
        if (encryptionMethod != null) {
            b2.put("enc", encryptionMethod.f1977b);
        }
        JWK jwk = this.f1956c;
        if (jwk != null) {
            b2.put("epk", jwk.d());
        }
        c cVar = this.f1957d;
        if (cVar != null) {
            b2.put("zip", cVar.f1987b);
        }
        Base64URL base64URL = this.f1958e;
        if (base64URL != null) {
            b2.put("apu", base64URL.f2053a);
        }
        Base64URL base64URL2 = this.f1959f;
        if (base64URL2 != null) {
            b2.put("apv", base64URL2.f2053a);
        }
        Base64URL base64URL3 = this.g;
        if (base64URL3 != null) {
            b2.put("p2s", base64URL3.f2053a);
        }
        int i2 = this.h;
        if (i2 > 0) {
            b2.put("p2c", Integer.valueOf(i2));
        }
        Base64URL base64URL4 = this.i;
        if (base64URL4 != null) {
            b2.put("iv", base64URL4.f2053a);
        }
        Base64URL base64URL5 = this.j;
        if (base64URL5 != null) {
            b2.put(InlineAnimation.TAG, base64URL5.f2053a);
        }
        return b2;
    }
}
