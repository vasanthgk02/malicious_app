package com.google.android.datatransport.cct.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo.NetworkType;

public final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {
    public final MobileSubtype mobileSubtype;
    public final NetworkType networkType;

    public AutoValue_NetworkConnectionInfo(NetworkType networkType2, MobileSubtype mobileSubtype2, AnonymousClass1 r3) {
        this.networkType = networkType2;
        this.mobileSubtype = mobileSubtype2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkType networkType2 = this.networkType;
        if (networkType2 != null ? networkType2.equals(((AutoValue_NetworkConnectionInfo) networkConnectionInfo).networkType) : ((AutoValue_NetworkConnectionInfo) networkConnectionInfo).networkType == null) {
            MobileSubtype mobileSubtype2 = this.mobileSubtype;
            if (mobileSubtype2 != null) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        NetworkType networkType2 = this.networkType;
        int i = 0;
        int hashCode = ((networkType2 == null ? 0 : networkType2.hashCode()) ^ 1000003) * 1000003;
        MobileSubtype mobileSubtype2 = this.mobileSubtype;
        if (mobileSubtype2 != null) {
            i = mobileSubtype2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NetworkConnectionInfo{networkType=");
        outline73.append(this.networkType);
        outline73.append(", mobileSubtype=");
        outline73.append(this.mobileSubtype);
        outline73.append("}");
        return outline73.toString();
    }
}
