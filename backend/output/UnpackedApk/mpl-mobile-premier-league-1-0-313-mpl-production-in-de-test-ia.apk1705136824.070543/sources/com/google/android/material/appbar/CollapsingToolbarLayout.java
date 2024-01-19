package com.google.android.material.appbar;

import a.a.a.a.d.b;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener;
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import sfs2x.client.entities.invitation.InvitationReply;

public class CollapsingToolbarLayout extends FrameLayout {
    public static final int DEF_STYLE_RES = R$style.Widget_Design_CollapsingToolbar;
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean collapsingTitleEnabled;
    public Drawable contentScrim;
    public int currentOffset;
    public boolean drawCollapsingTitle;
    public View dummyView;
    public final ElevationOverlayProvider elevationOverlayProvider;
    public int expandedMarginBottom;
    public int expandedMarginEnd;
    public int expandedMarginStart;
    public int expandedMarginTop;
    public int extraMultilineHeight;
    public boolean extraMultilineHeightEnabled;
    public boolean forceApplySystemWindowInsetTop;
    public WindowInsetsCompat lastInsets;
    public OnOffsetChangedListener onOffsetChangedListener;
    public boolean refreshToolbar;
    public int scrimAlpha;
    public long scrimAnimationDuration;
    public ValueAnimator scrimAnimator;
    public int scrimVisibleHeightTrigger;
    public boolean scrimsAreShown;
    public Drawable statusBarScrim;
    public int titleCollapseMode;
    public final Rect tmpRect;
    public ViewGroup toolbar;
    public View toolbarDirectChild;
    public int toolbarId;
    public int topInsetApplied;

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        public int collapseMode = 0;
        public float parallaxMult = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.parallaxMult = obtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class OffsetUpdateListener implements OnOffsetChangedListener {
        public OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.currentOffset = i;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.lastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                int i3 = layoutParams.collapseMode;
                if (i3 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(b.clamp(-i, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(childAt)));
                } else if (i3 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(Math.round(((float) (-i)) * layoutParams.parallaxMult));
                }
            }
            CollapsingToolbarLayout.this.updateScrimVisibility();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.statusBarScrim != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int minimumHeight = (height - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop;
            int scrimVisibleHeightTrigger = height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger();
            CollapsingTextHelper collapsingTextHelper = CollapsingToolbarLayout.this.collapsingTextHelper;
            float f2 = (float) minimumHeight;
            float min = Math.min(1.0f, ((float) scrimVisibleHeightTrigger) / f2);
            collapsingTextHelper.fadeModeStartFraction = min;
            collapsingTextHelper.fadeModeThresholdFraction = GeneratedOutlineSupport.outline3(1.0f, min, 0.5f, min);
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            CollapsingTextHelper collapsingTextHelper2 = collapsingToolbarLayout3.collapsingTextHelper;
            collapsingTextHelper2.currentOffsetY = collapsingToolbarLayout3.currentOffset + minimumHeight;
            collapsingTextHelper2.setExpansionFraction(((float) Math.abs(i)) / f2);
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    public static int getHeightWithMargins(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static ViewOffsetHelper getViewOffsetHelper(View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(R$id.view_offset_helper);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(R$id.view_offset_helper, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        ensureToolbar();
        if (this.toolbar == null) {
            Drawable drawable = this.contentScrim;
            if (drawable != null && this.scrimAlpha > 0) {
                drawable.mutate().setAlpha(this.scrimAlpha);
                this.contentScrim.draw(canvas);
            }
        }
        if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
            if (this.toolbar != null && this.contentScrim != null && this.scrimAlpha > 0 && isTitleCollapseFadeMode()) {
                CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                if (collapsingTextHelper2.expandedFraction < collapsingTextHelper2.fadeModeThresholdFraction) {
                    int save = canvas.save();
                    canvas.clipRect(this.contentScrim.getBounds(), Op.DIFFERENCE);
                    this.collapsingTextHelper.draw(canvas);
                    canvas.restoreToCount(save);
                }
            }
            this.collapsingTextHelper.draw(canvas);
        }
        if (this.statusBarScrim != null && this.scrimAlpha > 0) {
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), systemWindowInsetTop - this.currentOffset);
                this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
                this.statusBarScrim.draw(canvas);
            }
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.contentScrim != null && this.scrimAlpha > 0) {
            View view2 = this.toolbarDirectChild;
            if (view2 == null || view2 == this ? view == this.toolbar : view == view2) {
                updateContentScrimBounds(this.contentScrim, view, getWidth(), getHeight());
                this.contentScrim.mutate().setAlpha(this.scrimAlpha);
                this.contentScrim.draw(canvas);
                z = true;
                if (super.drawChild(canvas, view, j) && !z) {
                    return false;
                }
            }
        }
        z = false;
        return super.drawChild(canvas, view, j) ? true : true;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarScrim;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        if (collapsingTextHelper2 != null) {
            z |= collapsingTextHelper2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v8, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v6
      assigns: []
      uses: []
      mth insns count: 45
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ensureToolbar() {
        /*
            r6 = this;
            boolean r0 = r6.refreshToolbar
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.toolbar = r0
            r6.toolbarDirectChild = r0
            int r1 = r6.toolbarId
            r2 = -1
            if (r1 == r2) goto L_0x002f
            android.view.View r1 = r6.findViewById(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.toolbar = r1
            if (r1 == 0) goto L_0x002f
            android.view.ViewParent r2 = r1.getParent()
        L_0x001d:
            if (r2 == r6) goto L_0x002d
            if (r2 == 0) goto L_0x002d
            boolean r3 = r2 instanceof android.view.View
            if (r3 == 0) goto L_0x0028
            r1 = r2
            android.view.View r1 = (android.view.View) r1
        L_0x0028:
            android.view.ViewParent r2 = r2.getParent()
            goto L_0x001d
        L_0x002d:
            r6.toolbarDirectChild = r1
        L_0x002f:
            android.view.ViewGroup r1 = r6.toolbar
            r2 = 0
            if (r1 != 0) goto L_0x0056
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x0039:
            if (r3 >= r1) goto L_0x0054
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = r4 instanceof androidx.appcompat.widget.Toolbar
            if (r5 != 0) goto L_0x004a
            boolean r5 = r4 instanceof android.widget.Toolbar
            if (r5 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r5 = 0
            goto L_0x004b
        L_0x004a:
            r5 = 1
        L_0x004b:
            if (r5 == 0) goto L_0x0051
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0054
        L_0x0051:
            int r3 = r3 + 1
            goto L_0x0039
        L_0x0054:
            r6.toolbar = r0
        L_0x0056:
            r6.updateDummyView()
            r6.refreshToolbar = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.ensureToolbar():void");
    }

    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.collapsedTextGravity;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.collapsingTextHelper.collapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.expandedTextGravity;
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.collapsingTextHelper.expandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getHyphenationFrequency() {
        return this.collapsingTextHelper.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.collapsingTextHelper.textLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float getLineSpacingAdd() {
        return this.collapsingTextHelper.textLayout.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.collapsingTextHelper.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.collapsingTextHelper.maxLines;
    }

    public final int getMaxOffsetForPinChild(View view) {
        return ((getHeight() - getViewOffsetHelper(view).layoutTop) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.scrimVisibleHeightTrigger;
        if (i >= 0) {
            return i + this.topInsetApplied + this.extraMultilineHeight;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled) {
            return this.collapsingTextHelper.text;
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    public final boolean isTitleCollapseFadeMode() {
        return this.titleCollapseMode == 1;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (isTitleCollapseFadeMode()) {
                appBarLayout.setLiftOnScroll(false);
            }
            setFitsSystemWindows(ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new OffsetUpdateListener();
            }
            OnOffsetChangedListener onOffsetChangedListener2 = this.onOffsetChangedListener;
            if (appBarLayout.listeners == null) {
                appBarLayout.listeners = new ArrayList();
            }
            if (onOffsetChangedListener2 != null && !appBarLayout.listeners.contains(onOffsetChangedListener2)) {
                appBarLayout.listeners.add(onOffsetChangedListener2);
            }
            requestApplyInsets();
        }
    }

    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        OnOffsetChangedListener onOffsetChangedListener2 = this.onOffsetChangedListener;
        if (onOffsetChangedListener2 != null && (parent instanceof AppBarLayout)) {
            List<BaseOnOffsetChangedListener> list = ((AppBarLayout) parent).listeners;
            if (!(list == null || onOffsetChangedListener2 == null)) {
                list.remove(onOffsetChangedListener2);
            }
        }
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            ViewOffsetHelper viewOffsetHelper = getViewOffsetHelper(getChildAt(i6));
            viewOffsetHelper.layoutTop = viewOffsetHelper.view.getTop();
            viewOffsetHelper.layoutLeft = viewOffsetHelper.view.getLeft();
        }
        updateTextBounds(i, i2, i3, i4, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            getViewOffsetHelper(getChildAt(i7)).applyOffsets();
        }
    }

    public void onMeasure(int i, int i2) {
        ensureToolbar();
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i2);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int i3 = 0;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.forceApplySystemWindowInsetTop) && systemWindowInsetTop > 0) {
            this.topInsetApplied = systemWindowInsetTop;
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.extraMultilineHeightEnabled && this.collapsingTextHelper.maxLines > 1) {
            updateTitleFromToolbarIfNeeded();
            updateTextBounds(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            StaticLayout staticLayout = this.collapsingTextHelper.textLayout;
            if (staticLayout != null) {
                i3 = staticLayout.getLineCount();
            }
            if (i3 > 1) {
                CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                TextPaint textPaint = collapsingTextHelper2.tmpPaint;
                textPaint.setTextSize(collapsingTextHelper2.expandedTextSize);
                textPaint.setTypeface(collapsingTextHelper2.expandedTypeface);
                textPaint.setLetterSpacing(collapsingTextHelper2.expandedLetterSpacing);
                this.extraMultilineHeight = (i3 - 1) * Math.round(collapsingTextHelper2.tmpPaint.descent() + (-collapsingTextHelper2.tmpPaint.ascent()));
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.extraMultilineHeight, 1073741824));
            }
        }
        if (this.toolbar != null) {
            View view = this.toolbarDirectChild;
            if (view == null || view == this) {
                setMinimumHeight(getHeightWithMargins(this.toolbar));
            } else {
                setMinimumHeight(getHeightWithMargins(view));
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.contentScrim;
        if (drawable != null) {
            updateContentScrimBounds(drawable, this.toolbar, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        if (collapsingTextHelper2.collapsedTextGravity != i) {
            collapsingTextHelper2.collapsedTextGravity = i;
            collapsingTextHelper2.recalculate(false);
        }
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.collapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.contentScrim = drawable3;
            if (drawable3 != null) {
                updateContentScrimBounds(drawable3, this.toolbar, getWidth(), getHeight());
                this.contentScrim.setCallback(this);
                this.contentScrim.setAlpha(this.scrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        if (collapsingTextHelper2.expandedTextGravity != i) {
            collapsingTextHelper2.expandedTextGravity = i;
            collapsingTextHelper2.recalculate(false);
        }
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.expandedMarginBottom = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.expandedMarginEnd = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.expandedMarginStart = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.expandedMarginTop = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.collapsingTextHelper.setExpandedTextAppearance(i);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        if (collapsingTextHelper2.expandedTextColor != colorStateList) {
            collapsingTextHelper2.expandedTextColor = colorStateList;
            collapsingTextHelper2.recalculate(false);
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.collapsingTextHelper.setExpandedTypeface(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z) {
        this.extraMultilineHeightEnabled = z;
    }

    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.forceApplySystemWindowInsetTop = z;
    }

    public void setHyphenationFrequency(int i) {
        this.collapsingTextHelper.hyphenationFrequency = i;
    }

    public void setLineSpacingAdd(float f2) {
        this.collapsingTextHelper.lineSpacingAdd = f2;
    }

    public void setLineSpacingMultiplier(float f2) {
        this.collapsingTextHelper.lineSpacingMultiplier = f2;
    }

    public void setMaxLines(int i) {
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        if (i != collapsingTextHelper2.maxLines) {
            collapsingTextHelper2.maxLines = i;
            collapsingTextHelper2.clearTexture();
            collapsingTextHelper2.recalculate(false);
        }
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled = z;
    }

    public void setScrimAlpha(int i) {
        if (i != this.scrimAlpha) {
            if (this.contentScrim != null) {
                ViewGroup viewGroup = this.toolbar;
                if (viewGroup != null) {
                    ViewCompat.postInvalidateOnAnimation(viewGroup);
                }
            }
            this.scrimAlpha = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(long j) {
        this.scrimAnimationDuration = j;
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.scrimVisibleHeightTrigger != i) {
            this.scrimVisibleHeightTrigger = i;
            updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean z) {
        int i = 0;
        boolean z2 = ViewCompat.isLaidOut(this) && !isInEditMode();
        if (this.scrimsAreShown != z) {
            int i2 = InvitationReply.EXPIRED;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                ensureToolbar();
                ValueAnimator valueAnimator = this.scrimAnimator;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.scrimAnimator = valueAnimator2;
                    valueAnimator2.setDuration(this.scrimAnimationDuration);
                    this.scrimAnimator.setInterpolator(i2 > this.scrimAlpha ? AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                    this.scrimAnimator.addUpdateListener(new AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                } else if (valueAnimator.isRunning()) {
                    this.scrimAnimator.cancel();
                }
                this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, i2});
                this.scrimAnimator.start();
            } else {
                if (z) {
                    i = InvitationReply.EXPIRED;
                }
                setScrimAlpha(i);
            }
            this.scrimsAreShown = z;
        }
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.statusBarScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.statusBarScrim = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarScrim.setState(getDrawableState());
                }
                b.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
                this.statusBarScrim.setVisible(getVisibility() == 0, false);
                this.statusBarScrim.setCallback(this);
                this.statusBarScrim.setAlpha(this.scrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setTitle(CharSequence charSequence) {
        this.collapsingTextHelper.setText(charSequence);
        setContentDescription(getTitle());
    }

    public void setTitleCollapseMode(int i) {
        this.titleCollapseMode = i;
        boolean isTitleCollapseFadeMode = isTitleCollapseFadeMode();
        this.collapsingTextHelper.fadeModeEnabled = isTitleCollapseFadeMode;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (isTitleCollapseFadeMode()) {
                appBarLayout.setLiftOnScroll(false);
            }
        }
        if (isTitleCollapseFadeMode && this.contentScrim == null) {
            float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
            ElevationOverlayProvider elevationOverlayProvider2 = this.elevationOverlayProvider;
            setContentScrimColor(elevationOverlayProvider2.compositeOverlayIfNeeded(elevationOverlayProvider2.colorSurface, dimension));
        }
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.collapsingTitleEnabled) {
            this.collapsingTitleEnabled = z;
            setContentDescription(getTitle());
            updateDummyView();
            requestLayout();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.statusBarScrim;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.statusBarScrim.setVisible(z, false);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.contentScrim.setVisible(z, false);
        }
    }

    public final void updateContentScrimBounds(Drawable drawable, View view, int i, int i2) {
        if (isTitleCollapseFadeMode() && view != null && this.collapsingTitleEnabled) {
            i2 = view.getBottom();
        }
        drawable.setBounds(0, 0, i, i2);
    }

    public final void updateDummyView() {
        if (!this.collapsingTitleEnabled) {
            View view = this.dummyView;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.dummyView);
                }
            }
        }
        if (this.collapsingTitleEnabled && this.toolbar != null) {
            if (this.dummyView == null) {
                this.dummyView = new View(getContext());
            }
            if (this.dummyView.getParent() == null) {
                this.toolbar.addView(this.dummyView, -1, -1);
            }
        }
    }

    public final void updateScrimVisibility() {
        if (this.contentScrim != null || this.statusBarScrim != null) {
            setScrimsShown(getHeight() + this.currentOffset < getScrimVisibleHeightTrigger());
        }
    }

    public final void updateTextBounds(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        boolean z2 = z;
        if (this.collapsingTitleEnabled) {
            View view = this.dummyView;
            if (view != null) {
                int i8 = 0;
                boolean z3 = ViewCompat.isAttachedToWindow(view) && this.dummyView.getVisibility() == 0;
                this.drawCollapsingTitle = z3;
                if (z3 || z2) {
                    boolean z4 = getLayoutDirection() == 1;
                    View view2 = this.toolbarDirectChild;
                    if (view2 == null) {
                        view2 = this.toolbar;
                    }
                    int maxOffsetForPinChild = getMaxOffsetForPinChild(view2);
                    DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
                    ViewGroup viewGroup = this.toolbar;
                    if (viewGroup instanceof Toolbar) {
                        Toolbar toolbar2 = (Toolbar) viewGroup;
                        i8 = toolbar2.getTitleMarginStart();
                        i6 = toolbar2.getTitleMarginEnd();
                        i5 = toolbar2.getTitleMarginTop();
                        i7 = toolbar2.getTitleMarginBottom();
                    } else if (VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                        i7 = 0;
                        i6 = 0;
                        i5 = 0;
                    } else {
                        android.widget.Toolbar toolbar3 = (android.widget.Toolbar) viewGroup;
                        i8 = toolbar3.getTitleMarginStart();
                        i6 = toolbar3.getTitleMarginEnd();
                        i5 = toolbar3.getTitleMarginTop();
                        i7 = toolbar3.getTitleMarginBottom();
                    }
                    CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                    int i9 = this.tmpRect.left + (z4 ? i6 : i8);
                    Rect rect = this.tmpRect;
                    int i10 = rect.top + maxOffsetForPinChild + i5;
                    int i11 = rect.right;
                    if (!z4) {
                        i8 = i6;
                    }
                    int i12 = i11 - i8;
                    int i13 = (this.tmpRect.bottom + maxOffsetForPinChild) - i7;
                    if (!CollapsingTextHelper.rectEquals(collapsingTextHelper2.collapsedBounds, i9, i10, i12, i13)) {
                        collapsingTextHelper2.collapsedBounds.set(i9, i10, i12, i13);
                        collapsingTextHelper2.boundsChanged = true;
                        collapsingTextHelper2.onBoundsChanged();
                    }
                    CollapsingTextHelper collapsingTextHelper3 = this.collapsingTextHelper;
                    int i14 = z4 ? this.expandedMarginEnd : this.expandedMarginStart;
                    int i15 = this.tmpRect.top + this.expandedMarginTop;
                    int i16 = (i3 - i) - (z4 ? this.expandedMarginStart : this.expandedMarginEnd);
                    int i17 = (i4 - i2) - this.expandedMarginBottom;
                    if (!CollapsingTextHelper.rectEquals(collapsingTextHelper3.expandedBounds, i14, i15, i16, i17)) {
                        collapsingTextHelper3.expandedBounds.set(i14, i15, i16, i17);
                        collapsingTextHelper3.boundsChanged = true;
                        collapsingTextHelper3.onBoundsChanged();
                    }
                    this.collapsingTextHelper.recalculate(z2);
                }
            }
        }
    }

    public final void updateTitleFromToolbarIfNeeded() {
        CharSequence charSequence;
        if (this.toolbar != null && this.collapsingTitleEnabled && TextUtils.isEmpty(this.collapsingTextHelper.text)) {
            ViewGroup viewGroup = this.toolbar;
            if (viewGroup instanceof Toolbar) {
                charSequence = ((Toolbar) viewGroup).getTitle();
            } else {
                charSequence = viewGroup instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup).getTitle() : null;
            }
            setTitle(charSequence);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        this.topInsetApplied = 0;
        this.extraMultilineHeight = 0;
        Context context2 = getContext();
        CollapsingTextHelper collapsingTextHelper2 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper2;
        collapsingTextHelper2.textSizeInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
        collapsingTextHelper2.recalculate(false);
        this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled = false;
        this.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.CollapsingToolbarLayout, i, DEF_STYLE_RES, new int[0]);
        this.collapsingTextHelper.setExpandedTextGravity(obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.collapsingTextHelper.setCollapsedTextGravity(obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginBottom = dimensionPixelSize;
        this.expandedMarginEnd = dimensionPixelSize;
        this.expandedMarginTop = dimensionPixelSize;
        this.expandedMarginStart = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.expandedMarginStart = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.expandedMarginEnd = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.expandedMarginTop = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.expandedMarginBottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.collapsingTitleEnabled = obtainStyledAttributes.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(R$styleable.CollapsingToolbarLayout_title));
        this.collapsingTextHelper.setExpandedTextAppearance(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.collapsingTextHelper.setCollapsedTextAppearance(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.collapsingTextHelper.setExpandedTextAppearance(obtainStyledAttributes.getResourceId(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.collapsingTextHelper.setCollapsedTextAppearance(obtainStyledAttributes.getResourceId(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.scrimVisibleHeightTrigger = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (obtainStyledAttributes.hasValue(R$styleable.CollapsingToolbarLayout_maxLines)) {
            CollapsingTextHelper collapsingTextHelper3 = this.collapsingTextHelper;
            int i2 = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_maxLines, 1);
            if (i2 != collapsingTextHelper3.maxLines) {
                collapsingTextHelper3.maxLines = i2;
                collapsingTextHelper3.clearTexture();
                collapsingTextHelper3.recalculate(false);
            }
        }
        this.scrimAnimationDuration = (long) obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.toolbarId = obtainStyledAttributes.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.forceApplySystemWindowInsetTop = obtainStyledAttributes.getBoolean(R$styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.extraMultilineHeightEnabled = obtainStyledAttributes.getBoolean(R$styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
                WindowInsetsCompat windowInsetsCompat2 = null;
                if (collapsingToolbarLayout != null) {
                    if (ViewCompat.getFitsSystemWindows(collapsingToolbarLayout)) {
                        windowInsetsCompat2 = windowInsetsCompat;
                    }
                    if (!Objects.equals(collapsingToolbarLayout.lastInsets, windowInsetsCompat2)) {
                        collapsingToolbarLayout.lastInsets = windowInsetsCompat2;
                        collapsingToolbarLayout.requestLayout();
                    }
                    return windowInsetsCompat.consumeSystemWindowInsets();
                }
                throw null;
            }
        });
    }

    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public android.widget.FrameLayout.LayoutParams m94generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
        if (collapsingTextHelper2.collapsedTextColor != colorStateList) {
            collapsingTextHelper2.collapsedTextColor = colorStateList;
            collapsingTextHelper2.recalculate(false);
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
