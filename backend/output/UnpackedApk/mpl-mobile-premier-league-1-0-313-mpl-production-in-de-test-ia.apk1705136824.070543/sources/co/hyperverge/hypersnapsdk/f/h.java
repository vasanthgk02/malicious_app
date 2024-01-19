package co.hyperverge.hypersnapsdk.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Display;
import android.view.WindowManager;
import co.hyperverge.hypersnapsdk.R$color;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.service.a.a;

/* compiled from: UIUtils */
public class h {
    public static int a(Context context, float f2) {
        return (int) ((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f2);
    }

    public static int b() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static boolean e(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Display defaultDisplay2 = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point2 = new Point();
        defaultDisplay2.getRealSize(point2);
        return point.y < point2.y;
    }

    public static int a() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static Bitmap a(Context context, Bitmap bitmap, double d2, float f2, int i, boolean z) {
        if (f2 >= 1.0f || !z) {
            d2 = 0.0d;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int color = context.getResources().getColor(R$color.hv_white);
            Paint paint = new Paint();
            int i2 = (int) d2;
            Rect rect = new Rect(0, i2, bitmap.getWidth(), bitmap.getHeight() - i2);
            RectF rectF = new RectF(rect);
            float f3 = (float) i;
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawRoundRect(rectF, f3, f3, paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return createBitmap;
        } catch (Exception | OutOfMemoryError e2) {
            i.a(e2);
            n m = n.m();
            if (m.i == null) {
                m.i = new a(context);
            }
            m.i.a(e2);
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, Integer num) {
        Bitmap bitmap2;
        int i;
        try {
            if (bitmap.getWidth() > bitmap.getHeight()) {
                bitmap2 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getHeight(), Config.ARGB_8888);
            } else {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(), Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            if (bitmap.getWidth() > bitmap.getHeight()) {
                i = bitmap.getHeight() / 2;
            } else {
                i = bitmap.getWidth() / 2;
            }
            float f2 = (float) i;
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawCircle(f2, f2, f2, paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return bitmap2;
        } catch (OutOfMemoryError e2) {
            i.a((Throwable) e2);
            return null;
        }
    }
}
