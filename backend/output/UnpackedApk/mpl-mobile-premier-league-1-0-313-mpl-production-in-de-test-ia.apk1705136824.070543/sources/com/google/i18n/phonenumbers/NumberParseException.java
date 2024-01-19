package com.google.i18n.phonenumbers;

import com.android.tools.r8.GeneratedOutlineSupport;

public class NumberParseException extends Exception {
    public ErrorType errorType;
    public String message;

    public enum ErrorType {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(ErrorType errorType2, String str) {
        super(str);
        this.message = str;
        this.errorType = errorType2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error type: ");
        outline73.append(this.errorType);
        outline73.append(". ");
        outline73.append(this.message);
        return outline73.toString();
    }
}
