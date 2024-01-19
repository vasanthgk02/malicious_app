package com.yalantis.ucrop.task;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.UCropActivity.AnonymousClass8;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import java.io.File;
import java.io.IOException;

public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
    public int cropOffsetX;
    public int cropOffsetY;
    public final CompressFormat mCompressFormat;
    public final int mCompressQuality;
    public final BitmapCropCallback mCropCallback;
    public final RectF mCropRect;
    public int mCroppedImageHeight;
    public int mCroppedImageWidth;
    public float mCurrentAngle;
    public final RectF mCurrentImageRect;
    public float mCurrentScale;
    public final ExifInfo mExifInfo;
    public final String mImageInputPath;
    public final String mImageOutputPath;
    public final int mMaxResultImageSizeX;
    public final int mMaxResultImageSizeY;
    public Bitmap mViewBitmap;

    static {
        System.loadLibrary("ucrop");
    }

    public BitmapCropTask(Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.mCropRect;
        this.mCurrentImageRect = imageState.mCurrentImageRect;
        this.mCurrentScale = imageState.mCurrentScale;
        this.mCurrentAngle = imageState.mCurrentAngle;
        this.mMaxResultImageSizeX = cropParameters.mMaxResultImageSizeX;
        this.mMaxResultImageSizeY = cropParameters.mMaxResultImageSizeY;
        this.mCompressFormat = cropParameters.mCompressFormat;
        this.mCompressQuality = cropParameters.mCompressQuality;
        this.mImageInputPath = cropParameters.mImageInputPath;
        this.mImageOutputPath = cropParameters.mImageOutputPath;
        this.mExifInfo = cropParameters.mExifInfo;
        this.mCropCallback = bitmapCropCallback;
    }

    public static native boolean cropCImg(String str, String str2, int i, int i2, int i3, int i4, float f2, float f3, int i5, int i6, int i7, int i8) throws IOException, OutOfMemoryError;

    /* JADX WARNING: Removed duplicated region for block: B:43:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean crop(float r19) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            android.media.ExifInterface r0 = new android.media.ExifInterface
            java.lang.String r2 = r1.mImageInputPath
            r0.<init>(r2)
            android.graphics.RectF r2 = r1.mCropRect
            float r2 = r2.left
            android.graphics.RectF r3 = r1.mCurrentImageRect
            float r3 = r3.left
            float r2 = r2 - r3
            float r3 = r1.mCurrentScale
            float r2 = r2 / r3
            int r2 = java.lang.Math.round(r2)
            r1.cropOffsetX = r2
            android.graphics.RectF r2 = r1.mCropRect
            float r2 = r2.top
            android.graphics.RectF r3 = r1.mCurrentImageRect
            float r3 = r3.top
            float r2 = r2 - r3
            float r3 = r1.mCurrentScale
            float r2 = r2 / r3
            int r2 = java.lang.Math.round(r2)
            r1.cropOffsetY = r2
            android.graphics.RectF r2 = r1.mCropRect
            float r2 = r2.width()
            float r3 = r1.mCurrentScale
            float r2 = r2 / r3
            int r2 = java.lang.Math.round(r2)
            r1.mCroppedImageWidth = r2
            android.graphics.RectF r2 = r1.mCropRect
            float r2 = r2.height()
            float r3 = r1.mCurrentScale
            float r2 = r2 / r3
            int r2 = java.lang.Math.round(r2)
            r1.mCroppedImageHeight = r2
            int r3 = r1.mCroppedImageWidth
            int r2 = java.lang.Math.max(r3, r2)
            float r2 = (float) r2
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r2 / r3
            int r2 = java.lang.Math.round(r2)
            r3 = 1
            int r2 = r2 + r3
            int r4 = r1.mMaxResultImageSizeX
            r5 = 0
            if (r4 <= 0) goto L_0x0064
            int r4 = r1.mMaxResultImageSizeY
            if (r4 > 0) goto L_0x00b2
        L_0x0064:
            android.graphics.RectF r4 = r1.mCropRect
            float r4 = r4.left
            android.graphics.RectF r6 = r1.mCurrentImageRect
            float r6 = r6.left
            float r4 = r4 - r6
            float r4 = java.lang.Math.abs(r4)
            float r2 = (float) r2
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x00b2
            android.graphics.RectF r4 = r1.mCropRect
            float r4 = r4.top
            android.graphics.RectF r6 = r1.mCurrentImageRect
            float r6 = r6.top
            float r4 = r4 - r6
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x00b2
            android.graphics.RectF r4 = r1.mCropRect
            float r4 = r4.bottom
            android.graphics.RectF r6 = r1.mCurrentImageRect
            float r6 = r6.bottom
            float r4 = r4 - r6
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x00b2
            android.graphics.RectF r4 = r1.mCropRect
            float r4 = r4.right
            android.graphics.RectF r6 = r1.mCurrentImageRect
            float r6 = r6.right
            float r4 = r4 - r6
            float r4 = java.lang.Math.abs(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x00b2
            float r2 = r1.mCurrentAngle
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r3 = 0
        L_0x00b2:
            if (r3 == 0) goto L_0x00f0
            java.lang.String r6 = r1.mImageInputPath
            java.lang.String r7 = r1.mImageOutputPath
            int r8 = r1.cropOffsetX
            int r9 = r1.cropOffsetY
            int r10 = r1.mCroppedImageWidth
            int r11 = r1.mCroppedImageHeight
            float r12 = r1.mCurrentAngle
            android.graphics.Bitmap$CompressFormat r2 = r1.mCompressFormat
            int r14 = r2.ordinal()
            int r15 = r1.mCompressQuality
            com.yalantis.ucrop.model.ExifInfo r2 = r1.mExifInfo
            int r3 = r2.mExifDegrees
            int r2 = r2.mExifTranslation
            r13 = r19
            r16 = r3
            r17 = r2
            boolean r2 = cropCImg(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            if (r2 == 0) goto L_0x00ef
            android.graphics.Bitmap$CompressFormat r3 = r1.mCompressFormat
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00ef
            int r3 = r1.mCroppedImageWidth
            int r4 = r1.mCroppedImageHeight
            java.lang.String r5 = r1.mImageOutputPath
            com.yalantis.ucrop.util.ImageHeaderParser.copyExif(r0, r3, r4, r5)
        L_0x00ef:
            return r2
        L_0x00f0:
            java.lang.String r0 = r1.mImageInputPath
            java.lang.String r2 = r1.mImageOutputPath
            boolean r3 = r0.equalsIgnoreCase(r2)
            if (r3 == 0) goto L_0x00fb
            goto L_0x012e
        L_0x00fb:
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0136 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0136 }
            r6.<init>(r0)     // Catch:{ all -> 0x0136 }
            r4.<init>(r6)     // Catch:{ all -> 0x0136 }
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ all -> 0x0136 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x0132 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0132 }
            r6.<init>(r2)     // Catch:{ all -> 0x0132 }
            r0.<init>(r6)     // Catch:{ all -> 0x0132 }
            java.nio.channels.FileChannel r2 = r0.getChannel()     // Catch:{ all -> 0x0132 }
            r8 = 0
            long r10 = r4.size()     // Catch:{ all -> 0x012f }
            r7 = r4
            r12 = r2
            r7.transferTo(r8, r10, r12)     // Catch:{ all -> 0x012f }
            r4.close()     // Catch:{ all -> 0x012f }
            r4.close()
            if (r2 == 0) goto L_0x012e
            r2.close()
        L_0x012e:
            return r5
        L_0x012f:
            r0 = move-exception
            r3 = r2
            goto L_0x0133
        L_0x0132:
            r0 = move-exception
        L_0x0133:
            r2 = r3
            r3 = r4
            goto L_0x0138
        L_0x0136:
            r0 = move-exception
            r2 = r3
        L_0x0138:
            if (r3 == 0) goto L_0x013d
            r3.close()
        L_0x013d:
            if (r2 == 0) goto L_0x0142
            r2.close()
        L_0x0142:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.task.BitmapCropTask.crop(float):boolean");
    }

    public Object doInBackground(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        Bitmap bitmap = this.mViewBitmap;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        Options options = new Options();
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.mImageInputPath, options);
        int i = this.mExifInfo.mExifDegrees;
        if (!(i == 90 || i == 270)) {
            z = false;
        }
        this.mCurrentScale /= Math.min(((float) (z ? options.outHeight : options.outWidth)) / ((float) this.mViewBitmap.getWidth()), ((float) (z ? options.outWidth : options.outHeight)) / ((float) this.mViewBitmap.getHeight()));
        float f2 = 1.0f;
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            float width = this.mCropRect.width() / this.mCurrentScale;
            float height = this.mCropRect.height() / this.mCurrentScale;
            if (width > ((float) this.mMaxResultImageSizeX) || height > ((float) this.mMaxResultImageSizeY)) {
                f2 = Math.min(((float) this.mMaxResultImageSizeX) / width, ((float) this.mMaxResultImageSizeY) / height);
                this.mCurrentScale /= f2;
            }
        }
        try {
            crop(f2);
            this.mViewBitmap = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    public void onPostExecute(Object obj) {
        Throwable th = (Throwable) obj;
        BitmapCropCallback bitmapCropCallback = this.mCropCallback;
        if (bitmapCropCallback == null) {
            return;
        }
        if (th == null) {
            Uri fromFile = Uri.fromFile(new File(this.mImageOutputPath));
            BitmapCropCallback bitmapCropCallback2 = this.mCropCallback;
            int i = this.cropOffsetX;
            int i2 = this.cropOffsetY;
            int i3 = this.mCroppedImageWidth;
            int i4 = this.mCroppedImageHeight;
            AnonymousClass8 r0 = (AnonymousClass8) bitmapCropCallback2;
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", fromFile).putExtra("com.yalantis.ucrop.CropAspectRatio", uCropActivity.mGestureCropImageView.getTargetAspectRatio()).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
            UCropActivity.this.finish();
            return;
        }
        AnonymousClass8 r02 = (AnonymousClass8) bitmapCropCallback;
        UCropActivity.this.setResultError(th);
        UCropActivity.this.finish();
    }
}
