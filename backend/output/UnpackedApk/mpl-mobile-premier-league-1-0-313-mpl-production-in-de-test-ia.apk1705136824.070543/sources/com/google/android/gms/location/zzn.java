package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzn implements Comparator<ActivityTransition> {
    public final int compare(Object obj, Object obj2) {
        ActivityTransition activityTransition = (ActivityTransition) obj;
        ActivityTransition activityTransition2 = (ActivityTransition) obj2;
        Preconditions.checkNotNull(activityTransition);
        Preconditions.checkNotNull(activityTransition2);
        int i = activityTransition.zza;
        int i2 = activityTransition2.zza;
        int i3 = 1;
        if (i == i2) {
            int i4 = activityTransition.zzb;
            int i5 = activityTransition2.zzb;
            if (i4 == i5) {
                i3 = 0;
            } else if (i4 < i5) {
                i3 = -1;
            }
        } else if (i >= i2) {
            return i3;
        } else {
            return -1;
        }
        return i3;
    }
}
