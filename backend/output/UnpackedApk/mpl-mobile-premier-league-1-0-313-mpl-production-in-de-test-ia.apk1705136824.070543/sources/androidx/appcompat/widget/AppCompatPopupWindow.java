package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.CompoundButtonCompat;

public class AppCompatPopupWindow extends PopupWindow {
    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    public final void init(Context context, AttributeSet attributeSet, int i, int i2) {
        Drawable drawable;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PopupWindow, i, i2);
        if (obtainStyledAttributes.hasValue(R$styleable.PopupWindow_overlapAnchor)) {
            CompoundButtonCompat.setOverlapAnchor(this, obtainStyledAttributes.getBoolean(R$styleable.PopupWindow_overlapAnchor, false));
        }
        int i3 = R$styleable.PopupWindow_android_popupBackground;
        if (obtainStyledAttributes.hasValue(i3)) {
            int resourceId = obtainStyledAttributes.getResourceId(i3, 0);
            if (resourceId != 0) {
                drawable = AppCompatResources.getDrawable(context, resourceId);
                setBackgroundDrawable(drawable);
                obtainStyledAttributes.recycle();
            }
        }
        drawable = obtainStyledAttributes.getDrawable(i3);
        setBackgroundDrawable(drawable);
        obtainStyledAttributes.recycle();
    }

    public void showAsDropDown(View view, int i, int i2) {
        super.showAsDropDown(view, i, i2);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, i2, i3, i4);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        super.showAsDropDown(view, i, i2, i3);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i, i2);
    }
}
