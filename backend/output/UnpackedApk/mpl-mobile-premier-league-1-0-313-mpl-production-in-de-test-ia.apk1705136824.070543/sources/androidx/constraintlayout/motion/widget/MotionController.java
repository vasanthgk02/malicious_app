package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class MotionController {
    public int MAX_DIMENSION = 4;
    public CurveFit mArcSpline;
    public int[] mAttributeInterpolatorCount;
    public String[] mAttributeNames;
    public HashMap<String, ViewSpline> mAttributesMap;
    public int mCurveFitType = -1;
    public HashMap<String, ViewOscillator> mCycleMap;
    public MotionPaths mEndMotionPath = new MotionPaths();
    public MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    public int mId;
    public double[] mInterpolateData;
    public int[] mInterpolateVariables;
    public double[] mInterpolateVelocity;
    public ArrayList<Key> mKeyList = new ArrayList<>();
    public KeyTrigger[] mKeyTriggers;
    public ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    public float mMotionStagger = Float.NaN;
    public boolean mNoMovement = false;
    public int mPathMotionArc = -1;
    public Interpolator mQuantizeMotionInterpolator = null;
    public float mQuantizeMotionPhase = Float.NaN;
    public int mQuantizeMotionSteps = -1;
    public CurveFit[] mSpline;
    public float mStaggerOffset = 0.0f;
    public float mStaggerScale = 1.0f;
    public MotionPaths mStartMotionPath = new MotionPaths();
    public MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    public Rect mTempRect = new Rect();
    public HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    public int mTransformPivotTarget = -1;
    public View mTransformPivotView = null;
    public float[] mValuesBuff = new float[4];
    public float[] mVelocity = new float[1];
    public View mView;

    public MotionController(View view) {
        this.mView = view;
        this.mId = view.getId();
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            String str = ((ConstraintLayout.LayoutParams) layoutParams).constraintTag;
        }
    }

    public final float getAdjustedPosition(float f2, float[] fArr) {
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else if (((double) this.mStaggerScale) != 1.0d) {
            if (f2 < this.mStaggerOffset) {
                f2 = 0.0f;
            }
            float f5 = this.mStaggerOffset;
            if (f2 > f5 && ((double) f2) < 1.0d) {
                f2 = Math.min((f2 - f5) * this.mStaggerScale, 1.0f);
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float f6 = Float.NaN;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f7 = next.time;
                if (f7 < f2) {
                    easing = easing2;
                    f3 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = next.time;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f6)) {
                f4 = f6;
            }
            float f8 = f4 - f3;
            double d2 = (double) ((f2 - f3) / f8);
            f2 = (((float) easing.get(d2)) * f8) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d2);
            }
        }
        return f2;
    }

    public void getCenter(double d2, float[] fArr, float[] fArr2) {
        double d3 = d2;
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d3, dArr);
        this.mSpline[0].getSlope(d3, dArr2);
        float f2 = 0.0f;
        Arrays.fill(fArr2, 0.0f);
        MotionPaths motionPaths = this.mStartMotionPath;
        int[] iArr = this.mInterpolateVariables;
        float f3 = motionPaths.x;
        float f4 = motionPaths.y;
        float f5 = motionPaths.width;
        float f6 = motionPaths.height;
        float f7 = 0.0f;
        int i = 0;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (i < iArr.length) {
            float f10 = (float) dArr[i];
            float f11 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f10;
                f2 = f11;
            } else if (i2 == 2) {
                f4 = f10;
                f7 = f11;
            } else if (i2 == 3) {
                f5 = f10;
                f8 = f11;
            } else if (i2 == 4) {
                f6 = f10;
                f9 = f11;
            }
            i++;
            double d4 = d2;
            float[] fArr3 = fArr2;
        }
        float f12 = 2.0f;
        float f13 = (f8 / 2.0f) + f2;
        float f14 = (f9 / 2.0f) + f7;
        MotionController motionController = motionPaths.mRelativeToController;
        if (motionController != null) {
            float[] fArr4 = new float[2];
            float[] fArr5 = new float[2];
            motionController.getCenter(d2, fArr4, fArr5);
            float f15 = fArr4[0];
            float f16 = fArr4[1];
            float f17 = fArr5[0];
            float f18 = fArr5[1];
            double d5 = (double) f3;
            double d6 = (double) f4;
            float cos = (float) ((((double) f16) - (Math.cos(d6) * d5)) - ((double) (f6 / 2.0f)));
            double d7 = (double) f17;
            double d8 = (double) f2;
            double sin = (Math.sin(d6) * d8) + d7;
            double d9 = (double) f7;
            f14 = (float) ((Math.sin(d6) * d9) + (((double) f18) - (Math.cos(d6) * d8)));
            f4 = cos;
            f13 = (float) ((Math.cos(d6) * d9) + sin);
            f3 = (float) (((Math.sin(d6) * d5) + ((double) f15)) - ((double) (f5 / 2.0f)));
            f12 = 2.0f;
        }
        fArr[0] = (f5 / f12) + f3 + 0.0f;
        fArr[1] = (f6 / f12) + f4 + 0.0f;
        fArr2[0] = f13;
        fArr2[1] = f14;
    }

    public void getDpDt(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i = 0;
        if (curveFitArr != null) {
            double d2 = (double) adjustedPosition;
            curveFitArr[0].getSlope(d2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            float f5 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i >= dArr.length) {
                    break;
                }
                dArr[i] = dArr[i] * ((double) f5);
                i++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d2, dArr2);
                    this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        float f6 = motionPaths.x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f7 = f6 - motionPaths2.x;
        float f8 = motionPaths.y - motionPaths2.y;
        fArr[0] = (((motionPaths.width - motionPaths2.width) + f7) * f3) + ((1.0f - f3) * f7);
        fArr[1] = (((motionPaths.height - motionPaths2.height) + f8) * f4) + ((1.0f - f4) * f8);
    }

    public final float getPreCycleDistance() {
        char c2;
        float f2;
        float[] fArr = new float[2];
        float f3 = 1.0f / ((float) 99);
        double d2 = 0.0d;
        double d3 = 0.0d;
        float f4 = 0.0f;
        int i = 0;
        while (i < 100) {
            float f5 = ((float) i) * f3;
            double d4 = (double) f5;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f6 = Float.NaN;
            float f7 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f8 = next.time;
                    if (f8 < f5) {
                        easing = easing2;
                        f7 = f8;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                float f9 = f6 - f7;
                d4 = (double) ((((float) easing.get((double) ((f5 - f7) / f9))) * f9) + f7);
            }
            this.mSpline[0].getPos(d4, this.mInterpolateData);
            float f10 = f4;
            int i2 = i;
            this.mStartMotionPath.getCenter(d4, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i2 > 0) {
                c2 = 0;
                f2 = (float) (Math.hypot(d3 - ((double) fArr[1]), d2 - ((double) fArr[0])) + ((double) f10));
            } else {
                c2 = 0;
                f2 = f10;
            }
            d2 = (double) fArr[c2];
            i = i2 + 1;
            f4 = f2;
            d3 = (double) fArr[1];
        }
        return f4;
    }

    public boolean interpolate(View view, float f2, long j, KeyCache keyCache) {
        boolean z;
        ViewTimeCycle viewTimeCycle;
        boolean z2;
        float f3;
        boolean z3;
        ViewTimeCycle viewTimeCycle2;
        double d2;
        float f4;
        double d3;
        float f5;
        float f6;
        ViewTimeCycle viewTimeCycle3;
        MotionController motionController = this;
        View view2 = view;
        float adjustedPosition = motionController.getAdjustedPosition(f2, null);
        int i = motionController.mQuantizeMotionSteps;
        if (i != -1) {
            float f7 = 1.0f / ((float) i);
            float floor = ((float) Math.floor((double) (adjustedPosition / f7))) * f7;
            float f8 = (adjustedPosition % f7) / f7;
            if (!Float.isNaN(motionController.mQuantizeMotionPhase)) {
                f8 = (f8 + motionController.mQuantizeMotionPhase) % 1.0f;
            }
            Interpolator interpolator = motionController.mQuantizeMotionInterpolator;
            adjustedPosition = ((interpolator != null ? interpolator.getInterpolation(f8) : ((double) f8) > 0.5d ? 1.0f : 0.0f) * f7) + floor;
        }
        float f9 = adjustedPosition;
        HashMap<String, ViewSpline> hashMap = motionController.mAttributesMap;
        if (hashMap != null) {
            for (ViewSpline property : hashMap.values()) {
                property.setProperty(view2, f9);
            }
        }
        HashMap<String, ViewTimeCycle> hashMap2 = motionController.mTimeCycleAttributesMap;
        if (hashMap2 != null) {
            viewTimeCycle = null;
            z = false;
            for (ViewTimeCycle next : hashMap2.values()) {
                if (next instanceof PathRotate) {
                    viewTimeCycle = (PathRotate) next;
                } else {
                    z |= next.setProperty(view, f9, j, keyCache);
                }
            }
        } else {
            z = false;
            viewTimeCycle = null;
        }
        CurveFit[] curveFitArr = motionController.mSpline;
        if (curveFitArr != null) {
            double d4 = (double) f9;
            curveFitArr[0].getPos(d4, motionController.mInterpolateData);
            motionController.mSpline[0].getSlope(d4, motionController.mInterpolateVelocity);
            CurveFit curveFit = motionController.mArcSpline;
            if (curveFit != null) {
                double[] dArr = motionController.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d4, dArr);
                    motionController.mArcSpline.getSlope(d4, motionController.mInterpolateVelocity);
                }
            }
            if (!motionController.mNoMovement) {
                MotionPaths motionPaths = motionController.mStartMotionPath;
                int[] iArr = motionController.mInterpolateVariables;
                double[] dArr2 = motionController.mInterpolateData;
                double[] dArr3 = motionController.mInterpolateVelocity;
                float f10 = motionPaths.x;
                float f11 = motionPaths.y;
                float f12 = motionPaths.width;
                float f13 = motionPaths.height;
                if (iArr.length != 0) {
                    f5 = f10;
                    if (motionPaths.mTempValue.length <= iArr[iArr.length - 1]) {
                        int i2 = iArr[iArr.length - 1] + 1;
                        motionPaths.mTempValue = new double[i2];
                        motionPaths.mTempDelta = new double[i2];
                    }
                } else {
                    f5 = f10;
                }
                float f14 = f12;
                float f15 = f13;
                Arrays.fill(motionPaths.mTempValue, Double.NaN);
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    motionPaths.mTempValue[iArr[i3]] = dArr2[i3];
                    motionPaths.mTempDelta[iArr[i3]] = dArr3[i3];
                }
                float f16 = Float.NaN;
                float f17 = 0.0f;
                float f18 = f5;
                float f19 = f11;
                z3 = z;
                float f20 = 0.0f;
                int i4 = 0;
                float f21 = 0.0f;
                float f22 = 0.0f;
                while (true) {
                    double[] dArr4 = motionPaths.mTempValue;
                    f4 = f9;
                    if (i4 >= dArr4.length) {
                        break;
                    }
                    if (Double.isNaN(dArr4[i4])) {
                        viewTimeCycle3 = viewTimeCycle;
                    } else {
                        double d5 = 0.0d;
                        if (!Double.isNaN(motionPaths.mTempValue[i4])) {
                            d5 = motionPaths.mTempValue[i4] + 0.0d;
                        }
                        viewTimeCycle3 = viewTimeCycle;
                        float f23 = (float) d5;
                        float f24 = (float) motionPaths.mTempDelta[i4];
                        if (i4 == 1) {
                            f17 = f24;
                            f18 = f23;
                        } else if (i4 == 2) {
                            f20 = f24;
                            f19 = f23;
                        } else if (i4 == 3) {
                            f21 = f24;
                            f14 = f23;
                        } else if (i4 == 4) {
                            f22 = f24;
                            f15 = f23;
                        } else if (i4 == 5) {
                            f16 = f23;
                        }
                    }
                    i4++;
                    viewTimeCycle = viewTimeCycle3;
                    f9 = f4;
                }
                ViewTimeCycle viewTimeCycle4 = viewTimeCycle;
                MotionController motionController2 = motionPaths.mRelativeToController;
                if (motionController2 != null) {
                    float[] fArr = new float[2];
                    float[] fArr2 = new float[2];
                    motionController2.getCenter(d4, fArr, fArr2);
                    float f25 = fArr[0];
                    float f26 = fArr[1];
                    float f27 = fArr2[0];
                    float f28 = fArr2[1];
                    d2 = d4;
                    double d6 = (double) f18;
                    double[] dArr5 = dArr3;
                    double d7 = (double) f19;
                    float sin = (float) (((Math.sin(d7) * d6) + ((double) f25)) - ((double) (f14 / 2.0f)));
                    viewTimeCycle2 = viewTimeCycle4;
                    float cos = (float) ((((double) f26) - (Math.cos(d7) * d6)) - ((double) (f15 / 2.0f)));
                    double d8 = (double) f17;
                    f6 = f14;
                    double d9 = (double) f20;
                    float cos2 = (float) ((Math.cos(d7) * d6 * d9) + (Math.sin(d7) * d8) + ((double) f27));
                    float sin2 = (float) ((Math.sin(d7) * d6 * d9) + (((double) f28) - (Math.cos(d7) * d8)));
                    double[] dArr6 = dArr5;
                    if (dArr6.length >= 2) {
                        dArr6[0] = (double) cos2;
                        dArr6[1] = (double) sin2;
                    }
                    if (!Float.isNaN(f16)) {
                        view2 = view;
                        view2.setRotation((float) (Math.toDegrees(Math.atan2((double) sin2, (double) cos2)) + ((double) f16)));
                    } else {
                        view2 = view;
                    }
                    f18 = sin;
                    f19 = cos;
                } else {
                    viewTimeCycle2 = viewTimeCycle4;
                    d2 = d4;
                    f6 = f14;
                    if (!Float.isNaN(f16)) {
                        view2.setRotation((float) (Math.toDegrees(Math.atan2((double) ((f22 / 2.0f) + f20), (double) ((f21 / 2.0f) + f17))) + ((double) f16) + ((double) 0.0f)));
                    }
                }
                if (view2 instanceof FloatLayout) {
                    ((FloatLayout) view2).layout(f18, f19, f6 + f18, f19 + f15);
                } else {
                    float f29 = f18 + 0.5f;
                    int i5 = (int) f29;
                    float f30 = f19 + 0.5f;
                    int i6 = (int) f30;
                    int i7 = (int) (f29 + f6);
                    int i8 = (int) (f30 + f15);
                    int i9 = i7 - i5;
                    int i10 = i8 - i6;
                    if ((i9 == view.getMeasuredWidth() && i10 == view.getMeasuredHeight()) ? false : true) {
                        view2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(i10, 1073741824));
                    }
                    view2.layout(i5, i6, i7, i8);
                }
            } else {
                f4 = f9;
                viewTimeCycle2 = viewTimeCycle;
                z3 = z;
                d2 = d4;
            }
            motionController = this;
            if (motionController.mTransformPivotTarget != -1) {
                if (motionController.mTransformPivotView == null) {
                    motionController.mTransformPivotView = ((View) view.getParent()).findViewById(motionController.mTransformPivotTarget);
                }
                View view3 = motionController.mTransformPivotView;
                if (view3 != null) {
                    float bottom = ((float) (motionController.mTransformPivotView.getBottom() + view3.getTop())) / 2.0f;
                    float right = ((float) (motionController.mTransformPivotView.getRight() + motionController.mTransformPivotView.getLeft())) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view2.setPivotX(right - ((float) view.getLeft()));
                        view2.setPivotY(bottom - ((float) view.getTop()));
                    }
                }
            }
            HashMap<String, ViewSpline> hashMap3 = motionController.mAttributesMap;
            if (hashMap3 != null) {
                for (SplineSet next2 : hashMap3.values()) {
                    if (next2 instanceof ViewSpline.PathRotate) {
                        double[] dArr7 = motionController.mInterpolateVelocity;
                        if (dArr7.length > 1) {
                            d3 = d2;
                            view2.setRotation(((float) ((ViewSpline.PathRotate) next2).mCurveFit.getPos(d3, 0)) + ((float) Math.toDegrees(Math.atan2(dArr7[1], dArr7[0]))));
                            d2 = d3;
                        }
                    }
                    d3 = d2;
                    d2 = d3;
                }
            }
            double d10 = d2;
            if (viewTimeCycle2 != null) {
                double[] dArr8 = motionController.mInterpolateVelocity;
                view2.setRotation(viewTimeCycle2.get(f4, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(dArr8[1], dArr8[0]))));
                z2 = z3 | viewTimeCycle2.mContinue;
            } else {
                z2 = z3;
            }
            int i11 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = motionController.mSpline;
                if (i11 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i11].getPos(d10, motionController.mValuesBuff);
                motionController.mStartMotionPath.attributes.get(motionController.mAttributeNames[i11 - 1]).setInterpolatedValue(view2, motionController.mValuesBuff);
                i11++;
            }
            MotionConstrainedPoint motionConstrainedPoint = motionController.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f4 <= 0.0f) {
                    view2.setVisibility(motionConstrainedPoint.visibility);
                } else if (f4 >= 1.0f) {
                    view2.setVisibility(motionController.mEndPoint.visibility);
                } else if (motionController.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view2.setVisibility(0);
                }
            }
            if (motionController.mKeyTriggers != null) {
                int i12 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = motionController.mKeyTriggers;
                    if (i12 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i12].conditionallyFire(f4, view2);
                    i12++;
                }
            }
            f3 = f4;
        } else {
            f3 = f9;
            boolean z4 = z;
            MotionPaths motionPaths2 = motionController.mStartMotionPath;
            float f31 = motionPaths2.x;
            MotionPaths motionPaths3 = motionController.mEndMotionPath;
            float outline3 = GeneratedOutlineSupport.outline3(motionPaths3.x, f31, f3, f31);
            float f32 = motionPaths2.y;
            float outline32 = GeneratedOutlineSupport.outline3(motionPaths3.y, f32, f3, f32);
            float f33 = motionPaths2.width;
            float f34 = motionPaths3.width;
            float outline33 = GeneratedOutlineSupport.outline3(f34, f33, f3, f33);
            float f35 = motionPaths2.height;
            float f36 = motionPaths3.height;
            float f37 = outline3 + 0.5f;
            int i13 = (int) f37;
            float f38 = outline32 + 0.5f;
            int i14 = (int) f38;
            int i15 = (int) (f37 + outline33);
            int outline34 = (int) (f38 + GeneratedOutlineSupport.outline3(f36, f35, f3, f35));
            int i16 = i15 - i13;
            int i17 = outline34 - i14;
            if (!(f34 == f33 && f36 == f35)) {
                view2.measure(MeasureSpec.makeMeasureSpec(i16, 1073741824), MeasureSpec.makeMeasureSpec(i17, 1073741824));
            }
            view2.layout(i13, i14, i15, outline34);
            z2 = z4;
        }
        HashMap<String, ViewOscillator> hashMap4 = motionController.mCycleMap;
        if (hashMap4 != null) {
            for (ViewOscillator next3 : hashMap4.values()) {
                if (next3 instanceof PathRotateSet) {
                    double[] dArr9 = motionController.mInterpolateVelocity;
                    view2.setRotation(((PathRotateSet) next3).get(f3) + ((float) Math.toDegrees(Math.atan2(dArr9[1], dArr9[0]))));
                } else {
                    next3.setProperty(view2, f3);
                }
            }
        }
        return z2;
    }

    public final void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((float) ((int) this.mView.getX()), (float) ((int) this.mView.getY()), (float) this.mView.getWidth(), (float) this.mView.getHeight());
    }

    public void rotate(Rect rect, Rect rect2, int i, int i2, int i3) {
        if (i == 1) {
            int i4 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i3 - ((rect.height() + i4) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
        } else if (i == 2) {
            int i5 = rect.left + rect.right;
            rect2.left = i2 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i5 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
        } else if (i == 3) {
            int i6 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i6 / 2);
            rect2.top = i3 - ((rect.height() + i6) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
        } else if (i == 4) {
            int i7 = rect.left + rect.right;
            rect2.left = i2 - ((rect.width() + (rect.bottom + rect.top)) / 2);
            rect2.top = (i7 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
        }
    }

    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r0v12, types: [double[]] */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r31v1 */
    /* JADX WARNING: type inference failed for: r33v1 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r31v2 */
    /* JADX WARNING: type inference failed for: r33v2 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r0v23, types: [double[]] */
    /* JADX WARNING: type inference failed for: r8v29, types: [double[][]] */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v107 */
    /* JADX WARNING: type inference failed for: r0v108 */
    /* JADX WARNING: type inference failed for: r8v62 */
    /* JADX WARNING: type inference failed for: r0v109 */
    /* JADX WARNING: type inference failed for: r0v110 */
    /* JADX WARNING: type inference failed for: r8v63 */
    /* JADX WARNING: type inference failed for: r0v111 */
    /* JADX WARNING: type inference failed for: r8v64 */
    /* JADX WARNING: type inference failed for: r0v112 */
    /* JADX WARNING: type inference failed for: r0v113 */
    /* JADX WARNING: type inference failed for: r8v65 */
    /* JADX WARNING: type inference failed for: r0v114 */
    /* JADX WARNING: type inference failed for: r0v115 */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x035a, code lost:
        r15 = r18;
        r12 = r19;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0383, code lost:
        r7 = r27;
        r6 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0387, code lost:
        r18 = r3;
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x038b, code lost:
        r17 = r2;
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x044f, code lost:
        r16 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0451, code lost:
        switch(r16) {
            case 0: goto L_0x04b2;
            case 1: goto L_0x04ac;
            case 2: goto L_0x04a6;
            case 3: goto L_0x04a0;
            case 4: goto L_0x049a;
            case 5: goto L_0x0494;
            case 6: goto L_0x048e;
            case 7: goto L_0x0488;
            case 8: goto L_0x0482;
            case 9: goto L_0x047c;
            case 10: goto L_0x0476;
            case 11: goto L_0x0470;
            case 12: goto L_0x046a;
            case 13: goto L_0x0464;
            case 14: goto L_0x045e;
            case 15: goto L_0x0458;
            default: goto L_0x0454;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0454, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0458, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.ProgressSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x045e, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.TranslationZset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0464, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.TranslationYset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x046a, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.TranslationXset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0470, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.AlphaSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0476, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.AlphaSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x047c, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.ScaleYset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0482, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.ScaleXset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0488, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.PathRotate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x048e, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.PivotYset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0494, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.PivotXset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x049a, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.RotationYset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x04a0, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.RotationXset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x04a6, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.RotationSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x04ac, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.ElevationSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04b2, code lost:
        r16 = new androidx.constraintlayout.motion.utils.ViewSpline.AlphaSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04b7, code lost:
        r19 = r2;
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x06a6, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x06a8, code lost:
        r3 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x06c4, code lost:
        r4 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x06c5, code lost:
        switch(r4) {
            case 0: goto L_0x0710;
            case 1: goto L_0x070a;
            case 2: goto L_0x0704;
            case 3: goto L_0x06fe;
            case 4: goto L_0x06f8;
            case 5: goto L_0x06f2;
            case 6: goto L_0x06ec;
            case 7: goto L_0x06e6;
            case 8: goto L_0x06e0;
            case 9: goto L_0x06da;
            case 10: goto L_0x06d4;
            case 11: goto L_0x06ce;
            default: goto L_0x06c8;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x06c8, code lost:
        r16 = r15;
        r14 = r33;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x06ce, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.ProgressSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x06d4, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.TranslationZset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x06da, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.TranslationYset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x06e0, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.TranslationXset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x06e6, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.ScaleYset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x06ec, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.ScaleXset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x06f2, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x06f8, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.RotationYset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x06fe, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.RotationXset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0704, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.RotationSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x070a, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.ElevationSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0710, code lost:
        r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle.AlphaSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0715, code lost:
        r16 = r15;
        r4.last_time = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x0863, code lost:
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x0865, code lost:
        r3 = r20;
        r1 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0892, code lost:
        r2 = r1;
        r3 = r20;
        r1 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x08b7, code lost:
        r2 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x08b8, code lost:
        switch(r2) {
            case 0: goto L_0x0a7a;
            case 1: goto L_0x0a54;
            case 2: goto L_0x0a2e;
            case 3: goto L_0x0a07;
            case 4: goto L_0x09e0;
            case 5: goto L_0x09b9;
            case 6: goto L_0x0992;
            case 7: goto L_0x096b;
            case 8: goto L_0x0944;
            case 9: goto L_0x091d;
            case 10: goto L_0x08f6;
            case 11: goto L_0x08c9;
            default: goto L_0x08bb;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x08bb, code lost:
        r2 = r33;
        r15 = r34;
        r16 = r0;
        r14 = r19;
        r4 = r29;
        r0 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x08c9, code lost:
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x08d1, code lost:
        if (java.lang.Float.isNaN(r4.mProgress) != false) goto L_0x08f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x08d3, code lost:
        r16 = r0;
        r28 = r1;
        r22.setPoint(r4.mFramePosition, r4.mProgress, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x08f0, code lost:
        r16 = r0;
        r28 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x08f6, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x0902, code lost:
        if (java.lang.Float.isNaN(r4.mTranslationZ) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x0904, code lost:
        r22.setPoint(r4.mFramePosition, r4.mTranslationZ, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x091d, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0929, code lost:
        if (java.lang.Float.isNaN(r4.mTranslationY) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x092b, code lost:
        r22.setPoint(r4.mFramePosition, r4.mTranslationY, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0944, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0950, code lost:
        if (java.lang.Float.isNaN(r4.mTranslationX) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x0952, code lost:
        r22.setPoint(r4.mFramePosition, r4.mTranslationX, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x096b, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0977, code lost:
        if (java.lang.Float.isNaN(r4.mScaleY) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0979, code lost:
        r22.setPoint(r4.mFramePosition, r4.mScaleY, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0992, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x099e, code lost:
        if (java.lang.Float.isNaN(r4.mScaleX) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x09a0, code lost:
        r22.setPoint(r4.mFramePosition, r4.mScaleX, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x09b9, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x09c5, code lost:
        if (java.lang.Float.isNaN(r4.mTransitionPathRotate) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x09c7, code lost:
        r22.setPoint(r4.mFramePosition, r4.mTransitionPathRotate, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x09e0, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x09ec, code lost:
        if (java.lang.Float.isNaN(r4.mRotationY) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x09ee, code lost:
        r22.setPoint(r4.mFramePosition, r4.mRotationY, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0a07, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0a13, code lost:
        if (java.lang.Float.isNaN(r4.mRotationX) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x0a15, code lost:
        r22.setPoint(r4.mFramePosition, r4.mRotationX, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0a2e, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0a3a, code lost:
        if (java.lang.Float.isNaN(r4.mRotation) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0a3c, code lost:
        r22.setPoint(r4.mFramePosition, r4.mRotation, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0a54, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0a60, code lost:
        if (java.lang.Float.isNaN(r4.mElevation) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0a62, code lost:
        r22.setPoint(r4.mFramePosition, r4.mElevation, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0a7a, code lost:
        r16 = r0;
        r28 = r1;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x0a86, code lost:
        if (java.lang.Float.isNaN(r4.mAlpha) != false) goto L_0x0a9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x0a88, code lost:
        r22.setPoint(r4.mFramePosition, r4.mAlpha, r4.mWavePeriod, r4.mWaveShape, r4.mWaveOffset);
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v1
      assigns: []
      uses: []
      mth insns count: 1465
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x056d  */
    /* JADX WARNING: Removed duplicated region for block: B:549:0x0570 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setup(int r31, int r32, long r33) {
        /*
            r30 = this;
            r0 = r30
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r0.mPathMotionArc
            r6 = -1
            if (r5 == r6) goto L_0x0024
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mStartMotionPath
            r6.mPathMotionArc = r5
        L_0x0024:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r5 = r0.mStartPoint
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.mEndPoint
            float r7 = r5.alpha
            float r8 = r6.alpha
            boolean r7 = r5.diff(r7, r8)
            java.lang.String r8 = "alpha"
            if (r7 == 0) goto L_0x0037
            r2.add(r8)
        L_0x0037:
            float r7 = r5.elevation
            float r9 = r6.elevation
            boolean r7 = r5.diff(r7, r9)
            java.lang.String r9 = "elevation"
            if (r7 == 0) goto L_0x0046
            r2.add(r9)
        L_0x0046:
            int r7 = r5.visibility
            int r10 = r6.visibility
            if (r7 == r10) goto L_0x0057
            int r11 = r5.mVisibilityMode
            if (r11 != 0) goto L_0x0057
            if (r7 == 0) goto L_0x0054
            if (r10 != 0) goto L_0x0057
        L_0x0054:
            r2.add(r8)
        L_0x0057:
            float r7 = r5.rotation
            float r10 = r6.rotation
            boolean r7 = r5.diff(r7, r10)
            java.lang.String r10 = "rotation"
            if (r7 == 0) goto L_0x0066
            r2.add(r10)
        L_0x0066:
            float r7 = r5.mPathRotate
            boolean r7 = java.lang.Float.isNaN(r7)
            java.lang.String r11 = "transitionPathRotate"
            if (r7 == 0) goto L_0x0078
            float r7 = r6.mPathRotate
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x007b
        L_0x0078:
            r2.add(r11)
        L_0x007b:
            float r7 = r5.mProgress
            boolean r7 = java.lang.Float.isNaN(r7)
            java.lang.String r12 = "progress"
            if (r7 == 0) goto L_0x008d
            float r7 = r6.mProgress
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x0090
        L_0x008d:
            r2.add(r12)
        L_0x0090:
            float r7 = r5.rotationX
            float r13 = r6.rotationX
            boolean r7 = r5.diff(r7, r13)
            java.lang.String r13 = "rotationX"
            if (r7 == 0) goto L_0x009f
            r2.add(r13)
        L_0x009f:
            float r7 = r5.rotationY
            float r14 = r6.rotationY
            boolean r7 = r5.diff(r7, r14)
            java.lang.String r14 = "rotationY"
            if (r7 == 0) goto L_0x00ae
            r2.add(r14)
        L_0x00ae:
            float r7 = r5.mPivotX
            float r15 = r6.mPivotX
            boolean r7 = r5.diff(r7, r15)
            if (r7 == 0) goto L_0x00bd
            java.lang.String r7 = "transformPivotX"
            r2.add(r7)
        L_0x00bd:
            float r7 = r5.mPivotY
            float r15 = r6.mPivotY
            boolean r7 = r5.diff(r7, r15)
            if (r7 == 0) goto L_0x00cc
            java.lang.String r7 = "transformPivotY"
            r2.add(r7)
        L_0x00cc:
            float r7 = r5.scaleX
            float r15 = r6.scaleX
            boolean r7 = r5.diff(r7, r15)
            java.lang.String r15 = "scaleX"
            if (r7 == 0) goto L_0x00db
            r2.add(r15)
        L_0x00db:
            float r7 = r5.scaleY
            r16 = r13
            float r13 = r6.scaleY
            boolean r7 = r5.diff(r7, r13)
            java.lang.String r13 = "scaleY"
            if (r7 == 0) goto L_0x00ec
            r2.add(r13)
        L_0x00ec:
            float r7 = r5.translationX
            r17 = r14
            float r14 = r6.translationX
            boolean r7 = r5.diff(r7, r14)
            java.lang.String r14 = "translationX"
            if (r7 == 0) goto L_0x00fd
            r2.add(r14)
        L_0x00fd:
            float r7 = r5.translationY
            r18 = r14
            float r14 = r6.translationY
            boolean r7 = r5.diff(r7, r14)
            java.lang.String r14 = "translationY"
            if (r7 == 0) goto L_0x010e
            r2.add(r14)
        L_0x010e:
            float r7 = r5.translationZ
            float r6 = r6.translationZ
            boolean r5 = r5.diff(r7, r6)
            java.lang.String r6 = "translationZ"
            if (r5 == 0) goto L_0x011d
            r2.add(r6)
        L_0x011d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r5 = r0.mKeyList
            if (r5 == 0) goto L_0x01af
            java.util.Iterator r5 = r5.iterator()
            r7 = 0
        L_0x0126:
            boolean r19 = r5.hasNext()
            if (r19 == 0) goto L_0x01a6
            java.lang.Object r19 = r5.next()
            r20 = r5
            r5 = r19
            androidx.constraintlayout.motion.widget.Key r5 = (androidx.constraintlayout.motion.widget.Key) r5
            r19 = r14
            boolean r14 = r5 instanceof androidx.constraintlayout.motion.widget.KeyPosition
            if (r14 == 0) goto L_0x016e
            androidx.constraintlayout.motion.widget.KeyPosition r5 = (androidx.constraintlayout.motion.widget.KeyPosition) r5
            androidx.constraintlayout.motion.widget.MotionPaths r14 = new androidx.constraintlayout.motion.widget.MotionPaths
            r27 = r6
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.mStartMotionPath
            r28 = r12
            androidx.constraintlayout.motion.widget.MotionPaths r12 = r0.mEndMotionPath
            r21 = r14
            r22 = r31
            r23 = r32
            r24 = r5
            r25 = r6
            r26 = r12
            r21.<init>(r22, r23, r24, r25, r26)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r6 = r0.mMotionPaths
            int r6 = java.util.Collections.binarySearch(r6, r14)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r12 = r0.mMotionPaths
            int r6 = -r6
            r21 = r15
            r15 = -1
            int r6 = r6 + r15
            r12.add(r6, r14)
            int r5 = r5.mCurveFit
            if (r5 == r15) goto L_0x019b
            r0.mCurveFitType = r5
            goto L_0x019b
        L_0x016e:
            r27 = r6
            r28 = r12
            r21 = r15
            boolean r6 = r5 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r6 == 0) goto L_0x017c
            r5.getAttributeNames(r3)
            goto L_0x019b
        L_0x017c:
            boolean r6 = r5 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r6 == 0) goto L_0x0184
            r5.getAttributeNames(r1)
            goto L_0x019b
        L_0x0184:
            boolean r6 = r5 instanceof androidx.constraintlayout.motion.widget.KeyTrigger
            if (r6 == 0) goto L_0x0195
            if (r7 != 0) goto L_0x018f
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x018f:
            androidx.constraintlayout.motion.widget.KeyTrigger r5 = (androidx.constraintlayout.motion.widget.KeyTrigger) r5
            r7.add(r5)
            goto L_0x019b
        L_0x0195:
            r5.setInterpolation(r4)
            r5.getAttributeNames(r2)
        L_0x019b:
            r14 = r19
            r5 = r20
            r15 = r21
            r6 = r27
            r12 = r28
            goto L_0x0126
        L_0x01a6:
            r27 = r6
            r28 = r12
            r19 = r14
            r21 = r15
            goto L_0x01b8
        L_0x01af:
            r27 = r6
            r28 = r12
            r19 = r14
            r21 = r15
            r7 = 0
        L_0x01b8:
            r5 = 0
            if (r7 == 0) goto L_0x01c5
            androidx.constraintlayout.motion.widget.KeyTrigger[] r5 = new androidx.constraintlayout.motion.widget.KeyTrigger[r5]
            java.lang.Object[] r5 = r7.toArray(r5)
            androidx.constraintlayout.motion.widget.KeyTrigger[] r5 = (androidx.constraintlayout.motion.widget.KeyTrigger[]) r5
            r0.mKeyTriggers = r5
        L_0x01c5:
            boolean r5 = r2.isEmpty()
            r12 = 1
            if (r5 != 0) goto L_0x0573
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r0.mAttributesMap = r5
            java.util.Iterator r5 = r2.iterator()
        L_0x01d7:
            boolean r14 = r5.hasNext()
            if (r14 == 0) goto L_0x04f6
            java.lang.Object r14 = r5.next()
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r15 = "CUSTOM,"
            boolean r15 = r14.startsWith(r15)
            if (r15 == 0) goto L_0x023f
            android.util.SparseArray r15 = new android.util.SparseArray
            r15.<init>()
            java.lang.String r6 = ","
            java.lang.String[] r6 = r14.split(r6)
            r6 = r6[r12]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r12 = r0.mKeyList
            java.util.Iterator r12 = r12.iterator()
        L_0x01fe:
            boolean r20 = r12.hasNext()
            if (r20 == 0) goto L_0x0223
            java.lang.Object r20 = r12.next()
            r7 = r20
            androidx.constraintlayout.motion.widget.Key r7 = (androidx.constraintlayout.motion.widget.Key) r7
            r20 = r5
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r5 = r7.mCustomConstraints
            if (r5 != 0) goto L_0x0213
            goto L_0x0220
        L_0x0213:
            java.lang.Object r5 = r5.get(r6)
            androidx.constraintlayout.widget.ConstraintAttribute r5 = (androidx.constraintlayout.widget.ConstraintAttribute) r5
            if (r5 == 0) goto L_0x0220
            int r7 = r7.mFramePosition
            r15.append(r7, r5)
        L_0x0220:
            r5 = r20
            goto L_0x01fe
        L_0x0223:
            r20 = r5
            androidx.constraintlayout.motion.utils.ViewSpline$CustomSet r5 = new androidx.constraintlayout.motion.utils.ViewSpline$CustomSet
            r5.<init>(r14, r15)
            r15 = r18
            r12 = r19
            r7 = r27
            r6 = r28
            r18 = r3
            r19 = r16
            r3 = r17
            r17 = r2
            r2 = r5
            r5 = r21
            goto L_0x04bb
        L_0x023f:
            r20 = r5
            int r5 = r14.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x0434;
                case -1249320805: goto L_0x0417;
                case -1225497657: goto L_0x03fa;
                case -1225497656: goto L_0x03d9;
                case -1225497655: goto L_0x03b6;
                case -1001078227: goto L_0x0391;
                case -908189618: goto L_0x0361;
                case -908189617: goto L_0x033c;
                case -797520672: goto L_0x031c;
                case -760884510: goto L_0x02fd;
                case -760884509: goto L_0x02de;
                case -40300674: goto L_0x02c1;
                case -4379043: goto L_0x02a4;
                case 37232917: goto L_0x0287;
                case 92909918: goto L_0x026a;
                case 156108012: goto L_0x024a;
                default: goto L_0x0248;
            }
        L_0x0248:
            goto L_0x035a
        L_0x024a:
            java.lang.String r5 = "waveOffset"
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x035a
            r5 = 10
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 10
            goto L_0x0451
        L_0x026a:
            boolean r5 = r14.equals(r8)
            if (r5 == 0) goto L_0x035a
            r5 = 0
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 0
            goto L_0x0451
        L_0x0287:
            boolean r5 = r14.equals(r11)
            if (r5 == 0) goto L_0x035a
            r5 = 7
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 7
            goto L_0x0451
        L_0x02a4:
            boolean r5 = r14.equals(r9)
            if (r5 == 0) goto L_0x035a
            r5 = 1
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 1
            goto L_0x0451
        L_0x02c1:
            boolean r5 = r14.equals(r10)
            if (r5 == 0) goto L_0x035a
            r5 = 2
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 2
            goto L_0x0451
        L_0x02de:
            java.lang.String r5 = "transformPivotY"
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x035a
            r5 = 6
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 6
            goto L_0x0451
        L_0x02fd:
            java.lang.String r5 = "transformPivotX"
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x035a
            r5 = 5
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 5
            goto L_0x0451
        L_0x031c:
            java.lang.String r5 = "waveVariesBy"
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x035a
            r5 = 11
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 11
            goto L_0x0451
        L_0x033c:
            boolean r5 = r14.equals(r13)
            if (r5 == 0) goto L_0x035a
            r5 = 9
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 9
            goto L_0x0451
        L_0x035a:
            r15 = r18
            r12 = r19
            r5 = r21
            goto L_0x0383
        L_0x0361:
            r5 = r21
            boolean r6 = r14.equals(r5)
            if (r6 == 0) goto L_0x037f
            r6 = 8
            r15 = r18
            r12 = r19
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 8
            goto L_0x0451
        L_0x037f:
            r15 = r18
            r12 = r19
        L_0x0383:
            r7 = r27
            r6 = r28
        L_0x0387:
            r18 = r3
            r3 = r17
        L_0x038b:
            r17 = r2
            r2 = r16
            goto L_0x044f
        L_0x0391:
            r5 = r21
            r6 = r28
            boolean r7 = r14.equals(r6)
            if (r7 == 0) goto L_0x03af
            r7 = 15
            r15 = r18
            r12 = r19
            r7 = r27
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 15
            goto L_0x0451
        L_0x03af:
            r15 = r18
            r12 = r19
            r7 = r27
            goto L_0x0387
        L_0x03b6:
            r5 = r21
            r7 = r27
            r6 = r28
            boolean r12 = r14.equals(r7)
            if (r12 == 0) goto L_0x03d4
            r12 = 14
            r15 = r18
            r12 = r19
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 14
            goto L_0x0451
        L_0x03d4:
            r15 = r18
            r12 = r19
            goto L_0x0387
        L_0x03d9:
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            boolean r15 = r14.equals(r12)
            if (r15 == 0) goto L_0x03f7
            r15 = 13
            r15 = r18
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 13
            goto L_0x0451
        L_0x03f7:
            r15 = r18
            goto L_0x0387
        L_0x03fa:
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            boolean r18 = r14.equals(r15)
            if (r18 == 0) goto L_0x0387
            r18 = 12
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            r16 = 12
            goto L_0x0451
        L_0x0417:
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            boolean r17 = r14.equals(r3)
            if (r17 == 0) goto L_0x038b
            r17 = 4
            r17 = r2
            r2 = r16
            r16 = 4
            goto L_0x0451
        L_0x0434:
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r3 = r17
            r17 = r2
            r2 = r16
            boolean r16 = r14.equals(r2)
            if (r16 == 0) goto L_0x044f
            r16 = 3
            goto L_0x0451
        L_0x044f:
            r16 = -1
        L_0x0451:
            switch(r16) {
                case 0: goto L_0x04b2;
                case 1: goto L_0x04ac;
                case 2: goto L_0x04a6;
                case 3: goto L_0x04a0;
                case 4: goto L_0x049a;
                case 5: goto L_0x0494;
                case 6: goto L_0x048e;
                case 7: goto L_0x0488;
                case 8: goto L_0x0482;
                case 9: goto L_0x047c;
                case 10: goto L_0x0476;
                case 11: goto L_0x0470;
                case 12: goto L_0x046a;
                case 13: goto L_0x0464;
                case 14: goto L_0x045e;
                case 15: goto L_0x0458;
                default: goto L_0x0454;
            }
        L_0x0454:
            r16 = 0
            goto L_0x04b7
        L_0x0458:
            androidx.constraintlayout.motion.utils.ViewSpline$ProgressSet r16 = new androidx.constraintlayout.motion.utils.ViewSpline$ProgressSet
            r16.<init>()
            goto L_0x04b7
        L_0x045e:
            androidx.constraintlayout.motion.utils.ViewSpline$TranslationZset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$TranslationZset
            r16.<init>()
            goto L_0x04b7
        L_0x0464:
            androidx.constraintlayout.motion.utils.ViewSpline$TranslationYset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$TranslationYset
            r16.<init>()
            goto L_0x04b7
        L_0x046a:
            androidx.constraintlayout.motion.utils.ViewSpline$TranslationXset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$TranslationXset
            r16.<init>()
            goto L_0x04b7
        L_0x0470:
            androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet r16 = new androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet
            r16.<init>()
            goto L_0x04b7
        L_0x0476:
            androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet r16 = new androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet
            r16.<init>()
            goto L_0x04b7
        L_0x047c:
            androidx.constraintlayout.motion.utils.ViewSpline$ScaleYset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$ScaleYset
            r16.<init>()
            goto L_0x04b7
        L_0x0482:
            androidx.constraintlayout.motion.utils.ViewSpline$ScaleXset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$ScaleXset
            r16.<init>()
            goto L_0x04b7
        L_0x0488:
            androidx.constraintlayout.motion.utils.ViewSpline$PathRotate r16 = new androidx.constraintlayout.motion.utils.ViewSpline$PathRotate
            r16.<init>()
            goto L_0x04b7
        L_0x048e:
            androidx.constraintlayout.motion.utils.ViewSpline$PivotYset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$PivotYset
            r16.<init>()
            goto L_0x04b7
        L_0x0494:
            androidx.constraintlayout.motion.utils.ViewSpline$PivotXset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$PivotXset
            r16.<init>()
            goto L_0x04b7
        L_0x049a:
            androidx.constraintlayout.motion.utils.ViewSpline$RotationYset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$RotationYset
            r16.<init>()
            goto L_0x04b7
        L_0x04a0:
            androidx.constraintlayout.motion.utils.ViewSpline$RotationXset r16 = new androidx.constraintlayout.motion.utils.ViewSpline$RotationXset
            r16.<init>()
            goto L_0x04b7
        L_0x04a6:
            androidx.constraintlayout.motion.utils.ViewSpline$RotationSet r16 = new androidx.constraintlayout.motion.utils.ViewSpline$RotationSet
            r16.<init>()
            goto L_0x04b7
        L_0x04ac:
            androidx.constraintlayout.motion.utils.ViewSpline$ElevationSet r16 = new androidx.constraintlayout.motion.utils.ViewSpline$ElevationSet
            r16.<init>()
            goto L_0x04b7
        L_0x04b2:
            androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet r16 = new androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet
            r16.<init>()
        L_0x04b7:
            r19 = r2
            r2 = r16
        L_0x04bb:
            if (r2 != 0) goto L_0x04d5
            r2 = 1
            r21 = r5
            r28 = r6
            r27 = r7
            r2 = r17
            r16 = r19
            r5 = r20
            r17 = r3
            r19 = r12
            r3 = r18
            r12 = 1
            r18 = r15
            goto L_0x01d7
        L_0x04d5:
            r2.mType = r14
            r16 = r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r3 = r0.mAttributesMap
            r3.put(r14, r2)
            r2 = 1
            r21 = r5
            r28 = r6
            r27 = r7
            r2 = r17
            r3 = r18
            r5 = r20
            r18 = r15
            r17 = r16
            r16 = r19
            r19 = r12
            r12 = 1
            goto L_0x01d7
        L_0x04f6:
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r19 = r16
            r16 = r17
            r17 = r2
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r2 = r0.mKeyList
            if (r2 == 0) goto L_0x0526
            java.util.Iterator r2 = r2.iterator()
        L_0x0510:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0526
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.Key r3 = (androidx.constraintlayout.motion.widget.Key) r3
            boolean r14 = r3 instanceof androidx.constraintlayout.motion.widget.KeyAttributes
            if (r14 == 0) goto L_0x0510
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r14 = r0.mAttributesMap
            r3.addValues(r14)
            goto L_0x0510
        L_0x0526:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r2 = r0.mStartPoint
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r3 = r0.mAttributesMap
            r14 = 0
            r2.addValues(r3, r14)
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r2 = r0.mEndPoint
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r3 = r0.mAttributesMap
            r14 = 100
            r2.addValues(r3, r14)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r2 = r0.mAttributesMap
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0541:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0585
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r14 = r4.containsKey(r3)
            if (r14 == 0) goto L_0x0560
            java.lang.Object r14 = r4.get(r3)
            java.lang.Integer r14 = (java.lang.Integer) r14
            if (r14 == 0) goto L_0x0560
            int r14 = r14.intValue()
            goto L_0x0561
        L_0x0560:
            r14 = 0
        L_0x0561:
            r20 = r2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r2 = r0.mAttributesMap
            java.lang.Object r2 = r2.get(r3)
            androidx.constraintlayout.core.motion.utils.SplineSet r2 = (androidx.constraintlayout.core.motion.utils.SplineSet) r2
            if (r2 == 0) goto L_0x0570
            r2.setup(r14)
        L_0x0570:
            r2 = r20
            goto L_0x0541
        L_0x0573:
            r15 = r18
            r12 = r19
            r5 = r21
            r7 = r27
            r6 = r28
            r18 = r3
            r19 = r16
            r16 = r17
            r17 = r2
        L_0x0585:
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0af4
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r2 = r0.mTimeCycleAttributesMap
            if (r2 != 0) goto L_0x0596
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.mTimeCycleAttributesMap = r2
        L_0x0596:
            java.util.Iterator r1 = r1.iterator()
        L_0x059a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0731
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r3 = r0.mTimeCycleAttributesMap
            boolean r3 = r3.containsKey(r2)
            if (r3 == 0) goto L_0x05af
            goto L_0x059a
        L_0x05af:
            java.lang.String r3 = "CUSTOM,"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0609
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.lang.String r14 = ","
            java.lang.String[] r14 = r2.split(r14)
            r20 = 1
            r14 = r14[r20]
            r20 = r1
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.mKeyList
            java.util.Iterator r1 = r1.iterator()
        L_0x05ce:
            boolean r21 = r1.hasNext()
            if (r21 == 0) goto L_0x05f7
            java.lang.Object r21 = r1.next()
            r22 = r1
            r1 = r21
            androidx.constraintlayout.motion.widget.Key r1 = (androidx.constraintlayout.motion.widget.Key) r1
            r21 = r4
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r4 = r1.mCustomConstraints
            if (r4 != 0) goto L_0x05e5
            goto L_0x05f2
        L_0x05e5:
            java.lang.Object r4 = r4.get(r14)
            androidx.constraintlayout.widget.ConstraintAttribute r4 = (androidx.constraintlayout.widget.ConstraintAttribute) r4
            if (r4 == 0) goto L_0x05f2
            int r1 = r1.mFramePosition
            r3.append(r1, r4)
        L_0x05f2:
            r4 = r21
            r1 = r22
            goto L_0x05ce
        L_0x05f7:
            r21 = r4
            androidx.constraintlayout.motion.utils.ViewTimeCycle$CustomSet r1 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$CustomSet
            r1.<init>(r2, r3)
            r4 = r1
            r1 = r16
            r3 = r19
            r16 = r15
            r14 = r33
            goto L_0x071b
        L_0x0609:
            r20 = r1
            r21 = r4
            int r1 = r2.hashCode()
            switch(r1) {
                case -1249320806: goto L_0x06b8;
                case -1249320805: goto L_0x06ab;
                case -1225497657: goto L_0x0697;
                case -1225497656: goto L_0x0688;
                case -1225497655: goto L_0x0679;
                case -1001078227: goto L_0x066a;
                case -908189618: goto L_0x065c;
                case -908189617: goto L_0x064e;
                case -40300674: goto L_0x0640;
                case -4379043: goto L_0x0632;
                case 37232917: goto L_0x0624;
                case 92909918: goto L_0x0616;
                default: goto L_0x0614;
            }
        L_0x0614:
            goto L_0x06a6
        L_0x0616:
            boolean r1 = r2.equals(r8)
            if (r1 == 0) goto L_0x06a6
            r1 = 0
            r1 = r16
            r3 = r19
            r4 = 0
            goto L_0x06c5
        L_0x0624:
            boolean r1 = r2.equals(r11)
            if (r1 == 0) goto L_0x06a6
            r1 = 5
            r1 = r16
            r3 = r19
            r4 = 5
            goto L_0x06c5
        L_0x0632:
            boolean r1 = r2.equals(r9)
            if (r1 == 0) goto L_0x06a6
            r1 = 1
            r1 = r16
            r3 = r19
            r4 = 1
            goto L_0x06c5
        L_0x0640:
            boolean r1 = r2.equals(r10)
            if (r1 == 0) goto L_0x06a6
            r1 = 2
            r1 = r16
            r3 = r19
            r4 = 2
            goto L_0x06c5
        L_0x064e:
            boolean r1 = r2.equals(r13)
            if (r1 == 0) goto L_0x06a6
            r1 = 7
            r1 = r16
            r3 = r19
            r4 = 7
            goto L_0x06c5
        L_0x065c:
            boolean r1 = r2.equals(r5)
            if (r1 == 0) goto L_0x06a6
            r1 = 6
            r1 = r16
            r3 = r19
            r4 = 6
            goto L_0x06c5
        L_0x066a:
            boolean r1 = r2.equals(r6)
            if (r1 == 0) goto L_0x06a6
            r1 = 11
            r1 = r16
            r3 = r19
            r4 = 11
            goto L_0x06c5
        L_0x0679:
            boolean r1 = r2.equals(r7)
            if (r1 == 0) goto L_0x06a6
            r1 = 10
            r1 = r16
            r3 = r19
            r4 = 10
            goto L_0x06c5
        L_0x0688:
            boolean r1 = r2.equals(r12)
            if (r1 == 0) goto L_0x06a6
            r1 = 9
            r1 = r16
            r3 = r19
            r4 = 9
            goto L_0x06c5
        L_0x0697:
            boolean r1 = r2.equals(r15)
            if (r1 == 0) goto L_0x06a6
            r1 = 8
            r1 = r16
            r3 = r19
            r4 = 8
            goto L_0x06c5
        L_0x06a6:
            r1 = r16
        L_0x06a8:
            r3 = r19
            goto L_0x06c4
        L_0x06ab:
            r1 = r16
            boolean r3 = r2.equals(r1)
            if (r3 == 0) goto L_0x06a8
            r3 = 4
            r3 = r19
            r4 = 4
            goto L_0x06c5
        L_0x06b8:
            r1 = r16
            r3 = r19
            boolean r4 = r2.equals(r3)
            if (r4 == 0) goto L_0x06c4
            r4 = 3
            goto L_0x06c5
        L_0x06c4:
            r4 = -1
        L_0x06c5:
            switch(r4) {
                case 0: goto L_0x0710;
                case 1: goto L_0x070a;
                case 2: goto L_0x0704;
                case 3: goto L_0x06fe;
                case 4: goto L_0x06f8;
                case 5: goto L_0x06f2;
                case 6: goto L_0x06ec;
                case 7: goto L_0x06e6;
                case 8: goto L_0x06e0;
                case 9: goto L_0x06da;
                case 10: goto L_0x06d4;
                case 11: goto L_0x06ce;
                default: goto L_0x06c8;
            }
        L_0x06c8:
            r16 = r15
            r14 = r33
            r4 = 0
            goto L_0x071b
        L_0x06ce:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$ProgressSet r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$ProgressSet
            r4.<init>()
            goto L_0x0715
        L_0x06d4:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$TranslationZset r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$TranslationZset
            r4.<init>()
            goto L_0x0715
        L_0x06da:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$TranslationYset r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$TranslationYset
            r4.<init>()
            goto L_0x0715
        L_0x06e0:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$TranslationXset r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$TranslationXset
            r4.<init>()
            goto L_0x0715
        L_0x06e6:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$ScaleYset r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$ScaleYset
            r4.<init>()
            goto L_0x0715
        L_0x06ec:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$ScaleXset r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$ScaleXset
            r4.<init>()
            goto L_0x0715
        L_0x06f2:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate
            r4.<init>()
            goto L_0x0715
        L_0x06f8:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$RotationYset r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$RotationYset
            r4.<init>()
            goto L_0x0715
        L_0x06fe:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$RotationXset r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$RotationXset
            r4.<init>()
            goto L_0x0715
        L_0x0704:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$RotationSet r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$RotationSet
            r4.<init>()
            goto L_0x0715
        L_0x070a:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$ElevationSet r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$ElevationSet
            r4.<init>()
            goto L_0x0715
        L_0x0710:
            androidx.constraintlayout.motion.utils.ViewTimeCycle$AlphaSet r4 = new androidx.constraintlayout.motion.utils.ViewTimeCycle$AlphaSet
            r4.<init>()
        L_0x0715:
            r16 = r15
            r14 = r33
            r4.last_time = r14
        L_0x071b:
            if (r4 != 0) goto L_0x071e
            goto L_0x0725
        L_0x071e:
            r4.mType = r2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r14 = r0.mTimeCycleAttributesMap
            r14.put(r2, r4)
        L_0x0725:
            r19 = r3
            r15 = r16
            r4 = r21
            r16 = r1
            r1 = r20
            goto L_0x059a
        L_0x0731:
            r21 = r4
            r1 = r16
            r3 = r19
            r16 = r15
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r2 = r0.mKeyList
            if (r2 == 0) goto L_0x0ab9
            java.util.Iterator r2 = r2.iterator()
        L_0x0741:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0ab9
            java.lang.Object r4 = r2.next()
            androidx.constraintlayout.motion.widget.Key r4 = (androidx.constraintlayout.motion.widget.Key) r4
            boolean r14 = r4 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r14 == 0) goto L_0x0aad
            androidx.constraintlayout.motion.widget.KeyTimeCycle r4 = (androidx.constraintlayout.motion.widget.KeyTimeCycle) r4
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r14 = r0.mTimeCycleAttributesMap
            if (r4 == 0) goto L_0x0aab
            java.util.Set r15 = r14.keySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x075f:
            boolean r19 = r15.hasNext()
            if (r19 == 0) goto L_0x0aad
            java.lang.Object r19 = r15.next()
            r33 = r2
            r2 = r19
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r19 = r14.get(r2)
            r22 = r19
            androidx.constraintlayout.motion.utils.ViewTimeCycle r22 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r22
            if (r22 != 0) goto L_0x0781
            r28 = r1
            r19 = r14
            r34 = r15
            goto L_0x0a9f
        L_0x0781:
            r19 = r14
            java.lang.String r14 = "CUSTOM"
            boolean r14 = r2.startsWith(r14)
            if (r14 == 0) goto L_0x07e1
            r14 = 7
            java.lang.String r2 = r2.substring(r14)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r14 = r4.mCustomConstraints
            java.lang.Object r2 = r14.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r2 = (androidx.constraintlayout.widget.ConstraintAttribute) r2
            if (r2 == 0) goto L_0x07d9
            r14 = r22
            androidx.constraintlayout.motion.utils.ViewTimeCycle$CustomSet r14 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.CustomSet) r14
            r34 = r15
            int r15 = r4.mFramePosition
            float r0 = r4.mWavePeriod
            r20 = r3
            int r3 = r4.mWaveShape
            r28 = r1
            float r1 = r4.mWaveOffset
            r29 = r4
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintAttribute> r4 = r14.mConstraintAttributeList
            r4.append(r15, r2)
            android.util.SparseArray<float[]> r2 = r14.mWaveProperties
            r4 = 2
            float[] r4 = new float[r4]
            r22 = 0
            r4[r22] = r0
            r0 = 1
            r4[r0] = r1
            r2.append(r15, r4)
            int r0 = r14.mWaveShape
            int r0 = java.lang.Math.max(r0, r3)
            r14.mWaveShape = r0
            r0 = r30
            r2 = r33
            r15 = r34
            r14 = r19
            r3 = r20
            r1 = r28
            r4 = r29
            goto L_0x075f
        L_0x07d9:
            r0 = r30
            r2 = r33
            r14 = r19
            goto L_0x075f
        L_0x07e1:
            r28 = r1
            r20 = r3
            r29 = r4
            r34 = r15
            int r0 = r2.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x08a9;
                case -1249320805: goto L_0x0898;
                case -1225497657: goto L_0x0888;
                case -1225497656: goto L_0x087b;
                case -1225497655: goto L_0x086a;
                case -1001078227: goto L_0x0852;
                case -908189618: goto L_0x0842;
                case -908189617: goto L_0x0832;
                case -40300674: goto L_0x0822;
                case -4379043: goto L_0x0812;
                case 37232917: goto L_0x0802;
                case 92909918: goto L_0x07f2;
                default: goto L_0x07f0;
            }
        L_0x07f0:
            goto L_0x0863
        L_0x07f2:
            boolean r0 = r2.equals(r8)
            if (r0 == 0) goto L_0x0863
            r0 = 0
            r0 = r16
            r3 = r20
            r1 = r28
            r2 = 0
            goto L_0x08b8
        L_0x0802:
            boolean r0 = r2.equals(r11)
            if (r0 == 0) goto L_0x0863
            r0 = 5
            r0 = r16
            r3 = r20
            r1 = r28
            r2 = 5
            goto L_0x08b8
        L_0x0812:
            boolean r0 = r2.equals(r9)
            if (r0 == 0) goto L_0x0863
            r0 = 1
            r0 = r16
            r3 = r20
            r1 = r28
            r2 = 1
            goto L_0x08b8
        L_0x0822:
            boolean r0 = r2.equals(r10)
            if (r0 == 0) goto L_0x0863
            r0 = 2
            r0 = r16
            r3 = r20
            r1 = r28
            r2 = 2
            goto L_0x08b8
        L_0x0832:
            boolean r0 = r2.equals(r13)
            if (r0 == 0) goto L_0x0863
            r0 = 7
            r0 = r16
            r3 = r20
            r1 = r28
            r2 = 7
            goto L_0x08b8
        L_0x0842:
            boolean r0 = r2.equals(r5)
            if (r0 == 0) goto L_0x0863
            r0 = 6
            r0 = r16
            r3 = r20
            r1 = r28
            r2 = 6
            goto L_0x08b8
        L_0x0852:
            boolean r0 = r2.equals(r6)
            if (r0 == 0) goto L_0x0863
            r0 = 11
            r0 = r16
            r3 = r20
            r1 = r28
            r2 = 11
            goto L_0x08b8
        L_0x0863:
            r0 = r16
        L_0x0865:
            r3 = r20
            r1 = r28
            goto L_0x08b7
        L_0x086a:
            boolean r0 = r2.equals(r7)
            if (r0 == 0) goto L_0x0863
            r0 = 10
            r0 = r16
            r3 = r20
            r1 = r28
            r2 = 10
            goto L_0x08b8
        L_0x087b:
            boolean r0 = r2.equals(r12)
            if (r0 == 0) goto L_0x0863
            r0 = 9
            r0 = r16
            r1 = 9
            goto L_0x0892
        L_0x0888:
            r0 = r16
            boolean r1 = r2.equals(r0)
            if (r1 == 0) goto L_0x0865
            r1 = 8
        L_0x0892:
            r2 = r1
            r3 = r20
            r1 = r28
            goto L_0x08b8
        L_0x0898:
            r0 = r16
            r1 = r28
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x08a6
            r2 = 4
            r3 = r20
            goto L_0x08b8
        L_0x08a6:
            r3 = r20
            goto L_0x08b7
        L_0x08a9:
            r0 = r16
            r3 = r20
            r1 = r28
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x08b7
            r2 = 3
            goto L_0x08b8
        L_0x08b7:
            r2 = -1
        L_0x08b8:
            switch(r2) {
                case 0: goto L_0x0a7a;
                case 1: goto L_0x0a54;
                case 2: goto L_0x0a2e;
                case 3: goto L_0x0a07;
                case 4: goto L_0x09e0;
                case 5: goto L_0x09b9;
                case 6: goto L_0x0992;
                case 7: goto L_0x096b;
                case 8: goto L_0x0944;
                case 9: goto L_0x091d;
                case 10: goto L_0x08f6;
                case 11: goto L_0x08c9;
                default: goto L_0x08bb;
            }
        L_0x08bb:
            r2 = r33
            r15 = r34
            r16 = r0
            r14 = r19
            r4 = r29
            r0 = r30
            goto L_0x075f
        L_0x08c9:
            r4 = r29
            float r2 = r4.mProgress
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x08f0
            int r2 = r4.mFramePosition
            float r14 = r4.mProgress
            float r15 = r4.mWavePeriod
            r16 = r0
            int r0 = r4.mWaveShape
            r28 = r1
            float r1 = r4.mWaveOffset
            r23 = r2
            r24 = r14
            r25 = r15
            r26 = r0
            r27 = r1
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x08f0:
            r16 = r0
            r28 = r1
            goto L_0x0a9f
        L_0x08f6:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mTranslationZ
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mTranslationZ
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x091d:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mTranslationY
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mTranslationY
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x0944:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mTranslationX
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mTranslationX
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x096b:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mScaleY
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mScaleY
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x0992:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mScaleX
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mScaleX
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x09b9:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mTransitionPathRotate
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mTransitionPathRotate
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x09e0:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mRotationY
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mRotationY
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x0a07:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mRotationX
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mRotationX
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x0a2e:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mRotation
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mRotation
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x0a54:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mElevation
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mElevation
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
            goto L_0x0a9f
        L_0x0a7a:
            r16 = r0
            r28 = r1
            r4 = r29
            float r0 = r4.mAlpha
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0a9f
            int r0 = r4.mFramePosition
            float r1 = r4.mAlpha
            float r2 = r4.mWavePeriod
            int r14 = r4.mWaveShape
            float r15 = r4.mWaveOffset
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r14
            r27 = r15
            r22.setPoint(r23, r24, r25, r26, r27)
        L_0x0a9f:
            r0 = r30
            r2 = r33
            r15 = r34
            r14 = r19
            r1 = r28
            goto L_0x075f
        L_0x0aab:
            r0 = 0
            throw r0
        L_0x0aad:
            r28 = r1
            r33 = r2
            r0 = r30
            r2 = r33
            r1 = r28
            goto L_0x0741
        L_0x0ab9:
            r0 = 0
            r1 = r30
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r2 = r1.mTimeCycleAttributesMap
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0ac6:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0af6
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r4 = r21
            boolean r5 = r4.containsKey(r3)
            if (r5 == 0) goto L_0x0ae5
            java.lang.Object r5 = r4.get(r3)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x0ae6
        L_0x0ae5:
            r5 = 0
        L_0x0ae6:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r6 = r1.mTimeCycleAttributesMap
            java.lang.Object r3 = r6.get(r3)
            androidx.constraintlayout.motion.utils.ViewTimeCycle r3 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r3
            r3.setup(r5)
            r21 = r4
            goto L_0x0ac6
        L_0x0af4:
            r1 = r0
            r0 = 0
        L_0x0af6:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r2 = r1.mMotionPaths
            int r2 = r2.size()
            int r2 = r2 + 2
            androidx.constraintlayout.motion.widget.MotionPaths[] r3 = new androidx.constraintlayout.motion.widget.MotionPaths[r2]
            androidx.constraintlayout.motion.widget.MotionPaths r4 = r1.mStartMotionPath
            r5 = 0
            r3[r5] = r4
            int r4 = r2 + -1
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r1.mEndMotionPath
            r3[r4] = r6
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r4 = r1.mMotionPaths
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0b1a
            int r4 = r1.mCurveFitType
            r6 = -1
            if (r4 != r6) goto L_0x0b1a
            r1.mCurveFitType = r5
        L_0x0b1a:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r4 = r1.mMotionPaths
            java.util.Iterator r4 = r4.iterator()
            r5 = 1
        L_0x0b21:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0b33
            java.lang.Object r6 = r4.next()
            androidx.constraintlayout.motion.widget.MotionPaths r6 = (androidx.constraintlayout.motion.widget.MotionPaths) r6
            int r7 = r5 + 1
            r3[r5] = r6
            r5 = r7
            goto L_0x0b21
        L_0x0b33:
            r4 = 18
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r1.mEndMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r6 = r6.attributes
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0b46:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0b7e
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            androidx.constraintlayout.motion.widget.MotionPaths r8 = r1.mStartMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r8 = r8.attributes
            boolean r8 = r8.containsKey(r7)
            if (r8 == 0) goto L_0x0b79
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "CUSTOM,"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            r9 = r17
            boolean r8 = r9.contains(r8)
            if (r8 != 0) goto L_0x0b7b
            r5.add(r7)
            goto L_0x0b7b
        L_0x0b79:
            r9 = r17
        L_0x0b7b:
            r17 = r9
            goto L_0x0b46
        L_0x0b7e:
            r6 = 0
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            java.lang.String[] r5 = (java.lang.String[]) r5
            r1.mAttributeNames = r5
            int r5 = r5.length
            int[] r5 = new int[r5]
            r1.mAttributeInterpolatorCount = r5
            r5 = 0
        L_0x0b8f:
            java.lang.String[] r6 = r1.mAttributeNames
            int r7 = r6.length
            if (r5 >= r7) goto L_0x0bc6
            r6 = r6[r5]
            int[] r7 = r1.mAttributeInterpolatorCount
            r8 = 0
            r7[r5] = r8
            r7 = 0
        L_0x0b9c:
            if (r7 >= r2) goto L_0x0bc3
            r8 = r3[r7]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r8 = r8.attributes
            boolean r8 = r8.containsKey(r6)
            if (r8 == 0) goto L_0x0bc0
            r8 = r3[r7]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r8 = r8.attributes
            java.lang.Object r8 = r8.get(r6)
            androidx.constraintlayout.widget.ConstraintAttribute r8 = (androidx.constraintlayout.widget.ConstraintAttribute) r8
            if (r8 == 0) goto L_0x0bc0
            int[] r6 = r1.mAttributeInterpolatorCount
            r7 = r6[r5]
            int r8 = r8.numberOfInterpolatedValues()
            int r8 = r8 + r7
            r6[r5] = r8
            goto L_0x0bc3
        L_0x0bc0:
            int r7 = r7 + 1
            goto L_0x0b9c
        L_0x0bc3:
            int r5 = r5 + 1
            goto L_0x0b8f
        L_0x0bc6:
            r5 = 0
            r5 = r3[r5]
            int r5 = r5.mPathMotionArc
            r6 = -1
            if (r5 == r6) goto L_0x0bd0
            r5 = 1
            goto L_0x0bd1
        L_0x0bd0:
            r5 = 0
        L_0x0bd1:
            java.lang.String[] r6 = r1.mAttributeNames
            int r6 = r6.length
            int r4 = r4 + r6
            boolean[] r6 = new boolean[r4]
            r7 = 1
        L_0x0bd8:
            if (r7 >= r2) goto L_0x0c2c
            r8 = r3[r7]
            int r9 = r7 + -1
            r9 = r3[r9]
            float r10 = r8.x
            float r11 = r9.x
            boolean r10 = r8.diff(r10, r11)
            float r11 = r8.y
            float r12 = r9.y
            boolean r11 = r8.diff(r11, r12)
            r12 = 0
            boolean r13 = r6[r12]
            float r14 = r8.position
            float r15 = r9.position
            boolean r14 = r8.diff(r14, r15)
            r13 = r13 | r14
            r6[r12] = r13
            r12 = 1
            boolean r13 = r6[r12]
            r10 = r10 | r11
            r10 = r10 | r5
            r11 = r13 | r10
            r6[r12] = r11
            r11 = 2
            boolean r12 = r6[r11]
            r10 = r10 | r12
            r6[r11] = r10
            r10 = 3
            boolean r11 = r6[r10]
            float r12 = r8.width
            float r13 = r9.width
            boolean r12 = r8.diff(r12, r13)
            r11 = r11 | r12
            r6[r10] = r11
            r10 = 4
            boolean r11 = r6[r10]
            float r12 = r8.height
            float r9 = r9.height
            boolean r8 = r8.diff(r12, r9)
            r8 = r8 | r11
            r6[r10] = r8
            int r7 = r7 + 1
            goto L_0x0bd8
        L_0x0c2c:
            r5 = 0
            r7 = 1
        L_0x0c2e:
            if (r7 >= r4) goto L_0x0c39
            boolean r8 = r6[r7]
            if (r8 == 0) goto L_0x0c36
            int r5 = r5 + 1
        L_0x0c36:
            int r7 = r7 + 1
            goto L_0x0c2e
        L_0x0c39:
            int[] r7 = new int[r5]
            r1.mInterpolateVariables = r7
            r7 = 2
            int r5 = java.lang.Math.max(r7, r5)
            double[] r7 = new double[r5]
            r1.mInterpolateData = r7
            double[] r5 = new double[r5]
            r1.mInterpolateVelocity = r5
            r5 = 0
            r7 = 1
        L_0x0c4c:
            if (r7 >= r4) goto L_0x0c5c
            boolean r8 = r6[r7]
            if (r8 == 0) goto L_0x0c59
            int[] r8 = r1.mInterpolateVariables
            int r9 = r5 + 1
            r8[r5] = r7
            r5 = r9
        L_0x0c59:
            int r7 = r7 + 1
            goto L_0x0c4c
        L_0x0c5c:
            int[] r4 = r1.mInterpolateVariables
            int r4 = r4.length
            r5 = 2
            int[] r5 = new int[r5]
            r6 = 1
            r5[r6] = r4
            r4 = 0
            r5[r4] = r2
            java.lang.Class<double> r4 = double.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r4, r5)
            double[][] r4 = (double[][]) r4
            double[] r5 = new double[r2]
            r6 = 0
        L_0x0c73:
            if (r6 >= r2) goto L_0x0cbf
            r7 = r3[r6]
            r8 = r4[r6]
            int[] r9 = r1.mInterpolateVariables
            r10 = 6
            float[] r10 = new float[r10]
            float r11 = r7.position
            r12 = 0
            r10[r12] = r11
            float r11 = r7.x
            r12 = 1
            r10[r12] = r11
            float r11 = r7.y
            r12 = 2
            r10[r12] = r11
            float r11 = r7.width
            r12 = 3
            r10[r12] = r11
            float r11 = r7.height
            r13 = 4
            r10[r13] = r11
            float r7 = r7.mPathRotate
            r11 = 5
            r10[r11] = r7
            r7 = 0
            r11 = 0
        L_0x0c9e:
            int r14 = r9.length
            if (r7 >= r14) goto L_0x0cb5
            r14 = r9[r7]
            r15 = 6
            if (r14 >= r15) goto L_0x0cb0
            int r14 = r11 + 1
            r15 = r9[r7]
            r15 = r10[r15]
            double r12 = (double) r15
            r8[r11] = r12
            r11 = r14
        L_0x0cb0:
            int r7 = r7 + 1
            r12 = 3
            r13 = 4
            goto L_0x0c9e
        L_0x0cb5:
            r7 = r3[r6]
            float r7 = r7.time
            double r7 = (double) r7
            r5[r6] = r7
            int r6 = r6 + 1
            goto L_0x0c73
        L_0x0cbf:
            r6 = 0
        L_0x0cc0:
            int[] r7 = r1.mInterpolateVariables
            int r8 = r7.length
            if (r6 >= r8) goto L_0x0cf7
            r7 = r7[r6]
            java.lang.String[] r8 = androidx.constraintlayout.motion.widget.MotionPaths.names
            int r8 = r8.length
            if (r7 >= r8) goto L_0x0cf4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String[] r8 = androidx.constraintlayout.motion.widget.MotionPaths.names
            int[] r9 = r1.mInterpolateVariables
            r9 = r9[r6]
            r8 = r8[r9]
            java.lang.String r9 = " ["
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r7, r8, r9)
            r8 = 0
        L_0x0ce0:
            if (r8 >= r2) goto L_0x0cf4
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            r9 = r4[r8]
            r10 = r9[r6]
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            int r8 = r8 + 1
            goto L_0x0ce0
        L_0x0cf4:
            int r6 = r6 + 1
            goto L_0x0cc0
        L_0x0cf7:
            java.lang.String[] r6 = r1.mAttributeNames
            int r6 = r6.length
            int r6 = r6 + 1
            androidx.constraintlayout.core.motion.utils.CurveFit[] r6 = new androidx.constraintlayout.core.motion.utils.CurveFit[r6]
            r1.mSpline = r6
            r6 = 0
        L_0x0d01:
            java.lang.String[] r7 = r1.mAttributeNames
            int r8 = r7.length
            if (r6 >= r8) goto L_0x0db9
            r7 = r7[r6]
            r8 = 0
            r9 = 0
            r8 = r0
            r9 = 0
            r10 = 0
        L_0x0d0d:
            if (r9 >= r2) goto L_0x0da0
            r11 = r3[r9]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r11 = r11.attributes
            boolean r11 = r11.containsKey(r7)
            if (r11 == 0) goto L_0x0d98
            if (r8 != 0) goto L_0x0d40
            double[] r0 = new double[r2]
            r8 = r3[r9]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r8 = r8.attributes
            java.lang.Object r8 = r8.get(r7)
            androidx.constraintlayout.widget.ConstraintAttribute r8 = (androidx.constraintlayout.widget.ConstraintAttribute) r8
            if (r8 != 0) goto L_0x0d2b
            r8 = 0
            goto L_0x0d2f
        L_0x0d2b:
            int r8 = r8.numberOfInterpolatedValues()
        L_0x0d2f:
            r11 = 2
            int[] r11 = new int[r11]
            r12 = 1
            r11[r12] = r8
            r8 = 0
            r11[r8] = r2
            java.lang.Class<double> r8 = double.class
            java.lang.Object r8 = java.lang.reflect.Array.newInstance(r8, r11)
            double[][] r8 = (double[][]) r8
        L_0x0d40:
            r11 = r3[r9]
            float r11 = r11.time
            double r11 = (double) r11
            r0[r10] = r11
            r11 = r3[r9]
            r12 = r8[r10]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r11 = r11.attributes
            java.lang.Object r11 = r11.get(r7)
            androidx.constraintlayout.widget.ConstraintAttribute r11 = (androidx.constraintlayout.widget.ConstraintAttribute) r11
            if (r11 != 0) goto L_0x0d5c
        L_0x0d55:
            r31 = r0
            r32 = r7
            r33 = r8
            goto L_0x0d91
        L_0x0d5c:
            int r13 = r11.numberOfInterpolatedValues()
            r14 = 1
            if (r13 != r14) goto L_0x0d6c
            float r11 = r11.getValueToInterpolate()
            double r13 = (double) r11
            r11 = 0
            r12[r11] = r13
            goto L_0x0d55
        L_0x0d6c:
            int r13 = r11.numberOfInterpolatedValues()
            float[] r14 = new float[r13]
            r11.getValuesToInterpolate(r14)
            r11 = 0
            r15 = 0
        L_0x0d77:
            if (r11 >= r13) goto L_0x0d55
            int r16 = r15 + 1
            r31 = r0
            r0 = r14[r11]
            r32 = r7
            r33 = r8
            double r7 = (double) r0
            r12[r15] = r7
            int r11 = r11 + 1
            r0 = r31
            r7 = r32
            r8 = r33
            r15 = r16
            goto L_0x0d77
        L_0x0d91:
            int r10 = r10 + 1
            r0 = r31
            r8 = r33
            goto L_0x0d9a
        L_0x0d98:
            r32 = r7
        L_0x0d9a:
            int r9 = r9 + 1
            r7 = r32
            goto L_0x0d0d
        L_0x0da0:
            double[] r0 = java.util.Arrays.copyOf(r0, r10)
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r8, r10)
            double[][] r7 = (double[][]) r7
            androidx.constraintlayout.core.motion.utils.CurveFit[] r8 = r1.mSpline
            int r6 = r6 + 1
            int r9 = r1.mCurveFitType
            androidx.constraintlayout.core.motion.utils.CurveFit r0 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r9, r0, r7)
            r8[r6] = r0
            r0 = 0
            goto L_0x0d01
        L_0x0db9:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r0 = r1.mSpline
            int r6 = r1.mCurveFitType
            androidx.constraintlayout.core.motion.utils.CurveFit r4 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r6, r5, r4)
            r5 = 0
            r0[r5] = r4
            r0 = r3[r5]
            int r0 = r0.mPathMotionArc
            r4 = -1
            if (r0 == r4) goto L_0x0e0d
            int[] r0 = new int[r2]
            double[] r4 = new double[r2]
            r6 = 2
            int[] r7 = new int[r6]
            r8 = 1
            r7[r8] = r6
            r7[r5] = r2
            java.lang.Class<double> r5 = double.class
            java.lang.Object r5 = java.lang.reflect.Array.newInstance(r5, r7)
            double[][] r5 = (double[][]) r5
            r6 = 0
        L_0x0de0:
            if (r6 >= r2) goto L_0x0e06
            r7 = r3[r6]
            int r7 = r7.mPathMotionArc
            r0[r6] = r7
            r7 = r3[r6]
            float r7 = r7.time
            double r7 = (double) r7
            r4[r6] = r7
            r7 = r5[r6]
            r8 = r3[r6]
            float r8 = r8.x
            double r8 = (double) r8
            r10 = 0
            r7[r10] = r8
            r7 = r5[r6]
            r8 = r3[r6]
            float r8 = r8.y
            double r8 = (double) r8
            r10 = 1
            r7[r10] = r8
            int r6 = r6 + 1
            goto L_0x0de0
        L_0x0e06:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit r2 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit
            r2.<init>(r0, r4, r5)
            r1.mArcSpline = r2
        L_0x0e0d:
            r0 = 2143289344(0x7fc00000, float:NaN)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r1.mCycleMap = r2
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r2 = r1.mKeyList
            if (r2 == 0) goto L_0x0e85
            java.util.Iterator r2 = r18.iterator()
        L_0x0e1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0e4d
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.motion.utils.ViewOscillator r4 = androidx.constraintlayout.motion.utils.ViewOscillator.makeSpline(r3)
            if (r4 != 0) goto L_0x0e31
            goto L_0x0e1e
        L_0x0e31:
            int r5 = r4.mVariesBy
            r6 = 1
            if (r5 != r6) goto L_0x0e38
            r5 = 1
            goto L_0x0e39
        L_0x0e38:
            r5 = 0
        L_0x0e39:
            if (r5 == 0) goto L_0x0e45
            boolean r5 = java.lang.Float.isNaN(r0)
            if (r5 == 0) goto L_0x0e45
            float r0 = r30.getPreCycleDistance()
        L_0x0e45:
            r4.mType = r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r5 = r1.mCycleMap
            r5.put(r3, r4)
            goto L_0x0e1e
        L_0x0e4d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r2 = r1.mKeyList
            java.util.Iterator r2 = r2.iterator()
        L_0x0e53:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0e6b
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.Key r3 = (androidx.constraintlayout.motion.widget.Key) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r4 == 0) goto L_0x0e53
            androidx.constraintlayout.motion.widget.KeyCycle r3 = (androidx.constraintlayout.motion.widget.KeyCycle) r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r4 = r1.mCycleMap
            r3.addCycleValues(r4)
            goto L_0x0e53
        L_0x0e6b:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r2 = r1.mCycleMap
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0e75:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0e85
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r3 = (androidx.constraintlayout.motion.utils.ViewOscillator) r3
            r3.setup(r0)
            goto L_0x0e75
        L_0x0e85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.setup(int, int, long):void");
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" start: x: ");
        outline73.append(this.mStartMotionPath.x);
        outline73.append(" y: ");
        outline73.append(this.mStartMotionPath.y);
        outline73.append(" end: x: ");
        outline73.append(this.mEndMotionPath.x);
        outline73.append(" y: ");
        outline73.append(this.mEndMotionPath.y);
        return outline73.toString();
    }
}
