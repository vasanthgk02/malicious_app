package androidx.preference;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

public abstract class PreferenceGroup extends Preference {
    public final SimpleArrayMap<String, Long> mIdRecycleCache;
    public final List<Preference> mPreferences;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIdRecycleCache = new SimpleArrayMap<>();
        new Handler(Looper.getMainLooper());
        this.mPreferences = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PreferenceGroup, i, i2);
        int i3 = R$styleable.PreferenceGroup_orderingFromXml;
        b.getBoolean(obtainStyledAttributes, i3, i3, true);
        if (obtainStyledAttributes.hasValue(R$styleable.PreferenceGroup_initialExpandedChildrenCount)) {
            int i4 = R$styleable.PreferenceGroup_initialExpandedChildrenCount;
            if (obtainStyledAttributes.getInt(i4, obtainStyledAttributes.getInt(i4, Integer.MAX_VALUE)) != Integer.MAX_VALUE && !(!TextUtils.isEmpty(this.mKey))) {
                getClass().getSimpleName();
            }
        }
        obtainStyledAttributes.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
