package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<ActivityRecognitionResult> CREATOR = new zzk();
    @Field
    public List<DetectedActivity> zza;
    @Field
    public long zzb;
    @Field
    public long zzc;
    @Field
    public int zzd;
    @Field
    public Bundle zze;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r0 = true;
     */
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ActivityRecognitionResult(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) java.util.List<com.google.android.gms.location.DetectedActivity> r6, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) long r7, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) long r9, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) int r11, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) android.os.Bundle r12) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x000f
            int r2 = r6.size()
            if (r2 <= 0) goto L_0x000f
            r2 = 1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            java.lang.String r3 = "Must have at least 1 detected activity"
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2, r3)
            r2 = 0
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            r0 = 1
        L_0x0020:
            java.lang.String r1 = "Must set times"
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            r5.zza = r6
            r5.zzb = r7
            r5.zzc = r9
            r5.zzd = r11
            r5.zze = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.<init>(java.util.List, long, long, int, android.os.Bundle):void");
    }

    public static boolean zzb(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            return bundle2 == null;
        }
        if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!zzb(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (obj.getClass().isArray()) {
                if (obj2 != null && obj2.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    if (length == Array.getLength(obj2)) {
                        int i = 0;
                        while (i < length) {
                            if (Objects.equal(Array.get(obj, i), Array.get(obj2, i))) {
                                i++;
                            }
                        }
                        continue;
                    }
                }
                return false;
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    @ShowFirstParty
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ActivityRecognitionResult.class == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            return this.zzb == activityRecognitionResult.zzb && this.zzc == activityRecognitionResult.zzc && this.zzd == activityRecognitionResult.zzd && Objects.equal(this.zza, activityRecognitionResult.zza) && zzb(this.zze, activityRecognitionResult.zze);
        }
    }

    @ShowFirstParty
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zza, this.zze});
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        long j = this.zzb;
        long j2 = this.zzc;
        StringBuilder sb = new StringBuilder(valueOf.length() + 124);
        GeneratedOutlineSupport.outline102(sb, "ActivityRecognitionResult [probableActivities=", valueOf, ", timeMillis=");
        sb.append(j);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j2);
        sb.append(CMapParser.MARK_END_OF_ARRAY);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        long j = this.zzb;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        long j2 = this.zzc;
        parcel.writeInt(524291);
        parcel.writeLong(j2);
        int i2 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        SafeParcelWriter.writeBundle(parcel, 5, this.zze, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
