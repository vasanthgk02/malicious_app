package co.hyperverge.hypersnapsdk.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import co.hyperverge.hypersnapsdk.R$color;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;

/* compiled from: RectPortHoleView */
public class d extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3231a = d.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    public RectF f3232c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3233e = false;

    public d(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3233e) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Config.ARGB_8888);
                if (createBitmap != null) {
                    Canvas canvas2 = new Canvas(createBitmap);
                    Paint paint = new Paint(1);
                    paint.setColor(getContext().getResources().getColor(R$color.hv_white));
                    paint.setStyle(Style.FILL);
                    canvas2.drawPaint(paint);
                    paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
                    canvas2.drawRoundRect(this.f3232c, 20.0f, 20.0f, paint);
                    paint.setXfermode(null);
                    paint.setStyle(Style.STROKE);
                    paint.setColor(-16777216);
                    paint.setStrokeWidth(2.0f);
                    paint.setStrokeJoin(Join.ROUND);
                    canvas2.drawRoundRect(this.f3232c, 20.0f, 20.0f, paint);
                    canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
                }
            } catch (Exception | OutOfMemoryError e2) {
                i.a(e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
    }
}
