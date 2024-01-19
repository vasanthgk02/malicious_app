package com.google.android.gms.common.moduleinstall;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class ModuleInstallIntentResponse extends AbstractSafeParcelable {
    public static final Creator<ModuleInstallIntentResponse> CREATOR = new zab();
    @Field
    public final PendingIntent zaa;

    @Constructor
    @KeepForSdk
    public ModuleInstallIntentResponse(@Param(id = 1) PendingIntent pendingIntent) {
        this.zaa = pendingIntent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zaa, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
