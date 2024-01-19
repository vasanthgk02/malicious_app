package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Creator<ModuleInstallResponse> CREATOR = new zad();
    @Field
    public final int zaa;
    @Field
    public final boolean zab;

    @Constructor
    public ModuleInstallResponse(@Param(id = 1) int i, @Param(id = 2) boolean z) {
        this.zaa = i;
        this.zab = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        boolean z = this.zab;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
