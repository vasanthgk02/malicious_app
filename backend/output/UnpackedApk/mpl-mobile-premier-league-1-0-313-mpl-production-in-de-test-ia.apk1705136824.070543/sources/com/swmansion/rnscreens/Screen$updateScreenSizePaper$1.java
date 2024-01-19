package com.swmansion.rnscreens;

import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/Screen$updateScreenSizePaper$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Screen.kt */
public final class Screen$updateScreenSizePaper$1 extends GuardedRunnable {
    public final /* synthetic */ int $height;
    public final /* synthetic */ ReactContext $reactContext;
    public final /* synthetic */ int $width;
    public final /* synthetic */ Screen this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Screen$updateScreenSizePaper$1(ReactContext reactContext, Screen screen, int i, int i2) {
        // this.$reactContext = reactContext;
        // this.this$0 = screen;
        // this.$width = i;
        // this.$height = i2;
        super(reactContext);
    }

    public void runGuarded() {
        UIManagerModule uIManagerModule = (UIManagerModule) this.$reactContext.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.updateNodeSize(this.this$0.getId(), this.$width, this.$height);
        }
    }
}
