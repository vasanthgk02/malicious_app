package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.PerformanceTracker.FrameListener;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer.MatteType;
import com.airbnb.lottie.utils.MeanCalculator;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseLayer implements DrawingContent, AnimationListener, KeyPathElement {
    public final List<BaseKeyframeAnimation<?, ?>> animations;
    public final Matrix boundsMatrix;
    public final Paint clearPaint;
    public final Paint contentPaint;
    public final String drawTraceName;
    public final Paint dstInPaint;
    public final Paint dstOutPaint;
    public FloatKeyframeAnimation inOutAnimation;
    public final Layer layerModel;
    public final LottieDrawable lottieDrawable;
    public MaskKeyframeAnimation mask;
    public final RectF maskBoundsRect;
    public final Matrix matrix = new Matrix();
    public final RectF matteBoundsRect;
    public BaseLayer matteLayer;
    public final Paint mattePaint;
    public boolean outlineMasksAndMattes;
    public Paint outlineMasksAndMattesPaint;
    public BaseLayer parentLayer;
    public List<BaseLayer> parentLayers;
    public final Path path = new Path();
    public final RectF rect;
    public final RectF tempMaskBoundsRect;
    public final TransformKeyframeAnimation transform;
    public boolean visible;

    public BaseLayer(LottieDrawable lottieDrawable2, Layer layer) {
        boolean z = true;
        this.contentPaint = new LPaint(1);
        this.dstInPaint = new LPaint(1, Mode.DST_IN);
        this.dstOutPaint = new LPaint(1, Mode.DST_OUT);
        this.mattePaint = new LPaint(1);
        this.clearPaint = new LPaint(Mode.CLEAR);
        this.rect = new RectF();
        this.maskBoundsRect = new RectF();
        this.matteBoundsRect = new RectF();
        this.tempMaskBoundsRect = new RectF();
        this.boundsMatrix = new Matrix();
        this.animations = new ArrayList();
        this.visible = true;
        this.lottieDrawable = lottieDrawable2;
        this.layerModel = layer;
        this.drawTraceName = GeneratedOutlineSupport.outline62(new StringBuilder(), layer.layerName, "#draw");
        if (layer.matteType == MatteType.INVERT) {
            this.mattePaint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        } else {
            this.mattePaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        }
        AnimatableTransform animatableTransform = layer.transform;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
            this.transform = transformKeyframeAnimation;
            transformKeyframeAnimation.addListener(this);
            List<Mask> list = layer.masks;
            if (list != null && !list.isEmpty()) {
                MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.masks);
                this.mask = maskKeyframeAnimation;
                for (BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation : maskKeyframeAnimation.maskAnimations) {
                    baseKeyframeAnimation.listeners.add(this);
                }
                for (BaseKeyframeAnimation next : this.mask.opacityAnimations) {
                    addAnimation(next);
                    next.listeners.add(this);
                }
            }
            if (!this.layerModel.inOutKeyframes.isEmpty()) {
                FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.layerModel.inOutKeyframes);
                this.inOutAnimation = floatKeyframeAnimation;
                floatKeyframeAnimation.isDiscrete = true;
                floatKeyframeAnimation.listeners.add(new AnimationListener() {
                    public void onValueChanged() {
                        BaseLayer baseLayer = BaseLayer.this;
                        boolean z = baseLayer.inOutAnimation.getFloatValue() == 1.0f;
                        if (z != baseLayer.visible) {
                            baseLayer.visible = z;
                            baseLayer.lottieDrawable.invalidateSelf();
                        }
                    }
                });
                setVisible(((Float) this.inOutAnimation.getValue()).floatValue() != 1.0f ? false : z);
                addAnimation(this.inOutAnimation);
                return;
            }
            setVisible(true);
            return;
        }
        throw null;
    }

    public void addAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation != null) {
            this.animations.add(baseKeyframeAnimation);
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        this.transform.applyValueCallback(t, lottieValueCallback);
    }

    public final void buildParentLayerListIfNeeded() {
        if (this.parentLayers == null) {
            if (this.parentLayer == null) {
                this.parentLayers = Collections.emptyList();
                return;
            }
            this.parentLayers = new ArrayList();
            for (BaseLayer baseLayer = this.parentLayer; baseLayer != null; baseLayer = baseLayer.parentLayer) {
                this.parentLayers.add(baseLayer);
            }
        }
    }

    public final void clearCanvas(Canvas canvas) {
        RectF rectF = this.rect;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.clearPaint);
        L.endSection("Layer#clearLayer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x03b9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x025a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r18, android.graphics.Matrix r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.visible
            if (r3 == 0) goto L_0x0430
            com.airbnb.lottie.model.layer.Layer r3 = r0.layerModel
            boolean r3 = r3.hidden
            if (r3 == 0) goto L_0x0012
            goto L_0x0430
        L_0x0012:
            r17.buildParentLayerListIfNeeded()
            android.graphics.Matrix r3 = r0.matrix
            r3.reset()
            android.graphics.Matrix r3 = r0.matrix
            r3.set(r2)
            java.util.List<com.airbnb.lottie.model.layer.BaseLayer> r3 = r0.parentLayers
            int r3 = r3.size()
            r4 = 1
            int r3 = r3 - r4
        L_0x0027:
            if (r3 < 0) goto L_0x003f
            android.graphics.Matrix r5 = r0.matrix
            java.util.List<com.airbnb.lottie.model.layer.BaseLayer> r6 = r0.parentLayers
            java.lang.Object r6 = r6.get(r3)
            com.airbnb.lottie.model.layer.BaseLayer r6 = (com.airbnb.lottie.model.layer.BaseLayer) r6
            com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation r6 = r6.transform
            android.graphics.Matrix r6 = r6.getMatrix()
            r5.preConcat(r6)
            int r3 = r3 + -1
            goto L_0x0027
        L_0x003f:
            java.lang.String r3 = "Layer#parentMatrix"
            com.airbnb.lottie.L.endSection(r3)
            com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation r3 = r0.transform
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r3 = r3.opacity
            if (r3 != 0) goto L_0x004d
            r3 = 100
            goto L_0x0057
        L_0x004d:
            java.lang.Object r3 = r3.getValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
        L_0x0057:
            r5 = r20
            float r5 = (float) r5
            r6 = 1132396544(0x437f0000, float:255.0)
            float r5 = r5 / r6
            float r3 = (float) r3
            float r5 = r5 * r3
            r3 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 / r3
            float r5 = r5 * r6
            int r3 = (int) r5
            boolean r5 = r17.hasMatteOnThisLayer()
            java.lang.String r6 = "Layer#drawLayer"
            r7 = 0
            if (r5 != 0) goto L_0x0091
            boolean r5 = r17.hasMasksOnThisLayer()
            if (r5 != 0) goto L_0x0091
            android.graphics.Matrix r2 = r0.matrix
            com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation r4 = r0.transform
            android.graphics.Matrix r4 = r4.getMatrix()
            r2.preConcat(r4)
            android.graphics.Matrix r2 = r0.matrix
            r0.drawLayer(r1, r2, r3)
            com.airbnb.lottie.L.endSection(r6)
            java.lang.String r1 = r0.drawTraceName
            com.airbnb.lottie.L.endSection(r1)
            r0.recordRenderTime(r7)
            return
        L_0x0091:
            android.graphics.RectF r5 = r0.rect
            android.graphics.Matrix r8 = r0.matrix
            r9 = 0
            r0.getBounds(r5, r8, r9)
            android.graphics.RectF r5 = r0.rect
            boolean r8 = r17.hasMatteOnThisLayer()
            if (r8 != 0) goto L_0x00a2
            goto L_0x00c2
        L_0x00a2:
            com.airbnb.lottie.model.layer.Layer r8 = r0.layerModel
            com.airbnb.lottie.model.layer.Layer$MatteType r8 = r8.matteType
            com.airbnb.lottie.model.layer.Layer$MatteType r10 = com.airbnb.lottie.model.layer.Layer.MatteType.INVERT
            if (r8 != r10) goto L_0x00ab
            goto L_0x00c2
        L_0x00ab:
            android.graphics.RectF r8 = r0.matteBoundsRect
            r8.set(r7, r7, r7, r7)
            com.airbnb.lottie.model.layer.BaseLayer r8 = r0.matteLayer
            android.graphics.RectF r10 = r0.matteBoundsRect
            r8.getBounds(r10, r2, r4)
            android.graphics.RectF r8 = r0.matteBoundsRect
            boolean r8 = r5.intersect(r8)
            if (r8 != 0) goto L_0x00c2
            r5.set(r7, r7, r7, r7)
        L_0x00c2:
            android.graphics.Matrix r5 = r0.matrix
            com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation r8 = r0.transform
            android.graphics.Matrix r8 = r8.getMatrix()
            r5.preConcat(r8)
            android.graphics.RectF r5 = r0.rect
            android.graphics.Matrix r8 = r0.matrix
            android.graphics.RectF r10 = r0.maskBoundsRect
            r10.set(r7, r7, r7, r7)
            boolean r10 = r17.hasMasksOnThisLayer()
            r11 = 3
            r12 = 2
            if (r10 != 0) goto L_0x00e0
            goto L_0x017d
        L_0x00e0:
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r10 = r0.mask
            java.util.List<com.airbnb.lottie.model.content.Mask> r10 = r10.masks
            int r10 = r10.size()
            r13 = 0
        L_0x00e9:
            if (r13 >= r10) goto L_0x016f
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r14 = r0.mask
            java.util.List<com.airbnb.lottie.model.content.Mask> r14 = r14.masks
            java.lang.Object r14 = r14.get(r13)
            com.airbnb.lottie.model.content.Mask r14 = (com.airbnb.lottie.model.content.Mask) r14
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r15 = r0.mask
            java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path>> r15 = r15.maskAnimations
            java.lang.Object r15 = r15.get(r13)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r15 = (com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation) r15
            java.lang.Object r15 = r15.getValue()
            android.graphics.Path r15 = (android.graphics.Path) r15
            android.graphics.Path r7 = r0.path
            r7.set(r15)
            android.graphics.Path r7 = r0.path
            r7.transform(r8)
            com.airbnb.lottie.model.content.Mask$MaskMode r7 = r14.maskMode
            int r7 = r7.ordinal()
            if (r7 == 0) goto L_0x011e
            if (r7 == r4) goto L_0x017c
            if (r7 == r12) goto L_0x011e
            if (r7 == r11) goto L_0x017c
            goto L_0x0123
        L_0x011e:
            boolean r7 = r14.inverted
            if (r7 == 0) goto L_0x0123
            goto L_0x017c
        L_0x0123:
            android.graphics.Path r7 = r0.path
            android.graphics.RectF r14 = r0.tempMaskBoundsRect
            r7.computeBounds(r14, r9)
            if (r13 != 0) goto L_0x0134
            android.graphics.RectF r7 = r0.maskBoundsRect
            android.graphics.RectF r14 = r0.tempMaskBoundsRect
            r7.set(r14)
            goto L_0x0167
        L_0x0134:
            android.graphics.RectF r7 = r0.maskBoundsRect
            float r14 = r7.left
            android.graphics.RectF r15 = r0.tempMaskBoundsRect
            float r15 = r15.left
            float r14 = java.lang.Math.min(r14, r15)
            android.graphics.RectF r15 = r0.maskBoundsRect
            float r15 = r15.top
            android.graphics.RectF r9 = r0.tempMaskBoundsRect
            float r9 = r9.top
            float r9 = java.lang.Math.min(r15, r9)
            android.graphics.RectF r15 = r0.maskBoundsRect
            float r15 = r15.right
            android.graphics.RectF r11 = r0.tempMaskBoundsRect
            float r11 = r11.right
            float r11 = java.lang.Math.max(r15, r11)
            android.graphics.RectF r15 = r0.maskBoundsRect
            float r15 = r15.bottom
            android.graphics.RectF r12 = r0.tempMaskBoundsRect
            float r12 = r12.bottom
            float r12 = java.lang.Math.max(r15, r12)
            r7.set(r14, r9, r11, r12)
        L_0x0167:
            int r13 = r13 + 1
            r7 = 0
            r9 = 0
            r11 = 3
            r12 = 2
            goto L_0x00e9
        L_0x016f:
            android.graphics.RectF r7 = r0.maskBoundsRect
            boolean r7 = r5.intersect(r7)
            if (r7 != 0) goto L_0x017c
            r7 = 0
            r5.set(r7, r7, r7, r7)
            goto L_0x017d
        L_0x017c:
            r7 = 0
        L_0x017d:
            android.graphics.RectF r5 = r0.rect
            int r8 = r18.getWidth()
            float r8 = (float) r8
            int r9 = r18.getHeight()
            float r9 = (float) r9
            boolean r5 = r5.intersect(r7, r7, r8, r9)
            if (r5 != 0) goto L_0x0194
            android.graphics.RectF r5 = r0.rect
            r5.set(r7, r7, r7, r7)
        L_0x0194:
            java.lang.String r5 = "Layer#computeBounds"
            com.airbnb.lottie.L.endSection(r5)
            android.graphics.RectF r5 = r0.rect
            float r5 = r5.width()
            r7 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x03ed
            android.graphics.RectF r5 = r0.rect
            float r5 = r5.height()
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x03ed
            android.graphics.Paint r5 = r0.contentPaint
            r7 = 255(0xff, float:3.57E-43)
            r5.setAlpha(r7)
            android.graphics.RectF r5 = r0.rect
            android.graphics.Paint r8 = r0.contentPaint
            r9 = 31
            com.airbnb.lottie.utils.Utils.saveLayerCompat(r1, r5, r8, r9)
            java.lang.String r5 = "Layer#saveLayer"
            com.airbnb.lottie.L.endSection(r5)
            r17.clearCanvas(r18)
            android.graphics.Matrix r8 = r0.matrix
            r0.drawLayer(r1, r8, r3)
            com.airbnb.lottie.L.endSection(r6)
            boolean r6 = r17.hasMasksOnThisLayer()
            r8 = 19
            java.lang.String r10 = "Layer#restoreLayer"
            if (r6 == 0) goto L_0x03c4
            android.graphics.Matrix r6 = r0.matrix
            android.graphics.RectF r11 = r0.rect
            android.graphics.Paint r12 = r0.dstInPaint
            com.airbnb.lottie.utils.Utils.saveLayerCompat(r1, r11, r12, r8)
            int r11 = android.os.Build.VERSION.SDK_INT
            r12 = 28
            if (r11 >= r12) goto L_0x01eb
            r17.clearCanvas(r18)
        L_0x01eb:
            com.airbnb.lottie.L.endSection(r5)
            r11 = 0
        L_0x01ef:
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r12 = r0.mask
            java.util.List<com.airbnb.lottie.model.content.Mask> r12 = r12.masks
            int r12 = r12.size()
            if (r11 >= r12) goto L_0x03be
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r12 = r0.mask
            java.util.List<com.airbnb.lottie.model.content.Mask> r12 = r12.masks
            java.lang.Object r12 = r12.get(r11)
            com.airbnb.lottie.model.content.Mask r12 = (com.airbnb.lottie.model.content.Mask) r12
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r13 = r0.mask
            java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path>> r13 = r13.maskAnimations
            java.lang.Object r13 = r13.get(r11)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r13 = (com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation) r13
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r14 = r0.mask
            java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer>> r14 = r14.opacityAnimations
            java.lang.Object r14 = r14.get(r11)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r14 = (com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation) r14
            com.airbnb.lottie.model.content.Mask$MaskMode r15 = r12.maskMode
            int r15 = r15.ordinal()
            r16 = 1076048691(0x40233333, float:2.55)
            if (r15 == 0) goto L_0x034f
            if (r15 == r4) goto L_0x02e0
            r4 = 2
            if (r15 == r4) goto L_0x0268
            r4 = 3
            if (r15 == r4) goto L_0x022c
            goto L_0x03b9
        L_0x022c:
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r12 = r0.mask
            java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path>> r12 = r12.maskAnimations
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x0237
            goto L_0x0252
        L_0x0237:
            r12 = 0
        L_0x0238:
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r13 = r0.mask
            java.util.List<com.airbnb.lottie.model.content.Mask> r13 = r13.masks
            int r13 = r13.size()
            if (r12 >= r13) goto L_0x0257
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation r13 = r0.mask
            java.util.List<com.airbnb.lottie.model.content.Mask> r13 = r13.masks
            java.lang.Object r13 = r13.get(r12)
            com.airbnb.lottie.model.content.Mask r13 = (com.airbnb.lottie.model.content.Mask) r13
            com.airbnb.lottie.model.content.Mask$MaskMode r13 = r13.maskMode
            com.airbnb.lottie.model.content.Mask$MaskMode r14 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE
            if (r13 == r14) goto L_0x0254
        L_0x0252:
            r12 = 0
            goto L_0x0258
        L_0x0254:
            int r12 = r12 + 1
            goto L_0x0238
        L_0x0257:
            r12 = 1
        L_0x0258:
            if (r12 == 0) goto L_0x03b9
            android.graphics.Paint r12 = r0.contentPaint
            r12.setAlpha(r7)
            android.graphics.RectF r12 = r0.rect
            android.graphics.Paint r13 = r0.contentPaint
            r1.drawRect(r12, r13)
            goto L_0x03b9
        L_0x0268:
            r4 = 3
            boolean r12 = r12.inverted
            if (r12 == 0) goto L_0x02aa
            android.graphics.RectF r12 = r0.rect
            android.graphics.Paint r15 = r0.dstInPaint
            com.airbnb.lottie.utils.Utils.saveLayerCompat(r1, r12, r15, r9)
            android.graphics.RectF r12 = r0.rect
            android.graphics.Paint r15 = r0.contentPaint
            r1.drawRect(r12, r15)
            android.graphics.Paint r12 = r0.dstOutPaint
            java.lang.Object r14 = r14.getValue()
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            float r14 = (float) r14
            float r14 = r14 * r16
            int r14 = (int) r14
            r12.setAlpha(r14)
            java.lang.Object r12 = r13.getValue()
            android.graphics.Path r12 = (android.graphics.Path) r12
            android.graphics.Path r13 = r0.path
            r13.set(r12)
            android.graphics.Path r12 = r0.path
            r12.transform(r6)
            android.graphics.Path r12 = r0.path
            android.graphics.Paint r13 = r0.dstOutPaint
            r1.drawPath(r12, r13)
            r18.restore()
            goto L_0x03b9
        L_0x02aa:
            android.graphics.RectF r12 = r0.rect
            android.graphics.Paint r15 = r0.dstInPaint
            com.airbnb.lottie.utils.Utils.saveLayerCompat(r1, r12, r15, r9)
            java.lang.Object r12 = r13.getValue()
            android.graphics.Path r12 = (android.graphics.Path) r12
            android.graphics.Path r13 = r0.path
            r13.set(r12)
            android.graphics.Path r12 = r0.path
            r12.transform(r6)
            android.graphics.Paint r12 = r0.contentPaint
            java.lang.Object r13 = r14.getValue()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            float r13 = (float) r13
            float r13 = r13 * r16
            int r13 = (int) r13
            r12.setAlpha(r13)
            android.graphics.Path r12 = r0.path
            android.graphics.Paint r13 = r0.contentPaint
            r1.drawPath(r12, r13)
            r18.restore()
            goto L_0x03b9
        L_0x02e0:
            r4 = 3
            if (r11 != 0) goto L_0x02f6
            android.graphics.Paint r15 = r0.contentPaint
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r15.setColor(r4)
            android.graphics.Paint r4 = r0.contentPaint
            r4.setAlpha(r7)
            android.graphics.RectF r4 = r0.rect
            android.graphics.Paint r15 = r0.contentPaint
            r1.drawRect(r4, r15)
        L_0x02f6:
            boolean r4 = r12.inverted
            if (r4 == 0) goto L_0x0337
            android.graphics.RectF r4 = r0.rect
            android.graphics.Paint r12 = r0.dstOutPaint
            com.airbnb.lottie.utils.Utils.saveLayerCompat(r1, r4, r12, r9)
            android.graphics.RectF r4 = r0.rect
            android.graphics.Paint r12 = r0.contentPaint
            r1.drawRect(r4, r12)
            android.graphics.Paint r4 = r0.dstOutPaint
            java.lang.Object r12 = r14.getValue()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            float r12 = (float) r12
            float r12 = r12 * r16
            int r12 = (int) r12
            r4.setAlpha(r12)
            java.lang.Object r4 = r13.getValue()
            android.graphics.Path r4 = (android.graphics.Path) r4
            android.graphics.Path r12 = r0.path
            r12.set(r4)
            android.graphics.Path r4 = r0.path
            r4.transform(r6)
            android.graphics.Path r4 = r0.path
            android.graphics.Paint r12 = r0.dstOutPaint
            r1.drawPath(r4, r12)
            r18.restore()
            goto L_0x03b9
        L_0x0337:
            java.lang.Object r4 = r13.getValue()
            android.graphics.Path r4 = (android.graphics.Path) r4
            android.graphics.Path r12 = r0.path
            r12.set(r4)
            android.graphics.Path r4 = r0.path
            r4.transform(r6)
            android.graphics.Path r4 = r0.path
            android.graphics.Paint r12 = r0.dstOutPaint
            r1.drawPath(r4, r12)
            goto L_0x03b9
        L_0x034f:
            boolean r4 = r12.inverted
            if (r4 == 0) goto L_0x038f
            android.graphics.RectF r4 = r0.rect
            android.graphics.Paint r12 = r0.contentPaint
            com.airbnb.lottie.utils.Utils.saveLayerCompat(r1, r4, r12, r9)
            android.graphics.RectF r4 = r0.rect
            android.graphics.Paint r12 = r0.contentPaint
            r1.drawRect(r4, r12)
            java.lang.Object r4 = r13.getValue()
            android.graphics.Path r4 = (android.graphics.Path) r4
            android.graphics.Path r12 = r0.path
            r12.set(r4)
            android.graphics.Path r4 = r0.path
            r4.transform(r6)
            android.graphics.Paint r4 = r0.contentPaint
            java.lang.Object r12 = r14.getValue()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            float r12 = (float) r12
            float r12 = r12 * r16
            int r12 = (int) r12
            r4.setAlpha(r12)
            android.graphics.Path r4 = r0.path
            android.graphics.Paint r12 = r0.dstOutPaint
            r1.drawPath(r4, r12)
            r18.restore()
            goto L_0x03b9
        L_0x038f:
            java.lang.Object r4 = r13.getValue()
            android.graphics.Path r4 = (android.graphics.Path) r4
            android.graphics.Path r12 = r0.path
            r12.set(r4)
            android.graphics.Path r4 = r0.path
            r4.transform(r6)
            android.graphics.Paint r4 = r0.contentPaint
            java.lang.Object r12 = r14.getValue()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            float r12 = (float) r12
            float r12 = r12 * r16
            int r12 = (int) r12
            r4.setAlpha(r12)
            android.graphics.Path r4 = r0.path
            android.graphics.Paint r12 = r0.contentPaint
            r1.drawPath(r4, r12)
        L_0x03b9:
            int r11 = r11 + 1
            r4 = 1
            goto L_0x01ef
        L_0x03be:
            r18.restore()
            com.airbnb.lottie.L.endSection(r10)
        L_0x03c4:
            boolean r4 = r17.hasMatteOnThisLayer()
            if (r4 == 0) goto L_0x03e7
            android.graphics.RectF r4 = r0.rect
            android.graphics.Paint r6 = r0.mattePaint
            com.airbnb.lottie.utils.Utils.saveLayerCompat(r1, r4, r6, r8)
            com.airbnb.lottie.L.endSection(r5)
            r17.clearCanvas(r18)
            com.airbnb.lottie.model.layer.BaseLayer r4 = r0.matteLayer
            r4.draw(r1, r2, r3)
            r18.restore()
            com.airbnb.lottie.L.endSection(r10)
            java.lang.String r2 = "Layer#drawMatte"
            com.airbnb.lottie.L.endSection(r2)
        L_0x03e7:
            r18.restore()
            com.airbnb.lottie.L.endSection(r10)
        L_0x03ed:
            boolean r2 = r0.outlineMasksAndMattes
            if (r2 == 0) goto L_0x0426
            android.graphics.Paint r2 = r0.outlineMasksAndMattesPaint
            if (r2 == 0) goto L_0x0426
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r2.setStyle(r3)
            android.graphics.Paint r2 = r0.outlineMasksAndMattesPaint
            r3 = -251901(0xfffffffffffc2803, float:NaN)
            r2.setColor(r3)
            android.graphics.Paint r2 = r0.outlineMasksAndMattesPaint
            r3 = 1082130432(0x40800000, float:4.0)
            r2.setStrokeWidth(r3)
            android.graphics.RectF r2 = r0.rect
            android.graphics.Paint r3 = r0.outlineMasksAndMattesPaint
            r1.drawRect(r2, r3)
            android.graphics.Paint r2 = r0.outlineMasksAndMattesPaint
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL
            r2.setStyle(r3)
            android.graphics.Paint r2 = r0.outlineMasksAndMattesPaint
            r3 = 1357638635(0x50ebebeb, float:3.1664855E10)
            r2.setColor(r3)
            android.graphics.RectF r2 = r0.rect
            android.graphics.Paint r3 = r0.outlineMasksAndMattesPaint
            r1.drawRect(r2, r3)
        L_0x0426:
            java.lang.String r1 = r0.drawTraceName
            com.airbnb.lottie.L.endSection(r1)
            r1 = 0
            r0.recordRenderTime(r1)
            return
        L_0x0430:
            java.lang.String r1 = r0.drawTraceName
            com.airbnb.lottie.L.endSection(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.BaseLayer.draw(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public abstract void drawLayer(Canvas canvas, Matrix matrix2, int i);

    public void getBounds(RectF rectF, Matrix matrix2, boolean z) {
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        buildParentLayerListIfNeeded();
        this.boundsMatrix.set(matrix2);
        if (z) {
            List<BaseLayer> list = this.parentLayers;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.boundsMatrix.preConcat(this.parentLayers.get(size).transform.getMatrix());
                }
            } else {
                BaseLayer baseLayer = this.parentLayer;
                if (baseLayer != null) {
                    this.boundsMatrix.preConcat(baseLayer.transform.getMatrix());
                }
            }
        }
        this.boundsMatrix.preConcat(this.transform.getMatrix());
    }

    public String getName() {
        return this.layerModel.layerName;
    }

    public boolean hasMasksOnThisLayer() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.mask;
        return maskKeyframeAnimation != null && !maskKeyframeAnimation.maskAnimations.isEmpty();
    }

    public boolean hasMatteOnThisLayer() {
        return this.matteLayer != null;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public final void recordRenderTime(float f2) {
        PerformanceTracker performanceTracker = this.lottieDrawable.composition.performanceTracker;
        String str = this.layerModel.layerName;
        if (performanceTracker.enabled) {
            MeanCalculator meanCalculator = performanceTracker.layerRenderTimes.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                performanceTracker.layerRenderTimes.put(str, meanCalculator);
            }
            float f3 = meanCalculator.sum + f2;
            meanCalculator.sum = f3;
            int i = meanCalculator.n + 1;
            meanCalculator.n = i;
            if (i == Integer.MAX_VALUE) {
                meanCalculator.sum = f3 / 2.0f;
                meanCalculator.n = i / 2;
            }
            if (str.equals("__container")) {
                for (FrameListener onFrameRendered : performanceTracker.frameListeners) {
                    onFrameRendered.onFrameRendered(f2);
                }
            }
        }
    }

    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        BaseLayer baseLayer = this.matteLayer;
        if (baseLayer != null) {
            KeyPath addKey = keyPath2.addKey(baseLayer.layerModel.layerName);
            if (keyPath.fullyResolvesTo(this.matteLayer.layerModel.layerName, i)) {
                list.add(addKey.resolve(this.matteLayer));
            }
            if (keyPath.propagateToChildren(this.layerModel.layerName, i)) {
                this.matteLayer.resolveChildKeyPath(keyPath, keyPath.incrementDepthBy(this.matteLayer.layerModel.layerName, i) + i, list, addKey);
            }
        }
        if (keyPath.matches(this.layerModel.layerName, i)) {
            if (!"__container".equals(this.layerModel.layerName)) {
                keyPath2 = keyPath2.addKey(this.layerModel.layerName);
                if (keyPath.fullyResolvesTo(this.layerModel.layerName, i)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(this.layerModel.layerName, i)) {
                resolveChildKeyPath(keyPath, keyPath.incrementDepthBy(this.layerModel.layerName, i) + i, list, keyPath2);
            }
        }
    }

    public void setContents(List<Content> list, List<Content> list2) {
    }

    public void setOutlineMasksAndMattes(boolean z) {
        if (z && this.outlineMasksAndMattesPaint == null) {
            this.outlineMasksAndMattesPaint = new LPaint();
        }
        this.outlineMasksAndMattes = z;
    }

    public void setProgress(float f2) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transform;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = transformKeyframeAnimation.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f2);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = transformKeyframeAnimation.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f2);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = transformKeyframeAnimation.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.setProgress(f2);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = transformKeyframeAnimation.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.setProgress(f2);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = transformKeyframeAnimation.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.setProgress(f2);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = transformKeyframeAnimation.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.setProgress(f2);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = transformKeyframeAnimation.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.setProgress(f2);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = transformKeyframeAnimation.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f2);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = transformKeyframeAnimation.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.setProgress(f2);
        }
        if (this.mask != null) {
            for (int i = 0; i < this.mask.maskAnimations.size(); i++) {
                this.mask.maskAnimations.get(i).setProgress(f2);
            }
        }
        float f3 = this.layerModel.timeStretch;
        if (f3 != 0.0f) {
            f2 /= f3;
        }
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.inOutAnimation;
        if (floatKeyframeAnimation3 != null) {
            floatKeyframeAnimation3.setProgress(f2 / this.layerModel.timeStretch);
        }
        BaseLayer baseLayer = this.matteLayer;
        if (baseLayer != null) {
            baseLayer.setProgress(baseLayer.layerModel.timeStretch * f2);
        }
        for (int i2 = 0; i2 < this.animations.size(); i2++) {
            this.animations.get(i2).setProgress(f2);
        }
    }

    public final void setVisible(boolean z) {
        if (z != this.visible) {
            this.visible = z;
            this.lottieDrawable.invalidateSelf();
        }
    }
}
