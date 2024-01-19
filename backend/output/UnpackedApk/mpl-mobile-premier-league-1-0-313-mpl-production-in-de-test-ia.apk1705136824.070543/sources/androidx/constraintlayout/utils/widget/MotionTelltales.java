package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionPaths;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

public class MotionTelltales extends MockView {
    public Matrix mInvertMatrix = new Matrix();
    public MotionLayout mMotionLayout;
    public Paint mPaintTelltales = new Paint();
    public int mTailColor = -65281;
    public float mTailScale = 0.25f;
    public int mVelocityMode = 0;
    public float[] velocity = new float[2];

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionTelltales_telltales_tailColor) {
                    this.mTailColor = obtainStyledAttributes.getColor(index, this.mTailColor);
                } else if (index == R$styleable.MotionTelltales_telltales_velocityMode) {
                    this.mVelocityMode = obtainStyledAttributes.getInt(index, this.mVelocityMode);
                } else if (index == R$styleable.MotionTelltales_telltales_tailScale) {
                    this.mTailScale = obtainStyledAttributes.getFloat(index, this.mTailScale);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        float[] fArr;
        float[] fArr2;
        int i5;
        int i6;
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        float[] fArr3;
        float f3;
        int i7;
        double[] dArr;
        float f4;
        int i8;
        VelocityMatrix velocityMatrix;
        MotionTelltales motionTelltales = this;
        super.onDraw(canvas);
        getMatrix().invert(motionTelltales.mInvertMatrix);
        if (motionTelltales.mMotionLayout == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                motionTelltales.mMotionLayout = (MotionLayout) parent;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i9 = 5;
        float[] fArr4 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int i10 = 0;
        while (i10 < i9) {
            float f5 = fArr4[i10];
            int i11 = 0;
            while (i11 < i9) {
                float f6 = fArr4[i11];
                MotionLayout motionLayout = motionTelltales.mMotionLayout;
                float[] fArr5 = motionTelltales.velocity;
                int i12 = motionTelltales.mVelocityMode;
                float f7 = motionLayout.mLastVelocity;
                float f8 = motionLayout.mTransitionLastPosition;
                if (motionLayout.mInterpolator != null) {
                    float signum = Math.signum(motionLayout.mTransitionGoalPosition - f8);
                    float interpolation = motionLayout.mInterpolator.getInterpolation(motionLayout.mTransitionLastPosition + 1.0E-5f);
                    float interpolation2 = motionLayout.mInterpolator.getInterpolation(motionLayout.mTransitionLastPosition);
                    f7 = (((interpolation - interpolation2) / 1.0E-5f) * signum) / motionLayout.mTransitionDuration;
                    f8 = interpolation2;
                }
                Interpolator interpolator = motionLayout.mInterpolator;
                if (interpolator instanceof MotionInterpolator) {
                    f7 = ((MotionInterpolator) interpolator).getVelocity();
                }
                float f9 = f7;
                MotionController motionController = motionLayout.mFrameArrayList.get(motionTelltales);
                if ((i12 & 1) == 0) {
                    int width2 = getWidth();
                    int height2 = getHeight();
                    float adjustedPosition = motionController.getAdjustedPosition(f8, motionController.mVelocity);
                    HashMap<String, ViewSpline> hashMap = motionController.mAttributesMap;
                    SplineSet splineSet5 = hashMap == null ? null : hashMap.get("translationX");
                    HashMap<String, ViewSpline> hashMap2 = motionController.mAttributesMap;
                    fArr = fArr4;
                    if (hashMap2 == null) {
                        i6 = i12;
                        splineSet = null;
                    } else {
                        splineSet = hashMap2.get("translationY");
                        i6 = i12;
                    }
                    HashMap<String, ViewSpline> hashMap3 = motionController.mAttributesMap;
                    i4 = i10;
                    if (hashMap3 == null) {
                        i3 = i11;
                        splineSet2 = null;
                    } else {
                        splineSet2 = hashMap3.get("rotation");
                        i3 = i11;
                    }
                    HashMap<String, ViewSpline> hashMap4 = motionController.mAttributesMap;
                    i2 = height;
                    if (hashMap4 == null) {
                        i = width;
                        splineSet3 = null;
                    } else {
                        splineSet3 = hashMap4.get("scaleX");
                        i = width;
                    }
                    HashMap<String, ViewSpline> hashMap5 = motionController.mAttributesMap;
                    if (hashMap5 == null) {
                        f2 = f9;
                        splineSet4 = null;
                    } else {
                        splineSet4 = hashMap5.get("scaleY");
                        f2 = f9;
                    }
                    HashMap<String, ViewOscillator> hashMap6 = motionController.mCycleMap;
                    ViewOscillator viewOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
                    HashMap<String, ViewOscillator> hashMap7 = motionController.mCycleMap;
                    ViewOscillator viewOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
                    HashMap<String, ViewOscillator> hashMap8 = motionController.mCycleMap;
                    ViewOscillator viewOscillator3 = hashMap8 == null ? null : hashMap8.get("rotation");
                    HashMap<String, ViewOscillator> hashMap9 = motionController.mCycleMap;
                    ViewOscillator viewOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
                    HashMap<String, ViewOscillator> hashMap10 = motionController.mCycleMap;
                    ViewOscillator viewOscillator5 = hashMap10 == null ? null : hashMap10.get("scaleY");
                    VelocityMatrix velocityMatrix2 = new VelocityMatrix();
                    float[] fArr6 = fArr5;
                    velocityMatrix2.mDRotate = 0.0f;
                    velocityMatrix2.mDTranslateY = 0.0f;
                    velocityMatrix2.mDTranslateX = 0.0f;
                    velocityMatrix2.mDScaleY = 0.0f;
                    velocityMatrix2.mDScaleX = 0.0f;
                    velocityMatrix2.setRotationVelocity(splineSet2, adjustedPosition);
                    velocityMatrix2.setTranslationVelocity(splineSet5, splineSet, adjustedPosition);
                    velocityMatrix2.setScaleVelocity(splineSet3, splineSet4, adjustedPosition);
                    if (viewOscillator3 != null) {
                        velocityMatrix2.mDRotate = viewOscillator3.getSlope(adjustedPosition);
                    }
                    if (viewOscillator != null) {
                        velocityMatrix2.mDTranslateX = viewOscillator.getSlope(adjustedPosition);
                    }
                    if (viewOscillator2 != null) {
                        velocityMatrix2.mDTranslateY = viewOscillator2.getSlope(adjustedPosition);
                    }
                    if (viewOscillator4 != null) {
                        velocityMatrix2.mDScaleX = viewOscillator4.getSlope(adjustedPosition);
                    }
                    if (viewOscillator5 != null) {
                        velocityMatrix2.mDScaleY = viewOscillator5.getSlope(adjustedPosition);
                    }
                    CurveFit curveFit = motionController.mArcSpline;
                    if (curveFit != null) {
                        double[] dArr2 = motionController.mInterpolateData;
                        if (dArr2.length > 0) {
                            double d2 = (double) adjustedPosition;
                            curveFit.getPos(d2, dArr2);
                            motionController.mArcSpline.getSlope(d2, motionController.mInterpolateVelocity);
                            velocityMatrix = velocityMatrix2;
                            i8 = i6;
                            fArr3 = fArr6;
                            f4 = f6;
                            motionController.mStartMotionPath.setDpDt(f6, f5, fArr6, motionController.mInterpolateVariables, motionController.mInterpolateVelocity, motionController.mInterpolateData);
                        } else {
                            velocityMatrix = velocityMatrix2;
                            f4 = f6;
                            fArr3 = fArr6;
                            i8 = i6;
                        }
                        velocityMatrix.applyTransform(f4, f5, width2, height2, fArr3);
                        i7 = i8;
                        f3 = f4;
                    } else {
                        float[] fArr7 = fArr6;
                        VelocityMatrix velocityMatrix3 = velocityMatrix2;
                        if (motionController.mSpline != null) {
                            double adjustedPosition2 = (double) motionController.getAdjustedPosition(adjustedPosition, motionController.mVelocity);
                            motionController.mSpline[0].getSlope(adjustedPosition2, motionController.mInterpolateVelocity);
                            motionController.mSpline[0].getPos(adjustedPosition2, motionController.mInterpolateData);
                            float f10 = motionController.mVelocity[0];
                            int i13 = 0;
                            while (true) {
                                dArr = motionController.mInterpolateVelocity;
                                if (i13 >= dArr.length) {
                                    break;
                                }
                                dArr[i13] = dArr[i13] * ((double) f10);
                                i13++;
                            }
                            i7 = i6;
                            float f11 = f5;
                            float[] fArr8 = fArr7;
                            fArr3 = fArr7;
                            double[] dArr3 = dArr;
                            f3 = f6;
                            motionController.mStartMotionPath.setDpDt(f6, f11, fArr8, motionController.mInterpolateVariables, dArr3, motionController.mInterpolateData);
                            velocityMatrix3.applyTransform(f3, f11, width2, height2, fArr3);
                        } else {
                            MotionPaths motionPaths = motionController.mEndMotionPath;
                            KeyCycleOscillator keyCycleOscillator = viewOscillator5;
                            float f12 = motionPaths.x;
                            MotionPaths motionPaths2 = motionController.mStartMotionPath;
                            KeyCycleOscillator keyCycleOscillator2 = viewOscillator4;
                            float f13 = f12 - motionPaths2.x;
                            KeyCycleOscillator keyCycleOscillator3 = viewOscillator2;
                            float f14 = motionPaths.y - motionPaths2.y;
                            KeyCycleOscillator keyCycleOscillator4 = viewOscillator;
                            fArr7[0] = (((motionPaths.width - motionPaths2.width) + f13) * f6) + ((1.0f - f6) * f13);
                            fArr7[1] = (((motionPaths.height - motionPaths2.height) + f14) * f5) + ((1.0f - f5) * f14);
                            VelocityMatrix velocityMatrix4 = velocityMatrix3;
                            velocityMatrix4.mDRotate = 0.0f;
                            velocityMatrix4.mDTranslateY = 0.0f;
                            velocityMatrix4.mDTranslateX = 0.0f;
                            velocityMatrix4.mDScaleY = 0.0f;
                            velocityMatrix4.mDScaleX = 0.0f;
                            velocityMatrix4.setRotationVelocity(splineSet2, adjustedPosition);
                            velocityMatrix4.setTranslationVelocity(splineSet5, splineSet, adjustedPosition);
                            velocityMatrix4.setScaleVelocity(splineSet3, splineSet4, adjustedPosition);
                            if (viewOscillator3 != null) {
                                velocityMatrix4.mDRotate = viewOscillator3.getSlope(adjustedPosition);
                            }
                            if (keyCycleOscillator4 != null) {
                                velocityMatrix4.mDTranslateX = keyCycleOscillator4.getSlope(adjustedPosition);
                            }
                            if (keyCycleOscillator3 != null) {
                                velocityMatrix4.mDTranslateY = keyCycleOscillator3.getSlope(adjustedPosition);
                            }
                            if (keyCycleOscillator2 != null) {
                                velocityMatrix4.mDScaleX = keyCycleOscillator2.getSlope(adjustedPosition);
                            }
                            if (keyCycleOscillator != null) {
                                velocityMatrix4.mDScaleY = keyCycleOscillator.getSlope(adjustedPosition);
                            }
                            i5 = i6;
                            fArr2 = fArr7;
                            velocityMatrix4.applyTransform(f6, f5, width2, height2, fArr7);
                        }
                    }
                    i5 = i7;
                    f6 = f3;
                    fArr2 = fArr3;
                } else {
                    i = width;
                    i2 = height;
                    f2 = f9;
                    fArr = fArr4;
                    i4 = i10;
                    i5 = i12;
                    fArr2 = fArr5;
                    i3 = i11;
                    motionController.getDpDt(f8, f6, f5, fArr2);
                }
                if (i5 < 2) {
                    fArr2[0] = fArr2[0] * f2;
                    fArr2[1] = fArr2[1] * f2;
                }
                motionTelltales = this;
                motionTelltales.mInvertMatrix.mapVectors(motionTelltales.velocity);
                width = i;
                float f15 = ((float) width) * f6;
                height = i2;
                float f16 = ((float) height) * f5;
                float[] fArr9 = motionTelltales.velocity;
                float f17 = fArr9[0];
                float f18 = motionTelltales.mTailScale;
                float f19 = f16 - (fArr9[1] * f18);
                motionTelltales.mInvertMatrix.mapVectors(fArr9);
                canvas.drawLine(f15, f16, f15 - (f17 * f18), f19, motionTelltales.mPaintTelltales);
                i11 = i3 + 1;
                fArr4 = fArr;
                i10 = i4;
                i9 = 5;
            }
            float[] fArr10 = fArr4;
            i10++;
            i9 = 5;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
