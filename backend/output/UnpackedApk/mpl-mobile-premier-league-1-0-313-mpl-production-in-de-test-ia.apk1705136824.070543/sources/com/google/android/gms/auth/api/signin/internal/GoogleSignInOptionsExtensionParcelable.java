package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();
    @VersionField
    public final int zaa;
    @Field
    public int zab;
    @Field
    public Bundle zac;

    @Constructor
    public GoogleSignInOptionsExtensionParcelable(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) Bundle bundle) {
        this.zaa = i;
        this.zab = i2;
        this.zac = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.zab;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        SafeParcelWriter.writeBundle(parcel, 3, this.zac, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
