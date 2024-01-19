package org.spongycastle.openpgp;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;

public class PGPPublicKeyRing extends PGPKeyRing implements Object<PGPPublicKey> {
    public List keys = new ArrayList();

    public PGPPublicKeyRing(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException {
        BCPGInputStream bCPGInputStream;
        if (inputStream instanceof BCPGInputStream) {
            bCPGInputStream = (BCPGInputStream) inputStream;
        } else {
            bCPGInputStream = new BCPGInputStream(inputStream);
        }
        int nextPacketTag = bCPGInputStream.nextPacketTag();
        if (nextPacketTag == 6 || nextPacketTag == 14) {
            PublicKeyPacket publicKeyPacket = (PublicKeyPacket) bCPGInputStream.readPacket();
            TrustPacket readOptionalTrustPacket = PGPKeyRing.readOptionalTrustPacket(bCPGInputStream);
            List readSignaturesAndTrust = PGPKeyRing.readSignaturesAndTrust(bCPGInputStream);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            PGPKeyRing.readUserIDs(bCPGInputStream, arrayList, arrayList2, arrayList3);
            try {
                List list = this.keys;
                PGPPublicKey pGPPublicKey = new PGPPublicKey(publicKeyPacket, readOptionalTrustPacket, readSignaturesAndTrust, arrayList, arrayList2, arrayList3, keyFingerPrintCalculator);
                list.add(pGPPublicKey);
                while (bCPGInputStream.nextPacketTag() == 14) {
                    this.keys.add(new PGPPublicKey((PublicKeyPacket) bCPGInputStream.readPacket(), PGPKeyRing.readOptionalTrustPacket(bCPGInputStream), PGPKeyRing.readSignaturesAndTrust(bCPGInputStream), keyFingerPrintCalculator));
                }
            } catch (PGPException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("processing exception: ");
                outline73.append(e2.toString());
                throw new IOException(outline73.toString());
            }
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("public key ring doesn't start with public key tag: tag 0x");
            outline732.append(Integer.toHexString(nextPacketTag));
            throw new IOException(outline732.toString());
        }
    }

    public Iterator<PGPPublicKey> iterator() {
        return Collections.unmodifiableList(this.keys).iterator();
    }
}
