package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.Field;

public class ViewUtilsBase {
    public static Field sViewFlagsField;
    public static boolean sViewFlagsFieldFetched;

    public abstract void clearNonTransitionAlpha(View view);

    public abstract float getTransitionAlpha(View view);

    public abstract void saveNonTransitionAlpha(View view);

    public abstract void setAnimationMatrix(View view, Matrix matrix);

    public abstract void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4);

    public abstract void setTransitionAlpha(View view, float f2);

    public void setTransitionVisibility(View view, int i) {
        if (!sViewFlagsFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sViewFlagsFieldFetched = true;
        }
        Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void transformMatrixToGlobal(View view, Matrix matrix);

    public abstract void transformMatrixToLocal(View view, Matrix matrix);
}
