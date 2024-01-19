package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.braintreepayments.cardform.R$string;
import com.braintreepayments.cardform.utils.CardType;

public class CvvEditText extends ErrorEditText implements TextWatcher {
    public CardType mCardType;

    public CvvEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private int getSecurityCodeLength() {
        CardType cardType = this.mCardType;
        if (cardType == null) {
            return 3;
        }
        return cardType.getSecurityCodeLength();
    }

    private void init() {
        setInputType(2);
        setFilters(new InputFilter[]{new LengthFilter(3)});
        addTextChangedListener(this);
    }

    public void afterTextChanged(Editable editable) {
        CardType cardType = this.mCardType;
        if (cardType != null && cardType.getSecurityCodeLength() == editable.length() && getSelectionStart() == editable.length()) {
            validate();
            if (isValid()) {
                focusNextView();
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public String getErrorMessage() {
        String str;
        if (this.mCardType == null) {
            str = getContext().getString(R$string.bt_cvv);
        } else {
            str = getContext().getString(this.mCardType.getSecurityCodeName());
        }
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(R$string.bt_cvv_required, new Object[]{str});
        }
        return getContext().getString(R$string.bt_cvv_invalid, new Object[]{str});
    }

    public boolean isValid() {
        return this.mOptional || getText().toString().length() == getSecurityCodeLength();
    }

    public void setCardType(CardType cardType) {
        this.mCardType = cardType;
        setFilters(new InputFilter[]{new LengthFilter(cardType.getSecurityCodeLength())});
        setContentDescription(getContext().getString(cardType.getSecurityCodeName()));
        setFieldHint(cardType.getSecurityCodeName());
        invalidate();
    }

    public void setMask(boolean z) {
        if (z) {
            setInputType(18);
        } else {
            setInputType(2);
        }
    }

    public CvvEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
