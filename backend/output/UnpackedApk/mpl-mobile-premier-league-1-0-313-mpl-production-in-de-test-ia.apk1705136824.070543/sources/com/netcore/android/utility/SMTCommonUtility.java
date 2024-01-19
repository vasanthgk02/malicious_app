package com.netcore.android.utility;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.models.SMTSdkInitializeResponse.SmartTechSettings;
import com.netcore.android.network.models.SMTSdkInitializeResponse.SmartTechSettings.SmartTechBaseURL;
import com.netcore.android.network.models.SMTSdkInitializeResponse.SmartTechSettings.SmartTechDebugLevel;
import com.netcore.android.network.models.SMTSdkInitializeResponse.SmartTechSettings.SmartechGeoFenceSettings;
import com.netcore.android.notification.SMTNotificationConstants;
import com.netcore.android.preference.SMTGUIDPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.userexperior.models.recording.enums.UeCustomType;
import in.juspay.hypersdk.core.Labels.System;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.LinesSequence;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.Charsets;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010&\u001a\u00020 ¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b+\u0010\u0017J\u0015\u0010-\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0004\b/\u00100J#\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b1\u00102J\u001f\u00105\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b3\u00104J\u000f\u00108\u001a\u00020\u0019H\u0000¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u00020\u0019H\u0000¢\u0006\u0004\b9\u00107J\u001f\u0010>\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u0005H\u0000¢\u0006\u0004\b<\u0010=J\u0015\u0010@\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0011¢\u0006\u0004\b@\u0010*J\u0017\u0010B\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\bA\u0010\"J\u0017\u0010F\u001a\u00020C2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\bG\u0010*J?\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00052\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\u0005H\u0007¢\u0006\u0004\bK\u0010.J\u000f\u0010L\u001a\u00020\u0005H\u0007¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0019H\u0007¢\u0006\u0004\bN\u00107J\u000f\u0010O\u001a\u00020\u0019H\u0007¢\u0006\u0004\bO\u00107J\u0017\u0010Q\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\bP\u0010\u0017J\u0017\u0010R\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\bR\u0010\u0017J\u0015\u0010S\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\bS\u0010*J\u0017\u0010U\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\bT\u0010*J\u0017\u0010Y\u001a\u00020\u00192\u0006\u0010V\u001a\u00020 H\u0000¢\u0006\u0004\bW\u0010XJ\u000f\u0010[\u001a\u00020\u0005H\u0000¢\u0006\u0004\bZ\u0010MJ\r\u0010]\u001a\u00020\\¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020C2\b\u0010_\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b`\u0010aJ\u0019\u0010b\u001a\u0004\u0018\u00010\u00052\b\u0010_\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bb\u0010cJ\u0017\u0010e\u001a\u0004\u0018\u00010\\2\u0006\u0010d\u001a\u00020\\¢\u0006\u0004\be\u0010fJ\u001f\u0010i\u001a\u00020\u00052\u0006\u0010g\u001a\u00020C2\u0006\u0010h\u001a\u00020CH\u0007¢\u0006\u0004\bi\u0010jJ\u0017\u0010l\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\bk\u0010*J!\u0010o\u001a\u0004\u0018\u00010n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010m\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bo\u0010pJ\u001d\u0010s\u001a\u00020\u00192\u0006\u0010q\u001a\u00020C2\u0006\u0010r\u001a\u00020C¢\u0006\u0004\bs\u0010tJ\r\u0010u\u001a\u00020\u0019¢\u0006\u0004\bu\u00107J!\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010v\u001a\u00020\u0002¢\u0006\u0004\bw\u0010\u0007J\u001d\u0010y\u001a\u00020\u00022\u0006\u0010v\u001a\u00020\u00022\u0006\u0010x\u001a\u00020\u0019¢\u0006\u0004\by\u0010zJ\u001f\u0010\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010|\u001a\u00020{H\u0000¢\u0006\u0004\b}\u0010~J\u0018\u0010\u0001\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020 ¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0005\b\u0001\u0010\u000eJ2\u0010\u0001\u001a\u00020\u00192\u000f\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u000f\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u00020\u00052\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\u00020C2\u0007\u0010\u0001\u001a\u00020\u0005¢\u0006\u0005\b\u0001\u0010aJ\u0018\u0010\u0001\u001a\u00020\\2\u0006\u0010_\u001a\u00020\u0005¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00192\t\u0010\u0001\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u000b \u0001*\u0004\u0018\u00010\u00050\u00058\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00020 *\u00020 8F@\u0006¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00020 *\u00020 8F@\u0006¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/netcore/android/utility/SMTCommonUtility;", "", "Lorg/json/JSONObject;", "json", "Ljava/util/HashMap;", "", "_jsonToMap_", "(Lorg/json/JSONObject;)Ljava/util/HashMap;", "object1", "toMap", "Lorg/json/JSONArray;", "array", "", "toList", "(Lorg/json/JSONArray;)Ljava/util/List;", "Lcom/netcore/android/utility/g;", "smtInfo", "Landroid/content/Context;", "context", "", "updateDeviceInfo", "(Lcom/netcore/android/utility/g;Landroid/content/Context;)V", "readGUIDFromSharedPref", "(Landroid/content/Context;)Ljava/lang/String;", "attributionMap", "", "compareIdentity", "(Landroid/content/Context;Ljava/util/HashMap;)Z", "obj", "isLowercase", "parseJsonArray", "(Lorg/json/JSONArray;Z)Lorg/json/JSONArray;", "", "getAppIconId", "(Landroid/content/Context;)I", "Landroid/graphics/Bitmap;", "getAppIconBitmap", "(Landroid/content/Context;)Landroid/graphics/Bitmap;", "resourceId", "getBitmapFromResId", "(Landroid/content/Context;I)Landroid/graphics/Bitmap;", "isNetworkAvailable", "(Landroid/content/Context;)Z", "getApplicationName", "path", "deleteFile", "(Ljava/lang/String;)V", "loadImageFromLocalStorage", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "jsonToMap", "(Ljava/lang/Object;)Ljava/util/HashMap;", "checkIfDeviceDetailChanged$smartech_release", "(Lcom/netcore/android/utility/g;Landroid/content/Context;)Z", "checkIfDeviceDetailChanged", "shouldCheckPermission$smartech_release", "()Z", "shouldCheckPermission", "shouldCheckLocationBGPermission$smartech_release", "shouldCheckLocationBGPermission", "permission", "isPermissionGranted$smartech_release", "(Landroid/content/Context;Ljava/lang/String;)Z", "isPermissionGranted", "ctx", "isTablet", "getBOD$smartech_release", "getBOD", "", "getPushAmpNextScheduleTime$smartech_release", "(Landroid/content/Context;)J", "getPushAmpNextScheduleTime", "areNotificationsEnabled", "updateAttributionParams", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Ljava/util/HashMap;", "value", "writeToSDFile", "readFromSDFile", "()Ljava/lang/String;", "isExternalStorageWritable", "isExternalStorageReadable", "getStoredGUID$smartech_release", "getStoredGUID", "readGuidFromSharedPrefernce", "checkPanelAndSDKActiveStatus", "checkIfTrackingAllowed$smartech_release", "checkIfTrackingAllowed", "id", "eventsRepository$smartech_release", "(I)Z", "eventsRepository", "getUTCDateTime$smartech_release", "getUTCDateTime", "Ljava/util/Date;", "getCurrentUTCDateTime", "()Ljava/util/Date;", "mPublishedTimeStamp", "convertStringDatetoTimeStamp", "(Ljava/lang/String;)J", "getFormattedTimeDifference", "(Ljava/lang/String;)Ljava/lang/String;", "date", "dateToUTC", "(Ljava/util/Date;)Ljava/util/Date;", "publishedTimeStamp", "currentTime", "getDifferenceInWords", "(JJ)Ljava/lang/String;", "checkPanelStatus$smartech_release", "checkPanelStatus", "soundFile", "Landroid/net/Uri;", "getSoundUri", "(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;", "currentTimeStamp", "oldTimeStamp", "checkDateDifferenceProgressEvent", "(JJ)Z", "isFCMAvailable", "jsonObject", "jsonToHashMap", "isLowerCase", "jsonKeyCaseConverter", "(Lorg/json/JSONObject;Z)Lorg/json/JSONObject;", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings;", "settings", "updateSmartechSettingsConfig$smartech_release", "(Landroid/content/Context;Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings;)V", "updateSmartechSettingsConfig", "handleAppUpdate", "(Landroid/content/Context;)V", "flag", "handlePendingIntent", "(I)I", "jsonArrayToStringList", "list1", "list2", "compareLists", "(Ljava/util/List;Ljava/util/List;)Z", "Ljava/util/HashSet;", "mCollapseKeyList", "getCollapseKeyListAsString", "(Ljava/util/HashSet;)Ljava/lang/String;", "utcTime", "getUtcTimeStamp", "convertStringToUTCDate", "(Ljava/lang/String;)Ljava/util/Date;", "numericString", "isInteger", "(Ljava/lang/String;)Z", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "getToDp", "toDp", "getToPx", "toPx", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTCommonUtility.kt */
public final class SMTCommonUtility {
    public static final SMTCommonUtility INSTANCE = new SMTCommonUtility();
    public static final String TAG = SMTCommonUtility.class.getSimpleName();

    private final HashMap<String, Object> _jsonToMap_(JSONObject jSONObject) {
        return Intrinsics.areEqual(jSONObject, JSONObject.NULL) ^ true ? toMap(jSONObject) : new HashMap<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        if ((r6.length() == 0) != false) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean compareIdentity(android.content.Context r17, java.util.HashMap<java.lang.String, java.lang.String> r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            com.netcore.android.preference.SMTPreferenceHelper$Companion r2 = com.netcore.android.preference.SMTPreferenceHelper.Companion
            r3 = 0
            com.netcore.android.preference.SMTPreferenceHelper r4 = r2.getAppPreferenceInstance(r0, r3)
            java.lang.String r5 = "__stm_identity"
            java.lang.Object r6 = r1.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "(this as java.lang.String).toLowerCase()"
            java.lang.String r8 = ""
            if (r6 == 0) goto L_0x0021
            java.lang.String r6 = r6.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            goto L_0x0022
        L_0x0021:
            r6 = r8
        L_0x0022:
            java.lang.String r9 = "smt_user_identity"
            java.lang.String r10 = r4.getString(r9)
            int r10 = r10.length()
            r11 = 0
            r12 = 1
            if (r10 <= 0) goto L_0x0032
            r10 = 1
            goto L_0x0033
        L_0x0032:
            r10 = 0
        L_0x0033:
            if (r10 == 0) goto L_0x004b
            java.lang.String r10 = r4.getString(r9)
            if (r10 == 0) goto L_0x0043
            java.lang.String r10 = r10.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r7)
            goto L_0x004c
        L_0x0043:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            r10 = r8
        L_0x004c:
            com.netcore.android.logger.SMTLogger r7 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r13 = TAG
            java.lang.String r14 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Identity: App identity: "
            r14.append(r15)
            r14.append(r10)
            java.lang.String r15 = ", Notification identity: "
            r14.append(r15)
            r14.append(r6)
            java.lang.String r14 = r14.toString()
            r7.internal(r13, r14)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r6)
            if (r7 == 0) goto L_0x0078
            goto L_0x008e
        L_0x0078:
            int r7 = r10.length()
            if (r7 <= 0) goto L_0x0080
            r7 = 1
            goto L_0x0081
        L_0x0080:
            r7 = 0
        L_0x0081:
            if (r7 == 0) goto L_0x0090
            int r7 = r6.length()
            if (r7 != 0) goto L_0x008b
            r7 = 1
            goto L_0x008c
        L_0x008b:
            r7 = 0
        L_0x008c:
            if (r7 == 0) goto L_0x0090
        L_0x008e:
            r8 = r10
            goto L_0x00ba
        L_0x0090:
            int r7 = r10.length()
            if (r7 != 0) goto L_0x0098
            r7 = 1
            goto L_0x0099
        L_0x0098:
            r7 = 0
        L_0x0099:
            if (r7 == 0) goto L_0x00b1
            int r7 = r6.length()
            if (r7 <= 0) goto L_0x00a3
            r7 = 1
            goto L_0x00a4
        L_0x00a3:
            r7 = 0
        L_0x00a4:
            if (r7 == 0) goto L_0x00b1
            com.netcore.android.preference.SMTPreferenceHelper r0 = r2.getAppPreferenceInstance(r0, r3)
            java.lang.String r2 = "smt_user_old_identity"
            r0.setString(r2, r10)
            r8 = r6
            goto L_0x00ba
        L_0x00b1:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r6)
            r0 = r0 ^ r12
            if (r0 == 0) goto L_0x00ba
            r8 = r10
            r11 = 1
        L_0x00ba:
            r1.remove(r5)
            r4.setString(r9, r8)
            java.lang.String r0 = "smt_notification_identity"
            r4.setString(r0, r6)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.utility.SMTCommonUtility.compareIdentity(android.content.Context, java.util.HashMap):boolean");
    }

    private final JSONArray parseJsonArray(JSONArray jSONArray, boolean z) {
        Object obj;
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length() - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof JSONArray) {
                    obj = parseJsonArray((JSONArray) obj2, z);
                } else if (obj2 instanceof JSONObject) {
                    obj = jsonKeyCaseConverter((JSONObject) obj2, z);
                } else {
                    obj = jSONArray.get(i);
                }
                jSONArray2.put(obj);
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return jSONArray2;
    }

    private final String readGUIDFromSharedPref(Context context) {
        return SMTGUIDPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_GUID, "");
    }

    private final List<Object> toList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length() - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONArray) {
                    obj = toList((JSONArray) obj);
                } else if (obj instanceof JSONObject) {
                    obj = toMap((JSONObject) obj);
                }
                arrayList.add(obj);
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private final HashMap<String, Object> toMap(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            Intrinsics.checkNotNullExpressionValue(next, "key");
            Intrinsics.checkNotNullExpressionValue(obj, HSLCriteriaBuilder.VALUE);
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static /* synthetic */ HashMap updateAttributionParams$default(SMTCommonUtility sMTCommonUtility, Context context, String str, HashMap hashMap, int i, Object obj) {
        if ((i & 4) != 0) {
            hashMap = new HashMap();
        }
        return sMTCommonUtility.updateAttributionParams(context, str, hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        if (r2 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        if (r2 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (r2 != null) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateDeviceInfo(com.netcore.android.utility.g r6, android.content.Context r7) {
        /*
            r5 = this;
            com.netcore.android.preference.SMTPreferenceHelper$Companion r0 = com.netcore.android.preference.SMTPreferenceHelper.Companion
            r1 = 0
            com.netcore.android.preference.SMTPreferenceHelper r7 = r0.getAppPreferenceInstance(r7, r1)
            java.lang.String r0 = "os_version"
            java.lang.String r1 = ""
            java.lang.String r2 = r7.getString(r0, r1)
            int r2 = r2.length()
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 == 0) goto L_0x002d
            com.netcore.android.utility.d r2 = r6.c()
            if (r2 == 0) goto L_0x0029
            java.lang.String r2 = r2.p()
            if (r2 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r2 = r1
        L_0x002a:
            r7.setString(r0, r2)
        L_0x002d:
            java.lang.String r0 = "carrier"
            java.lang.String r2 = r7.getString(r0, r1)
            int r2 = r2.length()
            if (r2 != 0) goto L_0x003b
            r2 = 1
            goto L_0x003c
        L_0x003b:
            r2 = 0
        L_0x003c:
            if (r2 == 0) goto L_0x004f
            com.netcore.android.utility.j r2 = r6.d()
            if (r2 == 0) goto L_0x004b
            java.lang.String r2 = r2.d()
            if (r2 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r2 = r1
        L_0x004c:
            r7.setString(r0, r2)
        L_0x004f:
            java.lang.String r0 = "deviceLocale"
            java.lang.String r2 = r7.getString(r0, r1)
            int r2 = r2.length()
            if (r2 != 0) goto L_0x005d
            r2 = 1
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            if (r2 == 0) goto L_0x0071
            com.netcore.android.utility.d r2 = r6.c()
            if (r2 == 0) goto L_0x006d
            java.lang.String r2 = r2.d()
            if (r2 == 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r2 = r1
        L_0x006e:
            r7.setString(r0, r2)
        L_0x0071:
            java.lang.String r0 = "timezone"
            java.lang.String r2 = r7.getString(r0, r1)
            int r2 = r2.length()
            if (r2 != 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r3 = 0
        L_0x007f:
            if (r3 == 0) goto L_0x0091
            com.netcore.android.utility.d r6 = r6.c()
            if (r6 == 0) goto L_0x008e
            java.lang.String r6 = r6.r()
            if (r6 == 0) goto L_0x008e
            r1 = r6
        L_0x008e:
            r7.setString(r0, r1)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.utility.SMTCommonUtility.updateDeviceInfo(com.netcore.android.utility.g, android.content.Context):void");
    }

    public final boolean areNotificationsEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public final boolean checkDateDifferenceProgressEvent(long j, long j2) {
        long j3 = (j - j2) / ((long) 1000);
        long j4 = (long) 60;
        long j5 = ((j3 / j4) / j4) / ((long) 24);
        return j5 >= 0 && j5 >= ((long) 2);
    }

    public final boolean checkIfDeviceDetailChanged$smartech_release(g gVar, Context context) {
        Intrinsics.checkNotNullParameter(gVar, "smtInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        String str = null;
        SMTPreferenceHelper appPreferenceInstance = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
        updateDeviceInfo(gVar, context);
        String str2 = "";
        String string = appPreferenceInstance.getString("os_version", str2);
        d c2 = gVar.c();
        if (!Intrinsics.areEqual(string, c2 != null ? c2.p() : null)) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str3 = TAG;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            StringBuilder sb = new StringBuilder();
            sb.append("device detail updated for OS version ");
            sb.append("Existing os version is: ");
            sb.append(appPreferenceInstance.getString("os_version"));
            sb.append(' ');
            sb.append(" new os version is : ");
            d c3 = gVar.c();
            if (c3 != null) {
                str = c3.p();
            }
            sb.append(str);
            sMTLogger.i(str3, sb.toString());
            return true;
        }
        String string2 = appPreferenceInstance.getString("carrier", str2);
        j d2 = gVar.d();
        if (!Intrinsics.areEqual(string2, d2 != null ? d2.d() : null)) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str4 = TAG;
            Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("device detail updated for Carrier ");
            sb2.append("Existing Carrier is: ");
            sb2.append(appPreferenceInstance.getString("carrier"));
            sb2.append(' ');
            sb2.append(" new Carrier is : ");
            j d3 = gVar.d();
            if (d3 != null) {
                str = d3.d();
            }
            sb2.append(str);
            sMTLogger2.i(str4, sb2.toString());
            return true;
        }
        String string3 = appPreferenceInstance.getString("deviceLocale", str2);
        d c4 = gVar.c();
        if (!Intrinsics.areEqual(string3, c4 != null ? c4.d() : null)) {
            SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
            String str5 = TAG;
            Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("device detail updated for Locale ");
            sb3.append("Existing Locale is: ");
            sb3.append(appPreferenceInstance.getString("deviceLocale"));
            sb3.append(' ');
            sb3.append(" new Locale is : ");
            d c5 = gVar.c();
            if (c5 != null) {
                str = c5.d();
            }
            sb3.append(str);
            sMTLogger3.i(str5, sb3.toString());
            return true;
        }
        String string4 = appPreferenceInstance.getString("timezone", str2);
        d c6 = gVar.c();
        if (c6 != null) {
            String r = c6.r();
            if (r != null) {
                str2 = r;
            }
        }
        if (!(!Intrinsics.areEqual(string4, str2))) {
            return false;
        }
        SMTLogger sMTLogger4 = SMTLogger.INSTANCE;
        String str6 = TAG;
        Intrinsics.checkNotNullExpressionValue(str6, UeCustomType.TAG);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("device detail updated for SMT_TIMEZONE ");
        sb4.append("Existing SMT_TIMEZONE is: ");
        sb4.append(appPreferenceInstance.getString("timezone"));
        sb4.append(' ');
        sb4.append(" new SMT_TIMEZONE is : ");
        d c7 = gVar.c();
        if (c7 != null) {
            str = c7.r();
        }
        sb4.append(str);
        sMTLogger4.i(str6, sb4.toString());
        return true;
    }

    public final boolean checkIfTrackingAllowed$smartech_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getBoolean(SMTPreferenceConstants.OPT_IN_OUT_TRACKING, true) || !checkPanelAndSDKActiveStatus(context)) {
            return false;
        }
        return true;
    }

    public final boolean checkPanelAndSDKActiveStatus(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SMTPreferenceHelper appPreferenceInstance = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
        boolean z = appPreferenceInstance.getBoolean(SMTPreferenceConstants.IS_SDK_ACTIVE, false);
        boolean z2 = appPreferenceInstance.getBoolean(SMTPreferenceConstants.IS_PANEL_ACTIVE, false);
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public final boolean checkPanelStatus$smartech_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SMTPreferenceHelper appPreferenceInstance = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
        appPreferenceInstance.getBoolean(SMTPreferenceConstants.IS_PANEL_ACTIVE);
        boolean z = true;
        if (appPreferenceInstance.getString(SMTPreferenceConstants.SMT_BASE_URL).length() == 0) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.v(str, "Base URL is empty");
            return false;
        }
        boolean z2 = appPreferenceInstance.getBoolean(SMTPreferenceConstants.IS_PANEL_ACTIVE);
        if (!z2) {
            if (!z2) {
                long convert = TimeUnit.DAYS.convert(Math.abs(System.currentTimeMillis() - appPreferenceInstance.getLong(SMTPreferenceConstants.SMT_SDK_INIT_TIMESTAMP)), TimeUnit.MILLISECONDS);
                SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                sMTLogger2.v(str2, "Days difference ------> " + convert);
                if (convert < ((long) 7)) {
                    z = false;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
        String str3 = TAG;
        Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
        sMTLogger3.v(str3, "SMT Panle status ------> " + z);
        return z;
    }

    public final boolean compareLists(List<String> list, List<String> list2) {
        if (!(list == null || list2 == null)) {
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    int size2 = list2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (Intrinsics.areEqual(list.get(i), list2.get(i2))) {
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = TAG;
                GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
            }
        }
        return false;
    }

    public final long convertStringDatetoTimeStamp(String str) {
        if (str != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SMTConfigConstants.SERVER_TIME_FORMAT, Locale.getDefault());
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date parse = simpleDateFormat.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "simpleDateFormat.parse(mPublishedTimeStamp)");
                return parse.getTime();
            } catch (Exception e2) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str2 = TAG;
                GeneratedOutlineSupport.outline96(str2, UeCustomType.TAG, e2, sMTLogger, str2);
            }
        }
        return 0;
    }

    public final Date convertStringToUTCDate(String str) {
        Intrinsics.checkNotNullParameter(str, "mPublishedTimeStamp");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SMTConfigConstants.SERVER_TIME_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parse = simpleDateFormat.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "simpleDateFormat.parse(mPublishedTimeStamp)");
        return parse;
    }

    public final Date dateToUTC(Date date) {
        Intrinsics.checkNotNullParameter(date, DatePickerDialogModule.ARG_DATE);
        long time = date.getTime();
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        return new Date(time - ((long) instance.getTimeZone().getOffset(date.getTime())));
    }

    public final void deleteFile(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (file.delete()) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = TAG;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.v(str2, "File delete success :- " + str);
            return;
        }
        SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
        String str3 = TAG;
        Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
        sMTLogger2.v(str3, "File delete failed :- " + str);
    }

    public final boolean eventsRepository$smartech_release(int i) {
        return i == 20 || i == 71 || i == 86 || i == 89;
    }

    public final Bitmap getAppIconBitmap(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        Bitmap decodeResource = BitmapFactory.decodeResource(packageManager.getResourcesForApplication(applicationInfo), applicationInfo.icon);
        Drawable applicationIcon = packageManager.getApplicationIcon(context.getPackageName());
        int i2 = 1;
        if (applicationIcon != null) {
            i2 = applicationIcon.getIntrinsicWidth();
            i = applicationIcon.getIntrinsicHeight();
        } else {
            i = 1;
        }
        if (decodeResource == null) {
            decodeResource = Bitmap.createBitmap(i2, i, Config.ARGB_8888);
        }
        Intrinsics.checkNotNullExpressionValue(decodeResource, "appIconBitmap");
        return decodeResource;
    }

    public final int getAppIconId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).icon;
    }

    public final String getApplicationName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        if (i == 0) {
            return applicationInfo.nonLocalizedLabel.toString();
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n            stringId\n        )");
        return string;
    }

    public final int getBOD$smartech_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isTablet(context) ? SMTConfigConstants.BOD_FOR_TABLET : SMTConfigConstants.BOD_FOR_PHONE;
    }

    public final Bitmap getBitmapFromResId(Context context, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(context, "context");
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
        Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getPackageName());
        int i3 = 1;
        if (applicationIcon != null) {
            i3 = applicationIcon.getIntrinsicWidth();
            i2 = applicationIcon.getIntrinsicHeight();
        } else {
            i2 = 1;
        }
        if (decodeResource == null) {
            decodeResource = Bitmap.createBitmap(i3, i2, Config.ARGB_8888);
        }
        Intrinsics.checkNotNullExpressionValue(decodeResource, "appIconBitmap");
        return decodeResource;
    }

    public final String getCollapseKeyListAsString(HashSet<String> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "mCollapseKeyList");
        return GeneratedOutlineSupport.outline50(GeneratedOutlineSupport.outline50("'", TextUtils.join("','", hashSet)), "'");
    }

    public final Date getCurrentUTCDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SMTConfigConstants.SERVER_TIME_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        Intrinsics.checkNotNullExpressionValue(parse, "simpleDateFormat.parse(s…ateFormat.format(Date()))");
        return parse;
    }

    public final String getDifferenceInWords(long j, long j2) {
        String str;
        long j3 = j2 - j;
        long j4 = (long) 60;
        long j5 = j4 * 1000;
        long j6 = j4 * j5;
        long j7 = ((long) 24) * j6;
        long j8 = ((long) 30) * j7;
        int i = ((j3 / (((long) 12) * j8)) > 1 ? 1 : ((j3 / (((long) 12) * j8)) == 1 ? 0 : -1));
        if (i > 0) {
            return r12 + " yrs ago";
        } else if (i == 0) {
            return r12 + " yr ago";
        } else {
            int i2 = ((j3 / j8) > 1 ? 1 : ((j3 / j8) == 1 ? 0 : -1));
            if (i2 > 0) {
                return r10 + " months ago";
            } else if (i2 == 0) {
                return r10 + " month ago";
            } else {
                int i3 = ((j3 / j7) > 1 ? 1 : ((j3 / j7) == 1 ? 0 : -1));
                if (i3 > 0) {
                    return r10 + " days ago";
                } else if (i3 == 0) {
                    return r10 + " day ago";
                } else {
                    long j9 = j3 % j7;
                    int i4 = ((j9 / j6) > 1 ? 1 : ((j9 / j6) == 1 ? 0 : -1));
                    if (i4 > 0) {
                        return r8 + " hrs ago";
                    } else if (i4 == 0) {
                        return r8 + " hr ago";
                    } else {
                        long j10 = j9 % j6;
                        int i5 = ((j10 / j5) > 1 ? 1 : ((j10 / j5) == 1 ? 0 : -1));
                        if (i5 > 0) {
                            return r2 + " mins ago";
                        } else if (i5 == 0) {
                            return r2 + " min ago";
                        } else {
                            if (j10 / 1000 > 1) {
                                str = r0 + " secs ago";
                            } else {
                                str = r0 + " sec ago";
                            }
                            return str;
                        }
                    }
                }
            }
        }
    }

    public final String getFormattedTimeDifference(String str) {
        return getDifferenceInWords(convertStringDatetoTimeStamp(str), System.currentTimeMillis());
    }

    public final long getPushAmpNextScheduleTime$smartech_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Companion companion = SMTPreferenceHelper.Companion;
        int i = companion.getAppPreferenceInstance(context, null).getInt(SMTPreferenceConstants.PUSH_AMP_TASK_COUNT, 0);
        int i2 = companion.getAppPreferenceInstance(context, null).getInt(SMTPreferenceConstants.PUSH_AMP_INTERVAL) * 60 * 1000;
        companion.getAppPreferenceInstance(context, null).setInt(SMTPreferenceConstants.PUSH_AMP_TASK_COUNT, i + 1);
        long pow = (long) (Math.pow((double) 2, (double) i) * ((double) i2));
        if (pow <= SMTConfigConstants.Companion.getMAX_CAP_PAMP_INTERVAL()) {
            return pow;
        }
        companion.getAppPreferenceInstance(context, null).setInt(SMTPreferenceConstants.PUSH_AMP_TASK_COUNT, 0);
        companion.getAppPreferenceInstance(context, null).setInt(SMTPreferenceConstants.JOB_SCHEDULER_JOB_ID, 1);
        return (long) i2;
    }

    public final Uri getSoundUri(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(str == null || str.length() == 0)) {
            int identifier = context.getResources().getIdentifier(str, "raw", context.getPackageName());
            if (identifier != 0) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("android.resource://");
                outline73.append(context.getPackageName());
                outline73.append("/");
                outline73.append(identifier);
                return Uri.parse(outline73.toString());
            }
        }
        return null;
    }

    public final String getStoredGUID$smartech_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String readGUIDFromSharedPref = readGUIDFromSharedPref(context);
        if (readGUIDFromSharedPref.length() > 0) {
            SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).setBoolean(SMTPreferenceConstants.IS_SMT_GUID_STORED_PREVIOUSLY, true);
            return readGUIDFromSharedPref;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).setBoolean(SMTPreferenceConstants.IS_SMT_GUID_STORED_PREVIOUSLY, false);
        SMTGUIDPreferenceHelper.Companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_GUID, uuid);
        return uuid;
    }

    public final int getToDp(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) (((float) i) / system.getDisplayMetrics().density);
    }

    public final int getToPx(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) (((float) i) * system.getDisplayMetrics().density);
    }

    public final String getUTCDateTime$smartech_release() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SMTConfigConstants.SERVER_TIME_FORMAT, Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date());
            Intrinsics.checkNotNullExpressionValue(format, "simpleDateFormat.format(Date())");
            return format;
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = TAG;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
            return "";
        }
    }

    public final long getUtcTimeStamp(String str) {
        Intrinsics.checkNotNullParameter(str, "utcTime");
        long j = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SMTConfigConstants.SERVER_TIME_FORMAT, Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            if (str.length() > 0) {
                Date parse = simpleDateFormat.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "simpleDateFormat.parse(utcTime)");
                j = parse.getTime();
            }
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            sMTLogger.d("TimeStamp ", String.valueOf(j) + "  ====>" + str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return j;
    }

    public final void handleAppUpdate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_BASE_URL_TRACKAPPACT, "").length() == 0) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.internal(str, "trackApt url is empty ");
            SmartTechSettings smartTechSettings = new SmartTechSettings();
            smartTechSettings.setPanelActive(true);
            smartTechSettings.setSdkActive(true);
            smartTechSettings.setBaseUrl("https://fpn.netcoresmartech.com/");
            SmartTechBaseURL smartTechBaseURL = new SmartTechBaseURL();
            smartTechBaseURL.setTrackAppActUrl("https://fpn.netcoresmartech.com/");
            SmartTechDebugLevel smartTechDebugLevel = new SmartTechDebugLevel();
            smartTechDebugLevel.setLogEnabled(true);
            smartTechDebugLevel.setLogLevel(9);
            SmartechGeoFenceSettings smartechGeoFenceSettings = new SmartechGeoFenceSettings();
            smartechGeoFenceSettings.setGeoFenceDistance(50);
            smartTechSettings.setSmartechURL(smartTechBaseURL);
            smartTechSettings.setDebuglevel(smartTechDebugLevel);
            smartTechSettings.setSmartechGeoFenceSettings(smartechGeoFenceSettings);
            updateSmartechSettingsConfig$smartech_release(context, smartTechSettings);
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.internal(str, "Before app update settings: " + smartTechSettings);
            return;
        }
        SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
        String str2 = TAG;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger2.internal(str2, "trackApt url is not empty ");
    }

    public final int handlePendingIntent(int i) {
        return VERSION.SDK_INT >= 31 ? i | PDChoice.FLAG_COMMIT_ON_SEL_CHANGE : i;
    }

    public final boolean isExternalStorageReadable() {
        return TweetUtils.setOf((T[]) new String[]{"mounted", "mounted_ro"}).contains(Environment.getExternalStorageState());
    }

    public final boolean isExternalStorageWritable() {
        return Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted");
    }

    public final boolean isFCMAvailable() {
        try {
            Class.forName(c.f1276b.a());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean isInteger(String str) {
        boolean z = true;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (Exception | NumberFormatException unused) {
            z = false;
        }
        return z;
    }

    public final boolean isNetworkAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final boolean isPermissionGranted$smartech_release(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, System.PERMISSION);
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public final boolean isTablet(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "ctx.resources");
        return (resources.getConfiguration().screenLayout & 15) >= 3;
    }

    public final List<String> jsonArrayToStringList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = jSONArray.optString(i);
                Intrinsics.checkNotNullExpressionValue(optString, "array.optString(i)");
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    public final JSONObject jsonKeyCaseConverter(JSONObject jSONObject, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = null;
            try {
                Object obj2 = jSONObject.get(next);
                if (obj2 instanceof JSONArray) {
                    obj = parseJsonArray((JSONArray) obj2, z);
                } else if (obj2 instanceof JSONObject) {
                    obj = jsonKeyCaseConverter((JSONObject) obj2, z);
                } else {
                    obj = jSONObject.get(next);
                }
            } catch (JSONException unused) {
            }
            if (z) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                str = next.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
            } else if (!z) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
                str = next.toUpperCase(locale2);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toUpperCase(locale)");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            jSONObject2.put(str, obj);
        }
        return jSONObject2;
    }

    public final HashMap<String, Object> jsonToHashMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                Intrinsics.checkNotNullExpressionValue(next, "key");
                Intrinsics.checkNotNullExpressionValue(obj, HSLCriteriaBuilder.VALUE);
                hashMap.put(next, obj);
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = TAG;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
        }
        return hashMap;
    }

    public final HashMap<String, Object> jsonToMap(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "json");
        if (obj instanceof JSONObject) {
            return _jsonToMap_((JSONObject) obj);
        }
        if (obj instanceof String) {
            return _jsonToMap_(new JSONObject((String) obj));
        }
        return null;
    }

    public final Bitmap loadImageFromLocalStorage(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        try {
            return BitmapFactory.decodeStream(new FileInputStream(new File(str, "")));
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = TAG;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.e(str2, "Error while loading file path:" + str + ": error is : " + e2);
            return null;
        }
    }

    public final String readFromSDFile() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "root");
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append(SMTConfigConstants.EXTERNAL_FILE_DIR);
        File file = new File(sb.toString());
        if (!file.exists()) {
            return "";
        }
        File file2 = new File(file, SMTConfigConstants.EXTERNAL_FILE_NAME);
        StringBuffer stringBuffer = new StringBuffer();
        if (file2.exists()) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new DataInputStream(new FileInputStream(file2)), Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
                for (String append : TypeUtilsKt.constrainOnce(new LinesSequence(bufferedReader))) {
                    stringBuffer.append(append);
                }
                bufferedReader.close();
            } catch (IOException e2) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.e(str, String.valueOf(e2.getMessage()));
            } catch (Exception e3) {
                SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                String str2 = TAG;
                GeneratedOutlineSupport.outline96(str2, UeCustomType.TAG, e3, sMTLogger2, str2);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    public final String readGuidFromSharedPrefernce(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SMTGUIDPreferenceHelper.Companion companion = SMTGUIDPreferenceHelper.Companion;
        String string = companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_GUID);
        if (!(string.length() == 0)) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_GUID, uuid);
        return uuid;
    }

    public final boolean shouldCheckLocationBGPermission$smartech_release() {
        return VERSION.SDK_INT > 28;
    }

    public final boolean shouldCheckPermission$smartech_release() {
        return VERSION.SDK_INT >= 23;
    }

    public final HashMap<String, String> updateAttributionParams(Context context, String str, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(hashMap, "attributionMap");
        TweetUtils.listOf((T[]) new String[]{SMTNotificationConstants.NOTIF_ATTRIBUTION_ID, SMTNotificationConstants.NOTIF_ATTRIBUTION_MEDIUM, SMTNotificationConstants.NOTIF_ATTRIBUTION_SOURCE, SMTNotificationConstants.NOTIF_ATTRIBUTION_STA});
        try {
            boolean compareIdentity = compareIdentity(context, hashMap);
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = TAG;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.v(str2, "Drop Attribute is " + compareIdentity);
            String jSONObject = new JSONObject(hashMap).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(attributionMap).toString()");
            if (!compareIdentity) {
                SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_ATTRIBUTION_PARAMS, jSONObject);
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str3 = TAG;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger2.e(str3, "Error while fetching attribution param : " + e2);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0149, code lost:
        if (r0 != null) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015c, code lost:
        if (r0 != null) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x016f, code lost:
        if (r0 != null) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0182, code lost:
        if (r0 != null) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0195, code lost:
        if (r0 != null) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a8, code lost:
        if (r0 != null) goto L_0x01ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSmartechSettingsConfig$smartech_release(android.content.Context r8, com.netcore.android.network.models.SMTSdkInitializeResponse.SmartTechSettings r9) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "settings"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.netcore.android.preference.SMTPreferenceHelper$Companion r0 = com.netcore.android.preference.SMTPreferenceHelper.Companion
            r1 = 0
            com.netcore.android.preference.SMTPreferenceHelper r8 = r0.getAppPreferenceInstance(r8, r1)
            java.lang.String r0 = "is_smartech_settings_stored"
            r1 = 1
            r8.setBoolean(r0, r1)
            int r0 = r9.getBatchInterval()
            java.lang.String r2 = "batchInterval"
            r8.setInt(r2, r0)
            int r0 = r9.getBatchSize()
            java.lang.String r2 = "batchSize"
            r8.setInt(r2, r0)
            int r0 = r9.getTokenInterval()
            java.lang.String r2 = "tokenInterval"
            r8.setInt(r2, r0)
            boolean r0 = r9.getPaEnabled()
            java.lang.String r2 = "paEnabled"
            r8.setBoolean(r2, r0)
            int r0 = r9.getPaInterval()
            java.lang.String r2 = "paInterval"
            r8.setInt(r2, r0)
            boolean r0 = r9.getFetchLocation()
            java.lang.String r2 = "fetchLocation"
            r8.setBoolean(r2, r0)
            boolean r0 = r9.getPanelActive()
            java.lang.String r2 = "panelActive"
            r8.setBoolean(r2, r0)
            boolean r0 = r9.getSdkActive()
            java.lang.String r2 = "sdkActive"
            r8.setBoolean(r2, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r0 = r9.getSmartechEventSettings()
            if (r0 == 0) goto L_0x006a
            boolean r0 = r0.getPush()
            goto L_0x006b
        L_0x006a:
            r0 = 1
        L_0x006b:
            java.lang.String r2 = "isPushEventsEnabled"
            r8.setBoolean(r2, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r0 = r9.getSmartechEventSettings()
            if (r0 == 0) goto L_0x007b
            boolean r0 = r0.getAllevents()
            goto L_0x007c
        L_0x007b:
            r0 = 1
        L_0x007c:
            java.lang.String r2 = "isAllEventsEnabled"
            r8.setBoolean(r2, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r0 = r9.getSmartechEventSettings()
            if (r0 == 0) goto L_0x008c
            boolean r0 = r0.getLifecycle()
            goto L_0x008d
        L_0x008c:
            r0 = 1
        L_0x008d:
            java.lang.String r2 = "isLifecycleEventsEnabled"
            r8.setBoolean(r2, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r0 = r9.getSmartechEventSettings()
            if (r0 == 0) goto L_0x009d
            boolean r0 = r0.getAppinbox()
            goto L_0x009e
        L_0x009d:
            r0 = 1
        L_0x009e:
            java.lang.String r2 = "isInboxEventsEnabled"
            r8.setBoolean(r2, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r0 = r9.getSmartechEventSettings()
            if (r0 == 0) goto L_0x00ae
            boolean r0 = r0.getInapp()
            goto L_0x00af
        L_0x00ae:
            r0 = 1
        L_0x00af:
            java.lang.String r2 = "isInAppEventsEnabled"
            r8.setBoolean(r2, r0)
            int r0 = r9.getSessionInterval()
            java.lang.String r2 = "sessionInterval"
            r8.setInt(r2, r0)
            int r0 = r9.getEventLimit()
            java.lang.String r2 = "eventLimit"
            r8.setInt(r2, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r0 = r9.getSmartechGeoFenceSettings()
            r2 = 0
            if (r0 == 0) goto L_0x00d2
            boolean r0 = r0.getGeoFenceEnabled()
            goto L_0x00d3
        L_0x00d2:
            r0 = 0
        L_0x00d3:
            java.lang.String r3 = "isGeoFenceEnabled"
            r8.setBoolean(r3, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r0 = r9.getSmartechGeoFenceSettings()
            if (r0 == 0) goto L_0x00e3
            int r0 = r0.getGeoFenceDistance()
            goto L_0x00e5
        L_0x00e3:
            r0 = 50
        L_0x00e5:
            java.lang.String r3 = "geoFenceDistance"
            r8.setInt(r3, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r0 = r9.getSmartechGeoFenceSettings()
            r3 = 0
            if (r0 == 0) goto L_0x00f7
            long r5 = r0.getGeoFenceLastModified()
            goto L_0x00f8
        L_0x00f7:
            r5 = r3
        L_0x00f8:
            java.lang.String r0 = "geoFenceModifiedDate"
            r8.setLong(r0, r5)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r0 = r9.getSmartechGeoFenceSettings()
            if (r0 == 0) goto L_0x0115
            java.lang.String r5 = r0.getServerRefreshGeoFenceDistanceConfig()
            java.lang.String r6 = "serverRefreshGeoFenceDistanceConfig"
            r8.setString(r6, r5)
            java.lang.String r0 = r0.getAppRefreshGeoFenceDistanceConfig()
            java.lang.String r5 = "appRefreshGeoFenceDistanceConfig"
            r8.setString(r5, r0)
        L_0x0115:
            boolean r0 = r9.isAppInboxEnabled()
            java.lang.String r5 = "isAppInboxEnabled"
            r8.setBoolean(r5, r0)
            int r0 = r9.getMessageCachePeriod()
            java.lang.String r5 = "messageCachingPeriod"
            r8.setInt(r5, r0)
            int r0 = r9.getMediaCachingSize()
            java.lang.String r5 = "mediaCachingSize"
            r8.setInt(r5, r0)
            java.lang.String r0 = r9.getBaseUrl()
            java.lang.String r5 = ""
            if (r0 == 0) goto L_0x0139
            goto L_0x013a
        L_0x0139:
            r0 = r5
        L_0x013a:
            java.lang.String r6 = "SMT_BASE_URL"
            r8.setString(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r0 = r9.getSmartechURL()
            if (r0 == 0) goto L_0x014c
            java.lang.String r0 = r0.getTrackAppActUrl()
            if (r0 == 0) goto L_0x014c
            goto L_0x014d
        L_0x014c:
            r0 = r5
        L_0x014d:
            java.lang.String r6 = "SMT_BASE_URL_TRACKAPPACT"
            r8.setString(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r0 = r9.getSmartechURL()
            if (r0 == 0) goto L_0x015f
            java.lang.String r0 = r0.getInAppUrl()
            if (r0 == 0) goto L_0x015f
            goto L_0x0160
        L_0x015f:
            r0 = r5
        L_0x0160:
            java.lang.String r6 = "SMT_BASE_URL_INAPP"
            r8.setString(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r0 = r9.getSmartechURL()
            if (r0 == 0) goto L_0x0172
            java.lang.String r0 = r0.getInAppListSegUrl()
            if (r0 == 0) goto L_0x0172
            goto L_0x0173
        L_0x0172:
            r0 = r5
        L_0x0173:
            java.lang.String r6 = "SMT_BASE_URL_INAPP_LIST_SEG"
            r8.setString(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r0 = r9.getSmartechURL()
            if (r0 == 0) goto L_0x0185
            java.lang.String r0 = r0.getInboxUrl()
            if (r0 == 0) goto L_0x0185
            goto L_0x0186
        L_0x0185:
            r0 = r5
        L_0x0186:
            java.lang.String r6 = "SMT_BASE_URL_INBOX"
            r8.setString(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r0 = r9.getSmartechURL()
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = r0.getPushAmpUrl()
            if (r0 == 0) goto L_0x0198
            goto L_0x0199
        L_0x0198:
            r0 = r5
        L_0x0199:
            java.lang.String r6 = "SMT_BASE_URL_PUSHAMP"
            r8.setString(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r0 = r9.getSmartechURL()
            if (r0 == 0) goto L_0x01ab
            java.lang.String r0 = r0.getGeoFenceUrl()
            if (r0 == 0) goto L_0x01ab
            goto L_0x01ac
        L_0x01ab:
            r0 = r5
        L_0x01ac:
            java.lang.String r6 = "SMT_BASE_URL_GEOFENCE"
            r8.setString(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel r0 = r9.getDebuglevel()
            if (r0 == 0) goto L_0x01bc
            boolean r0 = r0.getLogEnabled()
            goto L_0x01bd
        L_0x01bc:
            r0 = 0
        L_0x01bd:
            java.lang.String r6 = "log_enable"
            r8.setBoolean(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel r0 = r9.getDebuglevel()
            if (r0 == 0) goto L_0x01cd
            int r0 = r0.getLogLevel()
            goto L_0x01ce
        L_0x01cd:
            r0 = 0
        L_0x01ce:
            java.lang.String r6 = "log_level"
            r8.setInt(r6, r0)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel r0 = r9.getDebuglevel()
            if (r0 == 0) goto L_0x01e6
            org.json.JSONArray r0 = r0.getGuids()
            if (r0 == 0) goto L_0x01e6
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x01e6
            r5 = r0
        L_0x01e6:
            java.lang.String r0 = "settings.debuglevel?.gui…g()\n                ?: \"\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r0 = "guids"
            r8.setString(r0, r5)
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r0 = r9.getSmartechInAppFrequencySettings()
            if (r0 == 0) goto L_0x0224
            int r0 = r0.getEnable()
            if (r0 != r1) goto L_0x0224
            com.netcore.android.preference.SMTPreferenceConstants r0 = com.netcore.android.preference.SMTPreferenceConstants.INSTANCE
            java.lang.String r1 = r0.getSMT_FC_IN_APP_ENABLE()
            int r1 = r8.getInt(r1, r2)
            if (r1 != 0) goto L_0x0224
            java.lang.String r1 = r0.getSMT_FC_IN_APP_DAY_COUNT()
            r8.setInt(r1, r2)
            java.lang.String r1 = r0.getSMT_FC_IN_APP_WEEK_COUNT()
            r8.setInt(r1, r2)
            java.lang.String r1 = r0.getSMT_FC_IN_APP_MONTH_COUNT()
            r8.setInt(r1, r2)
            java.lang.String r0 = r0.getSMT_FC_IN_APP_LAST_MILLIS()
            r8.setLong(r0, r3)
        L_0x0224:
            com.netcore.android.preference.SMTPreferenceConstants r0 = com.netcore.android.preference.SMTPreferenceConstants.INSTANCE
            java.lang.String r1 = r0.getSMT_FC_IN_APP_ENABLE()
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r3 = r9.getSmartechInAppFrequencySettings()
            if (r3 == 0) goto L_0x0235
            int r3 = r3.getEnable()
            goto L_0x0236
        L_0x0235:
            r3 = 0
        L_0x0236:
            r8.setInt(r1, r3)
            java.lang.String r1 = r0.getSMT_FC_IN_APP_DAY_LIMIT()
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r3 = r9.getSmartechInAppFrequencySettings()
            if (r3 == 0) goto L_0x0248
            int r3 = r3.getDay()
            goto L_0x0249
        L_0x0248:
            r3 = 0
        L_0x0249:
            r8.setInt(r1, r3)
            java.lang.String r1 = r0.getSMT_FC_IN_APP_WEEK_LIMIT()
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r3 = r9.getSmartechInAppFrequencySettings()
            if (r3 == 0) goto L_0x025b
            int r3 = r3.getWeek()
            goto L_0x025c
        L_0x025b:
            r3 = 0
        L_0x025c:
            r8.setInt(r1, r3)
            java.lang.String r0 = r0.getSMT_FC_IN_APP_MONTH_LIMIT()
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r1 = r9.getSmartechInAppFrequencySettings()
            if (r1 == 0) goto L_0x026d
            int r2 = r1.getMonth()
        L_0x026d:
            r8.setInt(r0, r2)
            com.netcore.android.logger.SMTLogger r8 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r0 = TAG
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Smartech settings: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r8.internal(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.utility.SMTCommonUtility.updateSmartechSettingsConfig$smartech_release(android.content.Context, com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings):void");
    }

    public final void writeToSDFile(String str) {
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "root");
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append(SMTConfigConstants.EXTERNAL_FILE_DIR);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, SMTConfigConstants.EXTERNAL_FILE_NAME));
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = TAG;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.e(str2, String.valueOf(e2.getMessage()));
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.i(str2, "******* File not found. Did you  add a WRITE_EXTERNAL_STORAGE permission to the manifest? : " + e2);
        } catch (IOException e3) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str3 = TAG;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger2.i(str3, "******* File not found. Did you add a WRITE_EXTERNAL_STORAGE permission to the manifest? : " + e3);
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger2.e(str3, String.valueOf(e3.getMessage()));
        } catch (Exception e4) {
            SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
            String str4 = TAG;
            GeneratedOutlineSupport.outline96(str4, UeCustomType.TAG, e4, sMTLogger3, str4);
        }
    }
}
