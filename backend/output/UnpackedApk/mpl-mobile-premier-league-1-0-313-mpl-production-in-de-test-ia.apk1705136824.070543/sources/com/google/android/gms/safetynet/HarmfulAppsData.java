package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class
@Reserved
public class HarmfulAppsData extends AbstractSafeParcelable {
    public static final Creator<HarmfulAppsData> CREATOR = new zzc();
    @Field
    public final int apkCategory;
    @Field
    public final String apkPackageName;
    @Field
    public final byte[] apkSha256;

    @Constructor
    public HarmfulAppsData(@Param(id = 2) String str, @Param(id = 3) byte[] bArr, @Param(id = 4) int i) {
        this.apkPackageName = str;
        this.apkSha256 = bArr;
        this.apkCategory = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.apkPackageName, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.apkSha256, false);
        int i2 = this.apkCategory;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
