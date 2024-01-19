package com.paynimo.android.payment.util;

import android.content.Context;
import android.util.Patterns;
import androidx.core.content.ContextCompat;
import com.facebook.react.modules.network.NetworkingModule;
import java.util.Map;
import java.util.regex.Pattern;

public class d {
    public static boolean checkPermission(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static Object getKeyFromValue(Map map, Object obj) {
        for (Object next : map.keySet()) {
            if (map.get(next).equals(obj)) {
                return next;
            }
        }
        return null;
    }

    public static boolean validateAadharNumber(String str) {
        boolean matches = Pattern.compile("\\d{12}").matcher(str).matches();
        return matches ? e.validateVerhoeff(str) : matches;
    }

    public static boolean validateAccHolderName(Context context, String str) {
        return Pattern.compile(context.getResources().getString(context.getResources().getIdentifier("regex_acc_holder_name", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName()))).matcher(str).matches() && !Pattern.compile(context.getResources().getString(context.getResources().getIdentifier("regex_number_only", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName()))).matcher(str).matches();
    }

    public static boolean validateAccountNo(Context context, String str) {
        return Pattern.compile(context.getResources().getString(context.getResources().getIdentifier("regex_acc_no", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName()))).matcher(str).matches();
    }

    public static boolean validateEmail(String str) {
        return Pattern.compile(Patterns.EMAIL_ADDRESS.pattern()).matcher(str).matches();
    }

    public static boolean validateIFSC(Context context, String str) {
        return Pattern.compile(context.getResources().getString(context.getResources().getIdentifier("regex_ifsc", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName()))).matcher(str).matches();
    }

    public static boolean validateMobileNo(Context context, String str) {
        return Pattern.compile(context.getResources().getString(context.getResources().getIdentifier("regex_mobile", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName()))).matcher(str).matches();
    }

    public static boolean validatePAN(Context context, String str) {
        return Pattern.compile(context.getResources().getString(context.getResources().getIdentifier("regex_pan", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName()))).matcher(str).matches();
    }

    public static boolean validatePhone(String str) {
        return Pattern.compile(Patterns.PHONE.pattern()).matcher(str).matches();
    }
}
