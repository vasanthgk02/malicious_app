package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTShapeShadowNode extends ARTVirtualNode {
    public float[] mBrushData;
    public Path mPath;
    public int mStrokeCap = 1;
    public float[] mStrokeColor;
    public float[] mStrokeDash;
    public int mStrokeJoin = 1;
    public float mStrokeWidth = 1.0f;

    public void draw(Canvas canvas, Paint paint, float f2) {
        float f3 = f2 * this.mOpacity;
        if (f3 > 0.01f) {
            saveAndSetupCanvas(canvas);
            if (this.mPath != null) {
                if (setupFillPaint(paint, f3)) {
                    canvas.drawPath(this.mPath, paint);
                }
                if (setupStrokePaint(paint, f3)) {
                    canvas.drawPath(this.mPath, paint);
                }
                canvas.restore();
            } else {
                throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
            }
        }
        markUpdateSeen();
    }

    @ReactProp(name = "fill")
    public void setFill(ReadableArray readableArray) {
        this.mBrushData = ImageOriginUtils.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(name = "d")
    public void setShapePath(ReadableArray readableArray) {
        int i;
        int i2;
        float[] floatArray = ImageOriginUtils.toFloatArray(readableArray);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        int i3 = 0;
        while (i3 < floatArray.length) {
            int i4 = i3 + 1;
            int i5 = (int) floatArray[i3];
            if (i5 != 0) {
                boolean z = true;
                if (i5 == 1) {
                    path.close();
                    i3 = i4;
                } else if (i5 != 2) {
                    if (i5 == 3) {
                        int i6 = i4 + 1;
                        float f2 = floatArray[i4];
                        float f3 = this.mScale;
                        int i7 = i6 + 1;
                        float f4 = floatArray[i6] * f3;
                        int i8 = i7 + 1;
                        float f5 = floatArray[i7] * f3;
                        int i9 = i8 + 1;
                        float f6 = floatArray[i8] * f3;
                        int i10 = i9 + 1;
                        i2 = i10 + 1;
                        path.cubicTo(f2 * f3, f4, f5, f6, floatArray[i9] * f3, floatArray[i10] * f3);
                    } else if (i5 == 4) {
                        int i11 = i4 + 1;
                        float f7 = floatArray[i4];
                        float f8 = this.mScale;
                        float f9 = f7 * f8;
                        int i12 = i11 + 1;
                        float f10 = floatArray[i11] * f8;
                        int i13 = i12 + 1;
                        float f11 = floatArray[i12] * f8;
                        int i14 = i13 + 1;
                        float degrees = (float) Math.toDegrees((double) floatArray[i13]);
                        int i15 = i14 + 1;
                        float degrees2 = (float) Math.toDegrees((double) floatArray[i14]);
                        i2 = i15 + 1;
                        if (floatArray[i15] == 1.0f) {
                            z = false;
                        }
                        float f12 = degrees2 - degrees;
                        if (Math.abs(f12) >= 360.0f) {
                            path.addCircle(f9, f10, f11, z ? Direction.CCW : Direction.CW);
                        } else {
                            float f13 = f12 % 360.0f;
                            if (f13 < 0.0f) {
                                f13 += 360.0f;
                            }
                            if (z && f13 < 360.0f) {
                                f13 = (360.0f - f13) * -1.0f;
                            }
                            path.arcTo(new RectF(f9 - f11, f10 - f11, f9 + f11, f10 + f11), degrees, f13);
                        }
                    } else {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline41("Unrecognized drawing instruction ", i5));
                    }
                    i3 = i2;
                } else {
                    int i16 = i4 + 1;
                    float f14 = floatArray[i4];
                    float f15 = this.mScale;
                    i = i16 + 1;
                    path.lineTo(f14 * f15, floatArray[i16] * f15);
                }
            } else {
                int i17 = i4 + 1;
                float f16 = floatArray[i4];
                float f17 = this.mScale;
                i = i17 + 1;
                path.moveTo(f16 * f17, floatArray[i17] * f17);
            }
            i3 = i;
        }
        this.mPath = path;
        markUpdated();
    }

    @ReactProp(name = "stroke")
    public void setStroke(ReadableArray readableArray) {
        this.mStrokeColor = ImageOriginUtils.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeCap")
    public void setStrokeCap(int i) {
        this.mStrokeCap = i;
        markUpdated();
    }

    @ReactProp(name = "strokeDash")
    public void setStrokeDash(ReadableArray readableArray) {
        this.mStrokeDash = ImageOriginUtils.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeJoin")
    public void setStrokeJoin(int i) {
        this.mStrokeJoin = i;
        markUpdated();
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(float f2) {
        this.mStrokeWidth = f2;
        markUpdated();
    }

    public boolean setupFillPaint(Paint paint, float f2) {
        float[] fArr;
        int[] iArr;
        Paint paint2 = paint;
        float[] fArr2 = this.mBrushData;
        int i = 0;
        if (fArr2 == null || fArr2.length <= 0) {
            return false;
        }
        paint.reset();
        paint2.setFlags(1);
        paint2.setStyle(Style.FILL);
        float[] fArr3 = this.mBrushData;
        int i2 = (int) fArr3[0];
        if (i2 == 0) {
            float f3 = fArr3.length > 4 ? fArr3[4] * f2 * 255.0f : f2 * 255.0f;
            float[] fArr4 = this.mBrushData;
            paint2.setARGB((int) f3, (int) (fArr4[1] * 255.0f), (int) (fArr4[2] * 255.0f), (int) (fArr4[3] * 255.0f));
        } else if (i2 != 1) {
            FLog.w((String) "ReactNative", "ART: Color type " + i2 + " not supported!");
        } else {
            int i3 = 5;
            if (fArr3.length < 5) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("[ARTShapeShadowNode setupFillPaint] expects 5 elements, received ");
                outline73.append(this.mBrushData.length);
                FLog.w((String) "ReactNative", outline73.toString());
                return false;
            }
            float f4 = fArr3[1];
            float f5 = this.mScale;
            float f6 = f4 * f5;
            float f7 = fArr3[2] * f5;
            float f8 = fArr3[3] * f5;
            float f9 = fArr3[4] * f5;
            int length = (fArr3.length - 5) / 5;
            if (length > 0) {
                int[] iArr2 = new int[length];
                float[] fArr5 = new float[length];
                while (i < length) {
                    float[] fArr6 = this.mBrushData;
                    fArr5[i] = fArr6[GeneratedOutlineSupport.outline7(length, 4, i3, i)];
                    int i4 = (i * 4) + i3;
                    iArr2[i] = Color.argb((int) (fArr6[i4 + 3] * 255.0f), (int) (fArr6[i4 + 0] * 255.0f), (int) (fArr6[i4 + 1] * 255.0f), (int) (fArr6[i4 + 2] * 255.0f));
                    i++;
                    i3 = 5;
                }
                iArr = iArr2;
                fArr = fArr5;
            } else {
                iArr = null;
                fArr = null;
            }
            LinearGradient linearGradient = new LinearGradient(f6, f7, f8, f9, iArr, fArr, TileMode.CLAMP);
            paint2.setShader(linearGradient);
        }
        return true;
    }

    public boolean setupStrokePaint(Paint paint, float f2) {
        if (this.mStrokeWidth != 0.0f) {
            float[] fArr = this.mStrokeColor;
            if (!(fArr == null || fArr.length == 0)) {
                paint.reset();
                paint.setFlags(1);
                paint.setStyle(Style.STROKE);
                int i = this.mStrokeCap;
                if (i == 0) {
                    paint.setStrokeCap(Cap.BUTT);
                } else if (i == 1) {
                    paint.setStrokeCap(Cap.ROUND);
                } else if (i == 2) {
                    paint.setStrokeCap(Cap.SQUARE);
                } else {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("strokeCap "), this.mStrokeCap, " unrecognized"));
                }
                int i2 = this.mStrokeJoin;
                if (i2 == 0) {
                    paint.setStrokeJoin(Join.MITER);
                } else if (i2 == 1) {
                    paint.setStrokeJoin(Join.ROUND);
                } else if (i2 == 2) {
                    paint.setStrokeJoin(Join.BEVEL);
                } else {
                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("strokeJoin "), this.mStrokeJoin, " unrecognized"));
                }
                paint.setStrokeWidth(this.mStrokeWidth * this.mScale);
                float[] fArr2 = this.mStrokeColor;
                int i3 = (int) (fArr2.length > 3 ? fArr2[3] * f2 * 255.0f : f2 * 255.0f);
                float[] fArr3 = this.mStrokeColor;
                paint.setARGB(i3, (int) (fArr3[0] * 255.0f), (int) (fArr3[1] * 255.0f), (int) (fArr3[2] * 255.0f));
                float[] fArr4 = this.mStrokeDash;
                if (fArr4 != null && fArr4.length > 0) {
                    paint.setPathEffect(new DashPathEffect(this.mStrokeDash, 0.0f));
                }
                return true;
            }
        }
        return false;
    }
}
