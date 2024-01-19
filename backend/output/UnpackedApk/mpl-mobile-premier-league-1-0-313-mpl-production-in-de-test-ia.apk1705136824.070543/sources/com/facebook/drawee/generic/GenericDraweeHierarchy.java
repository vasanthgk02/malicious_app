package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;
import java.util.List;

public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    public final ForwardingDrawable mActualImageWrapper;
    public final Drawable mEmptyActualImageDrawable = new ColorDrawable(0);
    public final FadeDrawable mFadeDrawable;
    public final Resources mResources;
    public RoundingParams mRoundingParams;
    public final RootDrawable mTopLevelDrawable;

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchy()");
        }
        this.mResources = genericDraweeHierarchyBuilder.mResources;
        this.mRoundingParams = genericDraweeHierarchyBuilder.mRoundingParams;
        this.mActualImageWrapper = new ForwardingDrawable(this.mEmptyActualImageDrawable);
        List<Drawable> list = genericDraweeHierarchyBuilder.mOverlays;
        int size = (list != null ? list.size() : 1) + (genericDraweeHierarchyBuilder.mPressedStateOverlay != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[(size + 6)];
        drawableArr[0] = buildBranch(genericDraweeHierarchyBuilder.mBackground, null);
        drawableArr[1] = buildBranch(genericDraweeHierarchyBuilder.mPlaceholderImage, genericDraweeHierarchyBuilder.mPlaceholderImageScaleType);
        ForwardingDrawable forwardingDrawable = this.mActualImageWrapper;
        ScalingUtils$ScaleType scalingUtils$ScaleType = genericDraweeHierarchyBuilder.mActualImageScaleType;
        PointF pointF = genericDraweeHierarchyBuilder.mActualImageFocusPoint;
        forwardingDrawable.setColorFilter(genericDraweeHierarchyBuilder.mActualImageColorFilter);
        drawableArr[2] = WrappingUtils.maybeWrapWithScaleType(forwardingDrawable, scalingUtils$ScaleType, pointF);
        drawableArr[3] = buildBranch(genericDraweeHierarchyBuilder.mProgressBarImage, genericDraweeHierarchyBuilder.mProgressBarImageScaleType);
        drawableArr[4] = buildBranch(genericDraweeHierarchyBuilder.mRetryImage, genericDraweeHierarchyBuilder.mRetryImageScaleType);
        drawableArr[5] = buildBranch(genericDraweeHierarchyBuilder.mFailureImage, genericDraweeHierarchyBuilder.mFailureImageScaleType);
        if (size > 0) {
            List<Drawable> list2 = genericDraweeHierarchyBuilder.mOverlays;
            if (list2 != null) {
                i = 0;
                for (Drawable buildBranch : list2) {
                    drawableArr[i + 6] = buildBranch(buildBranch, null);
                    i++;
                }
            } else {
                i = 1;
            }
            Drawable drawable = genericDraweeHierarchyBuilder.mPressedStateOverlay;
            if (drawable != null) {
                drawableArr[i + 6] = buildBranch(drawable, null);
            }
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr);
        this.mFadeDrawable = fadeDrawable;
        fadeDrawable.mDurationMs = genericDraweeHierarchyBuilder.mFadeDuration;
        if (fadeDrawable.mTransitionState == 1) {
            fadeDrawable.mTransitionState = 0;
        }
        RootDrawable rootDrawable = new RootDrawable(WrappingUtils.maybeWrapWithRoundedOverlayColor(this.mFadeDrawable, this.mRoundingParams));
        this.mTopLevelDrawable = rootDrawable;
        rootDrawable.mutate();
        resetFade();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public final Drawable buildBranch(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        return WrappingUtils.maybeWrapWithScaleType(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources), scalingUtils$ScaleType, null);
    }

    public final void fadeInLayer(int i) {
        if (i >= 0) {
            FadeDrawable fadeDrawable = this.mFadeDrawable;
            fadeDrawable.mTransitionState = 0;
            fadeDrawable.mIsLayerOn[i] = true;
            fadeDrawable.invalidateSelf();
        }
    }

    public final void fadeOutBranches() {
        fadeOutLayer(1);
        fadeOutLayer(2);
        fadeOutLayer(3);
        fadeOutLayer(4);
        fadeOutLayer(5);
    }

    public final void fadeOutLayer(int i) {
        if (i >= 0) {
            FadeDrawable fadeDrawable = this.mFadeDrawable;
            fadeDrawable.mTransitionState = 0;
            fadeDrawable.mIsLayerOn[i] = false;
            fadeDrawable.invalidateSelf();
        }
    }

    public final DrawableParent getParentDrawableAtIndex(int i) {
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        if (fadeDrawable != null) {
            boolean z = false;
            k.checkArgument(i >= 0);
            if (i < fadeDrawable.mDrawableParents.length) {
                z = true;
            }
            k.checkArgument(z);
            DrawableParent[] drawableParentArr = fadeDrawable.mDrawableParents;
            if (drawableParentArr[i] == null) {
                drawableParentArr[i] = new DrawableParent(i) {
                    public final /* synthetic */ int val$index;

                    {
                        this.val$index = r2;
                    }

                    public Drawable getDrawable() {
                        return ArrayDrawable.this.getDrawable(this.val$index);
                    }

                    public Drawable setDrawable(Drawable drawable) {
                        return ArrayDrawable.this.setDrawable(this.val$index, drawable);
                    }
                };
            }
            DrawableParent drawableParent = fadeDrawable.mDrawableParents[i];
            if (drawableParent.getDrawable() instanceof MatrixDrawable) {
                drawableParent = (MatrixDrawable) drawableParent.getDrawable();
            }
            return drawableParent.getDrawable() instanceof ScaleTypeDrawable ? (ScaleTypeDrawable) drawableParent.getDrawable() : drawableParent;
        }
        throw null;
    }

    public final ScaleTypeDrawable getScaleTypeDrawableAtIndex(int i) {
        DrawableParent parentDrawableAtIndex = getParentDrawableAtIndex(i);
        if (parentDrawableAtIndex instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) parentDrawableAtIndex;
        }
        Drawable maybeWrapWithScaleType = WrappingUtils.maybeWrapWithScaleType(parentDrawableAtIndex.setDrawable(WrappingUtils.sEmptyDrawable), ScalingUtils$ScaleType.FIT_XY, null);
        parentDrawableAtIndex.setDrawable(maybeWrapWithScaleType);
        k.checkNotNull(maybeWrapWithScaleType, (Object) "Parent has no child drawable!");
        return (ScaleTypeDrawable) maybeWrapWithScaleType;
    }

    public Drawable getTopLevelDrawable() {
        return this.mTopLevelDrawable;
    }

    public void reset() {
        this.mActualImageWrapper.setCurrent(this.mEmptyActualImageDrawable);
        resetFade();
    }

    public final void resetFade() {
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        if (fadeDrawable != null) {
            fadeDrawable.beginBatchMode();
            FadeDrawable fadeDrawable2 = this.mFadeDrawable;
            fadeDrawable2.mTransitionState = 0;
            Arrays.fill(fadeDrawable2.mIsLayerOn, true);
            fadeDrawable2.invalidateSelf();
            fadeOutBranches();
            fadeInLayer(1);
            this.mFadeDrawable.finishTransitionImmediately();
            this.mFadeDrawable.endBatchMode();
        }
    }

    public final void setChildDrawableAtIndex(int i, Drawable drawable) {
        if (drawable == null) {
            this.mFadeDrawable.setDrawable(i, null);
            return;
        }
        getParentDrawableAtIndex(i).setDrawable(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources));
    }

    public void setControllerOverlay(Drawable drawable) {
        RootDrawable rootDrawable = this.mTopLevelDrawable;
        rootDrawable.mControllerOverlay = drawable;
        rootDrawable.invalidateSelf();
    }

    public void setFailure(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(5) != null) {
            fadeInLayer(5);
        } else {
            fadeInLayer(1);
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setImage(Drawable drawable, float f2, boolean z) {
        Drawable maybeApplyLeafRounding = WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources);
        maybeApplyLeafRounding.mutate();
        this.mActualImageWrapper.setCurrent(maybeApplyLeafRounding);
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        fadeInLayer(2);
        setProgress(f2);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    public final void setProgress(float f2) {
        Drawable drawable = this.mFadeDrawable.getDrawable(3);
        if (drawable != null) {
            if (f2 >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                fadeOutLayer(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                fadeInLayer(3);
            }
            drawable.setLevel(Math.round(f2 * 10000.0f));
        }
    }

    public void setRetry(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(4) != null) {
            fadeInLayer(4);
        } else {
            fadeInLayer(1);
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setProgress(float f2, boolean z) {
        if (this.mFadeDrawable.getDrawable(3) != null) {
            this.mFadeDrawable.beginBatchMode();
            setProgress(f2);
            if (z) {
                this.mFadeDrawable.finishTransitionImmediately();
            }
            this.mFadeDrawable.endBatchMode();
        }
    }
}
