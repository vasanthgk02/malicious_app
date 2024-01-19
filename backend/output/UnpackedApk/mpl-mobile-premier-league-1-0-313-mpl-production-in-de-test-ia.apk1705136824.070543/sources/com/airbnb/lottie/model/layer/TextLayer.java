package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData.Justification;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextLayer extends BaseLayer {
    public final LongSparseArray<String> codePointCache = new LongSparseArray<>(10);
    public BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    public BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
    public final LottieComposition composition;
    public final Map<FontCharacter, List<ContentGroup>> contentsForCharacter = new HashMap();
    public final Paint fillPaint = new Paint(this, 1) {
        {
            setStyle(Style.FILL);
        }
    };
    public final LottieDrawable lottieDrawable;
    public final Matrix matrix = new Matrix();
    public final RectF rectF = new RectF();
    public final StringBuilder stringBuilder = new StringBuilder(2);
    public BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    public BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
    public final Paint strokePaint = new Paint(this, 1) {
        {
            setStyle(Style.STROKE);
        }
    };
    public BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    public BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
    public final TextKeyframeAnimation textAnimation;
    public BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
    public BaseKeyframeAnimation<Float, Float> trackingAnimation;
    public BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;

    public TextLayer(LottieDrawable lottieDrawable2, Layer layer) {
        super(lottieDrawable2, layer);
        this.lottieDrawable = lottieDrawable2;
        this.composition = layer.composition;
        TextKeyframeAnimation textKeyframeAnimation = new TextKeyframeAnimation(layer.text.keyframes);
        this.textAnimation = textKeyframeAnimation;
        textKeyframeAnimation.listeners.add(this);
        addAnimation(this.textAnimation);
        AnimatableTextProperties animatableTextProperties = layer.textProperties;
        if (animatableTextProperties != null) {
            AnimatableColorValue animatableColorValue = animatableTextProperties.color;
            if (animatableColorValue != null) {
                BaseKeyframeAnimation<Integer, Integer> createAnimation = animatableColorValue.createAnimation();
                this.colorAnimation = createAnimation;
                createAnimation.listeners.add(this);
                addAnimation(this.colorAnimation);
            }
        }
        if (animatableTextProperties != null) {
            AnimatableColorValue animatableColorValue2 = animatableTextProperties.stroke;
            if (animatableColorValue2 != null) {
                BaseKeyframeAnimation<Integer, Integer> createAnimation2 = animatableColorValue2.createAnimation();
                this.strokeColorAnimation = createAnimation2;
                createAnimation2.listeners.add(this);
                addAnimation(this.strokeColorAnimation);
            }
        }
        if (animatableTextProperties != null) {
            AnimatableFloatValue animatableFloatValue = animatableTextProperties.strokeWidth;
            if (animatableFloatValue != null) {
                BaseKeyframeAnimation<Float, Float> createAnimation3 = animatableFloatValue.createAnimation();
                this.strokeWidthAnimation = createAnimation3;
                createAnimation3.listeners.add(this);
                addAnimation(this.strokeWidthAnimation);
            }
        }
        if (animatableTextProperties != null) {
            AnimatableFloatValue animatableFloatValue2 = animatableTextProperties.tracking;
            if (animatableFloatValue2 != null) {
                BaseKeyframeAnimation<Float, Float> createAnimation4 = animatableFloatValue2.createAnimation();
                this.trackingAnimation = createAnimation4;
                createAnimation4.listeners.add(this);
                addAnimation(this.trackingAnimation);
            }
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        this.transform.applyValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                this.animations.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.listeners.add(this);
            addAnimation(this.colorCallbackAnimation);
        } else if (t == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorCallbackAnimation;
            if (baseKeyframeAnimation2 != null) {
                this.animations.remove(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.strokeColorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.strokeColorCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.listeners.add(this);
            addAnimation(this.strokeColorCallbackAnimation);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthCallbackAnimation;
            if (baseKeyframeAnimation3 != null) {
                this.animations.remove(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.strokeWidthCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.strokeWidthCallbackAnimation = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.listeners.add(this);
            addAnimation(this.strokeWidthCallbackAnimation);
        } else if (t == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.trackingCallbackAnimation;
            if (baseKeyframeAnimation4 != null) {
                this.animations.remove(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.trackingCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.trackingCallbackAnimation = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.listeners.add(this);
            addAnimation(this.trackingCallbackAnimation);
        } else if (t == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.textSizeCallbackAnimation;
            if (baseKeyframeAnimation5 != null) {
                this.animations.remove(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.textSizeCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.textSizeCallbackAnimation = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.listeners.add(this);
            addAnimation(this.textSizeCallbackAnimation);
        }
    }

    public final void applyJustification(Justification justification, Canvas canvas, float f2) {
        int ordinal = justification.ordinal();
        if (ordinal == 1) {
            canvas.translate(-f2, 0.0f);
        } else if (ordinal == 2) {
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    public final void drawCharacter(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    public final void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r12v14 */
    /* JADX WARNING: type inference failed for: r12v15, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r12v17 */
    /* JADX WARNING: type inference failed for: r15v4, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r12v20 */
    /* JADX WARNING: type inference failed for: r12v25, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r12v27 */
    /* JADX WARNING: type inference failed for: r12v28 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v14
      assigns: []
      uses: []
      mth insns count: 485
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03cf  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drawLayer(android.graphics.Canvas r20, android.graphics.Matrix r21, int r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r20.save()
            com.airbnb.lottie.LottieDrawable r2 = r0.lottieDrawable
            com.airbnb.lottie.LottieComposition r2 = r2.composition
            androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> r2 = r2.characters
            int r2 = r2.size()
            r3 = 1
            if (r2 <= 0) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 != 0) goto L_0x001c
            r20.concat(r21)
        L_0x001c:
            com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation r2 = r0.textAnimation
            java.lang.Object r2 = r2.getValue()
            com.airbnb.lottie.model.DocumentData r2 = (com.airbnb.lottie.model.DocumentData) r2
            com.airbnb.lottie.LottieComposition r4 = r0.composition
            java.util.Map<java.lang.String, com.airbnb.lottie.model.Font> r4 = r4.fonts
            java.lang.String r5 = r2.fontName
            java.lang.Object r4 = r4.get(r5)
            com.airbnb.lottie.model.Font r4 = (com.airbnb.lottie.model.Font) r4
            if (r4 != 0) goto L_0x0036
            r20.restore()
            return
        L_0x0036:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r5 = r0.colorCallbackAnimation
            if (r5 == 0) goto L_0x004a
            android.graphics.Paint r6 = r0.fillPaint
            java.lang.Object r5 = r5.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r6.setColor(r5)
            goto L_0x0065
        L_0x004a:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r5 = r0.colorAnimation
            if (r5 == 0) goto L_0x005e
            android.graphics.Paint r6 = r0.fillPaint
            java.lang.Object r5 = r5.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r6.setColor(r5)
            goto L_0x0065
        L_0x005e:
            android.graphics.Paint r5 = r0.fillPaint
            int r6 = r2.color
            r5.setColor(r6)
        L_0x0065:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r5 = r0.strokeColorCallbackAnimation
            if (r5 == 0) goto L_0x0079
            android.graphics.Paint r6 = r0.strokePaint
            java.lang.Object r5 = r5.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r6.setColor(r5)
            goto L_0x0094
        L_0x0079:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r5 = r0.strokeColorAnimation
            if (r5 == 0) goto L_0x008d
            android.graphics.Paint r6 = r0.strokePaint
            java.lang.Object r5 = r5.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r6.setColor(r5)
            goto L_0x0094
        L_0x008d:
            android.graphics.Paint r5 = r0.strokePaint
            int r6 = r2.strokeColor
            r5.setColor(r6)
        L_0x0094:
            com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation r5 = r0.transform
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r5 = r5.opacity
            if (r5 != 0) goto L_0x009d
            r5 = 100
            goto L_0x00a7
        L_0x009d:
            java.lang.Object r5 = r5.getValue()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
        L_0x00a7:
            int r5 = r5 * 255
            int r5 = r5 / 100
            android.graphics.Paint r6 = r0.fillPaint
            r6.setAlpha(r5)
            android.graphics.Paint r6 = r0.strokePaint
            r6.setAlpha(r5)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r5 = r0.strokeWidthCallbackAnimation
            if (r5 == 0) goto L_0x00c9
            android.graphics.Paint r6 = r0.strokePaint
            java.lang.Object r5 = r5.getValue()
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            r6.setStrokeWidth(r5)
            goto L_0x00f0
        L_0x00c9:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r5 = r0.strokeWidthAnimation
            if (r5 == 0) goto L_0x00dd
            android.graphics.Paint r6 = r0.strokePaint
            java.lang.Object r5 = r5.getValue()
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            r6.setStrokeWidth(r5)
            goto L_0x00f0
        L_0x00dd:
            float r5 = com.airbnb.lottie.utils.Utils.getScale(r21)
            android.graphics.Paint r6 = r0.strokePaint
            float r7 = r2.strokeWidth
            float r8 = com.airbnb.lottie.utils.Utils.dpScale()
            float r8 = r8 * r7
            float r8 = r8 * r5
            r6.setStrokeWidth(r8)
        L_0x00f0:
            com.airbnb.lottie.LottieDrawable r5 = r0.lottieDrawable
            com.airbnb.lottie.LottieComposition r5 = r5.composition
            androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> r5 = r5.characters
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00fe
            r5 = 1
            goto L_0x00ff
        L_0x00fe:
            r5 = 0
        L_0x00ff:
            r6 = 1120403456(0x42c80000, float:100.0)
            if (r5 == 0) goto L_0x02c1
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r3 = r0.textSizeCallbackAnimation
            if (r3 == 0) goto L_0x0112
            java.lang.Object r3 = r3.getValue()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L_0x0114
        L_0x0112:
            float r3 = r2.size
        L_0x0114:
            float r3 = r3 / r6
            float r5 = com.airbnb.lottie.utils.Utils.getScale(r21)
            java.lang.String r6 = r2.text
            float r7 = r2.lineHeight
            float r8 = com.airbnb.lottie.utils.Utils.dpScale()
            float r8 = r8 * r7
            java.util.List r6 = r0.getTextLines(r6)
            int r7 = r6.size()
            r9 = 0
        L_0x012c:
            if (r9 >= r7) goto L_0x04c5
            java.lang.Object r10 = r6.get(r9)
            java.lang.String r10 = (java.lang.String) r10
            r11 = 0
            r12 = 0
        L_0x0136:
            int r13 = r10.length()
            if (r12 >= r13) goto L_0x017a
            char r13 = r10.charAt(r12)
            java.lang.String r14 = r4.family
            java.lang.String r15 = r4.style
            int r13 = com.airbnb.lottie.model.FontCharacter.hashFor(r13, r14, r15)
            com.airbnb.lottie.LottieComposition r14 = r0.composition
            androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> r14 = r14.characters
            java.lang.Object r13 = r14.get(r13)
            com.airbnb.lottie.model.FontCharacter r13 = (com.airbnb.lottie.model.FontCharacter) r13
            if (r13 != 0) goto L_0x015a
            r13 = r8
            r16 = r9
            r22 = r10
            goto L_0x0172
        L_0x015a:
            double r14 = (double) r11
            r22 = r10
            double r10 = r13.width
            r13 = r8
            r16 = r9
            double r8 = (double) r3
            double r10 = r10 * r8
            float r8 = com.airbnb.lottie.utils.Utils.dpScale()
            double r8 = (double) r8
            double r10 = r10 * r8
            double r8 = (double) r5
            double r10 = r10 * r8
            double r10 = r10 + r14
            float r8 = (float) r10
            r11 = r8
        L_0x0172:
            int r12 = r12 + 1
            r10 = r22
            r8 = r13
            r9 = r16
            goto L_0x0136
        L_0x017a:
            r13 = r8
            r16 = r9
            r22 = r10
            r20.save()
            com.airbnb.lottie.model.DocumentData$Justification r8 = r2.justification
            r0.applyJustification(r8, r1, r11)
            int r8 = r7 + -1
            float r8 = (float) r8
            float r8 = r8 * r13
            r9 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r9
            r9 = r16
            float r10 = (float) r9
            float r10 = r10 * r13
            float r10 = r10 - r8
            r8 = 0
            r1.translate(r8, r10)
            r8 = 0
        L_0x019a:
            int r10 = r22.length()
            if (r8 >= r10) goto L_0x02b3
            r10 = r22
            char r11 = r10.charAt(r8)
            java.lang.String r12 = r4.family
            java.lang.String r14 = r4.style
            int r11 = com.airbnb.lottie.model.FontCharacter.hashFor(r11, r12, r14)
            com.airbnb.lottie.LottieComposition r12 = r0.composition
            androidx.collection.SparseArrayCompat<com.airbnb.lottie.model.FontCharacter> r12 = r12.characters
            java.lang.Object r11 = r12.get(r11)
            com.airbnb.lottie.model.FontCharacter r11 = (com.airbnb.lottie.model.FontCharacter) r11
            if (r11 != 0) goto L_0x01c4
            r14 = r21
            r22 = r6
            r17 = r7
            r16 = r10
            goto L_0x02a9
        L_0x01c4:
            java.util.Map<com.airbnb.lottie.model.FontCharacter, java.util.List<com.airbnb.lottie.animation.content.ContentGroup>> r12 = r0.contentsForCharacter
            boolean r12 = r12.containsKey(r11)
            if (r12 == 0) goto L_0x01db
            java.util.Map<com.airbnb.lottie.model.FontCharacter, java.util.List<com.airbnb.lottie.animation.content.ContentGroup>> r12 = r0.contentsForCharacter
            java.lang.Object r12 = r12.get(r11)
            java.util.List r12 = (java.util.List) r12
            r22 = r6
            r17 = r7
            r16 = r10
            goto L_0x0218
        L_0x01db:
            java.util.List<com.airbnb.lottie.model.content.ShapeGroup> r12 = r11.shapes
            int r14 = r12.size()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>(r14)
            r16 = 0
            r22 = r6
            r6 = 0
        L_0x01eb:
            if (r6 >= r14) goto L_0x020e
            java.lang.Object r16 = r12.get(r6)
            r17 = r7
            r7 = r16
            com.airbnb.lottie.model.content.ShapeGroup r7 = (com.airbnb.lottie.model.content.ShapeGroup) r7
            r16 = r10
            com.airbnb.lottie.animation.content.ContentGroup r10 = new com.airbnb.lottie.animation.content.ContentGroup
            r18 = r12
            com.airbnb.lottie.LottieDrawable r12 = r0.lottieDrawable
            r10.<init>(r12, r0, r7)
            r15.add(r10)
            int r6 = r6 + 1
            r10 = r16
            r7 = r17
            r12 = r18
            goto L_0x01eb
        L_0x020e:
            r17 = r7
            r16 = r10
            java.util.Map<com.airbnb.lottie.model.FontCharacter, java.util.List<com.airbnb.lottie.animation.content.ContentGroup>> r6 = r0.contentsForCharacter
            r6.put(r11, r15)
            r12 = r15
        L_0x0218:
            r6 = 0
        L_0x0219:
            int r7 = r12.size()
            if (r6 >= r7) goto L_0x026f
            java.lang.Object r7 = r12.get(r6)
            com.airbnb.lottie.animation.content.ContentGroup r7 = (com.airbnb.lottie.animation.content.ContentGroup) r7
            android.graphics.Path r7 = r7.getPath()
            android.graphics.RectF r10 = r0.rectF
            r14 = 0
            r7.computeBounds(r10, r14)
            android.graphics.Matrix r10 = r0.matrix
            r14 = r21
            r10.set(r14)
            android.graphics.Matrix r10 = r0.matrix
            float r15 = r2.baselineShift
            float r15 = -r15
            float r18 = com.airbnb.lottie.utils.Utils.dpScale()
            float r15 = r15 * r18
            r18 = r12
            r12 = 0
            r10.preTranslate(r12, r15)
            android.graphics.Matrix r10 = r0.matrix
            r10.preScale(r3, r3)
            android.graphics.Matrix r10 = r0.matrix
            r7.transform(r10)
            boolean r10 = r2.strokeOverFill
            if (r10 == 0) goto L_0x0260
            android.graphics.Paint r10 = r0.fillPaint
            r0.drawGlyph(r7, r10, r1)
            android.graphics.Paint r10 = r0.strokePaint
            r0.drawGlyph(r7, r10, r1)
            goto L_0x026a
        L_0x0260:
            android.graphics.Paint r10 = r0.strokePaint
            r0.drawGlyph(r7, r10, r1)
            android.graphics.Paint r10 = r0.fillPaint
            r0.drawGlyph(r7, r10, r1)
        L_0x026a:
            int r6 = r6 + 1
            r12 = r18
            goto L_0x0219
        L_0x026f:
            r14 = r21
            double r6 = r11.width
            float r6 = (float) r6
            float r6 = r6 * r3
            float r7 = com.airbnb.lottie.utils.Utils.dpScale()
            float r7 = r7 * r6
            float r7 = r7 * r5
            int r6 = r2.tracking
            float r6 = (float) r6
            r10 = 1092616192(0x41200000, float:10.0)
            float r6 = r6 / r10
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r10 = r0.trackingCallbackAnimation
            if (r10 == 0) goto L_0x0293
            java.lang.Object r10 = r10.getValue()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            goto L_0x02a1
        L_0x0293:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r10 = r0.trackingAnimation
            if (r10 == 0) goto L_0x02a2
            java.lang.Object r10 = r10.getValue()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
        L_0x02a1:
            float r6 = r6 + r10
        L_0x02a2:
            float r6 = r6 * r5
            float r6 = r6 + r7
            r7 = 0
            r1.translate(r6, r7)
        L_0x02a9:
            int r8 = r8 + 1
            r6 = r22
            r22 = r16
            r7 = r17
            goto L_0x019a
        L_0x02b3:
            r14 = r21
            r22 = r6
            r17 = r7
            r20.restore()
            int r9 = r9 + 1
            r8 = r13
            goto L_0x012c
        L_0x02c1:
            r14 = r21
            com.airbnb.lottie.utils.Utils.getScale(r21)
            com.airbnb.lottie.LottieDrawable r5 = r0.lottieDrawable
            java.lang.String r7 = r4.family
            java.lang.String r4 = r4.style
            android.graphics.drawable.Drawable$Callback r8 = r5.getCallback()
            r9 = 0
            if (r8 != 0) goto L_0x02d5
            r5 = r9
            goto L_0x02e6
        L_0x02d5:
            com.airbnb.lottie.manager.FontAssetManager r8 = r5.fontAssetManager
            if (r8 != 0) goto L_0x02e4
            com.airbnb.lottie.manager.FontAssetManager r8 = new com.airbnb.lottie.manager.FontAssetManager
            android.graphics.drawable.Drawable$Callback r10 = r5.getCallback()
            r8.<init>(r10)
            r5.fontAssetManager = r8
        L_0x02e4:
            com.airbnb.lottie.manager.FontAssetManager r5 = r5.fontAssetManager
        L_0x02e6:
            if (r5 == 0) goto L_0x034d
            com.airbnb.lottie.model.MutablePair<java.lang.String> r8 = r5.tempPair
            r8.first = r7
            r8.second = r4
            java.util.Map<com.airbnb.lottie.model.MutablePair<java.lang.String>, android.graphics.Typeface> r10 = r5.fontMap
            java.lang.Object r8 = r10.get(r8)
            android.graphics.Typeface r8 = (android.graphics.Typeface) r8
            if (r8 == 0) goto L_0x02f9
            goto L_0x034e
        L_0x02f9:
            java.util.Map<java.lang.String, android.graphics.Typeface> r8 = r5.fontFamilies
            java.lang.Object r8 = r8.get(r7)
            android.graphics.Typeface r8 = (android.graphics.Typeface) r8
            if (r8 == 0) goto L_0x0304
            goto L_0x031e
        L_0x0304:
            java.lang.String r8 = "fonts/"
            java.lang.StringBuilder r8 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r8, r7)
            java.lang.String r10 = r5.defaultFontFileExtension
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            android.content.res.AssetManager r10 = r5.assetManager
            android.graphics.Typeface r8 = android.graphics.Typeface.createFromAsset(r10, r8)
            java.util.Map<java.lang.String, android.graphics.Typeface> r10 = r5.fontFamilies
            r10.put(r7, r8)
        L_0x031e:
            java.lang.String r7 = "Italic"
            boolean r7 = r4.contains(r7)
            java.lang.String r10 = "Bold"
            boolean r4 = r4.contains(r10)
            if (r7 == 0) goto L_0x0330
            if (r4 == 0) goto L_0x0330
            r4 = 3
            goto L_0x0339
        L_0x0330:
            if (r7 == 0) goto L_0x0334
            r4 = 2
            goto L_0x0339
        L_0x0334:
            if (r4 == 0) goto L_0x0338
            r4 = 1
            goto L_0x0339
        L_0x0338:
            r4 = 0
        L_0x0339:
            int r7 = r8.getStyle()
            if (r7 != r4) goto L_0x0340
            goto L_0x0345
        L_0x0340:
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r8, r4)
            r8 = r4
        L_0x0345:
            java.util.Map<com.airbnb.lottie.model.MutablePair<java.lang.String>, android.graphics.Typeface> r4 = r5.fontMap
            com.airbnb.lottie.model.MutablePair<java.lang.String> r5 = r5.tempPair
            r4.put(r5, r8)
            goto L_0x034e
        L_0x034d:
            r8 = r9
        L_0x034e:
            if (r8 != 0) goto L_0x0352
            goto L_0x04c5
        L_0x0352:
            java.lang.String r4 = r2.text
            com.airbnb.lottie.LottieDrawable r5 = r0.lottieDrawable
            if (r5 == 0) goto L_0x04c9
            android.graphics.Paint r5 = r0.fillPaint
            r5.setTypeface(r8)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r5 = r0.textSizeCallbackAnimation
            if (r5 == 0) goto L_0x036c
            java.lang.Object r5 = r5.getValue()
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            goto L_0x036e
        L_0x036c:
            float r5 = r2.size
        L_0x036e:
            android.graphics.Paint r7 = r0.fillPaint
            float r8 = com.airbnb.lottie.utils.Utils.dpScale()
            float r8 = r8 * r5
            r7.setTextSize(r8)
            android.graphics.Paint r7 = r0.strokePaint
            android.graphics.Paint r8 = r0.fillPaint
            android.graphics.Typeface r8 = r8.getTypeface()
            r7.setTypeface(r8)
            android.graphics.Paint r7 = r0.strokePaint
            android.graphics.Paint r8 = r0.fillPaint
            float r8 = r8.getTextSize()
            r7.setTextSize(r8)
            float r7 = r2.lineHeight
            float r8 = com.airbnb.lottie.utils.Utils.dpScale()
            float r8 = r8 * r7
            int r7 = r2.tracking
            float r7 = (float) r7
            r9 = 1092616192(0x41200000, float:10.0)
            float r7 = r7 / r9
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r9 = r0.trackingCallbackAnimation
            if (r9 == 0) goto L_0x03ac
            java.lang.Object r9 = r9.getValue()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            goto L_0x03ba
        L_0x03ac:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r9 = r0.trackingAnimation
            if (r9 == 0) goto L_0x03bb
            java.lang.Object r9 = r9.getValue()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
        L_0x03ba:
            float r7 = r7 + r9
        L_0x03bb:
            float r9 = com.airbnb.lottie.utils.Utils.dpScale()
            float r9 = r9 * r7
            float r9 = r9 * r5
            float r9 = r9 / r6
            java.util.List r4 = r0.getTextLines(r4)
            int r5 = r4.size()
            r6 = 0
        L_0x03cd:
            if (r6 >= r5) goto L_0x04c5
            java.lang.Object r7 = r4.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            android.graphics.Paint r10 = r0.strokePaint
            float r10 = r10.measureText(r7)
            int r11 = r7.length()
            int r11 = r11 - r3
            float r3 = (float) r11
            float r3 = r3 * r9
            float r3 = r3 + r10
            r20.save()
            com.airbnb.lottie.model.DocumentData$Justification r10 = r2.justification
            r0.applyJustification(r10, r1, r3)
            int r3 = r5 + -1
            float r3 = (float) r3
            float r3 = r3 * r8
            r10 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r10
            float r10 = (float) r6
            float r10 = r10 * r8
            float r10 = r10 - r3
            r3 = 0
            r1.translate(r3, r10)
            r3 = 0
        L_0x03fd:
            int r10 = r7.length()
            if (r3 >= r10) goto L_0x04bd
            int r10 = r7.codePointAt(r3)
            int r11 = java.lang.Character.charCount(r10)
            int r11 = r11 + r3
        L_0x040c:
            int r12 = r7.length()
            if (r11 >= r12) goto L_0x044d
            int r12 = r7.codePointAt(r11)
            int r13 = java.lang.Character.getType(r12)
            r14 = 16
            if (r13 == r14) goto L_0x0440
            int r13 = java.lang.Character.getType(r12)
            r14 = 27
            if (r13 == r14) goto L_0x0440
            int r13 = java.lang.Character.getType(r12)
            r14 = 6
            if (r13 == r14) goto L_0x0440
            int r13 = java.lang.Character.getType(r12)
            r14 = 28
            if (r13 == r14) goto L_0x0440
            int r13 = java.lang.Character.getType(r12)
            r14 = 19
            if (r13 != r14) goto L_0x043e
            goto L_0x0440
        L_0x043e:
            r13 = 0
            goto L_0x0441
        L_0x0440:
            r13 = 1
        L_0x0441:
            if (r13 != 0) goto L_0x0444
            goto L_0x044d
        L_0x0444:
            int r13 = java.lang.Character.charCount(r12)
            int r11 = r11 + r13
            int r10 = r10 * 31
            int r10 = r10 + r12
            goto L_0x040c
        L_0x044d:
            androidx.collection.LongSparseArray<java.lang.String> r12 = r0.codePointCache
            long r13 = (long) r10
            boolean r10 = r12.mGarbage
            if (r10 == 0) goto L_0x0457
            r12.gc()
        L_0x0457:
            long[] r10 = r12.mKeys
            int r12 = r12.mSize
            int r10 = androidx.collection.ContainerHelpers.binarySearch(r10, r12, r13)
            if (r10 < 0) goto L_0x0463
            r10 = 1
            goto L_0x0464
        L_0x0463:
            r10 = 0
        L_0x0464:
            if (r10 == 0) goto L_0x046f
            androidx.collection.LongSparseArray<java.lang.String> r10 = r0.codePointCache
            java.lang.Object r10 = r10.get(r13)
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0492
        L_0x046f:
            java.lang.StringBuilder r10 = r0.stringBuilder
            r12 = 0
            r10.setLength(r12)
            r10 = r3
        L_0x0476:
            if (r10 >= r11) goto L_0x0487
            int r12 = r7.codePointAt(r10)
            java.lang.StringBuilder r15 = r0.stringBuilder
            r15.appendCodePoint(r12)
            int r12 = java.lang.Character.charCount(r12)
            int r10 = r10 + r12
            goto L_0x0476
        L_0x0487:
            java.lang.StringBuilder r10 = r0.stringBuilder
            java.lang.String r10 = r10.toString()
            androidx.collection.LongSparseArray<java.lang.String> r11 = r0.codePointCache
            r11.put(r13, r10)
        L_0x0492:
            int r11 = r10.length()
            int r3 = r3 + r11
            boolean r11 = r2.strokeOverFill
            if (r11 == 0) goto L_0x04a6
            android.graphics.Paint r11 = r0.fillPaint
            r0.drawCharacter(r10, r11, r1)
            android.graphics.Paint r11 = r0.strokePaint
            r0.drawCharacter(r10, r11, r1)
            goto L_0x04b0
        L_0x04a6:
            android.graphics.Paint r11 = r0.strokePaint
            r0.drawCharacter(r10, r11, r1)
            android.graphics.Paint r11 = r0.fillPaint
            r0.drawCharacter(r10, r11, r1)
        L_0x04b0:
            android.graphics.Paint r11 = r0.fillPaint
            float r10 = r11.measureText(r10)
            float r10 = r10 + r9
            r11 = 0
            r1.translate(r10, r11)
            goto L_0x03fd
        L_0x04bd:
            r20.restore()
            int r6 = r6 + 1
            r3 = 1
            goto L_0x03cd
        L_0x04c5:
            r20.restore()
            return
        L_0x04c9:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.drawLayer(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public void getBounds(RectF rectF2, Matrix matrix2, boolean z) {
        super.getBounds(rectF2, matrix2, z);
        rectF2.set(0.0f, 0.0f, (float) this.composition.bounds.width(), (float) this.composition.bounds.height());
    }

    public final List<String> getTextLines(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }
}
