package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.HashMap;

@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class GmsSignatureVerifier {
    static {
        zzag.zzl();
        zzag.zzl();
        zzag zzn = zzag.zzn(zzn.zzd.zzf(), zzn.zzb.zzf());
        Preconditions.checkNotNull(zzn);
        zzag zzk = zzag.zzk(zzn);
        zzag zzn2 = zzag.zzn(zzn.zzc.zzf(), zzn.zza.zzf());
        Preconditions.checkNotNull(zzn2);
        zzag zzk2 = zzag.zzk(zzn2);
        if (!zzk.isEmpty() || !zzk2.isEmpty()) {
            zzag.zzl();
            zzag.zzl();
            zzag zzm = zzag.zzm(zzn.zzd.zzf());
            Preconditions.checkNotNull(zzm);
            zzag zzk3 = zzag.zzk(zzm);
            zzag zzm2 = zzag.zzm(zzn.zzc.zzf());
            Preconditions.checkNotNull(zzm2);
            zzag zzk4 = zzag.zzk(zzm2);
            if (!zzk3.isEmpty() || !zzk4.isEmpty()) {
                new HashMap();
                return;
            }
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
    }
}
