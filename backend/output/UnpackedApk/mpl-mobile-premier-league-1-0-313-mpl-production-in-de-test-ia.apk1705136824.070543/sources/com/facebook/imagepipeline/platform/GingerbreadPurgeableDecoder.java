package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

@DoNotStrip
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    public static Method sGetFileDescriptorMethod;
    public final WebpBitmapFactory mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();

    public static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr) throws IOException {
        OutputStream outputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer) closeableReference.get());
            try {
                inputStream = new LimitedInputStream(pooledByteBufferInputStream, i);
            } catch (Throwable th) {
                th = th;
                inputStream = null;
                outputStream = null;
                inputStream2 = pooledByteBufferInputStream;
                CloseableReference.closeSafely(closeableReference);
                Closeables.closeQuietly(inputStream2);
                Closeables.closeQuietly(inputStream);
                Closeables.close(outputStream, true);
                throw th;
            }
            try {
                outputStream = memoryFile.getOutputStream();
                if (outputStream != null) {
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr2, 0, read);
                        }
                        if (bArr != null) {
                            memoryFile.writeBytes(bArr, 0, i, bArr.length);
                        }
                        closeableReference.close();
                        Closeables.closeQuietly(pooledByteBufferInputStream);
                        Closeables.closeQuietly(inputStream);
                        Closeables.close(outputStream, true);
                        return memoryFile;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = pooledByteBufferInputStream;
                        CloseableReference.closeSafely(closeableReference);
                        Closeables.closeQuietly(inputStream2);
                        Closeables.closeQuietly(inputStream);
                        Closeables.close(outputStream, true);
                        throw th;
                    }
                } else {
                    throw null;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                inputStream2 = pooledByteBufferInputStream;
                CloseableReference.closeSafely(closeableReference);
                Closeables.closeQuietly(inputStream2);
                Closeables.closeQuietly(inputStream);
                Closeables.close(outputStream, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            outputStream = null;
            CloseableReference.closeSafely(closeableReference);
            Closeables.closeQuietly(inputStream2);
            Closeables.closeQuietly(inputStream);
            Closeables.close(outputStream, true);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap decodeFileDescriptorAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> r2, int r3, byte[] r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r1 = this;
            r0 = 0
            android.os.MemoryFile r2 = copyToMemoryFile(r2, r3, r4)     // Catch:{ IOException -> 0x002e, all -> 0x002c }
            java.io.FileDescriptor r3 = r1.getMemoryFileDescriptor(r2)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            com.facebook.common.webp.WebpBitmapFactory r4 = r1.mWebpBitmapFactory     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            if (r4 == 0) goto L_0x001e
            com.facebook.common.webp.WebpBitmapFactory r4 = r1.mWebpBitmapFactory     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            android.graphics.Bitmap r3 = r4.decodeFileDescriptor(r3, r0, r5)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            java.lang.String r4 = "BitmapFactory returned null"
            co.hyperverge.hypersnapsdk.c.k.checkNotNull(r3, r4)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            if (r2 == 0) goto L_0x001d
            r2.close()
        L_0x001d:
            return r3
        L_0x001e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            java.lang.String r4 = "WebpBitmapFactory is null"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            throw r3     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
        L_0x0026:
            r3 = move-exception
            r0 = r2
            goto L_0x003c
        L_0x0029:
            r3 = move-exception
            r0 = r2
            goto L_0x002f
        L_0x002c:
            r3 = move-exception
            goto L_0x003c
        L_0x002e:
            r3 = move-exception
        L_0x002f:
            co.hyperverge.hypersnapsdk.c.k.propagateIfPossible(r3)     // Catch:{ all -> 0x003a }
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x003a }
            r2.<init>(r3)     // Catch:{ all -> 0x003a }
            throw r2     // Catch:{ all -> 0x003a }
        L_0x0038:
            r3 = r2
            goto L_0x003c
        L_0x003a:
            r2 = move-exception
            goto L_0x0038
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.close()
        L_0x0041:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder.decodeFileDescriptorAsPurgeable(com.facebook.common.references.CloseableReference, int, byte[], android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private synchronized Method getFileDescriptorMethod() {
        if (sGetFileDescriptorMethod == null) {
            try {
                sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e2) {
                k.propagateIfPossible(e2);
                throw new RuntimeException(e2);
            }
        }
        return sGetFileDescriptorMethod;
    }

    private FileDescriptor getMemoryFileDescriptor(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) getFileDescriptorMethod().invoke(memoryFile, new Object[0]);
        } catch (Exception e2) {
            k.propagateIfPossible(e2);
            throw new RuntimeException(e2);
        }
    }

    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, ((PooledByteBuffer) closeableReference.get()).size(), null, options);
    }

    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, i, DalvikPurgeableDecoder.endsWithEOI(closeableReference, i) ? null : DalvikPurgeableDecoder.EOI, options);
    }
}
