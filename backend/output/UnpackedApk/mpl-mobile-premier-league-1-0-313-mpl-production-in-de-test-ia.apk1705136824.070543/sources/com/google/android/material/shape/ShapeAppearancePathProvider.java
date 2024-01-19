package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.MaterialShapeDrawable.AnonymousClass1;
import com.google.android.material.shape.ShapePath.ShadowCompatOperation;
import java.util.ArrayList;
import java.util.List;

public class ShapeAppearancePathProvider {
    public final Path boundsPath = new Path();
    public final Path cornerPath = new Path();
    public final ShapePath[] cornerPaths = new ShapePath[4];
    public final Matrix[] cornerTransforms = new Matrix[4];
    public boolean edgeIntersectionCheckEnabled = true;
    public final Path edgePath = new Path();
    public final Matrix[] edgeTransforms = new Matrix[4];
    public final Path overlappedEdgePath = new Path();
    public final PointF pointF = new PointF();
    public final float[] scratch = new float[2];
    public final float[] scratch2 = new float[2];
    public final ShapePath shapePath = new ShapePath();

    public static class Lazy {
        public static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();
    }

    public interface PathListener {
    }

    public ShapeAppearancePathProvider() {
        for (int i = 0; i < 4; i++) {
            this.cornerPaths[i] = new ShapePath();
            this.cornerTransforms[i] = new Matrix();
            this.edgeTransforms[i] = new Matrix();
        }
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, Path path) {
        calculatePath(shapeAppearanceModel, f2, rectF, null, path);
    }

    public final boolean pathOverlapsCorner(Path path, int i) {
        this.cornerPath.reset();
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], this.cornerPath);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.cornerPath.computeBounds(rectF, true);
        path.op(this.cornerPath, Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return false;
        }
        return true;
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, PathListener pathListener, Path path) {
        float f3;
        EdgeTreatment edgeTreatment;
        CornerSize cornerSize;
        CornerTreatment cornerTreatment;
        ShapeAppearanceModel shapeAppearanceModel2 = shapeAppearanceModel;
        float f4 = f2;
        RectF rectF2 = rectF;
        Path path2 = path;
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF2, Direction.CW);
        char c2 = 0;
        int i = 0;
        while (i < 4) {
            if (i == 1) {
                cornerSize = shapeAppearanceModel2.bottomRightCornerSize;
            } else if (i == 2) {
                cornerSize = shapeAppearanceModel2.bottomLeftCornerSize;
            } else if (i != 3) {
                cornerSize = shapeAppearanceModel2.topRightCornerSize;
            } else {
                cornerSize = shapeAppearanceModel2.topLeftCornerSize;
            }
            if (i == 1) {
                cornerTreatment = shapeAppearanceModel2.bottomRightCorner;
            } else if (i == 2) {
                cornerTreatment = shapeAppearanceModel2.bottomLeftCorner;
            } else if (i != 3) {
                cornerTreatment = shapeAppearanceModel2.topRightCorner;
            } else {
                cornerTreatment = shapeAppearanceModel2.topLeftCorner;
            }
            ShapePath shapePath2 = this.cornerPaths[i];
            if (cornerTreatment != null) {
                cornerTreatment.getCornerPath(shapePath2, 90.0f, f4, cornerSize.getCornerSize(rectF2));
                int i2 = i + 1;
                float f5 = (float) (i2 * 90);
                this.cornerTransforms[i].reset();
                PointF pointF2 = this.pointF;
                if (i == 1) {
                    pointF2.set(rectF2.right, rectF2.bottom);
                } else if (i == 2) {
                    pointF2.set(rectF2.left, rectF2.bottom);
                } else if (i != 3) {
                    pointF2.set(rectF2.right, rectF2.top);
                } else {
                    pointF2.set(rectF2.left, rectF2.top);
                }
                Matrix matrix = this.cornerTransforms[i];
                PointF pointF3 = this.pointF;
                matrix.setTranslate(pointF3.x, pointF3.y);
                this.cornerTransforms[i].preRotate(f5);
                float[] fArr = this.scratch;
                ShapePath[] shapePathArr = this.cornerPaths;
                fArr[0] = shapePathArr[i].endX;
                fArr[1] = shapePathArr[i].endY;
                this.cornerTransforms[i].mapPoints(fArr);
                this.edgeTransforms[i].reset();
                Matrix matrix2 = this.edgeTransforms[i];
                float[] fArr2 = this.scratch;
                matrix2.setTranslate(fArr2[0], fArr2[1]);
                this.edgeTransforms[i].preRotate(f5);
                i = i2;
            } else {
                throw null;
            }
        }
        int i3 = 0;
        while (i3 < 4) {
            float[] fArr3 = this.scratch;
            ShapePath[] shapePathArr2 = this.cornerPaths;
            fArr3[c2] = shapePathArr2[i3].startX;
            fArr3[1] = shapePathArr2[i3].startY;
            this.cornerTransforms[i3].mapPoints(fArr3);
            if (i3 == 0) {
                float[] fArr4 = this.scratch;
                path2.moveTo(fArr4[c2], fArr4[1]);
            } else {
                float[] fArr5 = this.scratch;
                path2.lineTo(fArr5[c2], fArr5[1]);
            }
            this.cornerPaths[i3].applyToPath(this.cornerTransforms[i3], path2);
            if (pathListener != null) {
                ShapePath shapePath3 = this.cornerPaths[i3];
                Matrix matrix3 = this.cornerTransforms[i3];
                AnonymousClass1 r13 = (AnonymousClass1) pathListener;
                MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i3, shapePath3.containsIncompatibleShadowOp);
                ShadowCompatOperation[] shadowCompatOperationArr = MaterialShapeDrawable.this.cornerShadowOperation;
                shapePath3.addConnectingShadowIfNecessary(shapePath3.endShadowAngle);
                shadowCompatOperationArr[i3] = new ShadowCompatOperation(shapePath3, new ArrayList(shapePath3.shadowCompatOperations), new Matrix(matrix3)) {
                    public final /* synthetic */ List val$operations;
                    public final /* synthetic */ Matrix val$transformCopy;

                    {
                        this.val$operations = r2;
                        this.val$transformCopy = r3;
                    }

                    public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
                        for (ShadowCompatOperation draw : this.val$operations) {
                            draw.draw(this.val$transformCopy, shadowRenderer, i, canvas);
                        }
                    }
                };
            }
            int i4 = i3 + 1;
            int i5 = i4 % 4;
            float[] fArr6 = this.scratch;
            ShapePath[] shapePathArr3 = this.cornerPaths;
            fArr6[c2] = shapePathArr3[i3].endX;
            fArr6[1] = shapePathArr3[i3].endY;
            this.cornerTransforms[i3].mapPoints(fArr6);
            float[] fArr7 = this.scratch2;
            ShapePath[] shapePathArr4 = this.cornerPaths;
            fArr7[c2] = shapePathArr4[i5].startX;
            fArr7[1] = shapePathArr4[i5].startY;
            this.cornerTransforms[i5].mapPoints(fArr7);
            float[] fArr8 = this.scratch;
            float f6 = fArr8[c2];
            float[] fArr9 = this.scratch2;
            float max = Math.max(((float) Math.hypot((double) (f6 - fArr9[c2]), (double) (fArr8[1] - fArr9[1]))) - 0.001f, 0.0f);
            float[] fArr10 = this.scratch;
            ShapePath[] shapePathArr5 = this.cornerPaths;
            fArr10[c2] = shapePathArr5[i3].endX;
            fArr10[1] = shapePathArr5[i3].endY;
            this.cornerTransforms[i3].mapPoints(fArr10);
            if (i3 == 1 || i3 == 3) {
                f3 = Math.abs(rectF.centerX() - this.scratch[c2]);
            } else {
                f3 = Math.abs(rectF.centerY() - this.scratch[1]);
            }
            this.shapePath.reset(0.0f, 0.0f);
            if (i3 == 1) {
                edgeTreatment = shapeAppearanceModel2.bottomEdge;
            } else if (i3 == 2) {
                edgeTreatment = shapeAppearanceModel2.leftEdge;
            } else if (i3 != 3) {
                edgeTreatment = shapeAppearanceModel2.rightEdge;
            } else {
                edgeTreatment = shapeAppearanceModel2.topEdge;
            }
            edgeTreatment.getEdgePath(max, f3, f4, this.shapePath);
            this.edgePath.reset();
            this.shapePath.applyToPath(this.edgeTransforms[i3], this.edgePath);
            if (!this.edgeIntersectionCheckEnabled || (!edgeTreatment.forceIntersection() && !pathOverlapsCorner(this.edgePath, i3) && !pathOverlapsCorner(this.edgePath, i5))) {
                this.shapePath.applyToPath(this.edgeTransforms[i3], path2);
            } else {
                Path path3 = this.edgePath;
                path3.op(path3, this.boundsPath, Op.DIFFERENCE);
                float[] fArr11 = this.scratch;
                ShapePath shapePath4 = this.shapePath;
                fArr11[c2] = shapePath4.startX;
                fArr11[1] = shapePath4.startY;
                this.edgeTransforms[i3].mapPoints(fArr11);
                Path path4 = this.overlappedEdgePath;
                float[] fArr12 = this.scratch;
                path4.moveTo(fArr12[c2], fArr12[1]);
                this.shapePath.applyToPath(this.edgeTransforms[i3], this.overlappedEdgePath);
            }
            if (pathListener != null) {
                ShapePath shapePath5 = this.shapePath;
                Matrix matrix4 = this.edgeTransforms[i3];
                AnonymousClass1 r12 = (AnonymousClass1) pathListener;
                MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i3 + 4, shapePath5.containsIncompatibleShadowOp);
                ShadowCompatOperation[] shadowCompatOperationArr2 = MaterialShapeDrawable.this.edgeShadowOperation;
                shapePath5.addConnectingShadowIfNecessary(shapePath5.endShadowAngle);
                shadowCompatOperationArr2[i3] = new ShadowCompatOperation(shapePath5, new ArrayList(shapePath5.shadowCompatOperations), new Matrix(matrix4)) {
                    public final /* synthetic */ List val$operations;
                    public final /* synthetic */ Matrix val$transformCopy;

                    {
                        this.val$operations = r2;
                        this.val$transformCopy = r3;
                    }

                    public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
                        for (ShadowCompatOperation draw : this.val$operations) {
                            draw.draw(this.val$transformCopy, shadowRenderer, i, canvas);
                        }
                    }
                };
            }
            i3 = i4;
            c2 = 0;
        }
        path.close();
        this.overlappedEdgePath.close();
        if (!this.overlappedEdgePath.isEmpty()) {
            path2.op(this.overlappedEdgePath, Op.UNION);
        }
    }
}
