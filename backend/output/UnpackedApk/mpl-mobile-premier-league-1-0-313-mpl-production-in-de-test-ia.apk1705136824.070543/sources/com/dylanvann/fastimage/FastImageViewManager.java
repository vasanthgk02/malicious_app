package com.dylanvann.fastimage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.brentvatne.react.ReactVideoViewManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.BaseRequestOptions;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class FastImageViewManager extends SimpleViewManager<FastImageViewWithUrl> implements FastImageProgressListener {
    public static final String REACT_CLASS = "FastImageView";
    public static final String REACT_ON_LOAD_START_EVENT = "onFastImageLoadStart";
    public static final String REACT_ON_PROGRESS_EVENT = "onFastImageProgress";
    public static final Map<String, List<FastImageViewWithUrl>> VIEWS_FOR_URLS = new WeakHashMap();
    public RequestManager requestManager = null;

    public static Activity getActivityFromContext(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ThemedReactContext) {
            Context baseContext = ((ThemedReactContext) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
            if (baseContext instanceof ContextWrapper) {
                Context baseContext2 = ((ContextWrapper) baseContext).getBaseContext();
                if (baseContext2 instanceof Activity) {
                    return (Activity) baseContext2;
                }
            }
        }
        return null;
    }

    public static boolean isActivityDestroyed(Activity activity) {
        return activity.isDestroyed() || activity.isFinishing();
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidContextForGlide(Context context) {
        Activity activityFromContext = getActivityFromContext(context);
        if (activityFromContext == null) {
            return false;
        }
        return !isActivityDestroyed(activityFromContext);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put(REACT_ON_LOAD_START_EVENT, ImageOriginUtils.of("registrationName", REACT_ON_LOAD_START_EVENT));
        builder.put(REACT_ON_PROGRESS_EVENT, ImageOriginUtils.of("registrationName", REACT_ON_PROGRESS_EVENT));
        builder.put(FastImageRequestListener.REACT_ON_LOAD_EVENT, ImageOriginUtils.of("registrationName", FastImageRequestListener.REACT_ON_LOAD_EVENT));
        builder.put(FastImageRequestListener.REACT_ON_ERROR_EVENT, ImageOriginUtils.of("registrationName", FastImageRequestListener.REACT_ON_ERROR_EVENT));
        builder.put(FastImageRequestListener.REACT_ON_LOAD_END_EVENT, ImageOriginUtils.of("registrationName", FastImageRequestListener.REACT_ON_LOAD_END_EVENT));
        return builder.build();
    }

    public float getGranularityPercentage() {
        return 0.5f;
    }

    public String getName() {
        return "FastImageView";
    }

    public void onProgress(String str, long j, long j2) {
        List<FastImageViewWithUrl> list = VIEWS_FOR_URLS.get(str);
        if (list != null) {
            for (FastImageViewWithUrl fastImageViewWithUrl : list) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putInt(AnalyticsConstants.LOADED, (int) j);
                writableNativeMap.putInt(ECommerceParamNames.TOTAL, (int) j2);
                ((RCTEventEmitter) ((ThemedReactContext) fastImageViewWithUrl.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(fastImageViewWithUrl.getId(), REACT_ON_PROGRESS_EVENT, writableNativeMap);
            }
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(FastImageViewWithUrl fastImageViewWithUrl, String str) {
        fastImageViewWithUrl.setScaleType((ScaleType) FastImageViewConverter.getValue(ReactVideoViewManager.PROP_RESIZE_MODE, "cover", FastImageViewConverter.FAST_IMAGE_RESIZE_MODE_MAP, str));
    }

    @ReactProp(name = "source")
    public void setSrc(FastImageViewWithUrl fastImageViewWithUrl, ReadableMap readableMap) {
        if (readableMap == null || !readableMap.hasKey("uri") || isNullOrEmpty(readableMap.getString("uri"))) {
            RequestManager requestManager2 = this.requestManager;
            if (requestManager2 != null) {
                requestManager2.clear((View) fastImageViewWithUrl);
            }
            GlideUrl glideUrl = fastImageViewWithUrl.glideUrl;
            if (glideUrl != null) {
                FastImageOkHttpProgressGlideModule.forget(glideUrl.getSafeStringUrl());
            }
            fastImageViewWithUrl.setImageDrawable(null);
            return;
        }
        FastImageSource imageSource = FastImageViewConverter.getImageSource(fastImageViewWithUrl.getContext(), readableMap);
        GlideUrl glideUrl2 = imageSource.getGlideUrl();
        fastImageViewWithUrl.glideUrl = glideUrl2;
        RequestManager requestManager3 = this.requestManager;
        if (requestManager3 != null) {
            requestManager3.clear((View) fastImageViewWithUrl);
        }
        String safeStringUrl = glideUrl2.getSafeStringUrl();
        FastImageOkHttpProgressGlideModule.expect(safeStringUrl, this);
        List list = VIEWS_FOR_URLS.get(safeStringUrl);
        if (list != null && !list.contains(fastImageViewWithUrl)) {
            list.add(fastImageViewWithUrl);
        } else if (list == null) {
            VIEWS_FOR_URLS.put(safeStringUrl, new ArrayList(Collections.singletonList(fastImageViewWithUrl)));
        }
        ThemedReactContext themedReactContext = (ThemedReactContext) fastImageViewWithUrl.getContext();
        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(fastImageViewWithUrl.getId(), REACT_ON_LOAD_START_EVENT, new WritableNativeMap());
        RequestManager requestManager4 = this.requestManager;
        if (requestManager4 != null) {
            requestManager4.load(imageSource.getSourceForLoad()).apply((BaseRequestOptions<?>) FastImageViewConverter.getOptions(themedReactContext, imageSource, readableMap)).listener(new FastImageRequestListener(safeStringUrl)).into((ImageView) fastImageViewWithUrl);
        }
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(FastImageViewWithUrl fastImageViewWithUrl, Integer num) {
        if (num == null) {
            fastImageViewWithUrl.clearColorFilter();
        } else {
            fastImageViewWithUrl.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    public FastImageViewWithUrl createViewInstance(ThemedReactContext themedReactContext) {
        if (isValidContextForGlide(themedReactContext)) {
            this.requestManager = Glide.with((Context) themedReactContext);
        }
        return new FastImageViewWithUrl(themedReactContext);
    }

    public void onDropViewInstance(FastImageViewWithUrl fastImageViewWithUrl) {
        RequestManager requestManager2 = this.requestManager;
        if (requestManager2 != null) {
            requestManager2.clear((View) fastImageViewWithUrl);
        }
        GlideUrl glideUrl = fastImageViewWithUrl.glideUrl;
        if (glideUrl != null) {
            String cacheKey = glideUrl.getCacheKey();
            FastImageOkHttpProgressGlideModule.forget(cacheKey);
            List list = VIEWS_FOR_URLS.get(cacheKey);
            if (list != null) {
                list.remove(fastImageViewWithUrl);
                if (list.size() == 0) {
                    VIEWS_FOR_URLS.remove(cacheKey);
                }
            }
        }
        super.onDropViewInstance(fastImageViewWithUrl);
    }
}
