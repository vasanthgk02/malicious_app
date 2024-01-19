package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieDrawable.LazyCompositionTask;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

public class LottieAnimationView extends AppCompatImageView {
    public static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER = new LottieListener<Throwable>() {
        public void onResult(Object obj) {
            Throwable th = (Throwable) obj;
            if (Utils.isNetworkException(th)) {
                Logger.warning("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };
    public static final String TAG = LottieAnimationView.class.getSimpleName();
    public String animationName;
    public int animationResId;
    public boolean autoPlay = false;
    public int buildDrawingCacheDepth = 0;
    public boolean cacheComposition = true;
    public LottieComposition composition;
    public LottieTask<LottieComposition> compositionTask;
    public LottieListener<Throwable> failureListener;
    public int fallbackResource = 0;
    public boolean ignoreUnschedule = false;
    public boolean isInitialized;
    public final LottieListener<LottieComposition> loadedListener = new LottieListener<LottieComposition>() {
        public void onResult(Object obj) {
            LottieAnimationView.this.setComposition((LottieComposition) obj);
        }
    };
    public final LottieDrawable lottieDrawable = new LottieDrawable();
    public final Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
    public boolean playAnimationWhenShown = false;
    public RenderMode renderMode = RenderMode.AUTOMATIC;
    public boolean wasAnimatingWhenDetached = false;
    public boolean wasAnimatingWhenNotShown = false;
    public final LottieListener<Throwable> wrappedFailureListener = new LottieListener<Throwable>() {
        public void onResult(Object obj) {
            Throwable th = (Throwable) obj;
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int i = lottieAnimationView.fallbackResource;
            if (i != 0) {
                lottieAnimationView.setImageResource(i);
            }
            LottieListener<Throwable> lottieListener = LottieAnimationView.this.failureListener;
            if (lottieListener == null) {
                lottieListener = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
            }
            lottieListener.onResult(th);
        }
    };

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public String animationName;
        public int animationResId;
        public String imageAssetsFolder;
        public boolean isAnimating;
        public float progress;
        public int repeatCount;
        public int repeatMode;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }

        public SavedState(Parcel parcel, AnonymousClass1 r3) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() != 1 ? false : true;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }
    }

    public LottieAnimationView(Context context) {
        super(context, null);
        init(null, R$attr.lottieAnimationViewStyle);
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        this.composition = null;
        this.lottieDrawable.clearComposition();
        cancelLoaderTask();
        lottieTask.addListener(this.loadedListener);
        lottieTask.addFailureListener(this.wrappedFailureListener);
        this.compositionTask = lottieTask;
    }

    public void buildDrawingCache(boolean z) {
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
        L.endSection("buildDrawingCache");
    }

    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        lottieDrawable2.lazyCompositionTasks.clear();
        lottieDrawable2.animator.cancel();
        enableOrDisableHardwareLayer();
    }

    public final void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            LottieListener<LottieComposition> lottieListener = this.loadedListener;
            synchronized (lottieTask) {
                lottieTask.successListeners.remove(lottieListener);
            }
            LottieTask<LottieComposition> lottieTask2 = this.compositionTask;
            LottieListener<Throwable> lottieListener2 = this.wrappedFailureListener;
            synchronized (lottieTask2) {
                lottieTask2.failureListeners.remove(lottieListener2);
            }
        }
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        if (lottieDrawable2.enableMergePaths != z) {
            lottieDrawable2.enableMergePaths = z;
            if (lottieDrawable2.composition != null) {
                lottieDrawable2.buildCompositionLayer();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r3 != false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        if (r0 != 1) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void enableOrDisableHardwareLayer() {
        /*
            r5 = this;
            com.airbnb.lottie.RenderMode r0 = r5.renderMode
            int r0 = r0.ordinal()
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x000e
            if (r0 == r2) goto L_0x0036
        L_0x000c:
            r1 = 1
            goto L_0x0036
        L_0x000e:
            com.airbnb.lottie.LottieComposition r0 = r5.composition
            r3 = 0
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.hasDashPattern
            if (r0 == 0) goto L_0x001e
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L_0x001e
            goto L_0x0034
        L_0x001e:
            com.airbnb.lottie.LottieComposition r0 = r5.composition
            if (r0 == 0) goto L_0x0028
            int r0 = r0.maskAndMatteCount
            r4 = 4
            if (r0 <= r4) goto L_0x0028
            goto L_0x0034
        L_0x0028:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r0 == r4) goto L_0x0034
            r4 = 25
            if (r0 != r4) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r3 = 1
        L_0x0034:
            if (r3 == 0) goto L_0x000c
        L_0x0036:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L_0x0040
            r0 = 0
            r5.setLayerType(r1, r0)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.enableOrDisableHardwareLayer():void");
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return (long) lottieComposition.getDuration();
        }
        return 0;
    }

    public int getFrame() {
        return (int) this.lottieDrawable.animator.frame;
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.imageAssetsFolder;
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.lottieDrawable.composition;
        if (lottieComposition != null) {
            return lottieComposition.performanceTracker;
        }
        return null;
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.animator.getRepeatMode();
    }

    public float getScale() {
        return this.lottieDrawable.scale;
    }

    public float getSpeed() {
        return this.lottieDrawable.animator.speed;
    }

    public final void init(AttributeSet attributeSet, int i) {
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, i, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_rawRes);
        boolean hasValue2 = obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_fileName);
        boolean hasValue3 = obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_url);
        if (!hasValue || !hasValue2) {
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string = obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_fileName);
                if (string != null) {
                    setAnimation(string);
                }
            } else if (hasValue3) {
                String string2 = obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_url);
                if (string2 != null) {
                    setAnimationFromUrl(string2);
                }
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_fallbackRes, 0));
            if (obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false)) {
                this.wasAnimatingWhenDetached = true;
                this.autoPlay = true;
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false)) {
                this.lottieDrawable.animator.setRepeatCount(-1);
            }
            if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_repeatMode)) {
                setRepeatMode(obtainStyledAttributes.getInt(R$styleable.LottieAnimationView_lottie_repeatMode, 1));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_repeatCount)) {
                setRepeatCount(obtainStyledAttributes.getInt(R$styleable.LottieAnimationView_lottie_repeatCount, -1));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_speed)) {
                setSpeed(obtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_speed, 1.0f));
            }
            setImageAssetsFolder(obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
            setProgress(obtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_progress, 0.0f));
            enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
            if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_colorFilter)) {
                SimpleColorFilter simpleColorFilter = new SimpleColorFilter(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor());
                KeyPath keyPath = new KeyPath("**");
                LottieValueCallback lottieValueCallback = new LottieValueCallback(simpleColorFilter);
                this.lottieDrawable.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, lottieValueCallback);
            }
            if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_scale)) {
                this.lottieDrawable.scale = obtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_scale, 1.0f);
            }
            if (obtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_renderMode)) {
                int i2 = R$styleable.LottieAnimationView_lottie_renderMode;
                RenderMode renderMode2 = RenderMode.AUTOMATIC;
                int i3 = obtainStyledAttributes.getInt(i2, 0);
                if (i3 >= RenderMode.values().length) {
                    RenderMode renderMode3 = RenderMode.AUTOMATIC;
                    i3 = 0;
                }
                setRenderMode(RenderMode.values()[i3]);
            }
            obtainStyledAttributes.recycle();
            LottieDrawable lottieDrawable2 = this.lottieDrawable;
            if (Utils.getAnimationScale(getContext()) != 0.0f) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (lottieDrawable2 != null) {
                lottieDrawable2.systemAnimationsEnabled = valueOf.booleanValue();
                enableOrDisableHardwareLayer();
                this.isInitialized = true;
                return;
            }
            throw null;
        }
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        if (drawable2 == lottieDrawable2) {
            super.invalidateDrawable(lottieDrawable2);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.autoPlay || this.wasAnimatingWhenDetached)) {
            playAnimation();
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if (VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.animationName;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.animationResId;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.lottieDrawable.imageAssetsFolder = savedState.imageAssetsFolder;
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.getProgress();
        savedState.isAnimating = this.lottieDrawable.isAnimating() || (!ViewCompat.isAttachedToWindow(this) && this.wasAnimatingWhenDetached);
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        savedState.imageAssetsFolder = lottieDrawable2.imageAssetsFolder;
        savedState.repeatMode = lottieDrawable2.animator.getRepeatMode();
        savedState.repeatCount = this.lottieDrawable.getRepeatCount();
        return savedState;
    }

    public void onVisibilityChanged(View view, int i) {
        if (this.isInitialized) {
            if (isShown()) {
                if (this.wasAnimatingWhenNotShown) {
                    resumeAnimation();
                } else if (this.playAnimationWhenShown) {
                    playAnimation();
                }
                this.wasAnimatingWhenNotShown = false;
                this.playAnimationWhenShown = false;
            } else if (isAnimating()) {
                pauseAnimation();
                this.wasAnimatingWhenNotShown = true;
            }
        }
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        lottieDrawable2.lazyCompositionTasks.clear();
        lottieDrawable2.animator.removeFrameCallback();
        enableOrDisableHardwareLayer();
    }

    public void playAnimation() {
        if (isShown()) {
            this.lottieDrawable.playAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = true;
    }

    public void resumeAnimation() {
        if (isShown()) {
            this.lottieDrawable.resumeAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
    }

    public void setAnimation(final int i) {
        LottieTask lottieTask;
        LottieTask<LottieComposition> lottieTask2;
        this.animationResId = i;
        this.animationName = null;
        if (isInEditMode()) {
            lottieTask = new LottieTask(new Callable<LottieResult<LottieComposition>>() {
                public Object call() throws Exception {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    if (!lottieAnimationView.cacheComposition) {
                        return LottieCompositionFactory.fromRawResSync(lottieAnimationView.getContext(), i, null);
                    }
                    Context context = lottieAnimationView.getContext();
                    int i = i;
                    return LottieCompositionFactory.fromRawResSync(context, i, LottieCompositionFactory.rawResCacheKey(context, i));
                }
            }, true);
        } else {
            if (this.cacheComposition) {
                Context context = getContext();
                String rawResCacheKey = LottieCompositionFactory.rawResCacheKey(context, i);
                lottieTask2 = LottieCompositionFactory.cache(rawResCacheKey, new Callable<LottieResult<LottieComposition>>(new WeakReference(context), context.getApplicationContext(), i, rawResCacheKey) {
                    public Object call() throws Exception {
                        Context context = (Context) r4.get();
                        if (context == null) {
                            context = r2;
                        }
                        return LottieCompositionFactory.fromRawResSync(context, r3, null);
                    }
                });
            } else {
                lottieTask2 = LottieCompositionFactory.fromRawRes(getContext(), i, null);
            }
            lottieTask = lottieTask2;
        }
        setCompositionTask(lottieTask);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setCompositionTask(LottieCompositionFactory.cache(null, new Callable<LottieResult<LottieComposition>>(new ByteArrayInputStream(str.getBytes()), null) {
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ InputStream val$stream;

            {
                this.val$stream = r1;
                this.val$cacheKey = r2;
            }

            public Object call() throws Exception {
                return LottieCompositionFactory.fromJsonInputStreamSync(this.val$stream, this.val$cacheKey);
            }
        }));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? LottieCompositionFactory.fromUrl(getContext(), str) : LottieCompositionFactory.fromUrl(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.isApplyingOpacityToLayersEnabled = z;
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setComposition(LottieComposition lottieComposition) {
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        boolean z = true;
        this.ignoreUnschedule = true;
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        if (lottieDrawable2.composition == lottieComposition) {
            z = false;
        } else {
            lottieDrawable2.isDirty = false;
            lottieDrawable2.clearComposition();
            lottieDrawable2.composition = lottieComposition;
            lottieDrawable2.buildCompositionLayer();
            LottieValueAnimator lottieValueAnimator = lottieDrawable2.animator;
            boolean z2 = lottieValueAnimator.composition == null;
            lottieValueAnimator.composition = lottieComposition;
            if (z2) {
                lottieValueAnimator.setMinAndMaxFrames((float) ((int) Math.max(lottieValueAnimator.minFrame, lottieComposition.startFrame)), (float) ((int) Math.min(lottieValueAnimator.maxFrame, lottieComposition.endFrame)));
            } else {
                lottieValueAnimator.setMinAndMaxFrames((float) ((int) lottieComposition.startFrame), (float) ((int) lottieComposition.endFrame));
            }
            float f2 = lottieValueAnimator.frame;
            lottieValueAnimator.frame = 0.0f;
            lottieValueAnimator.setFrame((float) ((int) f2));
            lottieValueAnimator.notifyUpdate();
            lottieDrawable2.setProgress(lottieDrawable2.animator.getAnimatedFraction());
            lottieDrawable2.scale = lottieDrawable2.scale;
            Iterator it = new ArrayList(lottieDrawable2.lazyCompositionTasks).iterator();
            while (it.hasNext()) {
                LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
                if (lazyCompositionTask != null) {
                    lazyCompositionTask.run(lottieComposition);
                }
                it.remove();
            }
            lottieDrawable2.lazyCompositionTasks.clear();
            lottieComposition.performanceTracker.enabled = lottieDrawable2.performanceTrackingEnabled;
            Callback callback = lottieDrawable2.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(lottieDrawable2);
            }
        }
        this.ignoreUnschedule = false;
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || z) {
            if (!z) {
                boolean isAnimating = isAnimating();
                setImageDrawable(null);
                setImageDrawable(this.lottieDrawable);
                if (isAnimating) {
                    this.lottieDrawable.resumeAnimation();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (LottieOnCompositionLoadedListener onCompositionLoaded : this.lottieOnCompositionLoadedListeners) {
                onCompositionLoaded.onCompositionLoaded(lottieComposition);
            }
        }
    }

    public void setFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(int i) {
        this.fallbackResource = i;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
    }

    public void setFrame(int i) {
        this.lottieDrawable.setFrame(i);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        lottieDrawable2.imageAssetDelegate = imageAssetDelegate;
        ImageAssetManager imageAssetManager = lottieDrawable2.imageAssetManager;
        if (imageAssetManager != null) {
            imageAssetManager.delegate = imageAssetDelegate;
        }
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.imageAssetsFolder = str;
    }

    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i) {
        cancelLoaderTask();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.setMaxFrame(i);
    }

    public void setMaxProgress(float f2) {
        this.lottieDrawable.setMaxProgress(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.setMinAndMaxFrame(str);
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.setMinFrame(i);
    }

    public void setMinProgress(float f2) {
        this.lottieDrawable.setMinProgress(f2);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        if (lottieDrawable2.outlineMasksAndMattes != z) {
            lottieDrawable2.outlineMasksAndMattes = z;
            CompositionLayer compositionLayer = lottieDrawable2.compositionLayer;
            if (compositionLayer != null) {
                compositionLayer.setOutlineMasksAndMattes(z);
            }
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        lottieDrawable2.performanceTrackingEnabled = z;
        LottieComposition lottieComposition = lottieDrawable2.composition;
        if (lottieComposition != null) {
            lottieComposition.performanceTracker.enabled = z;
        }
    }

    public void setProgress(float f2) {
        this.lottieDrawable.setProgress(f2);
    }

    public void setRenderMode(RenderMode renderMode2) {
        this.renderMode = renderMode2;
        enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.animator.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.animator.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.safeMode = z;
    }

    public void setScale(float f2) {
        this.lottieDrawable.scale = f2;
        if (getDrawable() == this.lottieDrawable) {
            boolean isAnimating = isAnimating();
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
            if (isAnimating) {
                this.lottieDrawable.resumeAnimation();
            }
        }
    }

    public void setSpeed(float f2) {
        this.lottieDrawable.animator.speed = f2;
    }

    public void setTextDelegate(TextDelegate textDelegate) {
    }

    public void unscheduleDrawable(Drawable drawable) {
        if (!this.ignoreUnschedule) {
            LottieDrawable lottieDrawable2 = this.lottieDrawable;
            if (drawable == lottieDrawable2 && lottieDrawable2.isAnimating()) {
                pauseAnimation();
                super.unscheduleDrawable(drawable);
            }
        }
        if (!this.ignoreUnschedule && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable3 = (LottieDrawable) drawable;
            if (lottieDrawable3.isAnimating()) {
                lottieDrawable3.lazyCompositionTasks.clear();
                lottieDrawable3.animator.removeFrameCallback();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.setMaxFrame(str);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.setMinFrame(str);
    }

    public void setAnimationFromJson(String str, String str2) {
        setCompositionTask(LottieCompositionFactory.cache(str2, new Callable<LottieResult<LottieComposition>>(new ByteArrayInputStream(str.getBytes()), str2) {
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ InputStream val$stream;

            {
                this.val$stream = r1;
                this.val$cacheKey = r2;
            }

            public Object call() throws Exception {
                return LottieCompositionFactory.fromJsonInputStreamSync(this.val$stream, this.val$cacheKey);
            }
        }));
    }

    public void setAnimationFromUrl(String str, String str2) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str, str2));
    }

    public void setAnimation(final String str) {
        LottieTask lottieTask;
        this.animationName = str;
        this.animationResId = 0;
        if (isInEditMode()) {
            lottieTask = new LottieTask(new Callable<LottieResult<LottieComposition>>() {
                public Object call() throws Exception {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    return lottieAnimationView.cacheComposition ? LottieCompositionFactory.fromAssetSync(lottieAnimationView.getContext(), str) : LottieCompositionFactory.fromAssetSync(lottieAnimationView.getContext(), str, null);
                }
            }, true);
        } else {
            lottieTask = this.cacheComposition ? LottieCompositionFactory.fromAsset(getContext(), str) : LottieCompositionFactory.fromAsset(getContext(), str, null);
        }
        setCompositionTask(lottieTask);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }
}
