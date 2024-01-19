package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public class ContentGroup implements DrawingContent, PathContent, AnimationListener, KeyPathElement {
    public final List<Content> contents;
    public final boolean hidden;
    public final LottieDrawable lottieDrawable;
    public final Matrix matrix;
    public final String name;
    public Paint offScreenPaint;
    public RectF offScreenRectF;
    public final Path path;
    public List<PathContent> pathContents;
    public final RectF rect;
    public TransformKeyframeAnimation transformAnimation;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ContentGroup(com.airbnb.lottie.LottieDrawable r8, com.airbnb.lottie.model.layer.BaseLayer r9, com.airbnb.lottie.model.content.ShapeGroup r10) {
        /*
            r7 = this;
            java.lang.String r3 = r10.name
            boolean r4 = r10.hidden
            java.util.List<com.airbnb.lottie.model.content.ContentModel> r0 = r10.items
            java.util.ArrayList r5 = new java.util.ArrayList
            int r1 = r0.size()
            r5.<init>(r1)
            r1 = 0
            r2 = 0
        L_0x0011:
            int r6 = r0.size()
            if (r2 >= r6) goto L_0x0029
            java.lang.Object r6 = r0.get(r2)
            com.airbnb.lottie.model.content.ContentModel r6 = (com.airbnb.lottie.model.content.ContentModel) r6
            com.airbnb.lottie.animation.content.Content r6 = r6.toContent(r8, r9)
            if (r6 == 0) goto L_0x0026
            r5.add(r6)
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0029:
            java.util.List<com.airbnb.lottie.model.content.ContentModel> r10 = r10.items
        L_0x002b:
            int r0 = r10.size()
            if (r1 >= r0) goto L_0x0042
            java.lang.Object r0 = r10.get(r1)
            com.airbnb.lottie.model.content.ContentModel r0 = (com.airbnb.lottie.model.content.ContentModel) r0
            boolean r2 = r0 instanceof com.airbnb.lottie.model.animatable.AnimatableTransform
            if (r2 == 0) goto L_0x003f
            com.airbnb.lottie.model.animatable.AnimatableTransform r0 = (com.airbnb.lottie.model.animatable.AnimatableTransform) r0
            r6 = r0
            goto L_0x0044
        L_0x003f:
            int r1 = r1 + 1
            goto L_0x002b
        L_0x0042:
            r10 = 0
            r6 = r10
        L_0x0044:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.ContentGroup.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.content.ShapeGroup):void");
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t, lottieValueCallback);
        }
    }

    public void draw(Canvas canvas, Matrix matrix2, int i) {
        boolean z;
        int i2;
        if (!this.hidden) {
            this.matrix.set(matrix2);
            TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
            if (transformKeyframeAnimation != null) {
                this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.transformAnimation.opacity;
                if (baseKeyframeAnimation == null) {
                    i2 = 100;
                } else {
                    i2 = ((Integer) baseKeyframeAnimation.getValue()).intValue();
                }
                i = (int) ((((((float) i2) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
            }
            boolean z2 = false;
            if (this.lottieDrawable.isApplyingOpacityToLayersEnabled) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= this.contents.size()) {
                        z = false;
                        break;
                    }
                    if (this.contents.get(i3) instanceof DrawingContent) {
                        i4++;
                        if (i4 >= 2) {
                            z = true;
                            break;
                        }
                    }
                    i3++;
                }
                if (z && i != 255) {
                    z2 = true;
                }
            }
            if (z2) {
                this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                getBounds(this.offScreenRectF, this.matrix, true);
                this.offScreenPaint.setAlpha(i);
                Utils.saveLayerCompat(canvas, this.offScreenRectF, this.offScreenPaint, 31);
            }
            if (z2) {
                i = InvitationReply.EXPIRED;
            }
            for (int size = this.contents.size() - 1; size >= 0; size--) {
                Content content = this.contents.get(size);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).draw(canvas, this.matrix, i);
                }
            }
            if (z2) {
                canvas.restore();
            }
        }
    }

    public void getBounds(RectF rectF, Matrix matrix2, boolean z) {
        this.matrix.set(matrix2);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.rect, this.matrix, z);
                rectF.union(this.rect);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        this.matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.set(transformKeyframeAnimation.getMatrix());
        }
        this.path.reset();
        if (this.hidden) {
            return this.path;
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof PathContent) {
                this.path.addPath(((PathContent) content).getPath(), this.matrix);
            }
        }
        return this.path;
    }

    public List<PathContent> getPathList() {
        if (this.pathContents == null) {
            this.pathContents = new ArrayList();
            for (int i = 0; i < this.contents.size(); i++) {
                Content content = this.contents.get(i);
                if (content instanceof PathContent) {
                    this.pathContents.add((PathContent) content);
                }
            }
        }
        return this.pathContents;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.matches(this.name, i) || "__container".equals(this.name)) {
            if (!"__container".equals(this.name)) {
                keyPath2 = keyPath2.addKey(this.name);
                if (keyPath.fullyResolvesTo(this.name, i)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(this.name, i)) {
                int incrementDepthBy = keyPath.incrementDepthBy(this.name, i) + i;
                for (int i2 = 0; i2 < this.contents.size(); i2++) {
                    Content content = this.contents.get(i2);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, list, keyPath2);
                    }
                }
            }
        }
    }

    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(this.contents.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            content.setContents(arrayList, this.contents.subList(0, size));
            arrayList.add(content);
        }
    }

    public ContentGroup(LottieDrawable lottieDrawable2, BaseLayer baseLayer, String str, boolean z, List<Content> list, AnimatableTransform animatableTransform) {
        this.offScreenPaint = new LPaint();
        this.offScreenRectF = new RectF();
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = lottieDrawable2;
        this.hidden = z;
        this.contents = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
            this.transformAnimation = transformKeyframeAnimation;
            transformKeyframeAnimation.addAnimationsToLayer(baseLayer);
            this.transformAnimation.addListener(this);
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        int size2 = arrayList.size();
        while (true) {
            size2--;
            if (size2 >= 0) {
                ((GreedyContent) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
            } else {
                return;
            }
        }
    }
}
