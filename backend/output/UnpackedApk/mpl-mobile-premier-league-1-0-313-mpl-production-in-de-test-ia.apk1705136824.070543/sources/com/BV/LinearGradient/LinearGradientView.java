package com.BV.LinearGradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.View;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableArray;

public class LinearGradientView extends View {
    public float mAngle = 45.0f;
    public float[] mAngleCenter = {0.5f, 0.5f};
    public float[] mBorderRadii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    public int[] mColors;
    public float[] mEndPos = {0.0f, 1.0f};
    public float[] mLocations;
    public final Paint mPaint = new Paint(1);
    public Path mPathForBorderRadius;
    public LinearGradient mShader;
    public int[] mSize = {0, 0};
    public float[] mStartPos = {0.0f, 0.0f};
    public RectF mTempRectForBorderRadius;
    public boolean mUseAngle = false;

    public LinearGradientView(Context context) {
        super(context);
    }

    public final void drawGradient() {
        int[] iArr = this.mColors;
        if (iArr != null) {
            float[] fArr = this.mLocations;
            if (fArr == null || iArr.length == fArr.length) {
                float[] fArr2 = this.mStartPos;
                float[] fArr3 = this.mEndPos;
                if (this.mUseAngle && this.mAngleCenter != null) {
                    float sqrt = (float) Math.sqrt(2.0d);
                    double d2 = (double) ((this.mAngle - 90.0f) * 0.017453292f);
                    float[] fArr4 = {((float) Math.cos(d2)) * sqrt, ((float) Math.sin(d2)) * sqrt};
                    float[] fArr5 = this.mAngleCenter;
                    fArr2 = new float[]{fArr5[0] - (fArr4[0] / 2.0f), fArr5[1] - (fArr4[1] / 2.0f)};
                    fArr3 = new float[]{(fArr4[0] / 2.0f) + fArr5[0], (fArr4[1] / 2.0f) + fArr5[1]};
                }
                float f2 = fArr2[0];
                int[] iArr2 = this.mSize;
                float f3 = ((float) iArr2[0]) * f2;
                float f4 = fArr2[1] * ((float) iArr2[1]);
                LinearGradient linearGradient = new LinearGradient(f3, f4, fArr3[0] * ((float) iArr2[0]), fArr3[1] * ((float) iArr2[1]), this.mColors, this.mLocations, TileMode.CLAMP);
                this.mShader = linearGradient;
                this.mPaint.setShader(linearGradient);
                invalidate();
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.mPathForBorderRadius;
        if (path == null) {
            canvas.drawPaint(this.mPaint);
        } else {
            canvas.drawPath(path, this.mPaint);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mSize = new int[]{i, i2};
        updatePath();
        drawGradient();
    }

    public void setAngle(float f2) {
        this.mAngle = f2;
        drawGradient();
    }

    public void setAngleCenter(ReadableArray readableArray) {
        this.mAngleCenter = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setBorderRadii(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = ImageOriginUtils.toPixelFromDIP((float) readableArray.getDouble(i));
        }
        this.mBorderRadii = fArr;
        updatePath();
        drawGradient();
    }

    public void setColors(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = readableArray.getInt(i);
        }
        this.mColors = iArr;
        drawGradient();
    }

    public void setEndPosition(ReadableArray readableArray) {
        this.mEndPos = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setLocations(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        this.mLocations = fArr;
        drawGradient();
    }

    public void setStartPosition(ReadableArray readableArray) {
        this.mStartPos = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setUseAngle(boolean z) {
        this.mUseAngle = z;
        drawGradient();
    }

    public final void updatePath() {
        if (this.mPathForBorderRadius == null) {
            this.mPathForBorderRadius = new Path();
            this.mTempRectForBorderRadius = new RectF();
        }
        this.mPathForBorderRadius.reset();
        RectF rectF = this.mTempRectForBorderRadius;
        int[] iArr = this.mSize;
        rectF.set(0.0f, 0.0f, (float) iArr[0], (float) iArr[1]);
        this.mPathForBorderRadius.addRoundRect(this.mTempRectForBorderRadius, this.mBorderRadii, Direction.CW);
    }
}
