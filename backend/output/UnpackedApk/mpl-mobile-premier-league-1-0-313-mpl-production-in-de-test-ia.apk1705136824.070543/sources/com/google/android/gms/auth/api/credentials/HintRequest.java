package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<HintRequest> CREATOR = new zbe();
    @Field
    public final int zba;
    @Field
    public final CredentialPickerConfig zbb;
    @Field
    public final boolean zbc;
    @Field
    public final boolean zbd;
    @Field
    public final String[] zbe;
    @Field
    public final boolean zbf;
    @Field
    public final String zbg;
    @Field
    public final String zbh;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class Builder {
        public boolean zba;
        public boolean zbb;
        public String[] zbc;
        public CredentialPickerConfig zbd = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        public boolean zbe = false;

        public HintRequest build() {
            if (this.zbc == null) {
                this.zbc = new String[0];
            }
            if (this.zba || this.zbb || this.zbc.length != 0) {
                HintRequest hintRequest = new HintRequest(2, this.zbd, this.zba, this.zbb, this.zbc, this.zbe, null, null);
                return hintRequest;
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }
    }

    @Constructor
    public HintRequest(@Param(id = 1000) int i, @Param(id = 1) CredentialPickerConfig credentialPickerConfig, @Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) String[] strArr, @Param(id = 5) boolean z3, @Param(id = 6) String str, @Param(id = 7) String str2) {
        this.zba = i;
        Preconditions.checkNotNull(credentialPickerConfig);
        this.zbb = credentialPickerConfig;
        this.zbc = z;
        this.zbd = z2;
        Preconditions.checkNotNull(strArr);
        this.zbe = strArr;
        if (this.zba < 2) {
            this.zbf = true;
            this.zbg = null;
            this.zbh = null;
            return;
        }
        this.zbf = z3;
        this.zbg = str;
        this.zbh = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zbb, i, false);
        boolean z = this.zbc;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zbd;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.writeStringArray(parcel, 4, this.zbe, false);
        boolean z3 = this.zbf;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 6, this.zbg, false);
        SafeParcelWriter.writeString(parcel, 7, this.zbh, false);
        int i2 = this.zba;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
