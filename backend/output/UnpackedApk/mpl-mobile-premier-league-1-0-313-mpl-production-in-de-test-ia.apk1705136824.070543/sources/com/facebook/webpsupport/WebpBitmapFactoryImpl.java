package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.util.TypedValue;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;

@DoNotStrip
public class WebpBitmapFactoryImpl implements WebpBitmapFactory {
    public static BitmapCreator mBitmapCreator;
    public static WebpErrorLogger mWebpErrorLogger;

    @DoNotStrip
    public static Bitmap createBitmap(int i, int i2, Options options) {
        if (options != null) {
            Bitmap bitmap = options.inBitmap;
            if (bitmap != null && bitmap.isMutable()) {
                return options.inBitmap;
            }
        }
        return mBitmapCreator.createNakedBitmap(i, i2, Config.ARGB_8888);
    }

    @DoNotStrip
    public static byte[] getInTempStorageFromOptions(Options options) {
        if (options != null) {
            byte[] bArr = options.inTempStorage;
            if (bArr != null) {
                return bArr;
            }
        }
        return new byte[8192];
    }

    @DoNotStrip
    public static float getScaleFromOptions(Options options) {
        float f2 = 1.0f;
        if (options == null) {
            return 1.0f;
        }
        int i = options.inSampleSize;
        if (i > 1) {
            f2 = 1.0f / ((float) i);
        }
        if (!options.inScaled) {
            return f2;
        }
        int i2 = options.inDensity;
        int i3 = options.inTargetDensity;
        return (i2 == 0 || i3 == 0 || i2 == options.inScreenDensity) ? f2 : ((float) i3) / ((float) i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r3.length >= 20) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getWebpHeader(java.io.InputStream r2, android.graphics.BitmapFactory.Options r3) {
        /*
            r0 = 20
            r2.mark(r0)
            if (r3 == 0) goto L_0x000f
            byte[] r3 = r3.inTempStorage
            if (r3 == 0) goto L_0x000f
            int r1 = r3.length
            if (r1 < r0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            byte[] r3 = new byte[r0]
        L_0x0011:
            r1 = 0
            r2.read(r3, r1, r0)     // Catch:{ IOException -> 0x0019 }
            r2.reset()     // Catch:{ IOException -> 0x0019 }
            return r3
        L_0x0019:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webpsupport.WebpBitmapFactoryImpl.getWebpHeader(java.io.InputStream, android.graphics.BitmapFactory$Options):byte[]");
    }

    @DoNotStrip
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2, Options options) {
        StaticWebpNativeLoader.ensure();
        boolean z = WebpSupportStatus.sIsWebpSupportRequired;
        Bitmap originalDecodeByteArray = originalDecodeByteArray(bArr, i, i2, options);
        if (originalDecodeByteArray == null) {
            sendWebpErrorLog("webp_direct_decode_array_failed_on_no_webp");
        }
        return originalDecodeByteArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        throw r3;
     */
    @com.facebook.common.internal.DoNotStrip
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap hookDecodeFile(java.lang.String r2, android.graphics.BitmapFactory.Options r3) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x001a }
            r1.<init>(r2)     // Catch:{ Exception -> 0x001a }
            android.graphics.Bitmap r0 = hookDecodeStream(r1, r0, r3)     // Catch:{ all -> 0x000e }
            r1.close()     // Catch:{ Exception -> 0x001a }
            goto L_0x001a
        L_0x000e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r3 = move-exception
            r1.close()     // Catch:{ all -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ Exception -> 0x001a }
        L_0x0019:
            throw r3     // Catch:{ Exception -> 0x001a }
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webpsupport.WebpBitmapFactoryImpl.hookDecodeFile(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @DoNotStrip
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options) {
        StaticWebpNativeLoader.ensure();
        long nativeSeek = nativeSeek(fileDescriptor, 0, false);
        if (nativeSeek != -1) {
            InputStream fileInputStream = new FileInputStream(fileDescriptor);
            if (!fileInputStream.markSupported()) {
                fileInputStream = new BufferedInputStream(fileInputStream, 20);
            }
            try {
                getWebpHeader(fileInputStream, options);
                boolean z = WebpSupportStatus.sIsWebpSupportRequired;
                nativeSeek(fileDescriptor, nativeSeek, true);
                Bitmap originalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, options);
                if (originalDecodeFileDescriptor == null) {
                    sendWebpErrorLog("webp_direct_decode_fd_failed_on_no_webp");
                }
                try {
                    fileInputStream.close();
                    return originalDecodeFileDescriptor;
                } catch (Throwable unused) {
                    return originalDecodeFileDescriptor;
                }
            } catch (Throwable unused2) {
            }
        } else {
            Bitmap hookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, options);
            setPaddingDefaultValues(rect);
            return hookDecodeStream;
        }
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r3 != null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        throw r0;
     */
    @com.facebook.common.internal.DoNotStrip
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap hookDecodeResource(android.content.res.Resources r2, int r3, android.graphics.BitmapFactory.Options r4) {
        /*
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r1 = 0
            java.io.InputStream r3 = r2.openRawResource(r3, r0)     // Catch:{ Exception -> 0x0022 }
            android.graphics.Bitmap r1 = hookDecodeResourceStream(r2, r0, r3, r1, r4)     // Catch:{ all -> 0x0014 }
            if (r3 == 0) goto L_0x0022
            r3.close()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0022
        L_0x0014:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r0 = move-exception
            if (r3 == 0) goto L_0x0021
            r3.close()     // Catch:{ all -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch:{ Exception -> 0x0022 }
        L_0x0021:
            throw r0     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            if (r1 != 0) goto L_0x0033
            if (r4 == 0) goto L_0x0033
            android.graphics.Bitmap r2 = r4.inBitmap
            if (r2 != 0) goto L_0x002b
            goto L_0x0033
        L_0x002b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Problem decoding into existing bitmap"
            r2.<init>(r3)
            throw r2
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webpsupport.WebpBitmapFactoryImpl.hookDecodeResource(android.content.res.Resources, int, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @DoNotStrip
    public static Bitmap hookDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, Options options) {
        if (options == null) {
            options = new Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                options.inDensity = 160;
            } else if (i != 65535) {
                options.inDensity = i;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @DoNotStrip
    public static Bitmap hookDecodeStream(InputStream inputStream, Rect rect, Options options) {
        StaticWebpNativeLoader.ensure();
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 20);
        }
        getWebpHeader(inputStream, options);
        boolean z = WebpSupportStatus.sIsWebpSupportRequired;
        Bitmap originalDecodeStream = originalDecodeStream(inputStream, rect, options);
        if (originalDecodeStream == null) {
            sendWebpErrorLog("webp_direct_decode_stream_failed_on_no_webp");
        }
        return originalDecodeStream;
    }

    @DoNotStrip
    public static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, Options options, float f2, byte[] bArr2);

    @DoNotStrip
    public static native Bitmap nativeDecodeStream(InputStream inputStream, Options options, float f2, byte[] bArr);

    @DoNotStrip
    public static native long nativeSeek(FileDescriptor fileDescriptor, long j, boolean z);

    @DoNotStrip
    public static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2, Options options) {
        return BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    @DoNotStrip
    public static Bitmap originalDecodeFile(String str, Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    @DoNotStrip
    public static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @DoNotStrip
    public static Bitmap originalDecodeResource(Resources resources, int i, Options options) {
        return BitmapFactory.decodeResource(resources, i, options);
    }

    @DoNotStrip
    public static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, Options options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    @DoNotStrip
    public static Bitmap originalDecodeStream(InputStream inputStream, Rect rect, Options options) {
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    public static void sendWebpErrorLog(String str) {
        WebpErrorLogger webpErrorLogger = mWebpErrorLogger;
        if (webpErrorLogger != null) {
            webpErrorLogger.onWebpErrorLog(str, "decoding_failure");
        }
    }

    @DoNotStrip
    public static void setBitmapSize(Options options, int i, int i2) {
        if (options != null) {
            options.outWidth = i;
            options.outHeight = i2;
        }
    }

    @DoNotStrip
    public static boolean setOutDimensions(Options options, int i, int i2) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        options.outWidth = i;
        options.outHeight = i2;
        return true;
    }

    @DoNotStrip
    public static void setPaddingDefaultValues(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @SuppressLint({"NewApi"})
    @DoNotStrip
    public static boolean shouldPremultiply(Options options) {
        if (options != null) {
            return options.inPremultiplied;
        }
        return true;
    }

    public Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, null, options);
    }

    public void setBitmapCreator(BitmapCreator bitmapCreator) {
        mBitmapCreator = bitmapCreator;
    }

    public void setWebpErrorLogger(WebpErrorLogger webpErrorLogger) {
        mWebpErrorLogger = webpErrorLogger;
    }

    @DoNotStrip
    public static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2) {
        return BitmapFactory.decodeByteArray(bArr, i, i2);
    }

    @DoNotStrip
    public static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @DoNotStrip
    public static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    @DoNotStrip
    public static Bitmap originalDecodeResource(Resources resources, int i) {
        return BitmapFactory.decodeResource(resources, i);
    }

    @DoNotStrip
    public static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @DoNotStrip
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2) {
        return hookDecodeByteArray(bArr, i, i2, null);
    }

    @DoNotStrip
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, null);
    }

    @DoNotStrip
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @DoNotStrip
    public static Bitmap hookDecodeResource(Resources resources, int i) {
        return hookDecodeResource(resources, i, null);
    }

    @DoNotStrip
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }
}
