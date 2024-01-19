package com.reactnativecommunity.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTTextShadowNode extends ARTShapeShadowNode {
    public ReadableMap mFrame;
    public int mTextAlignment = 0;

    public final void applyTextPropertiesToPaint(Paint paint) {
        int i = this.mTextAlignment;
        int i2 = 2;
        if (i == 0) {
            paint.setTextAlign(Align.LEFT);
        } else if (i == 1) {
            paint.setTextAlign(Align.RIGHT);
        } else if (i == 2) {
            paint.setTextAlign(Align.CENTER);
        }
        ReadableMap readableMap = this.mFrame;
        if (readableMap != null && readableMap.hasKey("font")) {
            ReadableMap map = this.mFrame.getMap("font");
            if (map != null) {
                float f2 = 12.0f;
                if (map.hasKey("fontSize")) {
                    f2 = (float) map.getDouble("fontSize");
                }
                paint.setTextSize(f2 * this.mScale);
                boolean z = map.hasKey("fontWeight") && "bold".equals(map.getString("fontWeight"));
                boolean z2 = map.hasKey("fontStyle") && "italic".equals(map.getString("fontStyle"));
                if (z && z2) {
                    i2 = 3;
                } else if (z) {
                    i2 = 1;
                } else if (!z2) {
                    i2 = 0;
                }
                paint.setTypeface(Typeface.create(map.getString("fontFamily"), i2));
            }
        }
    }

    public void draw(Canvas canvas, Paint paint, float f2) {
        ReadableMap readableMap = this.mFrame;
        if (readableMap != null) {
            float f3 = f2 * this.mOpacity;
            if (f3 > 0.01f && readableMap.hasKey("lines")) {
                ReadableArray array = this.mFrame.getArray("lines");
                if (!(array == null || array.size() == 0)) {
                    saveAndSetupCanvas(canvas);
                    int size = array.size();
                    String[] strArr = new String[size];
                    for (int i = 0; i < size; i++) {
                        strArr[i] = array.getString(i);
                    }
                    String join = TextUtils.join("\n", strArr);
                    if (setupStrokePaint(paint)) {
                        applyTextPropertiesToPaint(paint);
                        Path path = this.mPath;
                        if (path == null) {
                            canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                        } else {
                            canvas.drawTextOnPath(join, path, 0.0f, 0.0f, paint);
                        }
                    }
                    if (setupFillPaint(paint, f3)) {
                        applyTextPropertiesToPaint(paint);
                        Path path2 = this.mPath;
                        if (path2 == null) {
                            canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                        } else {
                            canvas.drawTextOnPath(join, path2, 0.0f, 0.0f, paint);
                        }
                    }
                    if (this.mShadowOpacity > 0.0f) {
                        paint.setShadowLayer(this.mShadowRadius, this.mShadowOffsetX, this.mShadowOffsetY, this.mShadowColor);
                    }
                    canvas.restore();
                    markUpdateSeen();
                }
            }
        }
    }

    @ReactProp(defaultInt = 0, name = "alignment")
    public void setAlignment(int i) {
        this.mTextAlignment = i;
    }

    @ReactProp(name = "frame")
    public void setFrame(ReadableMap readableMap) {
        this.mFrame = readableMap;
    }
}
