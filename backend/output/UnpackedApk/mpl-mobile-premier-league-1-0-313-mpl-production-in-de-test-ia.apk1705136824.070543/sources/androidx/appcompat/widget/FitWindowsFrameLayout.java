package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass4;

public class FitWindowsFrameLayout extends FrameLayout {
    public FitWindowsViewGroup$OnFitSystemWindowsListener mListener;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean fitSystemWindows(Rect rect) {
        FitWindowsViewGroup$OnFitSystemWindowsListener fitWindowsViewGroup$OnFitSystemWindowsListener = this.mListener;
        if (fitWindowsViewGroup$OnFitSystemWindowsListener != null) {
            rect.top = ((AnonymousClass4) fitWindowsViewGroup$OnFitSystemWindowsListener).this$0.updateStatusGuard(null, rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(FitWindowsViewGroup$OnFitSystemWindowsListener fitWindowsViewGroup$OnFitSystemWindowsListener) {
        this.mListener = fitWindowsViewGroup$OnFitSystemWindowsListener;
    }
}
