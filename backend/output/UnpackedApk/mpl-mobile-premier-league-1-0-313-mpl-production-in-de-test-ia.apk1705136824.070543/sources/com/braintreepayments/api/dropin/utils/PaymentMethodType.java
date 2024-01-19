package com.braintreepayments.api.dropin.utils;

import com.braintreepayments.api.dropin.R$drawable;
import com.braintreepayments.api.dropin.R$string;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.cardform.utils.CardType;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.paynimo.android.payment.PaymentActivity;
import java.util.ArrayList;
import java.util.Set;

public enum PaymentMethodType {
    AMEX(CardType.AMEX.getFrontResource(), R$drawable.bt_ic_vaulted_amex, R$string.bt_descriptor_amex, "American Express", CardType.AMEX),
    GOOGLE_PAYMENT(R$drawable.bt_ic_google_pay, 0, R$string.bt_descriptor_google_pay, "Google Pay", null),
    DINERS(CardType.DINERS_CLUB.getFrontResource(), R$drawable.bt_ic_vaulted_diners_club, R$string.bt_descriptor_diners, "Diners", CardType.DINERS_CLUB),
    DISCOVER(CardType.DISCOVER.getFrontResource(), R$drawable.bt_ic_vaulted_discover, R$string.bt_descriptor_discover, "Discover", CardType.DISCOVER),
    JCB(CardType.JCB.getFrontResource(), R$drawable.bt_ic_vaulted_jcb, R$string.bt_descriptor_jcb, PaymentActivity.CARD_I_AUTHORITY_JCB, CardType.JCB),
    MAESTRO(CardType.MAESTRO.getFrontResource(), R$drawable.bt_ic_vaulted_maestro, R$string.bt_descriptor_maestro, "Maestro", CardType.MAESTRO),
    MASTERCARD(CardType.MASTERCARD.getFrontResource(), R$drawable.bt_ic_vaulted_mastercard, R$string.bt_descriptor_mastercard, "MasterCard", CardType.MASTERCARD),
    PAYPAL(R$drawable.bt_ic_paypal, R$drawable.bt_ic_vaulted_paypal, R$string.bt_descriptor_paypal, "PayPal", null),
    VISA(CardType.VISA.getFrontResource(), R$drawable.bt_ic_vaulted_visa, R$string.bt_descriptor_visa, "Visa", CardType.VISA),
    PAY_WITH_VENMO(R$drawable.bt_ic_venmo, R$drawable.bt_ic_vaulted_venmo, R$string.bt_descriptor_pay_with_venmo, "Venmo", null),
    UNIONPAY(CardType.UNIONPAY.getFrontResource(), R$drawable.bt_ic_vaulted_unionpay, R$string.bt_descriptor_unionpay, "UnionPay", CardType.UNIONPAY),
    HIPER(CardType.HIPER.getFrontResource(), R$drawable.bt_ic_vaulted_hiper, R$string.bt_descriptor_hiper, "Hiper", CardType.HIPER),
    HIPERCARD(CardType.HIPERCARD.getFrontResource(), R$drawable.bt_ic_vaulted_hipercard, R$string.bt_descriptor_hipercard, "Hipercard", CardType.HIPERCARD),
    UNKNOWN(CardType.UNKNOWN.getFrontResource(), R$drawable.bt_ic_vaulted_unknown, R$string.bt_descriptor_unknown, Constants.DOWNLOAD_STATUS_UNKNOWN, CardType.UNKNOWN);
    
    public String mCanonicalName;
    public CardType mCardType;
    public final int mIconDrawable;
    public final int mLocalizedName;
    public final int mVaultedDrawable;

    /* access modifiers changed from: public */
    PaymentMethodType(int i, int i2, int i3, String str, CardType cardType) {
        this.mIconDrawable = i;
        this.mVaultedDrawable = i2;
        this.mLocalizedName = i3;
        this.mCanonicalName = str;
        this.mCardType = cardType;
    }

    public static PaymentMethodType forType(String str) {
        for (PaymentMethodType paymentMethodType : values()) {
            if (paymentMethodType.mCanonicalName.equals(str)) {
                return paymentMethodType;
            }
        }
        return UNKNOWN;
    }

    public static CardType[] getCardsTypes(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (String forType : set) {
            PaymentMethodType forType2 = forType(forType);
            if (forType2 != UNKNOWN) {
                CardType cardType = forType2.mCardType;
                if (cardType != null) {
                    arrayList.add(cardType);
                }
            }
        }
        return (CardType[]) arrayList.toArray(new CardType[arrayList.size()]);
    }

    public String getCanonicalName() {
        return this.mCanonicalName;
    }

    public int getDrawable() {
        return this.mIconDrawable;
    }

    public int getLocalizedName() {
        return this.mLocalizedName;
    }

    public int getVaultedDrawable() {
        return this.mVaultedDrawable;
    }

    public static PaymentMethodType forType(PaymentMethodNonce paymentMethodNonce) {
        return forType(paymentMethodNonce.getTypeLabel());
    }
}
