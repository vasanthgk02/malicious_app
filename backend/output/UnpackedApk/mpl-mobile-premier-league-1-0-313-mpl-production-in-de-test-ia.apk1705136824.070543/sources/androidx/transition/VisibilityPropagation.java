package androidx.transition;

public abstract class VisibilityPropagation extends TransitionPropagation {
    public static final String[] VISIBILITY_PROPAGATION_VALUES = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public static int getViewCoordinate(TransitionValues transitionValues, int i) {
        if (transitionValues == null) {
            return -1;
        }
        int[] iArr = (int[]) transitionValues.values.get("android:visibilityPropagation:center");
        if (iArr == null) {
            return -1;
        }
        return iArr[i];
    }

    public int getViewVisibility(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return 8;
        }
        Integer num = (Integer) transitionValues.values.get("android:visibilityPropagation:visibility");
        if (num == null) {
            return 8;
        }
        return num.intValue();
    }
}
