package androidx.transition;

import android.view.View;
import android.view.ViewOverlay;

public class ViewOverlayApi18 implements ViewOverlayImpl {
    public final ViewOverlay mViewOverlay;

    public ViewOverlayApi18(View view) {
        this.mViewOverlay = view.getOverlay();
    }
}
