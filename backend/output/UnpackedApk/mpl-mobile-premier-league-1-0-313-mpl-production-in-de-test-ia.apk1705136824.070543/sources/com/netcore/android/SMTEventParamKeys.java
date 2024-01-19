package com.netcore.android;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/netcore/android/SMTEventParamKeys;", "", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
@Keep
/* compiled from: SMTSDKConstants.kt */
public final class SMTEventParamKeys {
    public static final Companion Companion = new Companion(null);
    public static final String SMT_AD_ID = "advertiserId";
    public static final String SMT_APN_CLICK_LINK = "apnClickLink";
    public static final String SMT_APP_BUILD = "appBuild";
    public static final String SMT_APP_BUNDLE_ID = "appBundleId";
    public static final String SMT_APP_ID = "appId";
    public static final String SMT_APP_VERSION = "appVersion";
    public static final String SMT_ATCA = "atca";
    public static final String SMT_ATCI = "atci";
    public static final String SMT_ATCM = "atcm";
    public static final String SMT_ATCS = "atcs";
    public static final String SMT_ATTRIBUTE_PARAMS = "attrParams";
    public static final String SMT_AT_OTHER = "otherAttrParams";
    public static final String SMT_BOD = "bod";
    public static final String SMT_CAN_TRACK_REINSTALL = "canTrackRI";
    public static final String SMT_CARRIER = "carrier";
    public static final String SMT_CG = "cg";
    public static final String SMT_CG_CONTROL_GROUP = "cgControlGroup";
    public static final String SMT_CG_RANDOM_NO = "cgRandom";
    public static final String SMT_CG_REPEAT = "cgRepeat";
    public static final String SMT_CLEAR_IDENTITY = "clearIdentity";
    public static final String SMT_COUNTRY_CODE = "countryCode";
    public static final String SMT_CT = "ct";
    public static final String SMT_DEVICE_HEIGHT = "deviceHeight";
    public static final String SMT_DEVICE_LOCALE = "deviceLocale";
    public static final String SMT_DEVICE_MAKE = "deviceMake";
    public static final String SMT_DEVICE_MODEL = "deviceModel";
    public static final String SMT_DEVICE_UID = "deviceUniqueId";
    public static final String SMT_DEVICE_WIDTH = "deviceWidth";
    public static final String SMT_EVENT_CRASH_MESSAGE = "errorMsg";
    public static final String SMT_EVENT_ID = "eventId";
    public static final String SMT_EVENT_NAME = "eventName";
    public static final String SMT_EVENT_TIME = "eventTime";
    public static final String SMT_GUID = "guid";
    public static final String SMT_GWSOURCE = "gwSource";
    public static final String SMT_IDENTITY = "identity";
    public static final String SMT_INBOX_CLICK_LINK = "inboxClickLink";
    public static final String SMT_IN_APP_CLICK_LINK = "inAppClickLink";
    public static final String SMT_IS_AMPLIFIED = "isAmplified";
    public static final String SMT_LATE_BIND = "lateBind";
    public static final String SMT_LATITUDE = "lat";
    public static final String SMT_LONGITUDE = "lng";
    public static final String SMT_MID = "mid";
    public static final String SMT_NETWORK_MODE = "networkMode";
    public static final String SMT_OS_NAME = "osName";
    public static final String SMT_OS_VERSION = "osVersion";
    public static final String SMT_PAYLOAD = "payload";
    public static final String SMT_PNMETA = "pnMeta";
    public static final String SMT_PN_REPLY = "pnReply";
    public static final String SMT_PUSH_TOKENS = "pushTokens";
    public static final String SMT_PUSH_TOKEN_CURRENT = "pushToken";
    public static final String SMT_PUSH_TOKEN_OLD = "pushTokenOld";
    public static final String SMT_RADIO = "radio";
    public static final String SMT_REQUEST_TIME = "requestTime";
    public static final String SMT_RETRY = "retry";
    public static final String SMT_SCREEN_ORIENTATION = "screenOrientation";
    public static final String SMT_SDK_VERSION = "sdkVersion";
    public static final String SMT_SESSION_ID = "sessionId";
    public static final String SMT_TIME_ZONE = "timeZone";
    public static final String SMT_TRID = "trid";
    public static final String SMT_USE_ADV_ID = "useAdvId";
    public static final String SMT_VENDOR_ID = "vendorId";

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\bA\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bA\u0010BR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u0004R\u0016\u0010\"\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0004R\u0016\u0010$\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u0004R\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u0004R\u0016\u0010&\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u0004R\u0016\u0010'\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u0004R\u0016\u0010(\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b(\u0010\u0004R\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u0004R\u0016\u0010*\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u0004R\u0016\u0010+\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\u0004R\u0016\u0010,\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b,\u0010\u0004R\u0016\u0010-\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b-\u0010\u0004R\u0016\u0010.\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b.\u0010\u0004R\u0016\u0010/\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b/\u0010\u0004R\u0016\u00100\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b0\u0010\u0004R\u0016\u00101\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b1\u0010\u0004R\u0016\u00102\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b2\u0010\u0004R\u0016\u00103\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b3\u0010\u0004R\u0016\u00104\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b4\u0010\u0004R\u0016\u00105\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b5\u0010\u0004R\u0016\u00106\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b6\u0010\u0004R\u0016\u00107\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b7\u0010\u0004R\u0016\u00108\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b8\u0010\u0004R\u0016\u00109\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b9\u0010\u0004R\u0016\u0010:\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b:\u0010\u0004R\u0016\u0010;\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b;\u0010\u0004R\u0016\u0010<\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b<\u0010\u0004R\u0016\u0010=\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b=\u0010\u0004R\u0016\u0010>\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b>\u0010\u0004R\u0016\u0010?\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b?\u0010\u0004R\u0016\u0010@\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b@\u0010\u0004¨\u0006C"}, d2 = {"Lcom/netcore/android/SMTEventParamKeys$Companion;", "", "", "SMT_AD_ID", "Ljava/lang/String;", "SMT_APN_CLICK_LINK", "SMT_APP_BUILD", "SMT_APP_BUNDLE_ID", "SMT_APP_ID", "SMT_APP_VERSION", "SMT_ATCA", "SMT_ATCI", "SMT_ATCM", "SMT_ATCS", "SMT_ATTRIBUTE_PARAMS", "SMT_AT_OTHER", "SMT_BOD", "SMT_CAN_TRACK_REINSTALL", "SMT_CARRIER", "SMT_CG", "SMT_CG_CONTROL_GROUP", "SMT_CG_RANDOM_NO", "SMT_CG_REPEAT", "SMT_CLEAR_IDENTITY", "SMT_COUNTRY_CODE", "SMT_CT", "SMT_DEVICE_HEIGHT", "SMT_DEVICE_LOCALE", "SMT_DEVICE_MAKE", "SMT_DEVICE_MODEL", "SMT_DEVICE_UID", "SMT_DEVICE_WIDTH", "SMT_EVENT_CRASH_MESSAGE", "SMT_EVENT_ID", "SMT_EVENT_NAME", "SMT_EVENT_TIME", "SMT_GUID", "SMT_GWSOURCE", "SMT_IDENTITY", "SMT_INBOX_CLICK_LINK", "SMT_IN_APP_CLICK_LINK", "SMT_IS_AMPLIFIED", "SMT_LATE_BIND", "SMT_LATITUDE", "SMT_LONGITUDE", "SMT_MID", "SMT_NETWORK_MODE", "SMT_OS_NAME", "SMT_OS_VERSION", "SMT_PAYLOAD", "SMT_PNMETA", "SMT_PN_REPLY", "SMT_PUSH_TOKENS", "SMT_PUSH_TOKEN_CURRENT", "SMT_PUSH_TOKEN_OLD", "SMT_RADIO", "SMT_REQUEST_TIME", "SMT_RETRY", "SMT_SCREEN_ORIENTATION", "SMT_SDK_VERSION", "SMT_SESSION_ID", "SMT_TIME_ZONE", "SMT_TRID", "SMT_USE_ADV_ID", "SMT_VENDOR_ID", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTSDKConstants.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
