package com.braintreepayments.cardform.utils;

import android.text.TextUtils;
import com.braintreepayments.cardform.R$drawable;
import com.braintreepayments.cardform.R$string;
import java.util.regex.Pattern;

public enum CardType {
    VISA("^4\\d*", R$drawable.bt_ic_visa, 16, 16, 3, R$string.bt_cvv, null),
    MASTERCARD("^(5[1-5]|222[1-9]|22[3-9]|2[3-6]|27[0-1]|2720)\\d*", R$drawable.bt_ic_mastercard, 16, 16, 3, R$string.bt_cvc, null),
    DISCOVER("^(6011|65|64[4-9]|622)\\d*", R$drawable.bt_ic_discover, 16, 16, 3, R$string.bt_cid, null),
    AMEX("^3[47]\\d*", R$drawable.bt_ic_amex, 15, 15, 4, R$string.bt_cid, null),
    DINERS_CLUB("^(36|38|30[0-5])\\d*", R$drawable.bt_ic_diners_club, 14, 14, 3, R$string.bt_cvv, null),
    JCB("^35\\d*", R$drawable.bt_ic_jcb, 16, 16, 3, R$string.bt_cvv, null),
    MAESTRO("^(5018|5020|5038|5[6-9]|6020|6304|6703|6759|676[1-3])\\d*", R$drawable.bt_ic_maestro, 12, 19, 3, R$string.bt_cvc, "^6\\d*"),
    UNIONPAY("^62\\d*", R$drawable.bt_ic_unionpay, 16, 19, 3, R$string.bt_cvn, null),
    HIPER("^637(095|568|599|609|612)\\d*", R$drawable.bt_ic_hiper, 16, 16, 3, R$string.bt_cvc, null),
    HIPERCARD("^606282\\d*", R$drawable.bt_ic_hipercard, 16, 16, 3, R$string.bt_cvc, null),
    UNKNOWN("\\d+", R$drawable.bt_ic_unknown, 12, 19, 3, R$string.bt_cvv, null),
    EMPTY("^$", R$drawable.bt_ic_unknown, 12, 19, 3, R$string.bt_cvv, null);
    
    public static final int[] AMEX_SPACE_INDICES = null;
    public static final int[] DEFAULT_SPACE_INDICES = null;
    public final int mFrontResource;
    public final int mMaxCardLength;
    public final int mMinCardLength;
    public final Pattern mPattern;
    public final Pattern mRelaxedPrefixPattern;
    public final int mSecurityCodeLength;
    public final int mSecurityCodeName;

    /* access modifiers changed from: public */
    static {
        AMEX_SPACE_INDICES = new int[]{4, 10};
        DEFAULT_SPACE_INDICES = new int[]{4, 8, 12};
    }

    /* access modifiers changed from: public */
    CardType(String str, int i, int i2, int i3, int i4, int i5, String str2) {
        Pattern pattern;
        this.mPattern = Pattern.compile(str);
        if (str2 == null) {
            pattern = null;
        } else {
            pattern = Pattern.compile(str2);
        }
        this.mRelaxedPrefixPattern = pattern;
        this.mFrontResource = i;
        this.mMinCardLength = i2;
        this.mMaxCardLength = i3;
        this.mSecurityCodeLength = i4;
        this.mSecurityCodeName = i5;
    }

    public static CardType forCardNumber(String str) {
        CardType forCardNumberPattern = forCardNumberPattern(str);
        if (forCardNumberPattern != EMPTY && forCardNumberPattern != UNKNOWN) {
            return forCardNumberPattern;
        }
        CardType forCardNumberRelaxedPrefixPattern = forCardNumberRelaxedPrefixPattern(str);
        if (forCardNumberRelaxedPrefixPattern != EMPTY && forCardNumberRelaxedPrefixPattern != UNKNOWN) {
            return forCardNumberRelaxedPrefixPattern;
        }
        if (!str.isEmpty()) {
            return UNKNOWN;
        }
        return EMPTY;
    }

    public static CardType forCardNumberPattern(String str) {
        for (CardType cardType : values()) {
            if (cardType.getPattern().matcher(str).matches()) {
                return cardType;
            }
        }
        return EMPTY;
    }

    public static CardType forCardNumberRelaxedPrefixPattern(String str) {
        for (CardType cardType : values()) {
            if (cardType.getRelaxedPrefixPattern() != null && cardType.getRelaxedPrefixPattern().matcher(str).matches()) {
                return cardType;
            }
        }
        return EMPTY;
    }

    public static boolean isLuhnValid(String str) {
        String stringBuffer = new StringBuffer(str).reverse().toString();
        int length = stringBuffer.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            char charAt = stringBuffer.charAt(i);
            if (Character.isDigit(charAt)) {
                int digit = Character.digit(charAt, 10);
                if (i % 2 == 0) {
                    i2 += digit;
                } else {
                    i3 += ((digit * 2) % 10) + (digit / 5);
                }
                i++;
            } else {
                throw new IllegalArgumentException(String.format("Not a digit: '%s'", new Object[]{Character.valueOf(charAt)}));
            }
        }
        if ((i2 + i3) % 10 == 0) {
            return true;
        }
        return false;
    }

    public int getFrontResource() {
        return this.mFrontResource;
    }

    public int getMaxCardLength() {
        return this.mMaxCardLength;
    }

    public int getMinCardLength() {
        return this.mMinCardLength;
    }

    public Pattern getPattern() {
        return this.mPattern;
    }

    public Pattern getRelaxedPrefixPattern() {
        return this.mRelaxedPrefixPattern;
    }

    public int getSecurityCodeLength() {
        return this.mSecurityCodeLength;
    }

    public int getSecurityCodeName() {
        return this.mSecurityCodeName;
    }

    public int[] getSpaceIndices() {
        return this == AMEX ? AMEX_SPACE_INDICES : DEFAULT_SPACE_INDICES;
    }

    public boolean validate(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return false;
        }
        int length = str.length();
        if (length < this.mMinCardLength || length > this.mMaxCardLength) {
            return false;
        }
        if (!this.mPattern.matcher(str).matches()) {
            Pattern pattern = this.mRelaxedPrefixPattern;
            if (pattern != null && !pattern.matcher(str).matches()) {
                return false;
            }
        }
        return isLuhnValid(str);
    }
}
