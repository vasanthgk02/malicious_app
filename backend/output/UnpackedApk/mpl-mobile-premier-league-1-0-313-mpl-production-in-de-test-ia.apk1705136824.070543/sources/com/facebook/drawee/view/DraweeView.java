package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.gestures.GestureDetector.ClickListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class DraweeView<DH extends DraweeHierarchy> extends ImageView {
    public static boolean sGlobalLegacyVisibilityHandlingEnabled;
    public float mAspectRatio = 0.0f;
    public DraweeHolder<DH> mDraweeHolder;
    public boolean mInitialised = false;
    public boolean mLegacyVisibilityHandlingEnabled = false;
    public final AspectRatioMeasure$Spec mMeasureSpec = new AspectRatioMeasure$Spec();

    public DraweeView(Context context) {
        super(context);
        init(context);
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        sGlobalLegacyVisibilityHandlingEnabled = z;
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public DraweeController getController() {
        return this.mDraweeHolder.mController;
    }

    public DH getHierarchy() {
        DH dh = this.mDraweeHolder.mHierarchy;
        k.checkNotNull1(dh);
        return dh;
    }

    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.getTopLevelDrawable();
    }

    public final void init(Context context) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DraweeView#init");
            }
            if (!this.mInitialised) {
                boolean z = true;
                this.mInitialised = true;
                this.mDraweeHolder = new DraweeHolder<>(null);
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return;
                }
                setColorFilter(imageTintList.getDefaultColor());
                if (!sGlobalLegacyVisibilityHandlingEnabled || context.getApplicationInfo().targetSdkVersion < 24) {
                    z = false;
                }
                this.mLegacyVisibilityHandlingEnabled = z;
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public final void maybeOverrideVisibilityHandling() {
        if (this.mLegacyVisibilityHandlingEnabled) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                drawable.setVisible(getVisibility() == 0, false);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeOverrideVisibilityHandling();
        this.mDraweeHolder.onAttach();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeOverrideVisibilityHandling();
        this.mDraweeHolder.onDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        maybeOverrideVisibilityHandling();
        this.mDraweeHolder.onAttach();
    }

    public void onMeasure(int i, int i2) {
        AspectRatioMeasure$Spec aspectRatioMeasure$Spec = this.mMeasureSpec;
        aspectRatioMeasure$Spec.width = i;
        aspectRatioMeasure$Spec.height = i2;
        float f2 = this.mAspectRatio;
        LayoutParams layoutParams = getLayoutParams();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (f2 > 0.0f && layoutParams != null) {
            int i3 = layoutParams.height;
            boolean z = true;
            if (i3 == 0 || i3 == -2) {
                aspectRatioMeasure$Spec.height = MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (MeasureSpec.getSize(aspectRatioMeasure$Spec.width) - paddingRight)) / f2) + ((float) paddingBottom)), aspectRatioMeasure$Spec.height), 1073741824);
            } else {
                int i4 = layoutParams.width;
                if (!(i4 == 0 || i4 == -2)) {
                    z = false;
                }
                if (z) {
                    aspectRatioMeasure$Spec.width = MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (MeasureSpec.getSize(aspectRatioMeasure$Spec.height) - paddingBottom)) * f2) + ((float) paddingRight)), aspectRatioMeasure$Spec.width), 1073741824);
                }
            }
        }
        AspectRatioMeasure$Spec aspectRatioMeasure$Spec2 = this.mMeasureSpec;
        super.onMeasure(aspectRatioMeasure$Spec2.width, aspectRatioMeasure$Spec2.height);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        maybeOverrideVisibilityHandling();
        this.mDraweeHolder.onDetach();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        boolean z = false;
        if (draweeHolder.isControllerValid()) {
            AbstractDraweeController abstractDraweeController = (AbstractDraweeController) draweeHolder.mController;
            if (abstractDraweeController != null) {
                if (FLog.isLoggable(2)) {
                    FLog.v(AbstractDraweeController.TAG, (String) "controller %x %s: onTouchEvent %s", (Object) Integer.valueOf(System.identityHashCode(abstractDraweeController)), (Object) abstractDraweeController.mId, (Object) motionEvent);
                }
                GestureDetector gestureDetector = abstractDraweeController.mGestureDetector;
                if (gestureDetector != null && (gestureDetector.mIsCapturingGesture || abstractDraweeController.shouldRetryOnTap())) {
                    GestureDetector gestureDetector2 = abstractDraweeController.mGestureDetector;
                    if (gestureDetector2 != null) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            gestureDetector2.mIsCapturingGesture = true;
                            gestureDetector2.mIsClickCandidate = true;
                            gestureDetector2.mActionDownTime = motionEvent.getEventTime();
                            gestureDetector2.mActionDownX = motionEvent.getX();
                            gestureDetector2.mActionDownY = motionEvent.getY();
                        } else if (action == 1) {
                            gestureDetector2.mIsCapturingGesture = false;
                            if (Math.abs(motionEvent.getX() - gestureDetector2.mActionDownX) > gestureDetector2.mSingleTapSlopPx || Math.abs(motionEvent.getY() - gestureDetector2.mActionDownY) > gestureDetector2.mSingleTapSlopPx) {
                                gestureDetector2.mIsClickCandidate = false;
                            }
                            if (gestureDetector2.mIsClickCandidate && motionEvent.getEventTime() - gestureDetector2.mActionDownTime <= ((long) ViewConfiguration.getLongPressTimeout())) {
                                ClickListener clickListener = gestureDetector2.mClickListener;
                                if (clickListener != null) {
                                    AbstractDraweeController abstractDraweeController2 = (AbstractDraweeController) clickListener;
                                    if (FLog.isLoggable(2)) {
                                        FLog.v(AbstractDraweeController.TAG, (String) "controller %x %s: onClick", (Object) Integer.valueOf(System.identityHashCode(abstractDraweeController2)), (Object) abstractDraweeController2.mId);
                                    }
                                    if (abstractDraweeController2.shouldRetryOnTap()) {
                                        abstractDraweeController2.mRetryManager.mTapToRetryAttempts++;
                                        abstractDraweeController2.mSettableDraweeHierarchy.reset();
                                        abstractDraweeController2.submitRequest();
                                    }
                                }
                            }
                            gestureDetector2.mIsClickCandidate = false;
                        } else if (action != 2) {
                            if (action == 3) {
                                gestureDetector2.mIsCapturingGesture = false;
                                gestureDetector2.mIsClickCandidate = false;
                            }
                        } else if (Math.abs(motionEvent.getX() - gestureDetector2.mActionDownX) > gestureDetector2.mSingleTapSlopPx || Math.abs(motionEvent.getY() - gestureDetector2.mActionDownY) > gestureDetector2.mSingleTapSlopPx) {
                            gestureDetector2.mIsClickCandidate = false;
                        }
                        z = true;
                    } else {
                        throw null;
                    }
                }
            } else {
                throw null;
            }
        }
        if (z) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        maybeOverrideVisibilityHandling();
    }

    public void setAspectRatio(float f2) {
        if (f2 != this.mAspectRatio) {
            this.mAspectRatio = f2;
            requestLayout();
        }
    }

    public void setController(DraweeController draweeController) {
        this.mDraweeHolder.setController(draweeController);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public void setHierarchy(DH dh) {
        this.mDraweeHolder.setHierarchy(dh);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mDraweeHolder.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mDraweeHolder.setController(null);
        super.setImageDrawable(drawable);
    }

    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mDraweeHolder.setController(null);
        super.setImageResource(i);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mDraweeHolder.setController(null);
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mLegacyVisibilityHandlingEnabled = z;
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = k.toStringHelper(this);
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        stringHelper.addHolder("holder", draweeHolder != null ? draweeHolder.toString() : "<no holder set>");
        return stringHelper.toString();
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
