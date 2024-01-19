package com.mpl.androidapp.utils;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.react.modules.GameLaunchHelper;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import org.apache.fontbox.cmap.CMap;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public class FileUtils {
    public static final int BUFFER = 8192;
    public static final String TAG = "FileUtils";

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void deleteFolder(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File deleteFolder : listFiles) {
                        deleteFolder(deleteFolder);
                    }
                }
            }
            file.delete();
        }
    }

    public static void extractFile(String str, String str2) throws IOException {
        CommonUtils.extractZipFile(new File(str), new File(str2));
    }

    public static void extractFromAssets(Context context, long j) throws IOException {
        String rNZipFileDestinationPath = getRNZipFileDestinationPath(context, j);
        CommonUtils.copyAssetZipToExternalStorage(context, getAssetsRelativePath(), rNZipFileDestinationPath);
        extractFile(rNZipFileDestinationPath, getRNExtractOrDownloadDirPath(context, j));
    }

    public static void extractFromDownloadDir(Context context, long j) throws IOException {
        extractFile(getRNZipFileDestinationPath(context, j), getRNExtractOrDownloadDirPath(context, j));
    }

    public static String getApkDownloadedFilePath(Context context, long j) {
        MLogger.d(GameLaunchHelper.TAG, "getApkDownloadedFilePath: ", Long.valueOf(j));
        Query query = new Query();
        query.setFilterById(new long[]{j});
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Constant.DOWNLOAD);
        Cursor query2 = downloadManager != null ? downloadManager.query(query) : null;
        if (query2 != null && query2.moveToFirst() && query2.getCount() > 0) {
            return query2.getString(query2.getColumnIndex("local_uri"));
        }
        if (query2 != null) {
            query2.close();
        }
        return "";
    }

    public static File getApkOutputFile(Context context, int i) {
        File mPLAppDownloadDir = getMPLAppDownloadDir(context, i);
        return new File(mPLAppDownloadDir, i + ".apk");
    }

    public static File getAppExternalAudioRecordedStoragePath(Context context) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "Recording");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File getAppExternalDownloadStoragePath(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    }

    public static File getAppExternalLogStoragePath(Context context) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "Logger");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File getAppExternalScreenShotStoragePath(Context context) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), Constant.SCREENSHOTS);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File getAppExternalScreenshotStoragePath(Context context) {
        return context.getExternalFilesDir(Constant.SCREENSHOTS);
    }

    public static File getAppExternalSendingImageStoragePath(Context context) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "Sent");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File getAppExternalStoriesStoragePath(Context context) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "Stories");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File getAppExternalVideoSnippetsStoragePath(Context context) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "VideoSnippets");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File getAppInternalDownloadStoragePath(Context context) {
        return new File(context.getFilesDir(), Environment.DIRECTORY_DOWNLOADS);
    }

    public static File getAppInternalDownloadStoragePathForPoker(Context context) {
        return new File(context.getFilesDir(), Constant.POKER_DIR_NAME);
    }

    public static String getAssetsRelativePath() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(Constant.BUNDLE_DIR_NAME), File.separator, Constant.ZIP_FILE);
    }

    public static String getFileExtension(File file) {
        return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
    }

    public static String getFileNameWithoutExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        return lastIndexOf > 0 ? name.substring(0, lastIndexOf) : name;
    }

    public static String getFileSize(long j) {
        double d2 = (double) j;
        int log10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d2 / Math.pow(1024.0d, (double) log10)) + CMap.SPACE + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }

    public static Double getFileSizeInBytesOrNull(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        return Double.valueOf((double) file.length());
    }

    public static String getGameAssetsDirPath(Context context) {
        File file = new File(context.getFilesDir(), "game");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getGameAssetsExtractOrDownloadDirPath(Context context, int i) {
        File file = new File(getGameAssetsDirPath(context), String.valueOf(i));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static File getMPLAppDownloadDir(Context context, int i) {
        File file = new File(getAppExternalDownloadStoragePath(context), GeneratedOutlineSupport.outline61(GeneratedOutlineSupport.outline73("mpl"), File.separator, i));
        if (!file.exists() && !file.mkdirs()) {
            MLogger.e(TAG, "Directory not present/created");
        }
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, file.getAbsolutePath());
        return file;
    }

    public static File getOrCreateDirPath(Context context, String str) {
        File file = new File(getAppExternalDownloadStoragePath(context), str);
        if (!file.exists()) {
            MLogger.d(TAG, "getOrCreateDirPath: ", Boolean.valueOf(file.mkdir()));
        }
        return file;
    }

    public static File getOrCreateFilePath(Context context, String str) {
        File file = new File(getAppExternalDownloadStoragePath(context), str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e2) {
            MLogger.e(TAG, "", e2);
        }
        return file;
    }

    public static File getOrCreateSponsorAssetsDirPath(Context context, String str) {
        File file = new File(getAppExternalDownloadStoragePath(context), GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(Constant.SPONSOR), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getRNExtractOrDownloadDirPath(Context context, long j) {
        File filesDir = context.getFilesDir();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(Constant.BUNDLE_DIR_NAME);
        outline73.append(File.separator);
        outline73.append(j);
        File file = new File(filesDir, outline73.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getRNExtractOrDownloadExternalDirPath(Context context, String str) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(Constant.BUNDLE_DIR_NAME), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getRNZipFileDestinationPath(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(getRNExtractOrDownloadDirPath(context, j));
        return GeneratedOutlineSupport.outline62(sb, File.separator, Constant.ZIP_FILE);
    }

    public static File getReactBundleOutputFile(Context context, int i) {
        return new File(getRNExtractOrDownloadDirPath(context, (long) i), Constant.ZIP_FILE);
    }

    public static String getScreenshotsDir(Context context) {
        File file = new File(String.valueOf(getAppExternalScreenshotStoragePath(context)));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        file.mkdir();
        return file.getAbsolutePath();
    }

    public static String getSponsorDir(Context context) {
        File file = new File(getAppExternalDownloadStoragePath(context), Constant.SPONSOR);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        file.mkdir();
        return file.getAbsolutePath();
    }

    public static String getSponsorDirPathById(Context context, String str) {
        File file = new File(getAppExternalDownloadStoragePath(context), GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(Constant.SPONSOR), File.separator, str));
        return file.exists() ? file.getAbsolutePath() : "";
    }

    public static File getThirdPartyApkOutputFile(Context context, int i, long j) {
        File thirdPartyAppDownloadDir = getThirdPartyAppDownloadDir(context, i, j);
        return new File(thirdPartyAppDownloadDir, i + ".apk");
    }

    public static File getThirdPartyAppDownloadDir(Context context, int i, long j) {
        File appExternalDownloadStoragePath = getAppExternalDownloadStoragePath(context);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("mpl");
        outline73.append(File.separator);
        outline73.append("APKS");
        outline73.append(File.separator);
        outline73.append(i);
        outline73.append(File.separator);
        outline73.append(j);
        File file = new File(appExternalDownloadStoragePath, outline73.toString());
        if (!file.exists() && !file.mkdirs()) {
            MLogger.e(TAG, "Directory not present/created");
        }
        MLogger.d(TAG, file.getAbsolutePath());
        return file;
    }

    public static File getVideoFilterExternalDownloadStoragePath(Context context) {
        return context.getExternalFilesDir("");
    }

    public static String getWebAssetsFolderPath(Context context, String str) {
        File file = new File(context.getFilesDir(), GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("web"), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getWebViewBundleExtractOrDownloadDirPath(Context context, String str, long j) {
        File filesDir = context.getFilesDir();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("web");
        outline73.append(File.separator);
        outline73.append(str);
        outline73.append(File.separator);
        outline73.append(j);
        File file = new File(filesDir, outline73.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static File getWebViewBundleOutputFile(Context context, String str, int i) {
        return new File(getWebViewBundleExtractOrDownloadDirPath(context, str, (long) i), "webApp.zip");
    }

    public static void installApk(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (VERSION.SDK_INT > 23) {
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file), "application/vnd.android.package-archive");
            intent.addFlags(1);
        } else {
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    public static void installApkNew(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (VERSION.SDK_INT > 23) {
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file), "application/vnd.android.package-archive");
            intent.addFlags(1);
        } else {
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    public static boolean isRNBundleAvailable(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(getRNExtractOrDownloadDirPath(context, j));
        sb.append(File.separator);
        sb.append(Constant.REACT_APP);
        return new File(GeneratedOutlineSupport.outline62(sb, File.separator, "app.bundle")).exists();
    }

    public static boolean isSponsorFileAvailable(Context context, String str) {
        return new File(getAppExternalDownloadStoragePath(context), GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(Constant.SPONSOR), File.separator, str)).exists();
    }

    public static boolean isWebViewBundleAvailable(Context context, String str, String str2, long j) {
        return webViewBundleLoadingPath(context, str, str2, j).exists();
    }

    public static void openStorageDir(Context context) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        Uri parse = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath());
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        intent.setDataAndType(parse, "resource/folder");
        context.startActivity(Intent.createChooser(intent, "Open folder"));
    }

    public static void removeInstalledApkFiles(Context context) {
        boolean z;
        int installedAppVersionCode = MBuildConfigUtils.getInstalledAppVersionCode();
        File[] listFiles = new File(getAppExternalDownloadStoragePath(context), "mpl").listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    MLogger.d(TAG, file.getName(), "is deleted ", Boolean.valueOf(file.delete()));
                } else if (file.isDirectory()) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Directory ");
                    outline73.append(file.getName());
                    MLogger.d(TAG, outline73.toString());
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 != null && listFiles2.length > 0) {
                        for (File file2 : listFiles2) {
                            if (file2 != null && file2.isFile()) {
                                String name = file.getName();
                                if (installedAppVersionCode == DBInteractor.getCurrentDownloadedAppVersionCode()) {
                                    z = file2.delete();
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(DBInteractor.getCurrentDownloadedAppVersionCode());
                                    sb.append("");
                                    z = !name.equals(sb.toString()) ? file2.delete() : false;
                                }
                                MLogger.d(TAG, name + " is deleted " + z);
                            }
                        }
                    }
                }
            }
        }
    }

    public static File webViewBundleLoadingPath(Context context, String str, String str2, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(getWebViewBundleExtractOrDownloadDirPath(context, str, j));
        sb.append(File.separator);
        sb.append(Constant.WEB_VIEW_FILE_NAME);
        sb.append(File.separator);
        sb.append(str2);
        return new File(GeneratedOutlineSupport.outline62(sb, File.separator, "index.html"));
    }

    public static void installApkNew(Activity activity, File file, int i) {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        if (VERSION.SDK_INT > 23) {
            intent.setDataAndType(FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", file), "application/vnd.android.package-archive");
            intent.addFlags(1);
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        activity.startActivityForResult(intent, i);
    }
}
