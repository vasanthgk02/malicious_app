package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONArray;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.io.Serializable;
import java.security.PrivateKey;
import java.util.List;
import java.util.Objects;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

public final class i extends JWK {

    /* renamed from: a  reason: collision with root package name */
    public final Base64URL f2044a;

    /* renamed from: b  reason: collision with root package name */
    public final Base64URL f2045b;

    /* renamed from: c  reason: collision with root package name */
    public final Base64URL f2046c;

    /* renamed from: d  reason: collision with root package name */
    public final Base64URL f2047d;

    /* renamed from: e  reason: collision with root package name */
    public final Base64URL f2048e;

    /* renamed from: f  reason: collision with root package name */
    public final Base64URL f2049f;
    public final Base64URL g;
    public final Base64URL h;
    public final List<a> i;
    public final PrivateKey j;

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Base64URL f2050a;

        /* renamed from: b  reason: collision with root package name */
        public final Base64URL f2051b;

        /* renamed from: c  reason: collision with root package name */
        public final Base64URL f2052c;

        public a(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) {
            if (base64URL != null) {
                this.f2050a = base64URL;
                if (base64URL2 != null) {
                    this.f2051b = base64URL2;
                    if (base64URL3 != null) {
                        this.f2052c = base64URL3;
                        return;
                    }
                    throw new IllegalArgumentException("The factor CRT coefficient must not be null");
                }
                throw new IllegalArgumentException("The factor CRT exponent must not be null");
            }
            throw new IllegalArgumentException("The prime factor must not be null");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r18, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r19, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r20, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r21, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r22, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r23, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r24, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r25, java.util.List<com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.i.a> r26, java.security.PrivateKey r27, com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.e r28, java.util.Set<com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.c> r29, com.cardinalcommerce.dependencies.internal.nimbusds.jose.a r30, java.lang.String r31, java.net.URI r32, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r33, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r34, java.util.List<com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64> r35, java.security.KeyStore r36) {
        /*
            r17 = this;
            r11 = r17
            r12 = r18
            r13 = r19
            r14 = r21
            r15 = r22
            r10 = r23
            r9 = r24
            r8 = r25
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.d r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.d.f2029b
            r16 = 0
            r0 = r17
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r12 == 0) goto L_0x010d
            r11.f2044a = r12
            if (r13 == 0) goto L_0x0105
            r11.f2045b = r13
            java.util.List r0 = r17.e()
            if (r0 == 0) goto L_0x0084
            java.util.List r0 = r17.e()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.util.List r0 = r17.e()     // Catch:{ ClassCastException -> 0x0078 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ ClassCastException -> 0x0078 }
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch:{ ClassCastException -> 0x0078 }
            java.security.PublicKey r0 = r0.getPublicKey()     // Catch:{ ClassCastException -> 0x0078 }
            java.security.interfaces.RSAPublicKey r0 = (java.security.interfaces.RSAPublicKey) r0     // Catch:{ ClassCastException -> 0x0078 }
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r2 = r11.f2045b
            java.math.BigInteger r2 = r2.b()
            java.math.BigInteger r3 = r0.getPublicExponent()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0065
            goto L_0x0079
        L_0x0065:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r2 = r11.f2044a
            java.math.BigInteger r2 = r2.b()
            java.math.BigInteger r0 = r0.getModulus()
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0076
            goto L_0x0079
        L_0x0076:
            r1 = 1
            goto L_0x0079
        L_0x0078:
        L_0x0079:
            if (r1 == 0) goto L_0x007c
            goto L_0x0084
        L_0x007c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters"
            r0.<init>(r1)
            throw r0
        L_0x0084:
            r0 = r20
            r11.f2046c = r0
            r0 = 0
            if (r14 == 0) goto L_0x00aa
            if (r15 == 0) goto L_0x00aa
            r1 = r23
            r2 = r24
            if (r1 == 0) goto L_0x00ae
            r3 = r25
            if (r2 == 0) goto L_0x00b0
            if (r3 == 0) goto L_0x00b0
            r11.f2047d = r14
            r11.f2048e = r15
            r11.f2049f = r1
            r11.g = r2
            r11.h = r3
            if (r26 == 0) goto L_0x00d2
            java.util.List r1 = java.util.Collections.unmodifiableList(r26)
            goto L_0x00d6
        L_0x00aa:
            r1 = r23
            r2 = r24
        L_0x00ae:
            r3 = r25
        L_0x00b0:
            if (r14 != 0) goto L_0x00bd
            if (r15 != 0) goto L_0x00bd
            if (r1 != 0) goto L_0x00bd
            if (r2 != 0) goto L_0x00bd
            if (r3 != 0) goto L_0x00bd
            if (r26 != 0) goto L_0x00bd
            goto L_0x00c8
        L_0x00bd:
            if (r14 != 0) goto L_0x00db
            if (r15 != 0) goto L_0x00db
            if (r1 != 0) goto L_0x00db
            if (r2 != 0) goto L_0x00db
            if (r3 == 0) goto L_0x00c8
            goto L_0x00db
        L_0x00c8:
            r11.f2047d = r0
            r11.f2048e = r0
            r11.f2049f = r0
            r11.g = r0
            r11.h = r0
        L_0x00d2:
            java.util.List r1 = java.util.Collections.emptyList()
        L_0x00d6:
            r11.i = r1
            r11.j = r0
            return
        L_0x00db:
            if (r14 == 0) goto L_0x00fd
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            if (r15 == 0) goto L_0x00f7
            if (r1 == 0) goto L_0x00f1
            if (r2 != 0) goto L_0x00eb
            java.lang.String r1 = "Incomplete second private (CRT) representation: The second factor CRT exponent must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00eb:
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first CRT coefficient must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00f1:
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first factor CRT exponent must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00f7:
            java.lang.String r1 = "Incomplete second private (CRT) representation: The second prime factor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00fd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first prime factor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x0105:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The public exponent value must not be null"
            r0.<init>(r1)
            throw r0
        L_0x010d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The modulus value must not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.i.<init>(com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, java.util.List, java.security.PrivateKey, com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.e, java.util.Set, com.cardinalcommerce.dependencies.internal.nimbusds.jose.a, java.lang.String, java.net.URI, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, java.util.List, java.security.KeyStore):void");
    }

    public boolean c() {
        return (this.f2046c == null && this.f2047d == null && this.j == null) ? false : true;
    }

    public JSONObject d() {
        JSONObject d2 = super.d();
        d2.put("n", this.f2044a.f2053a);
        d2.put("e", this.f2045b.f2053a);
        Base64URL base64URL = this.f2046c;
        if (base64URL != null) {
            d2.put("d", base64URL.f2053a);
        }
        Base64URL base64URL2 = this.f2047d;
        if (base64URL2 != null) {
            d2.put("p", base64URL2.f2053a);
        }
        Base64URL base64URL3 = this.f2048e;
        if (base64URL3 != null) {
            d2.put(SetUserPositionRequest.KEY_PLUS_ITEM_LIST, base64URL3.f2053a);
        }
        Base64URL base64URL4 = this.f2049f;
        if (base64URL4 != null) {
            d2.put("dp", base64URL4.f2053a);
        }
        Base64URL base64URL5 = this.g;
        if (base64URL5 != null) {
            d2.put("dq", base64URL5.f2053a);
        }
        Base64URL base64URL6 = this.h;
        if (base64URL6 != null) {
            d2.put("qi", base64URL6.f2053a);
        }
        List<a> list = this.i;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (a next : this.i) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("r", next.f2050a.f2053a);
                jSONObject.put("d", next.f2051b.f2053a);
                jSONObject.put("t", next.f2052c.f2053a);
                jSONArray.add(jSONObject);
            }
            d2.put("oth", jSONArray);
        }
        return d2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i) || !super.equals(obj)) {
            return false;
        }
        i iVar = (i) obj;
        if (!Objects.equals(this.f2044a, iVar.f2044a) || !Objects.equals(this.f2045b, iVar.f2045b) || !Objects.equals(this.f2046c, iVar.f2046c) || !Objects.equals(this.f2047d, iVar.f2047d) || !Objects.equals(this.f2048e, iVar.f2048e) || !Objects.equals(this.f2049f, iVar.f2049f) || !Objects.equals(this.g, iVar.g) || !Objects.equals(this.h, iVar.h) || !Objects.equals(this.i, iVar.i) || !Objects.equals(this.j, iVar.j)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.f2044a, this.f2045b, this.f2046c, this.f2047d, this.f2048e, this.f2049f, this.g, this.h, this.i, this.j});
    }
}
