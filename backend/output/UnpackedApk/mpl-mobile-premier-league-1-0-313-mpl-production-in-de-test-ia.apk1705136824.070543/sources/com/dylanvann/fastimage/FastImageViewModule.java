package com.dylanvann.fastimage;

import android.app.Activity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.BaseRequestOptions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public class FastImageViewModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "FastImageView";

    public FastImageViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "FastImageView";
    }

    @ReactMethod
    public void preload(final ReadableArray readableArray) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable(this) {
                public void run() {
                    Object obj;
                    for (int i = 0; i < readableArray.size(); i++) {
                        ReadableMap map = readableArray.getMap(i);
                        FastImageSource imageSource = FastImageViewConverter.getImageSource(currentActivity, map);
                        RequestManager with = Glide.with(currentActivity.getApplicationContext());
                        if (imageSource.isBase64Resource()) {
                            obj = imageSource.getSource();
                        } else {
                            obj = imageSource.isResource() ? imageSource.getUri() : imageSource.getGlideUrl();
                        }
                        with.load(obj).apply((BaseRequestOptions<?>) FastImageViewConverter.getOptions(currentActivity, imageSource, map)).preload();
                    }
                }
            });
        }
    }
}
