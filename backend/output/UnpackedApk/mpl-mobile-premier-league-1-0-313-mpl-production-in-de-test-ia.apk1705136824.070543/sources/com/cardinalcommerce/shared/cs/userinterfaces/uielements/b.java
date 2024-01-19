package com.cardinalcommerce.shared.cs.userinterfaces.uielements;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView.BufferType;
import com.cardinalcommerce.cardinalmobilesdk.R$drawable;

public class b extends CompoundButton {
    public b(Context context) {
        super(context);
        super.setPadding(20, 4, 28, 4);
        setCCAButtonDrawable(R$drawable.ic_radio_button_unchecked);
        setCCAMarginsBetweenBoxes(this);
    }

    private void setCCAMarginsBetweenBoxes(b bVar) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(8, 8, 8, 16);
        bVar.setLayoutParams(layoutParams);
    }

    public CharSequence getCCAText() {
        return super.getText();
    }

    public CharSequence getText() {
        return "*";
    }

    public void setButtonDrawable(int i) {
    }

    public void setCCAButtonDrawable(int i) {
        super.setButtonDrawable(i);
    }

    public void setCCAText(CharSequence charSequence) {
        super.setText(charSequence, BufferType.EDITABLE);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
    }
}
