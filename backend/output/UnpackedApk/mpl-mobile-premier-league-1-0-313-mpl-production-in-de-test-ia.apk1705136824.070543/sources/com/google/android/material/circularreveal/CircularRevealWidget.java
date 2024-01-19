package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.circularreveal.CircularRevealHelper.Delegate;

public interface CircularRevealWidget extends Delegate {

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = new CircularRevealEvaluator();
        public final RevealInfo revealInfo = new RevealInfo(null);

        public Object evaluate(float f2, Object obj, Object obj2) {
            RevealInfo revealInfo2 = (RevealInfo) obj;
            RevealInfo revealInfo3 = (RevealInfo) obj2;
            RevealInfo revealInfo4 = this.revealInfo;
            float lerp = ImageOriginUtils.lerp(revealInfo2.centerX, revealInfo3.centerX, f2);
            float lerp2 = ImageOriginUtils.lerp(revealInfo2.centerY, revealInfo3.centerY, f2);
            float lerp3 = ImageOriginUtils.lerp(revealInfo2.radius, revealInfo3.radius, f2);
            revealInfo4.centerX = lerp;
            revealInfo4.centerY = lerp2;
            revealInfo4.radius = lerp3;
            return this.revealInfo;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");

        public CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        public Object get(Object obj) {
            return ((CircularRevealWidget) obj).getRevealInfo();
        }

        public void set(Object obj, Object obj2) {
            ((CircularRevealWidget) obj).setRevealInfo((RevealInfo) obj2);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        public CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        public Object get(Object obj) {
            return Integer.valueOf(((CircularRevealWidget) obj).getCircularRevealScrimColor());
        }

        public void set(Object obj, Object obj2) {
            ((CircularRevealWidget) obj).setCircularRevealScrimColor(((Integer) obj2).intValue());
        }
    }

    public static class RevealInfo {
        public float centerX;
        public float centerY;
        public float radius;

        public RevealInfo() {
        }

        public RevealInfo(AnonymousClass1 r1) {
        }

        public RevealInfo(float f2, float f3, float f4) {
            this.centerX = f2;
            this.centerY = f3;
            this.radius = f4;
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(RevealInfo revealInfo);
}
