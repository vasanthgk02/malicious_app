package androidx.ads.identifier;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class AutoValue_AdvertisingIdInfo extends AdvertisingIdInfo {
    public final String id;
    public final boolean limitAdTrackingEnabled;
    public final String providerPackageName;

    public AutoValue_AdvertisingIdInfo(String str, String str2, boolean z, AnonymousClass1 r4) {
        this.id = str;
        this.providerPackageName = str2;
        this.limitAdTrackingEnabled = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r4.limitAdTrackingEnabled == r5.limitAdTrackingEnabled) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof androidx.ads.identifier.AdvertisingIdInfo
            r2 = 0
            if (r1 == 0) goto L_0x002d
            androidx.ads.identifier.AdvertisingIdInfo r5 = (androidx.ads.identifier.AdvertisingIdInfo) r5
            java.lang.String r1 = r4.id
            r3 = r5
            androidx.ads.identifier.AutoValue_AdvertisingIdInfo r3 = (androidx.ads.identifier.AutoValue_AdvertisingIdInfo) r3
            java.lang.String r3 = r3.id
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = r4.providerPackageName
            androidx.ads.identifier.AutoValue_AdvertisingIdInfo r5 = (androidx.ads.identifier.AutoValue_AdvertisingIdInfo) r5
            java.lang.String r3 = r5.providerPackageName
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002b
            boolean r1 = r4.limitAdTrackingEnabled
            boolean r5 = r5.limitAdTrackingEnabled
            if (r1 != r5) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            return r0
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.ads.identifier.AutoValue_AdvertisingIdInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return ((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.providerPackageName.hashCode()) * 1000003) ^ (this.limitAdTrackingEnabled ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AdvertisingIdInfo{id=");
        outline73.append(this.id);
        outline73.append(", providerPackageName=");
        outline73.append(this.providerPackageName);
        outline73.append(", limitAdTrackingEnabled=");
        return GeneratedOutlineSupport.outline66(outline73, this.limitAdTrackingEnabled, "}");
    }
}
