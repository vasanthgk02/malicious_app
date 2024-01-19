package com.google.firebase.crashlytics.internal.persistence;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class CrashlyticsReportPersistence {
    public static final String EVENT_COUNTER_FORMAT = "%010d";
    public static final int EVENT_COUNTER_WIDTH = 10;
    public static final FilenameFilter EVENT_FILE_FILTER = $$Lambda$CrashlyticsReportPersistence$yrLDYcvA2rHplfuqiXhfFmNn2UQ.INSTANCE;
    public static final String EVENT_FILE_NAME_PREFIX = "event";
    public static final int EVENT_NAME_LENGTH = 15;
    public static final Comparator<? super File> LATEST_SESSION_ID_FIRST_COMPARATOR = $$Lambda$CrashlyticsReportPersistence$cus4xBFpkzHLsoBdoVy1SdmpDs.INSTANCE;
    public static final int MAX_OPEN_SESSIONS = 8;
    public static final String NORMAL_EVENT_SUFFIX = "";
    public static final String PRIORITY_EVENT_SUFFIX = "_";
    public static final String REPORT_FILE_NAME = "report";
    public static final String SESSION_START_TIMESTAMP_FILE_NAME = "start-time";
    public static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public final AtomicInteger eventCounter = new AtomicInteger(0);
    public final FileStore fileStore;
    public final SettingsDataProvider settingsDataProvider;

    public CrashlyticsReportPersistence(FileStore fileStore2, SettingsDataProvider settingsDataProvider2) {
        this.fileStore = fileStore2;
        this.settingsDataProvider = settingsDataProvider2;
    }

    private SortedSet<String> capAndGetOpenSessions(String str) {
        this.fileStore.cleanupLegacyFiles();
        SortedSet<String> openSessionIds = getOpenSessionIds();
        if (str != null) {
            openSessionIds.remove(str);
        }
        if (openSessionIds.size() <= 8) {
            return openSessionIds;
        }
        while (openSessionIds.size() > 8) {
            String last = openSessionIds.last();
            Logger logger = Logger.getLogger();
            logger.d("Removing session over cap: " + last);
            this.fileStore.deleteSessionFiles(last);
            openSessionIds.remove(last);
        }
        return openSessionIds;
    }

    public static int capFilesCount(List<File> list, int i) {
        int size = list.size();
        for (File next : list) {
            if (size <= i) {
                return size;
            }
            FileStore.recursiveDelete(next);
            size--;
        }
        return size;
    }

    private void capFinalizedReports() {
        int i = this.settingsDataProvider.getSettings().getSessionData().maxCompleteSessionsCount;
        List<File> allFinalizedReportFiles = getAllFinalizedReportFiles();
        int size = allFinalizedReportFiles.size();
        if (size > i) {
            for (File delete : allFinalizedReportFiles.subList(i, size)) {
                delete.delete();
            }
        }
    }

    public static long convertTimestampFromSecondsToMs(long j) {
        return j * 1000;
    }

    private void deleteFiles(List<File> list) {
        for (File delete : list) {
            delete.delete();
        }
    }

    public static String generateEventFilename(int i, boolean z) {
        return GeneratedOutlineSupport.outline52("event", String.format(Locale.US, EVENT_COUNTER_FORMAT, new Object[]{Integer.valueOf(i)}), z ? "_" : "");
    }

    private List<File> getAllFinalizedReportFiles() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.fileStore.getPriorityReports());
        arrayList.addAll(this.fileStore.getNativeReports());
        Collections.sort(arrayList, LATEST_SESSION_ID_FIRST_COMPARATOR);
        List<File> reports = this.fileStore.getReports();
        Collections.sort(reports, LATEST_SESSION_ID_FIRST_COMPARATOR);
        arrayList.addAll(reports);
        return arrayList;
    }

    public static String getEventNameWithoutPriority(String str) {
        return str.substring(0, EVENT_NAME_LENGTH);
    }

    public static boolean isHighPriorityEventFile(String str) {
        return str.startsWith("event") && str.endsWith("_");
    }

    public static boolean isNormalPriorityEventFile(File file, String str) {
        return str.startsWith("event") && !str.endsWith("_");
    }

    public static int oldestEventFileFirst(File file, File file2) {
        return getEventNameWithoutPriority(file.getName()).compareTo(getEventNameWithoutPriority(file2.getName()));
    }

    public static String readTextFile(File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), UTF_8);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        throw th;
    }

    private void synthesizeNativeReportFile(File file, FilesPayload filesPayload, String str) {
        try {
            writeTextFile(this.fileStore.getNativeReport(str), TRANSFORM.reportToJson(TRANSFORM.reportFromJson(readTextFile(file)).withNdkPayload(filesPayload)));
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            logger.w("Could not synthesize final native report file for " + file, e2);
        }
    }

    private void synthesizeReport(String str, long j) {
        boolean z;
        List<File> sessionFiles = this.fileStore.getSessionFiles(str, EVENT_FILE_FILTER);
        if (sessionFiles.isEmpty()) {
            Logger logger = Logger.getLogger();
            logger.v("Session " + str + " has no events.");
            return;
        }
        Collections.sort(sessionFiles);
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = sessionFiles.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                File next = it.next();
                try {
                    arrayList.add(TRANSFORM.eventFromJson(readTextFile(next)));
                    if (z || isHighPriorityEventFile(next.getName())) {
                        z = true;
                    }
                } catch (IOException e2) {
                    Logger logger2 = Logger.getLogger();
                    logger2.w("Could not add event to report for " + next, e2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            Logger logger3 = Logger.getLogger();
            logger3.w("Could not parse event files for session " + str);
            return;
        }
        String readUserId = UserMetadata.readUserId(str, this.fileStore);
        synthesizeReportFile(this.fileStore.getSessionFile(str, REPORT_FILE_NAME), arrayList, j, z, readUserId);
    }

    private void synthesizeReportFile(File file, List<Event> list, long j, boolean z, String str) {
        File file2;
        try {
            CrashlyticsReport withEvents = TRANSFORM.reportFromJson(readTextFile(file)).withSessionEndFields(j, z, str).withEvents(ImmutableList.from(list));
            Session session = withEvents.getSession();
            if (session != null) {
                if (z) {
                    file2 = this.fileStore.getPriorityReport(session.getIdentifier());
                } else {
                    file2 = this.fileStore.getReport(session.getIdentifier());
                }
                writeTextFile(file2, TRANSFORM.reportToJson(withEvents));
            }
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            logger.w("Could not synthesize final report file for " + file, e2);
        }
    }

    private int trimEvents(String str, int i) {
        List<File> sessionFiles = this.fileStore.getSessionFiles(str, $$Lambda$5ewmHYO883ri5BmwN_Gn2GLWEFU.INSTANCE);
        Collections.sort(sessionFiles, $$Lambda$01Lorz603_5ziNugbvmzIHT6dw.INSTANCE);
        return capFilesCount(sessionFiles, i);
    }

    public static void writeTextFile(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void deleteAllReports() {
        deleteFiles(this.fileStore.getReports());
        deleteFiles(this.fileStore.getPriorityReports());
        deleteFiles(this.fileStore.getNativeReports());
    }

    public void finalizeReports(String str, long j) {
        for (String next : capAndGetOpenSessions(str)) {
            Logger logger = Logger.getLogger();
            logger.v("Finalizing report for session " + next);
            synthesizeReport(next, j);
            this.fileStore.deleteSessionFiles(next);
        }
        capFinalizedReports();
    }

    public void finalizeSessionWithNativeEvent(String str, FilesPayload filesPayload) {
        File sessionFile = this.fileStore.getSessionFile(str, REPORT_FILE_NAME);
        Logger logger = Logger.getLogger();
        logger.d("Writing native session report for " + str + " to file: " + sessionFile);
        synthesizeNativeReportFile(sessionFile, filesPayload, str);
    }

    public SortedSet<String> getOpenSessionIds() {
        return new TreeSet(this.fileStore.getAllOpenSessionIds()).descendingSet();
    }

    public long getStartTimestampMillis(String str) {
        return this.fileStore.getSessionFile(str, SESSION_START_TIMESTAMP_FILE_NAME).lastModified();
    }

    public boolean hasFinalizedReports() {
        return !this.fileStore.getReports().isEmpty() || !this.fileStore.getPriorityReports().isEmpty() || !this.fileStore.getNativeReports().isEmpty();
    }

    public List<CrashlyticsReportWithSessionId> loadFinalizedReports() {
        List<File> allFinalizedReportFiles = getAllFinalizedReportFiles();
        ArrayList arrayList = new ArrayList();
        for (File next : allFinalizedReportFiles) {
            try {
                arrayList.add(CrashlyticsReportWithSessionId.create(TRANSFORM.reportFromJson(readTextFile(next)), next.getName(), next));
            } catch (IOException e2) {
                Logger logger = Logger.getLogger();
                logger.w("Could not load report file " + next + "; deleting", e2);
                next.delete();
            }
        }
        return arrayList;
    }

    public void persistEvent(Event event, String str) {
        persistEvent(event, str, false);
    }

    public void persistReport(CrashlyticsReport crashlyticsReport) {
        Session session = crashlyticsReport.getSession();
        if (session == null) {
            Logger.getLogger().d("Could not get session for report");
            return;
        }
        String identifier = session.getIdentifier();
        try {
            writeTextFile(this.fileStore.getSessionFile(identifier, REPORT_FILE_NAME), TRANSFORM.reportToJson(crashlyticsReport));
            writeTextFile(this.fileStore.getSessionFile(identifier, SESSION_START_TIMESTAMP_FILE_NAME), "", session.getStartedAt());
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            logger.d("Could not persist report for session " + identifier, e2);
        }
    }

    public void persistEvent(Event event, String str, boolean z) {
        int i = this.settingsDataProvider.getSettings().getSessionData().maxCustomExceptionEvents;
        try {
            writeTextFile(this.fileStore.getSessionFile(str, generateEventFilename(this.eventCounter.getAndIncrement(), z)), TRANSFORM.eventToJson(event));
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            logger.w("Could not persist event for session " + str, e2);
        }
        trimEvents(str, i);
    }

    public static void writeTextFile(File file, String str, long j) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(convertTimestampFromSecondsToMs(j));
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
