package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.android.tools.r8.GeneratedOutlineSupport;

public final class ShimmerDrawable extends Drawable {
    public final Rect mDrawRect = new Rect();
    public final Matrix mShaderMatrix = new Matrix();
    public Shimmer mShimmer;
    public final Paint mShimmerPaint = new Paint();
    public final AnimatorUpdateListener mUpdateListener = new AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerDrawable.this.invalidateSelf();
        }
    };
    public ValueAnimator mValueAnimator;

    public ShimmerDrawable() {
        this.mShimmerPaint.setAntiAlias(true);
    }

    private float offset(float f2, float f3, float f4) {
        return GeneratedOutlineSupport.outline3(f3, f2, f4, f2);
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r12v0, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r3v8, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r12v1, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r3v9, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v1, types: [android.graphics.RadialGradient]
      assigns: [android.graphics.RadialGradient, android.graphics.LinearGradient]
      uses: [android.graphics.RadialGradient, android.graphics.Shader, android.graphics.LinearGradient]
      mth insns count: 54
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateShader() {
        /*
            r19 = this;
            r0 = r19
            android.graphics.Rect r1 = r19.getBounds()
            int r2 = r1.width()
            int r1 = r1.height()
            if (r2 == 0) goto L_0x0078
            if (r1 == 0) goto L_0x0078
            com.facebook.shimmer.Shimmer r3 = r0.mShimmer
            if (r3 != 0) goto L_0x0017
            goto L_0x0078
        L_0x0017:
            int r2 = r3.width(r2)
            com.facebook.shimmer.Shimmer r3 = r0.mShimmer
            int r1 = r3.height(r1)
            com.facebook.shimmer.Shimmer r3 = r0.mShimmer
            int r4 = r3.shape
            r5 = 1
            if (r4 == r5) goto L_0x004c
            int r3 = r3.direction
            r4 = 0
            if (r3 == r5) goto L_0x0032
            r6 = 3
            if (r3 != r6) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            if (r5 == 0) goto L_0x0035
            r2 = 0
        L_0x0035:
            if (r5 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = 0
        L_0x0039:
            android.graphics.LinearGradient r11 = new android.graphics.LinearGradient
            r4 = 0
            r5 = 0
            float r6 = (float) r2
            float r7 = (float) r1
            com.facebook.shimmer.Shimmer r1 = r0.mShimmer
            int[] r8 = r1.colors
            float[] r9 = r1.positions
            android.graphics.Shader$TileMode r10 = android.graphics.Shader.TileMode.CLAMP
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0073
        L_0x004c:
            android.graphics.RadialGradient r11 = new android.graphics.RadialGradient
            float r3 = (float) r2
            r4 = 1073741824(0x40000000, float:2.0)
            float r13 = r3 / r4
            float r3 = (float) r1
            float r14 = r3 / r4
            int r1 = java.lang.Math.max(r2, r1)
            double r1 = (double) r1
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r3 = java.lang.Math.sqrt(r3)
            double r1 = r1 / r3
            float r15 = (float) r1
            com.facebook.shimmer.Shimmer r1 = r0.mShimmer
            int[] r2 = r1.colors
            float[] r1 = r1.positions
            android.graphics.Shader$TileMode r18 = android.graphics.Shader.TileMode.CLAMP
            r12 = r11
            r16 = r2
            r17 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18)
        L_0x0073:
            android.graphics.Paint r1 = r0.mShimmerPaint
            r1.setShader(r11)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.shimmer.ShimmerDrawable.updateShader():void");
    }

    private void updateValueAnimator() {
        boolean z;
        if (this.mShimmer != null) {
            ValueAnimator valueAnimator = this.mValueAnimator;
            if (valueAnimator != null) {
                z = valueAnimator.isStarted();
                this.mValueAnimator.cancel();
                this.mValueAnimator.removeAllUpdateListeners();
            } else {
                z = false;
            }
            Shimmer shimmer = this.mShimmer;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, ((float) (shimmer.repeatDelay / shimmer.animationDuration)) + 1.0f});
            this.mValueAnimator = ofFloat;
            ofFloat.setRepeatMode(this.mShimmer.repeatMode);
            this.mValueAnimator.setRepeatCount(this.mShimmer.repeatCount);
            ValueAnimator valueAnimator2 = this.mValueAnimator;
            Shimmer shimmer2 = this.mShimmer;
            valueAnimator2.setDuration(shimmer2.animationDuration + shimmer2.repeatDelay);
            this.mValueAnimator.addUpdateListener(this.mUpdateListener);
            if (z) {
                this.mValueAnimator.start();
            }
        }
    }

    public void draw(Canvas canvas) {
        float f2;
        float offset;
        if (this.mShimmer != null && this.mShimmerPaint.getShader() != null) {
            float tan = (float) Math.tan(Math.toRadians((double) this.mShimmer.tilt));
            float width = (((float) this.mDrawRect.width()) * tan) + ((float) this.mDrawRect.height());
            float height = (tan * ((float) this.mDrawRect.height())) + ((float) this.mDrawRect.width());
            ValueAnimator valueAnimator = this.mValueAnimator;
            float f3 = 0.0f;
            float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
            int i = this.mShimmer.direction;
            if (i != 1) {
                if (i == 2) {
                    offset = offset(height, -height, animatedFraction);
                } else if (i != 3) {
                    offset = offset(-height, height, animatedFraction);
                } else {
                    f2 = offset(width, -width, animatedFraction);
                }
                f3 = offset;
                f2 = 0.0f;
            } else {
                f2 = offset(-width, width, animatedFraction);
            }
            this.mShaderMatrix.reset();
            this.mShaderMatrix.setRotate(this.mShimmer.tilt, ((float) this.mDrawRect.width()) / 2.0f, ((float) this.mDrawRect.height()) / 2.0f);
            this.mShaderMatrix.postTranslate(f3, f2);
            this.mShimmerPaint.getShader().setLocalMatrix(this.mShaderMatrix);
            canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
        }
    }

    public int getOpacity() {
        Shimmer shimmer = this.mShimmer;
        return (shimmer == null || (!shimmer.clipToChildren && !shimmer.alphaShimmer)) ? -1 : -3;
    }

    public boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public void maybeStartShimmer() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && !valueAnimator.isStarted()) {
            Shimmer shimmer = this.mShimmer;
            if (shimmer != null && shimmer.autoStart && getCallback() != null) {
                this.mValueAnimator.start();
            }
        }
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDrawRect.set(0, 0, rect.width(), rect.height());
        updateShader();
        maybeStartShimmer();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setShimmer(Shimmer shimmer) {
        this.mShimmer = shimmer;
        if (shimmer != null) {
            this.mShimmerPaint.setXfermode(new PorterDuffXfermode(this.mShimmer.alphaShimmer ? Mode.DST_IN : Mode.SRC_IN));
        }
        updateShader();
        updateValueAnimator();
        invalidateSelf();
    }

    public void startShimmer() {
        if (this.mValueAnimator != null && !isShimmerStarted() && getCallback() != null) {
            this.mValueAnimator.start();
        }
    }

    public void stopShimmer() {
        if (this.mValueAnimator != null && isShimmerStarted()) {
            this.mValueAnimator.cancel();
        }
    }
}
