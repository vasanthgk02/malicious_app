package co.hyperverge.hypersnapsdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import co.hyperverge.hypersnapsdk.f.h;

public class ScalableImageView extends ImageView {
    public ScalableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        if (getDrawable() != null) {
            int a2 = h.a(getContext(), 120.0f);
            if (h.e(getContext())) {
                a2 = h.a(getContext(), 100.0f);
            }
            setMeasuredDimension(a2, a2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public ScalableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
