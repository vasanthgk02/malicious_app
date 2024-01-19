package org.spongycastle.openpgp;

import org.spongycastle.bcpg.UserAttributeSubpacket;

public class PGPUserAttributeSubpacketVector {
    public UserAttributeSubpacket[] packets;

    public PGPUserAttributeSubpacketVector(UserAttributeSubpacket[] userAttributeSubpacketArr) {
        this.packets = userAttributeSubpacketArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PGPUserAttributeSubpacketVector)) {
            return false;
        }
        PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector = (PGPUserAttributeSubpacketVector) obj;
        if (pGPUserAttributeSubpacketVector.packets.length != this.packets.length) {
            return false;
        }
        int i = 0;
        while (true) {
            UserAttributeSubpacket[] userAttributeSubpacketArr = this.packets;
            if (i == userAttributeSubpacketArr.length) {
                return true;
            }
            if (!pGPUserAttributeSubpacketVector.packets[i].equals(userAttributeSubpacketArr[i])) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            UserAttributeSubpacket[] userAttributeSubpacketArr = this.packets;
            if (i == userAttributeSubpacketArr.length) {
                return i2;
            }
            i2 ^= userAttributeSubpacketArr[i].hashCode();
            i++;
        }
    }
}
