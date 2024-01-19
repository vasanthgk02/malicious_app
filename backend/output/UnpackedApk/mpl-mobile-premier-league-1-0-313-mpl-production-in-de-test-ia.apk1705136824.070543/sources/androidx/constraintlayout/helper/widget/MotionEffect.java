package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R$styleable;

public class MotionEffect extends MotionHelper {
    public int fadeMove = -1;
    public float motionEffectAlpha = 0.1f;
    public int motionEffectEnd = 50;
    public int motionEffectStart = 49;
    public boolean motionEffectStrictMove = true;
    public int motionEffectTranslationX = 0;
    public int motionEffectTranslationY = 0;
    public int viewTransitionId = -1;

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public final void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionEffect_motionEffect_start) {
                    int i2 = obtainStyledAttributes.getInt(index, this.motionEffectStart);
                    this.motionEffectStart = i2;
                    this.motionEffectStart = Math.max(Math.min(i2, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_end) {
                    int i3 = obtainStyledAttributes.getInt(index, this.motionEffectEnd);
                    this.motionEffectEnd = i3;
                    this.motionEffectEnd = Math.max(Math.min(i3, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationX) {
                    this.motionEffectTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationX);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationY) {
                    this.motionEffectTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationY);
                } else if (index == R$styleable.MotionEffect_motionEffect_alpha) {
                    this.motionEffectAlpha = obtainStyledAttributes.getFloat(index, this.motionEffectAlpha);
                } else if (index == R$styleable.MotionEffect_motionEffect_move) {
                    this.fadeMove = obtainStyledAttributes.getInt(index, this.fadeMove);
                } else if (index == R$styleable.MotionEffect_motionEffect_strict) {
                    this.motionEffectStrictMove = obtainStyledAttributes.getBoolean(index, this.motionEffectStrictMove);
                } else if (index == R$styleable.MotionEffect_motionEffect_viewTransition) {
                    this.viewTransitionId = obtainStyledAttributes.getResourceId(index, this.viewTransitionId);
                }
            }
            int i4 = this.motionEffectStart;
            int i5 = this.motionEffectEnd;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.motionEffectStart = i4 - 1;
                } else {
                    this.motionEffectEnd = i5 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isDecorator() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0186, code lost:
        if (r14 == 0.0f) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x019a, code lost:
        if (r1 == 0.0f) goto L_0x0188;
     */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            android.view.ViewParent r2 = r22.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.getViews(r2)
            if (r2 != 0) goto L_0x0014
            a.a.a.a.d.b.getLoc()
            return
        L_0x0014:
            androidx.constraintlayout.motion.widget.KeyAttributes r3 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r3.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r4 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r4.<init>()
            float r5 = r0.motionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.setValue(r6, r5)
            float r5 = r0.motionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.setValue(r6, r5)
            int r5 = r0.motionEffectStart
            r3.mFramePosition = r5
            int r5 = r0.motionEffectEnd
            r4.mFramePosition = r5
            androidx.constraintlayout.motion.widget.KeyPosition r5 = new androidx.constraintlayout.motion.widget.KeyPosition
            r5.<init>()
            int r6 = r0.motionEffectStart
            r5.mFramePosition = r6
            r6 = 0
            r5.mPositionType = r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.setValue(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.setValue(r9, r7)
            androidx.constraintlayout.motion.widget.KeyPosition r7 = new androidx.constraintlayout.motion.widget.KeyPosition
            r7.<init>()
            int r10 = r0.motionEffectEnd
            r7.mFramePosition = r10
            r7.mPositionType = r6
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.setValue(r8, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.setValue(r9, r8)
            int r8 = r0.motionEffectTranslationX
            r9 = 0
            if (r8 <= 0) goto L_0x009d
            androidx.constraintlayout.motion.widget.KeyAttributes r8 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r8.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r11 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r11.<init>()
            int r12 = r0.motionEffectTranslationX
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.setValue(r13, r12)
            int r12 = r0.motionEffectEnd
            r8.mFramePosition = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.setValue(r13, r12)
            int r12 = r0.motionEffectEnd
            int r12 = r12 - r10
            r11.mFramePosition = r12
            goto L_0x009f
        L_0x009d:
            r8 = r9
            r11 = r8
        L_0x009f:
            int r12 = r0.motionEffectTranslationY
            if (r12 <= 0) goto L_0x00ce
            androidx.constraintlayout.motion.widget.KeyAttributes r9 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r9.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r12 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r12.<init>()
            int r13 = r0.motionEffectTranslationY
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.setValue(r14, r13)
            int r13 = r0.motionEffectEnd
            r9.mFramePosition = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.setValue(r14, r13)
            int r13 = r0.motionEffectEnd
            int r13 = r13 - r10
            r12.mFramePosition = r13
            r21 = r12
            r12 = r9
            r9 = r21
            goto L_0x00cf
        L_0x00ce:
            r12 = r9
        L_0x00cf:
            int r13 = r0.fadeMove
            r15 = -1
            if (r13 != r15) goto L_0x0141
            r13 = 4
            int[] r15 = new int[r13]
            r13 = 0
        L_0x00d8:
            int r6 = r2.length
            if (r13 >= r6) goto L_0x012c
            r6 = r2[r13]
            java.lang.Object r6 = r1.get(r6)
            androidx.constraintlayout.motion.widget.MotionController r6 = (androidx.constraintlayout.motion.widget.MotionController) r6
            if (r6 != 0) goto L_0x00e8
            r20 = r9
            goto L_0x0126
        L_0x00e8:
            androidx.constraintlayout.motion.widget.MotionPaths r10 = r6.mEndMotionPath
            float r14 = r10.x
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r6.mStartMotionPath
            r20 = r9
            float r9 = r6.x
            float r14 = r14 - r9
            float r9 = r10.y
            float r6 = r6.y
            float r9 = r9 - r6
            r6 = 0
            int r10 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x0105
            r10 = 1
            r19 = r15[r10]
            int r19 = r19 + 1
            r15[r10] = r19
            goto L_0x0106
        L_0x0105:
            r10 = 1
        L_0x0106:
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x0111
            r9 = 0
            r18 = r15[r9]
            int r18 = r18 + 1
            r15[r9] = r18
        L_0x0111:
            int r9 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x011c
            r9 = 3
            r16 = r15[r9]
            int r16 = r16 + 1
            r15[r9] = r16
        L_0x011c:
            int r9 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0126
            r6 = 2
            r9 = r15[r6]
            int r9 = r9 + r10
            r15[r6] = r9
        L_0x0126:
            int r13 = r13 + 1
            r9 = r20
            r10 = 1
            goto L_0x00d8
        L_0x012c:
            r20 = r9
            r10 = 0
            r6 = r15[r10]
            r9 = 1
            r13 = 0
            r14 = 4
        L_0x0134:
            if (r9 >= r14) goto L_0x0143
            r10 = r15[r9]
            if (r6 >= r10) goto L_0x013d
            r6 = r15[r9]
            r13 = r9
        L_0x013d:
            int r9 = r9 + 1
            r10 = 0
            goto L_0x0134
        L_0x0141:
            r20 = r9
        L_0x0143:
            r9 = 0
        L_0x0144:
            int r6 = r2.length
            if (r9 >= r6) goto L_0x0223
            r6 = r2[r9]
            java.lang.Object r6 = r1.get(r6)
            androidx.constraintlayout.motion.widget.MotionController r6 = (androidx.constraintlayout.motion.widget.MotionController) r6
            if (r6 != 0) goto L_0x0157
        L_0x0151:
            r10 = r23
            r16 = r20
            goto L_0x0219
        L_0x0157:
            androidx.constraintlayout.motion.widget.MotionPaths r10 = r6.mEndMotionPath
            float r14 = r10.x
            androidx.constraintlayout.motion.widget.MotionPaths r15 = r6.mStartMotionPath
            float r1 = r15.x
            float r14 = r14 - r1
            float r1 = r10.y
            float r10 = r15.y
            float r1 = r1 - r10
            if (r13 != 0) goto L_0x0178
            r10 = 0
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x0176
            boolean r1 = r0.motionEffectStrictMove
            if (r1 == 0) goto L_0x0174
            int r1 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x0176
        L_0x0174:
            r15 = 1
            goto L_0x0188
        L_0x0176:
            r15 = 1
            goto L_0x018b
        L_0x0178:
            r10 = 0
            r15 = 1
            if (r13 != r15) goto L_0x018d
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x018b
            boolean r1 = r0.motionEffectStrictMove
            if (r1 == 0) goto L_0x0188
            int r1 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x018b
        L_0x0188:
            r1 = 0
            r15 = 3
            goto L_0x01af
        L_0x018b:
            r15 = 3
            goto L_0x01ae
        L_0x018d:
            r15 = 2
            if (r13 != r15) goto L_0x019d
            int r14 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r14 >= 0) goto L_0x018b
            boolean r14 = r0.motionEffectStrictMove
            if (r14 == 0) goto L_0x0188
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x018b
            goto L_0x0188
        L_0x019d:
            r15 = 3
            if (r13 != r15) goto L_0x01ae
            int r14 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r14 <= 0) goto L_0x01ae
            boolean r14 = r0.motionEffectStrictMove
            if (r14 == 0) goto L_0x01ac
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x01ae
        L_0x01ac:
            r1 = 0
            goto L_0x01af
        L_0x01ae:
            r1 = 1
        L_0x01af:
            if (r1 == 0) goto L_0x0151
            int r1 = r0.viewTransitionId
            r14 = -1
            if (r1 != r14) goto L_0x01ed
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r6.mKeyList
            r1.add(r3)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r6.mKeyList
            r1.add(r4)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r6.mKeyList
            r1.add(r5)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r6.mKeyList
            r1.add(r7)
            int r1 = r0.motionEffectTranslationX
            if (r1 <= 0) goto L_0x01d8
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r6.mKeyList
            r1.add(r8)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r6.mKeyList
            r1.add(r11)
        L_0x01d8:
            int r1 = r0.motionEffectTranslationY
            if (r1 <= 0) goto L_0x0151
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r6.mKeyList
            r1.add(r12)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r6.mKeyList
            r6 = r20
            r1.add(r6)
            r10 = r23
            r16 = r6
            goto L_0x0219
        L_0x01ed:
            r10 = r23
            r16 = r20
            androidx.constraintlayout.motion.widget.MotionScene r14 = r10.mScene
            if (r14 == 0) goto L_0x0219
            androidx.constraintlayout.motion.widget.ViewTransitionController r14 = r14.mViewTransitionController
            java.util.ArrayList<androidx.constraintlayout.motion.widget.ViewTransition> r14 = r14.viewTransitions
            java.util.Iterator r14 = r14.iterator()
        L_0x01fd:
            boolean r17 = r14.hasNext()
            if (r17 == 0) goto L_0x0219
            java.lang.Object r17 = r14.next()
            r15 = r17
            androidx.constraintlayout.motion.widget.ViewTransition r15 = (androidx.constraintlayout.motion.widget.ViewTransition) r15
            int r0 = r15.mId
            if (r0 != r1) goto L_0x0215
            androidx.constraintlayout.motion.widget.KeyFrames r0 = r15.mKeyFrames
            r0.addAllFrames(r6)
            goto L_0x0219
        L_0x0215:
            r15 = 3
            r0 = r22
            goto L_0x01fd
        L_0x0219:
            int r9 = r9 + 1
            r0 = r22
            r1 = r24
            r20 = r16
            goto L_0x0144
        L_0x0223:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
