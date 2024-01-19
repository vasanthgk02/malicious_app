package com.facebook.appevents.ml;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001b\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J+\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u001e"}, d2 = {"Lcom/facebook/appevents/ml/Operator;", "", "()V", "addmv", "", "x", "Lcom/facebook/appevents/ml/MTensor;", "b", "concatenate", "tensors", "", "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "conv1D", "w", "dense", "embedding", "texts", "", "seqLength", "", "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "flatten", "startDim", "maxPool1D", "poolSize", "mul", "relu", "softmax", "transpose2D", "transpose3D", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Operator.kt */
public final class Operator {
    public static final void addmv(MTensor mTensor, MTensor mTensor2) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(mTensor, "x");
                Intrinsics.checkNotNullParameter(mTensor2, "b");
                int i = mTensor.shape[0];
                int i2 = mTensor.shape[1];
                int i3 = mTensor.shape[2];
                float[] fArr = mTensor.data;
                float[] fArr2 = mTensor2.data;
                if (i > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        if (i2 > 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                if (i3 > 0) {
                                    int i8 = 0;
                                    while (true) {
                                        int i9 = i8 + 1;
                                        int outline7 = GeneratedOutlineSupport.outline7(i6, i3, i4 * i2 * i3, i8);
                                        fArr[outline7] = fArr[outline7] + fArr2[i8];
                                        if (i9 >= i3) {
                                            break;
                                        }
                                        i8 = i9;
                                    }
                                }
                                if (i7 >= i2) {
                                    break;
                                }
                                i6 = i7;
                            }
                        }
                        if (i5 >= i) {
                            break;
                        }
                        i4 = i5;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final MTensor concatenate(MTensor[] mTensorArr) {
        int i;
        MTensor[] mTensorArr2 = mTensorArr;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensorArr2, "tensors");
            int i2 = mTensorArr2[0].shape[0];
            int length = mTensorArr2.length - 1;
            if (length >= 0) {
                int i3 = 0;
                i = 0;
                while (true) {
                    int i4 = i3 + 1;
                    i += mTensorArr2[i3].shape[1];
                    if (i4 > length) {
                        break;
                    }
                    i3 = i4;
                }
            } else {
                i = 0;
            }
            MTensor mTensor = new MTensor(new int[]{i2, i});
            float[] fArr = mTensor.data;
            if (i2 > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    int i7 = i5 * i;
                    int length2 = mTensorArr2.length - 1;
                    if (length2 >= 0) {
                        int i8 = 0;
                        while (true) {
                            int i9 = i8 + 1;
                            float[] fArr2 = mTensorArr2[i8].data;
                            int i10 = mTensorArr2[i8].shape[1];
                            System.arraycopy(fArr2, i5 * i10, fArr, i7, i10);
                            i7 += i10;
                            if (i9 > length2) {
                                break;
                            }
                            i8 = i9;
                        }
                    }
                    if (i6 >= i2) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final MTensor conv1D(MTensor mTensor, MTensor mTensor2) {
        Class<Operator> cls;
        MTensor mTensor3;
        int i;
        int i2;
        MTensor mTensor4 = mTensor;
        MTensor mTensor5 = mTensor2;
        Class<Operator> cls2 = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor4, "x");
            Intrinsics.checkNotNullParameter(mTensor5, "w");
            int i3 = mTensor4.shape[0];
            int i4 = mTensor4.shape[1];
            int i5 = mTensor4.shape[2];
            int i6 = mTensor5.shape[0];
            int i7 = (i4 - i6) + 1;
            int i8 = mTensor5.shape[2];
            MTensor mTensor6 = new MTensor(new int[]{i3, i7, i8});
            float[] fArr = mTensor4.data;
            float[] fArr2 = mTensor6.data;
            float[] fArr3 = mTensor5.data;
            if (i3 > 0) {
                int i9 = 0;
                while (true) {
                    int i10 = i9 + 1;
                    if (i8 > 0) {
                        int i11 = 0;
                        while (true) {
                            int i12 = i11 + 1;
                            if (i7 > 0) {
                                int i13 = 0;
                                while (true) {
                                    cls = cls2;
                                    int i14 = i13 + 1;
                                    float f2 = 0.0f;
                                    if (i6 > 0) {
                                        int i15 = 0;
                                        while (true) {
                                            mTensor3 = mTensor6;
                                            int i16 = i15 + 1;
                                            if (i5 > 0) {
                                                int i17 = 0;
                                                while (true) {
                                                    i2 = i3;
                                                    int i18 = i17 + 1;
                                                    try {
                                                        f2 = (fArr[((i15 + i13) * i5) + (i4 * i5 * i9) + i17] * fArr3[(((i15 * i5) + i17) * i8) + i11]) + f2;
                                                        if (i18 >= i5) {
                                                            break;
                                                        }
                                                        i17 = i18;
                                                        i3 = i2;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        CrashShieldHandler.handleThrowable(th, cls);
                                                        return null;
                                                    }
                                                }
                                            } else {
                                                i2 = i3;
                                            }
                                            if (i16 >= i6) {
                                                break;
                                            }
                                            i15 = i16;
                                            mTensor6 = mTensor3;
                                            i3 = i2;
                                        }
                                    } else {
                                        i2 = i3;
                                        mTensor3 = mTensor6;
                                    }
                                    fArr2[GeneratedOutlineSupport.outline7(i13, i8, i7 * i8 * i9, i11)] = f2;
                                    if (i14 >= i7) {
                                        break;
                                    }
                                    i13 = i14;
                                    cls2 = cls;
                                    mTensor6 = mTensor3;
                                    i3 = i2;
                                }
                            } else {
                                cls = cls2;
                                i2 = i3;
                                mTensor3 = mTensor6;
                            }
                            if (i12 >= i8) {
                                break;
                            }
                            i11 = i12;
                            cls2 = cls;
                            mTensor6 = mTensor3;
                            i3 = i2;
                        }
                        i = i2;
                    } else {
                        cls = cls2;
                        mTensor3 = mTensor6;
                        i = i3;
                    }
                    if (i10 >= i) {
                        break;
                    }
                    i3 = i;
                    i9 = i10;
                    cls2 = cls;
                    mTensor6 = mTensor3;
                }
            } else {
                mTensor3 = mTensor6;
            }
            return mTensor3;
        } catch (Throwable th2) {
            th = th2;
            cls = cls2;
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final MTensor dense(MTensor mTensor, MTensor mTensor2, MTensor mTensor3) {
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor, "x");
            Intrinsics.checkNotNullParameter(mTensor2, "w");
            Intrinsics.checkNotNullParameter(mTensor3, "b");
            int i = mTensor.shape[0];
            int i2 = mTensor3.shape[0];
            MTensor mul = mul(mTensor, mTensor2);
            float[] fArr = mTensor3.data;
            float[] fArr2 = mul.data;
            if (i > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    if (i2 > 0) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5 + 1;
                            int i7 = (i3 * i2) + i5;
                            fArr2[i7] = fArr2[i7] + fArr[i5];
                            if (i6 >= i2) {
                                break;
                            }
                            i5 = i6;
                        }
                    }
                    if (i4 >= i) {
                        break;
                    }
                    i3 = i4;
                }
            }
            return mul;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final MTensor embedding(String[] strArr, int i, MTensor mTensor) {
        String[] strArr2 = strArr;
        int i2 = i;
        MTensor mTensor2 = mTensor;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(strArr2, "texts");
            Intrinsics.checkNotNullParameter(mTensor2, "w");
            int length = strArr2.length;
            int i3 = mTensor2.shape[1];
            MTensor mTensor3 = new MTensor(new int[]{length, i2, i3});
            float[] fArr = mTensor3.data;
            float[] fArr2 = mTensor2.data;
            if (length > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    int[] vectorize = Utils.INSTANCE.vectorize(strArr2[i4], i2);
                    if (i2 > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            System.arraycopy(fArr2, vectorize[i6] * i3, fArr, (i6 * i3) + (i3 * i2 * i4), i3);
                            if (i7 >= i2) {
                                break;
                            }
                            i6 = i7;
                        }
                    }
                    if (i5 >= length) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return mTensor3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void flatten(MTensor mTensor, int i) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(mTensor, "x");
                if (i < mTensor.shape.length) {
                    int length = mTensor.shape.length;
                    int i2 = 1;
                    if (i < length) {
                        int i3 = i;
                        while (true) {
                            int i4 = i3 + 1;
                            i2 *= mTensor.shape[i3];
                            if (i4 >= length) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    int[] iArr = new int[(i + 1)];
                    int i5 = 0;
                    if (i > 0) {
                        while (true) {
                            int i6 = i5 + 1;
                            iArr[i5] = mTensor.shape[i5];
                            if (i6 >= i) {
                                break;
                            }
                            i5 = i6;
                        }
                    }
                    iArr[i] = i2;
                    mTensor.reshape(iArr);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final MTensor maxPool1D(MTensor mTensor, int i) {
        int i2;
        MTensor mTensor2 = mTensor;
        int i3 = i;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor2, "x");
            int i4 = mTensor2.shape[0];
            int i5 = mTensor2.shape[1];
            int i6 = mTensor2.shape[2];
            int i7 = (i5 - i3) + 1;
            MTensor mTensor3 = new MTensor(new int[]{i4, i7, i6});
            float[] fArr = mTensor2.data;
            float[] fArr2 = mTensor3.data;
            if (i4 > 0) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (i6 > 0) {
                        int i10 = 0;
                        while (true) {
                            int i11 = i10 + 1;
                            if (i7 > 0) {
                                int i12 = 0;
                                while (true) {
                                    int i13 = i12 + 1;
                                    int i14 = i12 * i6;
                                    int i15 = (i8 * i7 * i6) + i14 + i10;
                                    int i16 = (i8 * i5 * i6) + i14 + i10;
                                    fArr2[i15] = Float.MIN_VALUE;
                                    if (i3 > 0) {
                                        int i17 = 0;
                                        while (true) {
                                            int i18 = i17 + 1;
                                            i2 = i5;
                                            fArr2[i15] = Math.max(fArr2[i15], fArr[(i17 * i6) + i16]);
                                            if (i18 >= i3) {
                                                break;
                                            }
                                            i17 = i18;
                                            i5 = i2;
                                        }
                                    } else {
                                        i2 = i5;
                                    }
                                    if (i13 >= i7) {
                                        break;
                                    }
                                    i12 = i13;
                                    i5 = i2;
                                }
                            } else {
                                i2 = i5;
                            }
                            if (i11 >= i6) {
                                break;
                            }
                            i10 = i11;
                            i5 = i2;
                        }
                    } else {
                        i2 = i5;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                    i8 = i9;
                    i5 = i2;
                }
            }
            return mTensor3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final MTensor mul(MTensor mTensor, MTensor mTensor2) {
        MTensor mTensor3 = mTensor;
        MTensor mTensor4 = mTensor2;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor3, "x");
            Intrinsics.checkNotNullParameter(mTensor4, "w");
            int i = mTensor3.shape[0];
            int i2 = mTensor4.shape[0];
            int i3 = mTensor4.shape[1];
            MTensor mTensor5 = new MTensor(new int[]{i, i3});
            float[] fArr = mTensor3.data;
            float[] fArr2 = mTensor4.data;
            float[] fArr3 = mTensor5.data;
            if (i > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i3 > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            int i8 = (i4 * i3) + i6;
                            fArr3[i8] = 0.0f;
                            if (i2 > 0) {
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9 + 1;
                                    fArr3[i8] = (fArr[(i4 * i2) + i9] * fArr2[(i9 * i3) + i6]) + fArr3[i8];
                                    if (i10 >= i2) {
                                        break;
                                    }
                                    i9 = i10;
                                }
                            }
                            if (i7 >= i3) {
                                break;
                            }
                            i6 = i7;
                        }
                    }
                    if (i5 >= i) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return mTensor5;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void relu(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(mTensor, "x");
                float[] fArr = mTensor.data;
                int i = 0;
                int length = fArr.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        if (fArr[i] < 0.0f) {
                            fArr[i] = 0.0f;
                        }
                        if (i2 > length) {
                            break;
                        }
                        i = i2;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void softmax(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(mTensor, "x");
                int i = 0;
                int i2 = mTensor.shape[0];
                int i3 = mTensor.shape[1];
                float[] fArr = mTensor.data;
                if (i2 > 0) {
                    while (true) {
                        int i4 = i + 1;
                        int i5 = i * i3;
                        int i6 = i5 + i3;
                        float f2 = Float.MIN_VALUE;
                        float f3 = 0.0f;
                        if (i5 < i6) {
                            int i7 = i5;
                            while (true) {
                                int i8 = i7 + 1;
                                if (fArr[i7] > f2) {
                                    f2 = fArr[i7];
                                }
                                if (i8 >= i6) {
                                    break;
                                }
                                i7 = i8;
                            }
                        }
                        if (i5 < i6) {
                            int i9 = i5;
                            while (true) {
                                int i10 = i9 + 1;
                                fArr[i9] = (float) Math.exp((double) (fArr[i9] - f2));
                                f3 += fArr[i9];
                                if (i10 >= i6) {
                                    break;
                                }
                                i9 = i10;
                            }
                        }
                        if (i5 < i6) {
                            while (true) {
                                int i11 = i5 + 1;
                                fArr[i5] = fArr[i5] / f3;
                                if (i11 >= i6) {
                                    break;
                                }
                                i5 = i11;
                            }
                        }
                        if (i4 >= i2) {
                            break;
                        }
                        i = i4;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final MTensor transpose2D(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor, "x");
            int i = mTensor.shape[0];
            int i2 = mTensor.shape[1];
            MTensor mTensor2 = new MTensor(new int[]{i2, i});
            float[] fArr = mTensor.data;
            float[] fArr2 = mTensor2.data;
            if (i > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    if (i2 > 0) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5 + 1;
                            fArr2[(i5 * i) + i3] = fArr[(i3 * i2) + i5];
                            if (i6 >= i2) {
                                break;
                            }
                            i5 = i6;
                        }
                    }
                    if (i4 >= i) {
                        break;
                    }
                    i3 = i4;
                }
            }
            return mTensor2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final MTensor transpose3D(MTensor mTensor) {
        MTensor mTensor2 = mTensor;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor2, "x");
            int i = mTensor2.shape[0];
            int i2 = mTensor2.shape[1];
            int i3 = mTensor2.shape[2];
            MTensor mTensor3 = new MTensor(new int[]{i3, i2, i});
            float[] fArr = mTensor2.data;
            float[] fArr2 = mTensor3.data;
            if (i > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i2 > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            if (i3 > 0) {
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8 + 1;
                                    fArr2[GeneratedOutlineSupport.outline7(i6, i, i8 * i * i2, i4)] = fArr[(i6 * i3) + (i4 * i2 * i3) + i8];
                                    if (i9 >= i3) {
                                        break;
                                    }
                                    i8 = i9;
                                }
                            }
                            if (i7 >= i2) {
                                break;
                            }
                            i6 = i7;
                        }
                    }
                    if (i5 >= i) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return mTensor3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
