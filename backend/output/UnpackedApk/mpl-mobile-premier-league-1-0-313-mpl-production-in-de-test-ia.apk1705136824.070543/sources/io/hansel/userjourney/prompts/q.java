package io.hansel.userjourney.prompts;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import io.hansel.core.utils.HSLUtils;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public Paint f5622a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    public Paint f5623b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public Path f5624c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public Path f5625d = new Path();

    /* renamed from: e  reason: collision with root package name */
    public int f5626e = HSLUtils.dpToPx(12);

    /* renamed from: f  reason: collision with root package name */
    public int f5627f = HSLUtils.dpToPx(12);

    public void a(Resources resources, ImageView imageView, int i, boolean z, int i2, int i3, Bitmap bitmap) {
        int i4 = this.f5626e - (i2 * 2);
        int i5 = this.f5627f - i2;
        int i6 = i2 + 0;
        this.f5623b.setColor(i);
        this.f5623b.setAntiAlias(true);
        this.f5622a.setColor(i3);
        this.f5622a.setAntiAlias(true);
        int i7 = i4 / 2;
        int i8 = this.f5626e / 2;
        Canvas canvas = new Canvas(bitmap);
        if (z) {
            float f2 = (float) 0;
            this.f5625d.moveTo(f2, (float) (this.f5627f + 0));
            float f3 = (float) (i7 + i6);
            this.f5625d.lineTo(f3, f2);
            this.f5625d.lineTo((float) (this.f5626e + 0), (float) (this.f5627f + 0));
            float f4 = (float) i6;
            float f5 = (float) (i5 + i6);
            this.f5624c.moveTo(f4, f5);
            this.f5624c.lineTo(f3, f4);
            this.f5624c.lineTo((float) (i6 + i4), f5);
            this.f5624c.lineTo(f4, f5);
        } else {
            float f6 = (float) 0;
            this.f5625d.moveTo((float) (this.f5626e + 0), f6);
            this.f5625d.lineTo((float) (i8 + 0), (float) (this.f5627f + 0));
            this.f5625d.lineTo(f6, f6);
            float f7 = (float) i6;
            this.f5624c.moveTo(f7, f6);
            this.f5624c.lineTo((float) (i4 + i6), f6);
            this.f5624c.lineTo((float) (i6 + i7), (float) (i5 + 0));
            this.f5624c.lineTo(f7, f6);
        }
        canvas.drawPath(this.f5625d, this.f5622a);
        canvas.drawPath(this.f5624c, this.f5623b);
        imageView.setImageDrawable(new BitmapDrawable(resources, bitmap));
        this.f5624c.reset();
        this.f5625d.reset();
    }
}
