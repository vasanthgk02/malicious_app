package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.android.material.shape.MaterialShapeDrawable;

public class NavigationView extends ScrimInsetsFrameLayout {
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int DEF_STYLE_RES = R$style.Widget_Design_NavigationView;
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public OnNavigationItemSelectedListener listener;
    public final int maxWidth;
    public final NavigationMenu menu;
    public MenuInflater menuInflater;
    public OnGlobalLayoutListener onGlobalLayoutListener;
    public final NavigationMenuPresenter presenter;
    public final int[] tmpLocation;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationViewStyle);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    public final ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
    }

    public MenuItem getCheckedItem() {
        return this.presenter.adapter.checkedItem;
    }

    public int getHeaderCount() {
        return this.presenter.headerLayout.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.presenter.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.presenter.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.presenter.itemIconPadding;
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.iconTintList;
    }

    public int getItemMaxLines() {
        return this.presenter.itemMaxLines;
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.textColor;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            TextAppearanceConfig.setParentAbsoluteElevation(this, (MaterialShapeDrawable) background);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            if (navigationMenuPresenter.paddingTopDefault != systemWindowInsetTop) {
                navigationMenuPresenter.paddingTopDefault = systemWindowInsetTop;
                navigationMenuPresenter.updateTopPadding();
            }
            NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
            navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
            ViewCompat.dispatchApplyWindowInsets(navigationMenuPresenter.headerLayout, windowInsetsCompat);
            return;
        }
        throw null;
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i = MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        this.menu.restorePresenterStates(savedState.menuState);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.menu.findItem(i);
        if (findItem != null) {
            this.presenter.adapter.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        TextAppearanceConfig.setElevation(this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemBackground = drawable;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemHorizontalPadding(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemHorizontalPadding = i;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemIconPadding = i;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemIconPaddingResource(int i) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconSize(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter.itemIconSize != i) {
            navigationMenuPresenter.itemIconSize = i;
            navigationMenuPresenter.hasCustomItemIconSize = true;
            navigationMenuPresenter.updateMenuView(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.iconTintList = colorStateList;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemMaxLines(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemMaxLines = i;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemTextAppearance(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.textAppearance = i;
        navigationMenuPresenter.textAppearanceSet = true;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.textColor = colorStateList;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.overScrollMode = i;
            NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r7v4, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r7v5, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r11v6, types: [android.graphics.drawable.InsetDrawable] */
    /* JADX WARNING: type inference failed for: r11v7, types: [android.graphics.drawable.InsetDrawable] */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fa, code lost:
        r6 = createDefaultColorStateList(16842806);
     */
    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v4, types: [android.graphics.drawable.Drawable]
      assigns: [android.graphics.drawable.Drawable, android.graphics.drawable.InsetDrawable]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], android.graphics.drawable.Drawable, android.graphics.drawable.InsetDrawable]
      mth insns count: 237
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationView(android.content.Context r18, android.util.AttributeSet r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r7 = r19
            r8 = r20
            int r1 = DEF_STYLE_RES
            r2 = r18
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r2, r7, r8, r1)
            r0.<init>(r1, r7, r8)
            com.google.android.material.internal.NavigationMenuPresenter r1 = new com.google.android.material.internal.NavigationMenuPresenter
            r1.<init>()
            r0.presenter = r1
            r1 = 2
            int[] r1 = new int[r1]
            r0.tmpLocation = r1
            android.content.Context r9 = r17.getContext()
            com.google.android.material.internal.NavigationMenu r1 = new com.google.android.material.internal.NavigationMenu
            r1.<init>(r9)
            r0.menu = r1
            int[] r3 = com.google.android.material.R$styleable.NavigationView
            int r5 = DEF_STYLE_RES
            r10 = 0
            int[] r6 = new int[r10]
            r1 = r9
            r2 = r19
            r4 = r20
            androidx.appcompat.widget.TintTypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R$styleable.NavigationView_android_background
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0049
            int r2 = com.google.android.material.R$styleable.NavigationView_android_background
            android.graphics.drawable.Drawable r2 = r1.getDrawable(r2)
            androidx.core.view.ViewCompat.setBackground(r0, r2)
        L_0x0049:
            android.graphics.drawable.Drawable r2 = r17.getBackground()
            if (r2 == 0) goto L_0x0057
            android.graphics.drawable.Drawable r2 = r17.getBackground()
            boolean r2 = r2 instanceof android.graphics.drawable.ColorDrawable
            if (r2 == 0) goto L_0x008a
        L_0x0057:
            int r2 = DEF_STYLE_RES
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder(r9, r7, r8, r2)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            android.graphics.drawable.Drawable r3 = r17.getBackground()
            com.google.android.material.shape.MaterialShapeDrawable r4 = new com.google.android.material.shape.MaterialShapeDrawable
            r4.<init>(r2)
            boolean r2 = r3 instanceof android.graphics.drawable.ColorDrawable
            if (r2 == 0) goto L_0x007b
            android.graphics.drawable.ColorDrawable r3 = (android.graphics.drawable.ColorDrawable) r3
            int r2 = r3.getColor()
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r4.setFillColor(r2)
        L_0x007b:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r4.drawableState
            com.google.android.material.elevation.ElevationOverlayProvider r3 = new com.google.android.material.elevation.ElevationOverlayProvider
            r3.<init>(r9)
            r2.elevationOverlayProvider = r3
            r4.updateZ()
            androidx.core.view.ViewCompat.setBackground(r0, r4)
        L_0x008a:
            int r2 = com.google.android.material.R$styleable.NavigationView_elevation
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x009c
            int r2 = com.google.android.material.R$styleable.NavigationView_elevation
            int r2 = r1.getDimensionPixelSize(r2, r10)
            float r2 = (float) r2
            r0.setElevation(r2)
        L_0x009c:
            int r2 = com.google.android.material.R$styleable.NavigationView_android_fitsSystemWindows
            boolean r2 = r1.getBoolean(r2, r10)
            r0.setFitsSystemWindows(r2)
            int r2 = com.google.android.material.R$styleable.NavigationView_android_maxWidth
            int r2 = r1.getDimensionPixelSize(r2, r10)
            r0.maxWidth = r2
            int r2 = com.google.android.material.R$styleable.NavigationView_itemIconTint
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x00bc
            int r2 = com.google.android.material.R$styleable.NavigationView_itemIconTint
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            goto L_0x00c3
        L_0x00bc:
            r2 = 16842808(0x1010038, float:2.3693715E-38)
            android.content.res.ColorStateList r2 = r0.createDefaultColorStateList(r2)
        L_0x00c3:
            int r3 = com.google.android.material.R$styleable.NavigationView_itemTextAppearance
            boolean r3 = r1.hasValue(r3)
            r4 = 1
            if (r3 == 0) goto L_0x00d4
            int r3 = com.google.android.material.R$styleable.NavigationView_itemTextAppearance
            int r3 = r1.getResourceId(r3, r10)
            r5 = 1
            goto L_0x00d6
        L_0x00d4:
            r3 = 0
            r5 = 0
        L_0x00d6:
            int r6 = com.google.android.material.R$styleable.NavigationView_itemIconSize
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x00e7
            int r6 = com.google.android.material.R$styleable.NavigationView_itemIconSize
            int r6 = r1.getDimensionPixelSize(r6, r10)
            r0.setItemIconSize(r6)
        L_0x00e7:
            r6 = 0
            int r7 = com.google.android.material.R$styleable.NavigationView_itemTextColor
            boolean r7 = r1.hasValue(r7)
            if (r7 == 0) goto L_0x00f6
            int r6 = com.google.android.material.R$styleable.NavigationView_itemTextColor
            android.content.res.ColorStateList r6 = r1.getColorStateList(r6)
        L_0x00f6:
            if (r5 != 0) goto L_0x0101
            if (r6 != 0) goto L_0x0101
            r6 = 16842806(0x1010036, float:2.369371E-38)
            android.content.res.ColorStateList r6 = r0.createDefaultColorStateList(r6)
        L_0x0101:
            int r7 = com.google.android.material.R$styleable.NavigationView_itemBackground
            android.graphics.drawable.Drawable r7 = r1.getDrawable(r7)
            if (r7 != 0) goto L_0x016d
            int r8 = com.google.android.material.R$styleable.NavigationView_itemShapeAppearance
            boolean r8 = r1.hasValue(r8)
            if (r8 != 0) goto L_0x011c
            int r8 = com.google.android.material.R$styleable.NavigationView_itemShapeAppearanceOverlay
            boolean r8 = r1.hasValue(r8)
            if (r8 == 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            r8 = 0
            goto L_0x011d
        L_0x011c:
            r8 = 1
        L_0x011d:
            if (r8 == 0) goto L_0x016d
            int r7 = com.google.android.material.R$styleable.NavigationView_itemShapeAppearance
            int r7 = r1.getResourceId(r7, r10)
            int r8 = com.google.android.material.R$styleable.NavigationView_itemShapeAppearanceOverlay
            int r8 = r1.getResourceId(r8, r10)
            com.google.android.material.shape.MaterialShapeDrawable r12 = new com.google.android.material.shape.MaterialShapeDrawable
            android.content.Context r11 = r17.getContext()
            com.google.android.material.shape.AbsoluteCornerSize r13 = new com.google.android.material.shape.AbsoluteCornerSize
            float r14 = (float) r10
            r13.<init>(r14)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r7 = com.google.android.material.shape.ShapeAppearanceModel.builder(r11, r7, r8, r13)
            com.google.android.material.shape.ShapeAppearanceModel r7 = r7.build()
            r12.<init>(r7)
            android.content.Context r7 = r17.getContext()
            int r8 = com.google.android.material.R$styleable.NavigationView_itemShapeFillColor
            android.content.res.ColorStateList r7 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r7, r1, r8)
            r12.setFillColor(r7)
            int r7 = com.google.android.material.R$styleable.NavigationView_itemShapeInsetStart
            int r13 = r1.getDimensionPixelSize(r7, r10)
            int r7 = com.google.android.material.R$styleable.NavigationView_itemShapeInsetTop
            int r14 = r1.getDimensionPixelSize(r7, r10)
            int r7 = com.google.android.material.R$styleable.NavigationView_itemShapeInsetEnd
            int r15 = r1.getDimensionPixelSize(r7, r10)
            int r7 = com.google.android.material.R$styleable.NavigationView_itemShapeInsetBottom
            int r16 = r1.getDimensionPixelSize(r7, r10)
            android.graphics.drawable.InsetDrawable r7 = new android.graphics.drawable.InsetDrawable
            r11 = r7
            r11.<init>(r12, r13, r14, r15, r16)
        L_0x016d:
            int r8 = com.google.android.material.R$styleable.NavigationView_itemHorizontalPadding
            boolean r8 = r1.hasValue(r8)
            if (r8 == 0) goto L_0x0180
            int r8 = com.google.android.material.R$styleable.NavigationView_itemHorizontalPadding
            int r8 = r1.getDimensionPixelSize(r8, r10)
            com.google.android.material.internal.NavigationMenuPresenter r11 = r0.presenter
            r11.setItemHorizontalPadding(r8)
        L_0x0180:
            int r8 = com.google.android.material.R$styleable.NavigationView_itemIconPadding
            int r8 = r1.getDimensionPixelSize(r8, r10)
            int r11 = com.google.android.material.R$styleable.NavigationView_itemMaxLines
            int r11 = r1.getInt(r11, r4)
            r0.setItemMaxLines(r11)
            com.google.android.material.internal.NavigationMenu r11 = r0.menu
            com.google.android.material.navigation.NavigationView$1 r12 = new com.google.android.material.navigation.NavigationView$1
            r12.<init>()
            r11.mCallback = r12
            com.google.android.material.internal.NavigationMenuPresenter r11 = r0.presenter
            r11.id = r4
            com.google.android.material.internal.NavigationMenu r12 = r0.menu
            r11.initForMenu(r9, r12)
            com.google.android.material.internal.NavigationMenuPresenter r9 = r0.presenter
            r9.iconTintList = r2
            r9.updateMenuView(r10)
            com.google.android.material.internal.NavigationMenuPresenter r2 = r0.presenter
            int r9 = r17.getOverScrollMode()
            r2.overScrollMode = r9
            com.google.android.material.internal.NavigationMenuView r2 = r2.menuView
            if (r2 == 0) goto L_0x01b7
            r2.setOverScrollMode(r9)
        L_0x01b7:
            if (r5 == 0) goto L_0x01c2
            com.google.android.material.internal.NavigationMenuPresenter r2 = r0.presenter
            r2.textAppearance = r3
            r2.textAppearanceSet = r4
            r2.updateMenuView(r10)
        L_0x01c2:
            com.google.android.material.internal.NavigationMenuPresenter r2 = r0.presenter
            r2.textColor = r6
            r2.updateMenuView(r10)
            com.google.android.material.internal.NavigationMenuPresenter r2 = r0.presenter
            r2.itemBackground = r7
            r2.updateMenuView(r10)
            com.google.android.material.internal.NavigationMenuPresenter r2 = r0.presenter
            r2.setItemIconPadding(r8)
            com.google.android.material.internal.NavigationMenu r2 = r0.menu
            com.google.android.material.internal.NavigationMenuPresenter r3 = r0.presenter
            android.content.Context r5 = r2.mContext
            r2.addMenuPresenter(r3, r5)
            com.google.android.material.internal.NavigationMenuPresenter r2 = r0.presenter
            com.google.android.material.internal.NavigationMenuView r3 = r2.menuView
            if (r3 != 0) goto L_0x0224
            android.view.LayoutInflater r3 = r2.layoutInflater
            int r5 = com.google.android.material.R$layout.design_navigation_menu
            android.view.View r3 = r3.inflate(r5, r0, r10)
            com.google.android.material.internal.NavigationMenuView r3 = (com.google.android.material.internal.NavigationMenuView) r3
            r2.menuView = r3
            com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuViewAccessibilityDelegate r5 = new com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuViewAccessibilityDelegate
            com.google.android.material.internal.NavigationMenuView r6 = r2.menuView
            r5.<init>(r6)
            r3.setAccessibilityDelegateCompat(r5)
            com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuAdapter r3 = r2.adapter
            if (r3 != 0) goto L_0x0205
            com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuAdapter r3 = new com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuAdapter
            r3.<init>()
            r2.adapter = r3
        L_0x0205:
            int r3 = r2.overScrollMode
            r5 = -1
            if (r3 == r5) goto L_0x020f
            com.google.android.material.internal.NavigationMenuView r5 = r2.menuView
            r5.setOverScrollMode(r3)
        L_0x020f:
            android.view.LayoutInflater r3 = r2.layoutInflater
            int r5 = com.google.android.material.R$layout.design_navigation_item_header
            com.google.android.material.internal.NavigationMenuView r6 = r2.menuView
            android.view.View r3 = r3.inflate(r5, r6, r10)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2.headerLayout = r3
            com.google.android.material.internal.NavigationMenuView r3 = r2.menuView
            com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuAdapter r5 = r2.adapter
            r3.setAdapter(r5)
        L_0x0224:
            com.google.android.material.internal.NavigationMenuView r2 = r2.menuView
            r0.addView(r2)
            int r2 = com.google.android.material.R$styleable.NavigationView_menu
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x024f
            int r2 = com.google.android.material.R$styleable.NavigationView_menu
            int r2 = r1.getResourceId(r2, r10)
            com.google.android.material.internal.NavigationMenuPresenter r3 = r0.presenter
            r3.setUpdateSuspended(r4)
            android.view.MenuInflater r3 = r17.getMenuInflater()
            com.google.android.material.internal.NavigationMenu r4 = r0.menu
            r3.inflate(r2, r4)
            com.google.android.material.internal.NavigationMenuPresenter r2 = r0.presenter
            r2.setUpdateSuspended(r10)
            com.google.android.material.internal.NavigationMenuPresenter r2 = r0.presenter
            r2.updateMenuView(r10)
        L_0x024f:
            int r2 = com.google.android.material.R$styleable.NavigationView_headerLayout
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0275
            int r2 = com.google.android.material.R$styleable.NavigationView_headerLayout
            int r2 = r1.getResourceId(r2, r10)
            com.google.android.material.internal.NavigationMenuPresenter r3 = r0.presenter
            android.view.LayoutInflater r4 = r3.layoutInflater
            android.widget.LinearLayout r5 = r3.headerLayout
            android.view.View r2 = r4.inflate(r2, r5, r10)
            android.widget.LinearLayout r4 = r3.headerLayout
            r4.addView(r2)
            com.google.android.material.internal.NavigationMenuView r2 = r3.menuView
            int r3 = r2.getPaddingBottom()
            r2.setPadding(r10, r10, r10, r3)
        L_0x0275:
            android.content.res.TypedArray r1 = r1.mWrapped
            r1.recycle()
            com.google.android.material.navigation.NavigationView$2 r1 = new com.google.android.material.navigation.NavigationView$2
            r1.<init>()
            r0.onGlobalLayoutListener = r1
            android.view.ViewTreeObserver r1 = r17.getViewTreeObserver()
            android.view.ViewTreeObserver$OnGlobalLayoutListener r2 = r0.onGlobalLayoutListener
            r1.addOnGlobalLayoutListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.adapter.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
