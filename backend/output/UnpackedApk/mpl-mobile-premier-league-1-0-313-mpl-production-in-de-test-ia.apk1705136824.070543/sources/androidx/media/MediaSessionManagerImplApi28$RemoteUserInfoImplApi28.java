package androidx.media;

import android.media.session.MediaSessionManager.RemoteUserInfo;
import java.util.Objects;

public final class MediaSessionManagerImplApi28$RemoteUserInfoImplApi28 implements MediaSessionManager$RemoteUserInfoImpl {
    public final RemoteUserInfo mObject;

    public MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(String str, int i, int i2) {
        this.mObject = new RemoteUserInfo(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionManagerImplApi28$RemoteUserInfoImplApi28)) {
            return false;
        }
        return this.mObject.equals(((MediaSessionManagerImplApi28$RemoteUserInfoImplApi28) obj).mObject);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mObject});
    }

    public MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(RemoteUserInfo remoteUserInfo) {
        this.mObject = remoteUserInfo;
    }
}
