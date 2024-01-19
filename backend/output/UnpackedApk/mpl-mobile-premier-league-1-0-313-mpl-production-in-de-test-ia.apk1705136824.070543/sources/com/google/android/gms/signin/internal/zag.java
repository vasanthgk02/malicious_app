package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Creator<zag> CREATOR = new zah();
    @Field
    public final List zaa;
    @Field
    public final String zab;

    @Constructor
    public zag(@Param(id = 1) List list, @Param(id = 2) String str) {
        this.zaa = list;
        this.zab = str;
    }

    public final Status getStatus() {
        if (this.zab != null) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 1, this.zaa, false);
        SafeParcelWriter.writeString(parcel, 2, this.zab, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
