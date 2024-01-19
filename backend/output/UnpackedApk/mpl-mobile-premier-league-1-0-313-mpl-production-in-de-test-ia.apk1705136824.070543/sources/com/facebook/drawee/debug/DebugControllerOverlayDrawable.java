package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.HashMap;
import java.util.Locale;

public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    public HashMap<String, String> mAdditionalData = new HashMap<>();
    public String mControllerId;
    public int mCurrentTextXPx;
    public int mCurrentTextYPx;
    public long mFinalImageTimeMs;
    public int mFrameCount;
    public int mHeightPx;
    public String mImageFormat;
    public int mImageSizeBytes;
    public int mLineIncrementPx;
    public int mLoopCount;
    public final Matrix mMatrix = new Matrix();
    public int mOriginColor = -1;
    public String mOriginText;
    public final Paint mPaint = new Paint(1);
    public final Rect mRect = new Rect();
    public final RectF mRectF = new RectF();
    public ScalingUtils$ScaleType mScaleType;
    public int mStartTextXPx;
    public int mStartTextYPx;
    public int mTextGravity = 80;
    public int mWidthPx;

    public DebugControllerOverlayDrawable() {
        reset();
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void addDebugText(Canvas canvas, String str, String str2, int i) {
        String outline50 = GeneratedOutlineSupport.outline50(str, ": ");
        float measureText = this.mPaint.measureText(outline50);
        float measureText2 = this.mPaint.measureText(str2);
        this.mPaint.setColor(1711276032);
        int i2 = this.mCurrentTextXPx;
        int i3 = this.mCurrentTextYPx;
        canvas.drawRect((float) (i2 - 4), (float) (i3 + 8), ((float) i2) + measureText + measureText2 + 4.0f, (float) (i3 + this.mLineIncrementPx + 8), this.mPaint);
        this.mPaint.setColor(-1);
        canvas.drawText(outline50, (float) this.mCurrentTextXPx, (float) this.mCurrentTextYPx, this.mPaint);
        this.mPaint.setColor(i);
        canvas.drawText(str2, ((float) this.mCurrentTextXPx) + measureText, (float) this.mCurrentTextYPx, this.mPaint);
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c5 A[LOOP:0: B:36:0x01bf->B:38:0x01c5, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r20) {
        /*
            r19 = this;
            r0 = r19
            r7 = r20
            android.graphics.Rect r8 = r19.getBounds()
            android.graphics.Paint r1 = r0.mPaint
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r1.setStyle(r2)
            android.graphics.Paint r1 = r0.mPaint
            r2 = 1073741824(0x40000000, float:2.0)
            r1.setStrokeWidth(r2)
            android.graphics.Paint r1 = r0.mPaint
            r2 = -26624(0xffffffffffff9800, float:NaN)
            r1.setColor(r2)
            int r1 = r8.left
            float r2 = (float) r1
            int r1 = r8.top
            float r3 = (float) r1
            int r1 = r8.right
            float r4 = (float) r1
            int r1 = r8.bottom
            float r5 = (float) r1
            android.graphics.Paint r6 = r0.mPaint
            r1 = r20
            r1.drawRect(r2, r3, r4, r5, r6)
            android.graphics.Paint r1 = r0.mPaint
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL
            r1.setStyle(r2)
            android.graphics.Paint r1 = r0.mPaint
            r2 = 0
            r1.setStrokeWidth(r2)
            android.graphics.Paint r1 = r0.mPaint
            r3 = -1
            r1.setColor(r3)
            int r1 = r0.mStartTextXPx
            r0.mCurrentTextXPx = r1
            int r1 = r0.mStartTextYPx
            r0.mCurrentTextYPx = r1
            java.lang.String r1 = r0.mControllerId
            java.lang.String r4 = "ID"
            r0.addDebugText(r7, r4, r1, r3)
            r1 = 2
            java.lang.Object[] r4 = new java.lang.Object[r1]
            int r5 = r8.width()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 0
            r4[r6] = r5
            int r5 = r8.height()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r8 = 1
            r4[r8] = r5
            java.lang.String r5 = "%dx%d"
            java.lang.String r4 = format(r5, r4)
            java.lang.String r9 = "D"
            r0.addDebugText(r7, r9, r4, r3)
            int r4 = r0.mWidthPx
            int r9 = r0.mHeightPx
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r10 = r0.mScaleType
            android.graphics.Rect r11 = r19.getBounds()
            int r15 = r11.width()
            android.graphics.Rect r11 = r19.getBounds()
            int r14 = r11.height()
            r17 = -65536(0xffffffffffff0000, float:NaN)
            if (r15 <= 0) goto L_0x0120
            if (r14 <= 0) goto L_0x0120
            if (r4 <= 0) goto L_0x0120
            if (r9 > 0) goto L_0x0098
            goto L_0x0120
        L_0x0098:
            if (r10 == 0) goto L_0x00e6
            android.graphics.Rect r11 = r0.mRect
            r11.top = r6
            r11.left = r6
            r11.right = r15
            r11.bottom = r14
            android.graphics.Matrix r11 = r0.mMatrix
            r11.reset()
            android.graphics.Matrix r11 = r0.mMatrix
            android.graphics.Rect r12 = r0.mRect
            r16 = 0
            r18 = 0
            com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType r10 = (com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType) r10
            r13 = r4
            r3 = r14
            r14 = r9
            r8 = r15
            r15 = r16
            r16 = r18
            r10.getTransform(r11, r12, r13, r14, r15, r16)
            android.graphics.RectF r10 = r0.mRectF
            r10.top = r2
            r10.left = r2
            float r2 = (float) r4
            r10.right = r2
            float r2 = (float) r9
            r10.bottom = r2
            android.graphics.Matrix r2 = r0.mMatrix
            r2.mapRect(r10)
            android.graphics.RectF r2 = r0.mRectF
            float r2 = r2.width()
            int r2 = (int) r2
            android.graphics.RectF r10 = r0.mRectF
            float r10 = r10.height()
            int r10 = (int) r10
            int r15 = java.lang.Math.min(r8, r2)
            int r14 = java.lang.Math.min(r3, r10)
            goto L_0x00e8
        L_0x00e6:
            r3 = r14
            r8 = r15
        L_0x00e8:
            float r2 = (float) r15
            r3 = 1036831949(0x3dcccccd, float:0.1)
            float r8 = r2 * r3
            r10 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 * r10
            float r11 = (float) r14
            float r3 = r3 * r11
            float r11 = r11 * r10
            int r4 = r4 - r15
            int r4 = java.lang.Math.abs(r4)
            int r9 = r9 - r14
            int r9 = java.lang.Math.abs(r9)
            float r4 = (float) r4
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0112
            float r8 = (float) r9
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0112
            r17 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            r2 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            goto L_0x0122
        L_0x0112:
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0120
            float r2 = (float) r9
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 >= 0) goto L_0x0120
            r17 = -256(0xffffffffffffff00, float:NaN)
            r2 = -256(0xffffffffffffff00, float:NaN)
            goto L_0x0122
        L_0x0120:
            r2 = -65536(0xffffffffffff0000, float:NaN)
        L_0x0122:
            java.lang.Object[] r3 = new java.lang.Object[r1]
            int r4 = r0.mWidthPx
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r6] = r4
            int r4 = r0.mHeightPx
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8 = 1
            r3[r8] = r4
            java.lang.String r3 = format(r5, r3)
            java.lang.String r4 = "I"
            r0.addDebugText(r7, r4, r3, r2)
            java.lang.Object[] r2 = new java.lang.Object[r8]
            int r3 = r0.mImageSizeBytes
            int r3 = r3 / 1024
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r6] = r3
            java.lang.String r3 = "%d KiB"
            java.lang.String r2 = format(r3, r2)
            r3 = -1
            r0.addDebugText(r7, r4, r2, r3)
            java.lang.String r2 = r0.mImageFormat
            if (r2 == 0) goto L_0x015d
            java.lang.String r4 = "i format"
            r0.addDebugText(r7, r4, r2, r3)
        L_0x015d:
            int r2 = r0.mFrameCount
            if (r2 <= 0) goto L_0x017f
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1[r6] = r2
            int r2 = r0.mLoopCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 1
            r1[r3] = r2
            java.lang.String r2 = "f %d, l %d"
            java.lang.String r1 = format(r2, r1)
            java.lang.String r2 = "anim"
            r3 = -1
            r0.addDebugText(r7, r2, r1, r3)
            goto L_0x0180
        L_0x017f:
            r3 = -1
        L_0x0180:
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r1 = r0.mScaleType
            if (r1 == 0) goto L_0x018d
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "scale"
            r0.addDebugText(r7, r2, r1, r3)
        L_0x018d:
            long r1 = r0.mFinalImageTimeMs
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x01aa
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r3[r6] = r1
            java.lang.String r1 = "%d ms"
            java.lang.String r1 = format(r1, r3)
            java.lang.String r2 = "t"
            r3 = -1
            r0.addDebugText(r7, r2, r1, r3)
        L_0x01aa:
            java.lang.String r1 = r0.mOriginText
            if (r1 == 0) goto L_0x01b5
            int r2 = r0.mOriginColor
            java.lang.String r3 = "origin"
            r0.addDebugText(r7, r3, r1, r2)
        L_0x01b5:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r0.mAdditionalData
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x01bf:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01dc
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r4 = -1
            r0.addDebugText(r7, r3, r2, r4)
            goto L_0x01bf
        L_0x01dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.debug.DebugControllerOverlayDrawable.draw(android.graphics.Canvas):void");
    }

    public int getOpacity() {
        return -3;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int min = Math.min(40, Math.max(10, Math.min(rect.width() / 8, rect.height() / 9)));
        this.mPaint.setTextSize((float) min);
        int i = min + 8;
        this.mLineIncrementPx = i;
        if (this.mTextGravity == 80) {
            this.mLineIncrementPx = i * -1;
        }
        this.mStartTextXPx = rect.left + 10;
        this.mStartTextYPx = this.mTextGravity == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mAdditionalData = new HashMap<>();
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        this.mControllerId = "none";
        invalidateSelf();
        this.mFinalImageTimeMs = -1;
        this.mOriginText = null;
        this.mOriginColor = -1;
        invalidateSelf();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
