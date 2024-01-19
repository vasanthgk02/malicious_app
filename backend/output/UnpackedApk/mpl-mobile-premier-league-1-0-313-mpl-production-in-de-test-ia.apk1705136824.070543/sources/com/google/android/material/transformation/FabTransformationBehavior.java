package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$animator;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat$1;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealScrimColorProperty;
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public float dependencyOriginalTranslationX;
    public float dependencyOriginalTranslationY;
    public final int[] tmpArray = new int[2];
    public final Rect tmpRect = new Rect();
    public final RectF tmpRectF1 = new RectF();
    public final RectF tmpRectF2 = new RectF();

    public static class FabTransformationSpec {
        public Positioning positioning;
        public MotionSpec timings;
    }

    public FabTransformationBehavior() {
    }

    public final Pair<MotionTiming, MotionTiming> calculateMotionTiming(float f2, float f3, boolean z, FabTransformationSpec fabTransformationSpec) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        if (f2 != 0.0f) {
            int i = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            if (i != 0) {
                if ((!z || f3 >= 0.0f) && (z || i <= 0)) {
                    motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
                    motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
                } else {
                    motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
                    motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
                }
                return new Pair<>(motionTiming2, motionTiming);
            }
        }
        motionTiming2 = fabTransformationSpec.timings.getTiming("translationXLinear");
        motionTiming = fabTransformationSpec.timings.getTiming("translationYLinear");
        return new Pair<>(motionTiming2, motionTiming);
    }

    public final float calculateTranslationX(View view, View view2, Positioning positioning) {
        float f2;
        float f3;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        calculateWindowBounds(view2, rectF2);
        float f4 = 0.0f;
        int i = positioning.gravity & 7;
        if (i == 1) {
            f3 = rectF2.centerX();
            f2 = rectF.centerX();
        } else if (i != 3) {
            if (i == 5) {
                f3 = rectF2.right;
                f2 = rectF.right;
            }
            return f4 + positioning.xAdjustment;
        } else {
            f3 = rectF2.left;
            f2 = rectF.left;
        }
        f4 = f3 - f2;
        return f4 + positioning.xAdjustment;
    }

    public final float calculateTranslationY(View view, View view2, Positioning positioning) {
        float f2;
        float f3;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        calculateWindowBounds(view2, rectF2);
        float f4 = 0.0f;
        int i = positioning.gravity & 112;
        if (i == 16) {
            f3 = rectF2.centerY();
            f2 = rectF.centerY();
        } else if (i != 48) {
            if (i == 80) {
                f3 = rectF2.bottom;
                f2 = rectF.bottom;
            }
            return f4 + positioning.yAdjustment;
        } else {
            f3 = rectF2.top;
            f2 = rectF.top;
        }
        f4 = f3 - f2;
        return f4 + positioning.yAdjustment;
    }

    public final float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f2, float f3) {
        long j = motionTiming.delay;
        long j2 = motionTiming.duration;
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        return AnimationUtils.lerp(f2, f3, motionTiming.getInterpolator().getInterpolation(((float) (((timing.delay + timing.duration) + 17) - j)) / ((float) j2)));
    }

    public final void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.tmpArray;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    public final void createChildrenFadeAnimation(View view, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator;
        if (view instanceof ViewGroup) {
            boolean z3 = view instanceof CircularRevealWidget;
            View findViewById = view.findViewById(R$id.mtrl_child_content_container);
            if (findViewById != null) {
                viewGroup = toViewGroupOrNull(findViewById);
            } else if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
                viewGroup = toViewGroupOrNull(((ViewGroup) view).getChildAt(0));
            } else {
                viewGroup = toViewGroupOrNull(view);
            }
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        ChildrenAlphaProperty.CHILDREN_ALPHA.set(viewGroup, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
                }
                fabTransformationSpec.timings.getTiming("contentFade").apply(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    public final void createColorAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(colorForState);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{i});
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{colorForState});
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.instance);
            fabTransformationSpec.timings.getTiming("color").apply(objectAnimator);
            list.add(objectAnimator);
        }
    }

    @TargetApi(21)
    public final void createElevationAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        ObjectAnimator objectAnimator;
        float elevation = ViewCompat.getElevation(view2) - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-elevation});
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(objectAnimator);
        list.add(objectAnimator);
    }

    public final void createTranslationAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List list, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-calculateTranslationX);
                view2.setTranslationY(-calculateTranslationY);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f});
            float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, -calculateTranslationX, 0.0f);
            float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, -calculateTranslationY, 0.0f);
            Rect rect = this.tmpRect;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.tmpRectF1;
            rectF2.set(rect);
            RectF rectF3 = this.tmpRectF2;
            calculateWindowBounds(view2, rectF3);
            rectF3.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{-calculateTranslationX});
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{-calculateTranslationY});
        }
        motionTiming.apply(objectAnimator2);
        motionTiming2.apply(objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    public void onAttachedToLayoutParams(LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z, boolean z2) {
        int i;
        FabTransformationSpec fabTransformationSpec;
        ArrayList arrayList;
        ArrayList arrayList2;
        CircularRevealWidget circularRevealWidget;
        ArrayList arrayList3;
        Animator animator;
        ObjectAnimator objectAnimator;
        View view3 = view;
        final View view4 = view2;
        boolean z3 = z;
        Context context = view2.getContext();
        if (z3) {
            i = R$animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i = R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationSpec fabTransformationSpec2 = new FabTransformationSpec();
        fabTransformationSpec2.timings = MotionSpec.createFromResource(context, i);
        fabTransformationSpec2.positioning = new Positioning(17, 0.0f, 0.0f);
        if (z3) {
            this.dependencyOriginalTranslationX = view.getTranslationX();
            this.dependencyOriginalTranslationY = view.getTranslationY();
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        createElevationAnimation(view, view2, z, z2, fabTransformationSpec2, arrayList4);
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = rectF;
        createTranslationAnimation(view, view2, z, z2, fabTransformationSpec2, arrayList4, rectF);
        float width = rectF2.width();
        float height = rectF2.height();
        float calculateTranslationX = calculateTranslationX(view3, view4, fabTransformationSpec2.positioning);
        float calculateTranslationY = calculateTranslationY(view3, view4, fabTransformationSpec2.positioning);
        Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z3, fabTransformationSpec2);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z3) {
            calculateTranslationX = this.dependencyOriginalTranslationX;
        }
        fArr[0] = calculateTranslationX;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z3) {
            calculateTranslationY = this.dependencyOriginalTranslationY;
        }
        fArr2[0] = calculateTranslationY;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, property2, fArr2);
        motionTiming.apply(ofFloat);
        motionTiming2.apply(ofFloat2);
        arrayList4.add(ofFloat);
        arrayList4.add(ofFloat2);
        boolean z4 = view4 instanceof CircularRevealWidget;
        if (z4 && (view3 instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget2 = (CircularRevealWidget) view4;
            final Drawable drawable = ((ImageView) view3).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z3) {
                    if (!z2) {
                        drawable.setAlpha(InvitationReply.EXPIRED);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
                }
                objectAnimator.addUpdateListener(new AnimatorUpdateListener(this) {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view4.invalidate();
                    }
                });
                fabTransformationSpec2.timings.getTiming("iconFade").apply(objectAnimator);
                arrayList4.add(objectAnimator);
                arrayList5.add(new AnimatorListenerAdapter(this) {
                    public void onAnimationEnd(Animator animator) {
                        circularRevealWidget2.setCircularRevealOverlayDrawable(null);
                    }

                    public void onAnimationStart(Animator animator) {
                        circularRevealWidget2.setCircularRevealOverlayDrawable(drawable);
                    }
                });
            }
        }
        if (!z4) {
            fabTransformationSpec = fabTransformationSpec2;
            arrayList2 = arrayList4;
            arrayList = arrayList5;
        } else {
            final CircularRevealWidget circularRevealWidget3 = (CircularRevealWidget) view4;
            Positioning positioning = fabTransformationSpec2.positioning;
            RectF rectF3 = this.tmpRectF1;
            RectF rectF4 = this.tmpRectF2;
            calculateWindowBounds(view3, rectF3);
            rectF3.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
            calculateWindowBounds(view4, rectF4);
            rectF4.offset(-calculateTranslationX(view3, view4, positioning), 0.0f);
            float centerX = rectF3.centerX() - rectF4.left;
            Positioning positioning2 = fabTransformationSpec2.positioning;
            RectF rectF5 = this.tmpRectF1;
            RectF rectF6 = this.tmpRectF2;
            calculateWindowBounds(view3, rectF5);
            rectF5.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
            calculateWindowBounds(view4, rectF6);
            rectF6.offset(0.0f, -calculateTranslationY(view3, view4, positioning2));
            float centerY = rectF5.centerY() - rectF6.top;
            ((FloatingActionButton) view3).getContentRect(this.tmpRect);
            float width2 = ((float) this.tmpRect.width()) / 2.0f;
            MotionTiming timing = fabTransformationSpec2.timings.getTiming("expansion");
            if (z3) {
                if (!z2) {
                    circularRevealWidget3.setRevealInfo(new RevealInfo(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = circularRevealWidget3.getRevealInfo().radius;
                }
                animator = ImageOriginUtils.createCircularReveal(circularRevealWidget3, centerX, centerY, ImageOriginUtils.distanceToFurthestCorner(centerX, centerY, 0.0f, 0.0f, width, height));
                animator.addListener(new AnimatorListenerAdapter(this) {
                    public void onAnimationEnd(Animator animator) {
                        RevealInfo revealInfo = circularRevealWidget3.getRevealInfo();
                        revealInfo.radius = Float.MAX_VALUE;
                        circularRevealWidget3.setRevealInfo(revealInfo);
                    }
                });
                long j = timing.delay;
                int i2 = (int) centerX;
                int i3 = (int) centerY;
                if (j > 0) {
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view4, i2, i3, width2, width2);
                    createCircularReveal.setStartDelay(0);
                    createCircularReveal.setDuration(j);
                    arrayList4.add(createCircularReveal);
                }
                circularRevealWidget = circularRevealWidget3;
                fabTransformationSpec = fabTransformationSpec2;
                arrayList2 = arrayList4;
                arrayList3 = arrayList5;
            } else {
                float f2 = circularRevealWidget3.getRevealInfo().radius;
                Animator createCircularReveal2 = ImageOriginUtils.createCircularReveal(circularRevealWidget3, centerX, centerY, width2);
                long j2 = timing.delay;
                int i4 = (int) centerX;
                int i5 = (int) centerY;
                if (j2 > 0) {
                    Animator createCircularReveal3 = ViewAnimationUtils.createCircularReveal(view4, i4, i5, f2, f2);
                    createCircularReveal3.setStartDelay(0);
                    createCircularReveal3.setDuration(j2);
                    arrayList4.add(createCircularReveal3);
                }
                long j3 = timing.delay;
                long j4 = timing.duration;
                MotionSpec motionSpec = fabTransformationSpec2.timings;
                Animator animator2 = createCircularReveal2;
                int i6 = motionSpec.timings.mSize;
                fabTransformationSpec = fabTransformationSpec2;
                arrayList3 = arrayList5;
                long j5 = 0;
                int i7 = 0;
                while (i7 < i6) {
                    int i8 = i6;
                    MotionTiming motionTiming3 = (MotionTiming) motionSpec.timings.valueAt(i7);
                    j5 = Math.max(j5, motionTiming3.delay + motionTiming3.duration);
                    i7++;
                    i6 = i8;
                    circularRevealWidget3 = circularRevealWidget3;
                    i4 = i4;
                    arrayList4 = arrayList4;
                }
                circularRevealWidget = circularRevealWidget3;
                int i9 = i4;
                ArrayList arrayList6 = arrayList4;
                long j6 = j3 + j4;
                if (j6 < j5) {
                    Animator createCircularReveal4 = ViewAnimationUtils.createCircularReveal(view4, i9, i5, width2, width2);
                    createCircularReveal4.setStartDelay(j6);
                    createCircularReveal4.setDuration(j5 - j6);
                    arrayList2 = arrayList6;
                    arrayList2.add(createCircularReveal4);
                } else {
                    arrayList2 = arrayList6;
                }
                animator = animator2;
            }
            timing.apply(animator);
            arrayList2.add(animator);
            arrayList = arrayList3;
            arrayList.add(new CircularRevealCompat$1(circularRevealWidget));
        }
        createColorAnimation(view, view2, z, z2, fabTransformationSpec, arrayList2);
        createChildrenFadeAnimation(view2, z, z2, fabTransformationSpec, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        ImageOriginUtils.playTogether(animatorSet, arrayList2);
        final View view5 = view;
        final boolean z5 = z;
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            public void onAnimationEnd(Animator animator) {
                if (!z5) {
                    view4.setVisibility(4);
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z5) {
                    view4.setVisibility(0);
                    view5.setAlpha(0.0f);
                    view5.setVisibility(4);
                }
            }
        });
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener((AnimatorListener) arrayList.get(i10));
        }
        return animatorSet;
    }

    public final ViewGroup toViewGroupOrNull(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
