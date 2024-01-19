package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior;
import com.swmansion.rnscreens.ScreenStackHeaderSubview.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u000278B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010#\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\u0006\u0010.\u001a\u00020\u0013J\u000e\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\fJ\u000e\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\tJ\b\u00105\u001a\u00020\tH\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00069"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment;", "Lcom/swmansion/rnscreens/ScreenFragment;", "screenView", "Lcom/swmansion/rnscreens/Screen;", "(Lcom/swmansion/rnscreens/Screen;)V", "()V", "mAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "mIsTranslucent", "", "mShadowHidden", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "onSearchViewCreate", "Lkotlin/Function1;", "Lcom/swmansion/rnscreens/CustomSearchView;", "Lkotlin/ParameterName;", "name", "searchView", "", "getOnSearchViewCreate", "()Lkotlin/jvm/functions/Function1;", "setOnSearchViewCreate", "(Lkotlin/jvm/functions/Function1;)V", "getSearchView", "()Lcom/swmansion/rnscreens/CustomSearchView;", "setSearchView", "(Lcom/swmansion/rnscreens/CustomSearchView;)V", "canNavigateBack", "dismiss", "notifyViewAppearTransitionEnd", "onContainerUpdate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrepareOptionsMenu", "onViewAnimationEnd", "removeToolbar", "setToolbar", "toolbar", "setToolbarShadowHidden", "hidden", "setToolbarTranslucent", "translucent", "shouldShowSearchBar", "updateToolbarMenu", "ScreensAnimation", "ScreensCoordinatorLayout", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenStackFragment.kt */
public final class ScreenStackFragment extends ScreenFragment {
    public AppBarLayout mAppBarLayout;
    public boolean mIsTranslucent;
    public boolean mShadowHidden;
    public Toolbar mToolbar;
    public Function1<? super CustomSearchView, Unit> onSearchViewCreate;
    public CustomSearchView searchView;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensAnimation;", "Landroid/view/animation/Animation;", "mFragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "(Lcom/swmansion/rnscreens/ScreenFragment;)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScreenStackFragment.kt */
    public static final class ScreensAnimation extends Animation {
        public final ScreenFragment mFragment;

        public ScreensAnimation(ScreenFragment screenFragment) {
            Intrinsics.checkNotNullParameter(screenFragment, "mFragment");
            this.mFragment = screenFragment;
        }

        public void applyTransformation(float f2, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, "t");
            super.applyTransformation(f2, transformation);
            ScreenFragment screenFragment = this.mFragment;
            screenFragment.dispatchTransitionProgress(f2, !screenFragment.isResumed());
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "mFragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenFragment;)V", "mAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "clearFocus", "", "startAnimation", "animation", "Landroid/view/animation/Animation;", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScreenStackFragment.kt */
    public static final class ScreensCoordinatorLayout extends CoordinatorLayout {
        public final AnimationListener mAnimationListener = new ScreenStackFragment$ScreensCoordinatorLayout$mAnimationListener$1(this);
        public final ScreenFragment mFragment;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ScreensCoordinatorLayout(Context context, ScreenFragment screenFragment) {
            // Intrinsics.checkNotNullParameter(context, "context");
            // Intrinsics.checkNotNullParameter(screenFragment, "mFragment");
            super(context, null);
            this.mFragment = screenFragment;
        }

        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }

        public void startAnimation(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ScreensAnimation screensAnimation = new ScreensAnimation(this.mFragment);
            screensAnimation.setDuration(animation.getDuration());
            if (!(animation instanceof AnimationSet) || this.mFragment.isRemoving()) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(animation);
                animationSet.addAnimation(screensAnimation);
                animationSet.setAnimationListener(this.mAnimationListener);
                super.startAnimation(animationSet);
                return;
            }
            AnimationSet animationSet2 = (AnimationSet) animation;
            animationSet2.addAnimation(screensAnimation);
            animationSet2.setAnimationListener(this.mAnimationListener);
            super.startAnimation(animationSet2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    @SuppressLint({"ValidFragment"})
    public ScreenStackFragment(Screen screen) {
        // Intrinsics.checkNotNullParameter(screen, "screenView");
        super(screen);
    }

    public final boolean canNavigateBack() {
        ScreenContainer<?> container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
        } else if (!Intrinsics.areEqual(((ScreenStack) container).getRootScreen(), getScreen())) {
            return true;
        } else {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof ScreenStackFragment) {
                return ((ScreenStackFragment) parentFragment).canNavigateBack();
            }
            return false;
        }
    }

    public final void dismiss() {
        ScreenContainer<?> container = getScreen().getContainer();
        if (container instanceof ScreenStack) {
            ScreenStack screenStack = (ScreenStack) container;
            if (screenStack != null) {
                Intrinsics.checkNotNullParameter(this, "screenFragment");
                screenStack.mDismissed.add(this);
                screenStack.performUpdatesNow();
                return;
            }
            throw null;
        }
        throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
    }

    public void onContainerUpdate() {
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        if (headerConfig != null) {
            headerConfig.onUpdate();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        updateToolbarMenu(menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = getContext();
        AppBarLayout appBarLayout = null;
        ViewGroup screensCoordinatorLayout = context == null ? null : new ScreensCoordinatorLayout(context, this);
        Screen screen = getScreen();
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.setBehavior(this.mIsTranslucent ? null : new ScrollingViewBehavior());
        screen.setLayoutParams(layoutParams);
        if (screensCoordinatorLayout != null) {
            Screen screen2 = getScreen();
            ScreenFragment.recycleView(screen2);
            screensCoordinatorLayout.addView(screen2);
        }
        Context context2 = getContext();
        if (context2 != null) {
            AppBarLayout appBarLayout2 = new AppBarLayout(context2, null);
            appBarLayout2.setBackgroundColor(0);
            appBarLayout2.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
            appBarLayout = appBarLayout2;
        }
        this.mAppBarLayout = appBarLayout;
        if (screensCoordinatorLayout != null) {
            screensCoordinatorLayout.addView(appBarLayout);
        }
        if (this.mShadowHidden) {
            AppBarLayout appBarLayout3 = this.mAppBarLayout;
            if (appBarLayout3 != null) {
                appBarLayout3.setTargetElevation(0.0f);
            }
        }
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            AppBarLayout appBarLayout4 = this.mAppBarLayout;
            if (appBarLayout4 != null) {
                ScreenFragment.recycleView(toolbar);
                appBarLayout4.addView(toolbar);
            }
        }
        setHasOptionsMenu(true);
        return screensCoordinatorLayout;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        updateToolbarMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    public void onViewAnimationEnd() {
        dispatchViewAnimationEvent(true);
        View view = getView();
        ViewParent parent = view == null ? null : view.getParent();
        if (parent instanceof ScreenStack) {
            ScreenStack screenStack = (ScreenStack) parent;
            if (!screenStack.mRemovalTransitionStarted) {
                screenStack.dispatchOnFinishTransitioning();
            }
        }
    }

    public final void updateToolbarMenu(Menu menu) {
        int i;
        menu.clear();
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        boolean z = false;
        if (headerConfig == null) {
            i = 0;
        } else {
            i = headerConfig.getConfigSubviewsCount();
        }
        if (headerConfig != null && i > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                int i3 = i2 + 1;
                ScreenStackHeaderSubview screenStackHeaderSubview = headerConfig.mConfigSubviews.get(i2);
                Intrinsics.checkNotNullExpressionValue(screenStackHeaderSubview, "mConfigSubviews[index]");
                if (screenStackHeaderSubview.getType() == Type.SEARCH_BAR) {
                    z = true;
                    break;
                }
                i2 = i3;
            }
        }
        if (z) {
            Context context = getContext();
            if (this.searchView == null && context != null) {
                CustomSearchView customSearchView = new CustomSearchView(context, this);
                this.searchView = customSearchView;
                Function1<? super CustomSearchView, Unit> function1 = this.onSearchViewCreate;
                if (function1 != null) {
                    function1.invoke(customSearchView);
                }
            }
            MenuItem add = menu.add("");
            add.setShowAsAction(2);
            add.setActionView(this.searchView);
        }
    }

    public ScreenStackFragment() {
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }
}
