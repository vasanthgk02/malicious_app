package com.swmansion.rnscreens;

import android.view.View.MeasureSpec;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/swmansion/rnscreens/ScreenContainer$mLayoutCallback$1", "Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;", "doFrame", "", "frameTimeNanos", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenContainer.kt */
public final class ScreenContainer$mLayoutCallback$1 extends FrameCallback {
    public final /* synthetic */ ScreenContainer<T> this$0;

    public ScreenContainer$mLayoutCallback$1(ScreenContainer<T> screenContainer) {
        this.this$0 = screenContainer;
    }

    public void doFrame(long j) {
        ScreenContainer<T> screenContainer = this.this$0;
        screenContainer.mLayoutEnqueued = false;
        screenContainer.measure(MeasureSpec.makeMeasureSpec(screenContainer.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(this.this$0.getHeight(), 1073741824));
        ScreenContainer<T> screenContainer2 = this.this$0;
        screenContainer2.layout(screenContainer2.getLeft(), this.this$0.getTop(), this.this$0.getRight(), this.this$0.getBottom());
    }
}
