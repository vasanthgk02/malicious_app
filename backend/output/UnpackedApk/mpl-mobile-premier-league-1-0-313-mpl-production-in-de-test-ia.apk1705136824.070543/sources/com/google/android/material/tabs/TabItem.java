package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R$styleable;

public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TabItem);
        this.text = obtainStyledAttributes.getText(R$styleable.TabItem_android_text);
        int i = R$styleable.TabItem_android_icon;
        if (obtainStyledAttributes.hasValue(i)) {
            int resourceId = obtainStyledAttributes.getResourceId(i, 0);
            if (resourceId != 0) {
                drawable = AppCompatResources.getDrawable(context, resourceId);
                this.icon = drawable;
                this.customLayout = obtainStyledAttributes.getResourceId(R$styleable.TabItem_android_layout, 0);
                obtainStyledAttributes.recycle();
            }
        }
        drawable = obtainStyledAttributes.getDrawable(i);
        this.icon = drawable;
        this.customLayout = obtainStyledAttributes.getResourceId(R$styleable.TabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
