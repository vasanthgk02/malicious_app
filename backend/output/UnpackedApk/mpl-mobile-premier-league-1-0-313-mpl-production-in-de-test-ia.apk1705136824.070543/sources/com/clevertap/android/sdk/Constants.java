package com.clevertap.android.sdk;

import com.mpl.androidapp.utils.Constant.EventsConstants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public interface Constants {
    public static final HashSet<String> ALL_IDENTITY_KEYS = new HashSet<>(Arrays.asList(new String[]{"Identity", EventsConstants.USER_EMAIL_CLEVER_TAP, EventsConstants.USER_PHONE_CLEVER_TAP}));
    public static final HashSet<String> LEGACY_IDENTITY_KEYS = new HashSet<>(Arrays.asList(new String[]{"Identity", EventsConstants.USER_EMAIL_CLEVER_TAP}));
    public static final String[] NULL_STRING_ARRAY = new String[0];
    public static final String[] SYSTEM_EVENTS = {"Notification Clicked", "Notification Viewed", "Geocluster Entered", "Geocluster Exited"};

    static {
        new SimpleDateFormat("MM/dd/yyyy", Locale.US);
    }
}
