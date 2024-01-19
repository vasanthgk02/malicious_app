package com.netcore.android.event;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/netcore/android/event/SMTEventId;", "", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
@Keep
/* compiled from: SMTEventConstants.kt */
public final class SMTEventId {
    public static final Companion Companion = new Companion(null);
    public static final int EVENT_APP_CRASHED = 82;
    public static final int EVENT_APP_INSTALLED = 20;
    public static final int EVENT_APP_INSTALL_UPDATE_NETCORE = 999;
    public static final int EVENT_APP_LAUNCHED = 21;
    public static final int EVENT_APP_REINSTALLED = 83;
    public static final int EVENT_APP_UPDATED = 81;
    public static final int EVENT_CUSTOM = 0;
    public static final int EVENT_DEVICE_DATA_DUMP = 99;
    public static final int EVENT_DEVICE_DETAILS_UPDATED = 26;
    public static final int EVENT_FIRST_APP_LAUNCHED = 80;
    public static final int EVENT_GEOFENCE_DWELL_EVENT_ID = 92;
    public static final int EVENT_GEOFENCE_ENTRY_EVENT_ID = 91;
    public static final int EVENT_GEOFENCE_EXIT_EVENT_ID = 93;
    public static final int EVENT_INAPP_CLICKED = 42;
    public static final int EVENT_INAPP_DISMISSED = 43;
    public static final int EVENT_INAPP_VIEWED = 41;
    public static final int EVENT_INBOX_CLICKED = 46;
    public static final int EVENT_INBOX_DELIVERED = 44;
    public static final int EVENT_INBOX_DISMISSED = 47;
    public static final int EVENT_INBOX_VIEWED = 45;
    public static final int EVENT_LOCATION_FETCH_DISABLED = 90;
    public static final int EVENT_LOCATION_FETCH_ENABLED = 89;
    public static final String EVENT_NH_BRANCH_TRACKER = "nh_branch_tracker";
    public static final int EVENT_NH_BRANCH_TRACKER_ID = 65;
    public static final String EVENT_NH_PROMPT_DISMISS = "nh_prompt_dismiss";
    public static final int EVENT_NH_PROMPT_DISMISS_ID = 64;
    public static final String EVENT_NH_PROMPT_SHOW = "nh_prompt_show";
    public static final int EVENT_NH_PROMPT_SHOW_ID = 63;
    public static final int EVENT_PN_CLICKED = 13;
    public static final int EVENT_PN_DELIVERED = 12;
    public static final int EVENT_PN_DISMISSED = 14;
    public static final int EVENT_PN_RENDERED = 18;
    public static final int EVENT_PN_REPLIED = 19;
    public static final int EVENT_PN_TOKEN_FAILED = 87;
    public static final int EVENT_PN_TOKEN_GENERATED = 86;
    public static final int EVENT_PN_TOKEN_REFRESHED = 88;
    public static final int EVENT_USER_DISABLED_PN = 85;
    public static final int EVENT_USER_ENABLED_PN = 84;
    public static final int EVENT_USER_INAPP_OPT_IN = 74;
    public static final int EVENT_USER_INAPP_OPT_OUT = 75;
    public static final int EVENT_USER_LOGGED_IN = 22;
    public static final int EVENT_USER_LOGGED_OUT = 23;
    public static final int EVENT_USER_PN_OPT_IN = 72;
    public static final int EVENT_USER_PN_OPT_OUT = 73;
    public static final int EVENT_USER_PROFILE_PUSH = 40;
    public static final int EVENT_USER_TRACKING_OPT_IN = 70;
    public static final int EVENT_USER_TRACKING_OPT_OUT = 71;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b9\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b;\u0010<J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u000bR\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u000bR\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u000bR\u0016\u0010!\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u000bR\u0016\u0010$\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u000bR\u0016\u0010&\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010'\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u000bR\u0016\u0010(\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b(\u0010\u000bR\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u000bR\u0016\u0010*\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u000bR\u0016\u0010+\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\u000bR\u0016\u0010,\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b,\u0010\u000bR\u0016\u0010-\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b-\u0010\u000bR\u0016\u0010.\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b.\u0010\u000bR\u0016\u0010/\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b/\u0010\u000bR\u0016\u00100\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b0\u0010\u000bR\u0016\u00101\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b1\u0010\u000bR\u0016\u00102\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b3\u0010\u000bR\u0016\u00104\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b4\u0010\u000bR\u0016\u00105\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b5\u0010\u000bR\u0016\u00106\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b7\u0010\u000bR\u0016\u00108\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b8\u0010\u000bR\u0016\u00109\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b9\u0010\u000bR\u0016\u0010:\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b:\u0010\u000b¨\u0006="}, d2 = {"Lcom/netcore/android/event/SMTEventId$Companion;", "", "", "id", "", "getEventName", "(I)Ljava/lang/String;", "eventName", "getEventId", "(Ljava/lang/String;)I", "EVENT_APP_CRASHED", "I", "EVENT_APP_INSTALLED", "EVENT_APP_INSTALL_UPDATE_NETCORE", "EVENT_APP_LAUNCHED", "EVENT_APP_REINSTALLED", "EVENT_APP_UPDATED", "EVENT_CUSTOM", "EVENT_DEVICE_DATA_DUMP", "EVENT_DEVICE_DETAILS_UPDATED", "EVENT_FIRST_APP_LAUNCHED", "EVENT_GEOFENCE_DWELL_EVENT_ID", "EVENT_GEOFENCE_ENTRY_EVENT_ID", "EVENT_GEOFENCE_EXIT_EVENT_ID", "EVENT_INAPP_CLICKED", "EVENT_INAPP_DISMISSED", "EVENT_INAPP_VIEWED", "EVENT_INBOX_CLICKED", "EVENT_INBOX_DELIVERED", "EVENT_INBOX_DISMISSED", "EVENT_INBOX_VIEWED", "EVENT_LOCATION_FETCH_DISABLED", "EVENT_LOCATION_FETCH_ENABLED", "EVENT_NH_BRANCH_TRACKER", "Ljava/lang/String;", "EVENT_NH_BRANCH_TRACKER_ID", "EVENT_NH_PROMPT_DISMISS", "EVENT_NH_PROMPT_DISMISS_ID", "EVENT_NH_PROMPT_SHOW", "EVENT_NH_PROMPT_SHOW_ID", "EVENT_PN_CLICKED", "EVENT_PN_DELIVERED", "EVENT_PN_DISMISSED", "EVENT_PN_RENDERED", "EVENT_PN_REPLIED", "EVENT_PN_TOKEN_FAILED", "EVENT_PN_TOKEN_GENERATED", "EVENT_PN_TOKEN_REFRESHED", "EVENT_USER_DISABLED_PN", "EVENT_USER_ENABLED_PN", "EVENT_USER_INAPP_OPT_IN", "EVENT_USER_INAPP_OPT_OUT", "EVENT_USER_LOGGED_IN", "EVENT_USER_LOGGED_OUT", "EVENT_USER_PN_OPT_IN", "EVENT_USER_PN_OPT_OUT", "EVENT_USER_PROFILE_PUSH", "EVENT_USER_TRACKING_OPT_IN", "EVENT_USER_TRACKING_OPT_OUT", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTEventConstants.kt */
    public static final class Companion {
        public Companion() {
        }

        public final int getEventId(String str) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            int hashCode = str.hashCode();
            if (hashCode != 786374131) {
                if (hashCode != 933549760) {
                    if (hashCode == 1724580820 && str.equals(SMTEventId.EVENT_NH_PROMPT_DISMISS)) {
                        return 64;
                    }
                } else if (str.equals(SMTEventId.EVENT_NH_BRANCH_TRACKER)) {
                    return 65;
                }
            } else if (str.equals(SMTEventId.EVENT_NH_PROMPT_SHOW)) {
                return 63;
            }
            return 0;
        }

        public final String getEventName(int i) {
            if (i == 0) {
                return "custom_event";
            }
            if (i == 26) {
                return "device_updated";
            }
            if (i == 99) {
                return "device_common_data";
            }
            switch (i) {
                case 12:
                    return "pn_delivered";
                case 13:
                    return "pn_clicked";
                case 14:
                    return "pn_dismissed";
                default:
                    switch (i) {
                        case 18:
                            return "pn_rendered";
                        case 19:
                            return "pn_replied";
                        case 20:
                            return "app_installed";
                        case 21:
                            return "regular_app_launched";
                        case 22:
                            return "user_logged_in";
                        case 23:
                            return "user_logged_out";
                        default:
                            switch (i) {
                                case 40:
                                    return "user_profile_push";
                                case 41:
                                    return "inapp_viewed";
                                case 42:
                                    return "inapp_clicked";
                                case 43:
                                    return "inapp_closed";
                                case 44:
                                    return "inbox_delivered";
                                case 45:
                                    return "inbox_viewed";
                                case 46:
                                    return "inbox_clicked";
                                case 47:
                                    return "inbox_dismissed";
                                default:
                                    switch (i) {
                                        case 70:
                                            return "user_tracking_opt_in";
                                        case 71:
                                            return "user_tracking_opt_out";
                                        case 72:
                                            return "user_pn_opt_in";
                                        case 73:
                                            return "user_pn_opt_out";
                                        case 74:
                                            return "user_inapp_opt_in";
                                        case 75:
                                            return "user_inapp_opt_out";
                                        default:
                                            switch (i) {
                                                case 80:
                                                    return "first_app_launched";
                                                case 81:
                                                    return "app_updated";
                                                case 82:
                                                    return "app_crashed";
                                                case 83:
                                                    return "app_reinstalled";
                                                case 84:
                                                    return "user_enabled_pn";
                                                case 85:
                                                    return "user_disabled_pn";
                                                case 86:
                                                    return "pn_token_generated";
                                                case 87:
                                                    return "pn_token_failed";
                                                case 88:
                                                    return "pn_token_refreshed";
                                                case 89:
                                                    return "app_location_enabled";
                                                case 90:
                                                    return "app_location_disabled";
                                                case 91:
                                                    return "geof_entry";
                                                case 92:
                                                    return "geof_dwell";
                                                case 93:
                                                    return "geof_exit";
                                                default:
                                                    return "";
                                            }
                                    }
                            }
                    }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
