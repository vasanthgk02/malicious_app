package com.freshchat.consumer.sdk.j;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;

public class s implements Transformation {
    public String key() {
        return "circularly_cropped_bitmap";
    }

    public Bitmap transform(Bitmap bitmap) {
        Bitmap bitmap2;
        boolean z;
        try {
            Bitmap a2 = af.a(bitmap);
            if (a2 == null) {
                z = false;
                bitmap2 = bitmap;
            } else {
                bitmap2 = a2;
                z = true;
            }
            if (!z) {
                return bitmap2;
            }
            bitmap.recycle();
            return bitmap2;
        } catch (Exception e2) {
            q.a(e2);
            return null;
        }
    }
}
