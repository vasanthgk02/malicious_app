package com.google.zxing.common.reedsolomon;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder {
    public final List<GenericGFPoly> cachedGenerators;
    public final GenericGF field;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.field = genericGF;
        ArrayList arrayList = new ArrayList();
        this.cachedGenerators = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    public void encode(int[] iArr, int i) {
        GenericGFPoly genericGFPoly;
        int[] iArr2 = iArr;
        int i2 = i;
        if (i2 != 0) {
            int length = iArr2.length - i2;
            if (length > 0) {
                int i3 = 2;
                char c2 = 0;
                int i4 = 1;
                if (i2 >= this.cachedGenerators.size()) {
                    GenericGFPoly genericGFPoly2 = (GenericGFPoly) GeneratedOutlineSupport.outline30(this.cachedGenerators, 1);
                    int size = this.cachedGenerators.size();
                    while (size <= i2) {
                        GenericGF genericGF = this.field;
                        int[] iArr3 = new int[i3];
                        iArr3[c2] = i4;
                        iArr3[i4] = genericGF.expTable[(size - 1) + genericGF.generatorBase];
                        GenericGFPoly genericGFPoly3 = new GenericGFPoly(genericGF, iArr3);
                        if (genericGFPoly2.field.equals(genericGFPoly3.field)) {
                            if (genericGFPoly2.isZero() || genericGFPoly3.isZero()) {
                                genericGFPoly2 = genericGFPoly2.field.zero;
                            } else {
                                int[] iArr4 = genericGFPoly2.coefficients;
                                int length2 = iArr4.length;
                                int[] iArr5 = genericGFPoly3.coefficients;
                                int length3 = iArr5.length;
                                int[] iArr6 = new int[((length2 + length3) - 1)];
                                for (int i5 = 0; i5 < length2; i5++) {
                                    int i6 = iArr4[i5];
                                    int i7 = 0;
                                    while (i7 < length3) {
                                        int i8 = i5 + i7;
                                        iArr6[i8] = genericGFPoly2.field.multiply(i6, iArr5[i7]) ^ iArr6[i8];
                                        i7++;
                                        iArr4 = iArr4;
                                        length2 = length2;
                                    }
                                    int[] iArr7 = iArr4;
                                    int i9 = length2;
                                }
                                genericGFPoly2 = new GenericGFPoly(genericGFPoly2.field, iArr6);
                            }
                            this.cachedGenerators.add(genericGFPoly2);
                            size++;
                            i3 = 2;
                            c2 = 0;
                            i4 = 1;
                        } else {
                            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                        }
                    }
                }
                GenericGFPoly genericGFPoly4 = this.cachedGenerators.get(i2);
                int[] iArr8 = new int[length];
                System.arraycopy(iArr2, 0, iArr8, 0, length);
                GenericGFPoly multiplyByMonomial = new GenericGFPoly(this.field, iArr8).multiplyByMonomial(i2, 1);
                if (!multiplyByMonomial.field.equals(genericGFPoly4.field)) {
                    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                } else if (!genericGFPoly4.isZero()) {
                    GenericGFPoly genericGFPoly5 = multiplyByMonomial.field.zero;
                    int coefficient = genericGFPoly4.getCoefficient(genericGFPoly4.getDegree());
                    GenericGF genericGF2 = multiplyByMonomial.field;
                    if (genericGF2 == null) {
                        throw null;
                    } else if (coefficient != 0) {
                        int i10 = genericGF2.expTable[(genericGF2.size - genericGF2.logTable[coefficient]) - 1];
                        GenericGFPoly genericGFPoly6 = multiplyByMonomial;
                        while (genericGFPoly6.getDegree() >= genericGFPoly4.getDegree() && !genericGFPoly6.isZero()) {
                            int degree = genericGFPoly6.getDegree() - genericGFPoly4.getDegree();
                            int multiply = multiplyByMonomial.field.multiply(genericGFPoly6.getCoefficient(genericGFPoly6.getDegree()), i10);
                            GenericGFPoly multiplyByMonomial2 = genericGFPoly4.multiplyByMonomial(degree, multiply);
                            GenericGF genericGF3 = multiplyByMonomial.field;
                            if (genericGF3 == null) {
                                throw null;
                            } else if (degree >= 0) {
                                if (multiply == 0) {
                                    genericGFPoly = genericGF3.zero;
                                } else {
                                    int[] iArr9 = new int[(degree + 1)];
                                    iArr9[0] = multiply;
                                    genericGFPoly = new GenericGFPoly(genericGF3, iArr9);
                                }
                                genericGFPoly5 = genericGFPoly5.addOrSubtract(genericGFPoly);
                                genericGFPoly6 = genericGFPoly6.addOrSubtract(multiplyByMonomial2);
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                        int[] iArr10 = new GenericGFPoly[]{genericGFPoly5, genericGFPoly6}[1].coefficients;
                        int length4 = i2 - iArr10.length;
                        for (int i11 = 0; i11 < length4; i11++) {
                            iArr2[length + i11] = 0;
                        }
                        System.arraycopy(iArr10, 0, iArr2, length + length4, iArr10.length);
                    } else {
                        throw new ArithmeticException();
                    }
                } else {
                    throw new IllegalArgumentException("Divide by 0");
                }
            } else {
                throw new IllegalArgumentException("No data bytes provided");
            }
        } else {
            throw new IllegalArgumentException("No error correction bytes");
        }
    }
}
