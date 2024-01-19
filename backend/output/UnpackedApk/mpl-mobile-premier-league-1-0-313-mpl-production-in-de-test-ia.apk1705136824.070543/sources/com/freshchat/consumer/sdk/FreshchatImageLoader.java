package com.freshchat.consumer.sdk;

import android.graphics.Bitmap;
import android.widget.ImageView;

public interface FreshchatImageLoader {
    void fetch(FreshchatImageLoaderRequest freshchatImageLoaderRequest);

    Bitmap get(FreshchatImageLoaderRequest freshchatImageLoaderRequest);

    void load(FreshchatImageLoaderRequest freshchatImageLoaderRequest, ImageView imageView);
}
