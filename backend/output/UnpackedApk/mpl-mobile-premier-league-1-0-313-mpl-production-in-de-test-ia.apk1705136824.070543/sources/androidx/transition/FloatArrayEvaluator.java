package androidx.transition;

import android.animation.TypeEvaluator;
import com.android.tools.r8.GeneratedOutlineSupport;

public class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    public float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    public Object evaluate(float f2, Object obj, Object obj2) {
        float[] fArr = (float[]) obj;
        float[] fArr2 = (float[]) obj2;
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f3 = fArr[i];
            fArr3[i] = GeneratedOutlineSupport.outline3(fArr2[i], f3, f2, f3);
        }
        return fArr3;
    }
}
