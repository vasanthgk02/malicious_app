package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@ShowFirstParty
@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zam extends AbstractSafeParcelable {
    public static final Creator<zam> CREATOR = new zak();
    @VersionField
    public final int zaa;
    @Field
    public final String zab;
    @Field
    public final FastJsonResponse.Field zac;

    @Constructor
    public zam(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) FastJsonResponse.Field field) {
        this.zaa = i;
        this.zab = str;
        this.zac = field;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeString(parcel, 2, this.zab, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public zam(String str, FastJsonResponse.Field field) {
        this.zaa = 1;
        this.zab = str;
        this.zac = field;
    }
}
