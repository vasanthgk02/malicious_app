package com.google.android.gms.internal.auth;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzfz<E> extends zzdn<E> implements RandomAccess {
    public static final zzfz<Object> zza;
    public E[] zzb;
    public int zzc;

    static {
        zzfz<Object> zzfz = new zzfz<>(new Object[0], 0);
        zza = zzfz;
        zzfz.zzb();
    }

    public zzfz() {
        this(new Object[10], 0);
    }

    public static <E> zzfz<E> zze() {
        return zza;
    }

    private final String zzf(int i) {
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    public final void add(int i, E e2) {
        zza();
        if (i >= 0) {
            int i2 = this.zzc;
            if (i <= i2) {
                E[] eArr = this.zzb;
                if (i2 < eArr.length) {
                    System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
                } else {
                    E[] eArr2 = new Object[GeneratedOutlineSupport.outline8(i2, 3, 2, 1)];
                    System.arraycopy(eArr, 0, eArr2, 0, i);
                    System.arraycopy(this.zzb, i, eArr2, i + 1, this.zzc - i);
                    this.zzb = eArr2;
                }
                this.zzb[i] = e2;
                this.zzc++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzf(i));
    }

    public final E get(int i) {
        zzg(i);
        return this.zzb[i];
    }

    public final E remove(int i) {
        zza();
        zzg(i);
        E[] eArr = this.zzb;
        E e2 = eArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e2;
    }

    public final E set(int i, E e2) {
        zza();
        zzg(i);
        E[] eArr = this.zzb;
        E e3 = eArr[i];
        eArr[i] = e2;
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzeu zzd(int i) {
        if (i >= this.zzc) {
            return new zzfz(Arrays.copyOf(this.zzb, i), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public zzfz(E[] eArr, int i) {
        this.zzb = eArr;
        this.zzc = i;
    }

    public final boolean add(E e2) {
        zza();
        int i = this.zzc;
        E[] eArr = this.zzb;
        if (i == eArr.length) {
            this.zzb = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        eArr2[i2] = e2;
        this.modCount++;
        return true;
    }
}
