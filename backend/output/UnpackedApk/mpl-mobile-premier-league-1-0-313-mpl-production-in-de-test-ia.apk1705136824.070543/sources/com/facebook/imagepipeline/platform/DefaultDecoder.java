package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.core.util.Pools$SynchronizedPool;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

@TargetApi(11)
public abstract class DefaultDecoder implements PlatformDecoder {
    public static final int DECODE_BUFFER_SIZE = 16384;
    public static final byte[] EOI_TAIL = {-1, -39};
    public static final Class<?> TAG = DefaultDecoder.class;
    public final BitmapPool mBitmapPool;
    public final Pools$SynchronizedPool<ByteBuffer> mDecodeBuffers;
    public final PreverificationHelper mPreverificationHelper;

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools$SynchronizedPool pools$SynchronizedPool) {
        this.mPreverificationHelper = VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = pools$SynchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        com.facebook.common.logging.FLog.e(TAG, (java.lang.String) "Could not decode region %s, decoding full bitmap instead.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0095, code lost:
        if (r1 != null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009b, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009c, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x008a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x00f4 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009f A[Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb, all -> 0x00c9, IOException -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a6 A[Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb, all -> 0x00c9, IOException -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromStream(java.io.InputStream r9, android.graphics.BitmapFactory.Options r10, android.graphics.Rect r11, android.graphics.ColorSpace r12) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0103
            int r1 = r10.outWidth
            int r2 = r10.outHeight
            if (r11 == 0) goto L_0x0017
            int r1 = r11.width()
            int r2 = r10.inSampleSize
            int r1 = r1 / r2
            int r2 = r11.height()
            int r3 = r10.inSampleSize
            int r2 = r2 / r3
        L_0x0017:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            r5 = 1
            r6 = 0
            if (r3 < r4) goto L_0x002d
            com.facebook.imagepipeline.platform.PreverificationHelper r3 = r8.mPreverificationHelper
            if (r3 == 0) goto L_0x002d
            android.graphics.Bitmap$Config r7 = r10.inPreferredConfig
            boolean r3 = r3.shouldUseHardwareBitmapConfig(r7)
            if (r3 == 0) goto L_0x002d
            r3 = 1
            goto L_0x002e
        L_0x002d:
            r3 = 0
        L_0x002e:
            if (r11 != 0) goto L_0x0036
            if (r3 == 0) goto L_0x0036
            r10.inMutable = r6
            r3 = r0
            goto L_0x004c
        L_0x0036:
            if (r11 == 0) goto L_0x003e
            if (r3 == 0) goto L_0x003e
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            r10.inPreferredConfig = r3
        L_0x003e:
            int r3 = r8.getBitmapSize(r1, r2, r10)
            com.facebook.imagepipeline.memory.BitmapPool r7 = r8.mBitmapPool
            java.lang.Object r3 = r7.get(r3)
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            if (r3 == 0) goto L_0x00fb
        L_0x004c:
            r10.inBitmap = r3
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r4) goto L_0x005c
            if (r12 != 0) goto L_0x005a
            android.graphics.ColorSpace$Named r12 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r12 = android.graphics.ColorSpace.get(r12)
        L_0x005a:
            r10.inPreferredColorSpace = r12
        L_0x005c:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r12 = r8.mDecodeBuffers
            java.lang.Object r12 = r12.acquire()
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            if (r12 != 0) goto L_0x006c
            r12 = 16384(0x4000, float:2.2959E-41)
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r12)
        L_0x006c:
            byte[] r4 = r12.array()     // Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb }
            r10.inTempStorage = r4     // Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb }
            if (r11 == 0) goto L_0x00a3
            if (r3 == 0) goto L_0x00a3
            android.graphics.Bitmap$Config r4 = r10.inPreferredConfig     // Catch:{ IOException -> 0x0089, all -> 0x0087 }
            r3.reconfigure(r1, r2, r4)     // Catch:{ IOException -> 0x0089, all -> 0x0087 }
            android.graphics.BitmapRegionDecoder r1 = android.graphics.BitmapRegionDecoder.newInstance(r9, r5)     // Catch:{ IOException -> 0x0089, all -> 0x0087 }
            android.graphics.Bitmap r11 = r1.decodeRegion(r11, r10)     // Catch:{ IOException -> 0x008a }
            r1.recycle()     // Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb }
            goto L_0x00a4
        L_0x0087:
            r10 = move-exception
            goto L_0x009d
        L_0x0089:
            r1 = r0
        L_0x008a:
            java.lang.Class<?> r2 = TAG     // Catch:{ all -> 0x009b }
            java.lang.String r4 = "Could not decode region %s, decoding full bitmap instead."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x009b }
            r5[r6] = r11     // Catch:{ all -> 0x009b }
            com.facebook.common.logging.FLog.e(r2, r4, r5)     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x00a3
            r1.recycle()     // Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb }
            goto L_0x00a3
        L_0x009b:
            r10 = move-exception
            r0 = r1
        L_0x009d:
            if (r0 == 0) goto L_0x00a2
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb }
        L_0x00a2:
            throw r10     // Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb }
        L_0x00a3:
            r11 = r0
        L_0x00a4:
            if (r11 != 0) goto L_0x00aa
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeStream(r9, r0, r10)     // Catch:{ IllegalArgumentException -> 0x00d4, RuntimeException -> 0x00cb }
        L_0x00aa:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r9 = r8.mDecodeBuffers
            r9.release(r12)
            if (r3 == 0) goto L_0x00c2
            if (r3 != r11) goto L_0x00b4
            goto L_0x00c2
        L_0x00b4:
            com.facebook.imagepipeline.memory.BitmapPool r9 = r8.mBitmapPool
            r9.release(r3)
            r11.recycle()
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x00c2:
            com.facebook.imagepipeline.memory.BitmapPool r9 = r8.mBitmapPool
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.of(r11, r9)
            return r9
        L_0x00c9:
            r9 = move-exception
            goto L_0x00f5
        L_0x00cb:
            r9 = move-exception
            if (r3 == 0) goto L_0x00d3
            com.facebook.imagepipeline.memory.BitmapPool r10 = r8.mBitmapPool     // Catch:{ all -> 0x00c9 }
            r10.release(r3)     // Catch:{ all -> 0x00c9 }
        L_0x00d3:
            throw r9     // Catch:{ all -> 0x00c9 }
        L_0x00d4:
            r10 = move-exception
            if (r3 == 0) goto L_0x00dc
            com.facebook.imagepipeline.memory.BitmapPool r11 = r8.mBitmapPool     // Catch:{ all -> 0x00c9 }
            r11.release(r3)     // Catch:{ all -> 0x00c9 }
        L_0x00dc:
            r9.reset()     // Catch:{ IOException -> 0x00f4 }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r9)     // Catch:{ IOException -> 0x00f4 }
            if (r9 == 0) goto L_0x00f3
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r11 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance()     // Catch:{ IOException -> 0x00f4 }
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.of(r9, r11)     // Catch:{ IOException -> 0x00f4 }
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r10 = r8.mDecodeBuffers
            r10.release(r12)
            return r9
        L_0x00f3:
            throw r10     // Catch:{ IOException -> 0x00f4 }
        L_0x00f4:
            throw r10     // Catch:{ all -> 0x00c9 }
        L_0x00f5:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r10 = r8.mDecodeBuffers
            r10.release(r12)
            throw r9
        L_0x00fb:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "BitmapPool.get returned null"
            r9.<init>(r10)
            throw r9
        L_0x0103:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.DefaultDecoder.decodeFromStream(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, android.graphics.ColorSpace):com.facebook.common.references.CloseableReference");
    }

    public static Options getDecodeOptionsForStream(EncodedImage encodedImage, Config config) {
        Options options = new Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
    }

    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Config config, Rect rect, ColorSpace colorSpace) {
        Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        boolean z = decodeOptionsForStream.inPreferredConfig != Config.ARGB_8888;
        try {
            return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e2) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Config.ARGB_8888, rect, colorSpace);
            }
            throw e2;
        }
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Config config, Rect rect, int i, ColorSpace colorSpace) {
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        InputStream inputStream = encodedImage.getInputStream();
        k.checkNotNull1(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        if (!isCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        boolean z = decodeOptionsForStream.inPreferredConfig != Config.ARGB_8888;
        try {
            return decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e2) {
            if (z) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Config.ARGB_8888, rect, i, colorSpace);
            }
            throw e2;
        }
    }

    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, Options options, Rect rect) {
        return decodeFromStream(inputStream, options, rect, null);
    }

    public abstract int getBitmapSize(int i, int i2, Options options);
}
