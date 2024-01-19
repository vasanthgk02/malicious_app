package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.os.Build.VERSION;

public class TransitionUtils {
    public static final boolean HAS_PICTURE_BITMAP = (VERSION.SDK_INT >= 28);

    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        public final float[] mTempEndValues = new float[9];
        public final Matrix mTempMatrix = new Matrix();
        public final float[] mTempStartValues = new float[9];

        public Object evaluate(float f2, Object obj, Object obj2) {
            ((Matrix) obj).getValues(this.mTempStartValues);
            ((Matrix) obj2).getValues(this.mTempEndValues);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.mTempEndValues;
                float f3 = fArr[i];
                float[] fArr2 = this.mTempStartValues;
                fArr[i] = ((f3 - fArr2[i]) * f2) + fArr2[i];
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.View copyViewImage(android.view.ViewGroup r13, android.view.View r14, android.view.View r15) {
        /*
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            int r1 = r15.getScrollX()
            int r1 = -r1
            float r1 = (float) r1
            int r15 = r15.getScrollY()
            int r15 = -r15
            float r15 = (float) r15
            r0.setTranslate(r1, r15)
            androidx.transition.ViewUtilsBase r15 = androidx.transition.ViewUtils.IMPL
            r15.transformMatrixToGlobal(r14, r0)
            androidx.transition.ViewUtilsBase r15 = androidx.transition.ViewUtils.IMPL
            r15.transformMatrixToLocal(r13, r0)
            android.graphics.RectF r15 = new android.graphics.RectF
            int r1 = r14.getWidth()
            float r1 = (float) r1
            int r2 = r14.getHeight()
            float r2 = (float) r2
            r3 = 0
            r15.<init>(r3, r3, r1, r2)
            r0.mapRect(r15)
            float r1 = r15.left
            int r1 = java.lang.Math.round(r1)
            float r2 = r15.top
            int r2 = java.lang.Math.round(r2)
            float r3 = r15.right
            int r3 = java.lang.Math.round(r3)
            float r4 = r15.bottom
            int r4 = java.lang.Math.round(r4)
            android.widget.ImageView r5 = new android.widget.ImageView
            android.content.Context r6 = r14.getContext()
            r5.<init>(r6)
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.CENTER_CROP
            r5.setScaleType(r6)
            boolean r6 = r14.isAttachedToWindow()
            r6 = r6 ^ 1
            r7 = 0
            if (r13 != 0) goto L_0x0062
            r8 = 0
            goto L_0x0066
        L_0x0062:
            boolean r8 = r13.isAttachedToWindow()
        L_0x0066:
            r9 = 0
            if (r6 == 0) goto L_0x007f
            if (r8 != 0) goto L_0x006d
            goto L_0x00f4
        L_0x006d:
            android.view.ViewParent r7 = r14.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            int r8 = r7.indexOfChild(r14)
            android.view.ViewGroupOverlay r10 = r13.getOverlay()
            r10.add(r14)
            goto L_0x0081
        L_0x007f:
            r7 = r9
            r8 = 0
        L_0x0081:
            float r10 = r15.width()
            int r10 = java.lang.Math.round(r10)
            float r11 = r15.height()
            int r11 = java.lang.Math.round(r11)
            if (r10 <= 0) goto L_0x00e8
            if (r11 <= 0) goto L_0x00e8
            r9 = 1233125376(0x49800000, float:1048576.0)
            int r12 = r10 * r11
            float r12 = (float) r12
            float r9 = r9 / r12
            r12 = 1065353216(0x3f800000, float:1.0)
            float r9 = java.lang.Math.min(r12, r9)
            float r10 = (float) r10
            float r10 = r10 * r9
            int r10 = java.lang.Math.round(r10)
            float r11 = (float) r11
            float r11 = r11 * r9
            int r11 = java.lang.Math.round(r11)
            float r12 = r15.left
            float r12 = -r12
            float r15 = r15.top
            float r15 = -r15
            r0.postTranslate(r12, r15)
            r0.postScale(r9, r9)
            boolean r15 = HAS_PICTURE_BITMAP
            if (r15 == 0) goto L_0x00d6
            android.graphics.Picture r15 = new android.graphics.Picture
            r15.<init>()
            android.graphics.Canvas r9 = r15.beginRecording(r10, r11)
            r9.concat(r0)
            r14.draw(r9)
            r15.endRecording()
            android.graphics.Bitmap r15 = android.graphics.Bitmap.createBitmap(r15)
            goto L_0x00e7
        L_0x00d6:
            android.graphics.Bitmap$Config r15 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r15 = android.graphics.Bitmap.createBitmap(r10, r11, r15)
            android.graphics.Canvas r9 = new android.graphics.Canvas
            r9.<init>(r15)
            r9.concat(r0)
            r14.draw(r9)
        L_0x00e7:
            r9 = r15
        L_0x00e8:
            if (r6 == 0) goto L_0x00f4
            android.view.ViewGroupOverlay r13 = r13.getOverlay()
            r13.remove(r14)
            r7.addView(r14, r8)
        L_0x00f4:
            if (r9 == 0) goto L_0x00f9
            r5.setImageBitmap(r9)
        L_0x00f9:
            int r13 = r3 - r1
            r14 = 1073741824(0x40000000, float:2.0)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r14)
            int r15 = r4 - r2
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r14)
            r5.measure(r13, r14)
            r5.layout(r1, r2, r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionUtils.copyViewImage(android.view.ViewGroup, android.view.View, android.view.View):android.view.View");
    }

    public static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
