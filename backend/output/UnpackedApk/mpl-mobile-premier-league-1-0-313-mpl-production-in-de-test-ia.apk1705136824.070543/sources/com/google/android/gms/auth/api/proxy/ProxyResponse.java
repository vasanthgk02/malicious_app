package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdkWithMembers
@ShowFirstParty
@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Creator<ProxyResponse> CREATOR = new zzb();
    @Field
    public final byte[] body;
    @Field
    public final int googlePlayServicesStatusCode;
    @Field
    public final PendingIntent recoveryAction;
    @Field
    public final int statusCode;
    @VersionField
    public final int zza;
    @Field
    public final Bundle zzb;

    @Constructor
    public ProxyResponse(@Param(id = 1000) int i, @Param(id = 1) int i2, @Param(id = 2) PendingIntent pendingIntent, @Param(id = 3) int i3, @Param(id = 4) Bundle bundle, @Param(id = 5) byte[] bArr) {
        this.zza = i;
        this.googlePlayServicesStatusCode = i2;
        this.statusCode = i3;
        this.zzb = bundle;
        this.body = bArr;
        this.recoveryAction = pendingIntent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.googlePlayServicesStatusCode;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.recoveryAction, i, false);
        int i3 = this.statusCode;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.body, false);
        int i4 = this.zza;
        parcel.writeInt(263144);
        parcel.writeInt(i4);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
