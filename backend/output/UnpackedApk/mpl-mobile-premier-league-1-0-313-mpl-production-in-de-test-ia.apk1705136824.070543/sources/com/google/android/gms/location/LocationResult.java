package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<LocationResult> CREATOR = new zzbg();
    public static final List<Location> zza = Collections.emptyList();
    @Field
    public final List<Location> zzb;

    @Constructor
    public LocationResult(@Param(id = 1) List<Location> list) {
        this.zzb = list;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.zzb.size() != this.zzb.size()) {
            return false;
        }
        Iterator<Location> it = this.zzb.iterator();
        for (Location time : locationResult.zzb) {
            if (it.next().getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public Location getLastLocation() {
        int size = this.zzb.size();
        if (size == 0) {
            return null;
        }
        return this.zzb.get(size - 1);
    }

    public int hashCode() {
        int i = 17;
        for (Location time : this.zzb) {
            long time2 = time.getTime();
            i = (i * 31) + ((int) (time2 ^ (time2 >>> 32)));
        }
        return i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzb);
        return GeneratedOutlineSupport.outline63(new StringBuilder(valueOf.length() + 27), "LocationResult[locations: ", valueOf, CMapParser.MARK_END_OF_ARRAY);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zzb, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
