package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public class PolystarContent implements PathContent, AnimationListener, KeyPathElementContent {
    public final boolean hidden;
    public final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    public final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    public boolean isPathValid;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    public final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    public final Path path = new Path();
    public final BaseKeyframeAnimation<?, Float> pointsAnimation;
    public final BaseKeyframeAnimation<?, PointF> positionAnimation;
    public final BaseKeyframeAnimation<?, Float> rotationAnimation;
    public CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
    public final Type type;

    public PolystarContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable2;
        this.name = polystarShape.name;
        this.type = polystarShape.type;
        this.hidden = polystarShape.hidden;
        this.pointsAnimation = polystarShape.points.createAnimation();
        this.positionAnimation = polystarShape.position.createAnimation();
        this.rotationAnimation = polystarShape.rotation.createAnimation();
        this.outerRadiusAnimation = polystarShape.outerRadius.createAnimation();
        this.outerRoundednessAnimation = polystarShape.outerRoundedness.createAnimation();
        if (this.type == Type.STAR) {
            this.innerRadiusAnimation = polystarShape.innerRadius.createAnimation();
            this.innerRoundednessAnimation = polystarShape.innerRoundedness.createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(this.pointsAnimation);
        baseLayer.addAnimation(this.positionAnimation);
        baseLayer.addAnimation(this.rotationAnimation);
        baseLayer.addAnimation(this.outerRadiusAnimation);
        baseLayer.addAnimation(this.outerRoundednessAnimation);
        if (this.type == Type.STAR) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        this.pointsAnimation.listeners.add(this);
        this.positionAnimation.listeners.add(this);
        this.rotationAnimation.listeners.add(this);
        this.outerRadiusAnimation.listeners.add(this);
        this.outerRoundednessAnimation.listeners.add(this);
        if (this.type == Type.STAR) {
            this.innerRadiusAnimation.listeners.add(this);
            this.innerRoundednessAnimation.listeners.add(this);
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else {
            if (t == LottieProperty.POLYSTAR_INNER_RADIUS) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.innerRadiusAnimation;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.setValueCallback(lottieValueCallback);
                    return;
                }
            }
            if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
                this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
                return;
            }
            if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
                if (baseKeyframeAnimation2 != null) {
                    baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
                    return;
                }
            }
            if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
                this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        float f2;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        double d3;
        float f11;
        float f12;
        double d4;
        double d5;
        double d6;
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int ordinal = this.type.ordinal();
        double d7 = 0.0d;
        if (ordinal == 0) {
            float floatValue = ((Float) this.pointsAnimation.getValue()).floatValue();
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
            if (baseKeyframeAnimation != null) {
                d7 = (double) ((Float) baseKeyframeAnimation.getValue()).floatValue();
            }
            double radians = Math.toRadians(d7 - 90.0d);
            double d8 = (double) floatValue;
            float f13 = (float) (6.283185307179586d / d8);
            float f14 = f13 / 2.0f;
            float f15 = floatValue - ((float) ((int) floatValue));
            int i = (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1));
            if (i != 0) {
                radians += (double) ((1.0f - f15) * f14);
            }
            float floatValue2 = ((Float) this.outerRadiusAnimation.getValue()).floatValue();
            float floatValue3 = ((Float) this.innerRadiusAnimation.getValue()).floatValue();
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
            float floatValue4 = baseKeyframeAnimation2 != null ? ((Float) baseKeyframeAnimation2.getValue()).floatValue() / 100.0f : 0.0f;
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.outerRoundednessAnimation;
            float floatValue5 = baseKeyframeAnimation3 != null ? ((Float) baseKeyframeAnimation3.getValue()).floatValue() / 100.0f : 0.0f;
            if (i != 0) {
                f6 = GeneratedOutlineSupport.outline3(floatValue2, floatValue3, f15, floatValue3);
                double d9 = (double) f6;
                f3 = floatValue3;
                f2 = floatValue4;
                f5 = (float) (Math.cos(radians) * d9);
                f4 = (float) (d9 * Math.sin(radians));
                this.path.moveTo(f5, f4);
                d2 = radians + ((double) ((f13 * f15) / 2.0f));
            } else {
                f3 = floatValue3;
                f2 = floatValue4;
                double d10 = (double) floatValue2;
                float cos = (float) (Math.cos(radians) * d10);
                f4 = (float) (Math.sin(radians) * d10);
                this.path.moveTo(cos, f4);
                d2 = radians + ((double) f14);
                f5 = cos;
                f6 = 0.0f;
            }
            double ceil = Math.ceil(d8) * 2.0d;
            float f16 = f14;
            int i2 = i;
            int i3 = 0;
            boolean z = false;
            while (true) {
                double d11 = (double) i3;
                if (d11 >= ceil) {
                    break;
                }
                float f17 = z ? floatValue2 : f3;
                int i4 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                if (i4 == 0 || d11 != ceil - 2.0d) {
                    f7 = f13;
                    f8 = f16;
                } else {
                    f7 = f13;
                    f8 = (f13 * f15) / 2.0f;
                }
                if (i4 == 0 || d11 != ceil - 1.0d) {
                    f9 = f6;
                    f6 = f17;
                    f10 = f8;
                } else {
                    f10 = f8;
                    f9 = f6;
                }
                double d12 = (double) f6;
                double d13 = d11;
                float cos2 = (float) (Math.cos(d2) * d12);
                float sin = (float) (d12 * Math.sin(d2));
                if (f2 == 0.0f && floatValue5 == 0.0f) {
                    this.path.lineTo(cos2, sin);
                    f11 = sin;
                    d3 = d2;
                    f12 = floatValue5;
                } else {
                    d3 = d2;
                    float f18 = f4;
                    float f19 = floatValue5;
                    double atan2 = (double) ((float) (Math.atan2((double) f4, (double) f5) - 1.5707963267948966d));
                    float cos3 = (float) Math.cos(atan2);
                    float sin2 = (float) Math.sin(atan2);
                    float f20 = f18;
                    f11 = sin;
                    f12 = f19;
                    double atan22 = (double) ((float) (Math.atan2((double) sin, (double) cos2) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan22);
                    float sin3 = (float) Math.sin(atan22);
                    float f21 = z ? f2 : f12;
                    float f22 = z ? f12 : f2;
                    float f23 = (z ? f3 : floatValue2) * f21 * 0.47829f;
                    float f24 = cos3 * f23;
                    float f25 = f23 * sin2;
                    float f26 = (z ? floatValue2 : f3) * f22 * 0.47829f;
                    float f27 = cos4 * f26;
                    float f28 = f26 * sin3;
                    if (i2 != 0) {
                        if (i3 == 0) {
                            f24 *= f15;
                            f25 *= f15;
                        } else if (d13 == ceil - 1.0d) {
                            f27 *= f15;
                            f28 *= f15;
                        }
                    }
                    this.path.cubicTo(f5 - f24, f20 - f25, cos2 + f27, f11 + f28, cos2, f11);
                }
                d2 = d3 + ((double) f10);
                z = !z;
                i3++;
                f5 = cos2;
                f6 = f9;
                f13 = f7;
                f4 = f11;
                floatValue5 = f12;
            }
            PointF pointF = (PointF) this.positionAnimation.getValue();
            this.path.offset(pointF.x, pointF.y);
            this.path.close();
        } else if (ordinal == 1) {
            int floor = (int) Math.floor((double) ((Float) this.pointsAnimation.getValue()).floatValue());
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation4 = this.rotationAnimation;
            if (baseKeyframeAnimation4 != null) {
                d7 = (double) ((Float) baseKeyframeAnimation4.getValue()).floatValue();
            }
            double radians2 = Math.toRadians(d7 - 90.0d);
            double d14 = (double) floor;
            float floatValue6 = ((Float) this.outerRoundednessAnimation.getValue()).floatValue() / 100.0f;
            float floatValue7 = ((Float) this.outerRadiusAnimation.getValue()).floatValue();
            double d15 = (double) floatValue7;
            float cos5 = (float) (Math.cos(radians2) * d15);
            float sin4 = (float) (Math.sin(radians2) * d15);
            this.path.moveTo(cos5, sin4);
            double d16 = (double) ((float) (6.283185307179586d / d14));
            double d17 = radians2 + d16;
            double ceil2 = Math.ceil(d14);
            int i5 = 0;
            while (((double) i5) < ceil2) {
                float cos6 = (float) (Math.cos(d17) * d15);
                double d18 = ceil2;
                float sin5 = (float) (Math.sin(d17) * d15);
                if (floatValue6 != 0.0f) {
                    d6 = d15;
                    d5 = d17;
                    double atan23 = (double) ((float) (Math.atan2((double) sin4, (double) cos5) - 1.5707963267948966d));
                    float cos7 = (float) Math.cos(atan23);
                    d4 = d16;
                    double atan24 = (double) ((float) (Math.atan2((double) sin5, (double) cos6) - 1.5707963267948966d));
                    float f29 = floatValue7 * floatValue6 * 0.25f;
                    this.path.cubicTo(cos5 - (cos7 * f29), sin4 - (((float) Math.sin(atan23)) * f29), cos6 + (((float) Math.cos(atan24)) * f29), sin5 + (f29 * ((float) Math.sin(atan24))), cos6, sin5);
                } else {
                    d5 = d17;
                    d6 = d15;
                    d4 = d16;
                    this.path.lineTo(cos6, sin5);
                }
                d17 = d5 + d4;
                i5++;
                sin4 = sin5;
                cos5 = cos6;
                ceil2 = d18;
                d15 = d6;
                d16 = d4;
            }
            PointF pointF2 = (PointF) this.positionAnimation.getValue();
            this.path.offset(pointF2.x, pointF2.y);
            this.path.close();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    public void onValueChanged() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.type == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.contents.add(trimPathContent);
                    trimPathContent.listeners.add(this);
                }
            }
        }
    }
}
