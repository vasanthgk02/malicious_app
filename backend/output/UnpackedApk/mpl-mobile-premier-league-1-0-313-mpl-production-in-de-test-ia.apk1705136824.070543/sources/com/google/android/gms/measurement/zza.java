package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzhy;
import com.google.android.gms.measurement.internal.zzia;
import com.google.android.gms.measurement.internal.zzin;
import com.google.android.gms.measurement.internal.zziu;
import com.google.android.gms.measurement.internal.zzll;
import com.google.android.gms.measurement.internal.zzlp;
import com.google.firebase.perf.config.RemoteConfigManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zza extends zzd {
    public final zzgi zza;
    public final zzin zzb;

    public zza(zzgi zzgi) {
        Preconditions.checkNotNull(zzgi);
        this.zza = zzgi;
        this.zzb = zzgi.zzq();
    }

    public final int zza(String str) {
        zzin zzin = this.zzb;
        if (zzin != null) {
            Preconditions.checkNotEmpty(str);
            zzaf zzaf = zzin.zzs.zzk;
            return 25;
        }
        throw null;
    }

    public final long zzb() {
        return this.zza.zzv().zzq();
    }

    public final String zzh() {
        return this.zzb.zzo();
    }

    public final String zzi() {
        zziu zziu = this.zzb.zzs.zzs().zzb;
        if (zziu != null) {
            return zziu.zzb;
        }
        return null;
    }

    public final String zzj() {
        zziu zziu = this.zzb.zzs.zzs().zzb;
        if (zziu != null) {
            return zziu.zza;
        }
        return null;
    }

    public final String zzk() {
        return this.zzb.zzo();
    }

    public final List zzm(String str, String str2) {
        zzin zzin = this.zzb;
        if (zzin.zzs.zzaA().zzs()) {
            zzin.zzs.zzaz().zzd.zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        zzaa zzaa = zzin.zzs.zzj;
        if (zzaa.zza()) {
            zzin.zzs.zzaz().zzd.zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        zzin.zzs.zzaA().zzd(atomicReference, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS, "get conditional user properties", new zzhy(zzin, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzlp.zzH(list);
        }
        zzin.zzs.zzaz().zzd.zzb("Timed out waiting for get conditional user properties", null);
        return new ArrayList();
    }

    public final Map zzo(String str, String str2, boolean z) {
        zzin zzin = this.zzb;
        if (zzin.zzs.zzaA().zzs()) {
            zzin.zzs.zzaz().zzd.zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzaa zzaa = zzin.zzs.zzj;
        if (zzaa.zza()) {
            zzin.zzs.zzaz().zzd.zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        zzgf zzaA = zzin.zzs.zzaA();
        zzia zzia = new zzia(zzin, atomicReference, str, str2, z);
        zzaA.zzd(atomicReference, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS, "get user properties", zzia);
        List<zzll> list = (List) atomicReference.get();
        if (list == null) {
            zzin.zzs.zzaz().zzd.zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzll zzll : list) {
            Object zza2 = zzll.zza();
            if (zza2 != null) {
                arrayMap.put(zzll.zzb, zza2);
            }
        }
        return arrayMap;
    }

    public final void zzp(String str) {
        this.zza.zzd().zzd(str, this.zza.zzr.elapsedRealtime());
    }

    public final void zzq(String str, String str2, Bundle bundle) {
        this.zza.zzq().zzA(str, str2, bundle);
    }

    public final void zzr(String str) {
        this.zza.zzd().zze(str, this.zza.zzr.elapsedRealtime());
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        this.zzb.zzE(str, str2, bundle);
    }

    public final void zzv(Bundle bundle) {
        zzin zzin = this.zzb;
        zzin.zzR(bundle, zzin.zzs.zzr.currentTimeMillis());
    }
}
