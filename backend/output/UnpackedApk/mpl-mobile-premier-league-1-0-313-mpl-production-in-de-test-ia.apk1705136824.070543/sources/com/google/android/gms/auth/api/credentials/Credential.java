package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;
import java.util.List;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Credential> CREATOR = new zba();
    @Field
    public final String zba;
    @Field
    public final String zbb;
    @Field
    public final Uri zbc;
    @Field
    public final List zbd;
    @Field
    public final String zbe;
    @Field
    public final String zbf;
    @Field
    public final String zbg;
    @Field
    public final String zbh;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static class Builder {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a4, code lost:
        r5 = null;
     */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Credential(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) java.lang.String r4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) java.lang.String r5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) android.net.Uri r6, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) java.util.List r7, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) java.lang.String r8, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 6) java.lang.String r9, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 9) java.lang.String r10, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 10) java.lang.String r11) {
        /*
            r3 = this;
            r3.<init>()
            java.lang.String r0 = "credential identifier cannot be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4, r0)
            java.lang.String r4 = r4.trim()
            java.lang.String r0 = "credential identifier cannot be empty"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4, r0)
            if (r8 == 0) goto L_0x0022
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x001a
            goto L_0x0022
        L_0x001a:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Password must not be empty if set"
            r4.<init>(r5)
            throw r4
        L_0x0022:
            if (r9 == 0) goto L_0x0083
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L_0x002d
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0074
        L_0x002d:
            android.net.Uri r0 = android.net.Uri.parse(r9)
            boolean r1 = r0.isAbsolute()
            if (r1 == 0) goto L_0x0072
            boolean r1 = r0.isHierarchical()
            if (r1 == 0) goto L_0x0072
            java.lang.String r1 = r0.getScheme()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0072
            java.lang.String r1 = r0.getAuthority()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0052
            goto L_0x0072
        L_0x0052:
            java.lang.String r1 = r0.getScheme()
            java.lang.String r2 = "http"
            boolean r1 = r2.equalsIgnoreCase(r1)
            r2 = 1
            if (r1 != 0) goto L_0x006d
            java.lang.String r0 = r0.getScheme()
            java.lang.String r1 = "https"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r2 = 0
        L_0x006d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            goto L_0x0074
        L_0x0072:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L_0x0074:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x007b
            goto L_0x0083
        L_0x007b:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Account type must be a valid Http/Https URI"
            r4.<init>(r5)
            throw r4
        L_0x0083:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x0098
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x0090
            goto L_0x0098
        L_0x0090:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Password and AccountType are mutually exclusive"
            r4.<init>(r5)
            throw r4
        L_0x0098:
            if (r5 == 0) goto L_0x00a5
            java.lang.String r0 = r5.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00a5
            r5 = 0
        L_0x00a5:
            r3.zbb = r5
            r3.zbc = r6
            if (r7 != 0) goto L_0x00b0
            java.util.List r5 = java.util.Collections.emptyList()
            goto L_0x00b4
        L_0x00b0:
            java.util.List r5 = java.util.Collections.unmodifiableList(r7)
        L_0x00b4:
            r3.zbd = r5
            r3.zba = r4
            r3.zbe = r8
            r3.zbf = r9
            r3.zbg = r10
            r3.zbh = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.Credential.<init>(java.lang.String, java.lang.String, android.net.Uri, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zba, credential.zba) && TextUtils.equals(this.zbb, credential.zbb) && Objects.equal(this.zbc, credential.zbc) && TextUtils.equals(this.zbe, credential.zbe) && TextUtils.equals(this.zbf, credential.zbf);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbe, this.zbf});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zba, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zbc, i, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zbd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zbe, false);
        SafeParcelWriter.writeString(parcel, 6, this.zbf, false);
        SafeParcelWriter.writeString(parcel, 9, this.zbg, false);
        SafeParcelWriter.writeString(parcel, 10, this.zbh, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
