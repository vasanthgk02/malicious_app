package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.List;

public class ClockHandView extends View {
    public final float centerDotRadius;
    public boolean changedDuringTouch;
    public int circleRadius;
    public double degRad;
    public float downX;
    public float downY;
    public boolean isInTapRegion;
    public final List<OnRotateListener> listeners;
    public float originalDeg;
    public final Paint paint;
    public ValueAnimator rotationAnimator;
    public int scaledTouchSlop;
    public final RectF selectorBox;
    public final int selectorRadius;
    public final int selectorStrokeWidth;

    public interface OnRotateListener {
        void onRotate(float f2, boolean z);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public final int getDegreesFromXY(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f3 - ((float) (getHeight() / 2))), (double) (f2 - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + JpegTranscoderUtils.FULL_ROUND : degrees;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f2 = (float) width;
        float f3 = (float) height;
        this.paint.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.circleRadius) * ((float) Math.cos(this.degRad))) + f2, (((float) this.circleRadius) * ((float) Math.sin(this.degRad))) + f3, (float) this.selectorRadius, this.paint);
        double sin = Math.sin(this.degRad);
        double cos = Math.cos(this.degRad);
        double d2 = (double) ((float) (this.circleRadius - this.selectorRadius));
        float f4 = (float) (width + ((int) (cos * d2)));
        float f5 = (float) (height + ((int) (d2 * sin)));
        this.paint.setStrokeWidth((float) this.selectorStrokeWidth);
        canvas.drawLine(f2, f3, f4, f5, this.paint);
        canvas.drawCircle(f2, f3, this.centerDotRadius, this.paint);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setHandRotation(this.originalDeg, false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z3 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i = (int) (x - this.downX);
                int i2 = (int) (y - this.downY);
                this.isInTapRegion = (i2 * i2) + (i * i) > this.scaledTouchSlop;
                z2 = this.changedDuringTouch;
                if (actionMasked == 1) {
                }
            } else {
                z2 = false;
            }
            z = false;
        } else {
            this.downX = x;
            this.downY = y;
            this.isInTapRegion = true;
            this.changedDuringTouch = false;
            z2 = false;
            z = true;
        }
        boolean z4 = this.changedDuringTouch;
        float degreesFromXY = (float) getDegreesFromXY(x, y);
        boolean z5 = this.originalDeg != degreesFromXY;
        if (!z || !z5) {
            if (z5 || z2) {
                setHandRotation(degreesFromXY, false);
            }
            this.changedDuringTouch = z4 | z3;
            return true;
        }
        z3 = true;
        this.changedDuringTouch = z4 | z3;
        return true;
    }

    public void setHandRotation(float f2, boolean z) {
        ValueAnimator valueAnimator = this.rotationAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            setHandRotationInternal(f2, false);
            return;
        }
        float f3 = this.originalDeg;
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (f3 < 180.0f && f2 > 180.0f) {
                f3 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f3), Float.valueOf(f2));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((Float) pair.first).floatValue(), ((Float) pair.second).floatValue()});
        this.rotationAnimator = ofFloat;
        ofFloat.setDuration(200);
        this.rotationAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClockHandView.this.setHandRotationInternal(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
            }
        });
        this.rotationAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.rotationAnimator.start();
    }

    public final void setHandRotationInternal(float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.originalDeg = f3;
        this.degRad = Math.toRadians((double) (f3 - 90.0f));
        float cos = (((float) this.circleRadius) * ((float) Math.cos(this.degRad))) + ((float) (getWidth() / 2));
        float sin = (((float) this.circleRadius) * ((float) Math.sin(this.degRad))) + ((float) (getHeight() / 2));
        RectF rectF = this.selectorBox;
        int i = this.selectorRadius;
        rectF.set(cos - ((float) i), sin - ((float) i), cos + ((float) i), sin + ((float) i));
        for (OnRotateListener onRotate : this.listeners) {
            onRotate.onRotate(f3, z);
        }
        invalidate();
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.listeners = new ArrayList();
        this.paint = new Paint();
        this.selectorBox = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.selectorStrokeWidth = resources.getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = (float) resources.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        this.paint.setAntiAlias(true);
        this.paint.setColor(color);
        setHandRotation(0.0f, false);
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }
}
