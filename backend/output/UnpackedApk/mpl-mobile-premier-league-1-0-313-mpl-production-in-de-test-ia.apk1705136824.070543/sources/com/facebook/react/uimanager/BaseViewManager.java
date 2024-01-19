package com.facebook.react.uimanager;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.R$id;
import com.facebook.react.R$string;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactAccessibilityDelegate.AccessibilityRole;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C> implements BaseViewManagerInterface<T> {
    public static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = ((float) Math.sqrt(5.0d));
    public static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    public static final String STATE_BUSY = "busy";
    public static final String STATE_CHECKED = "checked";
    public static final String STATE_EXPANDED = "expanded";
    public static final String STATE_MIXED = "mixed";
    public static MatrixMathHelper$MatrixDecompositionContext sMatrixDecompositionContext = new MatrixMathHelper$MatrixDecompositionContext();
    public static final Map<String, Integer> sStateDescription;
    public static double[] sTransformDecompositionArray = new double[16];

    static {
        HashMap hashMap = new HashMap();
        sStateDescription = hashMap;
        hashMap.put(STATE_BUSY, Integer.valueOf(R$string.state_busy_description));
        sStateDescription.put(STATE_EXPANDED, Integer.valueOf(R$string.state_expanded_description));
        sStateDescription.put("collapsed", Integer.valueOf(R$string.state_collapsed_description));
    }

    private void logUnsupportedPropertyWarning(String str) {
        FLog.w((String) "ReactNative", (String) "%s doesn't support property '%s'", getName(), str);
    }

    public static void resetTransformProperty(View view) {
        view.setTranslationX(ImageOriginUtils.toPixelFromDIP(0.0f));
        view.setTranslationY(ImageOriginUtils.toPixelFromDIP(0.0f));
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(0.0f);
    }

    public static float sanitizeFloatPropertyValue(float f2) {
        if (f2 >= -3.4028235E38f && f2 <= Float.MAX_VALUE) {
            return f2;
        }
        if (f2 < -3.4028235E38f || f2 == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        if (f2 > Float.MAX_VALUE || f2 == Float.POSITIVE_INFINITY) {
            return Float.MAX_VALUE;
        }
        if (Float.isNaN(f2)) {
            return 0.0f;
        }
        throw new IllegalStateException("Invalid float property value: " + f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x0714 A[LOOP:4: B:84:0x0712->B:85:0x0714, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x072c A[LOOP:5: B:87:0x072a->B:88:0x072c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0827  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setTransformProperty(android.view.View r106, com.facebook.react.bridge.ReadableArray r107) {
        /*
            r0 = r106
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r2 = r1.perspective
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext.resetArray(r2)
            double[] r2 = r1.scale
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext.resetArray(r2)
            double[] r2 = r1.skew
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext.resetArray(r2)
            double[] r2 = r1.translation
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext.resetArray(r2)
            double[] r1 = r1.rotationDegrees
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext.resetArray(r1)
            double[] r1 = sTransformDecompositionArray
            java.lang.ThreadLocal<double[]> r2 = com.facebook.react.uimanager.TransformHelper.sHelperMatrix
            java.lang.Object r2 = r2.get()
            double[] r2 = (double[]) r2
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.resetIdentityMatrix(r1)
            int r3 = r107.size()
            r4 = 0
            r5 = 0
        L_0x0030:
            r6 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r8 = 5
            r9 = 10
            r10 = 9
            r14 = 16
            r16 = 11
            r17 = 6
            if (r5 >= r3) goto L_0x0328
            r12 = r107
            com.facebook.react.bridge.ReadableMap r13 = r12.getMap(r5)
            com.facebook.react.bridge.ReadableMapKeySetIterator r20 = r13.keySetIterator()
            java.lang.String r15 = r20.nextKey()
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.resetIdentityMatrix(r2)
            java.lang.String r11 = "matrix"
            boolean r11 = r11.equals(r15)
            if (r11 == 0) goto L_0x0068
            com.facebook.react.bridge.ReadableArray r6 = r13.getArray(r15)
            r7 = 0
        L_0x005d:
            if (r7 >= r14) goto L_0x0191
            double r18 = r6.getDouble(r7)
            r2[r7] = r18
            int r7 = r7 + 1
            goto L_0x005d
        L_0x0068:
            java.lang.String r11 = "perspective"
            boolean r11 = r11.equals(r15)
            if (r11 == 0) goto L_0x0079
            double r13 = r13.getDouble(r15)
            double r6 = r6 / r13
            r2[r16] = r6
            goto L_0x0191
        L_0x0079:
            java.lang.String r6 = "rotateX"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x00a0
            double r6 = com.facebook.react.uimanager.TransformHelper.convertToRadians(r13, r15)
            double r13 = java.lang.Math.cos(r6)
            r2[r8] = r13
            double r13 = java.lang.Math.sin(r6)
            r2[r17] = r13
            double r13 = java.lang.Math.sin(r6)
            double r13 = -r13
            r2[r10] = r13
            double r6 = java.lang.Math.cos(r6)
            r2[r9] = r6
            goto L_0x0191
        L_0x00a0:
            java.lang.String r6 = "rotateY"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x00ca
            double r6 = com.facebook.react.uimanager.TransformHelper.convertToRadians(r13, r15)
            double r13 = java.lang.Math.cos(r6)
            r2[r4] = r13
            double r13 = java.lang.Math.sin(r6)
            double r13 = -r13
            r11 = 2
            r2[r11] = r13
            double r13 = java.lang.Math.sin(r6)
            r11 = 8
            r2[r11] = r13
            double r6 = java.lang.Math.cos(r6)
            r2[r9] = r6
            goto L_0x0191
        L_0x00ca:
            java.lang.String r6 = "rotate"
            boolean r6 = r6.equals(r15)
            if (r6 != 0) goto L_0x01a0
            java.lang.String r6 = "rotateZ"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x00dc
            goto L_0x01a0
        L_0x00dc:
            java.lang.String r6 = "scale"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x00ee
            double r6 = r13.getDouble(r15)
            r2[r4] = r6
            r2[r8] = r6
            goto L_0x0191
        L_0x00ee:
            java.lang.String r6 = "scaleX"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x00fe
            double r6 = r13.getDouble(r15)
            r2[r4] = r6
            goto L_0x0191
        L_0x00fe:
            java.lang.String r6 = "scaleY"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x010e
            double r6 = r13.getDouble(r15)
            r2[r8] = r6
            goto L_0x0191
        L_0x010e:
            java.lang.String r6 = "translate"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x0140
            com.facebook.react.bridge.ReadableArray r6 = r13.getArray(r15)
            double r13 = r6.getDouble(r4)
            r7 = 1
            double r22 = r6.getDouble(r7)
            int r7 = r6.size()
            r11 = 2
            if (r7 <= r11) goto L_0x0131
            double r6 = r6.getDouble(r11)
            r18 = r6
            goto L_0x0133
        L_0x0131:
            r18 = 0
        L_0x0133:
            r6 = 12
            r2[r6] = r13
            r6 = 13
            r2[r6] = r22
            r6 = 14
            r2[r6] = r18
            goto L_0x0191
        L_0x0140:
            r6 = 12
            r7 = 13
            java.lang.String r11 = "translateX"
            boolean r11 = r11.equals(r15)
            if (r11 == 0) goto L_0x0157
            double r13 = r13.getDouble(r15)
            r2[r6] = r13
            r18 = 0
            r2[r7] = r18
            goto L_0x0191
        L_0x0157:
            r18 = 0
            java.lang.String r11 = "translateY"
            boolean r11 = r11.equals(r15)
            if (r11 == 0) goto L_0x016a
            double r13 = r13.getDouble(r15)
            r2[r6] = r18
            r2[r7] = r13
            goto L_0x0191
        L_0x016a:
            java.lang.String r6 = "skewX"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x017e
            double r6 = com.facebook.react.uimanager.TransformHelper.convertToRadians(r13, r15)
            double r6 = java.lang.Math.tan(r6)
            r11 = 4
            r2[r11] = r6
            goto L_0x0191
        L_0x017e:
            java.lang.String r6 = "skewY"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x0194
            double r6 = com.facebook.react.uimanager.TransformHelper.convertToRadians(r13, r15)
            double r6 = java.lang.Math.tan(r6)
            r11 = 1
            r2[r11] = r6
        L_0x0191:
            r6 = 1
            r7 = 4
            goto L_0x01c0
        L_0x0194:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r1 = "Unsupported transform type: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r15)
            r0.<init>(r1)
            throw r0
        L_0x01a0:
            double r6 = com.facebook.react.uimanager.TransformHelper.convertToRadians(r13, r15)
            double r13 = java.lang.Math.cos(r6)
            r2[r4] = r13
            double r13 = java.lang.Math.sin(r6)
            r11 = 1
            r2[r11] = r13
            double r13 = java.lang.Math.sin(r6)
            double r13 = -r13
            r15 = 4
            r2[r15] = r13
            double r6 = java.lang.Math.cos(r6)
            r2[r8] = r6
            goto L_0x0191
        L_0x01c0:
            r13 = r1[r4]
            r18 = r1[r6]
            r6 = 2
            r22 = r1[r6]
            r6 = 3
            r24 = r1[r6]
            r6 = r1[r7]
            r26 = r1[r8]
            r28 = r1[r17]
            r11 = 7
            r30 = r1[r11]
            r11 = 8
            r32 = r1[r11]
            r34 = r1[r10]
            r36 = r1[r9]
            r38 = r1[r16]
            r11 = 12
            r40 = r1[r11]
            r11 = 13
            r42 = r1[r11]
            r11 = 14
            r44 = r1[r11]
            r11 = 15
            r46 = r1[r11]
            r48 = r2[r4]
            r11 = 1
            r50 = r2[r11]
            r11 = 2
            r52 = r2[r11]
            r11 = 3
            r54 = r2[r11]
            double r56 = r48 * r13
            double r58 = r50 * r6
            double r58 = r58 + r56
            double r56 = r52 * r32
            double r56 = r56 + r58
            double r58 = r54 * r40
            double r58 = r58 + r56
            r1[r4] = r58
            double r56 = r48 * r18
            double r58 = r50 * r26
            double r58 = r58 + r56
            double r56 = r52 * r34
            double r56 = r56 + r58
            double r58 = r54 * r42
            double r58 = r58 + r56
            r11 = 1
            r1[r11] = r58
            double r56 = r48 * r22
            double r58 = r50 * r28
            double r58 = r58 + r56
            double r56 = r52 * r36
            double r56 = r56 + r58
            double r58 = r54 * r44
            double r58 = r58 + r56
            r11 = 2
            r1[r11] = r58
            double r48 = r48 * r24
            double r50 = r50 * r30
            double r50 = r50 + r48
            double r52 = r52 * r38
            double r52 = r52 + r50
            double r54 = r54 * r46
            double r54 = r54 + r52
            r11 = 3
            r1[r11] = r54
            r11 = 4
            r48 = r2[r11]
            r50 = r2[r8]
            r52 = r2[r17]
            r15 = 7
            r54 = r2[r15]
            double r56 = r48 * r13
            double r58 = r50 * r6
            double r58 = r58 + r56
            double r56 = r52 * r32
            double r56 = r56 + r58
            double r58 = r54 * r40
            double r58 = r58 + r56
            r1[r11] = r58
            double r56 = r48 * r18
            double r58 = r50 * r26
            double r58 = r58 + r56
            double r56 = r52 * r34
            double r56 = r56 + r58
            double r58 = r54 * r42
            double r58 = r58 + r56
            r1[r8] = r58
            double r56 = r48 * r22
            double r58 = r50 * r28
            double r58 = r58 + r56
            double r56 = r52 * r36
            double r56 = r56 + r58
            double r58 = r54 * r44
            double r58 = r58 + r56
            r1[r17] = r58
            double r48 = r48 * r24
            double r50 = r50 * r30
            double r50 = r50 + r48
            double r52 = r52 * r38
            double r52 = r52 + r50
            double r54 = r54 * r46
            double r54 = r54 + r52
            r8 = 7
            r1[r8] = r54
            r8 = 8
            r48 = r2[r8]
            r50 = r2[r10]
            r52 = r2[r9]
            r54 = r2[r16]
            double r56 = r48 * r13
            double r58 = r50 * r6
            double r58 = r58 + r56
            double r56 = r52 * r32
            double r56 = r56 + r58
            double r58 = r54 * r40
            double r58 = r58 + r56
            r1[r8] = r58
            double r56 = r48 * r18
            double r58 = r50 * r26
            double r58 = r58 + r56
            double r56 = r52 * r34
            double r56 = r56 + r58
            double r58 = r54 * r42
            double r58 = r58 + r56
            r1[r10] = r58
            double r10 = r48 * r22
            double r56 = r50 * r28
            double r56 = r56 + r10
            double r10 = r52 * r36
            double r10 = r10 + r56
            double r56 = r54 * r44
            double r56 = r56 + r10
            r1[r9] = r56
            double r48 = r48 * r24
            double r50 = r50 * r30
            double r50 = r50 + r48
            double r52 = r52 * r38
            double r52 = r52 + r50
            double r54 = r54 * r46
            double r54 = r54 + r52
            r1[r16] = r54
            r8 = 12
            r9 = r2[r8]
            r11 = 13
            r15 = r2[r11]
            r11 = 14
            r48 = r2[r11]
            r11 = 15
            r50 = r2[r11]
            double r13 = r13 * r9
            double r6 = r6 * r15
            double r6 = r6 + r13
            double r32 = r32 * r48
            double r32 = r32 + r6
            double r40 = r40 * r50
            double r40 = r40 + r32
            r1[r8] = r40
            double r18 = r18 * r9
            double r26 = r26 * r15
            double r26 = r26 + r18
            double r34 = r34 * r48
            double r34 = r34 + r26
            double r42 = r42 * r50
            double r42 = r42 + r34
            r6 = 13
            r1[r6] = r42
            double r22 = r22 * r9
            double r28 = r28 * r15
            double r28 = r28 + r22
            double r36 = r36 * r48
            double r36 = r36 + r28
            double r44 = r44 * r50
            double r44 = r44 + r36
            r6 = 14
            r1[r6] = r44
            double r9 = r9 * r24
            double r15 = r15 * r30
            double r15 = r15 + r9
            double r48 = r48 * r38
            double r48 = r48 + r15
            double r50 = r50 * r46
            double r50 = r50 + r48
            r6 = 15
            r1[r6] = r50
            int r5 = r5 + 1
            goto L_0x0030
        L_0x0328:
            double[] r1 = sTransformDecompositionArray
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r2 = sMatrixDecompositionContext
            java.lang.Class<double> r3 = double.class
            int r5 = r1.length
            if (r5 != r14) goto L_0x0333
            r5 = 1
            goto L_0x0334
        L_0x0333:
            r5 = 0
        L_0x0334:
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertCondition(r5)
            double[] r5 = r2.perspective
            double[] r6 = r2.scale
            double[] r7 = r2.skew
            double[] r9 = r2.translation
            double[] r2 = r2.rotationDegrees
            r10 = 15
            r10 = r1[r10]
            boolean r10 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isZero(r10)
            if (r10 == 0) goto L_0x034d
            goto L_0x08af
        L_0x034d:
            r10 = 2
            int[] r10 = new int[r10]
            r10 = {4, 4} // fill-array
            java.lang.Object r10 = java.lang.reflect.Array.newInstance(r3, r10)
            double[][] r10 = (double[][]) r10
            double[] r11 = new double[r14]
            r12 = 4
            r13 = 0
        L_0x035d:
            if (r13 >= r12) goto L_0x0380
            r14 = 0
        L_0x0360:
            if (r14 >= r12) goto L_0x037c
            int r12 = r13 * 4
            int r12 = r12 + r14
            r22 = r1[r12]
            r15 = 15
            r24 = r1[r15]
            double r22 = r22 / r24
            r15 = r10[r13]
            r15[r14] = r22
            r15 = 3
            if (r14 != r15) goto L_0x0376
            r22 = 0
        L_0x0376:
            r11[r12] = r22
            int r14 = r14 + 1
            r12 = 4
            goto L_0x0360
        L_0x037c:
            int r13 = r13 + 1
            r12 = 4
            goto L_0x035d
        L_0x0380:
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r1 = 15
            r11[r1] = r12
            double r14 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.determinant(r11)
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isZero(r14)
            if (r1 == 0) goto L_0x0392
            goto L_0x08af
        L_0x0392:
            r1 = r10[r4]
            r14 = 3
            r22 = r1[r14]
            boolean r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isZero(r22)
            if (r1 == 0) goto L_0x03c0
            r1 = 1
            r15 = r10[r1]
            r22 = r15[r14]
            boolean r15 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isZero(r22)
            if (r15 == 0) goto L_0x03c1
            r15 = 2
            r22 = r10[r15]
            r23 = r22[r14]
            boolean r22 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isZero(r23)
            if (r22 != 0) goto L_0x03b4
            goto L_0x03c1
        L_0x03b4:
            r18 = 0
            r5[r15] = r18
            r5[r1] = r18
            r5[r4] = r18
            r5[r14] = r12
            goto L_0x0711
        L_0x03c0:
            r1 = 1
        L_0x03c1:
            r12 = 4
            double[] r12 = new double[r12]
            r13 = r10[r4]
            r22 = r13[r14]
            r12[r4] = r22
            r13 = r10[r1]
            r22 = r13[r14]
            r12[r1] = r22
            r1 = 2
            r13 = r10[r1]
            r22 = r13[r14]
            r12[r1] = r22
            r13 = r10[r14]
            r22 = r13[r14]
            r12[r14] = r22
            double r22 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.determinant(r11)
            boolean r13 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isZero(r22)
            if (r13 == 0) goto L_0x03e9
            goto L_0x0635
        L_0x03e9:
            r32 = r11[r4]
            r13 = 1
            r34 = r11[r13]
            r36 = r11[r1]
            r13 = r11[r14]
            r1 = 4
            r38 = r11[r1]
            r40 = r11[r8]
            r42 = r11[r17]
            r1 = 7
            r44 = r11[r1]
            r1 = 8
            r46 = r11[r1]
            r1 = 9
            r48 = r11[r1]
            r1 = 10
            r50 = r11[r1]
            r52 = r11[r16]
            r1 = 12
            r54 = r11[r1]
            r1 = 13
            r56 = r11[r1]
            r1 = 14
            r58 = r11[r1]
            r1 = 15
            r60 = r11[r1]
            r1 = 16
            double[] r11 = new double[r1]
            double r62 = r42 * r52
            double r24 = r62 * r56
            double r64 = r44 * r50
            double r26 = r64 * r56
            double r24 = r24 - r26
            double r66 = r44 * r48
            double r26 = r66 * r58
            double r26 = r26 + r24
            double r68 = r40 * r52
            double r24 = r68 * r58
            double r26 = r26 - r24
            double r70 = r42 * r48
            double r24 = r70 * r60
            double r28 = r26 - r24
            double r72 = r40 * r50
            r24 = r72
            r26 = r60
            r30 = r22
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline0(r24, r26, r28, r30)
            r11[r4] = r24
            double r74 = r13 * r50
            double r24 = r74 * r56
            double r76 = r36 * r52
            double r26 = r76 * r56
            double r24 = r24 - r26
            double r78 = r13 * r48
            double r26 = r78 * r58
            double r24 = r24 - r26
            double r80 = r34 * r52
            double r26 = r80 * r58
            double r26 = r26 + r24
            double r82 = r36 * r48
            double r24 = r82 * r60
            double r28 = r24 + r26
            double r84 = r34 * r50
            r24 = r84
            r26 = r60
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline1(r24, r26, r28, r30)
            r1 = 1
            r11[r1] = r24
            double r86 = r36 * r44
            double r24 = r86 * r56
            double r88 = r13 * r42
            double r26 = r88 * r56
            double r24 = r24 - r26
            double r90 = r13 * r40
            double r26 = r90 * r58
            double r26 = r26 + r24
            double r92 = r34 * r44
            double r24 = r92 * r58
            double r26 = r26 - r24
            double r94 = r36 * r40
            double r24 = r94 * r60
            double r28 = r26 - r24
            double r96 = r34 * r42
            r24 = r96
            r26 = r60
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline0(r24, r26, r28, r30)
            r1 = 2
            r11[r1] = r24
            double r24 = r88 * r48
            double r26 = r86 * r48
            double r24 = r24 - r26
            double r26 = r90 * r50
            double r24 = r24 - r26
            double r26 = r92 * r50
            double r26 = r26 + r24
            double r24 = r94 * r52
            double r28 = r24 + r26
            r24 = r96
            r26 = r52
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline1(r24, r26, r28, r30)
            r1 = 3
            r11[r1] = r24
            double r64 = r64 * r54
            double r62 = r62 * r54
            double r64 = r64 - r62
            double r62 = r44 * r46
            double r24 = r62 * r58
            double r64 = r64 - r24
            double r98 = r38 * r52
            double r24 = r98 * r58
            double r24 = r24 + r64
            double r64 = r42 * r46
            double r26 = r64 * r60
            double r28 = r26 + r24
            double r100 = r38 * r50
            r24 = r100
            r26 = r60
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline1(r24, r26, r28, r30)
            r1 = 4
            r11[r1] = r24
            double r76 = r76 * r54
            double r74 = r74 * r54
            double r76 = r76 - r74
            double r74 = r13 * r46
            double r24 = r74 * r58
            double r24 = r24 + r76
            double r76 = r32 * r52
            double r26 = r76 * r58
            double r24 = r24 - r26
            double r102 = r36 * r46
            double r26 = r102 * r60
            double r28 = r24 - r26
            double r104 = r32 * r50
            r24 = r104
            r26 = r60
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline0(r24, r26, r28, r30)
            r11[r8] = r24
            double r24 = r88 * r54
            double r26 = r86 * r54
            double r24 = r24 - r26
            double r13 = r13 * r38
            double r26 = r13 * r58
            double r24 = r24 - r26
            double r44 = r44 * r32
            double r26 = r44 * r58
            double r26 = r26 + r24
            double r36 = r36 * r38
            double r24 = r36 * r60
            double r28 = r24 + r26
            double r42 = r42 * r32
            r24 = r42
            r26 = r60
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline1(r24, r26, r28, r30)
            r11[r17] = r24
            double r86 = r86 * r46
            double r88 = r88 * r46
            double r86 = r86 - r88
            double r24 = r13 * r50
            double r24 = r24 + r86
            double r26 = r44 * r50
            double r24 = r24 - r26
            double r26 = r36 * r52
            double r28 = r24 - r26
            r24 = r42
            r26 = r52
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline0(r24, r26, r28, r30)
            r1 = 7
            r11[r1] = r24
            double r68 = r68 * r54
            double r66 = r66 * r54
            double r68 = r68 - r66
            double r62 = r62 * r56
            double r62 = r62 + r68
            double r98 = r98 * r56
            double r62 = r62 - r98
            double r66 = r40 * r46
            double r24 = r66 * r60
            double r28 = r62 - r24
            double r62 = r38 * r48
            r24 = r62
            r26 = r60
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline0(r24, r26, r28, r30)
            r1 = 8
            r11[r1] = r24
            double r78 = r78 * r54
            double r80 = r80 * r54
            double r78 = r78 - r80
            double r74 = r74 * r56
            double r78 = r78 - r74
            double r76 = r76 * r56
            double r76 = r76 + r78
            double r68 = r34 * r46
            double r24 = r68 * r60
            double r28 = r24 + r76
            double r74 = r32 * r48
            r24 = r74
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline1(r24, r26, r28, r30)
            r1 = 9
            r11[r1] = r24
            double r24 = r92 * r54
            double r26 = r90 * r54
            double r24 = r24 - r26
            double r26 = r13 * r56
            double r26 = r26 + r24
            double r24 = r44 * r56
            double r26 = r26 - r24
            double r34 = r34 * r38
            double r24 = r34 * r60
            double r28 = r26 - r24
            double r32 = r32 * r40
            r24 = r60
            r26 = r32
            double r24 = com.android.tools.r8.GeneratedOutlineSupport.outline0(r24, r26, r28, r30)
            r1 = 10
            r11[r1] = r24
            double r90 = r90 * r46
            double r92 = r92 * r46
            double r90 = r90 - r92
            double r13 = r13 * r48
            double r90 = r90 - r13
            double r44 = r44 * r48
            double r44 = r44 + r90
            double r13 = r34 * r52
            double r28 = r13 + r44
            r24 = r52
            double r13 = com.android.tools.r8.GeneratedOutlineSupport.outline1(r24, r26, r28, r30)
            r11[r16] = r13
            double r70 = r70 * r54
            double r72 = r72 * r54
            double r70 = r70 - r72
            double r64 = r64 * r56
            double r70 = r70 - r64
            double r100 = r100 * r56
            double r100 = r100 + r70
            double r66 = r66 * r58
            double r28 = r66 + r100
            r24 = r62
            r26 = r58
            double r13 = com.android.tools.r8.GeneratedOutlineSupport.outline1(r24, r26, r28, r30)
            r1 = 12
            r11[r1] = r13
            double r84 = r84 * r54
            double r82 = r82 * r54
            double r84 = r84 - r82
            double r102 = r102 * r56
            double r102 = r102 + r84
            double r104 = r104 * r56
            double r102 = r102 - r104
            double r68 = r68 * r58
            double r28 = r102 - r68
            r24 = r74
            double r13 = com.android.tools.r8.GeneratedOutlineSupport.outline0(r24, r26, r28, r30)
            r1 = 13
            r11[r1] = r13
            double r13 = r94 * r54
            double r54 = r54 * r96
            double r13 = r13 - r54
            double r24 = r36 * r56
            double r13 = r13 - r24
            double r56 = r56 * r42
            double r56 = r56 + r13
            double r13 = r34 * r58
            double r28 = r13 + r56
            r24 = r58
            r26 = r32
            double r13 = com.android.tools.r8.GeneratedOutlineSupport.outline1(r24, r26, r28, r30)
            r1 = 14
            r11[r1] = r13
            double r96 = r96 * r46
            double r94 = r94 * r46
            double r96 = r96 - r94
            double r36 = r36 * r48
            double r36 = r36 + r96
            double r42 = r42 * r48
            double r36 = r36 - r42
            double r34 = r34 * r50
            double r28 = r36 - r34
            r24 = r32
            r26 = r50
            double r13 = com.android.tools.r8.GeneratedOutlineSupport.outline0(r24, r26, r28, r30)
            r1 = 15
            r11[r1] = r13
        L_0x0635:
            r1 = 16
            double[] r1 = new double[r1]
            r13 = r11[r4]
            r1[r4] = r13
            r13 = 4
            r14 = r11[r13]
            r22 = 1
            r1[r22] = r14
            r14 = 8
            r23 = r11[r14]
            r14 = 2
            r1[r14] = r23
            r15 = 12
            r23 = r11[r15]
            r15 = 3
            r1[r15] = r23
            r22 = r11[r22]
            r1[r13] = r22
            r22 = r11[r8]
            r1[r8] = r22
            r13 = 9
            r22 = r11[r13]
            r1[r17] = r22
            r15 = 13
            r22 = r11[r15]
            r15 = 7
            r1[r15] = r22
            r22 = r11[r14]
            r14 = 8
            r1[r14] = r22
            r22 = r11[r17]
            r1[r13] = r22
            r13 = 10
            r22 = r11[r13]
            r1[r13] = r22
            r13 = 14
            r21 = r11[r13]
            r1[r16] = r21
            r14 = 3
            r21 = r11[r14]
            r23 = 12
            r1[r23] = r21
            r21 = r11[r15]
            r15 = 13
            r1[r15] = r21
            r21 = r11[r16]
            r1[r13] = r21
            r13 = 15
            r22 = r11[r13]
            r1[r13] = r22
            r22 = r12[r4]
            r11 = 1
            r24 = r12[r11]
            r11 = 2
            r26 = r12[r11]
            r11 = r12[r14]
            r13 = r1[r4]
            double r13 = r13 * r22
            r15 = 4
            r28 = r1[r15]
            double r28 = r28 * r24
            double r28 = r28 + r13
            r13 = 8
            r13 = r1[r13]
            double r13 = r13 * r26
            double r13 = r13 + r28
            r15 = 12
            r28 = r1[r15]
            double r28 = r28 * r11
            double r28 = r28 + r13
            r5[r4] = r28
            r13 = 1
            r14 = r1[r13]
            double r14 = r14 * r22
            r28 = r1[r8]
            double r28 = r28 * r24
            double r28 = r28 + r14
            r8 = 9
            r14 = r1[r8]
            double r14 = r14 * r26
            double r14 = r14 + r28
            r8 = 13
            r28 = r1[r8]
            double r28 = r28 * r11
            double r28 = r28 + r14
            r5[r13] = r28
            r8 = 2
            r13 = r1[r8]
            double r13 = r13 * r22
            r28 = r1[r17]
            double r28 = r28 * r24
            double r28 = r28 + r13
            r13 = 10
            r13 = r1[r13]
            double r13 = r13 * r26
            double r13 = r13 + r28
            r15 = 14
            r20 = r1[r15]
            double r20 = r20 * r11
            double r20 = r20 + r13
            r5[r8] = r20
            r14 = 3
            r20 = r1[r14]
            double r22 = r22 * r20
            r8 = 7
            r20 = r1[r8]
            double r24 = r24 * r20
            double r24 = r24 + r22
            r15 = r1[r16]
            double r26 = r26 * r15
            double r26 = r26 + r24
            r8 = 15
            r15 = r1[r8]
            double r11 = r11 * r15
            double r11 = r11 + r26
            r5[r14] = r11
        L_0x0711:
            r1 = 0
        L_0x0712:
            if (r1 >= r14) goto L_0x071d
            r5 = r10[r14]
            r11 = r5[r1]
            r9[r1] = r11
            int r1 = r1 + 1
            goto L_0x0712
        L_0x071d:
            r1 = 2
            int[] r1 = new int[r1]
            r1 = {3, 3} // fill-array
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r3, r1)
            double[][] r1 = (double[][]) r1
            r3 = 0
        L_0x072a:
            if (r3 >= r14) goto L_0x074a
            r5 = r1[r3]
            r8 = r10[r3]
            r11 = r8[r4]
            r5[r4] = r11
            r5 = r1[r3]
            r8 = r10[r3]
            r9 = 1
            r11 = r8[r9]
            r5[r9] = r11
            r5 = r1[r3]
            r8 = r10[r3]
            r9 = 2
            r11 = r8[r9]
            r5[r9] = r11
            int r3 = r3 + 1
            r14 = 3
            goto L_0x072a
        L_0x074a:
            r3 = r1[r4]
            double r8 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Length(r3)
            r6[r4] = r8
            r3 = r1[r4]
            r8 = r6[r4]
            double[] r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Normalize(r3, r8)
            r1[r4] = r3
            r3 = r1[r4]
            r5 = 1
            r8 = r1[r5]
            double r8 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Dot(r3, r8)
            r7[r4] = r8
            r10 = r1[r5]
            r11 = r1[r4]
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r12 = r7[r4]
            double r14 = -r12
            r12 = r8
            double[] r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Combine(r10, r11, r12, r14)
            r1[r5] = r3
            r3 = r1[r5]
            double r10 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Length(r3)
            r6[r5] = r10
            r3 = r1[r5]
            r10 = r6[r5]
            double[] r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Normalize(r3, r10)
            r1[r5] = r3
            r10 = r7[r4]
            r12 = r6[r5]
            double r10 = r10 / r12
            r7[r4] = r10
            r3 = r1[r4]
            r10 = 2
            r11 = r1[r10]
            double r11 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Dot(r3, r11)
            r7[r5] = r11
            r12 = r1[r10]
            r13 = r1[r4]
            r22 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r14 = r7[r5]
            double r14 = -r14
            r16 = r14
            r14 = r8
            double[] r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Combine(r12, r13, r14, r16)
            r1[r10] = r3
            r3 = r1[r5]
            r8 = r1[r10]
            double r8 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Dot(r3, r8)
            r7[r10] = r8
            r20 = r1[r10]
            r21 = r1[r5]
            r8 = r7[r10]
            double r8 = -r8
            r24 = r8
            double[] r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Combine(r20, r21, r22, r24)
            r1[r10] = r3
            r3 = r1[r10]
            double r8 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Length(r3)
            r6[r10] = r8
            r3 = r1[r10]
            r8 = r6[r10]
            double[] r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Normalize(r3, r8)
            r1[r10] = r3
            r3 = 1
            r8 = r7[r3]
            r11 = r6[r10]
            double r8 = r8 / r11
            r7[r3] = r8
            r8 = r7[r10]
            r11 = r6[r10]
            double r8 = r8 / r11
            r7[r10] = r8
            r5 = r1[r3]
            r7 = r1[r10]
            r8 = 3
            double[] r8 = new double[r8]
            r11 = r5[r3]
            r13 = r7[r10]
            double r11 = r11 * r13
            r13 = r5[r10]
            r15 = r7[r3]
            double r13 = r13 * r15
            double r11 = r11 - r13
            r8[r4] = r11
            r11 = r5[r10]
            r13 = r7[r4]
            double r11 = r11 * r13
            r13 = r5[r4]
            r15 = r7[r10]
            double r13 = r13 * r15
            double r11 = r11 - r13
            r8[r3] = r11
            r11 = r5[r4]
            r13 = r7[r3]
            double r11 = r11 * r13
            r13 = r5[r3]
            r15 = r7[r4]
            double r13 = r13 * r15
            double r11 = r11 - r13
            r8[r10] = r11
            r3 = r1[r4]
            double r7 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.v3Dot(r3, r8)
            r9 = 0
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 >= 0) goto L_0x0850
            r3 = 0
            r5 = 3
        L_0x0829:
            if (r3 >= r5) goto L_0x0850
            r7 = r6[r3]
            r9 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double r7 = r7 * r9
            r6[r3] = r7
            r7 = r1[r3]
            r11 = r7[r4]
            double r11 = r11 * r9
            r7[r4] = r11
            r7 = r1[r3]
            r8 = 1
            r11 = r7[r8]
            double r11 = r11 * r9
            r7[r8] = r11
            r7 = r1[r3]
            r8 = 2
            r11 = r7[r8]
            double r11 = r11 * r9
            r7[r8] = r11
            int r3 = r3 + 1
            goto L_0x0829
        L_0x0850:
            r3 = 2
            r5 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            r7 = r1[r3]
            r8 = 1
            r8 = r7[r8]
            r7 = r1[r3]
            r10 = r7[r3]
            double r7 = java.lang.Math.atan2(r8, r10)
            double r7 = -r7
            double r7 = r7 * r5
            double r7 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.roundTo3Places(r7)
            r2[r4] = r7
            r7 = r1[r3]
            r8 = r7[r4]
            double r7 = -r8
            r9 = r1[r3]
            r10 = 1
            r11 = r9[r10]
            r9 = r1[r3]
            r13 = r9[r10]
            double r11 = r11 * r13
            r9 = r1[r3]
            r13 = r9[r3]
            r9 = r1[r3]
            r15 = r9[r3]
            double r13 = r13 * r15
            double r13 = r13 + r11
            double r9 = java.lang.Math.sqrt(r13)
            double r7 = java.lang.Math.atan2(r7, r9)
            double r7 = -r7
            double r7 = r7 * r5
            double r7 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.roundTo3Places(r7)
            r3 = 1
            r2[r3] = r7
            r3 = r1[r3]
            r7 = r3[r4]
            r1 = r1[r4]
            r9 = r1[r4]
            double r7 = java.lang.Math.atan2(r7, r9)
            double r7 = -r7
            double r7 = r7 * r5
            double r5 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.roundTo3Places(r7)
            r1 = 2
            r2[r1] = r5
        L_0x08af:
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r1 = r1.translation
            r2 = r1[r4]
            float r1 = (float) r2
            float r1 = sanitizeFloatPropertyValue(r1)
            float r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toPixelFromDIP(r1)
            r0.setTranslationX(r1)
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r1 = r1.translation
            r2 = 1
            r2 = r1[r2]
            float r1 = (float) r2
            float r1 = sanitizeFloatPropertyValue(r1)
            float r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toPixelFromDIP(r1)
            r0.setTranslationY(r1)
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r1 = r1.rotationDegrees
            r2 = 2
            r2 = r1[r2]
            float r1 = (float) r2
            float r1 = sanitizeFloatPropertyValue(r1)
            r0.setRotation(r1)
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r1 = r1.rotationDegrees
            r2 = r1[r4]
            float r1 = (float) r2
            float r1 = sanitizeFloatPropertyValue(r1)
            r0.setRotationX(r1)
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r1 = r1.rotationDegrees
            r2 = 1
            r2 = r1[r2]
            float r1 = (float) r2
            float r1 = sanitizeFloatPropertyValue(r1)
            r0.setRotationY(r1)
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r1 = r1.scale
            r2 = r1[r4]
            float r1 = (float) r2
            float r1 = sanitizeFloatPropertyValue(r1)
            r0.setScaleX(r1)
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r1 = r1.scale
            r2 = 1
            r2 = r1[r2]
            float r1 = (float) r2
            float r1 = sanitizeFloatPropertyValue(r1)
            r0.setScaleY(r1)
            com.facebook.react.uimanager.MatrixMathHelper$MatrixDecompositionContext r1 = sMatrixDecompositionContext
            double[] r1 = r1.perspective
            int r2 = r1.length
            r3 = 2
            if (r2 <= r3) goto L_0x0946
            r2 = r1[r3]
            float r1 = (float) r2
            r2 = 0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0930
            r1 = 978111693(0x3a4ccccd, float:7.8125E-4)
        L_0x0930:
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r2 / r1
            android.util.DisplayMetrics r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.sScreenDisplayMetrics
            float r1 = r1.density
            float r1 = r1 * r1
            float r1 = r1 * r2
            float r2 = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER
            float r1 = r1 * r2
            float r1 = sanitizeFloatPropertyValue(r1)
            r0.setCameraDistance(r1)
        L_0x0946:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setTransformProperty(android.view.View, com.facebook.react.bridge.ReadableArray):void");
    }

    private void updateViewAccessibility(T t) {
        ReactAccessibilityDelegate.setDelegate(t);
    }

    private void updateViewContentDescription(T t) {
        String str = (String) t.getTag(R$id.accessibility_label);
        ReadableMap readableMap = (ReadableMap) t.getTag(R$id.accessibility_state);
        String str2 = (String) t.getTag(R$id.accessibility_hint);
        ArrayList arrayList = new ArrayList();
        ReadableMap readableMap2 = (ReadableMap) t.getTag(R$id.accessibility_value);
        if (str != null) {
            arrayList.add(str);
        }
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                Dynamic dynamic = readableMap.getDynamic(nextKey);
                if (nextKey.equals("checked") && dynamic.getType() == ReadableType.String && dynamic.asString().equals(STATE_MIXED)) {
                    arrayList.add(t.getContext().getString(R$string.state_mixed_description));
                } else if (nextKey.equals(STATE_BUSY) && dynamic.getType() == ReadableType.Boolean && dynamic.asBoolean()) {
                    arrayList.add(t.getContext().getString(R$string.state_busy_description));
                } else if (nextKey.equals(STATE_EXPANDED) && dynamic.getType() == ReadableType.Boolean) {
                    arrayList.add(t.getContext().getString(dynamic.asBoolean() ? R$string.state_expanded_description : R$string.state_collapsed_description));
                }
            }
        }
        if (readableMap2 != null && readableMap2.hasKey("text")) {
            Dynamic dynamic2 = readableMap2.getDynamic("text");
            if (dynamic2 != null && dynamic2.getType() == ReadableType.String) {
                arrayList.add(dynamic2.asString());
            }
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (arrayList.size() > 0) {
            t.setContentDescription(TextUtils.join(", ", arrayList));
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put("topAccessibilityAction", ImageOriginUtils.of("registrationName", "onAccessibilityAction"));
        return builder.build();
    }

    public void onAfterUpdateTransaction(T t) {
        super.onAfterUpdateTransaction(t);
        updateViewAccessibility(t);
    }

    @ReactProp(name = "accessibilityActions")
    public void setAccessibilityActions(T t, ReadableArray readableArray) {
        if (readableArray != null) {
            t.setTag(R$id.accessibility_actions, readableArray);
        }
    }

    @ReactProp(name = "accessibilityHint")
    public void setAccessibilityHint(T t, String str) {
        t.setTag(R$id.accessibility_hint, str);
        updateViewContentDescription(t);
    }

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(T t, String str) {
        t.setTag(R$id.accessibility_label, str);
        updateViewContentDescription(t);
    }

    @ReactProp(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(T t, String str) {
        if (str == null || str.equals("none")) {
            ViewCompat.setAccessibilityLiveRegion(t, 0);
        } else if (str.equals("polite")) {
            ViewCompat.setAccessibilityLiveRegion(t, 1);
        } else if (str.equals("assertive")) {
            ViewCompat.setAccessibilityLiveRegion(t, 2);
        }
    }

    @ReactProp(name = "accessibilityRole")
    public void setAccessibilityRole(T t, String str) {
        if (str != null) {
            t.setTag(R$id.accessibility_role, AccessibilityRole.fromValue(str));
        }
    }

    @ReactProp(name = "accessibilityValue")
    public void setAccessibilityValue(T t, ReadableMap readableMap) {
        if (readableMap != null) {
            t.setTag(R$id.accessibility_value, readableMap);
            if (readableMap.hasKey("text")) {
                updateViewContentDescription(t);
            }
        }
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(T t, int i) {
        t.setBackgroundColor(i);
    }

    public void setBorderBottomLeftRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderBottomLeftRadius");
    }

    public void setBorderBottomRightRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderBottomRightRadius");
    }

    public void setBorderRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderRadius");
    }

    public void setBorderTopLeftRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderTopLeftRadius");
    }

    public void setBorderTopRightRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderTopRightRadius");
    }

    @ReactProp(name = "elevation")
    public void setElevation(T t, float f2) {
        ViewCompat.setElevation(t, ImageOriginUtils.toPixelFromDIP(f2));
    }

    @ReactProp(name = "importantForAccessibility")
    public void setImportantForAccessibility(T t, String str) {
        if (str == null || str.equals("auto")) {
            ViewCompat.setImportantForAccessibility(t, 0);
        } else if (str.equals("yes")) {
            ViewCompat.setImportantForAccessibility(t, 1);
        } else if (str.equals("no")) {
            ViewCompat.setImportantForAccessibility(t, 2);
        } else if (str.equals("no-hide-descendants")) {
            ViewCompat.setImportantForAccessibility(t, 4);
        }
    }

    @ReactProp(name = "nativeID")
    public void setNativeId(T t, String str) {
        t.setTag(R$id.view_tag_native_id, str);
        ReactFindViewUtil.notifyViewRendered(t);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(T t, float f2) {
        t.setAlpha(f2);
    }

    @ReactProp(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T t, boolean z) {
        t.setLayerType(z ? 2 : 0, null);
    }

    @ReactProp(name = "rotation")
    @Deprecated
    public void setRotation(T t, float f2) {
        t.setRotation(f2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(T t, float f2) {
        t.setScaleX(f2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(T t, float f2) {
        t.setScaleY(f2);
    }

    @ReactProp(name = "testID")
    public void setTestId(T t, String str) {
        t.setTag(R$id.react_test_id, str);
        t.setTag(str);
    }

    @ReactProp(name = "transform")
    public void setTransform(T t, ReadableArray readableArray) {
        if (readableArray == null) {
            resetTransformProperty(t);
        } else {
            setTransformProperty(t, readableArray);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateX")
    @Deprecated
    public void setTranslateX(T t, float f2) {
        t.setTranslationX(ImageOriginUtils.toPixelFromDIP(f2));
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateY")
    @Deprecated
    public void setTranslateY(T t, float f2) {
        t.setTranslationY(ImageOriginUtils.toPixelFromDIP(f2));
    }

    @ReactProp(name = "accessibilityState")
    public void setViewState(T t, ReadableMap readableMap) {
        if (readableMap != null) {
            t.setTag(R$id.accessibility_state, readableMap);
            t.setSelected(false);
            t.setEnabled(true);
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (true) {
                if (!keySetIterator.hasNextKey()) {
                    break;
                }
                String nextKey = keySetIterator.nextKey();
                if (nextKey.equals(STATE_BUSY) || nextKey.equals(STATE_EXPANDED) || (nextKey.equals("checked") && readableMap.getType("checked") == ReadableType.String)) {
                    updateViewContentDescription(t);
                } else if (t.isAccessibilityFocused()) {
                    t.sendAccessibilityEvent(1);
                }
            }
            updateViewContentDescription(t);
        }
    }

    @ReactProp(name = "zIndex")
    public void setZIndex(T t, float f2) {
        ViewGroupManager.setViewZIndex(t, Math.round(f2));
        ViewParent parent = t.getParent();
        if (parent instanceof ReactZIndexedViewGroup) {
            ((ReactZIndexedViewGroup) parent).updateDrawingOrder();
        }
    }
}
