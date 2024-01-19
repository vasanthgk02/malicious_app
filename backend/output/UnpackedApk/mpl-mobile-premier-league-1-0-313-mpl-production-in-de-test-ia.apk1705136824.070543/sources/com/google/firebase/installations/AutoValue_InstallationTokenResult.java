package com.google.firebase.installations;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class AutoValue_InstallationTokenResult extends InstallationTokenResult {
    public final String token;
    public final long tokenCreationTimestamp;
    public final long tokenExpirationTimestamp;

    public AutoValue_InstallationTokenResult(String str, long j, long j2, AnonymousClass1 r6) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.tokenCreationTimestamp = j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r7.tokenCreationTimestamp == r8.tokenCreationTimestamp) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.installations.InstallationTokenResult
            r2 = 0
            if (r1 == 0) goto L_0x002d
            com.google.firebase.installations.InstallationTokenResult r8 = (com.google.firebase.installations.InstallationTokenResult) r8
            java.lang.String r1 = r7.token
            r3 = r8
            com.google.firebase.installations.AutoValue_InstallationTokenResult r3 = (com.google.firebase.installations.AutoValue_InstallationTokenResult) r3
            java.lang.String r3 = r3.token
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002b
            long r3 = r7.tokenExpirationTimestamp
            com.google.firebase.installations.AutoValue_InstallationTokenResult r8 = (com.google.firebase.installations.AutoValue_InstallationTokenResult) r8
            long r5 = r8.tokenExpirationTimestamp
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x002b
            long r3 = r7.tokenCreationTimestamp
            long r5 = r8.tokenCreationTimestamp
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            return r0
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.AutoValue_InstallationTokenResult.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long j = this.tokenExpirationTimestamp;
        long j2 = this.tokenCreationTimestamp;
        return ((((this.token.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("InstallationTokenResult{token=");
        outline73.append(this.token);
        outline73.append(", tokenExpirationTimestamp=");
        outline73.append(this.tokenExpirationTimestamp);
        outline73.append(", tokenCreationTimestamp=");
        return GeneratedOutlineSupport.outline58(outline73, this.tokenCreationTimestamp, "}");
    }
}
