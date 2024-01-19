package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new zzau();
    @Field
    public final List<zzbe> zza;
    @InitialTrigger
    @Field
    public final int zzb;
    @Field
    public final String zzc;
    @Field
    public final String zzd;

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    public static final class Builder {
        public final List<zzbe> zza = new ArrayList();
        @InitialTrigger
        public int zzb = 5;
        public String zzc = "";

        public Builder addGeofences(List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence next : list) {
                    if (next != null) {
                        Preconditions.checkNotNull(next, "geofence can't be null.");
                        Preconditions.checkArgument(next instanceof zzbe, "Geofence must be created using Geofence.Builder.");
                        this.zza.add((zzbe) next);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            Preconditions.checkArgument(!this.zza.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.zza, this.zzb, this.zzc, null);
        }
    }

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    public @interface InitialTrigger {
    }

    @Constructor
    public GeofencingRequest(@Param(id = 1) List<zzbe> list, @InitialTrigger @Param(id = 2) int i, @Param(id = 3) String str, @Param(id = 4) String str2) {
        this.zza = list;
        this.zzb = i;
        this.zzc = str;
        this.zzd = str2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GeofencingRequest[geofences=");
        outline73.append(this.zza);
        outline73.append(", initialTrigger=");
        outline73.append(this.zzb);
        outline73.append(", tag=");
        outline73.append(this.zzc);
        outline73.append(", attributionTag=");
        return GeneratedOutlineSupport.outline62(outline73, this.zzd, CMapParser.MARK_END_OF_ARRAY);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        int i2 = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
