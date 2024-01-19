package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;

public class HoneycombBitmapCreator implements BitmapCreator {
    public final FlexByteArrayPool mFlexByteArrayPool;
    public final EmptyJpegGenerator mJpegGenerator;

    public HoneycombBitmapCreator(PoolFactory poolFactory) {
        this.mFlexByteArrayPool = poolFactory.getFlexByteArrayPool();
        this.mJpegGenerator = new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory());
    }

    public static Options getBitmapFactoryOptions(int i, Config config) {
        Options options = new Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        options.inMutable = true;
        return options;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005e  */
    @android.annotation.TargetApi(12)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap createNakedBitmap(int r6, int r7, android.graphics.Bitmap.Config r8) {
        /*
            r5 = this;
            com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator r0 = r5.mJpegGenerator
            short r6 = (short) r6
            short r7 = (short) r7
            com.facebook.common.references.CloseableReference r6 = r0.generate(r6, r7)
            r7 = 0
            com.facebook.imagepipeline.image.EncodedImage r0 = new com.facebook.imagepipeline.image.EncodedImage     // Catch:{ all -> 0x0054 }
            r0.<init>(r6)     // Catch:{ all -> 0x0054 }
            com.facebook.imageformat.ImageFormat r1 = com.facebook.imageformat.DefaultImageFormats.JPEG     // Catch:{ all -> 0x0052 }
            r0.setImageFormat(r1)     // Catch:{ all -> 0x0052 }
            int r1 = r0.getSampleSize()     // Catch:{ all -> 0x0052 }
            android.graphics.BitmapFactory$Options r8 = getBitmapFactoryOptions(r1, r8)     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r6.get()     // Catch:{ all -> 0x0052 }
            com.facebook.common.memory.PooledByteBuffer r1 = (com.facebook.common.memory.PooledByteBuffer) r1     // Catch:{ all -> 0x0052 }
            int r1 = r1.size()     // Catch:{ all -> 0x0052 }
            java.lang.Object r2 = r6.get()     // Catch:{ all -> 0x0052 }
            com.facebook.common.memory.PooledByteBuffer r2 = (com.facebook.common.memory.PooledByteBuffer) r2     // Catch:{ all -> 0x0052 }
            com.facebook.imagepipeline.memory.FlexByteArrayPool r3 = r5.mFlexByteArrayPool     // Catch:{ all -> 0x0052 }
            int r4 = r1 + 2
            com.facebook.common.references.CloseableReference r7 = r3.get(r4)     // Catch:{ all -> 0x0052 }
            java.lang.Object r3 = r7.get()     // Catch:{ all -> 0x0052 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0052 }
            r4 = 0
            r2.read(r4, r3, r4, r1)     // Catch:{ all -> 0x0052 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r3, r4, r1, r8)     // Catch:{ all -> 0x0052 }
            r1 = 1
            r8.setHasAlpha(r1)     // Catch:{ all -> 0x0052 }
            r8.eraseColor(r4)     // Catch:{ all -> 0x0052 }
            r7.close()
            com.facebook.imagepipeline.image.EncodedImage.closeSafely(r0)
            r6.close()
            return r8
        L_0x0052:
            r8 = move-exception
            goto L_0x0056
        L_0x0054:
            r8 = move-exception
            r0 = r7
        L_0x0056:
            com.facebook.common.references.CloseableReference.closeSafely(r7)
            com.facebook.imagepipeline.image.EncodedImage.closeSafely(r0)
            if (r6 == 0) goto L_0x0061
            r6.close()
        L_0x0061:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator.createNakedBitmap(int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }
}
