package com.cardinalcommerce.shared.cs.userinterfaces.uielements;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView.BufferType;

@SuppressLint({"AppCompatCustomView"})
public class CCAButton extends Button {
    public CCAButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CCAButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CharSequence getCCAText() {
        return super.getText();
    }

    public CharSequence getText() {
        return "*";
    }

    public void setCCAOnClickListener(c$a c_a) {
        super.setOnClickListener(c_a);
    }

    public void setCCAOnFocusChangeListener(c$b c_b) {
        super.setOnFocusChangeListener(c_b);
    }

    public void setCCAOnTouchListener(c$d c_d) {
        super.setOnTouchListener(c_d);
    }

    public void setCCAText(CharSequence charSequence) {
        super.setText(charSequence, BufferType.EDITABLE);
    }

    public void setCCAVisibility(int i) {
        super.setVisibility(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
    }

    public void setVisibility(int i) {
    }
}
