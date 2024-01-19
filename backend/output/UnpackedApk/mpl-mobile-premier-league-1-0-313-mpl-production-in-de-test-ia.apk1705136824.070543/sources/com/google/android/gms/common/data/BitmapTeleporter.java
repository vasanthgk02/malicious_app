package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.nio.ByteBuffer;

@ShowFirstParty
@KeepForSdk
@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    @KeepForSdk
    public static final Creator<BitmapTeleporter> CREATOR = new zaa();
    @VersionField
    public final int zaa;
    @Field
    public ParcelFileDescriptor zab;
    @Field
    public final int zac;
    public Bitmap zad = null;

    @Constructor
    public BitmapTeleporter(@Param(id = 1) int i, @Param(id = 2) ParcelFileDescriptor parcelFileDescriptor, @Param(id = 3) int i2) {
        this.zaa = i;
        this.zab = parcelFileDescriptor;
        this.zac = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (this.zab != null) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            int i2 = this.zaa;
            parcel.writeInt(262145);
            parcel.writeInt(i2);
            SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i | 1, false);
            int i3 = this.zac;
            parcel.writeInt(262147);
            parcel.writeInt(i3);
            SafeParcelWriter.zzb(parcel, beginObjectHeader);
            this.zab = null;
            return;
        }
        Bitmap bitmap = this.zad;
        Preconditions.checkNotNull(bitmap);
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
        bitmap.copyPixelsToBuffer(allocate);
        allocate.array();
        throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
    }
}
