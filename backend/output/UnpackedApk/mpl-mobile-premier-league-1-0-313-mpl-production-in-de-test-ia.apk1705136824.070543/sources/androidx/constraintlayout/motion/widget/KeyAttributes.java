package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KeyAttributes extends Key {
    public float mAlpha = Float.NaN;
    public int mCurveFit = -1;
    public float mElevation = Float.NaN;
    public float mPivotX = Float.NaN;
    public float mPivotY = Float.NaN;
    public float mProgress = Float.NaN;
    public float mRotation = Float.NaN;
    public float mRotationX = Float.NaN;
    public float mRotationY = Float.NaN;
    public float mScaleX = Float.NaN;
    public float mScaleY = Float.NaN;
    public float mTransitionPathRotate = Float.NaN;
    public float mTranslationX = Float.NaN;
    public float mTranslationY = Float.NaN;
    public float mTranslationZ = Float.NaN;
    public boolean mVisibility = false;

    public static class Loader {
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(R$styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(R$styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(R$styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(R$styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(R$styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(R$styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(R$styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(R$styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(R$styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(R$styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(R$styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(R$styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(R$styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyAttributes.mAlpha = typedArray.getFloat(index, keyAttributes.mAlpha);
                        break;
                    case 2:
                        keyAttributes.mElevation = typedArray.getDimension(index, keyAttributes.mElevation);
                        break;
                    case 4:
                        keyAttributes.mRotation = typedArray.getFloat(index, keyAttributes.mRotation);
                        break;
                    case 5:
                        keyAttributes.mRotationX = typedArray.getFloat(index, keyAttributes.mRotationX);
                        break;
                    case 6:
                        keyAttributes.mRotationY = typedArray.getFloat(index, keyAttributes.mRotationY);
                        break;
                    case 7:
                        keyAttributes.mScaleX = typedArray.getFloat(index, keyAttributes.mScaleX);
                        break;
                    case 8:
                        keyAttributes.mTransitionPathRotate = typedArray.getFloat(index, keyAttributes.mTransitionPathRotate);
                        break;
                    case 9:
                        typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                                break;
                            } else {
                                keyAttributes.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            keyAttributes.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyAttributes.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                        break;
                    case 13:
                        keyAttributes.mCurveFit = typedArray.getInteger(index, keyAttributes.mCurveFit);
                        break;
                    case 14:
                        keyAttributes.mScaleY = typedArray.getFloat(index, keyAttributes.mScaleY);
                        break;
                    case 15:
                        keyAttributes.mTranslationX = typedArray.getDimension(index, keyAttributes.mTranslationX);
                        break;
                    case 16:
                        keyAttributes.mTranslationY = typedArray.getDimension(index, keyAttributes.mTranslationY);
                        break;
                    case 17:
                        keyAttributes.mTranslationZ = typedArray.getDimension(index, keyAttributes.mTranslationZ);
                        break;
                    case 18:
                        keyAttributes.mProgress = typedArray.getFloat(index, keyAttributes.mProgress);
                        break;
                    case 19:
                        keyAttributes.mPivotX = typedArray.getDimension(index, keyAttributes.mPivotX);
                        break;
                    case 20:
                        keyAttributes.mPivotY = typedArray.getDimension(index, keyAttributes.mPivotY);
                        break;
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        if (r1.equals("transitionPathRotate") != false) goto L_0x00dd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r6) {
        /*
            r5 = this;
            java.util.Set r0 = r6.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01d0
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r6.get(r1)
            androidx.constraintlayout.core.motion.utils.SplineSet r2 = (androidx.constraintlayout.core.motion.utils.SplineSet) r2
            if (r2 != 0) goto L_0x001d
            goto L_0x0008
        L_0x001d:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            r4 = 7
            if (r3 == 0) goto L_0x003e
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r3 = r5.mCustomConstraints
            java.lang.Object r1 = r3.get(r1)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            if (r1 == 0) goto L_0x0008
            androidx.constraintlayout.motion.utils.ViewSpline$CustomSet r2 = (androidx.constraintlayout.motion.utils.ViewSpline.CustomSet) r2
            int r3 = r5.mFramePosition
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintAttribute> r2 = r2.mConstraintAttributeList
            r2.append(r3, r1)
            goto L_0x0008
        L_0x003e:
            int r3 = r1.hashCode()
            switch(r3) {
                case -1249320806: goto L_0x00d2;
                case -1249320805: goto L_0x00c8;
                case -1225497657: goto L_0x00bd;
                case -1225497656: goto L_0x00b2;
                case -1225497655: goto L_0x00a7;
                case -1001078227: goto L_0x009c;
                case -908189618: goto L_0x0091;
                case -908189617: goto L_0x0086;
                case -760884510: goto L_0x007c;
                case -760884509: goto L_0x0072;
                case -40300674: goto L_0x0067;
                case -4379043: goto L_0x005c;
                case 37232917: goto L_0x0052;
                case 92909918: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x00dc
        L_0x0047:
            java.lang.String r3 = "alpha"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 0
            goto L_0x00dd
        L_0x0052:
            java.lang.String r3 = "transitionPathRotate"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            goto L_0x00dd
        L_0x005c:
            java.lang.String r3 = "elevation"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 1
            goto L_0x00dd
        L_0x0067:
            java.lang.String r3 = "rotation"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 2
            goto L_0x00dd
        L_0x0072:
            java.lang.String r3 = "transformPivotY"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 6
            goto L_0x00dd
        L_0x007c:
            java.lang.String r3 = "transformPivotX"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 5
            goto L_0x00dd
        L_0x0086:
            java.lang.String r3 = "scaleY"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 9
            goto L_0x00dd
        L_0x0091:
            java.lang.String r3 = "scaleX"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 8
            goto L_0x00dd
        L_0x009c:
            java.lang.String r3 = "progress"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 13
            goto L_0x00dd
        L_0x00a7:
            java.lang.String r3 = "translationZ"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 12
            goto L_0x00dd
        L_0x00b2:
            java.lang.String r3 = "translationY"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 11
            goto L_0x00dd
        L_0x00bd:
            java.lang.String r3 = "translationX"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 10
            goto L_0x00dd
        L_0x00c8:
            java.lang.String r3 = "rotationY"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 4
            goto L_0x00dd
        L_0x00d2:
            java.lang.String r3 = "rotationX"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00dc
            r4 = 3
            goto L_0x00dd
        L_0x00dc:
            r4 = -1
        L_0x00dd:
            switch(r4) {
                case 0: goto L_0x01bf;
                case 1: goto L_0x01ae;
                case 2: goto L_0x019d;
                case 3: goto L_0x018c;
                case 4: goto L_0x017b;
                case 5: goto L_0x016a;
                case 6: goto L_0x0159;
                case 7: goto L_0x0148;
                case 8: goto L_0x0137;
                case 9: goto L_0x0126;
                case 10: goto L_0x0115;
                case 11: goto L_0x0104;
                case 12: goto L_0x00f3;
                case 13: goto L_0x00e2;
                default: goto L_0x00e0;
            }
        L_0x00e0:
            goto L_0x0008
        L_0x00e2:
            float r1 = r5.mProgress
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mProgress
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x00f3:
            float r1 = r5.mTranslationZ
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mTranslationZ
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0104:
            float r1 = r5.mTranslationY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mTranslationY
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0115:
            float r1 = r5.mTranslationX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mTranslationX
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0126:
            float r1 = r5.mScaleY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mScaleY
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0137:
            float r1 = r5.mScaleX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mScaleX
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0148:
            float r1 = r5.mTransitionPathRotate
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mTransitionPathRotate
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x0159:
            float r1 = r5.mRotationY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mPivotY
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x016a:
            float r1 = r5.mRotationX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mPivotX
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x017b:
            float r1 = r5.mRotationY
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mRotationY
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x018c:
            float r1 = r5.mRotationX
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mRotationX
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x019d:
            float r1 = r5.mRotation
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mRotation
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x01ae:
            float r1 = r5.mElevation
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mElevation
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x01bf:
            float r1 = r5.mAlpha
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r5.mFramePosition
            float r3 = r5.mAlpha
            r2.setPoint(r1, r3)
            goto L_0x0008
        L_0x01d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.addValues(java.util.HashMap):void");
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute));
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.mCurveFit != -1) {
            if (!Float.isNaN(this.mAlpha)) {
                hashMap.put("alpha", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mElevation)) {
                hashMap.put("elevation", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotation)) {
                hashMap.put("rotation", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotationX)) {
                hashMap.put("rotationX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotationY)) {
                hashMap.put("rotationY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mPivotX)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mPivotY)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationX)) {
                hashMap.put("translationX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationY)) {
                hashMap.put("translationY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationZ)) {
                hashMap.put("translationZ", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTransitionPathRotate)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mScaleX)) {
                hashMap.put("scaleX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mScaleY)) {
                hashMap.put("scaleY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mProgress)) {
                hashMap.put("progress", Integer.valueOf(this.mCurveFit));
            }
            if (this.mCustomConstraints.size() > 0) {
                for (String outline50 : this.mCustomConstraints.keySet()) {
                    hashMap.put(GeneratedOutlineSupport.outline50("CUSTOM,", outline50), Integer.valueOf(this.mCurveFit));
                }
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1913008125: goto L_0x00b9;
                case -1812823328: goto L_0x00ae;
                case -1249320806: goto L_0x00a4;
                case -1249320805: goto L_0x009a;
                case -1225497657: goto L_0x008f;
                case -1225497656: goto L_0x0084;
                case -1225497655: goto L_0x0079;
                case -908189618: goto L_0x006e;
                case -908189617: goto L_0x0063;
                case -760884510: goto L_0x0059;
                case -760884509: goto L_0x004d;
                case -40300674: goto L_0x0042;
                case -4379043: goto L_0x0037;
                case 37232917: goto L_0x002b;
                case 92909918: goto L_0x0020;
                case 579057826: goto L_0x0015;
                case 1941332754: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00c3
        L_0x0009:
            java.lang.String r0 = "visibility"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 12
            goto L_0x00c4
        L_0x0015:
            java.lang.String r0 = "curveFit"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 1
            goto L_0x00c4
        L_0x0020:
            java.lang.String r0 = "alpha"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 0
            goto L_0x00c4
        L_0x002b:
            java.lang.String r0 = "transitionPathRotate"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 13
            goto L_0x00c4
        L_0x0037:
            java.lang.String r0 = "elevation"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 2
            goto L_0x00c4
        L_0x0042:
            java.lang.String r0 = "rotation"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 4
            goto L_0x00c4
        L_0x004d:
            java.lang.String r0 = "transformPivotY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 8
            goto L_0x00c4
        L_0x0059:
            java.lang.String r0 = "transformPivotX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 7
            goto L_0x00c4
        L_0x0063:
            java.lang.String r0 = "scaleY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 10
            goto L_0x00c4
        L_0x006e:
            java.lang.String r0 = "scaleX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 9
            goto L_0x00c4
        L_0x0079:
            java.lang.String r0 = "translationZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 16
            goto L_0x00c4
        L_0x0084:
            java.lang.String r0 = "translationY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 15
            goto L_0x00c4
        L_0x008f:
            java.lang.String r0 = "translationX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 14
            goto L_0x00c4
        L_0x009a:
            java.lang.String r0 = "rotationY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 6
            goto L_0x00c4
        L_0x00a4:
            java.lang.String r0 = "rotationX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 5
            goto L_0x00c4
        L_0x00ae:
            java.lang.String r0 = "transitionEasing"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 11
            goto L_0x00c4
        L_0x00b9:
            java.lang.String r0 = "motionProgress"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c3
            r2 = 3
            goto L_0x00c4
        L_0x00c3:
            r2 = -1
        L_0x00c4:
            switch(r2) {
                case 0: goto L_0x0149;
                case 1: goto L_0x0142;
                case 2: goto L_0x013b;
                case 3: goto L_0x0134;
                case 4: goto L_0x012d;
                case 5: goto L_0x0126;
                case 6: goto L_0x011f;
                case 7: goto L_0x0118;
                case 8: goto L_0x0111;
                case 9: goto L_0x010a;
                case 10: goto L_0x0103;
                case 11: goto L_0x00ff;
                case 12: goto L_0x00e9;
                case 13: goto L_0x00e1;
                case 14: goto L_0x00d9;
                case 15: goto L_0x00d1;
                case 16: goto L_0x00c9;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            goto L_0x014f
        L_0x00c9:
            float r2 = r1.toFloat(r3)
            r1.mTranslationZ = r2
            goto L_0x014f
        L_0x00d1:
            float r2 = r1.toFloat(r3)
            r1.mTranslationY = r2
            goto L_0x014f
        L_0x00d9:
            float r2 = r1.toFloat(r3)
            r1.mTranslationX = r2
            goto L_0x014f
        L_0x00e1:
            float r2 = r1.toFloat(r3)
            r1.mTransitionPathRotate = r2
            goto L_0x014f
        L_0x00e9:
            boolean r2 = r3 instanceof java.lang.Boolean
            if (r2 == 0) goto L_0x00f4
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r2 = r3.booleanValue()
            goto L_0x00fc
        L_0x00f4:
            java.lang.String r2 = r3.toString()
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
        L_0x00fc:
            r1.mVisibility = r2
            goto L_0x014f
        L_0x00ff:
            r3.toString()
            goto L_0x014f
        L_0x0103:
            float r2 = r1.toFloat(r3)
            r1.mScaleY = r2
            goto L_0x014f
        L_0x010a:
            float r2 = r1.toFloat(r3)
            r1.mScaleX = r2
            goto L_0x014f
        L_0x0111:
            float r2 = r1.toFloat(r3)
            r1.mPivotY = r2
            goto L_0x014f
        L_0x0118:
            float r2 = r1.toFloat(r3)
            r1.mPivotX = r2
            goto L_0x014f
        L_0x011f:
            float r2 = r1.toFloat(r3)
            r1.mRotationY = r2
            goto L_0x014f
        L_0x0126:
            float r2 = r1.toFloat(r3)
            r1.mRotationX = r2
            goto L_0x014f
        L_0x012d:
            float r2 = r1.toFloat(r3)
            r1.mRotation = r2
            goto L_0x014f
        L_0x0134:
            float r2 = r1.toFloat(r3)
            r1.mProgress = r2
            goto L_0x014f
        L_0x013b:
            float r2 = r1.toFloat(r3)
            r1.mElevation = r2
            goto L_0x014f
        L_0x0142:
            int r2 = r1.toInt(r3)
            r1.mCurveFit = r2
            goto L_0x014f
        L_0x0149:
            float r2 = r1.toFloat(r3)
            r1.mAlpha = r2
        L_0x014f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.setValue(java.lang.String, java.lang.Object):void");
    }

    public Key clone() {
        KeyAttributes keyAttributes = new KeyAttributes();
        super.copy(this);
        keyAttributes.mCurveFit = this.mCurveFit;
        keyAttributes.mVisibility = this.mVisibility;
        keyAttributes.mAlpha = this.mAlpha;
        keyAttributes.mElevation = this.mElevation;
        keyAttributes.mRotation = this.mRotation;
        keyAttributes.mRotationX = this.mRotationX;
        keyAttributes.mRotationY = this.mRotationY;
        keyAttributes.mPivotX = this.mPivotX;
        keyAttributes.mPivotY = this.mPivotY;
        keyAttributes.mTransitionPathRotate = this.mTransitionPathRotate;
        keyAttributes.mScaleX = this.mScaleX;
        keyAttributes.mScaleY = this.mScaleY;
        keyAttributes.mTranslationX = this.mTranslationX;
        keyAttributes.mTranslationY = this.mTranslationY;
        keyAttributes.mTranslationZ = this.mTranslationZ;
        keyAttributes.mProgress = this.mProgress;
        return keyAttributes;
    }
}
