package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class
@Reserved
public class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Creator<SafeBrowsingData> CREATOR = new zzj();
    @Field
    public String zzm;
    @Field
    public DataHolder zzn;
    @Field
    public ParcelFileDescriptor zzo;
    @Field
    public long zzp;
    @Field
    public byte[] zzq;

    static {
        Class<SafeBrowsingData> cls = SafeBrowsingData.class;
    }

    public SafeBrowsingData() {
        this.zzm = null;
        this.zzn = null;
        this.zzo = null;
        this.zzp = 0;
        this.zzq = null;
    }

    @Constructor
    public SafeBrowsingData(@Param(id = 2) String str, @Param(id = 3) DataHolder dataHolder, @Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @Param(id = 5) long j, @Param(id = 6) byte[] bArr) {
        this.zzm = str;
        this.zzn = dataHolder;
        this.zzo = parcelFileDescriptor;
        this.zzp = j;
        this.zzq = bArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelFileDescriptor parcelFileDescriptor = this.zzo;
        zzj.zza(this, parcel, i);
        this.zzo = null;
    }
}
