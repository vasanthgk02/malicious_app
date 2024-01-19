package com.freshchat.consumer.sdk.j.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.freshchat.consumer.sdk.j.ai;
import java.io.FileDescriptor;

public class e extends f {
    public int ka;
    public int kb;

    public e(Context context, int i) {
        super(context);
        A(i);
    }

    private Bitmap B(int i) {
        ai.d("ImageResizer", "processBitmap - " + i);
        return a(this.kj, i, this.ka, this.kb);
    }

    public static int a(Options options, int i, int i2) {
        float f2;
        float f3;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        if (i4 > i3) {
            f3 = (float) i3;
            f2 = (float) i2;
        } else {
            f3 = (float) i4;
            f2 = (float) i;
        }
        int round = Math.round(f3 / f2);
        while (((float) (i4 * i3)) / ((float) (round * round)) > ((float) (i * i2 * 2))) {
            round++;
        }
        return round;
    }

    public static Bitmap a(Resources resources, int i, int i2, int i3) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = a(options, i, i2);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        Boolean bool = Boolean.FALSE;
        if (i3 > i2 || i4 > i) {
            if (i4 > i3) {
                if (2048 < i4) {
                    bool = Boolean.TRUE;
                    i3 = Math.round((((float) 2048) / ((float) i4)) * ((float) i3));
                    i4 = 2048;
                }
            } else if (2048 < i3) {
                bool = Boolean.TRUE;
                i4 = Math.round((((float) 2048) / ((float) i3)) * ((float) i4));
                i3 = 2048;
            }
        }
        options.inJustDecodeBounds = false;
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        return bool.booleanValue() ? Bitmap.createScaledBitmap(decodeFileDescriptor, i4, i3, false) : decodeFileDescriptor;
    }

    public void A(int i) {
        c(i, i);
    }

    public void c(int i, int i2) {
        this.ka = i;
        this.kb = i2;
    }

    public Bitmap d(Object obj) {
        return B(Integer.parseInt(String.valueOf(obj)));
    }
}
