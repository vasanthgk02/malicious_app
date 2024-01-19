package androidx.appcompat.widget;

import a.a.a.a.d.b;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode.Callback;
import android.view.VelocityTracker;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

public class SwitchCompat extends CompoundButton {
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final Property<SwitchCompat, Float> THUMB_POS = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        public Object get(Object obj) {
            return Float.valueOf(((SwitchCompat) obj).mThumbPosition);
        }

        public void set(Object obj, Object obj2) {
            ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
        }
    };
    public boolean mHasThumbTint;
    public boolean mHasThumbTintMode;
    public boolean mHasTrackTint;
    public boolean mHasTrackTintMode;
    public int mMinFlingVelocity;
    public Layout mOffLayout;
    public Layout mOnLayout;
    public ObjectAnimator mPositionAnimator;
    public boolean mShowText;
    public boolean mSplitTrack;
    public int mSwitchBottom;
    public int mSwitchHeight;
    public int mSwitchLeft;
    public int mSwitchMinWidth;
    public int mSwitchPadding;
    public int mSwitchRight;
    public int mSwitchTop;
    public TransformationMethod mSwitchTransformationMethod;
    public int mSwitchWidth;
    public final Rect mTempRect;
    public ColorStateList mTextColors;
    public final AppCompatTextHelper mTextHelper;
    public CharSequence mTextOff;
    public CharSequence mTextOn;
    public final TextPaint mTextPaint;
    public Drawable mThumbDrawable;
    public float mThumbPosition;
    public int mThumbTextPadding;
    public ColorStateList mThumbTintList;
    public Mode mThumbTintMode;
    public int mThumbWidth;
    public int mTouchMode;
    public int mTouchSlop;
    public float mTouchX;
    public float mTouchY;
    public Drawable mTrackDrawable;
    public ColorStateList mTrackTintList;
    public Mode mTrackTintMode;
    public VelocityTracker mVelocityTracker;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    private int getThumbOffset() {
        float f2;
        if (ViewUtils.isLayoutRtl(this)) {
            f2 = 1.0f - this.mThumbPosition;
        } else {
            f2 = this.mThumbPosition;
        }
        return (int) ((f2 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.mTempRect;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            rect = DrawableUtils.getOpticalBounds(drawable2);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        return ((((this.mSwitchWidth - this.mThumbWidth) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    public final void applyThumbTint() {
        if (this.mThumbDrawable == null) {
            return;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            Drawable mutate = b.wrap(this.mThumbDrawable).mutate();
            this.mThumbDrawable = mutate;
            if (this.mHasThumbTint) {
                mutate.setTintList(this.mThumbTintList);
            }
            if (this.mHasThumbTintMode) {
                this.mThumbDrawable.setTintMode(this.mThumbTintMode);
            }
            if (this.mThumbDrawable.isStateful()) {
                this.mThumbDrawable.setState(getDrawableState());
            }
        }
    }

    public final void applyTrackTint() {
        if (this.mTrackDrawable == null) {
            return;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            Drawable mutate = b.wrap(this.mTrackDrawable).mutate();
            this.mTrackDrawable = mutate;
            if (this.mHasTrackTint) {
                mutate.setTintList(this.mTrackTintList);
            }
            if (this.mHasTrackTintMode) {
                this.mTrackDrawable.setTintMode(this.mTrackTintMode);
            }
            if (this.mTrackDrawable.isStateful()) {
                this.mTrackDrawable.setState(getDrawableState());
            }
        }
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        Rect rect2 = this.mTempRect;
        int i3 = this.mSwitchLeft;
        int i4 = this.mSwitchTop;
        int i5 = this.mSwitchRight;
        int i6 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            rect = DrawableUtils.getOpticalBounds(drawable);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i7 = rect2.left;
            thumbOffset += i7;
            if (rect != null) {
                int i8 = rect.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rect.top;
                int i10 = rect2.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rect.right;
                int i12 = rect2.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rect.bottom;
                int i14 = rect2.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                    this.mTrackDrawable.setBounds(i3, i, i5, i2);
                }
            } else {
                i = i4;
            }
            i2 = i6;
            this.mTrackDrawable.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i15 = thumbOffset - rect2.left;
            int i16 = thumbOffset + this.mThumbWidth + rect2.right;
            this.mThumbDrawable.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setHotspot(f2, f3);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            compoundPaddingLeft += this.mSwitchPadding;
        }
        return compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            compoundPaddingRight += this.mSwitchPadding;
        }
        return compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
    }

    public final Layout makeLayout(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.mSwitchTransformationMethod;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.mTextPaint;
        StaticLayout staticLayout = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        return staticLayout;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.mSwitchTop;
        int i3 = this.mSwitchBottom;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (!this.mSplitTrack || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.mOnLayout : this.mOffLayout;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.mTextColors;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i = bounds.left + bounds.right;
            } else {
                i = getWidth();
            }
            canvas.translate((float) ((i / 2) - (layout.getWidth() / 2)), (float) (((i4 + i5) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        super.onLayout(z, i, i2, i3, i4);
        int i10 = 0;
        if (this.mThumbDrawable != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
            i5 = Math.max(0, opticalBounds.left - rect.left);
            i10 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i5 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            i7 = getPaddingLeft() + i5;
            i6 = ((this.mSwitchWidth + i7) - i5) - i10;
        } else {
            i6 = (getWidth() - getPaddingRight()) - i10;
            i7 = (i6 - this.mSwitchWidth) + i5 + i10;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = getPaddingTop();
            int i11 = this.mSwitchHeight;
            int height = (((getHeight() + paddingTop) - getPaddingBottom()) / 2) - (i11 / 2);
            int i12 = height;
            i8 = i11 + height;
            i9 = i12;
        } else if (gravity != 80) {
            i9 = getPaddingTop();
            i8 = this.mSwitchHeight + i9;
        } else {
            i8 = getHeight() - getPaddingBottom();
            i9 = i8 - this.mSwitchHeight;
        }
        this.mSwitchLeft = i7;
        this.mSwitchTop = i9;
        this.mSwitchBottom = i8;
        this.mSwitchRight = i6;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOn);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOff);
            }
        }
        Rect rect = this.mTempRect;
        Drawable drawable = this.mThumbDrawable;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
            i3 = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            i4 = 0;
            i3 = 0;
        }
        if (this.mShowText) {
            i5 = (this.mThumbTextPadding * 2) + Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth());
        } else {
            i5 = 0;
        }
        this.mThumbWidth = Math.max(i5, i4);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable3);
            i7 = Math.max(i7, opticalBounds.left);
            i8 = Math.max(i8, opticalBounds.right);
        }
        int max = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + i7 + i8);
        int max2 = Math.max(i6, i3);
        this.mSwitchWidth = max;
        this.mSwitchHeight = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0 != 3) goto L_0x0155;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            r0.addMovement(r11)
            int r0 = r11.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0102
            r3 = 3
            r4 = 0
            r5 = 2
            if (r0 == r2) goto L_0x0095
            if (r0 == r5) goto L_0x0018
            if (r0 == r3) goto L_0x0095
            goto L_0x0155
        L_0x0018:
            int r0 = r10.mTouchMode
            if (r0 == r2) goto L_0x0061
            if (r0 == r5) goto L_0x0020
            goto L_0x0155
        L_0x0020:
            float r11 = r11.getX()
            int r0 = r10.getThumbScrollRange()
            float r1 = r10.mTouchX
            float r1 = r11 - r1
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0033
            float r0 = (float) r0
            float r1 = r1 / r0
            goto L_0x003e
        L_0x0033:
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003e
        L_0x003a:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003e:
            boolean r0 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r10)
            if (r0 == 0) goto L_0x0045
            float r1 = -r1
        L_0x0045:
            float r0 = r10.mThumbPosition
            float r0 = r0 + r1
            int r1 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x004d
            goto L_0x0055
        L_0x004d:
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0054
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0055
        L_0x0054:
            r4 = r0
        L_0x0055:
            float r0 = r10.mThumbPosition
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0060
            r10.mTouchX = r11
            r10.setThumbPosition(r4)
        L_0x0060:
            return r2
        L_0x0061:
            float r0 = r11.getX()
            float r1 = r11.getY()
            float r3 = r10.mTouchX
            float r3 = r0 - r3
            float r3 = java.lang.Math.abs(r3)
            int r4 = r10.mTouchSlop
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0087
            float r3 = r10.mTouchY
            float r3 = r1 - r3
            float r3 = java.lang.Math.abs(r3)
            int r4 = r10.mTouchSlop
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0155
        L_0x0087:
            r10.mTouchMode = r5
            android.view.ViewParent r11 = r10.getParent()
            r11.requestDisallowInterceptTouchEvent(r2)
            r10.mTouchX = r0
            r10.mTouchY = r1
            return r2
        L_0x0095:
            int r0 = r10.mTouchMode
            if (r0 != r5) goto L_0x00fa
            r10.mTouchMode = r1
            int r0 = r11.getAction()
            if (r0 != r2) goto L_0x00a9
            boolean r0 = r10.isEnabled()
            if (r0 == 0) goto L_0x00a9
            r0 = 1
            goto L_0x00aa
        L_0x00a9:
            r0 = 0
        L_0x00aa:
            boolean r5 = r10.isChecked()
            if (r0 == 0) goto L_0x00e0
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            r6 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r6)
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            float r0 = r0.getXVelocity()
            float r6 = java.lang.Math.abs(r0)
            int r7 = r10.mMinFlingVelocity
            float r7 = (float) r7
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x00db
            boolean r6 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r10)
            if (r6 == 0) goto L_0x00d3
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d9
            goto L_0x00d7
        L_0x00d3:
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d9
        L_0x00d7:
            r0 = 1
            goto L_0x00e1
        L_0x00d9:
            r0 = 0
            goto L_0x00e1
        L_0x00db:
            boolean r0 = r10.getTargetCheckedState()
            goto L_0x00e1
        L_0x00e0:
            r0 = r5
        L_0x00e1:
            if (r0 == r5) goto L_0x00e6
            r10.playSoundEffect(r1)
        L_0x00e6:
            r10.setChecked(r0)
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r11)
            r0.setAction(r3)
            super.onTouchEvent(r0)
            r0.recycle()
            super.onTouchEvent(r11)
            return r2
        L_0x00fa:
            r10.mTouchMode = r1
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            r0.clear()
            goto L_0x0155
        L_0x0102:
            float r0 = r11.getX()
            float r3 = r11.getY()
            boolean r4 = r10.isEnabled()
            if (r4 == 0) goto L_0x0155
            android.graphics.drawable.Drawable r4 = r10.mThumbDrawable
            if (r4 != 0) goto L_0x0115
            goto L_0x014d
        L_0x0115:
            int r4 = r10.getThumbOffset()
            android.graphics.drawable.Drawable r5 = r10.mThumbDrawable
            android.graphics.Rect r6 = r10.mTempRect
            r5.getPadding(r6)
            int r5 = r10.mSwitchTop
            int r6 = r10.mTouchSlop
            int r5 = r5 - r6
            int r7 = r10.mSwitchLeft
            int r7 = r7 + r4
            int r7 = r7 - r6
            int r4 = r10.mThumbWidth
            int r4 = r4 + r7
            android.graphics.Rect r8 = r10.mTempRect
            int r9 = r8.left
            int r4 = r4 + r9
            int r8 = r8.right
            int r4 = r4 + r8
            int r4 = r4 + r6
            int r8 = r10.mSwitchBottom
            int r8 = r8 + r6
            float r6 = (float) r7
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x014d
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x014d
            float r4 = (float) r5
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x014d
            float r4 = (float) r8
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x014d
            r1 = 1
        L_0x014d:
            if (r1 == 0) goto L_0x0155
            r10.mTouchMode = r2
            r10.mTouchX = r0
            r10.mTouchY = r3
        L_0x0155:
            boolean r11 = super.onTouchEvent(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (isChecked) {
            setOnStateDescriptionOnRAndAbove();
        } else {
            setOffStateDescriptionOnRAndAbove();
        }
        float f2 = 1.0f;
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this)) {
            ObjectAnimator objectAnimator = this.mPositionAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (!isChecked) {
                f2 = 0.0f;
            }
            setThumbPosition(f2);
            return;
        }
        if (!isChecked) {
            f2 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{f2});
        this.mPositionAnimator = ofFloat;
        ofFloat.setDuration(250);
        this.mPositionAnimator.setAutoCancel(true);
        this.mPositionAnimator.start();
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(CompoundButtonCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public final void setOffStateDescriptionOnRAndAbove() {
        if (VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.mTextOff;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.abc_capital_off);
            }
            ViewCompat.setStateDescription(this, charSequence);
        }
    }

    public final void setOnStateDescriptionOnRAndAbove() {
        if (VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.mTextOn;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.abc_capital_on);
            }
            ViewCompat.setStateDescription(this, charSequence);
        }
    }

    public void setShowText(boolean z) {
        if (this.mShowText != z) {
            this.mShowText = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.mSplitTrack = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.mSwitchMinWidth = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.mSwitchPadding = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.mTextPaint.getTypeface() != null && !this.mTextPaint.getTypeface().equals(typeface)) || (this.mTextPaint.getTypeface() == null && typeface != null)) {
            this.mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.mTextOff = charSequence;
        requestLayout();
        if (!isChecked()) {
            setOffStateDescriptionOnRAndAbove();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        this.mTextOn = charSequence;
        requestLayout();
        if (isChecked()) {
            setOnStateDescriptionOnRAndAbove();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f2) {
        this.mThumbPosition = f2;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.mThumbTextPadding = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mThumbDrawable || drawable == this.mTrackDrawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0117, code lost:
        r7 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r13, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x011b, code lost:
        if (r7 != null) goto L_0x0122;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SwitchCompat(android.content.Context r13, android.util.AttributeSet r14, int r15) {
        /*
            r12 = this;
            r12.<init>(r13, r14, r15)
            r0 = 0
            r12.mThumbTintList = r0
            r12.mThumbTintMode = r0
            r1 = 0
            r12.mHasThumbTint = r1
            r12.mHasThumbTintMode = r1
            r12.mTrackTintList = r0
            r12.mTrackTintMode = r0
            r12.mHasTrackTint = r1
            r12.mHasTrackTintMode = r1
            android.view.VelocityTracker r2 = android.view.VelocityTracker.obtain()
            r12.mVelocityTracker = r2
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r12.mTempRect = r2
            android.content.Context r2 = r12.getContext()
            androidx.appcompat.widget.ThemeUtils.checkAppCompatTheme(r12, r2)
            android.text.TextPaint r2 = new android.text.TextPaint
            r3 = 1
            r2.<init>(r3)
            r12.mTextPaint = r2
            android.content.res.Resources r2 = r12.getResources()
            android.text.TextPaint r4 = r12.mTextPaint
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            r4.density = r2
            int[] r2 = androidx.appcompat.R$styleable.SwitchCompat
            androidx.appcompat.widget.TintTypedArray r4 = new androidx.appcompat.widget.TintTypedArray
            android.content.res.TypedArray r2 = r13.obtainStyledAttributes(r14, r2, r15, r1)
            r4.<init>(r13, r2)
            int[] r7 = androidx.appcompat.R$styleable.SwitchCompat
            android.content.res.TypedArray r9 = r4.mWrapped
            r11 = 0
            r5 = r12
            r6 = r13
            r8 = r14
            r10 = r15
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r5, r6, r7, r8, r9, r10, r11)
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_android_thumb
            android.graphics.drawable.Drawable r2 = r4.getDrawable(r2)
            r12.mThumbDrawable = r2
            if (r2 == 0) goto L_0x0063
            r2.setCallback(r12)
        L_0x0063:
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_track
            android.graphics.drawable.Drawable r2 = r4.getDrawable(r2)
            r12.mTrackDrawable = r2
            if (r2 == 0) goto L_0x0070
            r2.setCallback(r12)
        L_0x0070:
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_android_textOn
            java.lang.CharSequence r2 = r4.getText(r2)
            r12.mTextOn = r2
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_android_textOff
            java.lang.CharSequence r2 = r4.getText(r2)
            r12.mTextOff = r2
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_showText
            boolean r2 = r4.getBoolean(r2, r3)
            r12.mShowText = r2
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_thumbTextPadding
            int r2 = r4.getDimensionPixelSize(r2, r1)
            r12.mThumbTextPadding = r2
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_switchMinWidth
            int r2 = r4.getDimensionPixelSize(r2, r1)
            r12.mSwitchMinWidth = r2
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_switchPadding
            int r2 = r4.getDimensionPixelSize(r2, r1)
            r12.mSwitchPadding = r2
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_splitTrack
            boolean r2 = r4.getBoolean(r2, r1)
            r12.mSplitTrack = r2
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_thumbTint
            android.content.res.ColorStateList r2 = r4.getColorStateList(r2)
            if (r2 == 0) goto L_0x00b4
            r12.mThumbTintList = r2
            r12.mHasThumbTint = r3
        L_0x00b4:
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_thumbTintMode
            r5 = -1
            int r2 = r4.getInt(r2, r5)
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r2, r0)
            android.graphics.PorterDuff$Mode r6 = r12.mThumbTintMode
            if (r6 == r2) goto L_0x00c7
            r12.mThumbTintMode = r2
            r12.mHasThumbTintMode = r3
        L_0x00c7:
            boolean r2 = r12.mHasThumbTint
            if (r2 != 0) goto L_0x00cf
            boolean r2 = r12.mHasThumbTintMode
            if (r2 == 0) goto L_0x00d2
        L_0x00cf:
            r12.applyThumbTint()
        L_0x00d2:
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_trackTint
            android.content.res.ColorStateList r2 = r4.getColorStateList(r2)
            if (r2 == 0) goto L_0x00de
            r12.mTrackTintList = r2
            r12.mHasTrackTint = r3
        L_0x00de:
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_trackTintMode
            int r2 = r4.getInt(r2, r5)
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r2, r0)
            android.graphics.PorterDuff$Mode r6 = r12.mTrackTintMode
            if (r6 == r2) goto L_0x00f0
            r12.mTrackTintMode = r2
            r12.mHasTrackTintMode = r3
        L_0x00f0:
            boolean r2 = r12.mHasTrackTint
            if (r2 != 0) goto L_0x00f8
            boolean r2 = r12.mHasTrackTintMode
            if (r2 == 0) goto L_0x00fb
        L_0x00f8:
            r12.applyTrackTint()
        L_0x00fb:
            int r2 = androidx.appcompat.R$styleable.SwitchCompat_switchTextAppearance
            int r2 = r4.getResourceId(r2, r1)
            if (r2 == 0) goto L_0x01bd
            int[] r6 = androidx.appcompat.R$styleable.TextAppearance
            android.content.res.TypedArray r2 = r13.obtainStyledAttributes(r2, r6)
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            boolean r7 = r2.hasValue(r6)
            if (r7 == 0) goto L_0x011e
            int r7 = r2.getResourceId(r6, r1)
            if (r7 == 0) goto L_0x011e
            android.content.res.ColorStateList r7 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r13, r7)
            if (r7 == 0) goto L_0x011e
            goto L_0x0122
        L_0x011e:
            android.content.res.ColorStateList r7 = r2.getColorStateList(r6)
        L_0x0122:
            if (r7 == 0) goto L_0x0127
            r12.mTextColors = r7
            goto L_0x012d
        L_0x0127:
            android.content.res.ColorStateList r6 = r12.getTextColors()
            r12.mTextColors = r6
        L_0x012d:
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_textSize
            int r6 = r2.getDimensionPixelSize(r6, r1)
            if (r6 == 0) goto L_0x0148
            float r6 = (float) r6
            android.text.TextPaint r7 = r12.mTextPaint
            float r7 = r7.getTextSize()
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0148
            android.text.TextPaint r7 = r12.mTextPaint
            r7.setTextSize(r6)
            r12.requestLayout()
        L_0x0148:
            int r6 = androidx.appcompat.R$styleable.TextAppearance_android_typeface
            int r6 = r2.getInt(r6, r5)
            int r7 = androidx.appcompat.R$styleable.TextAppearance_android_textStyle
            int r5 = r2.getInt(r7, r5)
            r7 = 2
            if (r6 == r3) goto L_0x0164
            if (r6 == r7) goto L_0x0161
            r8 = 3
            if (r6 == r8) goto L_0x015e
            r6 = r0
            goto L_0x0166
        L_0x015e:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            goto L_0x0166
        L_0x0161:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
            goto L_0x0166
        L_0x0164:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
        L_0x0166:
            r8 = 0
            if (r5 <= 0) goto L_0x0197
            if (r6 != 0) goto L_0x0170
            android.graphics.Typeface r6 = android.graphics.Typeface.defaultFromStyle(r5)
            goto L_0x0174
        L_0x0170:
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r5)
        L_0x0174:
            r12.setSwitchTypeface(r6)
            if (r6 == 0) goto L_0x017e
            int r6 = r6.getStyle()
            goto L_0x017f
        L_0x017e:
            r6 = 0
        L_0x017f:
            int r6 = ~r6
            r5 = r5 & r6
            android.text.TextPaint r6 = r12.mTextPaint
            r9 = r5 & 1
            if (r9 == 0) goto L_0x0188
            goto L_0x0189
        L_0x0188:
            r3 = 0
        L_0x0189:
            r6.setFakeBoldText(r3)
            android.text.TextPaint r3 = r12.mTextPaint
            r5 = r5 & r7
            if (r5 == 0) goto L_0x0193
            r8 = -1098907648(0xffffffffbe800000, float:-0.25)
        L_0x0193:
            r3.setTextSkewX(r8)
            goto L_0x01a4
        L_0x0197:
            android.text.TextPaint r3 = r12.mTextPaint
            r3.setFakeBoldText(r1)
            android.text.TextPaint r3 = r12.mTextPaint
            r3.setTextSkewX(r8)
            r12.setSwitchTypeface(r6)
        L_0x01a4:
            int r3 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r1 = r2.getBoolean(r3, r1)
            if (r1 == 0) goto L_0x01b8
            androidx.appcompat.text.AllCapsTransformationMethod r0 = new androidx.appcompat.text.AllCapsTransformationMethod
            android.content.Context r1 = r12.getContext()
            r0.<init>(r1)
            r12.mSwitchTransformationMethod = r0
            goto L_0x01ba
        L_0x01b8:
            r12.mSwitchTransformationMethod = r0
        L_0x01ba:
            r2.recycle()
        L_0x01bd:
            androidx.appcompat.widget.AppCompatTextHelper r0 = new androidx.appcompat.widget.AppCompatTextHelper
            r0.<init>(r12)
            r12.mTextHelper = r0
            r0.loadFromAttributes(r14, r15)
            android.content.res.TypedArray r14 = r4.mWrapped
            r14.recycle()
            android.view.ViewConfiguration r13 = android.view.ViewConfiguration.get(r13)
            int r14 = r13.getScaledTouchSlop()
            r12.mTouchSlop = r14
            int r13 = r13.getScaledMinimumFlingVelocity()
            r12.mMinFlingVelocity = r13
            r12.refreshDrawableState()
            boolean r13 = r12.isChecked()
            r12.setChecked(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
