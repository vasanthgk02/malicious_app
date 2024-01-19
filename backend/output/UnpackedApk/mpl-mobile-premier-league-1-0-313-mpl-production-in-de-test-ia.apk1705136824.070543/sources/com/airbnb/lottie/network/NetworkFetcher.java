package com.airbnb.lottie.network;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
    public final DefaultLottieNetworkFetcher fetcher;
    public final NetworkCache networkCache;

    public NetworkFetcher(NetworkCache networkCache2, DefaultLottieNetworkFetcher defaultLottieNetworkFetcher) {
        this.networkCache = networkCache2;
        this.fetcher = defaultLottieNetworkFetcher;
    }

    public final LottieResult<LottieComposition> fromInputStream(String str, InputStream inputStream, String str2, String str3) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResult;
        if (str2 == null) {
            str2 = DefaultSettingsSpiCall.ACCEPT_JSON_VALUE;
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            if (str3 == null) {
                lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), null);
            } else {
                lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(str, inputStream, fileExtension))), str);
            }
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            if (str3 == null) {
                lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null);
            } else {
                lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(str, inputStream, fileExtension).getAbsolutePath())), str);
            }
        }
        if (!(str3 == null || lottieResult.value == null)) {
            NetworkCache networkCache2 = this.networkCache;
            if (networkCache2 != null) {
                File file = new File(networkCache2.parentDir(), NetworkCache.filenameForUrl(str, fileExtension, true));
                File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
                boolean renameTo = file.renameTo(file2);
                Logger.debug("Copying temp file to real file (" + file2 + ")");
                if (!renameTo) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to rename cache file ");
                    outline73.append(file.getAbsolutePath());
                    outline73.append(" to ");
                    outline73.append(file2.getAbsolutePath());
                    outline73.append(".");
                    Logger.warning(outline73.toString());
                }
            } else {
                throw null;
            }
        }
        return lottieResult;
    }
}
