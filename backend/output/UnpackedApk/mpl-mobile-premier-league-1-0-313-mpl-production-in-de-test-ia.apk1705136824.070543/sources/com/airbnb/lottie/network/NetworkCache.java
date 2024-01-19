package com.airbnb.lottie.network;

import com.airbnb.lottie.L.AnonymousClass1;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NetworkCache {
    public final LottieNetworkCacheProvider cacheProvider;

    public NetworkCache(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.cacheProvider = lottieNetworkCacheProvider;
    }

    public static String filenameForUrl(String str, FileExtension fileExtension, boolean z) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("lottie_cache_");
        outline73.append(str.replaceAll("\\W+", ""));
        outline73.append(z ? fileExtension.tempExtension() : fileExtension.extension);
        return outline73.toString();
    }

    public final File parentDir() {
        AnonymousClass1 r0 = (AnonymousClass1) this.cacheProvider;
        if (r0 != null) {
            File file = new File(r0.val$context.getCacheDir(), "lottie_network_cache");
            if (file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        throw null;
    }

    public File writeTempCacheFile(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(parentDir(), filenameForUrl(str, fileExtension, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }
}
