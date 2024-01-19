package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.soloader.DoNotOptimize;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage> {
    public static final int COMMON_EXIF_THUMBNAIL_MAX_DIMENSION = 512;
    public static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
    public final ContentResolver mContentResolver;
    public final Executor mExecutor;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    @DoNotOptimize
    public class Api24Utils {
        public Api24Utils() {
        }

        public ExifInterface getExifInterface(FileDescriptor fileDescriptor) throws IOException {
            if (VERSION.SDK_INT >= 24) {
                return new ExifInterface(fileDescriptor);
            }
            return null;
        }
    }

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mContentResolver = contentResolver;
    }

    /* access modifiers changed from: private */
    public EncodedImage buildEncodedImage(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> decodeDimensions = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(pooledByteBuffer));
        int rotationAngle = getRotationAngle(exifInterface);
        int i = -1;
        int intValue = decodeDimensions != null ? ((Integer) decodeDimensions.first).intValue() : -1;
        if (decodeDimensions != null) {
            i = ((Integer) decodeDimensions.second).intValue();
        }
        CloseableReference of = CloseableReference.of(pooledByteBuffer);
        try {
            EncodedImage encodedImage = new EncodedImage(of);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
            encodedImage.setRotationAngle(rotationAngle);
            encodedImage.setWidth(intValue);
            encodedImage.setHeight(i);
            return encodedImage;
        } finally {
            if (of != null) {
                of.close();
            }
        }
    }

    private int getRotationAngle(ExifInterface exifInterface) {
        return ImageOriginUtils.getAutoRotateAngleFromOrientation(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }

    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        return ThumbnailSizeChecker.isImageBigEnough(512, 512, resizeOptions);
    }

    public boolean canReadAsFile(String str) throws IOException {
        boolean z = false;
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0063 A[SYNTHETIC, Splitter:B:38:0x0063] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.media.ExifInterface getExifInterface(android.net.Uri r8) {
        /*
            r7 = this;
            android.content.ContentResolver r0 = r7.mContentResolver
            boolean r1 = com.facebook.common.util.UriUtil.isLocalContentUri(r8)
            r6 = 0
            if (r1 == 0) goto L_0x0039
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r1 = r8
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x002b
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = "_data"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ all -> 0x0028 }
            r2 = -1
            if (r1 == r2) goto L_0x002b
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r8 = move-exception
            r6 = r0
            goto L_0x0033
        L_0x002b:
            r1 = r6
        L_0x002c:
            if (r0 == 0) goto L_0x0045
            r0.close()
            goto L_0x0045
        L_0x0032:
            r8 = move-exception
        L_0x0033:
            if (r6 == 0) goto L_0x0038
            r6.close()
        L_0x0038:
            throw r8
        L_0x0039:
            boolean r0 = com.facebook.common.util.UriUtil.isLocalFileUri(r8)
            if (r0 == 0) goto L_0x0044
            java.lang.String r1 = r8.getPath()
            goto L_0x0045
        L_0x0044:
            r1 = r6
        L_0x0045:
            boolean r0 = r7.canReadAsFile(r1)     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            if (r0 == 0) goto L_0x0051
            android.media.ExifInterface r8 = new android.media.ExifInterface     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            r8.<init>(r1)     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            return r8
        L_0x0051:
            android.content.ContentResolver r0 = r7.mContentResolver     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            boolean r1 = com.facebook.common.util.UriUtil.isLocalContentUri(r8)     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = "r"
            android.content.res.AssetFileDescriptor r8 = r0.openAssetFileDescriptor(r8, r1)     // Catch:{ FileNotFoundException -> 0x0060 }
            goto L_0x0061
        L_0x0060:
            r8 = r6
        L_0x0061:
            if (r8 == 0) goto L_0x0081
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            r1 = 24
            if (r0 < r1) goto L_0x0081
            com.facebook.imagepipeline.producers.LocalExifThumbnailProducer$Api24Utils r0 = new com.facebook.imagepipeline.producers.LocalExifThumbnailProducer$Api24Utils     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            r0.<init>()     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            java.io.FileDescriptor r1 = r8.getFileDescriptor()     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            android.media.ExifInterface r0 = r0.getExifInterface(r1)     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            r8.close()     // Catch:{ IOException -> 0x0081, StackOverflowError -> 0x007a }
            return r0
        L_0x007a:
            java.lang.Class<com.facebook.imagepipeline.producers.LocalExifThumbnailProducer> r8 = com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.class
            java.lang.String r0 = "StackOverflowError in ExifInterface constructor"
            com.facebook.common.logging.FLog.e(r8, r0)
        L_0x0081:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.getExifInterface(android.net.Uri):android.media.ExifInterface");
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener = producerContext.getProducerListener();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final AnonymousClass1 r0 = new StatefulProducerRunnable<EncodedImage>(consumer, producerListener, producerContext, PRODUCER_NAME) {
            public void disposeResult(EncodedImage encodedImage) {
                EncodedImage.closeSafely(encodedImage);
            }

            public Map<String, String> getExtraMapOnSuccess(EncodedImage encodedImage) {
                return ImmutableMap.of("createdThumbnail", Boolean.toString(encodedImage != null));
            }

            public EncodedImage getResult() throws Exception {
                ExifInterface exifInterface = LocalExifThumbnailProducer.this.getExifInterface(imageRequest.getSourceUri());
                if (exifInterface == null || !exifInterface.hasThumbnail()) {
                    return null;
                }
                return LocalExifThumbnailProducer.this.buildEncodedImage(LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer(exifInterface.getThumbnail()), exifInterface);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                r0.cancel();
            }
        });
        this.mExecutor.execute(r0);
    }
}
