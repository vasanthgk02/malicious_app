package com.swmansion.rnscreens;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/ScreenWindowTraits$setTranslucent$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits$setTranslucent$1 extends GuardedRunnable {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ boolean $translucent;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ScreenWindowTraits$setTranslucent$1(ReactContext reactContext, Activity activity, boolean z) {
        // this.$activity = activity;
        // this.$translucent = z;
        super(reactContext);
    }

    /* renamed from: runGuarded$lambda-0  reason: not valid java name */
    public static final WindowInsetsCompat m108runGuarded$lambda0(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        Intrinsics.checkNotNullExpressionValue(onApplyWindowInsets, "onApplyWindowInsets(v, insets)");
        return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
    }

    @TargetApi(21)
    public void runGuarded() {
        View decorView = this.$activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        if (this.$translucent) {
            ViewCompat.setOnApplyWindowInsetsListener(decorView, $$Lambda$x8OccbQJUvrWnqha1JOvYfLs4Gc.INSTANCE);
        } else {
            ViewCompat.setOnApplyWindowInsetsListener(decorView, null);
        }
        ViewCompat.requestApplyInsets(decorView);
    }
}
