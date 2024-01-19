package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.Motion;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.LinkedHashMap;

public class MotionPaths implements Comparable<MotionPaths> {
    public static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    public LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    public float height;
    public int mAnimateRelativeTo = -1;
    public int mDrawPath = 0;
    public Easing mKeyFrameEasing;
    public int mMode = 0;
    public int mPathMotionArc = -1;
    public float mPathRotate = Float.NaN;
    public float mRelativeAngle = Float.NaN;
    public MotionController mRelativeToController = null;
    public double[] mTempDelta = new double[18];
    public double[] mTempValue = new double[18];
    public float position;
    public float time;
    public float width;
    public float x;
    public float y;

    public MotionPaths() {
    }

    public void applyParameters(Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        int i = motion.mAnimateCircleAngleTo;
        float f2 = constraint.propertySet.mProgress;
        this.mRelativeAngle = constraint.layout.circleAngle;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.attributes.put(next, constraintAttribute);
            }
        }
    }

    public int compareTo(Object obj) {
        return Float.compare(this.position, ((MotionPaths) obj).position);
    }

    public final boolean diff(float f2, float f3) {
        boolean z = true;
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            if (Float.isNaN(f2) == Float.isNaN(f3)) {
                z = false;
            }
            return z;
        }
        if (Math.abs(f2 - f3) <= 1.0E-6f) {
            z = false;
        }
        return z;
    }

    public void getCenter(double d2, int[] iArr, double[] dArr, float[] fArr, int i) {
        int[] iArr2 = iArr;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f6 = (float) dArr[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f2 = f6;
            } else if (i3 == 2) {
                f3 = f6;
            } else if (i3 == 3) {
                f4 = f6;
            } else if (i3 == 4) {
                f5 = f6;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d2, fArr2, new float[2]);
            float f7 = fArr2[0];
            float f8 = fArr2[1];
            double d3 = (double) f7;
            double d4 = (double) f2;
            double d5 = (double) f3;
            f2 = (float) (((Math.sin(d5) * d4) + d3) - ((double) (f4 / 2.0f)));
            f3 = (float) ((((double) f8) - (Math.cos(d5) * d4)) - ((double) (f5 / 2.0f)));
        }
        fArr[i] = (f4 / 2.0f) + f2 + 0.0f;
        fArr[i + 1] = (f5 / 2.0f) + f3 + 0.0f;
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public void setDpDt(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f4 = f2;
        float f5 = f3;
        int[] iArr2 = iArr;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i = 0; i < iArr2.length; i++) {
            float f10 = (float) dArr[i];
            double d2 = dArr2[i];
            int i2 = iArr2[i];
            if (i2 == 1) {
                f6 = f10;
            } else if (i2 == 2) {
                f8 = f10;
            } else if (i2 == 3) {
                f7 = f10;
            } else if (i2 == 4) {
                f9 = f10;
            }
        }
        float f11 = f6 - ((0.0f * f7) / 2.0f);
        float f12 = f8 - ((0.0f * f9) / 2.0f);
        fArr[0] = GeneratedOutlineSupport.outline4((f7 * 1.0f) + f11, f2, (1.0f - f4) * f11, 0.0f);
        fArr[1] = GeneratedOutlineSupport.outline4((f9 * 1.0f) + f12, f5, (1.0f - f5) * f12, 0.0f);
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d2 = (double) ((((this.width / 2.0f) + this.x) - motionPaths.x) - (motionPaths.width / 2.0f));
        double d3 = (double) ((((this.height / 2.0f) + this.y) - motionPaths.y) - (motionPaths.height / 2.0f));
        this.mRelativeToController = motionController;
        this.x = (float) Math.hypot(d3, d2);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.y = (float) (Math.atan2(d3, d2) + 1.5707963267948966d);
        } else {
            this.y = (float) Math.toRadians((double) this.mRelativeAngle);
        }
    }

    public MotionPaths(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2;
        int i3;
        float f3;
        float f4;
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        if (motionPaths3.mAnimateRelativeTo != -1) {
            float f5 = ((float) keyPosition2.mFramePosition) / 100.0f;
            this.time = f5;
            this.mDrawPath = keyPosition2.mDrawPath;
            this.mMode = keyPosition2.mPositionType;
            float f6 = Float.isNaN(keyPosition2.mPercentWidth) ? f5 : keyPosition2.mPercentWidth;
            float f7 = Float.isNaN(keyPosition2.mPercentHeight) ? f5 : keyPosition2.mPercentHeight;
            float f8 = motionPaths4.width;
            float f9 = motionPaths3.width;
            float f10 = motionPaths4.height;
            float f11 = motionPaths3.height;
            this.position = this.time;
            this.width = (float) ((int) (((f8 - f9) * f6) + f9));
            this.height = (float) ((int) (((f10 - f11) * f7) + f11));
            int i4 = keyPosition2.mPositionType;
            if (i4 == 1) {
                float f12 = Float.isNaN(keyPosition2.mPercentX) ? f5 : keyPosition2.mPercentX;
                float f13 = motionPaths4.x;
                float f14 = motionPaths3.x;
                this.x = GeneratedOutlineSupport.outline3(f13, f14, f12, f14);
                f5 = !Float.isNaN(keyPosition2.mPercentY) ? keyPosition2.mPercentY : f5;
                float f15 = motionPaths4.y;
                float f16 = motionPaths3.y;
                this.y = GeneratedOutlineSupport.outline3(f15, f16, f5, f16);
            } else if (i4 != 2) {
                float f17 = Float.isNaN(keyPosition2.mPercentX) ? f5 : keyPosition2.mPercentX;
                float f18 = motionPaths4.x;
                float f19 = motionPaths3.x;
                this.x = GeneratedOutlineSupport.outline3(f18, f19, f17, f19);
                f5 = !Float.isNaN(keyPosition2.mPercentY) ? keyPosition2.mPercentY : f5;
                float f20 = motionPaths4.y;
                float f21 = motionPaths3.y;
                this.y = GeneratedOutlineSupport.outline3(f20, f21, f5, f21);
            } else {
                if (Float.isNaN(keyPosition2.mPercentX)) {
                    float f22 = motionPaths4.x;
                    float f23 = motionPaths3.x;
                    f3 = GeneratedOutlineSupport.outline3(f22, f23, f5, f23);
                } else {
                    f3 = keyPosition2.mPercentX * Math.min(f7, f6);
                }
                this.x = f3;
                if (Float.isNaN(keyPosition2.mPercentY)) {
                    float f24 = motionPaths4.y;
                    float f25 = motionPaths3.y;
                    f4 = GeneratedOutlineSupport.outline3(f24, f25, f5, f25);
                } else {
                    f4 = keyPosition2.mPercentY;
                }
                this.y = f4;
            }
            this.mAnimateRelativeTo = motionPaths3.mAnimateRelativeTo;
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition2.mTransitionEasing);
            this.mPathMotionArc = keyPosition2.mPathMotionArc;
            return;
        }
        int i5 = keyPosition2.mPositionType;
        if (i5 == 1) {
            MotionPaths motionPaths5 = motionPaths3;
            float f26 = ((float) keyPosition2.mFramePosition) / 100.0f;
            this.time = f26;
            this.mDrawPath = keyPosition2.mDrawPath;
            float f27 = Float.isNaN(keyPosition2.mPercentWidth) ? f26 : keyPosition2.mPercentWidth;
            float f28 = Float.isNaN(keyPosition2.mPercentHeight) ? f26 : keyPosition2.mPercentHeight;
            float f29 = motionPaths4.width - motionPaths5.width;
            float f30 = motionPaths4.height - motionPaths5.height;
            this.position = this.time;
            f26 = !Float.isNaN(keyPosition2.mPercentX) ? keyPosition2.mPercentX : f26;
            float f31 = motionPaths5.x;
            float f32 = motionPaths5.width;
            float f33 = motionPaths5.y;
            float f34 = motionPaths5.height;
            float f35 = ((motionPaths4.width / 2.0f) + motionPaths4.x) - ((f32 / 2.0f) + f31);
            float f36 = ((motionPaths4.height / 2.0f) + motionPaths4.y) - ((f34 / 2.0f) + f33);
            float f37 = f35 * f26;
            float f38 = f29 * f27;
            float f39 = f38 / 2.0f;
            this.x = (float) ((int) ((f31 + f37) - f39));
            float f40 = f26 * f36;
            float f41 = f30 * f28;
            float f42 = f41 / 2.0f;
            this.y = (float) ((int) ((f33 + f40) - f42));
            this.width = (float) ((int) (f32 + f38));
            this.height = (float) ((int) (f34 + f41));
            KeyPosition keyPosition3 = keyPosition;
            float f43 = Float.isNaN(keyPosition3.mPercentY) ? 0.0f : keyPosition3.mPercentY;
            float f44 = (-f36) * f43;
            float f45 = f35 * f43;
            this.mMode = 1;
            MotionPaths motionPaths6 = motionPaths;
            float f46 = (float) ((int) ((motionPaths6.x + f37) - f39));
            this.x = f46;
            float f47 = (float) ((int) ((motionPaths6.y + f40) - f42));
            this.y = f47;
            this.x = f46 + f44;
            this.y = f47 + f45;
            this.mAnimateRelativeTo = this.mAnimateRelativeTo;
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition3.mTransitionEasing);
            this.mPathMotionArc = keyPosition3.mPathMotionArc;
        } else if (i5 != 2) {
            float f48 = ((float) keyPosition2.mFramePosition) / 100.0f;
            this.time = f48;
            this.mDrawPath = keyPosition2.mDrawPath;
            float f49 = Float.isNaN(keyPosition2.mPercentWidth) ? f48 : keyPosition2.mPercentWidth;
            float f50 = Float.isNaN(keyPosition2.mPercentHeight) ? f48 : keyPosition2.mPercentHeight;
            float f51 = motionPaths4.width;
            float f52 = motionPaths3.width;
            float f53 = f51 - f52;
            float f54 = motionPaths4.height;
            float f55 = motionPaths3.height;
            float f56 = f54 - f55;
            this.position = this.time;
            float f57 = motionPaths3.x;
            float f58 = motionPaths3.y;
            float f59 = ((f51 / 2.0f) + motionPaths4.x) - ((f52 / 2.0f) + f57);
            float f60 = ((f54 / 2.0f) + motionPaths4.y) - ((f55 / 2.0f) + f58);
            float f61 = f53 * f49;
            float f62 = f61 / 2.0f;
            this.x = (float) ((int) (((f59 * f48) + f57) - f62));
            float f63 = (f60 * f48) + f58;
            float f64 = f56 * f50;
            float f65 = f64 / 2.0f;
            this.y = (float) ((int) (f63 - f65));
            this.width = (float) ((int) (f52 + f61));
            this.height = (float) ((int) (f55 + f64));
            KeyPosition keyPosition4 = keyPosition;
            float f66 = Float.isNaN(keyPosition4.mPercentX) ? f48 : keyPosition4.mPercentX;
            float f67 = Float.isNaN(keyPosition4.mAltPercentY) ? 0.0f : keyPosition4.mAltPercentY;
            f48 = !Float.isNaN(keyPosition4.mPercentY) ? keyPosition4.mPercentY : f48;
            if (Float.isNaN(keyPosition4.mAltPercentX)) {
                i3 = 0;
                f2 = 0.0f;
            } else {
                f2 = keyPosition4.mAltPercentX;
                i3 = 0;
            }
            this.mMode = i3;
            MotionPaths motionPaths7 = motionPaths;
            this.x = (float) ((int) (((f2 * f60) + ((f66 * f59) + motionPaths7.x)) - f62));
            this.y = (float) ((int) (((f60 * f48) + ((f59 * f67) + motionPaths7.y)) - f65));
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition4.mTransitionEasing);
            this.mPathMotionArc = keyPosition4.mPathMotionArc;
        } else {
            MotionPaths motionPaths8 = motionPaths3;
            KeyPosition keyPosition5 = keyPosition2;
            float f68 = ((float) keyPosition5.mFramePosition) / 100.0f;
            this.time = f68;
            this.mDrawPath = keyPosition5.mDrawPath;
            float f69 = Float.isNaN(keyPosition5.mPercentWidth) ? f68 : keyPosition5.mPercentWidth;
            float f70 = Float.isNaN(keyPosition5.mPercentHeight) ? f68 : keyPosition5.mPercentHeight;
            float f71 = motionPaths4.width;
            float f72 = motionPaths8.width;
            float f73 = f71 - f72;
            float f74 = motionPaths4.height;
            float f75 = motionPaths8.height;
            float f76 = f74 - f75;
            this.position = this.time;
            float f77 = motionPaths8.x;
            float f78 = motionPaths8.y;
            float f79 = (f71 / 2.0f) + motionPaths4.x;
            float f80 = (f74 / 2.0f) + motionPaths4.y;
            float f81 = f73 * f69;
            this.x = (float) ((int) ((((f79 - ((f72 / 2.0f) + f77)) * f68) + f77) - (f81 / 2.0f)));
            float f82 = f76 * f70;
            this.y = (float) ((int) ((((f80 - ((f75 / 2.0f) + f78)) * f68) + f78) - (f82 / 2.0f)));
            this.width = (float) ((int) (f72 + f81));
            this.height = (float) ((int) (f75 + f82));
            this.mMode = 2;
            KeyPosition keyPosition6 = keyPosition;
            if (!Float.isNaN(keyPosition6.mPercentX)) {
                this.x = (float) ((int) (keyPosition6.mPercentX * ((float) ((int) (((float) i) - this.width)))));
            }
            if (!Float.isNaN(keyPosition6.mPercentY)) {
                this.y = (float) ((int) (keyPosition6.mPercentY * ((float) ((int) (((float) i2) - this.height)))));
            }
            this.mAnimateRelativeTo = this.mAnimateRelativeTo;
            this.mKeyFrameEasing = Easing.getInterpolator(keyPosition6.mTransitionEasing);
            this.mPathMotionArc = keyPosition6.mPathMotionArc;
        }
    }
}
