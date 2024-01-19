package androidx.preference;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference.SummaryProvider;

public class EditTextPreference extends DialogPreference {

    public static final class SimpleSummaryProvider implements SummaryProvider<EditTextPreference> {
        public static SimpleSummaryProvider sSimpleSummaryProvider;

        public CharSequence provideSummary(Preference preference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            if (TextUtils.isEmpty(null)) {
                return editTextPreference.mContext.getString(R$string.not_set);
            }
            return null;
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EditTextPreference, i, 0);
        int i2 = R$styleable.EditTextPreference_useSimpleSummaryProvider;
        if (b.getBoolean(obtainStyledAttributes, i2, i2, false)) {
            if (SimpleSummaryProvider.sSimpleSummaryProvider == null) {
                SimpleSummaryProvider.sSimpleSummaryProvider = new SimpleSummaryProvider();
            }
            this.mSummaryProvider = SimpleSummaryProvider.sSimpleSummaryProvider;
        }
        obtainStyledAttributes.recycle();
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.getAttr(context, R$attr.editTextPreferenceStyle, 16842898));
    }
}
