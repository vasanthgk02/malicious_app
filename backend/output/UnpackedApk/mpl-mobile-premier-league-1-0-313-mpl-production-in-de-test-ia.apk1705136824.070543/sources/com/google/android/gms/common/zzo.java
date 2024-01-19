package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;

@Class
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzo extends AbstractSafeParcelable {
    public static final Creator<zzo> CREATOR = new zzp();
    @Field
    public final String zza;
    @Field
    public final boolean zzb;
    @Field
    public final boolean zzc;
    @Field
    public final Context zzd;
    @Field
    public final boolean zze;

    @Constructor
    public zzo(@Param(id = 1) String str, @Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) IBinder iBinder, @Param(id = 5) boolean z3) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = (Context) ObjectWrapper.unwrap(Stub.asInterface(iBinder));
        this.zze = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        boolean z = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.writeIBinder(parcel, 4, new ObjectWrapper(this.zzd), false);
        boolean z3 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
