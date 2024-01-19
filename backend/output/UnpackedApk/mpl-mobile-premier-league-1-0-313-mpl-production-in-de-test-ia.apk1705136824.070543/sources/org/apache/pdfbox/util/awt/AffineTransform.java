package org.apache.pdfbox.util.awt;

import android.graphics.Matrix;
import android.graphics.PointF;

public class AffineTransform {
    public double m00;
    public double m01;
    public double m02;
    public double m10;
    public double m11;
    public double m12;

    public AffineTransform() {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
    }

    public static AffineTransform getScaleInstance(double d2, double d3) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToScale(d2, d3);
        return affineTransform;
    }

    public static AffineTransform getTranslateInstance(double d2, double d3) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.m02 = d2;
        affineTransform.m12 = d3;
        return affineTransform;
    }

    public void getMatrix(double[] dArr) {
        dArr[0] = this.m00;
        dArr[1] = this.m10;
        dArr[2] = this.m01;
        dArr[3] = this.m11;
        dArr[4] = this.m02;
        dArr[5] = this.m12;
    }

    public double getScaleX() {
        return this.m00;
    }

    public double getScaleY() {
        return this.m11;
    }

    public double getShearX() {
        return this.m01;
    }

    public double getShearY() {
        return this.m10;
    }

    public double getTranslateX() {
        return this.m02;
    }

    public double getTranslateY() {
        return this.m12;
    }

    public boolean isIdentity() {
        return this.m00 == 1.0d && this.m01 == 0.0d && this.m02 == 0.0d && this.m10 == 0.0d && this.m11 == 1.0d && this.m12 == 0.0d;
    }

    public void rotate(double d2) {
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        double d3 = this.m00;
        double d4 = this.m01;
        double d5 = (d4 * sin) + (d3 * cos);
        double d6 = -sin;
        double d7 = (d4 * cos) + (d3 * d6);
        double d8 = this.m10;
        double d9 = d7;
        double d10 = this.m11;
        double d11 = sin * d10;
        this.m00 = d5;
        this.m01 = d9;
        this.m10 = d11 + (d8 * cos);
        this.m11 = (d10 * cos) + (d8 * d6);
    }

    public void scale(double d2, double d3) {
        this.m00 *= d2;
        this.m01 *= d3;
        this.m10 *= d2;
        this.m11 *= d3;
    }

    public void setToScale(double d2, double d3) {
        this.m00 = d2;
        this.m12 = 0.0d;
        this.m10 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m11 = d3;
    }

    public void setTransform(AffineTransform affineTransform) {
        this.m00 = affineTransform.m00;
        this.m01 = affineTransform.m01;
        this.m02 = affineTransform.m02;
        this.m10 = affineTransform.m10;
        this.m11 = affineTransform.m11;
        this.m12 = affineTransform.m12;
    }

    public Matrix toMatrix() {
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{(float) this.m00, (float) this.m01, (float) this.m02, (float) this.m10, (float) this.m11, (float) this.m12, 0.0f, 0.0f, 1.0f});
        return matrix;
    }

    public PointF transform(PointF pointF, PointF pointF2) {
        if (pointF2 == null) {
            pointF2 = new PointF();
        }
        double d2 = (double) pointF.x;
        double d3 = (double) pointF.y;
        pointF2.set((float) ((this.m01 * d3) + (this.m00 * d2) + this.m02), (float) ((this.m11 * d3) + (this.m10 * d2) + this.m12));
        return pointF2;
    }

    public void translate(double d2, double d3) {
        this.m02 = (this.m01 * d3) + (this.m00 * d2) + this.m02;
        this.m12 = (d3 * this.m11) + (d2 * this.m10) + this.m12;
    }

    public AffineTransform(AffineTransform affineTransform) {
        setTransform(affineTransform);
    }

    public AffineTransform(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.m00 = d2;
        this.m10 = d3;
        this.m01 = d4;
        this.m11 = d5;
        this.m02 = d6;
        this.m12 = d7;
    }

    public void transform(double[] dArr, int i, double[] dArr2, int i2, int i3) {
        if (dArr == dArr2 && i2 > i && i3 > 1) {
            int i4 = i3 * 2;
            if (i + i4 > i2) {
                double[] dArr3 = new double[i4];
                System.arraycopy(dArr, i, dArr3, 0, i4);
                dArr = dArr3;
            }
        }
        while (true) {
            i3--;
            if (i3 >= 0) {
                int i5 = i + 1;
                double d2 = dArr[i];
                i = i5 + 1;
                double d3 = dArr[i5];
                int i6 = i2 + 1;
                dArr2[i2] = (this.m01 * d3) + (this.m00 * d2) + this.m02;
                i2 = i6 + 1;
                dArr2[i6] = (this.m11 * d3) + (this.m10 * d2) + this.m12;
            } else {
                return;
            }
        }
    }

    public AffineTransform(double[] dArr) {
        this.m00 = dArr[0];
        this.m10 = dArr[1];
        this.m01 = dArr[2];
        this.m11 = dArr[3];
        if (dArr.length >= 6) {
            this.m02 = dArr[4];
            this.m12 = dArr[5];
        }
    }

    public void transform(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        float[] fArr3 = fArr;
        int i4 = i;
        float[] fArr4 = fArr2;
        int i5 = i2;
        int i6 = i3;
        if (fArr3 == fArr4 && i5 > i4 && i6 > 1) {
            int i7 = i6 * 2;
            if (i4 + i7 > i5) {
                float[] fArr5 = new float[i7];
                System.arraycopy(fArr3, i4, fArr5, 0, i7);
                fArr3 = fArr5;
            }
        }
        while (true) {
            i6--;
            if (i6 >= 0) {
                int i8 = i4 + 1;
                int i9 = i5 + 1;
                double d2 = (double) fArr3[i4];
                float[] fArr6 = fArr3;
                double d3 = (double) fArr3[i8];
                fArr4[i5] = (float) ((this.m01 * d3) + (this.m00 * d2) + this.m02);
                i5 = i9 + 1;
                fArr4[i9] = (float) ((this.m11 * d3) + (this.m10 * d2) + this.m12);
                fArr3 = fArr6;
                i4 = i8 + 1;
            } else {
                return;
            }
        }
    }

    public float[] transform(float[] fArr, float[] fArr2) {
        if (fArr2 == null) {
            fArr2 = new float[2];
        }
        float f2 = fArr[0];
        double d2 = (double) f2;
        double d3 = (double) fArr[1];
        double d4 = this.m01 * d3;
        double d5 = this.m10 * d2;
        fArr2[0] = (float) (d4 + (this.m00 * d2) + this.m02);
        fArr2[1] = (float) ((this.m11 * d3) + d5 + this.m12);
        return fArr2;
    }

    public AffineTransform(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        this.m00 = (double) fArr[0];
        this.m01 = (double) fArr[1];
        this.m02 = (double) fArr[2];
        this.m10 = (double) fArr[3];
        this.m11 = (double) fArr[4];
        this.m12 = (double) fArr[5];
    }
}
