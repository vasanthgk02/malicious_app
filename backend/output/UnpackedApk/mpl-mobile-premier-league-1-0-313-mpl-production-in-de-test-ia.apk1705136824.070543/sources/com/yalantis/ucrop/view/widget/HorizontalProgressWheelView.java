package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R$color;
import com.yalantis.ucrop.R$dimen;
import sfs2x.client.entities.invitation.InvitationReply;

public class HorizontalProgressWheelView extends View {
    public final Rect mCanvasClipBounds;
    public float mLastTouchedPosition;
    public int mMiddleLineColor;
    public int mProgressLineHeight;
    public int mProgressLineMargin;
    public Paint mProgressLinePaint;
    public int mProgressLineWidth;
    public boolean mScrollStarted;
    public ScrollingListener mScrollingListener;
    public float mTotalScrollDistance;

    public interface ScrollingListener {
        void onScroll(float f2, float f3);

        void onScrollEnd();

        void onScrollStart();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int width = this.mCanvasClipBounds.width();
        int i = this.mProgressLineWidth;
        int i2 = this.mProgressLineMargin;
        int i3 = width / (i + i2);
        float f2 = this.mTotalScrollDistance % ((float) (i2 + i));
        this.mProgressLinePaint.setColor(getResources().getColor(R$color.ucrop_color_progress_wheel_line));
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i3 / 4;
            if (i4 < i5) {
                this.mProgressLinePaint.setAlpha((int) ((((float) i4) / ((float) i5)) * 255.0f));
            } else if (i4 > (i3 * 3) / 4) {
                this.mProgressLinePaint.setAlpha((int) ((((float) (i3 - i4)) / ((float) i5)) * 255.0f));
            } else {
                this.mProgressLinePaint.setAlpha(InvitationReply.EXPIRED);
            }
            float f3 = -f2;
            Rect rect = this.mCanvasClipBounds;
            float f4 = ((float) rect.left) + f3 + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i4));
            float centerY = ((float) rect.centerY()) - (((float) this.mProgressLineHeight) / 4.0f);
            Rect rect2 = this.mCanvasClipBounds;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f4, centerY, f3 + ((float) rect2.left) + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i4)), (((float) this.mProgressLineHeight) / 4.0f) + ((float) rect2.centerY()), this.mProgressLinePaint);
        }
        this.mProgressLinePaint.setColor(this.mMiddleLineColor);
        float centerX = (float) this.mCanvasClipBounds.centerX();
        float centerY2 = ((float) this.mCanvasClipBounds.centerY()) - (((float) this.mProgressLineHeight) / 2.0f);
        Canvas canvas3 = canvas;
        float f5 = centerY2;
        canvas3.drawLine(centerX, f5, (float) this.mCanvasClipBounds.centerX(), (((float) this.mProgressLineHeight) / 2.0f) + ((float) this.mCanvasClipBounds.centerY()), this.mProgressLinePaint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchedPosition = motionEvent.getX();
        } else if (action == 1) {
            ScrollingListener scrollingListener = this.mScrollingListener;
            if (scrollingListener != null) {
                this.mScrollStarted = false;
                scrollingListener.onScrollEnd();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.mLastTouchedPosition;
            if (x != 0.0f) {
                if (!this.mScrollStarted) {
                    this.mScrollStarted = true;
                    ScrollingListener scrollingListener2 = this.mScrollingListener;
                    if (scrollingListener2 != null) {
                        scrollingListener2.onScrollStart();
                    }
                }
                this.mTotalScrollDistance -= x;
                postInvalidate();
                this.mLastTouchedPosition = motionEvent.getX();
                ScrollingListener scrollingListener3 = this.mScrollingListener;
                if (scrollingListener3 != null) {
                    scrollingListener3.onScroll(-x, this.mTotalScrollDistance);
                }
            }
        }
        return true;
    }

    public void setMiddleLineColor(int i) {
        this.mMiddleLineColor = i;
        invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanvasClipBounds = new Rect();
        this.mMiddleLineColor = ContextCompat.getColor(getContext(), R$color.ucrop_color_progress_wheel_line);
        this.mProgressLineWidth = getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.mProgressLinePaint = paint;
        paint.setStyle(Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth((float) this.mProgressLineWidth);
    }
}
