package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.view.View;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.LogcatLogger;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public class LottieDrawable extends Drawable implements Callback, Animatable {
    public int alpha;
    public final LottieValueAnimator animator = new LottieValueAnimator();
    public LottieComposition composition;
    public CompositionLayer compositionLayer;
    public boolean enableMergePaths;
    public FontAssetManager fontAssetManager;
    public ImageAssetDelegate imageAssetDelegate;
    public ImageAssetManager imageAssetManager;
    public String imageAssetsFolder;
    public boolean isApplyingOpacityToLayersEnabled;
    public boolean isDirty;
    public boolean isExtraScaleEnabled;
    public final ArrayList<LazyCompositionTask> lazyCompositionTasks = new ArrayList<>();
    public final Matrix matrix = new Matrix();
    public boolean outlineMasksAndMattes;
    public boolean performanceTrackingEnabled;
    public final AnimatorUpdateListener progressUpdateListener;
    public boolean safeMode = false;
    public float scale = 1.0f;
    public boolean systemAnimationsEnabled = true;

    public interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    public LottieDrawable() {
        AnonymousClass1 r2 = new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LottieDrawable lottieDrawable = LottieDrawable.this;
                CompositionLayer compositionLayer = lottieDrawable.compositionLayer;
                if (compositionLayer != null) {
                    compositionLayer.setProgress(lottieDrawable.animator.getAnimatedValueAbsolute());
                }
            }
        };
        this.progressUpdateListener = r2;
        this.alpha = InvitationReply.EXPIRED;
        this.isExtraScaleEnabled = true;
        this.isDirty = false;
        this.animator.updateListeners.add(r2);
    }

    public <T> void addValueCallback(final KeyPath keyPath, final T t, final LottieValueCallback<T> lottieValueCallback) {
        List list;
        CompositionLayer compositionLayer2 = this.compositionLayer;
        if (compositionLayer2 == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.addValueCallback(keyPath, t, lottieValueCallback);
                }
            });
            return;
        }
        boolean z = true;
        if (keyPath == KeyPath.COMPOSITION) {
            compositionLayer2.addValueCallback(t, lottieValueCallback);
        } else {
            KeyPathElement keyPathElement = keyPath.resolvedElement;
            if (keyPathElement != null) {
                keyPathElement.addValueCallback(t, lottieValueCallback);
            } else {
                if (compositionLayer2 == null) {
                    Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
                    list = Collections.emptyList();
                } else {
                    List arrayList = new ArrayList();
                    this.compositionLayer.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
                    list = arrayList;
                }
                for (int i = 0; i < list.size(); i++) {
                    ((KeyPath) list.get(i)).resolvedElement.addValueCallback(t, lottieValueCallback);
                }
                z = true ^ list.isEmpty();
            }
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public final void buildCompositionLayer() {
        Layer parse = LayerParser.parse(this.composition);
        LottieComposition lottieComposition = this.composition;
        CompositionLayer compositionLayer2 = new CompositionLayer(this, parse, lottieComposition.layers, lottieComposition);
        this.compositionLayer = compositionLayer2;
        if (this.outlineMasksAndMattes) {
            compositionLayer2.setOutlineMasksAndMattes(true);
        }
    }

    public void clearComposition() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator.running) {
            lottieValueAnimator.cancel();
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        LottieValueAnimator lottieValueAnimator2 = this.animator;
        lottieValueAnimator2.composition = null;
        lottieValueAnimator2.minFrame = -2.1474836E9f;
        lottieValueAnimator2.maxFrame = 2.1474836E9f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        this.isDirty = false;
        if (this.safeMode) {
            try {
                drawInternal(canvas);
            } catch (Throwable unused) {
                if (((LogcatLogger) Logger.INSTANCE) == null) {
                    throw null;
                }
            }
        } else {
            drawInternal(canvas);
        }
        L.endSection("Drawable#draw");
    }

    public final void drawInternal(Canvas canvas) {
        float f2;
        float f3;
        LottieComposition lottieComposition = this.composition;
        boolean z = true;
        if (lottieComposition != null && !getBounds().isEmpty()) {
            Rect bounds = getBounds();
            Rect rect = lottieComposition.bounds;
            if (((float) bounds.width()) / ((float) bounds.height()) != ((float) rect.width()) / ((float) rect.height())) {
                z = false;
            }
        }
        int i = -1;
        if (!z) {
            if (this.compositionLayer != null) {
                Rect bounds2 = getBounds();
                float width = ((float) bounds2.width()) / ((float) this.composition.bounds.width());
                float height = ((float) bounds2.height()) / ((float) this.composition.bounds.height());
                if (this.isExtraScaleEnabled) {
                    float min = Math.min(width, height);
                    if (min < 1.0f) {
                        f3 = 1.0f / min;
                        width /= f3;
                        height /= f3;
                    } else {
                        f3 = 1.0f;
                    }
                    if (f3 > 1.0f) {
                        i = canvas.save();
                        float width2 = ((float) bounds2.width()) / 2.0f;
                        float height2 = ((float) bounds2.height()) / 2.0f;
                        float f4 = width2 * min;
                        float f5 = min * height2;
                        canvas.translate(width2 - f4, height2 - f5);
                        canvas.scale(f3, f3, f4, f5);
                    }
                }
                this.matrix.reset();
                this.matrix.preScale(width, height);
                this.compositionLayer.draw(canvas, this.matrix, this.alpha);
                if (i > 0) {
                    canvas.restoreToCount(i);
                }
            }
        } else if (this.compositionLayer != null) {
            float f6 = this.scale;
            float min2 = Math.min(((float) canvas.getWidth()) / ((float) this.composition.bounds.width()), ((float) canvas.getHeight()) / ((float) this.composition.bounds.height()));
            if (f6 > min2) {
                f2 = this.scale / min2;
            } else {
                min2 = f6;
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                i = canvas.save();
                float width3 = ((float) this.composition.bounds.width()) / 2.0f;
                float height3 = ((float) this.composition.bounds.height()) / 2.0f;
                float f7 = width3 * min2;
                float f8 = height3 * min2;
                float f9 = this.scale;
                canvas.translate((width3 * f9) - f7, (f9 * height3) - f8);
                canvas.scale(f2, f2, f7, f8);
            }
            this.matrix.reset();
            this.matrix.preScale(min2, min2);
            this.compositionLayer.draw(canvas, this.matrix, this.alpha);
            if (i > 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (((float) lottieComposition.bounds.height()) * this.scale);
    }

    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (((float) lottieComposition.bounds.width()) * this.scale);
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public int getOpacity() {
        return -3;
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        if (!this.isDirty) {
            this.isDirty = true;
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.running;
    }

    public boolean isRunning() {
        return isAnimating();
    }

    public void playAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.playAnimation();
                }
            });
            return;
        }
        if (this.systemAnimationsEnabled || getRepeatCount() == 0) {
            LottieValueAnimator lottieValueAnimator = this.animator;
            lottieValueAnimator.running = true;
            boolean isReversed = lottieValueAnimator.isReversed();
            for (AnimatorListener next : lottieValueAnimator.listeners) {
                if (VERSION.SDK_INT >= 26) {
                    next.onAnimationStart(lottieValueAnimator, isReversed);
                } else {
                    next.onAnimationStart(lottieValueAnimator);
                }
            }
            lottieValueAnimator.setFrame((float) ((int) (lottieValueAnimator.isReversed() ? lottieValueAnimator.getMaxFrame() : lottieValueAnimator.getMinFrame())));
            lottieValueAnimator.lastFrameTimeNs = 0;
            lottieValueAnimator.repeatCount = 0;
            lottieValueAnimator.postFrameCallback();
        }
        if (!this.systemAnimationsEnabled) {
            setFrame((int) (this.animator.speed < 0.0f ? getMinFrame() : getMaxFrame()));
            this.animator.endAnimation();
        }
    }

    public void resumeAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.resumeAnimation();
                }
            });
            return;
        }
        if (this.systemAnimationsEnabled || getRepeatCount() == 0) {
            LottieValueAnimator lottieValueAnimator = this.animator;
            lottieValueAnimator.running = true;
            lottieValueAnimator.postFrameCallback();
            lottieValueAnimator.lastFrameTimeNs = 0;
            if (lottieValueAnimator.isReversed() && lottieValueAnimator.frame == lottieValueAnimator.getMinFrame()) {
                lottieValueAnimator.frame = lottieValueAnimator.getMaxFrame();
            } else if (!lottieValueAnimator.isReversed() && lottieValueAnimator.frame == lottieValueAnimator.getMaxFrame()) {
                lottieValueAnimator.frame = lottieValueAnimator.getMinFrame();
            }
        }
        if (!this.systemAnimationsEnabled) {
            setFrame((int) (this.animator.speed < 0.0f ? getMinFrame() : getMaxFrame()));
            this.animator.endAnimation();
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        this.alpha = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setFrame(i);
                }
            });
        } else {
            this.animator.setFrame((float) i);
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMaxFrame(i);
                }
            });
            return;
        }
        LottieValueAnimator lottieValueAnimator = this.animator;
        lottieValueAnimator.setMinAndMaxFrames(lottieValueAnimator.minFrame, ((float) i) + 0.99f);
    }

    public void setMaxProgress(final float f2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMaxProgress(f2);
                }
            });
        } else {
            setMaxFrame((int) MiscUtils.lerp(lottieComposition.startFrame, lottieComposition.endFrame, f2));
        }
    }

    public void setMinAndMaxFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i = (int) marker.startFrame;
            setMinAndMaxFrame(i, ((int) marker.durationFrames) + i);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("Cannot find marker with name ", str, "."));
    }

    public void setMinAndMaxProgress(final float f2, final float f3) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxProgress(f2, f3);
                }
            });
            return;
        }
        LottieComposition lottieComposition2 = this.composition;
        setMinAndMaxFrame((int) MiscUtils.lerp(lottieComposition.startFrame, lottieComposition.endFrame, f2), (int) MiscUtils.lerp(lottieComposition2.startFrame, lottieComposition2.endFrame, f3));
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinFrame(i);
                }
            });
            return;
        }
        LottieValueAnimator lottieValueAnimator = this.animator;
        lottieValueAnimator.setMinAndMaxFrames((float) i, (float) ((int) lottieValueAnimator.maxFrame));
    }

    public void setMinProgress(final float f2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinProgress(f2);
                }
            });
        } else {
            setMinFrame((int) MiscUtils.lerp(lottieComposition.startFrame, lottieComposition.endFrame, f2));
        }
    }

    public void setProgress(final float f2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setProgress(f2);
                }
            });
            return;
        }
        this.animator.setFrame(MiscUtils.lerp(lottieComposition.startFrame, lottieComposition.endFrame, f2));
        L.endSection("Drawable#setProgress");
    }

    public void start() {
        Callback callback = getCallback();
        if ((callback instanceof View) && !((View) callback).isInEditMode()) {
            playAnimation();
        }
    }

    public void stop() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void setMaxFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMaxFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMaxFrame((int) (marker.startFrame + marker.durationFrames));
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("Cannot find marker with name ", str, "."));
    }

    public void setMinFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMinFrame((int) marker.startFrame);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("Cannot find marker with name ", str, "."));
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() {
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.animator.setMinAndMaxFrames((float) i, ((float) i2) + 0.99f);
        }
    }
}
