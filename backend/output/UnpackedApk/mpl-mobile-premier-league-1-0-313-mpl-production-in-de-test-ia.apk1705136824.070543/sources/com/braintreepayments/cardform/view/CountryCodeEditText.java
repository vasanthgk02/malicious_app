package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.R$string;

public class CountryCodeEditText extends ErrorEditText {
    public CountryCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setInputType(3);
        setFilters(new InputFilter[]{new LengthFilter(4)});
    }

    public String getCountryCode() {
        return getText().toString().replaceAll("[^\\d]", "");
    }

    public String getErrorMessage() {
        return getContext().getString(R$string.bt_country_code_required);
    }

    public boolean isValid() {
        return this.mOptional || getText().toString().length() > 0;
    }

    public CountryCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
