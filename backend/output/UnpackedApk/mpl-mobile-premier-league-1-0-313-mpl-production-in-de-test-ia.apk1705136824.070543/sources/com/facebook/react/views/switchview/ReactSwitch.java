package com.facebook.react.views.switchview;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.SwitchCompat;

public class ReactSwitch extends SwitchCompat {
    public boolean mAllowChange = true;
    public Integer mTrackColorForFalse = null;
    public Integer mTrackColorForTrue = null;

    public ReactSwitch(Context context) {
        super(context, null);
    }

    public void setChecked(boolean z) {
        if (!this.mAllowChange || isChecked() == z) {
            super.setChecked(isChecked());
            return;
        }
        this.mAllowChange = false;
        super.setChecked(z);
        if (this.mTrackColorForTrue != null || this.mTrackColorForFalse != null) {
            setTrackColor(z ? this.mTrackColorForTrue : this.mTrackColorForFalse);
        }
    }

    public void setOn(boolean z) {
        if (isChecked() != z) {
            super.setChecked(z);
            if (!(this.mTrackColorForTrue == null && this.mTrackColorForFalse == null)) {
                setTrackColor(z ? this.mTrackColorForTrue : this.mTrackColorForFalse);
            }
        }
        this.mAllowChange = true;
    }

    public void setThumbColor(Integer num) {
        Drawable thumbDrawable = super.getThumbDrawable();
        if (num == null) {
            thumbDrawable.clearColorFilter();
        } else {
            thumbDrawable.setColorFilter(num.intValue(), Mode.MULTIPLY);
        }
    }

    public void setTrackColor(Integer num) {
        Drawable trackDrawable = super.getTrackDrawable();
        if (num == null) {
            trackDrawable.clearColorFilter();
        } else {
            trackDrawable.setColorFilter(num.intValue(), Mode.MULTIPLY);
        }
    }
}
