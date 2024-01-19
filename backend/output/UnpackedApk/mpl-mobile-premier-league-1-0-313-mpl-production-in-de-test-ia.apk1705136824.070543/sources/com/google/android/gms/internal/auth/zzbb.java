package com.google.android.gms.internal.auth;

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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbb extends AbstractSafeParcelable {
    public static final Creator<zzbb> CREATOR = new zzbc();
    @VersionField
    public final int zza;
    @Field
    public final String zzb;
    @Field
    public final PendingIntent zzc;

    @Constructor
    public zzbb(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) PendingIntent pendingIntent) {
        this.zza = 1;
        Preconditions.checkNotNull(str);
        this.zzb = str;
        Preconditions.checkNotNull(pendingIntent);
        this.zzc = pendingIntent;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public zzbb(String str, PendingIntent pendingIntent) {
        this(1, str, pendingIntent);
    }
}
