package com.facebook.internal.instrument.crashreport;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.$$Lambda$aOD1jvtU6JCTaH0LS4rXzlhizxo;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentData.Builder;
import com.facebook.internal.instrument.InstrumentData.Type;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashreport.CrashHandler.Companion;
import com.paynimo.android.payment.util.Constant;
import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "previousHandler", "(Ljava/lang/Thread$UncaughtExceptionHandler;)V", "uncaughtException", "", "t", "Ljava/lang/Thread;", "e", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashHandler.kt */
public final class CrashHandler implements UncaughtExceptionHandler {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = CrashHandler.class.getCanonicalName();
    public static CrashHandler instance;
    public final UncaughtExceptionHandler previousHandler;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler$Companion;", "", "()V", "MAX_CRASH_REPORT_NUM", "", "TAG", "", "kotlin.jvm.PlatformType", "instance", "Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "enable", "", "sendExceptionReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CrashHandler.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: sendExceptionReports$lambda-2  reason: not valid java name */
        public static final int m222sendExceptionReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
            Intrinsics.checkNotNullExpressionValue(instrumentData2, "o2");
            return instrumentData.compareTo(instrumentData2);
        }

        /* renamed from: sendExceptionReports$lambda-5  reason: not valid java name */
        public static final void m223sendExceptionReports$lambda5(List<InstrumentData> list, GraphResponse graphResponse) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(list, "$validReports");
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
                        for (InstrumentData instrumentData : list) {
                            InstrumentUtility.deleteFile(instrumentData.filename);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        public final void sendExceptionReports() {
            File[] fileArr;
            if (!Utility.isDataProcessingRestricted()) {
                File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
                if (instrumentReportDir == null) {
                    fileArr = new File[0];
                } else {
                    fileArr = instrumentReportDir.listFiles($$Lambda$aOD1jvtU6JCTaH0LS4rXzlhizxo.INSTANCE);
                    if (fileArr == null) {
                        fileArr = new File[0];
                    }
                }
                ArrayList arrayList = new ArrayList(fileArr.length);
                for (File load : fileArr) {
                    arrayList.add(Builder.load(load));
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object next : arrayList) {
                    if (((InstrumentData) next).isValid()) {
                        arrayList2.add(next);
                    }
                }
                List sortedWith = ArraysKt___ArraysJvmKt.sortedWith(arrayList2, $$Lambda$dchJtVPub_SzQZRVrsweQL2bN8k.INSTANCE);
                JSONArray jSONArray = new JSONArray();
                Iterator it = RangesKt___RangesKt.until(0, Math.min(sortedWith.size(), 5)).iterator();
                while (it.hasNext()) {
                    jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
                }
                InstrumentUtility.sendReports("crash_reports", jSONArray, new Callback(sortedWith) {
                    public final /* synthetic */ List f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onCompleted(GraphResponse graphResponse) {
                        Companion.m223sendExceptionReports$lambda5(this.f$0, graphResponse);
                    }
                });
            }
        }
    }

    public CrashHandler(UncaughtExceptionHandler uncaughtExceptionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this.previousHandler = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        int i;
        Intrinsics.checkNotNullParameter(thread, "t");
        Intrinsics.checkNotNullParameter(th, "e");
        Throwable th2 = th;
        Throwable th3 = null;
        loop0:
        while (true) {
            i = 0;
            if (th2 == null || th2 == th3) {
                break;
            }
            StackTraceElement[] stackTrace = th2.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                i++;
                Intrinsics.checkNotNullExpressionValue(stackTraceElement, "element");
                if (InstrumentUtility.isFromFbOrMeta(stackTraceElement)) {
                    i = 1;
                    break loop0;
                }
            }
            th3 = th2;
            th2 = th2.getCause();
        }
        if (i != 0) {
            ExceptionAnalyzer.execute(th);
            Type type = Type.CrashReport;
            Intrinsics.checkNotNullParameter(type, "t");
            new InstrumentData(th, type, (DefaultConstructorMarker) null).save();
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
