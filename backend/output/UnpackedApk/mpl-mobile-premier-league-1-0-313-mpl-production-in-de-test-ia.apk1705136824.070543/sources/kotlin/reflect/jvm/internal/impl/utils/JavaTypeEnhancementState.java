package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;

/* compiled from: JavaTypeEnhancementState.kt */
public final class JavaTypeEnhancementState {
    public static final ReportLevel DEFAULT_REPORT_LEVEL_FOR_JSPECIFY;
    public static final JavaTypeEnhancementState DISABLED_JSR_305;
    public final boolean disabledDefaultAnnotations;
    public final boolean disabledJsr305;
    public final boolean enableCompatqualCheckerFrameworkAnnotations;
    public final ReportLevel globalJsr305Level;
    public final ReportLevel jspecifyReportLevel;
    public final ReportLevel migrationLevelForJsr305;
    public final Map<String, ReportLevel> userDefinedLevelForSpecificJsr305Annotation;

    static {
        ReportLevel reportLevel = ReportLevel.WARN;
        DEFAULT_REPORT_LEVEL_FOR_JSPECIFY = reportLevel;
        new JavaTypeEnhancementState(reportLevel, null, ArraysKt___ArraysJvmKt.emptyMap(), false, null, 24);
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        JavaTypeEnhancementState javaTypeEnhancementState = new JavaTypeEnhancementState(reportLevel2, reportLevel2, ArraysKt___ArraysJvmKt.emptyMap(), false, null, 24);
        DISABLED_JSR_305 = javaTypeEnhancementState;
        ReportLevel reportLevel3 = ReportLevel.STRICT;
        new JavaTypeEnhancementState(reportLevel3, reportLevel3, ArraysKt___ArraysJvmKt.emptyMap(), false, null, 24);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaTypeEnhancementState(kotlin.reflect.jvm.internal.impl.utils.ReportLevel r2, kotlin.reflect.jvm.internal.impl.utils.ReportLevel r3, java.util.Map r4, boolean r5, kotlin.reflect.jvm.internal.impl.utils.ReportLevel r6, int r7) {
        /*
            r1 = this;
            r6 = r7 & 8
            r0 = 1
            if (r6 == 0) goto L_0x0006
            r5 = 1
        L_0x0006:
            r6 = r7 & 16
            if (r6 == 0) goto L_0x000d
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r6 = DEFAULT_REPORT_LEVEL_FOR_JSPECIFY
            goto L_0x000e
        L_0x000d:
            r6 = 0
        L_0x000e:
            java.lang.String r7 = "globalJsr305Level"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
            java.lang.String r7 = "userDefinedLevelForSpecificJsr305Annotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            java.lang.String r7 = "jspecifyReportLevel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            r1.<init>()
            r1.globalJsr305Level = r2
            r1.migrationLevelForJsr305 = r3
            r1.userDefinedLevelForSpecificJsr305Annotation = r4
            r1.enableCompatqualCheckerFrameworkAnnotations = r5
            r1.jspecifyReportLevel = r6
            kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState$description$2 r2 = new kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState$description$2
            r2.<init>(r1)
            com.twitter.sdk.android.tweetui.TweetUtils.lazy(r2)
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r2 = r1.globalJsr305Level
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r3 = kotlin.reflect.jvm.internal.impl.utils.ReportLevel.IGNORE
            r4 = 0
            if (r2 != r3) goto L_0x0048
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r2 = r1.migrationLevelForJsr305
            if (r2 != r3) goto L_0x0048
            java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.utils.ReportLevel> r2 = r1.userDefinedLevelForSpecificJsr305Annotation
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0048
            r2 = 1
            goto L_0x0049
        L_0x0048:
            r2 = 0
        L_0x0049:
            r1.disabledJsr305 = r2
            if (r2 != 0) goto L_0x0055
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r2 = r1.jspecifyReportLevel
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r3 = kotlin.reflect.jvm.internal.impl.utils.ReportLevel.IGNORE
            if (r2 != r3) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            r1.disabledDefaultAnnotations = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState.<init>(kotlin.reflect.jvm.internal.impl.utils.ReportLevel, kotlin.reflect.jvm.internal.impl.utils.ReportLevel, java.util.Map, boolean, kotlin.reflect.jvm.internal.impl.utils.ReportLevel, int):void");
    }
}
