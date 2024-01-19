package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {
    public boolean containsIncompatibleShadowOp;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    public final List<PathOperation> operations = new ArrayList();
    public final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    public static class ArcShadowOperation extends ShadowCompatOperation {
        public final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            ShadowRenderer shadowRenderer2 = shadowRenderer;
            int i2 = i;
            Canvas canvas2 = canvas;
            PathArcOperation pathArcOperation = this.operation;
            float f2 = pathArcOperation.startAngle;
            float f3 = pathArcOperation.sweepAngle;
            PathArcOperation pathArcOperation2 = this.operation;
            RectF rectF = new RectF(pathArcOperation2.left, pathArcOperation2.top, pathArcOperation2.right, pathArcOperation2.bottom);
            boolean z = f3 < 0.0f;
            Path path = shadowRenderer2.scratch;
            if (z) {
                int[] iArr = ShadowRenderer.cornerColors;
                iArr[0] = 0;
                iArr[1] = shadowRenderer2.shadowEndColor;
                iArr[2] = shadowRenderer2.shadowMiddleColor;
                iArr[3] = shadowRenderer2.shadowStartColor;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f2, f3);
                path.close();
                float f4 = (float) (-i2);
                rectF.inset(f4, f4);
                int[] iArr2 = ShadowRenderer.cornerColors;
                iArr2[0] = 0;
                iArr2[1] = shadowRenderer2.shadowStartColor;
                iArr2[2] = shadowRenderer2.shadowMiddleColor;
                iArr2[3] = shadowRenderer2.shadowEndColor;
            }
            float width = rectF.width() / 2.0f;
            if (width > 0.0f) {
                float f5 = 1.0f - (((float) i2) / width);
                float[] fArr = ShadowRenderer.cornerPositions;
                fArr[1] = f5;
                fArr[2] = ((1.0f - f5) / 2.0f) + f5;
                RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), width, ShadowRenderer.cornerColors, ShadowRenderer.cornerPositions, TileMode.CLAMP);
                shadowRenderer2.cornerShadowPaint.setShader(radialGradient);
                canvas.save();
                canvas2.concat(matrix);
                canvas2.scale(1.0f, rectF.height() / rectF.width());
                if (!z) {
                    canvas2.clipPath(path, Op.DIFFERENCE);
                    canvas2.drawPath(path, shadowRenderer2.transparentPaint);
                }
                canvas.drawArc(rectF, f2, f3, true, shadowRenderer2.cornerShadowPaint);
                canvas.restore();
            }
        }
    }

    public static class LineShadowOperation extends ShadowCompatOperation {
        public final PathLineOperation operation;
        public final float startX;
        public final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f2, float f3) {
            this.operation = pathLineOperation;
            this.startX = f2;
            this.startY = f3;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            PathLineOperation pathLineOperation = this.operation;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (pathLineOperation.y - this.startY), (double) (pathLineOperation.x - this.startX)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.startX, this.startY);
            matrix2.preRotate(getAngle());
            if (shadowRenderer != null) {
                rectF.bottom += (float) i;
                rectF.offset(0.0f, (float) (-i));
                int[] iArr = ShadowRenderer.edgeColors;
                iArr[0] = shadowRenderer.shadowEndColor;
                iArr[1] = shadowRenderer.shadowMiddleColor;
                iArr[2] = shadowRenderer.shadowStartColor;
                Paint paint = shadowRenderer.edgeShadowPaint;
                float f2 = rectF.left;
                LinearGradient linearGradient = new LinearGradient(f2, rectF.top, f2, rectF.bottom, ShadowRenderer.edgeColors, ShadowRenderer.edgePositions, TileMode.CLAMP);
                paint.setShader(linearGradient);
                canvas.save();
                canvas.concat(matrix2);
                canvas.drawRect(rectF, shadowRenderer.edgeShadowPaint);
                canvas.restore();
                return;
            }
            throw null;
        }

        public float getAngle() {
            PathLineOperation pathLineOperation = this.operation;
            return (float) Math.toDegrees(Math.atan((double) ((pathLineOperation.y - this.startY) / (pathLineOperation.x - this.startX))));
        }
    }

    public static class PathArcOperation extends PathOperation {
        public static final RectF rectF = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f2, float f3, float f4, float f5) {
            this.left = f2;
            this.top = f3;
            this.right = f4;
            this.bottom = f5;
        }

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            rectF.set(this.left, this.top, this.right, this.bottom);
            path.arcTo(rectF, this.startAngle, this.sweepAngle, false);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        public float x;
        public float y;

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.x, this.y);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {
        public final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix2, Path path);
    }

    public static abstract class ShadowCompatOperation {
        public static final Matrix IDENTITY_MATRIX = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas);
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    public void addArc(float f2, float f3, float f4, float f5, float f6, float f7) {
        PathArcOperation pathArcOperation = new PathArcOperation(f2, f3, f4, f5);
        pathArcOperation.startAngle = f6;
        pathArcOperation.sweepAngle = f7;
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        addConnectingShadowIfNecessary(f6);
        this.shadowCompatOperations.add(arcShadowOperation);
        this.currentShadowAngle = f9;
        double d2 = (double) f8;
        this.endX = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.endY = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void addConnectingShadowIfNecessary(float f2) {
        float f3 = this.currentShadowAngle;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.endX;
                float f6 = this.endY;
                PathArcOperation pathArcOperation = new PathArcOperation(f5, f6, f5, f6);
                pathArcOperation.startAngle = this.currentShadowAngle;
                pathArcOperation.sweepAngle = f4;
                this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
                this.currentShadowAngle = f2;
            }
        }
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i = 0; i < size; i++) {
            this.operations.get(i).applyToPath(matrix, path);
        }
    }

    public void lineTo(float f2, float f3) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.x = f2;
        pathLineOperation.y = f3;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, this.endX, this.endY);
        addConnectingShadowIfNecessary(lineShadowOperation.getAngle() + 270.0f);
        this.shadowCompatOperations.add(lineShadowOperation);
        this.currentShadowAngle = lineShadowOperation.getAngle() + 270.0f;
        this.endX = f2;
        this.endY = f3;
    }

    public void reset(float f2, float f3) {
        reset(f2, f3, 270.0f, 0.0f);
    }

    public void reset(float f2, float f3, float f4, float f5) {
        this.startX = f2;
        this.startY = f3;
        this.endX = f2;
        this.endY = f3;
        this.currentShadowAngle = f4;
        this.endShadowAngle = (f4 + f5) % 360.0f;
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }
}
