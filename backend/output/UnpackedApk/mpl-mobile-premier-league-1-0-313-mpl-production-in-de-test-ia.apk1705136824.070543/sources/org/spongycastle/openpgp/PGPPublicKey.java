package org.spongycastle.openpgp;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.bcpg.BCPGKey;
import org.spongycastle.bcpg.DSAPublicBCPGKey;
import org.spongycastle.bcpg.ECPublicBCPGKey;
import org.spongycastle.bcpg.ElGamalPublicBCPGKey;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.bcpg.RSAPublicBCPGKey;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;

public class PGPPublicKey {
    public byte[] fingerprint;
    public long keyID;
    public PublicKeyPacket publicPk;

    public PGPPublicKey(PublicKeyPacket publicKeyPacket, TrustPacket trustPacket, List list, KeyFingerPrintCalculator keyFingerPrintCalculator) throws PGPException {
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.publicPk = publicKeyPacket;
        init(keyFingerPrintCalculator);
    }

    public final void init(KeyFingerPrintCalculator keyFingerPrintCalculator) throws PGPException {
        PublicKeyPacket publicKeyPacket = this.publicPk;
        BCPGKey bCPGKey = publicKeyPacket.key;
        byte[] calculateFingerprint = keyFingerPrintCalculator.calculateFingerprint(publicKeyPacket);
        this.fingerprint = calculateFingerprint;
        if (this.publicPk.version <= 3) {
            RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) bCPGKey;
            this.keyID = rSAPublicBCPGKey.n.value.longValue();
            rSAPublicBCPGKey.n.value.bitLength();
            return;
        }
        this.keyID = (((long) (calculateFingerprint[calculateFingerprint.length - 2] & 255)) << 8) | (((long) (calculateFingerprint[calculateFingerprint.length - 8] & 255)) << 56) | (((long) (calculateFingerprint[calculateFingerprint.length - 7] & 255)) << 48) | (((long) (calculateFingerprint[calculateFingerprint.length - 6] & 255)) << 40) | (((long) (calculateFingerprint[calculateFingerprint.length - 5] & 255)) << 32) | (((long) (calculateFingerprint[calculateFingerprint.length - 4] & 255)) << 24) | (((long) (calculateFingerprint[calculateFingerprint.length - 3] & 255)) << 16) | ((long) (calculateFingerprint[calculateFingerprint.length - 1] & 255));
        if (bCPGKey instanceof RSAPublicBCPGKey) {
            ((RSAPublicBCPGKey) bCPGKey).n.value.bitLength();
        } else if (bCPGKey instanceof DSAPublicBCPGKey) {
            ((DSAPublicBCPGKey) bCPGKey).p.value.bitLength();
        } else if (bCPGKey instanceof ElGamalPublicBCPGKey) {
            ((ElGamalPublicBCPGKey) bCPGKey).p.value.bitLength();
        } else if (bCPGKey instanceof ECPublicBCPGKey) {
            TypeUtilsKt.getByOID(((ECPublicBCPGKey) bCPGKey).oid).curve.getFieldSize();
        }
    }

    public PGPPublicKey(PublicKeyPacket publicKeyPacket, TrustPacket trustPacket, List list, List list2, List list3, List list4, KeyFingerPrintCalculator keyFingerPrintCalculator) throws PGPException {
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.publicPk = publicKeyPacket;
        init(keyFingerPrintCalculator);
    }
}
