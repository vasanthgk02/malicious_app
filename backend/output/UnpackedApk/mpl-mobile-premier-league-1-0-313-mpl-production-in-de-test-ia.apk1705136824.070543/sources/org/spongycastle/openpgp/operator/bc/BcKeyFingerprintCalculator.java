package org.spongycastle.openpgp.operator.bc;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.spongycastle.bcpg.BCPGKey;
import org.spongycastle.bcpg.MPInteger;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.bcpg.RSAPublicBCPGKey;
import org.spongycastle.crypto.digests.GeneralDigest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;

public class BcKeyFingerprintCalculator implements KeyFingerPrintCalculator {
    public byte[] calculateFingerprint(PublicKeyPacket publicKeyPacket) throws PGPException {
        GeneralDigest generalDigest;
        BCPGKey bCPGKey = publicKeyPacket.key;
        if (publicKeyPacket.version <= 3) {
            RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) bCPGKey;
            try {
                generalDigest = new MD5Digest();
                byte[] encoded = new MPInteger(rSAPublicBCPGKey.n.value).getEncoded();
                generalDigest.update(encoded, 2, encoded.length - 2);
                byte[] encoded2 = new MPInteger(rSAPublicBCPGKey.f6251e.value).getEncoded();
                generalDigest.update(encoded2, 2, encoded2.length - 2);
            } catch (IOException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("can't encode key components: ");
                outline73.append(e2.getMessage());
                throw new PGPException(outline73.toString(), e2);
            }
        } else {
            try {
                byte[] encodedContents = publicKeyPacket.getEncodedContents();
                GeneralDigest sHA1Digest = new SHA1Digest();
                sHA1Digest.update(-103);
                sHA1Digest.update((byte) (encodedContents.length >> 8));
                sHA1Digest.update((byte) encodedContents.length);
                sHA1Digest.update(encodedContents, 0, encodedContents.length);
                generalDigest = sHA1Digest;
            } catch (IOException e3) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("can't encode key components: ");
                outline732.append(e3.getMessage());
                throw new PGPException(outline732.toString(), e3);
            }
        }
        byte[] bArr = new byte[generalDigest.getDigestSize()];
        generalDigest.doFinal(bArr, 0);
        return bArr;
    }
}
