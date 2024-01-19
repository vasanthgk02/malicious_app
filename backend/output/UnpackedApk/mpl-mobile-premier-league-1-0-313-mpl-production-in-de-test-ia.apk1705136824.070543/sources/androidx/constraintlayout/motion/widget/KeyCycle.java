package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public class KeyCycle extends Key {
    public float mAlpha = Float.NaN;
    public int mCurveFit = 0;
    public String mCustomWaveShape = null;
    public float mElevation = Float.NaN;
    public float mProgress = Float.NaN;
    public float mRotation = Float.NaN;
    public float mRotationX = Float.NaN;
    public float mRotationY = Float.NaN;
    public float mScaleX = Float.NaN;
    public float mScaleY = Float.NaN;
    public String mTransitionEasing = null;
    public float mTransitionPathRotate = Float.NaN;
    public float mTranslationX = Float.NaN;
    public float mTranslationY = Float.NaN;
    public float mTranslationZ = Float.NaN;
    public float mWaveOffset = 0.0f;
    public float mWavePeriod = Float.NaN;
    public float mWavePhase = 0.0f;
    public int mWaveShape = -1;
    public int mWaveVariesBy = -1;

    public static class Loader {
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R$styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R$styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R$styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R$styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R$styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R$styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R$styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R$styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R$styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R$styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R$styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R$styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R$styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R$styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R$styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R$styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R$styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R$styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R$styleable.KeyCycle_motionProgress, 20);
            mAttrMap.append(R$styleable.KeyCycle_wavePhase, 21);
        }

        public static void access$000(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                                break;
                            } else {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            keyCycle.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                        break;
                    case 3:
                        keyCycle.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 4:
                        keyCycle.mCurveFit = typedArray.getInteger(index, keyCycle.mCurveFit);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type != 3) {
                            keyCycle.mWaveShape = typedArray.getInt(index, keyCycle.mWaveShape);
                            break;
                        } else {
                            keyCycle.mCustomWaveShape = typedArray.getString(index);
                            keyCycle.mWaveShape = 7;
                            break;
                        }
                    case 6:
                        keyCycle.mWavePeriod = typedArray.getFloat(index, keyCycle.mWavePeriod);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type != 5) {
                            keyCycle.mWaveOffset = typedArray.getFloat(index, keyCycle.mWaveOffset);
                            break;
                        } else {
                            keyCycle.mWaveOffset = typedArray.getDimension(index, keyCycle.mWaveOffset);
                            break;
                        }
                    case 8:
                        keyCycle.mWaveVariesBy = typedArray.getInt(index, keyCycle.mWaveVariesBy);
                        break;
                    case 9:
                        keyCycle.mAlpha = typedArray.getFloat(index, keyCycle.mAlpha);
                        break;
                    case 10:
                        keyCycle.mElevation = typedArray.getDimension(index, keyCycle.mElevation);
                        break;
                    case 11:
                        keyCycle.mRotation = typedArray.getFloat(index, keyCycle.mRotation);
                        break;
                    case 12:
                        keyCycle.mRotationX = typedArray.getFloat(index, keyCycle.mRotationX);
                        break;
                    case 13:
                        keyCycle.mRotationY = typedArray.getFloat(index, keyCycle.mRotationY);
                        break;
                    case 14:
                        keyCycle.mTransitionPathRotate = typedArray.getFloat(index, keyCycle.mTransitionPathRotate);
                        break;
                    case 15:
                        keyCycle.mScaleX = typedArray.getFloat(index, keyCycle.mScaleX);
                        break;
                    case 16:
                        keyCycle.mScaleY = typedArray.getFloat(index, keyCycle.mScaleY);
                        break;
                    case 17:
                        keyCycle.mTranslationX = typedArray.getDimension(index, keyCycle.mTranslationX);
                        break;
                    case 18:
                        keyCycle.mTranslationY = typedArray.getDimension(index, keyCycle.mTranslationY);
                        break;
                    case 19:
                        keyCycle.mTranslationZ = typedArray.getDimension(index, keyCycle.mTranslationZ);
                        break;
                    case 20:
                        keyCycle.mProgress = typedArray.getFloat(index, keyCycle.mProgress);
                        break;
                    case 21:
                        keyCycle.mWavePhase = typedArray.getFloat(index, keyCycle.mWavePhase) / 360.0f;
                        break;
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bb, code lost:
        if (r3.equals("scaleY") != false) goto L_0x0109;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addCycleValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.util.Set r2 = r18.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x000c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0174
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "CUSTOM"
            boolean r5 = r3.startsWith(r4)
            r6 = 7
            r7 = -1
            if (r5 == 0) goto L_0x006a
            java.lang.String r4 = r3.substring(r6)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r5 = r0.mCustomConstraints
            java.lang.Object r4 = r5.get(r4)
            androidx.constraintlayout.widget.ConstraintAttribute r4 = (androidx.constraintlayout.widget.ConstraintAttribute) r4
            if (r4 == 0) goto L_0x000c
            androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r5 = r4.mType
            androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r6 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE
            if (r5 == r6) goto L_0x0037
            goto L_0x000c
        L_0x0037:
            java.lang.Object r3 = r1.get(r3)
            androidx.constraintlayout.motion.utils.ViewOscillator r3 = (androidx.constraintlayout.motion.utils.ViewOscillator) r3
            if (r3 != 0) goto L_0x0040
            goto L_0x000c
        L_0x0040:
            int r9 = r0.mFramePosition
            int r5 = r0.mWaveShape
            java.lang.String r6 = r0.mCustomWaveShape
            int r14 = r0.mWaveVariesBy
            float r10 = r0.mWavePeriod
            float r11 = r0.mWaveOffset
            float r12 = r0.mWavePhase
            float r13 = r4.getValueToInterpolate()
            java.util.ArrayList<androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$WavePoint> r15 = r3.mWavePoints
            androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$WavePoint r8 = new androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$WavePoint
            r16 = r8
            r8.<init>(r9, r10, r11, r12, r13)
            r15.add(r8)
            if (r14 == r7) goto L_0x0062
            r3.mVariesBy = r14
        L_0x0062:
            r3.mWaveShape = r5
            r3.setCustom(r4)
            r3.mWaveString = r6
            goto L_0x000c
        L_0x006a:
            int r5 = r3.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00fe;
                case -1249320805: goto L_0x00f4;
                case -1225497657: goto L_0x00e9;
                case -1225497656: goto L_0x00de;
                case -1225497655: goto L_0x00d3;
                case -1001078227: goto L_0x00c8;
                case -908189618: goto L_0x00be;
                case -908189617: goto L_0x00b5;
                case -40300674: goto L_0x00ab;
                case -4379043: goto L_0x00a1;
                case 37232917: goto L_0x0096;
                case 92909918: goto L_0x008b;
                case 156108012: goto L_0x007f;
                case 1530034690: goto L_0x0073;
                default: goto L_0x0071;
            }
        L_0x0071:
            goto L_0x0108
        L_0x0073:
            java.lang.String r5 = "wavePhase"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 12
            goto L_0x0109
        L_0x007f:
            java.lang.String r5 = "waveOffset"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 11
            goto L_0x0109
        L_0x008b:
            java.lang.String r5 = "alpha"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 0
            goto L_0x0109
        L_0x0096:
            java.lang.String r5 = "transitionPathRotate"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 5
            goto L_0x0109
        L_0x00a1:
            java.lang.String r5 = "elevation"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 1
            goto L_0x0109
        L_0x00ab:
            java.lang.String r5 = "rotation"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 2
            goto L_0x0109
        L_0x00b5:
            java.lang.String r5 = "scaleY"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            goto L_0x0109
        L_0x00be:
            java.lang.String r5 = "scaleX"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 6
            goto L_0x0109
        L_0x00c8:
            java.lang.String r5 = "progress"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 13
            goto L_0x0109
        L_0x00d3:
            java.lang.String r5 = "translationZ"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 10
            goto L_0x0109
        L_0x00de:
            java.lang.String r5 = "translationY"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 9
            goto L_0x0109
        L_0x00e9:
            java.lang.String r5 = "translationX"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 8
            goto L_0x0109
        L_0x00f4:
            java.lang.String r5 = "rotationY"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 4
            goto L_0x0109
        L_0x00fe:
            java.lang.String r5 = "rotationX"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0108
            r6 = 3
            goto L_0x0109
        L_0x0108:
            r6 = -1
        L_0x0109:
            switch(r6) {
                case 0: goto L_0x0137;
                case 1: goto L_0x0134;
                case 2: goto L_0x0131;
                case 3: goto L_0x012e;
                case 4: goto L_0x012b;
                case 5: goto L_0x0128;
                case 6: goto L_0x0125;
                case 7: goto L_0x0122;
                case 8: goto L_0x011f;
                case 9: goto L_0x011c;
                case 10: goto L_0x0119;
                case 11: goto L_0x0116;
                case 12: goto L_0x0113;
                case 13: goto L_0x0110;
                default: goto L_0x010c;
            }
        L_0x010c:
            r3.startsWith(r4)
            goto L_0x013b
        L_0x0110:
            float r4 = r0.mProgress
            goto L_0x0139
        L_0x0113:
            float r4 = r0.mWavePhase
            goto L_0x0139
        L_0x0116:
            float r4 = r0.mWaveOffset
            goto L_0x0139
        L_0x0119:
            float r4 = r0.mTranslationZ
            goto L_0x0139
        L_0x011c:
            float r4 = r0.mTranslationY
            goto L_0x0139
        L_0x011f:
            float r4 = r0.mTranslationX
            goto L_0x0139
        L_0x0122:
            float r4 = r0.mScaleY
            goto L_0x0139
        L_0x0125:
            float r4 = r0.mScaleX
            goto L_0x0139
        L_0x0128:
            float r4 = r0.mTransitionPathRotate
            goto L_0x0139
        L_0x012b:
            float r4 = r0.mRotationY
            goto L_0x0139
        L_0x012e:
            float r4 = r0.mRotationX
            goto L_0x0139
        L_0x0131:
            float r4 = r0.mRotation
            goto L_0x0139
        L_0x0134:
            float r4 = r0.mElevation
            goto L_0x0139
        L_0x0137:
            float r4 = r0.mAlpha
        L_0x0139:
            r13 = r4
            goto L_0x013f
        L_0x013b:
            r4 = 2143289344(0x7fc00000, float:NaN)
            r13 = 2143289344(0x7fc00000, float:NaN)
        L_0x013f:
            boolean r4 = java.lang.Float.isNaN(r13)
            if (r4 == 0) goto L_0x0147
            goto L_0x000c
        L_0x0147:
            java.lang.Object r3 = r1.get(r3)
            androidx.constraintlayout.motion.utils.ViewOscillator r3 = (androidx.constraintlayout.motion.utils.ViewOscillator) r3
            if (r3 != 0) goto L_0x0151
            goto L_0x000c
        L_0x0151:
            int r9 = r0.mFramePosition
            int r4 = r0.mWaveShape
            java.lang.String r5 = r0.mCustomWaveShape
            int r6 = r0.mWaveVariesBy
            float r10 = r0.mWavePeriod
            float r11 = r0.mWaveOffset
            float r12 = r0.mWavePhase
            java.util.ArrayList<androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$WavePoint> r14 = r3.mWavePoints
            androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$WavePoint r15 = new androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$WavePoint
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13)
            r14.add(r15)
            if (r6 == r7) goto L_0x016e
            r3.mVariesBy = r6
        L_0x016e:
            r3.mWaveShape = r4
            r3.mWaveString = r5
            goto L_0x000c
        L_0x0174:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyCycle.addCycleValues(java.util.HashMap):void");
    }

    public void addValues(HashMap<String, ViewSpline> hashMap) {
        hashMap.size();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(2, stackTrace.length - 1);
        String str = CMap.SPACE;
        for (int i = 1; i <= min; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            stackTrace[i].getFileName();
            stackTrace[i].getLineNumber();
            stackTrace[i].getMethodName();
            str = str + CMap.SPACE;
        }
        for (String next : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(next);
            if (splineSet != null) {
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
                            c2 = 8;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c2 = 9;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c2 = 10;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c2 = 13;
                            break;
                        }
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (next.equals("scaleY")) {
                            c2 = 7;
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
                            c2 = 5;
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 156108012:
                        if (next.equals("waveOffset")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (next.equals("wavePhase")) {
                            c2 = Tokenizer.FF;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        splineSet.setPoint(this.mFramePosition, this.mAlpha);
                        break;
                    case 1:
                        splineSet.setPoint(this.mFramePosition, this.mElevation);
                        break;
                    case 2:
                        splineSet.setPoint(this.mFramePosition, this.mRotation);
                        break;
                    case 3:
                        splineSet.setPoint(this.mFramePosition, this.mRotationX);
                        break;
                    case 4:
                        splineSet.setPoint(this.mFramePosition, this.mRotationY);
                        break;
                    case 5:
                        splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                        break;
                    case 6:
                        splineSet.setPoint(this.mFramePosition, this.mScaleX);
                        break;
                    case 7:
                        splineSet.setPoint(this.mFramePosition, this.mScaleY);
                        break;
                    case 8:
                        splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                        break;
                    case 9:
                        splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                        break;
                    case 10:
                        splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                        break;
                    case 11:
                        splineSet.setPoint(this.mFramePosition, this.mWaveOffset);
                        break;
                    case 12:
                        splineSet.setPoint(this.mFramePosition, this.mWavePhase);
                        break;
                    case 13:
                        splineSet.setPoint(this.mFramePosition, this.mProgress);
                        break;
                    default:
                        boolean startsWith = next.startsWith("CUSTOM");
                        break;
                }
            }
        }
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
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
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
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.access$000(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyCycle));
    }

    public Key clone() {
        KeyCycle keyCycle = new KeyCycle();
        super.copy(this);
        keyCycle.mTransitionEasing = this.mTransitionEasing;
        keyCycle.mCurveFit = this.mCurveFit;
        keyCycle.mWaveShape = this.mWaveShape;
        keyCycle.mCustomWaveShape = this.mCustomWaveShape;
        keyCycle.mWavePeriod = this.mWavePeriod;
        keyCycle.mWaveOffset = this.mWaveOffset;
        keyCycle.mWavePhase = this.mWavePhase;
        keyCycle.mProgress = this.mProgress;
        keyCycle.mWaveVariesBy = this.mWaveVariesBy;
        keyCycle.mAlpha = this.mAlpha;
        keyCycle.mElevation = this.mElevation;
        keyCycle.mRotation = this.mRotation;
        keyCycle.mTransitionPathRotate = this.mTransitionPathRotate;
        keyCycle.mRotationX = this.mRotationX;
        keyCycle.mRotationY = this.mRotationY;
        keyCycle.mScaleX = this.mScaleX;
        keyCycle.mScaleY = this.mScaleY;
        keyCycle.mTranslationX = this.mTranslationX;
        keyCycle.mTranslationY = this.mTranslationY;
        keyCycle.mTranslationZ = this.mTranslationZ;
        return keyCycle;
    }
}
