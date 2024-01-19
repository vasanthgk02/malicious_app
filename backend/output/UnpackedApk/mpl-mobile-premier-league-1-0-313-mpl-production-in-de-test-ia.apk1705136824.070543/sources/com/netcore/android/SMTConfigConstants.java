package com.netcore.android;

import androidx.annotation.Keep;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/netcore/android/SMTConfigConstants;", "", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTSDKConstants.kt */
public final class SMTConfigConstants {
    public static final String APP_INBOX_API_PATH = "app/v1/inbox";
    public static final int BOD_FOR_PHONE = 2602;
    public static final int BOD_FOR_TABLET = 3602;
    public static final String BROADCAST_EVENT_AUDIO_DISMISS = "com.smartech.AUDIO_NOTIF_DISMISS";
    public static final String BROADCAST_EVENT_INBOX_REFRESH = "com.smartech.EVENT_INBOX_REFRESH";
    public static final String BROADCAST_EVENT_PN_CLICKED = "com.smartech.EVENT_PN_CLICKED";
    public static final String BROADCAST_EVENT_PN_DISMISSED = "com.smartech.EVENT_PN_DISMISSED";
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_BATCH_INTERVAL = 30;
    public static final int DEFAULT_BATCH_SIZE = 5;
    public static final int DEFAULT_EVENT_LIMIT_SIZE = 200;
    public static final int DEFAULT_GEOFENCE_DIST = 50;
    public static final int DEFAULT_GEOFENCE_LAST_MODIFIED_DATE = 0;
    public static final boolean DEFAULT_IS_APP_INBOX_ENABLED = false;
    public static final boolean DEFAULT_IS_FETCH_LOCATION = true;
    public static final boolean DEFAULT_IS_GEOFENCE_ENABLED = false;
    public static final boolean DEFAULT_IS_INIT_API_CALL_SUCCESSFUL = false;
    public static final boolean DEFAULT_IS_PANEL_ACTIVE = false;
    public static final boolean DEFAULT_IS_PUSH_AMP_ENABLED = true;
    public static final boolean DEFAULT_IS_SDK_ACTIVE = false;
    public static final int DEFAULT_MEDIA_CACHING_SIZE = 50;
    public static final int DEFAULT_MSG_CACHING_PERIOD = 7;
    public static final int DEFAULT_PUSH_AMP_INTERVAL = 15;
    public static final int DEFAULT_SESSION_INTERVAL = 30;
    public static final int DEFAULT_TOKEN_INTERVAL = 60;
    public static final String EXTERNAL_FILE_DIR = "/netcore";
    public static final String EXTERNAL_FILE_NAME = "netcore_guid.txt";
    public static final String LOCATION_PERMISSION_BG_KEY = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String LOCATION_PERMISSION_MF_KEY = "android.permission.ACCESS_FINE_LOCATION";
    public static final String OS_NAME = "android";
    public static final String PUSHAMP_API_PATH = "app/v1/pushamp";
    public static final String READ_STORAGE_PERMISSION_MF_KEY = "android.permission.READ_EXTERNAL_STORAGE";
    public static final int READ_TIME_OUT = 60000;
    public static final String REQUEST_PARAM_KEY_APP_ID = "appid";
    public static final String REQUEST_PARAM_KEY_GUID = "guid";
    public static final String REQUEST_PARAM_KEY_IDENTITY = "identity";
    public static final String REQUEST_PARAM_KEY_OS = "os";
    public static final String SCREEN_ORIENTATION_LANDSCAPE = "landscape";
    public static final String SCREEN_ORIENTATION_PORTRAIT = "portrait";
    public static final String SERVER_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String SMT_BROADCAST_EVENT_PN_INBOX_CLICK = "com.smartech.EVENT_PN_INBOX_CLICK";
    public static final String SMT_PLATFORM = "app";
    public static final String SMT_SDK = "SmartechSDK";
    public static final String SMT_SOURCE = "smartech";
    public static final String TRACK_API_PATH = "app/v1/track_appact";
    public static final String WRITE_STORAGE_PERMISSION_MF_KEY = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final int WRITE_TIME_OUT = 60000;

    /* renamed from: a  reason: collision with root package name */
    public static final long f994a = TimeUnit.DAYS.toMillis(30);

    /* renamed from: b  reason: collision with root package name */
    public static final long f995b = TimeUnit.HOURS.toMillis(6);

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b&\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b=\u0010>R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0016\u0010\u0018\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0016\u0010\u001a\u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0016\u0010!\u001a\u00020\u00198\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010\"\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u000eR\u0016\u0010#\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u000eR\u0016\u0010$\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u000eR\u0016\u0010%\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u000eR\u0016\u0010&\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u000eR\u0016\u0010'\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u000bR\u0016\u0010(\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b(\u0010\u000bR\u0016\u0010)\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u000bR\u0016\u0010*\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u000bR\u0016\u0010+\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\u000bR\u0016\u0010,\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b,\u0010\u000bR\u0016\u0010-\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b-\u0010\u000bR\u0016\u0010.\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b.\u0010\u000eR\u0016\u0010/\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b/\u0010\u000bR\u0016\u00100\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b0\u0010\u000bR\u0016\u00101\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b1\u0010\u000bR\u0016\u00102\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b3\u0010\u000bR\u0016\u00104\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b4\u0010\u000bR\u0016\u00105\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b5\u0010\u000bR\u0016\u00106\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b7\u0010\u000bR\u0016\u00108\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b8\u0010\u000bR\u0016\u00109\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b9\u0010\u000bR\u0016\u0010:\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b:\u0010\u000bR\u0016\u0010;\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b;\u0010\u000bR\u0016\u0010<\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b<\u0010\u000e¨\u0006?"}, d2 = {"Lcom/netcore/android/SMTConfigConstants$Companion;", "", "", "NOTIFICATION_EXPIRY_TIME", "J", "getNOTIFICATION_EXPIRY_TIME", "()J", "MAX_CAP_PAMP_INTERVAL", "getMAX_CAP_PAMP_INTERVAL", "", "APP_INBOX_API_PATH", "Ljava/lang/String;", "", "BOD_FOR_PHONE", "I", "BOD_FOR_TABLET", "BROADCAST_EVENT_AUDIO_DISMISS", "BROADCAST_EVENT_INBOX_REFRESH", "BROADCAST_EVENT_PN_CLICKED", "BROADCAST_EVENT_PN_DISMISSED", "DEFAULT_BATCH_INTERVAL", "DEFAULT_BATCH_SIZE", "DEFAULT_EVENT_LIMIT_SIZE", "DEFAULT_GEOFENCE_DIST", "DEFAULT_GEOFENCE_LAST_MODIFIED_DATE", "", "DEFAULT_IS_APP_INBOX_ENABLED", "Z", "DEFAULT_IS_FETCH_LOCATION", "DEFAULT_IS_GEOFENCE_ENABLED", "DEFAULT_IS_INIT_API_CALL_SUCCESSFUL", "DEFAULT_IS_PANEL_ACTIVE", "DEFAULT_IS_PUSH_AMP_ENABLED", "DEFAULT_IS_SDK_ACTIVE", "DEFAULT_MEDIA_CACHING_SIZE", "DEFAULT_MSG_CACHING_PERIOD", "DEFAULT_PUSH_AMP_INTERVAL", "DEFAULT_SESSION_INTERVAL", "DEFAULT_TOKEN_INTERVAL", "EXTERNAL_FILE_DIR", "EXTERNAL_FILE_NAME", "LOCATION_PERMISSION_BG_KEY", "LOCATION_PERMISSION_MF_KEY", "OS_NAME", "PUSHAMP_API_PATH", "READ_STORAGE_PERMISSION_MF_KEY", "READ_TIME_OUT", "REQUEST_PARAM_KEY_APP_ID", "REQUEST_PARAM_KEY_GUID", "REQUEST_PARAM_KEY_IDENTITY", "REQUEST_PARAM_KEY_OS", "SCREEN_ORIENTATION_LANDSCAPE", "SCREEN_ORIENTATION_PORTRAIT", "SERVER_TIME_FORMAT", "SMT_BROADCAST_EVENT_PN_INBOX_CLICK", "SMT_PLATFORM", "SMT_SDK", "SMT_SOURCE", "TRACK_API_PATH", "WRITE_STORAGE_PERMISSION_MF_KEY", "WRITE_TIME_OUT", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTSDKConstants.kt */
    public static final class Companion {
        public Companion() {
        }

        public final long getMAX_CAP_PAMP_INTERVAL() {
            return SMTConfigConstants.f995b;
        }

        public final long getNOTIFICATION_EXPIRY_TIME() {
            return SMTConfigConstants.f994a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
