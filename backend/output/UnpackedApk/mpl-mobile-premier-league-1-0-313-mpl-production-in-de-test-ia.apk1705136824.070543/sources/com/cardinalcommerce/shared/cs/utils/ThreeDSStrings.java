package com.cardinalcommerce.shared.cs.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeDSStrings {
    public static final char[] CHALLENGE_CANCEL_CHAR = "01".toCharArray();
    public static final char[] CHALLENGE_CANCEL_ERROR = "06".toCharArray();
    public static final char[] DEFAULT_CHALLENGE_NO_ENTRY_VALUE = "Y".toCharArray();
    public static final char[] DEFAULT_CHAR_VALUE = new char[0];
    public static final boolean IS_EXTERNAL_BUILD = true;
    public static String SDKVersion = "2.2.5-2";
    public static final char[] WHITE_LIST_NOT_SELECTED_VALUE = "N".toCharArray();
    public static final char[] WHITE_LIST_SELECTED_VALUE = "Y".toCharArray();
    public static final List<String> supportedMessageVersions = Arrays.asList(new String[]{"2.1.0", "2.2.0"});

    static {
        new ArrayList();
    }
}
