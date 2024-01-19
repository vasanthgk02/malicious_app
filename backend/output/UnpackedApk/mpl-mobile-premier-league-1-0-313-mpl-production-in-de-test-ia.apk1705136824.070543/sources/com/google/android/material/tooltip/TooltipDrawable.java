package com.google.android.material.tooltip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableDelegate {
    public int arrowSize;
    public final OnLayoutChangeListener attachedViewLayoutChangeListener = new OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            TooltipDrawable tooltipDrawable = TooltipDrawable.this;
            if (tooltipDrawable != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                tooltipDrawable.locationOnScreenX = iArr[0];
                view.getWindowVisibleDisplayFrame(tooltipDrawable.displayFrame);
                return;
            }
            throw null;
        }
    };
    public final Context context;
    public final Rect displayFrame = new Rect();
    public final FontMetrics fontMetrics = new FontMetrics();
    public float labelOpacity = 1.0f;
    public int layoutMargin;
    public int locationOnScreenX;
    public int minHeight;
    public int minWidth;
    public int padding;
    public CharSequence text;
    public final TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
    public float tooltipPivotY = 0.5f;
    public float tooltipScaleX = 1.0f;
    public float tooltipScaleY = 1.0f;

    public TooltipDrawable(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
        this.context = context2;
        this.textDrawableHelper.textPaint.density = context2.getResources().getDisplayMetrics().density;
        this.textDrawableHelper.textPaint.setTextAlign(Align.CENTER);
    }

    public final float calculatePointerOffset() {
        int i;
        if (((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin < 0) {
            i = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
        } else if (((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin <= 0) {
            return 0.0f;
        } else {
            i = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        }
        return (float) i;
    }

    public final EdgeTreatment createMarkerEdge() {
        float width = ((float) (((double) getBounds().width()) - (Math.sqrt(2.0d) * ((double) this.arrowSize)))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment((float) this.arrowSize), Math.min(Math.max(-calculatePointerOffset(), -width), width));
    }

    public void draw(Canvas canvas) {
        canvas.save();
        float calculatePointerOffset = calculatePointerOffset();
        double sqrt = Math.sqrt(2.0d);
        canvas.scale(this.tooltipScaleX, this.tooltipScaleY, (((float) getBounds().width()) * 0.5f) + ((float) getBounds().left), (((float) getBounds().height()) * this.tooltipPivotY) + ((float) getBounds().top));
        canvas.translate(calculatePointerOffset, (float) (-((sqrt * ((double) this.arrowSize)) - ((double) this.arrowSize))));
        super.draw(canvas);
        if (this.text != null) {
            Rect bounds = getBounds();
            this.textDrawableHelper.textPaint.getFontMetrics(this.fontMetrics);
            FontMetrics fontMetrics2 = this.fontMetrics;
            int centerY = (int) (((float) bounds.centerY()) - ((fontMetrics2.descent + fontMetrics2.ascent) / 2.0f));
            TextDrawableHelper textDrawableHelper2 = this.textDrawableHelper;
            if (textDrawableHelper2.textAppearance != null) {
                textDrawableHelper2.textPaint.drawableState = getState();
                TextDrawableHelper textDrawableHelper3 = this.textDrawableHelper;
                textDrawableHelper3.textAppearance.updateDrawState(this.context, textDrawableHelper3.textPaint, textDrawableHelper3.fontCallback);
                this.textDrawableHelper.textPaint.setAlpha((int) (this.labelOpacity * 255.0f));
            }
            CharSequence charSequence = this.text;
            canvas.drawText(charSequence, 0, charSequence.length(), (float) bounds.centerX(), (float) centerY, this.textDrawableHelper.textPaint);
        }
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return (int) Math.max(this.textDrawableHelper.textPaint.getTextSize(), (float) this.minHeight);
    }

    public int getIntrinsicWidth() {
        float f2;
        float f3 = (float) (this.padding * 2);
        CharSequence charSequence = this.text;
        if (charSequence == null) {
            f2 = 0.0f;
        } else {
            f2 = this.textDrawableHelper.getTextWidth(charSequence.toString());
        }
        return (int) Math.max(f3 + f2, (float) this.minWidth);
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        ShapeAppearanceModel shapeAppearanceModel = this.drawableState.shapeAppearanceModel;
        if (shapeAppearanceModel != null) {
            Builder builder = new Builder(shapeAppearanceModel);
            builder.bottomEdge = createMarkerEdge();
            this.drawableState.shapeAppearanceModel = builder.build();
            invalidateSelf();
            return;
        }
        throw null;
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void onTextSizeChange() {
        invalidateSelf();
    }
}
