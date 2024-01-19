package co.hyperverge.hypersnapsdk.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import co.hyperverge.hypersnapsdk.R$color;
import co.hyperverge.hypersnapsdk.f.h;
import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: CircularProgressBar */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f3217a;

    /* renamed from: b  reason: collision with root package name */
    public int f3218b;

    /* renamed from: d  reason: collision with root package name */
    public float f3219d;

    /* renamed from: f  reason: collision with root package name */
    public int f3220f;
    public int g;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public final Paint n;
    public final Paint o;
    public final ValueAnimator p;

    /* renamed from: co.hyperverge.hypersnapsdk.views.a$a  reason: collision with other inner class name */
    /* compiled from: CircularProgressBar */
    public class C0061a implements AnimatorUpdateListener {
        public C0061a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f3219d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.invalidate();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getAnimationDuration() {
        return this.g;
    }

    public int getDiameter() {
        int min = Math.min(h.b(), h.a());
        getContext();
        return (int) ((float) (min - ((Math.min(h.b(), h.a()) * 15) / 100)));
    }

    public ValueAnimator getProgressBarAnimator() {
        return this.p;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3217a = getWidth();
        this.f3218b = getHeight();
        float f2 = (float) (((double) this.f3220f) / 2.0d);
        float diameter = ((float) getDiameter()) - f2;
        RectF rectF = new RectF(f2, f2, diameter, diameter);
        this.n.setColor(this.k);
        this.n.setStrokeWidth((float) this.f3220f);
        this.n.setAntiAlias(true);
        this.n.setStrokeCap(this.j ? Cap.ROUND : Cap.BUTT);
        this.n.setStyle(Style.STROKE);
        this.o.setColor(this.m);
        this.o.setStrokeWidth((float) this.f3220f);
        this.o.setAntiAlias(true);
        this.o.setStrokeCap(this.j ? Cap.ROUND : Cap.BUTT);
        this.o.setStyle(Style.STROKE);
        canvas.drawOval(rectF, this.o);
        canvas.drawArc(rectF, -90.0f, this.f3219d, false, this.n);
        this.p.setInterpolator(new LinearInterpolator());
        this.p.setDuration((long) this.g);
        this.p.addUpdateListener(new C0061a());
        if (this.i) {
            this.n.setTextSize(((float) Math.min(this.f3217a, this.f3218b)) / 5.0f);
            this.n.setTextAlign(Align.CENTER);
            this.n.setStrokeWidth(0.0f);
            this.n.setColor(this.l);
            canvas.drawText(GeneratedOutlineSupport.outline57(new StringBuilder(), (int) ((this.f3219d * 100.0f) / 360.0f), "%"), (float) (canvas.getWidth() / 2), (float) ((int) (((float) (canvas.getHeight() / 2)) - ((this.n.ascent() + this.n.descent()) / 2.0f))), this.n);
        }
    }

    public void setAnimationDuration(int i2) {
        this.g = i2;
    }

    public void setBackgroundColor(int i2) {
        this.m = i2;
        invalidate();
    }

    public void setMaxProgress(int i2) {
        this.f3219d = ((float) i2) * 3.6f;
    }

    public void setProgress(int i2) {
        this.p.setFloatValues(new float[]{this.f3219d, ((float) i2) * 3.6f});
        this.p.start();
    }

    public void setProgressColor(int i2) {
        this.k = i2;
        invalidate();
    }

    public void setProgressWidth(int i2) {
        this.f3220f = i2;
        invalidate();
    }

    public void setSweepAngle(float f2) {
        this.f3219d = f2;
        invalidate();
    }

    public void setTextColor(int i2) {
        this.l = i2;
        invalidate();
    }

    public void setmStrokeWidth(int i2) {
        this.f3220f = i2;
        invalidate();
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3219d = 0.0f;
        this.f3220f = 20;
        this.g = 1500;
        this.i = false;
        this.j = false;
        this.k = getResources().getColor(R$color.hv_white);
        this.l = -16777216;
        this.m = -16777216;
        this.p = ValueAnimator.ofFloat(new float[]{0.0f});
        this.n = new Paint(1);
        this.o = new Paint(1);
    }
}
