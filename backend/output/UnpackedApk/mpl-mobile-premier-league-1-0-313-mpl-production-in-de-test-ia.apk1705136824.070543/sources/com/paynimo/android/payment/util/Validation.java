package com.paynimo.android.payment.util;

import android.widget.EditText;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.regex.Pattern;

public class Validation {
    public static final String ALPHANUM_WITH_DOT_REGEX = "^[A-Za-z0-9\\s\\.]+$";
    public static final String EMAIL_MSG = "invalid email";
    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String NUMBER_ONLY_REGEX = "^\\d+";
    public static final String PHONE_MSG = "###-#######";
    public static final String PHONE_REGEX = "\\d{3}-\\d{7}";
    public static final String REQUIRED_MSG = "required";
    public static final String VPA_REGEX = "^([\\w.-]+[@][\\w]+)+$";

    public static boolean hasText(EditText editText) {
        String trim = editText.getText().toString().trim();
        editText.setError(null);
        if (trim.length() != 0) {
            return true;
        }
        editText.setError(REQUIRED_MSG);
        return false;
    }

    public static Boolean isCVVString(String str) {
        if (Pattern.compile("\\d").matcher(str).find()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static boolean isEmailAddress(EditText editText, boolean z) {
        return isValid(editText, EMAIL_REGEX, EMAIL_MSG, z);
    }

    public static Boolean isNumericData(String str) {
        if (Pattern.compile(NUMBER_ONLY_REGEX).matcher(str).find()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static Boolean isOTPString(String str, String str2, String str3) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("\\d{");
        outline73.append(str2.toString());
        outline73.append(",");
        outline73.append(str3);
        outline73.append("}");
        if (Pattern.compile(outline73.toString()).matcher(str).find()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static boolean isPhoneNumber(EditText editText, boolean z) {
        return isValid(editText, PHONE_REGEX, PHONE_MSG, z);
    }

    public static boolean isValid(EditText editText, String str, String str2, boolean z) {
        String trim = editText.getText().toString().trim();
        editText.setError(null);
        if (z && !hasText(editText)) {
            return false;
        }
        if (!z || Pattern.matches(str, trim)) {
            return true;
        }
        editText.setError(str2);
        return false;
    }

    public static Boolean isValidMobileNo(String str) {
        if (!Pattern.compile("^[7-9][0-9]{9}$", 2).matcher(str).matches()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean isValidName(String str) {
        if (Pattern.compile(ALPHANUM_WITH_DOT_REGEX).matcher(str).find()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static Boolean isValidVPA(String str) {
        if (Pattern.compile(VPA_REGEX).matcher(str).find()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
