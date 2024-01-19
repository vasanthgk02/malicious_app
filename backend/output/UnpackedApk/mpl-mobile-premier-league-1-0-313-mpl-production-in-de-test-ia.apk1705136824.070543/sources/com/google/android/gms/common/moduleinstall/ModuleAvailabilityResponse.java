package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {
    public static final Creator<ModuleAvailabilityResponse> CREATOR = new zaa();
    @Field
    public final boolean zaa;
    @Field
    public final int zab;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public @interface AvailabilityStatus {
    }

    @Constructor
    @KeepForSdk
    public ModuleAvailabilityResponse(@Param(id = 1) boolean z, @Param(id = 2) int i) {
        this.zaa = z;
        this.zab = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        boolean z = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        int i2 = this.zab;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
