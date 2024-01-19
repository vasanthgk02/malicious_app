package org.spongycastle.openpgp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.InputStreamPacket;
import org.spongycastle.bcpg.PublicKeyEncSessionPacket;
import org.spongycastle.bcpg.SymmetricKeyEncSessionPacket;

public class PGPEncryptedDataList implements Iterable {
    public InputStreamPacket data;
    public List list = new ArrayList();

    public PGPEncryptedDataList(BCPGInputStream bCPGInputStream) throws IOException {
        while (true) {
            if (bCPGInputStream.nextPacketTag() != 1 && bCPGInputStream.nextPacketTag() != 3) {
                break;
            }
            this.list.add(bCPGInputStream.readPacket());
        }
        this.data = (InputStreamPacket) bCPGInputStream.readPacket();
        for (int i = 0; i != this.list.size(); i++) {
            if (this.list.get(i) instanceof SymmetricKeyEncSessionPacket) {
                List list2 = this.list;
                list2.set(i, new PGPPBEEncryptedData((SymmetricKeyEncSessionPacket) list2.get(i), this.data));
            } else {
                List list3 = this.list;
                list3.set(i, new PGPPublicKeyEncryptedData((PublicKeyEncSessionPacket) list3.get(i), this.data));
            }
        }
    }

    public Iterator iterator() {
        return this.list.iterator();
    }
}
