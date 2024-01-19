package com.google.android.gms.internal.auth;

import org.apache.fontbox.ttf.GlyfDescript;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzhd {
    public static final zzhb zza = new zzhc();

    static {
        if (zzgz.zzu() && zzgz.zzv()) {
            int i = zzdo.zza;
        }
    }

    public static /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == 1) {
                byte b3 = bArr[i];
                if (b2 <= -12 && b3 <= -65) {
                    return b2 ^ (b3 << 8);
                }
            } else if (i3 == 2) {
                byte b4 = bArr[i];
                byte b5 = bArr[i + 1];
                if (b2 <= -12 && b4 <= -65 && b5 <= -65) {
                    return ((b4 << 8) ^ b2) ^ (b5 << GlyfDescript.X_DUAL);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b2 <= -12) {
            return b2;
        }
        return -1;
    }

    public static String zzb(byte[] bArr, int i, int i2) throws zzew {
        int i3;
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r11 < i4) {
                byte b2 = bArr[r11];
                if (!zzha.zzd(b2)) {
                    break;
                }
                i = r11 + 1;
                cArr[i3] = (char) b2;
                i5 = i3 + 1;
            }
            while (r11 < i4) {
                int i6 = r11 + 1;
                byte b3 = bArr[r11];
                if (zzha.zzd(b3)) {
                    int i7 = i3 + 1;
                    cArr[i3] = (char) b3;
                    r11 = i6;
                    while (true) {
                        i3 = i7;
                        if (r11 >= i4) {
                            break;
                        }
                        byte b4 = bArr[r11];
                        if (!zzha.zzd(b4)) {
                            break;
                        }
                        r11++;
                        i7 = i3 + 1;
                        cArr[i3] = (char) b4;
                    }
                } else if (b3 < -32) {
                    if (i6 < i4) {
                        zzha.zzb(b3, bArr[i6], cArr, i3);
                        r11 = i6 + 1;
                        i3++;
                    } else {
                        throw zzew.zzb();
                    }
                } else if (b3 < -16) {
                    if (i6 < i4 - 1) {
                        int i8 = i6 + 1;
                        zzha.zzc(b3, bArr[i6], bArr[i8], cArr, i3);
                        r11 = i8 + 1;
                        i3++;
                    } else {
                        throw zzew.zzb();
                    }
                } else if (i6 < i4 - 2) {
                    int i9 = i6 + 1;
                    int i10 = i9 + 1;
                    zzha.zza(b3, bArr[i6], bArr[i9], bArr[i10], cArr, i3);
                    i3 += 2;
                    r11 = i10 + 1;
                } else {
                    throw zzew.zzb();
                }
            }
            return new String(cArr, 0, i3);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzd(byte[] bArr, int i, int i2) {
        return zza.zzb(bArr, i, i2);
    }
}
