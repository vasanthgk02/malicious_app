package androidx.preference;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckBoxPreference extends TwoStatePreference {
    public final Listener mListener;

    public class Listener implements OnCheckedChangeListener {
        public Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (CheckBoxPreference.this != null) {
                CheckBoxPreference.this.setChecked(z);
                return;
            }
            throw null;
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CheckBoxPreference, i, 0);
        this.mSummaryOn = b.getString(obtainStyledAttributes, R$styleable.CheckBoxPreference_summaryOn, R$styleable.CheckBoxPreference_android_summaryOn);
        int i2 = R$styleable.CheckBoxPreference_summaryOff;
        int i3 = R$styleable.CheckBoxPreference_android_summaryOff;
        this.mSummaryOff = obtainStyledAttributes.getString(i2) == null ? obtainStyledAttributes.getString(i3) : obtainStyledAttributes.getString(i2);
        this.mDisableDependentsState = obtainStyledAttributes.getBoolean(R$styleable.CheckBoxPreference_disableDependentsState, obtainStyledAttributes.getBoolean(R$styleable.CheckBoxPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.getAttr(context, R$attr.checkBoxPreferenceStyle, 16842895));
    }
}
