package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.RoundingParams.RoundingMethod;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class WrappingUtils {
    public static final Drawable sEmptyDrawable = new ColorDrawable(0);

    public static Drawable applyLeafRounding(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            RoundedBitmapDrawable roundedBitmapDrawable = new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            applyRoundingParams(roundedBitmapDrawable, roundingParams);
            return roundedBitmapDrawable;
        } else if (drawable instanceof NinePatchDrawable) {
            RoundedNinePatchDrawable roundedNinePatchDrawable = new RoundedNinePatchDrawable((NinePatchDrawable) drawable);
            applyRoundingParams(roundedNinePatchDrawable, roundingParams);
            return roundedNinePatchDrawable;
        } else if (drawable instanceof ColorDrawable) {
            RoundedColorDrawable roundedColorDrawable = new RoundedColorDrawable(((ColorDrawable) drawable).getColor());
            applyRoundingParams(roundedColorDrawable, roundingParams);
            return roundedColorDrawable;
        } else {
            FLog.w((String) "WrappingUtils", (String) "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
    }

    public static void applyRoundingParams(Rounded rounded, RoundingParams roundingParams) {
        rounded.setCircle(roundingParams.mRoundAsCircle);
        rounded.setRadii(roundingParams.mCornersRadii);
        rounded.setBorder(roundingParams.mBorderColor, roundingParams.mBorderWidth);
        rounded.setPadding(roundingParams.mPadding);
        rounded.setScaleDownInsideBorders(roundingParams.mScaleDownInsideBorders);
        rounded.setPaintFilterBitmap(roundingParams.mPaintFilterBitmap);
    }

    public static Drawable maybeApplyLeafRounding(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("WrappingUtils#maybeApplyLeafRounding");
            }
            if (!(drawable == null || roundingParams == null)) {
                if (roundingParams.mRoundingMethod == RoundingMethod.BITMAP_ONLY) {
                    if (drawable instanceof ForwardingDrawable) {
                        DrawableParent drawableParent = (ForwardingDrawable) drawable;
                        while (true) {
                            Drawable drawable2 = drawableParent.getDrawable();
                            if (drawable2 == drawableParent) {
                                break;
                            } else if (!(drawable2 instanceof DrawableParent)) {
                                break;
                            } else {
                                drawableParent = (DrawableParent) drawable2;
                            }
                        }
                        drawableParent.setDrawable(applyLeafRounding(drawableParent.setDrawable(sEmptyDrawable), roundingParams, resources));
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return drawable;
                    }
                    Drawable applyLeafRounding = applyLeafRounding(drawable, roundingParams, resources);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return applyLeafRounding;
                }
            }
            return drawable;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public static Drawable maybeWrapWithRoundedOverlayColor(Drawable drawable, RoundingParams roundingParams) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithRoundedOverlayColor");
            }
            if (!(drawable == null || roundingParams == null)) {
                if (roundingParams.mRoundingMethod == RoundingMethod.OVERLAY_COLOR) {
                    RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                    applyRoundingParams(roundedCornersDrawable, roundingParams);
                    roundedCornersDrawable.mOverlayColor = roundingParams.mOverlayColor;
                    roundedCornersDrawable.invalidateSelf();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return roundedCornersDrawable;
                }
            }
            return drawable;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public static Drawable maybeWrapWithScaleType(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType, PointF pointF) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithScaleType");
        }
        if (drawable == null || scalingUtils$ScaleType == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return drawable;
        }
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scalingUtils$ScaleType);
        if (pointF != null && !k.equal(scaleTypeDrawable.mFocusPoint, pointF)) {
            if (scaleTypeDrawable.mFocusPoint == null) {
                scaleTypeDrawable.mFocusPoint = new PointF();
            }
            scaleTypeDrawable.mFocusPoint.set(pointF);
            scaleTypeDrawable.configureBounds();
            scaleTypeDrawable.invalidateSelf();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return scaleTypeDrawable;
    }

    public static void updateOverlayColorRounding(DrawableParent drawableParent, RoundingParams roundingParams) {
        Drawable drawable = drawableParent.getDrawable();
        if (roundingParams == null || roundingParams.mRoundingMethod != RoundingMethod.OVERLAY_COLOR) {
            if (drawable instanceof RoundedCornersDrawable) {
                drawableParent.setDrawable(((RoundedCornersDrawable) drawable).setCurrent(sEmptyDrawable));
                sEmptyDrawable.setCallback(null);
            }
        } else if (drawable instanceof RoundedCornersDrawable) {
            RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable;
            applyRoundingParams(roundedCornersDrawable, roundingParams);
            roundedCornersDrawable.mOverlayColor = roundingParams.mOverlayColor;
            roundedCornersDrawable.invalidateSelf();
        } else {
            drawableParent.setDrawable(maybeWrapWithRoundedOverlayColor(drawableParent.setDrawable(sEmptyDrawable), roundingParams));
        }
    }
}
