package org.apache.pdfbox.util;

import android.graphics.PointF;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Array;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.util.awt.AffineTransform;

public final class Matrix implements Cloneable {
    public static final float[] DEFAULT_SINGLE = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public float[] single;

    public Matrix() {
        float[] fArr = DEFAULT_SINGLE;
        float[] fArr2 = new float[fArr.length];
        this.single = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
    }

    public static Matrix getRotateInstance(double d2, float f2, float f3) {
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        Matrix matrix = new Matrix();
        float[] fArr = matrix.single;
        fArr[0] = cos;
        fArr[1] = sin;
        fArr[3] = -sin;
        fArr[4] = cos;
        fArr[6] = f2;
        fArr[7] = f3;
        return matrix;
    }

    public static Matrix getScaleInstance(float f2, float f3) {
        Matrix matrix = new Matrix();
        float[] fArr = matrix.single;
        fArr[0] = f2;
        fArr[4] = f3;
        return matrix;
    }

    public static Matrix getTranslateInstance(float f2, float f3) {
        Matrix matrix = new Matrix();
        float[] fArr = matrix.single;
        fArr[6] = f2;
        fArr[7] = f3;
        return matrix;
    }

    public static Matrix getTranslatingInstance(float f2, float f3) {
        return getTranslateInstance(f2, f3);
    }

    public void concatenate(Matrix matrix) {
        matrix.multiply(this, this);
    }

    public AffineTransform createAffineTransform() {
        float[] fArr = this.single;
        AffineTransform affineTransform = new AffineTransform((double) fArr[0], (double) fArr[1], (double) fArr[3], (double) fArr[4], (double) fArr[6], (double) fArr[7]);
        return affineTransform;
    }

    @Deprecated
    public Matrix extractScaling() {
        Matrix matrix = new Matrix();
        float[] fArr = matrix.single;
        float[] fArr2 = this.single;
        fArr[0] = fArr2[0];
        fArr[4] = fArr2[4];
        return matrix;
    }

    @Deprecated
    public Matrix extractTranslating() {
        Matrix matrix = new Matrix();
        float[] fArr = matrix.single;
        float[] fArr2 = this.single;
        fArr[6] = fArr2[6];
        fArr[7] = fArr2[7];
        return matrix;
    }

    public float getScaleX() {
        return this.single[0];
    }

    public float getScaleY() {
        return this.single[4];
    }

    public float getScalingFactorX() {
        float[] fArr = this.single;
        float f2 = fArr[0];
        if (fArr[1] == 0.0f && fArr[3] == 0.0f) {
            return f2;
        }
        return (float) Math.sqrt(Math.pow((double) this.single[1], 2.0d) + Math.pow((double) this.single[0], 2.0d));
    }

    public float getScalingFactorY() {
        float[] fArr = this.single;
        float f2 = fArr[4];
        if (fArr[1] == 0.0f && fArr[3] == 0.0f) {
            return f2;
        }
        return (float) Math.sqrt(Math.pow((double) this.single[4], 2.0d) + Math.pow((double) this.single[3], 2.0d));
    }

    public float getShearX() {
        return this.single[3];
    }

    public float getShearY() {
        return this.single[1];
    }

    public float getTranslateX() {
        return this.single[6];
    }

    public float getTranslateY() {
        return this.single[7];
    }

    public float getValue(int i, int i2) {
        return this.single[(i * 3) + i2];
    }

    public float[][] getValues() {
        float[][] fArr = (float[][]) Array.newInstance(float.class, new int[]{3, 3});
        float[] fArr2 = fArr[0];
        float[] fArr3 = this.single;
        fArr2[0] = fArr3[0];
        fArr[0][1] = fArr3[1];
        fArr[0][2] = fArr3[2];
        fArr[1][0] = fArr3[3];
        fArr[1][1] = fArr3[4];
        fArr[1][2] = fArr3[5];
        fArr[2][0] = fArr3[6];
        fArr[2][1] = fArr3[7];
        fArr[2][2] = fArr3[8];
        return fArr;
    }

    @Deprecated
    public double[][] getValuesAsDouble() {
        double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        double[] dArr2 = dArr[0];
        float[] fArr = this.single;
        dArr2[0] = (double) fArr[0];
        dArr[0][1] = (double) fArr[1];
        dArr[0][2] = (double) fArr[2];
        dArr[1][0] = (double) fArr[3];
        dArr[1][1] = (double) fArr[4];
        dArr[1][2] = (double) fArr[5];
        dArr[2][0] = (double) fArr[6];
        dArr[2][1] = (double) fArr[7];
        dArr[2][2] = (double) fArr[8];
        return dArr;
    }

    @Deprecated
    public float getXPosition() {
        return this.single[6];
    }

    @Deprecated
    public float getYPosition() {
        return this.single[7];
    }

    public Matrix multiply(Matrix matrix) {
        return multiply(matrix, new Matrix());
    }

    @Deprecated
    public void reset() {
        float[] fArr = DEFAULT_SINGLE;
        System.arraycopy(fArr, 0, this.single, 0, fArr.length);
    }

    public void rotate(double d2) {
        concatenate(getRotateInstance(d2, 0.0f, 0.0f));
    }

    public void scale(float f2, float f3) {
        concatenate(getScaleInstance(f2, f3));
    }

    @Deprecated
    public void setFromAffineTransform(AffineTransform affineTransform) {
        this.single[0] = (float) affineTransform.getScaleX();
        this.single[1] = (float) affineTransform.getShearY();
        this.single[3] = (float) affineTransform.getShearX();
        this.single[4] = (float) affineTransform.getScaleY();
        this.single[6] = (float) affineTransform.getTranslateX();
        this.single[7] = (float) affineTransform.getTranslateY();
    }

    public void setValue(int i, int i2, float f2) {
        this.single[(i * 3) + i2] = f2;
    }

    public COSArray toCOSArray() {
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) new COSFloat(0.0f));
        cOSArray.add((COSBase) new COSFloat(1.0f));
        cOSArray.add((COSBase) new COSFloat(3.0f));
        cOSArray.add((COSBase) new COSFloat(4.0f));
        cOSArray.add((COSBase) new COSFloat(6.0f));
        cOSArray.add((COSBase) new COSFloat(7.0f));
        return cOSArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("[");
        stringBuffer.append(this.single[0] + ",");
        stringBuffer.append(this.single[1] + ",");
        stringBuffer.append(this.single[3] + ",");
        stringBuffer.append(this.single[4] + ",");
        stringBuffer.append(this.single[6] + ",");
        stringBuffer.append(this.single[7] + CMapParser.MARK_END_OF_ARRAY);
        return stringBuffer.toString();
    }

    public void transform(PointF pointF) {
        float f2 = pointF.x;
        float f3 = pointF.y;
        float[] fArr = this.single;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[3];
        float f7 = fArr[4];
        float f8 = fArr[6];
        float f9 = fArr[7];
        pointF.set(GeneratedOutlineSupport.outline4(f6, f3, f4 * f2, f8), (f3 * f7) + (f2 * f5) + f9);
    }

    public PointF transformPoint(double d2, double d3) {
        float[] fArr = this.single;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[3];
        float f5 = fArr[4];
        return new PointF((float) ((((double) f4) * d3) + (((double) f2) * d2) + ((double) fArr[6])), (float) ((d3 * ((double) f5)) + (d2 * ((double) f3)) + ((double) fArr[7])));
    }

    public void translate(Vector vector) {
        concatenate(getTranslateInstance(vector.getX(), vector.getY()));
    }

    public static Matrix concatenate(Matrix matrix, Matrix matrix2) {
        Matrix clone = matrix.clone();
        clone.concatenate(matrix2);
        return clone;
    }

    public Matrix clone() {
        Matrix matrix = new Matrix();
        System.arraycopy(this.single, 0, matrix.single, 0, 9);
        return matrix;
    }

    public Matrix multiply(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = matrix;
        Matrix matrix4 = matrix2 == null ? new Matrix() : matrix2;
        if (matrix3 != null) {
            float[] fArr = matrix3.single;
            if (fArr != null) {
                float[] fArr2 = this.single;
                if (this == matrix4) {
                    float[] fArr3 = new float[fArr2.length];
                    System.arraycopy(fArr2, 0, fArr3, 0, fArr2.length);
                    fArr2 = fArr3;
                }
                if (matrix3 == matrix4) {
                    float[] fArr4 = matrix3.single;
                    fArr = new float[fArr4.length];
                    System.arraycopy(fArr4, 0, fArr, 0, fArr4.length);
                }
                float[] fArr5 = matrix4.single;
                fArr5[0] = (fArr2[2] * fArr[6]) + (fArr2[1] * fArr[3]) + (fArr2[0] * fArr[0]);
                fArr5[1] = (fArr2[2] * fArr[7]) + (fArr2[1] * fArr[4]) + (fArr2[0] * fArr[1]);
                fArr5[2] = (fArr2[2] * fArr[8]) + (fArr2[1] * fArr[5]) + (fArr2[0] * fArr[2]);
                fArr5[3] = (fArr2[5] * fArr[6]) + (fArr2[4] * fArr[3]) + (fArr2[3] * fArr[0]);
                fArr5[4] = (fArr2[5] * fArr[7]) + (fArr2[4] * fArr[4]) + (fArr2[3] * fArr[1]);
                fArr5[5] = (fArr2[5] * fArr[8]) + (fArr2[4] * fArr[5]) + (fArr2[3] * fArr[2]);
                fArr5[6] = (fArr2[8] * fArr[6]) + (fArr2[7] * fArr[3]) + (fArr2[6] * fArr[0]);
                fArr5[7] = (fArr2[8] * fArr[7]) + (fArr2[7] * fArr[4]) + (fArr2[6] * fArr[1]);
                fArr5[8] = (fArr2[8] * fArr[8]) + (fArr2[7] * fArr[5]) + (fArr2[6] * fArr[2]);
            }
        }
        return matrix4;
    }

    public void translate(float f2, float f3) {
        concatenate(getTranslateInstance(f2, f3));
    }

    public Matrix(COSArray cOSArray) {
        float[] fArr = new float[DEFAULT_SINGLE.length];
        this.single = fArr;
        fArr[0] = ((COSNumber) cOSArray.get(0)).floatValue();
        this.single[1] = ((COSNumber) cOSArray.get(1)).floatValue();
        this.single[3] = ((COSNumber) cOSArray.get(2)).floatValue();
        this.single[4] = ((COSNumber) cOSArray.get(3)).floatValue();
        this.single[6] = ((COSNumber) cOSArray.get(4)).floatValue();
        this.single[7] = ((COSNumber) cOSArray.get(5)).floatValue();
        this.single[8] = 1.0f;
    }

    public Vector transform(Vector vector) {
        float[] fArr = this.single;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[6];
        float f7 = fArr[7];
        float x = vector.getX();
        float y = vector.getY();
        return new Vector(GeneratedOutlineSupport.outline4(f4, y, f2 * x, f6), GeneratedOutlineSupport.outline4(y, f5, x * f3, f7));
    }

    public Matrix(float f2, float f3, float f4, float f5, float f6, float f7) {
        float[] fArr = new float[DEFAULT_SINGLE.length];
        this.single = fArr;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[6] = f6;
        fArr[7] = f7;
        fArr[8] = 1.0f;
    }

    public Matrix(AffineTransform affineTransform) {
        float[] fArr = DEFAULT_SINGLE;
        float[] fArr2 = new float[fArr.length];
        this.single = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        this.single[0] = (float) affineTransform.getScaleX();
        this.single[1] = (float) affineTransform.getShearY();
        this.single[3] = (float) affineTransform.getShearX();
        this.single[4] = (float) affineTransform.getScaleY();
        this.single[6] = (float) affineTransform.getTranslateX();
        this.single[7] = (float) affineTransform.getTranslateY();
    }
}
