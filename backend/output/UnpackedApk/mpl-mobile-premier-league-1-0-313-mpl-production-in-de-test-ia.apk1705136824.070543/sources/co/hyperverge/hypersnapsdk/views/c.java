package co.hyperverge.hypersnapsdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.FrameLayout;
import android.widget.TextView;
import co.hyperverge.hypersnapsdk.R$id;
import co.hyperverge.hypersnapsdk.R$layout;
import java.util.ArrayList;

/* compiled from: FaceBoxView */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Paint f3229a = new Paint();

    /* renamed from: f  reason: collision with root package name */
    public boolean f3230f = false;
    public TextView h;

    public c(Context context) {
        super(context);
        FrameLayout.inflate(getContext(), R$layout.frame_layout_facebox, this);
        setWillNotDraw(false);
        this.h = (TextView) findViewById(R$id.tv_message);
    }

    public ArrayList<Integer> getPoints() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Integer valueOf = Integer.valueOf(0);
        arrayList.add(valueOf);
        arrayList.add(valueOf);
        arrayList.add(valueOf);
        arrayList.add(valueOf);
        return arrayList;
    }

    public void onDraw(Canvas canvas) {
        if (!this.f3230f) {
            this.h.setVisibility(8);
            return;
        }
        this.f3229a.setColor(Color.parseColor("#99ca3e"));
        this.f3229a.setStyle(Style.STROKE);
        this.f3229a.setStrokeWidth(10.0f);
        float f2 = (float) 0;
        canvas.drawRect(f2, f2, f2, f2, this.f3229a);
    }
}
