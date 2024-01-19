package com.freshchat.consumer.sdk.b;

import android.content.Context;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.beans.FCLocale;
import com.freshchat.consumer.sdk.beans.config.DefaultAccountConfig;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.d;
import com.freshchat.consumer.sdk.j.i;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.j.o;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends i<e> {
    public static volatile e dK;
    public static final String[] dL = {"CONFIG_DOMAIN", "CONFIG_APP_ID", "CONFIG_APP_KEY", "CONFIG_VOICE_MESSAGING_ENABLED", "CONFIG_GALLERY_SELECTION_ENABLED", "CONFIG_LINK_REGEX", "CONFIG_LINK_SCHEME", "CONFIG_NOTIFICATION_PRIORITY", "CONFIG_NOTIFICATION_IMPORTANCE", "CONFIG_NOTIFICATION_SMALL_ICON", "CONFIG_NOTIFICATION_LARGE_ICON", "CONFIG_NOTIFICATION_SOUND_ENABLED", "CONFIG_NOTIFICATION_SOUND_URI", "CONFIG_RC_LAUNCH_DEEPLINK_TARGET_FROM_NOTIFICATION", "SOLUTIONS_LAST_REQUESTED_TIME", "SOLUTIONS_LAST_MODIFIED_AT", "SOLUTIONS_LAST_RECEIVED_LOCALE", "SOLUTIONS_LAST_REQUESTED_LOCALE", "REMOTE_CONFIG_LAST_UPDATED_TIME", "CONFIG_TEAM_MEMBER_INFO_VISIBLE", "CONFIG_CAMERA_CAPTURE_ENABLED", "CONFIG_AUDIO_STREAM_SPEAKERPHONE", "CONFIG_FALLBACK_ACTIVITY_FOR_EMPTY_BACKSTACK", "RC_IS_ACCOUNT_ACTIVE", "RC_ENABLED_FEATURES_JSON", "RC_CONFIG_FETCH_INTERVAL", "RC_RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL", "CONFIG_RC_SESSION_TIMEOUT_INTERVAL", "RC_ACTIVE_CONV_WINDOW", "RC_ACTIVE_CONV_FETCH_BACKOFF_RATIO", "RC_ACTIVE_CONV_MIN_FETCH_INTERVAL", "RC_ACTIVE_CONV_MAX_FETCH_INTERVAL", "RC_MSG_FETCH_INTERVAL_NORMAL", "RC_MSG_FETCH_INTERVAL_LAIDBACK", "RC_FAQ_FETCH_INTERVAL_NORMAL", "RC_FAQ_FETCH_INTERVAL_LAIDBACK", "RC_CHANNELS_FETCH_INTERVAL_NORMAL", "RC_CHANNELS_FETCH_INTERVAL_LAIDBACK", "RC_CSAT_AUTO_EXPIRE", "RC_CSAT_AUTO_EXPIRY_INTERVAL", "RC_MESSAGE_MASKING_CONFIG", "RC_UNSUPPORTED_FRAGMENT_CONFIG", "CONFIG_LAST_SESSION_END_TIME", "RC_USER_EVENT_DELAY_IN_MILLIS_UNTIL_UPLOAD", "RC_USER_EVENT_ALLOWED_LIMIT_PER_DAY", "RC_USER_EVENT_BATCH_UPLOAD_COUNT", "RC_USER_EVENT_TRIGGER_UPLOAD_COUNT", "RC_USER_EVENT_MAX_PROPERTIES_LIMIT", "RC_USER_EVENT_MAX_CHARS_PER_EVENT_NAME ", "RC_USER_EVENT_MAX_CHARS_PER_PROPERTY_NAME", "RC_USER_EVENT_MAX_CHARS_PER_PROPERTY_VALUE", "UNREGISTERED_USER_DAU_TRACKING_LAST_UPDATED_TIME", "RC_LIVE_TRANSLATION_ENABLED", "RC_ACCOUNT_FAQ_API_VERSION", "HAS_BUSINESS_HOURS_DETAILS_LOADED"};
    public static final String[] dM = {"CONFIG_USER_FIRST_NAME", "CONFIG_USER_LAST_NAME", "CONFIG_USER_EMAIL", "CONFIG_USER_ALIAS", "CONFIG_USER_PHONE", "CONFIG_USER_PHONE_COUNTRY", "CONFIG_USER_RESTORE_ID", "CONFIG_USER_LOCALE", "CONFIG_USER_REGISTERED", "CONFIG_USER_EXTERNAL_ID", "CONFIG_USER_JWT_ID_TOKEN", "CONFIG_USER_JWT_ID_TOKEN_STATUS", "MESSAGES_LAST_UPDATED_TIME", "CONFIG_VOTED_ARTICLES", "PrevSessionEndTime", "USER_DAU_TRACKING_LAST_UPDATED_TIME", "SDK_VERSION_CODE", "CONFIG_LAST_APP_VER_CODE", "CHANNELS_LAST_REQUESTED_TIME", "CHANNELS_LAST_MODIFIED_AT", "CHANNELS_LAST_RECEIVED_LOCALE", "CHANNELS_LAST_REQUESTED_LOCALE", "FRESHCHAT_USER_EVENTS_DATA", "FRESHCHAT_USER_EVENTS_UPLOADING_DATA", "FRESHCHAT_USER_EVENTS_DAILY_COUNTER", "FRESHCHAT_LAST_EVENT_LOGGED_TIME", "CONFIG_USER_CALENDAR_EMAIL"};
    public final Context context;

    public e(Context context2) {
        super(context2);
        this.context = context2;
    }

    private void bF() {
        remove("CHANNELS_LAST_REQUESTED_LOCALE");
    }

    private void bw() {
        remove("SOLUTIONS_LAST_REQUESTED_LOCALE");
    }

    private void by() {
        remove("SOLUTIONS_LAST_RECEIVED_LOCALE");
    }

    public static e i(Context context2) {
        if (dK == null || !dK.isReady()) {
            synchronized (e.class) {
                try {
                    if (dK == null) {
                        dK = new e(context2.getApplicationContext());
                    }
                }
            }
        }
        return dK;
    }

    public void A(String str) {
        putString("SOLUTIONS_LAST_REQUESTED_LOCALE", str);
    }

    public void B(String str) {
        putString("CHANNELS_LAST_MODIFIED_AT", str);
    }

    public void C(String str) {
        putString("CHANNELS_LAST_RECEIVED_LOCALE", str);
    }

    public void D(int i) {
        putInt("CONFIG_NOTIFICATION_IMPORTANCE", i);
    }

    public void D(String str) {
        putString("CHANNELS_LAST_REQUESTED_LOCALE", str);
    }

    public void D(boolean z) {
        putBoolean("SHOULD_LOAD_CONVERSATION_STATUS", z);
    }

    public void E(int i) {
        putInt("FRESHCHAT_USER_EVENTS_DAILY_COUNTER", i);
    }

    public void E(String str) {
        c("CONFIG_USER_RESTORE_ID", str, false);
    }

    public void F(String str) {
        putString("CONFIG_FALLBACK_ACTIVITY_FOR_EMPTY_BACKSTACK", str);
    }

    public void G(String str) {
        putString("CONFIG_FCM_REGISTRATION_TOKEN", str);
    }

    public void H(String str) {
        c("CONFIG_USER_PHONE_COUNTRY", str, false);
    }

    public void I(String str) {
        c("CONFIG_USER_PHONE", str, false);
    }

    public void J(String str) {
        c("CONFIG_USER_LOCALE", str, false);
    }

    public void L(String str) {
        putString("CONFIG_NOTIFICATION_SOUND_URI", str);
    }

    public void X(int i) {
        putInt("RC_ACCOUNT_FAQ_API_VERSION", i);
    }

    public void Z(String str) {
        putString("FRESHCHAT_USER_EVENTS_DATA", str);
    }

    public void a(JwtTokenStatus jwtTokenStatus) {
        putInt("CONFIG_USER_JWT_ID_TOKEN_STATUS", jwtTokenStatus.asInt());
    }

    public void a(Set<Integer> set) {
        a((String) "RC_RESOLVED_MESSAGE_TYPES", new JSONArray(set));
    }

    public void a(JSONArray jSONArray) {
        a((String) "RC_ENABLED_FEATURES_JSON", jSONArray);
    }

    public void a(JSONObject jSONObject) {
        a((String) "CONFIG_VOTED_ARTICLES", jSONObject);
    }

    public void aX(String str) {
        putString("RC_MESSAGE_MASKING_CONFIG", str);
    }

    public void aa(String str) {
        putString("FRESHCHAT_USER_EVENTS_UPLOADING_DATA", str);
    }

    public void b(Set<Integer> set) {
        a((String) "RC_REOPENED_MESSAGE_TYPES", new JSONArray(set));
    }

    public void bA() {
        at("REMOTE_CONFIG_LAST_UPDATED_TIME");
    }

    public String bB() {
        return getString("CHANNELS_LAST_MODIFIED_AT");
    }

    public FCLocale bC() {
        String string = getString("CHANNELS_LAST_RECEIVED_LOCALE");
        if (as.isEmpty(string)) {
            return null;
        }
        return FCLocale.fromString(string);
    }

    public void bD() {
        remove("CHANNELS_LAST_RECEIVED_LOCALE");
    }

    public String bE() {
        return getString("CHANNELS_LAST_REQUESTED_LOCALE");
    }

    public String bG() {
        return getString("CHANNELS_LAST_REQUESTED_TIME");
    }

    public void bH() {
        at("CHANNELS_LAST_REQUESTED_TIME");
    }

    public String bI() {
        return getString("CONFIG_USER_RESTORE_ID");
    }

    public String bJ() {
        return getString("MESSAGES_LAST_UPDATED_TIME");
    }

    public void bK() {
        at("MESSAGES_LAST_UPDATED_TIME");
    }

    public void bN() {
        bw();
        bF();
    }

    public void bO() {
        bx();
        by();
    }

    public String bP() {
        return getString("CONFIG_FCM_REGISTRATION_TOKEN");
    }

    public int bQ() {
        return getInt("CONFIG_NOTIFICATION_PRIORITY", 0);
    }

    public int bR() {
        return getInt("CONFIG_NOTIFICATION_SMALL_ICON", 0);
    }

    public int bS() {
        return getInt("CONFIG_NOTIFICATION_LARGE_ICON", 0);
    }

    public String bT() {
        return getString("CONFIG_FALLBACK_ACTIVITY_FOR_EMPTY_BACKSTACK");
    }

    public boolean bU() {
        return getBoolean("CONFIG_RC_LAUNCH_DEEPLINK_TARGET_FROM_NOTIFICATION", true);
    }

    public void bW() {
        a(dM);
    }

    public String bX() {
        return getString("CONFIG_USER_PHONE_COUNTRY");
    }

    public String bY() {
        return getString("CONFIG_USER_PHONE");
    }

    public String bZ() {
        return getString("CONFIG_USER_LOCALE");
    }

    public String bf() {
        return "90bd96d1c0b3dbe341cc5a33f373183a";
    }

    public String bg() {
        return getString("CONFIG_USER_FIRST_NAME");
    }

    public String bh() {
        return getString("CONFIG_USER_LAST_NAME");
    }

    public void bh(String str) {
        putString("RC_UNSUPPORTED_FRAGMENT_CONFIG", str);
    }

    public String bi() {
        return getString("CONFIG_USER_EMAIL");
    }

    public String bj() {
        return getString("CONFIG_USER_ALIAS");
    }

    public String bk() {
        return getString("CONFIG_USER_EXTERNAL_ID");
    }

    public boolean bl() {
        return getBoolean("CONFIG_USER_REGISTERED");
    }

    public String bm() {
        return getString("CONFIG_LAST_APP_VER_CODE");
    }

    public void bn(String str) {
        putString("CONFIG_USER_CALENDAR_EMAIL", str);
    }

    public boolean bn() {
        return getBoolean("CONFIG_VOICE_MESSAGING_ENABLED", false);
    }

    public boolean bo() {
        return getBoolean("CONFIG_AUDIO_STREAM_SPEAKERPHONE", true);
    }

    public String bp() {
        return getString("CONFIG_LINK_REGEX");
    }

    public String bq() {
        return getString("CONFIG_LINK_SCHEME");
    }

    public String br() {
        return getString("SOLUTIONS_LAST_REQUESTED_TIME");
    }

    public void bs() {
        at("SOLUTIONS_LAST_REQUESTED_TIME");
    }

    public String bt() {
        return getString("SOLUTIONS_LAST_MODIFIED_AT");
    }

    public FCLocale bu() {
        String string = getString("SOLUTIONS_LAST_RECEIVED_LOCALE");
        if (as.isEmpty(string)) {
            return null;
        }
        return FCLocale.fromString(string);
    }

    public String bv() {
        return getString("SOLUTIONS_LAST_REQUESTED_LOCALE");
    }

    public void bx() {
        remove("SOLUTIONS_LAST_REQUESTED_TIME");
    }

    public String bz() {
        return getString("REMOTE_CONFIG_LAST_UPDATED_TIME");
    }

    public void c(String str) {
        c("CONFIG_USER_JWT_ID_TOKEN", str, false);
    }

    public void c(boolean z) {
        putBoolean("CONFIG_USER_REGISTERED", z);
    }

    public long cQ() {
        return getLong("RC_CSAT_AUTO_EXPIRY_INTERVAL");
    }

    public String ca() {
        return getString("PrevSessionEndTime");
    }

    public void cb() {
        at("PrevSessionEndTime");
    }

    public String cc() {
        return getString("USER_DAU_TRACKING_LAST_UPDATED_TIME");
    }

    public void cd() {
        at("USER_DAU_TRACKING_LAST_UPDATED_TIME");
    }

    public long ce() {
        return getLong("PENDING_LOG_REQUEST_ID", 0);
    }

    public void cf() {
        remove("PENDING_LOG_REQUEST_ID");
    }

    public JSONArray cg() {
        return getJSONArray("RC_ENABLED_FEATURES_JSON");
    }

    public void d(long j) {
        putLong("PENDING_LOG_REQUEST_ID", j);
    }

    public void d(boolean z) {
        putBoolean("CONFIG_TEAM_MEMBER_INFO_VISIBLE", z);
    }

    public boolean doesCsatAutoExpire() {
        return getBoolean("RC_CSAT_AUTO_EXPIRE");
    }

    public void dp() {
        if (eO() && jO()) {
            bo(this.context);
            String gh = gh();
            String bk = bk();
            String bI = bI();
            if (as.a(gh)) {
                aa.a(this.context, true, false);
                o.bA(this.context);
            } else if (as.a(bk) && as.a(bI)) {
                try {
                    aa.a(this.context, true, false);
                    Freshchat.getInstance(this.context).identifyUser(bk, bI);
                } catch (MethodNotAllowedException e2) {
                    e2.printStackTrace();
                }
            } else if (d.aw(this.context)) {
                aa.a(this.context, true, false);
            }
        }
    }

    public void e(boolean z) {
        putBoolean("CONFIG_CAMERA_CAPTURE_ENABLED", z);
    }

    public String ee() {
        return getString("CONFIG_NOTIFICATION_SOUND_URI");
    }

    public void f(boolean z) {
        putBoolean("CONFIG_VOICE_MESSAGING_ENABLED", z);
    }

    public boolean fi() {
        return getBoolean("SHOULD_LOAD_CONVERSATION_STATUS");
    }

    public Set<Integer> fj() {
        return k.b(getJSONArray("RC_RESOLVED_MESSAGE_TYPES"));
    }

    public Set<Integer> fk() {
        return k.b(getJSONArray("RC_REOPENED_MESSAGE_TYPES"));
    }

    public void fl() {
        if (!getBoolean("HAS_BUSINESS_HOURS_DETAILS_LOADED")) {
            remove("MESSAGES_LAST_UPDATED_TIME");
            remove("REMOTE_CONFIG_LAST_UPDATED_TIME");
            remove("CHANNELS_LAST_REQUESTED_TIME");
            remove("CHANNELS_LAST_MODIFIED_AT");
            putBoolean("HAS_BUSINESS_HOURS_DETAILS_LOADED", true);
            putBoolean("SHOULD_LOAD_CONVERSATION_STATUS", true);
            ai.d("FRESHCHAT", "Reloading Business Hours Details");
        }
    }

    public String fq() {
        return getString("RC_MESSAGE_MASKING_CONFIG");
    }

    public void g(boolean z) {
        putBoolean("CONFIG_GALLERY_SELECTION_ENABLED", z);
    }

    public String gG() {
        return getString("FRESHCHAT_USER_EVENTS_DATA", "{}");
    }

    public void gH() {
        remove("FRESHCHAT_USER_EVENTS_DATA");
    }

    public String gI() {
        return getString("FRESHCHAT_USER_EVENTS_UPLOADING_DATA", "{}");
    }

    public int gJ() {
        return getInt("FRESHCHAT_USER_EVENTS_DAILY_COUNTER", 0);
    }

    public void gK() {
        remove("FRESHCHAT_USER_EVENTS_DAILY_COUNTER");
    }

    public long gL() {
        return getLong("FRESHCHAT_LAST_EVENT_LOGGED_TIME", 0);
    }

    public String gP() {
        return getString("UNREGISTERED_USER_DAU_TRACKING_LAST_UPDATED_TIME");
    }

    public void gQ() {
        at("UNREGISTERED_USER_DAU_TRACKING_LAST_UPDATED_TIME");
    }

    public double getActiveConvFetchBackoffRatio() {
        return getDouble("RC_ACTIVE_CONV_FETCH_BACKOFF_RATIO", new DefaultRemoteConfig().getConversationConfig().getActiveConvFetchBackoffRatio());
    }

    public long getActiveConvMaxFetchInterval() {
        return getLong("RC_ACTIVE_CONV_MAX_FETCH_INTERVAL");
    }

    public long getActiveConvMinFetchInterval() {
        return getLong("RC_ACTIVE_CONV_MIN_FETCH_INTERVAL");
    }

    public long getActiveConvWindow() {
        return getLong("RC_ACTIVE_CONV_WINDOW");
    }

    public String getAppId() {
        return getString("CONFIG_APP_ID");
    }

    public String getAppKey() {
        return getString("CONFIG_APP_KEY");
    }

    public long getChannelsFetchIntervalLaidback() {
        return getLong("RC_CHANNELS_FETCH_INTERVAL_LAIDBACK");
    }

    public long getChannelsFetchIntervalNormal() {
        return getLong("RC_CHANNELS_FETCH_INTERVAL_NORMAL");
    }

    public String getDomain() {
        return getString("CONFIG_DOMAIN");
    }

    public long getFaqFetchIntervalLaidback() {
        return getLong("RC_FAQ_FETCH_INTERVAL_LAIDBACK");
    }

    public long getFaqFetchIntervalNormal() {
        return getLong("RC_FAQ_FETCH_INTERVAL_NORMAL");
    }

    public long getMaxAllowedEventsPerDay() {
        return getLong("RC_USER_EVENT_ALLOWED_LIMIT_PER_DAY", 50);
    }

    public long getMaxAllowedPropertiesPerEvent() {
        return getLong("RC_USER_EVENT_MAX_PROPERTIES_LIMIT", 20);
    }

    public int getMaxCharsPerEventName() {
        return getInt("RC_USER_EVENT_MAX_CHARS_PER_EVENT_NAME ", 32);
    }

    public int getMaxCharsPerEventPropertyName() {
        return getInt("RC_USER_EVENT_MAX_CHARS_PER_PROPERTY_NAME", 32);
    }

    public int getMaxCharsPerEventPropertyValue() {
        return getInt("RC_USER_EVENT_MAX_CHARS_PER_PROPERTY_VALUE", 256);
    }

    public long getMaxDelayInMillisUntilUpload() {
        return getLong("RC_USER_EVENT_DELAY_IN_MILLIS_UNTIL_UPLOAD", DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD);
    }

    public long getMaxEventsPerBatch() {
        return getLong("RC_USER_EVENT_BATCH_UPLOAD_COUNT", 10);
    }

    public long getMsgFetchIntervalLaidback() {
        return getLong("RC_MSG_FETCH_INTERVAL_LAIDBACK");
    }

    public long getMsgFetchIntervalNormal() {
        return getLong("RC_MSG_FETCH_INTERVAL_NORMAL");
    }

    public long getRemoteConfigFetchInterval() {
        return getLong("RC_CONFIG_FETCH_INTERVAL");
    }

    public long getResponseTimeExpectationsFetchInterval() {
        return getLong("RC_RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL");
    }

    public long getSessionTimeoutInterval() {
        return getLong("CONFIG_RC_SESSION_TIMEOUT_INTERVAL");
    }

    public long getTriggerUploadOnEventsCount() {
        return getLong("RC_USER_EVENT_TRIGGER_UPLOAD_COUNT", 5);
    }

    public String gh() {
        return getString("CONFIG_USER_JWT_ID_TOKEN");
    }

    public void gi() {
        remove("CONFIG_USER_JWT_ID_TOKEN");
    }

    public int gj() {
        return getInt("CONFIG_USER_JWT_ID_TOKEN_STATUS", -1);
    }

    public boolean gk() {
        return getBoolean("RC_JWT_AUTH_STRICT_MODE_ENABLED");
    }

    public long gl() {
        return getLong("RC_JWT_AUTH_TIMEOUT_INTERVAL");
    }

    public String gm() {
        return getString("RC_UNSUPPORTED_FRAGMENT_CONFIG");
    }

    public long gt() {
        return getLong("CONFIG_LAST_SESSION_END_TIME");
    }

    public void gu() {
        putLong("CONFIG_LAST_SESSION_END_TIME", n.fP());
    }

    public int gw() {
        return getInt("CONFIG_NOTIFICATION_IMPORTANCE", 3);
    }

    public void h(int i) {
        putInt("CONFIG_NOTIFICATION_PRIORITY", i);
    }

    public void h(boolean z) {
        putBoolean("CONFIG_AUDIO_STREAM_SPEAKERPHONE", z);
    }

    public String hA() {
        return getString("CONFIG_USER_CALENDAR_EMAIL");
    }

    public void i(int i) {
        putInt("CONFIG_NOTIFICATION_SMALL_ICON", i);
    }

    public void i(boolean z) {
        putBoolean("CONFIG_NOTIFICATION_SOUND_ENABLED", z);
    }

    public JSONObject iK() {
        return getJSONObject("CONFIG_VOTED_ARTICLES");
    }

    public void iL() {
        remove("CONFIG_VOTED_ARTICLES");
    }

    public int iM() {
        return getInt("RC_ACCOUNT_FAQ_API_VERSION", DefaultAccountConfig.DEFAULT_FAQ_API_VERSION.asInt());
    }

    public long iN() {
        return getLong("CONFIG_FAQ_API_VERSION_UPDATED_AT", 0);
    }

    public void iO() {
        at("CONFIG_FAQ_API_VERSION_UPDATED_AT");
    }

    public void iP() {
        remove("SOLUTIONS_LAST_REQUESTED_TIME");
        remove("SOLUTIONS_LAST_MODIFIED_AT");
        remove("SOLUTIONS_LAST_RECEIVED_LOCALE");
        remove("SOLUTIONS_LAST_REQUESTED_LOCALE");
        iL();
    }

    public void is() {
        remove("CONFIG_USER_RESTORE_ID");
    }

    public boolean isAccountActive() {
        return getBoolean("RC_IS_ACCOUNT_ACTIVE", true);
    }

    public boolean isCameraCaptureEnabled() {
        return getBoolean("CONFIG_CAMERA_CAPTURE_ENABLED", true);
    }

    public boolean isGallerySelectionEnabled() {
        return getBoolean("CONFIG_GALLERY_SELECTION_ENABLED", true);
    }

    public boolean isJwtAuthEnabled() {
        return getBoolean("RC_JWT_AUTH_ENABLED");
    }

    public boolean isNotificationInterceptionEnabled() {
        return getBoolean("CONFIG_NOTIFICATION_INTERCEPTION_ENABLED");
    }

    public boolean isNotificationSoundEnabled() {
        return getBoolean("CONFIG_NOTIFICATION_SOUND_ENABLED", true);
    }

    public boolean isResponseExpectationEnabled() {
        return getBoolean("CONFIG_RESPONSE_EXPECTATION_ENABLED", true);
    }

    public boolean isTeamMemberInfoVisible() {
        return getBoolean("CONFIG_TEAM_MEMBER_INFO_VISIBLE", true);
    }

    public boolean isUserEventsTrackingEnabled() {
        return getBoolean("CONFIG_USER_EVENTS_TRACKING_ENABLED", true);
    }

    public boolean it() {
        return getBoolean("RC_LIVE_TRANSLATION_ENABLED");
    }

    public void j(int i) {
        putInt("CONFIG_NOTIFICATION_LARGE_ICON", i);
    }

    public void j(boolean z) {
        putBoolean("CONFIG_RC_LAUNCH_DEEPLINK_TARGET_FROM_NOTIFICATION", z);
    }

    public void k(int i) {
        putInt("SDK_VERSION_CODE", i);
    }

    public void o(String str) {
        putString("CONFIG_APP_ID", str);
    }

    public void p(String str) {
        putString("CONFIG_APP_KEY", str);
    }

    public void q(String str) {
        c("CONFIG_USER_FIRST_NAME", str, false);
    }

    public void r(String str) {
        c("CONFIG_USER_LAST_NAME", str, false);
    }

    public void s(long j) {
        putLong("RC_CSAT_AUTO_EXPIRY_INTERVAL", j);
    }

    public void s(String str) {
        c("CONFIG_USER_EMAIL", str, false);
    }

    public void setAccountActive(boolean z) {
        putBoolean("RC_IS_ACCOUNT_ACTIVE", z);
    }

    public void setActiveConvFetchBackoffRatio(double d2) {
        putDouble("RC_ACTIVE_CONV_FETCH_BACKOFF_RATIO", d2);
    }

    public void setActiveConvMaxFetchInterval(long j) {
        putLong("RC_ACTIVE_CONV_MAX_FETCH_INTERVAL", j);
    }

    public void setActiveConvMinFetchInterval(long j) {
        putLong("RC_ACTIVE_CONV_MIN_FETCH_INTERVAL", j);
    }

    public void setActiveConvWindow(long j) {
        putLong("RC_ACTIVE_CONV_WINDOW", j);
    }

    public void setChannelsFetchIntervalLaidback(long j) {
        putLong("RC_CHANNELS_FETCH_INTERVAL_LAIDBACK", j);
    }

    public void setChannelsFetchIntervalNormal(long j) {
        putLong("RC_CHANNELS_FETCH_INTERVAL_NORMAL", j);
    }

    public void setCsatAutoExpire(boolean z) {
        putBoolean("RC_CSAT_AUTO_EXPIRE", z);
    }

    public void setDomain(String str) {
        putString("CONFIG_DOMAIN", str);
    }

    public void setFaqFetchIntervalLaidback(long j) {
        putLong("RC_FAQ_FETCH_INTERVAL_LAIDBACK", j);
    }

    public void setFaqFetchIntervalNormal(long j) {
        putLong("RC_FAQ_FETCH_INTERVAL_NORMAL", j);
    }

    public void setJwtAuthEnabled(boolean z) {
        putBoolean("RC_JWT_AUTH_ENABLED", z);
    }

    public void setMaxAllowedEventsPerDay(long j) {
        putLong("RC_USER_EVENT_ALLOWED_LIMIT_PER_DAY", j);
    }

    public void setMaxAllowedPropertiesPerEvent(long j) {
        putLong("RC_USER_EVENT_MAX_PROPERTIES_LIMIT", j);
    }

    public void setMaxCharsPerEventName(int i) {
        putInt("RC_USER_EVENT_MAX_CHARS_PER_EVENT_NAME ", i);
    }

    public void setMaxCharsPerEventPropertyName(int i) {
        putInt("RC_USER_EVENT_MAX_CHARS_PER_PROPERTY_NAME", i);
    }

    public void setMaxCharsPerEventPropertyValue(int i) {
        putLong("RC_USER_EVENT_MAX_CHARS_PER_PROPERTY_VALUE", (long) i);
    }

    public void setMaxDelayInMillisUntilUpload(long j) {
        putLong("RC_USER_EVENT_DELAY_IN_MILLIS_UNTIL_UPLOAD", j);
    }

    public void setMaxEventsPerBatch(long j) {
        putLong("RC_USER_EVENT_BATCH_UPLOAD_COUNT", j);
    }

    public void setMsgFetchIntervalLaidback(long j) {
        putLong("RC_MSG_FETCH_INTERVAL_LAIDBACK", j);
    }

    public void setMsgFetchIntervalNormal(long j) {
        putLong("RC_MSG_FETCH_INTERVAL_NORMAL", j);
    }

    public void setRemoteConfigFetchInterval(long j) {
        putLong("RC_CONFIG_FETCH_INTERVAL", j);
    }

    public void setResponseTimeExpectationsFetchInterval(long j) {
        putLong("RC_RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL", j);
    }

    public void setSessionTimeoutInterval(long j) {
        putLong("CONFIG_RC_SESSION_TIMEOUT_INTERVAL", j);
    }

    public void setTriggerUploadOnEventsCount(long j) {
        putLong("RC_USER_EVENT_TRIGGER_UPLOAD_COUNT", j);
    }

    public void setUserEventsTrackingEnabled(boolean z) {
        putBoolean("CONFIG_USER_EVENTS_TRACKING_ENABLED", z);
    }

    public void t(String str) {
        putString("CONFIG_USER_ALIAS", str);
    }

    public void t(boolean z) {
        putBoolean("RC_JWT_AUTH_STRICT_MODE_ENABLED", z);
    }

    public void u(long j) {
        putLong("RC_JWT_AUTH_TIMEOUT_INTERVAL", j);
    }

    public void u(String str) {
        c("CONFIG_USER_EXTERNAL_ID", str, false);
    }

    public void u(boolean z) {
        putBoolean("CONFIG_NOTIFICATION_INTERCEPTION_ENABLED", z);
    }

    public void v(String str) {
        putString("CONFIG_LAST_APP_VER_CODE", str);
    }

    public void w(long j) {
        putLong("FRESHCHAT_LAST_EVENT_LOGGED_TIME", j);
    }

    public void w(String str) {
        putString("CONFIG_LINK_REGEX", str);
    }

    public void w(boolean z) {
        putBoolean("CONFIG_RESPONSE_EXPECTATION_ENABLED", z);
    }

    public void x(String str) {
        putString("CONFIG_LINK_SCHEME", str);
    }

    public void y(String str) {
        putString("SOLUTIONS_LAST_MODIFIED_AT", str);
    }

    public void z(String str) {
        putString("SOLUTIONS_LAST_RECEIVED_LOCALE", str);
    }

    public void z(boolean z) {
        putBoolean("RC_LIVE_TRANSLATION_ENABLED", z);
    }
}
