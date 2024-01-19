package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

public class GhostViewPlatform implements GhostView {
    public static Method sAddGhostMethod;
    public static boolean sAddGhostMethodFetched;
    public static Class<?> sGhostViewClass;
    public static boolean sGhostViewClassFetched;
    public static Method sRemoveGhostMethod;
    public static boolean sRemoveGhostMethodFetched;
    public final View mGhostView;

    public GhostViewPlatform(View view) {
        this.mGhostView = view;
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i) {
        this.mGhostView.setVisibility(i);
    }
}
