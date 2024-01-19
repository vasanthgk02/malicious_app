package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzt extends zzbz {
    public static final Creator<zzt> CREATOR = new zzu();
    public static final HashMap<String, Field<?, ?>> zzc;
    @Indicator
    public final Set<Integer> zza;
    @VersionField
    public final int zzb;
    @SafeParcelable.Field
    public zzv zzd;
    @SafeParcelable.Field
    public String zze;
    @SafeParcelable.Field
    public String zzf;
    @SafeParcelable.Field
    public String zzg;

    static {
        HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
        zzc = hashMap;
        hashMap.put("authenticatorInfo", Field.forConcreteType("authenticatorInfo", 2, zzv.class));
        zzc.put("signature", Field.forString("signature", 3));
        zzc.put("package", Field.forString("package", 4));
    }

    public zzt() {
        this.zza = new HashSet(3);
        this.zzb = 1;
    }

    public final <T extends FastJsonResponse> void addConcreteTypeInternal(Field field, String str, T t) {
        int i = field.zaf;
        if (i == 2) {
            this.zzd = (zzv) t;
            this.zza.add(Integer.valueOf(i));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[]{Integer.valueOf(i), t.getClass().getCanonicalName()}));
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
            return this.zze;
        }
        if (i == 4) {
            return this.zzf;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline31(37, "Unknown SafeParcelable id=", field.zaf));
    }

    public final boolean isFieldSet(Field field) {
        return this.zza.contains(Integer.valueOf(field.zaf));
    }

    public final void setStringInternal(Field<?, ?> field, String str, String str2) {
        int i = field.zaf;
        if (i == 3) {
            this.zze = str2;
        } else if (i == 4) {
            this.zzf = str2;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(i)}));
        }
        this.zza.add(Integer.valueOf(i));
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
            SafeParcelWriter.writeParcelable(parcel, 2, this.zzd, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            SafeParcelWriter.writeString(parcel, 3, this.zze, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeString(parcel, 4, this.zzf, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            SafeParcelWriter.writeString(parcel, 5, this.zzg, true);
        }
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    @Constructor
    public zzt(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) zzv zzv, @Param(id = 3) String str, @Param(id = 4) String str2, @Param(id = 5) String str3) {
        this.zza = set;
        this.zzb = i;
        this.zzd = zzv;
        this.zze = str;
        this.zzf = str2;
        this.zzg = str3;
    }
}
