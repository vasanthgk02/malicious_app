package com.google.android.material.chip;

import a.a.a.a.d.b;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import sfs2x.client.entities.invitation.InvitationReply;

public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Callback, TextDrawableDelegate {
    public static final int[] DEFAULT_STATE = {16842910};
    public static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());
    public int alpha = InvitationReply.EXPIRED;
    public boolean checkable;
    public Drawable checkedIcon;
    public ColorStateList checkedIconTint;
    public boolean checkedIconVisible;
    public ColorStateList chipBackgroundColor;
    public float chipCornerRadius = -1.0f;
    public float chipEndPadding;
    public Drawable chipIcon;
    public float chipIconSize;
    public ColorStateList chipIconTint;
    public boolean chipIconVisible;
    public float chipMinHeight;
    public final Paint chipPaint = new Paint(1);
    public float chipStartPadding;
    public ColorStateList chipStrokeColor;
    public float chipStrokeWidth;
    public ColorStateList chipSurfaceColor;
    public Drawable closeIcon;
    public CharSequence closeIconContentDescription;
    public float closeIconEndPadding;
    public Drawable closeIconRipple;
    public float closeIconSize;
    public float closeIconStartPadding;
    public int[] closeIconStateSet;
    public ColorStateList closeIconTint;
    public boolean closeIconVisible;
    public ColorFilter colorFilter;
    public ColorStateList compatRippleColor;
    public final Context context;
    public boolean currentChecked;
    public int currentChipBackgroundColor;
    public int currentChipStrokeColor;
    public int currentChipSurfaceColor;
    public int currentCompatRippleColor;
    public int currentCompositeSurfaceBackgroundColor;
    public int currentTextColor;
    public int currentTint;
    public final Paint debugPaint;
    public WeakReference<Delegate> delegate;
    public final FontMetrics fontMetrics = new FontMetrics();
    public boolean hasChipIconTint;
    public MotionSpec hideMotionSpec;
    public float iconEndPadding;
    public float iconStartPadding;
    public boolean isShapeThemingEnabled;
    public int maxWidth;
    public final PointF pointF = new PointF();
    public final RectF rectF = new RectF();
    public ColorStateList rippleColor;
    public final Path shapePath = new Path();
    public boolean shouldDrawText;
    public MotionSpec showMotionSpec;
    public CharSequence text;
    public final TextDrawableHelper textDrawableHelper;
    public float textEndPadding;
    public float textStartPadding;
    public ColorStateList tint;
    public PorterDuffColorFilter tintFilter;
    public Mode tintMode = Mode.SRC_IN;
    public TruncateAt truncateAt;
    public boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    public ChipDrawable(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
        Paint paint = null;
        this.delegate = new WeakReference<>(paint);
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        updateZ();
        this.context = context2;
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        this.text = "";
        textDrawableHelper2.textPaint.density = context2.getResources().getDisplayMetrics().density;
        this.debugPaint = paint;
        if (paint != null) {
            paint.setStyle(Style.STROKE);
        }
        setState(DEFAULT_STATE);
        setCloseIconState(DEFAULT_STATE);
        this.shouldDrawText = true;
        boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
        closeIconRippleMask.setTint(-1);
    }

    public final void applyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            b.setLayoutDirection(drawable, b.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.closeIcon) {
                if (drawable.isStateful()) {
                    drawable.setState(this.closeIconStateSet);
                }
                drawable.setTintList(this.closeIconTint);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.chipIcon;
            if (drawable == drawable2 && this.hasChipIconTint) {
                drawable2.setTintList(this.chipIconTint);
            }
        }
    }

    public final void calculateChipIconBounds(Rect rect, RectF rectF2) {
        float f2;
        rectF2.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f3 = this.chipStartPadding + this.iconStartPadding;
            float currentChipIconWidth = getCurrentChipIconWidth();
            if (b.getLayoutDirection(this) == 0) {
                float f4 = ((float) rect.left) + f3;
                rectF2.left = f4;
                rectF2.right = f4 + currentChipIconWidth;
            } else {
                float f5 = ((float) rect.right) - f3;
                rectF2.right = f5;
                rectF2.left = f5 - currentChipIconWidth;
            }
            Drawable drawable = this.currentChecked ? this.checkedIcon : this.chipIcon;
            if (this.chipIconSize > 0.0f || drawable == null) {
                f2 = this.chipIconSize;
            } else {
                f2 = (float) Math.ceil((double) ImageOriginUtils.dpToPx(this.context, 24));
                if (((float) drawable.getIntrinsicHeight()) <= f2) {
                    f2 = (float) drawable.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f2 / 2.0f);
            rectF2.top = exactCenterY;
            rectF2.bottom = exactCenterY + f2;
        }
    }

    public float calculateChipIconWidth() {
        if (!showsChipIcon() && !showsCheckedIcon()) {
            return 0.0f;
        }
        return getCurrentChipIconWidth() + this.iconStartPadding + this.iconEndPadding;
    }

    public final void calculateCloseIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f2 = this.chipEndPadding + this.closeIconEndPadding;
            if (b.getLayoutDirection(this) == 0) {
                float f3 = ((float) rect.right) - f2;
                rectF2.right = f3;
                rectF2.left = f3 - this.closeIconSize;
            } else {
                float f4 = ((float) rect.left) + f2;
                rectF2.left = f4;
                rectF2.right = f4 + this.closeIconSize;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.closeIconSize;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF2.top = f6;
            rectF2.bottom = f6 + f5;
        }
    }

    public final void calculateCloseIconTouchBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f2 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (b.getLayoutDirection(this) == 0) {
                float f3 = (float) rect.right;
                rectF2.right = f3;
                rectF2.left = f3 - f2;
            } else {
                int i = rect.left;
                rectF2.left = (float) i;
                rectF2.right = ((float) i) + f2;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    public float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            int i6 = this.alpha;
            if (i6 != 0) {
                int saveLayerAlpha = i6 < 255 ? canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i6) : 0;
                if (!this.isShapeThemingEnabled) {
                    this.chipPaint.setColor(this.currentChipSurfaceColor);
                    this.chipPaint.setStyle(Style.FILL);
                    this.rectF.set(bounds);
                    canvas2.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
                }
                if (!this.isShapeThemingEnabled) {
                    this.chipPaint.setColor(this.currentChipBackgroundColor);
                    this.chipPaint.setStyle(Style.FILL);
                    Paint paint = this.chipPaint;
                    ColorFilter colorFilter2 = this.colorFilter;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.tintFilter;
                    }
                    paint.setColorFilter(colorFilter2);
                    this.rectF.set(bounds);
                    canvas2.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
                }
                if (this.isShapeThemingEnabled) {
                    super.draw(canvas);
                }
                if (this.chipStrokeWidth > 0.0f && !this.isShapeThemingEnabled) {
                    this.chipPaint.setColor(this.currentChipStrokeColor);
                    this.chipPaint.setStyle(Style.STROKE);
                    if (!this.isShapeThemingEnabled) {
                        Paint paint2 = this.chipPaint;
                        ColorFilter colorFilter3 = this.colorFilter;
                        if (colorFilter3 == null) {
                            colorFilter3 = this.tintFilter;
                        }
                        paint2.setColorFilter(colorFilter3);
                    }
                    RectF rectF2 = this.rectF;
                    float f2 = this.chipStrokeWidth / 2.0f;
                    rectF2.set(((float) bounds.left) + f2, ((float) bounds.top) + f2, ((float) bounds.right) - f2, ((float) bounds.bottom) - f2);
                    float f3 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
                    canvas2.drawRoundRect(this.rectF, f3, f3, this.chipPaint);
                }
                this.chipPaint.setColor(this.currentCompatRippleColor);
                this.chipPaint.setStyle(Style.FILL);
                this.rectF.set(bounds);
                if (!this.isShapeThemingEnabled) {
                    canvas2.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
                } else {
                    calculatePathForSize(new RectF(bounds), this.shapePath);
                    drawShape(canvas, this.chipPaint, this.shapePath, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
                }
                if (showsChipIcon()) {
                    calculateChipIconBounds(bounds, this.rectF);
                    RectF rectF3 = this.rectF;
                    float f4 = rectF3.left;
                    float f5 = rectF3.top;
                    canvas2.translate(f4, f5);
                    this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
                    this.chipIcon.draw(canvas2);
                    canvas2.translate(-f4, -f5);
                }
                if (showsCheckedIcon()) {
                    calculateChipIconBounds(bounds, this.rectF);
                    RectF rectF4 = this.rectF;
                    float f6 = rectF4.left;
                    float f7 = rectF4.top;
                    canvas2.translate(f6, f7);
                    this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
                    this.checkedIcon.draw(canvas2);
                    canvas2.translate(-f6, -f7);
                }
                if (!this.shouldDrawText || this.text == null) {
                    i = saveLayerAlpha;
                    i2 = 0;
                } else {
                    PointF pointF2 = this.pointF;
                    pointF2.set(0.0f, 0.0f);
                    Align align = Align.LEFT;
                    if (this.text != null) {
                        float calculateChipIconWidth = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                        if (b.getLayoutDirection(this) == 0) {
                            pointF2.x = ((float) bounds.left) + calculateChipIconWidth;
                            align = Align.LEFT;
                        } else {
                            pointF2.x = ((float) bounds.right) - calculateChipIconWidth;
                            align = Align.RIGHT;
                        }
                        this.textDrawableHelper.textPaint.getFontMetrics(this.fontMetrics);
                        FontMetrics fontMetrics2 = this.fontMetrics;
                        pointF2.y = ((float) bounds.centerY()) - ((fontMetrics2.descent + fontMetrics2.ascent) / 2.0f);
                    }
                    RectF rectF5 = this.rectF;
                    rectF5.setEmpty();
                    if (this.text != null) {
                        float calculateChipIconWidth2 = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                        float calculateCloseIconWidth = calculateCloseIconWidth() + this.chipEndPadding + this.textEndPadding;
                        if (b.getLayoutDirection(this) == 0) {
                            rectF5.left = ((float) bounds.left) + calculateChipIconWidth2;
                            rectF5.right = ((float) bounds.right) - calculateCloseIconWidth;
                        } else {
                            rectF5.left = ((float) bounds.left) + calculateCloseIconWidth;
                            rectF5.right = ((float) bounds.right) - calculateChipIconWidth2;
                        }
                        rectF5.top = (float) bounds.top;
                        rectF5.bottom = (float) bounds.bottom;
                    }
                    TextDrawableHelper textDrawableHelper2 = this.textDrawableHelper;
                    if (textDrawableHelper2.textAppearance != null) {
                        textDrawableHelper2.textPaint.drawableState = getState();
                        TextDrawableHelper textDrawableHelper3 = this.textDrawableHelper;
                        textDrawableHelper3.textAppearance.updateDrawState(this.context, textDrawableHelper3.textPaint, textDrawableHelper3.fontCallback);
                    }
                    this.textDrawableHelper.textPaint.setTextAlign(align);
                    boolean z = Math.round(this.textDrawableHelper.getTextWidth(this.text.toString())) > Math.round(this.rectF.width());
                    if (z) {
                        i5 = canvas.save();
                        canvas2.clipRect(this.rectF);
                    } else {
                        i5 = 0;
                    }
                    CharSequence charSequence = this.text;
                    if (z && this.truncateAt != null) {
                        charSequence = TextUtils.ellipsize(charSequence, this.textDrawableHelper.textPaint, this.rectF.width(), this.truncateAt);
                    }
                    CharSequence charSequence2 = charSequence;
                    int length = charSequence2.length();
                    PointF pointF3 = this.pointF;
                    i = saveLayerAlpha;
                    i2 = 0;
                    canvas.drawText(charSequence2, 0, length, pointF3.x, pointF3.y, this.textDrawableHelper.textPaint);
                    if (z) {
                        canvas2.restoreToCount(i5);
                    }
                }
                if (showsCloseIcon()) {
                    calculateCloseIconBounds(bounds, this.rectF);
                    RectF rectF6 = this.rectF;
                    float f8 = rectF6.left;
                    float f9 = rectF6.top;
                    canvas2.translate(f8, f9);
                    this.closeIcon.setBounds(i2, i2, (int) this.rectF.width(), (int) this.rectF.height());
                    boolean z2 = RippleUtils.USE_FRAMEWORK_RIPPLE;
                    this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                    this.closeIconRipple.jumpToCurrentState();
                    this.closeIconRipple.draw(canvas2);
                    canvas2.translate(-f8, -f9);
                }
                Paint paint3 = this.debugPaint;
                if (paint3 != null) {
                    paint3.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
                    canvas2.drawRect(bounds, this.debugPaint);
                    if (showsChipIcon() || showsCheckedIcon()) {
                        calculateChipIconBounds(bounds, this.rectF);
                        canvas2.drawRect(this.rectF, this.debugPaint);
                    }
                    if (this.text != null) {
                        float f10 = (float) bounds.left;
                        float exactCenterY = bounds.exactCenterY();
                        float f11 = (float) bounds.right;
                        float exactCenterY2 = bounds.exactCenterY();
                        Paint paint4 = this.debugPaint;
                        i4 = InvitationReply.EXPIRED;
                        i3 = i;
                        canvas.drawLine(f10, exactCenterY, f11, exactCenterY2, paint4);
                    } else {
                        i3 = i;
                        i4 = InvitationReply.EXPIRED;
                    }
                    if (showsCloseIcon()) {
                        calculateCloseIconBounds(bounds, this.rectF);
                        canvas2.drawRect(this.rectF, this.debugPaint);
                    }
                    this.debugPaint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
                    RectF rectF7 = this.rectF;
                    rectF7.set(bounds);
                    if (showsCloseIcon()) {
                        float f12 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
                        if (b.getLayoutDirection(this) == 0) {
                            rectF7.right = ((float) bounds.right) - f12;
                        } else {
                            rectF7.left = ((float) bounds.left) + f12;
                        }
                    }
                    canvas2.drawRect(this.rectF, this.debugPaint);
                    this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
                    calculateCloseIconTouchBounds(bounds, this.rectF);
                    canvas2.drawRect(this.rectF, this.debugPaint);
                } else {
                    i3 = i;
                    i4 = InvitationReply.EXPIRED;
                }
                if (this.alpha < i4) {
                    canvas2.restoreToCount(i3);
                }
            }
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    public float getChipCornerRadius() {
        return this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius;
    }

    public Drawable getCloseIcon() {
        Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return b.unwrap(drawable);
        }
        return null;
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final float getCurrentChipIconWidth() {
        Drawable drawable = this.currentChecked ? this.checkedIcon : this.chipIcon;
        if (this.chipIconSize > 0.0f || drawable == null) {
            return this.chipIconSize;
        }
        return (float) drawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(calculateCloseIconWidth() + this.textDrawableHelper.getTextWidth(this.text.toString()) + calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding + this.textEndPadding + this.chipEndPadding), this.maxWidth);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.chipMinHeight, this.chipCornerRadius);
        }
        outline.setAlpha(((float) this.alpha) / 255.0f);
    }

    public void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r3 = this;
            android.content.res.ColorStateList r0 = r3.chipSurfaceColor
            boolean r0 = isStateful(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0066
            android.content.res.ColorStateList r0 = r3.chipBackgroundColor
            boolean r0 = isStateful(r0)
            if (r0 != 0) goto L_0x0066
            android.content.res.ColorStateList r0 = r3.chipStrokeColor
            boolean r0 = isStateful(r0)
            if (r0 != 0) goto L_0x0066
            boolean r0 = r3.useCompatRipple
            if (r0 == 0) goto L_0x0026
            android.content.res.ColorStateList r0 = r3.compatRippleColor
            boolean r0 = isStateful(r0)
            if (r0 != 0) goto L_0x0066
        L_0x0026:
            com.google.android.material.internal.TextDrawableHelper r0 = r3.textDrawableHelper
            com.google.android.material.resources.TextAppearance r0 = r0.textAppearance
            if (r0 == 0) goto L_0x0038
            android.content.res.ColorStateList r0 = r0.textColor
            if (r0 == 0) goto L_0x0038
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 != 0) goto L_0x0066
            boolean r0 = r3.checkedIconVisible
            if (r0 == 0) goto L_0x0049
            android.graphics.drawable.Drawable r0 = r3.checkedIcon
            if (r0 == 0) goto L_0x0049
            boolean r0 = r3.checkable
            if (r0 == 0) goto L_0x0049
            r0 = 1
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            if (r0 != 0) goto L_0x0066
            android.graphics.drawable.Drawable r0 = r3.chipIcon
            boolean r0 = isStateful(r0)
            if (r0 != 0) goto L_0x0066
            android.graphics.drawable.Drawable r0 = r3.checkedIcon
            boolean r0 = isStateful(r0)
            if (r0 != 0) goto L_0x0066
            android.content.res.ColorStateList r0 = r3.tint
            boolean r0 = isStateful(r0)
            if (r0 == 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.isStateful():boolean");
    }

    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= b.setLayoutDirection(this.chipIcon, i);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= b.setLayoutDirection(this.checkedIcon, i);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= b.setLayoutDirection(this.closeIcon, i);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
        }
        return true;
    }

    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public void onSizeChange() {
        Delegate delegate2 = (Delegate) this.delegate.get();
        if (delegate2 != null) {
            delegate2.onChipDrawableSizeChange();
        }
    }

    public boolean onStateChange(int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, this.closeIconStateSet);
    }

    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        if (this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (this.checkedIconVisible && this.checkedIcon != null && this.checkable) {
                this.checkedIcon.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        if (this.chipCornerRadius != f2) {
            this.chipCornerRadius = f2;
            this.drawableState.shapeAppearanceModel = this.drawableState.shapeAppearanceModel.withCornerSize(f2);
            invalidateSelf();
        }
    }

    public void setChipEndPadding(float f2) {
        if (this.chipEndPadding != f2) {
            this.chipEndPadding = f2;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipIcon(Drawable drawable) {
        Drawable drawable2 = this.chipIcon;
        Drawable drawable3 = null;
        Drawable unwrap = drawable2 != null ? b.unwrap(drawable2) : null;
        if (unwrap != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            if (drawable != null) {
                drawable3 = b.wrap(drawable).mutate();
            }
            this.chipIcon = drawable3;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(unwrap);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSize(float f2) {
        if (this.chipIconSize != f2) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f2;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                this.chipIcon.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipMinHeight(float f2) {
        if (this.chipMinHeight != f2) {
            this.chipMinHeight = f2;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPadding(float f2) {
        if (this.chipStartPadding != f2) {
            this.chipStartPadding = f2;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeWidth(float f2) {
        if (this.chipStrokeWidth != f2) {
            this.chipStrokeWidth = f2;
            this.chipPaint.setStrokeWidth(f2);
            if (this.isShapeThemingEnabled) {
                this.drawableState.strokeWidth = f2;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void setCloseIcon(Drawable drawable) {
        Drawable closeIcon2 = getCloseIcon();
        if (closeIcon2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            this.closeIcon = drawable != null ? b.wrap(drawable).mutate() : null;
            boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
            this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), this.closeIcon, closeIconRippleMask);
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPadding(float f2) {
        if (this.closeIconEndPadding != f2) {
            this.closeIconEndPadding = f2;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSize(float f2) {
        if (this.closeIconSize != f2) {
            this.closeIconSize = f2;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPadding(float f2) {
        if (this.closeIconStartPadding != f2) {
            this.closeIconStartPadding = f2;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public boolean setCloseIconState(int[] iArr) {
        if (!Arrays.equals(this.closeIconStateSet, iArr)) {
            this.closeIconStateSet = iArr;
            if (showsCloseIcon()) {
                return onStateChange(getState(), iArr);
            }
        }
        return false;
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                this.closeIcon.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter2) {
        if (this.colorFilter != colorFilter2) {
            this.colorFilter = colorFilter2;
            invalidateSelf();
        }
    }

    public void setIconEndPadding(float f2) {
        if (this.iconEndPadding != f2) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f2;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPadding(float f2) {
        if (this.iconStartPadding != f2) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f2;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            this.compatRippleColor = this.useCompatRipple ? RippleUtils.sanitizeRippleDrawableColor(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textDrawableHelper.textWidthDirty = true;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextEndPadding(float f2) {
        if (this.textEndPadding != f2) {
            this.textEndPadding = f2;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPadding(float f2) {
        if (this.textStartPadding != f2) {
            this.textStartPadding = f2;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = ImageOriginUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z) {
        if (this.useCompatRipple != z) {
            this.useCompatRipple = z;
            this.compatRippleColor = z ? RippleUtils.sanitizeRippleDrawableColor(this.rippleColor) : null;
            onStateChange(getState());
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    public final boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    public final boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    public final void unapplyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onStateChange(int[] r9, int[] r10) {
        /*
            r8 = this;
            boolean r0 = super.onStateChange(r9)
            android.content.res.ColorStateList r1 = r8.chipSurfaceColor
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r8.currentChipSurfaceColor
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r1 = r8.compositeElevationOverlayIfNeeded(r1)
            int r3 = r8.currentChipSurfaceColor
            r4 = 1
            if (r3 == r1) goto L_0x001d
            r8.currentChipSurfaceColor = r1
            r0 = 1
        L_0x001d:
            android.content.res.ColorStateList r3 = r8.chipBackgroundColor
            if (r3 == 0) goto L_0x0028
            int r5 = r8.currentChipBackgroundColor
            int r3 = r3.getColorForState(r9, r5)
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            int r3 = r8.compositeElevationOverlayIfNeeded(r3)
            int r5 = r8.currentChipBackgroundColor
            if (r5 == r3) goto L_0x0034
            r8.currentChipBackgroundColor = r3
            r0 = 1
        L_0x0034:
            int r1 = androidx.core.graphics.ColorUtils.compositeColors(r3, r1)
            int r3 = r8.currentCompositeSurfaceBackgroundColor
            if (r3 == r1) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r5 = r8.drawableState
            android.content.res.ColorStateList r5 = r5.fillColor
            if (r5 != 0) goto L_0x0047
            r5 = 1
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            r3 = r3 | r5
            if (r3 == 0) goto L_0x0055
            r8.currentCompositeSurfaceBackgroundColor = r1
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r1)
            r8.setFillColor(r0)
            r0 = 1
        L_0x0055:
            android.content.res.ColorStateList r1 = r8.chipStrokeColor
            if (r1 == 0) goto L_0x0060
            int r3 = r8.currentChipStrokeColor
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            int r3 = r8.currentChipStrokeColor
            if (r3 == r1) goto L_0x0068
            r8.currentChipStrokeColor = r1
            r0 = 1
        L_0x0068:
            android.content.res.ColorStateList r1 = r8.compatRippleColor
            if (r1 == 0) goto L_0x007b
            boolean r1 = com.google.android.material.ripple.RippleUtils.shouldDrawRippleCompat(r9)
            if (r1 == 0) goto L_0x007b
            android.content.res.ColorStateList r1 = r8.compatRippleColor
            int r3 = r8.currentCompatRippleColor
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x007c
        L_0x007b:
            r1 = 0
        L_0x007c:
            int r3 = r8.currentCompatRippleColor
            if (r3 == r1) goto L_0x0087
            r8.currentCompatRippleColor = r1
            boolean r1 = r8.useCompatRipple
            if (r1 == 0) goto L_0x0087
            r0 = 1
        L_0x0087:
            com.google.android.material.internal.TextDrawableHelper r1 = r8.textDrawableHelper
            com.google.android.material.resources.TextAppearance r1 = r1.textAppearance
            if (r1 == 0) goto L_0x0098
            android.content.res.ColorStateList r1 = r1.textColor
            if (r1 == 0) goto L_0x0098
            int r3 = r8.currentTextColor
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0099
        L_0x0098:
            r1 = 0
        L_0x0099:
            int r3 = r8.currentTextColor
            if (r3 == r1) goto L_0x00a0
            r8.currentTextColor = r1
            r0 = 1
        L_0x00a0:
            int[] r1 = r8.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            if (r1 != 0) goto L_0x00ab
        L_0x00a9:
            r1 = 0
            goto L_0x00b8
        L_0x00ab:
            int r5 = r1.length
            r6 = 0
        L_0x00ad:
            if (r6 >= r5) goto L_0x00a9
            r7 = r1[r6]
            if (r7 != r3) goto L_0x00b5
            r1 = 1
            goto L_0x00b8
        L_0x00b5:
            int r6 = r6 + 1
            goto L_0x00ad
        L_0x00b8:
            if (r1 == 0) goto L_0x00c0
            boolean r1 = r8.checkable
            if (r1 == 0) goto L_0x00c0
            r1 = 1
            goto L_0x00c1
        L_0x00c0:
            r1 = 0
        L_0x00c1:
            boolean r3 = r8.currentChecked
            if (r3 == r1) goto L_0x00db
            android.graphics.drawable.Drawable r3 = r8.checkedIcon
            if (r3 == 0) goto L_0x00db
            float r0 = r8.calculateChipIconWidth()
            r8.currentChecked = r1
            float r1 = r8.calculateChipIconWidth()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00da
            r0 = 1
            r1 = 1
            goto L_0x00dc
        L_0x00da:
            r0 = 1
        L_0x00db:
            r1 = 0
        L_0x00dc:
            android.content.res.ColorStateList r3 = r8.tint
            if (r3 == 0) goto L_0x00e7
            int r5 = r8.currentTint
            int r3 = r3.getColorForState(r9, r5)
            goto L_0x00e8
        L_0x00e7:
            r3 = 0
        L_0x00e8:
            int r5 = r8.currentTint
            if (r5 == r3) goto L_0x00f9
            r8.currentTint = r3
            android.content.res.ColorStateList r0 = r8.tint
            android.graphics.PorterDuff$Mode r3 = r8.tintMode
            android.graphics.PorterDuffColorFilter r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.updateTintFilter(r8, r0, r3)
            r8.tintFilter = r0
            goto L_0x00fa
        L_0x00f9:
            r4 = r0
        L_0x00fa:
            android.graphics.drawable.Drawable r0 = r8.chipIcon
            boolean r0 = isStateful(r0)
            if (r0 == 0) goto L_0x0109
            android.graphics.drawable.Drawable r0 = r8.chipIcon
            boolean r0 = r0.setState(r9)
            r4 = r4 | r0
        L_0x0109:
            android.graphics.drawable.Drawable r0 = r8.checkedIcon
            boolean r0 = isStateful(r0)
            if (r0 == 0) goto L_0x0118
            android.graphics.drawable.Drawable r0 = r8.checkedIcon
            boolean r0 = r0.setState(r9)
            r4 = r4 | r0
        L_0x0118:
            android.graphics.drawable.Drawable r0 = r8.closeIcon
            boolean r0 = isStateful(r0)
            if (r0 == 0) goto L_0x0135
            int r0 = r9.length
            int r3 = r10.length
            int r0 = r0 + r3
            int[] r0 = new int[r0]
            int r3 = r9.length
            java.lang.System.arraycopy(r9, r2, r0, r2, r3)
            int r9 = r9.length
            int r3 = r10.length
            java.lang.System.arraycopy(r10, r2, r0, r9, r3)
            android.graphics.drawable.Drawable r9 = r8.closeIcon
            boolean r9 = r9.setState(r0)
            r4 = r4 | r9
        L_0x0135:
            boolean r9 = com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE
            android.graphics.drawable.Drawable r9 = r8.closeIconRipple
            boolean r9 = isStateful(r9)
            if (r9 == 0) goto L_0x0146
            android.graphics.drawable.Drawable r9 = r8.closeIconRipple
            boolean r9 = r9.setState(r10)
            r4 = r4 | r9
        L_0x0146:
            if (r4 == 0) goto L_0x014b
            r8.invalidateSelf()
        L_0x014b:
            if (r1 == 0) goto L_0x0150
            r8.onSizeChange()
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.onStateChange(int[], int[]):boolean");
    }

    public static boolean isStateful(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean isStateful(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }
}
