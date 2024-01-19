package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

public class DropDownPreference extends ListPreference {
    public final ArrayAdapter mAdapter;
    public final Context mContext;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.dropdownPreferenceStyle);
    }

    public void notifyChanged() {
        ArrayAdapter arrayAdapter = this.mAdapter;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.mContext = context;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.mContext, 17367049);
        this.mAdapter = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.mEntries;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                this.mAdapter.add(charSequence.toString());
            }
        }
    }
}
