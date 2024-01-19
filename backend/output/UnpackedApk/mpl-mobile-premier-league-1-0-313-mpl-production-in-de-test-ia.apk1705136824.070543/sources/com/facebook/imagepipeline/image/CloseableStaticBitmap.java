package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.BitmapUtil;

public class CloseableStaticBitmap extends CloseableBitmap {
    public volatile Bitmap mBitmap;
    public CloseableReference<Bitmap> mBitmapReference;
    public final int mExifOrientation;
    public final QualityInfo mQualityInfo;
    public final int mRotationAngle;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        this(bitmap, resourceReleaser, qualityInfo, i, 0);
    }

    private synchronized CloseableReference<Bitmap> detachBitmapReference() {
        CloseableReference<Bitmap> closeableReference;
        closeableReference = this.mBitmapReference;
        this.mBitmapReference = null;
        this.mBitmap = null;
        return closeableReference;
    }

    public static int getBitmapHeight(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public static int getBitmapWidth(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public synchronized CloseableReference<Bitmap> cloneUnderlyingBitmapReference() {
        return CloseableReference.cloneOrNull(this.mBitmapReference);
    }

    public void close() {
        CloseableReference<Bitmap> detachBitmapReference = detachBitmapReference();
        if (detachBitmapReference != null) {
            detachBitmapReference.close();
        }
    }

    public synchronized CloseableReference<Bitmap> convertToBitmapReference() {
        k.checkNotNull(this.mBitmapReference, (Object) "Cannot convert a closed static bitmap");
        return detachBitmapReference();
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getHeight() {
        if (this.mRotationAngle % RotationOptions.ROTATE_180 == 0) {
            int i = this.mExifOrientation;
            if (!(i == 5 || i == 7)) {
                return getBitmapHeight(this.mBitmap);
            }
        }
        return getBitmapWidth(this.mBitmap);
    }

    public QualityInfo getQualityInfo() {
        return this.mQualityInfo;
    }

    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    public int getSizeInBytes() {
        return BitmapUtil.getSizeInBytes(this.mBitmap);
    }

    public Bitmap getUnderlyingBitmap() {
        return this.mBitmap;
    }

    public int getWidth() {
        if (this.mRotationAngle % RotationOptions.ROTATE_180 == 0) {
            int i = this.mExifOrientation;
            if (!(i == 5 || i == 7)) {
                return getBitmapWidth(this.mBitmap);
            }
        }
        return getBitmapHeight(this.mBitmap);
    }

    public synchronized boolean isClosed() {
        return this.mBitmapReference == null;
    }

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i, int i2) {
        if (bitmap != null) {
            this.mBitmap = bitmap;
            Bitmap bitmap2 = this.mBitmap;
            if (resourceReleaser != null) {
                this.mBitmapReference = CloseableReference.of(bitmap2, resourceReleaser);
                this.mQualityInfo = qualityInfo;
                this.mRotationAngle = i;
                this.mExifOrientation = i2;
                return;
            }
            throw null;
        }
        throw null;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i) {
        this(closeableReference, qualityInfo, i, 0);
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i, int i2) {
        CloseableReference<Bitmap> cloneOrNull = closeableReference.cloneOrNull();
        k.checkNotNull1(cloneOrNull);
        CloseableReference<Bitmap> closeableReference2 = cloneOrNull;
        this.mBitmapReference = closeableReference2;
        this.mBitmap = (Bitmap) closeableReference2.get();
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }
}
