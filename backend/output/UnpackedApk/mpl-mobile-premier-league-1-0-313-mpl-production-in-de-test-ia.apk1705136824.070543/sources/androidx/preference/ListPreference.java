package androidx.preference;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference.SummaryProvider;

public class ListPreference extends DialogPreference {
    public CharSequence[] mEntries;
    public CharSequence[] mEntryValues;
    public String mSummary;
    public String mValue;

    public static final class SimpleSummaryProvider implements SummaryProvider<ListPreference> {
        public static SimpleSummaryProvider sSimpleSummaryProvider;

        public CharSequence provideSummary(Preference preference) {
            ListPreference listPreference = (ListPreference) preference;
            if (TextUtils.isEmpty(listPreference.getEntry())) {
                return listPreference.mContext.getString(R$string.not_set);
            }
            return listPreference.getEntry();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPreference, i, i2);
        this.mEntries = b.getTextArray(obtainStyledAttributes, R$styleable.ListPreference_entries, R$styleable.ListPreference_android_entries);
        int i3 = R$styleable.ListPreference_entryValues;
        int i4 = R$styleable.ListPreference_android_entryValues;
        this.mEntryValues = obtainStyledAttributes.getTextArray(i3) == null ? obtainStyledAttributes.getTextArray(i4) : obtainStyledAttributes.getTextArray(i3);
        int i5 = R$styleable.ListPreference_useSimpleSummaryProvider;
        if (obtainStyledAttributes.getBoolean(i5, obtainStyledAttributes.getBoolean(i5, false))) {
            if (SimpleSummaryProvider.sSimpleSummaryProvider == null) {
                SimpleSummaryProvider.sSimpleSummaryProvider = new SimpleSummaryProvider();
            }
            this.mSummaryProvider = SimpleSummaryProvider.sSimpleSummaryProvider;
            notifyChanged();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.Preference, i, i2);
        this.mSummary = b.getString(obtainStyledAttributes2, R$styleable.Preference_summary, R$styleable.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    public CharSequence getEntry() {
        String str = this.mValue;
        int i = -1;
        if (str != null) {
            CharSequence[] charSequenceArr = this.mEntryValues;
            if (charSequenceArr != null) {
                int length = charSequenceArr.length - 1;
                while (true) {
                    if (length < 0) {
                        break;
                    } else if (TextUtils.equals(this.mEntryValues[length].toString(), str)) {
                        i = length;
                        break;
                    } else {
                        length--;
                    }
                }
            }
        }
        if (i >= 0) {
            CharSequence[] charSequenceArr2 = this.mEntries;
            if (charSequenceArr2 != null) {
                return charSequenceArr2[i];
            }
        }
        return null;
    }

    public CharSequence getSummary() {
        SummaryProvider summaryProvider = this.mSummaryProvider;
        if (summaryProvider != null) {
            return summaryProvider.provideSummary(this);
        }
        Object entry = getEntry();
        CharSequence summary = super.getSummary();
        String str = this.mSummary;
        if (str == null) {
            return summary;
        }
        Object[] objArr = new Object[1];
        if (entry == null) {
            entry = "";
        }
        objArr[0] = entry;
        String format = String.format(str, objArr);
        return TextUtils.equals(format, summary) ? summary : format;
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.getAttr(context, R$attr.dialogPreferenceStyle, 16842897));
    }
}
