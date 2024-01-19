package androidx.media;

import android.text.TextUtils;
import java.util.Objects;

public class MediaSessionManagerImplBase$RemoteUserInfoImplBase implements MediaSessionManager$RemoteUserInfoImpl {
    public String mPackageName;
    public int mPid;
    public int mUid;

    public MediaSessionManagerImplBase$RemoteUserInfoImplBase(String str, int i, int i2) {
        this.mPackageName = str;
        this.mPid = i;
        this.mUid = i2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionManagerImplBase$RemoteUserInfoImplBase)) {
            return false;
        }
        MediaSessionManagerImplBase$RemoteUserInfoImplBase mediaSessionManagerImplBase$RemoteUserInfoImplBase = (MediaSessionManagerImplBase$RemoteUserInfoImplBase) obj;
        if (!(TextUtils.equals(this.mPackageName, mediaSessionManagerImplBase$RemoteUserInfoImplBase.mPackageName) && this.mPid == mediaSessionManagerImplBase$RemoteUserInfoImplBase.mPid && this.mUid == mediaSessionManagerImplBase$RemoteUserInfoImplBase.mUid)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mPackageName, Integer.valueOf(this.mPid), Integer.valueOf(this.mUid)});
    }
}
