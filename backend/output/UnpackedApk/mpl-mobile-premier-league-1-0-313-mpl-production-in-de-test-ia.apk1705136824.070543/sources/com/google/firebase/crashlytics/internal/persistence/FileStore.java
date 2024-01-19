package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileStore {
    public static final String FILES_PATH = ".com.google.firebase.crashlytics.files.v1";
    public static final String NATIVE_REPORTS_PATH = "native-reports";
    public static final String NATIVE_SESSION_SUBDIR = "native";
    public static final String PRIORITY_REPORTS_PATH = "priority-reports";
    public static final String REPORTS_PATH = "reports";
    public static final String SESSIONS_PATH = "open-sessions";
    public final File nativeReportsDir = prepareBaseDir(new File(this.rootDir, NATIVE_REPORTS_PATH));
    public final File priorityReportsDir = prepareBaseDir(new File(this.rootDir, PRIORITY_REPORTS_PATH));
    public final File reportsDir = prepareBaseDir(new File(this.rootDir, REPORTS_PATH));
    public final File rootDir;
    public final File sessionsDir = prepareBaseDir(new File(this.rootDir, SESSIONS_PATH));

    public FileStore(Context context) {
        this.rootDir = prepareBaseDir(new File(context.getFilesDir(), FILES_PATH));
    }

    private File getSessionDir(String str) {
        return prepareDir(new File(this.sessionsDir, str));
    }

    public static synchronized File prepareBaseDir(File file) {
        synchronized (FileStore.class) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                Logger logger = Logger.getLogger();
                logger.d("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (file.mkdirs()) {
                return file;
            }
            throw new IllegalStateException("Could not create Crashlytics-specific directory: " + file);
        }
    }

    public static File prepareDir(File file) {
        file.mkdirs();
        return file;
    }

    public static boolean recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File recursiveDelete : listFiles) {
                recursiveDelete(recursiveDelete);
            }
        }
        return file.delete();
    }

    public static <T> List<T> safeArrayToList(T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    public void cleanupLegacyFiles() {
        File[] fileArr = {new File(this.rootDir.getParent(), ".com.google.firebase.crashlytics"), new File(this.rootDir.getParent(), ".com.google.firebase.crashlytics-ndk")};
        for (int i = 0; i < 2; i++) {
            File file = fileArr[i];
            if (file.exists() && recursiveDelete(file)) {
                Logger logger = Logger.getLogger();
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Deleted legacy Crashlytics files from ");
                outline73.append(file.getPath());
                logger.d(outline73.toString());
            }
        }
    }

    public void deleteAllCrashlyticsFiles() {
        recursiveDelete(this.rootDir);
    }

    public boolean deleteSessionFiles(String str) {
        return recursiveDelete(new File(this.sessionsDir, str));
    }

    public List<String> getAllOpenSessionIds() {
        return safeArrayToList(this.sessionsDir.list());
    }

    public File getCommonFile(String str) {
        return new File(this.rootDir, str);
    }

    public List<File> getCommonFiles(FilenameFilter filenameFilter) {
        return safeArrayToList(this.rootDir.listFiles(filenameFilter));
    }

    public File getNativeReport(String str) {
        return new File(this.nativeReportsDir, str);
    }

    public List<File> getNativeReports() {
        return safeArrayToList(this.nativeReportsDir.listFiles());
    }

    public File getNativeSessionDir(String str) {
        return prepareDir(new File(getSessionDir(str), NATIVE_SESSION_SUBDIR));
    }

    public File getPriorityReport(String str) {
        return new File(this.priorityReportsDir, str);
    }

    public List<File> getPriorityReports() {
        return safeArrayToList(this.priorityReportsDir.listFiles());
    }

    public File getReport(String str) {
        return new File(this.reportsDir, str);
    }

    public List<File> getReports() {
        return safeArrayToList(this.reportsDir.listFiles());
    }

    public File getSessionFile(String str, String str2) {
        return new File(getSessionDir(str), str2);
    }

    public List<File> getSessionFiles(String str, FilenameFilter filenameFilter) {
        return safeArrayToList(getSessionDir(str).listFiles(filenameFilter));
    }
}
