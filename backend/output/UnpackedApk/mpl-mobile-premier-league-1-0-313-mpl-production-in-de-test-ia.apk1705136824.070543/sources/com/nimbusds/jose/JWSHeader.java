package com.nimbusds.jose;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class JWSHeader extends CommonSEHeader {
    public static final Set<String> REGISTERED_PARAMETER_NAMES;
    public static final long serialVersionUID = 1;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("alg");
        hashSet.add("jku");
        hashSet.add("jwk");
        hashSet.add("x5u");
        hashSet.add("x5t");
        GeneratedOutlineSupport.outline104(hashSet, "x5t#S256", "x5c", "kid", "typ");
        hashSet.add("cty");
        hashSet.add("crit");
        REGISTERED_PARAMETER_NAMES = Collections.unmodifiableSet(hashSet);
    }

    public JWSHeader(JWSAlgorithm jWSAlgorithm, JOSEObjectType jOSEObjectType, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, Map<String, Object> map, Base64URL base64URL3) {
        super(jWSAlgorithm, jOSEObjectType, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, map, base64URL3);
        if (jWSAlgorithm.name.equals(Algorithm.NONE.name)) {
            throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
        }
    }

    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r10v2, types: [com.nimbusds.jose.jwk.JWK] */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v7, types: [com.nimbusds.jose.jwk.OctetKeyPair] */
    /* JADX WARNING: type inference failed for: r18v0, types: [com.nimbusds.jose.jwk.OctetSequenceKey] */
    /* JADX WARNING: type inference failed for: r18v1, types: [com.nimbusds.jose.jwk.RSAKey] */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r10v13, types: [com.nimbusds.jose.jwk.ECKey] */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r10v15 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r10v17 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: type inference failed for: r10v21 */
    /* JADX WARNING: type inference failed for: r10v22 */
    /* JADX WARNING: type inference failed for: r10v23 */
    /* JADX WARNING: type inference failed for: r10v24 */
    /* JADX WARNING: type inference failed for: r10v25 */
    /* JADX WARNING: type inference failed for: r10v26 */
    /* JADX WARNING: type inference failed for: r10v27 */
    /* JADX WARNING: type inference failed for: r18v3, types: [com.nimbusds.jose.jwk.OctetSequenceKey] */
    /* JADX WARNING: type inference failed for: r10v28 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r10v3
      assigns: []
      uses: []
      mth insns count: 432
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.nimbusds.jose.JWSHeader parse(com.nimbusds.jose.util.Base64URL r43) throws java.text.ParseException {
        /*
            java.lang.String r0 = new java.lang.String
            byte[] r1 = r43.decode()
            java.nio.charset.Charset r2 = com.nimbusds.jose.util.Base64.CHARSET
            r0.<init>(r1, r2)
            net.minidev.json.JSONObject r0 = com.google.android.material.resources.TextAppearanceConfig.parse(r0)
            java.lang.String r1 = "alg"
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r0, r1)
            com.nimbusds.jose.Algorithm r3 = com.nimbusds.jose.Algorithm.NONE
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0023
            com.nimbusds.jose.Algorithm r2 = com.nimbusds.jose.Algorithm.NONE
            goto L_0x01d4
        L_0x0023:
            java.lang.String r3 = "enc"
            boolean r3 = r0.containsKey(r3)
            if (r3 == 0) goto L_0x0120
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.RSA1_5
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0039
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.RSA1_5
            goto L_0x01d4
        L_0x0039:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.RSA_OAEP
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0047
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.RSA_OAEP
            goto L_0x01d4
        L_0x0047:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.RSA_OAEP_256
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0055
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.RSA_OAEP_256
            goto L_0x01d4
        L_0x0055:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.A128KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0063
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.A128KW
            goto L_0x01d4
        L_0x0063:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.A192KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0071
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.A192KW
            goto L_0x01d4
        L_0x0071:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.A256KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x007f
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.A256KW
            goto L_0x01d4
        L_0x007f:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.DIR
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x008d
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.DIR
            goto L_0x01d4
        L_0x008d:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.ECDH_ES
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x009b
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.ECDH_ES
            goto L_0x01d4
        L_0x009b:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.ECDH_ES_A128KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00a9
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.ECDH_ES_A128KW
            goto L_0x01d4
        L_0x00a9:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.ECDH_ES_A192KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00b7
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.ECDH_ES_A192KW
            goto L_0x01d4
        L_0x00b7:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.ECDH_ES_A256KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00c5
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.ECDH_ES_A256KW
            goto L_0x01d4
        L_0x00c5:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.A128GCMKW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00d3
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.A128GCMKW
            goto L_0x01d4
        L_0x00d3:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.A192GCMKW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00e1
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.A192GCMKW
            goto L_0x01d4
        L_0x00e1:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.A256GCMKW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00ef
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.A256GCMKW
            goto L_0x01d4
        L_0x00ef:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.PBES2_HS256_A128KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00fd
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.PBES2_HS256_A128KW
            goto L_0x01d4
        L_0x00fd:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.PBES2_HS384_A192KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x010b
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.PBES2_HS384_A192KW
            goto L_0x01d4
        L_0x010b:
            com.nimbusds.jose.JWEAlgorithm r3 = com.nimbusds.jose.JWEAlgorithm.PBES2_HS512_A256KW
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0119
            com.nimbusds.jose.JWEAlgorithm r2 = com.nimbusds.jose.JWEAlgorithm.PBES2_HS512_A256KW
            goto L_0x01d4
        L_0x0119:
            com.nimbusds.jose.JWEAlgorithm r3 = new com.nimbusds.jose.JWEAlgorithm
            r3.<init>(r2)
            goto L_0x01d3
        L_0x0120:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.HS256
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x012e
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.HS256
            goto L_0x01d4
        L_0x012e:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.HS384
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x013c
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.HS384
            goto L_0x01d4
        L_0x013c:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.HS512
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x014a
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.HS512
            goto L_0x01d4
        L_0x014a:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.RS256
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0158
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.RS256
            goto L_0x01d4
        L_0x0158:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.RS384
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0166
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.RS384
            goto L_0x01d4
        L_0x0166:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.RS512
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0173
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.RS512
            goto L_0x01d4
        L_0x0173:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.ES256
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0180
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.ES256
            goto L_0x01d4
        L_0x0180:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.ES384
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x018d
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.ES384
            goto L_0x01d4
        L_0x018d:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.ES512
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x019a
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.ES512
            goto L_0x01d4
        L_0x019a:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.PS256
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x01a7
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.PS256
            goto L_0x01d4
        L_0x01a7:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.PS384
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x01b4
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.PS384
            goto L_0x01d4
        L_0x01b4:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.PS512
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x01c1
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.PS512
            goto L_0x01d4
        L_0x01c1:
            com.nimbusds.jose.JWSAlgorithm r3 = com.nimbusds.jose.JWSAlgorithm.EdDSA
            java.lang.String r3 = r3.name
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x01ce
            com.nimbusds.jose.JWSAlgorithm r2 = com.nimbusds.jose.JWSAlgorithm.EdDSA
            goto L_0x01d4
        L_0x01ce:
            com.nimbusds.jose.JWSAlgorithm r3 = new com.nimbusds.jose.JWSAlgorithm
            r3.<init>(r2)
        L_0x01d3:
            r2 = r3
        L_0x01d4:
            boolean r3 = r2 instanceof com.nimbusds.jose.JWSAlgorithm
            if (r3 == 0) goto L_0x051c
            r5 = r2
            com.nimbusds.jose.JWSAlgorithm r5 = (com.nimbusds.jose.JWSAlgorithm) r5
            java.lang.String r2 = r5.name
            com.nimbusds.jose.Algorithm r3 = com.nimbusds.jose.Algorithm.NONE
            java.lang.String r3 = r3.name
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0514
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = r13
            r16 = r14
            r13 = r11
            r14 = r12
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r4
            r8 = r6
            r6 = r3
        L_0x0207:
            boolean r3 = r2.hasNext()
            if (r3 != 0) goto L_0x0216
            com.nimbusds.jose.JWSHeader r0 = new com.nimbusds.jose.JWSHeader
            r4 = r0
            r17 = r43
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r0
        L_0x0216:
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = r1.equals(r3)
            if (r4 != 0) goto L_0x050c
            java.lang.String r4 = "typ"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0234
            com.nimbusds.jose.JOSEObjectType r6 = new com.nimbusds.jose.JOSEObjectType
            java.lang.String r3 = com.google.android.material.resources.TextAppearanceConfig.getString(r0, r3)
            r6.<init>(r3)
            goto L_0x0207
        L_0x0234:
            java.lang.String r4 = "cty"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0241
            java.lang.String r7 = com.google.android.material.resources.TextAppearanceConfig.getString(r0, r3)
            goto L_0x0207
        L_0x0241:
            java.lang.String r4 = "crit"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0253
            java.util.HashSet r8 = new java.util.HashSet
            java.util.List r3 = com.google.android.material.resources.TextAppearanceConfig.getStringList(r0, r3)
            r8.<init>(r3)
            goto L_0x0207
        L_0x0253:
            java.lang.String r4 = "jku"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0260
            java.net.URI r9 = com.google.android.material.resources.TextAppearanceConfig.getURI(r0, r3)
            goto L_0x0207
        L_0x0260:
            java.lang.String r4 = "jwk"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x047b
            java.lang.Class<net.minidev.json.JSONObject> r4 = net.minidev.json.JSONObject.class
            java.lang.Object r3 = com.google.android.material.resources.TextAppearanceConfig.getGeneric(r0, r3, r4)
            net.minidev.json.JSONObject r3 = (net.minidev.json.JSONObject) r3
            java.lang.String r4 = "kty"
            java.lang.String r10 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r4)
            com.nimbusds.jose.jwk.KeyType r10 = com.nimbusds.jose.jwk.KeyType.parse(r10)
            r17 = r1
            com.nimbusds.jose.jwk.KeyType r1 = com.nimbusds.jose.jwk.KeyType.EC
            if (r10 != r1) goto L_0x0290
            com.nimbusds.jose.jwk.ECKey r10 = com.nimbusds.jose.jwk.ECKey.parse(r3)
            r38 = r2
            r39 = r5
            r40 = r6
            r41 = r7
            r42 = r8
            goto L_0x04f0
        L_0x0290:
            com.nimbusds.jose.jwk.KeyType r1 = com.nimbusds.jose.jwk.KeyType.RSA
            if (r10 != r1) goto L_0x0405
            com.nimbusds.jose.util.Base64URL r1 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r10 = "n"
            java.lang.String r10 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r10)
            r1.<init>(r10)
            com.nimbusds.jose.util.Base64URL r10 = new com.nimbusds.jose.util.Base64URL
            r38 = r2
            java.lang.String r2 = "e"
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r2)
            r10.<init>(r2)
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r4)
            com.nimbusds.jose.jwk.KeyType r2 = com.nimbusds.jose.jwk.KeyType.parse(r2)
            com.nimbusds.jose.jwk.KeyType r4 = com.nimbusds.jose.jwk.KeyType.RSA
            if (r2 != r4) goto L_0x03fc
            java.lang.String r2 = "d"
            boolean r4 = r3.containsKey(r2)
            if (r4 == 0) goto L_0x02cc
            com.nimbusds.jose.util.Base64URL r4 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r2)
            r4.<init>(r2)
            r21 = r4
            goto L_0x02cf
        L_0x02cc:
            r2 = 0
            r21 = r2
        L_0x02cf:
            java.lang.String r2 = "p"
            boolean r4 = r3.containsKey(r2)
            if (r4 == 0) goto L_0x02e3
            com.nimbusds.jose.util.Base64URL r4 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r2)
            r4.<init>(r2)
            r22 = r4
            goto L_0x02e6
        L_0x02e3:
            r2 = 0
            r22 = r2
        L_0x02e6:
            java.lang.String r2 = "q"
            boolean r4 = r3.containsKey(r2)
            if (r4 == 0) goto L_0x02fa
            com.nimbusds.jose.util.Base64URL r4 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r2)
            r4.<init>(r2)
            r23 = r4
            goto L_0x02fd
        L_0x02fa:
            r2 = 0
            r23 = r2
        L_0x02fd:
            java.lang.String r2 = "dp"
            boolean r4 = r3.containsKey(r2)
            if (r4 == 0) goto L_0x0311
            com.nimbusds.jose.util.Base64URL r4 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r2)
            r4.<init>(r2)
            r24 = r4
            goto L_0x0314
        L_0x0311:
            r2 = 0
            r24 = r2
        L_0x0314:
            java.lang.String r2 = "dq"
            boolean r4 = r3.containsKey(r2)
            if (r4 == 0) goto L_0x0328
            com.nimbusds.jose.util.Base64URL r4 = new com.nimbusds.jose.util.Base64URL
            r39 = r5
            java.lang.String r5 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r2)
            r4.<init>(r5)
            goto L_0x032b
        L_0x0328:
            r39 = r5
            r4 = 0
        L_0x032b:
            r25 = r4
            java.lang.String r4 = "qi"
            boolean r5 = r3.containsKey(r4)
            if (r5 == 0) goto L_0x0341
            com.nimbusds.jose.util.Base64URL r5 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r4 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r4)
            r5.<init>(r4)
            r26 = r5
            goto L_0x0344
        L_0x0341:
            r4 = 0
            r26 = r4
        L_0x0344:
            java.lang.String r4 = "oth"
            boolean r5 = r3.containsKey(r4)
            if (r5 == 0) goto L_0x03b5
            net.minidev.json.JSONArray r4 = com.google.android.material.resources.TextAppearanceConfig.getJSONArray(r3, r4)
            java.util.ArrayList r5 = new java.util.ArrayList
            r40 = r6
            int r6 = r4.size()
            r5.<init>(r6)
            java.util.Iterator r4 = r4.iterator()
        L_0x035f:
            boolean r6 = r4.hasNext()
            if (r6 != 0) goto L_0x036c
            r27 = r5
            r41 = r7
            r42 = r8
            goto L_0x03be
        L_0x036c:
            java.lang.Object r6 = r4.next()
            r18 = r4
            boolean r4 = r6 instanceof net.minidev.json.JSONObject
            if (r4 == 0) goto L_0x03a6
            net.minidev.json.JSONObject r6 = (net.minidev.json.JSONObject) r6
            com.nimbusds.jose.util.Base64URL r4 = new com.nimbusds.jose.util.Base64URL
            r41 = r7
            java.lang.String r7 = "r"
            java.lang.String r7 = com.google.android.material.resources.TextAppearanceConfig.getString(r6, r7)
            r4.<init>(r7)
            com.nimbusds.jose.util.Base64URL r7 = new com.nimbusds.jose.util.Base64URL
            r42 = r8
            java.lang.String r8 = com.google.android.material.resources.TextAppearanceConfig.getString(r6, r2)
            r7.<init>(r8)
            com.nimbusds.jose.util.Base64URL r8 = new com.nimbusds.jose.util.Base64URL
            r19 = r2
            java.lang.String r2 = "t"
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r6, r2)
            r8.<init>(r2)
            com.nimbusds.jose.jwk.RSAKey$OtherPrimesInfo r2 = new com.nimbusds.jose.jwk.RSAKey$OtherPrimesInfo
            r2.<init>(r4, r7, r8)
            r5.add(r2)
            goto L_0x03ac
        L_0x03a6:
            r19 = r2
            r41 = r7
            r42 = r8
        L_0x03ac:
            r4 = r18
            r2 = r19
            r7 = r41
            r8 = r42
            goto L_0x035f
        L_0x03b5:
            r40 = r6
            r41 = r7
            r42 = r8
            r2 = 0
            r27 = r2
        L_0x03be:
            com.nimbusds.jose.jwk.RSAKey r2 = new com.nimbusds.jose.jwk.RSAKey     // Catch:{ IllegalArgumentException -> 0x03f0 }
            r28 = 0
            com.nimbusds.jose.jwk.KeyUse r29 = com.google.android.material.resources.TextAppearanceConfig.parseKeyUse(r3)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            java.util.Set r30 = com.google.android.material.resources.TextAppearanceConfig.parseKeyOperations(r3)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            com.nimbusds.jose.Algorithm r31 = com.google.android.material.resources.TextAppearanceConfig.parseAlgorithm(r3)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            java.lang.String r32 = com.google.android.material.resources.TextAppearanceConfig.parseKeyID(r3)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            java.net.URI r33 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertURL(r3)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            com.nimbusds.jose.util.Base64URL r34 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertThumbprint(r3)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            com.nimbusds.jose.util.Base64URL r35 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertSHA256Thumbprint(r3)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            java.util.List r36 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertChain(r3)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            r37 = 0
            r18 = r2
            r19 = r1
            r20 = r10
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)     // Catch:{ IllegalArgumentException -> 0x03f0 }
            r10 = r2
            goto L_0x04f0
        L_0x03f0:
            r0 = move-exception
            java.text.ParseException r1 = new java.text.ParseException
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            r1.<init>(r0, r2)
            throw r1
        L_0x03fc:
            r0 = 0
            java.text.ParseException r1 = new java.text.ParseException
            java.lang.String r2 = "The key type \"kty\" must be RSA"
            r1.<init>(r2, r0)
            throw r1
        L_0x0405:
            r38 = r2
            r39 = r5
            r40 = r6
            r41 = r7
            r42 = r8
            com.nimbusds.jose.jwk.KeyType r1 = com.nimbusds.jose.jwk.KeyType.OCT
            if (r10 != r1) goto L_0x045c
            com.nimbusds.jose.util.Base64URL r1 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r2 = "k"
            java.lang.String r2 = com.google.android.material.resources.TextAppearanceConfig.getString(r3, r2)
            r1.<init>(r2)
            com.nimbusds.jose.jwk.KeyType r2 = com.google.android.material.resources.TextAppearanceConfig.parseKeyType(r3)
            com.nimbusds.jose.jwk.KeyType r4 = com.nimbusds.jose.jwk.KeyType.OCT
            if (r2 != r4) goto L_0x0453
            com.nimbusds.jose.jwk.OctetSequenceKey r10 = new com.nimbusds.jose.jwk.OctetSequenceKey
            com.nimbusds.jose.jwk.KeyUse r20 = com.google.android.material.resources.TextAppearanceConfig.parseKeyUse(r3)
            java.util.Set r21 = com.google.android.material.resources.TextAppearanceConfig.parseKeyOperations(r3)
            com.nimbusds.jose.Algorithm r22 = com.google.android.material.resources.TextAppearanceConfig.parseAlgorithm(r3)
            java.lang.String r23 = com.google.android.material.resources.TextAppearanceConfig.parseKeyID(r3)
            java.net.URI r24 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertURL(r3)
            com.nimbusds.jose.util.Base64URL r25 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertThumbprint(r3)
            com.nimbusds.jose.util.Base64URL r26 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertSHA256Thumbprint(r3)
            java.util.List r27 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertChain(r3)
            r28 = 0
            r18 = r10
            r19 = r1
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            goto L_0x04f0
        L_0x0453:
            java.text.ParseException r0 = new java.text.ParseException
            java.lang.String r1 = "The key type \"kty\" must be oct"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x045c:
            com.nimbusds.jose.jwk.KeyType r1 = com.nimbusds.jose.jwk.KeyType.OKP
            if (r10 != r1) goto L_0x0466
            com.nimbusds.jose.jwk.OctetKeyPair r10 = com.nimbusds.jose.jwk.OctetKeyPair.parse(r3)
            goto L_0x04f0
        L_0x0466:
            java.text.ParseException r0 = new java.text.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported key type \"kty\" parameter: "
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x047b:
            r17 = r1
            r38 = r2
            r39 = r5
            r40 = r6
            r41 = r7
            r42 = r8
            java.lang.String r1 = "x5u"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0494
            java.net.URI r11 = com.google.android.material.resources.TextAppearanceConfig.getURI(r0, r3)
            goto L_0x04f0
        L_0x0494:
            java.lang.String r1 = "x5t"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x04a6
            com.nimbusds.jose.util.Base64URL r12 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r1 = com.google.android.material.resources.TextAppearanceConfig.getString(r0, r3)
            r12.<init>(r1)
            goto L_0x04f0
        L_0x04a6:
            java.lang.String r1 = "x5t#S256"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x04b8
            com.nimbusds.jose.util.Base64URL r13 = new com.nimbusds.jose.util.Base64URL
            java.lang.String r1 = com.google.android.material.resources.TextAppearanceConfig.getString(r0, r3)
            r13.<init>(r1)
            goto L_0x04f0
        L_0x04b8:
            java.lang.String r1 = "x5c"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x04c9
            net.minidev.json.JSONArray r1 = com.google.android.material.resources.TextAppearanceConfig.getJSONArray(r0, r3)
            java.util.List r14 = com.google.android.material.resources.TextAppearanceConfig.parseX509CertChain(r1)
            goto L_0x04f0
        L_0x04c9:
            java.lang.String r1 = "kid"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x04d6
            java.lang.String r15 = com.google.android.material.resources.TextAppearanceConfig.getString(r0, r3)
            goto L_0x04f0
        L_0x04d6:
            java.lang.Object r1 = r0.get(r3)
            java.util.Set<java.lang.String> r2 = REGISTERED_PARAMETER_NAMES
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L_0x04fe
            if (r16 != 0) goto L_0x04e9
            java.util.HashMap r16 = new java.util.HashMap
            r16.<init>()
        L_0x04e9:
            r2 = r16
            r2.put(r3, r1)
            r16 = r2
        L_0x04f0:
            r1 = r17
            r2 = r38
            r5 = r39
            r6 = r40
            r7 = r41
            r8 = r42
            goto L_0x0207
        L_0x04fe:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The parameter name \""
            java.lang.String r2 = "\" matches a registered name"
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline51(r1, r3, r2)
            r0.<init>(r1)
            throw r0
        L_0x050c:
            r40 = r6
            r41 = r7
            r42 = r8
            goto L_0x0207
        L_0x0514:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The JWS algorithm \"alg\" cannot be \"none\""
            r0.<init>(r1)
            throw r0
        L_0x051c:
            java.text.ParseException r0 = new java.text.ParseException
            java.lang.String r1 = "The algorithm \"alg\" header parameter must be for signatures"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.JWSHeader.parse(com.nimbusds.jose.util.Base64URL):com.nimbusds.jose.JWSHeader");
    }
}
