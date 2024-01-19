package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Creator<ApiFeatureRequest> CREATOR = new zac();
    @Field
    public final List zab;
    @Field
    public final boolean zac;
    @Field
    public final String zad;
    @Field
    public final String zae;

    static {
        zab zab2 = zab.zaa;
    }

    @Constructor
    public ApiFeatureRequest(@Param(id = 1) List list, @Param(id = 2) boolean z, @Param(id = 3) String str, @Param(id = 4) String str2) {
        Preconditions.checkNotNull(list);
        this.zab = list;
        this.zac = z;
        this.zad = str;
        this.zae = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        if (this.zac != apiFeatureRequest.zac || !Objects.equal(this.zab, apiFeatureRequest.zab) || !Objects.equal(this.zad, apiFeatureRequest.zad) || !Objects.equal(this.zae, apiFeatureRequest.zae)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zac), this.zab, this.zad, this.zae});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zab, false);
        boolean z = this.zac;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 3, this.zad, false);
        SafeParcelWriter.writeString(parcel, 4, this.zae, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
