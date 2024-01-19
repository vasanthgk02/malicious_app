package androidx.preference;

import a.a.a.a.d.b;
import android.content.Context;
import android.util.AttributeSet;

public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
    }

    public boolean isEnabled() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.getAttr(context, R$attr.preferenceCategoryStyle, 16842892));
    }
}
