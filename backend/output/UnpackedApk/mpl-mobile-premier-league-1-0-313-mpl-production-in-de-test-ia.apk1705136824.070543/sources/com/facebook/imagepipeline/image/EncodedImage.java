package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.BytesRange;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;

public class EncodedImage implements Closeable {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    public BytesRange mBytesRange;
    public ColorSpace mColorSpace;
    public int mExifOrientation;
    public int mHeight;
    public ImageFormat mImageFormat;
    public final Supplier<FileInputStream> mInputStreamSupplier;
    public final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
    public int mRotationAngle;
    public int mSampleSize;
    public int mStreamSize;
    public int mWidth;

    public EncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        k.checkArgument(CloseableReference.isValid(closeableReference));
        this.mPooledByteBufferRef = closeableReference.clone();
        this.mInputStreamSupplier = null;
    }

    public static EncodedImage cloneOrNull(EncodedImage encodedImage) {
        if (encodedImage != null) {
            return encodedImage.cloneOrNull();
        }
        return null;
    }

    public static void closeSafely(EncodedImage encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    public static boolean isMetaDataAvailable(EncodedImage encodedImage) {
        return encodedImage.mRotationAngle >= 0 && encodedImage.mWidth >= 0 && encodedImage.mHeight >= 0;
    }

    private void parseMetaDataIfNeeded() {
        if (this.mWidth < 0 || this.mHeight < 0) {
            parseMetaData();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[SYNTHETIC, Splitter:B:14:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.imageutils.ImageMetaData readImageMetaData() {
        /*
            r4 = this;
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ all -> 0x002a }
            com.facebook.imageutils.ImageMetaData r1 = com.facebook.imageutils.BitmapUtil.decodeDimensionsAndColorSpace(r0)     // Catch:{ all -> 0x0028 }
            android.graphics.ColorSpace r2 = r1.mColorSpace     // Catch:{ all -> 0x0028 }
            r4.mColorSpace = r2     // Catch:{ all -> 0x0028 }
            android.util.Pair<java.lang.Integer, java.lang.Integer> r2 = r1.mDimensions     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0024
            java.lang.Object r3 = r2.first     // Catch:{ all -> 0x0028 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0028 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0028 }
            r4.mWidth = r3     // Catch:{ all -> 0x0028 }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x0028 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0028 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0028 }
            r4.mHeight = r2     // Catch:{ all -> 0x0028 }
        L_0x0024:
            r0.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            return r1
        L_0x0028:
            r1 = move-exception
            goto L_0x002c
        L_0x002a:
            r1 = move-exception
            r0 = 0
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.EncodedImage.readImageMetaData():com.facebook.imageutils.ImageMetaData");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009f, code lost:
        if (r0 == null) goto L_0x00a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.Pair<java.lang.Integer, java.lang.Integer> readWebPImageSize() {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.getInputStream()
            r1 = 4
            byte[] r2 = new byte[r1]
            r3 = 0
            r0.read(r2)     // Catch:{ IOException -> 0x009b }
            java.lang.String r4 = "RIFF"
            boolean r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.compare(r2, r4)     // Catch:{ IOException -> 0x009b }
            if (r4 != 0) goto L_0x001e
            r0.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x00a4
        L_0x0018:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00a4
        L_0x001e:
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getInt(r0)     // Catch:{ IOException -> 0x009b }
            r0.read(r2)     // Catch:{ IOException -> 0x009b }
            java.lang.String r4 = "WEBP"
            boolean r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.compare(r2, r4)     // Catch:{ IOException -> 0x009b }
            if (r4 != 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x00a4
        L_0x0031:
            r0.read(r2)     // Catch:{ IOException -> 0x009b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009b }
            r4.<init>()     // Catch:{ IOException -> 0x009b }
            r5 = 0
        L_0x003a:
            if (r5 >= r1) goto L_0x0045
            byte r6 = r2[r5]     // Catch:{ IOException -> 0x009b }
            char r6 = (char) r6     // Catch:{ IOException -> 0x009b }
            r4.append(r6)     // Catch:{ IOException -> 0x009b }
            int r5 = r5 + 1
            goto L_0x003a
        L_0x0045:
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x009b }
            java.lang.String r2 = "VP8 "
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x009b }
            if (r2 == 0) goto L_0x0059
            android.util.Pair r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getVP8Dimension(r0)     // Catch:{ IOException -> 0x009b }
            r0.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x00a4
        L_0x0059:
            java.lang.String r2 = "VP8L"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x009b }
            if (r2 == 0) goto L_0x0069
            android.util.Pair r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getVP8LDimension(r0)     // Catch:{ IOException -> 0x009b }
            r0.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x00a4
        L_0x0069:
            java.lang.String r2 = "VP8X"
            boolean r1 = r2.equals(r1)     // Catch:{ IOException -> 0x009b }
            if (r1 == 0) goto L_0x00a1
            r1 = 8
            r0.skip(r1)     // Catch:{ IOException -> 0x009b }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ IOException -> 0x009b }
            int r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.read3Bytes(r0)     // Catch:{ IOException -> 0x009b }
            int r2 = r2 + 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x009b }
            int r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.read3Bytes(r0)     // Catch:{ IOException -> 0x009b }
            int r4 = r4 + 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x009b }
            r1.<init>(r2, r4)     // Catch:{ IOException -> 0x009b }
            r0.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0097:
            r3 = r1
            goto L_0x00a4
        L_0x0099:
            r1 = move-exception
            goto L_0x00bb
        L_0x009b:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x00a4
        L_0x00a1:
            r0.close()     // Catch:{ IOException -> 0x0018 }
        L_0x00a4:
            if (r3 == 0) goto L_0x00ba
            java.lang.Object r0 = r3.first
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r7.mWidth = r0
            java.lang.Object r0 = r3.second
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r7.mHeight = r0
        L_0x00ba:
            return r3
        L_0x00bb:
            if (r0 == 0) goto L_0x00c5
            r0.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c5
        L_0x00c1:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00c5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.EncodedImage.readWebPImageSize():android.util.Pair");
    }

    public void close() {
        CloseableReference.closeSafely(this.mPooledByteBufferRef);
    }

    public void copyMetaDataFrom(EncodedImage encodedImage) {
        this.mImageFormat = encodedImage.getImageFormat();
        this.mWidth = encodedImage.getWidth();
        this.mHeight = encodedImage.getHeight();
        this.mRotationAngle = encodedImage.getRotationAngle();
        this.mExifOrientation = encodedImage.getExifOrientation();
        this.mSampleSize = encodedImage.getSampleSize();
        this.mStreamSize = encodedImage.getSize();
        this.mBytesRange = encodedImage.getBytesRange();
        this.mColorSpace = encodedImage.getColorSpace();
    }

    public CloseableReference<PooledByteBuffer> getByteBufferRef() {
        return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    }

    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public ColorSpace getColorSpace() {
        parseMetaDataIfNeeded();
        return this.mColorSpace;
    }

    public int getExifOrientation() {
        parseMetaDataIfNeeded();
        return this.mExifOrientation;
    }

    public String getFirstBytesAsHexString(int i) {
        CloseableReference<PooledByteBuffer> byteBufferRef = getByteBufferRef();
        if (byteBufferRef == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) byteBufferRef.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.read(0, bArr, 0, min);
            byteBufferRef.close();
            StringBuilder sb = new StringBuilder(min * 2);
            for (int i2 = 0; i2 < min; i2++) {
                sb.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i2])}));
            }
            return sb.toString();
        } finally {
            byteBufferRef.close();
        }
    }

    public int getHeight() {
        parseMetaDataIfNeeded();
        return this.mHeight;
    }

    public ImageFormat getImageFormat() {
        parseMetaDataIfNeeded();
        return this.mImageFormat;
    }

    public InputStream getInputStream() {
        Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            return (InputStream) supplier.get();
        }
        CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
        if (cloneOrNull == null) {
            return null;
        }
        try {
            return new PooledByteBufferInputStream((PooledByteBuffer) cloneOrNull.get());
        } finally {
            cloneOrNull.close();
        }
    }

    public int getRotationAngle() {
        parseMetaDataIfNeeded();
        return this.mRotationAngle;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    public int getSize() {
        CloseableReference<PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
        if (closeableReference == null || closeableReference.get() == null) {
            return this.mStreamSize;
        }
        return ((PooledByteBuffer) this.mPooledByteBufferRef.get()).size();
    }

    public synchronized SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly() {
        SharedReference<T> sharedReference;
        if (this.mPooledByteBufferRef != null) {
            CloseableReference<PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
            synchronized (closeableReference) {
                sharedReference = closeableReference.mSharedReference;
            }
        } else {
            sharedReference = null;
        }
        return sharedReference;
    }

    public int getWidth() {
        parseMetaDataIfNeeded();
        return this.mWidth;
    }

    public boolean isCompleteAt(int i) {
        ImageFormat imageFormat = this.mImageFormat;
        boolean z = true;
        if ((imageFormat != DefaultImageFormats.JPEG && imageFormat != DefaultImageFormats.DNG) || this.mInputStreamSupplier != null) {
            return true;
        }
        k.checkNotNull1(this.mPooledByteBufferRef);
        PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) this.mPooledByteBufferRef.get();
        if (!(pooledByteBuffer.read(i - 2) == -1 && pooledByteBuffer.read(i - 1) == -39)) {
            z = false;
        }
        return z;
    }

    public synchronized boolean isValid() {
        return CloseableReference.isValid(this.mPooledByteBufferRef) || this.mInputStreamSupplier != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c A[Catch:{ IOException -> 0x0094 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d A[Catch:{ IOException -> 0x0094 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseMetaData() {
        /*
            r6 = this;
            java.io.InputStream r0 = r6.getInputStream()
            com.facebook.imageformat.ImageFormat r0 = com.facebook.imageformat.ImageFormatChecker.getImageFormat_WrapIOException(r0)
            r6.mImageFormat = r0
            boolean r1 = com.facebook.imageformat.DefaultImageFormats.isStaticWebpFormat(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0019
            com.facebook.imageformat.ImageFormat r1 = com.facebook.imageformat.DefaultImageFormats.WEBP_ANIMATED
            if (r0 != r1) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r1 = 0
            goto L_0x001a
        L_0x0019:
            r1 = 1
        L_0x001a:
            if (r1 == 0) goto L_0x0021
            android.util.Pair r1 = r6.readWebPImageSize()
            goto L_0x0027
        L_0x0021:
            com.facebook.imageutils.ImageMetaData r1 = r6.readImageMetaData()
            android.util.Pair<java.lang.Integer, java.lang.Integer> r1 = r1.mDimensions
        L_0x0027:
            com.facebook.imageformat.ImageFormat r4 = com.facebook.imageformat.DefaultImageFormats.JPEG
            r5 = -1
            if (r0 != r4) goto L_0x009d
            int r4 = r6.mRotationAngle
            if (r4 != r5) goto L_0x009d
            if (r1 == 0) goto L_0x00e7
            java.io.InputStream r0 = r6.getInputStream()
            if (r0 == 0) goto L_0x0092
        L_0x0038:
            int r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.readPackedInt(r0, r2, r3)     // Catch:{ IOException -> 0x0094 }
            r4 = 2
            r5 = 255(0xff, float:3.57E-43)
            if (r1 != r5) goto L_0x0069
            r1 = 255(0xff, float:3.57E-43)
        L_0x0043:
            if (r1 != r5) goto L_0x004a
            int r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.readPackedInt(r0, r2, r3)     // Catch:{ IOException -> 0x0094 }
            goto L_0x0043
        L_0x004a:
            r5 = 225(0xe1, float:3.15E-43)
            if (r1 != r5) goto L_0x004f
            goto L_0x006a
        L_0x004f:
            r5 = 216(0xd8, float:3.03E-43)
            if (r1 == r5) goto L_0x0038
            if (r1 != r2) goto L_0x0056
            goto L_0x0038
        L_0x0056:
            r5 = 217(0xd9, float:3.04E-43)
            if (r1 == r5) goto L_0x0069
            r5 = 218(0xda, float:3.05E-43)
            if (r1 != r5) goto L_0x005f
            goto L_0x0069
        L_0x005f:
            int r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.readPackedInt(r0, r4, r3)     // Catch:{ IOException -> 0x0094 }
            int r1 = r1 - r4
            long r4 = (long) r1     // Catch:{ IOException -> 0x0094 }
            r0.skip(r4)     // Catch:{ IOException -> 0x0094 }
            goto L_0x0038
        L_0x0069:
            r2 = 0
        L_0x006a:
            if (r2 == 0) goto L_0x0089
            int r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.readPackedInt(r0, r4, r3)     // Catch:{ IOException -> 0x0094 }
            int r1 = r1 - r4
            r2 = 6
            if (r1 <= r2) goto L_0x0089
            r2 = 4
            int r2 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.readPackedInt(r0, r2, r3)     // Catch:{ IOException -> 0x0094 }
            int r1 = r1 + -4
            int r4 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.readPackedInt(r0, r4, r3)     // Catch:{ IOException -> 0x0094 }
            int r1 = r1 + -2
            r5 = 1165519206(0x45786966, float:3974.5874)
            if (r2 != r5) goto L_0x0089
            if (r4 != 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r1 = 0
        L_0x008a:
            if (r1 != 0) goto L_0x008d
            goto L_0x0094
        L_0x008d:
            int r3 = com.facebook.imageutils.TiffUtil.readOrientationFromTIFF(r0, r1)     // Catch:{ IOException -> 0x0094 }
            goto L_0x0094
        L_0x0092:
            r0 = 0
            throw r0     // Catch:{ IOException -> 0x0094 }
        L_0x0094:
            r6.mExifOrientation = r3
            int r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getAutoRotateAngleFromOrientation(r3)
            r6.mRotationAngle = r0
            goto L_0x00e7
        L_0x009d:
            com.facebook.imageformat.ImageFormat r1 = com.facebook.imageformat.DefaultImageFormats.HEIF
            if (r0 != r1) goto L_0x00e1
            int r0 = r6.mRotationAngle
            if (r0 != r5) goto L_0x00e1
            java.io.InputStream r0 = r6.getInputStream()
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r4 = "HeifExifUtil"
            r5 = 24
            if (r1 < r5) goto L_0x00d3
            android.media.ExifInterface r1 = new android.media.ExifInterface     // Catch:{ IOException -> 0x00bd }
            r1.<init>(r0)     // Catch:{ IOException -> 0x00bd }
            java.lang.String r0 = "Orientation"
            int r3 = r1.getAttributeInt(r0, r2)     // Catch:{ IOException -> 0x00bd }
            goto L_0x00d8
        L_0x00bd:
            r0 = move-exception
            com.facebook.common.logging.LoggingDelegate r1 = com.facebook.common.logging.FLog.sHandler
            com.facebook.common.logging.FLogDefaultLoggingDelegate r1 = (com.facebook.common.logging.FLogDefaultLoggingDelegate) r1
            r2 = 3
            boolean r1 = r1.isLoggable(r2)
            if (r1 == 0) goto L_0x00d8
            com.facebook.common.logging.LoggingDelegate r1 = com.facebook.common.logging.FLog.sHandler
            com.facebook.common.logging.FLogDefaultLoggingDelegate r1 = (com.facebook.common.logging.FLogDefaultLoggingDelegate) r1
            java.lang.String r5 = "Failed reading Heif Exif orientation -> ignoring"
            r1.println(r2, r4, r5, r0)
            goto L_0x00d8
        L_0x00d3:
            java.lang.String r0 = "Trying to read Heif Exif information before Android N -> ignoring"
            com.facebook.common.logging.FLog.d(r4, r0)
        L_0x00d8:
            r6.mExifOrientation = r3
            int r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getAutoRotateAngleFromOrientation(r3)
            r6.mRotationAngle = r0
            goto L_0x00e7
        L_0x00e1:
            int r0 = r6.mRotationAngle
            if (r0 != r5) goto L_0x00e7
            r6.mRotationAngle = r3
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.EncodedImage.parseMetaData():void");
    }

    public void setBytesRange(BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
    }

    public void setExifOrientation(int i) {
        this.mExifOrientation = i;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.mImageFormat = imageFormat;
    }

    public void setRotationAngle(int i) {
        this.mRotationAngle = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void setStreamSize(int i) {
        this.mStreamSize = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public static boolean isValid(EncodedImage encodedImage) {
        return encodedImage != null && encodedImage.isValid();
    }

    public EncodedImage cloneOrNull() {
        EncodedImage encodedImage;
        Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            encodedImage = new EncodedImage(supplier, this.mStreamSize);
        } else {
            CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
            if (cloneOrNull == null) {
                encodedImage = null;
            } else {
                try {
                    encodedImage = new EncodedImage(cloneOrNull);
                } catch (Throwable th) {
                    cloneOrNull.close();
                    throw th;
                }
            }
            if (cloneOrNull != null) {
                cloneOrNull.close();
            }
        }
        if (encodedImage != null) {
            encodedImage.copyMetaDataFrom(this);
        }
        return encodedImage;
    }

    public EncodedImage(Supplier<FileInputStream> supplier) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        if (supplier != null) {
            this.mPooledByteBufferRef = null;
            this.mInputStreamSupplier = supplier;
            return;
        }
        throw null;
    }

    public EncodedImage(Supplier<FileInputStream> supplier, int i) {
        this(supplier);
        this.mStreamSize = i;
    }
}
