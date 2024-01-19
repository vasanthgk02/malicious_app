package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import java.lang.reflect.Array;

public final class HybridBinarizer extends Binarizer {
    public static final byte[] EMPTY = new byte[0];
    public final int[] buckets = new int[32];
    public byte[] luminances = EMPTY;
    public BitMatrix matrix;

    public HybridBinarizer(RGBLuminanceSource rGBLuminanceSource) {
        super(rGBLuminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        int i;
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        RGBLuminanceSource rGBLuminanceSource = this.source;
        int i2 = rGBLuminanceSource.width;
        int i3 = rGBLuminanceSource.height;
        if (i2 < 40 || i3 < 40) {
            RGBLuminanceSource rGBLuminanceSource2 = this.source;
            int i4 = rGBLuminanceSource2.width;
            int i5 = rGBLuminanceSource2.height;
            BitMatrix bitMatrix2 = new BitMatrix(i4, i5);
            initArrays(i4);
            int[] iArr = this.buckets;
            for (int i6 = 1; i6 < 5; i6++) {
                byte[] row = rGBLuminanceSource2.getRow((i5 * i6) / 5, this.luminances);
                int i7 = (i4 << 2) / 5;
                for (int i8 = i4 / 5; i8 < i7; i8++) {
                    int i9 = (row[i8] & 255) >> 3;
                    iArr[i9] = iArr[i9] + 1;
                }
            }
            int length = iArr.length;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                if (iArr[i13] > i10) {
                    i10 = iArr[i13];
                    i12 = i13;
                }
                if (iArr[i13] > i11) {
                    i11 = iArr[i13];
                }
            }
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = i16 - i12;
                int i18 = iArr[i16] * i17 * i17;
                if (i18 > i15) {
                    i14 = i16;
                    i15 = i18;
                }
            }
            if (i12 <= i14) {
                int i19 = i12;
                i12 = i14;
                i14 = i19;
            }
            if (i12 - i14 > length / 16) {
                int i20 = i12 - 1;
                int i21 = i20;
                int i22 = -1;
                while (i20 > i14) {
                    int i23 = i20 - i14;
                    int i24 = (i11 - iArr[i20]) * (i12 - i20) * i23 * i23;
                    if (i24 > i22) {
                        i21 = i20;
                        i22 = i24;
                    }
                    i20--;
                }
                int i25 = i21 << 3;
                byte[] matrix2 = rGBLuminanceSource2.getMatrix();
                for (int i26 = 0; i26 < i5; i26++) {
                    int i27 = i26 * i4;
                    for (int i28 = 0; i28 < i4; i28++) {
                        if ((matrix2[i27 + i28] & 255) < i25) {
                            bitMatrix2.set(i28, i26);
                        }
                    }
                }
                this.matrix = bitMatrix2;
            } else {
                throw NotFoundException.INSTANCE;
            }
        } else {
            byte[] matrix3 = rGBLuminanceSource.getMatrix();
            int i29 = i2 >> 3;
            if ((i2 & 7) != 0) {
                i29++;
            }
            int i30 = i3 >> 3;
            if ((i3 & 7) != 0) {
                i30++;
            }
            int[] iArr2 = new int[2];
            iArr2[1] = i29;
            iArr2[0] = i30;
            int[][] iArr3 = (int[][]) Array.newInstance(int.class, iArr2);
            int i31 = 0;
            while (true) {
                int i32 = 8;
                if (i31 >= i30) {
                    break;
                }
                int i33 = i31 << 3;
                int i34 = i3 - 8;
                if (i33 > i34) {
                    i33 = i34;
                }
                int i35 = 0;
                while (i35 < i29) {
                    int i36 = i35 << 3;
                    int i37 = i2 - 8;
                    if (i36 > i37) {
                        i36 = i37;
                    }
                    int i38 = (i33 * i2) + i36;
                    byte b2 = 255;
                    int i39 = 0;
                    int i40 = 0;
                    byte b3 = 0;
                    while (i39 < i32) {
                        byte b4 = b3;
                        int i41 = 0;
                        while (i41 < i32) {
                            int i42 = i38;
                            byte b5 = matrix3[i38 + i41] & 255;
                            i40 += b5;
                            if (b5 < b2) {
                                b2 = b5;
                            }
                            if (b5 > b4) {
                                b4 = b5;
                            }
                            i41++;
                            i38 = i42;
                            i32 = 8;
                        }
                        int i43 = i38;
                        if (b4 - b2 > 24) {
                            i = i43;
                            while (true) {
                                i39++;
                                i += i2;
                                if (i39 >= 8) {
                                    break;
                                }
                                int i44 = 0;
                                for (int i45 = 8; i44 < i45; i45 = 8) {
                                    i40 += matrix3[i + i44] & 255;
                                    i44++;
                                    i = i;
                                }
                                int i46 = i;
                            }
                            int i47 = i;
                        } else {
                            i = i43;
                        }
                        i39++;
                        i38 = i + i2;
                        b3 = b4;
                        i32 = 8;
                    }
                    int i48 = i40 >> 6;
                    if (b3 - b2 <= 24) {
                        i48 = b2 / 2;
                        if (i31 > 0 && i35 > 0) {
                            int i49 = i31 - 1;
                            int i50 = i35 - 1;
                            int i51 = (((iArr3[i31][i50] * 2) + iArr3[i49][i35]) + iArr3[i49][i50]) / 4;
                            if (b2 < i51) {
                                i48 = i51;
                            }
                        }
                    }
                    iArr3[i31][i35] = i48;
                    i35++;
                    i32 = 8;
                }
                i31++;
            }
            BitMatrix bitMatrix3 = new BitMatrix(i2, i3);
            for (int i52 = 0; i52 < i30; i52++) {
                int i53 = i52 << 3;
                int i54 = i3 - 8;
                if (i53 > i54) {
                    i53 = i54;
                }
                int i55 = 0;
                while (i55 < i29) {
                    int i56 = i55 << 3;
                    int i57 = i2 - 8;
                    if (i56 > i57) {
                        i56 = i57;
                    }
                    int i58 = i29 - 3;
                    int i59 = i55 < 2 ? 2 : i55 > i58 ? i58 : i55;
                    int i60 = i30 - 3;
                    if (i52 < 2) {
                        i60 = 2;
                    } else if (i52 <= i60) {
                        i60 = i52;
                    }
                    int i61 = -2;
                    int i62 = 0;
                    for (int i63 = 2; i61 <= i63; i63 = 2) {
                        int[] iArr4 = iArr3[i60 + i61];
                        i62 = iArr4[i59 - 2] + iArr4[i59 - 1] + iArr4[i59] + iArr4[i59 + 1] + iArr4[i59 + 2] + i62;
                        i61++;
                    }
                    int i64 = i62 / 25;
                    int i65 = (i53 * i2) + i56;
                    int i66 = 0;
                    while (true) {
                        if (i66 >= 8) {
                            break;
                        }
                        int i67 = i3;
                        int i68 = 0;
                        for (int i69 = 8; i68 < i69; i69 = 8) {
                            byte[] bArr = matrix3;
                            if ((matrix3[i65 + i68] & 255) <= i64) {
                                bitMatrix3.set(i56 + i68, i53 + i66);
                            }
                            i68++;
                            matrix3 = bArr;
                        }
                        byte[] bArr2 = matrix3;
                        i66++;
                        i65 += i2;
                        i3 = i67;
                    }
                    byte[] bArr3 = matrix3;
                    int i70 = i3;
                    i55++;
                }
                byte[] bArr4 = matrix3;
                int i71 = i3;
            }
            this.matrix = bitMatrix3;
        }
        return this.matrix;
    }

    public final void initArrays(int i) {
        if (this.luminances.length < i) {
            this.luminances = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.buckets[i2] = 0;
        }
    }
}
