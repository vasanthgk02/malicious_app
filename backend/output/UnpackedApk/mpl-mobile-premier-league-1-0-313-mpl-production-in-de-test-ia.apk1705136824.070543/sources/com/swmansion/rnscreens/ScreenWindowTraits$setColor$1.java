package com.swmansion.rnscreens;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.view.Window;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/ScreenWindowTraits$setColor$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits$setColor$1 extends GuardedRunnable {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ boolean $animated;
    public final /* synthetic */ Integer $color;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ScreenWindowTraits$setColor$1(ReactContext reactContext, Activity activity, Integer num, boolean z) {
        // this.$activity = activity;
        // this.$color = num;
        // this.$animated = z;
        super(reactContext);
    }

    /* renamed from: runGuarded$lambda-0  reason: not valid java name */
    public static final void m107runGuarded$lambda0(Window window, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            window.setStatusBarColor(((Integer) animatedValue).intValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public void runGuarded() {
        Window window = this.$activity.getWindow();
        int statusBarColor = window.getStatusBarColor();
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(statusBarColor), this.$color});
        ofObject.addUpdateListener(new AnimatorUpdateListener(window) {
            public final /* synthetic */ Window f$0;

            {
                this.f$0 = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScreenWindowTraits$setColor$1.m107runGuarded$lambda0(this.f$0, valueAnimator);
            }
        });
        if (this.$animated) {
            ofObject.setDuration(300).setStartDelay(0);
        } else {
            ofObject.setDuration(0).setStartDelay(300);
        }
        ofObject.start();
    }
}
