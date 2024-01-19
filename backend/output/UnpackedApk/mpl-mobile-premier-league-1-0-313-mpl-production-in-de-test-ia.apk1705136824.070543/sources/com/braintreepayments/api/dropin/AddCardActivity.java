package com.braintreepayments.api.dropin;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.ActionBar;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.Card$1;
import com.braintreepayments.api.ThreeDSecure$3;
import com.braintreepayments.api.UnionPay;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.dropin.view.AddCardView;
import com.braintreepayments.api.dropin.view.EditCardView;
import com.braintreepayments.api.dropin.view.EnrollmentCardView;
import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.interfaces.UnionPayListener;
import com.braintreepayments.api.models.Authorization;
import com.braintreepayments.api.models.CardBuilder;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.braintreepayments.api.models.UnionPayCapabilities;
import com.braintreepayments.api.models.UnionPayCardBuilder;
import com.braintreepayments.cardform.CardScanningFragment;
import com.braintreepayments.cardform.utils.CardType;
import com.braintreepayments.cardform.view.CardForm;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.HashSet;

public class AddCardActivity extends BaseActivity implements ConfigurationListener, AddPaymentUpdateListener, PaymentMethodNonceCreatedListener, BraintreeErrorListener, BraintreeCancelListener, UnionPayListener {
    public ActionBar mActionBar;
    public AddCardView mAddCardView;
    public EditCardView mEditCardView;
    public EnrollmentCardView mEnrollmentCardView;
    public String mEnrollmentId;
    public boolean mPerformedThreeDSecureVerification;
    public int mState = 2;
    public boolean mUnionPayCard;
    public boolean mUnionPayDebitCard;
    public ViewSwitcher mViewSwitcher;

    public void createCard() {
        CardForm cardForm = this.mEditCardView.getCardForm();
        if (this.mUnionPayCard) {
            UnionPayCardBuilder unionPayCardBuilder = new UnionPayCardBuilder();
            String cardholderName = cardForm.getCardholderName();
            if (TextUtils.isEmpty(cardholderName)) {
                unionPayCardBuilder.mCardholderName = null;
            } else {
                unionPayCardBuilder.mCardholderName = cardholderName;
            }
            unionPayCardBuilder.cardNumber(cardForm.getCardNumber());
            unionPayCardBuilder.expirationMonth(cardForm.getExpirationMonth());
            unionPayCardBuilder.expirationYear(cardForm.getExpirationYear());
            unionPayCardBuilder.cvv(cardForm.getCvv());
            unionPayCardBuilder.postalCode(cardForm.getPostalCode());
            String countryCode = cardForm.getCountryCode();
            if (TextUtils.isEmpty(countryCode)) {
                unionPayCardBuilder.mMobileCountryCode = null;
            } else {
                unionPayCardBuilder.mMobileCountryCode = countryCode;
            }
            String mobileNumber = cardForm.getMobileNumber();
            if (TextUtils.isEmpty(mobileNumber)) {
                unionPayCardBuilder.mMobilePhoneNumber = null;
            } else {
                unionPayCardBuilder.mMobilePhoneNumber = mobileNumber;
            }
            String str = this.mEnrollmentId;
            if (TextUtils.isEmpty(str)) {
                unionPayCardBuilder.mEnrollmentId = null;
            } else {
                unionPayCardBuilder.mEnrollmentId = str;
            }
            String smsCode = this.mEnrollmentCardView.getSmsCode();
            if (TextUtils.isEmpty(smsCode)) {
                unionPayCardBuilder.mSmsCode = null;
            } else {
                unionPayCardBuilder.mSmsCode = smsCode;
            }
            UnionPay.tokenize(this.mBraintreeFragment, unionPayCardBuilder);
            return;
        }
        boolean z = this.mClientTokenPresent && cardForm.mSaveCardCheckBox.isChecked();
        CardBuilder cardBuilder = new CardBuilder();
        String cardholderName2 = cardForm.getCardholderName();
        if (TextUtils.isEmpty(cardholderName2)) {
            cardBuilder.mCardholderName = null;
        } else {
            cardBuilder.mCardholderName = cardholderName2;
        }
        cardBuilder.cardNumber(cardForm.getCardNumber());
        cardBuilder.expirationMonth(cardForm.getExpirationMonth());
        cardBuilder.expirationYear(cardForm.getExpirationYear());
        cardBuilder.cvv(cardForm.getCvv());
        cardBuilder.postalCode(cardForm.getPostalCode());
        cardBuilder.mValidate = z;
        cardBuilder.mValidateSet = true;
        BraintreeFragment braintreeFragment = this.mBraintreeFragment;
        k.tokenize(braintreeFragment, cardBuilder, new Card$1(braintreeFragment));
    }

    public final void enrollUnionPayCard() {
        UnionPayCardBuilder unionPayCardBuilder = new UnionPayCardBuilder();
        unionPayCardBuilder.cardNumber(this.mEditCardView.getCardForm().getCardNumber());
        unionPayCardBuilder.expirationMonth(this.mEditCardView.getCardForm().getExpirationMonth());
        unionPayCardBuilder.expirationYear(this.mEditCardView.getCardForm().getExpirationYear());
        unionPayCardBuilder.cvv(this.mEditCardView.getCardForm().getCvv());
        unionPayCardBuilder.postalCode(this.mEditCardView.getCardForm().getPostalCode());
        String countryCode = this.mEditCardView.getCardForm().getCountryCode();
        if (TextUtils.isEmpty(countryCode)) {
            unionPayCardBuilder.mMobileCountryCode = null;
        } else {
            unionPayCardBuilder.mMobileCountryCode = countryCode;
        }
        String mobileNumber = this.mEditCardView.getCardForm().getMobileNumber();
        if (TextUtils.isEmpty(mobileNumber)) {
            unionPayCardBuilder.mMobilePhoneNumber = null;
        } else {
            unionPayCardBuilder.mMobilePhoneNumber = mobileNumber;
        }
        UnionPay.enroll(this.mBraintreeFragment, unionPayCardBuilder);
    }

    public final void enterState(int i) {
        if (i == 1) {
            this.mActionBar.setTitle(R$string.bt_card_details);
            this.mViewSwitcher.setDisplayedChild(0);
        } else if (i == 2) {
            this.mActionBar.setTitle(R$string.bt_card_details);
            this.mAddCardView.setVisibility(0);
        } else if (i == 3) {
            this.mActionBar.setTitle(R$string.bt_card_details);
            this.mEditCardView.setCardNumber(this.mAddCardView.getCardForm().getCardNumber());
            this.mEditCardView.useUnionPay(this, this.mUnionPayCard, this.mUnionPayDebitCard);
            this.mEditCardView.setVisibility(0);
        } else if (i == 4) {
            this.mActionBar.setTitle(R$string.bt_confirm_enrollment);
            EnrollmentCardView enrollmentCardView = this.mEnrollmentCardView;
            enrollmentCardView.setPhoneNumber(PhoneNumberUtils.formatNumber(this.mEditCardView.getCardForm().getCountryCode() + this.mEditCardView.getCardForm().getMobileNumber()));
            this.mEnrollmentCardView.setVisibility(0);
        }
    }

    public void onBackRequested(View view) {
        if (view.getId() == this.mEditCardView.getId()) {
            setState(3, 2);
        } else if (view.getId() == this.mEnrollmentCardView.getId()) {
            setState(4, 3);
        }
    }

    public void onCancel(int i) {
        if (i == 13487) {
            this.mPerformedThreeDSecureVerification = false;
            this.mEditCardView.setVisibility(0);
        }
    }

    public void onCapabilitiesFetched(UnionPayCapabilities unionPayCapabilities) {
        boolean z = unionPayCapabilities.mIsUnionPay;
        this.mUnionPayCard = z;
        this.mUnionPayDebitCard = unionPayCapabilities.mIsDebit;
        if (!z || unionPayCapabilities.mIsSupported) {
            setState(this.mState, 3);
        } else {
            this.mAddCardView.showCardNotSupportedError();
        }
    }

    public void onConfigurationFetched(Configuration configuration) {
        this.mConfiguration = configuration;
        AddCardView addCardView = this.mAddCardView;
        boolean z = this.mClientTokenPresent;
        boolean z2 = false;
        addCardView.mCardForm.getCardEditText().displayCardTypeIcon(false);
        CardForm cardForm = addCardView.mCardForm;
        cardForm.mCardNumberRequired = true;
        cardForm.setup(this);
        addCardView.mCardForm.setOnCardTypeChangedListener(addCardView);
        addCardView.mCardForm.setOnCardFormValidListener(addCardView);
        addCardView.mCardForm.setOnCardFormSubmitListener(addCardView);
        HashSet hashSet = new HashSet(configuration.mCardConfiguration.getSupportedCardTypes());
        if (!z) {
            hashSet.remove(PaymentMethodType.UNIONPAY.getCanonicalName());
        }
        CardType[] cardsTypes = PaymentMethodType.getCardsTypes(hashSet);
        addCardView.mSupportedCardTypes = cardsTypes;
        addCardView.mSupportedCardTypesView.setSupportedCardTypes(cardsTypes);
        addCardView.mAnimatedButtonView.setVisibility(configuration.mUnionPayConfiguration.mEnabled ? 0 : 8);
        addCardView.mAnimatedButtonView.setClickListener(addCardView);
        if (addCardView.mCardNumber != null) {
            addCardView.mCardForm.getCardEditText().setText(addCardView.mCardNumber);
            addCardView.mCardNumber = null;
        }
        EditCardView editCardView = this.mEditCardView;
        DropInRequest dropInRequest = this.mDropInRequest;
        editCardView.mConfiguration = configuration;
        if (!Authorization.isTokenizationKey(dropInRequest.mAuthorization) && dropInRequest.mShowCheckBoxToAllowVaultOverride) {
            z2 = true;
        }
        CardForm cardForm2 = editCardView.mCardForm;
        cardForm2.mCardNumberRequired = true;
        cardForm2.mExpirationRequired = true;
        cardForm2.mCvvRequired = configuration.mChallenges.contains("cvv");
        cardForm2.mPostalCodeRequired = configuration.mChallenges.contains("postal_code");
        cardForm2.mCardholderNameStatus = dropInRequest.mCardholderNameStatus;
        cardForm2.mSaveCardCheckBoxVisible = z2;
        cardForm2.mSaveCardCheckBoxChecked = dropInRequest.mDefaultVaultValue;
        cardForm2.setup(this);
        editCardView.mCardForm.setOnCardFormSubmitListener(editCardView);
        editCardView.mAnimatedButtonView.setClickListener(editCardView);
        setState(1, this.mState);
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1791099786, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (this.mAddCardView.getCardForm().isCardScanningAvailable()) {
            getMenuInflater().inflate(R$menu.bt_card_io, menu);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Exception r9) {
        /*
            r8 = this;
            r0 = 0
            r8.mPerformedThreeDSecureVerification = r0
            boolean r1 = r9 instanceof com.braintreepayments.api.exceptions.ErrorWithResponse
            if (r1 == 0) goto L_0x0085
            r1 = r9
            com.braintreepayments.api.exceptions.ErrorWithResponse r1 = (com.braintreepayments.api.exceptions.ErrorWithResponse) r1
            com.braintreepayments.api.dropin.view.EnrollmentCardView r2 = r8.mEnrollmentCardView
            r3 = 0
            if (r2 == 0) goto L_0x0084
            java.lang.String r2 = "unionPayEnrollment"
            r4 = 1
            if (r1 == 0) goto L_0x0024
            com.braintreepayments.api.exceptions.BraintreeError r5 = r1.errorFor(r2)
            if (r5 == 0) goto L_0x0024
            java.lang.String r6 = "base"
            com.braintreepayments.api.exceptions.BraintreeError r5 = r5.errorFor(r6)
            if (r5 == 0) goto L_0x0024
            r5 = 1
            goto L_0x0025
        L_0x0024:
            r5 = 0
        L_0x0025:
            if (r5 == 0) goto L_0x0034
            int r9 = r8.mState
            r0 = 4
            r8.setState(r9, r0)
            com.braintreepayments.api.dropin.view.EnrollmentCardView r9 = r8.mEnrollmentCardView
            r9.setErrors(r1)
            goto L_0x00c5
        L_0x0034:
            com.braintreepayments.api.dropin.view.AddCardView r5 = r8.mAddCardView
            if (r5 == 0) goto L_0x0083
            java.lang.String r5 = "creditCard"
            com.braintreepayments.api.exceptions.BraintreeError r6 = r1.errorFor(r5)
            if (r6 == 0) goto L_0x004a
            java.lang.String r7 = "number"
            com.braintreepayments.api.exceptions.BraintreeError r6 = r6.errorFor(r7)
            if (r6 == 0) goto L_0x004a
            r6 = 1
            goto L_0x004b
        L_0x004a:
            r6 = 0
        L_0x004b:
            if (r6 == 0) goto L_0x005f
            com.braintreepayments.api.dropin.view.AddCardView r9 = r8.mAddCardView
            r9.setErrors(r1)
            com.braintreepayments.api.dropin.view.EditCardView r9 = r8.mEditCardView
            r9.setErrors(r1)
            int r9 = r8.mState
            r0 = 2
            r8.setState(r9, r0)
            goto L_0x00c5
        L_0x005f:
            com.braintreepayments.api.dropin.view.EditCardView r6 = r8.mEditCardView
            if (r6 == 0) goto L_0x0082
            com.braintreepayments.api.exceptions.BraintreeError r2 = r1.errorFor(r2)
            if (r2 != 0) goto L_0x006f
            com.braintreepayments.api.exceptions.BraintreeError r2 = r1.errorFor(r5)
            if (r2 == 0) goto L_0x0070
        L_0x006f:
            r0 = 1
        L_0x0070:
            if (r0 == 0) goto L_0x007e
            com.braintreepayments.api.dropin.view.EditCardView r9 = r8.mEditCardView
            r9.setErrors(r1)
            int r9 = r8.mState
            r0 = 3
            r8.setState(r9, r0)
            goto L_0x00c5
        L_0x007e:
            r8.finish(r9)
            goto L_0x00c5
        L_0x0082:
            throw r3
        L_0x0083:
            throw r3
        L_0x0084:
            throw r3
        L_0x0085:
            boolean r0 = r9 instanceof com.braintreepayments.api.exceptions.AuthenticationException
            if (r0 != 0) goto L_0x00bb
            boolean r0 = r9 instanceof com.braintreepayments.api.exceptions.AuthorizationException
            if (r0 != 0) goto L_0x00bb
            boolean r0 = r9 instanceof com.braintreepayments.api.exceptions.UpgradeRequiredException
            if (r0 == 0) goto L_0x0092
            goto L_0x00bb
        L_0x0092:
            boolean r0 = r9 instanceof com.braintreepayments.api.exceptions.ConfigurationException
            if (r0 == 0) goto L_0x009e
            com.braintreepayments.api.BraintreeFragment r0 = r8.mBraintreeFragment
            java.lang.String r1 = "sdk.exit.configuration-exception"
            r0.sendAnalyticsEvent(r1)
            goto L_0x00c2
        L_0x009e:
            boolean r0 = r9 instanceof com.braintreepayments.api.exceptions.ServerException
            if (r0 != 0) goto L_0x00b3
            boolean r0 = r9 instanceof com.braintreepayments.api.exceptions.UnexpectedException
            if (r0 == 0) goto L_0x00a7
            goto L_0x00b3
        L_0x00a7:
            boolean r0 = r9 instanceof com.braintreepayments.api.exceptions.DownForMaintenanceException
            if (r0 == 0) goto L_0x00c2
            com.braintreepayments.api.BraintreeFragment r0 = r8.mBraintreeFragment
            java.lang.String r1 = "sdk.exit.server-unavailable"
            r0.sendAnalyticsEvent(r1)
            goto L_0x00c2
        L_0x00b3:
            com.braintreepayments.api.BraintreeFragment r0 = r8.mBraintreeFragment
            java.lang.String r1 = "sdk.exit.server-error"
            r0.sendAnalyticsEvent(r1)
            goto L_0x00c2
        L_0x00bb:
            com.braintreepayments.api.BraintreeFragment r0 = r8.mBraintreeFragment
            java.lang.String r1 = "sdk.exit.developer-error"
            r0.sendAnalyticsEvent(r1)
        L_0x00c2:
            r8.finish(r9)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.dropin.AddCardActivity.onError(java.lang.Exception):void");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R$id.bt_card_io_button) {
            CardForm cardForm = this.mAddCardView.getCardForm();
            if (cardForm.isCardScanningAvailable() && cardForm.mCardScanningFragment == null) {
                cardForm.mCardScanningFragment = CardScanningFragment.requestScan(this, cardForm);
            }
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            setResult(0);
            finish();
            return true;
        }
    }

    public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
        if (this.mPerformedThreeDSecureVerification || !shouldRequestThreeDSecureVerification()) {
            this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.success");
            finish(paymentMethodNonce, null);
            return;
        }
        this.mPerformedThreeDSecureVerification = true;
        if (this.mDropInRequest.mThreeDSecureRequest == null) {
            ThreeDSecureRequest threeDSecureRequest = new ThreeDSecureRequest();
            DropInRequest dropInRequest = this.mDropInRequest;
            threeDSecureRequest.mAmount = dropInRequest.mAmount;
            dropInRequest.mThreeDSecureRequest = threeDSecureRequest;
        }
        DropInRequest dropInRequest2 = this.mDropInRequest;
        ThreeDSecureRequest threeDSecureRequest2 = dropInRequest2.mThreeDSecureRequest;
        if (threeDSecureRequest2.mAmount == null) {
            String str = dropInRequest2.mAmount;
            if (str != null) {
                threeDSecureRequest2.mAmount = str;
            }
        }
        ThreeDSecureRequest threeDSecureRequest3 = this.mDropInRequest.mThreeDSecureRequest;
        threeDSecureRequest3.mNonce = paymentMethodNonce.mNonce;
        BraintreeFragment braintreeFragment = this.mBraintreeFragment;
        k.performVerification(braintreeFragment, threeDSecureRequest3, new ThreeDSecure$3(braintreeFragment));
    }

    public void onPaymentUpdated(View view) {
        int i;
        int i2 = this.mState;
        if (view.getId() != this.mAddCardView.getId() || TextUtils.isEmpty(this.mAddCardView.getCardForm().getCardNumber())) {
            if (view.getId() == this.mEditCardView.getId()) {
                if (!this.mUnionPayCard) {
                    i = this.mState;
                    createCard();
                } else if (TextUtils.isEmpty(this.mEnrollmentId)) {
                    enrollUnionPayCard();
                } else {
                    i = 4;
                }
                setState(i2, i);
            } else if (view.getId() == this.mEnrollmentCardView.getId()) {
                i = this.mState;
                if (this.mEnrollmentCardView.mEnrollmentFailed) {
                    enrollUnionPayCard();
                } else {
                    createCard();
                }
                setState(i2, i);
            }
        } else if (!this.mConfiguration.mUnionPayConfiguration.mEnabled || !this.mClientTokenPresent) {
            this.mEditCardView.useUnionPay(this, false, false);
            i = 3;
            setState(i2, i);
        } else {
            UnionPay.fetchCapabilities(this.mBraintreeFragment, this.mAddCardView.getCardForm().getCardNumber());
        }
        i = i2;
        setState(i2, i);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("com.braintreepayments.api.EXTRA_STATE", this.mState);
        bundle.putString("com.braintreepayments.api.EXTRA_ENROLLMENT_ID", this.mEnrollmentId);
    }

    public void onSmsCodeSent(String str, boolean z) {
        this.mEnrollmentId = str;
        if (!z || this.mState == 4) {
            createCard();
        } else {
            onPaymentUpdated(this.mEditCardView);
        }
    }

    public final void setState(int i, int i2) {
        if (i != i2) {
            if (i == 1) {
                this.mViewSwitcher.setDisplayedChild(1);
            } else if (i == 2) {
                this.mAddCardView.setVisibility(8);
            } else if (i == 3) {
                this.mEditCardView.setVisibility(8);
            } else if (i == 4) {
                this.mEnrollmentCardView.setVisibility(8);
            }
            enterState(i2);
            this.mState = i2;
        }
    }
}
