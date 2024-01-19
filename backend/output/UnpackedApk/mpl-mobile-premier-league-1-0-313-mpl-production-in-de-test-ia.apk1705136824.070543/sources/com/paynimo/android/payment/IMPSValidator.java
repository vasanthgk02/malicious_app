package com.paynimo.android.payment;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.facebook.react.modules.network.NetworkingModule;
import com.paynimo.android.payment.util.Validation;
import java.util.regex.Pattern;

public class IMPSValidator {
    public static boolean validate(Context context, EditText editText, EditText editText2, EditText editText3) {
        boolean z = validateMMIDNumber(context, editText2) && validateMobileNumber(context, editText);
        if (!validateOTP(context, editText3) || !z) {
            return false;
        }
        return true;
    }

    public static boolean validateIsEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean validateMMIDNumber(Context context, EditText editText) {
        Boolean bool = Boolean.FALSE;
        if (validateIsEmpty(editText.getText().toString())) {
            editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
            return false;
        }
        if (editText.getText().toString().length() != 7 || !Validation.isNumericData(editText.getText().toString()).booleanValue()) {
            editText.setError(context.getString(context.getResources().getIdentifier("paynimo_invalidMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
        } else {
            bool = Boolean.TRUE;
        }
        return bool.booleanValue();
    }

    public static boolean validateMobileNumber(Context context, EditText editText) {
        if (validateIsEmpty(editText.getText().toString())) {
            editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
            return false;
        }
        if (Pattern.compile("^[7-9][0-9]{9}$", 2).matcher(editText.getText().toString()).matches()) {
            return true;
        }
        editText.setError(context.getString(context.getResources().getIdentifier("paynimo_invalidMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
        return false;
    }

    public static boolean validateOTP(Context context, EditText editText) {
        Boolean bool = Boolean.FALSE;
        if (validateIsEmpty(editText.getText().toString())) {
            editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
            return false;
        }
        if (editText.getText().toString().length() < 4 || editText.getText().toString().length() > 7 || !Validation.isOTPString(editText.getText().toString(), String.valueOf(3), String.valueOf(6)).booleanValue()) {
            editText.setError(context.getString(context.getResources().getIdentifier("paynimo_invalidMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
        } else {
            bool = Boolean.TRUE;
        }
        return bool.booleanValue();
    }
}
