package com.swmansion.rnscreens;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.swmansion.rnscreens.ScreenStackFragment.ScreensCoordinatorLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/swmansion/rnscreens/ScreenStackFragment$ScreensCoordinatorLayout$mAnimationListener$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenStackFragment.kt */
public final class ScreenStackFragment$ScreensCoordinatorLayout$mAnimationListener$1 implements AnimationListener {
    public final /* synthetic */ ScreensCoordinatorLayout this$0;

    public ScreenStackFragment$ScreensCoordinatorLayout$mAnimationListener$1(ScreensCoordinatorLayout screensCoordinatorLayout) {
        this.this$0 = screensCoordinatorLayout;
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.mFragment.onViewAnimationEnd();
    }

    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.mFragment.dispatchViewAnimationEvent(false);
    }
}
