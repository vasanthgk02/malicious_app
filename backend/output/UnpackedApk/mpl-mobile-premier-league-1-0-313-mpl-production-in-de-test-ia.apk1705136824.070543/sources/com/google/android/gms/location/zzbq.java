package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.location.zzbs;
import java.util.List;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbq extends AbstractSafeParcelable {
    public static final Creator<zzbq> CREATOR = new zzbr();
    @Field
    public final List<String> zza;
    @Field
    public final PendingIntent zzb;
    @Field
    public final String zzc;

    @Constructor
    public zzbq(@Param(id = 1) List<String> list, @Param(id = 2) PendingIntent pendingIntent, @Param(id = 3) String str) {
        zzbs<String> zzbs;
        if (list == null) {
            zzbs = zzbs.zzi();
        } else {
            zzbs = zzbs.zzj(list);
        }
        this.zza = zzbs;
        this.zzb = pendingIntent;
        this.zzc = str;
    }

    public static zzbq zza(List<String> list) {
        Preconditions.checkNotNull(list, "geofence can't be null.");
        Preconditions.checkArgument(!list.isEmpty(), "Geofences must contains at least one id.");
        return new zzbq(list, null, "");
    }

    public static zzbq zzb(PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent, "PendingIntent can not be null.");
        return new zzbq(null, pendingIntent, "");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
