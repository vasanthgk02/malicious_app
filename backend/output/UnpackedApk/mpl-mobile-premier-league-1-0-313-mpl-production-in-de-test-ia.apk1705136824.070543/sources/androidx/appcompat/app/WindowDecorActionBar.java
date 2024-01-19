package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar.OnMenuVisibilityListener;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WindowDecorActionBar extends ActionBar implements ActionBarVisibilityCallback {
    public static final Interpolator sHideInterpolator = new AccelerateInterpolator();
    public static final Interpolator sShowInterpolator = new DecelerateInterpolator();
    public ActionModeImpl mActionMode;
    public Activity mActivity;
    public ActionBarContainer mContainerView;
    public boolean mContentAnimations = true;
    public View mContentView;
    public Context mContext;
    public ActionBarContextView mContextView;
    public int mCurWindowVisibility = 0;
    public ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    public DecorToolbar mDecorToolbar;
    public ActionMode mDeferredDestroyActionMode;
    public Callback mDeferredModeDestroyCallback;
    public boolean mDisplayHomeAsUpSet;
    public boolean mHasEmbeddedTabs;
    public boolean mHiddenByApp;
    public boolean mHiddenBySystem;
    public final ViewPropertyAnimatorListener mHideListener = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mContentAnimations) {
                View view2 = windowDecorActionBar.mContentView;
                if (view2 != null) {
                    view2.setTranslationY(0.0f);
                    WindowDecorActionBar.this.mContainerView.setTranslationY(0.0f);
                }
            }
            WindowDecorActionBar.this.mContainerView.setVisibility(8);
            WindowDecorActionBar.this.mContainerView.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.mCurrentShowAnim = null;
            Callback callback = windowDecorActionBar2.mDeferredModeDestroyCallback;
            if (callback != null) {
                callback.onDestroyActionMode(windowDecorActionBar2.mDeferredDestroyActionMode);
                windowDecorActionBar2.mDeferredDestroyActionMode = null;
                windowDecorActionBar2.mDeferredModeDestroyCallback = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    };
    public boolean mHideOnContentScroll;
    public boolean mLastMenuVisibility;
    public ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    public boolean mNowShowing = true;
    public ActionBarOverlayLayout mOverlayLayout;
    public boolean mShowHideAnimationEnabled;
    public final ViewPropertyAnimatorListener mShowListener = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.mCurrentShowAnim = null;
            windowDecorActionBar.mContainerView.requestLayout();
        }
    };
    public boolean mShowingForMode;
    public Context mThemedContext;
    public final ViewPropertyAnimatorUpdateListener mUpdateListener = new ViewPropertyAnimatorUpdateListener() {
    };

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        public final Context mActionModeContext;
        public Callback mCallback;
        public WeakReference<View> mCustomView;
        public final MenuBuilder mMenu;

        public ActionModeImpl(Context context, Callback callback) {
            this.mActionModeContext = context;
            this.mCallback = callback;
            MenuBuilder menuBuilder = new MenuBuilder(context);
            menuBuilder.mDefaultShowAsAction = 1;
            this.mMenu = menuBuilder;
            menuBuilder.mCallback = this;
        }

        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mActionMode == this) {
                boolean z = windowDecorActionBar.mHiddenByApp;
                boolean z2 = windowDecorActionBar.mHiddenBySystem;
                boolean z3 = true;
                if (z || z2) {
                    z3 = false;
                }
                if (!z3) {
                    WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                    windowDecorActionBar2.mDeferredDestroyActionMode = this;
                    windowDecorActionBar2.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                WindowDecorActionBar.this.animateToMode(false);
                ActionBarContextView actionBarContextView = WindowDecorActionBar.this.mContextView;
                if (actionBarContextView.mClose == null) {
                    actionBarContextView.killMode();
                }
                WindowDecorActionBar.this.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
                windowDecorActionBar3.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar3.mHideOnContentScroll);
                WindowDecorActionBar.this.mActionMode = null;
            }
        }

        public View getCustomView() {
            WeakReference<View> weakReference = this.mCustomView;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        public CharSequence getTitle() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        public void invalidate() {
            if (WindowDecorActionBar.this.mActionMode == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.mCallback.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.mContextView.mTitleOptional;
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            Callback callback = this.mCallback;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.mCallback != null) {
                invalidate();
                ActionMenuPresenter actionMenuPresenter = WindowDecorActionBar.this.mContextView.mActionMenuPresenter;
                if (actionMenuPresenter != null) {
                    actionMenuPresenter.showOverflowMenu();
                }
            }
        }

        public void setCustomView(View view) {
            WindowDecorActionBar.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference<>(view);
        }

        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setTitle(charSequence);
        }

        public void setTitleOptionalHint(boolean z) {
            this.mTitleOptionalHint = z;
            WindowDecorActionBar.this.mContextView.setTitleOptional(z);
        }

        public void setSubtitle(int i) {
            WindowDecorActionBar.this.mContextView.setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }

        public void setTitle(int i) {
            WindowDecorActionBar.this.mContextView.setTitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        new ArrayList();
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (!z) {
            this.mContentView = decorView.findViewById(16908290);
        }
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z) {
            if (!this.mShowingForMode) {
                this.mShowingForMode = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                updateVisibility(false);
            }
        } else if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
        if (ViewCompat.isLaidOut(this.mContainerView)) {
            if (z) {
                viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(4, 100);
                viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(0, 200);
            } else {
                viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(0, 200);
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(8, 100);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.mAnimators.add(viewPropertyAnimatorCompat);
            View view = (View) viewPropertyAnimatorCompat.mView.get();
            long duration = view != null ? view.animate().getDuration() : 0;
            View view2 = (View) viewPropertyAnimatorCompat2.mView.get();
            if (view2 != null) {
                view2.animate().setStartDelay(duration);
            }
            viewPropertyAnimatorCompatSet.mAnimators.add(viewPropertyAnimatorCompat2);
            viewPropertyAnimatorCompatSet.start();
        } else if (z) {
            this.mDecorToolbar.setVisibility(4);
            this.mContextView.setVisibility(0);
        } else {
            this.mDecorToolbar.setVisibility(0);
            this.mContextView.setVisibility(8);
        }
    }

    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z;
            int size = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < size; i++) {
                this.mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    public final void init(View view) {
        DecorToolbar decorToolbar;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.mOverlayLayout = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R$id.action_bar);
        if (findViewById instanceof DecorToolbar) {
            decorToolbar = (DecorToolbar) findViewById;
        } else if (findViewById instanceof Toolbar) {
            decorToolbar = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Can't make a decor toolbar out of ");
            outline73.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(outline73.toString());
        }
        this.mDecorToolbar = decorToolbar;
        this.mContextView = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.mContainerView = actionBarContainer;
        DecorToolbar decorToolbar2 = this.mDecorToolbar;
        if (decorToolbar2 == null || this.mContextView == null || actionBarContainer == null) {
            throw new IllegalStateException(WindowDecorActionBar.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = decorToolbar2.getContext();
        boolean z = (this.mDecorToolbar.getDisplayOptions() & 4) != 0;
        if (z) {
            this.mDisplayHomeAsUpSet = true;
        }
        Context context = this.mContext;
        this.mDecorToolbar.setHomeButtonEnabled((context.getApplicationInfo().targetSdkVersion < 14) || z);
        setHasEmbeddedTabs(context.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (actionBarOverlayLayout2.mOverlayMode) {
                this.mHideOnContentScroll = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ViewCompat.setElevation(this.mContainerView, (float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(this.mContext.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs));
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl == null) {
            return false;
        }
        MenuBuilder menuBuilder = actionModeImpl.mMenu;
        if (menuBuilder == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        menuBuilder.setQwertyMode(z);
        return menuBuilder.performShortcut(i, keyEvent, 0);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayOptions(z ? 4 : 0, 4);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.mDecorToolbar.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions((i & i2) | ((~i2) & displayOptions));
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    public final void setHasEmbeddedTabs(boolean z) {
        this.mHasEmbeddedTabs = z;
        if (!z) {
            this.mDecorToolbar.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(null);
        } else {
            this.mContainerView.setTabContainer(null);
            this.mDecorToolbar.setEmbeddedTabView(null);
        }
        boolean z2 = true;
        boolean z3 = this.mDecorToolbar.getNavigationMode() == 2;
        this.mDecorToolbar.setCollapsible(!this.mHasEmbeddedTabs && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setIcon(int i) {
        this.mDecorToolbar.setIcon(i);
    }

    public void setShowHideAnimationEnabled(boolean z) {
        this.mShowHideAnimationEnabled = z;
        if (!z) {
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
            if (viewPropertyAnimatorCompatSet != null) {
                viewPropertyAnimatorCompatSet.cancel();
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        this.mDecorToolbar.setTitle(this.mContext.getString(i));
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    public ActionMode startActionMode(Callback callback) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.mContextView.getContext(), callback);
        actionModeImpl2.mMenu.stopDispatchingItemsChanged();
        try {
            if (!actionModeImpl2.mCallback.onCreateActionMode(actionModeImpl2, actionModeImpl2.mMenu)) {
                return null;
            }
            this.mActionMode = actionModeImpl2;
            actionModeImpl2.invalidate();
            this.mContextView.initForMode(actionModeImpl2);
            animateToMode(true);
            this.mContextView.sendAccessibilityEvent(32);
            return actionModeImpl2;
        } finally {
            actionModeImpl2.mMenu.startDispatchingItemsChanged();
        }
    }

    public final void updateVisibility(boolean z) {
        if (this.mShowingForMode || (!this.mHiddenByApp && !this.mHiddenBySystem)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
                if (viewPropertyAnimatorCompatSet != null) {
                    viewPropertyAnimatorCompatSet.cancel();
                }
                this.mContainerView.setVisibility(0);
                if (this.mCurWindowVisibility != 0 || (!this.mShowHideAnimationEnabled && !z)) {
                    this.mContainerView.setAlpha(1.0f);
                    this.mContainerView.setTranslationY(0.0f);
                    if (this.mContentAnimations) {
                        View view = this.mContentView;
                        if (view != null) {
                            view.setTranslationY(0.0f);
                        }
                    }
                    this.mShowListener.onAnimationEnd(null);
                } else {
                    this.mContainerView.setTranslationY(0.0f);
                    float f2 = (float) (-this.mContainerView.getHeight());
                    if (z) {
                        int[] iArr = {0, 0};
                        this.mContainerView.getLocationInWindow(iArr);
                        f2 -= (float) iArr[1];
                    }
                    this.mContainerView.setTranslationY(f2);
                    ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                    ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.mContainerView);
                    animate.translationY(0.0f);
                    animate.setUpdateListener(this.mUpdateListener);
                    if (!viewPropertyAnimatorCompatSet2.mIsStarted) {
                        viewPropertyAnimatorCompatSet2.mAnimators.add(animate);
                    }
                    if (this.mContentAnimations) {
                        View view2 = this.mContentView;
                        if (view2 != null) {
                            view2.setTranslationY(f2);
                            ViewPropertyAnimatorCompat animate2 = ViewCompat.animate(this.mContentView);
                            animate2.translationY(0.0f);
                            if (!viewPropertyAnimatorCompatSet2.mIsStarted) {
                                viewPropertyAnimatorCompatSet2.mAnimators.add(animate2);
                            }
                        }
                    }
                    Interpolator interpolator = sShowInterpolator;
                    if (!viewPropertyAnimatorCompatSet2.mIsStarted) {
                        viewPropertyAnimatorCompatSet2.mInterpolator = interpolator;
                    }
                    if (!viewPropertyAnimatorCompatSet2.mIsStarted) {
                        viewPropertyAnimatorCompatSet2.mDuration = 250;
                    }
                    ViewPropertyAnimatorListener viewPropertyAnimatorListener = this.mShowListener;
                    if (!viewPropertyAnimatorCompatSet2.mIsStarted) {
                        viewPropertyAnimatorCompatSet2.mListener = viewPropertyAnimatorListener;
                    }
                    this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
                    viewPropertyAnimatorCompatSet2.start();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            }
        } else if (this.mNowShowing) {
            this.mNowShowing = false;
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet3 = this.mCurrentShowAnim;
            if (viewPropertyAnimatorCompatSet3 != null) {
                viewPropertyAnimatorCompatSet3.cancel();
            }
            if (this.mCurWindowVisibility != 0 || (!this.mShowHideAnimationEnabled && !z)) {
                this.mHideListener.onAnimationEnd(null);
                return;
            }
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet4 = new ViewPropertyAnimatorCompatSet();
            float f3 = (float) (-this.mContainerView.getHeight());
            if (z) {
                int[] iArr2 = {0, 0};
                this.mContainerView.getLocationInWindow(iArr2);
                f3 -= (float) iArr2[1];
            }
            ViewPropertyAnimatorCompat animate3 = ViewCompat.animate(this.mContainerView);
            animate3.translationY(f3);
            animate3.setUpdateListener(this.mUpdateListener);
            if (!viewPropertyAnimatorCompatSet4.mIsStarted) {
                viewPropertyAnimatorCompatSet4.mAnimators.add(animate3);
            }
            if (this.mContentAnimations) {
                View view3 = this.mContentView;
                if (view3 != null) {
                    ViewPropertyAnimatorCompat animate4 = ViewCompat.animate(view3);
                    animate4.translationY(f3);
                    if (!viewPropertyAnimatorCompatSet4.mIsStarted) {
                        viewPropertyAnimatorCompatSet4.mAnimators.add(animate4);
                    }
                }
            }
            Interpolator interpolator2 = sHideInterpolator;
            if (!viewPropertyAnimatorCompatSet4.mIsStarted) {
                viewPropertyAnimatorCompatSet4.mInterpolator = interpolator2;
            }
            if (!viewPropertyAnimatorCompatSet4.mIsStarted) {
                viewPropertyAnimatorCompatSet4.mDuration = 250;
            }
            ViewPropertyAnimatorListener viewPropertyAnimatorListener2 = this.mHideListener;
            if (!viewPropertyAnimatorCompatSet4.mIsStarted) {
                viewPropertyAnimatorCompatSet4.mListener = viewPropertyAnimatorListener2;
            }
            this.mCurrentShowAnim = viewPropertyAnimatorCompatSet4;
            viewPropertyAnimatorCompatSet4.start();
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public WindowDecorActionBar(Dialog dialog) {
        new ArrayList();
        init(dialog.getWindow().getDecorView());
    }
}
