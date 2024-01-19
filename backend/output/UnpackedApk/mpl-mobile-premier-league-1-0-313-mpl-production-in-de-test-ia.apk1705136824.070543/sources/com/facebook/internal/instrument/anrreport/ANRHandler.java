package com.facebook.internal.instrument.anrreport;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.$$Lambda$maoa5aNYyaW_6qjduRfqgGYx_ro;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentData.Builder;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.paynimo.android.payment.util.Constant;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRHandler;", "", "()V", "MAX_ANR_REPORT_NUM", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enable", "", "sendANRReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ANRHandler.kt */
public final class ANRHandler {
    public static final ANRHandler INSTANCE = null;
    public static final AtomicBoolean enabled = new AtomicBoolean(false);

    public static final void sendANRReports() {
        File[] fileArr;
        Class<ANRHandler> cls = ANRHandler.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!Utility.isDataProcessingRestricted()) {
                    File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
                    if (instrumentReportDir == null) {
                        fileArr = new File[0];
                    } else {
                        fileArr = instrumentReportDir.listFiles($$Lambda$maoa5aNYyaW_6qjduRfqgGYx_ro.INSTANCE);
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
                    List sortedWith = ArraysKt___ArraysJvmKt.sortedWith(arrayList2, $$Lambda$32rOoGQOVWzJ05Z7eDHv0iZy0M.INSTANCE);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = RangesKt___RangesKt.until(0, Math.min(sortedWith.size(), 5)).iterator();
                    while (it.hasNext()) {
                        jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
                    }
                    InstrumentUtility.sendReports("anr_reports", jSONArray, new Callback(sortedWith) {
                        public final /* synthetic */ List f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onCompleted(GraphResponse graphResponse) {
                            ANRHandler.m221sendANRReports$lambda5(this.f$0, graphResponse);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: sendANRReports$lambda-2  reason: not valid java name */
    public static final int m220sendANRReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
        Class<ANRHandler> cls = ANRHandler.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullExpressionValue(instrumentData2, "o2");
            return instrumentData.compareTo(instrumentData2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    /* renamed from: sendANRReports$lambda-5  reason: not valid java name */
    public static final void m221sendANRReports$lambda5(List<InstrumentData> list, GraphResponse graphResponse) {
        Boolean bool;
        Class<ANRHandler> cls = ANRHandler.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
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
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
