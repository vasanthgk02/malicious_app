package com.mpl.androidapp.soutils;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;

public class StoriesCleanUpHelper {
    public static final String TAG = "StoriesCleanUpWorker -> StoriesCleanUpHelper";

    public static void clearDirectory(File file) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDirectory(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean deleteDirectory(File file) {
        clearDirectory(file);
        return file.delete();
    }

    public static void deleteStoriesExternalStorage(Context context) {
        MLogger.d(TAG, "deleteStoriesExternalStorage");
        try {
            File appExternalStoriesStoragePath = FileUtils.getAppExternalStoriesStoragePath(context);
            if (appExternalStoriesStoragePath.exists()) {
                deleteDirectory(appExternalStoriesStoragePath);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("deleteOldFoldersFromInternalStorage : ")));
        }
    }

    public static void deleteStoriesInternalStorage(Context context) {
        MLogger.d(TAG, "deleteStoriesInternalStorage");
        try {
            File file = new File(FileUtils.getAppInternalDownloadStoragePath(context), "SoFiles");
            File file2 = new File(context.getFilesDir(), "EditorAsset");
            if (file.exists()) {
                deleteDirectory(file);
            }
            if (file2.exists()) {
                deleteDirectory(file2);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("deleteStoriesInternalStorage : ")));
        }
    }
}
