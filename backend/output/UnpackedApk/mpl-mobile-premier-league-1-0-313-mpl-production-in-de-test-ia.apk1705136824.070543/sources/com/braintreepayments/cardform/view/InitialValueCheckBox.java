package com.braintreepayments.cardform.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;

public class InitialValueCheckBox extends AppCompatCheckBox {
    public boolean mRestored;

    public InitialValueCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("com.braintreepayments.cardform.view.InitialValueCheckBox.EXTRA_SUPER_STATE"));
        setChecked(bundle.getBoolean("com.braintreepayments.cardform.view.InitialValueCheckBox.EXTRA_CHECKED_VALUE"));
        this.mRestored = true;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.braintreepayments.cardform.view.InitialValueCheckBox.EXTRA_SUPER_STATE", onSaveInstanceState);
        bundle.putBoolean("com.braintreepayments.cardform.view.InitialValueCheckBox.EXTRA_CHECKED_VALUE", isChecked());
        return bundle;
    }

    public void setInitiallyChecked(boolean z) {
        if (!this.mRestored) {
            setChecked(z);
        }
    }

    public InitialValueCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
