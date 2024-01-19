package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zan extends AbstractSafeParcelable {
    public static final Creator<zan> CREATOR = new zao();
    @VersionField
    public final int zaa;
    public final HashMap zab;
    @Field
    public final String zac;

    @Constructor
    public zan(@Param(id = 1) int i, @Param(id = 2) ArrayList arrayList, @Param(id = 3) String str) {
        this.zaa = i;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zal = (zal) arrayList.get(i2);
            String str2 = zal.zab;
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList2 = zal.zac;
            Preconditions.checkNotNull(arrayList2);
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zam = (zam) zal.zac.get(i3);
                hashMap2.put(zam.zab, zam.zac);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zab = hashMap;
        Preconditions.checkNotNull(str);
        this.zac = str;
        for (String str3 : this.zab.keySet()) {
            Map map = (Map) this.zab.get(str3);
            for (String str4 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str4)).zaj = this;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.zab.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map = (Map) this.zab.get(str);
            for (String str2 : map.keySet()) {
                GeneratedOutlineSupport.outline102(sb, "  ", str2, ": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zab.keySet()) {
            arrayList.add(new zal(str, (Map) this.zab.get(str)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.zac, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final Map zab(String str) {
        return (Map) this.zab.get(str);
    }
}
