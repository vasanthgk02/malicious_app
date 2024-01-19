package com.facebook.imagepipeline.request;

import android.net.Uri;
import co.hyperverge.hypersnapsdk.c.k;
import com.dylanvann.fastimage.FastImageSource;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import java.io.File;
import java.util.Arrays;

public class ImageRequest {
    public final BytesRange mBytesRange;
    public final CacheChoice mCacheChoice;
    public final Boolean mDecodePrefetches;
    public final ImageDecodeOptions mImageDecodeOptions;
    public final boolean mIsDiskCacheEnabled;
    public final boolean mIsMemoryCacheEnabled;
    public final boolean mLocalThumbnailPreviewsEnabled;
    public final RequestLevel mLowestPermittedRequestLevel;
    public final Postprocessor mPostprocessor;
    public final boolean mProgressiveRenderingEnabled;
    public final RequestListener mRequestListener;
    public final Priority mRequestPriority;
    public final ResizeOptions mResizeOptions;
    public final Boolean mResizingAllowedOverride;
    public final RotationOptions mRotationOptions;
    public File mSourceFile;
    public final Uri mSourceUri;
    public final int mSourceUriType;

    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        
        public int mValue;

        /* access modifiers changed from: public */
        RequestLevel(int i) {
            this.mValue = i;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        RotationOptions rotationOptions;
        this.mCacheChoice = imageRequestBuilder.getCacheChoice();
        Uri sourceUri = imageRequestBuilder.getSourceUri();
        this.mSourceUri = sourceUri;
        this.mSourceUriType = getSourceUriType(sourceUri);
        this.mProgressiveRenderingEnabled = imageRequestBuilder.isProgressiveRenderingEnabled();
        this.mLocalThumbnailPreviewsEnabled = imageRequestBuilder.isLocalThumbnailPreviewsEnabled();
        this.mImageDecodeOptions = imageRequestBuilder.getImageDecodeOptions();
        this.mResizeOptions = imageRequestBuilder.getResizeOptions();
        if (imageRequestBuilder.getRotationOptions() == null) {
            rotationOptions = RotationOptions.autoRotate();
        } else {
            rotationOptions = imageRequestBuilder.getRotationOptions();
        }
        this.mRotationOptions = rotationOptions;
        this.mBytesRange = imageRequestBuilder.getBytesRange();
        this.mRequestPriority = imageRequestBuilder.getRequestPriority();
        this.mLowestPermittedRequestLevel = imageRequestBuilder.getLowestPermittedRequestLevel();
        this.mIsDiskCacheEnabled = imageRequestBuilder.isDiskCacheEnabled();
        this.mIsMemoryCacheEnabled = imageRequestBuilder.isMemoryCacheEnabled();
        this.mDecodePrefetches = imageRequestBuilder.shouldDecodePrefetches();
        this.mPostprocessor = imageRequestBuilder.getPostprocessor();
        this.mRequestListener = imageRequestBuilder.getRequestListener();
        this.mResizingAllowedOverride = imageRequestBuilder.getResizingAllowedOverride();
    }

    public static ImageRequest fromFile(File file) {
        if (file == null) {
            return null;
        }
        return fromUri(UriUtil.getUriForFile(file));
    }

    public static ImageRequest fromUri(Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.newBuilderWithSource(uri).build();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (this.mLocalThumbnailPreviewsEnabled != imageRequest.mLocalThumbnailPreviewsEnabled || this.mIsDiskCacheEnabled != imageRequest.mIsDiskCacheEnabled || this.mIsMemoryCacheEnabled != imageRequest.mIsMemoryCacheEnabled || !k.equal(this.mSourceUri, imageRequest.mSourceUri) || !k.equal(this.mCacheChoice, imageRequest.mCacheChoice) || !k.equal(this.mSourceFile, imageRequest.mSourceFile) || !k.equal(this.mBytesRange, imageRequest.mBytesRange) || !k.equal(this.mImageDecodeOptions, imageRequest.mImageDecodeOptions) || !k.equal(this.mResizeOptions, imageRequest.mResizeOptions) || !k.equal(this.mRequestPriority, imageRequest.mRequestPriority) || !k.equal(this.mLowestPermittedRequestLevel, imageRequest.mLowestPermittedRequestLevel) || !k.equal(this.mDecodePrefetches, imageRequest.mDecodePrefetches) || !k.equal(this.mResizingAllowedOverride, imageRequest.mResizingAllowedOverride) || !k.equal(this.mRotationOptions, imageRequest.mRotationOptions)) {
            return false;
        }
        Postprocessor postprocessor = this.mPostprocessor;
        CacheKey cacheKey = null;
        Object postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
        Postprocessor postprocessor2 = imageRequest.mPostprocessor;
        if (postprocessor2 != null) {
            cacheKey = postprocessor2.getPostprocessorCacheKey();
        }
        return k.equal(postprocessorCacheKey, cacheKey);
    }

    @Deprecated
    public boolean getAutoRotateEnabled() {
        return this.mRotationOptions.useImageMetadata();
    }

    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public boolean getLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public int getPreferredHeight() {
        ResizeOptions resizeOptions = this.mResizeOptions;
        if (resizeOptions != null) {
            return resizeOptions.height;
        }
        return 2048;
    }

    public int getPreferredWidth() {
        ResizeOptions resizeOptions = this.mResizeOptions;
        if (resizeOptions != null) {
            return resizeOptions.width;
        }
        return 2048;
    }

    public Priority getPriority() {
        return this.mRequestPriority;
    }

    public boolean getProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public Boolean getResizingAllowedOverride() {
        return this.mResizingAllowedOverride;
    }

    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    public synchronized File getSourceFile() {
        if (this.mSourceFile == null) {
            this.mSourceFile = new File(this.mSourceUri.getPath());
        }
        return this.mSourceFile;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public int getSourceUriType() {
        return this.mSourceUriType;
    }

    public int hashCode() {
        Postprocessor postprocessor = this.mPostprocessor;
        return Arrays.hashCode(new Object[]{this.mCacheChoice, this.mSourceUri, Boolean.valueOf(this.mLocalThumbnailPreviewsEnabled), this.mBytesRange, this.mRequestPriority, this.mLowestPermittedRequestLevel, Boolean.valueOf(this.mIsDiskCacheEnabled), Boolean.valueOf(this.mIsMemoryCacheEnabled), this.mImageDecodeOptions, this.mDecodePrefetches, this.mResizeOptions, this.mRotationOptions, postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null, this.mResizingAllowedOverride});
    }

    public boolean isDiskCacheEnabled() {
        return this.mIsDiskCacheEnabled;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mIsMemoryCacheEnabled;
    }

    public Boolean shouldDecodePrefetches() {
        return this.mDecodePrefetches;
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = k.toStringHelper(this);
        stringHelper.addHolder("uri", this.mSourceUri);
        stringHelper.addHolder("cacheChoice", this.mCacheChoice);
        stringHelper.addHolder("decodeOptions", this.mImageDecodeOptions);
        stringHelper.addHolder("postprocessor", this.mPostprocessor);
        stringHelper.addHolder("priority", this.mRequestPriority);
        stringHelper.addHolder("resizeOptions", this.mResizeOptions);
        stringHelper.addHolder("rotationOptions", this.mRotationOptions);
        stringHelper.addHolder("bytesRange", this.mBytesRange);
        stringHelper.addHolder("resizingAllowedOverride", this.mResizingAllowedOverride);
        stringHelper.add((String) "progressiveRenderingEnabled", this.mProgressiveRenderingEnabled);
        stringHelper.add((String) "localThumbnailPreviewsEnabled", this.mLocalThumbnailPreviewsEnabled);
        stringHelper.addHolder("lowestPermittedRequestLevel", this.mLowestPermittedRequestLevel);
        stringHelper.add((String) "isDiskCacheEnabled", this.mIsDiskCacheEnabled);
        stringHelper.add((String) "isMemoryCacheEnabled", this.mIsMemoryCacheEnabled);
        stringHelper.addHolder("decodePrefetches", this.mDecodePrefetches);
        return stringHelper.toString();
    }

    public static ImageRequest fromUri(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return fromUri(Uri.parse(str));
    }

    public static int getSourceUriType(Uri uri) {
        if (uri == null) {
            return -1;
        }
        boolean z = false;
        if (UriUtil.isNetworkUri(uri)) {
            return 0;
        }
        if (UriUtil.isLocalFileUri(uri)) {
            String extractMime = MediaUtils.extractMime(uri.getPath());
            if (extractMime != null && extractMime.startsWith("video/")) {
                z = true;
            }
            return z ? 2 : 3;
        } else if (UriUtil.isLocalContentUri(uri)) {
            return 4;
        } else {
            if ("asset".equals(UriUtil.getSchemeOrNull(uri))) {
                return 5;
            }
            if (FastImageSource.LOCAL_RESOURCE_SCHEME.equals(UriUtil.getSchemeOrNull(uri))) {
                return 6;
            }
            if ("data".equals(UriUtil.getSchemeOrNull(uri))) {
                return 7;
            }
            if (FastImageSource.ANDROID_RESOURCE_SCHEME.equals(UriUtil.getSchemeOrNull(uri))) {
                return 8;
            }
            return -1;
        }
    }
}
