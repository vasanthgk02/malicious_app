package co.hyperverge.hypersnapsdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import co.hyperverge.hypersnapsdk.R$drawable;
import co.hyperverge.hypersnapsdk.R$layout;
import co.hyperverge.hypersnapsdk.f.h;

public class TopBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f3216a = 3;

    public TopBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            a();
        }
    }

    public final void a() {
        int i = 0;
        setOrientation(0);
        while (i < this.f3216a) {
            View inflate = LinearLayout.inflate(getContext(), R$layout.view_top_tick, null);
            if (i == 0) {
                inflate.setBackground(getContext().getDrawable(R$drawable.circular_dots));
            } else {
                inflate.setBackground(getContext().getDrawable(R$drawable.grey_dots));
            }
            int i2 = i + 1;
            inflate.setTag("dot" + i2);
            addView(inflate);
            if (i < 2) {
                View inflate2 = LinearLayout.inflate(getContext(), R$layout.view_bar, null);
                LayoutParams layoutParams = new LayoutParams(h.a(getContext(), 40.0f), h.a(getContext(), 1.0f));
                layoutParams.gravity = 17;
                inflate2.setTag("bar" + i2);
                inflate2.setLayoutParams(layoutParams);
                addView(inflate2);
            }
            i = i2;
        }
    }

    public TopBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            a();
        }
    }
}
