package com.google.android.material.floatingactionbutton;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButton.ShadowDelegateImpl;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

public class FloatingActionButtonImpl {
    public static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final int[] ENABLED_STATE_SET = {16842910};
    public static final int[] FOCUSED_ENABLED_STATE_SET = {16842908, 16842910};
    public static final int[] HOVERED_ENABLED_STATE_SET = {16843623, 16842910};
    public static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {16843623, 16842908, 16842910};
    public static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    public int animState = 0;
    public BorderDrawable borderDrawable;
    public Drawable contentBackground;
    public Animator currentAnimator;
    public MotionSpec defaultHideMotionSpec;
    public MotionSpec defaultShowMotionSpec;
    public float elevation;
    public boolean ensureMinTouchTargetSize;
    public ArrayList<AnimatorListener> hideListeners;
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public float imageMatrixScale = 1.0f;
    public int maxImageSize;
    public int minTouchTargetSize;
    public OnPreDrawListener preDrawListener;
    public float pressedTranslationZ;
    public Drawable rippleDrawable;
    public float rotation;
    public boolean shadowPaddingEnabled = true;
    public final ShadowViewDelegate shadowViewDelegate;
    public ShapeAppearanceModel shapeAppearance;
    public MaterialShapeDrawable shapeDrawable;
    public ArrayList<AnimatorListener> showListeners;
    public MotionSpec showMotionSpec;
    public final StateListAnimator stateListAnimator;
    public final Matrix tmpMatrix = new Matrix();
    public final Rect tmpRect = new Rect();
    public final RectF tmpRectF1 = new RectF();
    public final RectF tmpRectF2 = new RectF();
    public ArrayList<InternalTransformationCallback> transformationCallbacks;
    public final FloatingActionButton view;

    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        public DisabledElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super(null);
        }

        public float getTargetShadowSize() {
            return 0.0f;
        }
    }

    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        public ElevateToHoveredFocusedTranslationZAnimation() {
            super(null);
        }

        public float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.hoveredFocusedTranslationZ;
        }
    }

    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        public ElevateToPressedTranslationZAnimation() {
            super(null);
        }

        public float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.pressedTranslationZ;
        }
    }

    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    public interface InternalVisibilityChangedListener {
    }

    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        public ResetElevationAnimation() {
            super(null);
        }

        public float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation;
        }
    }

    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements AnimatorUpdateListener {
        public float shadowSizeEnd;
        public float shadowSizeStart;
        public boolean validValues;

        public ShadowAnimatorImpl(AnonymousClass1 r2) {
        }

        public abstract float getTargetShadowSize();

        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.updateShapeElevation((float) ((int) this.shadowSizeEnd));
            this.validValues = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2;
            if (!this.validValues) {
                MaterialShapeDrawable materialShapeDrawable = FloatingActionButtonImpl.this.shapeDrawable;
                if (materialShapeDrawable == null) {
                    f2 = 0.0f;
                } else {
                    f2 = materialShapeDrawable.drawableState.elevation;
                }
                this.shadowSizeStart = f2;
                this.shadowSizeEnd = getTargetShadowSize();
                this.validValues = true;
            }
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            float f3 = this.shadowSizeStart;
            floatingActionButtonImpl.updateShapeElevation((float) ((int) ((valueAnimator.getAnimatedFraction() * (this.shadowSizeEnd - f3)) + f3)));
        }
    }

    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate2) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate2;
        StateListAnimator stateListAnimator2 = new StateListAnimator();
        this.stateListAnimator = stateListAnimator2;
        stateListAnimator2.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
        this.stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation()));
        this.stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = this.view.getRotation();
    }

    public final void calculateImageMatrixFromScale(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.view.getDrawable();
        if (drawable != null && this.maxImageSize != 0) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i = this.maxImageSize;
            rectF2.set(0.0f, 0.0f, (float) i, (float) i);
            matrix.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
            int i2 = this.maxImageSize;
            matrix.postScale(f2, f2, ((float) i2) / 2.0f, ((float) i2) / 2.0f);
        }
    }

    public final AnimatorSet createAnimator(MotionSpec motionSpec, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{f2});
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{f3});
        motionSpec.getTiming("scale").apply(ofFloat2);
        if (VERSION.SDK_INT == 26) {
            ofFloat2.setEvaluator(new TypeEvaluator<Float>(this) {
                public FloatEvaluator floatEvaluator = new FloatEvaluator();

                public Object evaluate(float f2, Object obj, Object obj2) {
                    float floatValue = this.floatEvaluator.evaluate(f2, (Float) obj, (Float) obj2).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
            });
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{f3});
        motionSpec.getTiming("scale").apply(ofFloat3);
        if (VERSION.SDK_INT == 26) {
            ofFloat3.setEvaluator(new TypeEvaluator<Float>(this) {
                public FloatEvaluator floatEvaluator = new FloatEvaluator();

                public Object evaluate(float f2, Object obj, Object obj2) {
                    float floatValue = this.floatEvaluator.evaluate(f2, (Float) obj, (Float) obj2).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
            });
        }
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f4, this.tmpMatrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator() {
            public Object evaluate(float f2, Object obj, Object obj2) {
                FloatingActionButtonImpl.this.imageMatrixScale = f2;
                ((Matrix) obj).getValues(this.tempStartValues);
                ((Matrix) obj2).getValues(this.tempEndValues);
                for (int i = 0; i < 9; i++) {
                    float[] fArr = this.tempEndValues;
                    float f3 = fArr[i];
                    float[] fArr2 = this.tempStartValues;
                    fArr[i] = ((f3 - fArr2[i]) * f2) + fArr2[i];
                }
                this.tempMatrix.setValues(this.tempEndValues);
                return this.tempMatrix;
            }
        }, new Matrix[]{new Matrix(this.tmpMatrix)});
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        ImageOriginUtils.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final ValueAnimator createElevationAnimator(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    public abstract float getElevation();

    public void getPadding(Rect rect) {
        int sizeDimension = this.ensureMinTouchTargetSize ? (this.minTouchTargetSize - this.view.getSizeDimension()) / 2 : 0;
        float elevation2 = this.shadowPaddingEnabled ? getElevation() + this.pressedTranslationZ : 0.0f;
        int max = Math.max(sizeDimension, (int) Math.ceil((double) elevation2));
        int max2 = Math.max(sizeDimension, (int) Math.ceil((double) (elevation2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public abstract void initializeBackgroundDrawable(ColorStateList colorStateList, Mode mode, ColorStateList colorStateList2, int i);

    public boolean isOrWillBeHidden() {
        boolean z = false;
        if (this.view.getVisibility() == 0) {
            if (this.animState == 1) {
                z = true;
            }
            return z;
        }
        if (this.animState != 2) {
            z = true;
        }
        return z;
    }

    public boolean isOrWillBeShown() {
        boolean z = false;
        if (this.view.getVisibility() != 0) {
            if (this.animState == 2) {
                z = true;
            }
            return z;
        }
        if (this.animState != 1) {
            z = true;
        }
        return z;
    }

    public abstract void jumpDrawableToCurrentState();

    public abstract void onCompatShadowChanged();

    public abstract void onDrawableStateChanged(int[] iArr);

    public abstract void onElevationsChanged(float f2, float f3, float f4);

    public void onScaleChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    public void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTranslationChanged();
            }
        }
    }

    public abstract boolean requirePreDrawListener();

    public final void setImageMatrixScale(float f2) {
        this.imageMatrixScale = f2;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f2, matrix);
        this.view.setImageMatrix(matrix);
    }

    public abstract void setRippleColor(ColorStateList colorStateList);

    public final void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearance = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.drawableState.shapeAppearanceModel = shapeAppearanceModel;
            materialShapeDrawable.invalidateSelf();
        }
        Drawable drawable = this.rippleDrawable;
        if (drawable instanceof Shapeable) {
            ((Shapeable) drawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable2 = this.borderDrawable;
        if (borderDrawable2 != null) {
            borderDrawable2.shapeAppearanceModel = shapeAppearanceModel;
            borderDrawable2.invalidateSelf();
        }
    }

    public abstract boolean shouldAddPadding();

    public final boolean shouldAnimateVisibilityChange() {
        return ViewCompat.isLaidOut(this.view) && !this.view.isInEditMode();
    }

    public final boolean shouldExpandBoundsForA11y() {
        return !this.ensureMinTouchTargetSize || this.view.getSizeDimension() >= this.minTouchTargetSize;
    }

    public abstract void updateFromViewRotation();

    public final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        b.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (shouldAddPadding()) {
            InsetDrawable insetDrawable = new InsetDrawable(this.contentBackground, rect.left, rect.top, rect.right, rect.bottom);
            ShadowDelegateImpl shadowDelegateImpl = (ShadowDelegateImpl) this.shadowViewDelegate;
            if (shadowDelegateImpl != null) {
                FloatingActionButtonImpl.super.setBackgroundDrawable(insetDrawable);
            } else {
                throw null;
            }
        } else {
            ShadowViewDelegate shadowViewDelegate2 = this.shadowViewDelegate;
            Drawable drawable = this.contentBackground;
            ShadowDelegateImpl shadowDelegateImpl2 = (ShadowDelegateImpl) shadowViewDelegate2;
            if (shadowDelegateImpl2 == null) {
                throw null;
            } else if (drawable != null) {
                FloatingActionButtonImpl.super.setBackgroundDrawable(drawable);
            }
        }
        ShadowViewDelegate shadowViewDelegate3 = this.shadowViewDelegate;
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        ShadowDelegateImpl shadowDelegateImpl3 = (ShadowDelegateImpl) shadowViewDelegate3;
        FloatingActionButton.this.shadowPadding.set(i, i2, i3, i4);
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        int i5 = floatingActionButton.imagePadding;
        floatingActionButton.setPadding(i + i5, i2 + i5, i3 + i5, i4 + i5);
    }

    public void updateShapeElevation(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.elevation != f2) {
                materialShapeDrawableState.elevation = f2;
                materialShapeDrawable.updateZ();
            }
        }
    }
}
