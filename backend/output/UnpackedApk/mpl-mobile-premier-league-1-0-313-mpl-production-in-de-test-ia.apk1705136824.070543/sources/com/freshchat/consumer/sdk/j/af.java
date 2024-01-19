package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.core.content.ContextCompat;
import com.facebook.imagepipeline.common.RotationOptions;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.b.c;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class af {
    public static final SimpleDateFormat iy = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US);
    public static FreshchatImageLoader kZ;

    public static Bitmap a(Context context, VectorDrawable vectorDrawable, int i) {
        if (vectorDrawable == null) {
            return null;
        }
        try {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            vectorDrawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            q.a(e2);
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            int width = (bitmap.getWidth() - min) / 2;
            int height = (bitmap.getHeight() - min) / 2;
            Config config = bitmap.getConfig();
            if (config == null) {
                config = Config.ARGB_8888;
            }
            bitmap2 = Bitmap.createBitmap(min, min, config);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            BitmapShader bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            if (!(width == 0 && height == 0)) {
                Matrix matrix = new Matrix();
                matrix.setTranslate((float) (-width), (float) (-height));
                bitmapShader.setLocalMatrix(matrix);
            }
            paint.setShader(bitmapShader);
            paint.setAntiAlias(true);
            float f2 = ((float) min) / 2.0f;
            canvas.drawCircle(f2, f2, f2, paint);
        } catch (Exception e2) {
            ai.e("FRESHCHAT", c.ERROR_WHILE_CROPPING.toString());
            q.a(e2);
        }
        return bitmap2;
    }

    public static void a(FreshchatImageLoader freshchatImageLoader) {
        kZ = freshchatImageLoader;
    }

    public static int aG(String str) {
        ac acVar;
        try {
            acVar = new ac(str);
        } catch (Exception e2) {
            ai.e("FRESHCHAT_WARNING", e2.toString());
            acVar = null;
        }
        if (acVar == null) {
            return 0;
        }
        int attributeInt = acVar.getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    public static int b(Context context, float f2) {
        if (context == null || f2 <= 0.0f) {
            return 0;
        }
        return (int) (((double) (f2 * context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static Bitmap b(Context context, int i, int i2) {
        try {
            Drawable drawable = ContextCompat.getDrawable(context, i);
            if (aw.eZ() && (drawable instanceof VectorDrawable)) {
                return a(context, (VectorDrawable) drawable, i2);
            }
            if (drawable instanceof BitmapDrawable) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
                return Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), dimensionPixelSize, dimensionPixelSize, false);
            }
            return null;
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static FreshchatImageLoader eK() {
        if (kZ == null) {
            kZ = t.eL();
        }
        return kZ;
    }

    public static boolean fW() {
        return kZ != null;
    }

    public static int i(Context context, int i) {
        if (context == null || i <= 0) {
            return 0;
        }
        return Math.round(((float) i) / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }
}
