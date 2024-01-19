package com.razorpay;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public class BaseConstants {
    public static final String CANCEL_PARAM = "/cancel?";
    public static final String DEFAULT_PROGRESS_COLOR = "#4aa3df";
    public static final String DEFAULT_SENDER = "razorpay";
    public static final String DEVELOPMENT = "development";
    public static final String GOOGLE_PAY_PKG = "com.google.android.apps.nbu.paisa.user";
    public static final int INCOMPATIBLE_PLUGIN = 7;
    public static final int INVALID_OPTIONS = 3;
    public static final String KEY_ID_PARAM = "key_id=";
    public static final String KEY_MISSING_EXCEPTION = "Please set your Razorpay API key in AndroidManifest.xml";
    public static final String METADATA_KEY = "com.razorpay.ApiKey";
    public static final String METADATA_PLUGIN_PREFIX = "com.razorpay.plugin.";
    public static final int NETWORK_ERROR = 2;
    public static final int PARSING_ERROR = 4;
    public static final int PAYMENT_CANCELED = 0;
    public static final int PAYMENT_ERROR = 5;
    public static final String PAYMENT_PREFERENCES_CACHE_KEY = "rzp_payment_preferences";
    public static final String PRODUCTION = "production";
    public static final String RZP_PAYMENTS_ENDPOINT = "https://api.razorpay.com/v1/payments/";
    public static final String RZP_PROGRESS_COLOR = "#0783B4";
    public static final String RZP_URL = "https://api.razorpay.com";
    public static final int SMS_CONSENT_REQUEST = 1001;
    public static final String STATUS_PARAM = "/status?";
    public static final int TLS_ERROR = 6;
    public static final String TLS_ERROR_MESSAGE = "TLSv1  is not supported for security reasons";
    public static final String TRUE_CALLER_PKG = "com.truecaller";
    public static final String UNKNOWN = "unknown";
    public static final int UPI_REQUEST_CODE = 99;
    public static final String UPI_URL_SCHEMA = "upi://pay";
}
