package org.spongycastle.bcpg;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.util.io.Streams;

public class UserIDPacket extends ContainedPacket {
    public byte[] idData;

    public UserIDPacket(BCPGInputStream bCPGInputStream) throws IOException {
        this.idData = Streams.readAll(bCPGInputStream);
    }

    public boolean equals(Object obj) {
        if (obj instanceof UserIDPacket) {
            return TypeUtilsKt.areEqual(this.idData, ((UserIDPacket) obj).idData);
        }
        return false;
    }

    public int hashCode() {
        return TypeUtilsKt.hashCode(this.idData);
    }
}
