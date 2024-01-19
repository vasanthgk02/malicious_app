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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzn extends zzbz {
    public static final Creator<zzn> CREATOR = new zzo();
    public static final HashMap<String, Field<?, ?>> zzc;
    @Indicator
    public final Set<Integer> zza;
    @VersionField
    public final int zzb;
    @SafeParcelable.Field
    public ArrayList<zzt> zzd;
    @SafeParcelable.Field
    public int zze;
    @SafeParcelable.Field
    public zzr zzf;

    static {
        HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
        zzc = hashMap;
        Field field = new Field(11, true, 11, true, "authenticatorData", 2, zzt.class, null);
        hashMap.put("authenticatorData", field);
        zzc.put("progress", Field.forConcreteType("progress", 4, zzr.class));
    }

    public zzn() {
        this.zza = new HashSet(1);
        this.zzb = 1;
    }

    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field field, String str, ArrayList<T> arrayList) {
        int i = field.zaf;
        if (i == 2) {
            this.zzd = arrayList;
            this.zza.add(Integer.valueOf(i));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", new Object[]{Integer.valueOf(i), arrayList.getClass().getCanonicalName()}));
    }

    public final <T extends FastJsonResponse> void addConcreteTypeInternal(Field field, String str, T t) {
        int i = field.zaf;
        if (i == 4) {
            this.zzf = (zzr) t;
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
        if (i == 4) {
            return this.zzf;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline31(37, "Unknown SafeParcelable id=", field.zaf));
    }

    public final boolean isFieldSet(Field field) {
        return this.zza.contains(Integer.valueOf(field.zaf));
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
            SafeParcelWriter.writeTypedList(parcel, 2, this.zzd, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            int i3 = this.zze;
            parcel.writeInt(262147);
            parcel.writeInt(i3);
        }
        if (set.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzf, i, true);
        }
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    @Constructor
    public zzn(@Indicator Set<Integer> set, @Param(id = 1) int i, @Param(id = 2) ArrayList<zzt> arrayList, @Param(id = 3) int i2, @Param(id = 4) zzr zzr) {
        this.zza = set;
        this.zzb = i;
        this.zzd = arrayList;
        this.zze = i2;
        this.zzf = zzr;
    }
}
