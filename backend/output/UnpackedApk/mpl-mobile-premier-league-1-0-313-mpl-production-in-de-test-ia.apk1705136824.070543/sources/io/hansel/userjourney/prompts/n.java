package io.hansel.userjourney.prompts;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import io.hansel.userjourney.models.h;
import java.util.HashMap;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f5589a;

    /* renamed from: b  reason: collision with root package name */
    public int f5590b;

    /* renamed from: c  reason: collision with root package name */
    public int f5591c;

    /* renamed from: d  reason: collision with root package name */
    public int f5592d;

    /* renamed from: e  reason: collision with root package name */
    public int f5593e;

    /* renamed from: f  reason: collision with root package name */
    public int f5594f;
    public int g;
    public int h;
    public String i;
    public int j = this.f5589a;
    public int k;
    public int l;
    public Resources m;

    public n(Resources resources, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        this.m = resources;
        this.f5589a = ((Integer) hashMap.get("ARROW_BASE_WIDTH")).intValue();
        this.f5590b = ((Integer) hashMap.get("ARROW_TIP_HEIGHT")).intValue();
        this.f5591c = ((Integer) hashMap.get("ARROW_BODY_HEIGHT")).intValue();
        this.f5592d = ((Integer) hashMap.get("ARROW_BODY_WIDTH")).intValue();
        this.f5593e = ((Integer) hashMap.get("ARROW_TOP_PADDING")).intValue();
        this.f5594f = ((Integer) hashMap.get("ARROW_BOTTOM_PADDING")).intValue();
        this.g = ((Integer) hashMap2.get("SPOTLIGHT_ARROW_COLOR")).intValue();
        this.h = ((Integer) hashMap2.get("SPOTLIGHT_ARROW_CIRCLE_SCALE")).intValue();
        this.i = String.valueOf(hashMap2.get("SPOTLIGHT_POINTER_TYPE"));
        int i2 = this.f5590b + this.f5591c;
        this.k = i2;
        this.l = i2 + this.f5594f + this.f5593e;
    }

    public static void a(Path path, h hVar) {
        path.moveTo(hVar.a(), hVar.d());
        path.lineTo(hVar.a(), hVar.c());
        path.lineTo(hVar.b(), hVar.c());
        path.lineTo(hVar.b(), hVar.d());
        path.lineTo(hVar.a(), hVar.d());
    }

    public void a(ImageView imageView) {
        ImageView imageView2 = imageView;
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        layoutParams.width = this.j;
        layoutParams.height = this.l;
        imageView2.setLayoutParams(layoutParams);
        Paint paint = new Paint();
        paint.setColor(this.g);
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(this.j, this.l, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        int i2 = this.f5589a / 2;
        int i3 = this.f5592d / 2;
        float f2 = (float) (i2 - i3);
        float f3 = (float) (i3 + i2);
        int i4 = this.f5594f;
        int i5 = this.f5591c + i4;
        float f4 = (float) i5;
        float f5 = (float) (i2 - i2);
        float f6 = (float) (i2 + i2);
        float f7 = (float) (i5 + this.f5590b);
        float f8 = (float) i2;
        float f9 = (float) i4;
        h hVar = new h();
        hVar.a(f3);
        hVar.b(f2);
        hVar.c(f4);
        hVar.d(f9);
        Bitmap bitmap = createBitmap;
        if (this.i.equalsIgnoreCase(z.CIRCLE.f5721a)) {
            a(path, hVar);
            float f10 = (float) this.h;
            path.addCircle(f8, f4 + f10, f10, Direction.CW);
        } else if (this.i.equalsIgnoreCase(z.ARROW.f5721a)) {
            path.moveTo(f3, f9);
            path.lineTo(f3, f4);
            path.lineTo(f6, f4);
            path.lineTo(f8, f7);
            path.lineTo(f5, f4);
            path.lineTo(f2, f4);
            path.lineTo(f2, f9);
            path.lineTo(f3, f9);
        } else {
            a(path, hVar);
        }
        path.close();
        canvas.drawPath(path, paint);
        imageView2.setPivotX(f8);
        imageView2.setPivotY((float) this.f5594f);
        imageView2.setImageDrawable(new BitmapDrawable(this.m, bitmap));
    }

    public void b(ImageView imageView) {
        ImageView imageView2 = imageView;
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        layoutParams.width = this.j;
        layoutParams.height = this.l;
        imageView2.setLayoutParams(layoutParams);
        Paint paint = new Paint();
        paint.setColor(this.g);
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(this.j, this.l, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        int i2 = this.f5589a / 2;
        int i3 = this.f5592d / 2;
        float f2 = (float) (i2 - i3);
        float f3 = (float) (i3 + i2);
        int i4 = this.k;
        int i5 = this.f5593e;
        float f4 = (float) (i4 + i5);
        float f5 = (float) (i2 - i2);
        float f6 = (float) (i2 + i2);
        float f7 = (float) ((this.l - this.f5591c) - this.f5594f);
        float f8 = (float) i2;
        float f9 = (float) i5;
        h hVar = new h();
        hVar.a(f2);
        hVar.b(f3);
        hVar.c(f7);
        hVar.d(f4);
        Bitmap bitmap = createBitmap;
        if (this.i.equalsIgnoreCase(z.CIRCLE.f5721a)) {
            a(path, hVar);
            float f10 = (float) this.h;
            path.addCircle(f8, f7 - f10, f10, Direction.CW);
        } else if (this.i.equalsIgnoreCase(z.ARROW.f5721a)) {
            path.moveTo(f2, f4);
            path.lineTo(f2, f7);
            path.lineTo(f5, f7);
            path.lineTo(f8, f9);
            path.lineTo(f6, f7);
            path.lineTo(f3, f7);
            path.lineTo(f3, f4);
            path.lineTo(f2, f4);
        } else {
            a(path, hVar);
        }
        path.close();
        canvas.drawPath(path, paint);
        imageView2.setPivotX(f8);
        imageView2.setPivotY((float) (this.k + this.f5593e));
        imageView2.setImageDrawable(new BitmapDrawable(this.m, bitmap));
    }
}
