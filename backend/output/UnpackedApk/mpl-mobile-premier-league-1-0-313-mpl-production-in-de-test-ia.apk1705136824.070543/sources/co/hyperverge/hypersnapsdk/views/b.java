package co.hyperverge.hypersnapsdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import co.hyperverge.hypersnapsdk.R$drawable;

/* compiled from: CrossHairView */
public class b extends View {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3222a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3223b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f3224c = getContext().getResources().getDrawable(R$drawable.ic_camera_focus_white_svg);

    /* renamed from: d  reason: collision with root package name */
    public Drawable f3225d = getContext().getResources().getDrawable(R$drawable.ic_camera_focus_white_svg);

    /* renamed from: e  reason: collision with root package name */
    public int f3226e;

    /* renamed from: f  reason: collision with root package name */
    public int f3227f;
    public Runnable g = new a();

    /* compiled from: CrossHairView */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            b bVar = b.this;
            bVar.f3222a = false;
            bVar.invalidate();
        }
    }

    public b(Context context) {
        super(context);
    }

    public void a(float f2, float f3, boolean z) {
        this.f3223b = z;
        this.f3226e = (int) f2;
        this.f3227f = (int) f3;
        removeCallbacks(this.g);
        this.f3222a = true;
        invalidate();
        postDelayed(this.g, 1000);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3222a) {
            int intrinsicWidth = this.f3224c.getIntrinsicWidth();
            int intrinsicHeight = this.f3224c.getIntrinsicHeight();
            if (this.f3223b) {
                Drawable drawable = this.f3225d;
                int i = this.f3226e;
                int i2 = intrinsicWidth / 2;
                int i3 = this.f3227f;
                int i4 = intrinsicHeight / 2;
                drawable.setBounds(i - i2, i3 - i4, i + i2, i3 + i4);
                this.f3225d.draw(canvas);
                return;
            }
            Drawable drawable2 = this.f3224c;
            int i5 = this.f3226e;
            int i6 = intrinsicWidth / 2;
            int i7 = this.f3227f;
            int i8 = intrinsicHeight / 2;
            drawable2.setBounds(i5 - i6, i7 - i8, i5 + i6, i7 + i8);
            this.f3224c.draw(canvas);
        }
    }
}
