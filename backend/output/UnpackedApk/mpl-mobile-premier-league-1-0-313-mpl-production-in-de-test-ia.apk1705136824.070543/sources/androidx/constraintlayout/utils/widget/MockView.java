package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;
import sfs2x.client.entities.invitation.InvitationReply;

public class MockView extends View {
    public int mDiagonalsColor = Color.argb(InvitationReply.EXPIRED, 0, 0, 0);
    public boolean mDrawDiagonals = true;
    public boolean mDrawLabel = true;
    public int mMargin = 4;
    public Paint mPaintDiagonals = new Paint();
    public Paint mPaintText = new Paint();
    public Paint mPaintTextBackground = new Paint();
    public String mText = null;
    public int mTextBackgroundColor = Color.argb(InvitationReply.EXPIRED, 50, 50, 50);
    public Rect mTextBounds = new Rect();
    public int mTextColor = Color.argb(InvitationReply.EXPIRED, 200, 200, 200);

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public final void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MockView_mock_label) {
                    this.mText = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MockView_mock_showDiagonals) {
                    this.mDrawDiagonals = obtainStyledAttributes.getBoolean(index, this.mDrawDiagonals);
                } else if (index == R$styleable.MockView_mock_diagonalsColor) {
                    this.mDiagonalsColor = obtainStyledAttributes.getColor(index, this.mDiagonalsColor);
                } else if (index == R$styleable.MockView_mock_labelBackgroundColor) {
                    this.mTextBackgroundColor = obtainStyledAttributes.getColor(index, this.mTextBackgroundColor);
                } else if (index == R$styleable.MockView_mock_labelColor) {
                    this.mTextColor = obtainStyledAttributes.getColor(index, this.mTextColor);
                } else if (index == R$styleable.MockView_mock_showLabel) {
                    this.mDrawLabel = obtainStyledAttributes.getBoolean(index, this.mDrawLabel);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mText == null) {
            try {
                this.mText = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * ((float) this.mMargin));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.mDrawDiagonals) {
            width--;
            height--;
            float f2 = (float) width;
            float f3 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f2, f3, this.mPaintDiagonals);
            Canvas canvas2 = canvas;
            float f4 = f2;
            canvas2.drawLine(0.0f, f3, f4, 0.0f, this.mPaintDiagonals);
            canvas2.drawLine(0.0f, 0.0f, f4, 0.0f, this.mPaintDiagonals);
            float f5 = f2;
            float f6 = f3;
            canvas2.drawLine(f5, 0.0f, f4, f6, this.mPaintDiagonals);
            float f7 = f3;
            canvas2.drawLine(f5, f7, 0.0f, f6, this.mPaintDiagonals);
            canvas2.drawLine(0.0f, f7, 0.0f, 0.0f, this.mPaintDiagonals);
        }
        String str = this.mText;
        if (str != null && this.mDrawLabel) {
            this.mPaintText.getTextBounds(str, 0, str.length(), this.mTextBounds);
            float width2 = ((float) (width - this.mTextBounds.width())) / 2.0f;
            float height2 = (((float) (height - this.mTextBounds.height())) / 2.0f) + ((float) this.mTextBounds.height());
            this.mTextBounds.offset((int) width2, (int) height2);
            Rect rect = this.mTextBounds;
            int i = rect.left;
            int i2 = this.mMargin;
            rect.set(i - i2, rect.top - i2, rect.right + i2, rect.bottom + i2);
            canvas.drawRect(this.mTextBounds, this.mPaintTextBackground);
            canvas.drawText(this.mText, width2, height2, this.mPaintText);
        }
    }

    public MockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
