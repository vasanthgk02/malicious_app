package com.facebook.common.webp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import java.io.FileDescriptor;

public interface WebpBitmapFactory {

    public interface WebpErrorLogger {
        void onWebpErrorLog(String str, String str2);
    }

    Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options);

    void setBitmapCreator(BitmapCreator bitmapCreator);

    void setWebpErrorLogger(WebpErrorLogger webpErrorLogger);
}
