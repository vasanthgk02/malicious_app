package com.reactnativecommunity.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.material.resources.TextAppearanceConfig;

public class ARTGroupShadowNode extends ARTVirtualNode {
    public RectF mClipping;

    public void draw(Canvas canvas, Paint paint, float f2) {
        float f3 = f2 * this.mOpacity;
        if (f3 > 0.01f) {
            saveAndSetupCanvas(canvas);
            RectF rectF = this.mClipping;
            if (rectF != null) {
                float f4 = rectF.left;
                float f5 = this.mScale;
                canvas.clipRect(f4 * f5, rectF.top * f5, rectF.right * f5, rectF.bottom * f5, Op.REPLACE);
            }
            for (int i = 0; i < getChildCount(); i++) {
                ARTVirtualNode aRTVirtualNode = (ARTVirtualNode) getChildAt(i);
                aRTVirtualNode.draw(canvas, paint, f3);
                aRTVirtualNode.markUpdateSeen();
            }
            canvas.restore();
        }
    }

    public boolean isVirtual() {
        return true;
    }

    @ReactProp(name = "clipping")
    public void setClipping(ReadableArray readableArray) {
        float[] floatArray = TextAppearanceConfig.toFloatArray(readableArray);
        if (floatArray == null) {
            return;
        }
        if (floatArray.length == 4) {
            this.mClipping = new RectF(floatArray[0], floatArray[1], floatArray[0] + floatArray[2], floatArray[1] + floatArray[3]);
            markUpdated();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Clipping should be array of length 4 (e.g. [x, y, width, height])");
    }
}
