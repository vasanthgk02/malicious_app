package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final /* synthetic */ class zab implements Comparator {
    public static final /* synthetic */ zab zaa = new zab();

    public final int compare(Object obj, Object obj2) {
        Feature feature = (Feature) obj;
        Feature feature2 = (Feature) obj2;
        Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
        if (!feature.zza.equals(feature2.zza)) {
            return feature.zza.compareTo(feature2.zza);
        }
        return (feature.getVersion() > feature2.getVersion() ? 1 : (feature.getVersion() == feature2.getVersion() ? 0 : -1));
    }
}
