package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;

@TargetApi(11)
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
    public static final String TAG = "HoneycombBitmapFactory";
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public boolean mImmutableBitmapFallback;
    public final EmptyJpegGenerator mJpegGenerator;
    public final PlatformDecoder mPurgeableDecoder;

    public HoneycombBitmapFactory(EmptyJpegGenerator emptyJpegGenerator, PlatformDecoder platformDecoder, CloseableReferenceFactory closeableReferenceFactory) {
        this.mJpegGenerator = emptyJpegGenerator;
        this.mPurgeableDecoder = platformDecoder;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
    }

    private CloseableReference<Bitmap> createFallbackBitmap(int i, int i2, Config config) {
        return this.mCloseableReferenceFactory.create(Bitmap.createBitmap(i, i2, config), SimpleBitmapReleaser.getInstance());
    }

    @TargetApi(12)
    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Config config) {
        EncodedImage encodedImage;
        if (this.mImmutableBitmapFallback) {
            return createFallbackBitmap(i, i2, config);
        }
        CloseableReference<PooledByteBuffer> generate = this.mJpegGenerator.generate((short) i, (short) i2);
        try {
            encodedImage = new EncodedImage(generate);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
            CloseableReference<Bitmap> decodeJPEGFromEncodedImage = this.mPurgeableDecoder.decodeJPEGFromEncodedImage(encodedImage, config, null, ((PooledByteBuffer) generate.get()).size());
            if (!((Bitmap) decodeJPEGFromEncodedImage.get()).isMutable()) {
                decodeJPEGFromEncodedImage.close();
                this.mImmutableBitmapFallback = true;
                String str = TAG;
                if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(6)) {
                    ((FLogDefaultLoggingDelegate) FLog.sHandler).println(6, str, "Immutable bitmap returned by decoder");
                }
                CloseableReference<Bitmap> createFallbackBitmap = createFallbackBitmap(i, i2, config);
                EncodedImage.closeSafely(encodedImage);
                generate.close();
                return createFallbackBitmap;
            }
            ((Bitmap) decodeJPEGFromEncodedImage.get()).setHasAlpha(true);
            ((Bitmap) decodeJPEGFromEncodedImage.get()).eraseColor(0);
            EncodedImage.closeSafely(encodedImage);
            generate.close();
            return decodeJPEGFromEncodedImage;
        } catch (Throwable th) {
            generate.close();
            throw th;
        }
    }
}
