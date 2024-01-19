package com.mpl.androidapp.updater.interactor;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.AssetsConfigReader;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;
import java.io.IOException;

public class FileInteractor {
    public static final String TAG = "com.mpl.androidapp.updater.interactor.FileInteractor";

    public static boolean deleteOldRNDir(Context context, long j) {
        File filesDir = context.getFilesDir();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(Constant.BUNDLE_DIR_NAME);
        outline73.append(File.separator);
        outline73.append(j);
        return CommonUtils.deleteDir(new File(filesDir, outline73.toString()));
    }

    public static void extractFileFromAssets(Context context) {
        try {
            FileUtils.extractFromAssets(context, (long) DBInteractor.getCurrentRNBundleVersionCode());
        } catch (IOException e2) {
            MLogger.e(TAG, e2);
        }
    }

    public static boolean extractFromDownloadDir(Context context) {
        try {
            FileUtils.extractFromDownloadDir(context, (long) DBInteractor.getCurrentRNBundleVersionCode());
            return true;
        } catch (IOException e2) {
            MLogger.e(TAG, e2);
            return false;
        }
    }

    public static boolean extractWebBundleFromDownloadDir(Context context, String str, int i) {
        try {
            MLogger.d(TAG, "extractWebBundleFromDownloadDir:[START] ", str, Integer.valueOf(i));
            File webViewBundleOutputFile = FileUtils.getWebViewBundleOutputFile(context, str, i);
            CommonUtils.extractZipFile(webViewBundleOutputFile, new File(FileUtils.getWebViewBundleExtractOrDownloadDirPath(context, str, (long) i), Constant.WEB_VIEW_FILE_NAME));
            webViewBundleOutputFile.delete();
            MLogger.d(TAG, "extractWebBundleFromDownloadDir:SUCCESS [END] ");
            return true;
        } catch (IOException e2) {
            MLogger.e(TAG, e2);
            MLogger.d(TAG, "extractWebBundleFromDownloadDir:FAIL [END] ");
            return false;
        }
    }

    public static void getWebAssetsFolder(Context context, int i, int i2, boolean z) {
        String valueOf = String.valueOf(i2);
        File file = new File(FileUtils.getWebAssetsFolderPath(context, String.valueOf(i)));
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (z) {
                        FileUtils.deleteFolder(file2);
                    } else if (!valueOf.equals(file2.getName())) {
                        FileUtils.deleteFolder(file2);
                    }
                }
            }
        }
    }

    public static boolean isLoadFromAssets(Context context) {
        int currentRNBundleVersionCode = DBInteractor.getCurrentRNBundleVersionCode();
        int versionCode = AssetsConfigReader.getVersionCode(context);
        if (versionCode >= currentRNBundleVersionCode) {
            DBInteractor.setCurrentRNBundleVersionCode(versionCode);
            return true;
        } else if (!DBInteractor.isFirstTimeLoad() || DBInteractor.getCurrentRNBundleVersionCode() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void performFileOperationAfterDownload(Context context, int i) {
        if (extractFromDownloadDir(context)) {
            MLogger.d(TAG, "New Downloaded file extracted", Boolean.TRUE);
            boolean deleteOldRNDir = deleteOldRNDir(context, (long) i);
            MLogger.d(TAG, "oldBundleDeleted", Boolean.valueOf(deleteOldRNDir));
            return;
        }
        MLogger.d(TAG, "New Downloaded file extracted", Boolean.FALSE);
    }

    public static boolean performWebAssetsFileOperationAfterDownload(Context context, String str, int i, int i2) {
        if (extractWebBundleFromDownloadDir(context, str, i)) {
            MLogger.d(TAG, "New Downloaded file extracted", Boolean.TRUE);
            File file = new File(FileUtils.getWebViewBundleExtractOrDownloadDirPath(context, str, (long) i2));
            if (file.exists()) {
                CommonUtils.deleteDir(file);
                MLogger.d(TAG, "extractWebBundleFromDownloadDir:Deleting old directory ");
            }
            return true;
        }
        MLogger.d(TAG, "New Downloaded file extracted", Boolean.FALSE);
        return false;
    }
}
