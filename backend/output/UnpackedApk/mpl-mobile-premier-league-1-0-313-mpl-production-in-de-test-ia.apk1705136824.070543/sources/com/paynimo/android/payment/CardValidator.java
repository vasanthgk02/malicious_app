package com.paynimo.android.payment;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.facebook.react.modules.network.NetworkingModule;
import com.paynimo.android.payment.CardTypeParser.CardType;
import com.paynimo.android.payment.util.Validation;
import java.util.Calendar;
import java.util.Collection;
import java.util.regex.Pattern;

public class CardValidator {
    public static boolean isValidCardType(Context context, EditText editText, CardType cardType) {
        return cardType != CardType.Invalid;
    }

    public static boolean luhnCheck(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return luhnCheck(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean validate(Context context, EditText editText, EditText editText2, EditText editText3, EditText editText4, CardType cardType, Collection<CardType> collection) {
        boolean z = validateDate(context, editText3, false) && (validateCreditCardNumber(context, editText2, cardType, collection) && validateName(context, editText));
        if (!validateCheckNumber(context, editText4, cardType) || !z) {
            return false;
        }
        return true;
    }

    public static boolean validateCheckNumber(Context context, EditText editText, CardType cardType) {
        editText.setError(null);
        if (validateIsEmpty(editText.getText().toString())) {
            editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
            editText.requestFocus();
            return false;
        }
        if (cardType == CardType.AmericanExpress) {
            if (!(editText.length() == CardType.AmericanExpress.getCVCLength() || editText.length() == CardType.AmericanExpress.getCVCLength() - 1)) {
                editText.setTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier("errorTextColor", "color", context.getPackageName())));
                return false;
            }
        } else if (editText.getText().length() != 3) {
            editText.setTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier("errorTextColor", "color", context.getPackageName())));
            return false;
        }
        return true;
    }

    public static boolean validateCreditCardNumber(Context context, EditText editText, CardType cardType, Collection<CardType> collection) {
        collection.toString();
        cardType.toString();
        editText.setError(null);
        if (validateIsEmpty(editText.getText().toString())) {
            editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
            editText.requestFocus();
            return false;
        }
        String replaceAll = editText.getText().toString().replaceAll("\\s", "");
        if (cardType.getMinLength() == cardType.getMaxLength() && cardType.getMaxLength() != replaceAll.length()) {
            editText.setTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier("errorTextColor", "color", context.getPackageName())));
            return false;
        } else if (replaceAll.length() < cardType.getMinLength() || replaceAll.length() > cardType.getMaxLength()) {
            editText.setTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier("errorTextColor", "color", context.getPackageName())));
            return false;
        } else if (!cardType.isLuhn() || luhnCheck(replaceAll)) {
            return true;
        } else {
            editText.setTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier("errorTextColor", "color", context.getPackageName())));
            return false;
        }
    }

    public static boolean validateDate(Context context, EditText editText, boolean z) {
        boolean z2;
        editText.setError(null);
        if (validateIsEmpty(editText.getText().toString())) {
            editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
            editText.requestFocus();
            return false;
        }
        String obj = editText.getText().toString();
        if (obj.length() > 4) {
            String substring = obj.substring(0, 2);
            String substring2 = obj.substring(3, 5);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            try {
                instance2.set(2, Integer.parseInt(substring) - 1);
                z2 = false;
            } catch (NumberFormatException unused) {
                editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
                editText.requestFocus();
                z2 = true;
            }
            try {
                instance2.set(1, Integer.parseInt(substring2) + 2000 + 0);
            } catch (NumberFormatException unused2) {
                editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
                editText.requestFocus();
                z2 = true;
            }
            if (z2) {
                return false;
            }
            instance2.set(5, instance2.getActualMaximum(5));
            instance2.set(11, 23);
            instance2.set(12, 59);
            if (instance2.before(instance)) {
                if (z) {
                    editText.setError(context.getString(context.getResources().getIdentifier("paynimo_expiryMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
                }
                editText.setTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier("errorTextColor", "color", context.getPackageName())));
                return false;
            }
        } else if (obj.length() <= 4) {
            if (z) {
                editText.setError(context.getString(context.getResources().getIdentifier("paynimo_expiryMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
            }
            editText.setTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier("errorTextColor", "color", context.getPackageName())));
            return false;
        }
        return true;
    }

    public static boolean validateDateFormat(String str) {
        return Pattern.compile("((^0(?![^1-9])[1-9]?)|(^1(?![^012])[012]?))(?![^\\/])\\/?[0-9]{0,2}$").matcher(str).find();
    }

    public static boolean validateIsEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean validateName(Context context, EditText editText) {
        if (validateIsEmpty(editText.getText().toString())) {
            return true;
        }
        if (Validation.isValidName(editText.getText().toString()).booleanValue() && editText.getText().toString().trim().length() < 60) {
            return true;
        }
        editText.setError(context.getString(context.getResources().getIdentifier("paynimo_emptyMSG", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName())));
        editText.requestFocus();
        return false;
    }

    public static boolean luhnCheck(long j) {
        String valueOf = String.valueOf(j);
        int i = 0;
        boolean z = false;
        for (int length = valueOf.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(valueOf.substring(length, length + 1));
            if (z) {
                parseInt *= 2;
                if (parseInt > 9) {
                    parseInt -= 9;
                }
            }
            i += parseInt;
            z = !z;
        }
        if (i % 10 == 0) {
            return true;
        }
        return false;
    }

    public static boolean validate(Context context, EditText editText, EditText editText2, CardType cardType, Collection<CardType> collection) {
        return validateCreditCardNumber(context, editText2, cardType, collection) && validateName(context, editText);
    }

    public static boolean validateDate(Context context, String str, String str2) {
        boolean z;
        if (validateIsEmpty(str) || validateIsEmpty(str2)) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        try {
            instance2.set(2, Integer.parseInt(str) - 1);
            z = false;
        } catch (NumberFormatException unused) {
            z = true;
        }
        try {
            instance2.set(1, Integer.parseInt(str2));
        } catch (NumberFormatException unused2) {
            z = true;
        }
        if (z) {
            return false;
        }
        instance2.set(5, instance2.getActualMaximum(5));
        instance2.set(11, 23);
        instance2.set(12, 59);
        if (instance2.before(instance)) {
            return false;
        }
        return true;
    }
}
