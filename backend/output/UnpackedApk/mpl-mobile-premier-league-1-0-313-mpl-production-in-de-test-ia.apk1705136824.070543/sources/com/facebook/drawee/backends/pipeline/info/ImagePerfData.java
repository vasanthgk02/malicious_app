package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;

public class ImagePerfData {
    public final Object mCallerContext;
    public final ImageInfo mImageInfo;

    public ImagePerfData(String str, String str2, ImageRequest imageRequest, Object obj, ImageInfo imageInfo, ImageRequest imageRequest2, ImageRequest imageRequest3, ImageRequest[] imageRequestArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i, String str3, boolean z, int i2, int i3, Throwable th, int i4, long j8, long j9, String str4, long j10) {
        this.mCallerContext = obj;
        this.mImageInfo = imageInfo;
    }
}
