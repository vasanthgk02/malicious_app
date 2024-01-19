package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Class
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zbb();
    @Field
    public final int zba;
    @Field
    public final boolean zbb;
    @Field
    public final boolean zbc;
    @Field
    public final int zbd;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static class Builder {
        public boolean zba = false;
        public boolean zbb = true;
        public int zbc = 1;

        public CredentialPickerConfig build() {
            CredentialPickerConfig credentialPickerConfig = new CredentialPickerConfig(2, this.zba, this.zbb, false, this.zbc);
            return credentialPickerConfig;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public @interface Prompt {
    }

    @Constructor
    public CredentialPickerConfig(@Param(id = 1000) int i, @Param(id = 1) boolean z, @Param(id = 2) boolean z2, @Param(id = 3) boolean z3, @Param(id = 4) int i2) {
        this.zba = i;
        this.zbb = z;
        this.zbc = z2;
        if (i < 2) {
            this.zbd = true == z3 ? 3 : 1;
        } else {
            this.zbd = i2;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        boolean z = this.zbb;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zbc;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        int i2 = this.zbd == 3 ? 1 : 0;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        int i3 = this.zbd;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        int i4 = this.zba;
        parcel.writeInt(263144);
        parcel.writeInt(i4);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
