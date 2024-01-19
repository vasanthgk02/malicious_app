package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.zzs;
import java.util.Collections;
import java.util.List;

@Class
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzj extends AbstractSafeParcelable {
    public static final Creator<zzj> CREATOR = new zzk();
    @VisibleForTesting
    public static final List<ClientIdentity> zza = Collections.emptyList();
    public static final zzs zzb = new zzs();
    @Field
    public final zzs zzc;
    @Field
    public final List<ClientIdentity> zzd;
    @Field
    public final String zze;

    @Constructor
    public zzj(@Param(id = 1) zzs zzs, @Param(id = 2) List<ClientIdentity> list, @Param(id = 3) String str) {
        this.zzc = zzs;
        this.zzd = list;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        if (!Objects.equal(this.zzc, zzj.zzc) || !Objects.equal(this.zzd, zzj.zzd) || !Objects.equal(this.zze, zzj.zze)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        String str = this.zze;
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline6(valueOf.length(), 77, valueOf2.length(), String.valueOf(str).length()));
        GeneratedOutlineSupport.outline103(sb, "DeviceOrientationRequestInternal{deviceOrientationRequest=", valueOf, ", clients=", valueOf2);
        return GeneratedOutlineSupport.outline63(sb, ", tag='", str, "'}");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzc, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 3, this.zze, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
