package com.facebook.internal.instrument;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import io.sentry.cache.EnvelopeCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 -2\u00020\u0001:\u0003,-.B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0012\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0012\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rB\u000f\b\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010%\u001a\u00020&J\u0011\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0000H\u0002J\u0006\u0010*\u001a\u00020&J\b\u0010+\u001a\u00020\u000bH\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0010\u0010 \u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData;", "", "features", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)V", "e", "", "t", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "(Ljava/lang/Throwable;Lcom/facebook/internal/instrument/InstrumentData$Type;)V", "anrCause", "", "st", "(Ljava/lang/String;Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "analysisReportParameters", "Lorg/json/JSONObject;", "getAnalysisReportParameters", "()Lorg/json/JSONObject;", "appVersion", "cause", "exceptionReportParameters", "getExceptionReportParameters", "featureNames", "filename", "isValid", "", "()Z", "parameters", "getParameters", "stackTrace", "timestamp", "", "Ljava/lang/Long;", "type", "clear", "", "compareTo", "", "data", "save", "toString", "Builder", "Companion", "Type", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstrumentData.kt */
public final class InstrumentData {
    public static final Companion Companion = new Companion(null);
    public String appVersion;
    public String cause;
    public JSONArray featureNames;
    public String filename;
    public String stackTrace;
    public Long timestamp;
    public Type type;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Builder;", "", "()V", "build", "Lcom/facebook/internal/instrument/InstrumentData;", "anrCause", "", "st", "e", "", "t", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "features", "Lorg/json/JSONArray;", "load", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstrumentData.kt */
    public static final class Builder {
        public static final InstrumentData load(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new InstrumentData(file, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Companion;", "", "()V", "PARAM_APP_VERSION", "", "PARAM_CALLSTACK", "PARAM_DEVICE_MODEL", "PARAM_DEVICE_OS", "PARAM_FEATURE_NAMES", "PARAM_REASON", "PARAM_TIMESTAMP", "PARAM_TYPE", "UNKNOWN", "getType", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "filename", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstrumentData.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Type;", "", "(Ljava/lang/String;I)V", "logPrefix", "", "getLogPrefix", "()Ljava/lang/String;", "toString", "Unknown", "Analysis", "AnrReport", "CrashReport", "CrashShield", "ThreadCheck", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstrumentData.kt */
    public enum Type {
        Unknown,
        Analysis,
        AnrReport,
        CrashReport,
        CrashShield,
        ThreadCheck;

        public final String getLogPrefix() {
            int ordinal = ordinal();
            if (ordinal == 1) {
                return "analysis_log_";
            }
            if (ordinal == 2) {
                return "anr_log_";
            }
            if (ordinal == 3) {
                return "crash_log_";
            }
            if (ordinal != 4) {
                return ordinal != 5 ? Constants.DOWNLOAD_STATUS_UNKNOWN : "thread_check_log_";
            }
            return "shield_log_";
        }

        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 1) {
                return "Analysis";
            }
            if (ordinal == 2) {
                return "AnrReport";
            }
            if (ordinal == 3) {
                return "CrashReport";
            }
            if (ordinal != 4) {
                return ordinal != 5 ? Constants.DOWNLOAD_STATUS_UNKNOWN : "ThreadCheck";
            }
            return "CrashShield";
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstrumentData.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            Type type = Type.Analysis;
            iArr[1] = 1;
            Type type2 = Type.AnrReport;
            iArr[2] = 2;
            Type type3 = Type.CrashReport;
            iArr[3] = 3;
            Type type4 = Type.CrashShield;
            iArr[4] = 4;
            Type type5 = Type.ThreadCheck;
            iArr[5] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public InstrumentData(JSONArray jSONArray, DefaultConstructorMarker defaultConstructorMarker) {
        this.type = Type.Analysis;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.featureNames = jSONArray;
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("analysis_log_");
        outline71.append(String.valueOf(this.timestamp));
        outline71.append(EnvelopeCache.SUFFIX_CURRENT_SESSION_FILE);
        String stringBuffer = outline71.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "StringBuffer()\n            .append(InstrumentUtility.ANALYSIS_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.filename = stringBuffer;
    }

    public final int compareTo(InstrumentData instrumentData) {
        Intrinsics.checkNotNullParameter(instrumentData, "data");
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        long longValue = l.longValue();
        Long l2 = instrumentData.timestamp;
        if (l2 == null) {
            return 1;
        }
        return Intrinsics.compare(l2.longValue(), longValue);
    }

    public final boolean isValid() {
        Type type2 = this.type;
        int i = type2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (!(i == 3 || i == 4 || i == 5) || this.stackTrace == null || this.timestamp == null) {
                    return false;
                }
            } else if (this.stackTrace == null || this.cause == null || this.timestamp == null) {
                return false;
            }
        } else if (this.featureNames == null || this.timestamp == null) {
            return false;
        }
        return true;
    }

    public final void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            com.facebook.internal.instrument.InstrumentData$Type r0 = r5.type
            if (r0 != 0) goto L_0x0006
            r0 = -1
            goto L_0x000e
        L_0x0006:
            int[] r1 = com.facebook.internal.instrument.InstrumentData.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x000e:
            r1 = 1
            java.lang.String r2 = "timestamp"
            r3 = 0
            if (r0 == r1) goto L_0x006a
            r1 = 2
            if (r0 == r1) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0021
            r1 = 4
            if (r0 == r1) goto L_0x0021
            r1 = 5
            if (r0 == r1) goto L_0x0021
            goto L_0x0084
        L_0x0021:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "device_os_version"
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x0084 }
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r1 = "device_model"
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0084 }
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r1 = r5.appVersion     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = "app_version"
            java.lang.String r4 = r5.appVersion     // Catch:{ JSONException -> 0x0084 }
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x0084 }
        L_0x003f:
            java.lang.Long r1 = r5.timestamp     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x0048
            java.lang.Long r1 = r5.timestamp     // Catch:{ JSONException -> 0x0084 }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0084 }
        L_0x0048:
            java.lang.String r1 = r5.cause     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = "reason"
            java.lang.String r2 = r5.cause     // Catch:{ JSONException -> 0x0084 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0084 }
        L_0x0053:
            java.lang.String r1 = r5.stackTrace     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x005e
            java.lang.String r1 = "callstack"
            java.lang.String r2 = r5.stackTrace     // Catch:{ JSONException -> 0x0084 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0084 }
        L_0x005e:
            com.facebook.internal.instrument.InstrumentData$Type r1 = r5.type     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x0083
            java.lang.String r1 = "type"
            com.facebook.internal.instrument.InstrumentData$Type r2 = r5.type     // Catch:{ JSONException -> 0x0084 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0084 }
            goto L_0x0083
        L_0x006a:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONArray r1 = r5.featureNames     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = "feature_names"
            org.json.JSONArray r4 = r5.featureNames     // Catch:{ JSONException -> 0x0084 }
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x0084 }
        L_0x007a:
            java.lang.Long r1 = r5.timestamp     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x0083
            java.lang.Long r1 = r5.timestamp     // Catch:{ JSONException -> 0x0084 }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0084 }
        L_0x0083:
            r3 = r0
        L_0x0084:
            if (r3 != 0) goto L_0x0095
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "JSONObject().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        L_0x0095:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "params.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.instrument.InstrumentData.toString():java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r6v5, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r8v7, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InstrumentData(java.lang.Throwable r6, com.facebook.internal.instrument.InstrumentData.Type r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r5 = this;
            r5.<init>()
            r5.type = r7
            java.lang.String r8 = com.facebook.internal.Utility.getAppVersion()
            r5.appVersion = r8
            r8 = 0
            if (r6 != 0) goto L_0x0010
            r0 = r8
            goto L_0x0023
        L_0x0010:
            java.lang.Throwable r0 = r6.getCause()
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = r6.toString()
            goto L_0x0023
        L_0x001b:
            java.lang.Throwable r0 = r6.getCause()
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x0023:
            r5.cause = r0
            if (r6 != 0) goto L_0x0028
            goto L_0x0056
        L_0x0028:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
        L_0x002d:
            if (r6 == 0) goto L_0x0052
            if (r6 == r8) goto L_0x0052
            java.lang.StackTraceElement[] r8 = r6.getStackTrace()
            java.lang.String r1 = "t.stackTrace"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            r1 = 0
            int r2 = r8.length
        L_0x003c:
            if (r1 >= r2) goto L_0x004a
            r3 = r8[r1]
            int r1 = r1 + 1
            java.lang.String r3 = r3.toString()
            r0.put(r3)
            goto L_0x003c
        L_0x004a:
            java.lang.Throwable r8 = r6.getCause()
            r4 = r8
            r8 = r6
            r6 = r4
            goto L_0x002d
        L_0x0052:
            java.lang.String r8 = r0.toString()
        L_0x0056:
            r5.stackTrace = r8
            long r0 = java.lang.System.currentTimeMillis()
            r6 = 1000(0x3e8, float:1.401E-42)
            long r2 = (long) r6
            long r0 = r0 / r2
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            r5.timestamp = r6
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            java.lang.String r7 = r7.getLogPrefix()
            r6.append(r7)
            java.lang.Long r7 = r5.timestamp
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r6.append(r7)
            java.lang.String r7 = ".json"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "StringBuffer().append(t.logPrefix).append(timestamp.toString()).append(\".json\").toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r5.filename = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.instrument.InstrumentData.<init>(java.lang.Throwable, com.facebook.internal.instrument.InstrumentData$Type, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public InstrumentData(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this.type = Type.AnrReport;
        this.appVersion = Utility.getAppVersion();
        this.cause = str;
        this.stackTrace = str2;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("anr_log_");
        outline71.append(String.valueOf(this.timestamp));
        outline71.append(EnvelopeCache.SUFFIX_CURRENT_SESSION_FILE);
        String stringBuffer = outline71.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "StringBuffer()\n            .append(InstrumentUtility.ANR_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.filename = stringBuffer;
    }

    public InstrumentData(File file, DefaultConstructorMarker defaultConstructorMarker) {
        Type type2;
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        this.filename = name;
        if (CharsKt__CharKt.startsWith$default(name, (String) "crash_log_", false, 2)) {
            type2 = Type.CrashReport;
        } else if (CharsKt__CharKt.startsWith$default(name, (String) "shield_log_", false, 2)) {
            type2 = Type.CrashShield;
        } else if (CharsKt__CharKt.startsWith$default(name, (String) "thread_check_log_", false, 2)) {
            type2 = Type.ThreadCheck;
        } else if (CharsKt__CharKt.startsWith$default(name, (String) "analysis_log_", false, 2)) {
            type2 = Type.Analysis;
        } else if (CharsKt__CharKt.startsWith$default(name, (String) "anr_log_", false, 2)) {
            type2 = Type.AnrReport;
        } else {
            type2 = Type.Unknown;
        }
        this.type = type2;
        JSONObject readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0));
            this.appVersion = readFile.optString("app_version", null);
            this.cause = readFile.optString("reason", null);
            this.stackTrace = readFile.optString("callstack", null);
            this.featureNames = readFile.optJSONArray("feature_names");
        }
    }
}
