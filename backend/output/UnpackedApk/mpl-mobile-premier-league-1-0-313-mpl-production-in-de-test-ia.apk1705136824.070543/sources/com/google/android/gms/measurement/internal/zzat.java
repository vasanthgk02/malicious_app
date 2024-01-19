package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Iterator;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzat extends AbstractSafeParcelable implements Iterable<String> {
    public static final Creator<zzat> CREATOR = new zzau();
    @Field
    public final Bundle zza;

    @Constructor
    public zzat(@Param(id = 2) Bundle bundle) {
        this.zza = bundle;
    }

    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzc(), false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final Bundle zzc() {
        return new Bundle(this.zza);
    }

    public final Double zzd() {
        return Double.valueOf(this.zza.getDouble(HSLCriteriaBuilder.VALUE));
    }

    public final Long zze() {
        return Long.valueOf(this.zza.getLong(HSLCriteriaBuilder.VALUE));
    }

    public final Object zzf(String str) {
        return this.zza.get(str);
    }

    public final String zzg(String str) {
        return this.zza.getString(str);
    }
}
