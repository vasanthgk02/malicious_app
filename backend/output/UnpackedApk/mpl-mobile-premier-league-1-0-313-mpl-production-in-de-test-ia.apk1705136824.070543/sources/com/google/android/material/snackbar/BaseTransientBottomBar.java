package com.google.android.material.snackbar;

import a.a.a.a.d.b;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int[] SNACKBAR_STYLE_ATTR = {R$attr.snackbarStyle};
    public static final Handler handler = new Handler(Looper.getMainLooper(), new Callback() {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                baseTransientBottomBar.view.setOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                });
                if (baseTransientBottomBar.view.getParent() == null) {
                    LayoutParams layoutParams = baseTransientBottomBar.view.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                        Behavior behavior = new Behavior();
                        BehaviorDelegate behaviorDelegate = behavior.delegate;
                        if (behaviorDelegate != null) {
                            behaviorDelegate.managerCallback = baseTransientBottomBar.managerCallback;
                            behavior.listener = new OnDismissListener() {
                                public void onDismiss(View view) {
                                    if (view.getParent() != null) {
                                        view.setVisibility(8);
                                    }
                                    BaseTransientBottomBar.this.dispatchDismiss(0);
                                }
                            };
                            layoutParams2.setBehavior(behavior);
                            layoutParams2.insetEdge = 80;
                        } else {
                            throw null;
                        }
                    }
                    baseTransientBottomBar.extraBottomMarginAnchorView = 0;
                    baseTransientBottomBar.updateMargins();
                    baseTransientBottomBar.view.setVisibility(4);
                    baseTransientBottomBar.targetParent.addView(baseTransientBottomBar.view);
                }
                if (ViewCompat.isLaidOut(baseTransientBottomBar.view)) {
                    baseTransientBottomBar.showViewImpl();
                } else {
                    baseTransientBottomBar.view.setOnLayoutChangeListener(new OnLayoutChangeListener() {
                    });
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
                int i2 = message.arg1;
                if (!baseTransientBottomBar2.shouldAnimate() || baseTransientBottomBar2.view.getVisibility() != 0) {
                    baseTransientBottomBar2.onViewHidden(i2);
                } else if (baseTransientBottomBar2.view.getAnimationMode() == 1) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                    ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                    ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            BaseTransientBottomBar.this.view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                    ofFloat.setDuration(75);
                    ofFloat.addListener(new AnimatorListenerAdapter(i2) {
                        public final /* synthetic */ int val$event;

                        {
                            this.val$event = r2;
                        }

                        public void onAnimationEnd(Animator animator) {
                            BaseTransientBottomBar.this.onViewHidden(this.val$event);
                        }
                    });
                    ofFloat.start();
                } else {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(new int[]{0, baseTransientBottomBar2.getTranslationYBottom()});
                    valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                    valueAnimator.setDuration(250);
                    valueAnimator.addListener(new AnimatorListenerAdapter(i2) {
                        public final /* synthetic */ int val$event;

                        {
                            this.val$event = r2;
                        }

                        public void onAnimationEnd(Animator animator) {
                            BaseTransientBottomBar.this.onViewHidden(this.val$event);
                        }

                        public void onAnimationStart(Animator animator) {
                            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) BaseTransientBottomBar.this.contentViewCallback;
                            snackbarContentLayout.messageView.setAlpha(1.0f);
                            ViewPropertyAnimator alpha = snackbarContentLayout.messageView.animate().alpha(0.0f);
                            long j = (long) RotationOptions.ROTATE_180;
                            long j2 = (long) 0;
                            alpha.setDuration(j).setStartDelay(j2).start();
                            if (snackbarContentLayout.actionView.getVisibility() == 0) {
                                snackbarContentLayout.actionView.setAlpha(1.0f);
                                snackbarContentLayout.actionView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
                            }
                        }
                    });
                    valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                        public int previousAnimatedIntValue = 0;

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            BaseTransientBottomBar.this.view.setTranslationY((float) intValue);
                            this.previousAnimatedIntValue = intValue;
                        }
                    });
                    valueAnimator.start();
                }
                return true;
            }
        }
    });
    public final AccessibilityManager accessibilityManager;
    public boolean anchorViewLayoutListenerEnabled = false;
    public final Runnable bottomMarginGestureInsetRunnable = new Runnable() {
        public void run() {
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.view != null) {
                Context context = baseTransientBottomBar.context;
                if (context != null) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
                    int i = displayMetrics.heightPixels;
                    BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                    int[] iArr = new int[2];
                    baseTransientBottomBar2.view.getLocationOnScreen(iArr);
                    int height = (i - (baseTransientBottomBar2.view.getHeight() + iArr[1])) + ((int) BaseTransientBottomBar.this.view.getTranslationY());
                    BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                    if (height < baseTransientBottomBar3.extraBottomMarginGestureInset) {
                        LayoutParams layoutParams = baseTransientBottomBar3.view.getLayoutParams();
                        if (layoutParams instanceof MarginLayoutParams) {
                            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                            int i2 = marginLayoutParams.bottomMargin;
                            BaseTransientBottomBar baseTransientBottomBar4 = BaseTransientBottomBar.this;
                            marginLayoutParams.bottomMargin = (baseTransientBottomBar4.extraBottomMarginGestureInset - height) + i2;
                            baseTransientBottomBar4.view.requestLayout();
                        }
                    }
                }
            }
        }
    };
    public final ContentViewCallback contentViewCallback;
    public final Context context;
    public int duration;
    public int extraBottomMarginAnchorView;
    public int extraBottomMarginGestureInset;
    public int extraBottomMarginWindowInset;
    public int extraLeftMarginWindowInset;
    public int extraRightMarginWindowInset;
    public SnackbarManager.Callback managerCallback = new SnackbarManager.Callback() {
        public void dismiss(int i) {
            Handler handler = BaseTransientBottomBar.handler;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        public void show() {
            Handler handler = BaseTransientBottomBar.handler;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    };
    public Rect originalMargins;
    public final ViewGroup targetParent;
    public final SnackbarBaseLayout view;

    public static class Behavior extends SwipeDismissBehavior<View> {
        public final BehaviorDelegate delegate = new BehaviorDelegate(this);

        public boolean canSwipeDismissView(View view) {
            if (this.delegate != null) {
                return view instanceof SnackbarBaseLayout;
            }
            throw null;
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            BehaviorDelegate behaviorDelegate = this.delegate;
            if (behaviorDelegate != null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        SnackbarManager.getInstance().restoreTimeoutIfPaused(behaviorDelegate.managerCallback);
                    }
                } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    SnackbarManager.getInstance().pauseTimeout(behaviorDelegate.managerCallback);
                }
                return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            }
            throw null;
        }
    }

    public static class BehaviorDelegate {
        public SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.alphaStartSwipeDistance = SwipeDismissBehavior.clamp(0.0f, 0.1f, 1.0f);
            swipeDismissBehavior.alphaEndSwipeDistance = SwipeDismissBehavior.clamp(0.0f, 0.6f, 1.0f);
            swipeDismissBehavior.swipeDirection = 0;
        }
    }

    public interface OnAttachStateChangeListener {
    }

    public interface OnLayoutChangeListener {
    }

    public static class SnackbarBaseLayout extends FrameLayout {
        public static final OnTouchListener consumeAllTouchListener = new OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        public final float actionTextColorAlpha;
        public int animationMode;
        public final float backgroundOverlayColorAlpha;
        public ColorStateList backgroundTint;
        public Mode backgroundTintMode;
        public OnAttachStateChangeListener onAttachStateChangeListener;
        public OnLayoutChangeListener onLayoutChangeListener;

        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            Drawable drawable;
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
            }
            this.animationMode = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            this.backgroundOverlayColorAlpha = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(ImageOriginUtils.getColorStateList(context2, obtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ImageOriginUtils.parseTintMode(obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), Mode.SRC_IN));
            this.actionTextColorAlpha = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                int i = R$attr.colorSurface;
                int i2 = R$attr.colorOnSurface;
                gradientDrawable.setColor(ImageOriginUtils.layer(ImageOriginUtils.getColor(this, i), ImageOriginUtils.getColor(this, i2), getBackgroundOverlayColorAlpha()));
                if (this.backgroundTint != null) {
                    drawable = b.wrap(gradientDrawable);
                    drawable.setTintList(this.backgroundTint);
                } else {
                    drawable = b.wrap(gradientDrawable);
                }
                ViewCompat.setBackground(this, drawable);
            }
        }

        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        public int getAnimationMode() {
            return this.animationMode;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener2 = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener2 != null) {
                AnonymousClass7 r0 = (AnonymousClass7) onAttachStateChangeListener2;
                if (r0 == null) {
                    throw null;
                } else if (VERSION.SDK_INT >= 29) {
                    WindowInsets rootWindowInsets = BaseTransientBottomBar.this.view.getRootWindowInsets();
                    if (rootWindowInsets != null) {
                        BaseTransientBottomBar.this.extraBottomMarginGestureInset = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                        BaseTransientBottomBar.this.updateMargins();
                    }
                }
            }
            ViewCompat.requestApplyInsets(this);
        }

        public void onDetachedFromWindow() {
            boolean z;
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener2 = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener2 != null) {
                AnonymousClass7 r0 = (AnonymousClass7) onAttachStateChangeListener2;
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                if (baseTransientBottomBar != null) {
                    SnackbarManager instance = SnackbarManager.getInstance();
                    SnackbarManager.Callback callback = baseTransientBottomBar.managerCallback;
                    synchronized (instance.lock) {
                        if (!instance.isCurrentSnackbarLocked(callback)) {
                            if (!instance.isNextSnackbarLocked(callback)) {
                                z = false;
                            }
                        }
                        z = true;
                    }
                    if (z) {
                        BaseTransientBottomBar.handler.post(new Runnable() {
                            public void run() {
                                BaseTransientBottomBar.this.onViewHidden(3);
                            }
                        });
                        return;
                    }
                    return;
                }
                throw null;
            }
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            OnLayoutChangeListener onLayoutChangeListener2 = this.onLayoutChangeListener;
            if (onLayoutChangeListener2 != null) {
                AnonymousClass8 r1 = (AnonymousClass8) onLayoutChangeListener2;
                BaseTransientBottomBar.this.view.setOnLayoutChangeListener(null);
                BaseTransientBottomBar.this.showViewImpl();
            }
        }

        public void setAnimationMode(int i) {
            this.animationMode = i;
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.backgroundTint == null)) {
                drawable = b.wrap(drawable.mutate());
                drawable.setTintList(this.backgroundTint);
                drawable.setTintMode(this.backgroundTintMode);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.backgroundTint = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = b.wrap(getBackground().mutate());
                wrap.setTintList(colorStateList);
                wrap.setTintMode(this.backgroundTintMode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setBackgroundTintMode(Mode mode) {
            this.backgroundTintMode = mode;
            if (getBackground() != null) {
                Drawable wrap = b.wrap(getBackground().mutate());
                wrap.setTintMode(mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener2) {
            this.onAttachStateChangeListener = onAttachStateChangeListener2;
        }

        public void setOnClickListener(OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener2) {
            this.onLayoutChangeListener = onLayoutChangeListener2;
        }
    }

    public BaseTransientBottomBar(Context context2, ViewGroup viewGroup, View view2, ContentViewCallback contentViewCallback2) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback2 != null) {
            this.targetParent = viewGroup;
            this.contentViewCallback = contentViewCallback2;
            this.context = context2;
            ThemeEnforcement.checkTheme(context2, ThemeEnforcement.APPCOMPAT_CHECK_ATTRS, "Theme.AppCompat");
            LayoutInflater from = LayoutInflater.from(context2);
            TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) from.inflate(resourceId != -1 ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar, this.targetParent, false);
            this.view = snackbarBaseLayout;
            if (view2 instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view2;
                float actionTextColorAlpha = snackbarBaseLayout.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.actionView.setTextColor(ImageOriginUtils.layer(ImageOriginUtils.getColor(snackbarContentLayout, R$attr.colorSurface), snackbarContentLayout.actionView.getCurrentTextColor(), actionTextColorAlpha));
                }
            }
            this.view.addView(view2);
            LayoutParams layoutParams = this.view.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            ViewCompat.setAccessibilityLiveRegion(this.view, 1);
            this.view.setImportantForAccessibility(1);
            this.view.setFitsSystemWindows(true);
            ViewCompat.setOnApplyWindowInsetsListener(this.view, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    BaseTransientBottomBar.this.extraBottomMarginWindowInset = windowInsetsCompat.getSystemWindowInsetBottom();
                    BaseTransientBottomBar.this.extraLeftMarginWindowInset = windowInsetsCompat.getSystemWindowInsetLeft();
                    BaseTransientBottomBar.this.extraRightMarginWindowInset = windowInsetsCompat.getSystemWindowInsetRight();
                    BaseTransientBottomBar.this.updateMargins();
                    return windowInsetsCompat;
                }
            });
            ViewCompat.setAccessibilityDelegate(this.view, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    accessibilityNodeInfoCompat.mInfo.addAction(1048576);
                    accessibilityNodeInfoCompat.mInfo.setDismissable(true);
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    if (i != 1048576) {
                        return super.performAccessibilityAction(view, i, bundle);
                    }
                    ((Snackbar) BaseTransientBottomBar.this).dispatchDismiss(3);
                    return true;
                }
            });
            this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    public void dispatchDismiss(int i) {
        SnackbarManager instance = SnackbarManager.getInstance();
        SnackbarManager.Callback callback = this.managerCallback;
        synchronized (instance.lock) {
            if (instance.isCurrentSnackbarLocked(callback)) {
                instance.cancelSnackbarLocked(instance.currentSnackbar, i);
            } else if (instance.isNextSnackbarLocked(callback)) {
                instance.cancelSnackbarLocked(instance.nextSnackbar, i);
            }
        }
    }

    public final int getTranslationYBottom() {
        int height = this.view.getHeight();
        LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams instanceof MarginLayoutParams ? height + ((MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public void onViewHidden(int i) {
        SnackbarManager instance = SnackbarManager.getInstance();
        SnackbarManager.Callback callback = this.managerCallback;
        synchronized (instance.lock) {
            if (instance.isCurrentSnackbarLocked(callback)) {
                instance.currentSnackbar = null;
                if (instance.nextSnackbar != null) {
                    instance.showNextSnackbarLocked();
                }
            }
        }
        ViewParent parent = this.view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.view);
        }
    }

    public void onViewShown() {
        SnackbarManager instance = SnackbarManager.getInstance();
        SnackbarManager.Callback callback = this.managerCallback;
        synchronized (instance.lock) {
            if (instance.isCurrentSnackbarLocked(callback)) {
                instance.scheduleTimeoutLocked(instance.currentSnackbar);
            }
        }
    }

    public boolean shouldAnimate() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        boolean z = true;
        if (accessibilityManager2 == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager2.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            z = false;
        }
        return z;
    }

    public final void showViewImpl() {
        if (shouldAnimate()) {
            this.view.post(new Runnable() {
                public void run() {
                    SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.view;
                    if (snackbarBaseLayout != null) {
                        if (snackbarBaseLayout.getParent() != null) {
                            BaseTransientBottomBar.this.view.setVisibility(0);
                        }
                        if (BaseTransientBottomBar.this.view.getAnimationMode() == 1) {
                            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                            if (baseTransientBottomBar != null) {
                                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                                ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                                ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        BaseTransientBottomBar.this.view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                    }
                                });
                                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
                                ofFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                                ofFloat2.addUpdateListener(new AnimatorUpdateListener() {
                                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                        BaseTransientBottomBar.this.view.setScaleX(floatValue);
                                        BaseTransientBottomBar.this.view.setScaleY(floatValue);
                                    }
                                });
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                                animatorSet.setDuration(150);
                                animatorSet.addListener(new AnimatorListenerAdapter() {
                                    public void onAnimationEnd(Animator animator) {
                                        BaseTransientBottomBar.this.onViewShown();
                                    }
                                });
                                animatorSet.start();
                            } else {
                                throw null;
                            }
                        } else {
                            BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                            int translationYBottom = baseTransientBottomBar2.getTranslationYBottom();
                            baseTransientBottomBar2.view.setTranslationY((float) translationYBottom);
                            ValueAnimator valueAnimator = new ValueAnimator();
                            valueAnimator.setIntValues(new int[]{translationYBottom, 0});
                            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                            valueAnimator.setDuration(250);
                            valueAnimator.addListener(new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    BaseTransientBottomBar.this.onViewShown();
                                }

                                public void onAnimationStart(Animator animator) {
                                    SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) BaseTransientBottomBar.this.contentViewCallback;
                                    snackbarContentLayout.messageView.setAlpha(0.0f);
                                    ViewPropertyAnimator alpha = snackbarContentLayout.messageView.animate().alpha(1.0f);
                                    long j = (long) RotationOptions.ROTATE_180;
                                    long j2 = (long) 70;
                                    alpha.setDuration(j).setStartDelay(j2).start();
                                    if (snackbarContentLayout.actionView.getVisibility() == 0) {
                                        snackbarContentLayout.actionView.setAlpha(0.0f);
                                        snackbarContentLayout.actionView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
                                    }
                                }
                            });
                            valueAnimator.addUpdateListener(new AnimatorUpdateListener(translationYBottom) {
                                public int previousAnimatedIntValue = this.val$translationYBottom;
                                public final /* synthetic */ int val$translationYBottom;

                                {
                                    this.val$translationYBottom = r2;
                                }

                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    BaseTransientBottomBar.this.view.setTranslationY((float) intValue);
                                    this.previousAnimatedIntValue = intValue;
                                }
                            });
                            valueAnimator.start();
                        }
                    }
                }
            });
            return;
        }
        if (this.view.getParent() != null) {
            this.view.setVisibility(0);
        }
        onViewShown();
    }

    public final void updateMargins() {
        LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            Rect rect = this.originalMargins;
            if (rect != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = rect.bottom + this.extraBottomMarginWindowInset;
                marginLayoutParams.leftMargin = rect.left + this.extraLeftMarginWindowInset;
                marginLayoutParams.rightMargin = rect.right + this.extraRightMarginWindowInset;
                this.view.requestLayout();
                if (VERSION.SDK_INT >= 29) {
                    boolean z = false;
                    if (this.extraBottomMarginGestureInset > 0) {
                        LayoutParams layoutParams2 = this.view.getLayoutParams();
                        if ((layoutParams2 instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams2).mBehavior instanceof SwipeDismissBehavior)) {
                            z = true;
                        }
                    }
                    if (z) {
                        this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
                        this.view.post(this.bottomMarginGestureInsetRunnable);
                    }
                }
            }
        }
    }
}
