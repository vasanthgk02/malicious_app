package co.hyperverge.hypersnapsdk.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import co.hyperverge.hypersnapsdk.R$color;
import co.hyperverge.hypersnapsdk.R$dimen;
import co.hyperverge.hypersnapsdk.R$styleable;
import java.util.ArrayList;

public class RippleBackground extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f3209a;

    /* renamed from: b  reason: collision with root package name */
    public float f3210b;

    /* renamed from: c  reason: collision with root package name */
    public float f3211c;

    /* renamed from: d  reason: collision with root package name */
    public int f3212d;

    /* renamed from: e  reason: collision with root package name */
    public int f3213e;

    /* renamed from: f  reason: collision with root package name */
    public int f3214f;
    public float g;
    public int h;
    public Paint i;
    public AnimatorSet k;
    public ArrayList<Animator> l;
    public LayoutParams m;
    public ArrayList<a> n = new ArrayList<>();

    public class a extends View {
        public a(Context context) {
            super(context);
            setVisibility(4);
        }

        public void onDraw(Canvas canvas) {
            float min = (float) (Math.min(getWidth(), getHeight()) / 2);
            RippleBackground rippleBackground = RippleBackground.this;
            canvas.drawCircle(min, min, min - rippleBackground.f3210b, rippleBackground.i);
        }
    }

    public RippleBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new Handler();
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RippleBackground);
                this.f3209a = obtainStyledAttributes.getColor(R$styleable.RippleBackground_rb_color, getResources().getColor(R$color.ripple_color));
                this.f3210b = obtainStyledAttributes.getDimension(R$styleable.RippleBackground_rb_strokeWidth, getResources().getDimension(R$dimen.rippleStrokeWidth));
                this.f3211c = obtainStyledAttributes.getDimension(R$styleable.RippleBackground_rb_radius, getResources().getDimension(R$dimen.rippleRadius));
                this.f3212d = obtainStyledAttributes.getInt(R$styleable.RippleBackground_rb_duration, 1500);
                this.f3213e = obtainStyledAttributes.getInt(R$styleable.RippleBackground_rb_rippleAmount, 6);
                this.g = obtainStyledAttributes.getFloat(R$styleable.RippleBackground_rb_scale, 6.0f);
                this.h = obtainStyledAttributes.getInt(R$styleable.RippleBackground_rb_type, 0);
                obtainStyledAttributes.recycle();
                this.f3214f = this.f3212d / this.f3213e;
                Paint paint = new Paint();
                this.i = paint;
                paint.setAntiAlias(true);
                if (this.h == 0) {
                    this.f3210b = 0.0f;
                    this.i.setStyle(Style.FILL);
                } else {
                    this.i.setStyle(Style.STROKE);
                }
                this.i.setColor(this.f3209a);
                int i2 = (int) ((this.f3211c + this.f3210b) * 2.0f);
                LayoutParams layoutParams = new LayoutParams(i2, i2);
                this.m = layoutParams;
                layoutParams.addRule(13, -1);
                AnimatorSet animatorSet = new AnimatorSet();
                this.k = animatorSet;
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                this.l = new ArrayList<>();
                for (int i3 = 0; i3 < this.f3213e; i3++) {
                    a aVar = new a(getContext());
                    addView(aVar, this.m);
                    this.n.add(aVar);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "ScaleX", new float[]{1.0f, this.g});
                    ofFloat.setStartDelay((long) (this.f3214f * i3));
                    ofFloat.setDuration((long) this.f3212d);
                    this.l.add(ofFloat);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar, "ScaleY", new float[]{1.0f, this.g});
                    ofFloat2.setStartDelay((long) (this.f3214f * i3));
                    ofFloat2.setDuration((long) this.f3212d);
                    this.l.add(ofFloat2);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(aVar, "Alpha", new float[]{1.0f, 0.0f});
                    ofFloat3.setStartDelay((long) (this.f3214f * i3));
                    ofFloat3.setDuration((long) this.f3212d);
                    this.l.add(ofFloat3);
                }
                this.k.playTogether(this.l);
                return;
            }
            throw new IllegalArgumentException("Attributes should be provided to this view,");
        }
    }

    public RippleBackground(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new Handler();
        a(context, attributeSet);
    }
}
