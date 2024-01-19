package com.google.android.datatransport.cct.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.cct.internal.ClientInfo.ClientType;

public final class AutoValue_ClientInfo extends ClientInfo {
    public final AndroidClientInfo androidClientInfo;
    public final ClientType clientType;

    public AutoValue_ClientInfo(ClientType clientType2, AndroidClientInfo androidClientInfo2, AnonymousClass1 r3) {
        this.clientType = clientType2;
        this.androidClientInfo = androidClientInfo2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientType clientType2 = this.clientType;
        if (clientType2 != null ? clientType2.equals(((AutoValue_ClientInfo) clientInfo).clientType) : ((AutoValue_ClientInfo) clientInfo).clientType == null) {
            AndroidClientInfo androidClientInfo2 = this.androidClientInfo;
            if (androidClientInfo2 != null) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        ClientType clientType2 = this.clientType;
        int i = 0;
        int hashCode = ((clientType2 == null ? 0 : clientType2.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo2 = this.androidClientInfo;
        if (androidClientInfo2 != null) {
            i = androidClientInfo2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ClientInfo{clientType=");
        outline73.append(this.clientType);
        outline73.append(", androidClientInfo=");
        outline73.append(this.androidClientInfo);
        outline73.append("}");
        return outline73.toString();
    }
}
