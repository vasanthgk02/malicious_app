package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportFactoryImpl;
import com.google.android.datatransport.runtime.TransportImpl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public class DataTransportCrashlyticsReportSender {
    public static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    public static final String CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    public static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    public static final Transformer<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM = $$Lambda$DataTransportCrashlyticsReportSender$JltQxiH58gc27V_xiyanKrAKU.INSTANCE;
    public static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    public final Transport<CrashlyticsReport> transport;
    public final Transformer<CrashlyticsReport, byte[]> transportTransform;

    public DataTransportCrashlyticsReportSender(Transport<CrashlyticsReport> transport2, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.transport = transport2;
        this.transportTransform = transformer;
    }

    public static DataTransportCrashlyticsReportSender create(Context context) {
        TransportRuntime.initialize(context);
        return new DataTransportCrashlyticsReportSender(((TransportFactoryImpl) TransportRuntime.getInstance().newFactory(new CCTDestination(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY))).getTransport(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, new Encoding("json"), DEFAULT_TRANSFORM), DEFAULT_TRANSFORM);
    }

    public static void lambda$sendReport$1(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
        } else {
            taskCompletionSource.zza.zze(crashlyticsReportWithSessionId);
        }
    }

    public static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public Task<CrashlyticsReportWithSessionId> sendReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        CrashlyticsReport report = crashlyticsReportWithSessionId.getReport();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((TransportImpl) this.transport).schedule(new AutoValue_Event(null, report, Priority.HIGHEST), new TransportScheduleCallback(crashlyticsReportWithSessionId) {
            public final /* synthetic */ CrashlyticsReportWithSessionId f$1;

            {
                this.f$1 = r2;
            }

            public final void onSchedule(Exception exc) {
                DataTransportCrashlyticsReportSender.lambda$sendReport$1(TaskCompletionSource.this, this.f$1, exc);
            }
        });
        return taskCompletionSource.zza;
    }
}
