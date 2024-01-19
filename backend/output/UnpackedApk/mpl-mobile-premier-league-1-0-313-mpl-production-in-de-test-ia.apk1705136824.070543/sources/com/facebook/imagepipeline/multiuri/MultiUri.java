package com.facebook.imagepipeline.multiuri;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources$1;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.ArrayList;
import java.util.LinkedList;

public class MultiUri {
    public static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    public ImageRequest mLowResImageRequest;
    public ImageRequest[] mMultiImageRequests;

    public static class Builder {
        public ImageRequest mLowResImageRequest;
        public ImageRequest[] mMultiImageRequests;

        public MultiUri build() {
            return new MultiUri(this);
        }

        public Builder setImageRequests(ImageRequest... imageRequestArr) {
            this.mMultiImageRequests = imageRequestArr;
            return this;
        }

        public Builder setLowResImageRequest(ImageRequest imageRequest) {
            this.mLowResImageRequest = imageRequest;
            return this;
        }

        public Builder() {
        }
    }

    public static Builder create() {
        return new Builder();
    }

    public static Supplier<DataSource<CloseableReference<CloseableImage>>> getFirstAvailableDataSourceSupplier(ImagePipeline imagePipeline, Object obj, RequestListener requestListener, ImageRequest[] imageRequestArr, boolean z, String str) {
        ArrayList arrayList = new ArrayList(imageRequestArr.length * 2);
        if (z) {
            for (ImageRequest imageRequestDataSourceSupplier : imageRequestArr) {
                arrayList.add(getImageRequestDataSourceSupplier(imagePipeline, imageRequestDataSourceSupplier, obj, RequestLevel.BITMAP_MEMORY_CACHE, requestListener, str));
            }
        }
        for (ImageRequest imageRequestDataSourceSupplier2 : imageRequestArr) {
            arrayList.add(getImageRequestDataSourceSupplier(imagePipeline, imageRequestDataSourceSupplier2, obj, requestListener, str));
        }
        return new FirstAvailableDataSourceSupplier(arrayList);
    }

    public static DataSource<CloseableReference<CloseableImage>> getImageRequestDataSource(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, RequestListener requestListener, String str) {
        return imagePipeline.fetchDecodedImage(imageRequest, obj, RequestLevel.FULL_FETCH, requestListener, str);
    }

    public static Supplier<DataSource<CloseableReference<CloseableImage>>> getImageRequestDataSourceSupplier(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, RequestLevel requestLevel, RequestListener requestListener, String str) {
        final ImagePipeline imagePipeline2 = imagePipeline;
        final ImageRequest imageRequest2 = imageRequest;
        final Object obj2 = obj;
        final RequestListener requestListener2 = requestListener;
        final String str2 = str;
        AnonymousClass1 r0 = new Supplier<DataSource<CloseableReference<CloseableImage>>>() {
            public DataSource<CloseableReference<CloseableImage>> get() {
                return MultiUri.getImageRequestDataSource(imagePipeline2, imageRequest2, obj2, requestListener2, str2);
            }
        };
        return r0;
    }

    public static Supplier<DataSource<CloseableReference<CloseableImage>>> getMultiUriDatasource(ImagePipeline imagePipeline, ImageRequest imageRequest, ImageRequest imageRequest2, Object obj) {
        return getMultiUriDatasourceSupplier(imagePipeline, create().setLowResImageRequest(imageRequest).setImageRequests(imageRequest2).build(), null, obj, null, null);
    }

    public static Supplier<DataSource<CloseableReference<CloseableImage>>> getMultiUriDatasourceSupplier(ImagePipeline imagePipeline, MultiUri multiUri, ImageRequest imageRequest, Object obj, RequestListener requestListener, String str) {
        Supplier<DataSource<CloseableReference<CloseableImage>>> supplier;
        if (imageRequest != null) {
            supplier = getImageRequestDataSourceSupplier(imagePipeline, imageRequest, obj, requestListener, str);
        } else {
            supplier = multiUri.getMultiImageRequests() != null ? getFirstAvailableDataSourceSupplier(imagePipeline, obj, requestListener, multiUri.getMultiImageRequests(), true, str) : null;
        }
        if (!(supplier == null || multiUri.getLowResImageRequest() == null)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(supplier);
            linkedList.add(getImageRequestDataSourceSupplier(imagePipeline, multiUri.getLowResImageRequest(), obj, requestListener, str));
            supplier = new IncreasingQualityDataSourceSupplier<>(linkedList, false);
        }
        return supplier == null ? new DataSources$1(NO_REQUEST_EXCEPTION) : supplier;
    }

    public ImageRequest getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    public ImageRequest[] getMultiImageRequests() {
        return this.mMultiImageRequests;
    }

    public MultiUri(Builder builder) {
        this.mLowResImageRequest = builder.mLowResImageRequest;
        this.mMultiImageRequests = builder.mMultiImageRequests;
    }

    public static Supplier<DataSource<CloseableReference<CloseableImage>>> getImageRequestDataSourceSupplier(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, RequestListener requestListener, String str) {
        return getImageRequestDataSourceSupplier(imagePipeline, imageRequest, obj, RequestLevel.FULL_FETCH, requestListener, str);
    }
}
