package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.concurrent.Executor;

public class SessionReportingCoordinator implements CrashlyticsLifecycleEvents {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int EVENT_THREAD_IMPORTANCE = 4;
    public static final String EVENT_TYPE_CRASH = "crash";
    public static final String EVENT_TYPE_LOGGED = "error";
    public static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
    public final CrashlyticsReportDataCapture dataCapture;
    public final LogFileManager logFileManager;
    public final UserMetadata reportMetadata;
    public final CrashlyticsReportPersistence reportPersistence;
    public final DataTransportCrashlyticsReportSender reportsSender;

    public SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager2, UserMetadata userMetadata) {
        this.dataCapture = crashlyticsReportDataCapture;
        this.reportPersistence = crashlyticsReportPersistence;
        this.reportsSender = dataTransportCrashlyticsReportSender;
        this.logFileManager = logFileManager2;
        this.reportMetadata = userMetadata;
    }

    private Event addLogsAndCustomKeysToEvent(Event event) {
        return addLogsAndCustomKeysToEvent(event, this.logFileManager, this.reportMetadata);
    }

    public static ApplicationExitInfo convertApplicationExitInfo(android.app.ApplicationExitInfo applicationExitInfo) {
        String str = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                str = convertInputStreamToString(traceInputStream);
            }
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Could not get input trace in application exit info: ");
            outline73.append(applicationExitInfo.toString());
            outline73.append(" Error: ");
            outline73.append(e2);
            logger.w(outline73.toString());
        }
        return ApplicationExitInfo.builder().setImportance(applicationExitInfo.getImportance()).setProcessName(applicationExitInfo.getProcessName()).setReasonCode(applicationExitInfo.getReason()).setTimestamp(applicationExitInfo.getTimestamp()).setPid(applicationExitInfo.getPid()).setPss(applicationExitInfo.getPss()).setRss(applicationExitInfo.getRss()).setTraceFile(str).build();
    }

    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static SessionReportingCoordinator create(Context context, IdManager idManager, FileStore fileStore, AppData appData, LogFileManager logFileManager2, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsDataProvider settingsDataProvider) {
        SessionReportingCoordinator sessionReportingCoordinator = new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager, appData, stackTraceTrimmingStrategy), new CrashlyticsReportPersistence(fileStore, settingsDataProvider), DataTransportCrashlyticsReportSender.create(context), logFileManager2, userMetadata);
        return sessionReportingCoordinator;
    }

    private android.app.ApplicationExitInfo findRelevantApplicationExitInfo(String str, List<android.app.ApplicationExitInfo> list) {
        long startTimestampMillis = this.reportPersistence.getStartTimestampMillis(str);
        for (android.app.ApplicationExitInfo next : list) {
            if (next.getTimestamp() < startTimestampMillis) {
                return null;
            }
            if (next.getReason() == 6) {
                return next;
            }
        }
        return null;
    }

    public static List<CustomAttribute> getSortedCustomAttributes(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Entry next : map.entrySet()) {
            arrayList.add(CustomAttribute.builder().setKey((String) next.getKey()).setValue((String) next.getValue()).build());
        }
        Collections.sort(arrayList, $$Lambda$SessionReportingCoordinator$TX0lZug2FS1EXHwsWNz9vWcgWJw.INSTANCE);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public boolean onReportSendComplete(Task<CrashlyticsReportWithSessionId> task) {
        if (task.isSuccessful()) {
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) task.getResult();
            Logger logger = Logger.getLogger();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Crashlytics report successfully enqueued to DataTransport: ");
            outline73.append(crashlyticsReportWithSessionId.getSessionId());
            logger.d(outline73.toString());
            File reportFile = crashlyticsReportWithSessionId.getReportFile();
            if (reportFile.delete()) {
                Logger logger2 = Logger.getLogger();
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Deleted report file: ");
                outline732.append(reportFile.getPath());
                logger2.d(outline732.toString());
            } else {
                Logger logger3 = Logger.getLogger();
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Crashlytics could not delete report file: ");
                outline733.append(reportFile.getPath());
                logger3.w(outline733.toString());
            }
            return true;
        }
        Logger.getLogger().w("Crashlytics report could not be enqueued to DataTransport", task.getException());
        return false;
    }

    private void persistEvent(Throwable th, Thread thread, String str, String str2, long j, boolean z) {
        boolean equals = str2.equals("crash");
        Event captureEventData = this.dataCapture.captureEventData(th, thread, str2, j, 4, 8, z);
        String str3 = str;
        this.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(captureEventData), str, equals);
    }

    public void finalizeSessionWithNativeEvent(String str, List<NativeSessionFile> list) {
        Logger.getLogger().d("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        for (NativeSessionFile asFilePayload : list) {
            FilesPayload.File asFilePayload2 = asFilePayload.asFilePayload();
            if (asFilePayload2 != null) {
                arrayList.add(asFilePayload2);
            }
        }
        this.reportPersistence.finalizeSessionWithNativeEvent(str, FilesPayload.builder().setFiles(ImmutableList.from((List<E>) arrayList)).build());
    }

    public void finalizeSessions(long j, String str) {
        this.reportPersistence.finalizeReports(str, j);
    }

    public boolean hasReportsToSend() {
        return this.reportPersistence.hasFinalizedReports();
    }

    public SortedSet<String> listSortedOpenSessionIds() {
        return this.reportPersistence.getOpenSessionIds();
    }

    public void onBeginSession(String str, long j) {
        this.reportPersistence.persistReport(this.dataCapture.captureReportData(str, j));
    }

    public void onCustomKey(String str, String str2) {
        this.reportMetadata.setCustomKey(str, str2);
    }

    public void onLog(long j, String str) {
        this.logFileManager.writeToLog(j, str);
    }

    public void onUserId(String str) {
        this.reportMetadata.setUserId(str);
    }

    public void persistFatalEvent(Throwable th, Thread thread, String str, long j) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting fatal event for session " + str);
        persistEvent(th, thread, str, "crash", j, true);
    }

    public void persistNonFatalEvent(Throwable th, Thread thread, String str, long j) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting non-fatal event for session " + str);
        persistEvent(th, thread, str, "error", j, false);
    }

    public void persistRelevantAppExitInfoEvent(String str, List<android.app.ApplicationExitInfo> list, LogFileManager logFileManager2, UserMetadata userMetadata) {
        android.app.ApplicationExitInfo findRelevantApplicationExitInfo = findRelevantApplicationExitInfo(str, list);
        if (findRelevantApplicationExitInfo == null) {
            Logger logger = Logger.getLogger();
            logger.v("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        Event captureAnrEventData = this.dataCapture.captureAnrEventData(convertApplicationExitInfo(findRelevantApplicationExitInfo));
        Logger logger2 = Logger.getLogger();
        logger2.d("Persisting anr for session " + str);
        this.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(captureAnrEventData, logFileManager2, userMetadata), str, true);
    }

    public void removeAllReports() {
        this.reportPersistence.deleteAllReports();
    }

    public Task<Void> sendReports(Executor executor) {
        List<CrashlyticsReportWithSessionId> loadFinalizedReports = this.reportPersistence.loadFinalizedReports();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId sendReport : loadFinalizedReports) {
            arrayList.add(this.reportsSender.sendReport(sendReport).continueWith(executor, new Continuation() {
                public final Object then(Task task) {
                    return Boolean.valueOf(SessionReportingCoordinator.this.onReportSendComplete(task));
                }
            }));
        }
        return Tasks.whenAll(arrayList);
    }

    private Event addLogsAndCustomKeysToEvent(Event event, LogFileManager logFileManager2, UserMetadata userMetadata) {
        Builder builder = event.toBuilder();
        String logString = logFileManager2.getLogString();
        if (logString != null) {
            builder.setLog(Log.builder().setContent(logString).build());
        } else {
            Logger.getLogger().v("No log data to include with this event.");
        }
        List<CustomAttribute> sortedCustomAttributes = getSortedCustomAttributes(userMetadata.getCustomKeys());
        List<CustomAttribute> sortedCustomAttributes2 = getSortedCustomAttributes(userMetadata.getInternalKeys());
        if (!sortedCustomAttributes.isEmpty() || !sortedCustomAttributes2.isEmpty()) {
            builder.setApp(event.getApp().toBuilder().setCustomAttributes(ImmutableList.from(sortedCustomAttributes)).setInternalKeys(ImmutableList.from(sortedCustomAttributes2)).build());
        }
        return builder.build();
    }
}
