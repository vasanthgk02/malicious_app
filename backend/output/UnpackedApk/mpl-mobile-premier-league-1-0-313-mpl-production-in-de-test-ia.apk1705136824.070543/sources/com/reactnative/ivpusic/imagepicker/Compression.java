package com.reactnative.ivpusic.imagepicker;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.Promise;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class Compression {
    public synchronized void compressVideo(String str, Promise promise) {
        promise.resolve(str);
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
        matrix.postRotate((float) (attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : -90 : 90 : RotationOptions.ROTATE_180));
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
