package com.braintreepayments.api.dropin.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.braintreepayments.api.dropin.R$id;
import com.braintreepayments.api.dropin.R$layout;
import com.braintreepayments.api.dropin.R$string;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;
import com.braintreepayments.api.exceptions.BraintreeError;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.cardform.OnCardFormFieldFocusedListener;
import com.braintreepayments.cardform.OnCardFormSubmitListener;
import com.braintreepayments.cardform.view.CardForm;

public class EditCardView extends LinearLayout implements OnCardFormFieldFocusedListener, OnClickListener, OnCardFormSubmitListener {
    public AnimatedButtonView mAnimatedButtonView;
    public CardForm mCardForm;
    public Configuration mConfiguration;
    public AddPaymentUpdateListener mListener;

    public EditCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CardForm getCardForm() {
        return this.mCardForm;
    }

    public final void init() {
        if (!isInEditMode()) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R$layout.bt_edit_card, this);
            this.mCardForm = (CardForm) findViewById(R$id.bt_card_form);
            this.mAnimatedButtonView = (AnimatedButtonView) findViewById(R$id.bt_animated_button_view);
        }
    }

    public void onCardFormSubmit() {
        if (this.mCardForm.isValid()) {
            this.mAnimatedButtonView.showLoading();
            AddPaymentUpdateListener addPaymentUpdateListener = this.mListener;
            if (addPaymentUpdateListener != null) {
                addPaymentUpdateListener.onPaymentUpdated(this);
                return;
            }
            return;
        }
        this.mAnimatedButtonView.showButton();
        this.mCardForm.validate();
    }

    public void onClick(View view) {
        onCardFormSubmit();
    }

    public void setAddPaymentUpdatedListener(AddPaymentUpdateListener addPaymentUpdateListener) {
        this.mListener = addPaymentUpdateListener;
    }

    public void setCardNumber(String str) {
        this.mCardForm.getCardEditText().setText(str);
    }

    public void setErrors(ErrorWithResponse errorWithResponse) {
        BraintreeError errorFor = errorWithResponse.errorFor("unionPayEnrollment");
        if (errorFor == null) {
            errorFor = errorWithResponse.errorFor("creditCard");
        }
        if (errorFor != null) {
            if (!(errorFor.errorFor("expirationYear") == null && errorFor.errorFor("expirationMonth") == null && errorFor.errorFor("expirationDate") == null)) {
                this.mCardForm.setExpirationError(getContext().getString(R$string.bt_expiration_invalid));
            }
            if (errorFor.errorFor("cvv") != null) {
                this.mCardForm.setCvvError(getContext().getString(R$string.bt_cvv_invalid, new Object[]{getContext().getString(this.mCardForm.getCardEditText().getCardType().getSecurityCodeName())}));
            }
            if (errorFor.errorFor("billingAddress") != null) {
                this.mCardForm.setPostalCodeError(getContext().getString(R$string.bt_postal_code_invalid));
            }
            if (errorFor.errorFor("mobileCountryCode") != null) {
                this.mCardForm.setCountryCodeError(getContext().getString(R$string.bt_country_code_invalid));
            }
            if (errorFor.errorFor("mobileNumber") != null) {
                this.mCardForm.setMobileNumberError(getContext().getString(R$string.bt_mobile_number_invalid));
            }
        }
        this.mAnimatedButtonView.showButton();
    }

    public void setMaskCardNumber(boolean z) {
        this.mCardForm.mCardNumber.setMask(z);
    }

    public void setMaskCvv(boolean z) {
        this.mCardForm.mCvv.setMask(z);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mAnimatedButtonView.showButton();
        if (i == 0) {
            if (!this.mCardForm.getExpirationDateEditText().isValid() || TextUtils.isEmpty(this.mCardForm.getExpirationDateEditText().getText())) {
                this.mCardForm.getExpirationDateEditText().requestFocus();
            } else if (this.mCardForm.getCvvEditText().getVisibility() == 0 && (!this.mCardForm.getCvvEditText().isValid() || TextUtils.isEmpty(this.mCardForm.getCvvEditText().getText()))) {
                this.mCardForm.getCvvEditText().requestFocus();
            } else if (this.mCardForm.getPostalCodeEditText().getVisibility() == 0 && !this.mCardForm.getPostalCodeEditText().isValid()) {
                this.mCardForm.getPostalCodeEditText().requestFocus();
            } else if (this.mCardForm.getCountryCodeEditText().getVisibility() == 0 && !this.mCardForm.getCountryCodeEditText().isValid()) {
                this.mCardForm.getCountryCodeEditText().requestFocus();
            } else if (this.mCardForm.getMobileNumberEditText().getVisibility() != 0 || this.mCardForm.getMobileNumberEditText().isValid()) {
                this.mAnimatedButtonView.requestFocus();
                this.mCardForm.mCardNumber.closeSoftKeyboard();
            } else {
                this.mCardForm.getMobileNumberEditText().requestFocus();
            }
            this.mCardForm.setOnFormFieldFocusedListener(this);
            return;
        }
        this.mCardForm.setOnFormFieldFocusedListener(null);
    }

    public void useUnionPay(AppCompatActivity appCompatActivity, boolean z, boolean z2) {
        this.mCardForm.getExpirationDateEditText().setOptional(false);
        this.mCardForm.getCvvEditText().setOptional(false);
        if (z) {
            if (z2) {
                this.mCardForm.getExpirationDateEditText().setOptional(true);
                this.mCardForm.getCvvEditText().setOptional(true);
            }
            CardForm cardForm = this.mCardForm;
            cardForm.mCardNumberRequired = true;
            cardForm.mExpirationRequired = true;
            cardForm.mCvvRequired = true;
            cardForm.mPostalCodeRequired = this.mConfiguration.mChallenges.contains("postal_code");
            cardForm.mMobileNumberRequired = true;
            cardForm.mMobileNumberExplanation.setText(getContext().getString(R$string.bt_unionpay_mobile_number_explanation));
            cardForm.setup(appCompatActivity);
        }
    }

    public EditCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
