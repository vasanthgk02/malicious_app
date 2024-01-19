package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.android.tools.r8.GeneratedOutlineSupport;
import sfs2x.client.entities.invitation.InvitationReply;

public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final int[] COLORS = {-16777216};
    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    public Animator mAnimator;
    public boolean mFinishing;
    public Resources mResources;
    public final Ring mRing;
    public float mRotation;
    public float mRotationCount;

    public static class Ring {
        public int mAlpha = InvitationReply.EXPIRED;
        public Path mArrow;
        public int mArrowHeight;
        public final Paint mArrowPaint = new Paint();
        public float mArrowScale = 1.0f;
        public int mArrowWidth;
        public final Paint mCirclePaint = new Paint();
        public int mColorIndex;
        public int[] mColors;
        public int mCurrentColor;
        public float mEndTrim = 0.0f;
        public final Paint mPaint = new Paint();
        public float mRingCenterRadius;
        public float mRotation = 0.0f;
        public boolean mShowArrow;
        public float mStartTrim = 0.0f;
        public float mStartingEndTrim;
        public float mStartingRotation;
        public float mStartingStartTrim;
        public float mStrokeWidth = 5.0f;
        public final RectF mTempBounds = new RectF();

        public Ring() {
            this.mPaint.setStrokeCap(Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Style.STROKE);
            this.mArrowPaint.setStyle(Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
            this.mCirclePaint.setColor(0);
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
            this.mCurrentColor = this.mColors[i];
        }

        public void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
            }
        }
    }

    public CircularProgressDrawable(Context context) {
        if (context != null) {
            this.mResources = context.getResources();
            Ring ring = new Ring();
            this.mRing = ring;
            ring.mColors = COLORS;
            ring.setColorIndex(0);
            Ring ring2 = this.mRing;
            ring2.mStrokeWidth = 2.5f;
            ring2.mPaint.setStrokeWidth(2.5f);
            invalidateSelf();
            final Ring ring3 = this.mRing;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CircularProgressDrawable.this.updateRingColor(floatValue, ring3);
                    CircularProgressDrawable.this.applyTransformation(floatValue, ring3, false);
                    CircularProgressDrawable.this.invalidateSelf();
                }
            });
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
            ofFloat.addListener(new AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                    CircularProgressDrawable.this.applyTransformation(1.0f, ring3, true);
                    Ring ring = ring3;
                    ring.mStartingStartTrim = ring.mStartTrim;
                    ring.mStartingEndTrim = ring.mEndTrim;
                    ring.mStartingRotation = ring.mRotation;
                    ring.setColorIndex((ring.mColorIndex + 1) % ring.mColors.length);
                    CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                    if (circularProgressDrawable.mFinishing) {
                        circularProgressDrawable.mFinishing = false;
                        animator.cancel();
                        animator.setDuration(1332);
                        animator.start();
                        ring3.setShowArrow(false);
                        return;
                    }
                    circularProgressDrawable.mRotationCount += 1.0f;
                }

                public void onAnimationStart(Animator animator) {
                    CircularProgressDrawable.this.mRotationCount = 0.0f;
                }
            });
            this.mAnimator = ofFloat;
            return;
        }
        throw null;
    }

    public void applyTransformation(float f2, Ring ring, boolean z) {
        float f3;
        float f4;
        if (this.mFinishing) {
            updateRingColor(f2, ring);
            float floor = (float) (Math.floor((double) (ring.mStartingRotation / 0.8f)) + 1.0d);
            float f5 = ring.mStartingStartTrim;
            float f6 = ring.mStartingEndTrim;
            ring.mStartTrim = (((f6 - 0.01f) - f5) * f2) + f5;
            ring.mEndTrim = f6;
            float f7 = ring.mStartingRotation;
            ring.mRotation = GeneratedOutlineSupport.outline3(floor, f7, f2, f7);
        } else if (f2 != 1.0f || z) {
            float f8 = ring.mStartingRotation;
            if (f2 < 0.5f) {
                f3 = ring.mStartingStartTrim;
                f4 = (MATERIAL_INTERPOLATOR.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + f3;
            } else {
                float f9 = ring.mStartingStartTrim + 0.79f;
                float f10 = f9;
                f3 = f9 - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f4 = f10;
            }
            ring.mStartTrim = f3;
            ring.mEndTrim = f4;
            ring.mRotation = (0.20999998f * f2) + f8;
            this.mRotation = (f2 + this.mRotationCount) * 216.0f;
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        Ring ring = this.mRing;
        RectF rectF = ring.mTempBounds;
        float f2 = ring.mRingCenterRadius;
        float f3 = (ring.mStrokeWidth / 2.0f) + f2;
        if (f2 <= 0.0f) {
            f3 = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) ring.mArrowWidth) * ring.mArrowScale) / 2.0f, ring.mStrokeWidth / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f3, ((float) bounds.centerY()) - f3, ((float) bounds.centerX()) + f3, ((float) bounds.centerY()) + f3);
        float f4 = ring.mStartTrim;
        float f5 = ring.mRotation;
        float f6 = (f4 + f5) * 360.0f;
        float f7 = ((ring.mEndTrim + f5) * 360.0f) - f6;
        ring.mPaint.setColor(ring.mCurrentColor);
        ring.mPaint.setAlpha(ring.mAlpha);
        float f8 = ring.mStrokeWidth / 2.0f;
        rectF.inset(f8, f8);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, ring.mCirclePaint);
        float f9 = -f8;
        rectF.inset(f9, f9);
        canvas.drawArc(rectF, f6, f7, false, ring.mPaint);
        if (ring.mShowArrow) {
            Path path = ring.mArrow;
            if (path == null) {
                Path path2 = new Path();
                ring.mArrow = path2;
                path2.setFillType(FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            ring.mArrow.moveTo(0.0f, 0.0f);
            ring.mArrow.lineTo(((float) ring.mArrowWidth) * ring.mArrowScale, 0.0f);
            Path path3 = ring.mArrow;
            float f10 = ring.mArrowScale;
            path3.lineTo((((float) ring.mArrowWidth) * f10) / 2.0f, ((float) ring.mArrowHeight) * f10);
            ring.mArrow.offset((rectF.centerX() + (Math.min(rectF.width(), rectF.height()) / 2.0f)) - ((((float) ring.mArrowWidth) * ring.mArrowScale) / 2.0f), (ring.mStrokeWidth / 2.0f) + rectF.centerY());
            ring.mArrow.close();
            ring.mArrowPaint.setColor(ring.mCurrentColor);
            ring.mArrowPaint.setAlpha(ring.mAlpha);
            canvas.save();
            canvas.rotate(f6 + f7, rectF.centerX(), rectF.centerY());
            canvas.drawPath(ring.mArrow, ring.mArrowPaint);
            canvas.restore();
        }
        canvas.restore();
    }

    public int getAlpha() {
        return this.mRing.mAlpha;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    public void setAlpha(int i) {
        this.mRing.mAlpha = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void setSizeParameters(float f2, float f3, float f4, float f5) {
        Ring ring = this.mRing;
        float f6 = this.mResources.getDisplayMetrics().density;
        float f7 = f3 * f6;
        ring.mStrokeWidth = f7;
        ring.mPaint.setStrokeWidth(f7);
        ring.mRingCenterRadius = f2 * f6;
        ring.setColorIndex(0);
        ring.mArrowWidth = (int) (f4 * f6);
        ring.mArrowHeight = (int) (f5 * f6);
    }

    public void setStyle(int i) {
        if (i == 0) {
            setSizeParameters(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            setSizeParameters(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void start() {
        this.mAnimator.cancel();
        Ring ring = this.mRing;
        float f2 = ring.mStartTrim;
        ring.mStartingStartTrim = f2;
        float f3 = ring.mEndTrim;
        ring.mStartingEndTrim = f3;
        ring.mStartingRotation = ring.mRotation;
        if (f3 != f2) {
            this.mFinishing = true;
            this.mAnimator.setDuration(666);
            this.mAnimator.start();
            return;
        }
        ring.setColorIndex(0);
        Ring ring2 = this.mRing;
        ring2.mStartingStartTrim = 0.0f;
        ring2.mStartingEndTrim = 0.0f;
        ring2.mStartingRotation = 0.0f;
        ring2.mStartTrim = 0.0f;
        ring2.mEndTrim = 0.0f;
        ring2.mRotation = 0.0f;
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
    }

    public void stop() {
        this.mAnimator.cancel();
        this.mRotation = 0.0f;
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        Ring ring = this.mRing;
        ring.mStartingStartTrim = 0.0f;
        ring.mStartingEndTrim = 0.0f;
        ring.mStartingRotation = 0.0f;
        ring.mStartTrim = 0.0f;
        ring.mEndTrim = 0.0f;
        ring.mRotation = 0.0f;
        invalidateSelf();
    }

    public void updateRingColor(float f2, Ring ring) {
        if (f2 > 0.75f) {
            float f3 = (f2 - 0.75f) / 0.25f;
            int[] iArr = ring.mColors;
            int i = ring.mColorIndex;
            int i2 = iArr[i];
            int i3 = iArr[(i + 1) % iArr.length];
            int i4 = (i2 >> 24) & InvitationReply.EXPIRED;
            int i5 = (i2 >> 16) & InvitationReply.EXPIRED;
            int i6 = (i2 >> 8) & InvitationReply.EXPIRED;
            int i7 = i2 & InvitationReply.EXPIRED;
            ring.mCurrentColor = ((i4 + ((int) (((float) (((i3 >> 24) & InvitationReply.EXPIRED) - i4)) * f3))) << 24) | ((i5 + ((int) (((float) (((i3 >> 16) & InvitationReply.EXPIRED) - i5)) * f3))) << 16) | ((i6 + ((int) (((float) (((i3 >> 8) & InvitationReply.EXPIRED) - i6)) * f3))) << 8) | (i7 + ((int) (f3 * ((float) ((i3 & InvitationReply.EXPIRED) - i7)))));
            return;
        }
        ring.mCurrentColor = ring.mColors[ring.mColorIndex];
    }
}
