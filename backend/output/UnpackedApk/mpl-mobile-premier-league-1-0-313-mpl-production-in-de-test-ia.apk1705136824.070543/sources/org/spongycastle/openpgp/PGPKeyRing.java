package org.spongycastle.openpgp;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.Packet;
import org.spongycastle.bcpg.SignaturePacket;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.bcpg.UserAttributePacket;
import org.spongycastle.bcpg.UserIDPacket;

public abstract class PGPKeyRing {
    public static TrustPacket readOptionalTrustPacket(BCPGInputStream bCPGInputStream) throws IOException {
        if (bCPGInputStream.nextPacketTag() == 12) {
            return (TrustPacket) bCPGInputStream.readPacket();
        }
        return null;
    }

    public static List readSignaturesAndTrust(BCPGInputStream bCPGInputStream) throws IOException {
        try {
            ArrayList arrayList = new ArrayList();
            while (bCPGInputStream.nextPacketTag() == 2) {
                arrayList.add(new PGPSignature((SignaturePacket) bCPGInputStream.readPacket(), readOptionalTrustPacket(bCPGInputStream)));
            }
            return arrayList;
        } catch (PGPException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("can't create signature object: ");
            outline73.append(e2.getMessage());
            outline73.append(", cause: ");
            outline73.append(e2.underlying.toString());
            throw new IOException(outline73.toString());
        }
    }

    public static void readUserIDs(BCPGInputStream bCPGInputStream, List list, List list2, List list3) throws IOException {
        while (true) {
            if (bCPGInputStream.nextPacketTag() == 13 || bCPGInputStream.nextPacketTag() == 17) {
                Packet readPacket = bCPGInputStream.readPacket();
                if (readPacket instanceof UserIDPacket) {
                    list.add((UserIDPacket) readPacket);
                } else {
                    list.add(new PGPUserAttributeSubpacketVector(((UserAttributePacket) readPacket).subpackets));
                }
                list2.add(readOptionalTrustPacket(bCPGInputStream));
                list3.add(readSignaturesAndTrust(bCPGInputStream));
            } else {
                return;
            }
        }
    }
}
