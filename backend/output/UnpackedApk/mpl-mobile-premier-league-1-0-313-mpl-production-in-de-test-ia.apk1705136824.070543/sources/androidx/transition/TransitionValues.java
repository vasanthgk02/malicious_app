package androidx.transition;

import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            if (this.view == transitionValues.view && this.values.equals(transitionValues.values)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TransitionValues@");
        outline73.append(Integer.toHexString(hashCode()));
        outline73.append(":\n");
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(outline73.toString(), "    view = ");
        outline78.append(this.view);
        outline78.append("\n");
        String outline50 = GeneratedOutlineSupport.outline50(outline78.toString(), "    values:");
        for (String next : this.values.keySet()) {
            StringBuilder outline81 = GeneratedOutlineSupport.outline81(outline50, "    ", next, ": ");
            outline81.append(this.values.get(next));
            outline81.append("\n");
            outline50 = outline81.toString();
        }
        return outline50;
    }

    public TransitionValues(View view2) {
        this.view = view2;
    }
}
