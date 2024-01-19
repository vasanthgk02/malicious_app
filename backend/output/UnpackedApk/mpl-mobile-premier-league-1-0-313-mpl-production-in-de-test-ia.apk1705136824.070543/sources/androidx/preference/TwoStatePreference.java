package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public abstract class TwoStatePreference extends Preference {
    public boolean mChecked;
    public boolean mCheckedSet;
    public boolean mDisableDependentsState;
    public CharSequence mSummaryOff;
    public CharSequence mSummaryOn;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    public void setChecked(boolean z) {
        boolean z2 = this.mChecked != z;
        if (z2 || !this.mCheckedSet) {
            this.mChecked = z;
            this.mCheckedSet = true;
            if (z2) {
                shouldDisableDependents();
            }
        }
    }

    public boolean shouldDisableDependents() {
        if ((this.mDisableDependentsState ? this.mChecked : !this.mChecked) || super.shouldDisableDependents()) {
            return true;
        }
        return false;
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
