package androidx.work.impl;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;

public class WorkDatabasePathHelper {
    public static final String[] DATABASE_EXTRA_FILES = {"-journal", "-shm", "-wal"};
    public static final String TAG = Logger.tagWithPrefix("WrkDbPathHelper");

    public static String getWorkDatabaseName() {
        return "androidx.work.workdb";
    }

    public static void migrateDatabase(Context context) {
        String str;
        File file;
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        if (VERSION.SDK_INT >= 23 && databasePath.exists()) {
            Logger.get().debug(TAG, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            HashMap hashMap = new HashMap();
            if (VERSION.SDK_INT >= 23) {
                File databasePath2 = context.getDatabasePath("androidx.work.workdb");
                if (VERSION.SDK_INT < 23) {
                    file = context.getDatabasePath("androidx.work.workdb");
                } else {
                    file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
                }
                hashMap.put(databasePath2, file);
                for (String str2 : DATABASE_EXTRA_FILES) {
                    hashMap.put(new File(databasePath2.getPath() + str2), new File(file.getPath() + str2));
                }
            }
            for (File file2 : hashMap.keySet()) {
                File file3 = (File) hashMap.get(file2);
                if (file2.exists() && file3 != null) {
                    if (file3.exists()) {
                        Logger.get().warning(TAG, String.format("Over-writing contents of %s", new Object[]{file3}), new Throwable[0]);
                    }
                    if (file2.renameTo(file3)) {
                        str = String.format("Migrated %s to %s", new Object[]{file2, file3});
                    } else {
                        str = String.format("Renaming %s to %s failed", new Object[]{file2, file3});
                    }
                    Logger.get().debug(TAG, str, new Throwable[0]);
                }
            }
        }
    }
}
