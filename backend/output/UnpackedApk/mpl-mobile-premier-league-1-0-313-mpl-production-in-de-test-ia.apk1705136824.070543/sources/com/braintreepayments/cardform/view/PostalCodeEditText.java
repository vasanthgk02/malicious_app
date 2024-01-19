package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.R$string;

public class PostalCodeEditText extends ErrorEditText {
    public PostalCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setInputType(112);
        setFilters(new InputFilter[]{new LengthFilter(16)});
    }

    public String getErrorMessage() {
        return getContext().getString(R$string.bt_postal_code_required);
    }

    public boolean isValid() {
        return this.mOptional || getText().toString().length() > 0;
    }

    public PostalCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
