package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R$color;
import com.yalantis.ucrop.R$dimen;
import com.yalantis.ucrop.R$styleable;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

public class AspectRatioTextView extends TextView {
    public float mAspectRatio;
    public String mAspectRatioTitle;
    public float mAspectRatioX;
    public float mAspectRatioY;
    public final Rect mCanvasClipBounds;
    public Paint mDotPaint;
    public int mDotSize;

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void applyActiveColor(int i) {
        Paint paint = this.mDotPaint;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i, ContextCompat.getColor(getContext(), R$color.ucrop_color_widget)}));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.mCanvasClipBounds);
            Rect rect = this.mCanvasClipBounds;
            int i = rect.bottom;
            int i2 = this.mDotSize;
            canvas.drawCircle(((float) (rect.right - rect.left)) / 2.0f, (float) (i - i2), (float) (i2 / 2), this.mDotPaint);
        }
    }

    public void setActiveColor(int i) {
        applyActiveColor(i);
        invalidate();
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.mAspectRatioTitle = aspectRatio.mAspectRatioTitle;
        float f2 = aspectRatio.mAspectRatioX;
        this.mAspectRatioX = f2;
        float f3 = aspectRatio.mAspectRatioY;
        this.mAspectRatioY = f3;
        if (f2 == 0.0f || f3 == 0.0f) {
            this.mAspectRatio = 0.0f;
        } else {
            this.mAspectRatio = f2 / f3;
        }
        setTitle();
    }

    public final void setTitle() {
        if (!TextUtils.isEmpty(this.mAspectRatioTitle)) {
            setText(this.mAspectRatioTitle);
            return;
        }
        setText(String.format(Locale.US, "%d:%d", new Object[]{Integer.valueOf((int) this.mAspectRatioX), Integer.valueOf((int) this.mAspectRatioY)}));
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanvasClipBounds = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ucrop_AspectRatioTextView);
        setGravity(1);
        this.mAspectRatioTitle = obtainStyledAttributes.getString(R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.mAspectRatioX = obtainStyledAttributes.getFloat(R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f2 = obtainStyledAttributes.getFloat(R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.mAspectRatioY = f2;
        float f3 = this.mAspectRatioX;
        if (f3 == 0.0f || f2 == 0.0f) {
            this.mAspectRatio = 0.0f;
        } else {
            this.mAspectRatio = f3 / f2;
        }
        this.mDotSize = getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.mDotPaint = paint;
        paint.setStyle(Style.FILL);
        setTitle();
        applyActiveColor(getResources().getColor(R$color.ucrop_color_widget_active));
        obtainStyledAttributes.recycle();
    }
}
