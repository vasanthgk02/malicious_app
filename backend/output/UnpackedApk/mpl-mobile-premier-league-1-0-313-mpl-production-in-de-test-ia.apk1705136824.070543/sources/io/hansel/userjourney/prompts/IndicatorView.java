package io.hansel.userjourney.prompts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.react.modules.appstate.AppStateModule;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.userjourney.n;

public class IndicatorView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f5474a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f5475b;

    /* renamed from: c  reason: collision with root package name */
    public int f5476c;

    /* renamed from: d  reason: collision with root package name */
    public int f5477d = 30;

    /* renamed from: e  reason: collision with root package name */
    public int f5478e;

    /* renamed from: f  reason: collision with root package name */
    public int f5479f;
    public int g;
    public int h;
    public int i;
    public int j;
    public String k;
    public int l;
    public int m;

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
        c();
        b();
    }

    private void a() {
        float f2 = ((float) this.m) / ((((float) this.f5479f) * 1.5f) + 2.0f);
        this.f5478e = (int) (0.66f * f2);
        this.l = ((int) f2) - 1;
    }

    private void b() {
        Paint paint = new Paint();
        this.f5475b = paint;
        paint.setStyle(Style.FILL);
    }

    private void c() {
        Paint paint = new Paint();
        this.f5474a = paint;
        paint.setAntiAlias(true);
        this.f5474a.setStyle(Style.FILL_AND_STROKE);
        this.f5474a.setStrokeJoin(Join.ROUND);
        this.f5474a.setStrokeCap(Cap.ROUND);
    }

    public void a(CoreJSONObject coreJSONObject, int i2) {
        CoreJSONObject coreJSONObject2;
        this.j = coreJSONObject.optInt("fontSize", 11);
        this.m = i2;
        try {
            coreJSONObject2 = coreJSONObject.getJSONObject("steps");
        } catch (CoreJSONException e2) {
            e2.printStackTrace();
            coreJSONObject2 = null;
        }
        this.k = coreJSONObject.optString("stepperType");
        if (coreJSONObject2 != null) {
            this.f5479f = coreJSONObject2.optInt(ECommerceParamNames.TOTAL, 2) + 1;
            this.g = coreJSONObject2.optInt(AppStateModule.APP_STATE_ACTIVE, 1) - 1;
            this.i = n.a(coreJSONObject2, (String) "activeColor", n.c("#FFFFFF"));
            this.h = n.a(coreJSONObject2, (String) "inactiveColor", n.c("#FFFFFF"));
        }
        a();
    }

    public String getStepperType() {
        return this.k;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k.equals("numbered")) {
            setTextColor(this.i);
            setText((this.g + 1) + " / " + (this.f5479f - 1));
            setTextSize((float) this.j);
            return;
        }
        int i2 = this.l;
        int i3 = 0;
        while (i3 < this.f5479f - 1) {
            this.f5474a.setStrokeWidth(0.0f);
            this.f5476c = i3 == 0 ? this.f5478e : this.f5476c + i2 + i2;
            this.f5474a.setColor(this.g == i3 ? this.i : this.h);
            if (this.g == i3) {
                this.f5474a.setStrokeWidth((float) (this.f5478e * 2));
                int i4 = this.f5476c;
                float f2 = (float) this.f5477d;
                canvas.drawLine((float) i4, f2, (float) ((this.f5478e * 3) + i4), f2, this.f5474a);
                this.f5476c = (this.f5478e * 3) + this.f5476c;
            } else {
                canvas.drawCircle((float) this.f5476c, (float) this.f5477d, (float) this.f5478e, this.f5474a);
            }
            i3++;
        }
    }
}
