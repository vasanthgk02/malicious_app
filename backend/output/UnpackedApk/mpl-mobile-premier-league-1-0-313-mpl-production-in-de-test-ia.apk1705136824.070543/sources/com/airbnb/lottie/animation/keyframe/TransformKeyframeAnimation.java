package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

public class TransformKeyframeAnimation {
    public BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    public BaseKeyframeAnimation<?, Float> endOpacity;
    public final Matrix matrix = new Matrix();
    public BaseKeyframeAnimation<Integer, Integer> opacity;
    public BaseKeyframeAnimation<?, PointF> position;
    public BaseKeyframeAnimation<Float, Float> rotation;
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    public FloatKeyframeAnimation skew;
    public FloatKeyframeAnimation skewAngle;
    public final Matrix skewMatrix1;
    public final Matrix skewMatrix2;
    public final Matrix skewMatrix3;
    public final float[] skewValues;
    public BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4;
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        AnimatablePathValue animatablePathValue = animatableTransform.anchorPoint;
        if (animatablePathValue == null) {
            baseKeyframeAnimation = null;
        } else {
            baseKeyframeAnimation = animatablePathValue.createAnimation();
        }
        this.anchorPoint = baseKeyframeAnimation;
        AnimatableValue<PointF, PointF> animatableValue = animatableTransform.position;
        if (animatableValue == null) {
            baseKeyframeAnimation2 = null;
        } else {
            baseKeyframeAnimation2 = animatableValue.createAnimation();
        }
        this.position = baseKeyframeAnimation2;
        AnimatableScaleValue animatableScaleValue = animatableTransform.scale;
        if (animatableScaleValue == null) {
            baseKeyframeAnimation3 = null;
        } else {
            baseKeyframeAnimation3 = animatableScaleValue.createAnimation();
        }
        this.scale = baseKeyframeAnimation3;
        AnimatableFloatValue animatableFloatValue = animatableTransform.rotation;
        if (animatableFloatValue == null) {
            baseKeyframeAnimation4 = null;
        } else {
            baseKeyframeAnimation4 = animatableFloatValue.createAnimation();
        }
        this.rotation = baseKeyframeAnimation4;
        AnimatableFloatValue animatableFloatValue2 = animatableTransform.skew;
        if (animatableFloatValue2 == null) {
            floatKeyframeAnimation = null;
        } else {
            floatKeyframeAnimation = (FloatKeyframeAnimation) animatableFloatValue2.createAnimation();
        }
        this.skew = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.skewMatrix1 = new Matrix();
            this.skewMatrix2 = new Matrix();
            this.skewMatrix3 = new Matrix();
            this.skewValues = new float[9];
        } else {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        AnimatableFloatValue animatableFloatValue3 = animatableTransform.skewAngle;
        if (animatableFloatValue3 == null) {
            floatKeyframeAnimation2 = null;
        } else {
            floatKeyframeAnimation2 = (FloatKeyframeAnimation) animatableFloatValue3.createAnimation();
        }
        this.skewAngle = floatKeyframeAnimation2;
        AnimatableIntegerValue animatableIntegerValue = animatableTransform.opacity;
        if (animatableIntegerValue != null) {
            this.opacity = animatableIntegerValue.createAnimation();
        }
        AnimatableFloatValue animatableFloatValue4 = animatableTransform.startOpacity;
        if (animatableFloatValue4 != null) {
            this.startOpacity = animatableFloatValue4.createAnimation();
        } else {
            this.startOpacity = null;
        }
        AnimatableFloatValue animatableFloatValue5 = animatableTransform.endOpacity;
        if (animatableFloatValue5 != null) {
            this.endOpacity = animatableFloatValue5.createAnimation();
        } else {
            this.endOpacity = null;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.opacity);
        baseLayer.addAnimation(this.startOpacity);
        baseLayer.addAnimation(this.endOpacity);
        baseLayer.addAnimation(this.anchorPoint);
        baseLayer.addAnimation(this.position);
        baseLayer.addAnimation(this.scale);
        baseLayer.addAnimation(this.rotation);
        baseLayer.addAnimation(this.skew);
        baseLayer.addAnimation(this.skewAngle);
    }

    public void addListener(AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.listeners.add(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.listeners.add(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.listeners.add(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.listeners.add(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.listeners.add(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.listeners.add(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.listeners.add(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.listeners.add(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.listeners.add(animationListener);
        }
    }

    public <T> boolean applyValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation = this.anchorPoint;
            if (baseKeyframeAnimation == null) {
                this.anchorPoint = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
            } else {
                baseKeyframeAnimation.setValueCallback(lottieValueCallback);
            }
        } else if (t == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.position;
            if (baseKeyframeAnimation2 == null) {
                this.position = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
            } else {
                baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            }
        } else {
            if (t == LottieProperty.TRANSFORM_POSITION_X) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation3 = this.position;
                if (baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                    SplitDimensionPathKeyframeAnimation splitDimensionPathKeyframeAnimation = (SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation3;
                    LottieValueCallback<Float> lottieValueCallback2 = splitDimensionPathKeyframeAnimation.xValueCallback;
                    splitDimensionPathKeyframeAnimation.xValueCallback = lottieValueCallback;
                }
            }
            if (t == LottieProperty.TRANSFORM_POSITION_Y) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.position;
                if (baseKeyframeAnimation4 instanceof SplitDimensionPathKeyframeAnimation) {
                    SplitDimensionPathKeyframeAnimation splitDimensionPathKeyframeAnimation2 = (SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation4;
                    LottieValueCallback<Float> lottieValueCallback3 = splitDimensionPathKeyframeAnimation2.yValueCallback;
                    splitDimensionPathKeyframeAnimation2.yValueCallback = lottieValueCallback;
                }
            }
            if (t == LottieProperty.TRANSFORM_SCALE) {
                BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.scale;
                if (baseKeyframeAnimation5 == null) {
                    this.scale = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                } else {
                    baseKeyframeAnimation5.setValueCallback(lottieValueCallback);
                }
            } else if (t == LottieProperty.TRANSFORM_ROTATION) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.rotation;
                if (baseKeyframeAnimation6 == null) {
                    this.rotation = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                } else {
                    baseKeyframeAnimation6.setValueCallback(lottieValueCallback);
                }
            } else if (t == LottieProperty.TRANSFORM_OPACITY) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.opacity;
                if (baseKeyframeAnimation7 == null) {
                    this.opacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, Integer.valueOf(100));
                } else {
                    baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
                }
            } else {
                if (t == LottieProperty.TRANSFORM_START_OPACITY) {
                    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation8 = this.startOpacity;
                    if (baseKeyframeAnimation8 != null) {
                        if (baseKeyframeAnimation8 == null) {
                            this.startOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, Integer.valueOf(100));
                        } else {
                            baseKeyframeAnimation8.setValueCallback(lottieValueCallback);
                        }
                    }
                }
                if (t == LottieProperty.TRANSFORM_END_OPACITY) {
                    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation9 = this.endOpacity;
                    if (baseKeyframeAnimation9 != null) {
                        if (baseKeyframeAnimation9 == null) {
                            this.endOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, Integer.valueOf(100));
                        } else {
                            baseKeyframeAnimation9.setValueCallback(lottieValueCallback);
                        }
                    }
                }
                if (t == LottieProperty.TRANSFORM_SKEW) {
                    FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
                    if (floatKeyframeAnimation != null) {
                        if (floatKeyframeAnimation == null) {
                            this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                        }
                        this.skew.setValueCallback(lottieValueCallback);
                    }
                }
                if (t == LottieProperty.TRANSFORM_SKEW_ANGLE) {
                    FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
                    if (floatKeyframeAnimation2 != null) {
                        if (floatKeyframeAnimation2 == null) {
                            this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                        }
                        this.skewAngle.setValueCallback(lottieValueCallback);
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final void clearSkewValues() {
        for (int i = 0; i < 9; i++) {
            this.skewValues[i] = 0.0f;
        }
    }

    public Matrix getMatrix() {
        float f2;
        this.matrix.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
        if (baseKeyframeAnimation != null) {
            PointF pointF = (PointF) baseKeyframeAnimation.getValue();
            if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
                this.matrix.preTranslate(pointF.x, pointF.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.rotation;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
                f2 = ((Float) baseKeyframeAnimation2.getValue()).floatValue();
            } else {
                f2 = ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
            }
            if (f2 != 0.0f) {
                this.matrix.preRotate(f2);
            }
        }
        if (this.skew != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = this.skewAngle;
            float cos = floatKeyframeAnimation == null ? 0.0f : (float) Math.cos(Math.toRadians((double) ((-floatKeyframeAnimation.getFloatValue()) + 90.0f)));
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
            float sin = floatKeyframeAnimation2 == null ? 1.0f : (float) Math.sin(Math.toRadians((double) ((-floatKeyframeAnimation2.getFloatValue()) + 90.0f)));
            clearSkewValues();
            float[] fArr = this.skewValues;
            fArr[0] = cos;
            fArr[1] = sin;
            float f3 = -sin;
            fArr[3] = f3;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.skewMatrix1.setValues(fArr);
            clearSkewValues();
            float[] fArr2 = this.skewValues;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians((double) this.skew.getFloatValue()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.skewMatrix2.setValues(fArr2);
            clearSkewValues();
            float[] fArr3 = this.skewValues;
            fArr3[0] = cos;
            fArr3[1] = f3;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.skewMatrix3.setValues(fArr3);
            this.skewMatrix2.preConcat(this.skewMatrix1);
            this.skewMatrix3.preConcat(this.skewMatrix2);
            this.matrix.preConcat(this.skewMatrix3);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.scale;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY scaleXY = (ScaleXY) baseKeyframeAnimation3.getValue();
            if (!(scaleXY.scaleX == 1.0f && scaleXY.scaleY == 1.0f)) {
                this.matrix.preScale(scaleXY.scaleX, scaleXY.scaleY);
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            PointF pointF2 = (PointF) baseKeyframeAnimation4.getValue();
            if (!(pointF2.x == 0.0f && pointF2.y == 0.0f)) {
                this.matrix.preTranslate(-pointF2.x, -pointF2.y);
            }
        }
        return this.matrix;
    }

    public Matrix getMatrixForRepeater(float f2) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
        PointF pointF = null;
        PointF pointF2 = baseKeyframeAnimation == null ? null : (PointF) baseKeyframeAnimation.getValue();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.scale;
        ScaleXY scaleXY = baseKeyframeAnimation2 == null ? null : (ScaleXY) baseKeyframeAnimation2.getValue();
        this.matrix.reset();
        if (pointF2 != null) {
            this.matrix.preTranslate(pointF2.x * f2, pointF2.y * f2);
        }
        if (scaleXY != null) {
            double d2 = (double) f2;
            this.matrix.preScale((float) Math.pow((double) scaleXY.scaleX, d2), (float) Math.pow((double) scaleXY.scaleY, d2));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.rotation;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = ((Float) baseKeyframeAnimation3.getValue()).floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
            if (baseKeyframeAnimation4 != null) {
                pointF = (PointF) baseKeyframeAnimation4.getValue();
            }
            Matrix matrix2 = this.matrix;
            float f3 = floatValue * f2;
            float f4 = 0.0f;
            float f5 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f4 = pointF.y;
            }
            matrix2.preRotate(f3, f5, f4);
        }
        return this.matrix;
    }
}
