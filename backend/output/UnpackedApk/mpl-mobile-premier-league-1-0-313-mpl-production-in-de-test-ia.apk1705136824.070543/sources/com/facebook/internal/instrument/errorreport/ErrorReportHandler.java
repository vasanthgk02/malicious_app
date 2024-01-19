package com.facebook.internal.instrument.errorreport;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.InstrumentUtility;
import com.paynimo.android.payment.util.Constant;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportHandler;", "", "()V", "MAX_ERROR_REPORT_NUM", "", "enable", "", "listErrorReportFiles", "", "Ljava/io/File;", "()[Ljava/io/File;", "save", "msg", "", "sendErrorReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ErrorReportHandler.kt */
public final class ErrorReportHandler {
    /* renamed from: listErrorReportFiles$lambda-3  reason: not valid java name */
    public static final boolean m224listErrorReportFiles$lambda3(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return new Regex(GeneratedOutlineSupport.outline70(new Object[]{"error_log_"}, 1, "^%s[0-9]+.json$", "java.lang.String.format(format, *args)")).matches(str);
    }

    /* renamed from: sendErrorReports$lambda-0  reason: not valid java name */
    public static final int m225sendErrorReports$lambda0(ErrorReportData errorReportData, ErrorReportData errorReportData2) {
        Intrinsics.checkNotNullExpressionValue(errorReportData2, "o2");
        if (errorReportData != null) {
            Intrinsics.checkNotNullParameter(errorReportData2, "data");
            Long l = errorReportData.timestamp;
            if (l == null) {
                return -1;
            }
            long longValue = l.longValue();
            Long l2 = errorReportData2.timestamp;
            if (l2 == null) {
                return 1;
            }
            return Intrinsics.compare(l2.longValue(), longValue);
        }
        throw null;
    }

    /* renamed from: sendErrorReports$lambda-2  reason: not valid java name */
    public static final void m226sendErrorReports$lambda2(ArrayList<ErrorReportData> arrayList, GraphResponse graphResponse) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(arrayList, "$validReports");
        Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
        try {
            if (graphResponse.error == null) {
                JSONObject jSONObject = graphResponse.jsonObject;
                if (jSONObject == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(jSONObject.getBoolean("success"));
                }
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    for (ErrorReportData errorReportData : arrayList) {
                        InstrumentUtility.deleteFile(errorReportData.filename);
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }
}
