package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Creator<MethodInvocation> CREATOR = new zan();
    @Field
    public final int zaa;
    @Field
    public final int zab;
    @Field
    public final int zac;
    @Field
    public final long zad;
    @Field
    public final long zae;
    @Field
    public final String zaf;
    @Field
    public final String zag;
    @Field
    public final int zah;
    @Field
    public final int zai;

    @Constructor
    public MethodInvocation(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3, @Param(id = 4) long j, @Param(id = 5) long j2, @Param(id = 6) String str, @Param(id = 7) String str2, @Param(id = 8) int i4, @Param(id = 9) int i5) {
        this.zaa = i;
        this.zab = i2;
        this.zac = i3;
        this.zad = j;
        this.zae = j2;
        this.zaf = str;
        this.zag = str2;
        this.zah = i4;
        this.zai = i5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.zab;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = this.zac;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        long j = this.zad;
        parcel.writeInt(524292);
        parcel.writeLong(j);
        long j2 = this.zae;
        parcel.writeInt(524293);
        parcel.writeLong(j2);
        SafeParcelWriter.writeString(parcel, 6, this.zaf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zag, false);
        int i5 = this.zah;
        parcel.writeInt(262152);
        parcel.writeInt(i5);
        int i6 = this.zai;
        parcel.writeInt(262153);
        parcel.writeInt(i6);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
