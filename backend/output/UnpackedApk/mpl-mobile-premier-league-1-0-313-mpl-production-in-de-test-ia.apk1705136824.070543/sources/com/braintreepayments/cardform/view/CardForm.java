package com.braintreepayments.cardform.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;
import com.braintreepayments.api.dropin.view.AddCardView;
import com.braintreepayments.api.dropin.view.EditCardView;
import com.braintreepayments.cardform.CardScanningFragment;
import com.braintreepayments.cardform.OnCardFormFieldFocusedListener;
import com.braintreepayments.cardform.OnCardFormSubmitListener;
import com.braintreepayments.cardform.OnCardFormValidListener;
import com.braintreepayments.cardform.R$drawable;
import com.braintreepayments.cardform.R$id;
import com.braintreepayments.cardform.R$layout;
import com.braintreepayments.cardform.utils.CardType;
import com.braintreepayments.cardform.view.CardEditText.OnCardTypeChangedListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;
import java.util.ArrayList;
import java.util.List;

public class CardForm extends LinearLayout implements OnCardTypeChangedListener, OnFocusChangeListener, OnClickListener, OnEditorActionListener, TextWatcher {
    public CardEditText mCardNumber;
    public ImageView mCardNumberIcon;
    public boolean mCardNumberRequired;
    public CardScanningFragment mCardScanningFragment;
    public CardholderNameEditText mCardholderName;
    public ImageView mCardholderNameIcon;
    public int mCardholderNameStatus = 0;
    public CountryCodeEditText mCountryCode;
    public CvvEditText mCvv;
    public boolean mCvvRequired;
    public ExpirationDateEditText mExpiration;
    public boolean mExpirationRequired;
    public MobileNumberEditText mMobileNumber;
    public TextView mMobileNumberExplanation;
    public ImageView mMobileNumberIcon;
    public boolean mMobileNumberRequired;
    public OnCardFormFieldFocusedListener mOnCardFormFieldFocusedListener;
    public OnCardFormSubmitListener mOnCardFormSubmitListener;
    public OnCardFormValidListener mOnCardFormValidListener;
    public OnCardTypeChangedListener mOnCardTypeChangedListener;
    public PostalCodeEditText mPostalCode;
    public ImageView mPostalCodeIcon;
    public boolean mPostalCodeRequired;
    public InitialValueCheckBox mSaveCardCheckBox;
    public boolean mSaveCardCheckBoxChecked;
    public boolean mSaveCardCheckBoxVisible;
    public boolean mValid = false;
    public List<ErrorEditText> mVisibleEditTexts;

    public CardForm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void setListeners(EditText editText) {
        editText.setOnFocusChangeListener(this);
        editText.setOnClickListener(this);
        editText.addTextChangedListener(this);
    }

    public void afterTextChanged(Editable editable) {
        boolean isValid = isValid();
        if (this.mValid != isValid) {
            this.mValid = isValid;
            OnCardFormValidListener onCardFormValidListener = this.mOnCardFormValidListener;
            if (onCardFormValidListener != null) {
                AddCardView addCardView = (AddCardView) onCardFormValidListener;
                if (addCardView.isValid()) {
                    addCardView.mAnimatedButtonView.showLoading();
                    addCardView.callAddPaymentUpdateListener();
                }
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CardEditText getCardEditText() {
        return this.mCardNumber;
    }

    public String getCardNumber() {
        return this.mCardNumber.getText().toString();
    }

    public String getCardholderName() {
        return this.mCardholderName.getText().toString();
    }

    public CardholderNameEditText getCardholderNameEditText() {
        return this.mCardholderName;
    }

    public String getCountryCode() {
        return this.mCountryCode.getCountryCode();
    }

    public CountryCodeEditText getCountryCodeEditText() {
        return this.mCountryCode;
    }

    public String getCvv() {
        return this.mCvv.getText().toString();
    }

    public CvvEditText getCvvEditText() {
        return this.mCvv;
    }

    public ExpirationDateEditText getExpirationDateEditText() {
        return this.mExpiration;
    }

    public String getExpirationMonth() {
        return this.mExpiration.getMonth();
    }

    public String getExpirationYear() {
        return this.mExpiration.getYear();
    }

    public String getMobileNumber() {
        return this.mMobileNumber.getMobileNumber();
    }

    public MobileNumberEditText getMobileNumberEditText() {
        return this.mMobileNumber;
    }

    public String getPostalCode() {
        return this.mPostalCode.getText().toString();
    }

    public PostalCodeEditText getPostalCodeEditText() {
        return this.mPostalCode;
    }

    @SuppressLint({"DefaultLocale"})
    public void handleCardIOResponse(int i, Intent intent) {
        if (i == 0 || i == -1) {
            this.mCardScanningFragment = null;
        }
        if (intent != null && intent.hasExtra("io.card.payment.scanResult")) {
            CreditCard parcelableExtra = intent.getParcelableExtra("io.card.payment.scanResult");
            if (this.mCardNumberRequired) {
                this.mCardNumber.setText(parcelableExtra.cardNumber);
                this.mCardNumber.focusNextView();
            }
            if (parcelableExtra.isExpiryValid() && this.mExpirationRequired) {
                this.mExpiration.setText(String.format("%02d%d", new Object[]{Integer.valueOf(parcelableExtra.expiryMonth), Integer.valueOf(parcelableExtra.expiryYear)}));
                this.mExpiration.focusNextView();
            }
        }
    }

    public final void init() {
        setVisibility(8);
        setOrientation(1);
        LinearLayout.inflate(getContext(), R$layout.bt_card_form_fields, this);
        this.mCardNumberIcon = (ImageView) findViewById(R$id.bt_card_form_card_number_icon);
        this.mCardNumber = (CardEditText) findViewById(R$id.bt_card_form_card_number);
        this.mExpiration = (ExpirationDateEditText) findViewById(R$id.bt_card_form_expiration);
        this.mCvv = (CvvEditText) findViewById(R$id.bt_card_form_cvv);
        this.mCardholderName = (CardholderNameEditText) findViewById(R$id.bt_card_form_cardholder_name);
        this.mCardholderNameIcon = (ImageView) findViewById(R$id.bt_card_form_cardholder_name_icon);
        this.mPostalCodeIcon = (ImageView) findViewById(R$id.bt_card_form_postal_code_icon);
        this.mPostalCode = (PostalCodeEditText) findViewById(R$id.bt_card_form_postal_code);
        this.mMobileNumberIcon = (ImageView) findViewById(R$id.bt_card_form_mobile_number_icon);
        this.mCountryCode = (CountryCodeEditText) findViewById(R$id.bt_card_form_country_code);
        this.mMobileNumber = (MobileNumberEditText) findViewById(R$id.bt_card_form_mobile_number);
        this.mMobileNumberExplanation = (TextView) findViewById(R$id.bt_card_form_mobile_number_explanation);
        this.mSaveCardCheckBox = (InitialValueCheckBox) findViewById(R$id.bt_card_form_save_card_checkbox);
        this.mVisibleEditTexts = new ArrayList();
        setListeners(this.mCardholderName);
        setListeners(this.mCardNumber);
        setListeners(this.mExpiration);
        setListeners(this.mCvv);
        setListeners(this.mPostalCode);
        setListeners(this.mMobileNumber);
        this.mCardNumber.setOnCardTypeChangedListener(this);
    }

    public boolean isCardScanningAvailable() {
        try {
            return CardIOActivity.canReadCardWithCamera();
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public boolean isValid() {
        boolean z = false;
        boolean z2 = this.mCardholderNameStatus != 2 || this.mCardholderName.isValid();
        if (this.mCardNumberRequired) {
            z2 = z2 && this.mCardNumber.isValid();
        }
        if (this.mExpirationRequired) {
            z2 = z2 && this.mExpiration.isValid();
        }
        if (this.mCvvRequired) {
            z2 = z2 && this.mCvv.isValid();
        }
        if (this.mPostalCodeRequired) {
            z2 = z2 && this.mPostalCode.isValid();
        }
        if (!this.mMobileNumberRequired) {
            return z2;
        }
        if (z2 && this.mCountryCode.isValid() && this.mMobileNumber.isValid()) {
            z = true;
        }
        return z;
    }

    public void onCardTypeChanged(CardType cardType) {
        this.mCvv.setCardType(cardType);
        OnCardTypeChangedListener onCardTypeChangedListener = this.mOnCardTypeChangedListener;
        if (onCardTypeChangedListener != null) {
            onCardTypeChangedListener.onCardTypeChanged(cardType);
        }
    }

    public void onClick(View view) {
        OnCardFormFieldFocusedListener onCardFormFieldFocusedListener = this.mOnCardFormFieldFocusedListener;
        if (onCardFormFieldFocusedListener != null) {
            EditCardView editCardView = (EditCardView) onCardFormFieldFocusedListener;
            if (view instanceof CardEditText) {
                AddPaymentUpdateListener addPaymentUpdateListener = editCardView.mListener;
                if (addPaymentUpdateListener != null) {
                    addPaymentUpdateListener.onBackRequested(editCardView);
                }
            }
        }
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            OnCardFormSubmitListener onCardFormSubmitListener = this.mOnCardFormSubmitListener;
            if (onCardFormSubmitListener != null) {
                onCardFormSubmitListener.onCardFormSubmit();
                return true;
            }
        }
        return false;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            OnCardFormFieldFocusedListener onCardFormFieldFocusedListener = this.mOnCardFormFieldFocusedListener;
            if (onCardFormFieldFocusedListener != null) {
                EditCardView editCardView = (EditCardView) onCardFormFieldFocusedListener;
                if (view instanceof CardEditText) {
                    AddPaymentUpdateListener addPaymentUpdateListener = editCardView.mListener;
                    if (addPaymentUpdateListener != null) {
                        addPaymentUpdateListener.onBackRequested(editCardView);
                    }
                }
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void requestEditTextFocus(EditText editText) {
        editText.requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(editText, 1);
    }

    public void setCardNumberError(String str) {
        if (this.mCardNumberRequired) {
            this.mCardNumber.setError(str);
            requestEditTextFocus(this.mCardNumber);
        }
    }

    public void setCardNumberIcon(int i) {
        this.mCardNumberIcon.setImageResource(i);
    }

    public void setCardholderNameError(String str) {
        if (this.mCardholderNameStatus == 2) {
            this.mCardholderName.setError(str);
            if (!this.mCardNumber.isFocused() && !this.mExpiration.isFocused() && !this.mCvv.isFocused()) {
                requestEditTextFocus(this.mCardholderName);
            }
        }
    }

    public void setCardholderNameIcon(int i) {
        this.mCardholderNameIcon.setImageResource(i);
    }

    public void setCountryCodeError(String str) {
        if (this.mMobileNumberRequired) {
            this.mCountryCode.setError(str);
            if (!this.mCardNumber.isFocused() && !this.mExpiration.isFocused() && !this.mCvv.isFocused() && !this.mCardholderName.isFocused() && !this.mPostalCode.isFocused()) {
                requestEditTextFocus(this.mCountryCode);
            }
        }
    }

    public void setCvvError(String str) {
        if (this.mCvvRequired) {
            this.mCvv.setError(str);
            if (!this.mCardNumber.isFocused() && !this.mExpiration.isFocused()) {
                requestEditTextFocus(this.mCvv);
            }
        }
    }

    public void setEnabled(boolean z) {
        this.mCardholderName.setEnabled(z);
        this.mCardNumber.setEnabled(z);
        this.mExpiration.setEnabled(z);
        this.mCvv.setEnabled(z);
        this.mPostalCode.setEnabled(z);
        this.mMobileNumber.setEnabled(z);
    }

    public void setExpirationError(String str) {
        if (this.mExpirationRequired) {
            this.mExpiration.setError(str);
            if (!this.mCardNumber.isFocused()) {
                requestEditTextFocus(this.mExpiration);
            }
        }
    }

    public final void setFieldVisibility(ErrorEditText errorEditText, boolean z) {
        int i = 0;
        errorEditText.setVisibility(z ? 0 : 8);
        if (errorEditText.getTextInputLayoutParent() != null) {
            TextInputLayout textInputLayoutParent = errorEditText.getTextInputLayoutParent();
            if (!z) {
                i = 8;
            }
            textInputLayoutParent.setVisibility(i);
        }
        if (z) {
            this.mVisibleEditTexts.add(errorEditText);
        } else {
            this.mVisibleEditTexts.remove(errorEditText);
        }
    }

    public void setMobileNumberError(String str) {
        if (this.mMobileNumberRequired) {
            this.mMobileNumber.setError(str);
            if (!this.mCardNumber.isFocused() && !this.mExpiration.isFocused() && !this.mCvv.isFocused() && !this.mCardholderName.isFocused() && !this.mPostalCode.isFocused() && !this.mCountryCode.isFocused()) {
                requestEditTextFocus(this.mMobileNumber);
            }
        }
    }

    public void setMobileNumberIcon(int i) {
        this.mMobileNumberIcon.setImageResource(i);
    }

    public void setOnCardFormSubmitListener(OnCardFormSubmitListener onCardFormSubmitListener) {
        this.mOnCardFormSubmitListener = onCardFormSubmitListener;
    }

    public void setOnCardFormValidListener(OnCardFormValidListener onCardFormValidListener) {
        this.mOnCardFormValidListener = onCardFormValidListener;
    }

    public void setOnCardTypeChangedListener(OnCardTypeChangedListener onCardTypeChangedListener) {
        this.mOnCardTypeChangedListener = onCardTypeChangedListener;
    }

    public void setOnFormFieldFocusedListener(OnCardFormFieldFocusedListener onCardFormFieldFocusedListener) {
        this.mOnCardFormFieldFocusedListener = onCardFormFieldFocusedListener;
    }

    public void setPostalCodeError(String str) {
        if (this.mPostalCodeRequired) {
            this.mPostalCode.setError(str);
            if (!this.mCardNumber.isFocused() && !this.mExpiration.isFocused() && !this.mCvv.isFocused() && !this.mCardholderName.isFocused()) {
                requestEditTextFocus(this.mPostalCode);
            }
        }
    }

    public void setPostalCodeIcon(int i) {
        this.mPostalCodeIcon.setImageResource(i);
    }

    public final void setViewVisibility(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    public void setup(AppCompatActivity appCompatActivity) {
        CardScanningFragment cardScanningFragment = (CardScanningFragment) appCompatActivity.getSupportFragmentManager().findFragmentByTag("com.braintreepayments.cardform.CardScanningFragment");
        this.mCardScanningFragment = cardScanningFragment;
        if (cardScanningFragment != null) {
            cardScanningFragment.mCardForm = this;
        }
        appCompatActivity.getWindow().setFlags(8192, 8192);
        boolean z = this.mCardholderNameStatus != 0;
        boolean isDarkBackground = k.isDarkBackground(appCompatActivity);
        this.mCardholderNameIcon.setImageResource(isDarkBackground ? R$drawable.bt_ic_cardholder_name_dark : R$drawable.bt_ic_cardholder_name);
        this.mCardNumberIcon.setImageResource(isDarkBackground ? R$drawable.bt_ic_card_dark : R$drawable.bt_ic_card);
        this.mPostalCodeIcon.setImageResource(isDarkBackground ? R$drawable.bt_ic_postal_code_dark : R$drawable.bt_ic_postal_code);
        this.mMobileNumberIcon.setImageResource(isDarkBackground ? R$drawable.bt_ic_mobile_number_dark : R$drawable.bt_ic_mobile_number);
        this.mExpiration.useDialogForExpirationDateEntry(appCompatActivity, true);
        setViewVisibility(this.mCardholderNameIcon, z);
        setFieldVisibility(this.mCardholderName, z);
        setViewVisibility(this.mCardNumberIcon, this.mCardNumberRequired);
        setFieldVisibility(this.mCardNumber, this.mCardNumberRequired);
        setFieldVisibility(this.mExpiration, this.mExpirationRequired);
        setFieldVisibility(this.mCvv, this.mCvvRequired);
        setViewVisibility(this.mPostalCodeIcon, this.mPostalCodeRequired);
        setFieldVisibility(this.mPostalCode, this.mPostalCodeRequired);
        setViewVisibility(this.mMobileNumberIcon, this.mMobileNumberRequired);
        setFieldVisibility(this.mCountryCode, this.mMobileNumberRequired);
        setFieldVisibility(this.mMobileNumber, this.mMobileNumberRequired);
        setViewVisibility(this.mMobileNumberExplanation, this.mMobileNumberRequired);
        setViewVisibility(this.mSaveCardCheckBox, this.mSaveCardCheckBoxVisible);
        for (int i = 0; i < this.mVisibleEditTexts.size(); i++) {
            TextInputEditText textInputEditText = this.mVisibleEditTexts.get(i);
            if (i == this.mVisibleEditTexts.size() - 1) {
                textInputEditText.setImeOptions(2);
                textInputEditText.setImeActionLabel(null, 2);
                textInputEditText.setOnEditorActionListener(this);
            } else {
                textInputEditText.setImeOptions(5);
                textInputEditText.setImeActionLabel(null, 1);
                textInputEditText.setOnEditorActionListener(null);
            }
        }
        this.mSaveCardCheckBox.setInitiallyChecked(this.mSaveCardCheckBoxChecked);
        setVisibility(0);
    }

    public void validate() {
        if (this.mCardholderNameStatus == 2) {
            this.mCardholderName.validate();
        }
        if (this.mCardNumberRequired) {
            this.mCardNumber.validate();
        }
        if (this.mExpirationRequired) {
            this.mExpiration.validate();
        }
        if (this.mCvvRequired) {
            this.mCvv.validate();
        }
        if (this.mPostalCodeRequired) {
            this.mPostalCode.validate();
        }
        if (this.mMobileNumberRequired) {
            this.mCountryCode.validate();
            this.mMobileNumber.validate();
        }
    }

    public CardForm(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
