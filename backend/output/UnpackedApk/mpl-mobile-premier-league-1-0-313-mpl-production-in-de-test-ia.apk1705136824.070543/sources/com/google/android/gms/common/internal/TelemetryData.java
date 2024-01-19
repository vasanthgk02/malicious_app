package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

@KeepForSdk
@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class TelemetryData extends AbstractSafeParcelable {
    public static final Creator<TelemetryData> CREATOR = new zaab();
    @Field
    public final int zaa;
    @Field
    public List zab;

    @Constructor
    public TelemetryData(@Param(id = 1) int i, @Param(id = 2) List list) {
        this.zaa = i;
        this.zab = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zab, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
