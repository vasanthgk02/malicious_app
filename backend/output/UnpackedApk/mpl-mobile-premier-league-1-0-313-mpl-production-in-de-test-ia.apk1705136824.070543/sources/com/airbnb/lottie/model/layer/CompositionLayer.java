package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public class CompositionLayer extends BaseLayer {
    public Paint layerPaint = new Paint();
    public final List<BaseLayer> layers = new ArrayList();
    public final RectF newClipRect = new RectF();
    public final RectF rect = new RectF();
    public BaseKeyframeAnimation<Float, Float> timeRemapping;

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        int i;
        BaseLayer baseLayer;
        super(lottieDrawable, layer);
        AnimatableFloatValue animatableFloatValue = layer.timeRemapping;
        if (animatableFloatValue != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = animatableFloatValue.createAnimation();
            this.timeRemapping = createAnimation;
            addAnimation(createAnimation);
            this.timeRemapping.listeners.add(this);
        } else {
            this.timeRemapping = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.layers.size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            int ordinal = layer2.layerType.ordinal();
            if (ordinal == 0) {
                baseLayer = new CompositionLayer(lottieDrawable, layer2, lottieComposition.precomps.get(layer2.refId), lottieComposition);
            } else if (ordinal == 1) {
                baseLayer = new SolidLayer(lottieDrawable, layer2);
            } else if (ordinal == 2) {
                baseLayer = new ImageLayer(lottieDrawable, layer2);
            } else if (ordinal == 3) {
                baseLayer = new NullLayer(lottieDrawable, layer2);
            } else if (ordinal == 4) {
                baseLayer = new ShapeLayer(lottieDrawable, layer2);
            } else if (ordinal != 5) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown layer type ");
                outline73.append(layer2.layerType);
                Logger.warning(outline73.toString());
                baseLayer = null;
            } else {
                baseLayer = new TextLayer(lottieDrawable, layer2);
            }
            if (baseLayer != null) {
                longSparseArray.put(baseLayer.layerModel.layerId, baseLayer);
                if (baseLayer2 != null) {
                    baseLayer2.matteLayer = baseLayer;
                    baseLayer2 = null;
                } else {
                    this.layers.add(0, baseLayer);
                    int ordinal2 = layer2.matteType.ordinal();
                    if (ordinal2 == 1 || ordinal2 == 2) {
                        baseLayer2 = baseLayer;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i));
            if (baseLayer3 != null) {
                BaseLayer baseLayer4 = (BaseLayer) longSparseArray.get(baseLayer3.layerModel.parentId);
                if (baseLayer4 != null) {
                    baseLayer3.parentLayer = baseLayer4;
                }
            }
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        this.transform.applyValueCallback(t, lottieValueCallback);
        if (t != LottieProperty.TIME_REMAP) {
            return;
        }
        if (lottieValueCallback == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.timeRemapping;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.setValueCallback(null);
                return;
            }
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
        this.timeRemapping = valueCallbackKeyframeAnimation;
        valueCallbackKeyframeAnimation.listeners.add(this);
        addAnimation(this.timeRemapping);
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        RectF rectF = this.newClipRect;
        Layer layer = this.layerModel;
        rectF.set(0.0f, 0.0f, (float) layer.preCompWidth, (float) layer.preCompHeight);
        matrix.mapRect(this.newClipRect);
        boolean z = this.lottieDrawable.isApplyingOpacityToLayersEnabled && this.layers.size() > 1 && i != 255;
        if (z) {
            this.layerPaint.setAlpha(i);
            Utils.saveLayerCompat(canvas, this.newClipRect, this.layerPaint, 31);
        } else {
            canvas.save();
        }
        if (z) {
            i = InvitationReply.EXPIRED;
        }
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            if (!this.newClipRect.isEmpty() ? canvas.clipRect(this.newClipRect) : true) {
                this.layers.get(size).draw(canvas, matrix, i);
            }
        }
        canvas.restore();
        L.endSection("CompositionLayer#draw");
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.layers.get(size).getBounds(this.rect, this.boundsMatrix, true);
            rectF.union(this.rect);
        }
    }

    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        for (int i2 = 0; i2 < this.layers.size(); i2++) {
            this.layers.get(i2).resolveKeyPath(keyPath, i, list, keyPath2);
        }
    }

    public void setOutlineMasksAndMattes(boolean z) {
        if (z && this.outlineMasksAndMattesPaint == null) {
            this.outlineMasksAndMattesPaint = new LPaint();
        }
        this.outlineMasksAndMattes = z;
        for (BaseLayer outlineMasksAndMattes : this.layers) {
            outlineMasksAndMattes.setOutlineMasksAndMattes(z);
        }
    }

    public void setProgress(float f2) {
        super.setProgress(f2);
        if (this.timeRemapping != null) {
            f2 = ((((Float) this.timeRemapping.getValue()).floatValue() * this.layerModel.composition.frameRate) - this.layerModel.composition.startFrame) / (this.lottieDrawable.composition.getDurationFrames() + 0.01f);
        }
        if (this.timeRemapping == null) {
            Layer layer = this.layerModel;
            f2 -= layer.startFrame / layer.composition.getDurationFrames();
        }
        float f3 = this.layerModel.timeStretch;
        if (f3 != 0.0f) {
            f2 /= f3;
        }
        int size = this.layers.size();
        while (true) {
            size--;
            if (size >= 0) {
                this.layers.get(size).setProgress(f2);
            } else {
                return;
            }
        }
    }
}
