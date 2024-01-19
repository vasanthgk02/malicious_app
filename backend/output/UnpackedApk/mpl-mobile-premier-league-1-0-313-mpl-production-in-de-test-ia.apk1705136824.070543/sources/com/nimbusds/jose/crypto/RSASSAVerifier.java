package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.util.Base64URL;
import in.juspay.hypersdk.security.SecurityHelper;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class RSASSAVerifier extends BaseJWSProvider implements JWSVerifier {
    public static final Set<JWSAlgorithm> SUPPORTED_ALGORITHMS;
    public final CriticalHeaderParamsDeferral critPolicy;
    public final RSAPublicKey publicKey;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWSAlgorithm.RS256);
        linkedHashSet.add(JWSAlgorithm.RS384);
        linkedHashSet.add(JWSAlgorithm.RS512);
        linkedHashSet.add(JWSAlgorithm.PS256);
        linkedHashSet.add(JWSAlgorithm.PS384);
        linkedHashSet.add(JWSAlgorithm.PS512);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    public RSASSAVerifier(RSAPublicKey rSAPublicKey) {
        super(SUPPORTED_ALGORITHMS);
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        if (rSAPublicKey != null) {
            this.publicKey = rSAPublicKey;
            criticalHeaderParamsDeferral.deferredParams = Collections.emptySet();
            return;
        }
        throw new IllegalArgumentException("The public RSA key must not be null");
    }

    public boolean verify(JWSHeader jWSHeader, byte[] bArr, Base64URL base64URL) throws JOSEException {
        String str;
        Signature signature;
        PSSParameterSpec pSSParameterSpec;
        String str2;
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = this.critPolicy;
        PSSParameterSpec pSSParameterSpec2 = null;
        if (criticalHeaderParamsDeferral != null) {
            Set<String> set = jWSHeader.crit;
            boolean z = true;
            if (set != null && !set.isEmpty()) {
                Set<String> set2 = criticalHeaderParamsDeferral.deferredParams;
                if (set2 == null || !set2.containsAll(set)) {
                    z = false;
                }
            }
            if (!z) {
                return false;
            }
            JWSAlgorithm jWSAlgorithm = (JWSAlgorithm) jWSHeader.alg;
            Provider provider = this.jcaContext.provider;
            if (jWSAlgorithm.equals(JWSAlgorithm.RS256)) {
                str = SecurityHelper.SHA_256_RSA;
            } else if (jWSAlgorithm.equals(JWSAlgorithm.RS384)) {
                str = "SHA384withRSA";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.RS512)) {
                str = "SHA512withRSA";
            } else {
                if (jWSAlgorithm.equals(JWSAlgorithm.PS256)) {
                    pSSParameterSpec = new PSSParameterSpec("SHA256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
                    str2 = "SHA256withRSAandMGF1";
                } else if (jWSAlgorithm.equals(JWSAlgorithm.PS384)) {
                    pSSParameterSpec = new PSSParameterSpec("SHA384", "MGF1", MGF1ParameterSpec.SHA384, 48, 1);
                    str2 = "SHA384withRSAandMGF1";
                } else if (jWSAlgorithm.equals(JWSAlgorithm.PS512)) {
                    pSSParameterSpec = new PSSParameterSpec("SHA512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1);
                    str2 = "SHA512withRSAandMGF1";
                } else {
                    Set<JWSAlgorithm> set3 = SUPPORTED_ALGORITHMS;
                    StringBuilder sb = new StringBuilder("Unsupported JWS algorithm ");
                    sb.append(jWSAlgorithm);
                    sb.append(", must be ");
                    StringBuilder sb2 = new StringBuilder();
                    Object[] array = set3.toArray();
                    for (int i = 0; i < array.length; i++) {
                        if (i != 0) {
                            if (i < array.length - 1) {
                                sb2.append(", ");
                            } else if (i == array.length - 1) {
                                sb2.append(" or ");
                            }
                        }
                        sb2.append(array[i].toString());
                    }
                    sb.append(sb2.toString());
                    throw new JOSEException(sb.toString());
                }
                String str3 = str2;
                pSSParameterSpec2 = pSSParameterSpec;
                str = str3;
            }
            if (provider != null) {
                try {
                    signature = Signature.getInstance(str, provider);
                } catch (NoSuchAlgorithmException e2) {
                    throw new JOSEException("Unsupported RSASSA algorithm: " + e2.getMessage(), e2);
                }
            } else {
                signature = Signature.getInstance(str);
            }
            if (pSSParameterSpec2 != null) {
                try {
                    signature.setParameter(pSSParameterSpec2);
                } catch (InvalidAlgorithmParameterException e3) {
                    throw new JOSEException("Invalid RSASSA-PSS salt length parameter: " + e3.getMessage(), e3);
                }
            }
            try {
                signature.initVerify(this.publicKey);
                try {
                    signature.update(bArr);
                    return signature.verify(base64URL.decode());
                } catch (SignatureException unused) {
                    return false;
                }
            } catch (InvalidKeyException e4) {
                throw new JOSEException("Invalid public RSA key: " + e4.getMessage(), e4);
            }
        } else {
            throw null;
        }
    }
}
