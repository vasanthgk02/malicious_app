package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public class StreamEncoder implements Encoder<InputStream> {
    public final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0042 A[SYNTHETIC, Splitter:B:27:0x0042] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(java.lang.Object r4, java.io.File r5, com.bumptech.glide.load.Options r6) {
        /*
            r3 = this;
            java.io.InputStream r4 = (java.io.InputStream) r4
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r3.byteArrayPool
            java.lang.Class<byte[]> r0 = byte[].class
            r1 = 65536(0x10000, float:9.1835E-41)
            java.lang.Object r6 = r6.get(r1, r0)
            byte[] r6 = (byte[]) r6
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002e }
            r2.<init>(r5)     // Catch:{ IOException -> 0x002e }
        L_0x0015:
            int r5 = r4.read(r6)     // Catch:{ IOException -> 0x002a, all -> 0x0028 }
            r1 = -1
            if (r5 == r1) goto L_0x0020
            r2.write(r6, r0, r5)     // Catch:{ IOException -> 0x002a, all -> 0x0028 }
            goto L_0x0015
        L_0x0020:
            r2.close()     // Catch:{ IOException -> 0x002a, all -> 0x0028 }
            r0 = 1
            r2.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x0039
        L_0x0028:
            r4 = move-exception
            goto L_0x0040
        L_0x002a:
            r1 = r2
            goto L_0x002e
        L_0x002c:
            r4 = move-exception
            goto L_0x003f
        L_0x002e:
            java.lang.String r4 = "StreamEncoder"
            r5 = 3
            android.util.Log.isLoggable(r4, r5)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r3.byteArrayPool
            r4.put(r6)
            return r0
        L_0x003f:
            r2 = r1
        L_0x0040:
            if (r2 == 0) goto L_0x0045
            r2.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r5 = r3.byteArrayPool
            r5.put(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.StreamEncoder.encode(java.lang.Object, java.io.File, com.bumptech.glide.load.Options):boolean");
    }
}
