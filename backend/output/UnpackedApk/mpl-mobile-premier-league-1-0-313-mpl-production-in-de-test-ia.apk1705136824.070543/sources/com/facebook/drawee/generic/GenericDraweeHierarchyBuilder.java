package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.List;

public class GenericDraweeHierarchyBuilder {
    public static final ScalingUtils$ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils$ScaleType.CENTER_CROP;
    public static final ScalingUtils$ScaleType DEFAULT_SCALE_TYPE = ScalingUtils$ScaleType.CENTER_INSIDE;
    public ColorFilter mActualImageColorFilter;
    public PointF mActualImageFocusPoint;
    public ScalingUtils$ScaleType mActualImageScaleType;
    public Drawable mBackground;
    public float mDesiredAspectRatio = 0.0f;
    public int mFadeDuration = 300;
    public Drawable mFailureImage;
    public ScalingUtils$ScaleType mFailureImageScaleType;
    public List<Drawable> mOverlays;
    public Drawable mPlaceholderImage = null;
    public ScalingUtils$ScaleType mPlaceholderImageScaleType;
    public Drawable mPressedStateOverlay;
    public Drawable mProgressBarImage;
    public ScalingUtils$ScaleType mProgressBarImageScaleType;
    public Resources mResources;
    public Drawable mRetryImage;
    public ScalingUtils$ScaleType mRetryImageScaleType;
    public RoundingParams mRoundingParams;

    public GenericDraweeHierarchyBuilder(Resources resources) {
        this.mResources = resources;
        ScalingUtils$ScaleType scalingUtils$ScaleType = DEFAULT_SCALE_TYPE;
        this.mPlaceholderImageScaleType = scalingUtils$ScaleType;
        this.mRetryImage = null;
        this.mRetryImageScaleType = scalingUtils$ScaleType;
        this.mFailureImage = null;
        this.mFailureImageScaleType = scalingUtils$ScaleType;
        this.mProgressBarImage = null;
        this.mProgressBarImageScaleType = scalingUtils$ScaleType;
        this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.mActualImageFocusPoint = null;
        this.mActualImageColorFilter = null;
        this.mBackground = null;
        this.mOverlays = null;
        this.mPressedStateOverlay = null;
        this.mRoundingParams = null;
    }

    public GenericDraweeHierarchy build() {
        List<Drawable> list = this.mOverlays;
        if (list != null) {
            for (Drawable checkNotNull1 : list) {
                k.checkNotNull1(checkNotNull1);
            }
        }
        return new GenericDraweeHierarchy(this);
    }
}
