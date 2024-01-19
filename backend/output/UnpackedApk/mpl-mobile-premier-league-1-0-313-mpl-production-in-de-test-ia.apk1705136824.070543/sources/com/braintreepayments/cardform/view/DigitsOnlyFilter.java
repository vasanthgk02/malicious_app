package com.braintreepayments.cardform.view;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

public class DigitsOnlyFilter implements InputFilter {
    public Pattern digitsRegex = Pattern.compile("[0-9]");
    public StringBuilder stringBuilder;

    public DigitsOnlyFilter(StringBuilder sb) {
        this.stringBuilder = sb;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = 0;
        this.stringBuilder.setLength(0);
        int length = charSequence.length();
        while (i5 < length) {
            int i6 = i5 + 1;
            CharSequence subSequence = charSequence.subSequence(i5, i6);
            if (this.digitsRegex.matcher(subSequence).matches()) {
                this.stringBuilder.append(subSequence);
            }
            i5 = i6;
        }
        return this.stringBuilder.toString();
    }
}
