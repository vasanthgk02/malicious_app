package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Class
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class CloudMessage extends AbstractSafeParcelable {
    public static final Creator<CloudMessage> CREATOR = new zza();
    @Field
    public Intent zza;

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
    public @interface MessagePriority {
    }

    @Constructor
    public CloudMessage(@Param(id = 1) Intent intent) {
        this.zza = intent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
