package com.airbnb.android.react.lottie;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.widget.ImageView.ScaleType;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.razorpay.AnalyticsConstants;
import io.sentry.cache.EnvelopeCache;
import java.util.Map;
import java.util.WeakHashMap;

public class LottieAnimationViewManager extends SimpleViewManager<LottieAnimationView> {
    public static final int COMMAND_PAUSE = 3;
    public static final int COMMAND_PLAY = 1;
    public static final int COMMAND_RESET = 2;
    public static final int COMMAND_RESUME = 4;
    public static final String REACT_CLASS = "LottieAnimationView";
    public static final String TAG = "LottieAnimationViewManager";
    public static final int VERSION = 1;
    public Map<LottieAnimationView, LottieAnimationViewPropertyManager> propManagersMap = new WeakHashMap();

    private LottieAnimationViewPropertyManager getOrCreatePropertyManager(LottieAnimationView lottieAnimationView) {
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager = this.propManagersMap.get(lottieAnimationView);
        if (lottieAnimationViewPropertyManager != null) {
            return lottieAnimationViewPropertyManager;
        }
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager2 = new LottieAnimationViewPropertyManager(lottieAnimationView);
        this.propManagersMap.put(lottieAnimationView, lottieAnimationViewPropertyManager2);
        return lottieAnimationViewPropertyManager2;
    }

    /* access modifiers changed from: private */
    public void sendOnAnimationFinishEvent(LottieAnimationView lottieAnimationView, boolean z) {
        ReactContext reactContext;
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("isCancelled", z);
        Context context = lottieAnimationView.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                reactContext = null;
                break;
            } else if (context instanceof ReactContext) {
                reactContext = (ReactContext) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (reactContext != null) {
            ((RCTEventEmitter) reactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(lottieAnimationView.getId(), "animationFinish", createMap);
        }
    }

    public Map<String, Integer> getCommandsMap() {
        return ImageOriginUtils.of("play", Integer.valueOf(1), AnalyticsConstants.RESET, Integer.valueOf(2), "pause", Integer.valueOf(3), "resume", Integer.valueOf(4));
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put("animationFinish", ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", "onAnimationFinish")));
        return builder.build();
    }

    public Map<String, Object> getExportedViewConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put("VERSION", Integer.valueOf(1));
        return builder.build();
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "colorFilters")
    public void setColorFilters(LottieAnimationView lottieAnimationView, ReadableArray readableArray) {
        getOrCreatePropertyManager(lottieAnimationView).colorFilters = readableArray;
    }

    @ReactProp(name = "enableMergePathsAndroidForKitKatAndAbove")
    public void setEnableMergePaths(LottieAnimationView lottieAnimationView, boolean z) {
        getOrCreatePropertyManager(lottieAnimationView).enableMergePaths = Boolean.valueOf(z);
    }

    @ReactProp(name = "imageAssetsFolder")
    public void setImageAssetsFolder(LottieAnimationView lottieAnimationView, String str) {
        getOrCreatePropertyManager(lottieAnimationView).imageAssetsFolder = str;
    }

    @ReactProp(name = "loop")
    public void setLoop(LottieAnimationView lottieAnimationView, boolean z) {
        getOrCreatePropertyManager(lottieAnimationView).loop = Boolean.valueOf(z);
    }

    @ReactProp(name = "progress")
    public void setProgress(LottieAnimationView lottieAnimationView, float f2) {
        getOrCreatePropertyManager(lottieAnimationView).progress = Float.valueOf(f2);
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(LottieAnimationView lottieAnimationView, String str) {
        ScaleType scaleType;
        if ("cover".equals(str)) {
            scaleType = ScaleType.CENTER_CROP;
        } else if ("contain".equals(str)) {
            scaleType = ScaleType.CENTER_INSIDE;
        } else {
            scaleType = "center".equals(str) ? ScaleType.CENTER : null;
        }
        getOrCreatePropertyManager(lottieAnimationView).scaleType = scaleType;
    }

    @ReactProp(name = "sourceJson")
    public void setSourceJson(LottieAnimationView lottieAnimationView, String str) {
        getOrCreatePropertyManager(lottieAnimationView).animationJson = str;
    }

    @ReactProp(name = "sourceName")
    public void setSourceName(LottieAnimationView lottieAnimationView, String str) {
        if (!str.contains(".")) {
            str = GeneratedOutlineSupport.outline50(str, EnvelopeCache.SUFFIX_CURRENT_SESSION_FILE);
        }
        LottieAnimationViewPropertyManager orCreatePropertyManager = getOrCreatePropertyManager(lottieAnimationView);
        orCreatePropertyManager.animationName = str;
        orCreatePropertyManager.animationNameDirty = true;
    }

    @ReactProp(name = "speed")
    public void setSpeed(LottieAnimationView lottieAnimationView, double d2) {
        getOrCreatePropertyManager(lottieAnimationView).speed = Float.valueOf((float) d2);
    }

    public LottieAnimationView createViewInstance(ThemedReactContext themedReactContext) {
        final LottieAnimationView lottieAnimationView = new LottieAnimationView(themedReactContext);
        lottieAnimationView.setScaleType(ScaleType.CENTER_INSIDE);
        lottieAnimationView.lottieDrawable.animator.listeners.add(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
                LottieAnimationViewManager.this.sendOnAnimationFinishEvent(lottieAnimationView, true);
            }

            public void onAnimationEnd(Animator animator) {
                LottieAnimationViewManager.this.sendOnAnimationFinishEvent(lottieAnimationView, false);
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        return lottieAnimationView;
    }

    public void onAfterUpdateTransaction(LottieAnimationView lottieAnimationView) {
        super.onAfterUpdateTransaction(lottieAnimationView);
        LottieAnimationViewPropertyManager orCreatePropertyManager = getOrCreatePropertyManager(lottieAnimationView);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) orCreatePropertyManager.viewWeakReference.get();
        if (lottieAnimationView2 != null) {
            String str = orCreatePropertyManager.animationJson;
            if (str != null) {
                lottieAnimationView2.setAnimationFromJson(str, Integer.toString(str.hashCode()));
                orCreatePropertyManager.animationJson = null;
            }
            if (orCreatePropertyManager.animationNameDirty) {
                lottieAnimationView2.setAnimation(orCreatePropertyManager.animationName);
                orCreatePropertyManager.animationNameDirty = false;
            }
            Float f2 = orCreatePropertyManager.progress;
            if (f2 != null) {
                lottieAnimationView2.setProgress(f2.floatValue());
                orCreatePropertyManager.progress = null;
            }
            Boolean bool = orCreatePropertyManager.loop;
            if (bool != null) {
                lottieAnimationView2.setRepeatCount(bool.booleanValue() ? -1 : 0);
                orCreatePropertyManager.loop = null;
            }
            Float f3 = orCreatePropertyManager.speed;
            if (f3 != null) {
                lottieAnimationView2.setSpeed(f3.floatValue());
                orCreatePropertyManager.speed = null;
            }
            ScaleType scaleType = orCreatePropertyManager.scaleType;
            if (scaleType != null) {
                lottieAnimationView2.setScaleType(scaleType);
                orCreatePropertyManager.scaleType = null;
            }
            String str2 = orCreatePropertyManager.imageAssetsFolder;
            if (str2 != null) {
                lottieAnimationView2.setImageAssetsFolder(str2);
                orCreatePropertyManager.imageAssetsFolder = null;
            }
            Boolean bool2 = orCreatePropertyManager.enableMergePaths;
            if (bool2 != null) {
                lottieAnimationView2.enableMergePathsForKitKatAndAbove(bool2.booleanValue());
                orCreatePropertyManager.enableMergePaths = null;
            }
            ReadableArray readableArray = orCreatePropertyManager.colorFilters;
            if (readableArray != null && readableArray.size() > 0) {
                for (int i = 0; i < orCreatePropertyManager.colorFilters.size(); i++) {
                    ReadableMap map = orCreatePropertyManager.colorFilters.getMap(i);
                    String string = map.getString("color");
                    String string2 = map.getString("keypath");
                    SimpleColorFilter simpleColorFilter = new SimpleColorFilter(Color.parseColor(string));
                    lottieAnimationView2.lottieDrawable.addValueCallback(new KeyPath(string2, "**"), LottieProperty.COLOR_FILTER, new LottieValueCallback(simpleColorFilter));
                }
            }
        }
    }

    public void receiveCommand(final LottieAnimationView lottieAnimationView, int i, final ReadableArray readableArray) {
        if (i == 1) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                public void run() {
                    int i = readableArray.getInt(0);
                    int i2 = readableArray.getInt(1);
                    if (!(i == -1 || i2 == -1)) {
                        if (i > i2) {
                            lottieAnimationView.lottieDrawable.setMinAndMaxFrame(i2, i);
                            lottieAnimationView.lottieDrawable.animator.reverseAnimationSpeed();
                        } else {
                            lottieAnimationView.lottieDrawable.setMinAndMaxFrame(i, i2);
                        }
                    }
                    if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
                        lottieAnimationView.setProgress(0.0f);
                        lottieAnimationView.playAnimation();
                        return;
                    }
                    lottieAnimationView.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                        public void onViewAttachedToWindow(View view) {
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) view;
                            lottieAnimationView.setProgress(0.0f);
                            lottieAnimationView.playAnimation();
                            lottieAnimationView.removeOnAttachStateChangeListener(this);
                        }

                        public void onViewDetachedFromWindow(View view) {
                            lottieAnimationView.removeOnAttachStateChangeListener(this);
                        }
                    });
                }
            });
        } else if (i == 2) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                public void run() {
                    if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
                        lottieAnimationView.cancelAnimation();
                        lottieAnimationView.setProgress(0.0f);
                    }
                }
            });
        } else if (i == 3) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                public void run() {
                    if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
                        lottieAnimationView.pauseAnimation();
                    }
                }
            });
        } else if (i == 4) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                public void run() {
                    if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
                        lottieAnimationView.resumeAnimation();
                    }
                }
            });
        }
    }
}
