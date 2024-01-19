package dmax.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ProgressLayout extends FrameLayout {
    public int spotsCount;

    public ProgressLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getSpotsCount() {
        return this.spotsCount;
    }

    public ProgressLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.Dialog, i, 0);
        this.spotsCount = obtainStyledAttributes.getInt(R$styleable.Dialog_DialogSpotCount, 5);
        obtainStyledAttributes.recycle();
    }
}
