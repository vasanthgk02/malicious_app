package com.visa;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.widget.AppCompatImageView;
import com.twitter.sdk.android.tweetui.TweetUtils;

public class SensoryBrandingView extends RelativeLayout {
    public static int p;

    /* renamed from: a  reason: collision with root package name */
    public View f4288a;

    /* renamed from: b  reason: collision with root package name */
    public View f4289b;

    /* renamed from: c  reason: collision with root package name */
    public View f4290c;

    /* renamed from: d  reason: collision with root package name */
    public View f4291d;

    /* renamed from: e  reason: collision with root package name */
    public View f4292e;

    /* renamed from: f  reason: collision with root package name */
    public View f4293f;
    public View g;
    public AppCompatImageView h;
    public AppCompatImageView i;
    public Trapezoid j;
    public Trapezoid k;
    public RelativeLayout l;
    public Context m;
    public AttributeSet n;
    public boolean o;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;

    public SensoryBrandingView(Context context) {
        this(context, null);
    }

    public SensoryBrandingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SensoryBrandingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = false;
        this.q = getResources().getColor(R.color.visa_blue);
        this.r = false;
        this.s = true;
        this.t = true;
        this.m = context;
        this.n = attributeSet;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            layoutInflater.inflate(R.layout.sensory_branding, this, true);
        }
        this.f4289b = findViewById(R.id.top_flag_constrained);
        this.f4290c = findViewById(R.id.top_flag_constrained_small);
        this.f4292e = findViewById(R.id.bottom_flag_constrained);
        this.f4293f = findViewById(R.id.bottom_flag_constrained_small);
        this.f4288a = findViewById(R.id.top_flag);
        this.f4291d = findViewById(R.id.bottom_flag);
        this.h = (AppCompatImageView) findViewById(R.id.visa_logo);
        this.k = (Trapezoid) findViewById(R.id.right_overlay);
        this.j = (Trapezoid) findViewById(R.id.left_overlay);
        this.l = (RelativeLayout) findViewById(R.id.container);
        this.g = findViewById(R.id.hide_mask);
        this.i = (AppCompatImageView) findViewById(R.id.checkmark);
        this.k.f4298a = 68.0d;
        this.j.f4298a = 68.0d;
        if (this.n != null) {
            TypedArray obtainStyledAttributes = this.m.getTheme().obtainStyledAttributes(this.n, R.styleable.SensoryBrandingView, 0, 0);
            try {
                this.s = obtainStyledAttributes.getBoolean(R.styleable.SensoryBrandingView_soundEnabled, false);
                int integer = obtainStyledAttributes.getInteger(R.styleable.SensoryBrandingView_backdropColor, getBackdropColor());
                this.q = integer;
                setBackgroundColor(integer);
                this.r = obtainStyledAttributes.getBoolean(R.styleable.SensoryBrandingView_constrainedFlags, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        e();
    }

    private int getConfirmationImgHeight() {
        return getConfirmationImgWidth();
    }

    private int getConfirmationImgWidth() {
        return getLogoHeight();
    }

    private int getFlagHeight() {
        return (int) (((double) getFlagWidth()) * 0.09d);
    }

    private int getFlagWidth() {
        return getLogoWidth();
    }

    private GradientDrawable getGradientForBottomConstrainedFlag() {
        GradientDrawable gradientDrawable = new GradientDrawable(Orientation.RIGHT_LEFT, new int[]{getBackdropColor(), getResources().getColor(17170445)});
        gradientDrawable.setCornerRadius(0.0f);
        return gradientDrawable;
    }

    private GradientDrawable getGradientForTopConstrainedFlag() {
        GradientDrawable gradientDrawable = new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{getBackdropColor(), getResources().getColor(17170445)});
        gradientDrawable.setCornerRadius(0.0f);
        return gradientDrawable;
    }

    private int getHideMaskParamsHeight() {
        return getHideMaskParamsWidth();
    }

    private int getHideMaskParamsWidth() {
        int logoWidth = getLogoWidth();
        int logoHeight = getLogoHeight();
        return (int) Math.sqrt((double) ((logoHeight * logoHeight) + (logoWidth * logoWidth)));
    }

    private int getLogoHeight() {
        return (int) (((double) getLogoWidth()) * 0.32d);
    }

    private int getLogoWidth() {
        return p;
    }

    private int getOverlayHeight() {
        return getLogoWidth();
    }

    private int getOverlayWidth() {
        return getLogoWidth() / 2;
    }

    private int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public final void a(final View view, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = 1;
            i3 = -2;
        } else {
            i2 = 0;
            i3 = 2;
        }
        AnimationSet animationSet = new AnimationSet(true);
        Animation a2 = TweetUtils.a(0.0f, 1.0f, 1.0f, 1.0f, 1, (float) i2, 1, 1.0f, 85);
        Animation a3 = TweetUtils.a(1, 0.0f, 1, (float) i3, 0, 0.0f, 0, 0.0f, 366);
        a3.setStartOffset(85);
        animationSet.addAnimation(a2);
        animationSet.addAnimation(a3);
        animationSet.setStartOffset(75);
        animationSet.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(animationSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0283  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.visa.SensoryBrandingCompletionHandler r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            android.content.Context r2 = r24.getContext()
            int r3 = r0.q
            android.content.res.Resources r4 = r2.getResources()
            r5 = 17170443(0x106000b, float:2.4611944E-38)
            int r4 = r4.getColor(r5)
            double r6 = androidx.core.graphics.ColorUtils.calculateContrast(r4, r3)
            r8 = 4613937818241073152(0x4008000000000000, double:3.0)
            r4 = 0
            r10 = 1
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x0023
        L_0x0021:
            r2 = 1
            goto L_0x0037
        L_0x0023:
            android.content.res.Resources r2 = r2.getResources()
            int r6 = com.visa.R.color.dark_blue
            int r2 = r2.getColor(r6)
            double r2 = androidx.core.graphics.ColorUtils.calculateContrast(r2, r3)
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0036
            goto L_0x0021
        L_0x0036:
            r2 = 0
        L_0x0037:
            if (r2 != 0) goto L_0x0046
            if (r1 == 0) goto L_0x0045
            java.lang.Error r2 = new java.lang.Error
            java.lang.String r3 = "Invalid background color selected, contrast levels are below 3:1 against #FFFFFF and #1A1F71"
            r2.<init>(r3)
            r1.onComplete(r2)
        L_0x0045:
            return
        L_0x0046:
            r0.o = r10
            com.visa.Trapezoid r2 = r0.k
            int r3 = r24.getBackdropColor()
            r2.a(r3)
            com.visa.Trapezoid r2 = r0.j
            int r3 = r24.getBackdropColor()
            r2.a(r3)
            boolean r2 = r24.hasConstrainedFlags()
            if (r2 == 0) goto L_0x0080
            android.view.View r2 = r0.f4289b
            int r3 = r0.q
            r2.setBackgroundColor(r3)
            android.view.View r2 = r0.f4292e
            int r3 = r0.q
            r2.setBackgroundColor(r3)
            android.view.View r2 = r0.f4290c
            android.graphics.drawable.GradientDrawable r3 = r24.getGradientForTopConstrainedFlag()
            r2.setBackground(r3)
            android.view.View r2 = r0.f4293f
            android.graphics.drawable.GradientDrawable r3 = r24.getGradientForBottomConstrainedFlag()
            r2.setBackground(r3)
        L_0x0080:
            android.content.res.Resources r2 = r24.getResources()
            int r3 = com.visa.R.color.visa_blue
            int r2 = r2.getColor(r3)
            android.content.res.Resources r3 = r24.getResources()
            int r6 = com.visa.R.color.white
            int r3 = r3.getColor(r6)
            android.content.res.Resources r6 = r24.getResources()
            int r7 = com.visa.R.color.dark_blue
            int r6 = r6.getColor(r7)
            int r7 = r0.q
            if (r7 != r2) goto L_0x00c1
            android.view.View r2 = r0.f4291d
            android.content.res.Resources r3 = r24.getResources()
            int r5 = com.visa.R.drawable.gradient_orange
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r5)
            r2.setBackground(r3)
            android.view.View r2 = r0.f4288a
            android.content.res.Resources r3 = r24.getResources()
            int r5 = com.visa.R.drawable.gradient_blue
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r5)
            r2.setBackground(r3)
            goto L_0x0119
        L_0x00c1:
            if (r7 != r3) goto L_0x00d3
            android.content.res.Resources r2 = r24.getResources()
            int r3 = com.visa.R.color.visa_gold
            int r2 = r2.getColor(r3)
            android.view.View r3 = r0.f4291d
            r3.setBackgroundColor(r2)
            goto L_0x0100
        L_0x00d3:
            android.content.Context r2 = r24.getContext()
            int r7 = r0.q
            android.content.res.Resources r8 = r2.getResources()
            int r5 = r8.getColor(r5)
            double r8 = androidx.core.graphics.ColorUtils.calculateContrast(r5, r7)
            android.content.res.Resources r2 = r2.getResources()
            int r11 = com.visa.R.color.dark_blue
            int r2 = r2.getColor(r11)
            double r11 = androidx.core.graphics.ColorUtils.calculateContrast(r2, r7)
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r5 = r2
        L_0x00f9:
            android.view.View r2 = r0.f4291d
            if (r5 != r6) goto L_0x0111
            r2.setBackgroundColor(r6)
        L_0x0100:
            android.view.View r2 = r0.f4288a
            r2.setBackgroundColor(r6)
            androidx.appcompat.widget.AppCompatImageView r2 = r0.h
            int r3 = com.visa.R.drawable.visa_logo_dark_blue
            r2.setImageResource(r3)
            androidx.appcompat.widget.AppCompatImageView r2 = r0.i
            int r3 = com.visa.R.drawable.animated_check_mark_dark_blue
            goto L_0x0124
        L_0x0111:
            r2.setBackgroundColor(r3)
            android.view.View r2 = r0.f4288a
            r2.setBackgroundColor(r3)
        L_0x0119:
            androidx.appcompat.widget.AppCompatImageView r2 = r0.h
            int r3 = com.visa.R.drawable.visa_logo_white
            r2.setImageResource(r3)
            androidx.appcompat.widget.AppCompatImageView r2 = r0.i
            int r3 = com.visa.R.drawable.animated_check_mark_white
        L_0x0124:
            r2.setImageResource(r3)
            r24.e()
            r11 = 1063279958(0x3f605d56, float:0.8764242)
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 1063279958(0x3f605d56, float:0.8764242)
            r14 = 1065353216(0x3f800000, float:1.0)
            r15 = 1
            r16 = 1056964608(0x3f000000, float:0.5)
            r17 = 1
            r18 = 1056964608(0x3f000000, float:0.5)
            r19 = 1880(0x758, double:9.29E-321)
            android.view.animation.Animation r2 = com.twitter.sdk.android.tweetui.TweetUtils.a(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            android.widget.RelativeLayout r3 = r0.l
            r3.startAnimation(r2)
            com.visa.SensoryBrandingView$1 r3 = new com.visa.SensoryBrandingView$1
            r3.<init>(r1)
            r2.setAnimationListener(r3)
            androidx.appcompat.widget.AppCompatImageView r1 = r0.h
            r1.setVisibility(r4)
            com.visa.Trapezoid r1 = r0.j
            r2 = 1127481344(0x43340000, float:180.0)
            r1.setRotation(r2)
            r11 = 1
            r12 = 0
            r13 = 1
            r17 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 206(0xce, double:1.02E-321)
            r14 = 1
            r15 = 0
            r16 = 1
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 206(0xce, double:1.02E-321)
            android.view.animation.Animation r8 = com.twitter.sdk.android.tweetui.TweetUtils.a(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            com.visa.Trapezoid r9 = r0.k
            r9.startAnimation(r8)
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r5
            r19 = r6
            android.view.animation.Animation r1 = com.twitter.sdk.android.tweetui.TweetUtils.a(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            com.visa.Trapezoid r2 = r0.j
            r2.startAnimation(r1)
            boolean r1 = r0.r
            r2 = 4
            if (r1 == 0) goto L_0x01b4
            android.view.View r1 = r0.f4288a
            r1.setVisibility(r2)
            android.view.View r1 = r0.f4291d
            r1.setVisibility(r2)
            android.view.View r1 = r0.f4289b
            r1.setVisibility(r4)
            android.view.View r1 = r0.f4292e
            r1.setVisibility(r4)
            android.view.View r1 = r0.f4290c
            r1.setVisibility(r4)
            android.view.View r1 = r0.f4293f
            r1.setVisibility(r4)
            goto L_0x01d2
        L_0x01b4:
            android.view.View r1 = r0.f4288a
            r1.setVisibility(r4)
            android.view.View r1 = r0.f4291d
            r1.setVisibility(r4)
            android.view.View r1 = r0.f4289b
            r1.setVisibility(r2)
            android.view.View r1 = r0.f4292e
            r1.setVisibility(r2)
            android.view.View r1 = r0.f4290c
            r1.setVisibility(r2)
            android.view.View r1 = r0.f4293f
            r1.setVisibility(r2)
        L_0x01d2:
            android.view.View r1 = r0.f4288a
            r0.a(r1, r10)
            android.view.View r1 = r0.f4291d
            r0.a(r1, r4)
            android.view.View r1 = r0.g
            r1.setVisibility(r4)
            android.view.View r1 = r0.g
            int r2 = r24.getBackdropColor()
            r1.setBackgroundColor(r2)
            r11 = 0
            r12 = 1102053376(0x41b00000, float:22.0)
            r13 = 1
            r14 = 1056964608(0x3f000000, float:0.5)
            r15 = 1
            r16 = 1056964608(0x3f000000, float:0.5)
            r17 = 0
            android.view.animation.Animation r1 = com.twitter.sdk.android.tweetui.TweetUtils.a(r11, r12, r13, r14, r15, r16, r17)
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = 1065353216(0x3f800000, float:1.0)
            r17 = 1
            r18 = 1056964608(0x3f000000, float:0.5)
            r19 = 245(0xf5, double:1.21E-321)
            android.view.animation.Animation r2 = com.twitter.sdk.android.tweetui.TweetUtils.a(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            android.view.animation.AnimationSet r3 = new android.view.animation.AnimationSet
            r3.<init>(r10)
            r3.addAnimation(r2)
            r3.addAnimation(r1)
            r1 = 695(0x2b7, double:3.434E-321)
            r3.setStartOffset(r1)
            android.view.View r1 = r0.g
            r1.startAnimation(r3)
            boolean r1 = r24.isCheckMarkShown()
            if (r1 == 0) goto L_0x027d
            android.view.animation.AlphaAnimation r1 = new android.view.animation.AlphaAnimation
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            r1.<init>(r2, r3)
            r1.setFillAfter(r10)
            r5 = 489(0x1e9, double:2.416E-321)
            r1.setDuration(r5)
            r5 = 714(0x2ca, double:3.53E-321)
            r1.setStartOffset(r5)
            r11 = 1117782016(0x42a00000, float:80.0)
            r12 = 0
            r13 = 1
            r14 = 1056964608(0x3f000000, float:0.5)
            r15 = 1
            r16 = 1056964608(0x3f000000, float:0.5)
            r17 = 395(0x18b, double:1.95E-321)
            android.view.animation.Animation r5 = com.twitter.sdk.android.tweetui.TweetUtils.a(r11, r12, r13, r14, r15, r16, r17)
            r6 = 808(0x328, double:3.99E-321)
            r5.setStartOffset(r6)
            android.view.animation.AlphaAnimation r6 = new android.view.animation.AlphaAnimation
            r6.<init>(r3, r2)
            r2 = 1636(0x664, double:8.083E-321)
            r6.setStartOffset(r2)
            r2 = 244(0xf4, double:1.206E-321)
            r6.setDuration(r2)
            android.view.animation.AnimationSet r2 = new android.view.animation.AnimationSet
            r2.<init>(r10)
            r2.addAnimation(r1)
            r2.addAnimation(r5)
            r2.addAnimation(r6)
            r2.setFillAfter(r4)
            androidx.appcompat.widget.AppCompatImageView r1 = r0.i
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            android.graphics.drawable.Animatable r1 = (android.graphics.drawable.Animatable) r1
            r1.start()
            androidx.appcompat.widget.AppCompatImageView r1 = r0.i
            r1.startAnimation(r2)
        L_0x027d:
            boolean r1 = r24.isHapticFeedbackEnabled()
            if (r1 == 0) goto L_0x029d
            android.content.Context r1 = r24.getContext()
            java.lang.String r2 = "vibrator"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.os.Vibrator r1 = (android.os.Vibrator) r1
            if (r1 == 0) goto L_0x029d
            r2 = 8
            long[] r2 = new long[r2]
            r2 = {0, 102, 48, 114, 179, 84, 60, 90} // fill-array
            r3 = -1
            r1.vibrate(r2, r3)
        L_0x029d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.SensoryBrandingView.a(com.visa.SensoryBrandingCompletionHandler):void");
    }

    public ViewPropertyAnimator animate() {
        if (!this.o) {
            a(null);
        }
        return null;
    }

    public void animate(SensoryBrandingCompletionHandler sensoryBrandingCompletionHandler) {
        if (!this.o) {
            a(sensoryBrandingCompletionHandler);
        } else {
            sensoryBrandingCompletionHandler.onComplete(new Error("Previous animation still in progress, cannot start a new animation."));
        }
    }

    public final void e() {
        int flagWidth = getFlagWidth();
        LayoutParams layoutParams = (LayoutParams) this.f4288a.getLayoutParams();
        layoutParams.width = flagWidth;
        layoutParams.height = getFlagHeight();
        this.f4288a.setLayoutParams(layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) this.f4291d.getLayoutParams();
        layoutParams2.width = flagWidth;
        layoutParams2.height = getFlagHeight();
        this.f4291d.setLayoutParams(layoutParams2);
        LayoutParams layoutParams3 = (LayoutParams) this.f4290c.getLayoutParams();
        layoutParams3.height = getFlagHeight();
        this.f4290c.setLayoutParams(layoutParams3);
        LayoutParams layoutParams4 = (LayoutParams) this.f4293f.getLayoutParams();
        layoutParams4.height = getFlagHeight();
        this.f4293f.setLayoutParams(layoutParams4);
        LayoutParams layoutParams5 = (LayoutParams) this.f4289b.getLayoutParams();
        layoutParams5.width = flagWidth;
        layoutParams5.height = getFlagHeight();
        this.f4289b.setLayoutParams(layoutParams5);
        LayoutParams layoutParams6 = (LayoutParams) this.f4292e.getLayoutParams();
        layoutParams6.width = flagWidth;
        layoutParams6.height = getFlagHeight();
        this.f4292e.setLayoutParams(layoutParams6);
        LayoutParams layoutParams7 = (LayoutParams) this.h.getLayoutParams();
        layoutParams7.width = getLogoWidth();
        layoutParams7.height = getLogoHeight();
        layoutParams7.topMargin = getFlagHeight();
        layoutParams7.bottomMargin = getFlagHeight();
        this.h.setLayoutParams(layoutParams7);
        LayoutParams layoutParams8 = (LayoutParams) this.g.getLayoutParams();
        layoutParams8.width = getHideMaskParamsWidth();
        layoutParams8.height = getHideMaskParamsHeight();
        this.g.setLayoutParams(layoutParams8);
        LayoutParams layoutParams9 = (LayoutParams) this.k.getLayoutParams();
        layoutParams9.width = getOverlayWidth();
        layoutParams9.height = getOverlayHeight();
        this.k.setLayoutParams(layoutParams9);
        LayoutParams layoutParams10 = (LayoutParams) this.j.getLayoutParams();
        layoutParams10.width = getOverlayWidth();
        layoutParams10.height = getOverlayHeight();
        this.j.setLayoutParams(layoutParams10);
        this.i.getLayoutParams().width = getConfirmationImgWidth();
        this.i.getLayoutParams().height = getConfirmationImgHeight();
    }

    public int getBackdropColor() {
        return this.q;
    }

    public boolean hasConstrainedFlags() {
        return this.r;
    }

    public final void i() {
        this.l.clearAnimation();
        for (int i2 = 0; i2 < this.l.getChildCount(); i2++) {
            this.l.getChildAt(i2).clearAnimation();
        }
    }

    public boolean isCheckMarkShown() {
        return this.t;
    }

    public boolean isSoundEnabled() {
        return this.s;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            getChildAt(i6).layout(i2, i3, i4, i5);
        }
        this.l.setTop(0);
    }

    public void onMeasure(int i2, int i3) {
        int size = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i3);
        int mode2 = MeasureSpec.getMode(i3);
        double screenWidth = (double) getScreenWidth();
        int i4 = (int) ((this.r ? 0.2d : 0.35d) * screenWidth);
        int i5 = (int) (screenWidth * 0.4d);
        if (mode != 0 && size >= i4) {
            i4 = size;
            if (size > i5) {
                size = i5;
            }
        } else {
            size = i4;
        }
        int i6 = (int) (((double) size) * 0.75d);
        if (mode2 == Integer.MIN_VALUE ? size2 < i6 : !(mode2 == 1073741824 && size2 >= i6)) {
            size2 = i6;
        }
        p = size;
        setMeasuredDimension(i4, size2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth() / getChildCount(), 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).measure(makeMeasureSpec, makeMeasureSpec2);
        }
    }

    public void setBackdropColor(int i2) {
        this.q = i2;
        setBackgroundColor(i2);
        this.g.setBackgroundColor(this.q);
        this.h.setVisibility(4);
        this.j.a(this.q);
        this.k.a(this.q);
        if (hasConstrainedFlags()) {
            this.f4289b.setVisibility(4);
            this.f4292e.setVisibility(4);
            this.f4290c.setVisibility(4);
            this.f4293f.setVisibility(4);
        }
        if (this.o) {
            i();
        }
    }

    public void setCheckMarkShown(boolean z) {
        this.t = z;
        if (this.o) {
            i();
        }
    }

    public void setConstrainedFlags(boolean z) {
        this.r = z;
        if (this.o) {
            i();
        }
    }

    public void setSoundEnabled(boolean z) {
        this.s = z;
    }
}
