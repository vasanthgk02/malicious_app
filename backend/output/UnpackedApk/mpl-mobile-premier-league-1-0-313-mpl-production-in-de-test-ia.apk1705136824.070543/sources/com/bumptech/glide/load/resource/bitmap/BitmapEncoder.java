package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<CompressFormat> COMPRESSION_FORMAT = new Option<>("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, Option.EMPTY_UPDATER);
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
    public final ArrayPool arrayPool;

    public BitmapEncoder(ArrayPool arrayPool2) {
        this.arrayPool = arrayPool2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:24|39|(2:41|42)|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r6 != null) goto L_0x005f;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b2 */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00af A[SYNTHETIC, Splitter:B:41:0x00af] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(java.lang.Object r9, java.io.File r10, com.bumptech.glide.load.Options r11) {
        /*
            r8 = this;
            com.bumptech.glide.load.engine.Resource r9 = (com.bumptech.glide.load.engine.Resource) r9
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r1 = COMPRESSION_FORMAT
            java.lang.Object r1 = r11.get(r1)
            android.graphics.Bitmap$CompressFormat r1 = (android.graphics.Bitmap.CompressFormat) r1
            if (r1 == 0) goto L_0x0015
            goto L_0x0020
        L_0x0015:
            boolean r1 = r9.hasAlpha()
            if (r1 == 0) goto L_0x001e
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L_0x0020
        L_0x001e:
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L_0x0020:
            r9.getWidth()
            r9.getHeight()
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = COMPRESSION_QUALITY     // Catch:{ all -> 0x00b3 }
            java.lang.Object r4 = r11.get(r4)     // Catch:{ all -> 0x00b3 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00b3 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00b3 }
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0059 }
            r7.<init>(r10)     // Catch:{ IOException -> 0x0059 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r10 = r8.arrayPool     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            if (r10 == 0) goto L_0x004a
            com.bumptech.glide.load.data.BufferedOutputStream r10 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r8.arrayPool     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            r10.<init>(r7, r6)     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            r6 = r10
            goto L_0x004b
        L_0x004a:
            r6 = r7
        L_0x004b:
            r9.compress(r1, r4, r6)     // Catch:{ IOException -> 0x0059 }
            r6.close()     // Catch:{ IOException -> 0x0059 }
            r5 = 1
            goto L_0x005f
        L_0x0053:
            r9 = move-exception
            goto L_0x00ad
        L_0x0055:
            r6 = r7
            goto L_0x0059
        L_0x0057:
            r9 = move-exception
            goto L_0x00ac
        L_0x0059:
            r10 = 3
            android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x0057 }
            if (r6 == 0) goto L_0x0062
        L_0x005f:
            r6.close()     // Catch:{ IOException -> 0x0062 }
        L_0x0062:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x00b3 }
            if (r10 == 0) goto L_0x00ab
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r10.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = "Compressed with type: "
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            r10.append(r1)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = " of size "
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            int r0 = com.bumptech.glide.util.Util.getBitmapByteSize(r9)     // Catch:{ all -> 0x00b3 }
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = " in "
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            double r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch:{ all -> 0x00b3 }
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = ", options format: "
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r0 = COMPRESSION_FORMAT     // Catch:{ all -> 0x00b3 }
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x00b3 }
            r10.append(r11)     // Catch:{ all -> 0x00b3 }
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch:{ all -> 0x00b3 }
            boolean r9 = r9.hasAlpha()     // Catch:{ all -> 0x00b3 }
            r10.append(r9)     // Catch:{ all -> 0x00b3 }
            r10.toString()     // Catch:{ all -> 0x00b3 }
        L_0x00ab:
            return r5
        L_0x00ac:
            r7 = r6
        L_0x00ad:
            if (r7 == 0) goto L_0x00b2
            r7.close()     // Catch:{ IOException -> 0x00b2 }
        L_0x00b2:
            throw r9     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(java.lang.Object, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
