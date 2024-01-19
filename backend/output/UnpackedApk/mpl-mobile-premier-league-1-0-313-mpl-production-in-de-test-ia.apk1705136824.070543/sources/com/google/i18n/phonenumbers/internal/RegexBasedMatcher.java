package com.google.i18n.phonenumbers.internal;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc;
import java.util.regex.Matcher;

public final class RegexBasedMatcher {
    public final RegexCache regexCache = new RegexCache(100);

    public boolean matchNationalNumber(CharSequence charSequence, Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc, boolean z) {
        String str = phonemetadata$PhoneNumberDesc.nationalNumberPattern_;
        boolean z2 = false;
        if (str.length() == 0) {
            return false;
        }
        Matcher matcher = this.regexCache.getPatternForRegex(str).matcher(charSequence);
        if (matcher.lookingAt()) {
            if (matcher.matches()) {
                z = true;
            }
            z2 = z;
        }
        return z2;
    }
}
