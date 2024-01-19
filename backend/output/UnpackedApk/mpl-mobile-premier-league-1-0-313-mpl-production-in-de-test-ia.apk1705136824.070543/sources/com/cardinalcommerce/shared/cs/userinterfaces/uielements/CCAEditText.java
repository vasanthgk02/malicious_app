package com.cardinalcommerce.shared.cs.userinterfaces.uielements;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import android.view.ViewDebug.ExportedProperty;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

@SuppressLint({"AppCompatCustomView"})
public class CCAEditText extends TextView {
    public CCAEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImeOptions(ClientDefaults.MAX_MSG_SIZE);
        setCursorVisible(true);
        setSingleLine();
        setGravity(17);
    }

    public CCAEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
    }

    public CharSequence getCCAText() {
        return super.getText();
    }

    @ExportedProperty(category = "text")
    public int getSelectionEnd() {
        return getText().toString().length();
    }

    @ExportedProperty(category = "text")
    public int getSelectionStart() {
        return getText().toString().length();
    }

    public Editable getText() {
        CharSequence text = super.getText();
        if (text == null) {
            return null;
        }
        setCursorVisible(true);
        setTextIsSelectable(true);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < text.length(); i++) {
            spannableStringBuilder.append('*');
        }
        return spannableStringBuilder;
    }

    public void setCCAFocusableInTouchMode(boolean z) {
        super.setFocusableInTouchMode(z);
    }

    public void setCCAOnFocusChangeListener(c$b c_b) {
        super.setOnFocusChangeListener(c_b);
    }

    public void setCCAText(CharSequence charSequence) {
        super.setText(charSequence, BufferType.EDITABLE);
    }

    public void setFocusableInTouchMode(boolean z) {
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText("", bufferType);
    }
}
