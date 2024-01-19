package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzez extends zzdn<String> implements RandomAccess, zzfa {
    public static final zzfa zza = zzb;
    public static final zzez zzb;
    public final List<Object> zzc;

    static {
        zzez zzez = new zzez(10);
        zzb = zzez;
        zzez.zzb();
    }

    public zzez() {
        this(10);
    }

    public static String zzh(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeb) {
            return ((zzeb) obj).zzm(zzev.zza);
        }
        return zzev.zzh((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzfa) {
            collection = ((zzfa) collection).zzg();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzh(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzh(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzeu zzd(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzez(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzfa zze() {
        return zzc() ? new zzgu(this) : this;
    }

    /* renamed from: zzf */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeb) {
            zzeb zzeb = (zzeb) obj;
            String zzm = zzeb.zzm(zzev.zza);
            if (zzeb.zzh()) {
                this.zzc.set(i, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzev.zzh(bArr);
        if (zzev.zzi(bArr)) {
            this.zzc.set(i, zzh);
        }
        return zzh;
    }

    public final List<?> zzg() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzez(int i) {
        this.zzc = new ArrayList(i);
    }

    public zzez(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
