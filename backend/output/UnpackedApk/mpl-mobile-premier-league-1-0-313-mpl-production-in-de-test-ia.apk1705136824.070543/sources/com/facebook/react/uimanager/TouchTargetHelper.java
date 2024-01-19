package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.UiThreadUtil;

public class TouchTargetHelper {
    public static final float[] mEventCoords = new float[2];
    public static final Matrix mInverseMatrix = new Matrix();
    public static final float[] mMatrixTransformCoords = new float[2];
    public static final PointF mTempPoint = new PointF();

    public static int findTargetTagAndCoordinatesForTouch(float f2, float f3, ViewGroup viewGroup, float[] fArr, int[] iArr) {
        int i;
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        fArr[0] = f2;
        fArr[1] = f3;
        View findTouchTargetView = findTouchTargetView(fArr, viewGroup);
        while (findTouchTargetView != null && findTouchTargetView.getId() <= 0) {
            findTouchTargetView = (View) findTouchTargetView.getParent();
        }
        if (findTouchTargetView == null) {
            return id;
        }
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (findTouchTargetView instanceof ReactCompoundView) {
            i = ((ReactCompoundView) findTouchTargetView).reactTagForTouch(f4, f5);
        } else {
            i = findTouchTargetView.getId();
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012a, code lost:
        if (((com.facebook.react.uimanager.ReactCompoundView) r4).reactTagForTouch(r12[0], r12[1]) != r4.getId()) goto L_0x014f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0151 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x016e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.View findTouchTargetView(float[] r12, android.view.ViewGroup r13) {
        /*
            int r0 = r13.getChildCount()
            boolean r1 = r13 instanceof com.facebook.react.uimanager.ReactZIndexedViewGroup
            r2 = 0
            if (r1 == 0) goto L_0x000d
            r1 = r13
            com.facebook.react.uimanager.ReactZIndexedViewGroup r1 = (com.facebook.react.uimanager.ReactZIndexedViewGroup) r1
            goto L_0x000e
        L_0x000d:
            r1 = r2
        L_0x000e:
            r3 = 1
            int r0 = r0 - r3
        L_0x0010:
            if (r0 < 0) goto L_0x0172
            if (r1 == 0) goto L_0x0019
            int r4 = r1.getZIndexMappedChildIndex(r0)
            goto L_0x001a
        L_0x0019:
            r4 = r0
        L_0x001a:
            android.view.View r4 = r13.getChildAt(r4)
            android.graphics.PointF r5 = mTempPoint
            r6 = 0
            r7 = r12[r6]
            r8 = r12[r3]
            int r9 = r13.getScrollX()
            float r9 = (float) r9
            float r7 = r7 + r9
            int r9 = r4.getLeft()
            float r9 = (float) r9
            float r7 = r7 - r9
            int r9 = r13.getScrollY()
            float r9 = (float) r9
            float r8 = r8 + r9
            int r9 = r4.getTop()
            float r9 = (float) r9
            float r8 = r8 - r9
            android.graphics.Matrix r9 = r4.getMatrix()
            boolean r10 = r9.isIdentity()
            if (r10 != 0) goto L_0x0059
            float[] r10 = mMatrixTransformCoords
            r10[r6] = r7
            r10[r3] = r8
            android.graphics.Matrix r7 = mInverseMatrix
            r9.invert(r7)
            r7.mapPoints(r10)
            r7 = r10[r6]
            r8 = r10[r3]
        L_0x0059:
            boolean r9 = r4 instanceof com.facebook.react.touch.ReactHitSlopView
            if (r9 == 0) goto L_0x00a0
            r9 = r4
            com.facebook.react.touch.ReactHitSlopView r9 = (com.facebook.react.touch.ReactHitSlopView) r9
            android.graphics.Rect r10 = r9.getHitSlopRect()
            if (r10 == 0) goto L_0x00a0
            android.graphics.Rect r9 = r9.getHitSlopRect()
            int r10 = r9.left
            int r10 = -r10
            float r10 = (float) r10
            int r10 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x00ca
            int r10 = r4.getRight()
            int r11 = r4.getLeft()
            int r10 = r10 - r11
            int r11 = r9.right
            int r10 = r10 + r11
            float r10 = (float) r10
            int r10 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x00ca
            int r10 = r9.top
            int r10 = -r10
            float r10 = (float) r10
            int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x00ca
            int r10 = r4.getBottom()
            int r11 = r4.getTop()
            int r10 = r10 - r11
            int r9 = r9.bottom
            int r10 = r10 + r9
            float r9 = (float) r10
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x00ca
            r5.set(r7, r8)
            goto L_0x00c8
        L_0x00a0:
            r9 = 0
            int r10 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r10 < 0) goto L_0x00ca
            int r10 = r4.getRight()
            int r11 = r4.getLeft()
            int r10 = r10 - r11
            float r10 = (float) r10
            int r10 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x00ca
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00ca
            int r9 = r4.getBottom()
            int r10 = r4.getTop()
            int r9 = r9 - r10
            float r9 = (float) r9
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x00ca
            r5.set(r7, r8)
        L_0x00c8:
            r7 = 1
            goto L_0x00cb
        L_0x00ca:
            r7 = 0
        L_0x00cb:
            if (r7 == 0) goto L_0x016e
            r7 = r12[r6]
            r8 = r12[r3]
            float r9 = r5.x
            r12[r6] = r9
            float r5 = r5.y
            r12[r3] = r5
            boolean r5 = r4 instanceof com.facebook.react.uimanager.ReactPointerEventsView
            if (r5 == 0) goto L_0x00e5
            r5 = r4
            com.facebook.react.uimanager.ReactPointerEventsView r5 = (com.facebook.react.uimanager.ReactPointerEventsView) r5
            com.facebook.react.uimanager.PointerEvents r5 = r5.getPointerEvents()
            goto L_0x00e7
        L_0x00e5:
            com.facebook.react.uimanager.PointerEvents r5 = com.facebook.react.uimanager.PointerEvents.AUTO
        L_0x00e7:
            boolean r9 = r4.isEnabled()
            if (r9 != 0) goto L_0x00fa
            com.facebook.react.uimanager.PointerEvents r9 = com.facebook.react.uimanager.PointerEvents.AUTO
            if (r5 != r9) goto L_0x00f4
            com.facebook.react.uimanager.PointerEvents r5 = com.facebook.react.uimanager.PointerEvents.BOX_NONE
            goto L_0x00fa
        L_0x00f4:
            com.facebook.react.uimanager.PointerEvents r9 = com.facebook.react.uimanager.PointerEvents.BOX_ONLY
            if (r5 != r9) goto L_0x00fa
            com.facebook.react.uimanager.PointerEvents r5 = com.facebook.react.uimanager.PointerEvents.NONE
        L_0x00fa:
            com.facebook.react.uimanager.PointerEvents r9 = com.facebook.react.uimanager.PointerEvents.NONE
            if (r5 != r9) goto L_0x00ff
            goto L_0x012d
        L_0x00ff:
            com.facebook.react.uimanager.PointerEvents r9 = com.facebook.react.uimanager.PointerEvents.BOX_ONLY
            if (r5 != r9) goto L_0x0104
            goto L_0x014f
        L_0x0104:
            com.facebook.react.uimanager.PointerEvents r9 = com.facebook.react.uimanager.PointerEvents.BOX_NONE
            if (r5 != r9) goto L_0x012f
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x012d
            r5 = r4
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.view.View r5 = findTouchTargetView(r12, r5)
            if (r5 == r4) goto L_0x0117
            r4 = r5
            goto L_0x014f
        L_0x0117:
            boolean r5 = r4 instanceof com.facebook.react.uimanager.ReactCompoundView
            if (r5 == 0) goto L_0x012d
            r5 = r4
            com.facebook.react.uimanager.ReactCompoundView r5 = (com.facebook.react.uimanager.ReactCompoundView) r5
            r9 = r12[r6]
            r10 = r12[r3]
            int r5 = r5.reactTagForTouch(r9, r10)
            int r9 = r4.getId()
            if (r5 == r9) goto L_0x012d
            goto L_0x014f
        L_0x012d:
            r4 = r2
            goto L_0x014f
        L_0x012f:
            com.facebook.react.uimanager.PointerEvents r9 = com.facebook.react.uimanager.PointerEvents.AUTO
            if (r5 != r9) goto L_0x0157
            boolean r5 = r4 instanceof com.facebook.react.uimanager.ReactCompoundViewGroup
            if (r5 == 0) goto L_0x0145
            r5 = r4
            com.facebook.react.uimanager.ReactCompoundViewGroup r5 = (com.facebook.react.uimanager.ReactCompoundViewGroup) r5
            r9 = r12[r6]
            r10 = r12[r3]
            boolean r5 = r5.interceptsTouchEvent(r9, r10)
            if (r5 == 0) goto L_0x0145
            goto L_0x014f
        L_0x0145:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x014f
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r4 = findTouchTargetView(r12, r4)
        L_0x014f:
            if (r4 == 0) goto L_0x0152
            return r4
        L_0x0152:
            r12[r6] = r7
            r12[r3] = r8
            goto L_0x016e
        L_0x0157:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r12 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r13 = "Unknown pointer event type: "
            java.lang.StringBuilder r13 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r13)
            java.lang.String r0 = r5.toString()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x016e:
            int r0 = r0 + -1
            goto L_0x0010
        L_0x0172:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.TouchTargetHelper.findTouchTargetView(float[], android.view.ViewGroup):android.view.View");
    }
}
