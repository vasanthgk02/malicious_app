package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzbl();
    @Field
    public final List<LocationRequest> zza;
    @Field
    public final boolean zzb;
    @Field
    public final boolean zzc;
    @Field
    public zzbj zzd;

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    public static final class Builder {
        public final ArrayList<LocationRequest> zza = new ArrayList<>();
        public boolean zzb = false;
        public boolean zzc = false;

        public Builder addLocationRequest(LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.zza.add(locationRequest);
            }
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zza, this.zzb, this.zzc, null);
        }
    }

    @Constructor
    public LocationSettingsRequest(@Param(id = 1) List<LocationRequest> list, @Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 5) zzbj zzbj) {
        this.zza = list;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = zzbj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, Collections.unmodifiableList(this.zza), false);
        boolean z = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
