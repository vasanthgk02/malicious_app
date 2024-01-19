package androidx.constraintlayout.motion.utils;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewSpline extends SplineSet {

    public static class AlphaSet extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setAlpha((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class CustomSet extends ViewSpline {
        public SparseArray<ConstraintAttribute> mConstraintAttributeList;
        public float[] mTempValues;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            String str2 = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setPoint(int i, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(View view, float f2) {
            this.mCurveFit.getPos((double) f2, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }

        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = ((double) this.mConstraintAttributeList.keyAt(i2)) * 0.01d;
                this.mConstraintAttributeList.valueAt(i2).getValuesToInterpolate(this.mTempValues);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    dArr2[i2][i3] = (double) fArr[i3];
                    i3++;
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }
    }

    public static class ElevationSet extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setElevation((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class PathRotate extends ViewSpline {
        public void setProperty(View view, float f2) {
        }
    }

    public static class PivotXset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setPivotX((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class PivotYset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setPivotY((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class ProgressSet extends ViewSpline {
        public boolean mNoMethod = false;

        public void setProperty(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress((float) this.mCurveFit.getPos((double) f2, 0));
            } else if (!this.mNoMethod) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf((float) this.mCurveFit.getPos((double) f2, 0))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
        }
    }

    public static class RotationSet extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setRotation((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class RotationXset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setRotationX((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class RotationYset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setRotationY((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class ScaleXset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setScaleX((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class ScaleYset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setScaleY((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class TranslationXset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setTranslationX((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class TranslationYset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setTranslationY((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public static class TranslationZset extends ViewSpline {
        public void setProperty(View view, float f2) {
            view.setTranslationZ((float) this.mCurveFit.getPos((double) f2, 0));
        }
    }

    public abstract void setProperty(View view, float f2);
}
