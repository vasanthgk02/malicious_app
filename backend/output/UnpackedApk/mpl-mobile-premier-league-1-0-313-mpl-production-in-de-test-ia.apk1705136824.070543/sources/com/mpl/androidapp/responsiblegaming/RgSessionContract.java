package com.mpl.androidapp.responsiblegaming;

import android.net.Uri;

public class RgSessionContract {
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://com.mpl.androidapp.rgsessionprovider");
    public static final String CONTENT_AUTHORITY = "com.mpl.androidapp.rgsessionprovider";
    public static final String CONTENT_AUTHORITY_POST_FIX = ".rgsessionprovider";
    public static final String PATH_CONFIG = "config";
    public static final String PATH_SESSIONS = "session";
    public static final String PATH_SESSION_COUNT = "session_count";
}
