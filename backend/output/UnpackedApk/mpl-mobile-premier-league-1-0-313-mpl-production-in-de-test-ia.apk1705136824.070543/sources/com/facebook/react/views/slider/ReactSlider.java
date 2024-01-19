package com.facebook.react.views.slider;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;

public class ReactSlider extends AppCompatSeekBar {
    public double mMaxValue = 0.0d;
    public double mMinValue = 0.0d;
    public double mStep = 0.0d;
    public double mStepCalculated = 0.0d;
    public double mValue = 0.0d;

    public ReactSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = VERSION.SDK_INT;
        if (i2 >= 23 && i2 < 26) {
            super.setStateListAnimator(null);
        }
    }

    private double getStepValue() {
        double d2 = this.mStep;
        return d2 > 0.0d ? d2 : this.mStepCalculated;
    }

    private int getTotalSteps() {
        return (int) Math.ceil((this.mMaxValue - this.mMinValue) / getStepValue());
    }

    public void setMaxValue(double d2) {
        this.mMaxValue = d2;
        updateAll();
    }

    public void setMinValue(double d2) {
        this.mMinValue = d2;
        updateAll();
    }

    public void setStep(double d2) {
        this.mStep = d2;
        updateAll();
    }

    public void setValue(double d2) {
        this.mValue = d2;
        updateValue();
    }

    public double toRealProgress(int i) {
        if (i == getMax()) {
            return this.mMaxValue;
        }
        return (((double) i) * getStepValue()) + this.mMinValue;
    }

    public final void updateAll() {
        if (this.mStep == 0.0d) {
            this.mStepCalculated = (this.mMaxValue - this.mMinValue) / ((double) 128);
        }
        setMax(getTotalSteps());
        updateValue();
    }

    public final void updateValue() {
        double d2 = this.mValue;
        double d3 = this.mMinValue;
        setProgress((int) Math.round(((d2 - d3) / (this.mMaxValue - d3)) * ((double) getTotalSteps())));
    }
}
