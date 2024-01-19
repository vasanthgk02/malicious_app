package com.braintreepayments.api.dropin.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.braintreepayments.api.dropin.R$id;
import com.braintreepayments.api.dropin.R$layout;
import com.braintreepayments.api.dropin.R$string;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;
import com.braintreepayments.api.exceptions.BraintreeError;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.cardform.OnCardFormSubmitListener;
import com.braintreepayments.cardform.OnCardFormValidListener;
import com.braintreepayments.cardform.utils.CardType;
import com.braintreepayments.cardform.view.CardEditText.OnCardTypeChangedListener;
import com.braintreepayments.cardform.view.CardForm;
import com.braintreepayments.cardform.view.SupportedCardTypesView;
import com.paynimo.android.payment.UPIFragment;
import java.util.Arrays;

public class AddCardView extends LinearLayout implements OnCardFormSubmitListener, OnCardFormValidListener, OnClickListener, OnCardTypeChangedListener {
    public AnimatedButtonView mAnimatedButtonView;
    public CardForm mCardForm;
    public String mCardNumber;
    public AddPaymentUpdateListener mListener;
    public CardType[] mSupportedCardTypes;
    public SupportedCardTypesView mSupportedCardTypesView;

    public AddCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void callAddPaymentUpdateListener() {
        AddPaymentUpdateListener addPaymentUpdateListener = this.mListener;
        if (addPaymentUpdateListener != null) {
            addPaymentUpdateListener.onPaymentUpdated(this);
        }
    }

    public CardForm getCardForm() {
        return this.mCardForm;
    }

    public final void init() {
        if (!isInEditMode()) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R$layout.bt_add_card, this, true);
            this.mCardForm = (CardForm) findViewById(R$id.bt_card_form);
            this.mSupportedCardTypesView = (SupportedCardTypesView) findViewById(R$id.bt_supported_card_types);
            this.mAnimatedButtonView = (AnimatedButtonView) findViewById(R$id.bt_animated_button_view);
        }
    }

    public final boolean isCardTypeValid() {
        return Arrays.asList(this.mSupportedCardTypes).contains(this.mCardForm.getCardEditText().getCardType());
    }

    public final boolean isValid() {
        return this.mCardForm.isValid() && isCardTypeValid();
    }

    public void onCardFormSubmit() {
        if (isValid()) {
            this.mAnimatedButtonView.showLoading();
            callAddPaymentUpdateListener();
        } else if (!this.mCardForm.isValid()) {
            this.mCardForm.validate();
        } else if (!isCardTypeValid()) {
            showCardNotSupportedError();
        }
    }

    public void onCardTypeChanged(CardType cardType) {
        if (cardType == CardType.EMPTY) {
            this.mSupportedCardTypesView.setSupportedCardTypes(this.mSupportedCardTypes);
            return;
        }
        this.mSupportedCardTypesView.setSelected(cardType);
    }

    public void onClick(View view) {
        if (isValid()) {
            callAddPaymentUpdateListener();
            return;
        }
        this.mAnimatedButtonView.showButton();
        if (!this.mCardForm.isValid()) {
            this.mCardForm.validate();
        } else if (!isCardTypeValid()) {
            showCardNotSupportedError();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCardNumber = bundle.getString("com.braintreepayments.api.dropin.view.CARD_NUMBER");
            parcelable = bundle.getParcelable("com.braintreepayments.api.dropin.view.PARENT_STATE");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.braintreepayments.api.dropin.view.PARENT_STATE", super.onSaveInstanceState());
        bundle.putString("com.braintreepayments.api.dropin.view.CARD_NUMBER", this.mCardForm.getCardNumber());
        return bundle;
    }

    public void setAddPaymentUpdatedListener(AddPaymentUpdateListener addPaymentUpdateListener) {
        this.mListener = addPaymentUpdateListener;
    }

    public void setErrors(ErrorWithResponse errorWithResponse) {
        BraintreeError errorFor = errorWithResponse.errorFor("creditCard");
        if (!(errorFor == null || errorFor.errorFor(UPIFragment.CONFIG_TYPE_NUMBER) == null)) {
            this.mCardForm.setCardNumberError(getContext().getString(R$string.bt_card_number_invalid));
        }
        this.mAnimatedButtonView.showButton();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mAnimatedButtonView.showButton();
        if (i == 0) {
            this.mCardForm.getCardEditText().requestFocus();
        }
    }

    public void showCardNotSupportedError() {
        this.mCardForm.getCardEditText().setError(getContext().getString(R$string.bt_card_not_accepted));
        this.mAnimatedButtonView.showButton();
    }

    public AddCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
