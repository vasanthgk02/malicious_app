package androidx.transition;

public class SidePropagation extends VisibilityPropagation {
    public float mPropagationSpeed = 3.0f;
    public int mSide = 80;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        if (r5 != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0086, code lost:
        if (r5 != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        r15 = 5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getStartDelay(android.view.ViewGroup r18, androidx.transition.Transition r19, androidx.transition.TransitionValues r20, androidx.transition.TransitionValues r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            r2 = 0
            if (r1 != 0) goto L_0x000b
            if (r21 != 0) goto L_0x000b
            return r2
        L_0x000b:
            android.graphics.Rect r4 = r19.getEpicenter()
            r5 = 1
            if (r21 == 0) goto L_0x001d
            int r6 = r0.getViewVisibility(r1)
            if (r6 != 0) goto L_0x0019
            goto L_0x001d
        L_0x0019:
            r1 = r21
            r6 = 1
            goto L_0x001e
        L_0x001d:
            r6 = -1
        L_0x001e:
            r7 = 0
            int r8 = androidx.transition.VisibilityPropagation.getViewCoordinate(r1, r7)
            int r1 = androidx.transition.VisibilityPropagation.getViewCoordinate(r1, r5)
            r9 = 2
            int[] r10 = new int[r9]
            r11 = r18
            r11.getLocationOnScreen(r10)
            r12 = r10[r7]
            float r13 = r18.getTranslationX()
            int r13 = java.lang.Math.round(r13)
            int r13 = r13 + r12
            r10 = r10[r5]
            float r12 = r18.getTranslationY()
            int r12 = java.lang.Math.round(r12)
            int r12 = r12 + r10
            int r10 = r18.getWidth()
            int r10 = r10 + r13
            int r14 = r18.getHeight()
            int r14 = r14 + r12
            if (r4 == 0) goto L_0x005a
            int r9 = r4.centerX()
            int r4 = r4.centerY()
            goto L_0x0066
        L_0x005a:
            int r4 = r13 + r10
            int r4 = r4 / r9
            int r15 = r12 + r14
            int r9 = r15 / 2
            r16 = r9
            r9 = r4
            r4 = r16
        L_0x0066:
            int r15 = r0.mSide
            r7 = 8388613(0x800005, float:1.175495E-38)
            r2 = 8388611(0x800003, float:1.1754948E-38)
            r3 = 3
            if (r15 != r2) goto L_0x007c
            int r15 = androidx.core.view.ViewCompat.getLayoutDirection(r18)
            if (r15 != r5) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r5 = 0
        L_0x0079:
            if (r5 == 0) goto L_0x0088
            goto L_0x008a
        L_0x007c:
            if (r15 != r7) goto L_0x008b
            int r15 = androidx.core.view.ViewCompat.getLayoutDirection(r18)
            if (r15 != r5) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r5 = 0
        L_0x0086:
            if (r5 == 0) goto L_0x008a
        L_0x0088:
            r15 = 3
            goto L_0x008b
        L_0x008a:
            r15 = 5
        L_0x008b:
            if (r15 == r3) goto L_0x00b2
            r5 = 5
            if (r15 == r5) goto L_0x00aa
            r4 = 48
            if (r15 == r4) goto L_0x00a2
            r4 = 80
            if (r15 == r4) goto L_0x009a
            r1 = 0
            goto L_0x00b9
        L_0x009a:
            int r1 = r1 - r12
            int r9 = r9 - r8
            int r4 = java.lang.Math.abs(r9)
            int r1 = r1 + r4
            goto L_0x00b9
        L_0x00a2:
            int r14 = r14 - r1
            int r9 = r9 - r8
            int r1 = java.lang.Math.abs(r9)
            int r1 = r1 + r14
            goto L_0x00b9
        L_0x00aa:
            int r8 = r8 - r13
            int r4 = r4 - r1
            int r1 = java.lang.Math.abs(r4)
            int r1 = r1 + r8
            goto L_0x00b9
        L_0x00b2:
            int r10 = r10 - r8
            int r4 = r4 - r1
            int r1 = java.lang.Math.abs(r4)
            int r1 = r1 + r10
        L_0x00b9:
            float r1 = (float) r1
            int r4 = r0.mSide
            if (r4 == r3) goto L_0x00ca
            r3 = 5
            if (r4 == r3) goto L_0x00ca
            if (r4 == r2) goto L_0x00ca
            if (r4 == r7) goto L_0x00ca
            int r2 = r18.getHeight()
            goto L_0x00ce
        L_0x00ca:
            int r2 = r18.getWidth()
        L_0x00ce:
            float r2 = (float) r2
            float r1 = r1 / r2
            r2 = r19
            long r2 = r2.mDuration
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x00dc
            r2 = 300(0x12c, double:1.48E-321)
        L_0x00dc:
            long r4 = (long) r6
            long r2 = r2 * r4
            float r2 = (float) r2
            float r3 = r0.mPropagationSpeed
            float r2 = r2 / r3
            float r2 = r2 * r1
            int r1 = java.lang.Math.round(r2)
            long r1 = (long) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.SidePropagation.getStartDelay(android.view.ViewGroup, androidx.transition.Transition, androidx.transition.TransitionValues, androidx.transition.TransitionValues):long");
    }
}
