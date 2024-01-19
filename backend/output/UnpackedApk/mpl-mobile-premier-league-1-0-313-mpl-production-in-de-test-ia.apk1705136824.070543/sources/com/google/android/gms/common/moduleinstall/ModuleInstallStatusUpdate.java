package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Creator<ModuleInstallStatusUpdate> CREATOR = new zae();
    @Field
    public final int zaa;
    @Field
    @InstallState
    public final int zab;
    @Field
    public final Long zac;
    @Field
    public final Long zad;
    @Field
    public final int zae;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public @interface InstallState {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static class ProgressInfo {
        public ProgressInfo(long j, long j2) {
            if (j2 == 0) {
                throw new IllegalArgumentException("Given Long is zero");
            }
        }
    }

    @Constructor
    @KeepForSdk
    public ModuleInstallStatusUpdate(@Param(id = 1) int i, @Param(id = 2) @InstallState int i2, @Param(id = 3) Long l, @Param(id = 4) Long l2, @Param(id = 5) int i3) {
        this.zaa = i;
        this.zab = i2;
        this.zac = l;
        this.zad = l2;
        this.zae = i3;
        if (l != null && l2 != null && l2.longValue() != 0) {
            new ProgressInfo(l.longValue(), l2.longValue());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.zab;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        SafeParcelWriter.writeLongObject(parcel, 3, this.zac, false);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zad, false);
        int i4 = this.zae;
        parcel.writeInt(262149);
        parcel.writeInt(i4);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
