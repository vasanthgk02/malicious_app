package com.braintreepayments.cardform.view;

import android.content.Context;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.R$string;

public class MobileNumberEditText extends ErrorEditText {
    public MobileNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setInputType(3);
            setFilters(new InputFilter[]{new LengthFilter(14)});
            addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        }
    }

    public String getErrorMessage() {
        return getContext().getString(R$string.bt_mobile_number_required);
    }

    public String getMobileNumber() {
        return PhoneNumberUtils.stripSeparators(getText().toString());
    }

    public boolean isValid() {
        return this.mOptional || getText().toString().length() >= 8;
    }

    public MobileNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
