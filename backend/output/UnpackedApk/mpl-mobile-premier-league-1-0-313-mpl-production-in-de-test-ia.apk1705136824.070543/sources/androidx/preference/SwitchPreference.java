package androidx.preference;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class SwitchPreference extends TwoStatePreference {
    public final Listener mListener;
    public CharSequence mSwitchOff;
    public CharSequence mSwitchOn;

    public class Listener implements OnCheckedChangeListener {
        public Listener() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreference.this != null) {
                SwitchPreference.this.setChecked(z);
                return;
            }
            throw null;
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SwitchPreference, i, 0);
        this.mSummaryOn = b.getString(obtainStyledAttributes, R$styleable.SwitchPreference_summaryOn, R$styleable.SwitchPreference_android_summaryOn);
        this.mSummaryOff = obtainStyledAttributes.getString(R$styleable.SwitchPreference_summaryOff) == null ? obtainStyledAttributes.getString(R$styleable.SwitchPreference_android_summaryOff) : obtainStyledAttributes.getString(R$styleable.SwitchPreference_summaryOff);
        this.mSwitchOn = obtainStyledAttributes.getString(R$styleable.SwitchPreference_switchTextOn) == null ? obtainStyledAttributes.getString(R$styleable.SwitchPreference_android_switchTextOn) : obtainStyledAttributes.getString(R$styleable.SwitchPreference_switchTextOn);
        int i2 = R$styleable.SwitchPreference_switchTextOff;
        int i3 = R$styleable.SwitchPreference_android_switchTextOff;
        this.mSwitchOff = obtainStyledAttributes.getString(i2) == null ? obtainStyledAttributes.getString(i3) : obtainStyledAttributes.getString(i2);
        this.mDisableDependentsState = obtainStyledAttributes.getBoolean(R$styleable.SwitchPreference_disableDependentsState, obtainStyledAttributes.getBoolean(R$styleable.SwitchPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.getAttr(context, R$attr.switchPreferenceStyle, 16843629));
    }
}
