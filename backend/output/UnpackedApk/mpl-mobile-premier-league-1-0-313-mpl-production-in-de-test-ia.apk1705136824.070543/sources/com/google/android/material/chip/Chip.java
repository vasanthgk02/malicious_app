package com.google.android.material.chip;

import a.a.a.a.d.b;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable.Delegate;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends AppCompatCheckBox implements Delegate, Shapeable {
    public static final int[] CHECKABLE_STATE_SET = {16842911};
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_Chip_Action;
    public static final Rect EMPTY_BOUNDS = new Rect();
    public static final int[] SELECTED_STATE = {16842913};
    public ChipDrawable chipDrawable;
    public boolean closeIconFocused;
    public boolean closeIconHovered;
    public boolean closeIconPressed;
    public boolean deferredCheckedValue;
    public boolean ensureMinTouchTargetSize;
    public final TextAppearanceFontCallback fontCallback;
    public InsetDrawable insetBackgroundDrawable;
    public int lastLayoutDirection;
    public int minTouchTargetSize;
    public OnCheckedChangeListener onCheckedChangeListenerInternal;
    public OnClickListener onCloseIconClickListener;
    public final Rect rect;
    public final RectF rectF;
    public RippleDrawable ripple;
    public final ChipTouchHelper touchHelper;

    public class ChipTouchHelper extends ExploreByTouchHelper {
        public ChipTouchHelper(Chip chip) {
            super(chip);
        }

        public int getVirtualViewAt(float f2, float f3) {
            return (!Chip.this.hasCloseIcon() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 0 : 1;
        }

        public void getVisibleVirtualViews(List<Integer> list) {
            boolean z = false;
            list.add(Integer.valueOf(0));
            if (Chip.this.hasCloseIcon()) {
                ChipDrawable chipDrawable = Chip.this.chipDrawable;
                if (chipDrawable != null && chipDrawable.closeIconVisible) {
                    z = true;
                }
                if (z && Chip.this.onCloseIconClickListener != null) {
                    list.add(Integer.valueOf(1));
                }
            }
        }

        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i2 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    OnClickListener onClickListener = chip.onCloseIconClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.touchHelper.sendEventForVirtualView(1, 1);
                }
            }
            return z;
        }

        public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.mInfo.setCheckable(Chip.this.isCheckable());
            accessibilityNodeInfoCompat.mInfo.setClickable(Chip.this.isClickable());
            if (Chip.this.isCheckable() || Chip.this.isClickable()) {
                accessibilityNodeInfoCompat.mInfo.setClassName(Chip.this.isCheckable() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                accessibilityNodeInfoCompat.mInfo.setClassName("android.view.View");
            }
            CharSequence text = Chip.this.getText();
            if (VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.mInfo.setText(text);
            } else {
                accessibilityNodeInfoCompat.mInfo.setContentDescription(text);
            }
        }

        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence = "";
            if (i == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.mInfo.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    accessibilityNodeInfoCompat.mInfo.setContentDescription(context.getString(i2, objArr).trim());
                }
                accessibilityNodeInfoCompat.mInfo.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.addAction(AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.mInfo.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.mInfo.setContentDescription(charSequence);
            accessibilityNodeInfoCompat.mInfo.setBoundsInParent(Chip.EMPTY_BOUNDS);
        }

        public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
            if (i == 1) {
                Chip chip = Chip.this;
                chip.closeIconFocused = z;
                chip.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    /* access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon() && this.onCloseIconClickListener != null) {
            ChipDrawable chipDrawable2 = this.chipDrawable;
            chipDrawable2.calculateCloseIconTouchBounds(chipDrawable2.getBounds(), this.rectF);
        }
        return this.rectF;
    }

    /* access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.rect;
    }

    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.textDrawableHelper.textAppearance;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.closeIconHovered != z) {
            this.closeIconHovered = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.closeIconPressed != z) {
            this.closeIconPressed = z;
            refreshDrawableState();
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z;
        Class<ExploreByTouchHelper> cls = ExploreByTouchHelper.class;
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = cls.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.touchHelper)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = cls.getDeclaredMethod("updateHoveredVirtualView", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.touchHelper, new Object[]{Integer.valueOf(LinearLayoutManager.INVALID_OFFSET)});
                    z = true;
                    if (!z || this.touchHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
                        return true;
                    }
                    return false;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        z = false;
        return !z ? true : true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ChipTouchHelper chipTouchHelper = this.touchHelper;
        if (chipTouchHelper != null) {
            int i = 0;
            if (keyEvent.getAction() != 1) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 61) {
                    int i2 = 66;
                    if (keyCode != 66) {
                        switch (keyCode) {
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                if (keyEvent.hasNoModifiers()) {
                                    if (keyCode == 19) {
                                        i2 = 33;
                                    } else if (keyCode == 21) {
                                        i2 = 17;
                                    } else if (keyCode != 22) {
                                        i2 = 130;
                                    }
                                    int repeatCount = keyEvent.getRepeatCount() + 1;
                                    int i3 = 0;
                                    while (i < repeatCount && chipTouchHelper.moveFocus(i2, null)) {
                                        i++;
                                        i3 = 1;
                                    }
                                    i = i3;
                                    break;
                                }
                                break;
                            case 23:
                                break;
                        }
                    }
                    if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                        int i4 = chipTouchHelper.mKeyboardFocusedVirtualViewId;
                        if (i4 != Integer.MIN_VALUE) {
                            chipTouchHelper.onPerformActionForVirtualView(i4, 16, null);
                        }
                        i = 1;
                    }
                } else if (keyEvent.hasNoModifiers()) {
                    i = chipTouchHelper.moveFocus(2, null);
                } else if (keyEvent.hasModifiers(1)) {
                    i = chipTouchHelper.moveFocus(1, null);
                }
            }
            if (i == 0 || this.touchHelper.mKeyboardFocusedVirtualViewId == Integer.MIN_VALUE) {
                return super.dispatchKeyEvent(keyEvent);
            }
            return true;
        }
        throw null;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable chipDrawable2 = this.chipDrawable;
        int i = 0;
        if (chipDrawable2 != null && ChipDrawable.isStateful(chipDrawable2.closeIcon)) {
            ChipDrawable chipDrawable3 = this.chipDrawable;
            int isEnabled = isEnabled();
            if (this.closeIconFocused) {
                isEnabled++;
            }
            if (this.closeIconHovered) {
                isEnabled++;
            }
            if (this.closeIconPressed) {
                isEnabled++;
            }
            if (isChecked()) {
                isEnabled++;
            }
            int[] iArr = new int[isEnabled];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.closeIconFocused) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.closeIconHovered) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.closeIconPressed) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            i = chipDrawable3.setCloseIconState(iArr);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public boolean ensureAccessibleTouchTarget(int i) {
        this.minTouchTargetSize = i;
        if (!this.ensureMinTouchTargetSize) {
            if (this.insetBackgroundDrawable != null) {
                removeBackgroundInset();
            } else {
                boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
                updateFrameworkRippleBackground();
            }
            return false;
        }
        int max = Math.max(0, i - ((int) this.chipDrawable.chipMinHeight));
        int max2 = Math.max(0, i - this.chipDrawable.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i2 = max2 > 0 ? max2 / 2 : 0;
            int i3 = max > 0 ? max / 2 : 0;
            if (this.insetBackgroundDrawable != null) {
                Rect rect2 = new Rect();
                this.insetBackgroundDrawable.getPadding(rect2);
                if (rect2.top == i3 && rect2.bottom == i3 && rect2.left == i2 && rect2.right == i2) {
                    boolean z2 = RippleUtils.USE_FRAMEWORK_RIPPLE;
                    updateFrameworkRippleBackground();
                    return true;
                }
            }
            if (getMinHeight() != i) {
                setMinHeight(i);
            }
            if (getMinWidth() != i) {
                setMinWidth(i);
            }
            InsetDrawable insetDrawable = new InsetDrawable(this.chipDrawable, i2, i3, i2, i3);
            this.insetBackgroundDrawable = insetDrawable;
            boolean z3 = RippleUtils.USE_FRAMEWORK_RIPPLE;
            updateFrameworkRippleBackground();
            return true;
        }
        if (this.insetBackgroundDrawable != null) {
            removeBackgroundInset();
        } else {
            boolean z4 = RippleUtils.USE_FRAMEWORK_RIPPLE;
            updateFrameworkRippleBackground();
        }
        return false;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.insetBackgroundDrawable;
        return insetDrawable == null ? this.chipDrawable : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.checkedIcon;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.checkedIconTint;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipBackgroundColor;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return Math.max(0.0f, chipDrawable2.getChipCornerRadius());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipEndPadding;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            Drawable drawable = chipDrawable2.chipIcon;
            if (drawable != null) {
                return b.unwrap(drawable);
            }
        }
        return null;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipIconSize;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipIconTint;
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipMinHeight;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipStartPadding;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipStrokeColor;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.chipStrokeWidth;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIcon();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconContentDescription;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconEndPadding;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconSize;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconStartPadding;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.closeIconTint;
        }
        return null;
    }

    public TruncateAt getEllipsize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.truncateAt;
        }
        return null;
    }

    public void getFocusedRect(Rect rect2) {
        ChipTouchHelper chipTouchHelper = this.touchHelper;
        if (chipTouchHelper.mKeyboardFocusedVirtualViewId == 1 || chipTouchHelper.mAccessibilityFocusedVirtualViewId == 1) {
            rect2.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect2);
        }
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.hideMotionSpec;
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.iconEndPadding;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.iconStartPadding;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.rippleColor;
        }
        return null;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.drawableState.shapeAppearanceModel;
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.showMotionSpec;
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.textEndPadding;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.textStartPadding;
        }
        return 0.0f;
    }

    public final boolean hasCloseIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return (chipDrawable2 == null || chipDrawable2.getCloseIcon() == null) ? false : true;
    }

    public boolean isCheckable() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        return chipDrawable2 != null && chipDrawable2.checkable;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextAppearanceConfig.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        invalidateOutline();
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, SELECTED_STATE);
        }
        if (isCheckable()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onFocusChanged(boolean z, int i, Rect rect2) {
        super.onFocusChanged(z, i, rect2);
        ChipTouchHelper chipTouchHelper = this.touchHelper;
        int i2 = chipTouchHelper.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            chipTouchHelper.clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            chipTouchHelper.moveFocus(i, rect2);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        int i2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isCheckable() || isClickable()) {
            accessibilityNodeInfo.setClassName(isCheckable() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.singleLine) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= chipGroup.getChildCount()) {
                        i4 = -1;
                        break;
                    }
                    if (chipGroup.getChildAt(i3) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i3)) == this) {
                            break;
                        }
                        i4++;
                    }
                    i3++;
                }
                i = i4;
            } else {
                i = -1;
            }
            Object tag = getTag(R$id.row_index_key);
            if (!(tag instanceof Integer)) {
                i2 = -1;
            } else {
                i2 = ((Integer) tag).intValue();
            }
            accessibilityNodeInfo.setCollectionItemInfo((CollectionItemInfo) CollectionItemInfoCompat.obtain(i2, 1, i, 1, false, isChecked()).mInfo);
        }
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.lastLayoutDirection != i) {
            this.lastLayoutDirection = i;
            updatePaddingInternal();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0045
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0040
            goto L_0x004c
        L_0x0021:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L_0x004c
            if (r1 != 0) goto L_0x004a
            r5.setCloseIconPressed(r2)
            goto L_0x004a
        L_0x002b:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L_0x0040
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.onCloseIconClickListener
            if (r0 == 0) goto L_0x0039
            r0.onClick(r5)
        L_0x0039:
            com.google.android.material.chip.Chip$ChipTouchHelper r0 = r5.touchHelper
            r0.sendEventForVirtualView(r3, r3)
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            r5.setCloseIconPressed(r2)
            goto L_0x004d
        L_0x0045:
            if (r1 == 0) goto L_0x004c
            r5.setCloseIconPressed(r3)
        L_0x004a:
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            if (r0 != 0) goto L_0x0055
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x0056
        L_0x0055:
            r2 = 1
        L_0x0056:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void removeBackgroundInset() {
        if (this.insetBackgroundDrawable != null) {
            this.insetBackgroundDrawable = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            boolean z = RippleUtils.USE_FRAMEWORK_RIPPLE;
            updateFrameworkRippleBackground();
        }
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.ripple) {
            super.setBackground(drawable);
        }
    }

    public void setBackgroundColor(int i) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.ripple) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(Mode mode) {
    }

    public void setCheckable(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckable(z);
        }
    }

    public void setCheckableResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckable(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChecked(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null) {
            this.deferredCheckedValue = z;
        } else if (chipDrawable2.checkable) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z) {
                OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListenerInternal;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(this, z);
                }
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIcon(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconTint(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconTint(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconVisible(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipBackgroundColor != colorStateList) {
            chipDrawable2.chipBackgroundColor = colorStateList;
            chipDrawable2.onStateChange(chipDrawable2.getState());
        }
    }

    public void setChipBackgroundColorResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipBackgroundColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipCornerRadius(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipCornerRadius(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(ChipDrawable chipDrawable2) {
        ChipDrawable chipDrawable3 = this.chipDrawable;
        if (chipDrawable3 != chipDrawable2) {
            if (chipDrawable3 != null) {
                chipDrawable3.delegate = new WeakReference<>(null);
            }
            this.chipDrawable = chipDrawable2;
            chipDrawable2.shouldDrawText = false;
            if (chipDrawable2 != null) {
                chipDrawable2.delegate = new WeakReference<>(this);
                ensureAccessibleTouchTarget(this.minTouchTargetSize);
                return;
            }
            throw null;
        }
    }

    public void setChipEndPadding(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipEndPadding != f2) {
            chipDrawable2.chipEndPadding = f2;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipEndPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipIcon(Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIcon(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
    }

    public void setChipIconSize(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconSize(f2);
        }
    }

    public void setChipIconSizeResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconSize(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconTint(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setChipIconVisible(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconVisible(chipDrawable2.context.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipMinHeight != f2) {
            chipDrawable2.chipMinHeight = f2;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipMinHeightResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipMinHeight(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipStartPadding(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.chipStartPadding != f2) {
            chipDrawable2.chipStartPadding = f2;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setChipStartPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeColor(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setChipStrokeWidth(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeWidth(f2);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeWidth(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIcon(drawable);
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.closeIconContentDescription != charSequence) {
            BidiFormatter instance = BidiFormatter.getInstance();
            chipDrawable2.closeIconContentDescription = instance.unicodeWrap(charSequence, instance.mDefaultTextDirectionHeuristicCompat, true);
            chipDrawable2.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconEndPadding(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIcon(AppCompatResources.getDrawable(chipDrawable2.context, i));
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconSize(f2);
        }
    }

    public void setCloseIconSizeResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconSize(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconStartPadding(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconTint(AppCompatResources.getColorStateList(chipDrawable2.context, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            MaterialShapeDrawableState materialShapeDrawableState = chipDrawable2.drawableState;
            if (materialShapeDrawableState.elevation != f2) {
                materialShapeDrawableState.elevation = f2;
                chipDrawable2.updateZ();
            }
        }
    }

    public void setEllipsize(TruncateAt truncateAt) {
        if (this.chipDrawable != null) {
            if (truncateAt != TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                ChipDrawable chipDrawable2 = this.chipDrawable;
                if (chipDrawable2 != null) {
                    chipDrawable2.truncateAt = truncateAt;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.ensureMinTouchTargetSize = z;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    public void setGravity(int i) {
        if (i == 8388627) {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.hideMotionSpec = motionSpec;
        }
    }

    public void setHideMotionSpecResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.hideMotionSpec = MotionSpec.createFromResource(chipDrawable2.context, i);
        }
    }

    public void setIconEndPadding(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconEndPadding(f2);
        }
    }

    public void setIconEndPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconStartPadding(f2);
        }
    }

    public void setIconStartPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setLayoutDirection(int i) {
        if (this.chipDrawable != null) {
            super.setLayoutDirection(i);
        }
    }

    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.maxWidth = i;
        }
    }

    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
        updateAccessibilityDelegate();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setRippleColor(colorStateList);
        }
        if (!this.chipDrawable.useCompatRipple) {
            updateFrameworkRippleBackground();
        }
    }

    public void setRippleColorResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setRippleColor(AppCompatResources.getColorStateList(chipDrawable2.context, i));
            if (!this.chipDrawable.useCompatRipple) {
                updateFrameworkRippleBackground();
            }
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        chipDrawable2.drawableState.shapeAppearanceModel = shapeAppearanceModel;
        chipDrawable2.invalidateSelf();
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.showMotionSpec = motionSpec;
        }
    }

    public void setShowMotionSpecResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.showMotionSpec = MotionSpec.createFromResource(chipDrawable2.context, i);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        if (this.chipDrawable != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(this.chipDrawable.shouldDrawText ? null : charSequence, bufferType);
            ChipDrawable chipDrawable2 = this.chipDrawable;
            if (chipDrawable2 != null) {
                chipDrawable2.setText(charSequence);
            }
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.textDrawableHelper.setTextAppearance(textAppearance, chipDrawable2.context);
        }
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.textEndPadding != f2) {
            chipDrawable2.textEndPadding = f2;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setTextEndPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextEndPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public void setTextStartPadding(float f2) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null && chipDrawable2.textStartPadding != f2) {
            chipDrawable2.textStartPadding = f2;
            chipDrawable2.invalidateSelf();
            chipDrawable2.onSizeChange();
        }
    }

    public void setTextStartPaddingResource(int i) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextStartPadding(chipDrawable2.context.getResources().getDimension(i));
        }
    }

    public final void updateAccessibilityDelegate() {
        if (hasCloseIcon()) {
            ChipDrawable chipDrawable2 = this.chipDrawable;
            if ((chipDrawable2 != null && chipDrawable2.closeIconVisible) && this.onCloseIconClickListener != null) {
                ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
                return;
            }
        }
        ViewCompat.setAccessibilityDelegate(this, null);
    }

    public final void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.rippleColor), getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
        updatePaddingInternal();
    }

    public final void updatePaddingInternal() {
        if (!TextUtils.isEmpty(getText())) {
            ChipDrawable chipDrawable2 = this.chipDrawable;
            if (chipDrawable2 != null) {
                int calculateCloseIconWidth = (int) (chipDrawable2.calculateCloseIconWidth() + chipDrawable2.chipEndPadding + chipDrawable2.textEndPadding);
                ChipDrawable chipDrawable3 = this.chipDrawable;
                int calculateChipIconWidth = (int) (chipDrawable3.calculateChipIconWidth() + chipDrawable3.chipStartPadding + chipDrawable3.textStartPadding);
                if (this.insetBackgroundDrawable != null) {
                    Rect rect2 = new Rect();
                    this.insetBackgroundDrawable.getPadding(rect2);
                    calculateChipIconWidth += rect2.left;
                    calculateCloseIconWidth += rect2.right;
                }
                ViewCompat.setPaddingRelative(this, calculateChipIconWidth, getPaddingTop(), calculateCloseIconWidth, getPaddingBottom());
            }
        }
    }

    public final void updateTextPaintDrawState() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            paint.drawableState = chipDrawable2.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.updateDrawState(getContext(), paint, this.fontCallback);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r15, android.util.AttributeSet r16, int r17) {
        /*
            r14 = this;
            r0 = r14
            r7 = r16
            r8 = r17
            int r1 = DEF_STYLE_RES
            r2 = r15
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r15, r7, r8, r1)
            r14.<init>(r1, r7, r8)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.rect = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.rectF = r1
            com.google.android.material.chip.Chip$1 r1 = new com.google.android.material.chip.Chip$1
            r1.<init>()
            r0.fontCallback = r1
            android.content.Context r9 = r14.getContext()
            r10 = 8388627(0x800013, float:1.175497E-38)
            r11 = 1
            if (r7 != 0) goto L_0x002f
            goto L_0x007d
        L_0x002f:
            java.lang.String r1 = "http://schemas.android.com/apk/res/android"
            java.lang.String r2 = "background"
            r7.getAttributeValue(r1, r2)
            java.lang.String r2 = "drawableLeft"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            if (r2 != 0) goto L_0x0346
            java.lang.String r2 = "drawableStart"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            if (r2 != 0) goto L_0x033e
            java.lang.String r2 = "drawableEnd"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            java.lang.String r3 = "Please set end drawable using R.attr#closeIcon."
            if (r2 != 0) goto L_0x0338
            java.lang.String r2 = "drawableRight"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            if (r2 != 0) goto L_0x0332
            java.lang.String r2 = "singleLine"
            boolean r2 = r7.getAttributeBooleanValue(r1, r2, r11)
            if (r2 == 0) goto L_0x032a
            java.lang.String r2 = "lines"
            int r2 = r7.getAttributeIntValue(r1, r2, r11)
            if (r2 != r11) goto L_0x032a
            java.lang.String r2 = "minLines"
            int r2 = r7.getAttributeIntValue(r1, r2, r11)
            if (r2 != r11) goto L_0x032a
            java.lang.String r2 = "maxLines"
            int r2 = r7.getAttributeIntValue(r1, r2, r11)
            if (r2 != r11) goto L_0x032a
            java.lang.String r2 = "gravity"
            r7.getAttributeIntValue(r1, r2, r10)
        L_0x007d:
            int r5 = DEF_STYLE_RES
            com.google.android.material.chip.ChipDrawable r12 = new com.google.android.material.chip.ChipDrawable
            r12.<init>(r9, r7, r8, r5)
            android.content.Context r1 = r12.context
            int[] r3 = com.google.android.material.R$styleable.Chip
            r13 = 0
            int[] r6 = new int[r13]
            r2 = r16
            r4 = r17
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R$styleable.Chip_shapeAppearance
            boolean r2 = r1.hasValue(r2)
            r12.isShapeThemingEnabled = r2
            android.content.Context r2 = r12.context
            int r3 = com.google.android.material.R$styleable.Chip_chipSurfaceColor
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r2, r1, r3)
            android.content.res.ColorStateList r3 = r12.chipSurfaceColor
            if (r3 == r2) goto L_0x00b0
            r12.chipSurfaceColor = r2
            int[] r2 = r12.getState()
            r12.onStateChange(r2)
        L_0x00b0:
            android.content.Context r2 = r12.context
            int r3 = com.google.android.material.R$styleable.Chip_chipBackgroundColor
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r2, r1, r3)
            r12.setChipBackgroundColor(r2)
            int r2 = com.google.android.material.R$styleable.Chip_chipMinHeight
            r3 = 0
            float r2 = r1.getDimension(r2, r3)
            r12.setChipMinHeight(r2)
            int r2 = com.google.android.material.R$styleable.Chip_chipCornerRadius
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x00d6
            int r2 = com.google.android.material.R$styleable.Chip_chipCornerRadius
            float r2 = r1.getDimension(r2, r3)
            r12.setChipCornerRadius(r2)
        L_0x00d6:
            android.content.Context r2 = r12.context
            int r4 = com.google.android.material.R$styleable.Chip_chipStrokeColor
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r2, r1, r4)
            r12.setChipStrokeColor(r2)
            int r2 = com.google.android.material.R$styleable.Chip_chipStrokeWidth
            float r2 = r1.getDimension(r2, r3)
            r12.setChipStrokeWidth(r2)
            android.content.Context r2 = r12.context
            int r4 = com.google.android.material.R$styleable.Chip_rippleColor
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r2, r1, r4)
            r12.setRippleColor(r2)
            int r2 = com.google.android.material.R$styleable.Chip_android_text
            java.lang.CharSequence r2 = r1.getText(r2)
            r12.setText(r2)
            android.content.Context r2 = r12.context
            int r4 = com.google.android.material.R$styleable.Chip_android_textAppearance
            com.google.android.material.resources.TextAppearance r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getTextAppearance(r2, r1, r4)
            int r4 = com.google.android.material.R$styleable.Chip_android_textSize
            float r5 = r2.textSize
            float r4 = r1.getDimension(r4, r5)
            r2.textSize = r4
            com.google.android.material.internal.TextDrawableHelper r4 = r12.textDrawableHelper
            android.content.Context r5 = r12.context
            r4.setTextAppearance(r2, r5)
            int r2 = com.google.android.material.R$styleable.Chip_android_ellipsize
            int r2 = r1.getInt(r2, r13)
            if (r2 == r11) goto L_0x0130
            r4 = 2
            if (r2 == r4) goto L_0x012b
            r4 = 3
            if (r2 == r4) goto L_0x0126
            goto L_0x0134
        L_0x0126:
            android.text.TextUtils$TruncateAt r2 = android.text.TextUtils.TruncateAt.END
            r12.truncateAt = r2
            goto L_0x0134
        L_0x012b:
            android.text.TextUtils$TruncateAt r2 = android.text.TextUtils.TruncateAt.MIDDLE
            r12.truncateAt = r2
            goto L_0x0134
        L_0x0130:
            android.text.TextUtils$TruncateAt r2 = android.text.TextUtils.TruncateAt.START
            r12.truncateAt = r2
        L_0x0134:
            int r2 = com.google.android.material.R$styleable.Chip_chipIconVisible
            boolean r2 = r1.getBoolean(r2, r13)
            r12.setChipIconVisible(r2)
            java.lang.String r2 = "http://schemas.android.com/apk/res-auto"
            if (r7 == 0) goto L_0x015a
            java.lang.String r4 = "chipIconEnabled"
            java.lang.String r4 = r7.getAttributeValue(r2, r4)
            if (r4 == 0) goto L_0x015a
            java.lang.String r4 = "chipIconVisible"
            java.lang.String r4 = r7.getAttributeValue(r2, r4)
            if (r4 != 0) goto L_0x015a
            int r4 = com.google.android.material.R$styleable.Chip_chipIconEnabled
            boolean r4 = r1.getBoolean(r4, r13)
            r12.setChipIconVisible(r4)
        L_0x015a:
            android.content.Context r4 = r12.context
            int r5 = com.google.android.material.R$styleable.Chip_chipIcon
            android.graphics.drawable.Drawable r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable1(r4, r1, r5)
            r12.setChipIcon(r4)
            int r4 = com.google.android.material.R$styleable.Chip_chipIconTint
            boolean r4 = r1.hasValue(r4)
            if (r4 == 0) goto L_0x0178
            android.content.Context r4 = r12.context
            int r5 = com.google.android.material.R$styleable.Chip_chipIconTint
            android.content.res.ColorStateList r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r4, r1, r5)
            r12.setChipIconTint(r4)
        L_0x0178:
            int r4 = com.google.android.material.R$styleable.Chip_chipIconSize
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r4 = r1.getDimension(r4, r5)
            r12.setChipIconSize(r4)
            int r4 = com.google.android.material.R$styleable.Chip_closeIconVisible
            boolean r4 = r1.getBoolean(r4, r13)
            r12.setCloseIconVisible(r4)
            if (r7 == 0) goto L_0x01a7
            java.lang.String r4 = "closeIconEnabled"
            java.lang.String r4 = r7.getAttributeValue(r2, r4)
            if (r4 == 0) goto L_0x01a7
            java.lang.String r4 = "closeIconVisible"
            java.lang.String r4 = r7.getAttributeValue(r2, r4)
            if (r4 != 0) goto L_0x01a7
            int r4 = com.google.android.material.R$styleable.Chip_closeIconEnabled
            boolean r4 = r1.getBoolean(r4, r13)
            r12.setCloseIconVisible(r4)
        L_0x01a7:
            android.content.Context r4 = r12.context
            int r5 = com.google.android.material.R$styleable.Chip_closeIcon
            android.graphics.drawable.Drawable r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable1(r4, r1, r5)
            r12.setCloseIcon(r4)
            android.content.Context r4 = r12.context
            int r5 = com.google.android.material.R$styleable.Chip_closeIconTint
            android.content.res.ColorStateList r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r4, r1, r5)
            r12.setCloseIconTint(r4)
            int r4 = com.google.android.material.R$styleable.Chip_closeIconSize
            float r4 = r1.getDimension(r4, r3)
            r12.setCloseIconSize(r4)
            int r4 = com.google.android.material.R$styleable.Chip_android_checkable
            boolean r4 = r1.getBoolean(r4, r13)
            r12.setCheckable(r4)
            int r4 = com.google.android.material.R$styleable.Chip_checkedIconVisible
            boolean r4 = r1.getBoolean(r4, r13)
            r12.setCheckedIconVisible(r4)
            if (r7 == 0) goto L_0x01f3
            java.lang.String r4 = "checkedIconEnabled"
            java.lang.String r4 = r7.getAttributeValue(r2, r4)
            if (r4 == 0) goto L_0x01f3
            java.lang.String r4 = "checkedIconVisible"
            java.lang.String r2 = r7.getAttributeValue(r2, r4)
            if (r2 != 0) goto L_0x01f3
            int r2 = com.google.android.material.R$styleable.Chip_checkedIconEnabled
            boolean r2 = r1.getBoolean(r2, r13)
            r12.setCheckedIconVisible(r2)
        L_0x01f3:
            android.content.Context r2 = r12.context
            int r4 = com.google.android.material.R$styleable.Chip_checkedIcon
            android.graphics.drawable.Drawable r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getDrawable1(r2, r1, r4)
            r12.setCheckedIcon(r2)
            int r2 = com.google.android.material.R$styleable.Chip_checkedIconTint
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0211
            android.content.Context r2 = r12.context
            int r4 = com.google.android.material.R$styleable.Chip_checkedIconTint
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r2, r1, r4)
            r12.setCheckedIconTint(r2)
        L_0x0211:
            android.content.Context r2 = r12.context
            int r4 = com.google.android.material.R$styleable.Chip_showMotionSpec
            com.google.android.material.animation.MotionSpec r2 = com.google.android.material.animation.MotionSpec.createFromAttribute(r2, r1, r4)
            r12.showMotionSpec = r2
            android.content.Context r2 = r12.context
            int r4 = com.google.android.material.R$styleable.Chip_hideMotionSpec
            com.google.android.material.animation.MotionSpec r2 = com.google.android.material.animation.MotionSpec.createFromAttribute(r2, r1, r4)
            r12.hideMotionSpec = r2
            int r2 = com.google.android.material.R$styleable.Chip_chipStartPadding
            float r2 = r1.getDimension(r2, r3)
            r12.setChipStartPadding(r2)
            int r2 = com.google.android.material.R$styleable.Chip_iconStartPadding
            float r2 = r1.getDimension(r2, r3)
            r12.setIconStartPadding(r2)
            int r2 = com.google.android.material.R$styleable.Chip_iconEndPadding
            float r2 = r1.getDimension(r2, r3)
            r12.setIconEndPadding(r2)
            int r2 = com.google.android.material.R$styleable.Chip_textStartPadding
            float r2 = r1.getDimension(r2, r3)
            r12.setTextStartPadding(r2)
            int r2 = com.google.android.material.R$styleable.Chip_textEndPadding
            float r2 = r1.getDimension(r2, r3)
            r12.setTextEndPadding(r2)
            int r2 = com.google.android.material.R$styleable.Chip_closeIconStartPadding
            float r2 = r1.getDimension(r2, r3)
            r12.setCloseIconStartPadding(r2)
            int r2 = com.google.android.material.R$styleable.Chip_closeIconEndPadding
            float r2 = r1.getDimension(r2, r3)
            r12.setCloseIconEndPadding(r2)
            int r2 = com.google.android.material.R$styleable.Chip_chipEndPadding
            float r2 = r1.getDimension(r2, r3)
            r12.setChipEndPadding(r2)
            int r2 = com.google.android.material.R$styleable.Chip_android_maxWidth
            r3 = 2147483647(0x7fffffff, float:NaN)
            int r2 = r1.getDimensionPixelSize(r2, r3)
            r12.maxWidth = r2
            r1.recycle()
            int[] r3 = com.google.android.material.R$styleable.Chip
            int r5 = DEF_STYLE_RES
            int[] r6 = new int[r13]
            r1 = r9
            r2 = r16
            r4 = r17
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R$styleable.Chip_ensureMinTouchTargetSize
            boolean r2 = r1.getBoolean(r2, r13)
            r0.ensureMinTouchTargetSize = r2
            android.content.Context r2 = r14.getContext()
            r3 = 48
            float r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.dpToPx(r2, r3)
            double r2 = (double) r2
            double r2 = java.lang.Math.ceil(r2)
            float r2 = (float) r2
            int r3 = com.google.android.material.R$styleable.Chip_chipMinTouchTargetSize
            float r2 = r1.getDimension(r3, r2)
            double r2 = (double) r2
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            r0.minTouchTargetSize = r2
            r1.recycle()
            r14.setChipDrawable(r12)
            float r1 = androidx.core.view.ViewCompat.getElevation(r14)
            r12.setElevation(r1)
            int[] r3 = com.google.android.material.R$styleable.Chip
            int r5 = DEF_STYLE_RES
            int[] r6 = new int[r13]
            r1 = r9
            r2 = r16
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 >= r3) goto L_0x02d9
            int r2 = com.google.android.material.R$styleable.Chip_android_textColor
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r9, r1, r2)
            r14.setTextColor(r2)
        L_0x02d9:
            int r2 = com.google.android.material.R$styleable.Chip_shapeAppearance
            boolean r2 = r1.hasValue(r2)
            r1.recycle()
            com.google.android.material.chip.Chip$ChipTouchHelper r1 = new com.google.android.material.chip.Chip$ChipTouchHelper
            r1.<init>(r14)
            r0.touchHelper = r1
            r14.updateAccessibilityDelegate()
            if (r2 != 0) goto L_0x02f6
            com.google.android.material.chip.Chip$2 r1 = new com.google.android.material.chip.Chip$2
            r1.<init>()
            r14.setOutlineProvider(r1)
        L_0x02f6:
            boolean r1 = r0.deferredCheckedValue
            r14.setChecked(r1)
            java.lang.CharSequence r1 = r12.text
            r14.setText(r1)
            android.text.TextUtils$TruncateAt r1 = r12.truncateAt
            r14.setEllipsize(r1)
            r14.updateTextPaintDrawState()
            com.google.android.material.chip.ChipDrawable r1 = r0.chipDrawable
            boolean r1 = r1.shouldDrawText
            if (r1 != 0) goto L_0x0314
            r14.setLines(r11)
            r14.setHorizontallyScrolling(r11)
        L_0x0314:
            r14.setGravity(r10)
            r14.updatePaddingInternal()
            boolean r1 = r0.ensureMinTouchTargetSize
            if (r1 == 0) goto L_0x0323
            int r1 = r0.minTouchTargetSize
            r14.setMinHeight(r1)
        L_0x0323:
            int r1 = r14.getLayoutDirection()
            r0.lastLayoutDirection = r1
            return
        L_0x032a:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Chip does not support multi-line text"
            r1.<init>(r2)
            throw r1
        L_0x0332:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            r1.<init>(r3)
            throw r1
        L_0x0338:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            r1.<init>(r3)
            throw r1
        L_0x033e:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Please set start drawable using R.attr#chipIcon."
            r1.<init>(r2)
            throw r1
        L_0x0346:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Please set left drawable using R.attr#chipIcon."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCloseIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconVisible(z);
        }
        updateAccessibilityDelegate();
    }

    public void setCheckedIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconVisible(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconVisible(z);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.textDrawableHelper.setTextAppearance(new TextAppearance(chipDrawable2.context, i), chipDrawable2.context);
        }
        updateTextPaintDrawState();
    }

    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.textDrawableHelper.setTextAppearance(new TextAppearance(chipDrawable2.context, i), chipDrawable2.context);
        }
        updateTextPaintDrawState();
    }
}
