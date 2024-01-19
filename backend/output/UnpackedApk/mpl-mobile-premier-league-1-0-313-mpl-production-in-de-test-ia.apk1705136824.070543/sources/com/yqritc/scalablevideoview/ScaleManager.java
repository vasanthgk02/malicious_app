package com.yqritc.scalablevideoview;

import android.graphics.Matrix;

public class ScaleManager {
    public Size mVideoSize;
    public Size mViewSize;

    public ScaleManager(Size size, Size size2) {
        this.mViewSize = size;
        this.mVideoSize = size2;
    }

    public final Matrix getCropScale(PivotPoint pivotPoint) {
        Size size = this.mViewSize;
        Size size2 = this.mVideoSize;
        float f2 = ((float) size.mWidth) / ((float) size2.mWidth);
        float f3 = ((float) size.mHeight) / ((float) size2.mHeight);
        float max = Math.max(f2, f3);
        return getMatrix(max / f2, max / f3, pivotPoint);
    }

    public final Matrix getFitScale(PivotPoint pivotPoint) {
        Size size = this.mViewSize;
        Size size2 = this.mVideoSize;
        float f2 = ((float) size.mWidth) / ((float) size2.mWidth);
        float f3 = ((float) size.mHeight) / ((float) size2.mHeight);
        float min = Math.min(f2, f3);
        return getMatrix(min / f2, min / f3, pivotPoint);
    }

    public final Matrix getMatrix(float f2, float f3, float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f3, f4, f5);
        return matrix;
    }

    public final Matrix getOriginalScale(PivotPoint pivotPoint) {
        Size size = this.mVideoSize;
        Size size2 = this.mViewSize;
        return getMatrix(((float) size.mWidth) / ((float) size2.mWidth), ((float) size.mHeight) / ((float) size2.mHeight), pivotPoint);
    }

    public Matrix getScaleMatrix(ScalableType scalableType) {
        Matrix matrix;
        Matrix matrix2;
        Matrix matrix3;
        switch (scalableType.ordinal()) {
            case 0:
                Size size = this.mVideoSize;
                Size size2 = this.mViewSize;
                return getMatrix(((float) size.mWidth) / ((float) size2.mWidth), ((float) size.mHeight) / ((float) size2.mHeight), PivotPoint.LEFT_TOP);
            case 1:
                return getMatrix(1.0f, 1.0f, PivotPoint.LEFT_TOP);
            case 2:
                return getFitScale(PivotPoint.LEFT_TOP);
            case 3:
                return getFitScale(PivotPoint.CENTER);
            case 4:
                return getFitScale(PivotPoint.RIGHT_BOTTOM);
            case 5:
                return getOriginalScale(PivotPoint.LEFT_TOP);
            case 6:
                return getOriginalScale(PivotPoint.LEFT_CENTER);
            case 7:
                return getOriginalScale(PivotPoint.LEFT_BOTTOM);
            case 8:
                return getOriginalScale(PivotPoint.CENTER_TOP);
            case 9:
                return getOriginalScale(PivotPoint.CENTER);
            case 10:
                return getOriginalScale(PivotPoint.CENTER_BOTTOM);
            case 11:
                return getOriginalScale(PivotPoint.RIGHT_TOP);
            case 12:
                return getOriginalScale(PivotPoint.RIGHT_CENTER);
            case 13:
                return getOriginalScale(PivotPoint.RIGHT_BOTTOM);
            case 14:
                return getCropScale(PivotPoint.LEFT_TOP);
            case 15:
                return getCropScale(PivotPoint.LEFT_CENTER);
            case 16:
                return getCropScale(PivotPoint.LEFT_BOTTOM);
            case 17:
                return getCropScale(PivotPoint.CENTER_TOP);
            case 18:
                return getCropScale(PivotPoint.CENTER);
            case 19:
                return getCropScale(PivotPoint.CENTER_BOTTOM);
            case 20:
                return getCropScale(PivotPoint.RIGHT_TOP);
            case 21:
                return getCropScale(PivotPoint.RIGHT_CENTER);
            case 22:
                return getCropScale(PivotPoint.RIGHT_BOTTOM);
            case 23:
                int i = this.mVideoSize.mHeight;
                Size size3 = this.mViewSize;
                if (i > size3.mWidth || i > size3.mHeight) {
                    matrix = getFitScale(PivotPoint.LEFT_TOP);
                } else {
                    matrix = getOriginalScale(PivotPoint.LEFT_TOP);
                }
                return matrix;
            case 24:
                int i2 = this.mVideoSize.mHeight;
                Size size4 = this.mViewSize;
                if (i2 > size4.mWidth || i2 > size4.mHeight) {
                    matrix2 = getFitScale(PivotPoint.CENTER);
                } else {
                    matrix2 = getOriginalScale(PivotPoint.CENTER);
                }
                return matrix2;
            case 25:
                int i3 = this.mVideoSize.mHeight;
                Size size5 = this.mViewSize;
                if (i3 > size5.mWidth || i3 > size5.mHeight) {
                    matrix3 = getFitScale(PivotPoint.RIGHT_BOTTOM);
                } else {
                    matrix3 = getOriginalScale(PivotPoint.RIGHT_BOTTOM);
                }
                return matrix3;
            default:
                return null;
        }
    }

    public final Matrix getMatrix(float f2, float f3, PivotPoint pivotPoint) {
        switch (pivotPoint.ordinal()) {
            case 0:
                return getMatrix(f2, f3, 0.0f, 0.0f);
            case 1:
                return getMatrix(f2, f3, 0.0f, ((float) this.mViewSize.mHeight) / 2.0f);
            case 2:
                return getMatrix(f2, f3, 0.0f, (float) this.mViewSize.mHeight);
            case 3:
                return getMatrix(f2, f3, ((float) this.mViewSize.mWidth) / 2.0f, 0.0f);
            case 4:
                Size size = this.mViewSize;
                return getMatrix(f2, f3, ((float) size.mWidth) / 2.0f, ((float) size.mHeight) / 2.0f);
            case 5:
                Size size2 = this.mViewSize;
                return getMatrix(f2, f3, ((float) size2.mWidth) / 2.0f, (float) size2.mHeight);
            case 6:
                return getMatrix(f2, f3, (float) this.mViewSize.mWidth, 0.0f);
            case 7:
                Size size3 = this.mViewSize;
                return getMatrix(f2, f3, (float) size3.mWidth, ((float) size3.mHeight) / 2.0f);
            case 8:
                Size size4 = this.mViewSize;
                return getMatrix(f2, f3, (float) size4.mWidth, (float) size4.mHeight);
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }
}
