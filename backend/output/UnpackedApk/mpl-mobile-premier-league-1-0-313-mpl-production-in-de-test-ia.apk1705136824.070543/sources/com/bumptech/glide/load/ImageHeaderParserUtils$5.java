package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class ImageHeaderParserUtils$5 implements ImageHeaderParserUtils$OrientationReader {
    public final /* synthetic */ ArrayPool val$byteArrayPool;
    public final /* synthetic */ ParcelFileDescriptorRewinder val$parcelFileDescriptorRewinder;

    public ImageHeaderParserUtils$5(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ArrayPool arrayPool) {
        this.val$parcelFileDescriptorRewinder = parcelFileDescriptorRewinder;
        this.val$byteArrayPool = arrayPool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOrientation(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0029 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0029 }
            com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r3 = r4.val$parcelFileDescriptorRewinder     // Catch:{ all -> 0x0029 }
            android.os.ParcelFileDescriptor r3 = r3.rewindAndGet()     // Catch:{ all -> 0x0029 }
            java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0029 }
            r2.<init>(r3)     // Catch:{ all -> 0x0029 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r4.val$byteArrayPool     // Catch:{ all -> 0x0029 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0029 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r0 = r4.val$byteArrayPool     // Catch:{ all -> 0x0026 }
            int r5 = r5.getOrientation(r1, r0)     // Catch:{ all -> 0x0026 }
            r1.close()     // Catch:{ IOException -> 0x0020 }
        L_0x0020:
            com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = r4.val$parcelFileDescriptorRewinder
            r0.rewindAndGet()
            return r5
        L_0x0026:
            r5 = move-exception
            r0 = r1
            goto L_0x002a
        L_0x0029:
            r5 = move-exception
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = r4.val$parcelFileDescriptorRewinder
            r0.rewindAndGet()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.ImageHeaderParserUtils$5.getOrientation(com.bumptech.glide.load.ImageHeaderParser):int");
    }
}
