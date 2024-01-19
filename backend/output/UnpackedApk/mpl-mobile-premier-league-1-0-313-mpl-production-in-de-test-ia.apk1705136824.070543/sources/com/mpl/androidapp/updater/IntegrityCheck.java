package com.mpl.androidapp.updater;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.Signature;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.interactor.FileInteractor;
import com.mpl.androidapp.updater.util.MD5Helper;
import com.mpl.androidapp.updater.util.SHA256Helper;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;
import java.security.MessageDigest;

public class IntegrityCheck {
    public static final String TAG = "IntegrityCheck";

    public static boolean ApkIntegrityCheck(File file) {
        boolean z = false;
        MLogger.d("IntegrityCheck", Constant.APP_UPDATE_CHECK, "ApkIntegrityCheck:[START] ");
        if (file == null || !file.exists()) {
            MLogger.d(Constant.APP_UPDATE_CHECK, "ApkIntegrityCheck:[END] File object is null or File is not present");
            return false;
        }
        boolean checkMD5 = MD5Helper.checkMD5(DBInteractor.getAppHash(), file);
        boolean checkSHA256 = SHA256Helper.checkSHA256(DBInteractor.getAppHash(), file);
        MLogger.d("IntegrityCheck", Constant.APP_UPDATE_CHECK, "ApkIntegrityCheck: [END]", "isMD5Correct: ", Boolean.valueOf(checkMD5), "isSHACorrect: ", Boolean.valueOf(checkSHA256));
        if (checkMD5 || checkSHA256) {
            z = true;
        }
        return z;
    }

    public static boolean RNBundleAvailableIntegrityCheck(Context context) {
        if (FileInteractor.isLoadFromAssets(context)) {
            return true;
        }
        String rNExtractOrDownloadDirPath = FileUtils.getRNExtractOrDownloadDirPath(context, (long) DBInteractor.getCurrentRNBundleVersionCode());
        StringBuilder sb = new StringBuilder();
        sb.append(File.separator);
        sb.append(Constant.REACT_APP);
        File file = new File(rNExtractOrDownloadDirPath, GeneratedOutlineSupport.outline62(sb, File.separator, "app.bundle"));
        MLogger.d("IntegrityCheck", Constant.APP_UPDATE_CHECK, file.getAbsolutePath());
        return file.exists();
    }

    @SuppressLint({"WrongConstant", "PackageManagerGetSignatures"})
    public static boolean installedApkIntegrityCheck(Context context) {
        boolean z;
        try {
            String aPKSignature = DBInteractor.getAPKSignature();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            int length = signatureArr.length;
            int i = 0;
            z = true;
            while (i < length) {
                try {
                    Signature signature = signatureArr[i];
                    MessageDigest instance = MessageDigest.getInstance("SHA");
                    instance.update(signature.toByteArray());
                    if (aPKSignature.equals(Base64.encodeToString(instance.digest(), 0).trim()) || MBuildConfigUtils.isDebuggable()) {
                        z = false;
                    }
                    i++;
                } catch (Exception e2) {
                    e = e2;
                    MLogger.e("IntegrityCheck", Constant.APP_UPDATE_CHECK, "installedApkIntegrityCheck", e);
                    return z;
                }
            }
            return z;
        } catch (Exception e3) {
            e = e3;
            z = true;
            MLogger.e("IntegrityCheck", Constant.APP_UPDATE_CHECK, "installedApkIntegrityCheck", e);
            return z;
        }
    }
}
