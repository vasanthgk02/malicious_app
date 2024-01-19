package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

public class ViewUtilsApi29 extends ViewUtilsApi23 {
    public float getTransitionAlpha(View view) {
        return view.getTransitionAlpha();
    }

    public void setAnimationMatrix(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    public void setTransitionAlpha(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    public void setTransitionVisibility(View view, int i) {
        view.setTransitionVisibility(i);
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
