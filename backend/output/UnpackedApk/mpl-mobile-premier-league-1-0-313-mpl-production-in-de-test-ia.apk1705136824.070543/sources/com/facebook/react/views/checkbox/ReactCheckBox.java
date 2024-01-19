package com.facebook.react.views.checkbox;

import android.content.Context;
import androidx.appcompat.widget.AppCompatCheckBox;

public class ReactCheckBox extends AppCompatCheckBox {
    public boolean mAllowChange = true;

    public ReactCheckBox(Context context) {
        super(context, null);
    }

    public void setChecked(boolean z) {
        if (this.mAllowChange) {
            this.mAllowChange = false;
            super.setChecked(z);
        }
    }

    public void setOn(boolean z) {
        if (isChecked() != z) {
            super.setChecked(z);
        }
        this.mAllowChange = true;
    }
}
