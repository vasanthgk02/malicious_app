package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.Spacing;
import java.util.Arrays;
import java.util.Locale;
import sfs2x.client.entities.invitation.InvitationReply;

public class ReactViewBackgroundDrawable extends Drawable {
    public int mAlpha = InvitationReply.EXPIRED;
    public Spacing mBorderAlpha;
    public float[] mBorderCornerRadii;
    public Spacing mBorderRGB;
    public float mBorderRadius = Float.NaN;
    public BorderStyle mBorderStyle;
    public Spacing mBorderWidth;
    public Path mCenterDrawPath;
    public int mColor = 0;
    public final Context mContext;
    public PointF mInnerBottomLeftCorner;
    public PointF mInnerBottomRightCorner;
    public Path mInnerClipPathForBorderRadius;
    public RectF mInnerClipTempRectForBorderRadius;
    public PointF mInnerTopLeftCorner;
    public PointF mInnerTopRightCorner;
    public int mLayoutDirection;
    public boolean mNeedUpdatePathForBorderRadius = false;
    public Path mOuterClipPathForBorderRadius;
    public RectF mOuterClipTempRectForBorderRadius;
    public final Paint mPaint = new Paint(1);
    public PathEffect mPathEffectForBorderStyle;
    public Path mPathForBorder;
    public Path mPathForBorderRadiusOutline;
    public RectF mTempRectForBorderRadiusOutline;
    public RectF mTempRectForCenterDrawPath;

    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    public enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED;

        public static PathEffect getPathEffect(BorderStyle borderStyle, float f2) {
            int ordinal = borderStyle.ordinal();
            if (ordinal == 1) {
                float f3 = f2 * 3.0f;
                return new DashPathEffect(new float[]{f3, f3, f3, f3}, 0.0f);
            } else if (ordinal != 2) {
                return null;
            } else {
                return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
            }
        }
    }

    public ReactViewBackgroundDrawable(Context context) {
        this.mContext = context;
    }

    public static void getEllipseIntersectionWithLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, PointF pointF) {
        PointF pointF2 = pointF;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = (d3 + d5) / 2.0d;
        double d12 = d6 - d10;
        double d13 = d7 - d11;
        double abs = Math.abs(d4 - d2) / 2.0d;
        double abs2 = Math.abs(d5 - d3) / 2.0d;
        double d14 = ((d9 - d11) - d13) / ((d8 - d10) - d12);
        double d15 = d13 - (d12 * d14);
        double d16 = abs2 * abs2;
        double d17 = abs * abs;
        double outline2 = GeneratedOutlineSupport.outline2(d17, d14, d14, d16);
        double d18 = 2.0d * abs * abs * d15 * d14;
        double d19 = (-(d17 * ((d15 * d15) - d16))) / outline2;
        double d20 = outline2 * 2.0d;
        double sqrt = ((-d18) / d20) - Math.sqrt(Math.pow(d18 / d20, 2.0d) + d19);
        double d21 = (d14 * sqrt) + d15;
        double d22 = sqrt + d10;
        double d23 = d21 + d11;
        if (!Double.isNaN(d22) && !Double.isNaN(d23)) {
            PointF pointF3 = pointF;
            pointF3.x = (float) d22;
            pointF3.y = (float) d23;
        }
    }

    public void draw(Canvas canvas) {
        Canvas canvas2;
        int i;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        int i3;
        int i4;
        int i5;
        int i6;
        Canvas canvas3 = canvas;
        BorderStyle borderStyle = this.mBorderStyle;
        PathEffect pathEffect = borderStyle != null ? BorderStyle.getPathEffect(borderStyle, getFullBorderWidth()) : null;
        this.mPathEffectForBorderStyle = pathEffect;
        this.mPaint.setPathEffect(pathEffect);
        boolean z = false;
        if (!hasRoundedBorders()) {
            this.mPaint.setStyle(Style.FILL);
            int multiplyColorAlpha1 = ImageOriginUtils.multiplyColorAlpha1(this.mColor, this.mAlpha);
            if (Color.alpha(multiplyColorAlpha1) != 0) {
                this.mPaint.setColor(multiplyColorAlpha1);
                canvas3.drawRect(getBounds(), this.mPaint);
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            int round = Math.round(directionAwareBorderInsets.left);
            int round2 = Math.round(directionAwareBorderInsets.top);
            int round3 = Math.round(directionAwareBorderInsets.right);
            int round4 = Math.round(directionAwareBorderInsets.bottom);
            if (round > 0 || round3 > 0 || round2 > 0 || round4 > 0) {
                Rect bounds = getBounds();
                int borderColor = getBorderColor(0);
                int borderColor2 = getBorderColor(1);
                int borderColor3 = getBorderColor(2);
                int borderColor4 = getBorderColor(3);
                boolean z2 = this.mLayoutDirection == 1;
                int borderColor5 = getBorderColor(4);
                int borderColor6 = getBorderColor(5);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                    if (isBorderColorDefined(4)) {
                        borderColor = borderColor5;
                    }
                    if (isBorderColorDefined(5)) {
                        borderColor3 = borderColor6;
                    }
                    int i7 = z2 ? borderColor3 : borderColor;
                    if (!z2) {
                        borderColor = borderColor3;
                    }
                    i4 = i7;
                    i3 = borderColor;
                } else {
                    int i8 = z2 ? borderColor6 : borderColor5;
                    if (!z2) {
                        borderColor5 = borderColor6;
                    }
                    boolean isBorderColorDefined = isBorderColorDefined(4);
                    boolean isBorderColorDefined2 = isBorderColorDefined(5);
                    boolean z3 = z2 ? isBorderColorDefined2 : isBorderColorDefined;
                    if (!z2) {
                        isBorderColorDefined = isBorderColorDefined2;
                    }
                    if (z3) {
                        borderColor = i8;
                    }
                    if (isBorderColorDefined) {
                        i4 = borderColor;
                        i3 = borderColor5;
                    } else {
                        i3 = borderColor3;
                        i4 = borderColor;
                    }
                }
                int i9 = bounds.left;
                int i10 = bounds.top;
                int i11 = -1;
                int i12 = (round > 0 ? i4 : -1) & (round2 > 0 ? borderColor2 : -1) & (round3 > 0 ? i3 : -1);
                if (round4 > 0) {
                    i11 = borderColor4;
                }
                int i13 = i11 & i12;
                if (i13 != ((round > 0 ? i4 : 0) | (round2 > 0 ? borderColor2 : 0) | (round3 > 0 ? i3 : 0) | (round4 > 0 ? borderColor4 : 0))) {
                    i13 = 0;
                }
                if (i13 == 0) {
                    this.mPaint.setAntiAlias(false);
                    int width = bounds.width();
                    int height = bounds.height();
                    if (round > 0) {
                        float f6 = (float) i9;
                        float f7 = (float) (i9 + round);
                        int i14 = i10 + height;
                        i5 = i10;
                        i6 = i9;
                        drawQuadrilateral(canvas, i4, f6, (float) i10, f7, (float) (i10 + round2), f7, (float) (i14 - round4), f6, (float) i14);
                    } else {
                        i5 = i10;
                        i6 = i9;
                    }
                    if (round2 > 0) {
                        float f8 = (float) i5;
                        float f9 = (float) (i5 + round2);
                        int i15 = i6 + width;
                        drawQuadrilateral(canvas, borderColor2, (float) i6, f8, (float) (i6 + round), f9, (float) (i15 - round3), f9, (float) i15, f8);
                    }
                    if (round3 > 0) {
                        int i16 = i6 + width;
                        float f10 = (float) i16;
                        int i17 = i5 + height;
                        float f11 = (float) (i16 - round3);
                        drawQuadrilateral(canvas, i3, f10, (float) i5, f10, (float) i17, f11, (float) (i17 - round4), f11, (float) (i5 + round2));
                    }
                    if (round4 > 0) {
                        int i18 = i5 + height;
                        float f12 = (float) i18;
                        int i19 = i6 + width;
                        float f13 = (float) i19;
                        float f14 = (float) (i19 - round3);
                        float f15 = (float) (i18 - round4);
                        drawQuadrilateral(canvas, borderColor4, (float) i6, f12, f13, f12, f14, f15, (float) (i6 + round), f15);
                    }
                    this.mPaint.setAntiAlias(true);
                } else if (Color.alpha(i13) != 0) {
                    int i20 = bounds.right;
                    int i21 = bounds.bottom;
                    this.mPaint.setColor(i13);
                    if (round > 0) {
                        canvas.drawRect((float) i9, (float) i10, (float) (i9 + round), (float) (i21 - round4), this.mPaint);
                    }
                    if (round2 > 0) {
                        canvas.drawRect((float) (round + i9), (float) i10, (float) i20, (float) (i10 + round2), this.mPaint);
                    }
                    if (round3 > 0) {
                        canvas.drawRect((float) (i20 - round3), (float) (i10 + round2), (float) i20, (float) i21, this.mPaint);
                    }
                    if (round4 > 0) {
                        canvas.drawRect((float) i9, (float) (i21 - round4), (float) (i20 - round3), (float) i21, this.mPaint);
                    }
                }
            }
        } else {
            updatePath();
            canvas.save();
            int multiplyColorAlpha12 = ImageOriginUtils.multiplyColorAlpha1(this.mColor, this.mAlpha);
            if (Color.alpha(multiplyColorAlpha12) != 0) {
                this.mPaint.setColor(multiplyColorAlpha12);
                this.mPaint.setStyle(Style.FILL);
                canvas2 = canvas;
                canvas2.drawPath(this.mInnerClipPathForBorderRadius, this.mPaint);
            } else {
                canvas2 = canvas;
            }
            RectF directionAwareBorderInsets2 = getDirectionAwareBorderInsets();
            int borderColor7 = getBorderColor(0);
            int borderColor8 = getBorderColor(1);
            int borderColor9 = getBorderColor(2);
            int borderColor10 = getBorderColor(3);
            if (directionAwareBorderInsets2.top > 0.0f || directionAwareBorderInsets2.bottom > 0.0f || directionAwareBorderInsets2.left > 0.0f || directionAwareBorderInsets2.right > 0.0f) {
                float fullBorderWidth = getFullBorderWidth();
                int borderColor11 = getBorderColor(8);
                if (directionAwareBorderInsets2.top != fullBorderWidth || directionAwareBorderInsets2.bottom != fullBorderWidth || directionAwareBorderInsets2.left != fullBorderWidth || directionAwareBorderInsets2.right != fullBorderWidth || borderColor7 != borderColor11 || borderColor8 != borderColor11 || borderColor9 != borderColor11 || borderColor10 != borderColor11) {
                    this.mPaint.setStyle(Style.FILL);
                    canvas2.clipPath(this.mOuterClipPathForBorderRadius, Op.INTERSECT);
                    canvas2.clipPath(this.mInnerClipPathForBorderRadius, Op.DIFFERENCE);
                    if (this.mLayoutDirection == 1) {
                        z = true;
                    }
                    int borderColor12 = getBorderColor(4);
                    int borderColor13 = getBorderColor(5);
                    if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                        if (isBorderColorDefined(4)) {
                            borderColor7 = borderColor12;
                        }
                        if (isBorderColorDefined(5)) {
                            borderColor9 = borderColor13;
                        }
                        int i22 = z ? borderColor9 : borderColor7;
                        if (!z) {
                            borderColor7 = borderColor9;
                        }
                        i = borderColor7;
                        i2 = i22;
                    } else {
                        int i23 = z ? borderColor13 : borderColor12;
                        if (!z) {
                            borderColor12 = borderColor13;
                        }
                        boolean isBorderColorDefined3 = isBorderColorDefined(4);
                        boolean isBorderColorDefined4 = isBorderColorDefined(5);
                        boolean z4 = z ? isBorderColorDefined4 : isBorderColorDefined3;
                        if (!z) {
                            isBorderColorDefined3 = isBorderColorDefined4;
                        }
                        if (z4) {
                            borderColor7 = i23;
                        }
                        if (isBorderColorDefined3) {
                            i2 = borderColor7;
                            i = borderColor12;
                        } else {
                            i2 = borderColor7;
                            i = borderColor9;
                        }
                    }
                    RectF rectF = this.mOuterClipTempRectForBorderRadius;
                    float f16 = rectF.left;
                    float f17 = rectF.right;
                    float f18 = rectF.top;
                    float f19 = rectF.bottom;
                    if (directionAwareBorderInsets2.left > 0.0f) {
                        PointF pointF = this.mInnerTopLeftCorner;
                        float f20 = pointF.x;
                        float f21 = pointF.y;
                        PointF pointF2 = this.mInnerBottomLeftCorner;
                        f3 = f19;
                        f4 = f18;
                        f5 = f17;
                        f2 = f16;
                        drawQuadrilateral(canvas, i2, f16, f18, f20, f21, pointF2.x, pointF2.y, f16, f3);
                    } else {
                        f3 = f19;
                        f4 = f18;
                        f5 = f17;
                        f2 = f16;
                    }
                    if (directionAwareBorderInsets2.top > 0.0f) {
                        PointF pointF3 = this.mInnerTopLeftCorner;
                        float f22 = pointF3.x;
                        float f23 = pointF3.y;
                        PointF pointF4 = this.mInnerTopRightCorner;
                        drawQuadrilateral(canvas, borderColor8, f2, f4, f22, f23, pointF4.x, pointF4.y, f5, f4);
                    }
                    if (directionAwareBorderInsets2.right > 0.0f) {
                        PointF pointF5 = this.mInnerTopRightCorner;
                        float f24 = pointF5.x;
                        float f25 = pointF5.y;
                        PointF pointF6 = this.mInnerBottomRightCorner;
                        drawQuadrilateral(canvas, i, f5, f4, f24, f25, pointF6.x, pointF6.y, f5, f3);
                    }
                    if (directionAwareBorderInsets2.bottom > 0.0f) {
                        PointF pointF7 = this.mInnerBottomLeftCorner;
                        float f26 = pointF7.x;
                        float f27 = pointF7.y;
                        PointF pointF8 = this.mInnerBottomRightCorner;
                        drawQuadrilateral(canvas, borderColor10, f2, f3, f26, f27, pointF8.x, pointF8.y, f5, f3);
                    }
                } else if (fullBorderWidth > 0.0f) {
                    this.mPaint.setColor(ImageOriginUtils.multiplyColorAlpha1(borderColor11, this.mAlpha));
                    this.mPaint.setStyle(Style.STROKE);
                    this.mPaint.setStrokeWidth(fullBorderWidth);
                    canvas2.drawPath(this.mCenterDrawPath, this.mPaint);
                }
            }
            canvas.restore();
        }
    }

    public final void drawQuadrilateral(Canvas canvas, int i, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (i != 0) {
            if (this.mPathForBorder == null) {
                this.mPathForBorder = new Path();
            }
            this.mPaint.setColor(i);
            this.mPathForBorder.reset();
            this.mPathForBorder.moveTo(f2, f3);
            this.mPathForBorder.lineTo(f4, f5);
            this.mPathForBorder.lineTo(f6, f7);
            this.mPathForBorder.lineTo(f8, f9);
            this.mPathForBorder.lineTo(f2, f3);
            canvas.drawPath(this.mPathForBorder, this.mPaint);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public final int getBorderColor(int i) {
        Spacing spacing = this.mBorderRGB;
        float f2 = spacing != null ? spacing.get(i) : 0.0f;
        Spacing spacing2 = this.mBorderAlpha;
        return ((((int) (spacing2 != null ? spacing2.get(i) : 255.0f)) << 24) & -16777216) | (((int) f2) & 16777215);
    }

    public float getBorderRadius(BorderRadiusLocation borderRadiusLocation) {
        return getBorderRadiusOrDefaultTo(Float.NaN, borderRadiusLocation);
    }

    public float getBorderRadiusOrDefaultTo(float f2, BorderRadiusLocation borderRadiusLocation) {
        float[] fArr = this.mBorderCornerRadii;
        if (fArr == null) {
            return f2;
        }
        float f3 = fArr[borderRadiusLocation.ordinal()];
        return ImageOriginUtils.isUndefined(f3) ? f2 : f3;
    }

    public float getBorderWidthOrDefaultTo(float f2, int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return f2;
        }
        float f3 = spacing.mSpacing[i];
        return ImageOriginUtils.isUndefined(f3) ? f2 : f3;
    }

    public RectF getDirectionAwareBorderInsets() {
        float borderWidthOrDefaultTo = getBorderWidthOrDefaultTo(0.0f, 8);
        boolean z = true;
        float borderWidthOrDefaultTo2 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 1);
        float borderWidthOrDefaultTo3 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 3);
        float borderWidthOrDefaultTo4 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 0);
        float borderWidthOrDefaultTo5 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 2);
        if (this.mBorderWidth != null) {
            if (this.mLayoutDirection != 1) {
                z = false;
            }
            float[] fArr = this.mBorderWidth.mSpacing;
            float f2 = fArr[4];
            float f3 = fArr[5];
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!ImageOriginUtils.isUndefined(f2)) {
                    borderWidthOrDefaultTo4 = f2;
                }
                if (!ImageOriginUtils.isUndefined(f3)) {
                    borderWidthOrDefaultTo5 = f3;
                }
                float f4 = z ? borderWidthOrDefaultTo5 : borderWidthOrDefaultTo4;
                if (z) {
                    borderWidthOrDefaultTo5 = borderWidthOrDefaultTo4;
                }
                borderWidthOrDefaultTo4 = f4;
            } else {
                float f5 = z ? f3 : f2;
                if (!z) {
                    f2 = f3;
                }
                if (!ImageOriginUtils.isUndefined(f5)) {
                    borderWidthOrDefaultTo4 = f5;
                }
                if (!ImageOriginUtils.isUndefined(f2)) {
                    borderWidthOrDefaultTo5 = f2;
                }
            }
        }
        return new RectF(borderWidthOrDefaultTo4, borderWidthOrDefaultTo2, borderWidthOrDefaultTo5, borderWidthOrDefaultTo3);
    }

    public float getFullBorderWidth() {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null || ImageOriginUtils.isUndefined(spacing.mSpacing[8])) {
            return 0.0f;
        }
        return this.mBorderWidth.mSpacing[8];
    }

    public int getOpacity() {
        int multiplyColorAlpha1 = ImageOriginUtils.multiplyColorAlpha1(this.mColor, this.mAlpha) >>> 24;
        if (multiplyColorAlpha1 == 255) {
            return -1;
        }
        return multiplyColorAlpha1 == 0 ? -2 : -3;
    }

    public void getOutline(Outline outline) {
        if ((ImageOriginUtils.isUndefined(this.mBorderRadius) || this.mBorderRadius <= 0.0f) && this.mBorderCornerRadii == null) {
            outline.setRect(getBounds());
            return;
        }
        updatePath();
        outline.setConvexPath(this.mPathForBorderRadiusOutline);
    }

    public boolean hasRoundedBorders() {
        if (!ImageOriginUtils.isUndefined(this.mBorderRadius) && this.mBorderRadius > 0.0f) {
            return true;
        }
        float[] fArr = this.mBorderCornerRadii;
        if (fArr != null) {
            for (float f2 : fArr) {
                if (!ImageOriginUtils.isUndefined(f2) && f2 > 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isBorderColorDefined(int i) {
        Spacing spacing = this.mBorderRGB;
        float f2 = Float.NaN;
        float f3 = spacing != null ? spacing.get(i) : Float.NaN;
        Spacing spacing2 = this.mBorderAlpha;
        if (spacing2 != null) {
            f2 = spacing2.get(i);
        }
        return !ImageOriginUtils.isUndefined(f3) && !ImageOriginUtils.isUndefined(f2);
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public void setBorderColor(int i, float f2, float f3) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing(0.0f);
        }
        if (!ImageOriginUtils.floatsEqual(this.mBorderRGB.mSpacing[i], f2)) {
            this.mBorderRGB.set(i, f2);
            invalidateSelf();
        }
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        if (!ImageOriginUtils.floatsEqual(this.mBorderAlpha.mSpacing[i], f3)) {
            this.mBorderAlpha.set(i, f3);
            invalidateSelf();
        }
    }

    public void setBorderStyle(String str) {
        BorderStyle borderStyle;
        if (str == null) {
            borderStyle = null;
        } else {
            borderStyle = BorderStyle.valueOf(str.toUpperCase(Locale.US));
        }
        if (this.mBorderStyle != borderStyle) {
            this.mBorderStyle = borderStyle;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setBorderWidth(int i, float f2) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new Spacing(0.0f);
        }
        if (!ImageOriginUtils.floatsEqual(this.mBorderWidth.mSpacing[i], f2)) {
            this.mBorderWidth.set(i, f2);
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                this.mNeedUpdatePathForBorderRadius = true;
            }
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setRadius(float f2, int i) {
        if (this.mBorderCornerRadii == null) {
            float[] fArr = new float[8];
            this.mBorderCornerRadii = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (!ImageOriginUtils.floatsEqual(this.mBorderCornerRadii[i], f2)) {
            this.mBorderCornerRadii[i] = f2;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public final void updatePath() {
        float f2;
        float f3;
        int i;
        float f4;
        if (this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            this.mInnerClipTempRectForBorderRadius.set(getBounds());
            this.mOuterClipTempRectForBorderRadius.set(getBounds());
            this.mTempRectForBorderRadiusOutline.set(getBounds());
            this.mTempRectForCenterDrawPath.set(getBounds());
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            RectF rectF = this.mInnerClipTempRectForBorderRadius;
            rectF.top += directionAwareBorderInsets.top;
            rectF.bottom -= directionAwareBorderInsets.bottom;
            rectF.left += directionAwareBorderInsets.left;
            rectF.right -= directionAwareBorderInsets.right;
            RectF rectF2 = this.mTempRectForCenterDrawPath;
            rectF2.top = (directionAwareBorderInsets.top * 0.5f) + rectF2.top;
            rectF2.bottom -= directionAwareBorderInsets.bottom * 0.5f;
            rectF2.left = (directionAwareBorderInsets.left * 0.5f) + rectF2.left;
            rectF2.right -= directionAwareBorderInsets.right * 0.5f;
            float f5 = ImageOriginUtils.isUndefined(this.mBorderRadius) ? 0.0f : this.mBorderRadius;
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(f5, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(f5, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(f5, BorderRadiusLocation.BOTTOM_LEFT);
            float borderRadiusOrDefaultTo4 = getBorderRadiusOrDefaultTo(f5, BorderRadiusLocation.BOTTOM_RIGHT);
            boolean z = this.mLayoutDirection == 1;
            float borderRadius = getBorderRadius(BorderRadiusLocation.TOP_START);
            float borderRadius2 = getBorderRadius(BorderRadiusLocation.TOP_END);
            float borderRadius3 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
            float borderRadius4 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!ImageOriginUtils.isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo = borderRadius;
                }
                if (!ImageOriginUtils.isUndefined(borderRadius2)) {
                    borderRadiusOrDefaultTo2 = borderRadius2;
                }
                if (!ImageOriginUtils.isUndefined(borderRadius3)) {
                    borderRadiusOrDefaultTo3 = borderRadius3;
                }
                if (!ImageOriginUtils.isUndefined(borderRadius4)) {
                    borderRadiusOrDefaultTo4 = borderRadius4;
                }
                f3 = z ? borderRadiusOrDefaultTo2 : borderRadiusOrDefaultTo;
                if (!z) {
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                }
                f2 = z ? borderRadiusOrDefaultTo4 : borderRadiusOrDefaultTo3;
                if (z) {
                    borderRadiusOrDefaultTo4 = borderRadiusOrDefaultTo3;
                }
            } else {
                float f6 = z ? borderRadius2 : borderRadius;
                if (!z) {
                    borderRadius = borderRadius2;
                }
                float f7 = z ? borderRadius4 : borderRadius3;
                if (!z) {
                    borderRadius3 = borderRadius4;
                }
                if (!ImageOriginUtils.isUndefined(f6)) {
                    borderRadiusOrDefaultTo = f6;
                }
                if (!ImageOriginUtils.isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo2 = borderRadius;
                }
                if (!ImageOriginUtils.isUndefined(f7)) {
                    borderRadiusOrDefaultTo3 = f7;
                }
                if (!ImageOriginUtils.isUndefined(borderRadius3)) {
                    f3 = borderRadiusOrDefaultTo;
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                    f2 = borderRadiusOrDefaultTo3;
                    borderRadiusOrDefaultTo4 = borderRadius3;
                } else {
                    f3 = borderRadiusOrDefaultTo;
                    borderRadiusOrDefaultTo = borderRadiusOrDefaultTo2;
                    f2 = borderRadiusOrDefaultTo3;
                }
            }
            float max = Math.max(f3 - directionAwareBorderInsets.left, 0.0f);
            float max2 = Math.max(f3 - directionAwareBorderInsets.top, 0.0f);
            float max3 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.right, 0.0f);
            float max4 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f);
            float max5 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.right, 0.0f);
            float max6 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.bottom, 0.0f);
            float max7 = Math.max(f2 - directionAwareBorderInsets.left, 0.0f);
            float max8 = Math.max(f2 - directionAwareBorderInsets.bottom, 0.0f);
            RectF rectF3 = directionAwareBorderInsets;
            float f8 = f2;
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{f3, f3, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo4, borderRadiusOrDefaultTo4, f8, f8}, Direction.CW);
            Spacing spacing = this.mBorderWidth;
            if (spacing != null) {
                i = 8;
                f4 = spacing.get(8) / 2.0f;
            } else {
                i = 8;
                f4 = 0.0f;
            }
            Path path = this.mPathForBorderRadiusOutline;
            RectF rectF4 = this.mTempRectForBorderRadiusOutline;
            float f9 = max6;
            float[] fArr = new float[i];
            float f10 = f3 + f4;
            fArr[0] = f10;
            fArr[1] = f10;
            float f11 = borderRadiusOrDefaultTo + f4;
            fArr[2] = f11;
            fArr[3] = f11;
            float f12 = borderRadiusOrDefaultTo4 + f4;
            fArr[4] = f12;
            fArr[5] = f12;
            float f13 = f8 + f4;
            fArr[6] = f13;
            fArr[7] = f13;
            path.addRoundRect(rectF4, fArr, Direction.CW);
            Path path2 = this.mCenterDrawPath;
            RectF rectF5 = this.mTempRectForCenterDrawPath;
            float[] fArr2 = new float[8];
            RectF rectF6 = rectF3;
            float f14 = rectF6.left;
            float f15 = max5;
            fArr2[0] = Math.max(f3 - (f14 * 0.5f), f14 > 0.0f ? f3 / f14 : 0.0f);
            float f16 = rectF6.top;
            fArr2[1] = Math.max(f3 - (f16 * 0.5f), f16 > 0.0f ? f3 / f16 : 0.0f);
            float f17 = rectF6.right;
            fArr2[2] = Math.max(borderRadiusOrDefaultTo - (f17 * 0.5f), f17 > 0.0f ? borderRadiusOrDefaultTo / f17 : 0.0f);
            float f18 = rectF6.top;
            fArr2[3] = Math.max(borderRadiusOrDefaultTo - (f18 * 0.5f), f18 > 0.0f ? borderRadiusOrDefaultTo / f18 : 0.0f);
            float f19 = rectF6.right;
            fArr2[4] = Math.max(borderRadiusOrDefaultTo4 - (f19 * 0.5f), f19 > 0.0f ? borderRadiusOrDefaultTo4 / f19 : 0.0f);
            float f20 = rectF6.bottom;
            fArr2[5] = Math.max(borderRadiusOrDefaultTo4 - (f20 * 0.5f), f20 > 0.0f ? borderRadiusOrDefaultTo4 / f20 : 0.0f);
            float f21 = rectF6.left;
            fArr2[6] = Math.max(f8 - (f21 * 0.5f), f21 > 0.0f ? f8 / f21 : 0.0f);
            float f22 = rectF6.bottom;
            fArr2[7] = Math.max(f8 - (f22 * 0.5f), f22 > 0.0f ? f8 / f22 : 0.0f);
            path2.addRoundRect(rectF5, fArr2, Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            PointF pointF = this.mInnerTopLeftCorner;
            PointF pointF2 = pointF;
            RectF rectF7 = this.mInnerClipTempRectForBorderRadius;
            float f23 = rectF7.left;
            pointF.x = f23;
            float f24 = rectF7.top;
            pointF.y = f24;
            double d2 = (double) f23;
            double d3 = d2;
            double d4 = d2;
            double d5 = (double) f24;
            RectF rectF8 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(d3, d5, (double) ((max * 2.0f) + f23), (double) ((max2 * 2.0f) + f24), (double) rectF8.left, (double) rectF8.top, d4, d5, pointF2);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            PointF pointF3 = this.mInnerBottomLeftCorner;
            PointF pointF4 = pointF3;
            RectF rectF9 = this.mInnerClipTempRectForBorderRadius;
            float f25 = rectF9.left;
            pointF3.x = f25;
            float f26 = rectF9.bottom;
            pointF3.y = f26;
            double d6 = (double) f25;
            double d7 = (double) f26;
            double d8 = d7;
            double d9 = d7;
            RectF rectF10 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(d6, (double) (f26 - (max8 * 2.0f)), (double) ((max7 * 2.0f) + f25), d9, (double) rectF10.left, (double) rectF10.bottom, d6, d8, pointF4);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            PointF pointF5 = this.mInnerTopRightCorner;
            PointF pointF6 = pointF5;
            RectF rectF11 = this.mInnerClipTempRectForBorderRadius;
            float f27 = rectF11.right;
            pointF5.x = f27;
            float f28 = rectF11.top;
            pointF5.y = f28;
            double d10 = (double) f28;
            double d11 = (double) f27;
            RectF rectF12 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine((double) (f27 - (max3 * 2.0f)), d10, d11, (double) ((max4 * 2.0f) + f28), (double) rectF12.right, (double) rectF12.top, d11, d10, pointF6);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            PointF pointF7 = this.mInnerBottomRightCorner;
            PointF pointF8 = pointF7;
            RectF rectF13 = this.mInnerClipTempRectForBorderRadius;
            float f29 = rectF13.right;
            pointF7.x = f29;
            float f30 = rectF13.bottom;
            pointF7.y = f30;
            double d12 = (double) f29;
            double d13 = (double) f30;
            RectF rectF14 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine((double) (f29 - (f15 * 2.0f)), (double) (f30 - (f9 * 2.0f)), d12, d13, (double) rectF14.right, (double) rectF14.bottom, d12, d13, pointF8);
        }
    }
}
