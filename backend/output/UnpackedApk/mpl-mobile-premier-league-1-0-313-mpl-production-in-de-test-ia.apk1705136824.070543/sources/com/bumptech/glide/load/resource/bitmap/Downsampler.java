package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.ImageReader.InputStreamImageReader;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() {
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void onObtainBounds() {
        }
    };
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
    public static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    public static final Queue<Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    public static final Set<ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageType.JPEG, ImageType.PNG_A, ImageType.PNG));
    public final BitmapPool bitmapPool;
    public final ArrayPool byteArrayPool;
    public final DisplayMetrics displayMetrics;
    public final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    public final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    static {
        Option<DownsampleStrategy> option = DownsampleStrategy.OPTION;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool arrayPool) {
        this.parsers = list;
        k.checkNotNull(displayMetrics2, (String) "Argument must not be null");
        this.displayMetrics = displayMetrics2;
        k.checkNotNull(bitmapPool2, (String) "Argument must not be null");
        this.bitmapPool = bitmapPool2;
        k.checkNotNull(arrayPool, (String) "Argument must not be null");
        this.byteArrayPool = arrayPool;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader r4, android.graphics.BitmapFactory.Options r5, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r6, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto L_0x000a
            r6.onObtainBounds()
            r4.stopGrowingBuffers()
        L_0x000a:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.BITMAP_DRAWABLE_LOCK
            r3.lock()
            android.graphics.Bitmap r4 = r4.decodeBitmap(r5)     // Catch:{ IllegalArgumentException -> 0x0021 }
        L_0x0019:
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.BITMAP_DRAWABLE_LOCK
            r5.unlock()
            return r4
        L_0x001f:
            r4 = move-exception
            goto L_0x003f
        L_0x0021:
            r3 = move-exception
            java.io.IOException r0 = newIoExceptionForInBitmapAssertion(r3, r0, r1, r2, r5)     // Catch:{ all -> 0x001f }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x001f }
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x003e
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch:{ IOException -> 0x003d }
            r7.put(r1)     // Catch:{ IOException -> 0x003d }
            r1 = 0
            r5.inBitmap = r1     // Catch:{ IOException -> 0x003d }
            android.graphics.Bitmap r4 = decodeStream(r4, r5, r6, r7)     // Catch:{ IOException -> 0x003d }
            goto L_0x0019
        L_0x003d:
            throw r0     // Catch:{ all -> 0x001f }
        L_0x003e:
            throw r0     // Catch:{ all -> 0x001f }
        L_0x003f:
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.BITMAP_DRAWABLE_LOCK
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    @TargetApi(19)
    public static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" (");
        outline73.append(bitmap.getAllocationByteCount());
        outline73.append(")");
        String sb = outline73.toString();
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("[");
        outline732.append(bitmap.getWidth());
        outline732.append("x");
        outline732.append(bitmap.getHeight());
        outline732.append("] ");
        outline732.append(bitmap.getConfig());
        outline732.append(sb);
        return outline732.toString();
    }

    public static int getDensityMultiplier(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    public static int[] getDimensions(ImageReader imageReader, Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static boolean isRotationRequired(int i) {
        return i == 90 || i == 270;
    }

    public static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, Options options) {
        StringBuilder outline75 = GeneratedOutlineSupport.outline75("Exception decoding bitmap, outWidth: ", i, ", outHeight: ", i2, ", outMimeType: ");
        outline75.append(str);
        outline75.append(", inBitmap: ");
        outline75.append(getBitmapString(options.inBitmap));
        return new IOException(outline75.toString(), illegalArgumentException);
    }

    public static void resetOptions(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int round(double d2) {
        return (int) (d2 + 0.5d);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return decode((ImageReader) new InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i, i2, options, decodeCallbacks);
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap decodeFromWrappedStreams(com.bumptech.glide.load.resource.bitmap.ImageReader r25, android.graphics.BitmapFactory.Options r26, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r27, com.bumptech.glide.load.DecodeFormat r28, com.bumptech.glide.load.PreferredColorSpace r29, boolean r30, int r31, int r32, boolean r33, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r34) throws java.io.IOException {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r34
            long r6 = com.bumptech.glide.util.LogTime.getLogTime()
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8 = r0.bitmapPool
            int[] r8 = getDimensions(r1, r2, r5, r8)
            r9 = 0
            r10 = r8[r9]
            r11 = 1
            r8 = r8[r11]
            r12 = -1
            if (r10 == r12) goto L_0x0025
            if (r8 != r12) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            r12 = r30
            goto L_0x0026
        L_0x0025:
            r12 = 0
        L_0x0026:
            int r13 = r25.getImageOrientation()
            switch(r13) {
                case 3: goto L_0x0035;
                case 4: goto L_0x0035;
                case 5: goto L_0x0032;
                case 6: goto L_0x0032;
                case 7: goto L_0x002f;
                case 8: goto L_0x002f;
                default: goto L_0x002d;
            }
        L_0x002d:
            r14 = 0
            goto L_0x0037
        L_0x002f:
            r14 = 270(0x10e, float:3.78E-43)
            goto L_0x0037
        L_0x0032:
            r14 = 90
            goto L_0x0037
        L_0x0035:
            r14 = 180(0xb4, float:2.52E-43)
        L_0x0037:
            switch(r13) {
                case 2: goto L_0x003c;
                case 3: goto L_0x003c;
                case 4: goto L_0x003c;
                case 5: goto L_0x003c;
                case 6: goto L_0x003c;
                case 7: goto L_0x003c;
                case 8: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r15 = 0
            goto L_0x003d
        L_0x003c:
            r15 = 1
        L_0x003d:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r11 = r31
            if (r11 != r9) goto L_0x004c
            boolean r11 = isRotationRequired(r14)
            if (r11 == 0) goto L_0x004b
            r11 = r8
            goto L_0x004c
        L_0x004b:
            r11 = r10
        L_0x004c:
            r30 = r13
            r13 = r32
            if (r13 != r9) goto L_0x005b
            boolean r9 = isRotationRequired(r14)
            if (r9 == 0) goto L_0x005a
            r13 = r10
            goto L_0x005b
        L_0x005a:
            r13 = r8
        L_0x005b:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r9 = r25.getImageType()
            r16 = r6
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r6 = r0.bitmapPool
            java.lang.String r7 = "]"
            java.lang.String r4 = "x"
            r18 = r12
            java.lang.String r12 = "Downsampler"
            r19 = r15
            if (r10 <= 0) goto L_0x01fd
            if (r8 > 0) goto L_0x0073
            goto L_0x01fd
        L_0x0073:
            boolean r14 = isRotationRequired(r14)
            if (r14 == 0) goto L_0x007c
            r14 = r8
            r15 = r10
            goto L_0x007e
        L_0x007c:
            r15 = r8
            r14 = r10
        L_0x007e:
            float r0 = r3.getScaleFactor(r14, r15, r11, r13)
            r20 = 0
            int r21 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r21 <= 0) goto L_0x01b6
            com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding r4 = r3.getSampleSizeRounding(r14, r15, r11, r13)
            if (r4 == 0) goto L_0x01ae
            float r7 = (float) r14
            r20 = r8
            float r8 = r0 * r7
            r21 = r10
            r22 = r11
            double r10 = (double) r8
            int r8 = round(r10)
            float r10 = (float) r15
            float r11 = r0 * r10
            r23 = r12
            double r11 = (double) r11
            int r11 = round(r11)
            int r8 = r14 / r8
            int r11 = r15 / r11
            com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding r12 = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding.MEMORY
            if (r4 != r12) goto L_0x00b3
            int r8 = java.lang.Math.max(r8, r11)
            goto L_0x00b7
        L_0x00b3:
            int r8 = java.lang.Math.min(r8, r11)
        L_0x00b7:
            int r11 = android.os.Build.VERSION.SDK_INT
            r12 = 23
            if (r11 > r12) goto L_0x00c9
            java.util.Set<java.lang.String> r11 = NO_DOWNSAMPLE_PRE_N_MIME_TYPES
            java.lang.String r12 = r2.outMimeType
            boolean r11 = r11.contains(r12)
            if (r11 == 0) goto L_0x00c9
            r8 = 1
            goto L_0x00e2
        L_0x00c9:
            int r8 = java.lang.Integer.highestOneBit(r8)
            r11 = 1
            int r8 = java.lang.Math.max(r11, r8)
            com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding r11 = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding.MEMORY
            if (r4 != r11) goto L_0x00e2
            float r4 = (float) r8
            r11 = 1065353216(0x3f800000, float:1.0)
            float r0 = r11 / r0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e2
            int r0 = r8 << 1
            r8 = r0
        L_0x00e2:
            r2.inSampleSize = r8
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG
            if (r9 != r0) goto L_0x0103
            r0 = 8
            int r4 = java.lang.Math.min(r8, r0)
            float r4 = (float) r4
            float r7 = r7 / r4
            double r6 = (double) r7
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            float r10 = r10 / r4
            double r9 = (double) r10
            double r9 = java.lang.Math.ceil(r9)
            int r4 = (int) r9
            int r8 = r8 / r0
            if (r8 <= 0) goto L_0x0140
            int r6 = r6 / r8
            int r4 = r4 / r8
            goto L_0x0140
        L_0x0103:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG
            if (r9 == r0) goto L_0x0152
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A
            if (r9 != r0) goto L_0x010c
            goto L_0x0152
        L_0x010c:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP
            if (r9 == r0) goto L_0x012f
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A
            if (r9 != r0) goto L_0x0115
            goto L_0x012f
        L_0x0115:
            int r0 = r14 % r8
            if (r0 != 0) goto L_0x0123
            int r0 = r15 % r8
            if (r0 == 0) goto L_0x011e
            goto L_0x0123
        L_0x011e:
            int r6 = r14 / r8
            int r4 = r15 / r8
            goto L_0x0140
        L_0x0123:
            int[] r0 = getDimensions(r1, r2, r5, r6)
            r4 = 0
            r6 = r0[r4]
            r4 = 1
            r0 = r0[r4]
            r4 = r0
            goto L_0x0140
        L_0x012f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r0 < r4) goto L_0x0143
            float r0 = (float) r8
            float r7 = r7 / r0
            int r6 = java.lang.Math.round(r7)
            float r10 = r10 / r0
            int r4 = java.lang.Math.round(r10)
        L_0x0140:
            r8 = r22
            goto L_0x0165
        L_0x0143:
            float r0 = (float) r8
            float r7 = r7 / r0
            double r6 = (double) r7
            double r6 = java.lang.Math.floor(r6)
            int r4 = (int) r6
            float r10 = r10 / r0
            double r6 = (double) r10
            double r6 = java.lang.Math.floor(r6)
            goto L_0x0160
        L_0x0152:
            float r0 = (float) r8
            float r7 = r7 / r0
            double r6 = (double) r7
            double r6 = java.lang.Math.floor(r6)
            int r4 = (int) r6
            float r10 = r10 / r0
            double r6 = (double) r10
            double r6 = java.lang.Math.floor(r6)
        L_0x0160:
            int r0 = (int) r6
            r6 = r4
            r8 = r22
            r4 = r0
        L_0x0165:
            float r0 = r3.getScaleFactor(r6, r4, r8, r13)
            double r3 = (double) r0
            int r0 = getDensityMultiplier(r3)
            double r6 = (double) r0
            double r6 = r6 * r3
            int r6 = round(r6)
            float r7 = (float) r6
            float r0 = (float) r0
            float r7 = r7 / r0
            double r9 = (double) r7
            double r9 = r3 / r9
            double r6 = (double) r6
            double r9 = r9 * r6
            int r0 = round(r9)
            r2.inTargetDensity = r0
            int r0 = getDensityMultiplier(r3)
            r2.inDensity = r0
            int r3 = r2.inTargetDensity
            if (r3 <= 0) goto L_0x0194
            if (r0 <= 0) goto L_0x0194
            if (r3 == r0) goto L_0x0194
            r0 = 1
            goto L_0x0195
        L_0x0194:
            r0 = 0
        L_0x0195:
            if (r0 == 0) goto L_0x019b
            r0 = 1
            r2.inScaled = r0
            goto L_0x01a0
        L_0x019b:
            r0 = 0
            r2.inTargetDensity = r0
            r2.inDensity = r0
        L_0x01a0:
            r0 = r23
            r3 = 2
            android.util.Log.isLoggable(r0, r3)
            r4 = r24
            r6 = r20
            r3 = r21
            goto L_0x022b
        L_0x01ae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot round with null rounding"
            r0.<init>(r1)
            throw r0
        L_0x01b6:
            r20 = r8
            r21 = r10
            r8 = r11
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Cannot scale with factor: "
            r2.append(r5)
            r2.append(r0)
            java.lang.String r0 = " from: "
            r2.append(r0)
            r2.append(r3)
            java.lang.String r0 = ", source: ["
            r2.append(r0)
            r3 = r21
            r2.append(r3)
            r2.append(r4)
            r6 = r20
            r2.append(r6)
            java.lang.String r0 = "], target: ["
            r2.append(r0)
            r2.append(r8)
            r2.append(r4)
            r2.append(r13)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01fd:
            r6 = r8
            r3 = r10
            r8 = r11
            r0 = r12
            r10 = 3
            boolean r11 = android.util.Log.isLoggable(r0, r10)
            if (r11 == 0) goto L_0x0229
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unable to determine dimensions for: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = " with target ["
            r10.append(r9)
            r10.append(r8)
            r10.append(r4)
            r10.append(r13)
            r10.append(r7)
            r10.toString()
        L_0x0229:
            r4 = r24
        L_0x022b:
            com.bumptech.glide.load.resource.bitmap.HardwareConfigState r7 = r4.hardwareConfigState
            r9 = r18
            r11 = r19
            boolean r7 = r7.isHardwareConfigAllowed(r8, r13, r9, r11)
            if (r7 == 0) goto L_0x023f
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.HARDWARE
            r2.inPreferredConfig = r9
            r11 = 0
            r2.inMutable = r11
            goto L_0x0240
        L_0x023f:
            r11 = 0
        L_0x0240:
            if (r7 == 0) goto L_0x0244
        L_0x0242:
            r7 = 1
            goto L_0x0281
        L_0x0244:
            com.bumptech.glide.load.DecodeFormat r7 = com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
            r9 = r28
            if (r9 == r7) goto L_0x027c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r7 = r25.getImageType()     // Catch:{ IOException -> 0x0253 }
            boolean r7 = r7.hasAlpha()     // Catch:{ IOException -> 0x0253 }
            goto L_0x026b
        L_0x0253:
            r7 = 3
            boolean r7 = android.util.Log.isLoggable(r0, r7)
            if (r7 == 0) goto L_0x026a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Cannot determine whether the image has alpha or not from header, format "
            r7.append(r10)
            r7.append(r9)
            r7.toString()
        L_0x026a:
            r7 = 0
        L_0x026b:
            if (r7 == 0) goto L_0x0270
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x0272
        L_0x0270:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGB_565
        L_0x0272:
            r2.inPreferredConfig = r7
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.RGB_565
            if (r7 != r9) goto L_0x0242
            r7 = 1
            r2.inDither = r7
            goto L_0x0281
        L_0x027c:
            r7 = 1
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
            r2.inPreferredConfig = r9
        L_0x0281:
            int r9 = r2.inSampleSize
            r10 = 0
            r12 = 26
            if (r3 < 0) goto L_0x028d
            if (r6 < 0) goto L_0x028d
            if (r33 == 0) goto L_0x028d
            goto L_0x02cc
        L_0x028d:
            int r8 = r2.inTargetDensity
            if (r8 <= 0) goto L_0x0299
            int r9 = r2.inDensity
            if (r9 <= 0) goto L_0x0299
            if (r8 == r9) goto L_0x0299
            r8 = 1
            goto L_0x029a
        L_0x0299:
            r8 = 0
        L_0x029a:
            if (r8 == 0) goto L_0x02a4
            int r8 = r2.inTargetDensity
            float r8 = (float) r8
            int r9 = r2.inDensity
            float r9 = (float) r9
            float r8 = r8 / r9
            goto L_0x02a6
        L_0x02a4:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x02a6:
            int r9 = r2.inSampleSize
            float r3 = (float) r3
            float r9 = (float) r9
            float r3 = r3 / r9
            double r13 = (double) r3
            double r13 = java.lang.Math.ceil(r13)
            int r3 = (int) r13
            float r6 = (float) r6
            float r6 = r6 / r9
            double r13 = (double) r6
            double r13 = java.lang.Math.ceil(r13)
            int r6 = (int) r13
            float r3 = (float) r3
            float r3 = r3 * r8
            int r3 = java.lang.Math.round(r3)
            float r6 = (float) r6
            float r6 = r6 * r8
            int r13 = java.lang.Math.round(r6)
            r6 = 2
            android.util.Log.isLoggable(r0, r6)
            r8 = r3
        L_0x02cc:
            if (r8 <= 0) goto L_0x02eb
            if (r13 <= 0) goto L_0x02eb
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r3 = r4.bitmapPool
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r12) goto L_0x02e0
            android.graphics.Bitmap$Config r6 = r2.inPreferredConfig
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.HARDWARE
            if (r6 != r9) goto L_0x02dd
            goto L_0x02eb
        L_0x02dd:
            android.graphics.Bitmap$Config r6 = r2.outConfig
            goto L_0x02e1
        L_0x02e0:
            r6 = r10
        L_0x02e1:
            if (r6 != 0) goto L_0x02e5
            android.graphics.Bitmap$Config r6 = r2.inPreferredConfig
        L_0x02e5:
            android.graphics.Bitmap r3 = r3.getDirty(r8, r13, r6)
            r2.inBitmap = r3
        L_0x02eb:
            int r3 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r3 < r6) goto L_0x0312
            com.bumptech.glide.load.PreferredColorSpace r3 = com.bumptech.glide.load.PreferredColorSpace.DISPLAY_P3
            r6 = r29
            if (r6 != r3) goto L_0x0303
            android.graphics.ColorSpace r3 = r2.outColorSpace
            if (r3 == 0) goto L_0x0303
            boolean r3 = r3.isWideGamut()
            if (r3 == 0) goto L_0x0303
            r3 = 1
            goto L_0x0304
        L_0x0303:
            r3 = 0
        L_0x0304:
            if (r3 == 0) goto L_0x0309
            android.graphics.ColorSpace$Named r3 = android.graphics.ColorSpace.Named.DISPLAY_P3
            goto L_0x030b
        L_0x0309:
            android.graphics.ColorSpace$Named r3 = android.graphics.ColorSpace.Named.SRGB
        L_0x030b:
            android.graphics.ColorSpace r3 = android.graphics.ColorSpace.get(r3)
            r2.inPreferredColorSpace = r3
            goto L_0x031c
        L_0x0312:
            if (r3 < r12) goto L_0x031c
            android.graphics.ColorSpace$Named r3 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r3 = android.graphics.ColorSpace.get(r3)
            r2.inPreferredColorSpace = r3
        L_0x031c:
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r3 = r4.bitmapPool
            android.graphics.Bitmap r1 = decodeStream(r1, r2, r5, r3)
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r3 = r4.bitmapPool
            r5.onDecodeComplete(r3, r1)
            r3 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r3)
            if (r0 == 0) goto L_0x0340
            getBitmapString(r1)
            android.graphics.Bitmap r0 = r2.inBitmap
            getBitmapString(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.getName()
            com.bumptech.glide.util.LogTime.getElapsedMillis(r16)
        L_0x0340:
            if (r1 == 0) goto L_0x03dd
            android.util.DisplayMetrics r0 = r4.displayMetrics
            int r0 = r0.densityDpi
            r1.setDensity(r0)
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r0 = r4.bitmapPool
            switch(r30) {
                case 2: goto L_0x0350;
                case 3: goto L_0x0350;
                case 4: goto L_0x0350;
                case 5: goto L_0x0350;
                case 6: goto L_0x0350;
                case 7: goto L_0x0350;
                case 8: goto L_0x0350;
                default: goto L_0x034e;
            }
        L_0x034e:
            r9 = 0
            goto L_0x0351
        L_0x0350:
            r9 = 1
        L_0x0351:
            if (r9 != 0) goto L_0x0356
            r10 = r1
            goto L_0x03d2
        L_0x0356:
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r5 = 1119092736(0x42b40000, float:90.0)
            r6 = 1127481344(0x43340000, float:180.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            switch(r30) {
                case 2: goto L_0x038e;
                case 3: goto L_0x038a;
                case 4: goto L_0x0381;
                case 5: goto L_0x0378;
                case 6: goto L_0x0374;
                case 7: goto L_0x036b;
                case 8: goto L_0x0367;
                default: goto L_0x0366;
            }
        L_0x0366:
            goto L_0x0393
        L_0x0367:
            r2.setRotate(r3)
            goto L_0x0393
        L_0x036b:
            r2.setRotate(r3)
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.postScale(r7, r3)
            goto L_0x0393
        L_0x0374:
            r2.setRotate(r5)
            goto L_0x0393
        L_0x0378:
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.setRotate(r5)
            r2.postScale(r7, r3)
            goto L_0x0393
        L_0x0381:
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.setRotate(r6)
            r2.postScale(r7, r3)
            goto L_0x0393
        L_0x038a:
            r2.setRotate(r6)
            goto L_0x0393
        L_0x038e:
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.setScale(r7, r3)
        L_0x0393:
            android.graphics.RectF r3 = new android.graphics.RectF
            int r5 = r1.getWidth()
            float r5 = (float) r5
            int r6 = r1.getHeight()
            float r6 = (float) r6
            r7 = 0
            r3.<init>(r7, r7, r5, r6)
            r2.mapRect(r3)
            float r5 = r3.width()
            int r5 = java.lang.Math.round(r5)
            float r6 = r3.height()
            int r6 = java.lang.Math.round(r6)
            android.graphics.Bitmap$Config r7 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getNonNullConfig(r1)
            android.graphics.Bitmap r0 = r0.get(r5, r6, r7)
            float r5 = r3.left
            float r5 = -r5
            float r3 = r3.top
            float r3 = -r3
            r2.postTranslate(r5, r3)
            boolean r3 = r1.hasAlpha()
            r0.setHasAlpha(r3)
            com.bumptech.glide.load.resource.bitmap.TransformationUtils.applyMatrix(r1, r0, r2)
            r10 = r0
        L_0x03d2:
            boolean r0 = r1.equals(r10)
            if (r0 != 0) goto L_0x03dd
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r0 = r4.bitmapPool
            r0.put(r1)
        L_0x03dd:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeFromWrappedStreams(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.DecodeFormat, com.bumptech.glide.load.PreferredColorSpace, boolean, int, int, boolean, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks):android.graphics.Bitmap");
    }

    public final Resource<Bitmap> decode(ImageReader imageReader, int i, int i2, com.bumptech.glide.load.Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Options poll;
        Options options2;
        com.bumptech.glide.load.Options options3 = options;
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        synchronized (Downsampler.class) {
            synchronized (OPTIONS_QUEUE) {
                poll = OPTIONS_QUEUE.poll();
            }
            if (poll == null) {
                poll = new Options();
                resetOptions(poll);
            }
            options2 = poll;
        }
        options2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options3.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options3.get(PREFERRED_COLOR_SPACE);
        try {
            BitmapResource obtain = BitmapResource.obtain(decodeFromWrappedStreams(imageReader, options2, (DownsampleStrategy) options3.get(DownsampleStrategy.OPTION), decodeFormat, preferredColorSpace, options3.get(ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options3.get(ALLOW_HARDWARE_CONFIG)).booleanValue(), i, i2, ((Boolean) options3.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue(), decodeCallbacks), this.bitmapPool);
            resetOptions(options2);
            synchronized (OPTIONS_QUEUE) {
                OPTIONS_QUEUE.offer(options2);
            }
            this.byteArrayPool.put(bArr);
            return obtain;
        } catch (Throwable th) {
            resetOptions(options2);
            synchronized (OPTIONS_QUEUE) {
                OPTIONS_QUEUE.offer(options2);
                this.byteArrayPool.put(bArr);
                throw th;
            }
        }
    }
}
