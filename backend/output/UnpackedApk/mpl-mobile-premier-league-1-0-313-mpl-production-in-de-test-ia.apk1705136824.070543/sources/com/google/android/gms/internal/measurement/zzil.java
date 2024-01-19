package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public abstract class zzil<MessageType extends zzil<MessageType, BuilderType>, BuilderType extends zzik<MessageType, BuilderType>> implements zzlj {
    public int zzb = 0;

    public static void zzbw(Iterable iterable, List list) {
        zzkk.zze(iterable);
        if (iterable instanceof zzkr) {
            List zzh = ((zzkr) iterable).zzh();
            zzkr zzkr = (zzkr) list;
            int size = list.size();
            for (Object next : zzh) {
                if (next == null) {
                    int size2 = zzkr.size();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Element at index ");
                    outline73.append(size2 - size);
                    outline73.append(" is null.");
                    String sb = outline73.toString();
                    int size3 = zzkr.size();
                    while (true) {
                        size3--;
                        if (size3 >= size) {
                            zzkr.remove(size3);
                        } else {
                            throw new NullPointerException(sb);
                        }
                    }
                } else if (next instanceof zzjb) {
                    zzkr.zzi((zzjb) next);
                } else {
                    zzkr.add((String) next);
                }
            }
        } else if (!(iterable instanceof zzlq)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size4 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    int size5 = list.size();
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Element at index ");
                    outline732.append(size5 - size4);
                    outline732.append(" is null.");
                    String sb2 = outline732.toString();
                    int size6 = list.size();
                    while (true) {
                        size6--;
                        if (size6 >= size4) {
                            list.remove(size6);
                        } else {
                            throw new NullPointerException(sb2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    public int zzbu() {
        throw null;
    }

    public final zzjb zzbv() {
        try {
            int zzbz = zzbz();
            zzjb zzjb = zzjb.zzb;
            byte[] bArr = new byte[zzbz];
            zzjj zzC = zzjj.zzC(bArr);
            zzbN(zzC);
            zzC.zzD();
            return new zziy(bArr);
        } catch (IOException e2) {
            throw new RuntimeException(GeneratedOutlineSupport.outline52("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e2);
        }
    }

    public void zzbx(int i) {
        throw null;
    }

    public final byte[] zzby() {
        try {
            byte[] bArr = new byte[zzbz()];
            zzjj zzC = zzjj.zzC(bArr);
            zzbN(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(GeneratedOutlineSupport.outline52("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e2);
        }
    }
}
