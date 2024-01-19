package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import sfs2x.client.entities.invitation.InvitationReply;

public class BadgeDrawable extends Drawable implements TextDrawableDelegate {
    public static final int DEFAULT_STYLE = R$style.Widget_MaterialComponents_Badge;
    public static final int DEFAULT_THEME_ATTR = R$attr.badgeStyle;
    public WeakReference<View> anchorViewRef;
    public final Rect badgeBounds = new Rect();
    public float badgeCenterX;
    public float badgeCenterY;
    public final float badgeRadius;
    public final float badgeWidePadding;
    public final float badgeWithTextRadius;
    public final WeakReference<Context> contextRef;
    public float cornerRadius;
    public WeakReference<FrameLayout> customBadgeParentRef;
    public float halfBadgeHeight;
    public float halfBadgeWidth;
    public int maxBadgeNumber;
    public final SavedState savedState;
    public final MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable();
    public final TextDrawableHelper textDrawableHelper;

    public static final class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int additionalHorizontalOffset;
        public int additionalVerticalOffset;
        public int alpha = InvitationReply.EXPIRED;
        public int backgroundColor;
        public int badgeGravity;
        public int badgeTextColor;
        public int contentDescriptionExceedsMaxBadgeNumberRes;
        public CharSequence contentDescriptionNumberless;
        public int contentDescriptionQuantityStrings;
        public int horizontalOffset;
        public boolean isVisible;
        public int maxCharacterCount;
        public int number = -1;
        public int verticalOffset;

        public SavedState(Context context) {
            int i = R$style.TextAppearance_MaterialComponents_Badge;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
            obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
            ColorStateList colorStateList = ImageOriginUtils.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
            ImageOriginUtils.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
            ImageOriginUtils.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
            obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
            obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
            int i2 = R$styleable.TextAppearance_fontFamily;
            i2 = !obtainStyledAttributes.hasValue(i2) ? R$styleable.TextAppearance_android_fontFamily : i2;
            obtainStyledAttributes.getResourceId(i2, 0);
            obtainStyledAttributes.getString(i2);
            obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
            ImageOriginUtils.getColorStateList(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
            obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
            obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
            obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, R$styleable.MaterialTextAppearance);
            obtainStyledAttributes2.hasValue(R$styleable.MaterialTextAppearance_android_letterSpacing);
            obtainStyledAttributes2.getFloat(R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
            obtainStyledAttributes2.recycle();
            this.badgeTextColor = colorStateList.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R$string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R$plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R$string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffset);
            parcel.writeInt(this.verticalOffset);
            parcel.writeInt(this.additionalHorizontalOffset);
            parcel.writeInt(this.additionalVerticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffset = parcel.readInt();
            this.verticalOffset = parcel.readInt();
            this.additionalHorizontalOffset = parcel.readInt();
            this.additionalVerticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }
    }

    public BadgeDrawable(Context context) {
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkTheme(context, ThemeEnforcement.MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.badgeRadius = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius);
        this.badgeWidePadding = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = (float) resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        textDrawableHelper2.textPaint.setTextAlign(Align.CENTER);
        this.savedState = new SavedState(context);
        int i = R$style.TextAppearance_MaterialComponents_Badge;
        Context context2 = (Context) this.contextRef.get();
        if (context2 != null) {
            TextAppearance textAppearance = new TextAppearance(context2, i);
            if (this.textDrawableHelper.textAppearance != textAppearance) {
                Context context3 = (Context) this.contextRef.get();
                if (context3 != null) {
                    this.textDrawableHelper.setTextAppearance(textAppearance, context3);
                    updateCenterAndBounds();
                }
            }
        }
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && this.savedState.alpha != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasNumber()) {
                Rect rect = new Rect();
                String badgeText = getBadgeText();
                this.textDrawableHelper.textPaint.getTextBounds(badgeText, 0, badgeText.length(), rect);
                canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + ((float) (rect.height() / 2)), this.textDrawableHelper.textPaint);
            }
        }
    }

    public int getAlpha() {
        return this.savedState.alpha;
    }

    public final String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance().format((long) getNumber());
        }
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return "";
        }
        return context.getString(R$string.mtrl_exceed_max_badge_number_suffix, new Object[]{Integer.valueOf(this.maxBadgeNumber), MqttTopic.SINGLE_LEVEL_WILDCARD});
    }

    public CharSequence getContentDescription() {
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return this.savedState.contentDescriptionNumberless;
        }
        if (this.savedState.contentDescriptionQuantityStrings <= 0) {
            return null;
        }
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return null;
        }
        int number = getNumber();
        int i = this.maxBadgeNumber;
        if (number <= i) {
            return context.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), new Object[]{Integer.valueOf(getNumber())});
        }
        return context.getString(this.savedState.contentDescriptionExceedsMaxBadgeNumberRes, new Object[]{Integer.valueOf(i)});
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getNumber() {
        if (!hasNumber()) {
            return 0;
        }
        return this.savedState.number;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean hasNumber() {
        return this.savedState.number != -1;
    }

    public boolean isStateful() {
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.savedState.alpha = i;
        this.textDrawableHelper.textPaint.setAlpha(i);
        invalidateSelf();
    }

    public void setBackgroundColor(int i) {
        this.savedState.backgroundColor = i;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable.drawableState.fillColor != valueOf) {
            materialShapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    public void setBadgeGravity(int i) {
        SavedState savedState2 = this.savedState;
        if (savedState2.badgeGravity != i) {
            savedState2.badgeGravity = i;
            WeakReference<View> weakReference = this.anchorViewRef;
            if (weakReference != null && weakReference.get() != null) {
                View view = (View) this.anchorViewRef.get();
                WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
                updateBadgeCoordinates(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
            }
        }
    }

    public void setBadgeTextColor(int i) {
        this.savedState.badgeTextColor = i;
        if (this.textDrawableHelper.textPaint.getColor() != i) {
            this.textDrawableHelper.textPaint.setColor(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setMaxCharacterCount(int i) {
        SavedState savedState2 = this.savedState;
        if (savedState2.maxCharacterCount != i) {
            savedState2.maxCharacterCount = i;
            this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) i) - 1.0d)) - 1;
            this.textDrawableHelper.textWidthDirty = true;
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void setNumber(int i) {
        int max = Math.max(0, i);
        SavedState savedState2 = this.savedState;
        if (savedState2.number != max) {
            savedState2.number = max;
            this.textDrawableHelper.textWidthDirty = true;
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        this.customBadgeParentRef = new WeakReference<>(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public final void updateCenterAndBounds() {
        Context context = (Context) this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.badgeBounds);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                viewGroup = (FrameLayout) weakReference2.get();
            }
            if (viewGroup != null) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            SavedState savedState2 = this.savedState;
            int i = savedState2.verticalOffset + savedState2.additionalVerticalOffset;
            int i2 = savedState2.badgeGravity;
            if (i2 == 8388691 || i2 == 8388693) {
                this.badgeCenterY = (float) (rect2.bottom - i);
            } else {
                this.badgeCenterY = (float) (rect2.top + i);
            }
            if (getNumber() <= 9) {
                float f2 = !hasNumber() ? this.badgeRadius : this.badgeWithTextRadius;
                this.cornerRadius = f2;
                this.halfBadgeHeight = f2;
                this.halfBadgeWidth = f2;
            } else {
                float f3 = this.badgeWithTextRadius;
                this.cornerRadius = f3;
                this.halfBadgeHeight = f3;
                this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
            SavedState savedState3 = this.savedState;
            int i3 = savedState3.horizontalOffset + savedState3.additionalHorizontalOffset;
            int i4 = savedState3.badgeGravity;
            if (i4 == 8388659 || i4 == 8388691) {
                this.badgeCenterX = ViewCompat.getLayoutDirection(view) == 0 ? (((float) rect2.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) i3) : ((((float) rect2.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) i3);
            } else {
                this.badgeCenterX = ViewCompat.getLayoutDirection(view) == 0 ? ((((float) rect2.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) i3) : (((float) rect2.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) i3);
            }
            Rect rect3 = this.badgeBounds;
            float f4 = this.badgeCenterX;
            float f5 = this.badgeCenterY;
            float f6 = this.halfBadgeWidth;
            float f7 = this.halfBadgeHeight;
            rect3.set((int) (f4 - f6), (int) (f5 - f7), (int) (f4 + f6), (int) (f5 + f7));
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            materialShapeDrawable.drawableState.shapeAppearanceModel = materialShapeDrawable.drawableState.shapeAppearanceModel.withCornerSize(this.cornerRadius);
            materialShapeDrawable.invalidateSelf();
            if (!rect.equals(this.badgeBounds)) {
                this.shapeDrawable.setBounds(this.badgeBounds);
            }
        }
    }
}
