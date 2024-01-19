package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new zbc();
    @Field
    public final int zba;
    @Field
    public final boolean zbb;
    @Field
    public final String[] zbc;
    @Field
    public final CredentialPickerConfig zbd;
    @Field
    public final CredentialPickerConfig zbe;
    @Field
    public final boolean zbf;
    @Field
    public final String zbg;
    @Field
    public final String zbh;
    @Field
    public final boolean zbi;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class Builder {
    }

    @Constructor
    public CredentialRequest(@Param(id = 1000) int i, @Param(id = 1) boolean z, @Param(id = 2) String[] strArr, @Param(id = 3) CredentialPickerConfig credentialPickerConfig, @Param(id = 4) CredentialPickerConfig credentialPickerConfig2, @Param(id = 5) boolean z2, @Param(id = 6) String str, @Param(id = 7) String str2, @Param(id = 8) boolean z3) {
        this.zba = i;
        this.zbb = z;
        Preconditions.checkNotNull(strArr);
        this.zbc = strArr;
        this.zbd = credentialPickerConfig == null ? new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.zbe = credentialPickerConfig2 == null ? new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
        if (i < 3) {
            this.zbf = true;
            this.zbg = null;
            this.zbh = null;
        } else {
            this.zbf = z2;
            this.zbg = str;
            this.zbh = str2;
        }
        this.zbi = z3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        boolean z = this.zbb;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zbc, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zbd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zbe, i, false);
        boolean z2 = this.zbf;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 6, this.zbg, false);
        SafeParcelWriter.writeString(parcel, 7, this.zbh, false);
        boolean z3 = this.zbi;
        parcel.writeInt(262152);
        parcel.writeInt(z3 ? 1 : 0);
        int i2 = this.zba;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
