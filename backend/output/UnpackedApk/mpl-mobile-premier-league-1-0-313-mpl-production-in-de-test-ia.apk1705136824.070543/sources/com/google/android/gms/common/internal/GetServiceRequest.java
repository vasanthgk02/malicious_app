package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor.Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new zzm();
    public static final Scope[] zza = new Scope[0];
    public static final Feature[] zzb = new Feature[0];
    @VersionField
    public final int zzc;
    @Field
    public final int zzd;
    @Field
    public int zze;
    @Field
    public String zzf;
    @Field
    public IBinder zzg;
    @Field
    public Scope[] zzh;
    @Field
    public Bundle zzi;
    @Field
    public Account zzj;
    @Field
    public Feature[] zzk;
    @Field
    public Feature[] zzl;
    @Field
    public boolean zzm;
    @Field
    public int zzn;
    @Field
    public boolean zzo;
    @Field
    public String zzp;

    @Constructor
    public GetServiceRequest(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3, @Param(id = 4) String str, @Param(id = 5) IBinder iBinder, @Param(id = 6) Scope[] scopeArr, @Param(id = 7) Bundle bundle, @Param(id = 8) Account account, @Param(id = 10) Feature[] featureArr, @Param(id = 11) Feature[] featureArr2, @Param(id = 12) boolean z, @Param(id = 13) int i4, @Param(id = 14) boolean z2, @Param(id = 15) String str2) {
        scopeArr = scopeArr == null ? zza : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? zzb : featureArr;
        featureArr2 = featureArr2 == null ? zzb : featureArr2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzf = "com.google.android.gms";
        } else {
            this.zzf = str;
        }
        if (i < 2) {
            this.zzj = iBinder != null ? AccountAccessor.getAccountBinderSafe(Stub.asInterface(iBinder)) : null;
        } else {
            this.zzg = iBinder;
            this.zzj = account;
        }
        this.zzh = scopeArr;
        this.zzi = bundle;
        this.zzk = featureArr;
        this.zzl = featureArr2;
        this.zzm = z;
        this.zzn = i4;
        this.zzo = z2;
        this.zzp = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
