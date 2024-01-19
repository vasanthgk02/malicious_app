package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzld extends LinkedHashMap {
    public static final zzld zza;
    public boolean zzb = true;

    static {
        zzld zzld = new zzld();
        zza = zzld;
        zzld.zzb = false;
    }

    public zzld() {
    }

    public static zzld zza() {
        return zza;
    }

    public static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            return zzkk.zzb((byte[]) obj);
        }
        if (!(obj instanceof zzke)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zzg() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzg();
        super.clear();
    }

    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    for (Entry entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            Object value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                                z = value.equals(obj2);
                                continue;
                            } else {
                                z = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            }
                            if (!z) {
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i;
    }

    public final Object put(Object obj, Object obj2) {
        zzg();
        zzkk.zze(obj);
        zzkk.zze(obj2);
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        zzg();
        for (Object next : map.keySet()) {
            zzkk.zze(next);
            zzkk.zze(map.get(next));
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    public final zzld zzb() {
        return isEmpty() ? new zzld() : new zzld(this);
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zzd(zzld zzld) {
        zzg();
        if (!zzld.isEmpty()) {
            putAll(zzld);
        }
    }

    public final boolean zze() {
        return this.zzb;
    }

    public zzld(Map map) {
        super(map);
    }
}
