package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzls extends zzim implements RandomAccess {
    public static final zzls zza;
    public Object[] zzb;
    public int zzc;

    static {
        zzls zzls = new zzls(new Object[0], 0);
        zza = zzls;
        zzls.zzb();
    }

    public zzls() {
        this(new Object[10], 0);
    }

    public static zzls zze() {
        return zza;
    }

    private final String zzf(int i) {
        return GeneratedOutlineSupport.outline43("Index:", i, ", Size:", this.zzc);
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    public final void add(int i, Object obj) {
        zzbS();
        if (i >= 0) {
            int i2 = this.zzc;
            if (i <= i2) {
                Object[] objArr = this.zzb;
                if (i2 < objArr.length) {
                    System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
                } else {
                    Object[] objArr2 = new Object[GeneratedOutlineSupport.outline8(i2, 3, 2, 1)];
                    System.arraycopy(objArr, 0, objArr2, 0, i);
                    System.arraycopy(this.zzb, i, objArr2, i + 1, this.zzc - i);
                    this.zzb = objArr2;
                }
                this.zzb[i] = obj;
                this.zzc++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzf(i));
    }

    public final Object get(int i) {
        zzg(i);
        return this.zzb[i];
    }

    public final Object remove(int i) {
        zzbS();
        zzg(i);
        Object[] objArr = this.zzb;
        Object obj = objArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i, Object obj) {
        zzbS();
        zzg(i);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzkj zzd(int i) {
        if (i >= this.zzc) {
            return new zzls(Arrays.copyOf(this.zzb, i), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public zzls(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final boolean add(Object obj) {
        zzbS();
        int i = this.zzc;
        Object[] objArr = this.zzb;
        if (i == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        objArr2[i2] = obj;
        this.modCount++;
        return true;
    }
}
