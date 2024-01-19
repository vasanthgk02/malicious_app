package org.spongycastle.openpgp;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.PublicSubkeyPacket;
import org.spongycastle.bcpg.SecretKeyPacket;
import org.spongycastle.bcpg.SecretSubkeyPacket;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;

public class PGPSecretKeyRing extends PGPKeyRing implements Object<PGPSecretKey> {
    public List extraPubKeys = new ArrayList();
    public List keys = new ArrayList();

    public PGPSecretKeyRing(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException, PGPException {
        BCPGInputStream bCPGInputStream;
        if (inputStream instanceof BCPGInputStream) {
            bCPGInputStream = (BCPGInputStream) inputStream;
        } else {
            bCPGInputStream = new BCPGInputStream(inputStream);
        }
        int nextPacketTag = bCPGInputStream.nextPacketTag();
        if (nextPacketTag == 5 || nextPacketTag == 7) {
            SecretKeyPacket secretKeyPacket = (SecretKeyPacket) bCPGInputStream.readPacket();
            while (bCPGInputStream.nextPacketTag() == 61) {
                bCPGInputStream.readPacket();
            }
            TrustPacket readOptionalTrustPacket = PGPKeyRing.readOptionalTrustPacket(bCPGInputStream);
            List readSignaturesAndTrust = PGPKeyRing.readSignaturesAndTrust(bCPGInputStream);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            PGPKeyRing.readUserIDs(bCPGInputStream, arrayList, arrayList2, arrayList3);
            List list = this.keys;
            PGPPublicKey pGPPublicKey = new PGPPublicKey(secretKeyPacket.pubKeyPacket, readOptionalTrustPacket, readSignaturesAndTrust, arrayList, arrayList2, arrayList3, keyFingerPrintCalculator);
            list.add(new PGPSecretKey(secretKeyPacket, pGPPublicKey));
            while (true) {
                if (bCPGInputStream.nextPacketTag() != 7 && bCPGInputStream.nextPacketTag() != 14) {
                    return;
                }
                if (bCPGInputStream.nextPacketTag() == 7) {
                    SecretSubkeyPacket secretSubkeyPacket = (SecretSubkeyPacket) bCPGInputStream.readPacket();
                    while (bCPGInputStream.nextPacketTag() == 61) {
                        bCPGInputStream.readPacket();
                    }
                    this.keys.add(new PGPSecretKey(secretSubkeyPacket, new PGPPublicKey(secretSubkeyPacket.pubKeyPacket, PGPKeyRing.readOptionalTrustPacket(bCPGInputStream), PGPKeyRing.readSignaturesAndTrust(bCPGInputStream), keyFingerPrintCalculator)));
                } else {
                    this.extraPubKeys.add(new PGPPublicKey((PublicSubkeyPacket) bCPGInputStream.readPacket(), PGPKeyRing.readOptionalTrustPacket(bCPGInputStream), PGPKeyRing.readSignaturesAndTrust(bCPGInputStream), keyFingerPrintCalculator));
                }
            }
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("secret key ring doesn't start with secret key tag: tag 0x");
            outline73.append(Integer.toHexString(nextPacketTag));
            throw new IOException(outline73.toString());
        }
    }

    public Iterator<PGPSecretKey> iterator() {
        return Collections.unmodifiableList(this.keys).iterator();
    }
}
