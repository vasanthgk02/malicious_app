package io.hansel.ujmtracker;

import android.content.Context;
import com.netcore.android.event.SMTEventId;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.logger.HSLLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class l {
    public static long a() {
        return System.currentTimeMillis();
    }

    public static Boolean a(String str) {
        return Boolean.valueOf(SMTEventId.EVENT_NH_BRANCH_TRACKER.equals(str) || SMTEventId.EVENT_NH_PROMPT_DISMISS.equals(str) || SMTEventId.EVENT_NH_PROMPT_SHOW.equals(str) || "Hansel_Nudge_Dismiss".equals(str) || "Hansel_Nudge_View".equals(str) || "hansel_nudge_event".equals(str) || "_hsl_page_load".equals(str));
    }

    public static String a(Context context) {
        String a2 = k.a(context);
        if (a2 == null) {
            a2 = HSLBuildConfig.getUjmAddEvent(context) + "/dashboard/event/v1/<app_id>/";
        }
        return HSLInternalUtils.getUrlFromFormat(context, a2, null);
    }

    public static boolean a(long j, long j2) {
        return a() >= j + j2;
    }

    public static boolean a(long j, String str) {
        try {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(date)).after(simpleDateFormat.parse(simpleDateFormat.format(new Date(j))));
        } catch (ParseException unused) {
            HSLLogger.wMin(str);
            return false;
        }
    }

    public static String b(Context context) {
        return HSLInternalUtils.getStringFromSharedPreferences(context, "lis_type_sp_key");
    }

    public static boolean b(long j, long j2) {
        return a(j, (String) "BranchTracker: Error parsing dates") || a(j, j2);
    }

    public static boolean b(String str) {
        return "ONVIEWCREATED".equals(str);
    }

    public static boolean c(Context context) {
        return HSLInternalUtils.getBooleanFromSharedPreferences(context, "is_lis_enabled");
    }
}
