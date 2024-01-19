package org.spongycastle.openpgp.operator.jcajce;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.asn1.x9.X962NamedCurves;
import org.spongycastle.bcpg.DSAPublicBCPGKey;
import org.spongycastle.bcpg.ECDHPublicBCPGKey;
import org.spongycastle.bcpg.ECDSAPublicBCPGKey;
import org.spongycastle.bcpg.ElGamalPublicBCPGKey;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.bcpg.RSAPublicBCPGKey;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPublicKey;

public class JcaPGPKeyConverter {
    public OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());

    public final ECParameterSpec getECParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws InvalidParameterSpecException, NoSuchProviderException, NoSuchAlgorithmException {
        AlgorithmParameters createAlgorithmParameters = this.helper.helper.createAlgorithmParameters("EC");
        String str = (String) NISTNamedCurves.names.get(aSN1ObjectIdentifier);
        if (str == null) {
            str = (String) SECNamedCurves.names.get(aSN1ObjectIdentifier);
        }
        if (str == null) {
            str = (String) TeleTrusTNamedCurves.names.get(aSN1ObjectIdentifier);
        }
        if (str == null) {
            str = (String) X962NamedCurves.names.get(aSN1ObjectIdentifier);
        }
        if (str == null) {
            str = (String) ECGOST3410NamedCurves.names.get(aSN1ObjectIdentifier);
        }
        createAlgorithmParameters.init(new ECGenParameterSpec(str));
        return (ECParameterSpec) createAlgorithmParameters.getParameterSpec(ECParameterSpec.class);
    }

    public PublicKey getPublicKey(PGPPublicKey pGPPublicKey) throws PGPException {
        PublicKeyPacket publicKeyPacket = pGPPublicKey.publicPk;
        try {
            int i = publicKeyPacket.algorithm;
            if (i == 1 || i == 2 || i == 3) {
                RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) publicKeyPacket.key;
                return this.helper.helper.createKeyFactory("RSA").generatePublic(new RSAPublicKeySpec(rSAPublicBCPGKey.n.value, rSAPublicBCPGKey.f6251e.value));
            }
            switch (i) {
                case 16:
                case 20:
                    ElGamalPublicBCPGKey elGamalPublicBCPGKey = (ElGamalPublicBCPGKey) publicKeyPacket.key;
                    return this.helper.helper.createKeyFactory("ElGamal").generatePublic(new DHPublicKeySpec(elGamalPublicBCPGKey.y.value, elGamalPublicBCPGKey.p.value, elGamalPublicBCPGKey.g.value));
                case 17:
                    DSAPublicBCPGKey dSAPublicBCPGKey = (DSAPublicBCPGKey) publicKeyPacket.key;
                    return this.helper.helper.createKeyFactory("DSA").generatePublic(new DSAPublicKeySpec(dSAPublicBCPGKey.y.value, dSAPublicBCPGKey.p.value, dSAPublicBCPGKey.q.value, dSAPublicBCPGKey.g.value));
                case 18:
                    ECDHPublicBCPGKey eCDHPublicBCPGKey = (ECDHPublicBCPGKey) publicKeyPacket.key;
                    ECPoint decodePoint = TypeUtilsKt.decodePoint(eCDHPublicBCPGKey.point, TypeUtilsKt.getByOID(eCDHPublicBCPGKey.oid).curve);
                    if (decodePoint.isNormalized()) {
                        BigInteger bigInteger = decodePoint.x.toBigInteger();
                        if (decodePoint.isNormalized()) {
                            return this.helper.helper.createKeyFactory("ECDH").generatePublic(new ECPublicKeySpec(new java.security.spec.ECPoint(bigInteger, decodePoint.getYCoord().toBigInteger()), getECParameterSpec(eCDHPublicBCPGKey.oid)));
                        }
                        throw new IllegalStateException("point not in normal form");
                    }
                    throw new IllegalStateException("point not in normal form");
                case 19:
                    ECDSAPublicBCPGKey eCDSAPublicBCPGKey = (ECDSAPublicBCPGKey) publicKeyPacket.key;
                    ECPoint decodePoint2 = TypeUtilsKt.decodePoint(eCDSAPublicBCPGKey.point, TypeUtilsKt.getByOID(eCDSAPublicBCPGKey.oid).curve);
                    if (decodePoint2.isNormalized()) {
                        BigInteger bigInteger2 = decodePoint2.x.toBigInteger();
                        if (decodePoint2.isNormalized()) {
                            return this.helper.helper.createKeyFactory("ECDSA").generatePublic(new ECPublicKeySpec(new java.security.spec.ECPoint(bigInteger2, decodePoint2.getYCoord().toBigInteger()), getECParameterSpec(eCDSAPublicBCPGKey.oid)));
                        }
                        throw new IllegalStateException("point not in normal form");
                    }
                    throw new IllegalStateException("point not in normal form");
                default:
                    throw new PGPException("unknown public key algorithm encountered");
            }
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("exception constructing public key", e3);
        }
    }
}
