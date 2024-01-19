package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.app.NotificationCompat.WearableExtender;
import androidx.fragment.app.Fragment;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.LayoutParams;
import com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior;
import com.swmansion.rnscreens.ScreenStackHeaderSubview.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u0001kB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0006J\u0006\u0010>\u001a\u00020;J\u000e\u0010?\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0006J\b\u0010@\u001a\u00020;H\u0002J\b\u0010A\u001a\u00020;H\u0014J\b\u0010B\u001a\u00020;H\u0014J0\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006H\u0014J\u0006\u0010I\u001a\u00020;J\u0006\u0010J\u001a\u00020;J\u000e\u0010K\u001a\u00020;2\u0006\u0010=\u001a\u00020\u0006J\u001a\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020\u00182\b\u0010N\u001a\u0004\u0018\u00010OH\u0002J\u000e\u0010P\u001a\u00020;2\u0006\u0010Q\u001a\u00020\fJ\u0015\u0010R\u001a\u00020;2\b\u0010S\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010TJ\u0010\u0010U\u001a\u00020;2\b\u0010V\u001a\u0004\u0018\u00010\u0018J\u000e\u0010W\u001a\u00020;2\u0006\u0010X\u001a\u00020\fJ\u000e\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020\fJ\u000e\u0010[\u001a\u00020;2\u0006\u0010\\\u001a\u00020\fJ\u000e\u0010]\u001a\u00020;2\u0006\u0010S\u001a\u00020\u0006J\u0010\u0010^\u001a\u00020;2\b\u0010_\u001a\u0004\u0018\u00010\u0018J\u000e\u0010`\u001a\u00020;2\u0006\u0010S\u001a\u00020\u0006J\u0010\u0010a\u001a\u00020;2\b\u0010b\u001a\u0004\u0018\u00010\u0018J\u000e\u0010c\u001a\u00020;2\u0006\u0010d\u001a\u00020$J\u0010\u0010e\u001a\u00020;2\b\u0010f\u001a\u0004\u0018\u00010\u0018J\u000e\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020\fJ\u000e\u0010i\u001a\u00020;2\u0006\u0010j\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u0004\u0018\u00010/8BX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00102\u001a\u0004\u0018\u0001038BX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006l"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "configSubviewsCount", "", "getConfigSubviewsCount", "()I", "headerTopInset", "Ljava/lang/Integer;", "mBackButtonInCustomView", "", "mBackClickListener", "Landroid/view/View$OnClickListener;", "mBackgroundColor", "mConfigSubviews", "Ljava/util/ArrayList;", "Lcom/swmansion/rnscreens/ScreenStackHeaderSubview;", "Lkotlin/collections/ArrayList;", "mDefaultStartInset", "mDefaultStartInsetWithNavigation", "mDestroyed", "mDirection", "", "mIsAttachedToWindow", "mIsBackButtonHidden", "mIsHidden", "mIsShadowHidden", "mIsTopInsetEnabled", "mIsTranslucent", "mTintColor", "mTitle", "mTitleColor", "mTitleFontFamily", "mTitleFontSize", "", "mTitleFontWeight", "screen", "Lcom/swmansion/rnscreens/Screen;", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "screenFragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "getScreenFragment", "()Lcom/swmansion/rnscreens/ScreenStackFragment;", "screenStack", "Lcom/swmansion/rnscreens/ScreenStack;", "getScreenStack", "()Lcom/swmansion/rnscreens/ScreenStack;", "titleTextView", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "toolbar", "Lcom/swmansion/rnscreens/CustomToolbar;", "getToolbar", "()Lcom/swmansion/rnscreens/CustomToolbar;", "addConfigSubview", "", "child", "index", "destroy", "getConfigSubview", "maybeUpdate", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onUpdate", "removeAllConfigSubviews", "removeConfigSubview", "sendEvent", "eventName", "eventContent", "Lcom/facebook/react/bridge/WritableMap;", "setBackButtonInCustomView", "backButtonInCustomView", "setBackgroundColor", "color", "(Ljava/lang/Integer;)V", "setDirection", "direction", "setHidden", "hidden", "setHideBackButton", "hideBackButton", "setHideShadow", "hideShadow", "setTintColor", "setTitle", "title", "setTitleColor", "setTitleFontFamily", "titleFontFamily", "setTitleFontSize", "titleFontSize", "setTitleFontWeight", "fontWeightString", "setTopInsetEnabled", "topInsetEnabled", "setTranslucent", "translucent", "DebugMenuToolbar", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenStackHeaderConfig.kt */
public final class ScreenStackHeaderConfig extends ViewGroup {
    public Integer headerTopInset;
    public boolean mBackButtonInCustomView;
    public final OnClickListener mBackClickListener = new OnClickListener() {
        public final void onClick(View view) {
            ScreenStackHeaderConfig.m103mBackClickListener$lambda1(ScreenStackHeaderConfig.this, view);
        }
    };
    public Integer mBackgroundColor;
    public final ArrayList<ScreenStackHeaderSubview> mConfigSubviews = new ArrayList<>(3);
    public final int mDefaultStartInset;
    public final int mDefaultStartInsetWithNavigation;
    public boolean mDestroyed;
    public String mDirection;
    public boolean mIsAttachedToWindow;
    public boolean mIsBackButtonHidden;
    public boolean mIsHidden;
    public boolean mIsShadowHidden;
    public boolean mIsTopInsetEnabled = true;
    public boolean mIsTranslucent;
    public int mTintColor;
    public String mTitle;
    public int mTitleColor;
    public String mTitleFontFamily;
    public float mTitleFontSize;
    public int mTitleFontWeight;
    public final CustomToolbar toolbar;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ScreenStackHeaderConfig(Context context) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context);
        setVisibility(8);
        CustomToolbar customToolbar = new CustomToolbar(context, this);
        this.toolbar = customToolbar;
        this.mDefaultStartInset = customToolbar.getContentInsetStart();
        this.mDefaultStartInsetWithNavigation = this.toolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            this.toolbar.setBackgroundColor(typedValue.data);
        }
        this.toolbar.setClipChildren(false);
    }

    private final Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    private final ScreenStack getScreenStack() {
        Screen screen = getScreen();
        ScreenContainer<?> container = screen == null ? null : screen.getContainer();
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    private final TextView getTitleTextView() {
        int childCount = this.toolbar.getChildCount();
        int i = 0;
        while (i < childCount) {
            int i2 = i + 1;
            View childAt = this.toolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (Intrinsics.areEqual(textView.getText(), this.toolbar.getTitle())) {
                    return textView;
                }
            }
            i = i2;
        }
        return null;
    }

    /* renamed from: mBackClickListener$lambda-1  reason: not valid java name */
    public static final void m103mBackClickListener$lambda1(ScreenStackHeaderConfig screenStackHeaderConfig, View view) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "this$0");
        ScreenStackFragment screenFragment = screenStackHeaderConfig.getScreenFragment();
        if (screenFragment != null) {
            ScreenStack screenStack = screenStackHeaderConfig.getScreenStack();
            if (screenStack != null && Intrinsics.areEqual(screenStack.getRootScreen(), screenFragment.getScreen())) {
                Fragment parentFragment = screenFragment.getParentFragment();
                if (parentFragment instanceof ScreenStackFragment) {
                    ScreenStackFragment screenStackFragment = (ScreenStackFragment) parentFragment;
                    if (screenStackFragment.getScreen().getNativeBackButtonDismissalEnabled()) {
                        screenStackFragment.dismiss();
                    } else {
                        screenStackFragment.dispatchHeaderBackButtonClickedEvent();
                    }
                }
            } else if (screenFragment.getScreen().getNativeBackButtonDismissalEnabled()) {
                screenFragment.dismiss();
            } else {
                screenFragment.dispatchHeaderBackButtonClickedEvent();
            }
        }
    }

    public final int getConfigSubviewsCount() {
        return this.mConfigSubviews.size();
    }

    public final ScreenStackFragment getScreenFragment() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            ScreenFragment fragment = ((Screen) parent).getFragment();
            if (fragment instanceof ScreenStackFragment) {
                return (ScreenStackFragment) fragment;
            }
        }
        return null;
    }

    public final CustomToolbar getToolbar() {
        return this.toolbar;
    }

    public final void maybeUpdate() {
        if (getParent() != null && !this.mDestroyed) {
            onUpdate();
        }
    }

    public void onAttachedToWindow() {
        Integer num;
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        sendEvent("onAttached", null);
        if (this.headerTopInset == null) {
            if (VERSION.SDK_INT >= 23) {
                num = Integer.valueOf(getRootWindowInsets().getSystemWindowInsetTop());
            } else {
                num = Integer.valueOf((int) (((float) 25) * getResources().getDisplayMetrics().density));
            }
            this.headerTopInset = num;
        }
        onUpdate();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
        sendEvent("onDetached", null);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public final void onUpdate() {
        Behavior behavior;
        ReactContext reactContext;
        ScreenStack screenStack = getScreenStack();
        boolean z = screenStack == null || Intrinsics.areEqual(screenStack.getTopScreen(), getParent());
        if (this.mIsAttachedToWindow && z && !this.mDestroyed) {
            ScreenStackFragment screenFragment = getScreenFragment();
            AppCompatActivity appCompatActivity = (AppCompatActivity) (screenFragment == null ? null : screenFragment.getActivity());
            if (appCompatActivity != null) {
                String str = this.mDirection;
                if (str != null) {
                    if (Intrinsics.areEqual(str, "rtl")) {
                        this.toolbar.setLayoutDirection(1);
                    } else if (Intrinsics.areEqual(this.mDirection, "ltr")) {
                        this.toolbar.setLayoutDirection(0);
                    }
                }
                Screen screen = getScreen();
                if (screen != null) {
                    if (getContext() instanceof ReactContext) {
                        Context context = getContext();
                        if (context != null) {
                            reactContext = (ReactContext) context;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                        }
                    } else {
                        ScreenFragment fragment = screen.getFragment();
                        reactContext = fragment == null ? null : fragment.tryGetContext();
                    }
                    ScreenWindowTraits.trySetWindowTraits$react_native_screens_release(screen, appCompatActivity, reactContext);
                }
                if (this.mIsHidden) {
                    if (this.toolbar.getParent() != null) {
                        ScreenStackFragment screenFragment2 = getScreenFragment();
                        if (screenFragment2 != null) {
                            AppBarLayout appBarLayout = screenFragment2.mAppBarLayout;
                            if (appBarLayout != null) {
                                Toolbar toolbar2 = screenFragment2.mToolbar;
                                if (toolbar2 != null && toolbar2.getParent() == appBarLayout) {
                                    appBarLayout.removeView(toolbar2);
                                }
                            }
                            screenFragment2.mToolbar = null;
                        }
                    }
                    return;
                }
                if (this.toolbar.getParent() == null) {
                    ScreenStackFragment screenFragment3 = getScreenFragment();
                    if (screenFragment3 != null) {
                        CustomToolbar customToolbar = this.toolbar;
                        Intrinsics.checkNotNullParameter(customToolbar, "toolbar");
                        AppBarLayout appBarLayout2 = screenFragment3.mAppBarLayout;
                        if (appBarLayout2 != null) {
                            appBarLayout2.addView(customToolbar);
                        }
                        LayoutParams layoutParams = new LayoutParams(-1, -2);
                        layoutParams.scrollFlags = 0;
                        customToolbar.setLayoutParams(layoutParams);
                        screenFragment3.mToolbar = customToolbar;
                    }
                }
                if (this.mIsTopInsetEnabled) {
                    Integer num = this.headerTopInset;
                    getToolbar().setPadding(0, num == null ? 0 : num.intValue(), 0, 0);
                } else if (this.toolbar.getPaddingTop() > 0) {
                    this.toolbar.setPadding(0, 0, 0, 0);
                }
                appCompatActivity.setSupportActionBar(this.toolbar);
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    this.toolbar.setContentInsetStartWithNavigation(this.mDefaultStartInsetWithNavigation);
                    CustomToolbar customToolbar2 = this.toolbar;
                    int i = this.mDefaultStartInset;
                    customToolbar2.ensureContentInsets();
                    customToolbar2.mContentInsets.setRelative(i, i);
                    ScreenStackFragment screenFragment4 = getScreenFragment();
                    supportActionBar.setDisplayHomeAsUpEnabled((screenFragment4 != null && screenFragment4.canNavigateBack()) && !this.mIsBackButtonHidden);
                    this.toolbar.setNavigationOnClickListener(this.mBackClickListener);
                    ScreenStackFragment screenFragment5 = getScreenFragment();
                    if (screenFragment5 != null) {
                        boolean z2 = this.mIsShadowHidden;
                        if (screenFragment5.mShadowHidden != z2) {
                            AppBarLayout appBarLayout3 = screenFragment5.mAppBarLayout;
                            if (appBarLayout3 != null) {
                                appBarLayout3.setTargetElevation(z2 ? 0.0f : ImageOriginUtils.toPixelFromDIP(4.0f));
                            }
                            screenFragment5.mShadowHidden = z2;
                        }
                    }
                    ScreenStackFragment screenFragment6 = getScreenFragment();
                    if (screenFragment6 != null) {
                        boolean z3 = this.mIsTranslucent;
                        if (screenFragment6.mIsTranslucent != z3) {
                            ViewGroup.LayoutParams layoutParams2 = screenFragment6.getScreen().getLayoutParams();
                            if (layoutParams2 != null) {
                                CoordinatorLayout.LayoutParams layoutParams3 = (CoordinatorLayout.LayoutParams) layoutParams2;
                                if (z3) {
                                    behavior = null;
                                } else {
                                    behavior = new ScrollingViewBehavior();
                                }
                                layoutParams3.setBehavior(behavior);
                                screenFragment6.mIsTranslucent = z3;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                            }
                        }
                    }
                    supportActionBar.setTitle((CharSequence) this.mTitle);
                    if (TextUtils.isEmpty(this.mTitle)) {
                        this.toolbar.setContentInsetStartWithNavigation(0);
                    }
                    TextView titleTextView = getTitleTextView();
                    int i2 = this.mTitleColor;
                    if (i2 != 0) {
                        this.toolbar.setTitleTextColor(i2);
                    }
                    if (titleTextView != null) {
                        if (this.mTitleFontFamily != null || this.mTitleFontWeight > 0) {
                            titleTextView.setTypeface(ImageOriginUtils.applyStyles(null, 0, this.mTitleFontWeight, this.mTitleFontFamily, getContext().getAssets()));
                        }
                        float f2 = this.mTitleFontSize;
                        if (f2 > 0.0f) {
                            titleTextView.setTextSize(f2);
                        }
                    }
                    Integer num2 = this.mBackgroundColor;
                    if (num2 != null) {
                        getToolbar().setBackgroundColor(num2.intValue());
                    }
                    if (this.mTintColor != 0) {
                        Drawable navigationIcon = this.toolbar.getNavigationIcon();
                        if (navigationIcon != null) {
                            navigationIcon.setColorFilter(this.mTintColor, Mode.SRC_ATOP);
                        }
                    }
                    int childCount = this.toolbar.getChildCount() - 1;
                    if (childCount >= 0) {
                        while (true) {
                            int i3 = childCount - 1;
                            if (this.toolbar.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                                this.toolbar.removeViewAt(childCount);
                            }
                            if (i3 < 0) {
                                break;
                            }
                            childCount = i3;
                        }
                    }
                    int size = this.mConfigSubviews.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ScreenStackHeaderSubview screenStackHeaderSubview = this.mConfigSubviews.get(i4);
                        Intrinsics.checkNotNullExpressionValue(screenStackHeaderSubview, "mConfigSubviews[i]");
                        ScreenStackHeaderSubview screenStackHeaderSubview2 = screenStackHeaderSubview;
                        Type type = screenStackHeaderSubview2.getType();
                        if (type == Type.BACK) {
                            View childAt = screenStackHeaderSubview2.getChildAt(0);
                            ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
                            if (imageView != null) {
                                supportActionBar.setHomeAsUpIndicator(imageView.getDrawable());
                            } else {
                                throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                            }
                        } else {
                            Toolbar.LayoutParams layoutParams4 = new Toolbar.LayoutParams(-2, -1);
                            int ordinal = type.ordinal();
                            if (ordinal == 0) {
                                if (!this.mBackButtonInCustomView) {
                                    this.toolbar.setNavigationIcon((Drawable) null);
                                }
                                this.toolbar.setTitle((CharSequence) null);
                                layoutParams4.gravity = 8388611;
                            } else if (ordinal == 1) {
                                layoutParams4.width = -1;
                                layoutParams4.gravity = 1;
                                this.toolbar.setTitle((CharSequence) null);
                            } else if (ordinal == 2) {
                                layoutParams4.gravity = WearableExtender.DEFAULT_CONTENT_ICON_GRAVITY;
                            }
                            screenStackHeaderSubview2.setLayoutParams(layoutParams4);
                            this.toolbar.addView(screenStackHeaderSubview2);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
    }

    public final void sendEvent(String str, WritableMap writableMap) {
        Context context = getContext();
        if (context != null) {
            RCTEventEmitter rCTEventEmitter = (RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class);
            if (rCTEventEmitter != null) {
                rCTEventEmitter.receiveEvent(getId(), str, null);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
    }

    public final void setBackButtonInCustomView(boolean z) {
        this.mBackButtonInCustomView = z;
    }

    public final void setBackgroundColor(Integer num) {
        this.mBackgroundColor = num;
    }

    public final void setDirection(String str) {
        this.mDirection = str;
    }

    public final void setHidden(boolean z) {
        this.mIsHidden = z;
    }

    public final void setHideBackButton(boolean z) {
        this.mIsBackButtonHidden = z;
    }

    public final void setHideShadow(boolean z) {
        this.mIsShadowHidden = z;
    }

    public final void setTintColor(int i) {
        this.mTintColor = i;
    }

    public final void setTitle(String str) {
        this.mTitle = str;
    }

    public final void setTitleColor(int i) {
        this.mTitleColor = i;
    }

    public final void setTitleFontFamily(String str) {
        this.mTitleFontFamily = str;
    }

    public final void setTitleFontSize(float f2) {
        this.mTitleFontSize = f2;
    }

    public final void setTitleFontWeight(String str) {
        this.mTitleFontWeight = ImageOriginUtils.parseFontWeight(str);
    }

    public final void setTopInsetEnabled(boolean z) {
        this.mIsTopInsetEnabled = z;
    }

    public final void setTranslucent(boolean z) {
        this.mIsTranslucent = z;
    }
}
