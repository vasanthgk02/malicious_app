package com.google.android.gms.internal.location;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public abstract class zzbs<E> extends zzbp<E> implements List<E>, RandomAccess {
    public static final zzbv<Object> zza = new zzbq(zzbt.zza, 0);

    public static <E> zzbs<E> zzi() {
        return zzbt.zza;
    }

    public static <E> zzbs<E> zzj(Collection<? extends E> collection) {
        if (collection instanceof zzbp) {
            zzbs<E> zze = ((zzbp) collection).zze();
            if (zze.zzf()) {
                Object[] array = zze.toArray();
                zze = zzk(array, array.length);
            }
            return zze;
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        int i = 0;
        while (i < length) {
            if (array2[i] != null) {
                i++;
            } else {
                throw new NullPointerException(GeneratedOutlineSupport.outline31(20, "at index ", i));
            }
        }
        return zzk(array2, length);
    }

    public static <E> zzbs<E> zzk(Object[] objArr, int i) {
        if (i == 0) {
            return zzbt.zza;
        }
        return new zzbt(objArr, i);
    }

    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzbl.zza(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!zzbl.zza(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final int indexOf(@NullableDecl Object obj) {
        int i = -1;
        if (obj == null) {
            return -1;
        }
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (obj.equals(get(i2))) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        return i;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(@NullableDecl Object obj) {
        int i = -1;
        if (obj == null) {
            return -1;
        }
        int size = size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (obj.equals(get(size))) {
                i = size;
                break;
            } else {
                size--;
            }
        }
        return i;
    }

    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    public final zzbu<E> zza() {
        return listIterator(0);
    }

    public final zzbs<E> zze() {
        return this;
    }

    public int zzg(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    /* renamed from: zzh */
    public zzbs<E> subList(int i, int i2) {
        zzbm.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzbt.zza;
        }
        return new zzbr(this, i, i3);
    }

    /* renamed from: zzl */
    public final zzbv<E> listIterator(int i) {
        zzbm.zzb(i, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzbq(this, i);
    }
}
