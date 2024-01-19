package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Option.CacheKeyUpdater;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    public static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    public static final Option<Integer> FRAME_OPTION = new Option<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new CacheKeyUpdater<Integer>() {
        public final ByteBuffer buffer = ByteBuffer.allocate(4);

        public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
            Integer num = (Integer) obj;
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.buffer) {
                    this.buffer.position(0);
                    messageDigest.update(this.buffer.putInt(num.intValue()).array());
                }
            }
        }
    });
    public static final Option<Long> TARGET_FRAME = new Option<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new CacheKeyUpdater<Long>() {
        public final ByteBuffer buffer = ByteBuffer.allocate(8);

        public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
            Long l = (Long) obj;
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putLong(l.longValue()).array());
            }
        }
    });
    public final BitmapPool bitmapPool;
    public final MediaMetadataRetrieverFactory factory;
    public final MediaMetadataRetrieverInitializer<T> initializer;

    public static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        public AssetFileDescriptorInitializer(AnonymousClass1 r1) {
        }

        public void initialize(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    public static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
        public void initialize(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            final ByteBuffer byteBuffer = (ByteBuffer) obj;
            mediaMetadataRetriever.setDataSource(new MediaDataSource(this) {
                public void close() {
                }

                public long getSize() {
                    return (long) byteBuffer.limit();
                }

                public int readAt(long j, byte[] bArr, int i, int i2) {
                    if (j >= ((long) byteBuffer.limit())) {
                        return -1;
                    }
                    byteBuffer.position((int) j);
                    int min = Math.min(i2, byteBuffer.remaining());
                    byteBuffer.get(bArr, i, min);
                    return min;
                }
            });
        }
    }

    public static class MediaMetadataRetrieverFactory {
    }

    public interface MediaMetadataRetrieverInitializer<T> {
        void initialize(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        public void initialize(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
        }
    }

    public VideoDecoder(BitmapPool bitmapPool2, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory = DEFAULT_FACTORY;
        this.bitmapPool = bitmapPool2;
        this.initializer = mediaMetadataRetrieverInitializer;
        this.factory = mediaMetadataRetrieverFactory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeFrame(android.media.MediaMetadataRetriever r9, long r10, int r12, int r13, int r14, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r15) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 27
            if (r0 < r1) goto L_0x0059
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == r0) goto L_0x0059
            if (r14 == r0) goto L_0x0059
            com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r0 = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.NONE
            if (r15 == r0) goto L_0x0059
            r0 = 18
            java.lang.String r0 = r9.extractMetadata(r0)     // Catch:{ all -> 0x0053 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0053 }
            r1 = 19
            java.lang.String r1 = r9.extractMetadata(r1)     // Catch:{ all -> 0x0053 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0053 }
            r2 = 24
            java.lang.String r2 = r9.extractMetadata(r2)     // Catch:{ all -> 0x0053 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0053 }
            r3 = 90
            if (r2 == r3) goto L_0x0036
            r3 = 270(0x10e, float:3.78E-43)
            if (r2 != r3) goto L_0x0039
        L_0x0036:
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x0039:
            float r13 = r15.getScaleFactor(r0, r1, r13, r14)     // Catch:{ all -> 0x0053 }
            float r14 = (float) r0     // Catch:{ all -> 0x0053 }
            float r14 = r14 * r13
            int r6 = java.lang.Math.round(r14)     // Catch:{ all -> 0x0053 }
            float r14 = (float) r1     // Catch:{ all -> 0x0053 }
            float r13 = r13 * r14
            int r7 = java.lang.Math.round(r13)     // Catch:{ all -> 0x0053 }
            r2 = r9
            r3 = r10
            r5 = r12
            android.graphics.Bitmap r13 = r2.getScaledFrameAtTime(r3, r5, r6, r7)     // Catch:{ all -> 0x0053 }
            goto L_0x005a
        L_0x0053:
            r13 = 3
            java.lang.String r14 = "VideoDecoder"
            android.util.Log.isLoggable(r14, r13)
        L_0x0059:
            r13 = 0
        L_0x005a:
            if (r13 != 0) goto L_0x0060
            android.graphics.Bitmap r13 = r9.getFrameAtTime(r10, r12)
        L_0x0060:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.decodeFrame(android.media.MediaMetadataRetriever, long, int, int, int, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy):android.graphics.Bitmap");
    }

    public Resource<Bitmap> decode(T t, int i, int i2, Options options) throws IOException {
        long longValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) options.get(FRAME_OPTION);
            if (num == null) {
                num = Integer.valueOf(2);
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.DEFAULT;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            if (this.factory != null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    this.initializer.initialize(mediaMetadataRetriever, t);
                    Bitmap decodeFrame = decodeFrame(mediaMetadataRetriever, longValue, num.intValue(), i, i2, downsampleStrategy2);
                    mediaMetadataRetriever.release();
                    return BitmapResource.obtain(decodeFrame, this.bitmapPool);
                } catch (RuntimeException e2) {
                    throw new IOException(e2);
                } catch (Throwable th) {
                    mediaMetadataRetriever.release();
                    throw th;
                }
            } else {
                throw null;
            }
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", longValue));
        }
    }

    public boolean handles(T t, Options options) {
        return true;
    }
}
