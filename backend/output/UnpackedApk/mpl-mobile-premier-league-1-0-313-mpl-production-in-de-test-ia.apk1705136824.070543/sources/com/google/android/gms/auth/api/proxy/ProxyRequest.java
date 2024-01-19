package com.google.android.gms.auth.api.proxy;

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
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new zza();
    @Field
    public final byte[] body;
    @Field
    public final int httpMethod;
    @Field
    public final long timeoutMillis;
    @Field
    public final String url;
    @VersionField
    public final int zza;
    @Field
    public Bundle zzb;

    @KeepForSdkWithMembers
    @ShowFirstParty
    /* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
    public static class Builder {
    }

    @Constructor
    public ProxyRequest(@Param(id = 1000) int i, @Param(id = 1) String str, @Param(id = 2) int i2, @Param(id = 3) long j, @Param(id = 4) byte[] bArr, @Param(id = 5) Bundle bundle) {
        this.zza = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzb = bundle;
    }

    public String toString() {
        String str = this.url;
        int i = this.httpMethod;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i);
        sb.append(" ]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        int i2 = this.httpMethod;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        long j = this.timeoutMillis;
        parcel.writeInt(524291);
        parcel.writeLong(j);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zzb, false);
        int i3 = this.zza;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
