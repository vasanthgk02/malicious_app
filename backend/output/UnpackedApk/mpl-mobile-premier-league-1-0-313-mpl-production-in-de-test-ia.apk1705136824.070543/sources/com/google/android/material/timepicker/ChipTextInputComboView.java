package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

public class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip chip;
    public final EditText editText;
    public TextView label;
    public final TextInputLayout textInputLayout;
    public TextWatcher watcher;

    public class TextFormatter extends TextWatcherAdapter {
        public TextFormatter(AnonymousClass1 r2) {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.chip.setText(ChipTextInputComboView.access$100(chipTextInputComboView, "00"));
                return;
            }
            ChipTextInputComboView chipTextInputComboView2 = ChipTextInputComboView.this;
            chipTextInputComboView2.chip.setText(ChipTextInputComboView.access$100(chipTextInputComboView2, editable));
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static String access$100(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        return String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
    }

    public boolean isChecked() {
        return this.chip.isChecked();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateHintLocales();
    }

    public void setChecked(boolean z) {
        this.chip.setChecked(z);
        int i = 0;
        this.editText.setVisibility(z ? 0 : 4);
        Chip chip2 = this.chip;
        if (z) {
            i = 8;
        }
        chip2.setVisibility(i);
        if (isChecked()) {
            this.editText.requestFocus();
            if (!TextUtils.isEmpty(this.editText.getText())) {
                EditText editText2 = this.editText;
                editText2.setSelection(editText2.getText().length());
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.chip.setOnClickListener(onClickListener);
    }

    public void setTag(int i, Object obj) {
        this.chip.setTag(i, obj);
    }

    public void toggle() {
        this.chip.toggle();
    }

    public final void updateHintLocales() {
        if (VERSION.SDK_INT >= 24) {
            this.editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater from = LayoutInflater.from(context);
        this.chip = (Chip) from.inflate(R$layout.material_time_chip, this, false);
        TextInputLayout textInputLayout2 = (TextInputLayout) from.inflate(R$layout.material_time_input, this, false);
        this.textInputLayout = textInputLayout2;
        EditText editText2 = textInputLayout2.getEditText();
        this.editText = editText2;
        editText2.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter(null);
        this.watcher = textFormatter;
        this.editText.addTextChangedListener(textFormatter);
        updateHintLocales();
        addView(this.chip);
        addView(this.textInputLayout);
        this.label = (TextView) findViewById(R$id.material_label);
        this.editText.setSaveEnabled(false);
    }
}
