package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewSpline.CustomSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.PropertySet;
import androidx.constraintlayout.widget.ConstraintSet.Transform;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public float alpha = 1.0f;
    public LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    public float elevation = 0.0f;
    public float mPathRotate = Float.NaN;
    public float mPivotX = Float.NaN;
    public float mPivotY = Float.NaN;
    public float mProgress = Float.NaN;
    public int mVisibilityMode = 0;
    public float position;
    public float rotation = 0.0f;
    public float rotationX = 0.0f;
    public float rotationY = 0.0f;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float translationX = 0.0f;
    public float translationY = 0.0f;
    public float translationZ = 0.0f;
    public int visibility;

    public void addValues(HashMap<String, ViewSpline> hashMap, int i) {
        for (String next : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(next);
            char c2 = 65535;
            switch (next.hashCode()) {
                case -1249320806:
                    if (next.equals("rotationX")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (next.equals("rotationY")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (next.equals("translationX")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c2 = Tokenizer.FF;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c2 = 13;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case -760884510:
                    if (next.equals("transformPivotX")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -760884509:
                    if (next.equals("transformPivotY")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -40300674:
                    if (next.equals("rotation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (next.equals("elevation")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (next.equals("transitionPathRotate")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            float f2 = 1.0f;
            float f3 = 0.0f;
            switch (c2) {
                case 0:
                    if (!Float.isNaN(this.alpha)) {
                        f2 = this.alpha;
                    }
                    viewSpline.setPoint(i, f2);
                    break;
                case 1:
                    if (!Float.isNaN(this.elevation)) {
                        f3 = this.elevation;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 2:
                    if (!Float.isNaN(this.rotation)) {
                        f3 = this.rotation;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 3:
                    if (!Float.isNaN(this.rotationX)) {
                        f3 = this.rotationX;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 4:
                    if (!Float.isNaN(this.rotationY)) {
                        f3 = this.rotationY;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 5:
                    if (!Float.isNaN(this.mPivotX)) {
                        f3 = this.mPivotX;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 6:
                    if (!Float.isNaN(this.mPivotY)) {
                        f3 = this.mPivotY;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 7:
                    if (!Float.isNaN(this.mPathRotate)) {
                        f3 = this.mPathRotate;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 8:
                    if (!Float.isNaN(this.mProgress)) {
                        f3 = this.mProgress;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 9:
                    if (!Float.isNaN(this.scaleX)) {
                        f2 = this.scaleX;
                    }
                    viewSpline.setPoint(i, f2);
                    break;
                case 10:
                    if (!Float.isNaN(this.scaleY)) {
                        f2 = this.scaleY;
                    }
                    viewSpline.setPoint(i, f2);
                    break;
                case 11:
                    if (!Float.isNaN(this.translationX)) {
                        f3 = this.translationX;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 12:
                    if (!Float.isNaN(this.translationY)) {
                        f3 = this.translationY;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                case 13:
                    if (!Float.isNaN(this.translationZ)) {
                        f3 = this.translationZ;
                    }
                    viewSpline.setPoint(i, f3);
                    break;
                default:
                    if (!next.startsWith("CUSTOM")) {
                        break;
                    } else {
                        String str = next.split(",")[1];
                        if (!this.attributes.containsKey(str)) {
                            break;
                        } else {
                            ConstraintAttribute constraintAttribute = this.attributes.get(str);
                            if (!(viewSpline instanceof CustomSet)) {
                                next + " ViewSpline not a CustomSet frame = " + i + ", value" + constraintAttribute.getValueToInterpolate() + viewSpline;
                                break;
                            } else {
                                ((CustomSet) viewSpline).mConstraintAttributeList.append(i, constraintAttribute);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.elevation = view.getElevation();
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        this.translationZ = view.getTranslationZ();
    }

    public int compareTo(Object obj) {
        return Float.compare(0.0f, ((MotionConstrainedPoint) obj).position);
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

    public void setState(View view) {
        view.getX();
        view.getY();
        view.getWidth();
        view.getHeight();
        applyParameters(view);
    }

    public void setState(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        float f2;
        int i3 = rect.left;
        rect.width();
        rect.height();
        Constraint constraint = constraintSet.get(i2);
        PropertySet propertySet = constraint.propertySet;
        int i4 = propertySet.mVisibilityMode;
        this.mVisibilityMode = i4;
        int i5 = propertySet.visibility;
        this.visibility = i5;
        if (i5 == 0 || i4 != 0) {
            f2 = constraint.propertySet.alpha;
        } else {
            f2 = 0.0f;
        }
        this.alpha = f2;
        Transform transform = constraint.transform;
        boolean z = transform.applyElevation;
        this.elevation = transform.elevation;
        this.rotation = transform.rotation;
        this.rotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.scaleX = transform.scaleX;
        this.scaleY = transform.scaleY;
        this.mPivotX = transform.transformPivotX;
        this.mPivotY = transform.transformPivotY;
        this.translationX = transform.translationX;
        this.translationY = transform.translationY;
        this.translationZ = transform.translationZ;
        Easing.getInterpolator(constraint.motion.mTransitionEasing);
        this.mPathRotate = constraint.motion.mPathRotate;
        this.mProgress = constraint.propertySet.mProgress;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute.isContinuous()) {
                this.attributes.put(next, constraintAttribute);
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            float f3 = this.rotation + 90.0f;
            this.rotation = f3;
            if (f3 > 180.0f) {
                this.rotation = f3 - 360.0f;
                return;
            }
            return;
        }
        this.rotation -= 90.0f;
    }
}
