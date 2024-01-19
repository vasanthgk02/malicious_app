package co.hyperverge.hypersnapsdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.widget.FrameLayout;
import co.hyperverge.hypersnapsdk.R$color;
import co.hyperverge.hypersnapsdk.f.h;

/* compiled from: TextureCamera */
public class e extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Path f3234a;

    public e(Context context) {
        super(context);
    }

    public void dispatchDraw(Canvas canvas) {
        this.f3234a = new Path();
        this.f3234a.addCircle((float) (getWidth() / 2), (float) (getHeight() / 2), ((float) getDiameter()) / 2.0f, Direction.CW);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R$color.black));
        paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        canvas.clipPath(this.f3234a);
        canvas.drawPath(this.f3234a, paint);
        super.dispatchDraw(canvas);
    }

    public int getDiameter() {
        int min = Math.min(h.b(), h.a());
        getContext();
        return (int) ((float) (min - ((Math.min(h.b(), h.a()) * 15) / 100)));
    }
}
