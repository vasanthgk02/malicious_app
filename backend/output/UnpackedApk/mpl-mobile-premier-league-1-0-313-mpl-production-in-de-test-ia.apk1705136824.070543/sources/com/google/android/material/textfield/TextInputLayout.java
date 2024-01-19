package com.google.android.material.textfield;

import a.a.a.a.d.b;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.customview.view.AbsSavedState;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout {
    public static final int DEF_STYLE_RES = R$style.Widget_Design_TextInputLayout;
    public ValueAnimator animator;
    public MaterialShapeDrawable boxBackground;
    public int boxBackgroundColor;
    public int boxBackgroundMode;
    public int boxCollapsedPaddingTopPx;
    public int boxLabelCutoutHeight;
    public final int boxLabelCutoutPaddingPx;
    public int boxStrokeColor;
    public int boxStrokeWidthDefaultPx;
    public int boxStrokeWidthFocusedPx;
    public int boxStrokeWidthPx;
    public MaterialShapeDrawable boxUnderline;
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean counterEnabled;
    public int counterMaxLength;
    public int counterOverflowTextAppearance;
    public ColorStateList counterOverflowTextColor;
    public boolean counterOverflowed;
    public int counterTextAppearance;
    public ColorStateList counterTextColor;
    public TextView counterView;
    public int defaultFilledBackgroundColor;
    public ColorStateList defaultHintTextColor;
    public int defaultStrokeColor;
    public int disabledColor;
    public int disabledFilledBackgroundColor;
    public EditText editText;
    public final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    public Drawable endDummyDrawable;
    public int endDummyDrawableWidth;
    public final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    public final SparseArray<EndIconDelegate> endIconDelegates;
    public final FrameLayout endIconFrame;
    public int endIconMode;
    public OnLongClickListener endIconOnLongClickListener;
    public ColorStateList endIconTintList;
    public Mode endIconTintMode;
    public final CheckableImageButton endIconView;
    public final LinearLayout endLayout;
    public OnLongClickListener errorIconOnLongClickListener;
    public ColorStateList errorIconTintList;
    public final CheckableImageButton errorIconView;
    public boolean expandedHintEnabled;
    public int focusedFilledBackgroundColor;
    public int focusedStrokeColor;
    public ColorStateList focusedTextColor;
    public boolean hasEndIconTintList;
    public boolean hasEndIconTintMode;
    public boolean hasStartIconTintList;
    public boolean hasStartIconTintMode;
    public CharSequence hint;
    public boolean hintAnimationEnabled;
    public boolean hintEnabled;
    public boolean hintExpanded;
    public int hoveredFilledBackgroundColor;
    public int hoveredStrokeColor;
    public boolean inDrawableStateChanged;
    public final IndicatorViewController indicatorViewController;
    public final FrameLayout inputFrame;
    public boolean isProvidingHint;
    public int maxWidth;
    public int minWidth;
    public Drawable originalEditTextEndDrawable;
    public CharSequence originalHint;
    public boolean placeholderEnabled;
    public CharSequence placeholderText;
    public int placeholderTextAppearance;
    public ColorStateList placeholderTextColor;
    public TextView placeholderTextView;
    public CharSequence prefixText;
    public final TextView prefixTextView;
    public boolean restoringSavedState;
    public ShapeAppearanceModel shapeAppearanceModel;
    public Drawable startDummyDrawable;
    public int startDummyDrawableWidth;
    public OnLongClickListener startIconOnLongClickListener;
    public ColorStateList startIconTintList;
    public Mode startIconTintMode;
    public final CheckableImageButton startIconView;
    public final LinearLayout startLayout;
    public ColorStateList strokeErrorColor;
    public CharSequence suffixText;
    public final TextView suffixTextView;
    public final Rect tmpBoundsRect;
    public final Rect tmpRect;
    public final RectF tmpRectF;
    public Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
            EditText editText = this.layout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.layout.hintExpanded;
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.mInfo.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.mInfo.setText(charSequence);
                if (z3 && placeholderText != null) {
                    accessibilityNodeInfoCompat.mInfo.setText(charSequence + ", " + placeholderText);
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.mInfo.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (z) {
                        charSequence = text + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.mInfo.setText(charSequence);
                }
                boolean z6 = !z;
                if (VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.mInfo.setShowingHintText(z6);
                } else {
                    accessibilityNodeInfoCompat.setBooleanProperty(4, z6);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.mInfo.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.mInfo.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R$id.textinput_helper_text);
            }
        }
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout textInputLayout, int i);
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
        public CharSequence error;
        public CharSequence helperText;
        public CharSequence hintText;
        public boolean isEndIconChecked;
        public CharSequence placeholderText;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("TextInputLayout.SavedState{");
            outline73.append(Integer.toHexString(System.identityHashCode(this)));
            outline73.append(" error=");
            outline73.append(this.error);
            outline73.append(" hint=");
            outline73.append(this.hintText);
            outline73.append(" helperText=");
            outline73.append(this.helperText);
            outline73.append(" placeholderText=");
            outline73.append(this.placeholderText);
            outline73.append("}");
            return outline73.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, i);
            TextUtils.writeToParcel(this.helperText, parcel, i);
            TextUtils.writeToParcel(this.placeholderText, parcel, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() != 1 ? false : true;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate endIconDelegate = this.endIconDelegates.get(this.endIconMode);
        return endIconDelegate != null ? endIconDelegate : this.endIconDelegates.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (!hasEndIcon() || !isEndIconVisible()) {
            return null;
        }
        return this.endIconView;
    }

    public static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (this.endIconMode != 3) {
                boolean z = editText2 instanceof TextInputEditText;
            }
            this.editText = editText2;
            setMinWidth(this.minWidth);
            setMaxWidth(this.maxWidth);
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            float textSize = this.editText.getTextSize();
            if (collapsingTextHelper2.expandedTextSize != textSize) {
                collapsingTextHelper2.expandedTextSize = textSize;
                collapsingTextHelper2.recalculate(false);
            }
            int gravity = this.editText.getGravity();
            this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
            this.collapsingTextHelper.setExpandedTextGravity(gravity);
            this.editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState, false);
                    TextInputLayout textInputLayout2 = TextInputLayout.this;
                    if (textInputLayout2.counterEnabled) {
                        textInputLayout2.updateCounter(editable.length());
                    }
                    TextInputLayout textInputLayout3 = TextInputLayout.this;
                    if (textInputLayout3.placeholderEnabled) {
                        textInputLayout3.updatePlaceholderText(editable.length());
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    CharSequence hint2 = this.editText.getHint();
                    this.originalHint = hint2;
                    setHint(hint2);
                    this.editText.setHint(null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startLayout.bringToFront();
            this.endLayout.bringToFront();
            this.endIconFrame.bringToFront();
            this.errorIconView.bringToFront();
            Iterator it = this.editTextAttachedListeners.iterator();
            while (it.hasNext()) {
                ((OnEditTextAttachedListener) it.next()).onEditTextAttached(this);
            }
            updatePrefixTextViewPadding();
            updateSuffixTextViewPadding();
            if (!isEnabled()) {
                editText2.setEnabled(false);
            }
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z) {
        int i = 0;
        this.errorIconView.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.endIconFrame;
        if (z) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        updateSuffixTextViewPadding();
        if (!hasEndIcon()) {
            updateDummyDrawables();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.collapsingTextHelper.setText(charSequence);
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    public static void setIconClickable(CheckableImageButton checkableImageButton, OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z = false;
        int i = 1;
        boolean z2 = onLongClickListener != null;
        if (hasOnClickListeners || z2) {
            z = true;
        }
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        if (!z) {
            i = 2;
        }
        checkableImageButton.setImportantForAccessibility(i);
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.placeholderEnabled != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.placeholderTextView = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_placeholder);
                ViewCompat.setAccessibilityLiveRegion(this.placeholderTextView, 1);
                setPlaceholderTextAppearance(this.placeholderTextAppearance);
                setPlaceholderTextColor(this.placeholderTextColor);
                TextView textView = this.placeholderTextView;
                if (textView != null) {
                    this.inputFrame.addView(textView);
                    this.placeholderTextView.setVisibility(0);
                }
            } else {
                TextView textView2 = this.placeholderTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                this.placeholderTextView = null;
            }
            this.placeholderEnabled = z;
        }
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void animateToExpansionFraction(float f2) {
        if (this.collapsingTextHelper.expandedFraction != f2) {
            if (this.animator == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.animator = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.animator.setDuration(167);
                this.animator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(new float[]{this.collapsingTextHelper.expandedFraction, f2});
            this.animator.start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void applyBoxAttributes() {
        /*
            r6 = this;
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.boxBackground
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.google.android.material.shape.ShapeAppearanceModel r1 = r6.shapeAppearanceModel
            r0.setShapeAppearanceModel(r1)
            int r0 = r6.boxBackgroundMode
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L_0x0021
            int r0 = r6.boxStrokeWidthPx
            if (r0 <= r2) goto L_0x001c
            int r0 = r6.boxStrokeColor
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 == 0) goto L_0x0021
            r0 = 1
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x002e
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.boxBackground
            int r1 = r6.boxStrokeWidthPx
            float r1 = (float) r1
            int r5 = r6.boxStrokeColor
            r0.setStroke(r1, r5)
        L_0x002e:
            int r0 = r6.boxBackgroundColor
            int r1 = r6.boxBackgroundMode
            if (r1 != r4) goto L_0x0044
            int r0 = com.google.android.material.R$attr.colorSurface
            android.content.Context r1 = r6.getContext()
            int r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColor(r1, r0, r3)
            int r1 = r6.boxBackgroundColor
            int r0 = androidx.core.graphics.ColorUtils.compositeColors(r1, r0)
        L_0x0044:
            r6.boxBackgroundColor = r0
            com.google.android.material.shape.MaterialShapeDrawable r1 = r6.boxBackground
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.setFillColor(r0)
            int r0 = r6.endIconMode
            r1 = 3
            if (r0 != r1) goto L_0x005d
            android.widget.EditText r0 = r6.editText
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            r0.invalidateSelf()
        L_0x005d:
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.boxUnderline
            if (r0 != 0) goto L_0x0062
            goto L_0x007b
        L_0x0062:
            int r0 = r6.boxStrokeWidthPx
            if (r0 <= r2) goto L_0x006b
            int r0 = r6.boxStrokeColor
            if (r0 == 0) goto L_0x006b
            r3 = 1
        L_0x006b:
            if (r3 == 0) goto L_0x0078
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.boxUnderline
            int r1 = r6.boxStrokeColor
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.setFillColor(r1)
        L_0x0078:
            r6.invalidate()
        L_0x007b:
            r6.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.applyBoxAttributes():void");
    }

    public final void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    public final void applyIconTint(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = b.wrap(drawable).mutate();
            if (z) {
                drawable.setTintList(colorStateList);
            }
            if (z2) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public final int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        if (i == 0 || i == 1) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else if (i != 2) {
            return 0;
        } else {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    public final boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.originalHint != null) {
            boolean z = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint2 = editText2.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
            } finally {
                this.editText.setHint(hint2);
                this.isProvidingHint = z;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i);
            onProvideAutofillVirtualStructure(viewStructure, i);
            viewStructure.setChildCount(this.inputFrame.getChildCount());
            for (int i2 = 0; i2 < this.inputFrame.getChildCount(); i2++) {
                View childAt = this.inputFrame.getChildAt(i2);
                ViewStructure newChild = viewStructure.newChild(i2);
                childAt.dispatchProvideAutofillStructure(newChild, i);
                if (childAt == this.editText) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        if (!this.inDrawableStateChanged) {
            boolean z = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            boolean state = collapsingTextHelper2 != null ? collapsingTextHelper2.setState(drawableState) | false : false;
            if (this.editText != null) {
                if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                    z = false;
                }
                updateLabelState(z, false);
            }
            updateEditTextBackground();
            updateTextInputBoxState();
            if (state) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    public int getBaseline() {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            return super.getBaseline();
        }
        return calculateLabelMarginTop() + getPaddingTop() + editText2.getBaseline();
    }

    public MaterialShapeDrawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public float getBoxCornerRadiusBottomEnd() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        return materialShapeDrawable.drawableState.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
    }

    public float getBoxCornerRadiusBottomStart() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        return materialShapeDrawable.drawableState.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
    }

    public float getBoxCornerRadiusTopEnd() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        return materialShapeDrawable.drawableState.shapeAppearanceModel.topRightCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    public CharSequence getCounterOverflowDescription() {
        if (this.counterEnabled && this.counterOverflowed) {
            TextView textView = this.counterView;
            if (textView != null) {
                return textView.getContentDescription();
            }
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    public CharSequence getError() {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        if (indicatorViewController2.errorEnabled) {
            return indicatorViewController2.errorText;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.errorViewContentDescription;
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public CharSequence getHelperText() {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        if (indicatorViewController2.helperTextEnabled) {
            return indicatorViewController2.helperText;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.indicatorViewController.helperTextView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public final int getLabelLeftBoundAlightWithPrefix(int i, boolean z) {
        int compoundPaddingLeft = this.editText.getCompoundPaddingLeft() + i;
        return (this.prefixText == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    }

    public final int getLabelRightBoundAlignedWithSuffix(int i, boolean z) {
        int compoundPaddingRight = i - this.editText.getCompoundPaddingRight();
        return (this.prefixText == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.prefixTextView.getMeasuredWidth() - this.prefixTextView.getPaddingRight());
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public final boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public final void onApplyBoxBackgroundMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
        } else if (i == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderline = new MaterialShapeDrawable();
        } else if (i == 2) {
            if (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
            }
            this.boxUnderline = null;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline57(new StringBuilder(), this.boxBackgroundMode, " is illegal; only @BoxBackgroundMode constants are supported."));
        }
        EditText editText2 = this.editText;
        if ((editText2 == null || this.boxBackground == null || editText2.getBackground() != null || this.boxBackgroundMode == 0) ? false : true) {
            ViewCompat.setBackground(this.editText, this.boxBackground);
        }
        updateTextInputBoxState();
        if (this.boxBackgroundMode == 1) {
            if (ImageOriginUtils.isFontScaleAtLeast2_0(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (ImageOriginUtils.isFontScaleAtLeast1_3(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.editText != null && this.boxBackgroundMode == 1) {
            if (ImageOriginUtils.isFontScaleAtLeast2_0(getContext())) {
                EditText editText3 = this.editText;
                editText3.setPaddingRelative(ViewCompat.getPaddingStart(editText3), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (ImageOriginUtils.isFontScaleAtLeast1_3(getContext())) {
                EditText editText4 = this.editText;
                editText4.setPaddingRelative(ViewCompat.getPaddingStart(editText4), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText2, rect);
            MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
            if (materialShapeDrawable != null) {
                int i7 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, i7 - this.boxStrokeWidthFocusedPx, rect.right, i7);
            }
            if (this.hintEnabled) {
                CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                float textSize = this.editText.getTextSize();
                if (collapsingTextHelper2.expandedTextSize != textSize) {
                    collapsingTextHelper2.expandedTextSize = textSize;
                    collapsingTextHelper2.recalculate(false);
                }
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                CollapsingTextHelper collapsingTextHelper3 = this.collapsingTextHelper;
                if (this.editText != null) {
                    Rect rect2 = this.tmpBoundsRect;
                    boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
                    rect2.bottom = rect.bottom;
                    int i8 = this.boxBackgroundMode;
                    if (i8 == 1) {
                        rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z2);
                        rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                        rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z2);
                    } else if (i8 != 2) {
                        rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z2);
                        rect2.top = getPaddingTop();
                        rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z2);
                    } else {
                        rect2.left = this.editText.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - calculateLabelMarginTop();
                        rect2.right = rect.right - this.editText.getPaddingRight();
                    }
                    if (collapsingTextHelper3 != null) {
                        int i9 = rect2.left;
                        int i10 = rect2.top;
                        int i11 = rect2.right;
                        int i12 = rect2.bottom;
                        if (!CollapsingTextHelper.rectEquals(collapsingTextHelper3.collapsedBounds, i9, i10, i11, i12)) {
                            collapsingTextHelper3.collapsedBounds.set(i9, i10, i11, i12);
                            collapsingTextHelper3.boundsChanged = true;
                            collapsingTextHelper3.onBoundsChanged();
                        }
                        CollapsingTextHelper collapsingTextHelper4 = this.collapsingTextHelper;
                        if (this.editText != null) {
                            Rect rect3 = this.tmpBoundsRect;
                            TextPaint textPaint = collapsingTextHelper4.tmpPaint;
                            textPaint.setTextSize(collapsingTextHelper4.expandedTextSize);
                            textPaint.setTypeface(collapsingTextHelper4.expandedTypeface);
                            textPaint.setLetterSpacing(collapsingTextHelper4.expandedLetterSpacing);
                            float f2 = -collapsingTextHelper4.tmpPaint.ascent();
                            rect3.left = this.editText.getCompoundPaddingLeft() + rect.left;
                            if (this.boxBackgroundMode == 1 && this.editText.getMinLines() <= 1) {
                                i5 = (int) (((float) rect.centerY()) - (f2 / 2.0f));
                            } else {
                                i5 = rect.top + this.editText.getCompoundPaddingTop();
                            }
                            rect3.top = i5;
                            rect3.right = rect.right - this.editText.getCompoundPaddingRight();
                            if (this.boxBackgroundMode == 1 && this.editText.getMinLines() <= 1) {
                                i6 = (int) (((float) rect3.top) + f2);
                            } else {
                                i6 = rect.bottom - this.editText.getCompoundPaddingBottom();
                            }
                            rect3.bottom = i6;
                            int i13 = rect3.left;
                            int i14 = rect3.top;
                            int i15 = rect3.right;
                            if (!CollapsingTextHelper.rectEquals(collapsingTextHelper4.expandedBounds, i13, i14, i15, i6)) {
                                collapsingTextHelper4.expandedBounds.set(i13, i14, i15, i6);
                                collapsingTextHelper4.boundsChanged = true;
                                collapsingTextHelper4.onBoundsChanged();
                            }
                            this.collapsingTextHelper.recalculate(false);
                            if (cutoutEnabled() && !this.hintExpanded) {
                                openCutout();
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException();
                    }
                    throw null;
                }
                throw new IllegalStateException();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean z = false;
        if (this.editText != null) {
            int max = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight());
            if (this.editText.getMeasuredHeight() < max) {
                this.editText.setMinimumHeight(max);
                z = true;
            }
        }
        boolean updateDummyDrawables = updateDummyDrawables();
        if (z || updateDummyDrawables) {
            this.editText.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.editText.requestLayout();
                }
            });
        }
        if (this.placeholderTextView != null) {
            EditText editText2 = this.editText;
            if (editText2 != null) {
                this.placeholderTextView.setGravity(editText2.getGravity());
                this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
            }
        }
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.endIconView.performClick();
                    TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = hasEndIcon() && this.endIconView.isChecked();
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void openCutout() {
        /*
            r12 = this;
            boolean r0 = r12.cutoutEnabled()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.graphics.RectF r0 = r12.tmpRectF
            com.google.android.material.internal.CollapsingTextHelper r1 = r12.collapsingTextHelper
            android.widget.EditText r2 = r12.editText
            int r2 = r2.getWidth()
            android.widget.EditText r3 = r12.editText
            int r3 = r3.getGravity()
            java.lang.CharSequence r4 = r1.text
            boolean r4 = r1.calculateIsRtl(r4)
            r1.isRtl = r4
            r5 = 8388613(0x800005, float:1.175495E-38)
            r6 = 1
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 17
            r9 = 5
            if (r3 == r8) goto L_0x005d
            r10 = r3 & 7
            if (r10 != r6) goto L_0x002f
            goto L_0x005d
        L_0x002f:
            r10 = r3 & r5
            if (r10 == r5) goto L_0x0049
            r10 = r3 & 5
            if (r10 != r9) goto L_0x0038
            goto L_0x0049
        L_0x0038:
            if (r4 == 0) goto L_0x0044
            android.graphics.Rect r4 = r1.collapsedBounds
            int r4 = r4.right
            float r4 = (float) r4
            float r10 = r1.calculateCollapsedTextWidth()
            goto L_0x0064
        L_0x0044:
            android.graphics.Rect r4 = r1.collapsedBounds
            int r4 = r4.left
            goto L_0x0051
        L_0x0049:
            boolean r4 = r1.isRtl
            if (r4 == 0) goto L_0x0053
            android.graphics.Rect r4 = r1.collapsedBounds
            int r4 = r4.left
        L_0x0051:
            float r4 = (float) r4
            goto L_0x0065
        L_0x0053:
            android.graphics.Rect r4 = r1.collapsedBounds
            int r4 = r4.right
            float r4 = (float) r4
            float r10 = r1.calculateCollapsedTextWidth()
            goto L_0x0064
        L_0x005d:
            float r4 = (float) r2
            float r4 = r4 / r7
            float r10 = r1.calculateCollapsedTextWidth()
            float r10 = r10 / r7
        L_0x0064:
            float r4 = r4 - r10
        L_0x0065:
            r0.left = r4
            android.graphics.Rect r10 = r1.collapsedBounds
            int r11 = r10.top
            float r11 = (float) r11
            r0.top = r11
            if (r3 == r8) goto L_0x009c
            r8 = r3 & 7
            if (r8 != r6) goto L_0x0075
            goto L_0x009c
        L_0x0075:
            r2 = r3 & r5
            if (r2 == r5) goto L_0x008b
            r2 = r3 & 5
            if (r2 != r9) goto L_0x007e
            goto L_0x008b
        L_0x007e:
            boolean r2 = r1.isRtl
            if (r2 == 0) goto L_0x0085
            int r2 = r10.right
            goto L_0x009a
        L_0x0085:
            float r2 = r1.calculateCollapsedTextWidth()
            float r2 = r2 + r4
            goto L_0x00a4
        L_0x008b:
            boolean r2 = r1.isRtl
            if (r2 == 0) goto L_0x0096
            float r2 = r0.left
            float r3 = r1.calculateCollapsedTextWidth()
            goto L_0x00a3
        L_0x0096:
            android.graphics.Rect r2 = r1.collapsedBounds
            int r2 = r2.right
        L_0x009a:
            float r2 = (float) r2
            goto L_0x00a4
        L_0x009c:
            float r2 = (float) r2
            float r2 = r2 / r7
            float r3 = r1.calculateCollapsedTextWidth()
            float r3 = r3 / r7
        L_0x00a3:
            float r2 = r2 + r3
        L_0x00a4:
            r0.right = r2
            android.graphics.Rect r2 = r1.collapsedBounds
            int r2 = r2.top
            float r2 = (float) r2
            float r1 = r1.getCollapsedTextHeight()
            float r1 = r1 + r2
            r0.bottom = r1
            float r1 = r0.left
            int r2 = r12.boxLabelCutoutPaddingPx
            float r2 = (float) r2
            float r1 = r1 - r2
            r0.left = r1
            float r1 = r0.right
            float r1 = r1 + r2
            r0.right = r1
            int r1 = r12.boxStrokeWidthPx
            r12.boxLabelCutoutHeight = r1
            r2 = 0
            r0.top = r2
            float r1 = (float) r1
            r0.bottom = r1
            int r1 = r12.getPaddingLeft()
            int r1 = -r1
            float r1 = (float) r1
            r0.offset(r1, r2)
            com.google.android.material.shape.MaterialShapeDrawable r1 = r12.boxBackground
            com.google.android.material.textfield.CutoutDrawable r1 = (com.google.android.material.textfield.CutoutDrawable) r1
            if (r1 == 0) goto L_0x00e4
            float r2 = r0.left
            float r3 = r0.top
            float r4 = r0.right
            float r0 = r0.bottom
            r1.setCutout(r2, r3, r4, r0)
            return
        L_0x00e4:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.openCutout():void");
    }

    public void refreshEndIconDrawableState() {
        refreshIconDrawableState(this.endIconView, this.endIconTintList);
    }

    public final void refreshIconDrawableState(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int[] drawableState = getDrawableState();
            int[] drawableState2 = checkableImageButton.getDrawableState();
            int length = drawableState.length;
            int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
            System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
            int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
            Drawable mutate = b.wrap(drawable).mutate();
            mutate.setTintList(ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            this.focusedFilledBackgroundColor = i;
            this.hoveredFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.boxBackgroundMode) {
            this.boxBackgroundMode = i;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.boxStrokeWidthDefaultPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.boxStrokeWidthFocusedPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.counterView = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.counterView.setTypeface(typeface2);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                ((MarginLayoutParams) this.counterView.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false, false);
        }
    }

    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        this.endIconMode = i;
        Iterator it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            ((OnEndIconChangedListener) it.next()).onEndIconChanged(this, i2);
        }
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            applyEndIconTint();
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("The current box background mode ");
        outline73.append(this.boxBackgroundMode);
        outline73.append(" is not supported by the end icon mode ");
        outline73.append(i);
        throw new IllegalStateException(outline73.toString());
    }

    public void setEndIconOnClickListener(OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.endIconView;
        OnLongClickListener onLongClickListener = this.endIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 8);
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.errorEnabled) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            IndicatorViewController indicatorViewController2 = this.indicatorViewController;
            indicatorViewController2.cancelCaptionAnimator();
            indicatorViewController2.errorText = charSequence;
            indicatorViewController2.errorView.setText(charSequence);
            if (indicatorViewController2.captionDisplayed != 1) {
                indicatorViewController2.captionToShow = 1;
            }
            indicatorViewController2.updateCaptionViewsVisibility(indicatorViewController2.captionDisplayed, indicatorViewController2.captionToShow, indicatorViewController2.shouldAnimateCaptionView(indicatorViewController2.errorView, charSequence));
        } else {
            this.indicatorViewController.hideError();
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.errorViewContentDescription = charSequence;
        TextView textView = indicatorViewController2.errorView;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        if (indicatorViewController2.errorEnabled != z) {
            indicatorViewController2.cancelCaptionAnimator();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController2.context);
                indicatorViewController2.errorView = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_error);
                indicatorViewController2.errorView.setTextAlignment(5);
                Typeface typeface2 = indicatorViewController2.typeface;
                if (typeface2 != null) {
                    indicatorViewController2.errorView.setTypeface(typeface2);
                }
                int i = indicatorViewController2.errorTextAppearance;
                indicatorViewController2.errorTextAppearance = i;
                TextView textView = indicatorViewController2.errorView;
                if (textView != null) {
                    indicatorViewController2.textInputView.setTextAppearanceCompatWithErrorFallback(textView, i);
                }
                ColorStateList colorStateList = indicatorViewController2.errorViewTextColor;
                indicatorViewController2.errorViewTextColor = colorStateList;
                TextView textView2 = indicatorViewController2.errorView;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                CharSequence charSequence = indicatorViewController2.errorViewContentDescription;
                indicatorViewController2.errorViewContentDescription = charSequence;
                TextView textView3 = indicatorViewController2.errorView;
                if (textView3 != null) {
                    textView3.setContentDescription(charSequence);
                }
                indicatorViewController2.errorView.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(indicatorViewController2.errorView, 1);
                indicatorViewController2.addIndicator(indicatorViewController2.errorView, 0);
            } else {
                indicatorViewController2.hideError();
                indicatorViewController2.removeIndicator(indicatorViewController2.errorView, 0);
                indicatorViewController2.errorView = null;
                indicatorViewController2.textInputView.updateEditTextBackground();
                indicatorViewController2.textInputView.updateTextInputBoxState();
            }
            indicatorViewController2.errorEnabled = z;
        }
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
        refreshIconDrawableState(this.errorIconView, this.errorIconTintList);
    }

    public void setErrorIconOnClickListener(OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.errorIconView;
        OnLongClickListener onLongClickListener = this.errorIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.errorIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.errorIconTintList = colorStateList;
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = b.wrap(drawable).mutate();
            drawable.setTintList(colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(Mode mode) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = b.wrap(drawable).mutate();
            drawable.setTintMode(mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.errorTextAppearance = i;
        TextView textView = indicatorViewController2.errorView;
        if (textView != null) {
            indicatorViewController2.textInputView.setTextAppearanceCompatWithErrorFallback(textView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.errorViewTextColor = colorStateList;
        TextView textView = indicatorViewController2.errorView;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.expandedHintEnabled != z) {
            this.expandedHintEnabled = z;
            updateLabelState(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.indicatorViewController.helperTextEnabled) {
                setHelperTextEnabled(true);
            }
            IndicatorViewController indicatorViewController2 = this.indicatorViewController;
            indicatorViewController2.cancelCaptionAnimator();
            indicatorViewController2.helperText = charSequence;
            indicatorViewController2.helperTextView.setText(charSequence);
            if (indicatorViewController2.captionDisplayed != 2) {
                indicatorViewController2.captionToShow = 2;
            }
            indicatorViewController2.updateCaptionViewsVisibility(indicatorViewController2.captionDisplayed, indicatorViewController2.captionToShow, indicatorViewController2.shouldAnimateCaptionView(indicatorViewController2.helperTextView, charSequence));
        } else if (this.indicatorViewController.helperTextEnabled) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.helperTextViewTextColor = colorStateList;
        TextView textView = indicatorViewController2.helperTextView;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        if (indicatorViewController2.helperTextEnabled != z) {
            indicatorViewController2.cancelCaptionAnimator();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController2.context);
                indicatorViewController2.helperTextView = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_helper_text);
                indicatorViewController2.helperTextView.setTextAlignment(5);
                Typeface typeface2 = indicatorViewController2.typeface;
                if (typeface2 != null) {
                    indicatorViewController2.helperTextView.setTypeface(typeface2);
                }
                indicatorViewController2.helperTextView.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(indicatorViewController2.helperTextView, 1);
                int i = indicatorViewController2.helperTextTextAppearance;
                indicatorViewController2.helperTextTextAppearance = i;
                TextView textView = indicatorViewController2.helperTextView;
                if (textView != null) {
                    CompoundButtonCompat.setTextAppearance(textView, i);
                }
                ColorStateList colorStateList = indicatorViewController2.helperTextViewTextColor;
                indicatorViewController2.helperTextViewTextColor = colorStateList;
                TextView textView2 = indicatorViewController2.helperTextView;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                indicatorViewController2.addIndicator(indicatorViewController2.helperTextView, 1);
            } else {
                indicatorViewController2.cancelCaptionAnimator();
                if (indicatorViewController2.captionDisplayed == 2) {
                    indicatorViewController2.captionToShow = 0;
                }
                indicatorViewController2.updateCaptionViewsVisibility(indicatorViewController2.captionDisplayed, indicatorViewController2.captionToShow, indicatorViewController2.shouldAnimateCaptionView(indicatorViewController2.helperTextView, null));
                indicatorViewController2.removeIndicator(indicatorViewController2.helperTextView, 1);
                indicatorViewController2.helperTextView = null;
                indicatorViewController2.textInputView.updateEditTextBackground();
                indicatorViewController2.textInputView.updateTextInputBoxState();
            }
            indicatorViewController2.helperTextEnabled = z;
        }
    }

    public void setHelperTextTextAppearance(int i) {
        IndicatorViewController indicatorViewController2 = this.indicatorViewController;
        indicatorViewController2.helperTextTextAppearance = i;
        TextView textView = indicatorViewController2.helperTextView;
        if (textView != null) {
            CompoundButtonCompat.setTextAppearance(textView, i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!z) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint(null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i);
        this.focusedTextColor = this.collapsingTextHelper.collapsedTextColor;
        if (this.editText != null) {
            updateLabelState(false, false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                if (collapsingTextHelper2.collapsedTextColor != colorStateList) {
                    collapsingTextHelper2.collapsedTextColor = colorStateList;
                    collapsingTextHelper2.recalculate(false);
                }
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false, false);
            }
        }
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
        EditText editText2 = this.editText;
        if (editText2 != null && i != -1) {
            editText2.setMaxWidth(i);
        }
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinWidth(int i) {
        this.minWidth = i;
        EditText editText2 = this.editText;
        if (editText2 != null && i != -1) {
            editText2.setMinWidth(i);
        }
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else if (!z) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        int i = 0;
        if (!this.placeholderEnabled || !TextUtils.isEmpty(charSequence)) {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        EditText editText2 = this.editText;
        if (editText2 != null) {
            i = editText2.getText().length();
        }
        updatePlaceholderText(i);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.placeholderTextAppearance = i;
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            CompoundButtonCompat.setTextAppearance(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            TextView textView = this.placeholderTextView;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.prefixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.prefixTextView.setText(charSequence);
        updatePrefixTextVisibility();
    }

    public void setPrefixTextAppearance(int i) {
        CompoundButtonCompat.setTextAppearance(this.prefixTextView, i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.startIconView;
        OnLongClickListener onLongClickListener = this.startIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.startIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyIconTint(this.startIconView, true, colorStateList, this.hasStartIconTintMode, this.startIconTintMode);
        }
    }

    public void setStartIconTintMode(Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, true, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        int i = 0;
        if ((this.startIconView.getVisibility() == 0) != z) {
            CheckableImageButton checkableImageButton = this.startIconView;
            if (!z) {
                i = 8;
            }
            checkableImageButton.setVisibility(i);
            updatePrefixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.suffixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(int i) {
        CompoundButtonCompat.setTextAppearance(this.suffixTextView, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    public void setTextAppearanceCompatWithErrorFallback(TextView textView, int i) {
        boolean z = true;
        try {
            CompoundButtonCompat.setTextAppearance(textView, i);
            if (VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception unused) {
        }
        if (z) {
            CompoundButtonCompat.setTextAppearance(textView, R$style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(ContextCompat.getColor(getContext(), R$color.design_error));
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            ViewCompat.setAccessibilityDelegate(editText2, accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.setTypefaces(typeface2);
            IndicatorViewController indicatorViewController2 = this.indicatorViewController;
            if (typeface2 != indicatorViewController2.typeface) {
                indicatorViewController2.typeface = typeface2;
                TextView textView = indicatorViewController2.errorView;
                if (textView != null) {
                    textView.setTypeface(typeface2);
                }
                TextView textView2 = indicatorViewController2.helperTextView;
                if (textView2 != null) {
                    textView2.setTypeface(typeface2);
                }
            }
            TextView textView3 = this.counterView;
            if (textView3 != null) {
                textView3.setTypeface(typeface2);
            }
        }
    }

    public final void updateCounter() {
        if (this.counterView != null) {
            EditText editText2 = this.editText;
            updateCounter(editText2 == null ? 0 : editText2.getText().length());
        }
    }

    public final void updateCounterTextAppearanceAndColor() {
        TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed) {
                ColorStateList colorStateList = this.counterTextColor;
                if (colorStateList != null) {
                    this.counterView.setTextColor(colorStateList);
                }
            }
            if (this.counterOverflowed) {
                ColorStateList colorStateList2 = this.counterOverflowTextColor;
                if (colorStateList2 != null) {
                    this.counterView.setTextColor(colorStateList2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean updateDummyDrawables() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.editText
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            android.graphics.drawable.Drawable r0 = r10.getStartIconDrawable()
            r2 = 1
            if (r0 != 0) goto L_0x0011
            java.lang.CharSequence r0 = r10.prefixText
            if (r0 == 0) goto L_0x001b
        L_0x0011:
            android.widget.LinearLayout r0 = r10.startLayout
            int r0 = r0.getMeasuredWidth()
            if (r0 <= 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r3 = 0
            r4 = 3
            r5 = 2
            if (r0 == 0) goto L_0x005d
            android.widget.LinearLayout r0 = r10.startLayout
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.startDummyDrawable
            if (r6 == 0) goto L_0x0036
            int r6 = r10.startDummyDrawableWidth
            if (r6 == r0) goto L_0x0042
        L_0x0036:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.startDummyDrawable = r6
            r10.startDummyDrawableWidth = r0
            r6.setBounds(r1, r1, r0, r2)
        L_0x0042:
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = r0.getCompoundDrawablesRelative()
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.startDummyDrawable
            if (r6 == r7) goto L_0x005b
            android.widget.EditText r6 = r10.editText
            r8 = r0[r2]
            r9 = r0[r5]
            r0 = r0[r4]
            r6.setCompoundDrawablesRelative(r7, r8, r9, r0)
        L_0x0059:
            r0 = 1
            goto L_0x0075
        L_0x005b:
            r0 = 0
            goto L_0x0075
        L_0x005d:
            android.graphics.drawable.Drawable r0 = r10.startDummyDrawable
            if (r0 == 0) goto L_0x005b
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = r0.getCompoundDrawablesRelative()
            android.widget.EditText r6 = r10.editText
            r7 = r0[r2]
            r8 = r0[r5]
            r0 = r0[r4]
            r6.setCompoundDrawablesRelative(r3, r7, r8, r0)
            r10.startDummyDrawable = r3
            goto L_0x0059
        L_0x0075:
            com.google.android.material.internal.CheckableImageButton r6 = r10.errorIconView
            int r6 = r6.getVisibility()
            if (r6 == 0) goto L_0x008d
            boolean r6 = r10.hasEndIcon()
            if (r6 == 0) goto L_0x0089
            boolean r6 = r10.isEndIconVisible()
            if (r6 != 0) goto L_0x008d
        L_0x0089:
            java.lang.CharSequence r6 = r10.suffixText
            if (r6 == 0) goto L_0x0097
        L_0x008d:
            android.widget.LinearLayout r6 = r10.endLayout
            int r6 = r6.getMeasuredWidth()
            if (r6 <= 0) goto L_0x0097
            r6 = 1
            goto L_0x0098
        L_0x0097:
            r6 = 0
        L_0x0098:
            if (r6 == 0) goto L_0x0106
            android.widget.TextView r3 = r10.suffixTextView
            int r3 = r3.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingRight()
            int r3 = r3 - r6
            com.google.android.material.internal.CheckableImageButton r6 = r10.getEndIconToUpdateDummyDrawable()
            if (r6 == 0) goto L_0x00bd
            int r7 = r6.getMeasuredWidth()
            int r7 = r7 + r3
            android.view.ViewGroup$LayoutParams r3 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
            int r3 = r3.getMarginStart()
            int r3 = r3 + r7
        L_0x00bd:
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = r6.getCompoundDrawablesRelative()
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r7 == 0) goto L_0x00de
            int r8 = r10.endDummyDrawableWidth
            if (r8 == r3) goto L_0x00de
            r10.endDummyDrawableWidth = r3
            r7.setBounds(r1, r1, r3, r2)
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r3 = r6[r2]
            android.graphics.drawable.Drawable r5 = r10.endDummyDrawable
            r4 = r6[r4]
            r0.setCompoundDrawablesRelative(r1, r3, r5, r4)
            goto L_0x0127
        L_0x00de:
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r7 != 0) goto L_0x00ee
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.endDummyDrawable = r7
            r10.endDummyDrawableWidth = r3
            r7.setBounds(r1, r1, r3, r2)
        L_0x00ee:
            r3 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r3 == r7) goto L_0x0104
            r0 = r6[r5]
            r10.originalEditTextEndDrawable = r0
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r3 = r6[r2]
            r4 = r6[r4]
            r0.setCompoundDrawablesRelative(r1, r3, r7, r4)
            goto L_0x0127
        L_0x0104:
            r2 = r0
            goto L_0x0127
        L_0x0106:
            android.graphics.drawable.Drawable r6 = r10.endDummyDrawable
            if (r6 == 0) goto L_0x0128
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = r6.getCompoundDrawablesRelative()
            r5 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r5 != r7) goto L_0x0124
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r5 = r6[r2]
            android.graphics.drawable.Drawable r7 = r10.originalEditTextEndDrawable
            r4 = r6[r4]
            r0.setCompoundDrawablesRelative(r1, r5, r7, r4)
            goto L_0x0125
        L_0x0124:
            r2 = r0
        L_0x0125:
            r10.endDummyDrawable = r3
        L_0x0127:
            r0 = r2
        L_0x0128:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateDummyDrawables():boolean");
    }

    public void updateEditTextBackground() {
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 0) {
            Drawable background = editText2.getBackground();
            if (background != null) {
                if (DrawableUtils.canSafelyMutateDrawable(background)) {
                    background = background.mutate();
                }
                if (this.indicatorViewController.errorShouldBeShown()) {
                    background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), Mode.SRC_IN));
                } else {
                    if (this.counterOverflowed) {
                        TextView textView = this.counterView;
                        if (textView != null) {
                            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), Mode.SRC_IN));
                        }
                    }
                    b.clearColorFilter(background);
                    this.editText.refreshDrawableState();
                }
            }
        }
    }

    public final void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    public final void updateLabelState(boolean z, boolean z2) {
        boolean isEnabled = isEnabled();
        EditText editText2 = this.editText;
        int i = 0;
        boolean z3 = editText2 != null && !TextUtils.isEmpty(editText2.getText());
        EditText editText3 = this.editText;
        boolean z4 = editText3 != null && editText3.hasFocus();
        boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList = this.defaultHintTextColor;
        if (colorStateList != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            ColorStateList colorStateList2 = this.defaultHintTextColor;
            int colorForState = colorStateList2 != null ? colorStateList2.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(colorForState));
        } else if (errorShouldBeShown) {
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            TextView textView = this.indicatorViewController.errorView;
            collapsingTextHelper2.setCollapsedTextColor(textView != null ? textView.getTextColors() : null);
        } else {
            if (this.counterOverflowed) {
                TextView textView2 = this.counterView;
                if (textView2 != null) {
                    this.collapsingTextHelper.setCollapsedTextColor(textView2.getTextColors());
                }
            }
            if (z4) {
                ColorStateList colorStateList3 = this.focusedTextColor;
                if (colorStateList3 != null) {
                    this.collapsingTextHelper.setCollapsedTextColor(colorStateList3);
                }
            }
        }
        if (z3 || !this.expandedHintEnabled || (isEnabled() && z4)) {
            if (z2 || this.hintExpanded) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.animator.cancel();
                }
                if (!z || !this.hintAnimationEnabled) {
                    this.collapsingTextHelper.setExpansionFraction(1.0f);
                } else {
                    animateToExpansionFraction(1.0f);
                }
                this.hintExpanded = false;
                if (cutoutEnabled()) {
                    openCutout();
                }
                EditText editText4 = this.editText;
                if (editText4 != null) {
                    i = editText4.getText().length();
                }
                updatePlaceholderText(i);
                updatePrefixTextVisibility();
                updateSuffixTextVisibility();
            }
        } else if (z2 || !this.hintExpanded) {
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.animator.cancel();
            }
            if (!z || !this.hintAnimationEnabled) {
                this.collapsingTextHelper.setExpansionFraction(0.0f);
            } else {
                animateToExpansionFraction(0.0f);
            }
            if (cutoutEnabled() && (!((CutoutDrawable) this.boxBackground).cutoutBounds.isEmpty()) && cutoutEnabled()) {
                ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.hintExpanded = true;
            TextView textView3 = this.placeholderTextView;
            if (textView3 != null && this.placeholderEnabled) {
                textView3.setText(null);
                this.placeholderTextView.setVisibility(4);
            }
            updatePrefixTextVisibility();
            updateSuffixTextVisibility();
        }
    }

    public final void updatePlaceholderText(int i) {
        if (i != 0 || this.hintExpanded) {
            TextView textView = this.placeholderTextView;
            if (textView != null && this.placeholderEnabled) {
                textView.setText(null);
                this.placeholderTextView.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView2 = this.placeholderTextView;
        if (textView2 != null && this.placeholderEnabled) {
            textView2.setText(this.placeholderText);
            this.placeholderTextView.setVisibility(0);
            this.placeholderTextView.bringToFront();
        }
    }

    public final void updatePrefixTextViewPadding() {
        if (this.editText != null) {
            int i = 0;
            if (!(this.startIconView.getVisibility() == 0)) {
                i = ViewCompat.getPaddingStart(this.editText);
            }
            ViewCompat.setPaddingRelative(this.prefixTextView, i, this.editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.editText.getCompoundPaddingBottom());
        }
    }

    public final void updatePrefixTextVisibility() {
        this.prefixTextView.setVisibility((this.prefixText == null || this.hintExpanded) ? 8 : 0);
        updateDummyDrawables();
    }

    public final void updateStrokeErrorColor(boolean z, boolean z2) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.boxStrokeColor = colorForState2;
        } else if (z2) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    public final void updateSuffixTextViewPadding() {
        if (this.editText != null) {
            int i = 0;
            if (!isEndIconVisible()) {
                if (!(this.errorIconView.getVisibility() == 0)) {
                    i = ViewCompat.getPaddingEnd(this.editText);
                }
            }
            ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.editText.getPaddingTop(), i, this.editText.getPaddingBottom());
        }
    }

    public final void updateSuffixTextVisibility() {
        int visibility = this.suffixTextView.getVisibility();
        int i = 0;
        boolean z = this.suffixText != null && !this.hintExpanded;
        TextView textView = this.suffixTextView;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
        if (visibility != this.suffixTextView.getVisibility()) {
            getEndIconDelegate().onSuffixVisibilityChanged(z);
        }
        updateDummyDrawables();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateTextInputBoxState() {
        /*
            r6 = this;
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.boxBackground
            if (r0 == 0) goto L_0x013b
            int r0 = r6.boxBackgroundMode
            if (r0 != 0) goto L_0x000a
            goto L_0x013b
        L_0x000a:
            boolean r0 = r6.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001f
            android.widget.EditText r0 = r6.editText
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            boolean r3 = r6.isHovered()
            if (r3 != 0) goto L_0x0033
            android.widget.EditText r3 = r6.editText
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            goto L_0x0034
        L_0x0033:
            r3 = 1
        L_0x0034:
            boolean r4 = r6.isEnabled()
            if (r4 != 0) goto L_0x003f
            int r4 = r6.disabledColor
            r6.boxStrokeColor = r4
            goto L_0x0081
        L_0x003f:
            com.google.android.material.textfield.IndicatorViewController r4 = r6.indicatorViewController
            boolean r4 = r4.errorShouldBeShown()
            if (r4 == 0) goto L_0x0058
            android.content.res.ColorStateList r4 = r6.strokeErrorColor
            if (r4 == 0) goto L_0x004f
            r6.updateStrokeErrorColor(r0, r3)
            goto L_0x0081
        L_0x004f:
            com.google.android.material.textfield.IndicatorViewController r4 = r6.indicatorViewController
            int r4 = r4.getErrorViewCurrentTextColor()
            r6.boxStrokeColor = r4
            goto L_0x0081
        L_0x0058:
            boolean r4 = r6.counterOverflowed
            if (r4 == 0) goto L_0x006f
            android.widget.TextView r4 = r6.counterView
            if (r4 == 0) goto L_0x006f
            android.content.res.ColorStateList r5 = r6.strokeErrorColor
            if (r5 == 0) goto L_0x0068
            r6.updateStrokeErrorColor(r0, r3)
            goto L_0x0081
        L_0x0068:
            int r4 = r4.getCurrentTextColor()
            r6.boxStrokeColor = r4
            goto L_0x0081
        L_0x006f:
            if (r0 == 0) goto L_0x0076
            int r4 = r6.focusedStrokeColor
            r6.boxStrokeColor = r4
            goto L_0x0081
        L_0x0076:
            if (r3 == 0) goto L_0x007d
            int r4 = r6.hoveredStrokeColor
            r6.boxStrokeColor = r4
            goto L_0x0081
        L_0x007d:
            int r4 = r6.defaultStrokeColor
            r6.boxStrokeColor = r4
        L_0x0081:
            android.graphics.drawable.Drawable r4 = r6.getErrorIconDrawable()
            if (r4 == 0) goto L_0x0094
            com.google.android.material.textfield.IndicatorViewController r4 = r6.indicatorViewController
            boolean r5 = r4.errorEnabled
            if (r5 == 0) goto L_0x0094
            boolean r4 = r4.errorShouldBeShown()
            if (r4 == 0) goto L_0x0094
            r1 = 1
        L_0x0094:
            r6.setErrorIconVisible(r1)
            com.google.android.material.internal.CheckableImageButton r1 = r6.errorIconView
            android.content.res.ColorStateList r4 = r6.errorIconTintList
            r6.refreshIconDrawableState(r1, r4)
            com.google.android.material.internal.CheckableImageButton r1 = r6.startIconView
            android.content.res.ColorStateList r4 = r6.startIconTintList
            r6.refreshIconDrawableState(r1, r4)
            r6.refreshEndIconDrawableState()
            com.google.android.material.textfield.EndIconDelegate r1 = r6.getEndIconDelegate()
            boolean r1 = r1.shouldTintIconOnError()
            if (r1 == 0) goto L_0x00de
            com.google.android.material.textfield.IndicatorViewController r1 = r6.indicatorViewController
            boolean r1 = r1.errorShouldBeShown()
            if (r1 == 0) goto L_0x00db
            android.graphics.drawable.Drawable r1 = r6.getEndIconDrawable()
            if (r1 == 0) goto L_0x00db
            android.graphics.drawable.Drawable r1 = r6.getEndIconDrawable()
            android.graphics.drawable.Drawable r1 = a.a.a.a.d.b.wrap(r1)
            android.graphics.drawable.Drawable r1 = r1.mutate()
            com.google.android.material.textfield.IndicatorViewController r4 = r6.indicatorViewController
            int r4 = r4.getErrorViewCurrentTextColor()
            r1.setTint(r4)
            com.google.android.material.internal.CheckableImageButton r4 = r6.endIconView
            r4.setImageDrawable(r1)
            goto L_0x00de
        L_0x00db:
            r6.applyEndIconTint()
        L_0x00de:
            if (r0 == 0) goto L_0x00eb
            boolean r1 = r6.isEnabled()
            if (r1 == 0) goto L_0x00eb
            int r1 = r6.boxStrokeWidthFocusedPx
            r6.boxStrokeWidthPx = r1
            goto L_0x00ef
        L_0x00eb:
            int r1 = r6.boxStrokeWidthDefaultPx
            r6.boxStrokeWidthPx = r1
        L_0x00ef:
            int r1 = r6.boxBackgroundMode
            r4 = 2
            if (r1 != r4) goto L_0x0115
            boolean r1 = r6.cutoutEnabled()
            if (r1 == 0) goto L_0x0115
            boolean r1 = r6.hintExpanded
            if (r1 != 0) goto L_0x0115
            int r1 = r6.boxLabelCutoutHeight
            int r4 = r6.boxStrokeWidthPx
            if (r1 == r4) goto L_0x0115
            boolean r1 = r6.cutoutEnabled()
            if (r1 == 0) goto L_0x0112
            com.google.android.material.shape.MaterialShapeDrawable r1 = r6.boxBackground
            com.google.android.material.textfield.CutoutDrawable r1 = (com.google.android.material.textfield.CutoutDrawable) r1
            r4 = 0
            r1.setCutout(r4, r4, r4, r4)
        L_0x0112:
            r6.openCutout()
        L_0x0115:
            int r1 = r6.boxBackgroundMode
            if (r1 != r2) goto L_0x0138
            boolean r1 = r6.isEnabled()
            if (r1 != 0) goto L_0x0124
            int r0 = r6.disabledFilledBackgroundColor
            r6.boxBackgroundColor = r0
            goto L_0x0138
        L_0x0124:
            if (r3 == 0) goto L_0x012d
            if (r0 != 0) goto L_0x012d
            int r0 = r6.hoveredFilledBackgroundColor
            r6.boxBackgroundColor = r0
            goto L_0x0138
        L_0x012d:
            if (r0 == 0) goto L_0x0134
            int r0 = r6.focusedFilledBackgroundColor
            r6.boxBackgroundColor = r0
            goto L_0x0138
        L_0x0134:
            int r0 = r6.defaultFilledBackgroundColor
            r6.boxBackgroundColor = r0
        L_0x0138:
            r6.applyBoxAttributes()
        L_0x013b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateTextInputBoxState():void");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(android.content.Context r22, android.util.AttributeSet r23, int r24) {
        /*
            r21 = this;
            r0 = r21
            r7 = r23
            r8 = r24
            int r1 = DEF_STYLE_RES
            r2 = r22
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r2, r7, r8, r1)
            r0.<init>(r1, r7, r8)
            r9 = -1
            r0.minWidth = r9
            r0.maxWidth = r9
            com.google.android.material.textfield.IndicatorViewController r1 = new com.google.android.material.textfield.IndicatorViewController
            r1.<init>(r0)
            r0.indicatorViewController = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpRect = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpBoundsRect = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.tmpRectF = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.editTextAttachedListeners = r1
            r10 = 0
            r0.endIconMode = r10
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r0.endIconDelegates = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.endIconChangedListeners = r1
            com.google.android.material.internal.CollapsingTextHelper r1 = new com.google.android.material.internal.CollapsingTextHelper
            r1.<init>(r0)
            r0.collapsingTextHelper = r1
            android.content.Context r11 = r21.getContext()
            r12 = 1
            r0.setOrientation(r12)
            r0.setWillNotDraw(r10)
            r0.setAddStatesFromChildren(r12)
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r11)
            r0.inputFrame = r1
            r1.setAddStatesFromChildren(r12)
            android.widget.FrameLayout r1 = r0.inputFrame
            r0.addView(r1)
            android.widget.LinearLayout r1 = new android.widget.LinearLayout
            r1.<init>(r11)
            r0.startLayout = r1
            r1.setOrientation(r10)
            android.widget.LinearLayout r1 = r0.startLayout
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r13 = -2
            r3 = 8388611(0x800003, float:1.1754948E-38)
            r2.<init>(r13, r9, r3)
            r1.setLayoutParams(r2)
            android.widget.FrameLayout r1 = r0.inputFrame
            android.widget.LinearLayout r2 = r0.startLayout
            r1.addView(r2)
            android.widget.LinearLayout r1 = new android.widget.LinearLayout
            r1.<init>(r11)
            r0.endLayout = r1
            r1.setOrientation(r10)
            android.widget.LinearLayout r1 = r0.endLayout
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 8388613(0x800005, float:1.175495E-38)
            r2.<init>(r13, r9, r3)
            r1.setLayoutParams(r2)
            android.widget.FrameLayout r1 = r0.inputFrame
            android.widget.LinearLayout r2 = r0.endLayout
            r1.addView(r2)
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r11)
            r0.endIconFrame = r1
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r13, r9)
            r1.setLayoutParams(r2)
            com.google.android.material.internal.CollapsingTextHelper r1 = r0.collapsingTextHelper
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            r1.textSizeInterpolator = r2
            r1.recalculate(r10)
            com.google.android.material.internal.CollapsingTextHelper r1 = r0.collapsingTextHelper
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            r1.positionInterpolator = r2
            r1.recalculate(r10)
            com.google.android.material.internal.CollapsingTextHelper r1 = r0.collapsingTextHelper
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.setCollapsedTextGravity(r2)
            int[] r3 = com.google.android.material.R$styleable.TextInputLayout
            int r5 = DEF_STYLE_RES
            r1 = 5
            int[] r6 = new int[r1]
            int r1 = com.google.android.material.R$styleable.TextInputLayout_counterTextAppearance
            r6[r10] = r1
            int r1 = com.google.android.material.R$styleable.TextInputLayout_counterOverflowTextAppearance
            r6[r12] = r1
            int r1 = com.google.android.material.R$styleable.TextInputLayout_errorTextAppearance
            r14 = 2
            r6[r14] = r1
            int r1 = com.google.android.material.R$styleable.TextInputLayout_helperTextTextAppearance
            r15 = 3
            r6[r15] = r1
            int r1 = com.google.android.material.R$styleable.TextInputLayout_hintTextAppearance
            r2 = 4
            r6[r2] = r1
            r1 = r11
            r2 = r23
            r4 = r24
            androidx.appcompat.widget.TintTypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R$styleable.TextInputLayout_hintEnabled
            boolean r2 = r1.getBoolean(r2, r12)
            r0.hintEnabled = r2
            int r2 = com.google.android.material.R$styleable.TextInputLayout_android_hint
            java.lang.CharSequence r2 = r1.getText(r2)
            r0.setHint(r2)
            int r2 = com.google.android.material.R$styleable.TextInputLayout_hintAnimationEnabled
            boolean r2 = r1.getBoolean(r2, r12)
            r0.hintAnimationEnabled = r2
            int r2 = com.google.android.material.R$styleable.TextInputLayout_expandedHintEnabled
            boolean r2 = r1.getBoolean(r2, r12)
            r0.expandedHintEnabled = r2
            int r2 = com.google.android.material.R$styleable.TextInputLayout_android_minWidth
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x012d
            int r2 = com.google.android.material.R$styleable.TextInputLayout_android_minWidth
            int r2 = r1.getDimensionPixelSize(r2, r9)
            r0.setMinWidth(r2)
        L_0x012d:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_android_maxWidth
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x013e
            int r2 = com.google.android.material.R$styleable.TextInputLayout_android_maxWidth
            int r2 = r1.getDimensionPixelSize(r2, r9)
            r0.setMaxWidth(r2)
        L_0x013e:
            int r2 = DEF_STYLE_RES
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder(r11, r7, r8, r2)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            r0.shapeAppearanceModel = r2
            android.content.res.Resources r2 = r11.getResources()
            int r3 = com.google.android.material.R$dimen.mtrl_textinput_box_label_cutout_padding
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.boxLabelCutoutPaddingPx = r2
            int r2 = com.google.android.material.R$styleable.TextInputLayout_boxCollapsedPaddingTop
            int r2 = r1.getDimensionPixelOffset(r2, r10)
            r0.boxCollapsedPaddingTopPx = r2
            int r2 = com.google.android.material.R$styleable.TextInputLayout_boxStrokeWidth
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.google.android.material.R$dimen.mtrl_textinput_box_stroke_width_default
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.getDimensionPixelSize(r2, r3)
            r0.boxStrokeWidthDefaultPx = r2
            int r2 = com.google.android.material.R$styleable.TextInputLayout_boxStrokeWidthFocused
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.google.android.material.R$dimen.mtrl_textinput_box_stroke_width_focused
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.getDimensionPixelSize(r2, r3)
            r0.boxStrokeWidthFocusedPx = r2
            int r2 = r0.boxStrokeWidthDefaultPx
            r0.boxStrokeWidthPx = r2
            int r2 = com.google.android.material.R$styleable.TextInputLayout_boxCornerRadiusTopStart
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r1.getDimension(r2, r3)
            int r4 = com.google.android.material.R$styleable.TextInputLayout_boxCornerRadiusTopEnd
            float r4 = r1.getDimension(r4, r3)
            int r5 = com.google.android.material.R$styleable.TextInputLayout_boxCornerRadiusBottomEnd
            float r5 = r1.getDimension(r5, r3)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_boxCornerRadiusBottomStart
            float r3 = r1.getDimension(r6, r3)
            com.google.android.material.shape.ShapeAppearanceModel r6 = r0.shapeAppearanceModel
            r7 = 0
            if (r6 == 0) goto L_0x0681
            com.google.android.material.shape.ShapeAppearanceModel$Builder r8 = new com.google.android.material.shape.ShapeAppearanceModel$Builder
            r8.<init>(r6)
            r6 = 0
            int r16 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r16 < 0) goto L_0x01b2
            r8.setTopLeftCornerSize(r2)
        L_0x01b2:
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x01b9
            r8.setTopRightCornerSize(r4)
        L_0x01b9:
            int r2 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x01c0
            r8.setBottomRightCornerSize(r5)
        L_0x01c0:
            int r2 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x01c7
            r8.setBottomLeftCornerSize(r3)
        L_0x01c7:
            com.google.android.material.shape.ShapeAppearanceModel r2 = r8.build()
            r0.shapeAppearanceModel = r2
            int r2 = com.google.android.material.R$styleable.TextInputLayout_boxBackgroundColor
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r11, r1, r2)
            if (r2 == 0) goto L_0x0229
            int r3 = r2.getDefaultColor()
            r0.defaultFilledBackgroundColor = r3
            r0.boxBackgroundColor = r3
            boolean r3 = r2.isStateful()
            r4 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r3 == 0) goto L_0x0207
            int[] r3 = new int[r12]
            r3[r10] = r4
            int r3 = r2.getColorForState(r3, r9)
            r0.disabledFilledBackgroundColor = r3
            int[] r3 = new int[r14]
            r3 = {16842908, 16842910} // fill-array
            int r3 = r2.getColorForState(r3, r9)
            r0.focusedFilledBackgroundColor = r3
            int[] r3 = new int[r14]
            r3 = {16843623, 16842910} // fill-array
            int r2 = r2.getColorForState(r3, r9)
            r0.hoveredFilledBackgroundColor = r2
            goto L_0x0233
        L_0x0207:
            int r2 = r0.defaultFilledBackgroundColor
            r0.focusedFilledBackgroundColor = r2
            int r2 = com.google.android.material.R$color.mtrl_filled_background_color
            android.content.res.ColorStateList r2 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r11, r2)
            int[] r3 = new int[r12]
            r3[r10] = r4
            int r3 = r2.getColorForState(r3, r9)
            r0.disabledFilledBackgroundColor = r3
            int[] r3 = new int[r12]
            r4 = 16843623(0x1010367, float:2.3696E-38)
            r3[r10] = r4
            int r2 = r2.getColorForState(r3, r9)
            r0.hoveredFilledBackgroundColor = r2
            goto L_0x0233
        L_0x0229:
            r0.boxBackgroundColor = r10
            r0.defaultFilledBackgroundColor = r10
            r0.disabledFilledBackgroundColor = r10
            r0.focusedFilledBackgroundColor = r10
            r0.hoveredFilledBackgroundColor = r10
        L_0x0233:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_android_textColorHint
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0245
            int r2 = com.google.android.material.R$styleable.TextInputLayout_android_textColorHint
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.focusedTextColor = r2
            r0.defaultHintTextColor = r2
        L_0x0245:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_boxStrokeColor
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r11, r1, r2)
            int r3 = com.google.android.material.R$styleable.TextInputLayout_boxStrokeColor
            int r3 = r1.getColor(r3, r10)
            r0.focusedStrokeColor = r3
            int r3 = com.google.android.material.R$color.mtrl_textinput_default_box_stroke_color
            int r3 = androidx.core.content.ContextCompat.getColor(r11, r3)
            r0.defaultStrokeColor = r3
            int r3 = com.google.android.material.R$color.mtrl_textinput_disabled_color
            int r3 = androidx.core.content.ContextCompat.getColor(r11, r3)
            r0.disabledColor = r3
            int r3 = com.google.android.material.R$color.mtrl_textinput_hovered_box_stroke_color
            int r3 = androidx.core.content.ContextCompat.getColor(r11, r3)
            r0.hoveredStrokeColor = r3
            if (r2 == 0) goto L_0x0270
            r0.setBoxStrokeColorStateList(r2)
        L_0x0270:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_boxStrokeErrorColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0281
            int r2 = com.google.android.material.R$styleable.TextInputLayout_boxStrokeErrorColor
            android.content.res.ColorStateList r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r11, r1, r2)
            r0.setBoxStrokeErrorColor(r2)
        L_0x0281:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_hintTextAppearance
            int r2 = r1.getResourceId(r2, r9)
            if (r2 == r9) goto L_0x0292
            int r2 = com.google.android.material.R$styleable.TextInputLayout_hintTextAppearance
            int r2 = r1.getResourceId(r2, r10)
            r0.setHintTextAppearance(r2)
        L_0x0292:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_errorTextAppearance
            int r2 = r1.getResourceId(r2, r10)
            int r3 = com.google.android.material.R$styleable.TextInputLayout_errorContentDescription
            java.lang.CharSequence r3 = r1.getText(r3)
            int r4 = com.google.android.material.R$styleable.TextInputLayout_errorEnabled
            boolean r4 = r1.getBoolean(r4, r10)
            android.content.Context r5 = r21.getContext()
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            int r6 = com.google.android.material.R$layout.design_text_input_end_icon
            android.widget.LinearLayout r8 = r0.endLayout
            android.view.View r5 = r5.inflate(r6, r8, r10)
            com.google.android.material.internal.CheckableImageButton r5 = (com.google.android.material.internal.CheckableImageButton) r5
            r0.errorIconView = r5
            int r6 = com.google.android.material.R$id.text_input_error_icon
            r5.setId(r6)
            com.google.android.material.internal.CheckableImageButton r5 = r0.errorIconView
            r6 = 8
            r5.setVisibility(r6)
            boolean r5 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isFontScaleAtLeast1_3(r11)
            if (r5 == 0) goto L_0x02d5
            com.google.android.material.internal.CheckableImageButton r5 = r0.errorIconView
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
            r5.setMarginStart(r10)
        L_0x02d5:
            int r5 = com.google.android.material.R$styleable.TextInputLayout_errorIconDrawable
            boolean r5 = r1.hasValue(r5)
            if (r5 == 0) goto L_0x02e6
            int r5 = com.google.android.material.R$styleable.TextInputLayout_errorIconDrawable
            android.graphics.drawable.Drawable r5 = r1.getDrawable(r5)
            r0.setErrorIconDrawable(r5)
        L_0x02e6:
            int r5 = com.google.android.material.R$styleable.TextInputLayout_errorIconTint
            boolean r5 = r1.hasValue(r5)
            if (r5 == 0) goto L_0x02f7
            int r5 = com.google.android.material.R$styleable.TextInputLayout_errorIconTint
            android.content.res.ColorStateList r5 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r11, r1, r5)
            r0.setErrorIconTintList(r5)
        L_0x02f7:
            int r5 = com.google.android.material.R$styleable.TextInputLayout_errorIconTintMode
            boolean r5 = r1.hasValue(r5)
            if (r5 == 0) goto L_0x030c
            int r5 = com.google.android.material.R$styleable.TextInputLayout_errorIconTintMode
            int r5 = r1.getInt(r5, r9)
            android.graphics.PorterDuff$Mode r5 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.parseTintMode(r5, r7)
            r0.setErrorIconTintMode(r5)
        L_0x030c:
            com.google.android.material.internal.CheckableImageButton r5 = r0.errorIconView
            android.content.res.Resources r8 = r21.getResources()
            int r13 = com.google.android.material.R$string.error_icon_content_description
            java.lang.CharSequence r8 = r8.getText(r13)
            r5.setContentDescription(r8)
            com.google.android.material.internal.CheckableImageButton r5 = r0.errorIconView
            androidx.core.view.ViewCompat.setImportantForAccessibility(r5, r14)
            com.google.android.material.internal.CheckableImageButton r5 = r0.errorIconView
            r5.setClickable(r10)
            com.google.android.material.internal.CheckableImageButton r5 = r0.errorIconView
            r5.setPressable(r10)
            com.google.android.material.internal.CheckableImageButton r5 = r0.errorIconView
            r5.setFocusable(r10)
            int r5 = com.google.android.material.R$styleable.TextInputLayout_helperTextTextAppearance
            int r5 = r1.getResourceId(r5, r10)
            int r8 = com.google.android.material.R$styleable.TextInputLayout_helperTextEnabled
            boolean r8 = r1.getBoolean(r8, r10)
            int r13 = com.google.android.material.R$styleable.TextInputLayout_helperText
            java.lang.CharSequence r13 = r1.getText(r13)
            int r15 = com.google.android.material.R$styleable.TextInputLayout_placeholderTextAppearance
            int r15 = r1.getResourceId(r15, r10)
            int r14 = com.google.android.material.R$styleable.TextInputLayout_placeholderText
            java.lang.CharSequence r14 = r1.getText(r14)
            int r12 = com.google.android.material.R$styleable.TextInputLayout_prefixTextAppearance
            int r12 = r1.getResourceId(r12, r10)
            int r7 = com.google.android.material.R$styleable.TextInputLayout_prefixText
            java.lang.CharSequence r7 = r1.getText(r7)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_suffixTextAppearance
            int r6 = r1.getResourceId(r6, r10)
            int r9 = com.google.android.material.R$styleable.TextInputLayout_suffixText
            java.lang.CharSequence r9 = r1.getText(r9)
            r17 = r6
            int r6 = com.google.android.material.R$styleable.TextInputLayout_counterEnabled
            boolean r6 = r1.getBoolean(r6, r10)
            int r10 = com.google.android.material.R$styleable.TextInputLayout_counterMaxLength
            r18 = r6
            r6 = -1
            int r10 = r1.getInt(r10, r6)
            r0.setCounterMaxLength(r10)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_counterTextAppearance
            r10 = 0
            int r6 = r1.getResourceId(r6, r10)
            r0.counterTextAppearance = r6
            int r6 = com.google.android.material.R$styleable.TextInputLayout_counterOverflowTextAppearance
            int r6 = r1.getResourceId(r6, r10)
            r0.counterOverflowTextAppearance = r6
            android.content.Context r6 = r21.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            r19 = r9
            int r9 = com.google.android.material.R$layout.design_text_input_start_icon
            r20 = r12
            android.widget.LinearLayout r12 = r0.startLayout
            android.view.View r6 = r6.inflate(r9, r12, r10)
            com.google.android.material.internal.CheckableImageButton r6 = (com.google.android.material.internal.CheckableImageButton) r6
            r0.startIconView = r6
            r9 = 8
            r6.setVisibility(r9)
            boolean r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isFontScaleAtLeast1_3(r11)
            if (r6 == 0) goto L_0x03b8
            com.google.android.material.internal.CheckableImageButton r6 = r0.startIconView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            r6.setMarginEnd(r10)
        L_0x03b8:
            r6 = 0
            r0.setStartIconOnClickListener(r6)
            r0.setStartIconOnLongClickListener(r6)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconDrawable
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x03eb
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconDrawable
            android.graphics.drawable.Drawable r6 = r1.getDrawable(r6)
            r0.setStartIconDrawable(r6)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconContentDescription
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x03e1
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconContentDescription
            java.lang.CharSequence r6 = r1.getText(r6)
            r0.setStartIconContentDescription(r6)
        L_0x03e1:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconCheckable
            r9 = 1
            boolean r6 = r1.getBoolean(r6, r9)
            r0.setStartIconCheckable(r6)
        L_0x03eb:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconTint
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x03fc
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconTint
            android.content.res.ColorStateList r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r11, r1, r6)
            r0.setStartIconTintList(r6)
        L_0x03fc:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconTintMode
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x0413
            int r6 = com.google.android.material.R$styleable.TextInputLayout_startIconTintMode
            r9 = -1
            int r6 = r1.getInt(r6, r9)
            r9 = 0
            android.graphics.PorterDuff$Mode r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.parseTintMode(r6, r9)
            r0.setStartIconTintMode(r6)
        L_0x0413:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_boxBackgroundMode
            r9 = 0
            int r6 = r1.getInt(r6, r9)
            r0.setBoxBackgroundMode(r6)
            android.content.Context r6 = r21.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r10 = com.google.android.material.R$layout.design_text_input_end_icon
            android.widget.FrameLayout r12 = r0.endIconFrame
            android.view.View r6 = r6.inflate(r10, r12, r9)
            com.google.android.material.internal.CheckableImageButton r6 = (com.google.android.material.internal.CheckableImageButton) r6
            r0.endIconView = r6
            android.widget.FrameLayout r9 = r0.endIconFrame
            r9.addView(r6)
            com.google.android.material.internal.CheckableImageButton r6 = r0.endIconView
            r9 = 8
            r6.setVisibility(r9)
            boolean r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isFontScaleAtLeast1_3(r11)
            if (r6 == 0) goto L_0x0450
            com.google.android.material.internal.CheckableImageButton r6 = r0.endIconView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            r9 = 0
            r6.setMarginStart(r9)
            goto L_0x0451
        L_0x0450:
            r9 = 0
        L_0x0451:
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r6 = r0.endIconDelegates
            com.google.android.material.textfield.CustomEndIconDelegate r10 = new com.google.android.material.textfield.CustomEndIconDelegate
            r10.<init>(r0)
            r12 = -1
            r6.append(r12, r10)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r6 = r0.endIconDelegates
            com.google.android.material.textfield.NoEndIconDelegate r10 = new com.google.android.material.textfield.NoEndIconDelegate
            r10.<init>(r0)
            r6.append(r9, r10)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r6 = r0.endIconDelegates
            com.google.android.material.textfield.PasswordToggleEndIconDelegate r9 = new com.google.android.material.textfield.PasswordToggleEndIconDelegate
            r9.<init>(r0)
            r10 = 1
            r6.append(r10, r9)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r6 = r0.endIconDelegates
            com.google.android.material.textfield.ClearTextEndIconDelegate r9 = new com.google.android.material.textfield.ClearTextEndIconDelegate
            r9.<init>(r0)
            r10 = 2
            r6.append(r10, r9)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r6 = r0.endIconDelegates
            com.google.android.material.textfield.DropdownMenuEndIconDelegate r9 = new com.google.android.material.textfield.DropdownMenuEndIconDelegate
            r9.<init>(r0)
            r10 = 3
            r6.append(r10, r9)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconMode
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x04c6
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconMode
            r9 = 0
            int r6 = r1.getInt(r6, r9)
            r0.setEndIconMode(r6)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconDrawable
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x04aa
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconDrawable
            android.graphics.drawable.Drawable r6 = r1.getDrawable(r6)
            r0.setEndIconDrawable(r6)
        L_0x04aa:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconContentDescription
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x04bb
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconContentDescription
            java.lang.CharSequence r6 = r1.getText(r6)
            r0.setEndIconContentDescription(r6)
        L_0x04bb:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconCheckable
            r9 = 1
            boolean r6 = r1.getBoolean(r6, r9)
            r0.setEndIconCheckable(r6)
            goto L_0x0512
        L_0x04c6:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleEnabled
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x0512
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleEnabled
            r9 = 0
            boolean r6 = r1.getBoolean(r6, r9)
            r0.setEndIconMode(r6)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleDrawable
            android.graphics.drawable.Drawable r6 = r1.getDrawable(r6)
            r0.setEndIconDrawable(r6)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleContentDescription
            java.lang.CharSequence r6 = r1.getText(r6)
            r0.setEndIconContentDescription(r6)
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleTint
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x04fb
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleTint
            android.content.res.ColorStateList r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r11, r1, r6)
            r0.setEndIconTintList(r6)
        L_0x04fb:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleTintMode
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x0512
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleTintMode
            r9 = -1
            int r6 = r1.getInt(r6, r9)
            r9 = 0
            android.graphics.PorterDuff$Mode r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.parseTintMode(r6, r9)
            r0.setEndIconTintMode(r6)
        L_0x0512:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_passwordToggleEnabled
            boolean r6 = r1.hasValue(r6)
            if (r6 != 0) goto L_0x0542
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconTint
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x052b
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconTint
            android.content.res.ColorStateList r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getColorStateList(r11, r1, r6)
            r0.setEndIconTintList(r6)
        L_0x052b:
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconTintMode
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x0542
            int r6 = com.google.android.material.R$styleable.TextInputLayout_endIconTintMode
            r9 = -1
            int r6 = r1.getInt(r6, r9)
            r9 = 0
            android.graphics.PorterDuff$Mode r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.parseTintMode(r6, r9)
            r0.setEndIconTintMode(r6)
        L_0x0542:
            androidx.appcompat.widget.AppCompatTextView r6 = new androidx.appcompat.widget.AppCompatTextView
            r6.<init>(r11)
            r0.prefixTextView = r6
            int r9 = com.google.android.material.R$id.textinput_prefix_text
            r6.setId(r9)
            android.widget.TextView r6 = r0.prefixTextView
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r10 = -2
            r9.<init>(r10, r10)
            r6.setLayoutParams(r9)
            android.widget.TextView r6 = r0.prefixTextView
            r9 = 1
            r6.setAccessibilityLiveRegion(r9)
            android.widget.LinearLayout r6 = r0.startLayout
            com.google.android.material.internal.CheckableImageButton r9 = r0.startIconView
            r6.addView(r9)
            android.widget.LinearLayout r6 = r0.startLayout
            android.widget.TextView r9 = r0.prefixTextView
            r6.addView(r9)
            androidx.appcompat.widget.AppCompatTextView r6 = new androidx.appcompat.widget.AppCompatTextView
            r6.<init>(r11)
            r0.suffixTextView = r6
            int r9 = com.google.android.material.R$id.textinput_suffix_text
            r6.setId(r9)
            android.widget.TextView r6 = r0.suffixTextView
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r10 = 80
            r11 = -2
            r9.<init>(r11, r11, r10)
            r6.setLayoutParams(r9)
            android.widget.TextView r6 = r0.suffixTextView
            r9 = 1
            r6.setAccessibilityLiveRegion(r9)
            android.widget.LinearLayout r6 = r0.endLayout
            android.widget.TextView r9 = r0.suffixTextView
            r6.addView(r9)
            android.widget.LinearLayout r6 = r0.endLayout
            com.google.android.material.internal.CheckableImageButton r9 = r0.errorIconView
            r6.addView(r9)
            android.widget.LinearLayout r6 = r0.endLayout
            android.widget.FrameLayout r9 = r0.endIconFrame
            r6.addView(r9)
            r0.setHelperTextEnabled(r8)
            r0.setHelperText(r13)
            r0.setHelperTextTextAppearance(r5)
            r0.setErrorEnabled(r4)
            r0.setErrorTextAppearance(r2)
            r0.setErrorContentDescription(r3)
            int r2 = r0.counterTextAppearance
            r0.setCounterTextAppearance(r2)
            int r2 = r0.counterOverflowTextAppearance
            r0.setCounterOverflowTextAppearance(r2)
            r0.setPlaceholderText(r14)
            r0.setPlaceholderTextAppearance(r15)
            r0.setPrefixText(r7)
            r2 = r20
            r0.setPrefixTextAppearance(r2)
            r2 = r19
            r0.setSuffixText(r2)
            r2 = r17
            r0.setSuffixTextAppearance(r2)
            int r2 = com.google.android.material.R$styleable.TextInputLayout_errorTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x05e6
            int r2 = com.google.android.material.R$styleable.TextInputLayout_errorTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setErrorTextColor(r2)
        L_0x05e6:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_helperTextTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x05f7
            int r2 = com.google.android.material.R$styleable.TextInputLayout_helperTextTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setHelperTextColor(r2)
        L_0x05f7:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_hintTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0608
            int r2 = com.google.android.material.R$styleable.TextInputLayout_hintTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setHintTextColor(r2)
        L_0x0608:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_counterTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0619
            int r2 = com.google.android.material.R$styleable.TextInputLayout_counterTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setCounterTextColor(r2)
        L_0x0619:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_counterOverflowTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x062a
            int r2 = com.google.android.material.R$styleable.TextInputLayout_counterOverflowTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setCounterOverflowTextColor(r2)
        L_0x062a:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_placeholderTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x063b
            int r2 = com.google.android.material.R$styleable.TextInputLayout_placeholderTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setPlaceholderTextColor(r2)
        L_0x063b:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_prefixTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x064c
            int r2 = com.google.android.material.R$styleable.TextInputLayout_prefixTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setPrefixTextColor(r2)
        L_0x064c:
            int r2 = com.google.android.material.R$styleable.TextInputLayout_suffixTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x065d
            int r2 = com.google.android.material.R$styleable.TextInputLayout_suffixTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setSuffixTextColor(r2)
        L_0x065d:
            r2 = r18
            r0.setCounterEnabled(r2)
            int r2 = com.google.android.material.R$styleable.TextInputLayout_android_enabled
            r3 = 1
            boolean r2 = r1.getBoolean(r2, r3)
            r0.setEnabled(r2)
            android.content.res.TypedArray r1 = r1.mWrapped
            r1.recycle()
            r1 = 2
            r0.setImportantForAccessibility(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x0680
            if (r1 < r2) goto L_0x0680
            r0.setImportantForAutofill(r3)
        L_0x0680:
            return
        L_0x0681:
            r1 = r7
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
        refreshEndIconDrawableState();
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            refreshIconDrawableState(this.startIconView, this.startIconTintList);
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.errorEnabled);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        int i2 = this.counterMaxLength;
        String str = null;
        if (i2 == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i > i2;
            Context context = getContext();
            this.counterView.setContentDescription(context.getString(this.counterOverflowed ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, new Object[]{Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)}));
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            BidiFormatter instance = BidiFormatter.getInstance();
            TextView textView = this.counterView;
            String string = getContext().getString(R$string.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)});
            TextDirectionHeuristicCompat textDirectionHeuristicCompat = instance.mDefaultTextDirectionHeuristicCompat;
            if (string != null) {
                str = instance.unicodeWrap(string, textDirectionHeuristicCompat, true).toString();
            }
            textView.setText(str);
        }
        if (this.editText != null && z != this.counterOverflowed) {
            updateLabelState(false, false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }
}
