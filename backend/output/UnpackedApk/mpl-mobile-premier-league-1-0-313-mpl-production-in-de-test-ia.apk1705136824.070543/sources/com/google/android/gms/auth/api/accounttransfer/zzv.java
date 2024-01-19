package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.collection.ArraySet;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzv extends zzbz {
    public static final Creator<zzv> CREATOR = new zzw();
    public static final HashMap<String, Field<?, ?>> zzc;
    @Indicator
    public final Set<Integer> zza;
    @VersionField
    public final int zzb;
    @SafeParcelable.Field
    public String zzd;
    @SafeParcelable.Field
    public int zze;
    @SafeParcelable.Field
    public byte[] zzf;
    @SafeParcelable.Field
    public PendingIntent zzg;
    @SafeParcelable.Field
    public DeviceMetaData zzh;

    static {
        HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
        zzc = hashMap;
        hashMap.put("accountType", Field.forString("accountType", 2));
        HashMap<String, Field<?, ?>> hashMap2 = zzc;
        Field field = new Field(0, false, 0, false, "status", 3, null, null);
        hashMap2.put("status", field);
        HashMap<String, Field<?, ?>> hashMap3 = zzc;
        Field field2 = new Field(8, false, 8, false, "transferBytes", 4, null, null);
        hashMap3.put("transferBytes", field2);
    }

    public zzv() {
        this.zza = new ArraySet(3);
        this.zzb = 1;
    }

    public final /* bridge */ /* synthetic */ Map getFieldMappings() {
        return zzc;
    }

    public final Object getFieldValue(Field field) {
        int i = field.zaf;
        if (i == 1) {
            return Integer.valueOf(this.zzb);
        }
        if (i == 2) {
            return this.zzd;
        }
        if (i == 3) {
            return Integer.valueOf(this.zze);
        }
        if (i == 4) {
            return this.zzf;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline31(37, "Unknown SafeParcelable id=", field.zaf));
    }

    public final boolean isFieldSet(Field field) {
        return this.zza.contains(Integer.valueOf(field.zaf));
    }

    public final void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        int i = field.zaf;
        if (i == 4) {
            this.zzf = bArr;
            this.zza.add(Integer.valueOf(i));
            return;
        }
        StringBuilder sb = new StringBuilder(59);
        sb.append("Field with id=");
        sb.append(i);
        sb.append(" is not known to be an byte array.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void setIntegerInternal(Field<?, ?> field, String str, int i) {
        int i2 = field.zaf;
        if (i2 == 3) {
            this.zze = i;
            this.zza.add(Integer.valueOf(i2));
            return;
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("Field with id=");
        sb.append(i2);
        sb.append(" is not known to be an int.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void setStringInternal(Field<?, ?> field, String str, String str2) {
        int i = field.zaf;
        if (i == 2) {
            this.zzd = str2;
            this.zza.add(Integer.valueOf(i));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(i)}));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zza;
        if (set.contains(Integer.valueOf(1))) {
            int i2 = this.zzb;
            parcel.writeInt(262145);
            parcel.writeInt(i2);
        }
        if (set.contains(Integer.valueOf(2))) {
            SafeParcelWriter.writeString(parcel, 2, this.zzd, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            int i3 = this.zze;
            parcel.writeInt(262147);
            parcel.writeInt(i3);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.zzf, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.zzg, i, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.zzh, i, true);
        }
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    @Constructor
    public zzv(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2, @Param(id = 4) byte[] bArr, @Param(id = 5) PendingIntent pendingIntent, @Param(id = 6) DeviceMetaData deviceMetaData) {
        this.zza = set;
        this.zzb = i;
        this.zzd = str;
        this.zze = i2;
        this.zzf = bArr;
        this.zzg = pendingIntent;
        this.zzh = deviceMetaData;
    }
}
