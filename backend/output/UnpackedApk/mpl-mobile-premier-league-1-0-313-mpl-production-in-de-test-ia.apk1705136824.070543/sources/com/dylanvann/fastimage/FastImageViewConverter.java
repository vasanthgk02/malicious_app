package com.dylanvann.fastimage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView.ScaleType;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.model.LazyHeaders.Builder;
import com.bumptech.glide.load.model.LazyHeaders.StringHeaderFactory;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.utils.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastImageViewConverter {
    public static final Map<String, FastImageCacheControl> FAST_IMAGE_CACHE_CONTROL_MAP = new HashMap<String, FastImageCacheControl>() {
        {
            put("immutable", FastImageCacheControl.IMMUTABLE);
            put("web", FastImageCacheControl.WEB);
            put("cacheOnly", FastImageCacheControl.CACHE_ONLY);
        }
    };
    public static final Map<String, Priority> FAST_IMAGE_PRIORITY_MAP = new HashMap<String, Priority>() {
        {
            put("low", Priority.LOW);
            put(ConfigZkFeatures.CONFIG_TYPE_NORMAL, Priority.NORMAL);
            put("high", Priority.HIGH);
        }
    };
    public static final Map<String, ScaleType> FAST_IMAGE_RESIZE_MODE_MAP = new HashMap<String, ScaleType>() {
        {
            put("contain", ScaleType.FIT_CENTER);
            put("cover", ScaleType.CENTER_CROP);
            put("stretch", ScaleType.FIT_XY);
            put("center", ScaleType.CENTER_INSIDE);
        }
    };
    public static final Drawable TRANSPARENT_DRAWABLE = new ColorDrawable(0);

    public static FastImageSource getImageSource(Context context, ReadableMap readableMap) {
        String string = readableMap.getString("uri");
        Headers headers = Headers.DEFAULT;
        if (readableMap.hasKey(Constant.HEADER)) {
            ReadableMap map = readableMap.getMap(Constant.HEADER);
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            Builder builder = new Builder();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                StringHeaderFactory stringHeaderFactory = new StringHeaderFactory(map.getString(nextKey));
                if (!builder.isUserAgentDefault || !"User-Agent".equalsIgnoreCase(nextKey)) {
                    builder.copyIfNecessary();
                    List list = builder.headers.get(nextKey);
                    if (list == null) {
                        list = new ArrayList();
                        builder.headers.put(nextKey, list);
                    }
                    list.add(stringHeaderFactory);
                } else {
                    builder.copyIfNecessary();
                    List list2 = builder.headers.get(nextKey);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        builder.headers.put(nextKey, list2);
                    }
                    list2.clear();
                    list2.add(stringHeaderFactory);
                    if (builder.isUserAgentDefault && "User-Agent".equalsIgnoreCase(nextKey)) {
                        builder.isUserAgentDefault = false;
                    }
                }
            }
            builder.copyOnModify = true;
            headers = new LazyHeaders(builder.headers);
        }
        return new FastImageSource(context, string, headers);
    }

    public static RequestOptions getOptions(Context context, FastImageSource fastImageSource, ReadableMap readableMap) {
        String str;
        Boolean bool;
        Map<String, Priority> map = FAST_IMAGE_PRIORITY_MAP;
        String str2 = null;
        try {
            str = readableMap.getString("priority");
        } catch (NoSuchKeyException unused) {
            str = null;
        }
        Priority priority = (Priority) getValue("priority", ConfigZkFeatures.CONFIG_TYPE_NORMAL, map, str);
        Map<String, FastImageCacheControl> map2 = FAST_IMAGE_CACHE_CONTROL_MAP;
        try {
            str2 = readableMap.getString("cache");
        } catch (NoSuchKeyException unused2) {
        }
        DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        Boolean bool2 = Boolean.FALSE;
        int ordinal = ((FastImageCacheControl) getValue("cache", "immutable", map2, str2)).ordinal();
        if (ordinal == 1) {
            diskCacheStrategy = DiskCacheStrategy.NONE;
            bool = Boolean.TRUE;
        } else if (ordinal != 2) {
            bool = bool2;
        } else {
            Boolean bool3 = bool2;
            bool2 = Boolean.TRUE;
            bool = bool3;
        }
        RequestOptions requestOptions = (RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().diskCacheStrategy(diskCacheStrategy)).onlyRetrieveFromCache(bool2.booleanValue())).skipMemoryCache(bool.booleanValue())).priority(priority)).placeholder(TRANSPARENT_DRAWABLE);
        return fastImageSource.isResource() ? (RequestOptions) requestOptions.apply(RequestOptions.signatureOf(ApplicationVersionSignature.obtain(context))) : requestOptions;
    }

    public static <T> T getValue(String str, String str2, Map<String, T> map, String str3) {
        if (str3 != null) {
            str2 = str3;
        }
        T t = map.get(str2);
        if (t != null) {
            return t;
        }
        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline53("FastImage, invalid ", str, " : ", str2));
    }
}
