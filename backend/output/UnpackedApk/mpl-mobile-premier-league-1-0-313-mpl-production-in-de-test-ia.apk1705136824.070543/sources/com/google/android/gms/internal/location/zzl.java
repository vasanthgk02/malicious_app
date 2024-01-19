package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.location.zzaw;
import com.google.android.gms.location.zzax;

@Class
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzl extends AbstractSafeParcelable {
    public static final Creator<zzl> CREATOR = new zzm();
    @Field
    public final int zza;
    @Field
    public final zzj zzb;
    @Field
    public final zzax zzc;
    @Field
    public final zzai zzd;

    @Constructor
    public zzl(@Param(id = 1) int i, @Param(id = 2) zzj zzj, @Param(id = 3) IBinder iBinder, @Param(id = 4) IBinder iBinder2) {
        zzax zzax;
        this.zza = i;
        this.zzb = zzj;
        zzai zzai = null;
        if (iBinder == null) {
            zzax = null;
        } else {
            zzax = zzaw.zzb(iBinder);
        }
        this.zzc = zzax;
        if (iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface instanceof zzai) {
                zzai = (zzai) queryLocalInterface;
            } else {
                zzai = new zzag(iBinder2);
            }
        }
        this.zzd = zzai;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzax zzax = this.zzc;
        IBinder iBinder2 = null;
        if (zzax == null) {
            iBinder = null;
        } else {
            iBinder = zzax.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        zzai zzai = this.zzd;
        if (zzai != null) {
            iBinder2 = zzai.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder2, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
