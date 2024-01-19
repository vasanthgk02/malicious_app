package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;

public class MatrixUtils {
    public static final Matrix IDENTITY_MATRIX = new Matrix() {
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix matrix) {
            oops();
            throw null;
        }

        public boolean postRotate(float f2, float f3, float f4) {
            oops();
            throw null;
        }

        public boolean postScale(float f2, float f3, float f4, float f5) {
            oops();
            throw null;
        }

        public boolean postSkew(float f2, float f3, float f4, float f5) {
            oops();
            throw null;
        }

        public boolean postTranslate(float f2, float f3) {
            oops();
            throw null;
        }

        public boolean preConcat(Matrix matrix) {
            oops();
            throw null;
        }

        public boolean preRotate(float f2, float f3, float f4) {
            oops();
            throw null;
        }

        public boolean preScale(float f2, float f3, float f4, float f5) {
            oops();
            throw null;
        }

        public boolean preSkew(float f2, float f3, float f4, float f5) {
            oops();
            throw null;
        }

        public boolean preTranslate(float f2, float f3) {
            oops();
            throw null;
        }

        public void reset() {
            oops();
            throw null;
        }

        public void set(Matrix matrix) {
            oops();
            throw null;
        }

        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            throw null;
        }

        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
            oops();
            throw null;
        }

        public boolean setRectToRect(RectF rectF, RectF rectF2, ScaleToFit scaleToFit) {
            oops();
            throw null;
        }

        public void setRotate(float f2, float f3, float f4) {
            oops();
            throw null;
        }

        public void setScale(float f2, float f3, float f4, float f5) {
            oops();
            throw null;
        }

        public void setSinCos(float f2, float f3, float f4, float f5) {
            oops();
            throw null;
        }

        public void setSkew(float f2, float f3, float f4, float f5) {
            oops();
            throw null;
        }

        public void setTranslate(float f2, float f3) {
            oops();
            throw null;
        }

        public void setValues(float[] fArr) {
            oops();
            throw null;
        }

        public boolean postRotate(float f2) {
            oops();
            throw null;
        }

        public boolean postScale(float f2, float f3) {
            oops();
            throw null;
        }

        public boolean postSkew(float f2, float f3) {
            oops();
            throw null;
        }

        public boolean preRotate(float f2) {
            oops();
            throw null;
        }

        public boolean preScale(float f2, float f3) {
            oops();
            throw null;
        }

        public boolean preSkew(float f2, float f3) {
            oops();
            throw null;
        }

        public void setRotate(float f2) {
            oops();
            throw null;
        }

        public void setScale(float f2, float f3) {
            oops();
            throw null;
        }

        public void setSinCos(float f2, float f3) {
            oops();
            throw null;
        }

        public void setSkew(float f2, float f3) {
            oops();
            throw null;
        }
    };
}
