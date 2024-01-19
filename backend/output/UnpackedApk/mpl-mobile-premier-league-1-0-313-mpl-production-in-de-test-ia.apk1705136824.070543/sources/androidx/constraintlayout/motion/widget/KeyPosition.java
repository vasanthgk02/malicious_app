package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

public class KeyPosition extends KeyPositionBase {
    public float mAltPercentX = Float.NaN;
    public float mAltPercentY = Float.NaN;
    public float mCalculatedPositionX = Float.NaN;
    public float mCalculatedPositionY = Float.NaN;
    public int mDrawPath = 0;
    public int mPathMotionArc = -1;
    public float mPercentHeight = Float.NaN;
    public float mPercentWidth = Float.NaN;
    public float mPercentX = Float.NaN;
    public float mPercentY = Float.NaN;
    public int mPositionType = 0;
    public String mTransitionEasing = null;

    public static class Loader {
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R$styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R$styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R$styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R$styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R$styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R$styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R$styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R$styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R$styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R$styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R$styleable.KeyPosition_pathMotionArc, 10);
        }

        public static void access$000(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                                break;
                            } else {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f2 = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f2;
                        keyPosition.mPercentHeight = f2;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        break;
                }
            }
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.access$000(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyPosition));
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1812823328: goto L_0x0044;
                case -1127236479: goto L_0x003a;
                case -1017587252: goto L_0x0030;
                case -827014263: goto L_0x0026;
                case -200259324: goto L_0x001c;
                case 428090547: goto L_0x0012;
                case 428090548: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "percentY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 6
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "percentX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 5
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "sizePercent"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 4
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "drawPath"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 1
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "percentHeight"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 3
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "percentWidth"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 2
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "transitionEasing"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 0
            goto L_0x004f
        L_0x004e:
            r2 = -1
        L_0x004f:
            switch(r2) {
                case 0: goto L_0x007f;
                case 1: goto L_0x0078;
                case 2: goto L_0x0071;
                case 3: goto L_0x006a;
                case 4: goto L_0x0061;
                case 5: goto L_0x005a;
                case 6: goto L_0x0053;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0085
        L_0x0053:
            float r2 = r1.toFloat(r3)
            r1.mPercentY = r2
            goto L_0x0085
        L_0x005a:
            float r2 = r1.toFloat(r3)
            r1.mPercentX = r2
            goto L_0x0085
        L_0x0061:
            float r2 = r1.toFloat(r3)
            r1.mPercentWidth = r2
            r1.mPercentHeight = r2
            goto L_0x0085
        L_0x006a:
            float r2 = r1.toFloat(r3)
            r1.mPercentHeight = r2
            goto L_0x0085
        L_0x0071:
            float r2 = r1.toFloat(r3)
            r1.mPercentWidth = r2
            goto L_0x0085
        L_0x0078:
            int r2 = r1.toInt(r3)
            r1.mDrawPath = r2
            goto L_0x0085
        L_0x007f:
            java.lang.String r2 = r3.toString()
            r1.mTransitionEasing = r2
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyPosition.setValue(java.lang.String, java.lang.Object):void");
    }

    public Key clone() {
        KeyPosition keyPosition = new KeyPosition();
        super.copy(this);
        keyPosition.mTransitionEasing = this.mTransitionEasing;
        keyPosition.mPathMotionArc = this.mPathMotionArc;
        keyPosition.mDrawPath = this.mDrawPath;
        keyPosition.mPercentWidth = this.mPercentWidth;
        keyPosition.mPercentHeight = Float.NaN;
        keyPosition.mPercentX = this.mPercentX;
        keyPosition.mPercentY = this.mPercentY;
        keyPosition.mAltPercentX = this.mAltPercentX;
        keyPosition.mAltPercentY = this.mAltPercentY;
        keyPosition.mCalculatedPositionX = this.mCalculatedPositionX;
        keyPosition.mCalculatedPositionY = this.mCalculatedPositionY;
        return keyPosition;
    }
}
