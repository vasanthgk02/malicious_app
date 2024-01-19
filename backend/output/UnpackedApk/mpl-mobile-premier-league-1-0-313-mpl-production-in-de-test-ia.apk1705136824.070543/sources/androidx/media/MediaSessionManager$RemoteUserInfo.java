package androidx.media;

import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.os.Build.VERSION;

public final class MediaSessionManager$RemoteUserInfo {
    public MediaSessionManager$RemoteUserInfoImpl mImpl;

    public MediaSessionManager$RemoteUserInfo(String str, int i, int i2) {
        if (VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(str, i, i2);
        } else {
            this.mImpl = new MediaSessionManagerImplBase$RemoteUserInfoImplBase(str, i, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionManager$RemoteUserInfo)) {
            return false;
        }
        return this.mImpl.equals(((MediaSessionManager$RemoteUserInfo) obj).mImpl);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public MediaSessionManager$RemoteUserInfo(RemoteUserInfo remoteUserInfo) {
        this.mImpl = new MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(remoteUserInfo);
    }
}
