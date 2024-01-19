package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.collection.ArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzr extends zzbz {
    public static final Creator<zzr> CREATOR = new zzs();
    public static final ArrayMap<String, Field<?, ?>> zzb;
    @VersionField
    public final int zza;
    @SafeParcelable.Field
    public List<String> zzc;
    @SafeParcelable.Field
    public List<String> zzd;
    @SafeParcelable.Field
    public List<String> zze;
    @SafeParcelable.Field
    public List<String> zzf;
    @SafeParcelable.Field
    public List<String> zzg;

    static {
        ArrayMap<String, Field<?, ?>> arrayMap = new ArrayMap<>();
        zzb = arrayMap;
        arrayMap.put("registered", Field.forStrings("registered", 2));
        zzb.put("in_progress", Field.forStrings("in_progress", 3));
        zzb.put("success", Field.forStrings("success", 4));
        zzb.put("failed", Field.forStrings("failed", 5));
        zzb.put("escrowed", Field.forStrings("escrowed", 6));
    }

    public zzr() {
        this.zza = 1;
    }

    public final Map<String, Field<?, ?>> getFieldMappings() {
        return zzb;
    }

    public final Object getFieldValue(Field field) {
        switch (field.zaf) {
            case 1:
                return Integer.valueOf(this.zza);
            case 2:
                return this.zzc;
            case 3:
                return this.zzd;
            case 4:
                return this.zze;
            case 5:
                return this.zzf;
            case 6:
                return this.zzg;
            default:
                throw new IllegalStateException(GeneratedOutlineSupport.outline31(37, "Unknown SafeParcelable id=", field.zaf));
        }
    }

    public final boolean isFieldSet(Field field) {
        return true;
    }

    public final void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        int i = field.zaf;
        if (i == 2) {
            this.zzc = arrayList;
        } else if (i == 3) {
            this.zzd = arrayList;
        } else if (i == 4) {
            this.zze = arrayList;
        } else if (i == 5) {
            this.zzf = arrayList;
        } else if (i == 6) {
            this.zzg = arrayList;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", new Object[]{Integer.valueOf(i)}));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzd, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zze, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzg, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    @Constructor
    public zzr(@Param(id = 1) int i, @Param(id = 2) List<String> list, @Param(id = 3) List<String> list2, @Param(id = 4) List<String> list3, @Param(id = 5) List<String> list4, @Param(id = 6) List<String> list5) {
        this.zza = i;
        this.zzc = list;
        this.zzd = list2;
        this.zze = list3;
        this.zzf = list4;
        this.zzg = list5;
    }
}
