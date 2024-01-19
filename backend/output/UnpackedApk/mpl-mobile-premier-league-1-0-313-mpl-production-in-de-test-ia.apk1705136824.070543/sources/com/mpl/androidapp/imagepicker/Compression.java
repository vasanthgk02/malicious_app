package com.mpl.androidapp.imagepicker;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Compression {
    public File compressImage(ReadableMap readableMap, String str, Options options) throws IOException {
        Integer num;
        Integer num2;
        Double d2 = null;
        Integer valueOf = readableMap.hasKey("compressImageMaxWidth") ? Integer.valueOf(readableMap.getInt("compressImageMaxWidth")) : null;
        Integer valueOf2 = readableMap.hasKey("compressImageMaxHeight") ? Integer.valueOf(readableMap.getInt("compressImageMaxHeight")) : null;
        if (readableMap.hasKey("compressImageQuality")) {
            d2 = Double.valueOf(readableMap.getDouble("compressImageQuality"));
        }
        boolean z = false;
        boolean z2 = d2 == null || d2.doubleValue() == 1.0d;
        boolean z3 = valueOf == null || valueOf.intValue() >= options.outWidth;
        boolean z4 = valueOf2 == null || valueOf2.intValue() >= options.outHeight;
        List asList = Arrays.asList(new String[]{"image/jpeg", "image/jpg", "image/png", "image/gif", "image/tiff"});
        String str2 = options.outMimeType;
        if (str2 != null && asList.contains(str2.toLowerCase())) {
            z = true;
        }
        if (z2 && z3 && z4 && z) {
            return new File(str);
        }
        int doubleValue = d2 != null ? (int) (d2.doubleValue() * 100.0d) : 100;
        if (valueOf == null) {
            num = Integer.valueOf(options.outWidth);
        } else {
            num = Integer.valueOf(Math.min(valueOf.intValue(), options.outWidth));
        }
        if (valueOf2 == null) {
            num2 = Integer.valueOf(options.outHeight);
        } else {
            num2 = Integer.valueOf(Math.min(valueOf2.intValue(), options.outHeight));
        }
        return resize(str, num.intValue(), num2.intValue(), doubleValue);
    }

    public synchronized void compressVideo(Activity activity, ReadableMap readableMap, String str, String str2, Promise promise) {
        promise.resolve(str);
    }

    public int getRotationInDegreesForOrientationTag(int i) {
        if (i == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (i != 6) {
            return i != 8 ? 0 : -90;
        }
        return 90;
    }

    public File resize(String str, int i, int i2, int i3) throws IOException {
        int i4;
        int i5;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        String str2 = str;
        int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
        Matrix matrix = new Matrix();
        matrix.postRotate((float) getRotationInDegreesForOrientationTag(attributeInt));
        float f2 = ((float) width) / ((float) height);
        int i6 = i;
        float f3 = (float) i6;
        int i7 = i2;
        float f4 = (float) i7;
        if (f3 / f4 > 1.0f) {
            i5 = (int) (f4 * f2);
            i4 = i7;
        } else {
            i4 = (int) (f3 / f2);
            i5 = i6;
        }
        Bitmap createBitmap = Bitmap.createBitmap(Bitmap.createScaledBitmap(decodeFile, i5, i4, true), 0, 0, i5, i4, matrix, true);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        File file = new File(externalStoragePublicDirectory, UUID.randomUUID() + ".jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        createBitmap.compress(CompressFormat.JPEG, i3, bufferedOutputStream);
        bufferedOutputStream.close();
        decodeFile.recycle();
        createBitmap.recycle();
        return file;
    }
}
