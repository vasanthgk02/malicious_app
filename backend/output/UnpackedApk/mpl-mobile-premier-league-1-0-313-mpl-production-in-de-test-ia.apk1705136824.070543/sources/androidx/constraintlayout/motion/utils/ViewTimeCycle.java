package androidx.constraintlayout.motion.utils;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ViewTimeCycle extends TimeCycleSplineSet {

    public static class AlphaSet extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setAlpha(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        public String mAttributeName;
        public float[] mCache;
        public SparseArray<ConstraintAttribute> mConstraintAttributeList;
        public float[] mTempValues;
        public SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setPoint(int i, float f2, float f3, int i2, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            View view2 = view;
            long j2 = j;
            this.mCurveFit.getPos((double) f2, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j3 = j2 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(view2, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f5 = (float) ((((((double) j3) * 1.0E-9d) * ((double) f3)) + ((double) this.last_cycle)) % 1.0d);
            this.last_cycle = f5;
            this.last_time = j2;
            float calcWave = calcWave(f5);
            this.mContinue = false;
            for (int i = 0; i < this.mCache.length; i++) {
                this.mContinue |= ((double) this.mTempValues[i]) != 0.0d;
                this.mCache[i] = (this.mTempValues[i] * calcWave) + f4;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view2, this.mCache);
            if (f3 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i2];
            this.mCache = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i2;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i3);
                float[] valueAt = this.mWaveProperties.valueAt(i3);
                dArr[i3] = ((double) keyAt) * 0.01d;
                this.mConstraintAttributeList.valueAt(i3).getValuesToInterpolate(this.mTempValues);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
                dArr2[i3][numberOfInterpolatedValues] = (double) valueAt[0];
                dArr2[i3][numberOfInterpolatedValues + 1] = (double) valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }
    }

    public static class ElevationSet extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setElevation(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    public static class ProgressSet extends ViewTimeCycle {
        public boolean mNoMethod = false;

        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f2, j, view, keyCache));
            } else if (this.mNoMethod) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f2, j, view, keyCache))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return this.mContinue;
        }
    }

    public static class RotationSet extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setRotation(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class RotationXset extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setRotationX(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class RotationYset extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setRotationY(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class ScaleXset extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setScaleX(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class ScaleYset extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setScaleY(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class TranslationXset extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setTranslationX(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class TranslationYset extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setTranslationY(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class TranslationZset extends ViewTimeCycle {
        public boolean setProperty(View view, float f2, long j, KeyCache keyCache) {
            view.setTranslationZ(get(f2, j, view, keyCache));
            return this.mContinue;
        }
    }

    public float get(float f2, long j, View view, KeyCache keyCache) {
        long j2 = j;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.mCurveFit.getPos((double) f2, this.mCache);
        float[] fArr = this.mCache;
        boolean z = true;
        float f3 = fArr[1];
        int i = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache2.getFloatValue(view2, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f4 = (float) ((((((double) (j2 - this.last_time)) * 1.0E-9d) * ((double) f3)) + ((double) this.last_cycle)) % 1.0d);
        this.last_cycle = f4;
        String str = this.mType;
        if (!keyCache2.map.containsKey(view2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, new float[]{f4});
            keyCache2.map.put(view2, hashMap);
        } else {
            HashMap hashMap2 = keyCache2.map.get(view2);
            if (hashMap2 == null) {
                hashMap2 = new HashMap();
            }
            if (!hashMap2.containsKey(str)) {
                hashMap2.put(str, new float[]{f4});
                keyCache2.map.put(view2, hashMap2);
            } else {
                float[] fArr2 = (float[]) hashMap2.get(str);
                if (fArr2 == null) {
                    fArr2 = new float[0];
                }
                if (fArr2.length <= 0) {
                    fArr2 = Arrays.copyOf(fArr2, 1);
                }
                fArr2[0] = f4;
                hashMap2.put(str, fArr2);
            }
        }
        this.last_time = j2;
        float f5 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f5) + this.mCache[2];
        if (f5 == 0.0f && i == 0) {
            z = false;
        }
        this.mContinue = z;
        return calcWave;
    }

    public abstract boolean setProperty(View view, float f2, long j, KeyCache keyCache);
}
