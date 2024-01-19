package org.apache.javax.imageio.stream;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;

public class MemoryCache {
    public static final int BUFFER_LENGTH = 8192;
    public ArrayList cache = new ArrayList();
    public long cacheStart = 0;
    public long length = 0;

    private byte[] getCacheBlock(long j) throws IOException {
        long j2 = j - this.cacheStart;
        if (j2 <= 2147483647L) {
            return (byte[]) this.cache.get((int) j2);
        }
        throw new IOException("Cache addressing limit exceeded!");
    }

    private void pad(long j) throws IOException {
        long size = (j / PlaybackStateCompat.ACTION_PLAY_FROM_URI) - ((this.cacheStart + ((long) this.cache.size())) - 1);
        long j2 = 0;
        while (j2 < size) {
            try {
                this.cache.add(new byte[8192]);
                j2++;
            } catch (OutOfMemoryError unused) {
                throw new IOException("No memory left for cache!");
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    public long loadFromStream(java.io.InputStream r13, long r14) throws java.io.IOException {
        /*
            r12 = this;
            long r0 = r12.length
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0007
            return r14
        L_0x0007:
            r2 = 8192(0x2000, double:4.0474E-320)
            long r4 = r0 % r2
            int r5 = (int) r4
            long r6 = r14 - r0
            r4 = 0
            if (r5 == 0) goto L_0x0017
            long r0 = r0 / r2
            byte[] r0 = r12.getCacheBlock(r0)
            goto L_0x0018
        L_0x0017:
            r0 = r4
        L_0x0018:
            r1 = 0
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0052
            r1 = 8192(0x2000, float:1.148E-41)
            if (r0 != 0) goto L_0x002e
            byte[] r0 = new byte[r1]     // Catch:{ OutOfMemoryError -> 0x0026 }
            r5 = 0
            goto L_0x002e
        L_0x0026:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r14 = "No memory left for cache!"
            r13.<init>(r14)
            throw r13
        L_0x002e:
            int r2 = 8192 - r5
            long r2 = (long) r2
            long r2 = java.lang.Math.min(r6, r2)
            int r3 = (int) r2
            int r2 = r13.read(r0, r5, r3)
            r3 = -1
            if (r2 != r3) goto L_0x0040
            long r13 = r12.length
            return r13
        L_0x0040:
            if (r5 != 0) goto L_0x0047
            java.util.ArrayList r3 = r12.cache
            r3.add(r0)
        L_0x0047:
            long r8 = (long) r2
            long r6 = r6 - r8
            long r10 = r12.length
            long r10 = r10 + r8
            r12.length = r10
            int r5 = r5 + r2
            if (r5 < r1) goto L_0x0018
            goto L_0x0017
        L_0x0052:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.javax.imageio.stream.MemoryCache.loadFromStream(java.io.InputStream, long):long");
    }

    public int read(long j) throws IOException {
        if (j >= this.length) {
            return -1;
        }
        byte[] cacheBlock = getCacheBlock(j / PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (cacheBlock == null) {
            return -1;
        }
        return cacheBlock[(int) (j % PlaybackStateCompat.ACTION_PLAY_FROM_URI)] & 255;
    }

    public void write(int i, long j) throws IOException {
        if (j >= 0) {
            if (j >= this.length) {
                pad(j);
                this.length = 1 + j;
            }
            getCacheBlock(j / PlaybackStateCompat.ACTION_PLAY_FROM_URI)[(int) (j % PlaybackStateCompat.ACTION_PLAY_FROM_URI)] = (byte) i;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("pos < 0");
    }
}
