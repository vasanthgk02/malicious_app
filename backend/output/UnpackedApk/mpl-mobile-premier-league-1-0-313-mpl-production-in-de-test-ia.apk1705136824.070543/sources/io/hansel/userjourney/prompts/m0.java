package io.hansel.userjourney.prompts;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.n;
import java.util.ArrayList;

public class m0 {
    public static float h;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5580a = false;

    /* renamed from: b  reason: collision with root package name */
    public i0 f5581b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f5582c;

    /* renamed from: d  reason: collision with root package name */
    public final AnimatorSet f5583d;

    /* renamed from: e  reason: collision with root package name */
    public final c f5584e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5585f;
    public final int g;

    public class a implements AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            m0.this.f5584e.getLayoutParams().width = (int) (((float) m0.this.f5585f) + floatValue);
            m0.this.f5584e.getLayoutParams().height = (int) (((float) m0.this.g) + floatValue);
            m0.this.f5584e.invalidate();
            m0.this.f5584e.requestLayout();
        }
    }

    public class b implements AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            m0.this.f5584e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            m0.this.f5584e.invalidate();
            m0.this.f5584e.requestLayout();
        }
    }

    public class c extends View {
        public c(Context context) {
            super(context);
            setVisibility(4);
            setBackgroundColor(0);
        }

        public void onDraw(Canvas canvas) {
            if (m0.this.f5581b == i0.CIRCLE) {
                float min = ((float) Math.min(getWidth(), getHeight())) / 2.0f;
                float min2 = ((float) Math.min(m0.this.g, m0.this.f5585f)) / 2.0f;
                float f2 = min - min2;
                m0.this.f5582c.setStyle(Style.STROKE);
                m0.this.f5582c.setStrokeWidth(f2);
                canvas.drawCircle(min, min, (f2 / 2.0f) + min2, m0.this.f5582c);
                return;
            }
            float width = (float) getWidth();
            float height = (float) getHeight();
            float b2 = (width - ((float) m0.this.f5585f)) / 2.0f;
            float c2 = (height - ((float) m0.this.g)) / 2.0f;
            if (VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(b2, c2, ((float) m0.this.f5585f) + b2, ((float) m0.this.g) + c2);
            } else {
                canvas.clipRect(b2, c2, b2 + ((float) m0.this.f5585f), c2 + ((float) m0.this.g), Op.DIFFERENCE);
            }
            canvas.drawRect(0.0f, 0.0f, width, height, m0.this.f5582c);
        }
    }

    public m0(Context context, i0 i0Var, RelativeLayout relativeLayout, int i, int i2) {
        h = (float) HSLUtils.dpToPx(20.0f);
        this.f5585f = i;
        this.g = i2;
        this.f5581b = i0Var;
        int a2 = n.a(0.8f, (String) "#FFFFFF");
        Paint paint = new Paint();
        this.f5582c = paint;
        paint.setAntiAlias(true);
        paint.setColor(a2);
        LayoutParams layoutParams = new LayoutParams(i, i2);
        layoutParams.addRule(13, -1);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5583d = animatorSet;
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ArrayList arrayList = new ArrayList();
        relativeLayout.removeAllViews();
        c cVar = new c(context);
        this.f5584e = cVar;
        relativeLayout.addView(cVar, layoutParams);
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, h * 2.0f}).setDuration(2500);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.addUpdateListener(new a());
        duration.setRepeatCount(-1);
        arrayList.add(duration);
        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(2500);
        duration2.setInterpolator(new AccelerateDecelerateInterpolator());
        duration2.addUpdateListener(new b());
        duration2.setRepeatCount(-1);
        arrayList.add(duration2);
        animatorSet.playTogether(arrayList);
    }

    public static void a(int i, int i2, int i3, int i4, RelativeLayout relativeLayout) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) Math.floor(((double) i3) + ((double) (h * 2.0f))), (int) Math.floor(((double) i4) + ((double) (h * 2.0f))));
        layoutParams.topMargin = (int) Math.floor((double) ((((float) i2) - (((float) i4) / 2.0f)) - h));
        layoutParams.leftMargin = (int) Math.floor((double) ((((float) i) - (((float) i3) / 2.0f)) - h));
        relativeLayout.setLayoutParams(layoutParams);
    }

    public static void a(int i, int i2, RelativeLayout relativeLayout, int i3) {
        double d2 = (double) i3;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) Math.floor(((double) (h * 2.0f)) + d2), (int) Math.floor(d2 + ((double) (h * 2.0f))));
        float f2 = ((float) i3) / 2.0f;
        layoutParams.topMargin = (int) Math.floor((double) ((((float) i2) - f2) - h));
        layoutParams.leftMargin = (int) Math.floor((double) ((((float) i) - f2) - h));
        relativeLayout.setLayoutParams(layoutParams);
    }

    public boolean a() {
        return this.f5580a;
    }

    public void b() {
        if (!a()) {
            this.f5584e.setVisibility(0);
            this.f5583d.start();
            this.f5580a = true;
        }
    }

    public void c() {
        if (a()) {
            this.f5583d.end();
            this.f5580a = false;
        }
    }
}
