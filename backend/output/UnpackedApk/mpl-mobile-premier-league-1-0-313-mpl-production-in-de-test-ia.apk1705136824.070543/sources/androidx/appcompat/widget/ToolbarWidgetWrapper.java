package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar.ExpandedActionViewMenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.legacy.app.ActionBarDrawerToggle;

public class ToolbarWidgetWrapper implements DecorToolbar {
    public ActionMenuPresenter mActionMenuPresenter;
    public View mCustomView;
    public int mDefaultNavigationContentDescription = 0;
    public Drawable mDefaultNavigationIcon;
    public int mDisplayOpts;
    public CharSequence mHomeDescription;
    public Drawable mIcon;
    public Drawable mLogo;
    public boolean mMenuPrepared;
    public Drawable mNavIcon;
    public int mNavigationMode = 0;
    public CharSequence mSubtitle;
    public View mTabView;
    public CharSequence mTitle;
    public boolean mTitleSet;
    public Toolbar mToolbar;
    public Callback mWindowCallback;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        int i;
        int i2 = R$string.abc_action_bar_up_description;
        this.mToolbar = toolbar;
        this.mTitle = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        this.mTitleSet = this.mTitle != null;
        this.mNavIcon = toolbar.getNavigationIcon();
        String str = null;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_logo);
            if (drawable != null) {
                this.mLogo = drawable;
                updateToolbarLogo();
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_icon);
            if (drawable2 != null) {
                this.mIcon = drawable2;
                updateToolbarLogo();
            }
            if (this.mNavIcon == null) {
                Drawable drawable3 = this.mDefaultNavigationIcon;
                if (drawable3 != null) {
                    this.mNavIcon = drawable3;
                    updateNavigationIcon();
                }
            }
            setDisplayOptions(obtainStyledAttributes.getInt(R$styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(this.mToolbar.getContext()).inflate(resourceId, this.mToolbar, false);
                View view = this.mCustomView;
                if (!(view == null || (this.mDisplayOpts & 16) == 0)) {
                    this.mToolbar.removeView(view);
                }
                this.mCustomView = inflate;
                if (!(inflate == null || (this.mDisplayOpts & 16) == 0)) {
                    this.mToolbar.addView(inflate);
                }
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                LayoutParams layoutParams = this.mToolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.mToolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                Toolbar toolbar2 = this.mToolbar;
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                toolbar2.ensureContentInsets();
                toolbar2.mContentInsets.setRelative(max, max2);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar3 = this.mToolbar;
                Context context = toolbar3.getContext();
                toolbar3.mTitleTextAppearance = resourceId2;
                TextView textView = toolbar3.mTitleTextView;
                if (textView != null) {
                    textView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar4 = this.mToolbar;
                Context context2 = toolbar4.getContext();
                toolbar4.mSubtitleTextAppearance = resourceId3;
                TextView textView2 = toolbar4.mSubtitleTextView;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.mToolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (this.mToolbar.getNavigationIcon() != null) {
                i = 15;
                this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
            } else {
                i = 11;
            }
            this.mDisplayOpts = i;
        }
        obtainStyledAttributes.mWrapped.recycle();
        if (i2 != this.mDefaultNavigationContentDescription) {
            this.mDefaultNavigationContentDescription = i2;
            if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
                int i3 = this.mDefaultNavigationContentDescription;
                this.mHomeDescription = i3 != 0 ? getContext().getString(i3) : str;
                updateHomeAccessibility();
            }
        }
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new OnClickListener() {
            public final ActionMenuItem mNavItem;

            {
                ActionMenuItem actionMenuItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), 0, ActionBarDrawerToggle.ID_HOME, 0, ToolbarWidgetWrapper.this.mTitle);
                this.mNavItem = actionMenuItem;
            }

            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Callback callback = toolbarWidgetWrapper.mWindowCallback;
                if (callback != null && toolbarWidgetWrapper.mMenuPrepared) {
                    callback.onMenuItemSelected(0, this.mNavItem);
                }
            }
        });
    }

    public boolean canShowOverflowMenu() {
        Toolbar toolbar = this.mToolbar;
        if (toolbar.getVisibility() == 0) {
            ActionMenuView actionMenuView = toolbar.mMenuView;
            if (actionMenuView != null && actionMenuView.mReserveOverflow) {
                return true;
            }
        }
        return false;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mToolbar.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mToolbar.mMenuView;
        if (actionMenuView != null) {
            ActionMenuPresenter actionMenuPresenter = actionMenuView.mPresenter;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.dismissPopupMenus();
            }
        }
    }

    public Context getContext() {
        return this.mToolbar.getContext();
    }

    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mToolbar.mExpandedMenuPresenter;
        return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mToolbar.mMenuView;
        if (actionMenuView == null) {
            return false;
        }
        ActionMenuPresenter actionMenuPresenter = actionMenuView.mPresenter;
        if (actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu()) {
            return true;
        }
        return false;
    }

    public void initIndeterminateProgress() {
    }

    public void initProgress() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOverflowMenuShowPending() {
        /*
            r4 = this;
            androidx.appcompat.widget.Toolbar r0 = r4.mToolbar
            androidx.appcompat.widget.ActionMenuView r0 = r0.mMenuView
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0022
            androidx.appcompat.widget.ActionMenuPresenter r0 = r0.mPresenter
            if (r0 == 0) goto L_0x001e
            androidx.appcompat.widget.ActionMenuPresenter$OpenOverflowRunnable r3 = r0.mPostedOpenRunnable
            if (r3 != 0) goto L_0x0019
            boolean r0 = r0.isOverflowMenuShowing()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            if (r0 == 0) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 == 0) goto L_0x0022
            r1 = 1
        L_0x0022:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ToolbarWidgetWrapper.isOverflowMenuShowPending():boolean");
    }

    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    public void setCollapsible(boolean z) {
        this.mToolbar.setCollapsible(z);
    }

    public void setDisplayOptions(int i) {
        int i2 = this.mDisplayOpts ^ i;
        this.mDisplayOpts = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    updateHomeAccessibility();
                }
                updateNavigationIcon();
            }
            if ((i2 & 3) != 0) {
                updateToolbarLogo();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.mToolbar.setTitle(this.mTitle);
                    this.mToolbar.setSubtitle(this.mSubtitle);
                } else {
                    this.mToolbar.setTitle((CharSequence) null);
                    this.mToolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0) {
                View view = this.mCustomView;
                if (view == null) {
                    return;
                }
                if ((i & 16) != 0) {
                    this.mToolbar.addView(view);
                } else {
                    this.mToolbar.removeView(view);
                }
            }
        }
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.mTabView;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.mToolbar;
            if (parent == toolbar) {
                toolbar.removeView(this.mTabView);
            }
        }
        this.mTabView = null;
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        this.mIcon = i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null;
        updateToolbarLogo();
    }

    public void setLogo(int i) {
        this.mLogo = i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null;
        updateToolbarLogo();
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.mActionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
            this.mActionMenuPresenter = actionMenuPresenter;
            actionMenuPresenter.mId = R$id.action_menu_presenter;
        }
        ActionMenuPresenter actionMenuPresenter2 = this.mActionMenuPresenter;
        actionMenuPresenter2.mCallback = callback;
        Toolbar toolbar = this.mToolbar;
        MenuBuilder menuBuilder = (MenuBuilder) menu;
        if (menuBuilder != null || toolbar.mMenuView != null) {
            toolbar.ensureMenuView();
            MenuBuilder menuBuilder2 = toolbar.mMenuView.mMenu;
            if (menuBuilder2 != menuBuilder) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(toolbar.mOuterActionMenuPresenter);
                    menuBuilder2.removeMenuPresenter(toolbar.mExpandedMenuPresenter);
                }
                if (toolbar.mExpandedMenuPresenter == null) {
                    toolbar.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter2.mExpandedActionViewsExclusive = true;
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter2, toolbar.mPopupContext);
                    menuBuilder.addMenuPresenter(toolbar.mExpandedMenuPresenter, toolbar.mPopupContext);
                } else {
                    actionMenuPresenter2.initForMenu(toolbar.mPopupContext, null);
                    ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = toolbar.mExpandedMenuPresenter;
                    MenuBuilder menuBuilder3 = expandedActionViewMenuPresenter.mMenu;
                    if (menuBuilder3 != null) {
                        MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
                        if (menuItemImpl != null) {
                            menuBuilder3.collapseItemActionView(menuItemImpl);
                        }
                    }
                    expandedActionViewMenuPresenter.mMenu = null;
                    actionMenuPresenter2.updateMenuView(true);
                    toolbar.mExpandedMenuPresenter.updateMenuView(true);
                }
                toolbar.mMenuView.setPopupTheme(toolbar.mPopupTheme);
                toolbar.mMenuView.setPresenter(actionMenuPresenter2);
                toolbar.mOuterActionMenuPresenter = actionMenuPresenter2;
            }
        }
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        Toolbar toolbar = this.mToolbar;
        toolbar.mActionMenuPresenterCallback = callback;
        toolbar.mMenuBuilderCallback = callback2;
        ActionMenuView actionMenuView = toolbar.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.mActionMenuPresenterCallback = callback;
            actionMenuView.mMenuBuilderCallback = callback2;
        }
    }

    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    public void setNavigationIcon(Drawable drawable) {
        this.mNavIcon = drawable;
        updateNavigationIcon();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setSubtitle(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setTitle(charSequence);
        }
    }

    public void setVisibility(int i) {
        this.mToolbar.setVisibility(i);
    }

    public void setWindowCallback(Callback callback) {
        this.mWindowCallback = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.mTitleSet) {
            this.mTitle = charSequence;
            if ((this.mDisplayOpts & 8) != 0) {
                this.mToolbar.setTitle(charSequence);
            }
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.mToolbar);
        animate.alpha(i == 0 ? 1.0f : 0.0f);
        animate.setDuration(j);
        AnonymousClass2 r4 = new ViewPropertyAnimatorListenerAdapter() {
            public boolean mCanceled = false;

            public void onAnimationCancel(View view) {
                this.mCanceled = true;
            }

            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    ToolbarWidgetWrapper.this.mToolbar.setVisibility(i);
                }
            }

            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
            }
        };
        View view = (View) animate.mView.get();
        if (view != null) {
            animate.setListenerInternal(view, r4);
        }
        return animate;
    }

    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    public final void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
        }
    }

    public final void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) != 0) {
            Toolbar toolbar = this.mToolbar;
            Drawable drawable = this.mNavIcon;
            if (drawable == null) {
                drawable = this.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.mToolbar.setNavigationIcon((Drawable) null);
    }

    public final void updateToolbarLogo() {
        Drawable drawable;
        int i = this.mDisplayOpts;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.mLogo;
            if (drawable == null) {
                drawable = this.mIcon;
            }
        } else {
            drawable = this.mIcon;
        }
        this.mToolbar.setLogo(drawable);
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        updateToolbarLogo();
    }
}
