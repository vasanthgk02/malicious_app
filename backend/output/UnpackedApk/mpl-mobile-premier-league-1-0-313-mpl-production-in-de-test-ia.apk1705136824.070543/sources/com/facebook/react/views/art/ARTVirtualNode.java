package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

public abstract class ARTVirtualNode extends ReactShadowNodeImpl {
    public static final float[] sMatrixData = new float[9];
    public static final float[] sRawMatrix = new float[9];
    public Matrix mMatrix = new Matrix();
    public float mOpacity = 1.0f;
    public final float mScale = ImageOriginUtils.sWindowDisplayMetrics.density;

    public abstract void draw(Canvas canvas, Paint paint, float f2);

    public boolean isVirtual() {
        return true;
    }

    public final void saveAndSetupCanvas(Canvas canvas) {
        canvas.save();
        Matrix matrix = this.mMatrix;
        if (matrix != null) {
            canvas.concat(matrix);
        }
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(float f2) {
        this.mOpacity = f2;
        markUpdated();
    }

    @ReactProp(name = "transform")
    public void setTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int floatArray = ImageOriginUtils.toFloatArray(readableArray, sMatrixData);
            if (floatArray == 6) {
                float[] fArr = sRawMatrix;
                float[] fArr2 = sMatrixData;
                fArr[0] = fArr2[0];
                fArr[1] = fArr2[2];
                float f2 = fArr2[4];
                float f3 = this.mScale;
                fArr[2] = f2 * f3;
                fArr[3] = fArr2[1];
                fArr[4] = fArr2[3];
                fArr[5] = fArr2[5] * f3;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
                fArr[8] = 1.0f;
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                }
                this.mMatrix.setValues(sRawMatrix);
            } else if (floatArray != -1) {
                throw new JSApplicationIllegalArgumentException("Transform matrices must be of size 6");
            }
        } else {
            this.mMatrix = null;
        }
        markUpdated();
    }
}
