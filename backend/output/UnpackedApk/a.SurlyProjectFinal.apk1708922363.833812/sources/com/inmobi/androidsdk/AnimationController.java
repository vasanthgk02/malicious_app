package com.inmobi.androidsdk;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.inmobi.androidsdk.IMAdView.AnimationType;
import com.inmobi.androidsdk.impl.anim.Rotate3dAnimation;
import com.inmobi.androidsdk.impl.anim.Rotate3dAnimationVert;

class AnimationController {
    private IMAdView advew;
    private AnimationListener manimlistner;

    public AnimationController(IMAdView advw, AnimationListener maniml) {
        this.advew = advw;
        this.manimlistner = maniml;
    }

    public void animateAndSwapWebView(AnimationType animtype) {
        if (animtype == AnimationType.ANIMATION_ALPHA) {
            AlphaAnimation typ1 = new AlphaAnimation(0.0f, 0.5f);
            AlphaAnimation typ2 = new AlphaAnimation(0.5f, 1.0f);
            typ1.setDuration(1000);
            typ1.setFillAfter(false);
            typ1.setAnimationListener(this.manimlistner);
            typ1.setInterpolator(new DecelerateInterpolator());
            typ2.setDuration(500);
            typ2.setFillAfter(false);
            typ2.setAnimationListener(this.manimlistner);
            typ2.setInterpolator(new DecelerateInterpolator());
            this.advew.setAnimFirstHalf(typ1);
            this.advew.setAnimSecHalf(typ2);
        } else if (animtype == AnimationType.ROTATE_HORIZONTAL_AXIS) {
            Rotate3dAnimation typ12 = new Rotate3dAnimation(0.0f, 90.0f, ((float) this.advew.getWidth()) / 2.0f, ((float) this.advew.getHeight()) / 2.0f, 0.0f, true);
            Rotate3dAnimation typ22 = new Rotate3dAnimation(270.0f, 360.0f, ((float) this.advew.getWidth()) / 2.0f, ((float) this.advew.getHeight()) / 2.0f, 0.0f, true);
            typ12.setDuration(500);
            typ12.setFillAfter(false);
            typ12.setAnimationListener(this.manimlistner);
            typ12.setInterpolator(new AccelerateInterpolator());
            typ22.setDuration(500);
            typ22.setFillAfter(false);
            typ22.setAnimationListener(this.manimlistner);
            typ22.setInterpolator(new DecelerateInterpolator());
            this.advew.setAnimFirstHalf(typ12);
            this.advew.setAnimSecHalf(typ22);
        } else if (animtype == AnimationType.ROTATE_VERTICAL_AXIS) {
            Rotate3dAnimationVert rotate3dAnimationVert = new Rotate3dAnimationVert(0.0f, 90.0f, ((float) this.advew.getWidth()) / 2.0f, ((float) this.advew.getHeight()) / 2.0f, 0.0f, true);
            Rotate3dAnimationVert typ23 = new Rotate3dAnimationVert(270.0f, 360.0f, ((float) this.advew.getWidth()) / 2.0f, ((float) this.advew.getHeight()) / 2.0f, 0.0f, true);
            rotate3dAnimationVert.setDuration(500);
            rotate3dAnimationVert.setFillAfter(false);
            rotate3dAnimationVert.setAnimationListener(this.manimlistner);
            rotate3dAnimationVert.setInterpolator(new AccelerateInterpolator());
            typ23.setDuration(500);
            typ23.setFillAfter(false);
            typ23.setAnimationListener(this.manimlistner);
            typ23.setInterpolator(new DecelerateInterpolator());
            this.advew.setAnimFirstHalf(rotate3dAnimationVert);
            this.advew.setAnimSecHalf(typ23);
        }
        this.advew.startAnimation(this.advew.getAnimFirstHalf());
    }
}
