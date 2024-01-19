package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class ToggleImageButton extends ImageButton {
    public static final int[] STATE_TOGGLED_ON = {R$attr.state_toggled_on};
    public String contentDescriptionOff;
    public String contentDescriptionOn;
    public boolean isToggledOn;
    public final boolean toggleOnClick;

    public ToggleImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (this.isToggledOn) {
            ImageButton.mergeDrawableStates(onCreateDrawableState, STATE_TOGGLED_ON);
        }
        return onCreateDrawableState;
    }

    public boolean performClick() {
        if (this.toggleOnClick) {
            setToggledOn(!this.isToggledOn);
        }
        return super.performClick();
    }

    public void setToggledOn(boolean z) {
        this.isToggledOn = z;
        setContentDescription(z ? this.contentDescriptionOn : this.contentDescriptionOff);
        refreshDrawableState();
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArray = null;
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ToggleImageButton, i, 0);
            String string = obtainStyledAttributes.getString(R$styleable.ToggleImageButton_contentDescriptionOn);
            String string2 = obtainStyledAttributes.getString(R$styleable.ToggleImageButton_contentDescriptionOff);
            this.contentDescriptionOn = string == null ? (String) getContentDescription() : string;
            this.contentDescriptionOff = string2 == null ? (String) getContentDescription() : string2;
            this.toggleOnClick = obtainStyledAttributes.getBoolean(R$styleable.ToggleImageButton_toggleOnClick, true);
            setToggledOn(false);
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }
}
