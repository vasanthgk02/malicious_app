package com.braintreepayments.cardform.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import com.braintreepayments.cardform.R$drawable;
import com.braintreepayments.cardform.R$string;
import com.braintreepayments.cardform.utils.CardNumberTransformation;
import com.braintreepayments.cardform.utils.CardType;

public class CardEditText extends ErrorEditText implements TextWatcher {
    public CardType mCardType;
    public boolean mDisplayCardIcon = true;
    public boolean mMask = false;
    public OnCardTypeChangedListener mOnCardTypeChangedListener;
    public TransformationMethod mSavedTranformationMethod;

    public interface OnCardTypeChangedListener {
        void onCardTypeChanged(CardType cardType);
    }

    public CardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setInputType(2);
        setCardIcon(R$drawable.bt_ic_unknown);
        addTextChangedListener(this);
        updateCardType();
        this.mSavedTranformationMethod = getTransformationMethod();
    }

    private void setCardIcon(int i) {
        if (!this.mDisplayCardIcon || getText().length() == 0) {
            setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void afterTextChanged(Editable editable) {
        for (Object removeSpan : editable.getSpans(0, editable.length(), SpaceSpan.class)) {
            editable.removeSpan(removeSpan);
        }
        updateCardType();
        setCardIcon(this.mCardType.getFrontResource());
        int[] spaceIndices = this.mCardType.getSpaceIndices();
        int length = editable.length();
        for (int i : spaceIndices) {
            if (i <= length) {
                editable.setSpan(new SpaceSpan(), i - 1, i, 33);
            }
        }
        if (this.mCardType.getMaxCardLength() == getSelectionStart()) {
            validate();
            if (isValid()) {
                focusNextView();
                return;
            }
            TransformationMethod transformationMethod = getTransformationMethod();
            TransformationMethod transformationMethod2 = this.mSavedTranformationMethod;
            if (transformationMethod != transformationMethod2) {
                setTransformationMethod(transformationMethod2);
            }
        } else if (!hasFocus() && this.mMask) {
            maskNumber();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void displayCardTypeIcon(boolean z) {
        this.mDisplayCardIcon = z;
        if (!z) {
            setCardIcon(-1);
        }
    }

    public CardType getCardType() {
        return this.mCardType;
    }

    public String getErrorMessage() {
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(R$string.bt_card_number_required);
        }
        return getContext().getString(R$string.bt_card_number_invalid);
    }

    public boolean isValid() {
        return this.mOptional || this.mCardType.validate(getText().toString());
    }

    public final void maskNumber() {
        if (!(getTransformationMethod() instanceof CardNumberTransformation)) {
            this.mSavedTranformationMethod = getTransformationMethod();
            setTransformationMethod(new CardNumberTransformation());
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            TransformationMethod transformationMethod = getTransformationMethod();
            TransformationMethod transformationMethod2 = this.mSavedTranformationMethod;
            if (transformationMethod != transformationMethod2) {
                setTransformationMethod(transformationMethod2);
            }
            if (getText().toString().length() > 0) {
                setSelection(getText().toString().length());
            }
        } else if (this.mMask && isValid()) {
            maskNumber();
        }
    }

    public void setMask(boolean z) {
        this.mMask = z;
    }

    public void setOnCardTypeChangedListener(OnCardTypeChangedListener onCardTypeChangedListener) {
        this.mOnCardTypeChangedListener = onCardTypeChangedListener;
    }

    public final void updateCardType() {
        CardType forCardNumber = CardType.forCardNumber(getText().toString());
        if (this.mCardType != forCardNumber) {
            this.mCardType = forCardNumber;
            setFilters(new InputFilter[]{new LengthFilter(this.mCardType.getMaxCardLength())});
            invalidate();
            OnCardTypeChangedListener onCardTypeChangedListener = this.mOnCardTypeChangedListener;
            if (onCardTypeChangedListener != null) {
                onCardTypeChangedListener.onCardTypeChanged(this.mCardType);
            }
        }
    }

    public CardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setInputType(2);
        setCardIcon(R$drawable.bt_ic_unknown);
        addTextChangedListener(this);
        updateCardType();
        this.mSavedTranformationMethod = getTransformationMethod();
    }
}
