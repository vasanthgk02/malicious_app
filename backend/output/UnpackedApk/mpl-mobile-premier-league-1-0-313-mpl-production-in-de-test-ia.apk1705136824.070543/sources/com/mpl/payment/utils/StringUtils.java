package com.mpl.payment.utils;

public class StringUtils {
    public static String getMessageFromException(Exception exc, String str) {
        return (exc == null || exc.getMessage() == null) ? str : exc.getMessage();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
