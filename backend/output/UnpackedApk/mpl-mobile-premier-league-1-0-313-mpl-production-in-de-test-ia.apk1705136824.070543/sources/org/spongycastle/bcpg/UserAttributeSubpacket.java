package org.spongycastle.bcpg;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class UserAttributeSubpacket {
    public byte[] data;
    public int type;

    public UserAttributeSubpacket(int i, boolean z, byte[] bArr) {
        this.type = i;
        this.data = bArr;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserAttributeSubpacket)) {
            return false;
        }
        UserAttributeSubpacket userAttributeSubpacket = (UserAttributeSubpacket) obj;
        if (this.type != userAttributeSubpacket.type || !TypeUtilsKt.areEqual(this.data, userAttributeSubpacket.data)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.type ^ TypeUtilsKt.hashCode(this.data);
    }
}
