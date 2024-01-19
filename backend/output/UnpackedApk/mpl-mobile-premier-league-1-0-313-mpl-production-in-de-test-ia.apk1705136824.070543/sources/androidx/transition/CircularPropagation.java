package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class CircularPropagation extends VisibilityPropagation {
    public float mPropagationSpeed = 3.0f;

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int i2;
        int i3;
        if (transitionValues == null && transitionValues2 == null) {
            return 0;
        }
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i = -1;
        } else {
            transitionValues = transitionValues2;
            i = 1;
        }
        int viewCoordinate = VisibilityPropagation.getViewCoordinate(transitionValues, 0);
        int viewCoordinate2 = VisibilityPropagation.getViewCoordinate(transitionValues, 1);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i3 = epicenter.centerX();
            i2 = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(viewGroup.getTranslationX() + ((float) ((viewGroup.getWidth() / 2) + iArr[0])));
            int i4 = iArr[1];
            int i5 = round;
            i2 = Math.round(viewGroup.getTranslationY() + ((float) ((viewGroup.getHeight() / 2) + i4)));
            i3 = i5;
        }
        float f2 = ((float) i3) - ((float) viewCoordinate);
        float f3 = ((float) i2) - ((float) viewCoordinate2);
        float sqrt = (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
        float width = ((float) viewGroup.getWidth()) - 0.0f;
        float height = ((float) viewGroup.getHeight()) - 0.0f;
        float sqrt2 = sqrt / ((float) Math.sqrt((double) ((height * height) + (width * width))));
        long j = transition.mDuration;
        if (j < 0) {
            j = 300;
        }
        return (long) Math.round((((float) (j * ((long) i))) / this.mPropagationSpeed) * sqrt2);
    }
}
