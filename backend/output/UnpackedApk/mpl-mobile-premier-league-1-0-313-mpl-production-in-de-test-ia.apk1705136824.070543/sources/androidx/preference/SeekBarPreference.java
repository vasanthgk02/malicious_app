package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class SeekBarPreference extends Preference {
    public boolean mAdjustable;
    public int mMax;
    public int mMin;
    public int mSeekBarIncrement;
    public boolean mUpdatesContinuously;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SeekBarPreference, i, 0);
        this.mMin = obtainStyledAttributes.getInt(R$styleable.SeekBarPreference_min, 0);
        int i2 = obtainStyledAttributes.getInt(R$styleable.SeekBarPreference_android_max, 100);
        int i3 = this.mMin;
        i2 = i2 < i3 ? i3 : i2;
        if (i2 != this.mMax) {
            this.mMax = i2;
        }
        int i4 = obtainStyledAttributes.getInt(R$styleable.SeekBarPreference_seekBarIncrement, 0);
        if (i4 != this.mSeekBarIncrement) {
            this.mSeekBarIncrement = Math.min(this.mMax - this.mMin, Math.abs(i4));
        }
        this.mAdjustable = obtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_adjustable, true);
        obtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_showSeekBarValue, false);
        this.mUpdatesContinuously = obtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_updatesContinuously, false);
        obtainStyledAttributes.recycle();
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarPreferenceStyle);
    }
}
